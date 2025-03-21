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

package com.dyuproject.fbsgen.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Represents an enum declared in either the {@link Proto} or nested in a {@link Message}.
 *
 * @author David Yu
 * @created Dec 21, 2009
 */
public final class EnumGroup extends AnnotationContainer implements UserDefinedType, HasOptions
{
    
    /**
     * Disabled by default (the earlier protoc 2.x versions enabled this by default, but 
     * was changed later on).
     */
    public static final boolean ENUM_ALLOW_ALIAS = Boolean.getBoolean(
            "fbsgen.enum_allow_alias");
    
    public static final boolean ENUM_EXPLICIT_ZERO = Boolean.getBoolean(
            "fbsgen.enum_explicit_zero");
    
    public static final boolean ENUM_SEQUENTIAL = Boolean.getBoolean(
            "fbsgen.enum_sequential");
    
    public static final boolean ENUM_ALLOW_NEGATIVE = Boolean.parseBoolean(
            System.getProperty("fbsgen.enum_allow_negative", "true"));
    
    static final String ZERO_NAME = "ZERO";
    
    private static boolean isSequentialExempted(boolean config, String name)
    {
        return config ? !"Q".equals(name) : "Tags".equals(name);
    }
    
    final String name;
    final Message parentMessage;
    final Proto proto;
    
    final LinkedHashMap<String,Value> values = new LinkedHashMap<String,Value>();
    final ArrayList<Value> sortedValues = new ArrayList<Value>();
    final LinkedHashMap<String,Object> standardOptions = new LinkedHashMap<String,Object>();
    final LinkedHashMap<String,Object> extraOptions = new LinkedHashMap<String,Object>();
    
    private ArrayList<Value> indexedValues;
    private ArrayList<Value> uniqueSortedValues;
    private List<Value> uniqueSortedDeclaredValues;
    
    private List<Value> declaredValues;
    private LinkedHashMap<String,Value> declaredValueMap;
    
    private Value zero;
    private int firstValueIndex;
    
    // cache
    private String relativeName, cppRelativeName;
    
    public EnumGroup(String name, Message parentMessage, Proto proto)
    {
        this.name = name;
        this.parentMessage = parentMessage;
        
        if (parentMessage != null)
        {
            this.proto = parentMessage.getProto();
            parentMessage.addNestedEnumGroup(this);
        }
        else
        {
            this.proto = proto;
            proto.addEnumGroup(this);
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    private String fullName(String packageName)
    {
        return fullName(packageName, '.');
    }
    
    private String fullName(String packageName, char separator)
    {
        StringBuilder buffer = new StringBuilder();
        if (isNested())
        {
            Message.resolveFullName(parentMessage, buffer, packageName, separator);
            buffer.append(separator);
        }
        else if (separator == '_')
            buffer.append(packageName).append("::");
        else
            buffer.append(packageName).append(separator);
        
        return buffer.append(name).toString();
    }
    
    public String getFullName()
    {
        return fullName(getProto().getPackageName());
    }
    
    public String getDeclaredFullName()
    {
        return fullName(getProto().getDeclaredPackageName());
    }
    
    public String getJavaFullName()
    {
        return fullName(getProto().getJavaPackageName());
    }
    
    public String getDeclaredJavaFullName()
    {
        return fullName(getProto().getDeclaredJavaPackageName());
    }
    
    public String getRelativeName()
    {
        if (relativeName != null)
            return relativeName;
        
        relativeName = isNested() ? parentMessage.getRelativeName() + "." + name : name;
        
        return relativeName;
    }
    
    public String getCppRelativeName()
    {
        if (cppRelativeName != null)
            return cppRelativeName;
        
        cppRelativeName = isNested() ? parentMessage.getRelativeName() + "_" + name : name;
        
        return cppRelativeName;
    }
    
    public String getCppFullName()
    {
        return fullName(getProto().getPackageName().replaceAll("\\.", "::"), '_');
    }
    
    public int getSizeof()
    {
        return Field.numSizeOf(Field.fbsIntType(typeAnnotation.getName()));
    }
    
    /* ================================================== */
    
    public Message getParentMessage()
    {
        return parentMessage;
    }
    
    public boolean isNested()
    {
        return parentMessage != null;
    }
    
    public Proto getProto()
    {
        return proto;
    }
    
    /* ================================================== */
    
    public void putStandardOption(String key, Object value)
    {
        putExtraOption(key, value);
        standardOptions.put(key, value);
    }
    
    public void putExtraOption(String key, Object value)
    {
        if (extraOptions.put(key, value) != null)
            throw err(this, " has multiple definitions of the option: " + key, getProto());
    }
    
    public LinkedHashMap<String,Object> getStandardOptions()
    {
        return standardOptions;
    }
    
    public Object getStandardOption(String key)
    {
        return standardOptions.get(key);
    }
    
    public LinkedHashMap<String,Object> getExtraOptions()
    {
        return extraOptions;
    }
    
    public LinkedHashMap<java.lang.String,Object> getO()
    {
        return getOptions();
    }
    
    public LinkedHashMap<String,Object> getOptions()
    {
        return extraOptions;
    }
    
    @SuppressWarnings("unchecked")
    public <V> V getExtraOption(java.lang.String key)
    {
        return (V)extraOptions.get(key);
    }
    
    public Value getValue(int index)
    {
        if (indexedValues == null)
            indexedValues = new ArrayList<Value>(values.values());
        
        return indexedValues.get(index);
    }
    
    public Value getValue(String name)
    {
        return values.get(name);
    }
    
    public LinkedHashMap<String,Value> getValueMap()
    {
        return values;
    }
    
    /**
     * Alias to {@link #getValueMap()}.
     */
    public LinkedHashMap<String,Value> getV()
    {
        return getValueMap();
    }
    
    public ArrayList<Value> getValues()
    {
        return sortedValues;
    }
    
    public List<Value> getSortedDeclaredValues()
    {
        if (firstValueIndex == 0)
            return sortedValues;
        
        return sortedValues.subList(1, sortedValues.size());
    }
    
    public Collection<Value> getDeclaredValues()
    {
        if (firstValueIndex == 0)
            return values.values();
        
        if (declaredValues == null)
        {
            ArrayList<Value> list = new ArrayList<Value>();
            Iterator<Value> iter = values.values().iterator();
            iter.next(); // skip the first element
            while (iter.hasNext())
                list.add(iter.next());
            
            declaredValues = list;
        }
        
        return declaredValues;
    }
    
    public LinkedHashMap<String,Value> getDeclaredValueMap()
    {
        if (firstValueIndex == 0)
            return values;
        
        if (declaredValueMap == null)
        {
            declaredValueMap = new LinkedHashMap<String, EnumGroup.Value>(values);
            declaredValueMap.remove(ZERO_NAME);
        }
        
        return declaredValueMap;
    }
    
    public boolean isDeclaredFirstValueZero()
    {
        return firstValueIndex == 0 && sortedValues.get(0).number == 0;
    }
    
    public Value getFirstValue()
    {
        if (indexedValues == null)
            indexedValues = new ArrayList<Value>(values.values());
        
        return indexedValues.get(firstValueIndex);
    }
    
    public Value getLastValue()
    {
        if (indexedValues == null)
            indexedValues = new ArrayList<Value>(values.values());
        
        return indexedValues.get(indexedValues.size() - 1);
    }
    
    public int getValueCount()
    {
        return values.size();
    }
    
    public boolean isBitFlags()
    {
        return typeAnnotation != null && Boolean.TRUE.equals(
                typeAnnotation.getValue("bit_flags"));
    }
    
    public boolean isSequential()
    {
        final int size = sortedValues.size(),
                diff = isDeclaredFirstValueZero() ? -1 : 0;
        
        return (size + diff) == sortedValues.get(size - 1).number;
    }
    
    void add(Value value)
    {
        if (!ENUM_ALLOW_NEGATIVE && value.number < 0)
            throw err(value, " cannot be negative.", getProto());
        
        if (zero == null)
        {
            if (value.number == 0)
            {
                zero = value;
            }
            else if (!ENUM_EXPLICIT_ZERO && values.isEmpty() && !isBitFlags() && 
                    !getA().containsKey("Config"))
            {
                zero = new Value(ZERO_NAME, 0, this);
                values.put(zero.name, zero);
                firstValueIndex = 1;
            }
        }
        
        if (values.put(value.name, value) != null)
            throw err(value, " cannot be defined more than once.", getProto());
        
        sortedValues.add(value);
    }
    
    void cacheFullyQualifiedName()
    {
        if (Message.SEQUENTIAL_FIELD_NUMBERS && 
                (typeAnnotation == null || Field.fbsIntType(typeAnnotation.name) == null))
        {
            throw err(this, 
                    " requires a valid (int) type annotation  ... something like @uint8", 
                    getProto());
        }
        
        // no alias allowed if field numbers should have no holes.
        final Boolean allowAlias = Message.SEQUENTIAL_FIELD_NUMBERS ? 
                Boolean.FALSE : (Boolean)getOptions().get("allow_alias");
        
        final boolean aliasAllowed = allowAlias != null ? 
                allowAlias.booleanValue() : ENUM_ALLOW_ALIAS;
        
        if (aliasAllowed)
            Collections.sort(sortedValues);
        else
            Collections.sort(sortedValues, Value.NO_ALIAS_COMPARATOR);
        
        if (isBitFlags())
        {
            for(Value v : sortedValues)
            {
                if (v.number <= 0 || 0 != (v.number & v.number-1))
                    throw err(v, " is not a valid bit flag (not a power-of-two): " + v.number, getProto());
            }
            
            String typeName = typeAnnotation.name;
            Value vLast = sortedValues.get(sortedValues.size() - 1);
            int lastNumber = vLast.number;
            switch (typeName.charAt(typeName.length() - 1))
            {
                case '8':
                    if (typeName.charAt(0) == 'U')
                    {
                        if (lastNumber > 0xFF)
                            throw err(vLast, " is out of range with its underlying integral type: " + typeName, getProto());
                    }
                    else if (lastNumber < -128 || lastNumber > 127)
                        throw err(vLast, " is out of range with its underlying integral type: " + typeName, getProto());
                    break;
                case '6':
                    if (typeName.charAt(0) == 'U')
                    {
                        if (lastNumber > 0xFFFF)
                            throw err(vLast, " is out of range with its underlying integral type: " + typeName, getProto());
                    }
                    else if (lastNumber < -32768 || lastNumber > 32767)
                        throw err(vLast, " is out of range with its underlying integral type:" + typeName, getProto());
                    break;
                
                // TODO only validate int8 and int16?
                //case '2':
                //case '4':
            }
        }
        else
        {
            boolean isConfig = getA().containsKey("Config");
            if (zero == null && !isConfig)
            {
                throw err(//this, 
                        "enum " + getRelativeName() + " does not have a declaration for this field's default of 0", 
                        getProto());
            }
            
            if (ENUM_SEQUENTIAL && !isSequentialExempted(isConfig, name) && !isSequential())
            {
                throw err(//this, 
                        "enum " + getRelativeName() + " does not have sequential values", 
                        getProto());
            }
        }
        
        final Proto proto = getProto();
        final String fullName = getFullName();
        
        proto.fullyQualifiedEnumGroups.put(fullName, this);
        
        if (!standardOptions.isEmpty())
            proto.references.add(new ConfiguredReference(standardOptions, extraOptions, fullName));
        
        for (Value v : values.values())
        {
            if (!v.field.standardOptions.isEmpty())
            {
                proto.references.add(new ConfiguredReference(
                        v.field.standardOptions, v.field.extraOptions, fullName));
            }
        }
    }
    
    public ArrayList<Value> getUniqueSortedValues()
    {
        if (uniqueSortedValues != null)
            return uniqueSortedValues;
        
        if (!ENUM_ALLOW_ALIAS)
        {
            uniqueSortedValues = sortedValues;
            return uniqueSortedValues;
        }
        
        uniqueSortedValues = new ArrayList<Value>();
        Value last = null;
        for (Value v : sortedValues)
        {
            if (last == null || v.number!=last.number)
                uniqueSortedValues.add(v);
            last = v;
        }
        return uniqueSortedValues;
    }
    
    public List<Value> getUniqueSortedDeclaredValues()
    {
        if (uniqueSortedDeclaredValues != null)
            return uniqueSortedDeclaredValues;
        
        if (!ENUM_ALLOW_ALIAS)
        {
            uniqueSortedDeclaredValues = firstValueIndex == 0 ? sortedValues : 
                    sortedValues.subList(1, sortedValues.size());
            
            return uniqueSortedDeclaredValues;
        }
        
        uniqueSortedDeclaredValues = new ArrayList<Value>();
        Value last = null;
        for (Value v : sortedValues)
        {
            if (firstValueIndex != 0 && v.number == 0)
                continue;
            
            if (last == null || v.number!=last.number)
                uniqueSortedDeclaredValues.add(v);
            last = v;
        }
        return uniqueSortedDeclaredValues;
    }
    
    @Override
    public String toString()
    {
        return  ConfiguredReference.UDT_TO_STRING_AS_FQCN ? getFullName() : getName();
    }
    
    public static class Value extends AnnotationContainer implements Comparable<Value>, HasName
    {
        public static final Comparator<Value> NO_ALIAS_COMPARATOR = 
                new Comparator<Value>()
        {
            public int compare(Value v1, Value v2)
            {
                if (v1.number == v2.number)
                {
                    throw err(v2, " cannot have the same number as " + v1.getName(), 
                            v2.enumGroup.getProto());
                }
                
                return v1.number - v2.number;
            }
        };
        
        final String name;
        final int number;
        final EnumGroup enumGroup;
        
        public final EnumField field = new EnumField(this);

        public Value(String name, int number, EnumGroup enumGroup)
        {
            this.name = name;
            this.number = number;
            this.enumGroup = enumGroup;
            
            field.enumGroup = enumGroup;
            field.name = name;
            
            enumGroup.add(this);
        }

        /**
         * @return the name
         */
        public String getName()
        {
            return name;
        }

        /**
         * @return the number
         */
        public int getNumber()
        {
            return number;
        }
        
        public Proto getProto()
        {
            return enumGroup.getProto();
        }
        
        /**
         * @return the enumGroup
         */
        public EnumGroup getEnumGroup()
        {
            return enumGroup;
        }
        
        /**
         * Alias to {@link #getEnumGroup()}.
         */
        public EnumGroup getEg()
        {
            return enumGroup;
        }
        
        // options
        
        public LinkedHashMap<java.lang.String,Object> getStandardOptions()
        {
            return field.getStandardOptions();
        }
        
        public LinkedHashMap<java.lang.String,Object> getExtraOptions()
        {
            return field.getExtraOptions();
        }
        
        public LinkedHashMap<java.lang.String,Object> getO()
        {
            return getOptions();
        }
        
        /**
         * Returns the options configured.
         */
        public LinkedHashMap<java.lang.String,Object> getOptions()
        {
            return field.getOptions();
        }
        
        public int compareTo(Value o)
        {
            // if equal, sort by order of declaration
            //return o.number < number ? 1 : -1;
            return number - o.number;
        }
    }

}
