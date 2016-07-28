//========================================================================
//Copyright 2007-2010 David Yu dyuproject@gmail.com
//------------------------------------------------------------------------
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at 
//http://www.apache.org/licenses/LICENSE-2.0
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
//========================================================================

package io.protostuff.fbsgen.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Utilities and helpers for compiling protos.
 * 
 * @author David Yu
 * @created Jan 5, 2010
 */
public final class CompilerUtil
{
    
    public static final boolean SILENT_MODE = Boolean.parseBoolean(
            System.getProperty("fbsgen.silent_mode", "true"));

    static final boolean PRINT_STACK_TRACE = Boolean.parseBoolean(
            System.getProperty("fbsgen.print_stack_trace", "false"));
    
    public static final Pattern DOT = Pattern.compile("\\.");
    public static final Pattern COMMA = Pattern.compile(",");
    public static final Pattern SEMI_COLON = Pattern.compile(";");
    public static final Pattern DOUBLE_UNDERSCORE = Pattern.compile("__");
    
    static final File BASE_DIR;
    static
    {
        try
        {
            BASE_DIR = new File(".").getCanonicalFile();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public static boolean isMatch(String stg, String filter)
    {
        return filter.indexOf('/') == -1 && stg.length() > filter.length() ? 
                (stg.endsWith(filter) && stg.charAt(stg.length() - filter.length() - 1) == '/') : 
                stg.equals(filter);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map fill(Map map, String csvOptions)
    {
        for (String o : COMMA.split(csvOptions))
        {
            int idx = o.indexOf(':');
            if (idx == -1)
                map.put(o.trim(), "");
            else
                map.put(o.substring(0, idx).trim(), o.substring(idx + 1).trim());
        }
        
        return map;
    }
    
    public static BufferedWriter newWriter(ProtoModule module, 
            String packageName, String fileName) throws IOException
    {
        return newWriter(module, packageName, fileName, null);
    }
    
    public static BufferedWriter newWriter(ProtoModule module, 
            String packageName, String fileName, File sourceFile) throws IOException
    {
        String encoding = module.getEncoding();
        if (encoding == null || encoding.isEmpty())
            encoding = "UTF-8";
        
        File dir = module.getOutputDir();
        if (sourceFile != null)
        {
            String path = dir.getPath();
            final String prefix = module.getOption("output_dir_prefix");
            if (prefix != null)
            {
                path = prefix + path;
                dir = resolveOutputDir(path, prefix.lastIndexOf('$'), 
                        sourceFile, null);
                
                // new dir with the prefix
                if (dir == null)
                    dir = new File(path);
            }
            else
            {
                dir = resolveOutputDir(path, path.lastIndexOf('$'), 
                        sourceFile, dir);
            }
        }
        
        final File outputDir = fileName.endsWith(".java") || 
                module.getO().containsKey("with_package_dir") ? 
                new File(dir, packageName.replace('.', '/')) : dir;
        
        if (!outputDir.exists())
            outputDir.mkdirs();
        
        File outputFile = new File(outputDir, fileName);
        FileOutputStream out = new FileOutputStream(outputFile);
        return new BufferedWriter(new OutputStreamWriter(out, encoding));
    }
    
    /**
     * Replace the token '$' with the module name.
     */
    private static File resolveOutputDir(String path, int dollar, 
            File sourceFile, File toReturnIfNotResolved) throws IOException
    {
        if (dollar == -1)
            return toReturnIfNotResolved;
        
        final File sourceFileDir = sourceFile.getParentFile().getCanonicalFile();
        final ArrayList<String> dirNames = new ArrayList<String>();
        
        File d = sourceFileDir;
        String dirName;
        while (!BASE_DIR.getName().equals((dirName = d.getName())))
        {
            dirNames.add(dirName);
            d = d.getParentFile();
        }
        
        if (dirNames.isEmpty())
            return toReturnIfNotResolved;
        
        final StringBuilder sb = new StringBuilder();
        for (int i = 0, offset = dirNames.size(), len = dollar + 1; i < len; i++)
            sb.append(dirNames.get(--offset)).append('/');
        
        return new File(sb.append(path.substring(dollar + 1)).toString());
    }

    public static List<File> getProtoFiles(File dir)
    {
        return getFilesByExtension(dir, new String[] { ".proto" });
    }

    /**
     * Returns a list of file filtered by their file types/extensions; (E.g ".proto")
     */
    public static List<File> getFilesByExtension(File dir, String[] extensions)
    {
        if (!dir.isDirectory() || extensions == null)
            return Collections.emptyList();
        List<File> files = new ArrayList<File>();
        addFilesByExtension(files, dir, extensions);
        return files;
    }

    static void addFilesByExtension(List<File> list, File dir, String[] extensions)
    {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++)
        {
            File f = files[i];
            if (f.isDirectory())
                addFilesByExtension(list, f, extensions);
            else
            {
                for (String s : extensions)
                {
                    if (f.getName().endsWith(s))
                    {
                        list.add(f);
                        break;
                    }
                }
            }
        }
    }
    
    public static int $int(Object arg)
    {
        return arg instanceof Integer ? 
                ((Integer)arg).intValue() : Integer.parseInt(arg.toString());
    }

}
