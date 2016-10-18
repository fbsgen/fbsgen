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

package com.dyuproject.fbsgen.compiler.map;

import com.dyuproject.fbsgen.compiler.CompilerUtil;
import com.dyuproject.fbsgen.compiler.FakeMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Split the arg with a pre-defined delimiter.
 * 
 * @author David Yu
 * @created Sep 12, 2014
 */
public final class SplitMap extends FakeMap
{
    public interface Function
    {
        Object split(String str);
    }

    public final Function func;
    
    public SplitMap(String name, Function func)
    {
        super(name);
        this.func = func;
    }
    
    public Object get(Object key)
    {
        return func.split((String)key);
    }
    
    public static void addAllTo(List<FakeMap> list)
    {
        for (Functions c : Functions.values())
            list.add(c.map);
    }
    
    static int sizeOf(int fieldNumber)
    {
        return fieldNumber > 15 ? 2 : 1;
    }
    
    public enum Functions implements Function
    {
        CHARS
        {
            @Override
            public Object split(String str)
            {
                ArrayList<String> list = new ArrayList<String>(str.length());
                
                for (int i = 0, len = str.length(); i < len; i++)
                    list.add(new String(new char[]{str.charAt(i)}));
                
                return list;
            }
            
        },
        DOT_AFTER_SLASH
        {
            @Override
            public Object split(String str)
            {
                if (str == null || str.isEmpty())
                    return Collections.EMPTY_LIST;
                
                int slash = str.lastIndexOf('/');
                return CompilerUtil.DOT.split(slash == -1 ? str : str.substring(slash + 1));
            }
        },
        DOT
        {
            @Override
            public Object split(String str)
            {
                return str == null || str.isEmpty() ? Collections.EMPTY_LIST : 
                        Arrays.asList(CompilerUtil.DOT.split(str));
            }
        },
        COMMA
        {
            @Override
            public Object split(String str)
            {
                return str == null || str.isEmpty() ? Collections.EMPTY_LIST : 
                        Arrays.asList(CompilerUtil.COMMA.split(str));
            }
        },
        SEMI_COLON
        {
            @Override
            public Object split(String str)
            {
                return str == null || str.isEmpty() ? Collections.EMPTY_LIST : 
                        Arrays.asList(CompilerUtil.SEMI_COLON.split(str));
            }
        },
        DOUBLE_UNDERSCORE
        {
            @Override
            public Object split(String str)
            {
                return str == null || str.isEmpty() ? Collections.EMPTY_LIST : 
                        Arrays.asList(CompilerUtil.DOUBLE_UNDERSCORE.split(str));
            }
        }
        ;
        public final SplitMap map;

        private Functions()
        {
            map = new SplitMap("split_" + name().toLowerCase(), this);
        }
    }
}
