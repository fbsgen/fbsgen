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
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    
    public final Function func;
    
    public FilterMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return key instanceof Message ? func.filter((Message)key) : 
            Collections.EMPTY_LIST;
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    public enum Functions implements Function
    {
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
        // not repeated, not a message
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
        DISPLAY_ORDER_FIELDS
        {
            public Collection<Field<?>> filter(Message message)
            {
                ArrayList<Field<?>> list = new ArrayList<Field<?>>(message.getFields());
                
                Collections.sort(list, DISPLAY_ORDER_COMPARATOR);
                
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
