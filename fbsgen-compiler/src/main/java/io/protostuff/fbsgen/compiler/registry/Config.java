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

import static io.protostuff.fbsgen.compiler.ErrorUtil.err;
import static io.protostuff.fbsgen.compiler.registry.QueryUtil.getFieldIdxChar;
import static io.protostuff.fbsgen.compiler.registry.QueryUtil.getUusvFields;
import io.protostuff.fbsgen.compiler.ST4Group;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.HasName;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.ProtoUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.stringtemplate.v4.AttributeRenderer;

/**
 * Represents an {@link EnumGroup} that acts as a configuration for messages/enums.
 * 
 * @author David Yu
 * @created Jul 30, 2013
 */
public final class Config implements HasName
{
    
    /**
     * Cache for the expensive-to-recreate {@link Config} objects.
     */
    private static final HashMap<String,Config> __cache = new HashMap<String,Config>();
    
    static void initRenderers()
    {
        ST4Group.setAttributeRenderer(Config.Value.Permutation.class, 
                Config.Value.Permutation.RENDERER);
    }
    
    public static Config getConfig(EnumGroup eg)
    {
        Annotation a = eg.getAnnotation("Config");
        if (a == null)
            return null;
        
        // return cached if we've seen it before
        String sourcePath = eg.getProto().getSourcePath();
        String key = sourcePath + eg.getRelativeName();
        Config cached = __cache.get(key);
        if (cached != null)
            return cached;
        
        final Object paramLink = a.getP().get("link"), 
                paramTarget = a.getP().get("target"), 
                paramService = a.getP().get("service");
        
        if (paramLink != null && !(paramLink instanceof EnumGroup))
        {
            throw err("The config " + eg.getRelativeName() + 
                    " contains a 'link' param that does not point to an enum.", 
                    eg.getProto());
        }
        
        if (paramTarget != null && !(paramTarget instanceof Message))
        {
            throw err("The config " + eg.getRelativeName() + 
                    " contains a 'target' param that does not point to a message.", 
                    eg.getProto());
        }
        
        if (paramService != null && !(paramService instanceof EnumGroup.Value))
        {
            throw err("The config " + eg.getRelativeName() + 
                    " contains a 'service' param that does not point to an enum value.", 
                    eg.getProto());
        }
        
        final EnumGroup link = (EnumGroup)paramLink;
        final boolean resolvePermutations = link != null && link.getName().equals("SI");
        
        Message target = (Message)paramTarget;
        if (null == target && null == (target = eg.getParentMessage()) && 
                resolvePermutations)
        {
            throw err("The non-nested config " + eg.getRelativeName() + 
                    ", does not have a 'target' param that points to a message.", 
                    eg.getProto());
        }
        
        final EnumGroup.Value service = (EnumGroup.Value)paramService;
        
        final Config config = new Config(eg, target, link, service);
        
        for (EnumGroup.Value ev : eg.getValues())
        {
            config.values.put(ev.getName(), newV(config, ev, "f", target, link, 
                    ev.getOptions(), resolvePermutations));
        }
        
        // cache this config
        __cache.put(key, config);
        
        return config;
    }
    
    public static Value newV(Config config, 
            EnumGroup.Value configField, String entryPrefix, 
            Message target, EnumGroup link, 
            Map<String,Object> options, boolean resolvePermutations)
    {
        final String firstEntryName = entryPrefix + "0";
        final Object firstEntry = options.get(firstEntryName);
        if (null == firstEntry)
        {
            if (!resolvePermutations)
                return new Value(config, configField, null);
            
            throw err("The config value " + config.getName() + "." + configField.getName() + 
                    " for " + target.getName() + 
                    " must define the entry: " + firstEntryName, 
                    config.eg.getProto());
        }
        
        if (firstEntry instanceof String)
        {
            if (target == null)
            {
                throw err("The non-nested config " + config.eg.getName() + 
                        " with a string entry: " + firstEntryName + 
                        " must define a 'target' param that points to a message", 
                        config.eg.getProto());
            }

            return newVWithFieldRef(config, configField, entryPrefix, options, 
                    resolvePermutations);
        }
        
        if (resolvePermutations)
        {
            throw err("The config value " + config.getName() + "." + configField.getName() + 
                    " for " + target.getName() + 
                    " contains a non-string entry: " + firstEntryName, 
                    config.eg.getProto());
        }
        
        if (firstEntry instanceof EnumGroup.Value)
        {
            if (link == null)
            {
                throw err("The non-nested config " + config.eg.getName() + 
                        " with a non-string entry: " + firstEntryName + 
                        " must define a 'link' param that points to an enum", 
                        config.eg.getProto());
            }
            
            return newVWithEnumValueRef(config, configField, entryPrefix, options);
        }
        
        if (firstEntry instanceof Message)
        {
            return newVWithMessageRef(config, configField, entryPrefix, options);
        }

        throw err("The config value " + config.getName() + "." + configField.getName() + 
                " for " + target.getName() + 
                " contains an invalid entry: " + firstEntryName, 
                config.eg.getProto());
    }
    
    static Value newVWithFieldRef(Config config, 
            EnumGroup.Value configField, String entryPrefix, 
            Map<String,Object> options, boolean resolvePermutations)
    {
        final Message target = config.target;
        
        Field<?> parentKey = null;
        if (resolvePermutations)
        {
            final String fieldRef = (String)configField.getOptions().get("parent_key");
            if (fieldRef != null && null == (parentKey = target.getField(fieldRef)))
            {
                throw err("The config value " + config.getName() + "." + configField.getName() + 
                        " for " + target.getName() + 
                        " contains a parent_key entry that points to nothing",  
                        config.eg.getProto());
            }
        }
        
        final Value v = new Value(config, configField, parentKey);
        
        for (int i = 0; ; i++)
        {
            String entryName = entryPrefix+i;
            Object entry = options.get(entryName);
            if (entry == null)
            {
                if (i == 0)
                    throw new RuntimeException("Should not happen.");
                
                break;
            }
            
            if (!(entry instanceof String))
            {
                throw err("The config value " + config.getName() + "." + configField.getName() + 
                        " for " + target.getName() + 
                        " contains an entry that does not point to a field: " + entryName, 
                        config.eg.getProto());
            }
            
            String name = (String)entry;
            
            Field<?> f = target.getField(name);
            if (f == null)
            {
                throw err("The config value " + config.getName() + "." + configField.getName() + 
                        " for " + target.getName() + 
                        " contains an entry that does not point to a field: " + entryName, 
                        config.eg.getProto());
            }
            
            v.add(new Value.Entry(v, i, entryName, f));
        }
        
        if (resolvePermutations)
            v.resolvePermutations();
        
        return v;
    }
    
    static Value newVWithEnumValueRef(Config config, 
            EnumGroup.Value configField, String entryPrefix, 
            Map<String,Object> options)
    {
        final Value v = new Value(config, configField, null);
        
        for (int i = 0; ; i++)
        {
            String entryName = entryPrefix+i;
            Object entry = options.get(entryName);
            if (entry == null)
            {
                if (i == 0)
                    throw new RuntimeException("Should not happen.");
                
                break;
            }
            
            if (entry instanceof EnumGroup.Value 
                    && config.link == ((EnumGroup.Value)entry).getEnumGroup())
            {
                v.add(new Value.Entry(v, i, entryName, 
                        ((EnumGroup.Value)entry).field));
                
                continue;
            }
            
            throw err("The config value " + config.getName() + "." + configField.getName() + 
                    " for " + config.target.getName() + 
                    " contains an entry that does not belong to the link: " + entryName, 
                    config.eg.getProto());
        }
        
        return v;
    }
    
    static Value newVWithMessageRef(Config config, 
            EnumGroup.Value configField, String entryPrefix, 
            Map<String,Object> options)
    {
        final Value v = new Value(config, configField, null);
        
        for (int i = 0; ; i++)
        {
            String entryName = entryPrefix+i;
            Object entry = options.get(entryName);
            if (entry == null)
            {
                if (i == 0)
                    throw new RuntimeException("Should not happen.");
                
                break;
            }
            
            if (entry instanceof Message)
            {
                v.add(new Value.Entry(v, i, entryName, 
                        new EntryMessageField((Message)entry)));
                
                continue;
            }
                
            throw err("The config value " + config.getName() + "." + configField.getName() + 
                    " for " + config.target.getName() + 
                    " contains an entry that does not point to a message: " + entryName, 
                    config.eg.getProto());
        }
        
        return v;
    }
    
    static void validate(Config.Value.Entry e, Config.Value.Permutation p)
    {
        if (e.field != p.v.config.target.getField(e.field.getName()))
        {
            throw err("The config value " + p.v.config.getName() + "." + p.v.getName() + 
                    " for " + p.v.config.target.getName() + 
                    " contains an entry " + p.name + 
                    " that does not match the fields from " + 
                    p.resolvedValue.getName(), 
                    p.v.config.eg.getProto());
        }
    }
    
    static void validate(Config.Value.Permutation p)
    {
        if (p.getFieldCount() != p.getResolvedFields().size())
        {
            throw err("The config value " + p.v.config.getName() + "." + p.v.getName() + 
                    " for " + p.v.config.target.getName() + 
                    " contains an entry " + p.name + 
                    " that does not equal the number of fields from " + 
                    p.resolvedValue.getName(), 
                    p.v.config.eg.getProto());
        }
        
        for (Field<?> f : p.getResolvedFields())
        {
            if (!p.v.fieldNameEntries.containsKey(f.getName()))
            {
                throw err("The config value " + p.v.config.getName() + "." + p.v.getName() + 
                        " for " + p.v.config.target.getName() + 
                        " contains an entry " + p.name + 
                        " with a misconfigured incompatible value: " + 
                        p.resolvedValue.getName(), 
                        p.v.config.eg.getProto());
            }
        }
        
        for (Config.Value.Entry e : p.requiredList)
            validate(e, p);
        
        for (Config.Value.Entry e : p.optionalList)
            validate(e, p);
    }
    
    static <T extends HasName> StringBuilder appendNames(List<T> list, List<T> another)
    {
        StringBuilder sb = new StringBuilder();
        
        for (T hn : list)
            sb.append(hn.getName());
        
        for (T hn : another)
            sb.append(hn.getName());
        
        return sb;
    }
    
    final EnumGroup eg;
    final Message target;
    final EnumGroup link;
    final LinkedHashMap<String,Value> values = new LinkedHashMap<String,Value>();
    final LinkedHashMap<String,ArrayList<Value.Permutation>> servicePermutationsMap = 
            new LinkedHashMap<String,ArrayList<Value.Permutation>>();
    final LinkedHashMap<String,LinkedHashMap<String,Value.Permutation>> serviceRpcPermutationsMap = 
            new LinkedHashMap<String,LinkedHashMap<String,Value.Permutation>>(); 
    final EnumGroup.Value service;
    
    int bytesCount, keyCount;
    
    private Config(EnumGroup eg, Message target, EnumGroup link, EnumGroup.Value service)
    {
        this.eg = eg;
        this.target = target;
        this.link = link;
        this.service = service;
    }

    public String getName()
    {
        return eg.getName();
    }
    
    /**
     * Alias for {@link #getEnumGroup()}.
     */
    public EnumGroup getEg()
    {
        return eg;
    }

    public EnumGroup getEnumGroup()
    {
        return eg;
    }
    
    public Message getTarget()
    {
        return target;
    }
    
    public EnumGroup getLink()
    {
        return link;
    }
    
    public EnumGroup.Value getService()
    {
        return service;
    }
    
    public LinkedHashMap<String,Object> getParams()
    {
        return eg.getAnnotation("Config").getParams();
    }
    
    /**
     * Alias for {@link #getValueMap()}.
     */
    public LinkedHashMap<String,Value> getV()
    {
        return values;
    }
    
    public LinkedHashMap<String,Value> getValueMap()
    {
        return values;
    }
    
    public Collection<Value> getValues()
    {
        return values.values();
    }
    
    public int getValueSize()
    {
        return values.size();
    }
    
    public Map<String,Annotation> getA()
    {
        return eg.getA();
    }
    
    public LinkedHashMap<String,Object> getO()
    {
        return getOptions();
    }
    
    public LinkedHashMap<String,Object> getOptions()
    {
        return eg.getOptions();
    }
    
    public LinkedHashMap<String,ArrayList<Value.Permutation>> getServicePermutationsMap()
    {
        return servicePermutationsMap;
    }
    
    public LinkedHashMap<String,LinkedHashMap<String,Value.Permutation>> 
        getServiceRpcPermutationsMap()
    {
        return serviceRpcPermutationsMap;
    }
    
    public int getBytesCount()
    {
        return bytesCount;
    }
    
    public int getKeyCount()
    {
        return keyCount;
    }
    
    public static final class Value implements HasName
    {
        
        final Config config;
        final EnumGroup.Value v;
        final LinkedHashMap<String,Entry> entries = new LinkedHashMap<String,Entry>();
        final LinkedHashMap<String,Entry> fieldNameEntries = 
                new LinkedHashMap<String,Entry>();
        final ArrayList<Entry> entryList = new ArrayList<Entry>();
        private List<Entry> requiredList;
        
        final LinkedHashMap<String,Permutation> permutations = 
                new LinkedHashMap<String, Permutation>();
        
        final Field<?> parentKey;
        
        int keyCount, bytesCount, defaultValueCount, immutableCount, requiredCount;
        
        final EnumGroup.Value service;

        private Entry firstEntry, lastEntry;
        
        private boolean allRid, userMapped;
        
        public Value(Config config, EnumGroup.Value v, Field<?> parentKey)
        {
            this.config = config;
            this.v = v;
            this.parentKey = parentKey;
            
            service = (EnumGroup.Value)v.getOptions().get("service");
        }
        
        public Config getConfig()
        {
            return config;
        }
        
        public EnumGroup.Value getV()
        {
            return v;
        }
        
        public Field<?> getParentKey()
        {
            return parentKey;
        }
        
        public EnumGroup.Value getService()
        {
            return service;
        }
        
        public EnumGroup.Value getAvailableService()
        {
            return service == null ? config.service : service;
        }
        
        public boolean isServiceDifferentFromParent()
        {
            return service != null && service != config.service;
        }
        
        public EnumGroup getEg()
        {
            return v.getEnumGroup();
        }
        
        public EnumGroup getEnumGroup()
        {
            return v.getEnumGroup();
        }
        
        public String getName()
        {
            return v.getName();
        }
        
        public int getNumber()
        {
            return v.getNumber();
        }
        
        public Map<String,Annotation> getA()
        {
            return v.getA();
        }
        
        public LinkedHashMap<String,Object> getO()
        {
            return getOptions();
        }
        
        public LinkedHashMap<String,Object> getOptions()
        {
            return v.getOptions();
        }
        
        /**
         * Alias for {@link #getEntryMap()}.
         */
        public LinkedHashMap<String,Entry> getE()
        {
            return entries;
        }
        
        public LinkedHashMap<String,Entry> getEntryMap()
        {
            return entries;
        }
        
        /**
         * Alias for {@link #getFieldNameEntryMap()}.
         */
        public LinkedHashMap<String,Entry> getFne()
        {
            return fieldNameEntries;
        }
        
        public LinkedHashMap<String,Entry> getFieldNameEntryMap()
        {
            return fieldNameEntries;
        }
        
        public ArrayList<Entry> getEntries()
        {
            return entryList;
        }
        
        public int getEntrySize()
        {
            return entries.size();
        }
        
        public Entry getFirstEntry()
        {
            return firstEntry;
        }

        public Entry getLastEntry()
        {
            return lastEntry;
        }
        
        public boolean isOne()
        {
            return 1 == entries.size();
        }
        
        public int getOptionalStartIdx()
        {
            return requiredCount;
        }
        
        public List<Entry> getRequiredList()
        {
            return requiredList;
        }
        
        public int getKeyCount()
        {
            return keyCount;
        }
        
        public int getBytesCount()
        {
            return bytesCount;
        }
        
        public int getDefaultValueCount()
        {
            return defaultValueCount;
        }
        
        public int getImmutableCount()
        {
            return immutableCount;
        }
        
        public int getRequiredCount()
        {
            return requiredCount;
        }
        
        public int getOptionalCount()
        {
            return getEntrySize() - requiredCount;
        }
        
        /**
         * Is all required, immutable and has a default value?
         */
        public boolean isAllRid()
        {
            return allRid;
        }
        
        public boolean isAllBytes()
        {
            return getEntrySize() == bytesCount;
        }
        
        public boolean isAllRequired()
        {
            return getEntrySize() == requiredCount;
        }
        
        public boolean isAllDefaultValue()
        {
            return getEntrySize() == defaultValueCount;
        }
        
        public boolean isAllImmutable()
        {
            return getEntrySize() == immutableCount;
        }
        
        public boolean isUserMapped()
        {
            return userMapped;
        }
        
        public Collection<Permutation> getPermutations()
        {
            return permutations.values();
        }
        
        public LinkedHashMap<String,Permutation> getPermutationMap()
        {
            return permutations;
        }
        
        public String toString()
        {
            return getName();
        }
        
        void add(Entry e)
        {
            entries.put(e.name, e);
            
            if (e.isRequired() && ++requiredCount != entries.size())
            {
                String forTarget = config.target == null ? "" : 
                    " for " + config.target.getName();
                    
                throw err("The config value " + config.getName() + "." + getName() + 
                        forTarget + 
                        " must declare the required fields before the optional fields.", 
                        config.eg.getProto());
            }
            
            fieldNameEntries.put(e.field.getName(), e);
            entryList.add(e);
            
            if (firstEntry == null)
                firstEntry = e;
            
            lastEntry = e;
        }
        
        void addPermutation(Permutation p)
        {
            permutations.put(p.getName(), p);
            
            QueryUtil.appendTo(config.servicePermutationsMap, p, p.service.getName());
            
            QueryUtil.appendUnqiueTo(config.serviceRpcPermutationsMap, p, 
                    p.service.getName(), p.getRpcName());
        }
        
        void resolvePermutations()
        {
            if (requiredCount == 0)
            {
                throw err("The config " + config.getName() + 
                        " for " + config.target.getName() + 
                        " must not declare the first field as optional: " + getName(), 
                        config.eg.getProto());
            }
            
            // user-defined-permutation-mapping
            userMapped = !Boolean.TRUE.equals(getOptions().get("automap"));
            requiredList = entryList.subList(0, requiredCount);
            
            // the first permutation (all required)
            List<Entry> empty = Collections.emptyList();
            addPermutation(new Permutation(this, 
                    appendNames(requiredList, empty).toString(), 
                    requiredList, empty, userMapped));
            
            if (isAllRequired())
            {
                // we have all the permutations we need
                allRid = requiredCount == defaultValueCount 
                        && requiredCount == immutableCount;
                return;
            }
            
            final int start = requiredCount, size = getEntrySize();
            // start at the optional
            for (int count = 0, offset = start, oCount = getOptionalCount(); 
                    count < oCount; offset++, count++)
            {
                addPermutationTo(this, start, offset, size - offset, 
                        entryList, requiredList, null, userMapped);
            }
        }
        
        static void addPermutationTo(final Value v, 
                final int start, final int offset, final int size, 
                final List<Entry> entryList, final List<Entry> requiredList, 
                final List<Entry> prefix, 
                final boolean userMapped)
        {
            for (int c = 0, i = offset; c < size; c++, i++)
            {
                // permutation
                ArrayList<Entry> optionalList = new ArrayList<Entry>();
                
                if (prefix != null)
                    optionalList.addAll(prefix);
                
                for (int j = offset; j <= i; j++)
                    optionalList.add(entryList.get(j));
                
                v.addPermutation(new Permutation(v, 
                        appendNames(requiredList, optionalList).toString(), 
                        requiredList, optionalList, userMapped));
            }
            
            List<Entry> pfx = null;
            for (int i = 0, s = offset - start; s-- > 1; i++)
            {
                if (pfx == null)
                {
                    // lazy
                    if (prefix == null)
                    {
                        pfx = new ArrayList<Entry>(1);
                        pfx.add(entryList.get(offset));
                    }
                    else
                    {
                        pfx = new ArrayList<Entry>(1 + prefix.size());
                        pfx.addAll(prefix);
                        pfx.add(entryList.get(offset));
                    }
                }
                
                addPermutationTo(v, start, start + i, s, 
                        entryList, requiredList, pfx, userMapped);
            }
        }
        
        public static final class Entry implements HasName
        {
            final Value v;
            final int index;
            final String name;
            final Field<?> field;
            final boolean optional;
            final boolean immutable;
            final Object defaultValue;
            final Object endValue;
            
            public Entry(Value v, int index, String name, Field<?> field)
            {
                this.v = v;
                this.index = index;
                this.name = name;
                this.field = field;
                
                optional = Boolean.TRUE.equals(v.getOptions().get("o"+name));
                
                if (field.isBytesField())
                {
                    v.bytesCount++;
                    v.config.bytesCount++;
                    
                    if (field.getName().endsWith("_key"))
                    {
                        v.keyCount++;
                        v.config.keyCount++;
                    }
                }
                
                immutable = Boolean.TRUE.equals(v.getOptions().get("immutable_" + name));
                if (immutable)
                    v.immutableCount++;
                
                defaultValue = v.getOptions().get("default_" + name);
                if (defaultValue != null)
                    v.defaultValueCount++;
                
                endValue = v.getOptions().get("end_" + name);
            }
            
            public int getUniqueNumber()
            {
                return v.getNumber() | (field.getNumber() << 3);
            }
            
            public Value getV()
            {
                return v;
            }
            
            public int getIndex()
            {
                return index;
            }
            
            public String getName()
            {
                return name;
            }
            
            public Field<?> getField()
            {
                return field;
            }
            
            public boolean isOptional()
            {
                return optional;
            }
            
            public boolean isRequired()
            {
                return !optional;
            }
            
            public boolean isKey()
            {
                return field.isBytesField() && field.getName().endsWith("_key");
            }
            
            public boolean isImmutable()
            {
                return immutable;
            }
            
            public boolean isRequiredAndImmutable()
            {
                return isRequired() && isImmutable();
            }
            
            public Object getDefaultValue()
            {
                return defaultValue;
            }
            
            public boolean isDefaultValueSet()
            {
                return defaultValue != null;
            }
            
            public Object getEndValue()
            {
                return endValue;
            }
            
            public boolean isEndValueSet()
            {
                return endValue != null;
            }
            
            public boolean isRid()
            {
                return isRequiredAndImmutable() && isDefaultValueSet();
            }
            
            public boolean isRidr()
            {
                return isRequiredAndImmutable() && isDefaultValueSet() && 
                        isEndValueSet();
            }
            
            public String toString()
            {
                return getName();
            }
        }
        
        public static final class Permutation implements HasName
        {
            
            /**
             * Computes the args to compose a client query request.
             */
            public static final AttributeRenderer RENDERER = new AttributeRenderer()
            {
                public String toString(Object o, String ownerName, Locale locale)
                {
                    Permutation p = (Permutation)o;
                    StringBuilder sb = new StringBuilder();
                    
                    if (p.fieldCount != 1)
                    {
                        sb.append("io.protostuff.fbsgen.ds.gwt.prk.P")
                            .append(p.resolvedIdxString)
                            .append('.');
                        
                        if (p.nonLastDoubleCount != 0)
                            sb.append('$');
                        
                        sb.append("create(");
                    }
                    
                    final int last = p.resolvedFields.size() - 1;
                    for (int i = 0 ; i < last; i++)
                        appendArgString(p, p.resolvedFields.get(i), ownerName, sb);
                    
                    // last
                    appendArgLast(p, p.resolvedFields.get(last), ownerName, sb);
                    
                    if (p.fieldCount != 1)
                        sb.append(')');
                    
                    return sb.toString();
                }
            };
            
            static void appendArgString(Permutation p, 
                    Field<?> f, String ownerName, 
                    StringBuilder sb)
            {
                if (ownerName.charAt(0) == '.')
                {
                    // autocomplete params (use the provided default values)
                    Entry e = p.v.fieldNameEntries.get(f.getName());
                    if (f.isBoolField())
                        sb.append(Boolean.TRUE.equals(e.defaultValue) ? '1' : '0');
                    else if (f.isStringField() && p.lastResolvedEntry.field == f)
                        sb.append("str");
                    else
                        sb.append(e.defaultValue);
                    
                    sb.append(", ");
                    return;
                }
                
                sb.append(ownerName)
                    .append("get")
                    .append(ProtoUtil.toPascalCase(f.getName()))
                    .append("()");
                
                if (f.isBoolField())
                    sb.append(" ? 1 : 0");
                else if (f.isEnumField())
                    sb.append(".getNumber()");
                
                sb.append(", ");
            }
            
            static void appendArgLast(Permutation p, 
                    Field<?> f, String ownerName, 
                    StringBuilder sb)
            {
                sb.append("io.protostuff.fbsgen.ds.gwt.P")
                    .append(QueryUtil.getFieldIdxChar(f, p.v.v, p.v.config.target))
                    .append('.');
                
                if (f instanceof Field.Double)
                    sb.append('$');
                
                sb.append("create(");
                
                appendArgString(p, f, ownerName, sb);
                
                sb.append("prk)");
            }
            
            static StringBuilder appendIdxString(List<Entry> requiredList, 
                    List<Entry> optionalList)
            {
                StringBuilder sb = new StringBuilder();
                
                for (Entry e : requiredList)
                    sb.append(getFieldIdxChar(e.field, e.v.v, e.v.config.target));
                
                for (Entry e : optionalList)
                    sb.append(getFieldIdxChar(e.field, e.v.v, e.v.config.target));
                
                return sb;
            }
            
            static Entry getLastResolvedEntryFrom(List<Entry> requiredList, 
                    List<Entry> optionalList, ArrayList<Field<?>> fields)
            {
                Field<?> last = fields.get(fields.size()-1);
                for (Entry e : requiredList)
                {
                    if (last == e.field)
                        return e;
                }
                
                for (Entry e : optionalList)
                {
                    if (last == e.field)
                        return e;
                }
                
                throw new RuntimeException("Should not happen.");
            }
            
            final Value v;
            final String name;
            final List<Entry> requiredList, optionalList;
            final Entry lastEntry, lastResolvedEntry;
            final int fieldCount;
            final String idxString;
            
            final EnumGroup.Value resolvedValue;
            final ArrayList<Field<?>> resolvedFields;
            final String resolvedIdxString;
            
            final EnumGroup.Value service;
            final String rpcName;
            
            int nonLastDoubleCount;
            
            public Permutation(Value v, String name, List<Entry> requiredList, 
                    List<Entry> optionalList, boolean userMapped)
            {
                this.v = v;
                this.name = name;
                this.requiredList = requiredList;
                this.optionalList = optionalList;
                this.fieldCount = requiredList.size() + optionalList.size();
                idxString = appendIdxString(requiredList, optionalList).toString();
                
                if (fieldCount == 1)
                {
                    // single field
                    if (v.config.link == null)
                    {
                        throw err("The config value " + v.config.getName() + "." + v.getName() + 
                                " for " + v.config.target.getName() + 
                                " must have a link |E.g @Config(link = Foo)| " + 
                                " in order to resolve the entry: " + name, 
                                v.config.eg.getProto());
                    }
                    String fieldName = (String)v.getOptions().get(name);
                    resolvedValue = v.config.link.getValue(fieldName.toUpperCase());
                }
                else if (userMapped)
                {
                    // permutation
                    try
                    {
                        resolvedValue = (EnumGroup.Value)v.getOptions().get(name);
                    }
                    catch (RuntimeException e)
                    {
                        throw err("The config value " + v.config.getName() + "." + v.getName() + 
                                " for " + v.config.target.getName() + 
                                " contains an entry that points to nothing: " + name, 
                                v.config.eg.getProto());
                    }
                }
                else
                {
                    // TODO
                    throw err("Auto-mapping of permutations not yet implemented: " + 
                            v.config.getName() + "." + v.getName(), 
                            v.config.eg.getProto());
                }
                
                if (resolvedValue == null)
                {
                    throw err("The config value " + v.config.getName() + "." + v.getName() + 
                            " for " + v.config.target.getName() + 
                            " with the entry " + name + 
                            " does not point to an existing secondary index entry.", 
                            v.config.eg.getProto());
                }
                
                lastEntry = optionalList.isEmpty() ? 
                        requiredList.get(requiredList.size()-1) : 
                            optionalList.get(optionalList.size()-1);
                
                EnumGroup.Value service = (EnumGroup.Value)v.getOptions().get(
                        "service_" + name);
                
                // resolve to the the parent's service if null
                if (null == service && null == (service=v.service) 
                        && null == (service=v.config.service))
                {
                    throw err("The config value " + v.config.getName() + "." + v.getName() + 
                            " for " + v.config.target.getName() + 
                            " must define an option entry: service_" + name, 
                            v.config.eg.getProto());
                }
                
                this.service = service;
                
                resolvedFields = getUusvFields(v.getNumber() < 224, 
                        resolvedValue, v.config.target);
                
                lastResolvedEntry = getLastResolvedEntryFrom(requiredList, optionalList, 
                        resolvedFields);
                
                StringBuilder sb = new StringBuilder();
                for (Field<?> f : resolvedFields)
                {
                    sb.append(getFieldIdxChar(f, resolvedValue, v.config.target));
                    
                    if (f instanceof Field.Double)
                        nonLastDoubleCount++;
                }
                
                // if the last one was a double, discard it
                if (resolvedFields.get(resolvedFields.size()-1) instanceof Field.Double)
                    nonLastDoubleCount--;
                
                resolvedIdxString = sb.toString();
                
                validate(this);
                
                rpcName = new StringBuilder()
                    .append('q')
                    .append(v.config.target.getName())
                    .append('0')
                    .append(ProtoUtil.toPascalCase(resolvedValue.getName().toLowerCase()))
                    .toString();
            }
            
            public String getUniqueConstantName()
            {
                final StringBuilder sb = new StringBuilder().append("Q_");
                
                int i = 0;
                Entry first = requiredList.get(i);
                sb.append(first.field.getName().toUpperCase());
                if (first.defaultValue != null && first.immutable)
                    sb.append(first.defaultValue);
                
                for (int len = requiredList.size(); ++i < len;)
                {
                    Entry e = requiredList.get(i);
                    sb.append("__").append(e.field.getName().toUpperCase());
                    if (e.defaultValue != null)
                        sb.append(e.defaultValue);
                }
                
                for (int j = 0, len = optionalList.size(); j < len; j++)
                {
                    Entry e = optionalList.get(j);
                    sb.append("__").append(e.field.getName().toUpperCase());
                }
                
                return sb.toString();
            }
            
            public boolean isAllRequired()
            {
                return optionalList.isEmpty();
            }
            
            public EnumGroup.Value getResolvedValue()
            {
                return resolvedValue;
            }
            
            public ArrayList<Field<?>> getResolvedFields()
            {
                return resolvedFields;
            }
            
            public String getResolvedIdxString()
            {
                return resolvedIdxString;
            }
            
            public Entry getLastResolvedEntry()
            {
                return lastResolvedEntry;
            }
            
            public Value getV()
            {
                return v;
            }

            public String getName()
            {
                return name;
            }
            
            public boolean isRequiredPresent()
            {
                return !requiredList.isEmpty();
            }
            
            public List<Entry> getRequiredList()
            {
                return requiredList;
            }
            
            public List<Entry> getOptionalList()
            {
                return optionalList;
            }
            
            public int getFieldCount()
            {
                return fieldCount;
            }
            
            public String getIdxString()
            {
                return idxString;
            }
            
            public Entry getLastEntry()
            {
                return lastEntry;
            }
            
            public EnumGroup.Value getService()
            {
                return service;
            }
            
            public String getRpcName()
            {
                return rpcName;
            }

            @Override
            public String toString()
            {
                return name + " => " + getResolvedValue();
            }
            
            public int getOrJoinedId()
            {
                int x = 0;
                
                for (Entry e : getRequiredList())
                    x |= (1 << e.index);
                
                for (Entry e : getOptionalList())
                    x |= (1 << e.index);
                
                return x;
            }
        }
    }
}
