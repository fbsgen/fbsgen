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

import java.util.ArrayList;

import io.protostuff.fbsgen.compiler.FakeMap;
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
    
    public static final ArrayList<FakeMap> LIST = new ArrayList<FakeMap>();
    
    static
    {
        // message fields
        CountMap.addAllTo(LIST);
        FilterMap.addAllTo(LIST);
        
        // message
        IsMessageMap.addAllTo(LIST);
        
        // field
        IsFieldMap.addAllTo(LIST);
        
        // any annotation container:
        // EnumGroup, EnumGroup.Value, 
        // Service, Service.RpcMethod,
        // Message, Field
        AnnotationMap.addAllTo(LIST);
        
        // string
        SplitMap.addAllTo(LIST);
        
        // any object
        IsMap.addAllTo(LIST);
        GetMap.addAllTo(LIST);
        NewMap.addAllTo(LIST);
        VerifyMap.addAllTo(LIST);
        FormatMap.addAllTo(LIST);
    }

    public static void addMapsTo(TemplateGroup group)
    {
        for (FakeMap map : LIST)
            group.put(map.name, map);
    }
}
