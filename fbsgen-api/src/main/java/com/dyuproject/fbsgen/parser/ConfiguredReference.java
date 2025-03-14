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


package com.dyuproject.fbsgen.parser;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * The reference configured via options and annotations.
 *
 * @author David Yu
 * @created Dec 22, 2011
 */
public final class ConfiguredReference
{
    public static final boolean RESOLVE_ENUM_VALUE_REF = Boolean.parseBoolean(
            System.getProperty("fbsgen.resolve_enum_value_ref", "true"));
    public static final boolean RESOLVE_UDT_AS_FQCN = Boolean.parseBoolean(
            System.getProperty("fbsgen.resolve_udt_as_fqcn", "false"));
    public static final boolean UDT_TO_STRING_AS_FQCN = Boolean.parseBoolean(
            System.getProperty("fbsgen.udt_to_string_as_fqcn", "true"));
    
    // could be same
    final LinkedHashMap<String,Object> source, destination;
    String enclosingNamespace;
    
    public ConfiguredReference(LinkedHashMap<String,Object> source, 
            LinkedHashMap<String,Object> destination, String enclosingNamespace)
    {
        this.source = source;
        this.destination = destination;
        this.enclosingNamespace = enclosingNamespace;
    }
    
    void resolve(Proto proto)
    {
        resolve(proto, source, destination, enclosingNamespace);
    }
    
    static void resolve(Proto proto, LinkedHashMap<String,Object> source, 
            LinkedHashMap<String,Object> destination, String enclosingNamespace)
    {
        int dot;
        HasName hn;
        // we iterate this way (no EntrySet) to avoid concurrent modification exception 
        // if the source and destination are the same.
        String[] keys = source.keySet().toArray(new String[source.size()]);
        for (String key : keys)
        {
            Object val = source.get(key);
            if (val instanceof String)
            {
                String refName = (String)val;
                String ns = enclosingNamespace == null ? proto.getPackageName() : 
                    enclosingNamespace;
                
                if (null != (hn = proto.findReference(refName, ns)))
                {
                    if (RESOLVE_UDT_AS_FQCN && hn instanceof UserDefinedType)
                        destination.put(key, ((UserDefinedType)hn).getFullName());
                    else
                        destination.put(key, hn);
                }
                else if (RESOLVE_ENUM_VALUE_REF &&
                        0 < (dot = refName.lastIndexOf('.')) &&
                        (dot + 1) != refName.length() &&
                        (hn = proto.findReference(refName.substring(0, dot), ns)) instanceof EnumGroup)
                {
                    EnumGroup.Value v = ((EnumGroup)hn).getValue(refName.substring(dot + 1));
                    if (v != null)
                        destination.put(key, v);
                }
            }
        }
    }
    
    static void resolveJsonRefs(Proto proto, List<Proto.RefEntry> refs,
            String enclosingNamespace)
    {
        int dot;
        HasName hn;
        for (Proto.RefEntry ref : refs)
        {
            Object val = ref.get();
            if (val instanceof String)
            {
                String refName = (String)val;
                String ns = enclosingNamespace == null ? proto.getPackageName() : 
                    enclosingNamespace;
                
                if (null != (hn = proto.findReference(refName, ns)))
                {
                    if (RESOLVE_UDT_AS_FQCN && hn instanceof UserDefinedType)
                        ref.put(((UserDefinedType)hn).getFullName());
                    else
                        ref.put(hn);
                }
                else if (RESOLVE_ENUM_VALUE_REF &&
                        0 < (dot = refName.lastIndexOf('.')) &&
                        (dot + 1) != refName.length() &&
                        (hn = proto.findReference(refName.substring(0, dot), ns)) instanceof EnumGroup)
                {
                    EnumGroup.Value v = ((EnumGroup)hn).getValue(refName.substring(dot + 1));
                    if (v != null)
                        ref.put(v);
                }
            }
        }
    }
}
