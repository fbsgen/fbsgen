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

import static io.protostuff.fbsgen.compiler.ErrorUtil.err;
import static io.protostuff.fbsgen.compiler.ErrorUtil.getProto;
import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.compiler.TemplateGroup;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;

/**
 * A map that simply verifies a param and returns it.
 * 
 * @author David Yu
 * @created Jul 26, 2013
 */
public final class VerifyMap extends FakeMap
{
    
    public interface Function
    {
        Object verify(Object obj);
    }

    public final String id;
    public final Function func;
    
    public VerifyMap(String id, Function func)
    {
        this.id = id;
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.verify(key);
    }
    
    public static void addAllTo(TemplateGroup group)
    {
        for (Functions c : Functions.values())
            group.put(c.map.id, c.map);
    }
    
    static int sizeOf(int fieldNumber)
    {
        return fieldNumber > 15 ? 2 : 1;
    }
    
    public enum Functions implements Function
    {
        CONFIG
        {
            public Object verify(Object obj)
            {
                if(obj instanceof EnumGroup)
                {
                    EnumGroup eg = (EnumGroup)obj;
                    EnumGroup.Value v = eg.getSortedValues().get(0);
                    if(v.getNumber() <= 0)
                    {
                        throw err("The config "  + eg.getName() + 
                                " cannot have a field with a negative/zero number: " + 
                                v.getName(), eg.getProto());
                    }
                    
                    return eg;
                }
                
                if(obj instanceof Message)
                {
                    // TODO
                    
                    return obj;
                }
                
                throw err("codegen error - passed wrong param: " + 
                        String.valueOf(obj), getProto(obj));
            }
        },
        
        POWER_OF_TWO
        {
            public Object verify(Object obj)
            {
                if(obj instanceof Message)
                {
                    Message message = (Message)obj;
                    for(Field<?> f : message.getFields())
                    {
                        int num = f.getNumber();
                        if(num > 0 && 0 == (num & (num-1)))
                            continue;
                        
                        throw err("The message " + message.getName() + 
                                " has field numbers that are not a power of two:" + f.getName(), 
                                message.getProto());
                    }
                }
                
                if(obj instanceof EnumGroup)
                {
                    EnumGroup eg = (EnumGroup)obj;
                    for(EnumGroup.Value v : eg.getValues())
                    {
                        int num = v.getNumber();
                        if(num > 0 && 0 == (num & (num-1)))
                            continue;
                        
                        throw err("The enum " + eg.getName() + 
                                " has values that are not a power of two:" + v.getName(), 
                                eg.getProto());
                    }
                }
                
                return obj;
            }
        }
        
        ;
        public final VerifyMap map;

        private Functions()
        {
            map = new VerifyMap("verify_" + name().toLowerCase(), this);
        }
    }
}
