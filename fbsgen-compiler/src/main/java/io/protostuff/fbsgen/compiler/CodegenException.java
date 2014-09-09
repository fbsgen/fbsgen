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

/**
 * Thrown during code generation (after the proto is parsed).
 * 
 * @author David Yu
 * @created Sep 9, 2014
 */
public class CodegenException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public CodegenException()
    {
        super();
    }
    
    public CodegenException(String message)
    {
        super(message);
    }
    
    public CodegenException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public CodegenException(Throwable cause)
    {
        super(cause);
    }
}
