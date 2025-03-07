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
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Represents the message defined in the {@link Proto}.
 *
 * @author David Yu
 * @created Dec 19, 2009
 */
public final class Message extends AnnotationContainer implements UserDefinedType, HasFields
{
    
    static final boolean SEQUENTIAL_FIELD_NUMBERS = Boolean.getBoolean(
            "fbsgen.sequential_field_numbers");
    
    final String name;
    final Message parentMessage;
    final Proto proto;
    
    final LinkedHashMap<String, Message> nestedMessages = new LinkedHashMap<String, Message>();
    final LinkedHashMap<String,EnumGroup> nestedEnumGroups = new LinkedHashMap<String,EnumGroup>();
    final LinkedHashMap<String,Service> nestedServices = new LinkedHashMap<String,Service>();
    
    final LinkedHashMap<String,Field<?>> fields = new LinkedHashMap<String,Field<?>>();
    //final ArrayList<Extension> nestedExtensions = new ArrayList<Extension>();
    final ArrayList<Field<?>> sortedFields = new ArrayList<Field<?>>();
    
    private ArrayList<Field<?>> nonDeprecatedFields;
    
    //final ArrayList<int[]> extensionRanges = new ArrayList<int[]>();
    //final LinkedHashMap<Integer, Field<?>> extensions = new LinkedHashMap<Integer,Field<?>>();
    final LinkedHashMap<String,Object> standardOptions = new LinkedHashMap<String,Object>();
    final LinkedHashMap<String,Object> extraOptions = new LinkedHashMap<String,Object>();
    boolean extensible;
    
    // struct specific
    int minAlign = 1;
    int forceAlign;
    final ArrayList<Integer> sizeofValues = new ArrayList<Integer>();
    
    // cache
    private String relativeName, cppRelativeName;
    
    // =====================================
    // code generator helpers
    
    // for root message only
    boolean bytesFieldPresent, repeatedFieldPresent, requiredFieldPresent;
    boolean bytesOrStringDefaultValuePresent;
    
    // for every message
    boolean annotationPresentOnFields;
    int requiredFieldCount, repeatedFieldCount, singularFieldCount;
    int requiredMessageFieldCount, repeatedMessageFieldCount, singularMessageFieldCount;
    int requiredEnumFieldCount, repeatedEnumFieldCount, singularEnumFieldCount;
    int requiredBytesFieldCount, repeatedBytesFieldCount, singularBytesFieldCount;
    int requiredStringFieldCount, repeatedStringFieldCount, singularStringFieldCount;
    
    // cache these formats
    private java.lang.String nameCC;
    
    public Message(String name, Message parentMessage, Proto proto)
    {
        this.name = name;
        this.parentMessage = parentMessage;
        
        if (parentMessage != null)
        {
            this.proto = parentMessage.getProto();
            parentMessage.addNestedMessage(this);
        }
        else
        {
            this.proto = proto;
            proto.addMessage(this);
        }
    }
    
    public java.lang.String getNameCC()
    {
        if (nameCC == null)
            nameCC = Formatter.BUILTIN.CC.format(name);
        
        return nameCC;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Proto getProto()
    {
        return proto;
    }
    
    public Message getRootMessage()
    {
        return parentMessage == null ? null : getRoot(parentMessage);
    }
    
    public Message getParentMessage()
    {
        return parentMessage;
    }
    
    public boolean isNested()
    {
        return parentMessage != null;
    }
    
    public boolean hasNestedMessages()
    {
        return !nestedMessages.isEmpty();
    }
    
    public boolean hasNestedEnumGroups()
    {
        return !nestedEnumGroups.isEmpty();
    }
    
    public LinkedHashMap<String,Message> getNestedMessageMap()
    {
        return nestedMessages;
    }
    
    /**
     * Alias to {@link #getNestedMessageMap()}.
     */
    public LinkedHashMap<String,Message> getM()
    {
        return getNestedMessageMap();
    }
    
    public Collection<Message> getNestedMessages()
    {
        return nestedMessages.values();
    }
    
    public Message getNestedMessage(String name)
    {
        return nestedMessages.get(name);     
    }
    
    void addNestedMessage(Message message)
    {
        if (nestedMessages.put(message.name, message) != null)
        {
            throw err(message, " cannot be defined more than once.", getProto());
        }
    }
    
    /* ================================================== */
    
    public LinkedHashMap<String,EnumGroup> getNestedEnumGroupMap()
    {
        return nestedEnumGroups;
    }
    
    /**
     * Alias to {@link #getNestedEnumGroupMap()}.
     */
    public LinkedHashMap<String,EnumGroup> getE()
    {
        return getNestedEnumGroupMap();
    }
    
    public Collection<EnumGroup> getNestedEnumGroups()
    {
        return nestedEnumGroups.values();
    }
    
    public EnumGroup getNestedEnumGroup(String name)
    {
        return nestedEnumGroups.get(name);
    }
    
    void addNestedEnumGroup(EnumGroup enumGroup)
    {
        if (nestedEnumGroups.put(enumGroup.name, enumGroup) != null)
        {
            throw err(enumGroup, " cannot be defined more than once.", getProto());
        }
    }
    
    /* ================================================== */
    
    public LinkedHashMap<String,Service> getNestedServiceMap()
    {
        return nestedServices;
    }
    
    /**
     * Alias to {@link #getNestedServiceMap()}.
     */
    public LinkedHashMap<String,Service> getS()
    {
        return getNestedServiceMap();
    }
    
    public Collection<Service> getNestedServices()
    {
        return nestedServices.values();
    }
    
    public Service getNestedService(String name)
    {
        return nestedServices.get(name);
    }
    
    void addNestedService(Service service)
    {
        if (nestedServices.put(service.name, service) != null)
        {
            throw err(service, " cannot be defined more than once.", getProto());
        }
    }
    
    /* ================================================== */
    
    public LinkedHashMap<String,Field<?>> getFieldMap()
    {
        return fields;
    }
    
    /**
     * Alias to {@link #getFieldMap()}.
     */
    public LinkedHashMap<String,Field<?>> getF()
    {
        return getFieldMap();
    }
    
    public List<Field<?>> getNonDeprecatedFields()
    {
        if (nonDeprecatedFields == null)
        {
            nonDeprecatedFields = new ArrayList<Field<?>>();
            for (Field<?> f : sortedFields)
            {
                if (Boolean.TRUE.equals(f.getO().get("deprecated")))
                    continue;
                
                nonDeprecatedFields.add(f);
            }
        }
        
        return nonDeprecatedFields;
    }
    
    public List<Field<?>> getFields()
    {
        return sortedFields;
    }
    
    public Collection<Field<?>> getDeclaredFields()
    {
        return fields.values();
    }
    
    public Field<?> getField(String name)
    {
        return fields.get(name);
    }
    
    public boolean isDescendant(Message other)
    {
        if (parentMessage == null)
            return false;
        return parentMessage == other || parentMessage.isDescendant(other);
    }
    
    public Message getDescendant(String name)
    {
        if (parentMessage == null)
            return null;
        
        return name.equals(parentMessage.name) ? parentMessage : parentMessage.getDescendant(name);
    }

    @SuppressWarnings("unchecked")
    public <T extends Field<?>> T getField(String name, Class<T> typeClass)
    {
        return (T)fields.get(name);
    }
    
    public boolean isStruct()
    {
        return typeAnnotation != null && "struct".equals(typeAnnotation.name);
    }
    
    public void addField(Field<?> field)
    {
        // if it errors, the err msg (below) will include the field's owner.
        field.owner = this;
        
        if (field.number < 1)
            throw err(field, " has an invalid field number: " + field.number, getProto());
        
        if (fields.put(field.name, field) != null)
            throw err(field, " cannot be defined more than once.", getProto());
    }
    
    /*public void defineExtensionRange(int first, int last)
    {
        extensionRanges.add(new int[]{ first, last });
        this.extensible = true;
    }

    public void addNestedExtension(Extension extension) 
    {
        this.nestedExtensions.add(extension);
    }

    public Collection<Extension> getNestedExtensions()
    {
        return this.nestedExtensions;
    }
    
    public void extend(Extension extension)
    {
        if (isExtensible() == false)
        {
            throw err("Message " + getFullName()
                    + " does not define extension range", getProto());
        }

        for (Field<?> field : extension.getFields())
        {
            int number = field.getNumber();
            boolean inRange = false;
            for (int[] range : extensionRanges)
            {
                if (number >= range[0] && number <= range[1])
                {
                    inRange = true;
                    break;
                }
            }
            if (inRange == false)
            {
                throw err("Extension '" + field.getName()
                        + "' is outside extension range", getProto());
            }
            if (this.extensions.containsKey(number))
            {
                throw err("Extension already defined for number '" + number
                        + "'", getProto());
            }
            this.extensions.put(number, field);
        }
    }*/
    
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
    
    @SuppressWarnings("unchecked")
    public <V> V getExtraOption(java.lang.String key)
    {
        return (V)extraOptions.get(key);
    }
    
    public LinkedHashMap<String,Object> getO()
    {
        return getOptions();
    }
    
    public LinkedHashMap<String,Object> getOptions()
    {
        return extraOptions;
    }
    
    public String getEnclosingNamespace()
    {
        return getFullName();
    }
    
    private String fullName(String packageName)
    {
        return fullName(packageName, '.');
    }
    
    private String fullName(String packageName, char separator)
    {
        StringBuilder buffer = new StringBuilder();
        resolveFullName(this, buffer, packageName, separator);
        return buffer.toString();
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
        
        StringBuilder buffer = new StringBuilder();
        resolveRelativeName(this, buffer, null, '.');
        return (relativeName = buffer.toString());
    }
    
    public String getCppRelativeName()
    {
        if (cppRelativeName != null)
            return cppRelativeName;
        
        StringBuilder buffer = new StringBuilder();
        resolveRelativeName(this, buffer, null, '_');
        return (cppRelativeName = buffer.toString());
    }
    
    public String getCppFullName()
    {
        return fullName(getProto().getPackageName().replaceAll("\\.", "::"), '_');
    }
    
    public boolean isExtensible()
    {
        return extensible;
    }
    
    // codegen helpers
    
    public boolean isAnnotationPresentOnFields()
    {
        return annotationPresentOnFields;
    }
    
    public boolean isRepeatedFieldPresent()
    {
        return repeatedFieldPresent;
    }
    
    public boolean isBytesFieldPresent()
    {
        return bytesFieldPresent;
    }
    
    public boolean isBytesOrStringDefaultValuePresent()
    {
        return bytesOrStringDefaultValuePresent;
    }
    
    public boolean isRequiredFieldPresent()
    {
        return requiredFieldPresent;
    }
    
    public boolean isRequiredFieldPresentOnCurrent()
    {
        return requiredFieldCount != 0;
    }
    
    // field count
    
    public int getFieldCount()
    {
        return fields.size();
    }
    
    public int getRequiredFieldCount()
    {
        return requiredFieldCount;
    }
    
    public int getRepeatedFieldCount()
    {
        return repeatedFieldCount;
    }
    
    public int getOptionalFieldCount()
    {
        return singularFieldCount - requiredFieldCount;
    }
    
    public int getSingularFieldCount()
    {
        return singularFieldCount;
    }
    
    // message field count
    
    public int getMessageFieldCount()
    {
        return repeatedMessageFieldCount + singularMessageFieldCount;
    }
    
    public int getRequiredMessageFieldCount()
    {
        return requiredMessageFieldCount;
    }
    
    public int getRepeatedMessageFieldCount()
    {
        return repeatedMessageFieldCount;
    }
    
    public int getOptionalMessageFieldCount()
    {
        return singularMessageFieldCount - requiredMessageFieldCount;
    }
    
    public int getSingularMessageFieldCount()
    {
        return singularMessageFieldCount;
    }
    
    // enum field count
    
    public int getEnumFieldCount()
    {
        return repeatedEnumFieldCount + singularEnumFieldCount;
    }
    
    public int getRequiredEnumFieldCount()
    {
        return requiredEnumFieldCount;
    }
    
    public int getRepeatedEnumFieldCount()
    {
        return repeatedEnumFieldCount;
    }
    
    public int getOptionalEnumFieldCount()
    {
        return singularEnumFieldCount - requiredEnumFieldCount;
    }
    
    public int getSingularEnumFieldCount()
    {
        return singularEnumFieldCount;
    }
    
    // bytes field count
    
    public int getBytesFieldCount()
    {
        return repeatedBytesFieldCount + singularBytesFieldCount;
    }
    
    public int getRequiredBytesFieldCount()
    {
        return requiredBytesFieldCount;
    }
    
    public int getRepeatedBytesFieldCount()
    {
        return repeatedBytesFieldCount;
    }
    
    public int getOptionalBytesFieldCount()
    {
        return singularBytesFieldCount - requiredBytesFieldCount;
    }
    
    public int getSingularBytesFieldCount()
    {
        return singularBytesFieldCount;
    }
    
    // string field count
    
    public int getStringFieldCount()
    {
        return repeatedStringFieldCount + singularStringFieldCount;
    }
    
    public int getRequiredStringFieldCount()
    {
        return requiredStringFieldCount;
    }
    
    public int getRepeatedStringFieldCount()
    {
        return repeatedStringFieldCount;
    }
    
    public int getOptionalStringFieldCount()
    {
        return singularStringFieldCount - requiredStringFieldCount;
    }
    
    public int getSingularStringFieldCount()
    {
        return singularStringFieldCount;
    }
    
    // scalar field count
    
    public int getScalarFieldCount()
    {
        return getFields().size() - repeatedMessageFieldCount - singularMessageFieldCount;
    }
    
    public int getScalarWithoutEnumFieldCount()
    {
        return getScalarFieldCount() - repeatedEnumFieldCount - singularEnumFieldCount;
    }
    
    public boolean isSequentialFieldNumbers()
    {
        return sortedFields.size() == sortedFields.get(sortedFields.size() - 1).number;
    }
    
    /**
     * Alias to {@link #isSequentialFieldNumbers()}.
     */
    public boolean isSfn()
    {
        return isSequentialFieldNumbers();
    }
    
    public int getMinAlign()
    {
        return minAlign;
    }
    
    public int getForceAlign()
    {
        return forceAlign;
    }
    
    public ArrayList<Integer> getSizeofValues()
    {
        return sizeofValues;
    }
    
    // post parse
    
    void resolveReferences(Message root)
    {
        final Proto proto = getProto();
        final String fullName = getFullName();
        final boolean struct = isStruct();
        
        if (struct && typeAnnotation.getP().containsKey("force_align"))
        {
            Object value = typeAnnotation.getValue("force_align");
            if (!(value instanceof Integer))
                throw err(this, " contains the attribute: force_align which must be a power of two integer ranging from the struct's natural alignment to 256", proto);
            
            forceAlign = ((Integer)value).intValue();
            if (forceAlign < 1 || 0 != (forceAlign & forceAlign-1))
                throw err(this, " contains the attribute: force_align which must be a power of two integer ranging from the struct's natural alignment to 256", proto);
        }
        
        final Collection<Field<?>> declaredFields = fields.values();
        for (Field<?> f : declaredFields)
        {
            if (struct && Boolean.TRUE.equals(f.getO().get("deprecated")))
                throw err(f, " cannot be deprecated in a struct", proto);
            
            if (f.isRepeated())
            {
                if (struct)
                    throw err(f, " cannot be repeated in a struct", proto);
                
                repeatedFieldCount++;
                root.repeatedFieldPresent = true;
            }
            else
            {
                singularFieldCount++;
                
                if (f.isRequired())
                {
                    requiredFieldCount++;
                    root.requiredFieldPresent = true;
                }
            }
            
            if (!annotationPresentOnFields && !f.annotations.isEmpty())
                annotationPresentOnFields = true;
            
            if (f instanceof Field.Bytes)
            {
                if (struct)
                    throw err(f, " is neither a scalar nor struct field", proto);
                
                if (f.isRepeated())
                    repeatedBytesFieldCount++;
                else
                {
                    singularBytesFieldCount++;
                    
                    if (f.isRequired())
                        requiredBytesFieldCount++;
                }
                
                if (!root.bytesFieldPresent)
                    root.bytesFieldPresent = true;
                if (!root.bytesOrStringDefaultValuePresent && f.defaultValue != null)
                    root.bytesOrStringDefaultValuePresent = true;
            }
            else if (f instanceof Field.String)
            {
                if (struct)
                    throw err(f, " is neither a scalar nor struct field", proto);
                
                if (f.isRepeated())
                    repeatedStringFieldCount++;
                else
                {
                    singularStringFieldCount++;
                    
                    if (f.isRequired())
                        requiredStringFieldCount++;
                }
                
                if (!root.bytesOrStringDefaultValuePresent && f.defaultValue != null)
                    root.bytesOrStringDefaultValuePresent = true;
            }
            else if (f instanceof Field.Reference)
            {
                Field.Reference fr = (Field.Reference)f;
                String refName = fr.refName;
                String packageName = fr.packageName;
                String fullRefName = (packageName == null ? refName : packageName + '.' + refName);

                HasName refObj = proto.findReference(fullRefName, fullName);
                if (refObj instanceof Message)
                {
                    MessageField mf = newMessageField((Message) refObj, fr, this);
                    fields.put(mf.name, mf);
                    
                    if (struct && !mf.message.isStruct())
                        throw err(f, " is neither a scalar nor struct field", proto);
                    
                    if (mf.isRepeated())
                        repeatedMessageFieldCount++;
                    else
                    {
                        singularMessageFieldCount++;
                        
                        if (mf.isRequired())
                            requiredMessageFieldCount++;
                    }
                    
                    // references inside options
                    if (!mf.standardOptions.isEmpty())
                        proto.references.add(new ConfiguredReference(mf.standardOptions, mf.extraOptions, fullName));
                    
                    continue;
                }
                
                if (refObj instanceof EnumGroup)
                {
                    EnumField ef = newEnumField((EnumGroup) refObj, fr, this);
                    fields.put(ef.name, ef);
                    
                    if (struct && ef.enumGroup.typeAnnotation != null)
                    {
                        int sizeOf = ef.enumGroup.getSizeof();
                        sizeofValues.add(sizeOf);
                        minAlign = Math.max(minAlign, sizeOf);
                    }
                    
                    if (ef.isRepeated())
                        repeatedEnumFieldCount++;
                    else
                    {
                        singularEnumFieldCount++;
                        
                        if (ef.isRequired())
                            requiredEnumFieldCount++;
                    }
                    
                    // references inside options
                    if (!ef.standardOptions.isEmpty())
                        proto.references.add(new ConfiguredReference(ef.standardOptions, ef.extraOptions, fullName));
                    
                    continue;
                }
                
                throw err(this, " contains an unknown field type: " + fullRefName, proto);
            }
            else if (struct)
            {
                if (f.isBoolField())
                {
                    sizeofValues.add(1);
                }
                else
                {
                    int sizeOf = Field.numSizeOf(f.getFbsType());
                    sizeofValues.add(sizeOf);
                    minAlign = Math.max(minAlign, sizeOf);
                }
            }
            
            // references inside options
            if (!f.standardOptions.isEmpty())
                proto.references.add(new ConfiguredReference(f.standardOptions, f.extraOptions, fullName));
        }
        
        if (!fields.isEmpty())
        {
            sortedFields.addAll(declaredFields);
            
            if (fields.size() > 1)
                Collections.sort(sortedFields);
            
            if (SEQUENTIAL_FIELD_NUMBERS && !getA().containsKey("MergeParent") && !isSequentialFieldNumbers())
                throw err(this, " must have sequential field numbers (starts at 1, no gaps in-between)", proto);
            
            if (struct && forceAlign != 0 && forceAlign < minAlign)
                throw err(this, " contains the attribute: force_align which must be a power of two integer ranging from the struct's natural alignment to 256", proto);
        }
        
        //for (Extension extension : this.nestedExtensions)
        //    extension.resolveReferences();
        
        for (Service s : nestedServices.values())
            s.resolveReferences();
        
        for (Message m : nestedMessages.values())
            m.resolveReferences(root);
    }
    
    void cacheFullyQualifiedNames()
    {
        Proto proto = getProto();
        proto.fullyQualifiedMessages.put(getFullName(), this);
        
        for (Message m : nestedMessages.values())
            m.cacheFullyQualifiedNames();
        for (EnumGroup eg : nestedEnumGroups.values())
            eg.cacheFullyQualifiedName();
        
        Annotation mp = getA().get("MergeParent");
        if (mp != null)
        {
            if (parentMessage == null)
                throw err(this, "A message with @MergeParent must be nested.", proto);
            
            if (Boolean.TRUE.equals(mp.getP().get("partial")))
            {
                final boolean flex_modifier = Boolean.TRUE.equals(mp.getP().get("flex_modifier"));
                for (Field<?> f : fields.values())
                {
                    f.getO().put("~mp.partial", Boolean.TRUE);
                    
                    Field<?> pf = parentMessage.getField(f.getName());
                    if (pf == null)
                        continue;
                    
                    if (pf.getClass() != f.getClass() || pf.number != f.number)
                        throw err(f, " is not the same as its parent field.", proto);
                    
                    if (pf.getModifier() == f.getModifier())
                        f.getO().put("~mp", Boolean.TRUE);
                    else if (!flex_modifier)
                        throw err(f, " is not the same as its parent field.", proto);
                }
            }
            else
            {
                for (Field<?> f : parentMessage.fields.values())
                {
                    Field<?> cf = f.create();
                    copy(f, cf, false);
                    cf.pbType = f.pbType;
                    cf.getO().put("~mp", Boolean.TRUE);
                    addField(cf);
                }
            }
        }
        
        if (!standardOptions.isEmpty())
            proto.references.add(new ConfiguredReference(standardOptions, extraOptions, getFullName()));
    }
    
    static MessageField newMessageField(Message message, Field.Reference fr, Message owner)
    {
        MessageField mf = new MessageField(message);
        mf.owner = owner;
        mf.packable = false;
        copy(fr, mf);
        //System.err.println(owner.getRelativeName() + "." + mf.name +": " + mf.getJavaType());
        return mf;
    }
    
    static EnumField newEnumField(EnumGroup enumGroup, Field.Reference fr, Message owner)
    {
        EnumField ef = new EnumField(enumGroup);
        ef.owner = owner;
        ef.packable = true;
        String refName = (String)fr.getDefaultValue();
        if (refName == null)
            ef.defaultValue = enumGroup.getFirstValue();
        else
        {
            ef.defaultValueSet = true;
            ef.defaultValue = enumGroup.getValue(refName);
            if (ef.defaultValue == null)
                throw err(ef, " contains an unknown enum value: " + refName, owner.getProto());
        }
        copy(fr, ef);
        //System.err.println(owner.getRelativeName() + "." + ef.name +": " + ef.getJavaType());
        return ef;
    }
    
    static void copy(Field<?> from, Field<?> to)
    {
        copy(from, to, true);
    }
    
    static void copy(Field<?> from, Field<?> to, boolean clearSource)
    {
        to.name = from.name;
        to.number = from.number;
        to.modifier = from.modifier;
        to.addAnnotations(from, clearSource);
        to.standardOptions.putAll(from.standardOptions);
        to.extraOptions.putAll(from.extraOptions);
    }
    
    static void resolveFullName(Message message, StringBuilder buffer, String packageName, 
            char separator)
    {
        buffer.insert(0, message.name).insert(0, separator);
        if (message.isNested())
            resolveFullName(message.parentMessage, buffer, packageName, separator);
        else if (separator == '_')
        {
            buffer.setCharAt(0, ':');
            buffer.insert(0, ':').insert(0, packageName);
        }
        else
            buffer.insert(0, packageName);
    }
    
    static void resolveRelativeName(Message message, StringBuilder buffer, 
            Message descendant, char separator)
    {
        buffer.insert(0, message.name);
        if (message.parentMessage != null && message.parentMessage != descendant)
        {
            buffer.insert(0, separator);
            resolveRelativeName(message.parentMessage, buffer, descendant, separator);
        }
    }
    
    static void computeName(Message message, Message owner, StringBuilder buffer)
    {
        computeName(message, owner, buffer, false);
    }
    
    static void computeName(Message message, Message owner, StringBuilder buffer, 
            boolean withDescendantOwnerName)
    {
        if (message.parentMessage==owner)
        {
            if (withDescendantOwnerName)
                buffer.append(owner.name).append('.');
            buffer.append(message.name);
        }
        else if (owner==message || owner.isDescendant(message))
            buffer.append(message.name);
        else if (message.isDescendant(owner))
        {
            Message.resolveRelativeName(message, buffer, owner, '.');
            if (withDescendantOwnerName)
            {
                buffer.insert(0, '.');
                buffer.insert(0, owner.name);
            }
        }
        else if (message.getProto().getJavaPackageName().equals(owner.getProto().getJavaPackageName()))
            buffer.append(message.getRelativeName());
        else
            buffer.append(message.getJavaFullName());
    }
    
    static void computeCppName(Message message, Message owner, StringBuilder buffer)
    {
        if (owner==message || message.parentMessage==owner || owner.isDescendant(message))
            buffer.append(message.name);
        else if (message.isDescendant(owner))
            Message.resolveRelativeName(message, buffer, owner, '_');
        else if (message.getProto() == owner.getProto())
            buffer.append(message.getCppRelativeName());
        else
            buffer.append(message.getCppFullName());
    }
    
    static Message getRoot(Message parent)
    {
        return parent.parentMessage == null ? parent: getRoot(parent.parentMessage);
    }
    
    @Override
    public String toString()
    {
        return  ConfiguredReference.UDT_TO_STRING_AS_FQCN ? getFullName() : getName();
    }
}
