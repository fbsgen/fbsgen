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

package com.dyuproject.fbsgen.compiler;

import static com.dyuproject.fbsgen.compiler.ErrorUtil.err;
import static com.dyuproject.fbsgen.compiler.TemplatedCodeGenerator.FORMAT_DELIM;
import static com.dyuproject.fbsgen.compiler.TemplatedCodeGenerator.chainedFormat;
import static com.dyuproject.fbsgen.compiler.TemplatedCodeGenerator.errorCount;
import static com.dyuproject.fbsgen.compiler.TemplatedCodeGenerator.format;
import com.dyuproject.fbsgen.compiler.map.FakeMapUtil;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.stringtemplate.v4.AttributeRenderer;
import org.stringtemplate.v4.AutoIndentWriter;
import org.stringtemplate.v4.InstanceScope;
import org.stringtemplate.v4.Interpreter;
import org.stringtemplate.v4.ModelAdaptor;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.STWriter;
import org.stringtemplate.v4.compiler.CompiledST;
import org.stringtemplate.v4.compiler.GroupLexer;
import org.stringtemplate.v4.compiler.GroupParser;
import org.stringtemplate.v4.debug.EvalTemplateEvent;
import org.stringtemplate.v4.debug.InterpEvent;
import org.stringtemplate.v4.gui.STViz;
import org.stringtemplate.v4.misc.ErrorBuffer;
import org.stringtemplate.v4.misc.ErrorManager;
import org.stringtemplate.v4.misc.STMessage;
import org.stringtemplate.v4.misc.STNoSuchPropertyException;

/**
 * String template 4 group.
 * 
 * @author David Yu
 * @created Sep 9, 2014
 */
public final class ST4Group extends STGroup implements TemplateGroup
{
    
    static final HashMap<Class<?>, AttributeRenderer> DEFAULT_RENDERERS =
            new HashMap<Class<?>, AttributeRenderer>();

    static final HashMap<String,ST4GroupFile> 
            FROM_CP_CACHE = new HashMap<String, ST4GroupFile>(),
            FROM_FILE_CACHE = new HashMap<String, ST4GroupFile>();
    
    static final ModelAdaptor FAKEMAP_ADAPTOR = new ModelAdaptor()
    {
        @Override
        public Object getProperty(Interpreter interp, ST self, Object o, Object property,
                String propertyName) throws STNoSuchPropertyException
        {
            return ((FakeMap)o).get(property instanceof ST ? propertyName : property);
        }
    };
    
    static final AttributeRenderer STRING_RENDERER = 
            new AttributeRenderer()
    {
        @Override
        public String toString(Object o, String formatName, Locale locale)
        {
            String str = o.toString();
            if (formatName == null)
                return str;

            String[] formats = FORMAT_DELIM.split(formatName);

            return formats.length == 0 ? format(str, formatName) :
                    chainedFormat(str, formats);
        }
    };
    
    static final STErrorListener ERROR_LISTENER = new STErrorListener()
    {
        @Override
        public void compileTimeError(STMessage msg)
        {
            if (0 == errorCount++)
                System.err.println(msg);
        }

        @Override
        public void runTimeError(STMessage msg)
        {
            if (0 == errorCount++)
                System.err.println(msg);
        }

        @Override
        public void IOError(STMessage msg)
        {
            if (0 == errorCount++)
                System.err.println(msg);
        }

        @Override
        public void internalError(STMessage msg)
        {
            if (0 == errorCount++)
                System.err.println(msg);
        }
    };
    
    static ST4GroupFile importGroup(String fileName)
    {
        final char[] delim = new char[5];
        boolean checkFile = true;
        
        if (fileName.charAt(fileName.length()-2) == '_')
        {
            // extracts foo from "foo_"
            fileName = fileName.substring(1, fileName.length() - 2) + ".stg";
            
            // check cache
            ST4GroupFile existing = FROM_CP_CACHE.get(fileName);
            if (existing != null)
            {
                // cached
                return existing;
            }
            
            checkFile = false;
        }
        else
        {
            // removes the quotes, extracts foo from "foo"
            fileName = fileName.substring(1, fileName.length() - 1) + ".stg";
            
            ST4GroupFile existing = FROM_FILE_CACHE.get(fileName);
            if (existing != null || (existing = FROM_CP_CACHE.get(fileName)) != null)
            {
                // cached
                return existing;
            }
        }
        
        final URL url = TemplateUtil.getUrl(fileName, delim, checkFile);
        if (url == null)
            throw err(null, "Import not found: " + fileName);
        
        if (delim[2] != 0)
            throw err(null, "This delimiter: " + new String(delim) + " is not supported");
        
        char delimiterStartChar = '«',
                delimiterStopChar = '»';
        
        if (delim[0] != 0)
        {
            delimiterStartChar = delim[0];
            delimiterStopChar = delim[1];
        }
        
        final ST4GroupFile stgf = new ST4GroupFile(url, "UTF-8", 
                delimiterStartChar, delimiterStopChar);
        
        switch ((int)delim[4])
        {
            case 1:
                // from file
                FROM_FILE_CACHE.put(fileName, stgf);
                
                if (fileName.equals("fbsgen/dict.stg"))
                    FakeMapUtil.addMapsTo(stgf);
                
                break;
            case 2:
                // from classpath
                FROM_CP_CACHE.put(fileName, stgf);
                
                if (fileName.equals("fbsgen/dict.stg"))
                    FakeMapUtil.addMapsTo(stgf);
                
                break;
        }
        
        return stgf;
    }
    
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
            throw err(null, "This delimiter: " + new String(delim, 0, 2) + " is not supported by st4");
        
        if (delim[0] != 0)
        {
            delimiterStartChar = delim[0];
            delimiterStopChar = delim[1];
        }
        else
        {
            delimiterStartChar = '«';
            delimiterStopChar = '»';
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
            throw err(null, e.getMessage(), e);
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
            throw err(null, e.getMessage(), e);
        }
    }
    
    protected CompiledST load(String name)
    {
        return templates.get(name.substring(1));
    }
    
    public ST createStringTemplate(CompiledST impl)
    {
        return new CustomST(this, impl);
    }
    
    public ST createStringTemplateInternally(ST proto)
    {
        return new CustomST(proto);
    }
    
    public void importTemplates(Token fileNameToken)
    {
        importTemplates(importGroup(fileNameToken.getText()), false);
    }
    
    @Override
    public Template getTemplate(String name)
    {
        CompiledST st = rawGetTemplate(name);
        
        return st == null ? null : new ST4Template(this, st);
    }
    
    public AttributeRenderer getAttributeRenderer(Class<?> attributeType)
    {
        AttributeRenderer r = DEFAULT_RENDERERS.get(attributeType);
        return r == null ? STRING_RENDERER : r;
    }
    
    public void registerRenderer(Class<?> attributeType, 
            AttributeRenderer r, boolean recursive)
    {
        // noop
    }
    
    public ModelAdaptor getModelAdaptor(Class<?> attributeType)
    {
        return FakeMap.class.isAssignableFrom(attributeType) ? FAKEMAP_ADAPTOR : 
            super.getModelAdaptor(attributeType);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void put(String name, FakeMap map)
    {
        // hack
        Map<?,?> m = map;
        dictionaries.put(name, (Map<String, Object>)m);
    }
    
    static final class ST4GroupFile extends STGroupFile implements TemplateGroup
    {

        public ST4GroupFile(URL url, String encoding, char delimiterStartChar,
                char delimiterStopChar)
        {
            super(url, encoding, delimiterStartChar, delimiterStopChar);
        }
        
        public ST createStringTemplate(CompiledST impl)
        {
            return new CustomST(this, impl);
        }
        
        public ST createStringTemplateInternally(ST proto)
        {
            return new CustomST(proto);
        }
        
        public void importTemplates(Token fileNameToken)
        {
            importTemplates(importGroup(fileNameToken.getText()), false);
        }

        @Override
        public Template getTemplate(String name)
        {
            throw new UnsupportedOperationException();
        }

        public AttributeRenderer getAttributeRenderer(Class<?> attributeType)
        {
            AttributeRenderer r = DEFAULT_RENDERERS.get(attributeType);
            return r == null ? STRING_RENDERER : r;
        }
        
        public void registerRenderer(Class<?> attributeType, 
                AttributeRenderer r, boolean recursive)
        {
            // noop
        }
        
        public ModelAdaptor getModelAdaptor(Class<?> attributeType)
        {
            return FakeMap.class.isAssignableFrom(attributeType) ? FAKEMAP_ADAPTOR : 
                super.getModelAdaptor(attributeType);
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public void put(String name, FakeMap map)
        {
            // hack
            Map<?,?> m = map;
            dictionaries.put(name, (Map<String, Object>)m);
        }
    }
    
    static final class ST4Template implements Template
    {
        final ST4Group group;
        final CompiledST st;
        
        ST4Template(ST4Group group, CompiledST st)
        {
            this.group = group;
            this.st = st;
        }
        
        @Override
        public void renderTo(Writer writer, String argName, 
                Object argValue, ProtoModule module) throws IOException
        {
            ST template = group.createStringTemplate(st);

            template.add(argName, argValue);
            template.add("module", module);
            
            AutoIndentWriter w = new AutoIndentWriter(writer);
            /*int n = */template.write(w, Locale.getDefault(), ERROR_LISTENER);
        }
    }
    
    static final class CustomST extends ST
    {
        CustomST(STGroup group, CompiledST impl)
        {
            super();
            
            this.impl = impl;
            this.groupThatCreatedThisInstance = group;
            
            if (impl.formalArguments != null)
            {
                locals = new Object[impl.formalArguments.size()];
                Arrays.fill(locals, ST.EMPTY_ATTR);
            }
        }
        
        CustomST(ST proto)
        {
            super(proto);
        }
        
        public int write(STWriter out) throws IOException
        {
            Interpreter interp = new CustomInterpreter(groupThatCreatedThisInstance,
                    impl.nativeGroup.errMgr, false);
            InstanceScope scope = new InstanceScope(null, this);
            return interp.exec(out, scope);
        }

        public int write(STWriter out, Locale locale)
        {
            Interpreter interp = new CustomInterpreter(groupThatCreatedThisInstance, 
                    locale, impl.nativeGroup.errMgr, false);
            InstanceScope scope = new InstanceScope(null, this);
            return interp.exec(out, scope);
        }

        public int write(STWriter out, STErrorListener listener)
        {
            Interpreter interp = new CustomInterpreter(groupThatCreatedThisInstance,
                    new ErrorManager(listener), false);
            InstanceScope scope = new InstanceScope(null, this);
            return interp.exec(out, scope);
        }

        public int write(STWriter out, Locale locale, STErrorListener listener)
        {
            Interpreter interp = new CustomInterpreter(groupThatCreatedThisInstance, 
                    locale, new ErrorManager(listener), false);
            InstanceScope scope = new InstanceScope(null, this);
            return interp.exec(out, scope);
        }
        
        public STViz inspect(ErrorManager errMgr, Locale locale, int lineWidth)
        {
            ErrorBuffer errors = new ErrorBuffer();
            impl.nativeGroup.setListener(errors);
            StringWriter out = new StringWriter();
            STWriter wr = new AutoIndentWriter(out);
            wr.setLineWidth(lineWidth);
            Interpreter interp = new CustomInterpreter(groupThatCreatedThisInstance, 
                    locale, true);
            InstanceScope scope = new InstanceScope(null, this);
            interp.exec(wr, scope); // render and track events
            List<InterpEvent> events = interp.getEvents();
            EvalTemplateEvent overallTemplateEval = (EvalTemplateEvent)events
                    .get(events.size() - 1);
            STViz viz = new STViz(errMgr, overallTemplateEval, out.toString(), interp,
                    interp.getExecutionTrace(), errors.errors);
            viz.open();
            return viz;
        }
    }
    
    static final class CustomInterpreter extends Interpreter
    {

        public CustomInterpreter(STGroup group, boolean debug)
        {
            super(group, debug);
        }

        public CustomInterpreter(STGroup group, ErrorManager errMgr, boolean debug)
        {
            super(group, errMgr, debug);
        }

        public CustomInterpreter(STGroup group, Locale locale, boolean debug)
        {
            super(group, locale, debug);
        }

        public CustomInterpreter(STGroup group, Locale locale, ErrorManager errMgr, boolean debug)
        {
            super(group, locale, errMgr, debug);
        }

        /**
         * Does not catch exceptions (fail fast).
         */
        @Override
        public int exec(STWriter out, InstanceScope scope)
        {
            setDefaultArguments(out, scope);
            return _exec(out, scope);
        }
    }
}
