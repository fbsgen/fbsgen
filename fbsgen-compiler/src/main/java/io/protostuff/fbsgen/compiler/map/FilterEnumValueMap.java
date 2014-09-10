//========================================================================
//Copyright 2012 David Yu
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
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.EnumGroup.Value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Codegen helper for filtering enum values.
 * 
 * @author David Yu
 * @created Nov 12, 2012
 */
public final class FilterEnumValueMap extends FakeMap
{
    
    public interface Function
    {
        Collection<Value> filter(EnumGroup eg);
    }
    
    public final String id;
    public final Function func;
    
    public FilterEnumValueMap(String id, Function func)
    {
        this.id = id;
        this.func = func;
    }

    public Object get(Object key)
    {
        return key instanceof EnumGroup ? func.filter((EnumGroup)key) : 
            Collections.EMPTY_LIST;
    }
    
    public static void addAllTo(TemplateGroup group)
    {
        for (Functions f : Functions.values())
            group.put(f.map.id, f.map);
    }
    
    public enum Functions implements Function
    {
        ANN_USER_MANAGED
        {

            public Collection<Value> filter(EnumGroup eg)
            {
                final ArrayList<Value> list = new ArrayList<Value>();
                
                for (Value v : eg.getValues())
                {
                    if (v.getAnnotation("UserManaged") != null)
                        list.add(v);
                }
                
                return list;
            }
            
        }
        ;
        
        public final FilterEnumValueMap map;

        private Functions()
        {
            map = new FilterEnumValueMap("filter_ev_" + name().toLowerCase(), this);
        }
    }

}
