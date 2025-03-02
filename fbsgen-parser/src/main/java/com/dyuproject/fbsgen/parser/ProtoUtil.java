//========================================================================
//Copyright 2007-2009 David Yu dyuproject@gmail.com
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

package com.dyuproject.fbsgen.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

/**
 * Utility for loading protos from various input.
 *
 * @author David Yu
 * @created Dec 24, 2009
 */
public final class ProtoUtil
{
    
    private ProtoUtil() {}
    
    /**
     * Loads the proto from an {@link ANTLRReaderStream}.
     */
    public static void loadFrom(ANTLRReaderStream input, Proto target) throws IOException
    {
        // Create an ExprLexer that feeds from that stream
        ProtoLexer lexer = new ProtoLexer(input);
        // Create a stream of tokens fed by the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create a parser that feeds off the token stream
        ProtoParser parser = new ProtoParser(tokens);
        // Begin parsing at rule parse
        try
        {
            parser.parse(target);
        }
        catch (RecognitionException e)
        {
            throw new ParseException(e.getMessage(), e);
        }
    }
    
    /**
     * Loads the proto from an {@link InputStream}.
     */
    public static void loadFrom(InputStream in, Proto target) throws IOException
    {
        loadFrom(new ANTLRInputStream(in), target);
    }
    
    /**
     * Loads the proto from a {@link Reader}.
     */
    public static void loadFrom(Reader reader, Proto target) throws IOException
    {
        loadFrom(new ANTLRReaderStream(reader), target);
    }
    
    public static Proto parseProto(File file) throws IOException
    {
        Proto proto = new Proto(file, DefaultProtoLoader.DEFAULT_INSTANCE);
        loadFrom(file, proto);
        return proto;
    }
    
    public static void loadFrom(File file, Proto target) throws IOException
    {
        FileInputStream in = new FileInputStream(file);
        try
        {
            loadFrom(in, target);
        }
        finally
        {
            in.close();
        }
    }
    
    public static void loadFrom(URL resource, Proto target) throws IOException
    {
        InputStream in = resource.openStream();
        try
        {
            loadFrom(in, target);
        }
        finally
        {
            in.close();
        }
    }
}
