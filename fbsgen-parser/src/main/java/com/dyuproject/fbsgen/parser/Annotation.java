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

package com.dyuproject.fbsgen.parser;

import static com.dyuproject.fbsgen.parser.AnnotationContainer.err;
import static com.dyuproject.fbsgen.parser.AnnotationContainer.msg;

import java.util.LinkedHashMap;

/**
 * Annotation for messages, enums, services, rpc, fields
 *
 * @author David Yu
 * @created Dec 30, 2010
 */
public final class Annotation implements HasName
{
    final String name;
    final Proto proto;
    
    final LinkedHashMap<String,Object> refs = new LinkedHashMap<String,Object>(); 
    final LinkedHashMap<String,Object> params = new LinkedHashMap<String,Object>();
    
    public Annotation(String name, Proto proto)
    {
        this.name = name;
        this.proto = proto;
    }
    
    public LinkedHashMap<String,Object> getParams()
    {
        return params;
    }
    
    public LinkedHashMap<String,Object> getRefs()
    {
        return refs;
    }
    
    /**
     * Shorthand for {@link #getParams()}.
     * 
     * <pre>
     * If you have an annotation like &#64;Foo(id = 1), you then can use:
     * &lt;if (message.a.("Foo")&gt;
     * &lt;if (message.a.("Foo").p.("id")&gt;
     * ...
     * &lt;endif&gt;
     * &lt;endif&gt;
     * </pre>
     */
    public final LinkedHashMap<String,Object> getP()
    {
        return params;
    }
    
    void put(String key, Object value)
    {
        if ("default".equals(key))
        {
            System.err.println(
                    msg("default is a reserved keyword for non-repeated scalar fields.", 
                            proto));
        }
        else if (params.put(key, value) != null)
        {
            throw err("@" + name + "::" + key + " cannot be defined more than once.", 
                    proto);
        }
    }
    
    void putRef(String key, Object value)
    {
        put(key, value);
        refs.put(key, value);
    }
    
    @SuppressWarnings("unchecked")
    public <T> T getValue(String key)
    {
        return (T)params.get(key);
    }
    
    public int getInt(String key, int defaultValue)
    {
        Integer val = (Integer)params.get(key);
        return val == null ? defaultValue : val.intValue();
    }

    public String getName()
    {
        return name;
    }
    
    /**
     * Shorthand for params.isEmpty().
     * 
     * <pre>
     * You can then use:
     * &lt;if (message.a.("Foo").emptyP&gt;
     * </pre>
     * 
     * <pre>
     * Note that this does not work on stringtemplate: 
     * &lt;if (message.a.("Foo").empty)&gt;
     * 
     * Even though {@link java.util.Map#isEmpty()} exists. 
     * </pre>
     */
    public final boolean isEmptyP()
    {
        return params.isEmpty();
    }
    
    public String toString()
    {
        return getName();
    }

}
