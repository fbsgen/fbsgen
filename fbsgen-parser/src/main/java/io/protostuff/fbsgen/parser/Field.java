//========================================================================
//Copyright 2007-2009 David Yu dyuproject@gmail.com
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

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;

/**
 * Base class for fields defined in a {@link Message}.
 *
 * @author David Yu
 * @created Dec 19, 2009
 */
public abstract class Field<T> extends AnnotationContainer implements Comparable<Field<?>>, HasName, HasOptions
{
    
    public enum Modifier
    {
        OPTIONAL,
        REQUIRED,
        REPEATED;
        
        public java.lang.String getName()
        {
            return name();
        }
    }
   
    
    java.lang.String name, defaultValueConstant;
    int number;
    Modifier modifier;
    boolean packable;
    T defaultValue;
    Message owner;
    final LinkedHashMap<java.lang.String,Object> standardOptions = 
        new LinkedHashMap<java.lang.String,Object>();
    
    final LinkedHashMap<java.lang.String,Object> extraOptions = 
            new LinkedHashMap<java.lang.String,Object>();
    
    public Field()
    {
        
    }
    
    public Field(boolean packable)
    {
        this.packable = packable;
    }
    
    public Proto getProto()
    {
        return owner == null ? null : owner.getProto();
    }
    
    public LinkedHashMap<java.lang.String,Object> getStandardOptions()
    {
        return standardOptions;
    }
    
    public LinkedHashMap<java.lang.String,Object> getExtraOptions()
    {
        return extraOptions;
    }
    
    public LinkedHashMap<java.lang.String,Object> getO() 
    {
        return getOptions();
    }
    
    /**
     * Returns this options
     */
    public LinkedHashMap<java.lang.String,Object> getOptions()
    {
        return extraOptions;
    }
    
    /**
     * Returns the option defined by the {@code key}.
     */
    @SuppressWarnings("unchecked")
    public <V> V getOption(java.lang.String key)
    {
        return (V)extraOptions.get(key);
    }
    
    public void putStandardOption(java.lang.String key, Object value)
    {
        putExtraOption(key, value);
        standardOptions.put(key, value);
    }
    
    public void putExtraOption(java.lang.String key, Object value)
    {
        if (extraOptions.put(key, value) != null)
            throw err(this, " has multiple definitions of the option: " + key, getProto());
    }
    
    /**
     * @return the name
     */
    public java.lang.String getName()
    {
        return name;
    }
    
    public java.lang.String getDefaultValueConstant()
    {
        return defaultValueConstant;
    }

    /**
     * @return the number
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * @return the modifier
     */
    public Modifier getModifier()
    {
        return modifier;
    }

    /**
     * @return the packable
     */
    public boolean isPackable()
    {
        return packable;
    }

    /**
     * @return the defaultValue
     */
    public T getDefaultValue()
    {
        return defaultValue;
    }
    
    public boolean isRepeated()
    {
        return modifier == Modifier.REPEATED;
    }
    
    public boolean isRequired()
    {
        return modifier == Modifier.REQUIRED;
    }
    
    public boolean isOptional()
    {
        return modifier == Modifier.OPTIONAL;
    }
    
    public boolean isDefaultValueSet()
    {
        return getDefaultValue() != null;
    }
    
    public boolean isNumberField()
    {
        return Number.class.isAssignableFrom(getClass());
    }
    
    public boolean isEnumField()
    {
        return EnumField.class.isAssignableFrom(getClass());
    }
    
    public boolean isMessageField()
    {
        return MessageField.class.isAssignableFrom(getClass());
    }
    
    public boolean isBytesField()
    {
        return Bytes.class.isAssignableFrom(getClass());
    }
    
    public boolean isStringField()
    {
        return String.class.isAssignableFrom(getClass());
    }
    
    public boolean isBoolField()
    {
        return Bool.class.isAssignableFrom(getClass());
    }
    
    public boolean isDelimited()
    {
        return false;
    }
    
    public int compareTo(Field<?> f)
    {
        if (f.number == number)
        {
            throw err(f, " cannot have the same number as " + name, 
                    owner == null ? null : owner.getProto());
        }
        
        return f.number < number ? 1 : -1;
    }
    
    /**
     * Returns null by default.
     */
    public HasName getUserDefinedType()
    {
        return null;
    }
    
    public abstract java.lang.String getJavaType();
    
    public abstract java.lang.String getFbsType();
    
    public java.lang.String getDefaultValueAsString()
    {
        return getDefaultValue().toString();
    }
    
    public Message getOwner()
    {
        return owner;
    }
    
    static abstract class Number<T> extends Field<T>
    {
        public Number()
        {
            super(true);
        }
    }
    
    public static class Int8 extends Number<Integer>
    {
        public java.lang.String getJavaType()
        {
            return "byte";
        }
        
        public java.lang.String getFbsType()
        {
            return "byte";
        }
    }
    
    public static class UInt8 extends Number<Integer>
    {
        public java.lang.String getJavaType()
        {
            return "byte";
        }
        
        public java.lang.String getFbsType()
        {
            return "ubyte";
        }
    }
    
    public static class Int16 extends Number<Integer>
    {
        public java.lang.String getJavaType()
        {
            return "int";
        }
        
        public java.lang.String getFbsType()
        {
            return "short";
        }
    }
    
    public static class UInt16 extends Number<Integer>
    {
        public java.lang.String getJavaType()
        {
            return "int";
        }
        
        public java.lang.String getFbsType()
        {
            return "ushort";
        }
    }
    
    public static class Int32 extends Number<Integer>
    {
        public java.lang.String getJavaType()
        {
            return "int";
        }
        
        public java.lang.String getFbsType()
        {
            return "int";
        }
    }
    
    public static class UInt32 extends Number<Integer>
    {
        public java.lang.String getJavaType()
        {
            return "int";
        }
        
        public java.lang.String getFbsType()
        {
            return "uint";
        }
    }
    
    public static class Int64 extends Number<Long>
    {
        public java.lang.String getJavaType()
        {
            return "long";
        }
        
        public java.lang.String getFbsType()
        {
            return "long";
        }
    }
    
    public static class UInt64 extends Number<Long>
    {
        public java.lang.String getJavaType()
        {
            return "long";
        }
        
        public java.lang.String getFbsType()
        {
            return "ulong";
        }
    }
    
    public static class Float extends Number<java.lang.Float>
    {
        public java.lang.String getJavaType()
        {
            return "float";
        }
        
        public java.lang.String getFbsType()
        {
            return "float";
        }
    }
    
    public static class Double extends Number<java.lang.Double>
    {
        public java.lang.String getJavaType()
        {
            return "double";
        }
        
        public java.lang.String getFbsType()
        {
            return "double";
        }
    }
    
    public static class Bool extends Field<Boolean>
    {
        public Bool()
        {
            super(true);
        }
        public java.lang.String getJavaType()
        {
            return "boolean";
        }
        
        public java.lang.String getFbsType()
        {
            return "bool";
        }
    }
    
    public static class String extends Field<java.lang.String>
    {
        public String()
        {
            super(false);
        }
        public java.lang.String getJavaType()
        {
            return "String";
        }
        public java.lang.String getFbsType()
        {
            return "string";
        }
        public java.lang.String getDefaultValueAsString()
        {
            return TextFormat.escapeText(getDefaultValue());
        }
        public boolean isDelimited()
        {
            return true;
        }
    }
    
    public static class Bytes extends Field<byte[]>
    {
        public Bytes()
        {
            super(false);
        }
        public java.lang.String getJavaType()
        {
            return "ByteString";
        }
        public java.lang.String getFbsType()
        {
            return "string";
        }
        public java.lang.String getDefaultValueAsString()
        {
            return TextFormat.escapeBytes(ByteBuffer.wrap(getDefaultValue())).toString();
        }
        public boolean isDelimited()
        {
            return true;
        }
    }
    
    public static class Reference extends Field<Object>
    {
        java.lang.String refName, packageName;
        HasFields hasFields;
        
        public Reference(java.lang.String packageName, java.lang.String refName, 
                HasFields hasFields)
        {
            this.packageName = packageName;
            this.refName = refName;
            this.hasFields = hasFields;
        }
        
        public java.lang.String getRefName()
        {
            return refName;
        }
        
        public java.lang.String getPackageName()
        {
            return packageName;
        }
        
        public java.lang.String getJavaType()
        {
            return refName;
        }
        
        public java.lang.String getFbsType()
        {
            return getJavaType().replace('.', '_');
        }
    }

}
