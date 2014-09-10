//========================================================================
//Copyright 2007-2010 David Yu dyuproject@gmail.com
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
import io.protostuff.fbsgen.parser.Annotation;
import io.protostuff.fbsgen.parser.EnumGroup;
import io.protostuff.fbsgen.parser.Message;
import io.protostuff.fbsgen.parser.Proto;
import io.protostuff.fbsgen.parser.ProtoUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;


/**
 * A plugin proto compiler whose output relies on the 'output' param configured in {@link ProtoModule}. The output param
 * should point to a ST resource (file, url, or from classpath).
 * 
 * @author David Yu
 * @created May 25, 2010
 */
public final class TemplatedProtoCompiler extends TemplatedCodeGenerator
{

    protected static final boolean CHECK_PLACEHOLDER = Boolean.parseBoolean(
            System.getProperty("fbsgen.check_placeholder", "true"));
    
    public final ProtoModule module;
    public final TemplateGroup group;
    public final Template enumBlockTemplate, messageBlockTemplate, protoBlockTemplate;
    public final boolean javaOutput;
    public final String fileExtension, outputName, outputPrefix, outputSuffix;

    public TemplatedProtoCompiler(ProtoModule module)
    {
        this(module, CHECK_PLACEHOLDER);
    }

    public TemplatedProtoCompiler(ProtoModule module, boolean checkPlaceHolder)
    {
        super(module.getOutput());

        this.module = module;
        
        String output = module.getOutput();
        fileExtension = TemplateUtil.getFileExtension(output);
        javaOutput = ".java".equalsIgnoreCase(fileExtension);

        outputName = TemplateUtil.getOutputName(output);
        
        group = TemplateUtil.resolveGroup(output, outputName, fileExtension);

        protoBlockTemplate = group.getTemplate("proto_block");
        if (protoBlockTemplate == null)
        {
            // validate that at least enum_block or message_block is present.
            enumBlockTemplate = group.getTemplate("enum_block");
            messageBlockTemplate = group.getTemplate("message_block");

            if (enumBlockTemplate == null && messageBlockTemplate == null)
            {
                throw err("At least one of these templates " +
                        "(proto_block|message_block|enum_block) " +
                        "need to be declared in " + module.getOutput());
            }
        }
        else
        {
            enumBlockTemplate = null;
            messageBlockTemplate = null;
        }
        
        final int placeHolder = checkPlaceHolder ? outputName.indexOf('$') : -1;
        if (placeHolder == -1)
        {
            // no placeholder
            outputPrefix = "";
            outputSuffix = "";
        }
        else if (placeHolder == 0)
        {
            // suffix only
            outputPrefix = "";
            // check if provided text is only 1 char "$"
            outputSuffix = outputName.length() == 1 ? "" : outputName.substring(1);
        }
        else if (placeHolder == outputName.length() - 1)
        {
            // prefix only
            outputPrefix = outputName.substring(0, outputName.length() - 1);
            outputSuffix = "";
        }
        else
        {
            // has both prefix and suffix
            outputPrefix = outputName.substring(0, placeHolder);
            outputSuffix = outputName.substring(placeHolder + 1);
        }
    }

    public String resolveFileName(String name)
    {
        return outputPrefix + name + outputSuffix + fileExtension;
    }

    public void compile(ProtoModule module, Proto proto) throws IOException
    {
        if (!this.module.getOutput().startsWith(module.getOutput()))
        {
            throw err("Wrong module: " +
                    this.module.getOutput() + " != " + module.getOutput());
        }

        final String packageName = javaOutput ? proto.getJavaPackageName() :
                proto.getPackageName();

        if (protoBlockTemplate != null)
        {
            compileProtoBlock(module, proto, packageName, protoBlockTemplate);
            return;
        }

        if (enumBlockTemplate != null)
        {
            for (EnumGroup eg : proto.getEnumGroups())
            {
                if (!eg.getA().isEmpty())
                {
                    Annotation a = eg.getAnnotation("Exclude");
                    if (a != null)
                    {
                        if (!getOutputId().startsWith(String.valueOf(
                                a.getP().get("unless_output"))))
                        {
                            continue;
                        }
                        
                        //@Exclude(unless_output = "foo.java.stg")
                    }
                    else if (null != (a = eg.getAnnotation("Include")))
                    {
                        if (getOutputId().startsWith(String.valueOf(
                                a.getP().get("unless_output"))))
                        {
                            continue;
                        }
                        
                        //@Include(unless_output = "bar.java.stg")
                    }
                }
                
                compileEnumBlock(module, eg, packageName,
                        resolveFileName(eg.getName()), enumBlockTemplate);
            }
        }

        if (messageBlockTemplate != null)
        {
            for (Message message : proto.getMessages())
            {
                if (!message.getA().isEmpty())
                {
                    Annotation a = message.getAnnotation("Exclude");
                    if (a != null)
                    {
                        if (!getOutputId().startsWith(String.valueOf(
                                a.getP().get("unless_output"))))
                        {
                            continue;
                        }
                        
                        //@Exclude(unless_output = "foo.java.stg")
                    }
                    else if (null != (a = message.getAnnotation("Include")))
                    {
                        if (getOutputId().startsWith(String.valueOf(
                                a.getP().get("unless_output"))))
                        {
                            continue;
                        }
                        
                        //@Include(unless_output = "bar.java.stg")
                    }
                }
                
                compileMessageBlock(module, message, packageName,
                        resolveFileName(message.getName()), messageBlockTemplate);
            }
        }
    }

    public static void compileEnumBlock(ProtoModule module, EnumGroup eg,
            String packageName, String fileName,
            Template enumBlockTemplate) throws IOException
    {
        BufferedWriter writer = CompilerUtil.newWriter(module, packageName, fileName);

        compileEnumBlockTo(writer, module, eg, enumBlockTemplate);

        writer.close();
    }

    public static void compileEnumBlockTo(BufferedWriter writer,
            ProtoModule module, EnumGroup eg,
            Template enumBlockTemplate) throws IOException
    {
        HashMap<String,Object> args = new HashMap<String, Object>();
        args.put("eg", eg);
        args.put("module", module);
        args.put("options", module.getOptions());
        
        enumBlockTemplate.renderTo(writer, args);
    }

    public static void compileMessageBlock(ProtoModule module, Message message,
            String packageName, String fileName,
            Template messageBlockTemplate) throws IOException
    {
        BufferedWriter writer = CompilerUtil.newWriter(module, packageName, fileName);

        compileMessageBlockTo(writer, module, message, messageBlockTemplate);

        writer.close();
    }

    public static void compileMessageBlockTo(BufferedWriter writer,
            ProtoModule module, Message message,
            Template messageBlockTemplate) throws IOException
    {
        HashMap<String,Object> args = new HashMap<String,Object>();
        args.put("message", message);
        args.put("module", module);
        args.put("options", module.getOptions());
        
        messageBlockTemplate.renderTo(writer, args);
    }

    public void compileProtoBlock(ProtoModule module, Proto proto,
            String packageName, Template protoBlockTemplate) throws IOException
    {
        String name = ProtoUtil.toPascalCase(proto.getFile().getName().replace(
                ".proto", "")).toString();

        if (javaOutput)
        {
            String outerClassname = proto.getExtraOption("java_outer_classname");
            if (outerClassname != null)
                name = outerClassname;
        }

        final String fileName;
        if (outputPrefix.isEmpty() && outputSuffix.isEmpty())
        {
            // resolve the prefix/suffix from module option
            String outerFilePrefix = module.getOption("outer_file_prefix");
            if (outerFilePrefix != null)
                name = outerFilePrefix + name;

            String outerFileSuffix = module.getOption("outer_file_suffix");
            if (outerFileSuffix != null)
                name += outerFileSuffix;

            fileName = name + fileExtension;
        }
        else
        {
            // use the placeholder in the output name
            fileName = resolveFileName(name);
        }

        BufferedWriter writer = CompilerUtil.newWriter(module, packageName, fileName);

        HashMap<String,Object> args = new HashMap<String, Object>();
        args.put("proto", proto);
        args.put("module", module);
        args.put("options", module.getOptions());
        
        protoBlockTemplate.renderTo(writer, args);

        writer.close();
    }

}
