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

import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.ErrorMap;
import io.protostuff.fbsgen.parser.Message;

import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * Configuration for the proto w/c ontains the compile options and arguments.
 * 
 * @author David Yu
 * @created Jan 5, 2010
 */
public class ProtoModule implements Serializable
{

    private static final long serialVersionUID = 6231036933426077777L;

    private File source;
    private String output;
    private String encoding;
    private File outputDir;

    Properties options;
    Properties config;

    private CachingProtoLoader protoLoader;

    private HashMap<String, Object> attributes = new HashMap<String, Object>();
    
    final Writable writable = new Writable();

    public ProtoModule()
    {
        this(new Properties());
    }
    
    public ProtoModule(Properties options)
    {
        this.options = options;
    }

    public ProtoModule(File source, String output, String encoding, File outputDir)
    {
        this(new Properties());
        
        this.source = source;
        this.output = output;
        this.encoding = encoding;
        this.outputDir = outputDir;
    }

    public File getSource()
    {
        return source;
    }

    public void setSource(File source)
    {
        this.source = source;
    }

    public String getOutput()
    {
        return output;
    }

    public void setOutput(String output)
    {
        this.output = output;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }

    public File getOutputDir()
    {
        return outputDir;
    }

    public void setOutputDir(File outputDir)
    {
        this.outputDir = outputDir;
    }

    public Properties getOptions()
    {
        return options;
    }
    
    /**
     * Alias to {@link #getOptions()}.
     */
    public Properties getO()
    {
        return getOptions();
    }

    public void setOptions(Properties options)
    {
        this.options.putAll(options);
    }

    public String getOption(String key)
    {
        return options.getProperty(key);
    }

    public void setOption(String key, String value)
    {
        options.setProperty(key, value);
    }

    public CachingProtoLoader getCachingProtoLoader()
    {
        return protoLoader;
    }

    public void setCachingProtoLoader(CachingProtoLoader protoLoader)
    {
        this.protoLoader = protoLoader;
    }

    public Properties getConfig()
    {
        return config;
    }

    public void setAttribute(String key, Object value)
    {
        attributes.put(key, value);
    }

    public HashMap<String, Object> getAttributes()
    {
        return attributes;
    }
    
    /**
     * Alias for {@link #getAttributes()}.
     */
    public HashMap<String, Object> getAttrs()
    {
        return getAttributes();
    }
    
    /**
     * Alias for {@link #getAttributes()}.
     */
    public HashMap<String, Object> getA()
    {
        return getAttributes();
    }
    
    /**
     * Lazily creates a {@link Writable}.
     */
    public Writable getWritable()
    {
        return writable;
    }
    
    public Writable wk(String key)
    {
        Writable w = writable;
        w.setkey.get(key);
        return w;
    }
    
    public Writable wn(Integer num)
    {
        Writable w = writable;
        w.setnumber.get(num);
        return w;
    }
    
    /**
     * Alias to {@link Writable#getNum()}.
     */
    public int getNum()
    {
        return writable.getNum();
    }
    
    /**
     * Alias to {@link Writable#val}.
     */
    public Object getVal()
    {
        return writable.val;
    }
    
    /**
     * Returns an empty list if the value is null.
     */
    @SuppressWarnings("unchecked")
    public List<Message> wget_mlist(String key)
    {
        Writable w = getWritable();
        List<Message> list = (List<Message>)w.map.get(key);
        if (list == null)
            list = Collections.emptyList();
        return list;
    }
    
    /**
     * Returns an empty list if the value is null.
     */
    @SuppressWarnings("unchecked")
    public List<EnumGroup> wget_eglist(String key)
    {
        Writable w = getWritable();
        List<EnumGroup> list = (List<EnumGroup>)w.map.get(key);
        if (list == null)
            list = Collections.emptyList();
        return list;
    }
    
    /**
     * Alias to {@link #getWritable()}.
     */
    public Writable getW()
    {
        return getWritable();
    }
    
    public ProtoModule clear()
    {
        return clear(false);
    }
    
    public ProtoModule clear(boolean clearAttrs)
    {
        writable.getClearAll();
        
        if (clearAttrs)
            attributes.clear();
        
        return this;
    }
    
    public String getLc()
    {
        return "{";
    }
    
    public String getRc()
    {
        return "}";
    }
    
    public String getEmpty()
    {
        return "";
    }
    
    /**
     * Used by the templates to print/throw an error msg.
     */
    public ErrorMap getErr()
    {
        return ErrorMap.INSTANCE;
    }
    
    public Env getEnv()
    {
        return Env.INSTANCE;
    }
    
    public static final class Env
    {
        static final Env INSTANCE = new Env();
        
        final String basePath, basePrefix;
        
        private Env()
        {
            basePath = CompilerUtil.BASE_DIR.toString();
            basePrefix = basePath + "/";
        }
        
        public File getBaseDir()
        {
            return CompilerUtil.BASE_DIR;
        }
        
        public String getBasePath()
        {
            return basePath;
        }
        
        public String getBasePrefix()
        {
            return basePrefix;
        }
    }
}
