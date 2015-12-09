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

package io.protostuff.fbsgen.compiler.map;

import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.compiler.JetGroup;
import io.protostuff.fbsgen.parser.Message;

import java.util.List;

/**
 * Sorts the args.
 * 
 * @author David Yu
 * @created Sep 20, 2014
 */
public final class SortMap extends FakeMap
{
    public interface Function
    {
        Object sort(Object arg);
    }

    public final Function func;
    
    public SortMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.sort(key);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    public enum Functions implements Function
    {
        FBS_CREATE_FIELDS
        {
            @Override
            public Object sort(Object arg)
            {
                return JetGroup.Base.sort_fbs_create_fields((Message)arg);
            }
        }
        ;
        public final SortMap map;

        private Functions()
        {
            map = new SortMap("sort_" + name().toLowerCase(), this);
        }
    }
}
