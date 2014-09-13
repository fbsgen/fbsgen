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

import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.AnnotationContainer;
import io.protostuff.fbsgen.parser.HasName;

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
    
    static final Object K_INIT = new String("");
    
    public final ArrayList<Object> list = new ArrayList<Object>();
    
    public final LinkedHashMap<Object,Object> map = new LinkedHashMap<Object,Object>();
    
    int number = 0, argCount = 0, argFalseCount = 0;
    
    Object currentKey = null;
    
    final FakeMap get = new FakeMap("get")
    {
        @SuppressWarnings("unchecked")
        public Object get(Object entry)
        {
            if (currentKey != null)
            {
                if (currentKey == K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                int index = currentKey instanceof Number ? 
                        ((Number)currentKey).intValue() : Integer.parseInt(
                                currentKey.toString());
                
                currentKey = null;
                
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
    
    static Object $get(int index, List<Object> list)
    {
        if (index < 0 && (index = list.size() + index) < 0)
            return null;
        
        return list.size() > index ? list.get(index) : null;
    }
    
    final FakeMap set0 = new FakeMap("set0")
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
    
    final FakeMap fmt = new FakeMap("fmt")
    {
        public Object get(Object entry)
        {
            if (currentKey == null || currentKey == K_INIT)
                throw new RuntimeException("Misuse of chain.");
            
            final String str = currentKey.toString();
            currentKey = null;
            return TemplatedCodeGenerator.format(str, entry.toString());
        }
    };
    
    final FakeMap eq = new FakeMap("eq")
    {
        public Object get(Object entry)
        {
            if (entry instanceof String)
            {
                String str = (String)entry;
                return !str.isEmpty() && number == Integer.parseInt(str) ? 
                        Boolean.TRUE : Boolean.FALSE;
            }
            
            return entry instanceof Integer && number == ((Integer)entry).intValue() ? 
                    Boolean.TRUE : Boolean.FALSE;
        }
    };
    
    final FakeMap gt = new FakeMap("gt")
    {
        public Object get(Object entry)
        {
            return number > ((Integer)entry).intValue();
        }
    };
    
    final FakeMap gte = new FakeMap("gte")
    {
        public Object get(Object entry)
        {
            return number >= ((Integer)entry).intValue();
        }
    };
    
    final FakeMap lt = new FakeMap("lt")
    {
        public Object get(Object entry)
        {
            return number < ((Integer)entry).intValue();
        }
    };
    
    final FakeMap lte = new FakeMap("lte")
    {
        public Object get(Object entry)
        {
            return number <= ((Integer)entry).intValue();
        }
    };
    
    final FakeMap keq = new FakeMap("keq")
    {
        public Object get(Object entry)
        {
            if (currentKey == null || currentKey == K_INIT)
                throw new RuntimeException("Misuse of chain.");
            
            Boolean ret = currentKey.equals(entry) ? Boolean.TRUE : Boolean.FALSE;
            currentKey = null;
            return ret;
        }
    };
    
    final FakeMap intersect = new FakeMap("intersect")
    {
        public Object get(Object entry)
        {
            int num = entry instanceof Integer ? 
                    ((Integer)entry).intValue() : Integer.parseInt(entry.toString());
            
            return 0 != (num & number) ? Boolean.TRUE : Boolean.FALSE;
        }
    };
    
    final FakeMap and = new FakeMap("and")
    {
        public Object get(Object entry)
        {
            number &= entry instanceof Integer ? 
                    ((Integer)entry).intValue() : Integer.parseInt(entry.toString());
            return Writable.this;
        }
    };
    
    final FakeMap or = new FakeMap("or")
    {
        public Object get(Object entry)
        {
            number |= entry instanceof Integer ? 
                    ((Integer)entry).intValue() : Integer.parseInt(entry.toString());
            return Writable.this;
        }
    };
    
    final FakeMap xor = new FakeMap("xor")
    {
        public Object get(Object entry)
        {
            number ^= entry instanceof Integer ? 
                    ((Integer)entry).intValue() : Integer.parseInt(entry.toString());
            return Writable.this;
        }
    };
    
    final FakeMap setnumber = new FakeMap("setnumber")
    {
        public Object get(Object entry)
        {
            number = entry instanceof Integer ? 
                    ((Integer)entry).intValue() : Integer.parseInt(entry.toString());
            return Writable.this;
        }
    };
    
    final FakeMap incby = new FakeMap("incby")
    {
        public Object get(Object entry)
        {
            number += ((Integer)entry).intValue();
            return Writable.this;
        }
    };
    
    final FakeMap decby = new FakeMap("decby")
    {
        public Object get(Object entry)
        {
            number -= ((Integer)entry).intValue();
            return Writable.this;
        }
    };
    
    final FakeMap mremove = new FakeMap("mremove")
    {
        public Object get(Object entry)
        {
            map.remove(entry);
            return Writable.this;
        }
    };
    
    final FakeMap lremove = new FakeMap("lremove")
    {
        public Object get(Object entry)
        {
            if (entry instanceof Integer)
            {
                list.remove(((Integer)entry).intValue());
            }
            else
            {
                list.remove(entry);
            }
            return Writable.this;
        }
    };
    
    final FakeMap arg = new FakeMap("arg")
    {
        public Object get(Object key)
        {
            argCount++;
            if (key.toString().isEmpty())
                argFalseCount++;
            //final String str = key.toString();
            //if (str.isEmpty() || str.equals("false"))
            //    argFalseCount++;
            
            return Writable.this;
        }
    };
    
    final FakeMap notarg = new FakeMap("notarg")
    {
        public Object get(Object key)
        {
            argCount++;
            if (!key.toString().isEmpty())
                argFalseCount++;
            //final String str = key.toString();
            //if (!str.isEmpty() && !str.equals("false"))
            //    argFalseCount++;
            
            return Writable.this;
        }
    };
    
    final FakeMap in = new FakeMap("in")
    {
        public Object get(Object map)
        {
            final Object k = currentKey;
            if (k == null || k == K_INIT)
                throw new RuntimeException("Misuse of chain.");
            
            currentKey = null;
            
            argCount++;
            if (!((Map<?,?>)map).containsKey(k))
                argFalseCount++;
            
            return Writable.this;
        }
    };
    
    final FakeMap notin = new FakeMap("notin")
    {
        public Object get(Object map)
        {
            final Object k = currentKey;
            if (k == null || k == K_INIT)
                throw new RuntimeException("Misuse of chain.");
            
            currentKey = null;
            
            argCount++;
            if (((Map<?,?>)map).containsKey(k))
                argFalseCount++;
            
            return Writable.this;
        }
    };
    
    final FakeMap add = new FakeMap("add")
    {
        public Object get(Object key)
        {
            if (currentKey != null)
            {
                if (currentKey != K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                // sets the key
                currentKey = String.valueOf(key);
                return Writable.this;
            }
            
            list.add(key);
            return Writable.this;
        }
    };
    
    final FakeMap addall = new FakeMap("addall")
    {
        @SuppressWarnings("unchecked")
        public Object get(Object key)
        {
            list.addAll((Collection<Object>)key);
            return Writable.this;
        }
    };
    
    final FakeMap addput = new FakeMap("addput")
    {
        public Object get(Object entry)
        {
            if (currentKey != null)
            {
                if (currentKey == K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                addput(currentKey, entry);
                currentKey = null;
                return Writable.this;
            }
            
            HasName hn = (HasName)entry;
            addput(hn.getName(), hn);
            return Writable.this;
        }
    };
    
    void addput(Object key, Object value)
    {
        list.add(value);
        map.put(key, value);
    }
    
    final FakeMap adduput = new FakeMap("adduput")
    {
        public Object get(Object entry)
        {
            if (currentKey != null)
            {
                if (currentKey == K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                adduput(currentKey, entry);
                currentKey = null;
                return Writable.this;
            }
            
            HasName hn = (HasName)entry;
            adduput(hn.getName(), hn);
            return Writable.this;
        }
    };
    
    void adduput(Object key, Object value)
    {
        list.add(value);
        
        if (!map.containsKey(key))
        {
            // unique, 
            map.put(key, value);
        }
    }
    
    final FakeMap put = new FakeMap("put")
    {
        public Object get(Object entry)
        {
            if (currentKey != null)
            {
                if (currentKey == K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                map.put(currentKey, entry);
                currentKey = null;
                return Writable.this;
            }
            
            HasName hn = (HasName)entry;
            map.put(hn.getName(), hn);
            return Writable.this;
        }
    };
    
    final FakeMap uput = new FakeMap("uput")
    {
        public Object get(Object entry)
        {
            if (currentKey != null)
            {
                if (currentKey == K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                uput(currentKey, entry);
                currentKey = null;
                return Writable.this;
            }
            
            HasName hn = (HasName)entry;
            uput(hn.getName(), hn);
            return Writable.this;
        }
    };
    
    void uput(Object key, Object value)
    {
        if (!map.containsKey(key))
        {
            // unique
            map.put(key, value);
        }
    }
    
    final FakeMap uputadd = new FakeMap("uputadd")
    {
        public Object get(Object entry)
        {
            if (currentKey != null)
            {
                if (currentKey == K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                uputadd(currentKey, entry);
                currentKey = null;
                return Writable.this;
            }
            
            HasName hn = (HasName)entry;
            uputadd(hn.getName(), hn);
            return Writable.this;
        }
    };
    
    void uputadd(Object key, Object value)
    {
        if (!map.containsKey(key))
        {
            // unique, 
            map.put(key, value);
            list.add(value);
        }
    }
    
    final FakeMap putlist = new FakeMap("putlist")
    {
        public Object get(Object entry)
        {
            if (currentKey != null)
            {
                if (currentKey == K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                putlist(currentKey, entry);
                currentKey = null;
                return Writable.this;
            }
            
            HasName hn = (HasName)entry;
            putlist(hn.getName(), hn);
            return Writable.this;
        }
    };
    
    @SuppressWarnings("unchecked")
    void putlist(Object key, Object value)
    {
        ArrayList<Object> existing = (ArrayList<Object>)map.get(key);
        if (existing == null)
        {
            existing = new ArrayList<Object>();
            map.put(key, existing);
        }
        
        existing.add(value);
    }
    
    final FakeMap sublist = new FakeMap("sublist")
    {
        public Object get(Object entry)
        {
            if (entry instanceof List)
            {
                List<?> l = (List<?>)entry;
                return number == l.size() ? Collections.EMPTY_LIST : 
                        l.subList(number, l.size() - number);
            }
            
            int start = ((Integer)entry).intValue();
            return start == list.size() ? Collections.EMPTY_LIST : 
                    list.subList(start, list.size() - start);
        }
    };
    
    final FakeMap pfxlist = new FakeMap("pfxlist")
    {
        public Object get(Object entry)
        {
            if (entry instanceof List)
            {
                List<?> l = (List<?>)entry;
                return number == l.size() - 1 ? l : 
                        l.subList(0, number + 1);
            }
            
            int inclusiveEnd = ((Integer)entry).intValue();
            return inclusiveEnd == list.size() - 1 ? list : 
                    list.subList(0, inclusiveEnd + 1);
        }
    };
    
    final FakeMap substr = new FakeMap("substr")
    {
        public Object get(Object entry)
        {
            if (currentKey == null || currentKey == K_INIT)
                throw new RuntimeException("Misuse of chain.");
            
            String str = currentKey.toString();
            currentKey = null;
            
            int start = ((Integer)entry).intValue();
            return start == 0 ? str : str.substring(start);
        }
    };
    
    final FakeMap pfxstr = new FakeMap("pfxstr")
    {
        public Object get(Object entry)
        {
            if (currentKey == null || currentKey == K_INIT)
                throw new RuntimeException("Misuse of chain.");
            
            String str = currentKey.toString();
            currentKey = null;
            
            int inclusiveEnd = ((Integer)entry).intValue();
            return inclusiveEnd == str.length() - 1 ? str : 
                    str.substring(0, inclusiveEnd + 1);
        }
    };
    
    final FakeMap pfxstr__ = new FakeMap("pfxstr__")
    {
        public Object get(Object entry)
        {
            if (currentKey == null || currentKey == K_INIT)
                throw new RuntimeException("Misuse of chain.");
            
            String str = currentKey.toString();
            currentKey = null;
            
            int count = 1 + ((Integer)entry).intValue(), start = 0;
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
     * Atomic query and put.  Returns null if not unique.
     */
    final FakeMap unique = new FakeMap("unique")
    {
        public Object get(Object entry)
        {
            if (currentKey != null)
            {
                if (currentKey == K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                Object ret = unique(currentKey, entry);
                currentKey = null;
                return ret;
            }
            
            HasName hn = (HasName)entry;
            return unique(hn.getName(), hn);
        }
    };
    
    Object unique(Object key, Object value)
    {
        if (!map.containsKey(key))
        {
            // unique
            map.put(key, value);
            return this;
        }
        
        return null;
    }
    
    /**
     * Fill objects.
     */
    final FakeMap fill = new FakeMap("fill")
    {
        public Object get(Object entry)
        {
            if (currentKey != null)
            {
                if (currentKey == K_INIT)
                    throw new RuntimeException("Misuse of chain.");
                
                Object ret = fill((String)currentKey, entry);
                currentKey = null;
                return ret;
            }
            
            // the entry is the key and the target to fill will be the map/list 
            // of this instance.
            return fill(String.valueOf(entry), null);
        }
    };
    
    Object fill(String key, Object value)
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
    
    public ArrayList<Object> getList()
    {
        return list;
    }
    
    /**
     * Compares the last two elements in the list.
     * 
     * Called from stringtemplate via "&lt;writable.add.(obj1).add.(obj2).same&gt;"
     */
    public boolean getSame()
    {
        int size = list.size();
        return list.get(size-1) == list.get(size-2);
    }
    
    /**
     * Compares the last two elements in the list (and removes them at the same time).
     * 
     * Called from stringtemplate via "&lt;writable.add.(obj1).add.(obj2).popsame&gt;"
     */
    public boolean getPopsame()
    {
        int size = list.size();
        return list.remove(size-1) == list.remove(size-2);
    }
    
    public int getNumber()
    {
        return number;
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
     * Allias to {@link #getNumber()}.
     */
    public int getNum()
    {
        return getNumber();
    }
    
    /**
     * Alias to {@link #getSetnumber()}.
     */
    public FakeMap getN()
    {
        return getSetnumber();
    }
    
    public Object getGet0()
    {
        return list.get(0);
    }
    
    public FakeMap getSet0()
    {
        return set0;
    }
    
    /**
     * Formats the currentKey with the arg.
     * 
     * Called from stringtemplate via "&lt;writable.k.(message.name).fmt.("UC")&gt;"
     */
    public FakeMap getFmt()
    {
        return fmt;
    }
    
    /**
     * Compares the number against the arg.
     * 
     * Called from stringtemplate via "&lt;writable.n.(0).eq.(0)&gt;"
     */
    public FakeMap getEq()
    {
        return eq;
    }
    
    /**
     * Compares the number against the arg.
     * 
     * Called from stringtemplate via "&lt;writable.n.(0).gt.(0)&gt;"
     */
    public FakeMap getGt()
    {
        return gt;
    }
    
    /**
     * Compares the number against the arg.
     * 
     * Called from stringtemplate via "&lt;writable.n.(0).gte.(0)&gt;"
     */
    public FakeMap getGte()
    {
        return gte;
    }
    
    /**
     * Compares the number against the arg.
     * 
     * Called from stringtemplate via "&lt;writable.n.(0).lt.(0)&gt;"
     */
    public FakeMap getLt()
    {
        return lt;
    }
    
    /**
     * Compares the number against the arg.
     * 
     * Called from stringtemplate via "&lt;writable.n.(0).lte.(0)&gt;"
     */
    public FakeMap getLte()
    {
        return lte;
    }
    
    /**
     * Compares the key against the arg.
     * 
     * Called from stringtemplate via "&lt;writable.k.("foo").keq.("foo")&gt;"
     */
    public FakeMap getKeq()
    {
        return keq;
    }
    
    public FakeMap getIntersect()
    {
        return intersect;
    }
    
    /**
     * Merges the number against the arg.
     * 
     * Called from stringtemplate via "&lt;writable.n.(0).and.(0)&gt;"
     */
    public FakeMap getAnd()
    {
        return and;
    }
    
    /**
     * Merges the number against the arg.
     * 
     * Called from stringtemplate via "&lt;writable.n.(0).or.(0)&gt;"
     */
    public FakeMap getOr()
    {
        return or;
    }
    
    /**
     * Merges the number against the arg.
     * 
     * Called from stringtemplate via "&lt;writable.n.(0).xor.(0)&gt;"
     */
    public FakeMap getXor()
    {
        return xor;
    }
    
    /**
     * Checks the arg if it exists.
     * 
     * Called from stringtemplate via "&lt;if (writable.arg.(""+field.o.("foo")).andArgs)&gt;"
     */
    public FakeMap getArg()
    {
        return arg;
    }
    
    /**
     * Alias to {@link #getArg()}.
     */
    public FakeMap getA()
    {
        return getArg();
    }
    
    /**
     * Checks the arg if it does not exist.
     * 
     * Called from stringtemplate via "&lt;if (writable.notarg.(""+field.o.("foo")).andArgs)&gt;"
     */
    public FakeMap getNotarg()
    {
        return notarg;
    }
    
    /**
     * Alias to {@link #getNotarg()}.
     */
    public FakeMap getNa()
    {
        return getNotarg();
    }
    
    /**
     * Checks if the key is inside the arg.
     * 
     * Called from stringtemplate via "&lt;if (writable.k.("foo").in.(options).andArgs)&gt;"
     */
    public FakeMap getIn()
    {
        return in;
    }
    
    /**
     * Checks if the key is not inside the arg.
     * 
     * Called from stringtemplate via "&lt;if (writable.k.("foo").notin.(options).andArgs)&gt;"
     */
    public FakeMap getNotin()
    {
        return notin;
    }
    
    /**
     * Evaluates the args (added to {@link #list}).
     * 
     * Called from stringtemplate via "&lt;if (writable.a.(""+field.o.("1")).a.(""+field.o.("2")).andArgs)&gt;"
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
     * Called from stringtemplate via "&lt;if (writable.a.(""+field.o.("1")).a.(""+field.o.("2")).orArgs)&gt;"
     */
    public boolean getOrArgs()
    {
        final boolean ret = argFalseCount != argCount;
        
        argCount = 0;
        argFalseCount = 0;
        
        return ret;
    }
    
    /**
     * Get the element at index from list if k was set.  Otherwise, the arg will 
     * be read as 'key.0' where 'key' is used to retrieve the list from the map 
     * and '0' is the index.
     * 
     * Called from stringtemplate via:
     * <pre>
     * &lt;writable.k.("0").get.(message.fields)&gt;
     * &lt;writable.k.(1).get.(message.fields)&gt;
     * &lt;(writable.get.("key.0"))&gt;
     * </pre>
     */
    public FakeMap getGet()
    {
        return get;
    }
    
    /**
     * Sets the number.
     * 
     * Called from stringtemplate via "&lt;(writable.setnumber.(2))&gt;"
     */
    public FakeMap getSetnumber()
    {
        return setnumber;
    }
    
    /**
     * Increments the number.
     * 
     * Called from stringtemplate via "&lt;(writable.incby.(2))&gt;"
     */
    public FakeMap getIncby()
    {
        return incby;
    }
    
    /**
     * Decrements the number.
     * 
     * Called from stringtemplate via "&lt;(writable.decby.(2)&gt;"
     */
    public FakeMap getDecby()
    {
        return decby;
    }
    
    /**
     * Returns a sublist based on the arg.
     * 
     * Called from stringtemplate via "&lt;(writable.sublist.(2))&gt;"
     */
    public FakeMap getSublist()
    {
        return sublist;
    }
    
    /**
     * Returns a sublist based on the arg.
     * 
     * Called from stringtemplate via "&lt;(writable.pfxlist.(2))&gt;"
     */
    public FakeMap getPfxlist()
    {
        return pfxlist;
    }
    
    /**
     * Returns a substring based on the arg.
     * 
     * Called from stringtemplate via "&lt;writable.k.("foo").substr.(1)&gt;" - which
     * returns "oo".
     */
    public FakeMap getSubstr()
    {
        return substr;
    }
    
    /**
     * Returns a substring based on the arg.
     * 
     * Called from stringtemplate via "&lt;writable.k.("foo").pfxstr.(1)&gt;" - which
     * returns "fo".
     */
    public FakeMap getPfxstr()
    {
        return pfxstr;
    }
    
    /**
     * Returns a substring (counting the delimiter) based on the arg.
     * 
     * Called from stringtemplate via "&lt;writable.k.("foo__bar__baz").pfxstr.(1)&gt;" - which
     * returns "foo__bar".
     */
    public FakeMap getPfxstr__()
    {
        return pfxstr__;
    }
    
    /**
     * Removes an item from the map.
     * 
     * Called from stringtemplate via "&lt;(writable.mremove.("1"))&gt;"
     */
    public FakeMap getMremove()
    {
        return mremove;
    }
    
    /**
     * Removes an item from the list.
     * 
     * Called from stringtemplate via "&lt;(writable.lremove.(1))&gt;"
     */
    public FakeMap getLremove()
    {
        return lremove;
    }
    
    /**
     * Adds to the list.
     * 
     * Called from stringtemplate via "&lt;(writable.add.(field))&gt;"
     */
    public FakeMap getAdd()
    {
        return add;
    }
    
    /**
     * Adds all the elements to the list.
     * 
     * Called from stringtemplate via "&lt;(writable.addall.(field))&gt;"
     */
    public FakeMap getAddall()
    {
        return addall;
    }
    
    /**
     * Adds to the list and puts to the map.
     * 
     * Called from stringtemplate via "&lt;(writable.addput.(field))&gt;"
     */
    public FakeMap getAddput()
    {
        return addput;
    }
    
    /**
     * Adds to the list and puts only the unique entry to the map.
     * 
     * Called from stringtemplate via "&lt;(writable.addput.(field))&gt;"
     */
    public FakeMap getAdduput()
    {
        return adduput;
    }
    
    /* ================================================== */
    
    public Map<Object,Object> getMap()
    {
        return map;
    }
    
    /**
     * Puts into the map.
     * 
     * Called from stringtemplate via "&lt;(writable.put.(field))&gt;"
     */
    public FakeMap getPut()
    {
        return put;
    }
    
    /**
     * Puts only unique entries into the map.
     * 
     * Called from stringtemplate via "&lt;(writable.uput.(field))&gt;"
     */
    public FakeMap getUput()
    {
        return uput;
    }
    
    /**
     * Puts only unique entries into the map and added to list.
     * 
     * Called from stringtemplate via "&lt;(writable.uput.(field))&gt;"
     */
    public FakeMap getUputadd()
    {
        return uputadd;
    }
    
    /**
     * The entry will be a list that contains the values that are mapped to the same key.
     * 
     * Called from stringtemplate via "&lt;(writable.putlist.(field))&gt;"
     */
    public FakeMap getPutlist()
    {
        return putlist;
    }
    
    /**
     * Returns true if the entry is unique;
     * 
     * Called from stringtemplate via "&lt;(writable.unique.(field))&gt;"
     */
    public FakeMap getUnique()
    {
        return unique;
    }
    
    /**
     * Fill the contents based on the parameter.
     */
    public FakeMap getFill()
    {
        return fill;
    }
    
    /**
     * Returns a map that the caller should use to set the key and then chain.
     * <pre>
     * E.g "&lt;writable.k.("key").put.("value")&gt;".
     * 
     * You can also chain it continuously as long as its the order is key->value.
     * E.g "&lt;writable.k.("k1").put.("v1").k.("k2").put.("v2")&gt;".
     * </pre>
     */
    public FakeMap getK()
    {
        if (currentKey != null)
            throw new RuntimeException("Misuse of chain.");
        
        currentKey = K_INIT;
        
        return add;
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
    
    public Writable getClearAll()
    {
        list.clear();
        map.clear();
        number = 0;
        return this;
    }
    
    @SuppressWarnings("rawtypes")
    public boolean isListAndKeySameSize()
    {
        if (currentKey == null || currentKey == K_INIT)
            throw new RuntimeException("Misuse of chain.");
        
        Object existing = map.get(currentKey);
        currentKey = null;
        if (existing instanceof Map)
            return list.size() == ((Map)existing).size();
        
        return list.size() == ((Collection)existing).size();
    }

    public boolean isListAndMapSameSize()
    {
        return list.size() == map.size();
    }
    
    /**
     * Purposely empty.
     */
    public String toString()
    {
        return "";
    }
}
