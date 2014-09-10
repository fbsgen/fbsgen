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

package io.protostuff.fbsgen.compiler.registry;

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
}
