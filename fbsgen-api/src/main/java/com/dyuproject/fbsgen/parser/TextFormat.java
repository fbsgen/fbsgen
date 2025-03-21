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

// Protocol Buffers - Google's data interchange format
// Copyright 2008 Google Inc.  All rights reserved.
// http://code.google.com/p/protobuf/
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
//
//     * Redistributions of source code must retain the above copyright
// notice, this list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above
// copyright notice, this list of conditions and the following disclaimer
// in the documentation and/or other materials provided with the
// distribution.
//     * Neither the name of Google Inc. nor the names of its
// contributors may be used to endorse or promote products derived from
// this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

package com.dyuproject.fbsgen.parser;

import static com.dyuproject.fbsgen.parser.AnnotationContainer.err;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Provide ascii text parsing and formatting support for proto2 instances. The implementation largely follows
 * google/protobuf/text_format.cc.
 * 
 * @author wenboz@google.com Wenbo Zhu
 * @author kenton@google.com Kenton Varda
 * @author David Yu
 */
public final class TextFormat
{
    private TextFormat() {}

    static final Charset UTF8 = Charset.forName("UTF-8"), 
            ISO_8859_1 = Charset.forName("ISO-8859-1");

    // =================================================================
    // Utility functions
    //
    // Some of these methods are package-private because Descriptors.java uses
    // them.

    /**
     * Escapes bytes in the format used in protocol buffer text format, which is the same as the format used for C
     * string literals. All bytes that are not printable 7-bit ASCII characters are escaped, as well as backslash,
     * single-quote, and double-quote characters. Characters for which no defined short-hand escape sequence is defined
     * will be escaped using 3-digit octal sequences.
     */
    static StringBuilder escapeBytes(ByteBuffer input)
    {
        // input.flip();
        int length = input.limit();
        final StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++)
        {
            final byte b = input.get(i);
            switch (b)
            {
            // Java does not recognize \a or \v, apparently.
                case 0x07:
                    builder.append("\\007");
                    break;
                case '\b':
                    builder.append("\\b");
                    break;
                case '\f':
                    builder.append("\\f");
                    break;
                case '\n':
                    builder.append("\\n");
                    break;
                case '\r':
                    builder.append("\\r");
                    break;
                case '\t':
                    builder.append("\\t");
                    break;
                case 0x0b:
                    builder.append("\\013");
                    break;
                case '\\':
                    builder.append("\\\\");
                    break;
                case '\'':
                    builder.append("\\\'");
                    break;
                case '"':
                    builder.append("\\\"");
                    break;
                default:
                    if (b >= 0x20)
                    {
                        builder.append((char) b);
                    }
                    else
                    {
                        builder.append('\\');
                        builder.append((char) ('0' + ((b >>> 6) & 3)));
                        builder.append((char) ('0' + ((b >>> 3) & 7)));
                        builder.append((char) ('0' + (b & 7)));
                    }
                    break;
            }
        }
        return builder;
    }

    /**
     * Un-escape a byte sequence as escaped using {@link #escapeBytes(ByteString)}. Two-digit hex escapes (starting with
     * "\x") are also recognized.
     */
    static ByteBuffer unescapeBytes(final CharSequence input)
    {
        int pos = 0, len = input.length();
        final byte[] result = new byte[len];
        ByteBuffer buffer = ByteBuffer.wrap(result);
        for (int i = 0; i < len; i++)
        {
            char c = input.charAt(i);
            if (c == '\\')
            {
                if (i + 1 < len)
                {
                    ++i;
                    c = input.charAt(i);
                    if (isOctal(c))
                    {
                        // Octal escape.
                        int code = digitValue(c);
                        if (i + 1 < len && isOctal(input.charAt(i + 1)))
                        {
                            ++i;
                            code = code * 8 + digitValue(input.charAt(i));
                        }
                        if (i + 1 < len && isOctal(input.charAt(i + 1)))
                        {
                            ++i;
                            code = code * 8 + digitValue(input.charAt(i));
                        }
                        result[pos++] = (byte) code;
                    }
                    else
                    {
                        switch (c)
                        {
                            case 'a':
                                result[pos++] = 0x07;
                                break;
                            case 'b':
                                result[pos++] = '\b';
                                break;
                            case 'f':
                                result[pos++] = '\f';
                                break;
                            case 'n':
                                result[pos++] = '\n';
                                break;
                            case 'r':
                                result[pos++] = '\r';
                                break;
                            case 't':
                                result[pos++] = '\t';
                                break;
                            case 'v':
                                result[pos++] = 0x0b;
                                break;
                            case '\\':
                                result[pos++] = '\\';
                                break;
                            case '\'':
                                result[pos++] = '\'';
                                break;
                            case '"':
                                result[pos++] = '\"';
                                break;

                            case 'x':
                                // hex escape
                                int code = 0;
                                if (i + 1 < len && isHex(input.charAt(i + 1)))
                                {
                                    ++i;
                                    code = digitValue(input.charAt(i));
                                }
                                else
                                {
                                    throw new InvalidEscapeSequenceException(
                                            "Invalid escape sequence: '\\x' with no digits");
                                }
                                if (i + 1 < len && isHex(input.charAt(i + 1)))
                                {
                                    ++i;
                                    code = code * 16 + digitValue(input.charAt(i));
                                }
                                result[pos++] = (byte) code;
                                break;

                            default:
                                throw new InvalidEscapeSequenceException(
                                        "Invalid escape sequence: '\\" + c + '\'');
                        }
                    }
                }
                else
                {
                    throw new InvalidEscapeSequenceException(
                            "Invalid escape sequence: '\\' at end of string.");
                }
            }
            else
            {
                result[pos++] = (byte) c;
            }
        }
        buffer.limit(pos);
        return buffer;
    }

    /**
     * Thrown by {@link TextFormat#unescapeBytes} and {@link TextFormat#unescapeText} when an invalid escape sequence is
     * seen.
     */
    static class InvalidEscapeSequenceException extends RuntimeException
    {
        private static final long serialVersionUID = -8164033650142593305L;

        InvalidEscapeSequenceException(final String description)
        {
            super(description);
        }
    }

    /**
     * Like {@link #escapeBytes(ByteString)}, but escapes a text string. Non-ASCII characters are first encoded as
     * UTF-8, then each byte is escaped individually as a 3-digit octal escape. Yes, it's weird.
     */
    static String escapeText(final String input)
    {
        return escapeBytes(ByteBuffer.wrap(input.getBytes(ISO_8859_1))).toString();
    }

    /**
     * Un-escape a text string as escaped using {@link #escapeText(String)}. Two-digit hex escapes (starting with "\x")
     * are also recognized.
     */
    static String unescapeText(String input)
    {
        ByteBuffer buffer = unescapeBytes(input);
        return new String(buffer.array(), buffer.position(), buffer.limit(), ISO_8859_1);
    }

    /**
     * Is this an octal digit?
     */
    private static boolean isOctal(final char c)
    {
        return '0' <= c && c <= '7';
    }

    /**
     * Is this a hex digit?
     */
    private static boolean isHex(final char c)
    {
        return ('0' <= c && c <= '9') ||
                ('a' <= c && c <= 'f') ||
                ('A' <= c && c <= 'F');
    }

    /**
     * Interpret a character as a digit (in any base up to 36) and return the numeric value. This is like
     * {@code Character.digit()} but we don't accept non-ASCII digits.
     */
    private static int digitValue(final char c)
    {
        if ('0' <= c && c <= '9')
        {
            return c - '0';
        }
        else if ('a' <= c && c <= 'z')
        {
            return c - 'a' + 10;
        }
        else
        {
            return c - 'A' + 10;
        }
    }

    static int parseInt(Proto proto, HasName target, 
            final String text, final boolean isSigned)
            throws NumberFormatException
    {
        return (int)parseNumber(proto, target, text, isSigned, false);
    }

    static long parseLong(Proto proto, HasName target, 
            final String text, final boolean isSigned)
            throws NumberFormatException
    {
        return parseNumber(proto, target, text, isSigned, true);
    }

    private static long parseNumber(Proto proto, HasName target, 
            final String text, final boolean isSigned, 
            final boolean isLong) throws NumberFormatException
    {
        int pos = 0;

        boolean negative = false;
        if (text.startsWith("-", pos))
        {
            if (!isSigned)
            {
                throw err(proto, "Number must be positive: " + text + " @ " + target.getName());
            }
            ++pos;
            negative = true;
        }

        int radix = 10;
        if (text.startsWith("0x", pos))
        {
            pos += 2;
            radix = 16;
        }
        else if (text.startsWith("0", pos))
        {
            radix = 8;
        }

        final String numberText = text.substring(pos);

        long result = 0;
        if (numberText.length() < 16)
        {
            // Can safely assume no overflow.
            result = Long.parseLong(numberText, radix);
            if (negative)
            {
                result = -result;
            }

            // Check bounds.
            // No need to check for 64-bit numbers since they'd have to be 16
            // chars
            // or longer to overflow.
            if (!isLong)
            {
                if (isSigned)
                {
                    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                    {
                        throw err(proto, "Number out of range for 32-bit signed integer: " + text
                                + " @ " + target.getName());
                    }
                }
                else
                {
                    if (result >= (1L << 32) || result < 0)
                    {
                        throw err(proto, "Number out of range for 32-bit unsigned integer: " + text
                                + " @ " + target.getName());
                    }
                }
            }
        }
        else
        {
            BigInteger bigValue = new BigInteger(numberText, radix);
            if (negative)
            {
                bigValue = bigValue.negate();
            }

            // Check bounds.
            if (!isLong)
            {
                if (isSigned)
                {
                    if (bigValue.bitLength() > 31)
                    {
                        throw err(proto, "Number out of range for 32-bit signed integer: " + text
                                + " @ " + target.getName());
                    }
                }
                else
                {
                    if (bigValue.bitLength() > 32)
                    {
                        throw err(proto, "Number out of range for 32-bit unsigned integer: " + text
                                + " @ " + target.getName());
                    }
                }
            }
            else
            {
                if (isSigned)
                {
                    if (bigValue.bitLength() > 63)
                    {
                        throw err(proto, "Number out of range for 64-bit signed integer: " + text
                                + " @ " + target.getName());
                    }
                }
                else
                {
                    if (bigValue.bitLength() > 64)
                    {
                        throw err(proto, "Number out of range for 64-bit unsigned integer: " + text
                                + " @ " + target.getName());
                    }
                }
            }

            result = bigValue.longValue();
        }

        return result;
    }
    public static StringBuilder toCamelCase(String name)
    {
        StringBuilder buffer = new StringBuilder();
        int toUpper = 0;
        char c;
        for (int i=0, len=name.length(); i<len;)
        {
            c= name.charAt(i++);
            if (c=='_')
            {
                if (i==len)
                    break;
                if (buffer.length()!=0)
                    toUpper++;
                continue;
            }
            else if (toUpper!=0)
            {
                if (c>96 && c<123)
                {
                    buffer.append((char)(c-32));
                    toUpper = 0;
                }
                else if (c>64 && c<91)
                {
                    buffer.append(c);
                    toUpper = 0;
                }
                else
                {
                    while (toUpper>0)
                    {
                        buffer.append('_');
                        toUpper--;
                    }
                    buffer.append(c);
                }
            }
            else
            {
                if (buffer.length()==0 && c>64 && c<91)
                    buffer.append((char)(c+32));
                else
                    buffer.append(c);
            }
        }
        return buffer;
    }
    
    public static StringBuilder toPascalCase(String name)
    {
        StringBuilder buffer = toCamelCase(name);
        char c = buffer.charAt(0);
        if (c>96 && c<123)
            buffer.setCharAt(0, (char)(c-32));
        
        return buffer;
    }
    
    public static StringBuilder toUnderscoreCase(String name)
    {
        StringBuilder buffer = new StringBuilder();
        boolean toLower = false, appendUnderscore=false;
        for (int i=0, len=name.length(); i<len;)
        {
            char c = name.charAt(i++);
            if (c=='_')
            {
                if (i==len)
                    break;
                if (buffer.length()!=0)
                    appendUnderscore = true;
                
                continue;
            }
            
            if (appendUnderscore)
                buffer.append('_');
            
            if (c>96 && c<123)
            {
                buffer.append(c);
                toLower = true;
            }
            else if (c>64 && c<91)
            {
                if (toLower)
                {
                    // avoid duplicate underscore
                    if (!appendUnderscore)
                        buffer.append('_');
                    toLower = false;
                }
                buffer.append((char)(c+32));
            }
            else
            {
                buffer.append(c);
                toLower = false;
            }
            appendUnderscore = false;
        }
        return buffer;
    }
    
    /*public static void main(String[] args)
    {
        String[] gg = {"foo_bar_baz", "fooBarBaz", "FooBarBaz", "foo_bar_baz", "____Foo____Bar___Baz____"};
        for (String g : gg)
        {
            System.err.println(toCamelCase(g));
            System.err.println(toPascalCase(g));
            System.err.println(toUnderscoreCase(g));
            System.err.println(toUnderscoreCase(g).toString().toUpperCase());
        }
    }*/
}
