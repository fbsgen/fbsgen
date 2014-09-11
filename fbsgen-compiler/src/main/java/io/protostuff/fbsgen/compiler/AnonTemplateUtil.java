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

package io.protostuff.fbsgen.compiler;

import static io.protostuff.fbsgen.compiler.CompilerUtil.COMMA;
import static io.protostuff.fbsgen.compiler.ErrorUtil.err;
import static io.protostuff.fbsgen.compiler.TemplateUtil.PUSH_BACK_SIZE;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Codegen via anonymous template.
 * 
 * @author David Yu
 * @created Feb 6, 2014
 */
public final class AnonTemplateUtil
{
    
    static final String IMPORTS = System.getProperty("imports", ""),
            OPTIONS = System.getProperty("options", "");
    
    static final char CLI_SEPARATOR = parseSeparator(
            System.getProperty("cli.separator", ""));
    
    static char parseSeparator(String arg)
    {
        return 1 == arg.length() ? arg.charAt(0) : 0;
    }
    
    static char getSeparator(String arg)
    {
        return 1 == arg.length() && CLI_SEPARATOR == arg.charAt(0) ? CLI_SEPARATOR : 0;
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
            
            templateHeader = sb.append("anon_block(params, module, options) ::= <<")
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
    
    static HashMap<String,String> newGlobalParams(String[] args, int offset, int limit, 
            char limitChar)
    {
        final HashMap<String,String> params = new HashMap<String,String>();
        
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
    
    static void putTemplateParamsTo(HashMap<String,String> params, 
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
    
    static HashMap<String,String> newTemplateParams(String[] args, int offset, int limit)
    {
        final HashMap<String,String> params = new HashMap<String,String>();
        
        putTemplateParamsTo(params, args, offset, limit);
        
        return params;
    }
    
    static void compileTemplate(HashMap<String,String> params, ProtoModule module, 
            InputStream in, OutputStream out) throws IOException
    {
        final InWrapper iw = new InWrapper(in);
        final TemplateGroup group = TemplateUtil.newGroup("anon", iw, iw.delim, false);
        
        final Template template = group.getTemplate("anon_block");
        
        HashMap<String,Object> args = new HashMap<String, Object>();
        args.put("params", params);
        args.put("module", module);
        args.put("options", module.getOptions());
        
        final BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(out, "UTF-8"));
        
        template.renderTo(writer, args);
        
        writer.close();
    }
    
    static final class ArgGroup
    {
        static final int TEMPLATE_OPTION_OFFSET = 5;
        
        final File in, out;
        final int offset, paramOffset, pathOffset, limit;
        
        ArgGroup(File in, File out, 
                int offset, int paramOffset, int pathOffset, int limit)
        {
            this.in = in;
            this.out = out;
            
            this.offset = offset;
            this.paramOffset = paramOffset;
            this.pathOffset = pathOffset;
            this.limit = limit;
        }
    }
    
    static ArgGroup parse(final String[] args, final int offset, final int len, 
            boolean hasGlobalParams, int group)
    {
        if (hasGlobalParams)
        {
            if (len < 5 || !"-i".equals(args[offset]) || !"-o".equals(args[offset+2]))
            {
                throw err("The required params must be in this order: " +
                        "-i in_dir -o out_dir [-params params --] <paths>");
            }
        }
        else if (len < 8 || !"-i".equals(args[offset]) || !"-o".equals(args[offset+2]) || 
                !"-params".equals(args[offset+4]))
        {
            throw err("The required params must be in this order: " +
            		"-i in_dir -o out_dir -params params -- <paths>");
        }
        
        final File in = new File(args[offset+1]), 
                out = new File(args[offset+3]);
        
        if (!in.exists() || !in.isDirectory())
            throw err("The in_dir " + in + " is not a directory");
        
        if (!out.exists() || !out.isDirectory())
            throw err("The out_dir " + out + " is not a directory");
        
        final int limit = offset + len;
        
        final int paramOffset = !hasGlobalParams || "-params".equals(args[offset+4]) ? 
                offset + 5 : -1;
        
        final int pathOffset;
        if (paramOffset == -1)
        {
            // all global params
            pathOffset = offset + 4;
        }
        else
        {
            int doubleHyphenOffset = -1, start = offset + 6, i = start;
            
            for (; i < limit; i++)
            {
                String str = args[i];
                if (str.length() == 2 && '-' == str.charAt(0) && '-' == str.charAt(1))
                {
                    // the separator
                    doubleHyphenOffset = i;
                    break;
                }
            }
            
            if (doubleHyphenOffset == -1)
                throw err("The -- separator is missing at group: " + group);
            
            if (i == start)
                throw err("Empty params (-params --) at group: " + group);
            
            if (doubleHyphenOffset == limit)
                throw err("No path(s) specified at group: " + group);
            
            pathOffset = doubleHyphenOffset + 1;
        }
        
        return new ArgGroup(in, out, offset, paramOffset, pathOffset, limit);
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
        
        char separator = getSeparator(args[0]);
        if (0 == separator)
        {
            // using unix pipes
            compileTemplate(newTemplateParams(args, 0, args.length), module, 
                    System.in, System.out);
            return;
        }
        
        int start = 1;
        
        final HashMap<String,String> globalParams;
        if (args.length > 1 && "-gparams".equals(args[1]))
        {
            globalParams = newGlobalParams(args, ++start, args.length, separator);
            if (globalParams.isEmpty())
                throw err("The global params must have at least one entry");
            
            // move to the offset after the separator
            start += (1 + globalParams.size());
            
            if (start == args.length)
                throw err("No entries after global params");
        }
        else
        {
            globalParams = null;
        }
        
        final ArrayList<ArgGroup> list = new ArrayList<ArgGroup>();
        
        int count = 0;
        for (int offset = start, limit = args.length; offset < limit; offset++)
        {
            if (isSeparator(args[offset], separator))
            {
                list.add(parse(args, start, offset - start, globalParams != null, count++));
                start = offset + 1;
            }
        }
        
        if (!isSeparator(args[args.length - 1], separator))
        {
            // append the last entry
            list.add(parse(args, start, args.length - start, globalParams != null, count++));
        }
        
        for (ArgGroup ag : list)
        {
            final HashMap<String, String> params;
            if (ag.paramOffset == -1)
            {
                params = globalParams;
            }
            else
            {
                params = new HashMap<String,String>();
                
                if (globalParams != null)
                    params.putAll(globalParams);
                
                putTemplateParamsTo(params, args, ag.paramOffset, 
                        // the offset of the delimiter "--" as limit
                        ag.pathOffset - 1);
            }
            
            for (int i = ag.pathOffset, limit = ag.limit; i < limit; i++)
            {
                FileInputStream in = new FileInputStream(new File(ag.in, args[i]));
                FileOutputStream out = new FileOutputStream(new File(ag.out, args[i]));
                
                compileTemplate(params, module, in, out);
            }
        }
    }
}
