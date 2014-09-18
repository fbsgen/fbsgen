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
    
    public static final Pattern COMMA = Pattern.compile(",");
    public static final Pattern SEMI_COLON = Pattern.compile(";");
    public static final Pattern DOUBLE_UNDERSCORE = Pattern.compile("__");

    public static BufferedWriter newWriter(ProtoModule module, String packageName, String fileName)
            throws IOException
    {
        String encoding = module.getEncoding();
        if (encoding == null || encoding.isEmpty())
            encoding = "UTF-8";
        
        final File outputDir = fileName.endsWith(".java") || 
                module.getO().containsKey("with_package_dir") ? 
                new File(module.getOutputDir(), packageName.replace('.', '/')) : 
                    module.getOutputDir();
        
        if (!outputDir.exists())
            outputDir.mkdirs();
        
        File outputFile = new File(outputDir, fileName);
        FileOutputStream out = new FileOutputStream(outputFile);
        return new BufferedWriter(new OutputStreamWriter(out, encoding));
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

}
