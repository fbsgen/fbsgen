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

package io.protostuff.fbsgen.compiler;

import static io.protostuff.fbsgen.compiler.CompilerUtil.$int;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.AnnotationContainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Allows string templates to write/modify the members of this class.
 * 
 * @author David Yu
 * @created Aug 10, 2013
 */
public final class Writable
{
    static final FakeMap EMPTY = new FakeMap("EMPTY")
    {
        @Override
        public Object get(Object arg0)
        {
            return "";
        }
    };
    
    public Object key = null, val = null;
    
    public int number = 0;
    
    public final StringBuilder builder = new StringBuilder();
    
    public final ArrayList<Object> list = new ArrayList<Object>();
    
    public final LinkedHashMap<Object,Object> map = new LinkedHashMap<Object,Object>();
    
    int argCount = 0, argFalseCount = 0;
    
    /**
     * Cast the argument as integer.
     * <pre>
     *   «writable.as_int.("1")»
     * </pre>
     */
    public final FakeMap as_int = new FakeMap("as_int")
    {
        public Object get(Object entry)
        {
            return entry instanceof Integer ? entry : 
                Integer.parseInt(String.valueOf(entry));
        }
    };
    
    /**
     * Appends the arg to the string builder.
     * <pre>
     *   «writable.b.("a").b.("b").»
     * </pre>
     */
    public final FakeMap b = new FakeMap("b")
    {
        public Object get(Object arg)
        {
            if (arg != null)
                builder.append(arg.toString());
            
            return Writable.this;
        }
    };
    
    /**
     * Appends the arg to the string builder if val is truthy.
     * <pre>
     *   «writable.v.(true).b.("a").bvt.("b").»
     * </pre>
     */
    public final FakeMap bvt = new FakeMap("bvt")
    {
        public Object get(Object arg)
        {
            if (arg != null && val != null && !Boolean.FALSE.equals(val))
                builder.append(arg.toString());
            
            return Writable.this;
        }
    };
    
    /**
     * Appends the arg to the string builder if val is not truthy.
     * <pre>
     *   «writable.v.(false).b.("a").bvf.("b").»
     * </pre>
     */
    public final FakeMap bvf = new FakeMap("bvf")
    {
        public Object get(Object arg)
        {
            if (arg != null && (val == null || Boolean.FALSE.equals(val)))
                builder.append(arg.toString());
            
            return Writable.this;
        }
    };
    
    /**
     * Get the element at index from list if k was set.  Otherwise, the arg will 
     * be read as 'key.0' where 'key' is used to retrieve the list from the map 
     * and '0' is the index.
     * <pre>
     *   «writable.k.("0").get.(message.fields)»
     *   «writable.k.(1).get.(message.fields)»
     *   «(writable.get.("key.0"))»
     * </pre>
     */
    public final FakeMap get = new FakeMap("get")
    {
        @SuppressWarnings("unchecked")
        public Object get(Object entry)
        {
            if (key != null)
            {
                int index = key instanceof Number ? 
                        ((Number)key).intValue() : Integer.parseInt(
                                key.toString());
                
                key = null;
                
                return entry instanceof List ? $get(index, (List<Object>)entry) : null;
            }
            
            if (entry == null)
                return null;
            
            // key.0
            String param = entry.toString();
            int dot = param.indexOf('.');
            if (dot == -1)
                return null;
            int index = Integer.parseInt(param.substring(dot+1));
            
            String key = param.substring(0, dot);
            Object val = map.get(key);
            
            return val instanceof List ? $get(index, (List<Object>)val) : null;
        }
    };
    
    /**
     * Get the element at index from list.
     * <pre>
     *   «writable.n.(1).get_from.(message.fields)»
     * </pre>
     */
    public final FakeMap get_from = new FakeMap("get_from")
    {
        @SuppressWarnings("unchecked")
        public Object get(Object entry)
        {
            return $get(number, (List<Object>)entry);
        }
    };
    
    /**
     * Get the element at index (one-based, so we deduct 1) from list.
     * <pre>
     *   «writable.n.(1).get_from1.(message.fields)»
     * </pre>
     */
    public final FakeMap get_from1 = new FakeMap("get_from1")
    {
        @SuppressWarnings("unchecked")
        public Object get(Object entry)
        {
            return $get(number - 1, (List<Object>)entry);
        }
    };
    
    static Object $get(int index, List<Object> list)
    {
        if (index < 0 && (index = list.size() + index) < 0)
            return null;
        
        return list.size() > index ? list.get(index) : null;
    }
    
    /**
     * Sets the first element of the list.
     * <pre>
     *   «writable.set0.("foo")»
     * </pre>
     */
    public final FakeMap set0 = new FakeMap("set0")
    {
        public Object get(Object entry)
        {
            if (list.isEmpty())
                list.add(entry);
            else
                list.set(0, entry);
            
            return Writable.this;
        }
    };
    
    /**
     * Formats the val with the arg.
     * <pre>
     *   «writable.v.(message.name).vfmt.("UC")»
     * </pre>
     */
    public final FakeMap vfmt = new FakeMap("vfmt")
    {
        public Object get(Object entry)
        {
            if (val == null)
                throw new RuntimeException("Misuse of chain (val must not be null).");
            
            return TemplatedCodeGenerator.format(val.toString(), entry.toString());
        }
    };
    
    /**
     * Compares the number against the arg.
     * <pre>
     *   «writable.n.(0).eq.(0)»
     * </pre>
     */
    public final FakeMap eq = new FakeMap("eq")
    {
        public Object get(Object arg)
        {
            if (arg instanceof String)
            {
                String str = (String)arg;
                return !str.isEmpty() && number == Integer.parseInt(str) ? 
                        Boolean.TRUE : Boolean.FALSE;
            }
            
            return arg instanceof Integer && number == ((Integer)arg).intValue() ? 
                    Boolean.TRUE : Boolean.FALSE;
        }
    };
    
    /**
     * Adds the number with the arg.
     * <pre>
     *   «writable.n.(0).plus.(1)»
     * </pre>
     */
    public final FakeMap plus = new FakeMap("plus")
    {
        public Object get(Object entry)
        {
            return number + $int(entry);
        }
    };
    
    /**
     * Subtracts the number with the arg.
     * <pre>
     *   «writable.n.(0).minus.(1)»
     * </pre>
     */
    public final FakeMap minus = new FakeMap("minus")
    {
        public Object get(Object entry)
        {
            return number - $int(entry);
        }
    };
    
    /**
     * Divides the number with the arg.
     * <pre>
     *   «writable.n.(4).div.(2)»
     * </pre>
     */
    public final FakeMap div = new FakeMap("div")
    {
        public Object get(Object entry)
        {
            return number / $int(entry);
        }
    };
    
    /**
     * Multiplies the number with the arg.
     * <pre>
     *   «writable.n.(4).mul.(2)»
     * </pre>
     */
    public final FakeMap mul = new FakeMap("mul")
    {
        public Object get(Object entry)
        {
            return number * $int(entry);
        }
    };
    
    /**
     * The operator "<<" applied to the number with the arg.
     * <pre>
     *   «writable.n.("1").lshift.("2")»
     * </pre>
     */
    public final FakeMap lshift = new FakeMap("lshift")
    {
        public Object get(Object arg)
        {
            return number << $int(arg);
        }
    };
    
    /**
     * The operator "<<" applied to the number with the arg.
     * <pre>
     *   «writable.n.("2").rshift.("1")»
     * </pre>
     */
    public final FakeMap rshift = new FakeMap("rshift")
    {
        public Object get(Object arg)
        {
            return number >>> $int(arg);
        }
    };
    
    /**
     * Compares the number against the arg.
     * <pre>
     *   «writable.n.(0).gt.(0)»
     * </pre>
     */
    public final FakeMap gt = new FakeMap("gt")
    {
        public Object get(Object entry)
        {
            return number > $int(entry);
        }
    };
    
    /**
     * Compares the number against the arg.
     * <pre>
     *   «writable.n.(0).gte.(0)»
     * </pre>
     */
    public final FakeMap gte = new FakeMap("gte")
    {
        public Object get(Object entry)
        {
            return number >= $int(entry);
        }
    };
    
    /**
     * Compares the number against the arg.
     * <pre>
     *   «writable.n.(0).lt.(0)»
     * </pre>
     */
    public final FakeMap lt = new FakeMap("lt")
    {
        public Object get(Object entry)
        {
            return number < $int(entry);
        }
    };
    
    /**
     * Compares the number against the arg.
     * <pre>
     *   «writable.n.(0).lte.(0)»
     * </pre>
     */
    public final FakeMap lte = new FakeMap("lte")
    {
        public Object get(Object entry)
        {
            return number <= $int(entry);
        }
    };
    
    /**
     * Compares the key against the arg.
     * <pre>
     *   «writable.k.("foo").keq.("foo")»
     * </pre>
     */
    public final FakeMap keq = new FakeMap("keq")
    {
        public Object get(Object arg)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            Boolean ret = key.equals(arg) ? Boolean.TRUE : Boolean.FALSE;
            key = null;
            return ret;
        }
    };
    
    /**
     * Compares the key against the arg via identify.
     * <pre>
     *   «writable.k.(foo).ksame.(bar)»
     * </pre>
     */
    public final FakeMap ksame = new FakeMap("ksame")
    {
        public Object get(Object arg)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            Boolean ret = key == arg ? Boolean.TRUE : Boolean.FALSE;
            key = null;
            return ret;
        }
    };
    
    /**
     * Removes a prefix of the key based on the arg.
     * <pre>
     *   «writable.k.("foo").ksubstr.("fo")»
     * </pre>
     */
    public final FakeMap ksubstr = new FakeMap("ksubstr")
    {
        public Object get(Object arg)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            final String k = key.toString();
            key = null;
            
            if (arg == null)
                return k;
            
            if (arg instanceof Integer)
            {
                int i = ((Integer)arg).intValue();
                return i < 0 ? k.substring(0, k.length()+i) : k.substring(i);
            }
            
            final String sub = arg.toString();
            return k.startsWith(sub) ? k.substring(sub.length()) : k;
        }
    };
    
    /**
     * Appends the current key with the arg.
     * <pre>
     *   «writable.k.("foo").kappend.("bar")»
     * </pre>
     */
    public final FakeMap kappend = new FakeMap("kappend")
    {
        public Object get(Object arg)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            final String k = key.toString();
            key = null;
            
            if (arg == null)
                return k;
            
            return k + arg.toString();
        }
    };
    
    /**
     * Appends the current key with val if arg is true.
     * <pre>
     *   «writable.k.("foo").v.(".bar").kappendv.(true)»
     * </pre>
     */
    public final FakeMap kappendv = new FakeMap("kappendv")
    {
        public Object get(Object arg)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            final String k = key.toString();
            key = null;
            
            if (arg == null || Boolean.FALSE.equals(arg))
                return k;
            
            return k + val.toString();
        }
    };
    
    /**
     * Prepends the current key with the arg.
     * <pre>
     *   «writable.k.("foo").kprepend.("bar")»
     * </pre>
     */
    public final FakeMap kprepend = new FakeMap("kprepend")
    {
        public Object get(Object arg)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            final String k = key.toString();
            key = null;
            
            if (arg == null)
                return k;
            
            return arg.toString() + k;
        }
    };
    
    /**
     * Prepends the current key with val if arg is true.
     * <pre>
     *   «writable.v.("foo.").k.("bar").kprependv.(true)»
     * </pre>
     */
    public final FakeMap kprependv = new FakeMap("kprependv")
    {
        public Object get(Object arg)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            final String k = key.toString();
            key = null;
            
            if (arg == null || Boolean.FALSE.equals(arg))
                return k;
            
            return val.toString() + k;
        }
    };
    
    /**
     * Formats the current key with arg as the format.
     * <pre>
     *   «writable.k.("foo").kfmt.("bar")»
     * </pre>
     */
    public final FakeMap kfmt = new FakeMap("kfmt")
    {
        public Object get(Object arg)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            final String k = key.toString();
            key = null;
            
            if (arg == null)
                return k;
            
            return TemplatedCodeGenerator.format(k, arg.toString());
        }
    };
    
    /**
     * Returns true if the key is found in the arg.
     * <pre>
     *   «writable.k.("foo").kin.("hellofooworld")»
     *   «writable.k.("foo").kin.(map_or_annotation)»
     * </pre>
     */
    public final FakeMap kin = new FakeMap("kin")
    {
        public Object get(Object entry)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            final String k = key.toString();
            key = null;
            
            if (entry == null)
                return Boolean.FALSE;
            
            if (entry instanceof Annotation)
                return ((Annotation)entry).getP().get(k);
            
            if (entry instanceof Map<?,?>)
                return ((Map<?,?>)entry).get(k);
            
            return -1 != entry.toString().indexOf(k);
        }
    };
    
    /**
     * Returns true if the key starts with the arg.
     * <pre>
     *   «writable.k.("foo").ksw.("foo")»
     * </pre>
     */
    public final FakeMap ksw = new FakeMap("ksw")
    {
        public Object get(Object entry)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            Boolean ret = entry != null && key.toString().startsWith(entry.toString()) ? 
                    Boolean.TRUE : Boolean.FALSE;
            key = null;
            return ret;
        }
    };
    
    /**
     * Returns true if the key ends with the arg.
     * <pre>
     *   «writable.k.("foo").kew.("foo")»
     * </pre>
     */
    public final FakeMap kew = new FakeMap("kew")
    {
        public Object get(Object entry)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            Boolean ret = entry != null && key.toString().endsWith(entry.toString()) ? 
                    Boolean.TRUE : Boolean.FALSE;
            key = null;
            return ret;
        }
    };
    
    /**
     * Returns true if {@link #number} & arg is not zero.
     * <pre>
     *   «writable.n.("5").intersect.("1")»
     * </pre>
     */
    public final FakeMap intersect = new FakeMap("intersect")
    {
        public Object get(Object arg)
        {
            return 0 != (number & $int(arg)) ? Boolean.TRUE : Boolean.FALSE;
        }
    };
    
    /**
     * The operator "&=" applied to the number with the arg.
     * <pre>
     *   «writable.n.("5").and.("7")»
     * </pre>
     */
    public final FakeMap and = new FakeMap("and")
    {
        public Object get(Object arg)
        {
            number &= $int(arg);
            return Writable.this;
        }
    };
    
    /**
     * The operator "|=" applied to the number with the arg.
     * <pre>
     *   «writable.n.("5").or.("7")»
     * </pre>
     */
    public final FakeMap or = new FakeMap("or")
    {
        public Object get(Object arg)
        {
            number |= $int(arg);
            return Writable.this;
        }
    };
    
    /**
     * The operator "^=" applied to the number with the arg.
     * <pre>
     *   «writable.n.("5").xor.("7")»
     * </pre>
     */
    public final FakeMap xor = new FakeMap("xor")
    {
        public Object get(Object arg)
        {
            number ^= $int(arg);
            return Writable.this;
        }
    };
    
    /**
     * Sets the number.
     * <pre>
     *   «(writable.setnumber.(field.number))»
     * </pre>
     */
    public final FakeMap setnumber = new FakeMap("setnumber")
    {
        public Object get(Object arg)
        {
            if (arg instanceof Map<?,?>)
                number = ((Map<?,?>)arg).size();
            else if (arg instanceof Collection<?>)
                number = ((Collection<?>)arg).size();
            else
                number = $int(arg);
            return Writable.this;
        }
    };
    
    /**
     * Increments the number.
     * <pre>
     *   «(writable.incby.("2"))»
     * </pre>
     */
    public final FakeMap incby = new FakeMap("incby")
    {
        public Object get(Object arg)
        {
            number += $int(arg);
            return Writable.this;
        }
    };
    
    /**
     * Decrements the number.
     * <pre>
     *   «(writable.decby.("2")»
     * </pre>
     */
    public final FakeMap decby = new FakeMap("decby")
    {
        public Object get(Object arg)
        {
            number -= $int(arg);
            return Writable.this;
        }
    };
    
    /**
     * Removes an item from the map.
     * <pre>
     *   «(writable.map_remove.("foo"))»
     * </pre>
     */
    public final FakeMap map_remove = new FakeMap("map_remove")
    {
        public Object get(Object entry)
        {
            map.remove(entry);
            return Writable.this;
        }
    };
    
    /**
     * Removes an item from the list.
     * <pre>
     *   «(writable.list_remove.(writable.number))»
     * </pre>
     */
    public final FakeMap list_remove = new FakeMap("list_remove")
    {
        public Object get(Object entry)
        {
            if (entry instanceof Integer)
                list.remove(((Integer)entry).intValue());
            else
                list.remove(entry);
            
            return Writable.this;
        }
    };
    
    /**
     * The arg is evaluated.
     * <pre>
     *   «if(writable.arg.({«message.o.("foo")»}).arg(message.o.({«message.o.("bar")»})).andArgs)»
     * </pre>
     */
    public final FakeMap arg = new FakeMap("arg")
    {
        public Object get(Object arg)
        {
            argCount++;
            if (arg.toString().isEmpty())
                argFalseCount++;
            
            return Writable.this;
        }
    };
    
    /**
     * The arg is evaluated.
     * <pre>
     *   «if(writable.notarg.({«message.o.("foo")»}).notarg(message.o.({«message.o.("bar")»})).andArgs)»
     * </pre>
     */
    public final FakeMap notarg = new FakeMap("notarg")
    {
        public Object get(Object arg)
        {
            argCount++;
            if (!arg.toString().isEmpty())
                argFalseCount++;
            
            return Writable.this;
        }
    };
    
    /**
     * Checks if the key is inside the arg.
     * <pre>
     *   «if(writable.k.("foo").in.(message.o).k.("bar").in.(message.o).andArgs)»
     * </pre>
     */
    public final FakeMap in = new FakeMap("in")
    {
        public Object get(Object map)
        {
            final Object k = key;
            if (k == null)
                throw new RuntimeException("Misuse of chain.");
            
            key = null;
            
            argCount++;
            if (!((Map<?,?>)map).containsKey(k))
                argFalseCount++;
            
            return Writable.this;
        }
    };
    
    /**
     * Checks if the key is not inside the arg.
     * <pre>
     *   «if(writable.k.("foo").notin.(message.o).k.("bar").notin.(message.o).andArgs)»
     * </pre>
     */
    public final FakeMap notin = new FakeMap("notin")
    {
        public Object get(Object map)
        {
            final Object k = key;
            if (k == null)
                throw new RuntimeException("Misuse of chain.");
            
            key = null;
            
            argCount++;
            if (((Map<?,?>)map).containsKey(k))
                argFalseCount++;
            
            return Writable.this;
        }
    };
    
    /**
     * Sets the key.
     * <pre>
     *   «writable.setkey.("key").put.("value")».
     * 
     * You can also chain it continuously as long as its the order is key->value.
     *   «writable.k.("k1").put.("v1").k.("k2").put.("v2")».
     * </pre>
     */
    public final FakeMap setkey = new FakeMap("setkey")
    {
        public Object get(Object newKey)
        {
            if (key != null)
                throw new RuntimeException("Misuse of chain.");
            if (newKey == null)
                throw new RuntimeException("Null key.");
            
            key = newKey;
            return Writable.this;
        }
    };
    
    /**
     * Sets the value.
     * <pre>
     *   «writable.setval.("foo")»
     *   or
     *   «writable.v.("foo")».
     * </pre>
     */
    public final FakeMap setval = new FakeMap("setval")
    {
        public Object get(Object arg)
        {
            val = arg;
            return Writable.this;
        }
    };
    
    /**
     * Adds to the list.
     * <pre>
     *   «writable.add.(field)»
     * </pre>
     */
    public final FakeMap add = new FakeMap("add")
    {
        public Object get(Object entry)
        {
            list.add(entry);
            return Writable.this;
        }
    };
    
    /**
     * Adds all the elements to the list.
     * 
     * Called from stringtemplate via «(writable.addall.(field))»
     */
    public final FakeMap addall = new FakeMap("addall")
    {
        @SuppressWarnings("unchecked")
        public Object get(Object entry)
        {
            list.addAll((Collection<Object>)entry);
            return Writable.this;
        }
    };
    
    /**
     * Adds to the list and puts to the map.
     * <pre>
     *   «writable.k.(field.name).add_and_put.(field)»
     * </pre>
     */
    public final FakeMap add_and_put = new FakeMap("add_and_put")
    {
        public Object get(Object entry)
        {
            if (key != null)
            {
                $add_and_put(key, entry);
                key = null;
            }
            else if (entry != null)
                $add_and_put(entry.toString(), entry);
            
            return Writable.this;
        }
    };
    
    void $add_and_put(Object key, Object value)
    {
        list.add(value);
        map.put(key, value);
    }
    
    /**
     * Adds to the list and puts only the unique entry to the map.
     * <pre>
     *   «writable.k.(field.name).add_and_uput.(field)»
     * </pre>
     */
    public final FakeMap add_and_uput = new FakeMap("add_and_uput")
    {
        public Object get(Object entry)
        {
            if (key != null)
            {
                $add_and_uput(key, entry);
                key = null;
            }
            else if (entry != null)
                $add_and_uput(entry.toString(), entry);
            
            return Writable.this;
        }
    };
    
    void $add_and_uput(Object key, Object value)
    {
        list.add(value);
        
        if (!map.containsKey(key))
        {
            // unique, 
            map.put(key, value);
        }
    }
    
    /**
     * Returns a new map filled with the csv arg.
     * <pre>
     *   «(writable.k.("foo").inc_map_value.(field))»
     * </pre>
     */
    public final FakeMap new_map_from_csv = new FakeMap("new_map_from_csv")
    {
        public Object get(Object arg)
        {
            if (key != null)
                throw new RuntimeException("Misuse of chain.");
            
            if (arg == null)
                return Collections.EMPTY_MAP;
            
            return CompilerUtil.fill(new LinkedHashMap<String,String>(), arg.toString());
        }
    };
    
    /**
     * Increments the value with the arg.
     * <pre>
     *   «(writable.k.("foo").inc_map_value.(field))»
     * </pre>
     */
    public final FakeMap inc_map_value = new FakeMap("inc_map_value")
    {
        public Object get(Object arg)
        {
            final Object k = key;
            if (k == null)
                throw new RuntimeException("Misuse of chain.");
            
            key = null;
            
            Object value = map.get(k);
            if (value == null)
                map.put(k, arg);
            else
                map.put(k, ((Integer)value).intValue() + $int(arg));
            
            return Writable.this;
        }
    };
    
    /**
     * Puts the entry into the map.
     * <pre>
     *   «(writable.k.("foo").put.(field))»
     * </pre>
     */
    public final FakeMap put = new FakeMap("put")
    {
        public Object get(Object entry)
        {
            if (key != null)
            {
                map.put(key, entry);
                key = null;
            }
            else if (entry != null)
                map.put(entry.toString(), entry);
            
            return Writable.this;
        }
    };
    
    /**
     * Puts only unique entries into the map.
     * <pre>
     *   «(writable.k.(field.name).uput.(field))»
     * </pre>
     */
    public final FakeMap uput = new FakeMap("uput")
    {
        public Object get(Object entry)
        {
            if (key != null)
            {
                $uput(key, entry);
                key = null;
            }
            else if (entry != null)
                $uput(entry.toString(), entry);
            
            return Writable.this;
        }
    };
    
    void $uput(Object key, Object value)
    {
        if (!map.containsKey(key))
        {
            // unique
            map.put(key, value);
        }
    }
    
    /**
     * Puts only unique entries into the map and added to list.
     * <pre>
     *   «(writable.k.(field.name).uput_and_add.(field))»
     * </pre>
     */
    public final FakeMap uput_and_add = new FakeMap("uput_and_add")
    {
        public Object get(Object entry)
        {
            if (key != null)
            {
                $uput_and_add(key, entry);
                key = null;
            }
            else if (entry != null)
                $uput_and_add(entry.toString(), entry);
            
            return Writable.this;
        }
    };
    
    void $uput_and_add(Object key, Object value)
    {
        if (!map.containsKey(key))
        {
            // unique
            map.put(key, value);
            list.add(value);
        }
    }
    
    /**
     * The entry will be a list that contains the values that are mapped to the same key.
     * <pre>
     *   «(writable.k.(field.name).putlist.(field))»
     * </pre>
     */
    public final FakeMap putlist = new FakeMap("putlist")
    {
        public Object get(Object entry)
        {
            if (key != null)
            {
                $putlist(key, entry);
                key = null;
            }
            else if (entry != null)
                $putlist(entry.toString(), entry);
            
            return Writable.this;
        }
    };
    
    @SuppressWarnings("unchecked")
    void $putlist(Object key, Object value)
    {
        ArrayList<Object> existing = (ArrayList<Object>)map.get(key);
        if (existing == null)
        {
            existing = new ArrayList<Object>();
            map.put(key, existing);
        }
        
        existing.add(value);
    }
    
    /**
     * Returns a sublist based on the arg.
     * <pre>
     *   «(writable.sublist.("2"))»
     * </pre>
     */
    public final FakeMap sublist = new FakeMap("sublist")
    {
        public Object get(Object entry)
        {
            if (entry instanceof List)
            {
                List<?> l = (List<?>)entry;
                return number == l.size() ? Collections.EMPTY_LIST : 
                        l.subList(number, l.size() - number);
            }
            
            int start = $int(entry);
            return start == list.size() ? Collections.EMPTY_LIST : 
                    list.subList(start, list.size() - start);
        }
    };
    
    /**
     * Returns a sublist based on the arg.
     * <pre>
     *   «(writable.pfxlist.("2"))»
     * </pre>
     */
    public final FakeMap pfxlist = new FakeMap("pfxlist")
    {
        public Object get(Object entry)
        {
            if (entry instanceof List)
            {
                List<?> l = (List<?>)entry;
                return number == l.size() - 1 ? l : 
                        l.subList(0, number + 1);
            }
            
            int inclusiveEnd = $int(entry);
            return inclusiveEnd == list.size() - 1 ? list : 
                    list.subList(0, inclusiveEnd + 1);
        }
    };
    
    /**
     * Returns a substring based on the arg.
     * <pre>
     *   «writable.k.("foo").substr.("1")» // returns oo
     * </pre>
     */
    public final FakeMap substr = new FakeMap("substr")
    {
        public Object get(Object entry)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            String str = key.toString();
            key = null;
            
            int start = $int(entry);
            return start == 0 ? str : str.substring(start);
        }
    };
    
    /**
     * Returns a substring based on the arg.
     * <pre>
     *   «writable.k.("foo").pfxstr.(1)» // returns fo
     * </pre> 
     */
    public final FakeMap pfxstr = new FakeMap("pfxstr")
    {
        public Object get(Object entry)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            String str = key.toString();
            key = null;
            
            int inclusiveEnd = $int(entry);
            return inclusiveEnd == str.length() - 1 ? str : 
                    str.substring(0, inclusiveEnd + 1);
        }
    };
    
    /**
     * Returns a substring (counting the delimiter) based on the arg.
     * <pre>
     *   «writable.k.("foo__bar__baz").pfxstr.("1")» // returns foo__bar
     * </pre>
     */
    public final FakeMap pfxstr__ = new FakeMap("pfxstr__")
    {
        public Object get(Object entry)
        {
            if (key == null)
                throw new RuntimeException("Misuse of chain.");
            
            String str = key.toString();
            key = null;
            
            int count = 1 + $int(entry), start = 0;
            for (int i = 0; i < count; i++)
            {
                int idx = str.indexOf("__", start);
                if (idx == -1)
                    throw new RuntimeException("No __ delimiter on " + str + " starting at " + start);
                
                start = idx + 2;
            }

            return str.substring(0, start - 2);
        }
    };
    
    /**
     * Returns the {@link Writable} if the entry is unique.
     * <pre>
     *   «writable.k.(field.name).unique.(field).add.(field)» // adds the field if unique
     * </pre>
     */
    public final FakeMap unique = new FakeMap("unique")
    {
        public Object get(Object entry)
        {
            if (key != null)
            {
                Object ret = $unique(key, entry);
                key = null;
                return ret;
            }
            
            return entry == null ? null : $unique(entry.toString(), entry);
        }
    };
    
    Object $unique(Object key, Object value)
    {
        if (!map.containsKey(key))
        {
            // unique
            map.put(key, value);
            return this;
        }
        
        return EMPTY;
    }
    
    /**
     * Fill the contents based on the key.
     * <pre>
     *   «writable.k.("@Annotation.fK").fill.(message)»
     *   
     *   Example:
     *   &#64;Annotation (f0 = "foo", f1 = "bar", f2 = "baz")
     *   message Foo {
     *     required string name = 1;
     *   }
     * 
     *   With the example above it is equivalent to:
     *     map.put("f", ["f0", "f1", "f2"])
     *   
     *   If the key is "@Annotation.fV", then it is equivalent to:
     *     map.put("f", ["foo", "bar", "baz"])
     *   
     *   If the key is "@Annotation.fI", then it is equivalent to:
     *     map.put("f", ["foo", "bar", "baz"])
     *     map.put("foo", 0)
     *     map.put("bar", 1)
     *     map.put("baz", 2)
     *   
     * </pre>
     */
    public final FakeMap fill = new FakeMap("fill")
    {
        public Object get(Object entry)
        {
            if (key != null)
            {
                Object ret = $fill(key.toString(), entry);
                key = null;
                return ret;
            }
            
            // the entry is the key and the target to fill will be the map/list 
            // of this instance.
            return $fill(entry.toString(), null);
        }
    };
    
    Object $fill(String key, Object value)
    {
        switch(key.charAt(0))
        {
            case ':': // returns true if the string value contains the key
                return value instanceof String && -1 != value.toString().indexOf(
                        key.substring(1)) ? Boolean.TRUE : Boolean.FALSE;
                
            case '@': // fills the map with entries from the annotation
            {
                final AnnotationContainer ac = (AnnotationContainer)value;
                final int dot = key.indexOf('.');
                if (dot == -1)
                {
                    // copies the contents.
                    Annotation a = ac.getAnnotation(key.substring(1));
                    if (a != null)
                        map.putAll(a.getP());
                    
                    return this;
                }
                
                final Annotation a = ac.getAnnotation(key.substring(1, dot));
                if (a != null)
                {
                    //map.putAll(a.getP());
                    
                    int last = key.length() - 1;
                    switch(key.charAt(last))
                    {
                        case 'K':
                        {
                            String entry = key.substring(dot+1, last);
                            map.put("$" + entry, AnnotationUtil.fillKeys(
                                    new ArrayList<String>(), a, entry));
                            break;
                        }
                        case 'V':
                        {
                            String entry = key.substring(dot+1, last);
                            map.put("$" + entry, AnnotationUtil.fillList(
                                    new ArrayList<Object>(), a, entry));
                            break;
                        }
                        case 'I':
                        {
                            String entry = key.substring(dot+1, last);
                            map.put("#" + entry, AnnotationUtil.fillList(
                                    new ArrayList<Object>(), a, entry, map));
                            break;
                        }
                            
                        default:
                            String entry = key.substring(dot+1);
                            map.put("$" + entry, AnnotationUtil.fillMap(
                                    new LinkedHashMap<String,Object>(), a, entry));
                    }
                }
                
                return this;
            }
        }
        
        throw new RuntimeException("Unsupported fill param: " + key);
    }
    
    /* ================================================== */
    
    /**
     * Compares the last two elements in the list.
     * 
     * Called from stringtemplate via «writable.add.(obj1).add.(obj2).same»
     */
    public boolean getSame()
    {
        int size = list.size();
        return list.get(size-1) == list.get(size-2);
    }
    
    /**
     * Compares the last two elements in the list (and removes them at the same time).
     * 
     * Called from stringtemplate via «writable.add.(obj1).add.(obj2).popsame»
     */
    public boolean getPopsame()
    {
        int size = list.size();
        return list.remove(size-1) == list.remove(size-2);
    }
    
    public int getGetandinc()
    {
        return number++;
    }
    
    public int getGetanddec()
    {
        return number--;
    }
    
    public Writable getInc()
    {
        number++;
        return this;
    }
    
    public Writable getDec()
    {
        number--;
        return this;
    }
    
    /**
     * Shorthand to {@link #number}.
     */
    public int getNum()
    {
        return number;
    }
    
    /**
     * Shorthand to {@link #setnumber}.
     */
    public FakeMap getN()
    {
        return setnumber;
    }
    
    /**
     * Gets the list's first element (counterpart to {@link #set0}).
     */
    public Object getGet0()
    {
        return list.get(0);
    }
    
    /**
     * Shorthand to {@link #arg}.
     */
    public FakeMap getA()
    {
        return arg;
    }
    
    /**
     * Shorthand to {@link #notarg}.
     */
    public FakeMap getNa()
    {
        return notarg;
    }
    
    /**
     * Evaluates the args (added to {@link #list}).
     * 
     * Called from stringtemplate via «if(writable.a.(""+field.o.("1")).a.(""+field.o.("2")).andArgs)»
     */
    public boolean getAndArgs()
    {
        final boolean ret = argFalseCount == 0;
        
        argCount = 0;
        argFalseCount = 0;
        
        return ret;
    }
    
    /**
     * Evaluates the args (added to {@link #list}).
     * 
     * Called from stringtemplate via «if(writable.a.(""+field.o.("1")).a.(""+field.o.("2")).orArgs)»
     */
    public boolean getOrArgs()
    {
        final boolean ret = argFalseCount != argCount;
        
        argCount = 0;
        argFalseCount = 0;
        
        return ret;
    }

    /* ================================================== */
    
    /**
     * Shorthand to {@link #setkey}.
     */
    public FakeMap getK()
    {
        return setkey;
    }
    
    /**
     * Shorthand to {@link #setval}.
     */
    public FakeMap getV()
    {
        return setval;
    }
    
    /**
     * Returns {@link #builder}'s toString();
     */
    public String getStr()
    {
        String str = builder.toString();
        builder.setLength(0);
        return str;
    }
    
    public StringBuilder getSb()
    {
        return builder;
    }
    
    public boolean isEmptyList()
    {
        return list.isEmpty();
    }
    
    /**
     * Clears the list.
     */
    public Writable getClearList()
    {
        list.clear();
        return this;
    }
    
    public boolean isEmptyMap()
    {
        return map.isEmpty();
    }
    
    /**
     * Clears the map.
     */
    public Writable getClearMap()
    {
        map.clear();
        return this;
    }
    
    /**
     * Sets the number to zero and clears the list and map.
     */
    public Writable getClearAll()
    {
        key = null;
        number = 0;
        list.clear();
        map.clear();
        builder.setLength(0);
        return this;
    }
    
    @SuppressWarnings("rawtypes")
    public boolean isListAndKeySameSize()
    {
        if (key == null)
            throw new RuntimeException("Misuse of chain.");
        
        Object existing = map.get(key);
        key = null;
        if (existing instanceof Map)
            return list.size() == ((Map)existing).size();
        
        return list.size() == ((Collection)existing).size();
    }

    public boolean isListAndMapSameSize()
    {
        return list.size() == map.size();
    }
    
    @SuppressWarnings("unchecked")
    public <T> T $val(Class<T> clazz)
    {
        return val != null && clazz.isAssignableFrom(val.getClass()) ? (T)val : null;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T $get(Class<T> clazz)
    {
        return (T)map.get(clazz.getSimpleName());
    }
    
    @SuppressWarnings("unchecked")
    public <T> T $remove(Class<T> clazz)
    {
        return (T)map.remove(clazz.getSimpleName());
    }
    
    /**
     * Purposely empty.
     */
    public String toString()
    {
        return "";
    }
}
