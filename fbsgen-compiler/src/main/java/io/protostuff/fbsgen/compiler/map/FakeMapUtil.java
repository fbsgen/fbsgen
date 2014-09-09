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

package io.protostuff.fbsgen.compiler.map;

import io.protostuff.fbsgen.compiler.TemplateGroup;


/**
 * FakeMap util.
 * 
 * @author David Yu
 * @created Sep 9, 2014
 */
public final class FakeMapUtil
{
    private FakeMapUtil() {}

    public static void addMapsTo(TemplateGroup group)
    {
        // message fields
        CountMap.addAllTo(group);
        FilterMap.addAllTo(group);
        
        // enum values
        FilterEnumValueMap.addAllTo(group);
        
        // message
        IsMessageMap.addAllTo(group);
        
        // field
        IsFieldMap.addAllTo(group);
        
        // any annotation container:
        // EnumGroup, EnumGroup.Value, 
        // Service, Service.RpcMethod,
        // Message, Field
        AnnotationMap.addAllTo(group);
        
        // any object
        IsMap.addAllTo(group);
        GetMap.addAllTo(group);
        NewMap.addAllTo(group);
        VerifyMap.addAllTo(group);
        FormatMap.addAllTo(group);
    }
}
