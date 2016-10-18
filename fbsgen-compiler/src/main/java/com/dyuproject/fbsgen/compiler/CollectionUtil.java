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
import com.dyuproject.fbsgen.parser.Proto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Collection utils.
 * 
 * @author David Yu
 * @created Aug 26, 2014
 */
public final class CollectionUtil
{
    private CollectionUtil() {}

    public static <K,T> void addTo(HashMap<K,ArrayList<T>> map, T entry, 
            K key)
    {
        ArrayList<T> existing = map.get(key);
        if (existing == null)
        {
            existing = new ArrayList<T>();
            map.put(key, existing);
        }
        
        existing.add(entry);
    }
    
    public static <K,T> void addTo(Map<K,Object> map, T entry, 
            K key)
    {
        @SuppressWarnings("unchecked")
        ArrayList<T> existing = (ArrayList<T>)map.get(key);
        if (existing == null)
        {
            existing = new ArrayList<T>();
            map.put(key, existing);
        }
        
        existing.add(entry);
    }
    
    public static <T> void addTo(final HashMap<String,ArrayList<T>> map, final T entry, 
            final ProtoModule module, final String[] stgs, final Proto proto)
    {
        for (String stg : stgs)
        {
            stg = stg.trim();
            
            if (stg.charAt(0) == '_')
            {
                // search in proto, then options then config
                String csv = proto == null ? null : (String)proto.getOptions().get(stg);
                if (null != csv 
                        || null != (csv = module.getOptions().getProperty(stg))
                        || null != (csv = module.getConfig().getProperty(stg)))
                {
                    // referenced
                    addTo(map, entry, module, COMMA.split(csv), null);
                    continue;
                }
            }
            
            CollectionUtil.addTo(map, entry, stg);
        }
    }
}
