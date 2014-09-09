//========================================================================
//Copyright 2012 David Yu
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

import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.compiler.TemplateGroup;
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.Message;

/**
 * Codegen helper for message queries.
 * 
 * @author David Yu
 * @created Nov 8, 2012
 */
public final class IsMessageMap extends FakeMap
{

    public interface Function
    {
        boolean query(Message message);
    }

    public final String id;
    public final Function func;
    
    public IsMessageMap(String id, Function func)
    {
        this.id = id;
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return key instanceof Message && func.query((Message)key);
    }
    
    public static void addAllTo(TemplateGroup group)
    {
        for (Functions c : Functions.values())
            group.put(c.map.id, c.map);
    }
    
    public enum Functions implements Function
    {
        ENTITY
        {
            public boolean query(Message message)
            {
                return message.getOptions().containsKey("~entity.kind");
                //return message.getAnnotationMap().get("Entity") != null || 
                //        message.getOptions().get("entity.kind") instanceof Integer;
            }
        },
        LINKED_ENTITY
        {
            public boolean query(Message message)
            {
                return message.getOptions().containsKey("~entity.kind") && 
                        message.getOptions().get("~entity.parent") instanceof Message;
                /*Annotation entity = message.getAnnotationMap().get("Entity");
                if(entity != null)
                    return entity.getValue("parent") instanceof Message;

                return message.getOptions().get("entity.kind") instanceof Integer
                        && message.getOptions().get("entity.parent") instanceof Message;*/
            }
        },
        CACHED_ENTITY
        {
            public boolean query(Message message)
            {
                return message.getOptions().containsKey("~entity.kind") && 
                        message.getAnnotation("Entity").getValue("cache") instanceof Message;
            }
        },
        /*ENTITY_ON_FORM
        {
            public boolean query(Message message)
            {
                if(!ENTITY.query(message))
                    return false;
                
                Annotation display = message.getAnnotation("Display");
                return display == null || !Boolean.TRUE.equals(display.getValue(
                        "non_entity_on_form"));
            }
        }, */
        
        ENTITY_ON_NFORM
        {
            public boolean query(Message message)
            {
                if(!ENTITY.query(message))
                    return false;
                
                Annotation display = message.getAnnotation("NForm");
                return display == null || !Boolean.TRUE.equals(display.getValue(
                        "as_non_entity"));
            }
        }, 
        
        ENTITY_ON_UFORM
        {
            public boolean query(Message message)
            {
                if(!ENTITY.query(message))
                    return false;
                
                Annotation display = message.getAnnotation("UForm");
                return display == null || !Boolean.TRUE.equals(display.getValue(
                        "as_non_entity"));
            }
        }
        
        ;
        
        public final IsMessageMap map;

        private Functions()
        {
            map = new IsMessageMap("is_message_" + name().toLowerCase(), this);
        }
    }
    
}
