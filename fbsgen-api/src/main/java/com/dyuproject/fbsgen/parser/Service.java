//========================================================================
//Copyright 2007-2010 David Yu dyuproject@gmail.com
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

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Represents a service defined in the proto (for generating rpc services).
 *
 * @author David Yu
 * @created Jun 18, 2010
 */
public final class Service extends AnnotationContainer implements UserDefinedType, HasOptions
{
    
    final String name;
    final Message parentMessage;
    final Proto proto;
    
    final LinkedHashMap<String,RpcMethod> rpcMethods = new LinkedHashMap<String,RpcMethod>();
    
    final LinkedHashMap<String,Object> standardOptions = new LinkedHashMap<String,Object>();
    final LinkedHashMap<String,Object> extraOptions = new LinkedHashMap<String,Object>();
    
    // cache
    private String relativeName, cppRelativeName;
    
    public Service(String name, Message parentMessage, Proto proto)
    {
        this.name = name;
        this.parentMessage = parentMessage;
        
        if (parentMessage != null)
        {
            this.proto = parentMessage.getProto();
            parentMessage.addNestedService(this);
        }
        else
        {
            this.proto = proto;
            proto.addService(this);
        }
    }

    public String getName()
    {
        return name;
    }
    
    private String fullName(String packageName)
    {
        return fullName(packageName, '.');
    }
    
    private String fullName(String packageName, char separator)
    {
        StringBuilder buffer = new StringBuilder();
        if (isNested())
            Message.resolveFullName(parentMessage, buffer, packageName, separator);
        else if (separator == '_')
        {
            buffer.setCharAt(0, ':');
            buffer.insert(0, ':').insert(0, packageName);
        }
        else
            buffer.append(packageName);
        
        return buffer.append(separator).append(name).toString();
    }
    
    public String getFullName()
    {
        return fullName(getProto().getPackageName());
    }
    
    public String getDeclaredFullName()
    {
        return fullName(getProto().getDeclaredPackageName());
    }
    
    public String getJavaFullName()
    {
        return fullName(getProto().getJavaPackageName());
    }
    
    public String getDeclaredJavaFullName()
    {
        return fullName(getProto().getDeclaredJavaPackageName());
    }
    
    public String getRelativeName()
    {
        if (relativeName != null)
            return relativeName;
        
        relativeName = isNested() ? parentMessage.getRelativeName() + "." + name : name;
        
        return relativeName;
    }
    
    public String getCppRelativeName()
    {
        if (cppRelativeName != null)
            return cppRelativeName;
        
        cppRelativeName = isNested() ? parentMessage.getRelativeName() + "_" + name : name;
        
        return cppRelativeName;
    }
    
    public String getCppFullName()
    {
        return fullName(getProto().getPackageName().replaceAll("\\.", "::"), '_');
    }
    
    /* ================================================== */
    
    public Message getParentMessage()
    {
        return parentMessage;
    }
    
    public boolean isNested()
    {
        return parentMessage != null;
    }
    
    public Proto getProto()
    {
        return proto;
    }
    
    /* ================================================== */
    
    public Collection<RpcMethod> getRpcMethods()
    {
        return rpcMethods.values();
    }
    
    /**
     * Alias to {@link #getRpcMethods()}.
     */
    public Collection<RpcMethod> getRpcs()
    {
        return getRpcMethods();
    }
    
    public LinkedHashMap<String,RpcMethod> getRpcMethodMap()
    {
        return rpcMethods;
    }
    
    /**
     * Alias to {@link #getRpcMethodMap()}.
     */
    public LinkedHashMap<String,RpcMethod> getRpcMap()
    {
        return getRpcMethodMap();
    }
    
    /**
     * Alias to {@link #getRpcMethodMap()}.
     */
    public LinkedHashMap<String,RpcMethod> getR()
    {
        return getRpcMethodMap();
    }
    
    public RpcMethod getRpcMethod(String name)
    {
        return rpcMethods.get(name);
    }
    
    /**
     * Alias to {@link #getRpcMethod(String)}.
     */
    public RpcMethod getRpc(String name)
    {
        return getRpcMethod(name);
    }
    
    RpcMethod addRpcMethod(String name, String argName, String argPackage, 
            String retName, String retPackage)
    {
        return new RpcMethod(name, this, argName, argPackage, retName, retPackage);
    }
    
    public LinkedHashMap<String,Object> getStandardOptions()
    {
        return standardOptions;
    }
    
    public void putStandardOption(String key, Object value)
    {
        putExtraOption(key, value);
        standardOptions.put(key, value);
    }
    
    public Object getStandardOption(String name)
    {
        return standardOptions.get(name);
    }
    
    public LinkedHashMap<String,Object> getExtraOptions()
    {
        return extraOptions;
    }
    
    public void putExtraOption(String key, Object value)
    {
        if (extraOptions.put(key, value) != null)
            throw err(this, " has multiple definitions of the option: " + key, getProto());
    }
    
    public Object getExtraOption(String name)
    {
        return extraOptions.get(name);
    }
    
    public LinkedHashMap<String,Object> getO()
    {
        return getOptions();
    }
    
    public LinkedHashMap<String,Object> getOptions()
    {
        return extraOptions;
    }
    
    void resolveReferences()
    {
        for (RpcMethod rm : rpcMethods.values())
            rm.resolveReferences();
        
        if (!standardOptions.isEmpty())
            proto.references.add(new ConfiguredReference(standardOptions, extraOptions, proto.getPackageName()));
    }
    
    @Override
    public String toString()
    {
        return  ConfiguredReference.UDT_TO_STRING_AS_FQCN ? getFullName() : getName();
    }
    
    public static class RpcMethod extends AnnotationContainer implements HasName, HasOptions
    {
        static String asJavaType(Message message, Proto ownerProto)
        {
            return ownerProto.getJavaPackageName().equals(message.getProto().getJavaPackageName()) ? 
                    message.getRelativeName() : message.getJavaFullName();
        }
        
        final LinkedHashMap<String,Object> standardOptions = new LinkedHashMap<String,Object>();
        final LinkedHashMap<String,Object> extraOptions = new LinkedHashMap<String,Object>();
        
        final String name;
        final Service service;
        final int index;
        
        final String argName, argPackage, retName, retPackage;
        
        Message argType, returnType;
        
        RpcMethod(String name, Service service, 
                String argName, String argPackage, 
                String retName, String retPackage)
        {
            this.name = name;
            this.service = service;
            index = service.rpcMethods.size();
            
            this.argName = argName;
            this.argPackage = argPackage;
            
            this.retName = retName;
            this.retPackage = retPackage;
            
            if (service.rpcMethods.put(name, this) != null)
                throw err(this, " cannot be defined more than once.", service.getProto());
        }

        public String getName()
        {
            return name;
        }
        
        public int getIndex()
        {
            return index;
        }
        
        public Proto getProto()
        {
            return service.getProto();
        }
        
        public Service getService()
        {
            return service;
        }
        
        public Service getOwner()
        {
            return service;
        }
        
        public Message getArgType()
        {
            return argType;
        }
        
        public Message getReturnType()
        {
            return returnType;
        }
        
        public boolean isVoidBoth()
        {
            return isVoidArgType() && isVoidReturnType();
        }
        
        public boolean isVoidArgType()
        {
            return argType == null;
        }
        
        public boolean isVoidReturnType()
        {
            return returnType == null;
        }
        
        public String getJavaArgType()
        {
            return argType == null ? "null" : asJavaType(argType, getProto());
        }
        
        public String getJavaReturnType()
        {
            return returnType == null ? "null" : asJavaType(returnType, getProto());
        }
        
        public String getDartArgType()
        {
            return argType == null ? "null" : MessageField.asDartType(argType, getProto());
        }
        
        public String getDartReturnType()
        {
            return returnType == null ? "null" : MessageField.asDartType(returnType, getProto());
        }
        
        public LinkedHashMap<String,Object> getStandardOptions()
        {
            return standardOptions;
        }
        
        public void putStandardOption(String key, Object value)
        {
            putExtraOption(key, value);
            standardOptions.put(key, value);
        }
        
        public Object getStandardOption(String name)
        {
            return standardOptions.get(name);
        }
        
        public LinkedHashMap<String,Object> getExtraOptions()
        {
            return extraOptions;
        }
        
        public void putExtraOption(String key, Object value)
        {
            if (extraOptions.put(key, value) != null)
                throw err(this, " has multiple definitions of the option: " + key, getProto());
        }
        
        public Object getExtraOption(String name)
        {
            return extraOptions.get(name);
        }
        
        public LinkedHashMap<String,Object> getO()
        {
            return getOptions();
        }
        
        public LinkedHashMap<String,Object> getOptions()
        {
            return extraOptions;
        }
        
        void resolveReferences()
        {
            final Proto proto = getProto();
            
            String enclosingNs = service.isNested() ? 
                    service.parentMessage.getFullName() : proto.getPackageName();
                    
            String fullArgName = (argPackage != null ? argPackage + '.' + argName : argName);
            if (!"void".equals(fullArgName))
            {
                Message argType = proto.findMessageReference(fullArgName, enclosingNs);
                if (argType == null)
                    throw err(this, " has an unresolved arg type: " + fullArgName, proto);
                
                this.argType = argType;
            }
            
            String fullReturnName = (retPackage != null ? retPackage + '.' + retName : retName);
            if (!"void".equals(fullReturnName))
            {
                Message returnType = proto.findMessageReference(fullReturnName, enclosingNs);
                if (returnType == null)
                    throw err(this, " has an unresolved return type: " + fullReturnName, proto);
                
                this.returnType = returnType;
            }
            
            if (!standardOptions.isEmpty())
                proto.references.add(new ConfiguredReference(standardOptions, extraOptions, proto.getPackageName()));
        }
        
    }

}
