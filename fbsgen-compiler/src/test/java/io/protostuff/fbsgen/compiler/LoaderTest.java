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

import junit.framework.TestCase;

/**
 * Template load from file/classpath test.
 * 
 * @author David Yu
 * @created Sep 9, 2014
 */
public class LoaderTest extends TestCase
{
    
    public void testLoadBase()
    {
        char[] delim = new char[4];
        assertNotNull(TemplateUtil.getUrl("fbsgen/base.stg", delim, true));
        assertTrue(delim[0] == 0);
        assertTrue(delim[1] == 0);
        
        assertNotNull(TemplateUtil.getReader("fbsgen/test_square_delim.stg", delim, true));
        assertTrue(delim[0] == '[');
        assertTrue(delim[1] == ']');
    }

}
