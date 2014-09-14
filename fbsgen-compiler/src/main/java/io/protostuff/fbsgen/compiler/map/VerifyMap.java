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

import static io.protostuff.fbsgen.parser.AnnotationContainer.err;
import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;

import java.util.List;

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

    public final Function func;
    
    public VerifyMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.verify(key);
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
    
    public enum Functions implements Function
    {
        POWER_OF_TWO
        {
            public Object verify(Object obj)
            {
                if (obj instanceof Message)
                {
                    Message message = (Message)obj;
                    for (Field<?> f : message.getFields())
                    {
                        int num = f.getNumber();
                        if (num > 0 && 0 == (num & (num-1)))
                            continue;
                        
                        throw err(f, " is not a power of two: " + f.getNumber(), 
                                message.getProto());
                    }
                }
                
                if (obj instanceof EnumGroup)
                {
                    EnumGroup eg = (EnumGroup)obj;
                    for (EnumGroup.Value v : eg.getValues())
                    {
                        int num = v.getNumber();
                        if (num > 0 && 0 == (num & (num-1)))
                            continue;
                        
                        throw err(v, " is not a power of two: " + v.getNumber(), 
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
