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

package io.protostuff.fbsgen.compiler;

import io.protostuff.fbsgen.parser.HasName;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * The subclass must override {@link Map#get(Object)}.
 * 
 * @author David Yu
 * @created Aug 10, 2013
 */
public abstract class FakeMap implements Map<Object,Object>, HasName
{
    
    public final String name;
    
    public FakeMap(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public boolean containsKey(Object arg0)
    {
        return true;
    }
    
    public boolean isEmpty()
    {
        return false;
    }
    
    public int size()
    {
        return 1;
    }

    public boolean containsValue(Object arg0)
    {
        throw new UnsupportedOperationException();
    }

    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    public Set<java.util.Map.Entry<Object, Object>> entrySet()
    {
        throw new UnsupportedOperationException();
    }

    public Set<Object> keySet()
    {
        throw new UnsupportedOperationException();
    }

    public Object put(Object arg0, Object arg1)
    {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends Object, ? extends Object> arg0)
    {
        throw new UnsupportedOperationException();
    }

    public Object remove(Object arg0)
    {
        throw new UnsupportedOperationException();
    }

    public Collection<Object> values()
    {
        throw new UnsupportedOperationException();
    }
    
    public String $(Object obj)
    {
        get(obj);
        return "";
    }
}
