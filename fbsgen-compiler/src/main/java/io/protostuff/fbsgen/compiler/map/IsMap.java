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

import static io.protostuff.fbsgen.compiler.CompilerUtil.$int;
import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.compiler.JetGroup;
import io.protostuff.fbsgen.parser.AnnotationContainer;

import java.util.Collection;
import java.util.List;
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

    public final Function func;
    
    public IsMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.is(key) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    static int sizeOf(int fieldNumber)
    {
        return fieldNumber > 15 ? 2 : 1;
    }
    
    public enum Functions implements Function
    {
        ZERO
        {
            public boolean is(Object data)
            {
                return 0 == ((Number)data).intValue();
            }
        },
        
        EXCLUDE_CLIENT
        {
            public boolean is(Object data)
            {
                return JetGroup.Base.is_exclude_client((AnnotationContainer)data);
            }
        },
        
        EXCLUDE_SERVER
        {
            public boolean is(Object data)
            {
                return JetGroup.Base.is_exclude_server((AnnotationContainer)data);
            }
        },
        
        NULL_OR_EMPTY
        {
            public boolean is(Object data)
            {
                return JetGroup.Base.is_null_or_empty(data);
            }
        },
        
        SIZE_ZERO
        {
            public boolean is(Object data)
            {
                if (data instanceof String)
                    return data.toString().length() == 0;
                
                return data instanceof Map ? ((Map<?,?>)data).isEmpty() : 
                    ((Collection<?>)data).isEmpty();
            }
        },
        
        SIZE_ONE
        {
            public boolean is(Object data)
            {
                if (data instanceof String)
                    return data.toString().length() == 1;
                
                return data instanceof Map ? ((Map<?,?>)data).size() == 1 : 
                    ((Collection<?>)data).size() == 1;
            }
        },
        
        SIZE_GT_ONE
        {
            public boolean is(Object data)
            {
                if (data instanceof String)
                    return data.toString().length() > 1;
                
                return data instanceof Map ? ((Map<?,?>)data).size() > 1 : 
                    ((Collection<?>)data).size() > 1;
            }
        },
        
        POWER_OF_TWO
        {
            public boolean is(Object data)
            {
                return JetGroup.Base.is_power_of_two($int(data));
            }
        },
        
        INSTANCEOF_STRING
        {
            public boolean is(Object data)
            {
                return data instanceof String;
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
