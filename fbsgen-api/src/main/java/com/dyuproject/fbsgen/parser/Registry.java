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

package com.dyuproject.fbsgen.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dyuproject.fbsgen.parser.EnumGroup;
import com.dyuproject.fbsgen.parser.Message;
import com.dyuproject.fbsgen.parser.Proto;
import com.dyuproject.fbsgen.parser.Service;

/**
 * Registry for all proto components.
 * 
 * @author David Yu
 * @created Sep 12, 2014
 */
public interface Registry
{
    List<Proto> getProtos();
    List<Message> getMessages();
    List<EnumGroup> getEnumGroups();
    List<Service> getServices();
    
    Map<String,Proto> getProtoPathMap();
    Map<String,ArrayList<Proto>>  getPkgProtoMapping();
    Map<String,ArrayList<Proto>>  getStgProtoMapping();
    Map<String,ArrayList<Message>>  getStgMessageMapping();
    Map<String,ArrayList<EnumGroup>>  getStgEnumGroupMapping();
}
