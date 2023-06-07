// $ANTLR 3.5.2 com/dyuproject/fbsgen/parser/ProtoLexer.g 2023-06-07 18:10:04

    package com.dyuproject.fbsgen.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ProtoLexer extends AbstractLexer {
	public static final int EOF=-1;
	public static final int ASSIGN=4;
	public static final int AT=5;
	public static final int BOOL=6;
	public static final int BYTES=7;
	public static final int COLON=8;
	public static final int COMMA=9;
	public static final int COMMENT=10;
	public static final int DEFAULT=11;
	public static final int DOC_COMMENT=12;
	public static final int DOUBLE=13;
	public static final int ENUM=14;
	public static final int ESC_SEQ=15;
	public static final int EXP=16;
	public static final int FALSE=17;
	public static final int FLOAT=18;
	public static final int FULL_ID=19;
	public static final int HEX=20;
	public static final int HEX_DIGIT=21;
	public static final int ID=22;
	public static final int IMPORT=23;
	public static final int INT16=24;
	public static final int INT32=25;
	public static final int INT64=26;
	public static final int INT8=27;
	public static final int LEFTCURLY=28;
	public static final int LEFTPAREN=29;
	public static final int LEFTSQUARE=30;
	public static final int MAX=31;
	public static final int MESSAGE=32;
	public static final int MINUS=33;
	public static final int NUMDOUBLE=34;
	public static final int NUMFLOAT=35;
	public static final int NUMINT=36;
	public static final int OCTAL=37;
	public static final int OCTAL_ESC=38;
	public static final int OPTION=39;
	public static final int OPTIONAL=40;
	public static final int PKG=41;
	public static final int PLUS=42;
	public static final int REPEATED=43;
	public static final int REQUIRED=44;
	public static final int RETURNS=45;
	public static final int RIGHTCURLY=46;
	public static final int RIGHTPAREN=47;
	public static final int RIGHTSQUARE=48;
	public static final int RPC=49;
	public static final int SEMICOLON=50;
	public static final int SERVICE=51;
	public static final int STRING=52;
	public static final int STRING_LITERAL=53;
	public static final int SYNTAX=54;
	public static final int TO=55;
	public static final int TRUE=56;
	public static final int UINT16=57;
	public static final int UINT32=58;
	public static final int UINT64=59;
	public static final int UINT8=60;
	public static final int UNICODE_ESC=61;
	public static final int VOID=62;
	public static final int WS=63;

	// delegates
	// delegators
	public AbstractLexer[] getDelegates() {
		return new AbstractLexer[] {};
	}

	public ProtoLexer() {} 
	public ProtoLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ProtoLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "com/dyuproject/fbsgen/parser/ProtoLexer.g"; }

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:35:5: ( '=' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:35:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "AT"
	public final void mAT() throws RecognitionException {
		try {
			int _type = AT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:39:5: ( '@' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:39:9: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AT"

	// $ANTLR start "LEFTCURLY"
	public final void mLEFTCURLY() throws RecognitionException {
		try {
			int _type = LEFTCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:43:5: ( '{' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:43:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFTCURLY"

	// $ANTLR start "RIGHTCURLY"
	public final void mRIGHTCURLY() throws RecognitionException {
		try {
			int _type = RIGHTCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:47:5: ( '}' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:47:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHTCURLY"

	// $ANTLR start "LEFTPAREN"
	public final void mLEFTPAREN() throws RecognitionException {
		try {
			int _type = LEFTPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:51:5: ( '(' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:51:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFTPAREN"

	// $ANTLR start "RIGHTPAREN"
	public final void mRIGHTPAREN() throws RecognitionException {
		try {
			int _type = RIGHTPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:55:5: ( ')' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:55:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHTPAREN"

	// $ANTLR start "LEFTSQUARE"
	public final void mLEFTSQUARE() throws RecognitionException {
		try {
			int _type = LEFTSQUARE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:59:5: ( '[' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:59:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFTSQUARE"

	// $ANTLR start "RIGHTSQUARE"
	public final void mRIGHTSQUARE() throws RecognitionException {
		try {
			int _type = RIGHTSQUARE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:63:5: ( ']' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:63:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHTSQUARE"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:67:5: ( ':' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:67:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:71:5: ( ';' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:71:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:75:5: ( ',' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:75:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:79:5: ( '+' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:79:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:83:5: ( '-' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:83:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "TO"
	public final void mTO() throws RecognitionException {
		try {
			int _type = TO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:87:5: ( 'to' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:87:9: 'to'
			{
			match("to"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TO"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:91:5: ( 'true' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:91:9: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:95:5: ( 'false' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:95:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "PKG"
	public final void mPKG() throws RecognitionException {
		try {
			int _type = PKG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:99:5: ( 'package' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:99:9: 'package'
			{
			match("package"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PKG"

	// $ANTLR start "SYNTAX"
	public final void mSYNTAX() throws RecognitionException {
		try {
			int _type = SYNTAX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:103:5: ( 'syntax' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:103:9: 'syntax'
			{
			match("syntax"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SYNTAX"

	// $ANTLR start "IMPORT"
	public final void mIMPORT() throws RecognitionException {
		try {
			int _type = IMPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:107:5: ( 'import' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:107:9: 'import'
			{
			match("import"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPORT"

	// $ANTLR start "OPTION"
	public final void mOPTION() throws RecognitionException {
		try {
			int _type = OPTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:111:5: ( 'option' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:111:9: 'option'
			{
			match("option"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPTION"

	// $ANTLR start "MESSAGE"
	public final void mMESSAGE() throws RecognitionException {
		try {
			int _type = MESSAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:115:5: ( 'message' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:115:9: 'message'
			{
			match("message"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MESSAGE"

	// $ANTLR start "SERVICE"
	public final void mSERVICE() throws RecognitionException {
		try {
			int _type = SERVICE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:119:5: ( 'service' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:119:9: 'service'
			{
			match("service"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SERVICE"

	// $ANTLR start "ENUM"
	public final void mENUM() throws RecognitionException {
		try {
			int _type = ENUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:123:5: ( 'enum' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:123:9: 'enum'
			{
			match("enum"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENUM"

	// $ANTLR start "REQUIRED"
	public final void mREQUIRED() throws RecognitionException {
		try {
			int _type = REQUIRED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:127:5: ( 'required' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:127:9: 'required'
			{
			match("required"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REQUIRED"

	// $ANTLR start "OPTIONAL"
	public final void mOPTIONAL() throws RecognitionException {
		try {
			int _type = OPTIONAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:131:5: ( 'optional' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:131:9: 'optional'
			{
			match("optional"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPTIONAL"

	// $ANTLR start "REPEATED"
	public final void mREPEATED() throws RecognitionException {
		try {
			int _type = REPEATED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:135:5: ( 'repeated' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:135:9: 'repeated'
			{
			match("repeated"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REPEATED"

	// $ANTLR start "RPC"
	public final void mRPC() throws RecognitionException {
		try {
			int _type = RPC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:151:5: ( 'rpc' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:151:9: 'rpc'
			{
			match("rpc"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPC"

	// $ANTLR start "RETURNS"
	public final void mRETURNS() throws RecognitionException {
		try {
			int _type = RETURNS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:155:5: ( 'returns' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:155:9: 'returns'
			{
			match("returns"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURNS"

	// $ANTLR start "INT8"
	public final void mINT8() throws RecognitionException {
		try {
			int _type = INT8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:159:5: ( 'int8' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:159:9: 'int8'
			{
			match("int8"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT8"

	// $ANTLR start "INT16"
	public final void mINT16() throws RecognitionException {
		try {
			int _type = INT16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:163:5: ( 'int16' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:163:9: 'int16'
			{
			match("int16"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT16"

	// $ANTLR start "INT32"
	public final void mINT32() throws RecognitionException {
		try {
			int _type = INT32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:167:5: ( 'int32' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:167:9: 'int32'
			{
			match("int32"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT32"

	// $ANTLR start "INT64"
	public final void mINT64() throws RecognitionException {
		try {
			int _type = INT64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:171:5: ( 'int64' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:171:9: 'int64'
			{
			match("int64"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT64"

	// $ANTLR start "UINT8"
	public final void mUINT8() throws RecognitionException {
		try {
			int _type = UINT8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:175:5: ( 'uint8' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:175:9: 'uint8'
			{
			match("uint8"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UINT8"

	// $ANTLR start "UINT16"
	public final void mUINT16() throws RecognitionException {
		try {
			int _type = UINT16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:179:5: ( 'uint16' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:179:9: 'uint16'
			{
			match("uint16"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UINT16"

	// $ANTLR start "UINT32"
	public final void mUINT32() throws RecognitionException {
		try {
			int _type = UINT32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:183:5: ( 'uint32' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:183:9: 'uint32'
			{
			match("uint32"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UINT32"

	// $ANTLR start "UINT64"
	public final void mUINT64() throws RecognitionException {
		try {
			int _type = UINT64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:187:5: ( 'uint64' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:187:9: 'uint64'
			{
			match("uint64"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UINT64"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:191:5: ( 'float' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:191:9: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "DOUBLE"
	public final void mDOUBLE() throws RecognitionException {
		try {
			int _type = DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:195:5: ( 'double' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:195:9: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE"

	// $ANTLR start "BOOL"
	public final void mBOOL() throws RecognitionException {
		try {
			int _type = BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:199:5: ( 'bool' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:199:9: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:203:5: ( 'string' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:203:9: 'string'
			{
			match("string"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "BYTES"
	public final void mBYTES() throws RecognitionException {
		try {
			int _type = BYTES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:207:5: ( 'bytes' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:207:9: 'bytes'
			{
			match("bytes"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BYTES"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:211:5: ( 'default' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:211:9: 'default'
			{
			match("default"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "MAX"
	public final void mMAX() throws RecognitionException {
		try {
			int _type = MAX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:215:5: ( 'max' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:215:9: 'max'
			{
			match("max"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAX"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:219:5: ( 'void' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:219:9: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID"

	// $ANTLR start "FULL_ID"
	public final void mFULL_ID() throws RecognitionException {
		try {
			int _type = FULL_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:223:5: ( ID ( '.' ID )+ )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:223:7: ID ( '.' ID )+
			{
			mID(); 

			// com/dyuproject/fbsgen/parser/ProtoLexer.g:223:10: ( '.' ID )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='.') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:223:11: '.' ID
					{
					match('.'); 
					mID(); 

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FULL_ID"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:227:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:227:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:227:33: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "EXP"
	public final void mEXP() throws RecognitionException {
		try {
			int _type = EXP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:231:5: ( NUMINT ( 'e' | 'E' ) NUMINT )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:231:9: NUMINT ( 'e' | 'E' ) NUMINT
			{
			mNUMINT(); 

			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			mNUMINT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXP"

	// $ANTLR start "NUMDOUBLE"
	public final void mNUMDOUBLE() throws RecognitionException {
		try {
			int _type = NUMDOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:235:5: ( ( NUMFLOAT | NUMINT ) 'e' ( '0' .. '9' )+ )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:235:9: ( NUMFLOAT | NUMINT ) 'e' ( '0' .. '9' )+
			{
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:235:9: ( NUMFLOAT | NUMINT )
			int alt3=2;
			alt3 = dfa3.predict(input);
			switch (alt3) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:235:10: NUMFLOAT
					{
					mNUMFLOAT(); 

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:235:19: NUMINT
					{
					mNUMINT(); 

					}
					break;

			}

			match('e'); 
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:236:13: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMDOUBLE"

	// $ANTLR start "NUMFLOAT"
	public final void mNUMFLOAT() throws RecognitionException {
		try {
			int _type = NUMFLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:240:5: ( NUMINT '.' ( '0' .. '9' )+ ( 'f' )? )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:240:9: NUMINT '.' ( '0' .. '9' )+ ( 'f' )?
			{
			mNUMINT(); 

			match('.'); 
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:240:20: ( '0' .. '9' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			// com/dyuproject/fbsgen/parser/ProtoLexer.g:240:30: ( 'f' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='f') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:240:30: 'f'
					{
					match('f'); 
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMFLOAT"

	// $ANTLR start "NUMINT"
	public final void mNUMINT() throws RecognitionException {
		try {
			int _type = NUMINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:244:5: ( '0' | ( MINUS )? '1' .. '9' ( '0' .. '9' )* )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='0') ) {
				alt9=1;
			}
			else if ( (LA9_0=='-'||(LA9_0 >= '1' && LA9_0 <= '9')) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:244:9: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:244:15: ( MINUS )? '1' .. '9' ( '0' .. '9' )*
					{
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:244:15: ( MINUS )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0=='-') ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoLexer.g:
							{
							if ( input.LA(1)=='-' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					matchRange('1','9'); 
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:244:31: ( '0' .. '9' )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoLexer.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop8;
						}
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMINT"

	// $ANTLR start "HEX"
	public final void mHEX() throws RecognitionException {
		try {
			int _type = HEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:248:5: ( ( MINUS )? '0' ( 'x' | 'X' ) ( HEX_DIGIT )+ )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:248:9: ( MINUS )? '0' ( 'x' | 'X' ) ( HEX_DIGIT )+
			{
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:248:9: ( MINUS )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='-') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:
					{
					if ( input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			match('0'); 
			if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:248:30: ( HEX_DIGIT )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'F')||(LA11_0 >= 'a' && LA11_0 <= 'f')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX"

	// $ANTLR start "OCTAL"
	public final void mOCTAL() throws RecognitionException {
		try {
			int _type = OCTAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:252:5: ( '0' ( '0' .. '7' )+ )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:252:9: '0' ( '0' .. '7' )+
			{
			match('0'); 
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:252:13: ( '0' .. '7' )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '0' && LA12_0 <= '7')) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OCTAL"

	// $ANTLR start "DOC_COMMENT"
	public final void mDOC_COMMENT() throws RecognitionException {
		try {
			int _type = DOC_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:256:5: ( '///' ( (~ ( '\\n' | '\\r' ) )* ) ( '\\r' )? '\\n' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:256:9: '///' ( (~ ( '\\n' | '\\r' ) )* ) ( '\\r' )? '\\n'
			{
			match("///"); 

			// com/dyuproject/fbsgen/parser/ProtoLexer.g:256:15: ( (~ ( '\\n' | '\\r' ) )* )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:256:16: (~ ( '\\n' | '\\r' ) )*
			{
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:256:16: (~ ( '\\n' | '\\r' ) )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '\u0000' && LA13_0 <= '\t')||(LA13_0 >= '\u000B' && LA13_0 <= '\f')||(LA13_0 >= '\u000E' && LA13_0 <= '\uFFFF')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop13;
				}
			}

			}

			// com/dyuproject/fbsgen/parser/ProtoLexer.g:256:31: ( '\\r' )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0=='\r') ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:256:31: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOC_COMMENT"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:260:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0=='/') ) {
				int LA18_1 = input.LA(2);
				if ( (LA18_1=='/') ) {
					alt18=1;
				}
				else if ( (LA18_1=='*') ) {
					alt18=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:260:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// com/dyuproject/fbsgen/parser/ProtoLexer.g:260:14: (~ ( '\\n' | '\\r' ) )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( ((LA15_0 >= '\u0000' && LA15_0 <= '\t')||(LA15_0 >= '\u000B' && LA15_0 <= '\f')||(LA15_0 >= '\u000E' && LA15_0 <= '\uFFFF')) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoLexer.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop15;
						}
					}

					// com/dyuproject/fbsgen/parser/ProtoLexer.g:260:28: ( '\\r' )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0=='\r') ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoLexer.g:260:28: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					skip();
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:261:9: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// com/dyuproject/fbsgen/parser/ProtoLexer.g:261:14: ( options {greedy=false; } : . )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0=='*') ) {
							int LA17_1 = input.LA(2);
							if ( (LA17_1=='/') ) {
								alt17=2;
							}
							else if ( ((LA17_1 >= '\u0000' && LA17_1 <= '.')||(LA17_1 >= '0' && LA17_1 <= '\uFFFF')) ) {
								alt17=1;
							}

						}
						else if ( ((LA17_0 >= '\u0000' && LA17_0 <= ')')||(LA17_0 >= '+' && LA17_0 <= '\uFFFF')) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoLexer.g:261:42: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop17;
						}
					}

					match("*/"); 

					skip();
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:264:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:264:9: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:272:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:272:9: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:272:13: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
			loop19:
			while (true) {
				int alt19=3;
				int LA19_0 = input.LA(1);
				if ( (LA19_0=='\\') ) {
					alt19=1;
				}
				else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '!')||(LA19_0 >= '#' && LA19_0 <= '[')||(LA19_0 >= ']' && LA19_0 <= '\uFFFF')) ) {
					alt19=2;
				}

				switch (alt19) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:272:15: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:272:25: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop19;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "HEX_DIGIT"
	public final void mHEX_DIGIT() throws RecognitionException {
		try {
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:276:5: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_DIGIT"

	// $ANTLR start "ESC_SEQ"
	public final void mESC_SEQ() throws RecognitionException {
		try {
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:280:5: ( '\\\\' ( 'a' | 'v' | 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | '\\\\' ( 'x' | 'X' ) HEX_DIGIT HEX_DIGIT | UNICODE_ESC | OCTAL_ESC )
			int alt20=4;
			int LA20_0 = input.LA(1);
			if ( (LA20_0=='\\') ) {
				switch ( input.LA(2) ) {
				case '\"':
				case '\'':
				case '\\':
				case 'a':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't':
				case 'v':
					{
					alt20=1;
					}
					break;
				case 'X':
				case 'x':
					{
					alt20=2;
					}
					break;
				case 'u':
					{
					alt20=3;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
					{
					alt20=4;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:280:9: '\\\\' ( 'a' | 'v' | 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
					{
					match('\\'); 
					if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||(input.LA(1) >= 'a' && input.LA(1) <= 'b')||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t'||input.LA(1)=='v' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:281:9: '\\\\' ( 'x' | 'X' ) HEX_DIGIT HEX_DIGIT
					{
					match('\\'); 
					if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					mHEX_DIGIT(); 

					mHEX_DIGIT(); 

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:282:9: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:283:9: OCTAL_ESC
					{
					mOCTAL_ESC(); 

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC_SEQ"

	// $ANTLR start "OCTAL_ESC"
	public final void mOCTAL_ESC() throws RecognitionException {
		try {
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:287:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt21=3;
			int LA21_0 = input.LA(1);
			if ( (LA21_0=='\\') ) {
				int LA21_1 = input.LA(2);
				if ( ((LA21_1 >= '0' && LA21_1 <= '3')) ) {
					int LA21_2 = input.LA(3);
					if ( ((LA21_2 >= '0' && LA21_2 <= '7')) ) {
						int LA21_4 = input.LA(4);
						if ( ((LA21_4 >= '0' && LA21_4 <= '7')) ) {
							alt21=1;
						}

						else {
							alt21=2;
						}

					}

					else {
						alt21=3;
					}

				}
				else if ( ((LA21_1 >= '4' && LA21_1 <= '7')) ) {
					int LA21_3 = input.LA(3);
					if ( ((LA21_3 >= '0' && LA21_3 <= '7')) ) {
						alt21=2;
					}

					else {
						alt21=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 21, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:287:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:288:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoLexer.g:289:9: '\\\\' ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OCTAL_ESC"

	// $ANTLR start "UNICODE_ESC"
	public final void mUNICODE_ESC() throws RecognitionException {
		try {
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:293:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// com/dyuproject/fbsgen/parser/ProtoLexer.g:293:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			{
			match('\\'); 
			match('u'); 
			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNICODE_ESC"

	@Override
	public void mTokens() throws RecognitionException {
		// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:8: ( ASSIGN | AT | LEFTCURLY | RIGHTCURLY | LEFTPAREN | RIGHTPAREN | LEFTSQUARE | RIGHTSQUARE | COLON | SEMICOLON | COMMA | PLUS | MINUS | TO | TRUE | FALSE | PKG | SYNTAX | IMPORT | OPTION | MESSAGE | SERVICE | ENUM | REQUIRED | OPTIONAL | REPEATED | RPC | RETURNS | INT8 | INT16 | INT32 | INT64 | UINT8 | UINT16 | UINT32 | UINT64 | FLOAT | DOUBLE | BOOL | STRING | BYTES | DEFAULT | MAX | VOID | FULL_ID | ID | EXP | NUMDOUBLE | NUMFLOAT | NUMINT | HEX | OCTAL | DOC_COMMENT | COMMENT | WS | STRING_LITERAL )
		int alt22=56;
		alt22 = dfa22.predict(input);
		switch (alt22) {
			case 1 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:10: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 2 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:17: AT
				{
				mAT(); 

				}
				break;
			case 3 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:20: LEFTCURLY
				{
				mLEFTCURLY(); 

				}
				break;
			case 4 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:30: RIGHTCURLY
				{
				mRIGHTCURLY(); 

				}
				break;
			case 5 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:41: LEFTPAREN
				{
				mLEFTPAREN(); 

				}
				break;
			case 6 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:51: RIGHTPAREN
				{
				mRIGHTPAREN(); 

				}
				break;
			case 7 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:62: LEFTSQUARE
				{
				mLEFTSQUARE(); 

				}
				break;
			case 8 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:73: RIGHTSQUARE
				{
				mRIGHTSQUARE(); 

				}
				break;
			case 9 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:85: COLON
				{
				mCOLON(); 

				}
				break;
			case 10 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:91: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 11 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:101: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 12 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:107: PLUS
				{
				mPLUS(); 

				}
				break;
			case 13 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:112: MINUS
				{
				mMINUS(); 

				}
				break;
			case 14 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:118: TO
				{
				mTO(); 

				}
				break;
			case 15 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:121: TRUE
				{
				mTRUE(); 

				}
				break;
			case 16 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:126: FALSE
				{
				mFALSE(); 

				}
				break;
			case 17 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:132: PKG
				{
				mPKG(); 

				}
				break;
			case 18 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:136: SYNTAX
				{
				mSYNTAX(); 

				}
				break;
			case 19 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:143: IMPORT
				{
				mIMPORT(); 

				}
				break;
			case 20 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:150: OPTION
				{
				mOPTION(); 

				}
				break;
			case 21 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:157: MESSAGE
				{
				mMESSAGE(); 

				}
				break;
			case 22 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:165: SERVICE
				{
				mSERVICE(); 

				}
				break;
			case 23 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:173: ENUM
				{
				mENUM(); 

				}
				break;
			case 24 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:178: REQUIRED
				{
				mREQUIRED(); 

				}
				break;
			case 25 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:187: OPTIONAL
				{
				mOPTIONAL(); 

				}
				break;
			case 26 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:196: REPEATED
				{
				mREPEATED(); 

				}
				break;
			case 27 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:205: RPC
				{
				mRPC(); 

				}
				break;
			case 28 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:209: RETURNS
				{
				mRETURNS(); 

				}
				break;
			case 29 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:217: INT8
				{
				mINT8(); 

				}
				break;
			case 30 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:222: INT16
				{
				mINT16(); 

				}
				break;
			case 31 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:228: INT32
				{
				mINT32(); 

				}
				break;
			case 32 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:234: INT64
				{
				mINT64(); 

				}
				break;
			case 33 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:240: UINT8
				{
				mUINT8(); 

				}
				break;
			case 34 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:246: UINT16
				{
				mUINT16(); 

				}
				break;
			case 35 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:253: UINT32
				{
				mUINT32(); 

				}
				break;
			case 36 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:260: UINT64
				{
				mUINT64(); 

				}
				break;
			case 37 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:267: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 38 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:273: DOUBLE
				{
				mDOUBLE(); 

				}
				break;
			case 39 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:280: BOOL
				{
				mBOOL(); 

				}
				break;
			case 40 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:285: STRING
				{
				mSTRING(); 

				}
				break;
			case 41 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:292: BYTES
				{
				mBYTES(); 

				}
				break;
			case 42 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:298: DEFAULT
				{
				mDEFAULT(); 

				}
				break;
			case 43 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:306: MAX
				{
				mMAX(); 

				}
				break;
			case 44 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:310: VOID
				{
				mVOID(); 

				}
				break;
			case 45 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:315: FULL_ID
				{
				mFULL_ID(); 

				}
				break;
			case 46 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:323: ID
				{
				mID(); 

				}
				break;
			case 47 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:326: EXP
				{
				mEXP(); 

				}
				break;
			case 48 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:330: NUMDOUBLE
				{
				mNUMDOUBLE(); 

				}
				break;
			case 49 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:340: NUMFLOAT
				{
				mNUMFLOAT(); 

				}
				break;
			case 50 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:349: NUMINT
				{
				mNUMINT(); 

				}
				break;
			case 51 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:356: HEX
				{
				mHEX(); 

				}
				break;
			case 52 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:360: OCTAL
				{
				mOCTAL(); 

				}
				break;
			case 53 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:366: DOC_COMMENT
				{
				mDOC_COMMENT(); 

				}
				break;
			case 54 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:378: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 55 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:386: WS
				{
				mWS(); 

				}
				break;
			case 56 :
				// com/dyuproject/fbsgen/parser/ProtoLexer.g:1:389: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;

		}
	}


	protected DFA3 dfa3 = new DFA3(this);
	protected DFA22 dfa22 = new DFA22(this);
	static final String DFA3_eotS =
		"\7\uffff";
	static final String DFA3_eofS =
		"\7\uffff";
	static final String DFA3_minS =
		"\1\55\1\56\1\61\1\56\2\uffff\1\56";
	static final String DFA3_maxS =
		"\1\71\1\145\1\71\1\145\2\uffff\1\145";
	static final String DFA3_acceptS =
		"\4\uffff\1\1\1\2\1\uffff";
	static final String DFA3_specialS =
		"\7\uffff}>";
	static final String[] DFA3_transitionS = {
			"\1\2\2\uffff\1\1\11\3",
			"\1\4\66\uffff\1\5",
			"\11\3",
			"\1\4\1\uffff\12\6\53\uffff\1\5",
			"",
			"",
			"\1\4\1\uffff\12\6\53\uffff\1\5"
	};

	static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
	static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
	static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
	static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
	static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
	static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
	static final short[][] DFA3_transition;

	static {
		int numStates = DFA3_transitionS.length;
		DFA3_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
		}
	}

	protected class DFA3 extends DFA {

		public DFA3(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 3;
			this.eot = DFA3_eot;
			this.eof = DFA3_eof;
			this.min = DFA3_min;
			this.max = DFA3_max;
			this.accept = DFA3_accept;
			this.special = DFA3_special;
			this.transition = DFA3_transition;
		}
		@Override
		public String getDescription() {
			return "235:9: ( NUMFLOAT | NUMINT )";
		}
	}

	static final String DFA22_eotS =
		"\15\uffff\1\41\16\46\2\74\5\uffff\1\104\2\46\2\uffff\24\46\5\uffff\1\74"+
		"\3\uffff\13\46\1\156\4\46\1\163\6\46\2\77\1\175\1\uffff\1\u0081\7\46\1"+
		"\u0089\5\46\1\uffff\1\u008f\3\46\1\uffff\3\46\1\u0099\1\46\1\u009b\1\uffff"+
		"\1\77\1\175\5\uffff\1\u009d\1\u009e\5\46\1\uffff\1\u00a4\1\u00a5\1\u00a6"+
		"\2\46\1\uffff\3\46\1\u00ac\5\46\1\uffff\1\u00b2\4\uffff\1\46\1\u00b4\1"+
		"\46\1\u00b6\1\u00b7\3\uffff\1\u00b9\4\46\1\uffff\1\u00be\1\u00bf\1\u00c0"+
		"\1\u00c1\1\46\1\uffff\1\u00c3\1\uffff\1\u00c4\2\uffff\1\46\1\uffff\1\u00c6"+
		"\2\46\1\u00c9\4\uffff\1\u00ca\2\uffff\1\u00cb\1\uffff\1\u00cc\1\u00cd"+
		"\5\uffff";
	static final String DFA22_eofS =
		"\u00ce\uffff";
	static final String DFA22_minS =
		"\1\11\14\uffff\1\60\20\56\1\52\4\uffff\3\56\2\uffff\24\56\1\uffff\1\55"+
		"\1\60\2\uffff\1\56\1\0\2\uffff\27\56\3\60\1\0\16\56\1\uffff\4\56\1\uffff"+
		"\6\56\1\uffff\1\60\1\145\1\uffff\1\0\1\12\2\uffff\7\56\1\uffff\5\56\1"+
		"\uffff\11\56\1\uffff\1\56\4\uffff\5\56\3\uffff\5\56\1\uffff\5\56\1\uffff"+
		"\1\56\1\uffff\1\56\2\uffff\1\56\1\uffff\4\56\4\uffff\1\56\2\uffff\1\56"+
		"\1\uffff\2\56\5\uffff";
	static final String DFA22_maxS =
		"\1\175\14\uffff\1\71\16\172\1\170\1\145\1\57\4\uffff\3\172\2\uffff\24"+
		"\172\1\uffff\2\71\2\uffff\1\145\1\uffff\2\uffff\27\172\2\71\1\146\1\uffff"+
		"\16\172\1\uffff\4\172\1\uffff\6\172\1\uffff\1\71\1\145\1\uffff\1\uffff"+
		"\1\12\2\uffff\7\172\1\uffff\5\172\1\uffff\11\172\1\uffff\1\172\4\uffff"+
		"\5\172\3\uffff\5\172\1\uffff\5\172\1\uffff\1\172\1\uffff\1\172\2\uffff"+
		"\1\172\1\uffff\4\172\4\uffff\1\172\2\uffff\1\172\1\uffff\2\172\5\uffff";
	static final String DFA22_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\22\uffff"+
		"\1\67\1\70\1\15\1\63\3\uffff\1\56\1\55\24\uffff\1\62\2\uffff\1\57\1\64"+
		"\2\uffff\1\66\1\16\51\uffff\1\53\4\uffff\1\33\6\uffff\1\60\2\uffff\1\61"+
		"\2\uffff\1\65\1\17\7\uffff\1\35\5\uffff\1\27\11\uffff\1\47\1\uffff\1\54"+
		"\1\65\1\20\1\45\5\uffff\1\36\1\37\1\40\5\uffff\1\41\5\uffff\1\51\1\uffff"+
		"\1\22\1\uffff\1\50\1\23\1\uffff\1\24\4\uffff\1\42\1\43\1\44\1\46\1\uffff"+
		"\1\21\1\26\1\uffff\1\25\2\uffff\1\34\1\52\1\31\1\30\1\32";
	static final String DFA22_specialS =
		"\102\uffff\1\0\34\uffff\1\2\36\uffff\1\1\117\uffff}>";
	static final String[] DFA22_transitionS = {
			"\2\37\2\uffff\1\37\22\uffff\1\37\1\uffff\1\40\5\uffff\1\5\1\6\1\uffff"+
			"\1\14\1\13\1\15\1\uffff\1\36\1\34\11\35\1\11\1\12\1\uffff\1\1\2\uffff"+
			"\1\2\32\33\1\7\1\uffff\1\10\1\uffff\1\33\1\uffff\1\33\1\31\1\33\1\30"+
			"\1\25\1\17\2\33\1\22\3\33\1\24\1\33\1\23\1\20\1\33\1\26\1\21\1\16\1\27"+
			"\1\32\4\33\1\3\1\uffff\1\4",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\42\11\35",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\43\2"+
			"\45\1\44\10\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\50\12\45\1"+
			"\51\16\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\52\31\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\54\16"+
			"\45\1\55\4\45\1\53\1\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\14\45\1\56\1"+
			"\57\14\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\17\45\1\60\12"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\62\3\45\1\61"+
			"\25\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\15\45\1\63\14"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\64\12"+
			"\45\1\65\12\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\10\45\1\66\21"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\70\11"+
			"\45\1\67\13\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\71\11"+
			"\45\1\72\1\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\73\13"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\76\1\uffff\10\100\15\uffff\1\77\22\uffff\1\42\14\uffff\1\75\22\uffff"+
			"\1\42",
			"\1\76\1\uffff\12\101\13\uffff\1\77\37\uffff\1\75",
			"\1\103\4\uffff\1\102",
			"",
			"",
			"",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\24\45\1\105\5"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\13\45\1\106\16"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\107\13"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\2\45\1\110\27"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\15\45\1\111\14"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\21\45\1\112\10"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\21\45\1\113\10"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\17\45\1\114\12"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\23\45\1\115\6"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\23\45\1\116\6"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\22\45\1\117\7"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\27\45\1\120\2"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\24\45\1\121\5"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\17\45\1\123\1"+
			"\122\2\45\1\124\6\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\2\45\1\125\27"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\15\45\1\126\14"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\24\45\1\127\5"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\5\45\1\130\24"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\131\13"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\23\45\1\132\6"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\10\45\1\133\21"+
			"\45",
			"",
			"\1\77\2\uffff\1\134\11\135",
			"\12\136",
			"",
			"",
			"\1\76\1\uffff\12\101\13\uffff\1\77\37\uffff\1\75",
			"\57\103\1\137\uffd0\103",
			"",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\140\25"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\22\45\1\141\7"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\142\31\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\12\45\1\143\17"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\23\45\1\144\6"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\25\45\1\145\4"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\10\45\1\146\21"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\147\13"+
			"\45",
			"\1\47\1\uffff\1\45\1\151\1\45\1\152\2\45\1\153\1\45\1\150\1\45\7\uffff"+
			"\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\10\45\1\154\21"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\22\45\1\155\7"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\14\45\1\157\15"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\24\45\1\160\5"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\161\25"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\24\45\1\162\5"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\23\45\1\164\6"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\45\1\165\30"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\166\31\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\13\45\1\167\16"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\170\25"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\3\45\1\171\26"+
			"\45",
			"\12\172",
			"\12\173",
			"\12\136\53\uffff\1\172\1\174",
			"\12\176\1\u0080\2\176\1\177\ufff2\176",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\u0082"+
			"\25\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\23\45\1\u0083"+
			"\6\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\u0084\31\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\u0085\31\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\10\45\1\u0086"+
			"\21\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\15\45\1\u0087"+
			"\14\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\21\45\1\u0088"+
			"\10\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\6\45\1\u008a\3\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32"+
			"\45",
			"\1\47\1\uffff\2\45\1\u008b\7\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32"+
			"\45",
			"\1\47\1\uffff\4\45\1\u008c\5\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\u008d"+
			"\13\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\u008e\31\45",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\10\45\1\u0090"+
			"\21\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\u0091\31\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\21\45\1\u0092"+
			"\10\45",
			"",
			"\1\47\1\uffff\1\45\1\u0094\1\45\1\u0095\2\45\1\u0096\1\45\1\u0093\1"+
			"\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\13\45\1\u0097"+
			"\16\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\24\45\1\u0098"+
			"\5\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\22\45\1\u009a"+
			"\7\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"\12\173",
			"\1\172",
			"",
			"\12\176\1\u0080\2\176\1\177\ufff2\176",
			"\1\u0080",
			"",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\6\45\1\u009f"+
			"\23\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\27\45\1\u00a0"+
			"\2\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\2\45\1\u00a1"+
			"\27\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\6\45\1\u00a2"+
			"\23\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\23\45\1\u00a3"+
			"\6\45",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\15\45\1\u00a7"+
			"\14\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\6\45\1\u00a8"+
			"\23\45",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\21\45\1\u00a9"+
			"\10\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\23\45\1\u00aa"+
			"\6\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\15\45\1\u00ab"+
			"\14\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\6\45\1\u00ad\3\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32"+
			"\45",
			"\1\47\1\uffff\2\45\1\u00ae\7\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32"+
			"\45",
			"\1\47\1\uffff\4\45\1\u00af\5\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32"+
			"\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\u00b0"+
			"\25\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\13\45\1\u00b1"+
			"\16\45",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\u00b3"+
			"\25\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\u00b5"+
			"\25\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\1\u00b8\31\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\u00ba"+
			"\25\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\u00bb"+
			"\25\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\u00bc"+
			"\25\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\22\45\1\u00bd"+
			"\7\45",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\23\45\1\u00c2"+
			"\6\45",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\13\45\1\u00c5"+
			"\16\45",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\3\45\1\u00c7"+
			"\26\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\3\45\1\u00c8"+
			"\26\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\47\1\uffff\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
	static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
	static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
	static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
	static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
	static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
	static final short[][] DFA22_transition;

	static {
		int numStates = DFA22_transitionS.length;
		DFA22_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
		}
	}

	protected class DFA22 extends DFA {

		public DFA22(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 22;
			this.eot = DFA22_eot;
			this.eof = DFA22_eof;
			this.min = DFA22_min;
			this.max = DFA22_max;
			this.accept = DFA22_accept;
			this.special = DFA22_special;
			this.transition = DFA22_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( ASSIGN | AT | LEFTCURLY | RIGHTCURLY | LEFTPAREN | RIGHTPAREN | LEFTSQUARE | RIGHTSQUARE | COLON | SEMICOLON | COMMA | PLUS | MINUS | TO | TRUE | FALSE | PKG | SYNTAX | IMPORT | OPTION | MESSAGE | SERVICE | ENUM | REQUIRED | OPTIONAL | REPEATED | RPC | RETURNS | INT8 | INT16 | INT32 | INT64 | UINT8 | UINT16 | UINT32 | UINT64 | FLOAT | DOUBLE | BOOL | STRING | BYTES | DEFAULT | MAX | VOID | FULL_ID | ID | EXP | NUMDOUBLE | NUMFLOAT | NUMINT | HEX | OCTAL | DOC_COMMENT | COMMENT | WS | STRING_LITERAL );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA22_66 = input.LA(1);
						s = -1;
						if ( (LA22_66=='/') ) {s = 95;}
						else if ( ((LA22_66 >= '\u0000' && LA22_66 <= '.')||(LA22_66 >= '0' && LA22_66 <= '\uFFFF')) ) {s = 67;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA22_126 = input.LA(1);
						s = -1;
						if ( (LA22_126=='\r') ) {s = 127;}
						else if ( (LA22_126=='\n') ) {s = 128;}
						else if ( ((LA22_126 >= '\u0000' && LA22_126 <= '\t')||(LA22_126 >= '\u000B' && LA22_126 <= '\f')||(LA22_126 >= '\u000E' && LA22_126 <= '\uFFFF')) ) {s = 126;}
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA22_95 = input.LA(1);
						s = -1;
						if ( ((LA22_95 >= '\u0000' && LA22_95 <= '\t')||(LA22_95 >= '\u000B' && LA22_95 <= '\f')||(LA22_95 >= '\u000E' && LA22_95 <= '\uFFFF')) ) {s = 126;}
						else if ( (LA22_95=='\r') ) {s = 127;}
						else if ( (LA22_95=='\n') ) {s = 128;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 22, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
