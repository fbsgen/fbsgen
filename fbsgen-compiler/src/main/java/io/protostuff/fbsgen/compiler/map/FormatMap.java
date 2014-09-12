//========================================================================
//Copyright 2012 David Yu
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

import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.parser.HasName;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Codegen helper for formatting values
 * 
 * @author David Yu
 * @created Oct 30, 2012
 */
public final class FormatMap extends FakeMap
{
    
    public interface Function
    {
        Object format(Object data);
    }

    public final Function func;
    
    public FormatMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.format(key);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    static int sizeOf(int fieldNumber)
    {
        return fieldNumber > 15 ? 2 : 1;
    }
    
    static final SimpleDateFormat ECLIPSE_DEFAULT_DATE_FORMAT = 
            new SimpleDateFormat("MMM dd, yyyy"), 
            YEAR_FORMAT = new SimpleDateFormat("yyyy");
    
    public enum Functions implements Function
    {
        TO_STRING
        {
            public Object format(Object data)
            {
                return data.toString();
            }
        },
        
        TO_CLASSNAME
        {
            public Object format(Object data)
            {
                return data.getClass().getName();
            }
        },
        
        TO_INT
        {
            public Object format(Object data)
            {
                return data instanceof Integer ? data : Integer.parseInt(data.toString());
            }
        },
        
        VIA_NAME_CSV
        {
            @SuppressWarnings("unchecked")
            public Object format(Object data)
            {
                final List<HasName> list = (List<HasName>)data;
                if (list == null || list.size() == 0)
                    return "";
                
                final StringBuilder sb = new StringBuilder()
                    // append first child
                    .append(list.get(0).getName());
                
                for (int i = 1, len = list.size(); i < len; i++)
                    sb.append(", ").append(list.get(i).getName());
                
                return sb.toString();
            }
        },
        
        DATE_TODAY
        {
            public Object format(Object data)
            {
                return ECLIPSE_DEFAULT_DATE_FORMAT.format(new Date());
            }
        },
        
        YEAR
        {
            public Object format(Object data)
            {
                return YEAR_FORMAT.format(new Date());
            }
        },
        
        PRINT_OUT
        {
            public Object format(Object data)
            {
                System.out.println(data);
                return "";
            }
        },
        
        PRINT_OUT_NAME
        {
            @SuppressWarnings("unchecked")
            public Object format(Object data)
            {
                if (data instanceof Map<?,?>)
                {
                    StringBuilder sb = new StringBuilder();
                    Collection<HasName> list = ((Map<?,HasName>)data).values();
                    for (HasName hn : list)
                        sb.append(hn.getName()).append(',').append(' ');
                    
                    System.out.println(sb.substring(0, sb.length()-2));
                }
                else if (data instanceof List<?>)
                {
                    StringBuilder sb = new StringBuilder();
                    List<HasName> list = (List<HasName>)data;
                    for (HasName hn : list)
                        sb.append(hn.getName()).append(',').append(' ');
                    
                    System.out.println(sb.substring(0, sb.length()-2));
                }
                else
                {
                    System.out.println(((HasName)data).getName());
                }
                return "";
            }
        },
        
        PRINT_ERR
        {
            public Object format(Object data)
            {
                System.err.println(data);
                return "";
            }
        },
        
        PRINT_ERR_NAME
        {
            @SuppressWarnings("unchecked")
            public Object format(Object data)
            {
                if (data instanceof Map<?,?>)
                {
                    StringBuilder sb = new StringBuilder();
                    Collection<HasName> list = ((Map<?,HasName>)data).values();
                    for (HasName hn : list)
                        sb.append(hn.getName()).append(',').append(' ');
                    
                    System.err.println(sb.substring(0, sb.length()-2));
                }
                else if (data instanceof List<?>)
                {
                    StringBuilder sb = new StringBuilder();
                    List<HasName> list = (List<HasName>)data;
                    for (HasName hn : list)
                        sb.append(hn.getName()).append(',').append(' ');
                    
                    System.err.println(sb.substring(0, sb.length()-2));
                }
                else
                {
                    System.err.println(((HasName)data).getName());
                }
                return "";
            }
        },
        ;
        
        public final FormatMap map;

        private Functions()
        {
            map = new FormatMap("format_" + name().toLowerCase(), this);
        }
    }
}
