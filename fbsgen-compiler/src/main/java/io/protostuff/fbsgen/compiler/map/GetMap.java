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

import static io.protostuff.fbsgen.compiler.CompilerUtil.$int;
import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.compiler.JetGroup;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.MessageField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
    
    /*public static void main(String[] args)
    {
        int x = 8;
        System.err.println(Functions.BIT_POT_INDEX.get(x));
        // 3
    }*/
    
    // struct padding fields that can be checked via "field.repeated"
    static final class Int8 extends Field.Int8
    {
        Int8(int id)
        {
            this.name = "padding" + id;
        }
        @Override
        public boolean isRepeated()
        {
            return true;
        }
    }
    static final class Int16 extends Field.Int16
    {
        Int16(int id)
        {
            this.name = "padding" + id;
        }
        @Override
        public boolean isRepeated()
        {
            return true;
        }
    }
    static final class Int32 extends Field.Int32
    {
        Int32(int id)
        {
            this.name = "padding" + id;
        }
        @Override
        public boolean isRepeated()
        {
            return true;
        }
    }
    
    enum PadType
    {
        I8
        {
            @Override
            Field<?> create(int id)
            {
                return new Int8(id);
            }
        },
        I16
        {
            @Override
            Field<?> create(int id)
            {
                return new Int16(id);
            }
        },
        I32
        {
            @Override
            Field<?> create(int id)
            {
                return new Int32(id);
            }
        }
        ;
        
        abstract Field<?> create(int id);
    }
    
    static final class StructMetadata
    {
        final int minAlign, sizeOf;
        final ArrayList<Field<?>> fields, paddedFields;
        
        public StructMetadata(int minAlign, int sizeOf, 
                ArrayList<Field<?>> fields, ArrayList<Field<?>> paddedFields)
        {
            this.minAlign = minAlign;
            this.sizeOf = sizeOf;
            this.fields = fields;
            this.paddedFields = paddedFields;
        }
        
        public int getMinAlign()
        {
            return minAlign;
        }
        
        public int getSizeOf()
        {
            return sizeOf;
        }
        
        public ArrayList<Field<?>> getFields()
        {
            return fields;
        }
        
        public ArrayList<Field<?>> getPaddedFields()
        {
            return paddedFields;
        }
    }
    
    static final class FakeField extends Field<Object>
    {
        final java.lang.String fbsType;

        FakeField(java.lang.String fbsType)
        {
            this.fbsType = fbsType;
        }
        
        @Override
        public java.lang.String getJavaType()
        {
            return "fake";
        }

        @Override
        public java.lang.String getFbsType()
        {
            return fbsType;
        }
        
    }
    
    static void addTo(ArrayList<Field<?>> fl, ArrayList<Field<?>> pfl, PadType type)
    {
        if (fl != null)
        {
            Field<?> f = type.create(pfl.size());
            fl.add(f);
            pfl.add(f);
        }
    }
    
    static int padIfNecessary(int sizeOf, int alignment, 
            int current, ArrayList<Field<?>> fl, ArrayList<Field<?>> pfl)
    {
        int plusPO2 = current + alignment, 
                boundary = plusPO2 - (plusPO2 % alignment), 
                remaining = boundary - current;
        
        switch (remaining)
        {
            case 1: // 1
                addTo(fl, pfl, PadType.I8);
                break;
            case 2: 
                if (sizeOf == 0 || sizeOf > remaining) // 2
                    addTo(fl, pfl, PadType.I16);
                else
                    remaining = 0;
                
                break;
            case 3: 
                if (sizeOf == 0 || sizeOf > remaining) // 1, 2
                {
                    addTo(fl, pfl, PadType.I8);
                    addTo(fl, pfl, PadType.I16);
                }
                else if (sizeOf != 1)
                {
                    addTo(fl, pfl, PadType.I8);
                    remaining = 1;
                }
                else
                {
                    remaining = 0;
                }
                break;
            case 4: 
                if (sizeOf == 0 || sizeOf > remaining) // 4
                    addTo(fl, pfl, PadType.I32);
                else
                    remaining = 0;
                break;
            case 5: 
                if (sizeOf == 0 || sizeOf > remaining) // 1, 4
                {
                    addTo(fl, pfl, PadType.I8);
                    addTo(fl, pfl, PadType.I32);
                }
                else if (sizeOf != 1)
                {
                    addTo(fl, pfl, PadType.I8);
                    remaining = 1;
                }
                else
                {
                    remaining = 0;
                }
                break;
            case 6: 
                if (sizeOf == 0 || sizeOf > remaining) // 2, 4
                {
                    addTo(fl, pfl, PadType.I16);
                    addTo(fl, pfl, PadType.I32);
                }
                else if (sizeOf == 4)
                {
                    addTo(fl, pfl, PadType.I16);
                    remaining = 2;
                }
                else
                {
                    remaining = 0;
                }
                break;
            case 7: 
                if (sizeOf == 0 || sizeOf > remaining) // 1, 2, 4
                {
                    addTo(fl, pfl, PadType.I8);
                    addTo(fl, pfl, PadType.I16);
                    addTo(fl, pfl, PadType.I32);
                }
                else if (sizeOf == 4)
                {
                    addTo(fl, pfl, PadType.I8);
                    addTo(fl, pfl, PadType.I16);
                    remaining = 3;
                }
                else if (sizeOf == 2)
                {
                    addTo(fl, pfl, PadType.I8);
                    remaining = 1;
                }
                else
                {
                    remaining = 0;
                }
                break;
            default:
                throw new RuntimeException("Should not happen.");
        }
        
        return remaining + sizeOf;
    }
    
    static StructMetadata getStructMetadata(Message message, 
            ArrayList<Field<?>> fl, ArrayList<Field<?>> pfl)
    {
        int minAlign = message.getMinAlign();
        int current = 0;
        for (int i = 0, sizeOf = 0, sizeOfCount = 0, 
                fieldCount = message.getFieldCount(); i < fieldCount; i++)
        {
            final Field<?> field = message.getFields().get(i);
            if (field.isMessageField())
            {
                StructMetadata md = getStructMetadata(
                        ((MessageField)field).getMessage(), null, null);
                minAlign = Math.max(minAlign, md.minAlign);
                sizeOf = md.getSizeOf();
            }
            else
            {
                sizeOf = message.getSizeofValues().get(sizeOfCount++);
            }
            
            if (current % 8 == 0 || (current + sizeOf) % 8 == 0)
                current += sizeOf;
            else
                current += padIfNecessary(sizeOf, 8, current, fl, pfl);
            
            if (fl != null)
                fl.add(field);
        }
        
        if (current % minAlign != 0)
            current += padIfNecessary(0, minAlign, current, fl, pfl);
        
        if (message.getForceAlign() > minAlign)
            minAlign = message.getForceAlign();
        
        return new StructMetadata(minAlign, current, fl, pfl);
    }
    
    public enum Functions implements Function
    {
        /**
         * bit power-of-two shift number.
         */
        BIT_POT_SHIFTNUM
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_bit_pot_shiftnum($int(data));
            }
        },
        
        SPARSE_ENUM_VALUE_NAMES
        {
            public Object get(Object data)
            {
                final EnumGroup eg = (EnumGroup)data;
                final ArrayList<String> list = new ArrayList<String>();
                
                final ArrayList<EnumGroup.Value> values = eg.getValues();
                int j = 0;
                EnumGroup.Value v = values.get(j++);
                list.add(v.getName());
                
                for (int i = v.getNumber(), 
                        len = values.get(values.size() - 1).getNumber(); 
                        i < len; i++)
                {
                    v = values.get(j);
                    if (i == (v.getNumber() - 1))
                    {
                        list.add(v.getName());
                        j++;
                    }
                    else
                    {
                        list.add("");
                    }
                }
                
                return list;
            }
        },
        
        PB_FIELD_TYPE
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_pb_field_type((Field<?>)data);
            }
        },
        
        FBS_FIELD_OFFSET
        {
            public Object get(Object data)
            {
                return 4 + (($int(data) - 1) << 1);
            }
        },
        
        FBS_INT_TYPE
        {
            public Object get(Object data)
            {
                return Field.fbsIntType((String)data);
            }
        },
        
        FBS_MESSAGE_TYPE
        {
            public Object get(Object data)
            {
                return JetGroup.Base.get_fbs_message_type((Message)data);
            }
        },
        
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
        
        STRUCT_MD
        {
            public Object get(Object data)
            {
                return getStructMetadata((Message)data, new ArrayList<Field<?>>(), 
                        new ArrayList<Field<?>>());
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
