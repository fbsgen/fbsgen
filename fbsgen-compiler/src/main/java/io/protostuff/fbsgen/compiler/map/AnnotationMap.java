//========================================================================
//Copyright 2013 David Yu
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

package io.protostuff.fbsgen.compiler.map;

import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.AnnotationContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A map for querying within ST.
 * 
 * @author David Yu
 * @created Mar 27, 2013
 */
public final class AnnotationMap extends FakeMap
{
    
    public interface Function
    {
        Object query(AnnotationContainer target);
    }

    public final Function func;
    
    public AnnotationMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.query((AnnotationContainer)key);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    static Object get(final AnnotationContainer ac, final String name, 
            final String key)
    {
        Annotation a = ac.getAnnotation(name);
        return a == null ? null : a.getP().get(key);
    }
    
    static int count(final AnnotationContainer ac, final String name, 
            final String key, final String prefix)
    {
        final Annotation a = ac.getAnnotation(name);
        if (a == null)
            return 0;
        
        int count = 0, filterCount = 0;
        
        while(a.getP().containsKey(key + count))
        {
            if (Boolean.TRUE.equals(a.getP().get(prefix + key + count)))
                filterCount++;
            
            count++;
        }
        
        return filterCount;
    }
    
    static int count(final AnnotationContainer ac, final String name, 
            final String key)
    {
        final Annotation a = ac.getAnnotation(name);
        if (a == null)
            return 0;
        
        int count = 0;
        
        while(a.getP().containsKey(key + count))
            count++;
        
        return count;
    }
    
    static List<Object> list(final AnnotationContainer ac, final String name, 
            final String key)
    {
        final Annotation a = ac.getAnnotation(name);
        if (a == null)
            return Collections.emptyList();
        
        return fillList(new ArrayList<Object>(), a, key);
    }
    
    public static List<Object> fillList(final ArrayList<Object> list, 
            final Annotation a, final String key)
    {
        for (String k = key + list.size(); a.getP().containsKey(k); k = key + list.size())
            list.add(a.getP().get(k));
        
        return list;
    }
    
    static List<String> keys(final AnnotationContainer ac, final String name, 
            final String key)
    {
        final Annotation a = ac.getAnnotation(name);
        if (a == null)
            return Collections.emptyList();
        
        return fillKeys(new ArrayList<String>(), a, key);
    }
    
    public static List<String> fillKeys(final ArrayList<String> list, 
            final Annotation a, final String key)
    {
        for (String k = key + list.size(); a.getP().containsKey(k); k = key + list.size())
            list.add(k);
        
        return list;
    }
    
    public static List<Object> fillList(final ArrayList<Object> list, 
            final Annotation a, final String key, Map<Object,Object> valueIndexMap)
    {
        for (String k = key + list.size(); a.getP().containsKey(k); k = key + list.size())
        {
            Object value = a.getP().get(k);
            valueIndexMap.put(value, list.size());
            list.add(value);
        }
        
        return list;
    }
    
    /*public static List<String> fillKeys(final ArrayList<String> list, 
            final Annotation a, final String key, Map<Object,Object> valueIndexMap)
    {
        for (String k = key + list.size(); a.getP().containsKey(k); k = key + list.size())
        {
            valueIndexMap.put(a.getP().get(k), list.size());
            list.add(k);
        }
        
        return list;
    }*/
    
    static Map<String,Object> map(final AnnotationContainer ac, 
            final String name, final String key)
    {
        final Annotation a = ac.getAnnotation(name);
        if (a == null)
            return Collections.emptyMap();
        
        return fillMap(new LinkedHashMap<String, Object>(), a, key);
    }
    
    public static Map<String,Object> fillMap(final Map<String,Object> map, 
            final Annotation a, final String key)
    {
        for (String k = key + map.size(); a.getP().containsKey(k); k = key + map.size())
            map.put(k, a.getP().get(k));
        
        return map;
    }
    
    public enum Functions implements Function
    {
        count_Display_entry
        {
            public Object query(AnnotationContainer ac)
            {
                return count(ac, "Display", "entry");
            }
        },
        count_Display_new_entry
        {
            public Object query(AnnotationContainer ac)
            {
                return count(ac, "Display", "entry", "new_");
            }
        },
        count_Display_update_entry
        {
            public Object query(AnnotationContainer ac)
            {
                return count(ac, "Display", "entry", "update_");
            }
        },
        list_Display_entry
        {
            public Object query(AnnotationContainer ac)
            {
                return list(ac, "Display", "entry");
            }
        },
        keys_Display_entry
        {
            public Object query(AnnotationContainer ac)
            {
                return keys(ac, "Display", "entry");
            }
        },
        map_Display_entry
        {
            public Object query(AnnotationContainer ac)
            {
                return map(ac, "Display", "entry");
            }
        }
        ;
        
        public final AnnotationMap map;

        private Functions()
        {
            map = new AnnotationMap("a_" + name(), this);
        }
    }

}
