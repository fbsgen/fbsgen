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

import static io.protostuff.fbsgen.compiler.TemplatedCodeGenerator.FORMAT_DELIM;
import static io.protostuff.fbsgen.compiler.TemplatedCodeGenerator.chainedFormat;
import static io.protostuff.fbsgen.compiler.TemplatedCodeGenerator.errorCount;
import static io.protostuff.fbsgen.compiler.TemplatedCodeGenerator.format;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.stringtemplate.v4.AttributeRenderer;
import org.stringtemplate.v4.AutoIndentWriter;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.compiler.CompiledST;
import org.stringtemplate.v4.compiler.GroupLexer;
import org.stringtemplate.v4.compiler.GroupParser;
import org.stringtemplate.v4.misc.STMessage;

/**
 * String template 4 group.
 * 
 * @author David Yu
 * @created Sep 9, 2014
 */
public final class ST4Group extends STGroup implements TemplateGroup
{
    
    public static final String TEMPLATE_BASE = "fbsgen";

    static final HashMap<Class<?>, AttributeRenderer> DEFAULT_RENDERERS =
            new HashMap<Class<?>, AttributeRenderer>();

    static final HashMap<String,STGroupFile> 
            FROM_CP_CACHE = new HashMap<String, STGroupFile>(),
            FROM_FILE_CACHE = new HashMap<String, STGroupFile>();
    
    public static final AttributeRenderer STRING_ATTRIBUTE_RENDERER = 
            new AttributeRenderer()
    {
        @Override
        public String toString(Object o, String formatName, Locale locale)
        {
            String str = (String) o;
            if (formatName == null)
                return str;

            String[] formats = FORMAT_DELIM.split(formatName);

            return formats.length == 0 ? format(str, formatName) :
                    chainedFormat(str, formats);
        }
    };

    static
    {
        // attribute renderers

        setAttributeRenderer(String.class, STRING_ATTRIBUTE_RENDERER);

        //GROUP_LOADER.loadGroup("base").setAttributeRenderers(DEFAULT_RENDERERS);
    }
    

    public static final STErrorListener ERROR_LISTENER = new STErrorListener()
    {
        @Override
        public void compileTimeError(STMessage msg)
        {
            errorCount += 1;
            System.err.println("compile-time error: " + msg);
        }

        @Override
        public void runTimeError(STMessage msg)
        {
            errorCount += 1;
            System.err.println("runtime error: " + msg);
        }

        @Override
        public void IOError(STMessage msg)
        {
            errorCount += 1;
            System.err.println("io error: " + msg);
        }

        @Override
        public void internalError(STMessage msg)
        {
            errorCount += 1;
            System.err.println("internal error: " + msg);
        }
    };
    
    /**
     * Returns true if there was no previous attribute renderer with the same class.
     */
    public static boolean setAttributeRenderer(Class<?> typeClass, AttributeRenderer ar)
    {
        return null == DEFAULT_RENDERERS.put(typeClass, ar);
    }
    
    final String name;
    
    public ST4Group(String name, Reader r, char[] delim)
    {
        if (delim[2] != 0 || delim[0] == '[' || delim[0] == '{')
            throw TemplateUtil.err("This delimiter: " + new String(delim) + " is not supported by st4");
        
        if (delim[0] != 0)
        {
            delimiterStartChar = delim[0];
            delimiterStopChar = delim[1];
        }
        
        this.name = name;
        // TODO re-declare this to un-synchronize it?
        //this.templates = new LinkedHashMap<String, CompiledST>();
        //this.dictionaries = new HashMap<String, Map<String,Object>>();
        
        ANTLRReaderStream fs;
        try
        {
            fs = new ANTLRReaderStream(r);
        }
        catch (IOException e)
        {
            throw TemplateUtil.err(e.getMessage(), e);
        }
        GroupLexer lexer = new GroupLexer(fs);
        fs.name = name;
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GroupParser parser = new GroupParser(tokens);
        try
        {
            parser.group(this, "");
        }
        catch (RecognitionException e)
        {
            throw TemplateUtil.err(e.getMessage(), e);
        }
    }
    
    protected CompiledST load(String name)
    {
        return templates.get(name.substring(1));
    }
    
    public AttributeRenderer getAttributeRenderer(Class<?> attributeType)
    {
        return DEFAULT_RENDERERS.get(attributeType);
    }
    
    public void registerRenderer(Class<?> attributeType, 
            AttributeRenderer r, boolean recursive)
    {
        // noop
    }
    
    @Override
    public Template getTemplate(String name)
    {
        CompiledST st = rawGetTemplate(name);
        
        return st == null ? null : new ST4Template(this, st);
    }
    
    public void importTemplates(Token fileNameToken)
    {
        final char[] delim = new char[5];
        String fileName = fileNameToken.getText();
        boolean checkFile = true;
        
        if (fileName.charAt(fileName.length()-2) == '_')
        {
            // extracts foo from "foo_"
            fileName = fileName.substring(1, fileName.length() - 2) + ".stg";
            
            // check cache
            STGroupFile existing = FROM_CP_CACHE.get(fileName);
            if (existing != null)
            {
                // cached
                importTemplates(existing, false);
                return;
            }
            
            checkFile = false;
        }
        else
        {
            // removes the quotes, extracts foo from "foo"
            fileName = fileName.substring(1, fileName.length() - 1) + ".stg";
            
            STGroupFile existing = FROM_FILE_CACHE.get(fileName);
            if (existing != null)
            {
                // cached
                importTemplates(existing, false);
                return;
            }
        }
        
        final URL url = TemplateUtil.getUrl(fileName, delim, checkFile);
        if (url == null)
            throw TemplateUtil.err("Import not found: " + fileName);
        
        if (delim[2] != 0)
            throw TemplateUtil.err("This delimiter: " + new String(delim) + " is not supported");
        
        char delimiterStartChar = '<',
                delimiterStopChar = '>';
        
        if (delim[0] != 0)
        {
            delimiterStartChar = delim[0];
            delimiterStopChar = delim[1];
        }
        
        final STGroupFile stgf = new STGroupFile(url, "UTF-8", 
                delimiterStartChar, delimiterStopChar);
        importTemplates(stgf, false);
        
        switch ((int)delim[4])
        {
            case 1:
                // from file
                FROM_FILE_CACHE.put(fileName, stgf);
                break;
            case 2:
                // from classpath
                FROM_CP_CACHE.put(fileName, stgf);
                break;
        }
    }
    
    public static final class ST4Template implements Template
    {
        final ST4Group group;
        final CompiledST st;
        
        ST4Template(ST4Group group, CompiledST st)
        {
            this.group = group;
            this.st = st;
        }
        
        @Override
        public void renderTo(BufferedWriter writer, Map<String, Object> args) throws IOException
        {
            ST template = group.createStringTemplate(st);
            for (Map.Entry<String, Object> entry : args.entrySet())
                template.add(entry.getKey(), entry.getValue());
            
            AutoIndentWriter w = new AutoIndentWriter(writer);
            /*int n = */template.write(w, Locale.getDefault(), ERROR_LISTENER);
        }
    }
    
}
