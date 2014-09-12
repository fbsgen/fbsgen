//================================================================================
//Copyright (c) 2011, David Yu
//All rights reserved.
//--------------------------------------------------------------------------------
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
// 1. Redistributions of source code must retain the above copyright notice,
//    this list of conditions and the following disclaimer.
// 2. Redistributions in binary form must reproduce the above copyright notice,
//    this list of conditions and the following disclaimer in the documentation
//    and/or other materials provided with the distribution.
// 3. Neither the name of protostuff nor the names of its contributors may be used
//    to endorse or promote products derived from this software without
//    specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.
//================================================================================


package io.protostuff.fbsgen.compiler.map;

import io.protostuff.fbsgen.compiler.FakeMap;
import io.protostuff.fbsgen.parser.Message;

import java.util.List;

/**
 * Codegen helper for counting the filtered fields.
 *
 * @author David Yu
 * @created Dec 24, 2011
 */
public final class CountMap extends FakeMap
{
    
    public interface Function
    {
        int count(Message message);
    }
    
    public final Function func;
    
    public CountMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }

    public Object get(Object key)
    {
        return Integer.valueOf(key instanceof Message ? func.count((Message)key) : 0);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    public enum Functions implements Function
    {
        FORM_FIELDS
        {
            public int count(Message message)
            {
                return message.getSingularFieldCount() - message.getSingularBytesFieldCount();
            }
        },
        FORM_SCALAR_FIELDS
        {
            public int count(Message message)
            {
                return message.getSingularFieldCount() - message.getSingularBytesFieldCount() - message.getSingularMessageFieldCount();
            }
        },
        ;
        
        public final CountMap map;

        private Functions()
        {
            map = new CountMap("count_" + name().toLowerCase(), this);
        }

    }

    
}