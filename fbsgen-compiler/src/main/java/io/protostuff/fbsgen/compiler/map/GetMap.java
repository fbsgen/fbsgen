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

import static io.protostuff.fbsgen.parser.AnnotationContainer.err;
import io.protostuff.fbsgen.compiler.CompilerUtil;
import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.HasName;
import io.protostuff.fbsgen.parser.Message;

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
    
    /*public static void main(String[] args)
    {
        int x = 8;
        System.err.println(Functions.BIT_POT_INDEX.get(x));
        // 3
    }*/
    
    public enum Functions implements Function
    {
        /**
         * bit power-of-two shift number.
         */
        BIT_POT_SHIFTNUM
        {
            public Object get(Object data)
            {
                int num = CompilerUtil.$int(data), 
                        count = 0;
                
                while (num != 0)
                {
                    num = num >>> 1;
                    count++;
                }
                    
                return count - 1;
            }
        },
        
        PB_FIELD_TYPE
        {
            public Object get(Object data)
            {
                Field<?> field = (Field<?>)data;
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
                    
                    default:
                        HasName udt = field.getUdt();
                        if (udt == null)
                            return type.toLowerCase();
                        
                        if (udt instanceof Message)
                            return ((Message)udt).getFullName();
                        
                        if (udt instanceof EnumGroup)
                            return ((EnumGroup)udt).getFullName();
                        
                        return udt.getName();
                }
            }
        },
        
        FBS_INT_TYPE
        {
            public Object get(Object data)
            {
                return Field.fbsIntType((String)data);
            }
        },
        
        FBS_MESSAGE_TYPE
        {
            public Object get(Object data)
            {
                Message m = (Message)data;
                Annotation ta = m.getTa();
                return ta != null && ta.getName().equals("struct") ? "struct" : "table";
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
