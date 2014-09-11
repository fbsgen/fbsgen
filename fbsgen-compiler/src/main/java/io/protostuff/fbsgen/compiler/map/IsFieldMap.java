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
import io.protostuff.fbsgen.compiler.registry.QueryUtil;
import io.protostuff.fbsgen.parser.CodegenUtil;
import io.protostuff.fbsgen.parser.Field;

import java.util.List;

/**
 * Codegen helper for field queries.
 *
 * @author David Yu
 * @created Nov 8, 2012
 */
public final class IsFieldMap extends FakeMap
{
    
    public interface Function
    {
        boolean query(Field<?> f);
    }

    public final Function func;
    
    public IsFieldMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return key instanceof Field<?> && func.query((Field<?>)key);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    public enum Functions implements Function
    {
        BOOL_OR_ENUM
        {
            public boolean query(Field<?> f)
            {
                return f.isBoolField() || f.isEnumField();
            }
        },
        
        ONEBYTE
        {
            public boolean query(Field<?> f)
            {
                return CodegenUtil.isOneByte(f);
            }
        },
        
        DATE
        {
            public boolean query(Field<?> f)
            {
                return f instanceof Field.UInt64 && 
                        Boolean.TRUE.equals(f.getOptions().get("date"));
            }
        },
        
        DATETIME
        {
            public boolean query(Field<?> f)
            {
                return f instanceof Field.UInt64 && 
                        Boolean.TRUE.equals(f.getOptions().get("datetime"));
            }
        },
        
        DATE_OR_DATETIME
        {
            public boolean query(Field<?> f)
            {
                return f instanceof Field.UInt64 && 
                        (Boolean.TRUE.equals(f.getOptions().get("date")) || 
                        Boolean.TRUE.equals(f.getOptions().get("datetime")));
            }
        },
        
        VALIDATED
        {
            public boolean query(Field<?> f)
            {
                if (f.isRepeated() || f.isMessageField())
                    return false;
                
                return f.isOptional() && (f.getA().isEmpty() || 
                        (f.getA().size() == 1 && f.getAnnotation("Display") != null)) ? 
                                false : true;
            }
        },
        
        SINGLE_VALIDATION
        {
            public boolean query(Field<?> f)
            {
                return f.getA().size() == (f.getAnnotation("Display") == null ? 1 : 2);
            }
        },
        
        BYTES_OR_VALIDATED
        {
            public boolean query(Field<?> f)
            {
                return f.isBytesField() || VALIDATED.query(f);
            }
        },
        
        ARG_OVERLOADABLE
        {
            public boolean query(Field<?> f)
            {
                switch(QueryUtil.getFieldIdxChar(f, null, null))
                {
                    case 'D':
                    case 'S':
                        return true;
                    default: return false;
                }
            }
        },
        
        KEY
        {
            public boolean query(Field<?> f)
            {
                return f.isBytesField() && f.getName().endsWith("_key");
            }
        },
        
        KEY_OR_ENDS_WITH
        {
            public boolean query(Field<?> f)
            {
                if (!f.isBytesField())
                    return false;
                
                final String str = f.getName();
                
                return str.length() == 3 ? str.equals("key") : str.endsWith("_key");
            }
        }
        ;
        
        public final IsFieldMap map;

        private Functions()
        {
            map = new IsFieldMap("is_field_" + name().toLowerCase(), this);
        }
    }
}
