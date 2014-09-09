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
import io.protostuff.fbsgen.compiler.TemplateGroup;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.HasName;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.Proto;
import io.protostuff.fbsgen.parser.Service.RpcMethod;

import java.util.Collection;
import java.util.Map;

/**
 * A map that returns true/false based the param.
 * 
 * @author David Yu
 * @created Jul 25, 2013
 */
public final class IsMap extends FakeMap
{
    
    public interface Function
    {
        boolean is(Object data);
    }

    public final String id;
    public final Function func;
    
    public IsMap(String id, Function func)
    {
        this.id = id;
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.is(key) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public static void addAllTo(TemplateGroup group)
    {
        for (Functions c : Functions.values())
            group.put(c.map.id, c.map);
    }
    
    static int sizeOf(int fieldNumber)
    {
        return fieldNumber > 15 ? 2 : 1;
    }
    
    public enum Functions implements Function
    {
        NOT_ZERO
        {
            public boolean is(Object data)
            {
                return 0 != ((Number)data).intValue();
            }
        },
        
        NULL_OR_EMPTY
        {
            public boolean is(Object data)
            {
                if(data == null)
                    return true;
                
                return data instanceof Map ? ((Map<?,?>)data).isEmpty() : 
                    ((Collection<?>)data).isEmpty();
            }
        },
        
        SIZE_ZERO
        {
            public boolean is(Object data)
            {
                return data instanceof Map ? ((Map<?,?>)data).isEmpty() : 
                    ((Collection<?>)data).isEmpty();
            }
        },
        
        SIZE_ONE
        {
            public boolean is(Object data)
            {
                return data instanceof Map ? ((Map<?,?>)data).size() == 1 : 
                    ((Collection<?>)data).size() == 1;
            }
        },
        
        SIZE_GT_ONE
        {
            public boolean is(Object data)
            {
                return data instanceof Map ? ((Map<?,?>)data).size() > 1 : 
                    ((Collection<?>)data).size() > 1;
            }
        },
        
        GT15
        {
            public boolean is(Object data)
            {
                return data instanceof Integer && ((Integer)data).intValue() > 15 ? 
                        Boolean.TRUE : Boolean.FALSE;
            }
        },
        
        POWER_OF_TWO
        {
            public boolean is(Object data)
            {
                int num = ((Integer)data).intValue();
                return num > 0 && 0 == (num & (num-1));
            }
        },
        
        RPC_READ_ONLY
        {
            public boolean is(Object data)
            {
                RpcMethod rm = (RpcMethod)data;
                String name = rm.getName();
                
                return name.startsWith("get") || name.startsWith("list") || 
                        name.startsWith("find") || 
                        // q followed by [A-Z]
                        (name.charAt(0) == 'q' && name.charAt(1) > 96);
            }
        },
        
        AUTH_REQUIRED
        {
            public boolean is(Object data)
            {
                EnumGroup.Value v = (EnumGroup.Value)data;
                
                Boolean b = (Boolean)v.getOptions().get("auth_required");
                
                if(b != null)
                    return b.booleanValue();
                
                Annotation a = v.getEnumGroup().getAnnotation("ServiceGroup");
                return a != null && Boolean.TRUE.equals(a.getValue("auth_required"));
            }
        },
        
        /*ENTITY
        {
            public boolean is(Object data)
            {
                return data instanceof Message && IsMessageMap.Functions.ENTITY.query(
                        (Message)data);
            }
        },*/
        
        PROTO_PROTOSTUFF_DS_PKG
        {
            public boolean is(Object data)
            {
                return data instanceof Proto && ((Proto)data).getPackageName().startsWith(
                        "com.dyuproject.protostuff.ds.");
            }
        },
        
        STR_ENDS_WITH_UPPER_S
        {
            public boolean is(Object data)
            {
                return data instanceof String && ((String)data).endsWith("S");
            }
        },
        
        TYPE_STRING
        {
            public boolean is(Object data)
            {
                return data instanceof String;
            }
        },
        
        STARTS_WITH_DOT
        {
            public boolean is(Object data)
            {
                return data.toString().charAt(0) == '.';
            }
        },
        
        STARTS_WITH_SI
        {
            public boolean is(Object data)
            {
                return data.toString().startsWith("SI_");
            }
        },
        
        SINGLE_COMPUTED_UPDATE_FIELD
        {
            public boolean is(Object data)
            {
                final Object first;
                if (data instanceof Map)
                {
                    if (((Map<?,?>)data).size() != 1)
                        return false;
                    
                    first = ((Map<?,?>)data).values().iterator().next();
                }
                else
                {
                    if (((Collection<?>)data).size() != 1)
                        return false;
                    
                    first = ((Collection<?>)data).iterator().next();
                }
                
                return ((Field<?>)first).getO().containsKey("compute_to_parent");
            }
        },
        
        PARAM_UPDATE
        {
            public boolean is(Object data)
            {
                return ((Message)data).getName().indexOf("Update") != -1;
            }
        },
        
        KEY_OR_ENDS_WITH
        {
            public boolean is(Object data)
            {
                if (data == null)
                    return false;
                
                final String str = data instanceof HasName ? 
                        ((HasName)data).getName() : data.toString();
                
                return str.length() == 3 ? str.equals("key") : str.endsWith("_key");
            }
        }
        ;
        
        public final IsMap map;

        private Functions()
        {
            map = new IsMap("is_" + name().toLowerCase(), this);
        }
    }
}
