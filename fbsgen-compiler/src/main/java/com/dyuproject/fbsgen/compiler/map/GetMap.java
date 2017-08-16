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

package com.dyuproject.fbsgen.compiler.map;

import static com.dyuproject.fbsgen.compiler.CompilerUtil.$int;
import com.dyuproject.fbsgen.compiler.FakeMap;
import com.dyuproject.fbsgen.compiler.JetGroup;
import com.dyuproject.fbsgen.parser.EnumGroup;
import com.dyuproject.fbsgen.parser.Field;
import com.dyuproject.fbsgen.parser.Message;

import java.util.Collection;
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
    
    static final class FakeField extends Field<Object>
    {
        final java.lang.String fbsType;

        FakeField(java.lang.String fbsType)
        {
            this.fbsType = fbsType;
        }
        
        @Override
        public java.lang.String getJavaType()
        {
            return "fake";
        }

        @Override
        public java.lang.String getFbsType()
        {
            return fbsType;
        }

        @Override
        public void resolvePbType()
        {
            
        }
        
        @Override
        public FakeField create()
        {
            return new FakeField(fbsType);
        }
    }
    
    public enum Functions implements Function
    {
        /**
         * bit power-of-two shift number.
         */
        BIT_POT_SHIFTNUM
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_bit_pot_shiftnum($int(data));
            }
        },
        
        SPARSE_ENUM_VALUE_NAMES
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_sparse_enum_value_names((EnumGroup)data);
            }
        },
        
        PB_FIELD_TYPE
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_pb_field_type((Field<?>)data);
            }
        },
        
        FBS_FIELD_OFFSET
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_fbs_field_offset($int(data));
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
                return JetGroup.Base.get_fbs_message_type((Message)data);
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
                if (Boolean.TRUE.equals(f.getOption("cas_protected")))
                    result |= 8;
                
                return result;
            }
        },
        
        STRUCT_MD
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_struct_md((Message)data);
            }
        },
        
        STR_LAST_NS
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_str_last_ns((String)data);
            }
        },
        
        STR_FIRST_NS
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_str_first_ns((String)data);
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
