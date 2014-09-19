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
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.MessageField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
    
    static int sizeOf(int fieldNumber)
    {
        return fieldNumber > 15 ? 2 : 1;
    }
    
    static int cmpDouble(Field<?> f1, Field<?> f2)
    {
        if (f2 instanceof Field.Double)
            return f2.isRepeated() ? -1 : (f1.getNumber() - f2.getNumber());
        
        return -1;
    }
    
    static int rcmpDouble(Field<?> f1, Field<?> f2)
    {
        if (f2 instanceof Field.Double)
            return f2.isRepeated() ? (f1.getNumber() - f2.getNumber()) : 1;
        
        if (f2 instanceof Field.UInt64 || f2 instanceof Field.Int64)
            return f2.isRepeated() ? -1 : 1;
        
        return -1;
    }
    
    static int cmpUInt64(Field<?> f1, Field<?> f2)
    {
        if (f2 instanceof Field.Double)
            return f2.isRepeated() ? -1 : 1;
        
        if (f2 instanceof Field.UInt64)
            return f2.isRepeated() ? -1 : (f1.getNumber() - f2.getNumber());
        
        return -1;
    }
    
    static int rcmpUInt64(Field<?> f1, Field<?> f2)
    {
        if (f2 instanceof Field.Double)
            return 1;
        
        if (f2 instanceof Field.UInt64)
            return f2.isRepeated() ? (f1.getNumber() - f2.getNumber()) : 1;
        
        if (f2 instanceof Field.Int64)
            return f2.isRepeated() ? -1 : 1;
        
        return -1;
    }
    
    static int cmpInt64(Field<?> f1, Field<?> f2)
    {
        if (f2 instanceof Field.Double || f2 instanceof Field.UInt64)
            return f2.isRepeated() ? -1 : 1;
        
        if (f2 instanceof Field.Int64)
            return f2.isRepeated() ? -1 : (f1.getNumber() - f2.getNumber());
        
        return -1;
    }
    
    static int rcmpInt64(Field<?> f1, Field<?> f2)
    {
        if (f2 instanceof Field.Double || f2 instanceof Field.UInt64)
            return 1;
        
        if (f2 instanceof Field.Int64)
            return f2.isRepeated() ? (f1.getNumber() - f2.getNumber()) : 1;
        
        return -1;
    }
    
    static int cmpMessage(MessageField f1, Field<?> f2)
    {
        if (f2 instanceof Field.Double || f2 instanceof Field.UInt64 || f2 instanceof Field.UInt64)
            return 1;
        
        if (!(f2 instanceof MessageField) || f2.isRepeated())
            return -1;
        
        MessageField mf = (MessageField)f2;
        int c1 = f1.getMessage().getFieldCount(), c2 = mf.getMessage().getFieldCount();
        if (c1 == c2)
            return f1.getNumber() - f2.getNumber();
        
        // if c2 has more fields, it is placed before c1
        return c2 - c1;
    }
    
    static int rcmpMessage(MessageField f1, Field<?> f2)
    {
        if (f2 instanceof Field.Double || f2 instanceof Field.UInt64 || f2 instanceof Field.UInt64)
            return 1;
        
        if (!(f2 instanceof MessageField))
            return -1;
        
        if (!f2.isRepeated())
            return 1;
        
        MessageField mf = (MessageField)f2;
        int c1 = f1.getMessage().getFieldCount(), c2 = mf.getMessage().getFieldCount();
        if (c1 == c2)
            return f1.getNumber() - f2.getNumber();
        
        // if c2 has more fields, it is placed before c1
        return c2 - c1;
    }
    
    static final Comparator<Field<?>> CMP_CREATE_FIELDS = new Comparator<Field<?>>()
    {
        @Override
        public int compare(Field<?> f1, Field<?> f2)
        {
            if (f1 instanceof Field.Double)
                return f1.isRepeated() ? rcmpDouble(f1, f2) : cmpDouble(f1, f2);
            else if (f2 instanceof Field.Double)
                return f2.isRepeated() ? -rcmpDouble(f2, f1) : 1;
            else if (f1 instanceof Field.UInt64)
                return f1.isRepeated() ? rcmpUInt64(f1, f2) : cmpUInt64(f1, f2);
            else if (f2 instanceof Field.UInt64)
                return f2.isRepeated() ? -rcmpUInt64(f2, f1) : 1;
            else if (f1 instanceof Field.Int64)
                return f1.isRepeated() ? rcmpInt64(f1, f2) : cmpInt64(f1, f2);
            else if (f2 instanceof Field.Int64)
                return f2.isRepeated() ? -rcmpInt64(f2, f1) : 1;
            else if (f1 instanceof MessageField)
                return f1.isRepeated() ? rcmpMessage((MessageField)f1, f2) : cmpMessage((MessageField)f1, f2);
            else if (f2 instanceof MessageField)
                return f2.isRepeated() ? -rcmpMessage((MessageField)f2, f1) : 1;
            // TODO
            return 0;
        }
    };
    
    public enum Functions implements Function
    {
        FBS_CREATE_FIELDS
        {
            @Override
            public Object sort(Object arg)
            {
                @SuppressWarnings("unchecked")
                final ArrayList<Field<?>> list = new ArrayList<Field<?>>(
                        (Collection<Field<?>>)arg);
                
                Collections.sort(list, CMP_CREATE_FIELDS);
                
                return list;
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
