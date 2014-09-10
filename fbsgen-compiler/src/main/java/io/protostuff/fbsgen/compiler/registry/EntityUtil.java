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

package io.protostuff.fbsgen.compiler.registry;

import static io.protostuff.fbsgen.compiler.registry.CollectionUtil.addTo;
import static io.protostuff.fbsgen.compiler.ErrorUtil.err;
import static io.protostuff.fbsgen.compiler.registry.QueryUtil.getUusvFields;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import io.protostuff.fbsgen.compiler.ErrorUtil;
import io.protostuff.fbsgen.compiler.map.IsMessageMap;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.CodegenUtil;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.MessageField;

/**
 * Utils for validating/querying an entity.
 * 
 * @author David Yu
 * @created Dec 12, 2013
 */
public final class EntityUtil
{
    private EntityUtil() {}
    
    //Field types used on parent-field indexing.
    /*static final int 
            FT_INT32 = 1, // can be enum 
            FT_UINT32 = 2, 
            FT_SINT32 = 3, 
            FT_FIXED32 = 4, 
            FT_SFIXED32 = 5, 
            FT_FLOAT = 6, 
            
            FT_BYTES = 7, 
            FT_BOOL = 8, 
                    
            FT_INT64 = 9, 
            FT_UINT64 = 10, 
            FT_SINT64 = 11, 
            FT_FIXED64 = 12, 
            FT_SFIXED64 = 13,
            FT_DOUBLE = 14, 
            FT_STRING = 15;
    
    private static final HashMap<String,Integer> fieldTypeMapping = 
            new HashMap<String, Integer>();
    
    static
    {
        fieldTypeMapping.put(Field.Int32.class.getSimpleName(), FT_INT32);
        fieldTypeMapping.put(Field.UInt32.class.getSimpleName(), FT_UINT32);
        fieldTypeMapping.put(Field.SInt32.class.getSimpleName(), FT_SINT32);
        fieldTypeMapping.put(Field.Fixed32.class.getSimpleName(), FT_FIXED32);
        fieldTypeMapping.put(Field.SFixed32.class.getSimpleName(), FT_SFIXED32);
        fieldTypeMapping.put(Field.Float.class.getSimpleName(), FT_FLOAT);
        
        fieldTypeMapping.put(Field.Bytes.class.getSimpleName(), FT_BYTES);
        fieldTypeMapping.put(Field.Bool.class.getSimpleName(), FT_BOOL);
        
        fieldTypeMapping.put(Field.Int64.class.getSimpleName(), FT_INT64);
        fieldTypeMapping.put(Field.UInt64.class.getSimpleName(), FT_UINT64);
        fieldTypeMapping.put(Field.SInt64.class.getSimpleName(), FT_SINT64);
        fieldTypeMapping.put(Field.Fixed64.class.getSimpleName(), FT_FIXED64);
        fieldTypeMapping.put(Field.SFixed64.class.getSimpleName(), FT_SFIXED64);
        fieldTypeMapping.put(Field.Double.class.getSimpleName(), FT_DOUBLE);
        fieldTypeMapping.put(Field.String.class.getSimpleName(), FT_STRING);
    }
    
    public static int getFieldType(Field<?> field)
    {
        return fieldTypeMapping.get(field.getClass().getSimpleName()).intValue();
    }
    
    static boolean isVarInt(int fieldType)
    {
        return 0 != (0x03 & fieldType) && 0 == (0x04 & fieldType);
    }
    
    static boolean isVarInt32(int fieldType)
    {
        //return fieldType < 4;
        return 0 != (0x03 & fieldType) && 0 == (0x0C & fieldType);
    }
    
    static boolean isVarInt64(int fieldType)
    {
        return 0 != (0x03 & fieldType) && 8 == (0x0C & fieldType);
    }
    
    static boolean isDelimited(int fieldType)
    {
        return 7 == (0x07 & fieldType);
    }
    
    public static void main(String[] args)
    {
        System.err.println("---------------- varint ");
        for (int i = 0; i < 16;)
            System.err.println(isVarInt(++i) + " " + i);
        
        System.err.println("---------------- delimited ");
        for (int i = 0; i < 16;)
            System.err.println(isDelimited(++i) + " " + i);
        
        System.err.println("---------------- varint32 ");
        for (int i = 0; i < 16;)
            System.err.println(isVarInt32(++i) + " " + i);
        
        System.err.println("---------------- varint64 ");
        for (int i = 0; i < 16;)
            System.err.println(isVarInt64(++i) + " " + i);
    }*/
    
    /*public static int getEntityKind(Message message)
    {
        Annotation entity = message.getAnnotationMap().get("Entity");
        if (entity != null)
            return getKind(entity.getP().get("kind"), message);

        return getKind(message.getOptions().get("entity.kind"), message);
    }*/
    
    public static Message getEntityParent(Message message)
    {
        return (Message)message.getOptions().get("~entity.parent");
        /*Annotation entity = message.getAnnotationMap().get("Entity");
        if (entity != null)
            return entity.getValue("parent");

        return message.getOptions().get("entity.kind") instanceof Integer ? 
                (Message)message.getOptions().get("entity.parent") : null;*/
    }
    
    public static Message getEntityRoot(Message message)
    {
        for (Message parent = getEntityParent(message); parent != null; 
                parent = getEntityParent(message))
        {
            message = parent;
        }
        return message;
    }
    
    public static Message getEntityRootIfNested(Message message)
    {
        if (!message.isNested())
            return message;
        
        for (Message parent = message.getParentMessage(); 
                parent != null && IsMessageMap.Functions.ENTITY.query(parent); 
                parent = message.getParentMessage())
        {
            message = parent;
        }
        return message;
    }
    
    static int getKind(Object k, Message message)
    {
        if (k instanceof Integer)
        {
            int kind = ((Integer)k).intValue();
            if (kind > 0 && kind < 128)
                return kind;
        }
        
        throw err("The entity kind for " +
                message.getRelativeName() + " must be a number(1-127).", message);
    }
    
    public static int sizeOf(int fieldNumber)
    {
        return fieldNumber > 15 ? 2 : 1;
    }
    
    /**
     * Returns null if the message is not an entity.
     * Returns the parent if the entity has a parent, otherwise it returns 
     * the message itself.
     */
    public static Message fill(final Message message)
    {
        if (message.getOptions().containsKey("~entity.kind"))
        {
            Message parent = (Message)message.getOptions().get("~entity.parent");
            return parent == null ? message : parent;
        }
        
        final Annotation entity = message.getAnnotationMap().get("Entity");
        if (entity == null)
            return null;
        /*if (entity != null)
        {
            kind = getKind(entity.getP().get("kind"), message);
            p = entity.getParams().get("parent");
            withLinkIndex = (Boolean)entity.getParams().get("with_link_index");
        }
        else
        {
            final Object k = message.getOptions().get("entity.kind");
            if (k == null)
                return null;
            
            kind = getKind(k, message);
            p = message.getOptions().get("entity.parent");
            withLinkIndex = (Boolean)message.getOptions().get("with_link_index");
        }*/
        
        final int kind = getKind(entity.getP().get("kind"), message);
        final Object p = entity.getParams().get("parent");
        final Boolean withLinkIndex = entity.getValue("with_link_index");
        final Object cache = entity.getValue("cache");
        
        Field<?> rev = null;
        if (Boolean.TRUE.equals(entity.getValue("rev")))
        {
            rev = message.getField("rev");
            if (rev == null || !rev.getJavaType().equals("int"))
            {
                throw err("The revisioned entity: " + message.getRelativeName() + 
                        " must have the field: rev (int)", 
                        message);
            }
            
            message.getOptions().put("~entity.rev", rev);
        }
        
        Field.UInt64 updateTs = null;
        if (Boolean.TRUE.equals(entity.getValue("update_ts")))
        {
            Object f = message.getField("update_ts");
            if (f == null || !(f instanceof Field.UInt64) || 
                    !Boolean.TRUE.equals((updateTs = (Field.UInt64)f).getO().get("datetime")))
            {
                throw err("The updateTsisioned entity: " + message.getRelativeName() + 
                        " must have the field: update_ts (fixed64, datetime)", 
                        message);
            }
            
            message.getOptions().put("~entity.update_ts", updateTs);
        }
        
        if (updateTs != null || rev != null)
            message.getOptions().put("~entity.computed_update", true);
        
        if (cache != null && !Boolean.FALSE.equals(cache))
        {
            Field<?> id = message.getField("id");
            if (id == null || !id.getJavaType().equals("int"))
            {
                throw err("The cached entity: " + message.getRelativeName() + 
                        " must have the field: id (int)", 
                        message);
            }
        }
        
        Field<?> f;
        if (message.getFieldCount() < 3 || 
                // key
                !(f=message.getFields().get(0)).isOptional() || 
                !f.isBytesField() || 
                !f.getName().equals("key") || f.getNumber() != 1 ||
                // ts
                !(f=message.getFields().get(1)).isOptional() || 
                !(f instanceof Field.UInt64) || 
                !f.getName().equals("ts") || f.getNumber() != 2)
        {
            throw err("The entity: " + message.getRelativeName() + 
                    " must have atleast 3 fields with these first two declared:" + 
                    "\noptional bytes key = 1 [provided = true, immutable = true];" + 
                    "\noptional fixed64 ts = 2 [provided = true, immutable = true, datetime = true];", 
                    message);
        }
        
        if (message.getRepeatedFieldCount() != 0)
        {
            throw err("The entity: " + message.getRelativeName() + 
                    " cannot have repeated fields.", message);
        }
        
        EnumGroup si = message.getNestedEnumGroup("SI");
        if (si != null && !si.getA().containsKey("Config"))
        {
            throw err("The entity: " + message.getRelativeName() + 
                    " must annotate the nested enum SI with @Config", 
                    message);
        }
        
        int lastOffset = 0;
        Field<?> lastField = null;
        boolean checkValueOffset = true;
        for (int i = message.getFieldCount(); i-->2;)
        {
            f = message.getFields().get(i);
            int number = f.getNumber();
            if (number < 3 || number > 127)
            {
                throw err("The entity: " + message.getRelativeName() + 
                        " contains an invalid field: " + f.getName() + 
                        " (its number must be from 3 to 127)", 
                        message);
            }
            
            if (f instanceof MessageField)
            {
                throw err("The entity: " + message.getRelativeName() + 
                        " cannot have a message field: " + f.getName(), 
                        message);
            }
            
            if (f.isOptional() && !f.isDefaultValueSet())
            {
                throw err("The entity: " + message.getRelativeName() + 
                        " must define a default value for the field: " + f.getName(), 
                        message);
            }
            
            if (!checkValueOffset)
                continue;
            
            if (f.isBoolField() || CodegenUtil.isOneByte(f))
            {
                if (lastField == null)
                    lastOffset = 1;
                else
                    lastOffset = 1 + sizeOf(lastField.getNumber()) + lastOffset;
                
                lastField = f;
                //offsets.put(lastOffset, f);
                f.getOptions().put("~vo", lastOffset);
                f.getOptions().put("~volen", 1);
                
                continue;
            }
            
            if (f instanceof Field.UInt32 
                    || f instanceof Field.Float)
            {
                if (lastField == null)
                    lastOffset = 4;
                else
                    lastOffset = 4 + sizeOf(lastField.getNumber()) + lastOffset;
                
                lastField = f;
                //offsets.put(lastOffset, f);
                f.getOptions().put("~vo", lastOffset);
                f.getOptions().put("~volen", 4);
                
                continue;
            }
            
            if (f instanceof Field.UInt64 
                    || f instanceof Field.Double)
            {
                if (lastField == null)
                    lastOffset = 8;
                else
                    lastOffset = 8 + sizeOf(lastField.getNumber()) + lastOffset;
                
                lastField = f;
                //offsets.put(lastOffset, f);
                f.getOptions().put("~vo", lastOffset);
                f.getOptions().put("~volen", 8);
                
                if (f instanceof Field.UInt64 && (Boolean.TRUE.equals(
                        f.getOptions().get("date")) || Boolean.TRUE.equals(
                                f.getOptions().get("datetime"))))
                {
                    f.getOptions().put("~volen_on_idx_key", 6);
                }
                
                continue;
            }
            
            if (f.isBytesField() && f.getName().endsWith("key"))
            {
                if (lastField == null)
                    lastOffset = 9;
                else
                    lastOffset = 9 + sizeOf(lastField.getNumber()) + lastOffset;
                
                lastField = f;
                //offsets.put(lastOffset, f);
                f.getOptions().put("~vo", lastOffset);
                f.getOptions().put("~volen", 9);
                
                lastOffset++; // adjustment because of the length delimiter
                
                continue;
            }
            
            checkValueOffset = false;
        }
        
        message.getOptions().put("~entity.kind", kind);
        if (withLinkIndex != null && withLinkIndex.booleanValue())
            message.getOptions().put("~entity.with_link_index", Boolean.TRUE);
        
        if (p != null)
        {
            if (!(p instanceof Message))
            {
                throw err("The parent of " + 
                        message.getRelativeName() + " must be another entity.", message);
            }
            
            final Message parent = (Message)p;
            if (parent != message && (message.getAnnotationMap().containsKey("Entity") || 
                    message.getOptions().containsKey("entity.kind")))
            {
                message.getOptions().put("~entity.parent", parent);
                
                if (message.getName().endsWith("Entry"))
                    fillEntry(message, parent, entity, rev, updateTs);
                
                return parent;
            }
            
            throw err("The parent of " + 
                    message.getRelativeName() + " must be another entity.", message);
        }
        
        return message;
    }
    
    static void fillEntry(Message message, Message parent, Annotation entity, 
            Field<?> rev, Field.UInt64 updateTs)
    {
        if (!entity.getP().containsKey("create") && !entity.getP().containsKey("update"))
            return;
        
        addTo(parent.getOptions(), message, "~entity.entry_list");
        
        Object siUnique = entity.getValue("si_unique");
        if (siUnique != null)
        {
            EnumGroup.Value v;
            if (!(siUnique instanceof EnumGroup.Value) || 
                    !(v = (EnumGroup.Value)siUnique).getEg().getName().equals("SI"))
            {
                throw err("@Entity.si_unique of " + 
                        message.getRelativeName() + 
                        " must point to an enum value (SI.FOO).", message);
            }
            
            ArrayList<Field<?>> ff = getUusvFields(v.getNumber() < 224, 
                    v, v.getEnumGroup().getParentMessage());
            
            if (!ff.isEmpty())
            {
                message.getO().put("~entry.si_unique_ff", ff);
            }
        }
        
        Object computeToParent = entity.getValue("compute_to_parent");
        if (computeToParent != null)
        {
            final Field<?> field;
            if (computeToParent instanceof Boolean)
            {
                if (null == (field = parent.getField("total_entry_count")))
                {
                    throw ErrorUtil.err("@Entity.compute_to_parent of " + 
                            message.getRelativeName() + 
                            " was configured but the parent does not have the field: total_entry_count", 
                            message);
                }
            }
            else if (computeToParent instanceof String)
            {
                if (null == (field = parent.getField(computeToParent.toString())))
                {
                    throw ErrorUtil.err("@Entity.compute_to_parent of " + 
                            message.getRelativeName() + 
                            " must point to a parent field: " + computeToParent.toString(), 
                            message);
                }
            }
            else
            {
                throw ErrorUtil.err("@Entity.compute_to_parent of " + 
                        message.getRelativeName() + 
                        " must either be true or a string that points to a parent field", 
                        message);
            }
            
            addTo(message.getOptions(), field, "~entry.computed_list");
        }
        
        
        LinkedHashMap<String, ArrayList<Field<?>>> srcFieldMapping = 
                new LinkedHashMap<String, ArrayList<Field<?>>>();
        LinkedHashMap<Message, ArrayList<Field<?>>> srcProvidedFieldMapping = null;
        //ArrayList<EnumGroup.Value> srcSIList = null;
        Object src = null;
        int computedCount = 0;
        for (Field<?> f : message.getFields())
        {
            if (f.getNumber() < 2)
                continue;
            
            if ((src = f.getO().get("src")) == null)
            {
                if (f.getOptions().containsKey("compute_to_parent"))
                {
                    addTo(message.getOptions(), f, "~entry.computed_list");
                    computedCount++;
                }
                
                continue;
            }
            
            if (src instanceof EnumGroup.Value)
            {
                EnumGroup.Value v = (EnumGroup.Value)src;
                if (Boolean.TRUE.equals(v.getO().get("unique")))
                {
                    message.getOptions().put("~entry.src_si_unique", 
                            Boolean.TRUE);
                }
                else if (v.getO().containsKey("unique_prefix"))
                {
                    message.getOptions().put("~entry.src_si_unique_prefix", 
                            Boolean.TRUE);
                }
                else
                {
                    throw ErrorUtil.err("The @Entity annotation of " + 
                            message.getRelativeName() + 
                            " contains a field: " + f.getName() + 
                            " with a non-unique SI: " + 
                            v.getEg().getRelativeName() + "::" + 
                            v.getName(), message);
                }
                
                message.getOptions().put("~entry.src_si", Boolean.TRUE);
                addTo(srcFieldMapping, f, "SI_" + v.getName());
                
                /*if (srcSIList == null)
                    srcSIList = new ArrayList<EnumGroup.Value>();
                
                srcSIList.add(v);*/
            }
            else if (src instanceof Message)
            {
                Message m = (Message)src;
                String relativeName = m.getRelativeName();
                
                Object mapping = entity.getValue(relativeName);
                if (mapping != null && !(entity.getValue(relativeName) instanceof Message))
                {
                    throw ErrorUtil.err("The @Entity annotation of " + 
                            message.getRelativeName() + 
                            " contains a mapping: " + relativeName + 
                            " that does not point to a message.", message);
                }
                
                addTo(srcFieldMapping, f, relativeName);
                
                if (Boolean.TRUE.equals(entity.getValue(relativeName + ".provided")))
                {
                    if (srcProvidedFieldMapping == null)
                        srcProvidedFieldMapping = new LinkedHashMap<Message, ArrayList<Field<?>>>();
                    
                    addTo(srcProvidedFieldMapping, f, m);
                }
                else
                {
                    addTo(message.getOptions(), m, "~entry.src_non_provided_list");
                }
            }
            else
            {
                throw ErrorUtil.err("The src option of " + 
                        message.getRelativeName() + "::" + f.getName() + 
                        " must be a message.", message);
            }
            
            if (f.getOptions().containsKey("compute_to_parent"))
            {
                addTo(message.getOptions(), f, "~entry.computed_list");
                computedCount++;
            }
        }
        
        message.getOptions().put("~entry.src_map", srcFieldMapping);
        
        if (srcProvidedFieldMapping != null)
            message.getOptions().put("~entry.src_provided_map", srcProvidedFieldMapping);
        
        /*if (srcSIList != null)
        {
            for (EnumGroup.Value v : srcSIList)
            {
                ArrayList<Field<?>> ff = getUusvFields(v.getNumber() < 224, 
                        v, v.getEnumGroup().getParentMessage());
                
                if (ff.isEmpty())
                    continue;
                
                // TODO find parent field references in src SI
            }
        }*/
        
        if (computedCount != 0 || rev != null || updateTs != null)
            message.getOptions().put("~entry.computed_update", true);
    }
}