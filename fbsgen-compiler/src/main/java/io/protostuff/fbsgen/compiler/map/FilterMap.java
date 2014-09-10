//================================================================================
//Copyright (c) 2011, David Yu
//All rights reserved.
//--------------------------------------------------------------------------------
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
// 1. Redistributions of source code must retain the above copyright notice,
//    this list of conditions and the following disclaimer.
// 2. Redistributions in binary form must reproduce the above copyright notice,
//    this list of conditions and the following disclaimer in the documentation
//    and/or other materials provided with the distribution.
// 3. Neither the name of protostuff nor the names of its contributors may be used
//    to endorse or promote products derived from this software without
//    specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.
//================================================================================


package io.protostuff.fbsgen.compiler.map;

import static io.protostuff.fbsgen.compiler.ErrorUtil.err;
import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.compiler.TemplateGroup;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Codegen helper for filtering fields.
 *
 * @author David Yu
 * @created Dec 25, 2011
 */
public final class FilterMap extends FakeMap
{
    
    static final Comparator<Field<?>> DISPLAY_ORDER_COMPARATOR = 
            new Comparator<Field<?>>()
    {
        public int compare(Field<?> f1, Field<?> f2)
        {
            Annotation a1 = f1.getAnnotation("Display");
            Annotation a2 = f2.getAnnotation("Display");
            
            if (a1 == null)
            {
                return a2 != null && a2.getValue("order") != null ? 1 : 
                    f1.getNumber() - f2.getNumber();
            }
            
            if (a2 == null)
            {
                return a1.getValue("order") != null ? -1 : 
                    f1.getNumber() - f2.getNumber();
            }
            
            Integer o1 = a1.getValue("order");
            Integer o2 = a2.getValue("order");
            if (o1 == null)
                return o2 != null ? 1 : f1.getNumber() - f2.getNumber();
            
            if (o2 == null)
                return -1;
            
            int diff = o1 - o2;
            return diff != 0 ? diff : f1.getNumber() - f2.getNumber();
        }
    };
    
    public interface Function
    {
        Collection<Field<?>> filter(Message message);
    }
    
    public final String id;
    public final Function func;
    
    public FilterMap(String id, Function func)
    {
        this.id = id;
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return key instanceof Message ? func.filter((Message)key) : 
            Collections.EMPTY_LIST;
    }
    
    public static void addAllTo(TemplateGroup group)
    {
        for (Functions f : Functions.values())
            group.put(f.map.id, f.map);
    }
    
    public enum Functions implements Function
    {
        
        NOT_REPEATED_MESSAGE_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() || !f.isMessageField())
                        list.add(f);
                }
                
                return list;
            }
        },
        REQUIRED_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.isRequired())
                        list.add(f);
                }
                
                return list;
            }
        },
        SINGULAR_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated())
                        list.add(f);
                }
                
                return list;
            }
        },
        SINGULAR_FIELDS_BOOL
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isBoolField())
                        list.add(f);
                }
                
                return list;
            }
        },
        FORM_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && !f.isBytesField() && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        FORM_DISPLAY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && !f.isBytesField() && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                Collections.sort(list, DISPLAY_ORDER_COMPARATOR);
                
                return list;
            }
        },
        FORM_MESSAGE_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isMessageField() 
                            && !Boolean.TRUE.equals(f.getOption("readonly")))
                    {
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        FORM_NEW_MESSAGE_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isMessageField() 
                            && !Boolean.TRUE.equals(f.getOption("readonly"))
                            && !Boolean.TRUE.equals(f.getOption("provided")))
                    {
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        FORM_SCALAR_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && !f.isBytesField() && !f.isMessageField() && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        FORM_VALIDATED_SCALAR_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.isRepeated() || f.isBytesField() || f.isMessageField() || Boolean.TRUE.equals(f.getOption("readonly")))
                        continue;
                    
                    if (f.isOptional() && (f.getA().isEmpty() || (f.getA().size() == 1 && f.getAnnotation("Display") != null)))
                        continue;
                    
                    list.add(f);
                }
                
                return list;
            }
        },
        FORM_SCALAR_FIELDS_INT
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isNumberField() && "int".equals(f.getJavaType()) && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        FORM_SCALAR_FIELDS_LONG
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isNumberField() && "long".equals(f.getJavaType()) && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        FORM_SCALAR_FIELDS_FLOAT
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f instanceof Field.Float && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        FORM_SCALAR_FIELDS_DOUBLE
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f instanceof Field.Double && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        FORM_SCALAR_FIELDS_STRING
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isStringField() && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        FORM_SCALAR_FIELDS_BOOLEAN
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isBoolField() && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        
        ENTITY_VALIDATED_SINGULAR_SCALAR_FIELDS_INT
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3)
                        continue;
                    
                    if (!f.isRepeated() && f.isNumberField() && "int".equals(f.getJavaType()) && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_MUTABLE_VALIDATED_SINGULAR_SCALAR_FIELDS_INT
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3 || Boolean.TRUE.equals(f.getOption("immutable")))
                        continue;
                    
                    if (!f.isRepeated() && f.isNumberField() && "int".equals(f.getJavaType()) && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_VALIDATED_SINGULAR_SCALAR_FIELDS_LONG
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3)
                        continue;
                    
                    if (!f.isRepeated() && f.isNumberField() && "long".equals(f.getJavaType()) && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_MUTABLE_VALIDATED_SINGULAR_SCALAR_FIELDS_LONG
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3 || Boolean.TRUE.equals(f.getOption("immutable")))
                        continue;
                    
                    if (!f.isRepeated() && f.isNumberField() && "long".equals(f.getJavaType()) && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_VALIDATED_SINGULAR_SCALAR_FIELDS_FLOAT
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3)
                        continue;
                    
                    if (!f.isRepeated() && f instanceof Field.Float && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_MUTABLE_VALIDATED_SINGULAR_SCALAR_FIELDS_FLOAT
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3 || Boolean.TRUE.equals(f.getOption("immutable")))
                        continue;
                    
                    if (!f.isRepeated() && f instanceof Field.Float && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_VALIDATED_SINGULAR_SCALAR_FIELDS_DOUBLE
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3)
                        continue;
                    
                    if (!f.isRepeated() && f instanceof Field.Double && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_MUTABLE_VALIDATED_SINGULAR_SCALAR_FIELDS_DOUBLE
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3 || Boolean.TRUE.equals(f.getOption("immutable")))
                        continue;
                    
                    if (!f.isRepeated() && f instanceof Field.Double && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_VALIDATED_SINGULAR_SCALAR_FIELDS_STRING
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3)
                        continue;
                    
                    if (!f.isRepeated() && f.isStringField() && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_MUTABLE_VALIDATED_SINGULAR_SCALAR_FIELDS_STRING
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3 || Boolean.TRUE.equals(f.getOption("immutable")))
                        continue;
                    
                    if (!f.isRepeated() && f.isStringField() && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_VALIDATED_SINGULAR_SCALAR_FIELDS_BOOLEAN
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3)
                        continue;
                    
                    if (!f.isRepeated() && f.isBoolField() && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_MUTABLE_VALIDATED_SINGULAR_SCALAR_FIELDS_BOOLEAN
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3 || Boolean.TRUE.equals(f.getOption("immutable")))
                        continue;
                    
                    if (!f.isRepeated() && f.isBoolField() && !f.getA().isEmpty())
                    {
                        if (f.getA().size() == 1 && f.getAnnotation("Display") != null)
                            continue;
                        
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        
        ENTITY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() > 2)
                        list.add(f);
                }
                
                return list;
            }
        },
        ENTITY_FORM_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() > 2 && !f.isRepeated() && !f.isBytesField() && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        ENTITY_FORM_DISPLAY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() > 2 && !f.isRepeated() && !f.isBytesField() && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                Collections.sort(list, DISPLAY_ORDER_COMPARATOR);
                
                return list;
            }
        },
        ENTITY_FORM_SCALAR_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() > 2 && !f.isRepeated() && !f.isBytesField() && !f.isMessageField() && !Boolean.TRUE.equals(f.getOption("readonly")))
                        list.add(f);
                }
                
                return list;
            }
        },
        ENTITY_FORM_VALIDATED_SCALAR_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3 || f.isRepeated() || f.isBytesField() || f.isMessageField() || Boolean.TRUE.equals(f.getOption("readonly")))
                        continue;
                    
                    if (f.isOptional() && (f.getA().isEmpty() || (f.getA().size() == 1 && f.getAnnotation("Display") != null)))
                        continue;
                    
                    list.add(f);
                }
                
                return list;
            }
        },
        ENTITY_OPTIONAL_NON_DVOOR_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() > 2 && f.isOptional() && !Boolean.TRUE.equals(f.getOption("dvoor")))
                        list.add(f);
                }
                
                return list;
            }
        },
        ENTITY_PROVIDED_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (Boolean.TRUE.equals(f.getOption("provided")))
                    {
                        if (!f.isOptional())
                        {
                            throw err(f.getName() + 
                                    " of " + message.getRelativeName() + 
                                    " must be optional when it is provided.", message);
                        }
                        
                        if (f.getNumber() > 2)
                            list.add(f);
                    }
                }
                
                return list;
            }
        },
        ENTITY_MUTABLE_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3 || f.isRepeated() || f.isMessageField() || Boolean.TRUE.equals(f.getOption("immutable")))
                        continue;
                    
                    list.add(f);
                }
                
                return list;
            }
        },
        ENTITY_MUTABLE_ENUM_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3 || f.isRepeated() || !f.isEnumField() || Boolean.TRUE.equals(f.getOption("immutable")))
                        continue;
                    
                    list.add(f);
                }
                
                return list;
            }
        },
        FORM_KEY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly")))
                    {
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        FORM_DISPLAY_KEY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly")))
                    {
                        list.add(f);
                    }
                }
                
                Collections.sort(list, DISPLAY_ORDER_COMPARATOR);
                
                return list;
            }
        },
        FORM_REQUIRED_KEY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.isRequired() && f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly")))
                    {
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        FORM_NEW_KEY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly"))
                            && !Boolean.TRUE.equals(f.getOption("provided")))
                    {
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        FORM_DISPLAY_NEW_KEY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly"))
                            && !Boolean.TRUE.equals(f.getOption("provided")))
                    {
                        list.add(f);
                    }
                }
                
                Collections.sort(list, DISPLAY_ORDER_COMPARATOR);
                
                return list;
            }
        },
        FORM_NEW_REQUIRED_KEY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.isRequired() && f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly"))
                            && !Boolean.TRUE.equals(f.getOption("provided")))
                    {
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        FORM_UPDATE_KEY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly"))
                            && !Boolean.TRUE.equals(f.getOption("immutable")))
                    {
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        FORM_UPDATE_REQUIRED_KEY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (f.isRequired() && f.isBytesField() && f.getName().endsWith("_key")
                            && !Boolean.TRUE.equals(f.getOption("readonly"))
                            && !Boolean.TRUE.equals(f.getOption("immutable")))
                    {
                        list.add(f);
                    }
                }
                
                return list;
            }
        },
        FORM_IMMUTABLE_KEY_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>();
                for (Field<?> f : message.getFields())
                {
                    if (!f.isRepeated() && f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly"))
                            && Boolean.TRUE.equals(f.getOption("immutable")))
                    {
                        list.add(f);
                    }
                }
                
                return list;
            }
        }
        ;
        
        public final FilterMap map;

        private Functions()
        {
            map = new FilterMap("filter_" + name().toLowerCase(), this);
        }
        
    }

}
