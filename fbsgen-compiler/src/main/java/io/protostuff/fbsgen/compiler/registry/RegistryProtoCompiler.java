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


package io.protostuff.fbsgen.compiler.registry;

import static io.protostuff.fbsgen.compiler.CompilerUtil.COMMA;
import static io.protostuff.fbsgen.compiler.CompilerUtil.SEMI_COLON;
import io.protostuff.fbsgen.compiler.CachingProtoLoader;
import io.protostuff.fbsgen.compiler.CompilerMain;
import io.protostuff.fbsgen.compiler.CompilerUtil;
import io.protostuff.fbsgen.compiler.ProtoModule;
import io.protostuff.fbsgen.compiler.Template;
import io.protostuff.fbsgen.compiler.TemplateGroup;
import io.protostuff.fbsgen.compiler.TemplateUtil;
import io.protostuff.fbsgen.compiler.TemplatedCodeGenerator;
import io.protostuff.fbsgen.compiler.TemplatedProtoCompiler;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Field;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.Proto;
import io.protostuff.fbsgen.parser.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Collects all the proto components and allows the delegates (stg) to generate code 
 * based on the {@link Registry}.
 *
 * @author David Yu
 * @created Dec 5, 2011
 */
public class RegistryProtoCompiler extends TemplatedCodeGenerator
{
    
    static
    {
        Config.initRenderers();
        Verbs.initRenderers();
    }

    public RegistryProtoCompiler()
    {
        super("registry");
    }
    
    @Override
    public void compile(ProtoModule module) throws IOException
    {
        final String stgsOption = module.getOption("stgs");
        final String activeStgsOption = module.getOption("active_stgs");
        
        if (stgsOption == null && activeStgsOption == null)
            throw new IllegalStateException("Required option: stgs or active_stgs");
        
        final String[] stgs = stgsOption == null ? new String[0] : 
            SEMI_COLON.split(stgsOption);
        
        final String[] activeStgs = activeStgsOption == null ? new String[0] : 
            SEMI_COLON.split(activeStgsOption);
        
        final boolean provideLoader = module.getCachingProtoLoader() == null;
        if (provideLoader)
        {
            // we need to cache 
            module.setCachingProtoLoader(new CachingProtoLoader());
        }
        
        final Registry registry = new Registry();
        collect(module, registry);
        
        final ArrayList<Proto> overridden = new ArrayList<Proto>();
        try
        {
            for (String stg : activeStgs)
                compile(module, registry, overridden, stg.trim(), true);
            
            for (String stg : stgs)
                compile(module, registry, overridden, stg.trim(), false);
        }
        finally
        {
            if (provideLoader)
                module.setCachingProtoLoader(null);
        }
    }
    
    private void compile(ProtoModule module, Registry registry, 
            ArrayList<Proto> overridden, String stg, boolean active) throws IOException
    {
        if (stg.charAt(0) == '_')
        {
            String ref = module.getConfig().getProperty(stg);
            if (ref == null)
                throw new RuntimeException("Missing property: " + stg);
            
            for (String s : COMMA.split(ref))
                compile(module, registry, overridden, s.trim(), active);
            return;
        }
        
        String name = TemplateUtil.getOutputName(stg),
                fileExtension = TemplateUtil.getFileExtension(stg);
        
        final TemplateGroup group = TemplateUtil.resolveGroup(stg, name, fileExtension);
        if (group == null)
            throw new RuntimeException("Unknown stg: " + stg);
        
        String optionsParam = module.getConfig().getProperty(stg + ".options");
        final Properties previousOptions;
        if (optionsParam != null)
        {
            previousOptions = new Properties();
            previousOptions.putAll(module.getOptions());
            
            CompilerMain.addOptionsTo(module.getOptions(), 
                    COMMA.split(optionsParam), 
                    module.getConfig());
            
            if (null != (optionsParam = module.getOption(stg + ".options")))
            {
                // embedded options
                CompilerMain.addOptionsTo(module.getOptions(), 
                        COMMA.split(optionsParam), 
                        module.getConfig());
            }
        }
        else if (null != (optionsParam = module.getOption(stg + ".options")))
        {
            // embedded options
            previousOptions = new Properties();
            previousOptions.putAll(module.getOptions());
            
            CompilerMain.addOptionsTo(module.getOptions(), 
                    COMMA.split(optionsParam), 
                    module.getConfig());
        }
        else
        {
            previousOptions = null;
        }
        
        final HashMap<String,Proto> foreignProtoPathMap = new HashMap<String, Proto>();
        final String output = module.getOutput();
        final File outputDir = module.getOutputDir();
        try
        {
            for (Proto proto : registry.getProtos())
                overrideAndAddTo(overridden, module, proto, registry, foreignProtoPathMap);
            
            final Template registryBlockTemplate = group.getTemplate("registry_block");
            
            if (registryBlockTemplate != null)
                compileToSingleFile(module, registry, stg, registryBlockTemplate);
            else if (active)
                compileActive(module, registry, stg);
            else
                filterAndCompile(module, registry, stg);
        }
        finally
        {
            // restore
            for (Proto p : overridden)
                postCompile(module, p);
            
            overridden.clear();

            if (previousOptions != null)
            {
                module.getOptions().clear();
                module.getOptions().putAll(previousOptions);
            }
            
            module.setOutput(output);
            module.setOutputDir(outputDir);
        }
    }
    
    static void overrideAndAddTo(ArrayList<Proto> overridden, 
            ProtoModule module, Proto proto, 
            Registry registry, HashMap<String,Proto> foreignProtoPathMap)
    {
        if (override(module, proto))
            overridden.add(proto);
        
        for (Proto p : proto.getImportedProtos())
        {
            // TODO this is freakishly slow, fix this
            String sourcePath = p.getSourcePath();
            
            if (!registry.protoPathMap.containsKey(sourcePath) && 
                    !foreignProtoPathMap.containsKey(sourcePath))
            {
                // its a foreign proto (not within the base path)
                // first time we've seen this
                foreignProtoPathMap.put(sourcePath, p);
                
                // inclue in override 
                overrideAndAddTo(overridden, module, p, registry, foreignProtoPathMap);
            }
        }
    }
    
    private static String getRequiredStgConfigFrom(ProtoModule module, String name)
    {
        // allow override from options
        String value = module.getOption(name);
        if (value == null && 
                null == (value = module.getConfig().getProperty(name)))
        {
            throw new RuntimeException("Missing config: " + name);
        }
        
        return value;
    }
    
    static void compileActive(final ProtoModule module, final Registry registry, 
            final String stg) throws IOException
    {
        // hack
        module.setOutput(stg);
        
        final TemplatedProtoCompiler compiler = new TemplatedProtoCompiler(module);
        
        final String outputDir = getRequiredStgConfigFrom(module, stg + ".output_dir");
        
        // hack
        module.setOutputDir(new File(outputDir.trim()));
        
        for (Proto proto : registry.getProtos())
            compileActive(module, compiler, proto, stg);
    }
    
    static void compileActive(final ProtoModule module, 
            final TemplatedProtoCompiler compiler, final Proto proto, 
            final String stg) throws IOException
    {
        if (compiler.protoBlockTemplate != null)
        {
            compiler.compileProtoBlock(module, proto, 
                    getPackageName(proto, compiler), 
                    compiler.protoBlockTemplate);
            
            return;
        }
        
        int templates = 0;
        if (compiler.messageBlockTemplate != null)
        {
            templates++;
            
            for (Message message : proto.getMessages())
            {
                if (!message.getA().isEmpty() && message.getA().containsKey("Exclude"))
                    continue;
                
                TemplatedProtoCompiler.compileMessageBlock(module, message, 
                        getPackageName(message.getProto(), compiler), 
                        compiler.resolveFileName(message.getRelativeName().replaceAll("\\.", "")), 
                        compiler.messageBlockTemplate);
            }
        }

        if (compiler.enumBlockTemplate != null)
        {
            templates++;
            
            for (EnumGroup eg : proto.getEnumGroups())
            {
                if (!eg.getA().isEmpty() && eg.getA().containsKey("Exclude"))
                    continue;
                
                TemplatedProtoCompiler.compileEnumBlock(module, eg, 
                        getPackageName(eg.getProto(), compiler), 
                        compiler.resolveFileName(eg.getRelativeName().replaceAll("\\.", "")), 
                        compiler.enumBlockTemplate);
            }
        }
        
        if (templates == 0)
        {
            throw new RuntimeException("Registry requires " +
                    "proto_block|message_block|enum_block for " + stg);
        }
    }
    
    static void filterAndCompile(final ProtoModule module, final Registry registry, 
            final String stg) throws IOException
    {
        // hack
        module.setOutput(stg);
        
        final TemplatedProtoCompiler compiler = new TemplatedProtoCompiler(module);
        
        final String outputDir = getRequiredStgConfigFrom(module, stg + ".output_dir");
        
        // hack
        module.setOutputDir(new File(outputDir.trim()));
        
        final ArrayList<Proto> protos = registry.stgProtoMapping.get(stg);
        if (protos != null)
        {
            if (compiler.protoBlockTemplate == null)
                throw new RuntimeException("Registry requires proto_block for " + stg);
            
            for (Proto proto : protos)
            {
                compiler.compileProtoBlock(module, proto, 
                        getPackageName(proto, compiler), 
                        compiler.protoBlockTemplate);
            }
        }
        
        final ArrayList<Message> messages = registry.stgMessageMapping.get(stg);
        if (messages != null)
        {
            if (compiler.messageBlockTemplate == null)
                throw new RuntimeException("Registry requires message_block for " + stg);
            
            for (Message message : messages)
            {
                if (!message.getA().isEmpty() && message.getA().containsKey("Exclude"))
                    continue;
                
                TemplatedProtoCompiler.compileMessageBlock(module, message, 
                        getPackageName(message.getProto(), compiler), 
                        compiler.resolveFileName(message.getRelativeName().replaceAll("\\.", "")), 
                        compiler.messageBlockTemplate);
            }
        }
        
        final ArrayList<EnumGroup> enumGroups = registry.stgEnumGroupMapping.get(stg);
        if (enumGroups != null)
        {
            if (compiler.enumBlockTemplate == null)
                throw new RuntimeException("Registry requires enum_block for " + stg);
            
            for (EnumGroup eg : enumGroups)
            {
                if (!eg.getA().isEmpty() && eg.getA().containsKey("Exclude"))
                    continue;
                
                TemplatedProtoCompiler.compileEnumBlock(module, eg, 
                        getPackageName(eg.getProto(), compiler), 
                        compiler.resolveFileName(eg.getRelativeName().replaceAll("\\.", "")), 
                        compiler.enumBlockTemplate);
            }
        }
    }
    
    static void compileToSingleFile(final ProtoModule module, final Registry registry, 
            final String stg, Template registryBlockTemplate) throws IOException
    {
        final String packageName = module.getOption(stg + ".package_name");
        if (packageName == null || packageName.isEmpty())
            throw new IllegalStateException("Missing option: " + stg + ".package_name");
        
        final String outputDir = getRequiredStgConfigFrom(module, stg + ".output_dir");

        // hack
        module.setOutputDir(new File(outputDir.trim()));
        
        final BufferedWriter writer = CompilerUtil.newWriter(module, packageName, stg);
        
        HashMap<String,Object> args = new HashMap<String, Object>();
        args.put("registry", registry);
        args.put("module", module);
        args.put("options", module.getOptions());
        
        registryBlockTemplate.renderTo(writer, args);
        
        writer.close();
    }
    
    static void collect(ProtoModule module, Registry target) throws IOException
    {
        File source = module.getSource();
        if (source.isDirectory())
        {
            for (File f : CompilerUtil.getProtoFiles(source))
                collect(parseProto(f, module), module, target);
        }
        else
            collect(parseProto(source, module), module, target);
        
        target.complete();
        
        module.setAttribute("registry", target);
    }
    
    static void collect(Proto proto, ProtoModule module, Registry target)
    {
        target.add(proto, module);
        
        for (EnumGroup eg : proto.getEnumGroups())
            collect(eg, module, target);
        
        for (Message m : proto.getMessages())
            collect(m, module, target);
        
        for (Service s : proto.getServices())
            target.add(s, module);
    }
    
    static void collect(EnumGroup eg, ProtoModule module, Registry target)
    {
        target.add(eg, module);
        
        for (EnumGroup.Value v : eg.getSortedValues())
            target.add(v, module);
    }
    
    static void collect(Message message, ProtoModule module, Registry target)
    {
        for (Service s : message.getNestedServices())
            target.add(s, module);
        
        for (EnumGroup eg : message.getNestedEnumGroups())
            collect(eg, module, target);
        
        for (Message m : message.getNestedMessages())
            collect(m, module, target);
        
        for (Field<?> f : message.getFields())
            target.add(f, module);
        
        target.add(message, module);
    }

    @Override
    protected void compile(ProtoModule module, Proto proto) throws IOException
    {
        // unused
    }
    
    static String getPackageName(Proto proto, TemplatedProtoCompiler compiler)
    {
        return compiler.javaOutput ? proto.getJavaPackageName() : proto.getPackageName();
    }
}