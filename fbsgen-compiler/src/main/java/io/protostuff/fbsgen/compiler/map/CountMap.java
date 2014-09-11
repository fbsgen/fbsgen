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

import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.EnumField;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;

import java.util.List;

/**
 * Codegen helper for counting the filtered fields.
 *
 * @author David Yu
 * @created Dec 24, 2011
 */
public final class CountMap extends FakeMap
{
    
    public interface Function
    {
        int count(Message message);
    }
    
    public final Function func;
    
    public CountMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }

    public Object get(Object key)
    {
        return Integer.valueOf(key instanceof Message ? func.count((Message)key) : 0);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    public enum Functions implements Function
    {
        
        // hack ... returns the entity kind or zero if its not an entity.
        ENTITY_KIND
        {
            public int count(Message message)
            {
                final Annotation entity = message.getAnnotationMap().get("Entity");
                final Integer kind = entity == null ? 
                        (Integer)message.getOptions().get("entity.kind") : 
                            (Integer)entity.getValue("kind");
                
                return kind == null ? 0 : kind.intValue();
            }
        },
        
        ENTITY_FIELDS
        {
            public int count(Message message)
            {
                int found = 0;
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() > 2)
                        found++;
                }
                
                return found;
            }
        },
        
        ENTITY_IMMUTABLE_FIELDS
        {
            public int count(Message message)
            {
                int found = 0;
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() > 2 && Boolean.TRUE.equals(f.getOption("immutable")))
                        found++;
                }
                
                return found;
            }
        },
        PROVIDED_FIELDS
        {
            public int count(Message message)
            {
                int found = 0;
                for (Field<?> f : message.getFields())
                {
                    if (Boolean.TRUE.equals(f.getOption("provided")))
                        found++;
                }
                
                return found;
            }
        },
        READONLY_FIELDS
        {
            public int count(Message message)
            {
                int found = 0;
                for (Field<?> f : message.getFields())
                {
                    if (Boolean.TRUE.equals(f.getOption("readonly")))
                        found++;
                }
                
                return found;
            }
        },
        /*INDEX_FIELDS
        {
            public int count(Message message)
            {
                int found = 0;
                for (Field<?> f : message.getFields())
                {
                    if (Boolean.TRUE.equals(f.getOption("index")))
                        found++;
                }
                
                return found;
            }
        },*/
        FORM_FIELDS
        {
            public int count(Message message)
            {
                return message.getSingularFieldCount() - message.getSingularBytesFieldCount();
            }
        },
        FORM_SCALAR_FIELDS
        {
            public int count(Message message)
            {
                return message.getSingularFieldCount() - message.getSingularBytesFieldCount() - message.getSingularMessageFieldCount();
            }
        },
        ENTITY_FORM_FIELDS
        {
            public int count(Message message)
            {
                return message.getSingularFieldCount() - message.getSingularBytesFieldCount() - 2;
            }
        },
        ENTITY_FORM_SCALAR_FIELDS
        {
            public int count(Message message)
            {
                return message.getSingularFieldCount() - message.getSingularBytesFieldCount() - message.getSingularMessageFieldCount() - 2;
            }
        },
        ENTITY_SCALAR_FIELDS
        {
            public int count(Message message)
            {
                return message.getSingularFieldCount() - message.getSingularMessageFieldCount() - 2;
            }
        },
        
        // extras
        
        ENTITY_ONE_BYTE_VALUE
        {
            public int count(Message message)
            {
                int count = 0;
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3)
                        continue;
                    
                    if (Field.UInt32.class.isAssignableFrom(f.getClass()))
                    {
                        // uint32 field with the option: [onebyte = true]
                        if (Boolean.TRUE.equals(f.getOption("onebyte")))
                            count++;
                    }
                    else if (f.isEnumField() && 
                            null != ((EnumField)f).getEnumGroup().getAnnotation("OneByte"))
                    {
                        // links to an enum with the annotation: @OneByte
                        count++;
                    }
                }
                
                return count;
            }
        },
        
        ENTITY_DATE_OR_DATETIME
        {
            public int count(Message message)
            {
                int count = 0;
                for (Field<?> f : message.getFields())
                {
                    if (f.getNumber() < 3)
                        continue;
                    
                    // fixed64 fields with the option: [date = true] or [datetime = true]
                    if (Field.UInt64.class.isAssignableFrom(f.getClass()) && 
                            (Boolean.TRUE.equals(f.getOption("date")) || 
                                    Boolean.TRUE.equals(f.getOption("datetime"))))
                    {
                        count++;
                    }
                }
                
                return count;
            }
        },
        
        FIRST_FIELD_CHAR_LEN
        {
            public int count(Message message)
            {
                return message.getFields().get(0).getName().length();
            }
        },
        FORM_KEY_FIELDS
        {
            public int count(Message message)
            {
                int count = 0;
                for (Field<?> f : message.getFields())
                {
                    if (f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly")))
                    {
                        count++;
                    }
                }
                
                return count;
            }
        },
        FORM_NEW_KEY_FIELDS
        {
            public int count(Message message)
            {
                int count = 0;
                for (Field<?> f : message.getFields())
                {
                    if (f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly"))
                            && !Boolean.TRUE.equals(f.getOption("provided")))
                    {
                        count++;
                    }
                }
                
                return count;
            }
        },
        FORM_UPDATE_KEY_FIELDS
        {
            public int count(Message message)
            {
                int count = 0;
                for (Field<?> f : message.getFields())
                {
                    if (f.isBytesField() && f.getName().endsWith("_key") 
                            && !Boolean.TRUE.equals(f.getOption("readonly"))
                            && !Boolean.TRUE.equals(f.getOption("immutable")))
                    {
                        count++;
                    }
                }
                
                return count;
            }
        }
        ;
        
        public final CountMap map;

        private Functions()
        {
            map = new CountMap("count_" + name().toLowerCase(), this);
        }

    }

    
}