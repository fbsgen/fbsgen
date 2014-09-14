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
import io.protostuff.fbsgen.compiler.ProtoModule;
import io.protostuff.fbsgen.compiler.Writable;

import java.util.List;
import java.util.Map;

/**
 * A map that simply creates objects.
 * 
 * @author David Yu
 * @created Aug 10, 2013
 */
public final class NewMap extends FakeMap
{

    public interface Function
    {
        Object create(Object data);
    }

    public final Function func;
    
    public NewMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.create(key);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    public enum Functions implements Function
    {
        WRITABLE
        {
            @SuppressWarnings("unchecked")
            public Object create(Object data)
            {
                final Writable w = new Writable();
                
                if (data instanceof ProtoModule)
                    ((ProtoModule)data).setAttribute("w", w);
                else if (data instanceof Map)
                    ((Map<Object,Object>)data).put("w", w);
                else if (data instanceof List)
                    ((List<Object>)data).add(w);
                    
                return w;
            }
        }
        ;
        
        public final NewMap map;

        private Functions()
        {
            map = new NewMap("new_" + name().toLowerCase(), this);
        }
    }

}
