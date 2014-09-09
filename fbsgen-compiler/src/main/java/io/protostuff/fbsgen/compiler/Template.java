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

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Renders to a writer.
 * 
 * @author David Yu
 * @created Sep 9, 2014
 */
public interface Template
{
    
    void renderTo(BufferedWriter writer, Map<String,Object> args) throws IOException;
    
}