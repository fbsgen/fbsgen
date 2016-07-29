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
import java.util.HashMap;
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
        REPEATED(0),
        OPTIONAL(1),
        REQUIRED(2);
        
        public final int number;
        
        private Modifier(int number)
        {
            this.number = number;
        }
        
        public int getNumber()
        {
            return number;
        }
        
        public java.lang.String getName()
        {
            return name();
        }
    }
    
    public enum PbType
    {
        MESSAGE(0, "Message"),
        BOOL(1, "Bool"),
        BYTES(2, "Bytes"),
        STRING(3, "String"),
        FLOAT(4, "Float"),
        DOUBLE(5, "Double"),
        UINT32(6, "UInt32"),
        UINT64(7, "UInt64"),
        INT32(8, "Int32"),
        INT64(9, "Int64"),
        FIXED32(10, "Fixed32"),
        FIXED64(11, "Fixed64"),
        SINT32(12, "SInt32"),
        SINT64(13, "SInt64"),
        SFIXED32(14, "SFixed32"),
        SFIXED64(15, "SFixed64"),
        ENUM(16, "Enum");
        
        public final int number;
        public final java.lang.String namePC;
        
        private PbType(int number, java.lang.String namePC)
        {
            this.number = number;
            this.namePC = namePC;
        }
        
        public int getNumber()
        {
            return number;
        }
        
        public java.lang.String getNamePC()
        {
            return namePC;
        }
        
        public java.lang.String getName()
        {
            return name();
        }
    }
    
    static final HashMap<java.lang.String,java.lang.String> INT_TYPES = 
            new HashMap<java.lang.String, java.lang.String>();
    
    static final HashMap<java.lang.String,Integer> FBS_NUM_SIZEOF_MAP = 
            new HashMap<java.lang.String, Integer>();
    
    static
    {
        putIntType(Int8.class, "byte", 1);
        putIntType(UInt8.class, "ubyte", 1);
        putIntType(Int16.class, "short", 2);
        putIntType(UInt16.class, "ushort", 2);
        putIntType(Int32.class, "int", 4);
        putIntType(UInt32.class, "uint",4);
        putIntType(Int64.class, "long", 8);
        putIntType(UInt64.class, "ulong", 8);
        
        FBS_NUM_SIZEOF_MAP.put("float", 4);
        FBS_NUM_SIZEOF_MAP.put("double", 8);
    }
    
    private static void putIntType(Class<?> c, java.lang.String fbsType, int sizeOf)
    {
        INT_TYPES.put(c.getSimpleName().toLowerCase(), fbsType);
        FBS_NUM_SIZEOF_MAP.put(fbsType, sizeOf);
    }
    
    public static java.lang.String fbsIntType(java.lang.String fieldType)
    {
        return INT_TYPES.get(fieldType);
    }
    
    public static int numSizeOf(java.lang.String fbsType)
    {
        Integer size = FBS_NUM_SIZEOF_MAP.get(fbsType);
        return size == null ? 0 : size.intValue();
    }
    
    
    protected java.lang.String name, defaultValueConstant;
    protected int number;
    protected Modifier modifier;
    protected PbType pbType;
    protected boolean packable;
    protected T defaultValue;
    protected Message owner;
    protected final LinkedHashMap<java.lang.String,Object> standardOptions = 
        new LinkedHashMap<java.lang.String,Object>();
    
    protected final LinkedHashMap<java.lang.String,Object> extraOptions = 
            new LinkedHashMap<java.lang.String,Object>();
    
    public Field()
    {
        
    }
    
    public Field(boolean packable)
    {
        this.packable = packable;
    }
    
    public PbType getPbType()
    {
        return pbType;
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
    public UserDefinedType getUserDefinedType()
    {
        return null;
    }
    
    /**
     * Alias to {@link #getUserDefinedType()}.
     */
    public UserDefinedType getUdt()
    {
        return getUserDefinedType();
    }
    
    public abstract java.lang.String getJavaType();
    
    public abstract java.lang.String getFbsType();
    
    protected abstract void resolvePbType();
    
    /**
     * Alias to {@link #getFbsType()}.
     */
    public java.lang.String getCppType()
    {
        return getFbsType();
    }
    
    public boolean isFpt()
    {
        return false;
    }
    
    public java.lang.String getDefaultValueAsString()
    {
        return getDefaultValue().toString();
    }
    
    public Message getOwner()
    {
        return owner;
    }
    
    public static abstract class Number<T> extends Field<T>
    {
        public final int bits;
        
        Number(int bits)
        {
            super(true);
            this.bits = bits;
        }
        
        public boolean isFloatingPointType()
        {
            return false;
        }
        
        /**
         * Alias to {@link #isFloatingPointType()}.
         */
        public final boolean isFpt()
        {
            return isFloatingPointType();
        }
        
        public final boolean isBit64()
        {
            return 64 == bits;
        }
        
        public final boolean isBit32()
        {
            return 32 == bits;
        }
        
        public final boolean isBit16()
        {
            return 16 == bits;
        }
        
        public final boolean isBit8()
        {
            return 8 == bits;
        }
        
        public int getBits()
        {
            return bits;
        }
    }
    
    public static class Int8 extends Number<Integer>
    {
        public Int8()
        {
            super(8);
            pbType = PbType.INT32;
        }
        
        public java.lang.String getJavaType()
        {
            return "byte";
        }
        
        public java.lang.String getFbsType()
        {
            return "byte";
        }

        @Override
        protected void resolvePbType()
        {
            
        }
    }
    
    public static class UInt8 extends Number<Integer>
    {
        public UInt8()
        {
            super(8);
            pbType = PbType.UINT32;
        }
        
        public java.lang.String getJavaType()
        {
            return "byte";
        }
        
        public java.lang.String getFbsType()
        {
            return "ubyte";
        }

        @Override
        protected void resolvePbType()
        {
            
        }
    }
    
    public static class Int16 extends Number<Integer>
    {
        public Int16()
        {
            super(16);
            pbType = PbType.INT32;
        }
        
        public java.lang.String getJavaType()
        {
            return "int";
        }
        
        public java.lang.String getFbsType()
        {
            return "short";
        }

        @Override
        protected void resolvePbType()
        {
            
        }
    }
    
    public static class UInt16 extends Number<Integer>
    {
        public UInt16()
        {
            super(16);
            pbType = PbType.UINT32;
        }
        
        public java.lang.String getJavaType()
        {
            return "int";
        }
        
        public java.lang.String getFbsType()
        {
            return "ushort";
        }
        
        @Override
        protected void resolvePbType()
        {
            
        }
    }
    
    public static class Int32 extends Number<Integer>
    {
        public Int32()
        {
            super(32);
        }
        
        public java.lang.String getJavaType()
        {
            return "int";
        }
        
        public java.lang.String getFbsType()
        {
            return "int";
        }
        
        @Override
        protected void resolvePbType()
        {
            if (Boolean.TRUE.equals(getO().get("varint")))
                pbType = Boolean.TRUE.equals(getO().get("signed")) ? PbType.SINT32 : PbType.INT32;
            else
                pbType = Boolean.TRUE.equals(getO().get("signed")) ? PbType.SFIXED32 : PbType.FIXED32;
        }
    }
    
    public static class UInt32 extends Number<Integer>
    {
        public UInt32()
        {
            super(32);
        }
        
        public java.lang.String getJavaType()
        {
            return "int";
        }
        
        public java.lang.String getFbsType()
        {
            return "uint";
        }
        
        @Override
        protected void resolvePbType()
        {
            pbType = Boolean.TRUE.equals(getO().get("varint")) ? 
                    PbType.UINT32 : PbType.FIXED32;
        }
    }
    
    public static class Int64 extends Number<Long>
    {
        public Int64()
        {
            super(64);
        }
        
        public java.lang.String getJavaType()
        {
            return "long";
        }
        
        public java.lang.String getFbsType()
        {
            return "long";
        }
        
        @Override
        protected void resolvePbType()
        {
            if (Boolean.TRUE.equals(getO().get("varint")))
                pbType = Boolean.TRUE.equals(getO().get("signed")) ? PbType.SINT64 : PbType.INT64;
            else
                pbType = Boolean.TRUE.equals(getO().get("signed")) ? PbType.SFIXED64 : PbType.FIXED64;
        }
    }
    
    public static class UInt64 extends Number<Long>
    {
        public UInt64()
        {
            super(64);
        }
        
        public java.lang.String getJavaType()
        {
            return "long";
        }
        
        public java.lang.String getFbsType()
        {
            return "ulong";
        }
        
        @Override
        protected void resolvePbType()
        {
            pbType = Boolean.TRUE.equals(getO().get("varint")) ? 
                    PbType.UINT64 : PbType.FIXED64;
        }
    }
    
    public static class Float extends Number<java.lang.Float>
    {
        public Float()
        {
            super(32);
            pbType = PbType.FLOAT;
        }
        
        public java.lang.String getJavaType()
        {
            return "float";
        }
        
        public java.lang.String getFbsType()
        {
            return "float";
        }

        public boolean isFloatingPointType()
        {
            return true;
        }
        
        @Override
        protected void resolvePbType()
        {
            
        }
    }
    
    public static class Double extends Number<java.lang.Double>
    {
        public Double()
        {
            super(64);
            pbType = PbType.DOUBLE;
        }
        
        public java.lang.String getJavaType()
        {
            return "double";
        }
        
        public java.lang.String getFbsType()
        {
            return "double";
        }
        
        public boolean isFloatingPointType()
        {
            return true;
        }
        
        @Override
        protected void resolvePbType()
        {
            
        }
    }
    
    public static class Bool extends Field<Boolean>
    {
        public Bool()
        {
            super(true);
            pbType = PbType.BOOL;
        }
        public java.lang.String getJavaType()
        {
            return "boolean";
        }
        
        public java.lang.String getFbsType()
        {
            return "bool";
        }
        @Override
        protected void resolvePbType()
        {
            
        }
    }
    
    public static class String extends Field<java.lang.String>
    {
        public String()
        {
            super(false);
            pbType = PbType.STRING;
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
        @Override
        protected void resolvePbType()
        {
            
        }
    }
    
    public static class Bytes extends Field<byte[]>
    {
        public Bytes()
        {
            super(false);
            pbType = PbType.BYTES;
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
        @Override
        protected void resolvePbType()
        {
            
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

        @Override
        protected void resolvePbType()
        {
            // no impl
        }
    }

}
