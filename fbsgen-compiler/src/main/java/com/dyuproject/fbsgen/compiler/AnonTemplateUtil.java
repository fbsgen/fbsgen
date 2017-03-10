//========================================================================
//Copyright 2014 David Yu
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

package com.dyuproject.fbsgen.compiler;

import static com.dyuproject.fbsgen.compiler.CompilerUtil.COMMA;
import static com.dyuproject.fbsgen.compiler.ErrorUtil.err;
import static com.dyuproject.fbsgen.compiler.TemplateUtil.PUSH_BACK_SIZE;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Codegen via anonymous template.
 * 
 * @author David Yu
 * @created Feb 6, 2014
 */
public final class AnonTemplateUtil
{
    
    static final String IMPORTS = System.getProperty("cli.imports", ""),
            OPTIONS = System.getProperty("cli.options", ""),
            COPY_EXT = System.getProperty("cli.copy_ext", "");
    
    static final boolean P_BLOCK = Boolean.getBoolean("cli.p_block");
    
    static final String SRC = "src/",
            MAIN_JAVA = "main/java/",
            TEST_JAVA = "test/java/",
            START_INTERPOLATE = "{{";
    
    static Pattern PATTERN_INTERPOLATE = Pattern.compile("\\{\\{(.+?)\\}\\}");
    
    static final HashMap<String,Boolean> EXTENSIONS_TO_COPY = new HashMap<String,Boolean>();
    
    private static void putExt(String ... extensions)
    {
        for (String ext : extensions)
            EXTENSIONS_TO_COPY.put(ext, Boolean.TRUE);
    }
    
    static
    {
        putExt("bin", "exe", "png", "jpg", "jpeg", "gif", "ico", "stg");
        
        if (!COPY_EXT.isEmpty())
            putExt(COMMA.split(COPY_EXT));
    }
    
    /*interface Replacer
    {
        String replace(Matcher matcher);
    }

    // This is a generalization of http://stackoverflow.com/a/4742293/860000,
    // acting as an equivalent to String.prototype(/pattern/g, replacer.replace)
    static String replaceAll(String input, Pattern pattern, Replacer replacer)
    {
        StringBuffer output = new StringBuffer();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find())
            matcher.appendReplacement(output, replacer.replace(matcher));
        
        matcher.appendTail(output);
        return output.toString();
    }

    // Same as above but without the global flag.
    static String replaceFirst(String input, Pattern pattern, Replacer replacer)
    {
        StringBuffer output = new StringBuffer();
        Matcher matcher = pattern.matcher(input);
        if (matcher.find())
            matcher.appendReplacement(output, replacer.replace(matcher));
        
        matcher.appendTail(output);
        return output.toString();
    }*/
    
    public static String interpolate(String str, final Map<String, String> map)
    {
        Matcher matcher = PATTERN_INTERPOLATE.matcher(str);
        // StringBuilder cannot be used here because Matcher expects StringBuffer
        int replaceCount = 0;
        StringBuffer buffer = new StringBuffer();
        while (matcher.find())
        {
            String g1 = matcher.group(1),
                    val = g1 == null ? null : map.get(g1.trim());
            if (val == null)
                continue;
            
            matcher.appendReplacement(buffer, Matcher.quoteReplacement(val));
            
            replaceCount++;
        }
        
        if (replaceCount == 0)
            return str;
        
        matcher.appendTail(buffer);
        return buffer.toString();
    }
    
    static char parseSeparator(String arg)
    {
        return 1 == arg.length() ? arg.charAt(0) : 0;
    }
    
    static boolean isSeparator(String arg, char separator)
    {
        return 1 == arg.length() && separator == arg.charAt(0);
    }
    
    static String[] copy(String[] args, int offset, int len)
    {
        String[] copy = new String[len];
        System.arraycopy(args, offset, copy, 0, len);
        return copy;
    }
    
    static final class InWrapper extends InputStream
    {
        static final byte[] templateFooter = "\n>>\n".getBytes();
        final byte[] templateHeader;

        final char[] delim = new char[4];
        final InputStream in;
        
        private int footerOffset, headerOffset;
        private final byte[] header;
        private final int headerLen;
        
        InWrapper(InputStream in) throws IOException
        {
            this.in = in;
            
            StringBuilder sb = new StringBuilder();
            
            if (!IMPORTS.isEmpty())
            {
                for (String i : COMMA.split(IMPORTS))
                    sb.append("import \"").append(i).append('"').append('\n');
            }
            
            templateHeader = sb.append("anon_block(p, module) ::= <<\n")
                    .toString().getBytes();
            
            header = new byte[templateHeader.length + PUSH_BACK_SIZE];
            
            System.arraycopy(templateHeader, 0, header, 0, templateHeader.length);
            
            int offset = templateHeader.length;
            int read = in.read(header, offset, PUSH_BACK_SIZE);
            if (read < PUSH_BACK_SIZE)
            {
                throw err("Template's content has less than " + 
                        PUSH_BACK_SIZE + " characters.");
            }
            
            TemplateUtil.fillDelim(delim, header, offset);
            
            headerLen = delim[0] == 0 ? header.length : 
                    header.length - PUSH_BACK_SIZE;
        }
        
        @Override
        public int read() throws IOException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public int read(byte[] buf, int offset, int len) throws IOException
        {
            if (footerOffset == templateFooter.length)
                return -1;
            
            if (headerOffset != headerLen)
            {
                // copy header
                final int copyLen = Math.min(headerLen - headerOffset, len);
                System.arraycopy(header, headerOffset, buf, offset, copyLen);
                
                headerOffset += copyLen;
                
                if (headerOffset != headerLen)
                    return copyLen;
                
                len -= copyLen;
                if (len == 0)
                    return copyLen;
                
                // done copying header
                offset += copyLen;
                
                // read body
                final int read = in.read(buf, offset, len);
                return read > 0 ? copyLen + read : copyLen;
            }
            
            int read = in.read(buf, offset, len);
            if (read > 0)
                return read;
            
            // body fully read, copy footer
            int copyLen = Math.min(templateFooter.length - footerOffset, len);
            System.arraycopy(templateFooter, footerOffset, buf, offset, copyLen);
            
            footerOffset += copyLen;
            
            return copyLen;
        }
    }
    
    static LinkedHashMap<String,String> newGlobalParams(String[] args, int offset, int limit, 
            char limitChar)
    {
        final LinkedHashMap<String,String> params = new LinkedHashMap<String,String>();
        
        for (int colon; offset < limit; offset++)
        {
            String arg = args[offset];
            
            if (limitChar == arg.charAt(0))
                break;
            
            if (-1 == (colon = arg.indexOf(':')))
                params.put(arg, "");
            else
                params.put(arg.substring(0, colon), arg.substring(colon + 1));
        }
        
        return params;
    }
    
    static void putTemplateParamsTo(LinkedHashMap<String,String> params, 
            String[] args, int offset, int limit)
    {
        for (int colon; offset < limit; offset++)
        {
            String arg = args[offset];
            if (-1 == (colon = arg.indexOf(':')))
                params.put(arg, "");
            else
                params.put(arg.substring(0, colon), arg.substring(colon + 1));
        }
    }
    
    static LinkedHashMap<String,String> newTemplateParams(String[] args, int offset, int limit)
    {
        final LinkedHashMap<String,String> params = new LinkedHashMap<String,String>();
        
        putTemplateParamsTo(params, args, offset, limit);
        
        return params;
    }
    
    static void compileTemplate(LinkedHashMap<String,String> params, ProtoModule module, 
            InputStream in, OutputStream out) throws IOException
    {
        final TemplateGroup group;
        final Template template;
        if (P_BLOCK)
        {
            group = TemplateUtil.newGroup("anon", in, new char[4], true);
            template = group.getTemplate("p_block");
        }
        else
        {
            InWrapper iw = new InWrapper(in);
            group = TemplateUtil.newGroup("anon", iw, iw.delim, false);
            template = group.getTemplate("anon_block");
        }
        
        final BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(out, "UTF-8"));
        
        template.renderTo(writer, "p", params, module);
        
        writer.close();
    }
    
    static void compileTemplates(String[] args) throws IOException
    {
        final ProtoModule module = new ProtoModule();
        if (!OPTIONS.isEmpty())
        {
            for (String o : COMMA.split(OPTIONS))
            {
                int idx = o.indexOf(':');
                if (idx == -1)
                    module.setOption(o.trim(), "");
                else
                    module.setOption(o.substring(0, idx).trim(), o.substring(idx + 1).trim());
            }
        }
        
        final String first = args[0];
        if (first.length() == 1)
        {
            compileWithSeparator(first.charAt(0), module, args, 1);
        }
        else
        {
            // using unix pipes
            compileTemplate(newTemplateParams(args, 0, args.length), module, 
                    System.in, System.out);
        }
    }
    
    static void compileWithSeparator(char separator, ProtoModule module, 
            String[] args, int offset) throws IOException
    {
        // minimum
        // : in out : path
        if (args.length < 5)
        {
            System.err.println("A minimum of 5 args are required:");
            System.err.println(": in out (k:v)* : path");
            System.exit(1);
        }
        
        final String inDir = args[offset++],
                outDir = args[offset++];
        
        final LinkedHashMap<String,String> params = new LinkedHashMap<String, String>();
        for (int colon; offset < args.length;)
        {
            String arg = args[offset++];
            if (arg.length() == 1 && arg.charAt(0) == separator)
                break;
            
            if (-1 == (colon = arg.indexOf(':')))
                params.put(arg, "");
            else
                params.put(arg.substring(0, colon), arg.substring(colon + 1));
        }
        
        final String packageName = params.get("package_name"),
                packagePath = packageName != null && !packageName.isEmpty() ? 
                        packageName.replace('.', '/') : null;
        
        int src, idx, lastDot;
        String arg, ext, argOut, prefix, next;
        File inFile;
        while (offset < args.length)
        {
            arg = args[offset++];
            if (arg.startsWith("./"))
                arg = arg.substring(2);
            
            if (!(inFile = new File(inDir, arg)).exists())
            {
                // file/dir with space
                prefix = args[offset - 1];
                StringBuilder sb = new StringBuilder()
                        .append(arg);
                
                while (offset < args.length && 
                        !(inFile = new File(inDir, (next=args[offset]))).exists() && 
                        !next.startsWith(prefix))
                {
                    sb.append(' ').append(next);
                    offset++;
                }
                
                arg = sb.toString();
                if (!(inFile = new File(inDir, arg)).exists())
                {
                    System.err.println("Excluding: " + arg);
                    continue;
                }
            }
            
            argOut = arg;
            if ((idx = arg.indexOf(START_INTERPOLATE)) != -1)
                argOut = interpolate(arg, params);
            
            if (packageName != null && (src = argOut.indexOf(SRC)) != -1 && 
                    (argOut.startsWith(MAIN_JAVA, src + SRC.length()) || 
                            argOut.startsWith(TEST_JAVA, src + SRC.length())))
            {
                // main/test has same length
                idx = src + SRC.length() + MAIN_JAVA.length();
                argOut = argOut.substring(0, idx) + packagePath + argOut.substring(idx - 1);
            }
            
            if ((idx = argOut.lastIndexOf('/')) != -1)
                new File(outDir, argOut.substring(0, idx)).mkdirs();
            
            if ((lastDot = argOut.lastIndexOf('.')) == -1)
            {
                // pass-through
            }
            else if ((ext = argOut.substring(lastDot+1)).equals("stg") && P_BLOCK)
            {
                // strip stg extension
                argOut = argOut.substring(0, argOut.length() - 4);
            }
            else if (EXTENSIONS_TO_COPY.containsKey(ext))
            {
                // simply copy this file
                Files.copy(inFile.toPath(), new File(outDir, argOut).toPath());
                continue;
            }
            
            compileTemplate(params, module, 
                    new FileInputStream(inFile), 
                    new FileOutputStream(new File(outDir, argOut)));
        }
    }
}
