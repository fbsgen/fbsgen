//========================================================================
//Copyright 2007-2009 David Yu dyuproject@gmail.com
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

package com.dyuproject.fbsgen.parser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains the metadata of parsed protos.
 * Basically repesents the .proto file.
 *
 * @author David Yu
 * @created Dec 18, 2009
 */
public final class Proto extends AnnotationContainer implements HasOptions, HasName
{
    static abstract class RefEntry
    {
        abstract Object get();
        abstract void put(Object obj);
    }
    static final class ListRefEntry extends RefEntry
    {
        final int idx;
        final List<Object> list;
        
        ListRefEntry(int idx, List<Object> list)
        {
            this.idx = idx;
            this.list = list;
        }
        @Override
        Object get()
        {
            return list.get(idx);
        }
        @Override
        void put(Object obj)
        {
            list.set(idx, obj);
        }
    }
    static final class MapRefEntry extends RefEntry
    {
        final String key;
        final Map<String, Object> map;
        
        MapRefEntry(String key, Map<String, Object> map)
        {
            this.key = key;
            this.map = map;
        }
        @Override
        Object get()
        {
            return map.get(key);
        }
        @Override
        void put(Object obj)
        {
            map.put(key, obj);
        }
    }
  
    static final boolean IMPLICIT_TYPE_ANNOTATIONS = Boolean.getBoolean("proto.implicit_type_annotations");
    
    transient final File file;
    // if loaded form classpath.
    transient final URL url;
    transient final Loader loader;
    final Proto importer;
    Mutable<String> packageName;
    transient Mutable<String> javaPackageName;
    final LinkedHashMap<String, Proto> importedProtos = new LinkedHashMap<String, Proto>();
    final ArrayList<String> importPaths = new ArrayList<String>();
    transient final LinkedHashMap<String,Object> standardOptions = new LinkedHashMap<String,Object>();
    final LinkedHashMap<String,Object> extraOptions = new LinkedHashMap<String,Object>();
    final LinkedHashMap<String, Message> messages = new LinkedHashMap<String, Message>();
    final LinkedHashMap<String, EnumGroup> enumGroups = new LinkedHashMap<String, EnumGroup>();
    final LinkedHashMap<String, Service> services = new LinkedHashMap<String, Service>();
    //final ArrayList<Extension> extensions = new ArrayList<Extension>();
    final LinkedHashMap<String, Message> fullyQualifiedMessages = new LinkedHashMap<String, Message>();
    final LinkedHashMap<String, EnumGroup> fullyQualifiedEnumGroups = new LinkedHashMap<String, EnumGroup>();
    
    // from options and annotations
    transient final ArrayList<ConfiguredReference> references = new ArrayList<ConfiguredReference>();
    transient final ArrayList<Annotation> typeAnnotations = new ArrayList<Annotation>();
    
    // list/map values that point to messages/enums/etc
    transient final ArrayList<RefEntry> jsonReferences = new ArrayList<RefEntry>();
    
    transient int refOffset;
    
    private String sourcePath;
    
    public Proto()
    {
        this((File)null, null, null);
    }
    
    public Proto(File file)
    {
        this(file, null, null);
    }
    
    public Proto(Loader loader)
    {
        this((File)null, loader, null);
    }
    
    public Proto(File file, Loader loader)
    {
        this(file, loader, null);
    }
    
    public Proto(File file, Loader loader, Proto importer)
    {
        this.url = null;
        
        this.file = file;
        this.loader = loader;
        this.importer = importer;
    }
    
    public Proto(URL url, Loader loader, Proto importer)
    {
        this.file = null;
        
        this.url = url;
        this.loader = loader;
        this.importer = importer;
    }
    
    void checkAnnotations()
    {
        if (!annotations.isEmpty())
            throw err(this, "Misplaced annotations: " + annotations);
    }
    
    void addComment(String comment)
    {
        // exclude the space from "/// text"
        int start = 3, 
                end = comment.length()-1;
        
        if (comment.charAt(end-1) == '\r')
            end--;
        
        if (comment.charAt(start) == ' ')
            start++;
        
        comments.add(comment.substring(start, end));
    }
    
    public String getName()
    {
        return getSourcePath();
    }
    
    public Proto getProto()
    {
        return this;
    }
    
    public ErrorMap getError()
    {
        return ErrorMap.INSTANCE;
    }
    
    public File getFile()
    {
        return file;
    }
    
    public String getSourcePath()
    {
        if (sourcePath == null)
            sourcePath = file == null ? String.valueOf(url) : file.toString();
            
        return sourcePath;
    }
    
    public Mutable<String> getMutablePackageName()
    {
        return packageName;
    }
    
    public String getPackageName()
    {
        return packageName == null ? null : packageName.getValue();
    }
    
    /**
     * Returns the package name that was declared in the proto.
     * Note that {@link #getPackageName()} will have the same value as this, 
     * if the compiler options did not have entries that override it.
     */
    public String getDeclaredPackageName()
    {
        return packageName == null ? null : packageName.getLastOrValue();
    }
    
    public Mutable<String> getMutableJavaPackageName()
    {
        return javaPackageName;
    }
    
    public String getJavaPackageName()
    {
        return javaPackageName.getValue();
    }
    
    /**
     * Returns the java package name that was declared in the proto.
     * Note that {@link #getJavaPackageName()} will have the same value as this, 
     * if the compiler options did not have entries that override it.
     */
    public String getDeclaredJavaPackageName()
    {
        return javaPackageName == null ? null : javaPackageName.getLastOrValue();
    }
    
    void setPackageName(String packageName)
    {
        if (this.packageName == null)
            this.packageName = new Mutable<String>(packageName);
    }
    
    public LinkedHashMap<String,Object> getStandardOptions()
    {
        return standardOptions;
    }
    
    public Object getStandardOption(String name)
    {
        return standardOptions.get(name);
    }
    
    public LinkedHashMap<String,Object> getExtraOptions()
    {
        return extraOptions;
    }
    
    public LinkedHashMap<String,Object> getO()
    {
        return getOptions();
    }

    public LinkedHashMap<String,Object> getOptions()
    {
        return extraOptions;
    }
    
    public void addRefTo(List<Object> list, String value)
    {
        jsonReferences.add(new ListRefEntry(list.size(), list));
        list.add(value);
    }
    
    public void putRefTo(Map<String, Object> map, String key, String value)
    {
        jsonReferences.add(new MapRefEntry(key, map));
        map.put(key, value);  
    }
    
    public void putStandardOption(String key, Object value)
    {
        putExtraOption(key, value);
        standardOptions.put(key, value);
    }
    
    public void putExtraOption(String key, Object value)
    {
        if (extraOptions.put(key, value) != null)
            throw err("Cannot have multiple definitions of the option: " + key, getProto());
    }
    
    @SuppressWarnings("unchecked")
    public <V> V getExtraOption(java.lang.String key)
    {
        return (V)extraOptions.get(key);
    }
    
    public Map<String,Message> getMessageMap()
    {
        return messages;
    }
    
    /**
     * Alias to {@link #getMessageMap()}.
     */
    public Map<String,Message> getM()
    {
        return getMessageMap();
    }
    
    public Collection<Message> getMessages()
    {
        return messages.values();
    }
    
    public Message getMessage(String name)
    {
        return messages.get(name);
    }
    
    void addMessage(Message message)
    {
        if (messages.put(message.name, message) != null)
            throw err(message, " cannot be defined more than once.", this);
    }
    
    public Map<String,EnumGroup> getEnumGroupMap()
    {
        return enumGroups;
    }
    
    /**
     * Alias to {@link #getEnumGroupMap()}.
     */
    public Map<String,EnumGroup> getE()
    {
        return getEnumGroupMap();
    }
    
    public Collection<EnumGroup> getEnumGroups()
    {
        return enumGroups.values();
    }
    
    public EnumGroup getEnumGroup(String name)
    {
        return enumGroups.get(name);
    }
    
    void addEnumGroup(EnumGroup enumGroup)
    {
        if (enumGroups.put(enumGroup.name, enumGroup) != null)
            throw err(enumGroup, " cannot be defined more than once.", this);
    }
    
    public Map<String,Service> getServiceMap()
    {
        return services;
    }
    
    /**
     * Alias to {@link #getServiceMap()}.
     */
    public Map<String,Service> getS()
    {
        return getServiceMap();
    }
    
    public Collection<Service> getServices()
    {
        return services.values();
    }
    
    public Service getService(String name)
    {
        return services.get(name);
    }
    
    void addService(Service service)
    {
        if (services.put(service.name, service) != null)
            throw err(service, " cannot be defined more than once.", this);
    }

    /*public void addExtension(Extension extension)
    {
        extensions.add(extension);
    }

    public Collection<Extension> getExtensions()
    {
        return extensions;
    }*/

    public ArrayList<String> getImportPaths()
    {
        return importPaths;
    }
    
    public Collection<Proto> getImportedProtos()
    {
        return importedProtos.values();
    }
    
    public Proto getImportedProto(File file)
    {
        return importedProtos.get(file.toURI().toString());
    }
    
    public Proto getImportedProto(URL url)
    {
        return importedProtos.get(url.toString());
    }
    
    public Proto getImportedProto(String url)
    {
        return importedProtos.get(url);
    }
    
    void importProto(String path)
    {
        if (loader == null)
            throw err("Failed to import " + path + " (No loader set)", this);
        try
        {
            addImportedProto(loader.load(path, this));
        }
        catch (IOException e)
        {
            throw err("Failed to import " + path, this);
        }
        importPaths.add(path);
    }
    
    void addImportedProto(Proto proto)
    {
        if (proto.url == null)
            importedProtos.put(proto.file.toURI().toString(), proto);
        else
            importedProtos.put(proto.url.toString(), proto);
    }
    
    void postParse()
    {
        if (packageName == null)
            throw err("proto package not defined", this);
        
        String javaPkg = (String)extraOptions.get("java_package");
        String javaPackageName = javaPkg == null || javaPkg.length()==0 ? 
                packageName.getValue() : javaPkg;
        this.javaPackageName = new Mutable<String>(javaPackageName);
        
        // Cache all fully-qualified message names and enum group names so we
        // can look them up quickly
        for (Message m : getMessages())
            m.cacheFullyQualifiedNames();
        for (EnumGroup eg : getEnumGroups())
            eg.cacheFullyQualifiedName();
        
        for (Message m : getMessages())
            m.resolveReferences(m);
        
        for (Service s : getServices())
            s.resolveReferences();

        //for (Extension e : getExtensions())
        //  e.resolveReferences();
        
        for (ConfiguredReference r : references)
            r.resolve(this);
        
        if (!standardOptions.isEmpty())
            ConfiguredReference.resolve(this, standardOptions, extraOptions, getPackageName());
        
        if (!jsonReferences.isEmpty())
            ConfiguredReference.resolveJsonRefs(this, jsonReferences, getPackageName());
    }
    
    public void add(Annotation annotation)
    {
        super.add(annotation);
        
        if (Character.isLowerCase(annotation.name.charAt(0)))
            typeAnnotations.add(annotation);
        
        if (!annotation.refs.isEmpty())
            references.add(new ConfiguredReference(annotation.refs, annotation.params, null));
    }
    
    void addAnnotationsTo(Message target)
    {
        if (target.addAnnotations(this, true))
        {
            if (refOffset != references.size())
            {
                String enclosingNamespace = target.getFullName();
                int size = references.size();
                while (refOffset < size)
                    references.get(refOffset++).enclosingNamespace = enclosingNamespace;
            }
        }
        
        if (typeAnnotations.isEmpty())
            return;
        
        if (typeAnnotations.size() > 1)
            throw err(target, " has multiple (must only be one) type annotations: " + typeAnnotations, this);
        
        target.typeAnnotation = typeAnnotations.remove(0);
    }
    
    void addAnnotationsTo(EnumGroup target)
    {
        if (target.addAnnotations(this, true))
        {
            if (refOffset != references.size())
            {
                String enclosingNamespace = target.getFullName();
                int size = references.size();
                while (refOffset < size)
                    references.get(refOffset++).enclosingNamespace = enclosingNamespace;
            }
        }
        
        if (typeAnnotations.isEmpty())
        {
            if (IMPLICIT_TYPE_ANNOTATIONS)
                target.typeAnnotation = new Annotation("uint8", this);
            return;
        }
        
        if (typeAnnotations.size() > 1)
            throw err(target, " has multiple (must only be one) type annotations: " + typeAnnotations, this);
        
        target.typeAnnotation = typeAnnotations.remove(0);
    }
    
    void addAnnotationsTo(EnumGroup.Value target)
    {
        if (target.addAnnotations(this, true))
        {
            if (refOffset != references.size())
            {
                String enclosingNamespace = target.getEnumGroup().getFullName();
                int size = references.size();
                while (refOffset < size)
                    references.get(refOffset++).enclosingNamespace = enclosingNamespace;
            }
        }
        
        if (typeAnnotations.isEmpty())
            return;
        
        if (typeAnnotations.size() > 1)
            throw err(target, " has multiple (must only be one) type annotations: " + typeAnnotations, this);
        
        target.typeAnnotation = typeAnnotations.remove(0);
    }
    
    void addAnnotationsTo(Field<?> target, String enclosingNamespace)
    {
        if (target.addAnnotations(this, true))
        {
            if (refOffset != references.size())
            {
                int size = references.size();
                while (refOffset < size)
                    references.get(refOffset++).enclosingNamespace = enclosingNamespace;
            }
        }
        
        if (typeAnnotations.isEmpty())
            return;
        
        if (typeAnnotations.size() > 1)
            throw err(target, " has multiple (must only be one) type annotations: " + typeAnnotations, this);
        
        target.typeAnnotation = typeAnnotations.remove(0);
    }
    
    void addAnnotationsTo(Service target)
    {
        // enclosingNamespace not necessary
        if (target.addAnnotations(this, true))
            refOffset = references.size();
        
        if (typeAnnotations.isEmpty())
            return;
        
        if (typeAnnotations.size() > 1)
            throw err(target, " has multiple (must only be one) type annotations: " + typeAnnotations, this);
        
        target.typeAnnotation = typeAnnotations.remove(0);
    }
    
    void addAnnotationsTo(Service.RpcMethod target)
    {
        // enclosingNamespace not necessary
        if (target.addAnnotations(this, true))
            refOffset = references.size();
        
        if (typeAnnotations.isEmpty())
            return;
        
        if (typeAnnotations.size() > 1)
            throw err(target, " has multiple (must only be one) type annotations: " + typeAnnotations, this);
        
        target.typeAnnotation = typeAnnotations.remove(0);
    }
    
    /*void addAnnotationsTo(Extension target)
    {
        if (target.addAnnotations(this, true))
        {
            if (refOffset != references.size())
            {
                String enclosingNamespace = target.getEnclosingNamespace();
                int size = references.size();
                while (refOffset < size)
                    references.get(refOffset++).enclosingNamespace = enclosingNamespace;
            }
        }
    }*/
    
    /**
     * Given the name of a Message/EnumGroup reference and the namespace 
     * enclosing that reference (can be a full message name or package 
     * name), returns the referenced object if it exists.
     * 
     * @param fullRefName The full name of the object as specified by the reference,
     *    including a package name if it was specified
     * @param fullEnclosingNamespace The full enclosing namespace of the reference
     * @return A Message or EnumGroup instance, or null
     */
    HasName findReference(String fullRefName, String enclosingNamespace)
    {
        boolean doneSearch = false;
        
        // Special case: if fullRefName begins with a period it is a fully qualified
        // name so just search for that (but strip off the initial dot!)
        if (fullRefName.charAt(0) == '.')
            return findFullyQualifiedObject(fullRefName.substring(1));
        
        // Search for the object in the enclosing namespace, as well as each parent
        // namespace until we find the object
        while (!doneSearch)
        {
            String searchName = (enclosingNamespace == null ? fullRefName : enclosingNamespace + '.' + fullRefName);
            HasName obj = findFullyQualifiedObject(searchName);
            if (obj != null)
                return obj;
            
            // We didn't find the object. Strip off the last component of the
            // namespace and try again
            if (enclosingNamespace != null)
            {
                int dotIndex = enclosingNamespace.lastIndexOf('.');
                if (dotIndex < 0)
                    enclosingNamespace = null;
                else
                    enclosingNamespace = enclosingNamespace.substring(0, dotIndex);
            }
            else
            {
                doneSearch = true;
            }
        }
        
        // If we didn't find a match using the normal protobuf-compatible
        // lookup method, try searching each imported .proto as if we were
        // in their namespace
        for (Proto proto : getImportedProtos())
        {
            String searchName = (proto.getPackageName() == null ? fullRefName : proto.getPackageName() + '.' + fullRefName);
            HasName result = proto.findFullyQualifiedObject(searchName);
            if (result != null)
                return result;
        }
        
        // No results
        return null;
    }
    
    Message findMessageReference(String fullRefName, String enclosingNamespace)
    {
        HasName refObj = findReference(fullRefName, enclosingNamespace);
        if (refObj instanceof Message)
            return (Message) refObj;
        else
            return null;
    }
    
    EnumGroup findEnumGroupReference(String fullRefName, String enclosingNamespace)
    {
        HasName refObj = findReference(fullRefName, enclosingNamespace);
        if (refObj instanceof EnumGroup)
            return (EnumGroup) refObj;
        else
            return null;
    }
    
    /**
     * Returns a Message or EnumGroup given its fully qualified name
     * @param fullyQualifiedName The fully qualified name, without an
     *     initial dot ('.')
     * @return The Message or EnumGroup instance if it is defined in
     *     this Proto or one of its imports.
     */
    HasName findFullyQualifiedObject(String fullyQualifiedName)
    {
        Message m = fullyQualifiedMessages.get(fullyQualifiedName);
        if (m != null)
            return m;
        
        EnumGroup eg = fullyQualifiedEnumGroups.get(fullyQualifiedName);
        if (eg != null)
            return eg;
        
        // Search imported protos as well
        for (Proto proto : getImportedProtos())
        {
            HasName importedObj = proto.findFullyQualifiedObject(fullyQualifiedName);
            if (importedObj != null)
                return importedObj;
        }
        
        return null;
    }
    
    public interface Loader
    {
        public Proto load(String path, Proto importer) throws IOException;
    }
}
