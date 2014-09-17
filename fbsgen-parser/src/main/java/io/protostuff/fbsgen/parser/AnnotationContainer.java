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

package io.protostuff.fbsgen.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Base class for components that contain annotations.
 *
 * @author David Yu
 * @created Dec 30, 2010
 */
public abstract class AnnotationContainer implements HasAnnotations, HasName
{
    
    final LinkedHashMap<String,Annotation> annotations = 
        new LinkedHashMap<String,Annotation>();
    
    final ArrayList<String> comments = new ArrayList<String>();
    
    protected Annotation typeAnnotation;

    public void add(Annotation annotation)
    {
        if (annotations.put(annotation.name, annotation) != null)
            throw err("Duplicate annotation: " + annotation.name, null);
    }
    
    public Annotation getTypeAnnotation()
    {
        return typeAnnotation;
    }
    
    /**
     * Alias to {@link #getTypeAnnotation()}.
     */
    public Annotation getTa()
    {
        return getTypeAnnotation(); 
    }

    public Map<String, Annotation> getAnnotationMap()
    {
        return annotations;
    }
    
    /**
     * Short-hand for {@link #getAnnotationMap()}.
     * 
     * You then can use:
     * <pre>
     * &lt;if (message.a.("SomeAnnotation"))&gt;
     * </pre>
     */
    public final Map<String, Annotation> getA()
    {
        return annotations;
    } 

    public Collection<Annotation> getAnnotations()
    {
        return annotations.values();
    }
    
    public Annotation getAnnotation(String name)
    {
        return annotations.get(name);
    }

    public boolean addAnnotations(AnnotationContainer source, boolean clearSource)
    {
        if (!source.annotations.isEmpty())
            annotations.putAll(source.annotations);
        
        if (!source.comments.isEmpty())
            comments.addAll(source.comments);
        
        if (clearSource)
        {
            source.annotations.clear();
            source.comments.clear();
        }
        
        return !annotations.isEmpty();
    }
    
    /**
     * Shorthand for annotations.isEmpty().
     * 
     * <pre>
     * You can then use:
     * &lt;if (message.emptyA)&gt;
     * </pre>
     * 
     * <pre>
     * Note that this does not work on stringtemplate: 
     * &lt;if (message.annotationMap.empty)&gt;
     * 
     * Even though {@link java.util.Map#isEmpty()} exists. 
     * </pre>
     * 
     * 
     */
    public final boolean isEmptyA()
    {
        return annotations.isEmpty();
    }
    
    public ArrayList<String> getComments()
    {
        return comments;
    }
    
    public final boolean isEmptyC()
    {
        return comments.isEmpty();
    }
    
    public static ParseException err(EnumGroup.Value v, String msg, Proto proto)
    {
        return err(v.getEnumGroup().getRelativeName() + "::" + v.name + msg, proto);
    }
    
    public static ParseException err(EnumGroup eg, String msg, Proto proto)
    {
        return err(eg.getRelativeName() + msg, proto);
    }
    
    public static ParseException err(Field<?> field, String msg, Proto proto)
    {
        Message owner = field.getOwner();
        if (owner == null)
            return err("The field: " + field.name + " " + msg, proto);
        
        return err(owner.getRelativeName() + "::" + field.name + msg, proto);
    }
    
    public static ParseException err(Message message, String msg, Proto proto)
    {
        return err(message.getRelativeName() + msg, proto);
    }
    
    public static ParseException err(Service.RpcMethod rpc, String msg, Proto proto)
    {
        return err(rpc.getOwner().getRelativeName() + "::" + rpc.name + msg, proto);
    }
    
    public static ParseException err(Service service, String msg, Proto proto)
    {
        return err(service.getRelativeName() + msg, proto);
    }
    
    public static ParseException err(String msg, Proto proto)
    {
        if (proto == null)
            return new ParseException(msg);
        
        return new ParseException(msg + " [" + proto.getSourcePath() + "]");
    }
    
    public static ParseException err(String msg, Proto proto, Throwable cause)
    {
        if (proto == null)
            return new ParseException(msg, cause);
        
        return new ParseException(msg + " [" + proto.getSourcePath() + "]", cause);
    }

    @Override
    public boolean equals(Object obj)
    {
        return this == obj;
    }

    @Override
    public int hashCode()
    {
        return getName().hashCode();
    }
    
    @Override
    public final String toString()
    {
        return getName();
    }
    
}
