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

import static io.protostuff.fbsgen.compiler.ErrorUtil.err;
import io.protostuff.fbsgen.parser.DefaultProtoLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Template utils.
 * 
 * @author David Yu
 * @created Sep 9, 2014
 */
public final class TemplateUtil
{
    private TemplateUtil() {}
    
    static final int PUSH_BACK_SIZE = 5;
    
    static final HashMap<String, ST4Group> STG_CACHE = new HashMap<String, ST4Group>();
    
    private static final ArrayList<File> __templateLoadDirs = new ArrayList<File>();
    
    static
    {
        String templatePath = System.getProperty("template_path");
        if (templatePath != null)
        {
            StringTokenizer tokenizer = new StringTokenizer(templatePath, ",:;");
            while (tokenizer.hasMoreTokens())
            {
                String path = tokenizer.nextToken().trim();
                File dir = new File(path);
                if (dir.exists() && dir.isDirectory())
                    __templateLoadDirs.add(dir);
                else
                    System.err.println("warn: template dir does not exist " + path);
            }
        }
    }
    
    public static TemplateGroup resolveGroup(String output, String name, String fileExtension)
    {
        String path = output + ".jetg";
        File file = lookupFile(path);
        if (file != null)
            return new JetGroup(path, file);
        
        final char[] delim = new char[4];
        
        String resource = output + ".stg";
        
        ST4Group stg = STG_CACHE.get(resource);
        if (stg != null)
            return stg;
        
        Reader reader = getReader(resource, delim, true);
        if (reader != null)
        {
            stg = new ST4Group(name, reader, delim);
            STG_CACHE.put(resource, stg);
            return stg;
        }
        
        throw err(null, "Could not load resource: " + output);
    }
    
    static TemplateGroup newGroup(String name, InputStream in, char[] delim, 
            boolean parseDelim) throws IOException
    {
        return new ST4Group(name, newReader(in, parseDelim ? delim : null), delim);
    }
    
    static File lookupFile(String resource)
    {
        File file;
        for (File dir : __templateLoadDirs)
        {
            file = new File(dir, resource);
            if (file.exists())
                return file;
        }
        
        return null;
    }
    
    static Reader getReader(String resource, char[] delim, boolean checkFile)
    {
        try
        {
            if (checkFile)
            {
                for (File dir : __templateLoadDirs)
                {
                    File file = new File(dir, resource);
                    if (file.exists())
                        return newReader(new FileInputStream(file), delim);
                }
            }
    
            URL url = DefaultProtoLoader.getResource(resource, TemplateUtil.class);
            if (url != null)
                return newReader(url.openStream(), delim);
            
            if (resource.startsWith("http://"))
                return newReader(new URL(resource).openStream(), delim);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        
        return null;
    }

    static URL getUrl(String resource, char[] delim, boolean checkFile)
    {
        try
        {
            if (checkFile)
            {
                for (File dir : __templateLoadDirs)
                {
                    File file = new File(dir, resource);
                    if (file.exists())
                    {
                        delim[4] = 1; // marker to indicate found from file
                        return file.toURI().toURL();
                    }
                }
            }
            
            URL url = DefaultProtoLoader.getResource(resource, TemplateUtil.class);
            if (url != null)
            {
                delim[4] = 2; // marker to indicate found from classpath
                return url;
            }
            
            if (resource.startsWith("http://"))
                return new URL(resource);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        
        return null;
    }
    
    public static String[] getOutputFragments(String resource)
    {
        final int lastDot = resource.lastIndexOf('.'), 
                lastSlash = resource.lastIndexOf('/', lastDot);
        
        return new String[]{
                resource.substring(lastSlash + 1, lastDot),
                resource.substring(lastDot)
        };
    }
    
    static Reader newReader(InputStream in, char[] delim) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        if (delim == null)
            return br;
        
        PushbackReader reader = new PushbackReader(br, PUSH_BACK_SIZE);
        
        fillDelim(delim, reader);
        
        return reader;
    }
    
    static int fillDelim(char[] target, PushbackReader reader) throws IOException
    {
        final char[] cbuf = new char[PUSH_BACK_SIZE];
        int len = reader.read(cbuf);
        while(len < PUSH_BACK_SIZE)
        {
            // read until we reach the push back size
            len += reader.read(cbuf, len, PUSH_BACK_SIZE - len);
        }
        
        // defaults to angle bracket if not specified
        int delimSize = fillDelim(target, cbuf, 0);
        
        reader.unread(cbuf, 0, len);
        
        return delimSize;
    }
    
    
    static int fillDelim(char[] target, byte[] buf, int offset)
    {
        return fillDelim(target, 
                (char)buf[offset], 
                (char)buf[offset+1], 
                (char)buf[offset+2], 
                (char)buf[offset+3], 
                (char)buf[offset+4]);
    }
    
    static int fillDelim(char[] target, char[] buf, int offset)
    {
        return fillDelim(target, 
                buf[offset], 
                buf[offset+1], 
                buf[offset+2], 
                buf[offset+3], 
                buf[offset+4]);
    }

    static int fillDelim(char[] target, char c0, char c1, char c2, char c3, char c4)
    {
        if (c0 != c1 || c0 != c2)
            return 0;
        
        switch(c0)
        {
            case '#':
            case '/':
            case ';':
                return fillDelim(target, c3, c4);
                
            default:
                return 0;
        }
    }
    
    static int fillDelim(char[] target, char c0, char c1)
    {
        switch(c0)
        {
            case '«':
                target[0] = '«';
                target[1] = '»';
                return 2;
                
            case '[':
                switch(c1)
                {
                    case ']':
                        target[0] = '[';
                        target[1] = ']';
                        return 2;
                    case '[': 
                        target[0] = '[';
                        target[1] = '[';
                        target[2] = ']';
                        target[3] = ']';
                        return 4;
                    default: return 0;
                }
                
            case '{':
                switch(c1)
                {
                    case '}':
                        target[0] = '{';
                        target[1] = '}';
                        return 2;
                    case '{': 
                        target[0] = '{';
                        target[1] = '{';
                        target[2] = '}';
                        target[3] = '}';
                        return 4;
                    default: return 0;
                }
                
            case '<':
                switch(c1)
                {
                    case '>':
                        target[0] = '<';
                        target[1] = '>';
                        return 2;
                    case '<': 
                        target[0] = '<';
                        target[1] = '<';
                        target[2] = '>';
                        target[3] = '>';
                        return 4;
                    default: return 0;
                }
                
            default:
                return 0;
        }
    }
}
