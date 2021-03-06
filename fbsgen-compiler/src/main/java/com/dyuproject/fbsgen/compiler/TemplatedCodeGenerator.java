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

package com.dyuproject.fbsgen.compiler;

import com.dyuproject.fbsgen.parser.Formatter;
import com.dyuproject.fbsgen.parser.Proto;
import com.dyuproject.fbsgen.parser.ProtoUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Base class for code generators using templates.
 * 
 * @author David Yu
 * @created Jan 5, 2010
 */
public abstract class TemplatedCodeGenerator implements ProtoCompiler
{
    
    public static int errorCount = 0;
    
    public static final Pattern FORMAT_DELIM = Pattern.compile("&&");
    
    static final HashMap<String, Formatter> DEFAULT_FORMATTERS =
            new HashMap<String, Formatter>();
    
    static
    {
        Formatter.BUILTIN.addAllTo(DEFAULT_FORMATTERS);
    }
    
    /**
     * Returns true if there was no previous formatter with the same name.
     */
    public static boolean setFormatter(String name, Formatter f)
    {
        return null == DEFAULT_FORMATTERS.put(name, f);
    }

    /*public static final CommonGroupLoader GROUP_LOADER =
            new CommonGroupLoader(TEMPLATE_BASE, ERROR_LISTENER);*/



    /**
     * Formats the string n times.
     * <p/>
     * 
     * <pre>
     * For example:
     * input = "some_foo"
     * formatters = ["PCS", "UPPER"]
     * 
     * Output:
     * 1st pass: "Some Foo"
     * 2nd pass: "SOME FOO"
     * </pre>
     */
    public static String chainedFormat(String str, String[] formats)
    {
        // chained formatting
        String formatted = str;
        for (String f : formats)
            formatted = format(formatted, f);

        return formatted;
    }
    
    static String removeDot(String str)
    {
        char c;
        int i = 0, len = str.length();
        StringBuilder sb = new StringBuilder(len);
        while (i < len)
        {
            if ('.' != (c = str.charAt(i++)))
                sb.append(c);
        }
        
        return len == sb.length() ? str : sb.toString();
    }

    /**
     * Formats the string {@code str} using the format {@code formatName}.
     * <p/>
     * If the formatter with the name does not exist, the input string will be appended with the formatName.
     */
    public static String format(String str, String formatName)
    {
        final Formatter formatter = DEFAULT_FORMATTERS.get(formatName);
        if (formatter != null)
            return formatter.format(str);
        
        // regex replace
        int eq = formatName.indexOf("=="), len;
        if (eq > 0)
        {
            len = formatName.length();
            
            /*if (len < 5 && len == eq + 2 && formatName.charAt(eq - 1) == '.' && 
                    (len == 3 || formatName.charAt(0) == '\\'))
            {
                // .== or \.==
                return removeDot(str);
            }*/
            
            return len == 4 && eq == 1 ?
                    // single char replacement
                    str.replace(formatName.charAt(0), formatName.charAt(3)) :
                    // regex replace
                    str.replaceAll(formatName.substring(0, eq), formatName.substring(eq + 2));
        }

        return str + formatName;
    }


    /*public static STGroup getSTG(String groupName)
    {
        return __loader.loadGroup(groupName);
    }

    public static ST getST(String groupName, String name)
    {
        return getSTG(groupName).getInstanceOf(name);
    }

    public static void setGroupLoader(STGroupLoader loader)
    {
        if (loader != null)
        {
            __loader = loader;
            STGroup.registerGroupLoader(loader);
        }
    }

    private static STGroupLoader __loader = GROUP_LOADER;*/

    protected final String id;

    public TemplatedCodeGenerator(String id)
    {
        this.id = id;
    }

    public String getOutputId()
    {
        return id;
    }

    public void compile(ProtoModule module) throws IOException
    {
        String ci = module.getOption("compile_imports");
        boolean compileImports = ci != null && !"false".equalsIgnoreCase(ci);
        boolean recursive = "recursive".equalsIgnoreCase(ci);

        File source = module.getSource();
        if (source.isDirectory())
        {
            for (File f : CompilerUtil.getProtoFiles(source, !module.getO().containsKey("exclude_dirs")))
                compile(module, parseProto(f, module), compileImports, recursive);
        }
        else
            compile(module, parseProto(source, module), compileImports, recursive);
    }

    protected static Proto parseProto(File file, ProtoModule module) throws IOException
    {
        CachingProtoLoader loader = module.getCachingProtoLoader();
        if (loader == null)
            return ProtoUtil.parseProto(file);
        
        return loader.loadFrom(file, null);
    }

    protected void compile(ProtoModule module, Proto proto, boolean compileImports,
            boolean recursive) throws IOException
    {
        final List<Proto> overridden = new ArrayList<Proto>();
        try
        {
            collect(module, proto, overridden, recursive);

            if (!recursive)
            {
                compile(module, proto);
                if (compileImports)
                {
                    for (Proto p : proto.getImportedProtos())
                        compile(module, p);
                }
            }
        }
        finally
        {
            for (Proto p : overridden)
                postCompile(module, p);
        }
    }

    protected void collect(ProtoModule module, Proto proto,
            List<Proto> overridden, boolean compile) throws IOException
    {
        for (Proto p : proto.getImportedProtos())
            collect(module, p, overridden, compile);

        if (override(module, proto))
            overridden.add(proto);

        if (compile)
            compile(module, proto);
    }

    protected static boolean override(ProtoModule module, Proto proto)
    {
        String pkg = proto.getPackageName();
        String jpkg = proto.getJavaPackageName();
        String opkg = module.getOption(pkg);
        String ojpkg = module.getOption(jpkg);
        boolean override = false;
        if (opkg != null && opkg.length() != 0)
        {
            proto.getMutablePackageName().override(opkg);
            override = true;
        }
        if (ojpkg != null && ojpkg.length() != 0)
        {
            proto.getMutableJavaPackageName().override(ojpkg);
            override = true;
        }
        return override;
    }

    protected static void postCompile(ProtoModule module, Proto proto)
    {
        proto.getMutableJavaPackageName().reset();
        proto.getMutablePackageName().reset();
    }

    protected abstract void compile(ProtoModule module, Proto proto) throws IOException;

}
