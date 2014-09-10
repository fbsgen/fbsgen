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

package io.protostuff.fbsgen.parser;

import io.protostuff.fbsgen.parser.Field;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


/**
 * Utils for protostuff-ds-codegen to have access to some fields.
 * 
 * @author David Yu
 * @created Sep 1, 2012
 */
public final class CodegenUtil
{
    private CodegenUtil() {}
    
    public static class Bytes extends Field.Bytes
    {
        
    }

    static byte[] ser(String nonNullValue)
    {
        try
        {
            return nonNullValue.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public static void replaceFieldStringWithBytes(Message message, 
            boolean includeNestedMessages, boolean removeFieldAnnotations)
    {
        if (includeNestedMessages)
        {
            for (Message m : message.getNestedMessages())
            {
                replaceFieldStringWithBytes(m, includeNestedMessages, 
                        removeFieldAnnotations);
            }
        }
        
        for (int i = 0, len = message.sortedFields.size(); i < len; i++)
        {
            Field<?> f = message.sortedFields.get(i);
            if (f.isStringField())
            {
                Bytes fb = new Bytes();
                
                // copy
                Message.copy(f, fb);
                if (f.isDefaultValueSet())
                {
                    fb.defaultValue = ser((String)f.getDefaultValue());
                }
                
                
                // replace
                message.sortedFields.set(i, fb);
                message.fields.put(f.name, fb);
                
                // update info
                if (f.isRepeated())
                {
                    message.repeatedBytesFieldCount++;
                    message.repeatedStringFieldCount--;
                }
                else
                {
                    message.singularBytesFieldCount++;
                    message.singularStringFieldCount--;
                }
                
                if (removeFieldAnnotations)
                    fb.annotations.clear();
            }
        }
    }
    
    public static ArrayList<Field<?>> getSortedFields(Message message)
    {
        return message.sortedFields;
    }
    
    public static boolean isOneByte(Field<?> f)
    {
        if (f.isEnumField())
            return ((EnumField)f).getEnumGroup().getAnnotation("OneByte") != null;
        
        return f instanceof Field.UInt32 && 
                Boolean.TRUE.equals(f.getOptions().get("onebyte"));
    }
    
    /* ================================================== */

    public static Field<?> setName(Field<?> field, String name)
    {
        field.name = name;
        return field;
    }
    
    public static Field.Bytes newForeignKeyField(String name, Message owner)
    {
        //if (!name.endsWith("_key0"))
        //    throw new RuntimeException(name + " must end with key0");
        
        Field.Bytes f = new Field.Bytes();
        f.owner = owner;
        
        f.modifier = Field.Modifier.OPTIONAL;
        f.name = name;
        f.number = 0;
        
        f.getOptions().put("~foreign", Boolean.TRUE);
        f.getOptions().put("~foreign_key", Boolean.TRUE);
        
        return f;
    }
    
    public static Field.UInt64 newForeignDateField(String name, Message owner)
    {
        //if ('0' != name.charAt(name.length()-1))
        //    throw new RuntimeException(name + " must end with 0");
        
        Field.UInt64 f = new Field.UInt64();
        f.owner = owner;
        
        f.modifier = Field.Modifier.OPTIONAL;
        f.name = name;
        f.number = 0;
        
        f.getOptions().put("date", Boolean.TRUE);
        f.getOptions().put("~foreign", Boolean.TRUE);
        
        return f;
    }
    
    public static Field.UInt64 newForeignDatetimeField(String name, Message owner)
    {
        //if ('0' != name.charAt(name.length()-1))
        //    throw new RuntimeException(name + " must end with 0");
        
        Field.UInt64 f = new Field.UInt64();
        f.owner = owner;
        
        f.modifier = Field.Modifier.OPTIONAL;
        f.name = name;
        f.number = 0;
        
        f.getOptions().put("datetime", Boolean.TRUE);
        f.getOptions().put("~foreign", Boolean.TRUE);
        
        return f;
    }
}
