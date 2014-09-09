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

    public final String id;
    public final Function func;
    
    public NewMap(String id, Function func)
    {
        this.id = id;
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.create(key);
    }
    
    public static void addAllTo(TemplateGroup group)
    {
        for (Functions c : Functions.values())
            group.put(c.map.id, c.map);
    }
    
    public enum Functions implements Function
    {
        WRITABLE
        {
            public Object create(Object data)
            {
                return null;//return new Writable();
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
