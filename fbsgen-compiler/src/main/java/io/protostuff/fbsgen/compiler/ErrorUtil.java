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

package io.protostuff.fbsgen.compiler;

import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.HasProto;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.Proto;
import io.protostuff.fbsgen.parser.Service;

/**
 * Utils for formatting error msgs in exceptions.
 * 
 * @author David Yu
 * @created Dec 09, 2013
 */
public final class ErrorUtil
{
    private ErrorUtil() {}
    
    public static CodegenException err(Proto proto, String msg)
    {
        if(proto == null)
            return new CodegenException(msg);
        
        return new CodegenException(msg + " [" + proto.getSourcePath() + "]");
    }
    
    public static CodegenException err(Proto proto, String msg, Throwable cause)
    {
        if(proto == null)
            return new CodegenException(msg, cause);
        
        return new CodegenException(msg + " [" + proto.getSourcePath() + "]", cause);
    }
    
    public static Proto getProto(Object obj)
    {
        return obj instanceof HasProto ? ((HasProto)obj).getProto() : null;
    }
    
    public static CodegenException err(String msg, Proto proto)
    {
        if(proto == null)
            return new CodegenException(msg);
        
        return new CodegenException(msg + " [" + proto.getSourcePath() + "]");
    }
    
    public static CodegenException err(String msg, Message m)
    {
        return err(msg, m.getProto());
    }
    
    public static CodegenException err(String msg, EnumGroup eg)
    {
        return err(msg, eg.getProto());
    }
    
    public static CodegenException err(String msg, EnumGroup.Value v)
    {
        return err(msg, v.getEg().getProto());
    }
    
    public static CodegenException err(String msg, Service s)
    {
        return err(msg, s.getProto());
    }
    
    public static CodegenException err(String msg, Service.RpcMethod r)
    {
        return err(msg, r.getProto());
    }
}