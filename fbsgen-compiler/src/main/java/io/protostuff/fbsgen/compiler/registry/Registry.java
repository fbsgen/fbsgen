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


package io.protostuff.fbsgen.compiler.registry;

import static io.protostuff.fbsgen.compiler.CompilerUtil.COMMA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.compiler.ProtoModule;
import io.protostuff.fbsgen.compiler.map.IsMessageMap;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.HasName;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.Proto;
import io.protostuff.fbsgen.parser.ProtoUtil;
import io.protostuff.fbsgen.parser.Service;

/**
 * Contains all necessary proto components for codegen.
 *
 * @author David Yu
 * @created Dec 25, 2011
 */
public final class Registry
{
    
    public static final boolean INSPECT = Boolean.getBoolean("registry.inspect");
    
    static final int MIN_ADJECTIVE_LEN = Integer.getInteger("rpc.min_adjective_len", 3);
    
    final FakeMap lookupEntityMap = new FakeMap("lookupEntityMap")
    {
        public Object get(Object key)
        {
            String name = String.valueOf(key);
            Message entity = relEntityMap.get(name);
            if (entity == null && name.length() > MIN_ADJECTIVE_LEN)
            {
                // the starting string could be an adjective
                for (int i = MIN_ADJECTIVE_LEN, len = name.length(); i < len; i++)
                {
                    if (Verbs.isUppercase(name.charAt(i)) && 
                            null != (entity=relEntityMap.get(name.substring(i))))
                    {
                        // stripped the adjective and found the entity
                        //System.out.println(name + " > " + entity.getName());
                        return entity;
                    }
                }
            }
            
            return entity;
        }
    };
    
    private final ArrayList<Proto> protos = new ArrayList<Proto>();
    final HashMap<String,ArrayList<Proto>> stgProtoMapping = 
            new HashMap<String, ArrayList<Proto>>();
    
    final HashMap<String,Proto> protoPathMap = new HashMap<String,Proto>();
    
    private final ArrayList<Message> messages = new ArrayList<Message>();
    final HashMap<String,ArrayList<Message>> stgMessageMapping = 
            new HashMap<String, ArrayList<Message>>();
    
    private final ArrayList<EnumGroup> enumGroups = new ArrayList<EnumGroup>();
    final HashMap<String,ArrayList<EnumGroup>> stgEnumGroupMapping = 
            new HashMap<String, ArrayList<EnumGroup>>();
    
    private final ArrayList<Service> services = new ArrayList<Service>();
    //final HashMap<String,ArrayList<Service>> stgServiceMapping = 
    //        new HashMap<String, ArrayList<Service>>();
    
    private final ArrayList<Message> entities = new ArrayList<Message>();
    private final HashMap<String,ArrayList<Message>> entityParentChildMapping = 
            new HashMap<String, ArrayList<Message>>();
    // by relative name
    final LinkedHashMap<String,Message> relEntityMap = new LinkedHashMap<String,Message>();
    //final LinkedHashMap<String,Message> entityPathMap = new LinkedHashMap<String,Message>();
    
    private final LinkedHashMap<String,HasName> nameMap = new LinkedHashMap<String, HasName>();

    /* ================================================== */
    
    //private final ArrayList<EnumGroup> configs = new ArrayList<EnumGroup>();
    private final HashMap<String,LinkedHashMap<String,ArrayList<Config.Value.Permutation>>> pkgServicePermutationsMap = 
            new HashMap<String,LinkedHashMap<String,ArrayList<Config.Value.Permutation>>>();
    
    private final HashMap<String,LinkedHashMap<String,ArrayList<Service>>> pkgNestedServicesMap = 
            new HashMap<String,LinkedHashMap<String,ArrayList<Service>>>();
    
    public LinkedHashMap<String, HasName> getNameMap()
    {
        return nameMap;
    }
    
    public Collection<HasName> getNames()
    {
        return nameMap.values();
    }
    
    public ArrayList<Proto> getProtos()
    {
        return protos;
    }
    
    public ArrayList<Message> getMessages()
    {
        return messages;
    }
    
    public ArrayList<EnumGroup> getEnumGroups()
    {
        return enumGroups;
    }
    
    public ArrayList<Service> getServices()
    {
        return services;
    }
    
    public ArrayList<Message> getEntities()
    {
        return entities;
    }
    
    public LinkedHashMap<String,Message> getRelEntityMap()
    {
        return relEntityMap;
    }
    
    public FakeMap getLookupEntityMap()
    {
        return lookupEntityMap;
    }
    
    /*public LinkedHashMap<String,Message> getEntityPathMap()
    {
        return entityPathMap;
    }*/
    
    public HashMap<String,LinkedHashMap<String,ArrayList<Config.Value.Permutation>>> 
        getPkgServicePermutationsMap()
    {
        return pkgServicePermutationsMap;
    }
    
    public HashMap<String,LinkedHashMap<String,ArrayList<Service>>>
        getPkgNestedServicesMap()
    {
        return pkgNestedServicesMap;
    }
    
    private void put(HasName name)
    {
        HasName last = nameMap.put(name.getName(), name);
        if (last != null && last instanceof Field && ((Field<?>)last).isRequired())
        {
            // don't override required fields.
            nameMap.put(last.getName(), last);
        }
    }
    
    void add(EnumGroup.Value v, ProtoModule module)
    {
        put(v);
    }
    
    void add(Field<?> field, ProtoModule module)
    {
        put(field);
        
        if (!INSPECT || !IsMessageMap.Functions.ENTITY.query(field.getOwner()))
            return;
        
        if (field.isBytesField() && field.getName().endsWith("_key"))
        {
            if (Boolean.TRUE.equals(field.getOption("provided")))
            {
                if (!Boolean.TRUE.equals(field.getOption("immutable")) 
                        && !Boolean.TRUE.equals(field.getOption("readonly")))
                {
                    String sourcePath = field.getOwner().getProto().getSourcePath();
                    int entityIdx = sourcePath.indexOf("entity/");
                    if (entityIdx == -1)
                        return;
                    
                    // only print when inside entity dir
                    System.err.println("Could be immutable/readonly:");
                    System.err.print(field.getName() + " @ ");
                    System.err.print(field.getOwner().getRelativeName());
                    System.err.print(" (");
                    System.err.print(sourcePath.substring(entityIdx));
                    System.err.println(")");
                }
            }
            else if (!field.isRequired())
            {
                String sourcePath = field.getOwner().getProto().getSourcePath();
                int entityIdx = sourcePath.indexOf("entity/");
                if (entityIdx == -1)
                    return;
                
                // only print when inside entity dir
                System.err.println("Could be required/provided/readonly:");
                System.err.print(field.getName() + " @ ");
                System.err.print(field.getOwner().getRelativeName());
                System.err.print(" (");
                System.err.print(sourcePath.substring(entityIdx));
                System.err.println(")");
            }
        }
    }
    
    void add(final Message message, ProtoModule module)
    {
        messages.add(message);
        
        final Message entityOrParent = EntityUtil.fill(message);
        if (entityOrParent != null)
        {
            // entity
            entities.add(message);
            
            if (entityOrParent != message)
            {
                // its the parent
                CollectionUtil.addTo(entityParentChildMapping, message, 
                        entityOrParent.getRelativeName());
            }
            
            if (null != relEntityMap.put(message.getRelativeName(), message))
                System.out.println("Warning: duplicate entity name: " + message.getRelativeName());
            // TODO put it in path map?
            //String key = message.getProto().getSourcePath() + message.getRelativeName();
            //entityPathMap.put(key, message);
        }
        
        String stgs = (String)message.getOptions().get("stgs");
        if (stgs != null)
        {
            addTo(stgMessageMapping, message, module, COMMA.split(stgs), 
                    message.getProto());
        }
    }
    
    void add(EnumGroup enumGroup, ProtoModule module)
    {
        enumGroups.add(enumGroup);
        
        Config config = Config.getConfig(enumGroup);
        if (config != null && "Q".equals(config.getName()) && 
                config.link != null && "SI".equals(config.link.getName()))
        {
            // map to services
            
            String pkg = null;
            
            for (String key : config.serviceRpcPermutationsMap.keySet())
            {
                LinkedHashMap<String,Config.Value.Permutation> rpcMap = 
                        config.serviceRpcPermutationsMap.get(key);
                
                // lazy
                if (pkg == null)
                    pkg = enumGroup.getProto().getDeclaredPackageName();
                
                QueryUtil.appendListTo(pkgServicePermutationsMap, 
                        rpcMap.values(), 
                        pkg, key);
            }
        }
        
        String stgs = (String)enumGroup.getOptions().get("stgs");
        if (stgs != null)
        {
            addTo(stgEnumGroupMapping, enumGroup, module, COMMA.split(stgs), 
                    enumGroup.getProto());
        }
    }
    
    void add(Service service, ProtoModule module)
    {
        if (service.isNested())
        {
            // map to services
            String pkg = service.getProto().getDeclaredJavaPackageName();
            QueryUtil.appendTo(pkgNestedServicesMap, service, pkg, service.getName());
        }
        else
        {
            services.add(service);
        }
        
        /*String stgs = (String)service.getOptions().get("stgs");
        if (stgs == null)
            return;
        
        for (String stg : CompilerMain.COMMA.split(stgs))
            addTo(stgServiceMapping, stg.trim(), service);*/
    }
    
    void add(Proto proto, ProtoModule module)
    {
        protos.add(proto);
        
        protoPathMap.put(proto.getSourcePath(), proto);
        
        String stgs = (String)proto.getOptions().get("stgs");
        if (stgs != null)
            addTo(stgProtoMapping, proto, module, COMMA.split(stgs), proto);
    }
    
    void complete()
    {
        for (EnumGroup eg : enumGroups)
        {
            String key = ProtoUtil.toUnderscoreCase(eg.getName()).toString();
            if (!nameMap.containsKey(key))
            {
                nameMap.put(key, eg);
            }
        }
        
        for (Message entity : entities)
        {
            String key = ProtoUtil.toUnderscoreCase(entity.getName()).toString();
            if (!nameMap.containsKey(key))
            {
                nameMap.put(key, entity);
            }
            
            ArrayList<Message> children = entityParentChildMapping.get(
                    entity.getRelativeName());
            
            // also check if this attribute has already been set
            if (children == null || entity.getOptions().containsKey("~entity.children"))
                continue;
            
            /*int set = 0;
            for (Message child : children)
            {
                if (child == entity)
                {
                    throw err("An entity cannot be its own parent: " + 
                            entity.getRelativeName());
                }
                
                set |= ((Integer)entity.getOptions().get("~entity.kind")).intValue();
            }
            
            entity.getOptions().put("~entity.children_intset", set);*/
            entity.getOptions().put("~entity.children", children);
        }
    }
    
    private static <T> void addTo(final HashMap<String,ArrayList<T>> map, final T entry, 
            final ProtoModule module, final String[] stgs, final Proto proto)
    {
        for (String stg : stgs)
        {
            stg = stg.trim();
            
            if (stg.charAt(0) == '_')
            {
                // search in proto, then options then config
                String csv = proto == null ? null : (String)proto.getOptions().get(stg);
                if (null != csv 
                        || null != (csv = module.getOptions().getProperty(stg))
                        || null != (csv = module.getConfig().getProperty(stg)))
                {
                    // referenced
                    addTo(map, entry, module, COMMA.split(csv), null);
                    continue;
                }
            }
            
            CollectionUtil.addTo(map, entry, stg);
        }
    }
    

}