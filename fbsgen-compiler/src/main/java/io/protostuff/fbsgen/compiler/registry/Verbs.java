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

import io.protostuff.fbsgen.compiler.ST4Group;

import java.util.Locale;

import org.stringtemplate.v4.AttributeRenderer;

/**
 * Verbs used in rpc.
 * 
 * @author David Yu
 * @created Aug 1, 2013
 */
public final class Verbs
{
    private Verbs() {}
    
    static void initRenderers()
    {
        ST4Group.setAttributeRenderer(View.class, VIEW_RENDERER);
        ST4Group.setAttributeRenderer(Op.class, OP_RENDERER);
    }
    
    public static boolean isUppercase(char c)
    {
        return c > 64 && c < 91;
    }
    
    public enum View
    {
        GET, LIST, FIND, Q, F;
    }
    
    public enum Op
    {
        NEW, UPDATE, DELETE, MARK;
    }
    
    static final String NONE = "";
    
    public static final AttributeRenderer VIEW_RENDERER = new AttributeRenderer()
    {
        @Override
        public String toString(Object o, String name, Locale locale)
        {
            if (o == null)
                return NONE;
            
            View verb = (View)o;
            switch(verb)
            {
                case GET:
                {
                    int idx = name.lastIndexOf("From");
                    
                    // getNestedEntityFromX
                    if (idx != -1 && isUppercase(name.charAt(idx+4)))
                        return name.substring(idx+4);
                    
                    // TODO getX
                    return NONE;
                }
                case LIST:
                {
                    int idx = name.lastIndexOf("From");
                    
                    // listNestedEntityFromX
                    if (idx != -1 && isUppercase(name.charAt(idx+4)))
                        return name.substring(idx+4);
                    
                    // listXByName
                    if (-1 != (idx=name.lastIndexOf("By")) && isUppercase(name.charAt(idx+2)))
                        return name.substring(4, idx);
                    
                    // listX
                    return name.substring(4);
                }
                case FIND:
                {
                    int idx = name.lastIndexOf("By");
                    
                    // findXByName
                    if (idx != -1 && isUppercase(name.charAt(idx+2)))
                        return name.substring(4, idx);
                    
                    return NONE;
                }
                case F:
                case Q:
                {
                    // idx0 = q, idx1 = uppercase-char
                    // start digit search at idx2 since an entity could be a single char
                    for (int i = 2, len = name.length(); i < len; i++)
                    {
                        if (Character.isDigit(name.charAt(i)))
                            return name.substring(1, i);
                    }
                    
                    return NONE;
                }
            }
            
            return NONE;
        }
    };

    public static final AttributeRenderer OP_RENDERER = new AttributeRenderer()
    {
        @Override
        public String toString(Object o, String name, Locale locale)
        {
            if (o == null)
                return NONE;
            
            Op verb = (Op)o;
            switch(verb)
            {
                case NEW:
                {
                    int idx = name.lastIndexOf("From");
                    
                    // newXFromTemplate
                    if (idx > 3 && isUppercase(name.charAt(idx+4)))
                        return name.substring(3, idx);
                    
                    return name.substring(3);
                }
                case UPDATE:
                {
                    int idx = name.lastIndexOf("Add");
                    
                    // updateXAdd
                    if (idx > 6 && isUppercase(name.charAt(idx+3)))
                        return name.substring(6, idx);
                    
                    // updateXRemove
                    if (6 < (idx=name.lastIndexOf("Remove")) && isUppercase(name.charAt(idx+6)))
                        return name.substring(6, idx);
                    
                    // updateXSet
                    if (6 < (idx=name.lastIndexOf("Set")) && isUppercase(name.charAt(idx+3)))
                        return name.substring(6, idx);
                    
                    return name.substring(6);
                }
                case DELETE:
                    return name.substring(6);
                    
                case MARK:
                {
                    int idx = name.lastIndexOf("As");
                    
                    // markXAs
                    if (idx > 4 && isUppercase(name.charAt(idx+2)))
                        return name.substring(4, idx);
                    
                    return NONE;
                }
            }
            
            return NONE;
        }
    };
}
