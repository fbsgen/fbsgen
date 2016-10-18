//========================================================================
//Copyright 2015 David Yu
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

package com.dyuproject.fbsgen.compiler;

import com.dyuproject.fbsgen.parser.EnumField;
import com.dyuproject.fbsgen.parser.EnumGroup;
import com.dyuproject.fbsgen.parser.Field;
import com.dyuproject.fbsgen.parser.MessageField;

import java.util.Comparator;

/**
 * TODO
 * 
 * @author David Yu
 * @created Dec 9, 2015
 */
public final class TypeUtil
{
    private TypeUtil() {}
    
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
}
