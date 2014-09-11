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

import static io.protostuff.fbsgen.compiler.CompilerUtil.COMMA;
import static io.protostuff.fbsgen.compiler.CompilerUtil.DOUBLE_UNDERSCORE;
import static io.protostuff.fbsgen.compiler.ErrorUtil.err;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.AnnotationContainer;
import io.protostuff.fbsgen.parser.CodegenUtil;
import io.protostuff.fbsgen.parser.EnumField;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.HasName;
import io.protostuff.fbsgen.parser.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Util for query *Map objects.
 * 
 * @author David Yu
 * @created Jul 25, 2013
 */
public final class QueryUtil
{
    private QueryUtil() {}
    
    static final String[] ANN_NAMES = new String[]{
        "Display", "Exclude"
    };
    
    static final String ANN_KEY = "config_target";
    
    /**
     * Append the entry to the list, with the latter being put into the map with the key.
     */
    public static <T> void appendTo(Map<String,ArrayList<T>> map, T entry, 
            String key)
    {
        ArrayList<T> existing = map.get(key);
        if (existing == null)
        {
            existing = new ArrayList<T>();
            map.put(key, existing);
        }
        
        existing.add(entry);
    }
    
    /**
     * Append the entry to the map (using innerKey), with the latter being put 
     * into the map with the key.
     */
    public static <T> void appendUnqiueTo(Map<String,LinkedHashMap<String,T>> map, 
            T entry, 
            String key, String innerKey)
    {
        LinkedHashMap<String,T> existing = map.get(key);
        if (existing == null)
        {
            existing = new LinkedHashMap<String,T>();
            map.put(key, existing);
        }
        
        if (existing.containsKey(innerKey))
            return;
        
        existing.put(innerKey, entry);
    }
    
    /**
     * Put the entry to the map with the innerKey.
     */
    public static <T extends HasName> void appendTo(
            Map<String,LinkedHashMap<String,ArrayList<T>>> map, T entry, 
            String key, String innerKey)
    {
        LinkedHashMap<String,ArrayList<T>> existing = map.get(key);
        if (existing == null)
        {
            existing = new LinkedHashMap<String,ArrayList<T>>();
            map.put(key, existing);
        }
        
        appendTo(existing, entry, innerKey);
    }
    
    /**
     * Put the list entry to the map with the innerKey.
     */
    public static <T> void appendListTo(
            //  pkg                  service          p
            Map<String,LinkedHashMap<String,ArrayList<T>>> map, Collection<T> entry, 
            String key, String innerKey)
    {
        LinkedHashMap<String,ArrayList<T>> existing = map.get(key);
        
        ArrayList<T> list;
        if (existing == null)
        {
            existing = new LinkedHashMap<String,ArrayList<T>>();
            map.put(key, existing);
            
            list = new ArrayList<T>();
            existing.put(innerKey, list);
        }
        else
        {
            list = existing.get(innerKey);
            
            if (list == null)
            {
                list = new ArrayList<T>();
                existing.put(innerKey, list);
            }
        }
        
        list.addAll(entry);
    }
    
    /**
     * Returns 1/4/8/D/B/K/S.
     */
    public static char getFieldIdxChar(Field<?> f, EnumGroup.Value v, Message message)
    {
        if (f.getNumber() == 1)
        {
            throw err("The secondary index for " + message.getName() + 
                    "should not directly reference the key field: " + v.getName(), 
                    message.getProto());
        }
        
        if (f.isMessageField())
        {
            throw err("The secondary index for " + message.getName() + 
                    "cannot reference a message field: " + v.getName() + " -> " + 
                    f.getName(), 
                    message.getProto());
        }
        
        if (f.isStringField())
            return 'S';
        
        if (f.isBytesField())
        {
            return f.getName().endsWith("_key") || Boolean.TRUE.equals(
                    f.getOptions().get("~foreign_key")) ? 'K' : 'B';
        }
        
        if (f.isBoolField() || CodegenUtil.isOneByte(f))
            return '1';
        
        if (f.isEnumField())
            return '4';
        
        /* ================================================== */
        // numbers

        String javaType = f.getJavaType();
        
        if ("int".equals(javaType) || "float".equals(javaType))
            return '4';
        
        // double or long
        
        if (f instanceof Field.UInt64 && 
                        (Boolean.TRUE.equals(f.getOptions().get("date")) || 
                        Boolean.TRUE.equals(f.getOptions().get("datetime"))))
        {
            return 'D';
        }
        
        return '8';
    }
    
    public static String getFieldIdxPrefix(Field<?> f)
    {
        // TODO bytes handling
        if (f.isStringField())// || (f.isBytesField() && !f.getName().endsWith("_key")))
            return ", FN_";
        
        return ", -FN_";
    }
    
    /* ================================================== */
    
    private static Annotation getAnnotationWithConfigTarget(AnnotationContainer ac, 
            String[] names, String key)
    {
        if (ac.isEmptyA())
            return null;
        
        for (String name : names)
        {
            Annotation a = ac.getAnnotation(name);
            if (a != null)
            {
                Message m = a.getValue(key);
                if (m != null)
                    return a;
            }
        }
        
        return null;
    }
    
    /* ================================================== */
    
    public static LinkedHashMap<String,ArrayList<Field<?>>> getConfigTargetFieldMap(
            EnumGroup config, String entryPrefix, boolean entryPrefixOnly)
    {
        Annotation display = getAnnotationWithConfigTarget(config, 
                ANN_NAMES, ANN_KEY);
        
        // defaults to parent message
        Message target = display == null ? config.getParentMessage() : 
            (Message)display.getValue(ANN_KEY);
        
        LinkedHashMap<String,ArrayList<Field<?>>> map = 
                new LinkedHashMap<String, ArrayList<Field<?>>>();
        
        for (EnumGroup.Value v : config.getValues())
        {
            map.put(v.getName(), getConfigTargetFields(v, config, 
                    entryPrefix, entryPrefixOnly, 
                    target, display, v.getOptions()));
        }
            
        return map;
    }
    
    public static LinkedHashMap<String,ArrayList<Field<?>>> getConfigTargetFieldMap(
            Message config, String entryPrefix, boolean entryPrefixOnly)
    {
        Annotation display = getAnnotationWithConfigTarget(config, 
                ANN_NAMES, ANN_KEY);
        
        // defaults to parent message
        Message target = display == null ? config.getParentMessage() : 
            (Message)display.getValue(ANN_KEY);
        
        LinkedHashMap<String,ArrayList<Field<?>>> map = 
                new LinkedHashMap<String, ArrayList<Field<?>>>();
        
        for (Field<?> f : config.getFields())
        {
            map.put(f.getName(), getConfigTargetFields(f, config, 
                    entryPrefix, entryPrefixOnly, 
                    target, display, f.getOptions()));
        }
            
        return map;
    }
    
    /* ================================================== */
    
    public static ArrayList<Field<?>> getConfigTargetFields(EnumGroup.Value configField, 
            String entryPrefix, boolean entryPrefixOnly)
    {
        EnumGroup config = configField.getEnumGroup();
        
        Annotation display = getAnnotationWithConfigTarget(config, 
                ANN_NAMES, ANN_KEY);
        
        // defaults to parent message
        Message target = display == null ? config.getParentMessage() : 
            (Message)display.getValue(ANN_KEY);
        
        return getConfigTargetFields(configField, config, 
                entryPrefix, entryPrefixOnly, 
                target, display, configField.getOptions());
    }
    
    public static ArrayList<Field<?>> getConfigTargetFields(Field<?> configField, 
            String entryPrefix, boolean entryPrefixOnly)
    {
        Message config = configField.getOwner();
        
        Annotation display = getAnnotationWithConfigTarget(config, 
                ANN_NAMES, ANN_KEY);
        
        // defaults to parent message
        Message target = display == null ? config.getParentMessage() : 
            (Message)display.getValue(ANN_KEY);
        
        return getConfigTargetFields(configField, config, 
                entryPrefix, entryPrefixOnly, 
                target, display, configField.getOptions());
    }
    
    /* ================================================== */
    
    private static ArrayList<Field<?>> getConfigTargetFields(HasName configField, 
            HasName config, String entryPrefix, boolean entryPrefixOnly, 
            Message target, Annotation display, Map<String,Object> options)
    {
        ArrayList<Field<?>> fields = new ArrayList<Field<?>>();
        
        if (display != null)
        {
            // TODO remove casting hack
            AnnotationContainer ac = (AnnotationContainer)configField;
            Annotation a = ac.getAnnotation(display.getName());
            if (a != null && appendConfigTargetFieldsTo(fields, 
                    configField, config, 
                    entryPrefix, entryPrefixOnly, 
                    target, a.getParams()))
            {
                return fields;
            }
        }
        
        if (appendConfigTargetFieldsTo(fields, 
                configField, config, 
                entryPrefix, entryPrefixOnly, 
                target, options))
        {
            return fields;
        }
        
        throw err("The config " + config.getName() + " for " + target.getName() + 
                " has unconfigured entries: " + configField.getName(), 
                target.getProto());
    }
    
    /* ================================================== */
    
    public static boolean appendConfigTargetFieldsTo(ArrayList<Field<?>> fields, 
            HasName configField, HasName config, 
            String entryPrefix, boolean entryPrefixOnly, 
            Message target, Map<String,Object> optionOrAnnotationMap)
    {
        if (null == optionOrAnnotationMap.get(entryPrefix + "0"))
        {
            if (entryPrefixOnly)
                return false;
            
            // defaults to csv
            Pattern pattern = COMMA;
            
            String csv = (String)optionOrAnnotationMap.get("csv");
            if (csv == null)
            {
                // defaults to uusv
                pattern = DOUBLE_UNDERSCORE;
                csv = (String)optionOrAnnotationMap.get("uusv");
                
                if (csv == null)
                    return false;
            }
            
            for (String n : pattern.split(csv))
            {
                String name = n.trim().toLowerCase();
                
                Field<?> f = target.getField(name);
                if (f == null)
                {
                    throw err("The config " + config.getName() + " for " + 
                            target.getName() + " has invalid field references: " + 
                            configField.getName() + " -> " + name, 
                            target.getProto());
                }
                
                fields.add(f);
            }
            
            if (fields.isEmpty())
            {
                String svType = pattern == COMMA ? "csv" : "uusv";
                throw err("The config " + config.getName() + " for " + 
                        target.getName() + " has entries with empty " + svType + 
                        " value: " + configField.getName(), 
                        target.getProto());
            }
            
            return true;
        }
        
        // f0=foo, f1=bar
        
        for (int i = 0; ; i++)
        {
            String name = (String)optionOrAnnotationMap.get(entryPrefix+i);
            if (name == null)
            {
                if (i == 0)
                    throw new RuntimeException("Should not happen.");
                
                break;
            }
            
            Field<?> f = target.getField(name);
            if (f == null)
            {
                throw err("The config " + config.getName() + " for " + 
                        target.getName() + " has invalid field references: " + 
                        configField.getName() + " -> " + name, 
                        target.getProto());
            }
            
            fields.add(f);
        }
        
        return true;
    }
    
    static boolean appendForeignFieldTo(ArrayList<Field<?>> list, boolean tag, 
            String name, EnumGroup.Value v, Message target)
    {
        //if (tag && "key".equals(name))
        //{
        //    list.add(CodegenUtil.newForeignKeyField("key0", target));
        //    return true;
        //}
        
        if (tag && "datetime".equals(name))
        {
            list.add(CodegenUtil.newForeignDatetimeField("datetime0", target));
            return true;
        }
        
        if ("date".equals(name))
        {
            list.add(CodegenUtil.newForeignDateField("date0", target));
            return true;
        }
        
        final Message parent = EntityUtil.getEntityParent(target);
        if (parent == null)
            return false;
        
        if ("parent_key".equals(name))
        {
            list.add(CodegenUtil.newForeignKeyField("parent_key0", parent));
            return true;
        }
        
        if ("parent_date".equals(name))
        {
            list.add(CodegenUtil.newForeignDateField("parent_date0", parent));
            return true;
        }
        
        if ("parent_datetime".equals(name))
        {
            list.add(CodegenUtil.newForeignDatetimeField("parent_datetime0", parent));
            return true;
        }
        
        final Field<?> field = parent.getField(name);
        if (field == null || field.getNumber() < 3)
            return false;
        
        list.add(field);
        return true;
    }
    
    public static ArrayList<Field<?>> getUusvForeignFields(boolean tag, EnumGroup.Value v, Message target)
    {
        final ArrayList<Field<?>> fields = new ArrayList<Field<?>>();
        
        for (String n : DOUBLE_UNDERSCORE.split(v.getName()))
        {
            String name = n.trim().toLowerCase();
            
            Field<?> f = target.getField(name);
            if (f != null)
            {
                continue;
            }
            
            // foreign field
            if (name.charAt(name.length()-1) == '0' && appendForeignFieldTo(fields, tag, 
                    // reserved word, remove suffix
                    name.substring(0, name.length()-1), v, target))
            {
                continue;
            }
            
            throw err("The " + (tag ? "tag" : "secondary") + " index for " + target.getName() + 
                    " has invalid field references: " + v.getName() + 
                    " -> " + name, 
                    target.getProto());
        }
        
        return fields;
    }
    
    public static ArrayList<Field<?>> getUusvFields(boolean tag, EnumGroup.Value v, Message target)
    {
        final ArrayList<Field<?>> fields = new ArrayList<Field<?>>();
        
        for (String n : DOUBLE_UNDERSCORE.split(v.getName()))
        {
            String name = n.trim().toLowerCase();
            
            Field<?> f = target.getField(name);
            if (f != null)
            {
                fields.add(f);
                continue;
            }
            
            // foreign field
            if (name.charAt(name.length()-1) == '0' && appendForeignFieldTo(fields, tag, 
                    // reserved word, remove suffix
                    name.substring(0, name.length()-1), v, target))
            {
                continue;
            }
            
            throw err("The " + (tag ? "tag" : "secondary") + " index for " + target.getName() + 
                    " has invalid field references: " + v.getName() + 
                    " -> " + name, 
                    target.getProto());
        }
        
        return fields;
    }
    
    public static String getUusvIdxString(boolean tag, EnumGroup.Value v, Message target)
    {
        final StringBuilder sb = new StringBuilder();
        
        for (Field<?> f : getUusvFields(tag, v, target))
            sb.append(getFieldIdxChar(f, v, target));
        
        return sb.toString();
    }
    
    static StringBuilder appendForeignCsvTo(StringBuilder sb, boolean tag, 
            String name, EnumGroup.Value v, Message target)
    {
        //if (tag && "key".equals(name))
        //    return sb.append(", $KEY");
        
        if (tag && "datetime".equals(name))
            return sb.append(", $DATETIME");
        
        if ("date".equals(name))
            return sb.append(", $DATE");
        
        final Message parent = EntityUtil.getEntityParent(target);
        if (parent == null)
            return null;

        if ("parent_key".equals(name))
            return sb.append(", $PARENT_KEY");
        
        if ("parent_date".equals(name))
            return sb.append(", $PARENT_DATE");
        
        if ("parent_datetime".equals(name))
            return sb.append(", $PARENT_DATETIME");
        
        final Field<?> field = parent.getField(name);
        if (field == null || field.getNumber() < 3)
            return null;

        if (!Boolean.TRUE.equals(field.getOptions().get("immutable")))
        {
            throw err("The entity: " + parent.getRelativeName() + 
                    " cannot have a mutable field: " + field.getName() + 
                    " being referenced by the child: " + target.getRelativeName(), 
                    v);
        }
        
        if (Boolean.TRUE.equals(field.getOptions().get("computed")))
        {
            throw err("The entity: " + parent.getRelativeName() + 
                    " cannot have a computed field: " + field.getName() + 
                    " being referenced by the child: " + target.getRelativeName(), 
                    v);
        }
        
        if (!Boolean.TRUE.equals(parent.getOptions().get("~entity.with_link_index")))
        {
            throw err("The entity: " + parent.getRelativeName() + 
                    " must set the 'with_link_index' option/annotation to true " + 
                    " since its field is being referenced by the child: " + 
                    target.getRelativeName(), 
                    v);
        }
        
        sb.append(", ");
        if (!field.isStringField() && (!field.isBytesField() || name.endsWith("_key")))
            sb.append('-');
        
        Integer volen = (Integer)field.getOptions().get("~volen");
        if (volen != null)
        {
            Integer volen_on_idx_key = (Integer)field.getOptions().get("~volen_on_idx_key");
            if (volen_on_idx_key != null)
                volen = volen_on_idx_key;
            
            return sb.append("((").append(parent.getRelativeName())
                    .append(".VO_").append(name.toUpperCase()).append(" << 8) | ")
                    .append(volen.intValue()).append(')');
        }
        
        final String ftSuffix;
        
        if (field.isEnumField())
        {
            ftSuffix = null == ((EnumField)field).getEnumGroup().getAnnotation(
                    "OneByte") ? "INT32" : "INT8";
        }
        else if (field instanceof Field.UInt32 && Boolean.TRUE.equals(
                field.getOptions().get("onebyte")))
        {
            ftSuffix = "INT8";
        }
        else
        {
            ftSuffix = field.getClass().getSimpleName().toUpperCase();
        }
        
        return sb.append("((").append(parent.getRelativeName())
                .append(".FN_").append(name.toUpperCase()).append(" << 8) | (FT_")
                .append(ftSuffix).append(" << 4))");
    }
    
    public static String getUusvIdxCsv(boolean tag, EnumGroup.Value v, Message target)
    {
        final StringBuilder sb = new StringBuilder();
        
        for (String n : DOUBLE_UNDERSCORE.split(v.getName()))
        {
            String name = n.trim().toLowerCase();
            
            Field<?> f = target.getField(name);
            if (f != null)
            {
                sb.append(getFieldIdxPrefix(f)).append(f.getName().toUpperCase());
                continue;
            }
            
            // foreign field
            if (name.charAt(name.length()-1) == '0' && null != appendForeignCsvTo(sb, tag, 
                    // reserved word, remove suffix
                    name.substring(0, name.length()-1), v, target))
            {
                continue;
            }
            
            throw err("The " + (tag ? "tag" : "secondary") + " index for " + target.getName() + 
                    " has invalid field references: " + v.getName() + 
                    " -> " + name, 
                    target.getProto());
        }
        
        return sb.toString();
    }
}