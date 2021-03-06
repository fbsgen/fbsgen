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

import java.io.IOException;




/**
 * Represents an enum field defined in a {@link Message}.
 *
 * @author David Yu
 * @created Dec 19, 2009
 */
public final class EnumField extends Field<EnumGroup.Value>
{
    
    //java.lang.String javaType;
    final EnumGroup.Value ev;
    EnumGroup enumGroup;
    boolean defaultValueSet;
    
    public EnumField()
    {
        this((EnumGroup.Value)null);
    }

    public EnumField(EnumGroup enumGroup)
    {
        this((EnumGroup.Value)null);
        this.enumGroup = enumGroup;
    }
    
    public EnumField(EnumGroup.Value ev)
    {
        super(true);
        this.ev = ev;
        pbType = PbType.ENUM;
    }
    
    public EnumGroup.Value getEv()
    {
        return ev;
    }
    
    public boolean isDefaultValueSet()
    {
        return defaultValueSet;
    }
    
    public EnumGroup getEnumGroup()
    {
        return enumGroup;
    }
    
    /**
     * Alias to {@link #getEnumGroup()}.
     */
    public final EnumGroup getEg()
    {
        return getEnumGroup();
    }
    
    public UserDefinedType getUserDefinedType()
    {
        return enumGroup;
    }
    
    public java.lang.String getDartType()
    {
        StringBuilder buffer = new StringBuilder();
        if (!enumGroup.getProto().getJavaPackageName().equals(owner.getProto().getJavaPackageName()))
        {
            buffer.append(enumGroup.getProto().getJavaPackageName().replace('.', '_'))
                    .append('.');
        }
        
        if (enumGroup.isNested())
        {
            Message.resolveRelativeName(enumGroup.parentMessage, buffer, null, '_');
            buffer.append('_');
        }

        buffer.append(enumGroup.name);
        
        return buffer.toString();
    }
    
    public java.lang.String getJavaType()
    {
        //if (javaType != null)
        //    return javaType;
        
        StringBuilder buffer = new StringBuilder();
        if (enumGroup.isNested())
        {
            if (enumGroup.parentMessage==owner)
                buffer.append(enumGroup.name);
            else
            {
                Message.computeName(enumGroup.parentMessage, owner, buffer);
                buffer.append('.').append(enumGroup.name);
            }
        }
        else if (enumGroup.getProto().getJavaPackageName().equals(owner.getProto().getJavaPackageName()))
            buffer.append(enumGroup.name);
        else
            buffer.append(enumGroup.getProto().getJavaPackageName()).append('.').append(enumGroup.getName());
        
        return buffer.toString();
        //return (javaType=buffer.toString());
        
    }
    
    public java.lang.String getFbsType()
    {
        StringBuilder buffer = new StringBuilder();
        if (enumGroup.isNested())
        {
            if (enumGroup.parentMessage==owner)
                buffer.append(enumGroup.name);
            else
            {
                Message.computeCppName(enumGroup.parentMessage, owner, buffer);
                buffer.append('_').append(enumGroup.name);
            }
        }
        else if (enumGroup.getProto() == owner.getProto())
            buffer.append(enumGroup.name);
        else
            buffer.append(enumGroup.getProto().getPackageName().replaceAll("\\.", "::")).append("::").append(enumGroup.getName());
        
        return buffer.toString();
    }
    
    @Override
    protected void resolvePbType()
    {
        
    }
    
    public java.lang.String getInitialValueAsString()
    {
        return "0";
    }
    
    @Override
    public java.lang.String getRegularType()
    {
        if (regularType != null)
            return regularType;
        
        java.lang.String javaType = getJavaType();
        Proto egProto = enumGroup.getProto();
        java.lang.String javaPackage = egProto.getJavaPackageName();
        java.lang.String protoPackage = egProto.getPackageName();
        if (javaType.startsWith(javaPackage) && !javaPackage.equals(protoPackage))
            javaType = javaType.replace(javaPackage, protoPackage);
        
        regularType = javaType;
        return javaType;
    }
    
    public java.lang.String getDefaultValueAsString()
    {
        return getJavaType() + "." + getDefaultValue().getName();
    }
    
    public boolean isSameProto()
    {
        return getOwner().getProto() == getEnumGroup().getProto();
    }
    
    public boolean isSameDir() throws IOException
    {
        return getOwner().getProto().getFile().getParentFile().getCanonicalPath().equals(
                getEnumGroup().getProto().getFile().getParentFile().getCanonicalPath());
    }
    
    public boolean isSamePackage()
    {
        return getOwner().getProto().getPackageName().equals(
                getEnumGroup().getProto().getPackageName());
    }
    
    public java.lang.String getRelativePath()
    {
        if (isSameProto())
            return "";
        
        java.lang.String currentPackage = getOwner().getProto().getPackageName();
        java.lang.String targetPackage = getEnumGroup().getProto().getPackageName();
        java.lang.String path = "../";
        for (int idx=currentPackage.indexOf('.'); idx!=-1; idx=currentPackage.indexOf('.', idx+1))
            path += "../";

        return path + targetPackage.replace('.', '/') + "/";
    }

    public Proto getProto()
    {
        return ev != null ? ev.getProto() : super.getProto();
    }
    
    @Override
    public EnumField create()
    {
        return new EnumField();
    }
}
