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

package io.protostuff.fbsgen.compiler.map;

import static io.protostuff.fbsgen.compiler.CompilerUtil.COMMA;
import static io.protostuff.fbsgen.compiler.ErrorUtil.err;
import static io.protostuff.fbsgen.compiler.ErrorUtil.getProto;
import static io.protostuff.fbsgen.compiler.registry.QueryUtil.getConfigTargetFieldMap;
import static io.protostuff.fbsgen.compiler.registry.QueryUtil.getConfigTargetFields;
import static io.protostuff.fbsgen.compiler.registry.QueryUtil.getUusvFields;
import static io.protostuff.fbsgen.compiler.registry.QueryUtil.getUusvForeignFields;
import static io.protostuff.fbsgen.compiler.registry.QueryUtil.getUusvIdxCsv;
import static io.protostuff.fbsgen.compiler.registry.QueryUtil.getUusvIdxString;
import io.protostuff.fbsgen.compiler.ErrorUtil;
import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.compiler.registry.Config;
import io.protostuff.fbsgen.compiler.registry.EntityUtil;
import io.protostuff.fbsgen.compiler.registry.Verbs;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.EnumField;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.MessageField;
import io.protostuff.fbsgen.parser.Proto;
import io.protostuff.fbsgen.parser.Service.RpcMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A map that retrieves any value from any param.
 * 
 * @author David Yu
 * @created Apr 9, 2013
 */
public final class GetMap extends FakeMap
{
    
    public interface Function
    {
        Object get(Object data);
    }

    public final Function func;
    
    public GetMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.get(key);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    public enum Functions implements Function
    {
        SIZE
        {
            public Object get(Object data)
            {
                return data instanceof Map ? ((Map<?,?>)data).size() : 
                    ((Collection<?>)data).size();
            }
        },
        
        FIRST
        {
            public Object get(Object data)
            {
                return data instanceof Map ? ((Map<?,?>)data).values().iterator().next() : 
                    ((Collection<?>)data).iterator().next();
            }
        },
        
        CSV_SPLIT
        {
            public Object get(Object data)
            {
                return data == null ? Collections.EMPTY_LIST : Arrays.asList(COMMA.split(data.toString()));
            }
        },
        
        OP_PKG
        {
            public Object get(Object data)
            {
                Proto proto = (Proto)data;
                String opPkg = proto.getExtraOption("op_pkg");
                if (opPkg == null)
                    return proto.getJavaPackageName();
                
                if (opPkg.charAt(0) == '.')
                    return proto.getJavaPackageName() + opPkg;
                
                return opPkg;
            }
        },
        
        VIEW_PKG
        {
            public Object get(Object data)
            {
                Proto proto = (Proto)data;
                String viewPkg = proto.getExtraOption("view_pkg");
                if (viewPkg == null)
                    return proto.getJavaPackageName();
                
                if (viewPkg.charAt(0) == '.')
                    return proto.getJavaPackageName() + viewPkg;
                
                return viewPkg;
            }
        },
        
        VERB_VIEW
        {
            public Object get(Object data)
            {
                RpcMethod rm = (RpcMethod)data;
                String name = rm.getName();
                
                if (name.startsWith("get"))
                    return Verbs.View.GET;
                
                if (name.startsWith("list"))
                    return Verbs.View.LIST;
                
                if (name.startsWith("find"))
                    return Verbs.View.FIND;
                
                if (name.charAt(0) == 'q' && Verbs.isUppercase(name.charAt(1)))
                    return Verbs.View.Q;
                
                return null;
            }
        },
        
        VERB_OP
        {
            public Object get(Object data)
            {
                RpcMethod rm = (RpcMethod)data;
                String name = rm.getName();
                
                if (name.startsWith("new"))
                    return Verbs.Op.NEW;
                
                if (name.startsWith("update"))
                    return Verbs.Op.UPDATE;
                
                if (name.startsWith("delete"))
                    return Verbs.Op.DELETE;
                
                if (name.startsWith("mark"))
                    return Verbs.Op.MARK;
                
                return null;
            }
        },
        
        CONFIG
        {
            public Object get(Object data)
            {
                return data == null ? null : Config.getConfig((EnumGroup)data);
            }
        },
        
        ENTITY_PARENT
        {
            public Object get(Object data)
            {
                return EntityUtil.getEntityParent((Message)data);
            }
        },
        
        ENTITY_ROOT
        {
            public Object get(Object data)
            {
                return EntityUtil.getEntityRoot((Message)data);
            }
        },
        
        ENTITY_ROOT_IF_NESTED
        {
            public Object get(Object data)
            {
                return EntityUtil.getEntityRootIfNested((Message)data);
            }
        },
        
        ENTITY_RPC_RETURN_TYPE
        {
            public Object get(Object data)
            {
                RpcMethod rm = (RpcMethod)data;
                Message message = rm.getReturnType();
                
                if (IsMessageMap.Functions.ENTITY.query(message))
                    return message;
                
                if (message.getName().equals("PList"))
                {
                    Message parent = message.getParentMessage();
                    if (IsMessageMap.Functions.ENTITY.query(parent))
                        return parent;
                }
                
                return null;
            }
        },
        
        ENTITY_IDX_ID
        {
            public Object get(Object obj)
            {
                Config.Value v = (Config.Value)obj;
                final boolean tag = v.getNumber() < 224;
                
                final StringBuilder sb = new StringBuilder();
                int start = 0;
                if (tag)
                {
                    // tag idx
                    if (v.getEntries().isEmpty())
                    {
                        throw err("The tag (1-223) index entry: " + 
                                v.getEg().getRelativeName() + "." + v.getName() + 
                                " must have an option f0 that points to a tag.", v.getV());
                    }
                    
                    Config.Value.Entry entry = v.getEntries().get(start++);
                    EnumGroup.Value ev = ((EnumField)entry.getField()).getEv();
                    
                    sb.append(ev.getEg().getRelativeName())
                        .append('.')
                        .append(ev.getName());
                    
                    if (0 == (v.getEntrySize() - start))
                        return sb.toString();
                }
                else
                {
                    // entity idx
                    sb.append("IDX_").append(v.getName());
                    
                    if (v.getEntries().isEmpty())
                        return sb.toString();
                }
                
                sb.append(", 0");
                
                for (int i = start, len = v.getEntrySize(); i < len; i++)
                {
                    Config.Value.Entry entry = v.getEntries().get(i);
                    EnumGroup.Value ev = ((EnumField)entry.getField()).getEv();
                    
                    sb.append(", ")
                        .append(ev.getEg().getRelativeName())
                        .append('.')
                        .append(ev.getName());
                }
                
                return sb.append(", 0").toString();
            }
        },
        
        ENTITY_IDX_STRING
        {
            public Object get(Object obj)
            {
                if (obj instanceof EnumGroup.Value)
                {
                    EnumGroup.Value v = (EnumGroup.Value)obj;
                    
                    return getUusvIdxString(v.getNumber() < 224, 
                            v, v.getEnumGroup().getParentMessage());
                }
                
                Config.Value v = (Config.Value)obj;
                
                return getUusvIdxString(v.getNumber() < 224, 
                        v.getV(), v.getEnumGroup().getParentMessage());
            }
        },
        
        ENTITY_IDX_CSV
        {
            public Object get(Object obj)
            {
                if (obj instanceof EnumGroup.Value)
                {
                    EnumGroup.Value v = (EnumGroup.Value)obj;
                    
                    return getUusvIdxCsv(v.getNumber() < 224, 
                            v, v.getEnumGroup().getParentMessage());
                }
                
                Config.Value v = (Config.Value)obj;
                
                return getUusvIdxCsv(v.getNumber() < 224, 
                        v.getV(), v.getEnumGroup().getParentMessage());
            }
        },
        
        ENTITY_IDX_FIELDS
        {
            public Object get(Object obj)
            {
                if (obj instanceof EnumGroup.Value)
                {
                    EnumGroup.Value v = (EnumGroup.Value)obj;
                    
                    return getUusvFields(v.getNumber() < 224, 
                            v, v.getEnumGroup().getParentMessage());
                }
                
                Config.Value v = (Config.Value)obj;
                
                return getUusvFields(v.getNumber() < 224, 
                        v.getV(), v.getEnumGroup().getParentMessage());
            }
        },
        
        ENTITY_IDX_FOREIGN_FIELDS
        {
            public Object get(Object obj)
            {
                if (obj instanceof EnumGroup.Value)
                {
                    EnumGroup.Value v = (EnumGroup.Value)obj;
                    
                    return getUusvForeignFields(v.getNumber() < 224, 
                            v, v.getEnumGroup().getParentMessage());
                }
                
                Config.Value v = (Config.Value)obj;
                
                return getUusvForeignFields(v.getNumber() < 224, 
                        v.getV(), v.getEnumGroup().getParentMessage());
            }
        },
        
        CONFIG_FIELDS
        {
            public Object get(Object obj)
            {
                if (obj instanceof EnumGroup.Value)
                    return getConfigTargetFields((EnumGroup.Value)obj, "f", false);
                
                if (obj instanceof Field<?>)
                    return getConfigTargetFields((Field<?>)obj, "f", false);
                
                throw err("Codegen error calling get_config_fields.(x) where x is" + 
                        obj.getClass().getSimpleName(), getProto(obj));
            }
        },
        
        PREFIX_CONFIG_FIELDS
        {
            public Object get(Object obj)
            {
                if (obj instanceof EnumGroup.Value)
                    return getConfigTargetFields((EnumGroup.Value)obj, "f", true);
                
                if (obj instanceof Field<?>)
                    return getConfigTargetFields((Field<?>)obj, "f", true);
                
                throw err("Codegen error calling get_config_fields.(x) where x is" + 
                        obj.getClass().getSimpleName(), getProto(obj));
            }
        },
        
        MAP_CONFIG_FIELDS
        {
            public Object get(Object obj)
            {
                if (obj instanceof EnumGroup)
                    return getConfigTargetFieldMap((EnumGroup)obj, "f", false);
                
                if (obj instanceof Message)
                    return getConfigTargetFieldMap((Message)obj, "f", false);
                
                throw err("Codegen error calling get_map_config_fields.(x) where x is" + 
                        obj.getClass().getSimpleName(), getProto(obj));
            }
        },
        
        MAP_PREFIX_CONFIG_FIELDS
        {
            public Object get(Object obj)
            {
                if (obj instanceof EnumGroup)
                    return getConfigTargetFieldMap((EnumGroup)obj, "f", true);
                
                if (obj instanceof Message)
                    return getConfigTargetFieldMap((Message)obj, "f", true);
                
                throw err("Codegen error calling get_map_config_fields.(x) where x is" + 
                        obj.getClass().getSimpleName(), getProto(obj));
            }
        },
        
        MAP_ENTITY_FIELD_VALUE_OFFSET
        {
            public Object get(Object obj)
            {
                Message message = (Message)obj;
                
                List<Field<?>> sortedFields = message.getFields();
                
                LinkedHashMap<Integer,Field<?>> offsets = 
                        new LinkedHashMap<Integer,Field<?>>(sortedFields.size());
                
                //int lastOffset = 0;
                //Field<?> lastField = null;
                for (int i = sortedFields.size(); i-- > 0;)
                {
                    Field<?> f = sortedFields.get(i);
                    Integer vo = (Integer)f.getOptions().get("~vo");
                    if (vo == null)
                        break;
                    
                    offsets.put(vo, f);
                    /*if (f.isBoolField() || CodegenUtil.isOneByte(f))
                    {
                        if (lastField == null)
                            lastOffset = 1;
                        else
                            lastOffset = 1 + EntityUtil.sizeOf(lastField.getNumber()) + lastOffset;
                        
                        lastField = f;
                        offsets.put(lastOffset, f);
                        
                        continue;
                    }
                    
                    if (f instanceof Field.Fixed32 
                            || f instanceof Field.SFixed32 
                            || f instanceof Field.Float)
                    {
                        if (lastField == null)
                            lastOffset = 4;
                        else
                            lastOffset = 4 + EntityUtil.sizeOf(lastField.getNumber()) + lastOffset;
                        
                        lastField = f;
                        offsets.put(lastOffset, f);
                        
                        continue;
                    }
                    
                    if (f instanceof Field.Fixed64 
                            || f instanceof Field.SFixed64
                            || f instanceof Field.Double)
                    {
                        if (lastField == null)
                            lastOffset = 8;
                        else
                            lastOffset = 8 + EntityUtil.sizeOf(lastField.getNumber()) + lastOffset;
                        
                        lastField = f;
                        offsets.put(lastOffset, f);
                        
                        continue;
                    }
                    
                    if (f.isBytesField() && f.getName().endsWith("key"))
                    {
                        if (lastField == null)
                            lastOffset = 9;
                        else
                            lastOffset = 9 + EntityUtil.sizeOf(lastField.getNumber()) + lastOffset;
                        
                        lastField = f;
                        offsets.put(lastOffset, f);
                        
                        lastOffset++; // adjustment because of the length delimiter
                        
                        continue;
                    }
                    
                    break;*/
                }
                
                return offsets;
            }
        },
        FIELD_ACCESS_BITS
        {
            public Object get(Object data)
            {
                int result = 0;
                Field<?> f = (Field<?>)data;
                
                if (Boolean.TRUE.equals(f.getOption("readonly")))
                    result |= 1;
                if (Boolean.TRUE.equals(f.getOption("provided")))
                    result |= 2;
                if (Boolean.TRUE.equals(f.getOption("immutable")))
                    result |= 4;
                
                return result;
            }
        },
        SORTED_DISPLAY_FIELDS
        {
            @SuppressWarnings("unchecked")
            public Object get(Object data)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>((List<Field<?>>)data);
                Collections.sort(list, FilterMap.DISPLAY_ORDER_COMPARATOR);
                return list;
            }
        },
        
        FIELD_TYPE
        {
            public Object get(Object data)
            {
                Field<?> f = (Field<?>)data;
                if (f.isBytesField())
                {
                    Message message;
                    Annotation key = f.getAnnotation("Key");
                    if (key == null || (message = key.getValue("entity")) == null)
                    {
                        throw err("The field: " + f.getName() + " of " + 
                                f.getOwner().getRelativeName() + 
                                " must be annotated with @Key(entity = SomeEntity)", 
                                f.getProto());
                    }
                    
                    return message;
                }
                
                if (!f.isMessageField())
                    return null;
                
                // TODO
                //Message message = ((MessageField)f).getMessage();
                
                
                return null;
            }
        },
        
        HASID_FIELD
        {
            public Object get(Object data)
            {
                MessageField f = (MessageField)data;
                Message m = f.getMessage();
                Annotation a = m.getAnnotation("HasId");
                String f0 = a.getValue("f0");
                
                return f0 != null ? m.getField(f0) : m.getField("id");
            }
        },
        
        HASKEY_FIELD
        {
            public Object get(Object data)
            {
                MessageField f = (MessageField)data;
                Message m = f.getMessage();
                Annotation a = m.getAnnotation("HasKey");
                String f0 = a.getValue("f0");
                
                return f0 != null ? m.getField(f0) : m.getField("key");
            }
        },
        
        VALIDATED_ENTITY_IDX_STRING
        {
            public Object get(Object data)
            {
                final EnumGroup.Value v = data instanceof Config.Value ? 
                        ((Config.Value)data).getV() : (EnumGroup.Value)data;
                
                final String str = getUusvIdxString(v.getNumber() < 224, 
                        v, v.getEnumGroup().getParentMessage());
                        
                final Object optionV = v.getO().get("unique_prefix");
                
                if (optionV == null)
                    return str;
                
                final int index;
                if (!(optionV instanceof Integer) || 
                        0 > (index = ((Integer)optionV).intValue()))
                {
                    throw ErrorUtil.err("The unique_prefix of " + 
                            v.getEg().getRelativeName() + "::" + v.getName() + 
                            " must be configured with a positive number (int).", 
                            v);
                }
                
                if (index >= str.length())
                {
                    throw ErrorUtil.err("The unique_prefix of " + 
                            v.getEg().getRelativeName() + "::" + v.getName() + 
                            " is out of bounds (must be less than the total fields).", 
                            v);
                }
                if ('S' != str.charAt(index))
                {
                    throw ErrorUtil.err("The unique_prefix of " + 
                            v.getEg().getRelativeName() + "::" + v.getName() + 
                            " must point to the index where the string field is.", 
                            v);
                }
                
                return str;
            }
        }
        ;
        public final GetMap map;

        private Functions()
        {
            map = new GetMap("get_" + name().toLowerCase(), this);
        }
    }
}
