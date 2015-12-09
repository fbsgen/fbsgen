//========================================================================
//Copyright 2015 David Yu
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

import static io.protostuff.fbsgen.compiler.TemplatedCodeGenerator.FORMAT_DELIM;
import static io.protostuff.fbsgen.parser.AnnotationContainer.err;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.HasName;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.ParseException;
import io.protostuff.fbsgen.parser.Proto;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import jetbrick.template.JetConfig;
import jetbrick.template.JetContext;
import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;
import jetbrick.template.parser.JetTemplateCodeVisitor;
import jetbrick.template.resource.FileSystemResource;
import jetbrick.template.resource.Resource;
import jetbrick.template.resource.loader.ResourceLoader;
import jetbrick.template.runtime.JetPage;
import jetbrick.template.runtime.JetUtils;
import jetbrick.template.runtime.JetWriter;
import jetbrick.template.utils.UnsafeCharArrayWriter;

/**
 * TODO
 * 
 * @author David Yu
 * @created Dec 1, 2015
 */
public final class JetGroup implements TemplateGroup, Template
{
    private static final String ENCODING = "utf-8";
    
    private static final HashMap<String,FileSystemResource> CACHE = 
            new HashMap<String,FileSystemResource>();
    
    //private static final HashMap<String,Object> VAR_MAP = new HashMap<String, Object>();
    
    static final JetEngine ENGINE;
    
    static
    {
        // set logging to warn
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "warn");
        // empty string evaluates to true
        JetUtils.STR_TRUE = "";
        
        JetTemplateCodeVisitor.NON_VOID_CALL.put("sort", Boolean.TRUE);
        JetTemplateCodeVisitor.NON_VOID_CALL.put("split", Boolean.TRUE);
        
        /*StringBuilder buffer = new StringBuilder();
        int i = 0;
        for (FakeMap fm : FakeMapUtil.LIST)
        {
            if (1 != ++i)
                buffer.append(", ");
            
            buffer.append("Map<Object,Object> ").append(fm.name);
            VAR_MAP.put(fm.name, fm);
        }*/
        
        ENGINE = JetEngine.create(newConfig(/*buffer.toString()*/));
    }
    
    private static Properties newConfig(/*String importVars*/)
    {
        Properties config = new Properties();
        
        config.put(JetConfig.INPUT_ENCODING, ENCODING);
        config.put(JetConfig.OUTPUT_ENCODING, ENCODING);
        
        config.put(JetConfig.TRIM_DIRECTIVE_COMMENTS, "false");
        
        //config.put(JetConfig.IMPORT_VARIABLES, importVars);
        //config.put(JetConfig.GLOBAL_VARIABLES, GlobalVars.class.getName());
        
        config.put(JetConfig.IMPORT_PACKAGES, 
                "io.protostuff.fbsgen.compiler.*, io.protostuff.fbsgen.parser.*");
        
        config.put(JetConfig.TEMPLATE_LOADER, Loader.class.getName());
        config.put(JetConfig.TEMPLATE_PATH, new File(".").getAbsolutePath()); // dummy
        config.put(JetConfig.TEMPLATE_SUFFIX, ".jetg");
        
        config.put(JetConfig.COMPILE_STRATEGY, "auto");
        config.put(JetConfig.COMPILE_PATH, "target/jetg");
        
        return config;
    }
    
    static FileSystemResource put(String name, File file)
    {
        FileSystemResource fsr = new FileSystemResource(name, file, ENCODING);
        CACHE.put(name, fsr);
        return fsr;
    }
    
    /*public static final class GlobalVars implements JetGlobalVariables
    {
        @Override
        public Object get(JetContext context, String name)
        {
            return VAR_MAP.get(name);
        }
    }*/
    
    public static final class Loader implements ResourceLoader
    {
        @Override
        public void initialize(JetEngine engine, String basepath, String encoding)
        {
            
        }

        @Override
        public Resource load(final String name)
        {
            FileSystemResource fsr = CACHE.get(name);
            if (fsr == null)
            {
                File file = TemplateUtil.lookupFile(name.substring(1));
                if (file == null)
                    return null;
                
                fsr = put(name, file);
            }
            
            return fsr;
        }

        @Override
        public List<String> loadAll()
        {
            return Collections.emptyList();
        }
    }
    
    final String path;
    final File file;
    final JetTemplate template;
    
    public JetGroup(String path, File file)
    {
        this.path = path;
        this.file = file;
        
        put("/" + path, file);
        
        template = ENGINE.getTemplate(path);
    }

    @Override
    public Template getTemplate(String name)
    {
        return template.getJetPage().hasProcBlock(name) ? this : null;
    }

    @Override
    public void put(String name, FakeMap map)
    {
        // noop
    }

    @Override
    public void renderTo(Writer writer, String argName, Object argValue, ProtoModule module)
            throws IOException
    {
        JetContext context = new JetContext();
        context.put(argName, argValue);
        context.put("module", module);
        template.render(context, writer);
    }
    
    public static abstract class Base extends JetPage
    {
        public static String format(Object it, String formatName)
        {
            if (it == null)
                return "";
            
            String str = it.toString();
            String[] formats = FORMAT_DELIM.split(formatName);

            return formats.length == 0 ? TemplatedCodeGenerator.format(str, formatName) :
                TemplatedCodeGenerator.chainedFormat(str, formats);
        }
        
        public static void separator(JetWriter $out, Object it, String param, int i) 
                throws IOException
        {
            if (i != 0)
                $out.print(param);
        }
        
        public static void error(JetWriter $out, Proto proto, String msg)
        {
            throw new ParseException(msg + " [ " + proto.getSourcePath() + " ] ");
        }
        
        /* ================================================== */
        // st built-in functions
        
        public static <T> List<T> reverse(List<T> list)
        {
            ArrayList<T> reversed = new ArrayList<T>(list);
            Collections.reverse(reversed);
            return reversed;
        }
        
        public static <T> List<T> rest(List<T> list)
        {
            return list.subList(1, list.size());
        }
        
        public static <T> T last(List<T> list)
        {
            return list.get(list.size()-1);
        }
        
        public static <T> T first(List<T> list)
        {
            return list.get(0);
        }
        
        /* ================================================== */
        // new utils
        
        public static UnsafeCharArrayWriter new_writer(int size)
        {
            return new UnsafeCharArrayWriter(size);
        }
        
        public static JetWriter new_jet_writer(Writer writer)
        {
            return JetWriter.create(writer, ENCODING);
        }
        
        /* ================================================== */
        // split utils TODO raw string array?
        
        public static List<String> split_dot(String str)
        {
            List<String> list = Collections.emptyList();
            if (str != null && !str.isEmpty())
                list = Arrays.asList(CompilerUtil.DOT.split(str));
            return list;
        }
        
        /* ================================================== */
        // sort utils
        
        public static List<Field<?>> sort_fbs_create_fields(Message message)
        {
            final ArrayList<Field<?>> list = new ArrayList<Field<?>>(
                    message.getNonDeprecatedFields());
            
            Annotation ta = message.getTa();
            if (ta != null && Boolean.TRUE.equals(ta.getP().get("original_order")))
                Collections.reverse(list);
            else
                Collections.sort(list, TypeUtil.CMP_CREATE_FIELDS);
            
            return list;
        }
        
        /* ================================================== */
        // is_* methods
        
        public static boolean is_null_or_empty(Object data)
        {
            if (data == null)
                return true;
            
            if (data instanceof String)
                return ((String)data).isEmpty();
            
            return data instanceof Map ? ((Map<?,?>)data).isEmpty() : 
                ((Collection<?>)data).isEmpty();
        }
        
        public static boolean is_power_of_two(int num)
        {
            return num > 0 && 0 == (num & (num-1));
        }
        
        /* ================================================== */
        // get_* methods
        
        public static int get_bit_pot_shiftnum(int num)
        {
            int count = 0;
            
            while (num != 0)
            {
                num = num >>> 1;
                count++;
            }
                
            return count - 1;
        }
        
        public static String get_fbs_int_type(String data)
        {
            return Field.fbsIntType(data);
        }
        
        public static int get_fbs_field_offset(int fieldNumber)
        {
            return 4 + ((fieldNumber - 1) << 1);
        }
        
        public static String get_fbs_message_type(Message m)
        {
            Annotation ta = m.getTa();
            return ta != null && ta.getName().equals("struct") ? "struct" : "table";
        }
        
        public static StructMetadata get_struct_md(Message message)
        {
            return StructMetadata.create(message, new ArrayList<Field<?>>(), 
                    new ArrayList<Field<?>>());
        }
        
        public static List<String> get_sparse_enum_value_names(EnumGroup eg)
        {
            final ArrayList<String> list = new ArrayList<String>();
            
            final ArrayList<EnumGroup.Value> values = eg.getValues();
            int j = 0;
            EnumGroup.Value v = values.get(j++);
            list.add(v.getName());
            
            for (int i = v.getNumber(), 
                    len = values.get(values.size() - 1).getNumber(); 
                    i < len; i++)
            {
                v = values.get(j);
                if (i == (v.getNumber() - 1))
                {
                    list.add(v.getName());
                    j++;
                }
                else
                {
                    list.add("");
                }
            }
            
            return list;
        }
        
        public static String get_pb_field_type(Field<?> field)
        {
            String type = field.getClass().getSimpleName();
            switch(type.charAt(type.length()-1))
            {
                case '8': // int8
                    return type.toLowerCase().substring(0, type.length()-1) + "32";
                
                case '6': // int16
                    return type.toLowerCase().substring(0, type.length()-2) + "32";
                
                case '2': // int32
                    if (Boolean.TRUE.equals(field.getO().get("fixed")))
                        return type.charAt(0) == 'U' ? "fixed32" : "sfixed32";
                    
                    if (Boolean.TRUE.equals(field.getO().get("signed")))
                    {
                        if (type.charAt(0) == 'U')
                            throw err(field, " cannot be a signed int type", field.getProto());
                        
                        return "sint32";
                    }
                    
                    return type.toLowerCase();
                
                case '4': // int64
                    if (Boolean.TRUE.equals(field.getO().get("fixed")))
                        return type.charAt(0) == 'U' ? "fixed64" : "sfixed64";
                    
                    if (Boolean.TRUE.equals(field.getO().get("signed")))
                    {
                        if (type.charAt(0) == 'U')
                            throw err(field, " cannot be a signed int type", field.getProto());
                        
                        return "sint64";
                    }
                    
                    return type.toLowerCase();
            }
            
            HasName udt = field.getUdt();
            if (udt == null)
                return type.toLowerCase();
            
            if (udt instanceof Message)
                return ((Message)udt).getFullName();
            
            if (udt instanceof EnumGroup)
                return ((EnumGroup)udt).getFullName();
            
            return udt.getName();
        }
        
        /* ================================================== */
        // str utils
        
        public static String get_substr(String str, String prefix)
        {
            return str.startsWith(prefix) ? str.substring(prefix.length()) : str;
        }
    }
}
