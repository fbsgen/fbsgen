//========================================================================
//Copyright 2014 David Yu
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

import static io.protostuff.fbsgen.compiler.CollectionUtil.addTo;
import static io.protostuff.fbsgen.compiler.CompilerUtil.COMMA;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.Proto;
import io.protostuff.fbsgen.parser.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple registry impl.
 * 
 * @author David Yu
 * @created Sep 12, 2014
 */
public class DefaultRegistry implements Registry
{
    
    protected final ArrayList<Service> services = new ArrayList<Service>();
    
    protected final ArrayList<Proto> protos = new ArrayList<Proto>();
    
    protected final HashMap<String,ArrayList<Proto>> stgProtoMapping = 
            new HashMap<String, ArrayList<Proto>>();
    
    protected final HashMap<String,Proto> protoPathMap = new HashMap<String,Proto>();
    
    protected final ArrayList<Message> messages = new ArrayList<Message>();
    protected final HashMap<String,ArrayList<Message>> stgMessageMapping = 
            new HashMap<String, ArrayList<Message>>();
    
    protected final ArrayList<EnumGroup> enumGroups = new ArrayList<EnumGroup>();
    protected final HashMap<String,ArrayList<EnumGroup>> stgEnumGroupMapping = 
            new HashMap<String, ArrayList<EnumGroup>>();
    
    @Override
    public void add(EnumGroup eg, ProtoModule module)
    {
        enumGroups.add(eg);
        
        String stgs = (String)eg.getOptions().get("stgs");
        if (stgs != null)
        {
            addTo(stgEnumGroupMapping, eg, module, COMMA.split(stgs), 
                    eg.getProto());
        }
    }

    @Override
    public void add(Message message, ProtoModule module)
    {
        messages.add(message);
        
        String stgs = (String)message.getOptions().get("stgs");
        if (stgs != null)
        {
            addTo(stgMessageMapping, message, module, COMMA.split(stgs), 
                    message.getProto());
        }
    }

    @Override
    public void add(Service service, ProtoModule module)
    {
        services.add(service);
    }

    @Override
    public void add(Proto proto, ProtoModule module)
    {
        protos.add(proto);
        
        protoPathMap.put(proto.getSourcePath(), proto);
        
        String stgs = (String)proto.getOptions().get("stgs");
        if (stgs != null)
            addTo(stgProtoMapping, proto, module, COMMA.split(stgs), proto);
    }

    public List<Message> getMessages()
    {
        return messages;
    }
    
    public List<EnumGroup> getEnumGroups()
    {
        return enumGroups;
    }
    
    public List<Service> getServices()
    {
        return services;
    }
    
    @Override
    public List<Proto> getProtos()
    {
        return protos;
    }

    @Override
    public Map<String, Proto> getProtoPathMap()
    {
        return protoPathMap;
    }

    @Override
    public Map<String, ArrayList<Proto>> getStgProtoMapping()
    {
        return stgProtoMapping;
    }

    @Override
    public Map<String, ArrayList<Message>> getStgMessageMapping()
    {
        return stgMessageMapping;
    }

    @Override
    public Map<String, ArrayList<EnumGroup>> getStgEnumGroupMapping()
    {
        return stgEnumGroupMapping;
    }

    @Override
    public Registry complete(ProtoModule module)
    {
        return this;
    }

}
