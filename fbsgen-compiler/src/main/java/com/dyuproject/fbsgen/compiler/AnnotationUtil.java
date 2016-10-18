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

import com.dyuproject.fbsgen.parser.Annotation;
import com.dyuproject.fbsgen.parser.AnnotationContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link Annotation} utils.
 * 
 * @author David Yu
 * @created Sep 13, 2014
 */
public final class AnnotationUtil
{
    private AnnotationUtil() {}
    
    static Object get(final AnnotationContainer ac, final String name, 
            final String key)
    {
        Annotation a = ac.getAnnotation(name);
        return a == null ? null : a.getP().get(key);
    }
    
    public static int count(final AnnotationContainer ac, final String name, 
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
    
    public static int count(final AnnotationContainer ac, final String name, 
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
    
    public static List<Object> list(final AnnotationContainer ac, final String name, 
            final String key)
    {
        final Annotation a = ac.getAnnotation(name);
        if (a == null)
            return Collections.emptyList();
        
        return fillList(new ArrayList<Object>(), a, key);
    }
    
    public static List<String> keys(final AnnotationContainer ac, final String name, 
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
            final Annotation a, final String key)
    {
        for (String k = key + list.size(); a.getP().containsKey(k); k = key + list.size())
            list.add(a.getP().get(k));
        
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
    
    public static Map<String,Object> map(final AnnotationContainer ac, 
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
}
