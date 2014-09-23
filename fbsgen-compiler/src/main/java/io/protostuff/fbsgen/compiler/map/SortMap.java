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
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.EnumField;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.MessageField;

import java.util.ArrayList;
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
    
    static int cmpRep(Field<?> f1, Field<?> f2)
    {
        if (f2.isRepeated())
            return f2.getNumber() - f1.getNumber();
        
        if (f2.isNumberField())
            return ((Field.Number<?>)f2).bits >= 32 ? 1 : -1;
        
        if (f2.isEnumField())
        {
            EnumField ef = (EnumField)f2;
            EnumGroup eg = ef.getEg();
            String type = eg.getTa().getName();
            return type.charAt(type.length() - 1) == '4' ? 1 : -1;
        }
        
        if (f2.isDelimited() || f2.isMessageField())
            return 1;
        
        return -1;
    }
    
    static int cmp64(Field.Number<?> f1, Field<?> f2)
    {
        if (f2 instanceof Field.Number<?> && ((Field.Number<?>)f2).isBit64())
            return f2.getNumber() - f1.getNumber();
        
        if (f2.isEnumField())
        {
            EnumField ef = (EnumField)f2;
            EnumGroup eg = ef.getEg();
            String type = eg.getTa().getName();
            return type.charAt(type.length() - 1) == '4' ? 
                    (f2.getNumber() - f1.getNumber()) : -1;
        }
        
        return -1;
    }
    
    static int cmpMessage(MessageField f1, Field<?> f2)
    {
        if (f2.isDelimited() || f2 instanceof MessageField)
            return f2.getNumber() - f1.getNumber();
        
        if (f2.isEnumField())
        {
            EnumField ef = (EnumField)f2;
            EnumGroup eg = ef.getEg();
            String type = eg.getTa().getName();
            return type.charAt(type.length() - 1) == '4' ? 1 : -1;
        }
        
        return -1;
    }
    
    static int cmp32(Field.Number<?> f1, Field<?> f2)
    {
        if (f2 instanceof Field.Number<?> && ((Field.Number<?>)f2).isBit32())
            return f2.getNumber() - f1.getNumber();
        
        if (f2.isEnumField())
        {
            EnumField ef = (EnumField)f2;
            EnumGroup eg = ef.getEg();
            String type = eg.getTa().getName();
            return type.charAt(type.length() - 1) == '2' ? 
                    (f2.getNumber() - f1.getNumber()) : -1;
        }
        
        return -1;
    }
    
    static int cmp16(Field.Number<?> f1, Field<?> f2)
    {
        if (f2 instanceof Field.Number<?> && ((Field.Number<?>)f2).isBit16())
            return f2.getNumber() - f1.getNumber();
        
        if (f2.isEnumField())
        {
            EnumField ef = (EnumField)f2;
            EnumGroup eg = ef.getEg();
            String type = eg.getTa().getName();
            return type.charAt(type.length() - 1) == '6' ? 
                    (f2.getNumber() - f1.getNumber()) : -1;
        }
        
        return -1;
    }
    
    static final Comparator<Field<?>> CMP_CREATE_FIELDS = new Comparator<Field<?>>()
    {
        @Override
        public int compare(Field<?> f1, Field<?> f2)
        {
            if (f1.isRepeated())
                return cmpRep(f1, f2);
            
            if (f2.isRepeated())
                return -cmpRep(f2, f1);
            
            if (f1 instanceof Field.Number<?> && ((Field.Number<?>)f1).isBit64())
                return cmp64((Field.Number<?>)f1, f2);
            
            if (f2 instanceof Field.Number<?> && ((Field.Number<?>)f2).isBit64())
                return 1;
            
            if (f1 instanceof MessageField)
                return cmpMessage((MessageField)f1, f2);
            
            if (f2 instanceof MessageField)
                return -cmpMessage((MessageField)f2, f1);
            
            if (f1.isDelimited())
                return f2.isDelimited() ? (f2.getNumber() - f1.getNumber()) : -1;
            
            if (f2.isDelimited())
                return 1;
            
            if (f1 instanceof Field.Number<?> && ((Field.Number<?>)f1).isBit32())
                return cmp32((Field.Number<?>)f1, f2);
            
            if (f2 instanceof Field.Number<?> && ((Field.Number<?>)f2).isBit32())
                return -cmp32((Field.Number<?>)f2, f1);
            
            if (f1 instanceof Field.Number<?> && ((Field.Number<?>)f1).isBit16())
                return cmp16((Field.Number<?>)f1, f2);
            
            if (f2 instanceof Field.Number<?> && ((Field.Number<?>)f2).isBit16())
                return -cmp16((Field.Number<?>)f2, f1);
            
            return f2.getNumber() - f1.getNumber();
        }
    };
    
    public enum Functions implements Function
    {
        FBS_CREATE_FIELDS
        {
            @Override
            public Object sort(Object arg)
            {
                Message message = (Message)arg;
                final ArrayList<Field<?>> list = new ArrayList<Field<?>>(message.getFields());
                
                Annotation ta = message.getTa();
                if (ta != null && Boolean.TRUE.equals(ta.getP().get("original_order")))
                    Collections.reverse(list);
                else
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
