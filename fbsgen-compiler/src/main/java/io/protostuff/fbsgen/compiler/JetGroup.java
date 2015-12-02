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
import static io.protostuff.fbsgen.compiler.TemplatedCodeGenerator.chainedFormat;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import jetbrick.template.JetConfig;
import jetbrick.template.JetContext;
import jetbrick.template.JetEngine;
import jetbrick.template.JetGlobalVariables;
import jetbrick.template.JetTemplate;
import jetbrick.template.resource.FileSystemResource;
import jetbrick.template.resource.Resource;
import jetbrick.template.resource.loader.ResourceLoader;
import jetbrick.template.runtime.JetUtils;

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
    
    private static final HashMap<String,Object> VAR_MAP = new HashMap<String, Object>();
    
    static final JetEngine ENGINE;
    
    static
    {
        // set logging to warn
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "warn");
        // empty string evaluates to true
        JetUtils.STR_TRUE = "";
        
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
    
    public static final class GlobalVars implements JetGlobalVariables
    {
        @Override
        public Object get(JetContext context, String name)
        {
            return VAR_MAP.get(name);
        }
    }
    
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
    
    public static String format(String str, String formatName)
    {
        String[] formats = FORMAT_DELIM.split(formatName);

        return formats.length == 0 ? format(str, formatName) :
                chainedFormat(str, formats);
    }

}
