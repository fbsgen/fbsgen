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
import io.protostuff.fbsgen.parser.Field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * A map that retrieves any value from any param.
 * 
 * @author David Yu
 * @created Apr 9, 2013
 */
public final class GetMap extends FakeMap
{
    
    public interface Function
    {
        Object get(Object data);
    }

    public final Function func;
    
    public GetMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.get(key);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    public enum Functions implements Function
    {
        FBS_INT_TYPE
        {
            public Object get(Object data)
            {
                return Field.fbsIntType((String)data);
            }
        },
        
        SIZE
        {
            public Object get(Object data)
            {
                return data instanceof Map ? ((Map<?,?>)data).size() : 
                    ((Collection<?>)data).size();
            }
        },
        
        FIRST
        {
            public Object get(Object data)
            {
                return data instanceof Map ? ((Map<?,?>)data).values().iterator().next() : 
                    ((Collection<?>)data).iterator().next();
            }
        },
        
        FIELD_ACCESS_BITS
        {
            public Object get(Object data)
            {
                int result = 0;
                Field<?> f = (Field<?>)data;
                
                if (Boolean.TRUE.equals(f.getOption("readonly")))
                    result |= 1;
                if (Boolean.TRUE.equals(f.getOption("provided")))
                    result |= 2;
                if (Boolean.TRUE.equals(f.getOption("immutable")))
                    result |= 4;
                
                return result;
            }
        },
        SORTED_DISPLAY_FIELDS
        {
            @SuppressWarnings("unchecked")
            public Object get(Object data)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>((List<Field<?>>)data);
                Collections.sort(list, FilterMap.DISPLAY_ORDER_COMPARATOR);
                return list;
            }
        }
        ;
        public final GetMap map;

        private Functions()
        {
            map = new GetMap("get_" + name().toLowerCase(), this);
        }
    }
}
