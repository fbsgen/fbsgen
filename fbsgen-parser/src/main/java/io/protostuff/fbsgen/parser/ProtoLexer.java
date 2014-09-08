// $ANTLR 3.5.2 io/protostuff/fbsgen/parser/ProtoLexer.g 2014-09-08 20:23:14

    package io.protostuff.fbsgen.parser;


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
	public static final int COMMA=8;
	public static final int COMMENT=9;
	public static final int DEFAULT=10;
	public static final int DOC_COMMENT=11;
	public static final int DOUBLE=12;
	public static final int ENUM=13;
	public static final int ESC_SEQ=14;
	public static final int EXP=15;
	public static final int FALSE=16;
	public static final int FLOAT=17;
	public static final int FULL_ID=18;
	public static final int HEX=19;
	public static final int HEX_DIGIT=20;
	public static final int ID=21;
	public static final int IMPORT=22;
	public static final int INT16=23;
	public static final int INT32=24;
	public static final int INT64=25;
	public static final int INT8=26;
	public static final int LEFTCURLY=27;
	public static final int LEFTPAREN=28;
	public static final int LEFTSQUARE=29;
	public static final int MAX=30;
	public static final int MESSAGE=31;
	public static final int MINUS=32;
	public static final int NUMDOUBLE=33;
	public static final int NUMFLOAT=34;
	public static final int NUMINT=35;
	public static final int OCTAL=36;
	public static final int OCTAL_ESC=37;
	public static final int OPTION=38;
	public static final int OPTIONAL=39;
	public static final int PKG=40;
	public static final int PLUS=41;
	public static final int REPEATED=42;
	public static final int REQUIRED=43;
	public static final int RETURNS=44;
	public static final int RIGHTCURLY=45;
	public static final int RIGHTPAREN=46;
	public static final int RIGHTSQUARE=47;
	public static final int RPC=48;
	public static final int SEMICOLON=49;
	public static final int SERVICE=50;
	public static final int STRING=51;
	public static final int STRING_LITERAL=52;
	public static final int SYNTAX=53;
	public static final int TO=54;
	public static final int TRUE=55;
	public static final int UINT16=56;
	public static final int UINT32=57;
	public static final int UINT64=58;
	public static final int UINT8=59;
	public static final int UNICODE_ESC=60;
	public static final int VOID=61;
	public static final int WS=62;

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
	@Override public String getGrammarFileName() { return "io/protostuff/fbsgen/parser/ProtoLexer.g"; }

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// io/protostuff/fbsgen/parser/ProtoLexer.g:35:5: ( '=' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:35:9: '='
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:39:5: ( '@' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:39:9: '@'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:43:5: ( '{' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:43:9: '{'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:47:5: ( '}' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:47:9: '}'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:51:5: ( '(' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:51:9: '('
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:55:5: ( ')' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:55:9: ')'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:59:5: ( '[' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:59:9: '['
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:63:5: ( ']' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:63:9: ']'
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

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// io/protostuff/fbsgen/parser/ProtoLexer.g:67:5: ( ';' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:67:9: ';'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:71:5: ( ',' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:71:9: ','
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:75:5: ( '+' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:75:9: '+'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:79:5: ( '-' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:79:9: '-'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:83:5: ( 'to' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:83:9: 'to'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:87:5: ( 'true' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:87:9: 'true'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:91:5: ( 'false' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:91:9: 'false'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:95:5: ( 'package' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:95:9: 'package'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:99:5: ( 'syntax' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:99:9: 'syntax'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:103:5: ( 'import' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:103:9: 'import'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:107:5: ( 'option' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:107:9: 'option'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:111:5: ( 'message' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:111:9: 'message'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:115:5: ( 'service' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:115:9: 'service'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:119:5: ( 'enum' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:119:9: 'enum'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:123:5: ( 'required' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:123:9: 'required'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:127:5: ( 'optional' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:127:9: 'optional'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:131:5: ( 'repeated' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:131:9: 'repeated'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:147:5: ( 'rpc' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:147:9: 'rpc'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:151:5: ( 'returns' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:151:9: 'returns'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:155:5: ( 'int8' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:155:9: 'int8'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:159:5: ( 'int16' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:159:9: 'int16'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:163:5: ( 'int32' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:163:9: 'int32'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:167:5: ( 'int64' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:167:9: 'int64'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:171:5: ( 'uint8' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:171:9: 'uint8'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:175:5: ( 'uint16' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:175:9: 'uint16'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:179:5: ( 'uint32' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:179:9: 'uint32'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:183:5: ( 'uint64' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:183:9: 'uint64'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:187:5: ( 'float' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:187:9: 'float'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:191:5: ( 'double' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:191:9: 'double'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:195:5: ( 'bool' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:195:9: 'bool'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:199:5: ( 'string' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:199:9: 'string'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:203:5: ( 'bytes' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:203:9: 'bytes'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:207:5: ( 'default' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:207:9: 'default'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:211:5: ( 'max' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:211:9: 'max'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:215:5: ( 'void' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:215:9: 'void'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:219:5: ( ID ( '.' ID )+ )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:219:7: ID ( '.' ID )+
			{
			mID(); 

			// io/protostuff/fbsgen/parser/ProtoLexer.g:219:10: ( '.' ID )+
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:219:11: '.' ID
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:223:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:223:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// io/protostuff/fbsgen/parser/ProtoLexer.g:223:33: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:227:5: ( NUMINT ( 'e' | 'E' ) NUMINT )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:227:9: NUMINT ( 'e' | 'E' ) NUMINT
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:231:5: ( ( NUMFLOAT | NUMINT ) 'e' ( '0' .. '9' )+ )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:231:9: ( NUMFLOAT | NUMINT ) 'e' ( '0' .. '9' )+
			{
			// io/protostuff/fbsgen/parser/ProtoLexer.g:231:9: ( NUMFLOAT | NUMINT )
			int alt3=2;
			alt3 = dfa3.predict(input);
			switch (alt3) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:231:10: NUMFLOAT
					{
					mNUMFLOAT(); 

					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:231:19: NUMINT
					{
					mNUMINT(); 

					}
					break;

			}

			match('e'); 
			// io/protostuff/fbsgen/parser/ProtoLexer.g:232:13: ( '0' .. '9' )+
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:236:5: ( NUMINT '.' ( '0' .. '9' )+ ( 'f' )? )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:236:9: NUMINT '.' ( '0' .. '9' )+ ( 'f' )?
			{
			mNUMINT(); 

			match('.'); 
			// io/protostuff/fbsgen/parser/ProtoLexer.g:236:20: ( '0' .. '9' )+
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:
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

			// io/protostuff/fbsgen/parser/ProtoLexer.g:236:30: ( 'f' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='f') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:236:30: 'f'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:240:5: ( '0' | ( MINUS )? '1' .. '9' ( '0' .. '9' )* )
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:240:9: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:240:15: ( MINUS )? '1' .. '9' ( '0' .. '9' )*
					{
					// io/protostuff/fbsgen/parser/ProtoLexer.g:240:15: ( MINUS )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0=='-') ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// io/protostuff/fbsgen/parser/ProtoLexer.g:
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:240:31: ( '0' .. '9' )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// io/protostuff/fbsgen/parser/ProtoLexer.g:
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:244:5: ( ( MINUS )? '0' ( 'x' | 'X' ) ( HEX_DIGIT )+ )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:244:9: ( MINUS )? '0' ( 'x' | 'X' ) ( HEX_DIGIT )+
			{
			// io/protostuff/fbsgen/parser/ProtoLexer.g:244:9: ( MINUS )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='-') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:244:30: ( HEX_DIGIT )+
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:248:5: ( '0' ( '0' .. '7' )+ )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:248:9: '0' ( '0' .. '7' )+
			{
			match('0'); 
			// io/protostuff/fbsgen/parser/ProtoLexer.g:248:13: ( '0' .. '7' )+
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:252:5: ( '///' ( (~ ( '\\n' | '\\r' ) )* ) ( '\\r' )? '\\n' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:252:9: '///' ( (~ ( '\\n' | '\\r' ) )* ) ( '\\r' )? '\\n'
			{
			match("///"); 

			// io/protostuff/fbsgen/parser/ProtoLexer.g:252:15: ( (~ ( '\\n' | '\\r' ) )* )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:252:16: (~ ( '\\n' | '\\r' ) )*
			{
			// io/protostuff/fbsgen/parser/ProtoLexer.g:252:16: (~ ( '\\n' | '\\r' ) )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '\u0000' && LA13_0 <= '\t')||(LA13_0 >= '\u000B' && LA13_0 <= '\f')||(LA13_0 >= '\u000E' && LA13_0 <= '\uFFFF')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:
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

			// io/protostuff/fbsgen/parser/ProtoLexer.g:252:31: ( '\\r' )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0=='\r') ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:252:31: '\\r'
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:256:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:256:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// io/protostuff/fbsgen/parser/ProtoLexer.g:256:14: (~ ( '\\n' | '\\r' ) )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( ((LA15_0 >= '\u0000' && LA15_0 <= '\t')||(LA15_0 >= '\u000B' && LA15_0 <= '\f')||(LA15_0 >= '\u000E' && LA15_0 <= '\uFFFF')) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// io/protostuff/fbsgen/parser/ProtoLexer.g:
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

					// io/protostuff/fbsgen/parser/ProtoLexer.g:256:28: ( '\\r' )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0=='\r') ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// io/protostuff/fbsgen/parser/ProtoLexer.g:256:28: '\\r'
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:257:9: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// io/protostuff/fbsgen/parser/ProtoLexer.g:257:14: ( options {greedy=false; } : . )*
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
							// io/protostuff/fbsgen/parser/ProtoLexer.g:257:42: .
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:260:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:260:9: ( ' ' | '\\t' | '\\r' | '\\n' )
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:268:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:268:9: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// io/protostuff/fbsgen/parser/ProtoLexer.g:268:13: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:268:15: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:268:25: ~ ( '\\\\' | '\"' )
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:272:5: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:276:5: ( '\\\\' ( 'a' | 'v' | 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | '\\\\' ( 'x' | 'X' ) HEX_DIGIT HEX_DIGIT | UNICODE_ESC | OCTAL_ESC )
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:276:9: '\\\\' ( 'a' | 'v' | 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:277:9: '\\\\' ( 'x' | 'X' ) HEX_DIGIT HEX_DIGIT
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:278:9: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 4 :
					// io/protostuff/fbsgen/parser/ProtoLexer.g:279:9: OCTAL_ESC
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:283:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:283:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:284:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
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
					// io/protostuff/fbsgen/parser/ProtoLexer.g:285:9: '\\\\' ( '0' .. '7' )
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
			// io/protostuff/fbsgen/parser/ProtoLexer.g:289:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// io/protostuff/fbsgen/parser/ProtoLexer.g:289:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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
		// io/protostuff/fbsgen/parser/ProtoLexer.g:1:8: ( ASSIGN | AT | LEFTCURLY | RIGHTCURLY | LEFTPAREN | RIGHTPAREN | LEFTSQUARE | RIGHTSQUARE | SEMICOLON | COMMA | PLUS | MINUS | TO | TRUE | FALSE | PKG | SYNTAX | IMPORT | OPTION | MESSAGE | SERVICE | ENUM | REQUIRED | OPTIONAL | REPEATED | RPC | RETURNS | INT8 | INT16 | INT32 | INT64 | UINT8 | UINT16 | UINT32 | UINT64 | FLOAT | DOUBLE | BOOL | STRING | BYTES | DEFAULT | MAX | VOID | FULL_ID | ID | EXP | NUMDOUBLE | NUMFLOAT | NUMINT | HEX | OCTAL | DOC_COMMENT | COMMENT | WS | STRING_LITERAL )
		int alt22=55;
		alt22 = dfa22.predict(input);
		switch (alt22) {
			case 1 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:10: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 2 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:17: AT
				{
				mAT(); 

				}
				break;
			case 3 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:20: LEFTCURLY
				{
				mLEFTCURLY(); 

				}
				break;
			case 4 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:30: RIGHTCURLY
				{
				mRIGHTCURLY(); 

				}
				break;
			case 5 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:41: LEFTPAREN
				{
				mLEFTPAREN(); 

				}
				break;
			case 6 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:51: RIGHTPAREN
				{
				mRIGHTPAREN(); 

				}
				break;
			case 7 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:62: LEFTSQUARE
				{
				mLEFTSQUARE(); 

				}
				break;
			case 8 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:73: RIGHTSQUARE
				{
				mRIGHTSQUARE(); 

				}
				break;
			case 9 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:85: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 10 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:95: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 11 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:101: PLUS
				{
				mPLUS(); 

				}
				break;
			case 12 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:106: MINUS
				{
				mMINUS(); 

				}
				break;
			case 13 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:112: TO
				{
				mTO(); 

				}
				break;
			case 14 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:115: TRUE
				{
				mTRUE(); 

				}
				break;
			case 15 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:120: FALSE
				{
				mFALSE(); 

				}
				break;
			case 16 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:126: PKG
				{
				mPKG(); 

				}
				break;
			case 17 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:130: SYNTAX
				{
				mSYNTAX(); 

				}
				break;
			case 18 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:137: IMPORT
				{
				mIMPORT(); 

				}
				break;
			case 19 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:144: OPTION
				{
				mOPTION(); 

				}
				break;
			case 20 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:151: MESSAGE
				{
				mMESSAGE(); 

				}
				break;
			case 21 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:159: SERVICE
				{
				mSERVICE(); 

				}
				break;
			case 22 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:167: ENUM
				{
				mENUM(); 

				}
				break;
			case 23 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:172: REQUIRED
				{
				mREQUIRED(); 

				}
				break;
			case 24 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:181: OPTIONAL
				{
				mOPTIONAL(); 

				}
				break;
			case 25 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:190: REPEATED
				{
				mREPEATED(); 

				}
				break;
			case 26 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:199: RPC
				{
				mRPC(); 

				}
				break;
			case 27 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:203: RETURNS
				{
				mRETURNS(); 

				}
				break;
			case 28 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:211: INT8
				{
				mINT8(); 

				}
				break;
			case 29 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:216: INT16
				{
				mINT16(); 

				}
				break;
			case 30 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:222: INT32
				{
				mINT32(); 

				}
				break;
			case 31 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:228: INT64
				{
				mINT64(); 

				}
				break;
			case 32 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:234: UINT8
				{
				mUINT8(); 

				}
				break;
			case 33 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:240: UINT16
				{
				mUINT16(); 

				}
				break;
			case 34 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:247: UINT32
				{
				mUINT32(); 

				}
				break;
			case 35 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:254: UINT64
				{
				mUINT64(); 

				}
				break;
			case 36 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:261: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 37 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:267: DOUBLE
				{
				mDOUBLE(); 

				}
				break;
			case 38 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:274: BOOL
				{
				mBOOL(); 

				}
				break;
			case 39 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:279: STRING
				{
				mSTRING(); 

				}
				break;
			case 40 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:286: BYTES
				{
				mBYTES(); 

				}
				break;
			case 41 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:292: DEFAULT
				{
				mDEFAULT(); 

				}
				break;
			case 42 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:300: MAX
				{
				mMAX(); 

				}
				break;
			case 43 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:304: VOID
				{
				mVOID(); 

				}
				break;
			case 44 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:309: FULL_ID
				{
				mFULL_ID(); 

				}
				break;
			case 45 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:317: ID
				{
				mID(); 

				}
				break;
			case 46 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:320: EXP
				{
				mEXP(); 

				}
				break;
			case 47 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:324: NUMDOUBLE
				{
				mNUMDOUBLE(); 

				}
				break;
			case 48 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:334: NUMFLOAT
				{
				mNUMFLOAT(); 

				}
				break;
			case 49 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:343: NUMINT
				{
				mNUMINT(); 

				}
				break;
			case 50 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:350: HEX
				{
				mHEX(); 

				}
				break;
			case 51 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:354: OCTAL
				{
				mOCTAL(); 

				}
				break;
			case 52 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:360: DOC_COMMENT
				{
				mDOC_COMMENT(); 

				}
				break;
			case 53 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:372: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 54 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:380: WS
				{
				mWS(); 

				}
				break;
			case 55 :
				// io/protostuff/fbsgen/parser/ProtoLexer.g:1:383: STRING_LITERAL
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
			return "231:9: ( NUMFLOAT | NUMINT )";
		}
	}

	static final String DFA22_eotS =
		"\14\uffff\1\40\16\45\2\73\5\uffff\1\103\2\45\2\uffff\24\45\5\uffff\1\73"+
		"\3\uffff\13\45\1\155\4\45\1\162\6\45\2\76\1\174\1\uffff\1\u0080\7\45\1"+
		"\u0088\5\45\1\uffff\1\u008e\3\45\1\uffff\3\45\1\u0098\1\45\1\u009a\1\uffff"+
		"\1\76\1\174\5\uffff\1\u009c\1\u009d\5\45\1\uffff\1\u00a3\1\u00a4\1\u00a5"+
		"\2\45\1\uffff\3\45\1\u00ab\5\45\1\uffff\1\u00b1\4\uffff\1\45\1\u00b3\1"+
		"\45\1\u00b5\1\u00b6\3\uffff\1\u00b8\4\45\1\uffff\1\u00bd\1\u00be\1\u00bf"+
		"\1\u00c0\1\45\1\uffff\1\u00c2\1\uffff\1\u00c3\2\uffff\1\45\1\uffff\1\u00c5"+
		"\2\45\1\u00c8\4\uffff\1\u00c9\2\uffff\1\u00ca\1\uffff\1\u00cb\1\u00cc"+
		"\5\uffff";
	static final String DFA22_eofS =
		"\u00cd\uffff";
	static final String DFA22_minS =
		"\1\11\13\uffff\1\60\20\56\1\52\4\uffff\3\56\2\uffff\24\56\1\uffff\1\55"+
		"\1\60\2\uffff\1\56\1\0\2\uffff\27\56\3\60\1\0\16\56\1\uffff\4\56\1\uffff"+
		"\6\56\1\uffff\1\60\1\145\1\uffff\1\0\1\12\2\uffff\7\56\1\uffff\5\56\1"+
		"\uffff\11\56\1\uffff\1\56\4\uffff\5\56\3\uffff\5\56\1\uffff\5\56\1\uffff"+
		"\1\56\1\uffff\1\56\2\uffff\1\56\1\uffff\4\56\4\uffff\1\56\2\uffff\1\56"+
		"\1\uffff\2\56\5\uffff";
	static final String DFA22_maxS =
		"\1\175\13\uffff\1\71\16\172\1\170\1\145\1\57\4\uffff\3\172\2\uffff\24"+
		"\172\1\uffff\2\71\2\uffff\1\145\1\uffff\2\uffff\27\172\2\71\1\146\1\uffff"+
		"\16\172\1\uffff\4\172\1\uffff\6\172\1\uffff\1\71\1\145\1\uffff\1\uffff"+
		"\1\12\2\uffff\7\172\1\uffff\5\172\1\uffff\11\172\1\uffff\1\172\4\uffff"+
		"\5\172\3\uffff\5\172\1\uffff\5\172\1\uffff\1\172\1\uffff\1\172\2\uffff"+
		"\1\172\1\uffff\4\172\4\uffff\1\172\2\uffff\1\172\1\uffff\2\172\5\uffff";
	static final String DFA22_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\22\uffff\1\66"+
		"\1\67\1\14\1\62\3\uffff\1\55\1\54\24\uffff\1\61\2\uffff\1\56\1\63\2\uffff"+
		"\1\65\1\15\51\uffff\1\52\4\uffff\1\32\6\uffff\1\57\2\uffff\1\60\2\uffff"+
		"\1\64\1\16\7\uffff\1\34\5\uffff\1\26\11\uffff\1\46\1\uffff\1\53\1\64\1"+
		"\17\1\44\5\uffff\1\35\1\36\1\37\5\uffff\1\40\5\uffff\1\50\1\uffff\1\21"+
		"\1\uffff\1\47\1\22\1\uffff\1\23\4\uffff\1\41\1\42\1\43\1\45\1\uffff\1"+
		"\20\1\25\1\uffff\1\24\2\uffff\1\33\1\51\1\30\1\27\1\31";
	static final String DFA22_specialS =
		"\101\uffff\1\2\34\uffff\1\0\36\uffff\1\1\117\uffff}>";
	static final String[] DFA22_transitionS = {
			"\2\36\2\uffff\1\36\22\uffff\1\36\1\uffff\1\37\5\uffff\1\5\1\6\1\uffff"+
			"\1\13\1\12\1\14\1\uffff\1\35\1\33\11\34\1\uffff\1\11\1\uffff\1\1\2\uffff"+
			"\1\2\32\32\1\7\1\uffff\1\10\1\uffff\1\32\1\uffff\1\32\1\30\1\32\1\27"+
			"\1\24\1\16\2\32\1\21\3\32\1\23\1\32\1\22\1\17\1\32\1\25\1\20\1\15\1\26"+
			"\1\31\4\32\1\3\1\uffff\1\4",
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
			"\1\41\11\34",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\42\2"+
			"\44\1\43\10\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\47\12\44\1"+
			"\50\16\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\51\31\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\53\16"+
			"\44\1\54\4\44\1\52\1\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\14\44\1\55\1"+
			"\56\14\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\17\44\1\57\12"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\61\3\44\1\60"+
			"\25\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\62\14"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\63\12"+
			"\44\1\64\12\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\10\44\1\65\21"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\67\11"+
			"\44\1\66\13\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\70\11"+
			"\44\1\71\1\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\72\13"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\75\1\uffff\10\77\15\uffff\1\76\22\uffff\1\41\14\uffff\1\74\22\uffff"+
			"\1\41",
			"\1\75\1\uffff\12\100\13\uffff\1\76\37\uffff\1\74",
			"\1\102\4\uffff\1\101",
			"",
			"",
			"",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\24\44\1\104\5"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\105\16"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\106\13"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\2\44\1\107\27"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\110\14"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\111\10"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\112\10"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\17\44\1\113\12"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\114\6"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\115\6"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\22\44\1\116\7"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\27\44\1\117\2"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\24\44\1\120\5"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\17\44\1\122\1"+
			"\121\2\44\1\123\6\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\2\44\1\124\27"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\125\14"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\24\44\1\126\5"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\5\44\1\127\24"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\130\13"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\131\6"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\10\44\1\132\21"+
			"\44",
			"",
			"\1\76\2\uffff\1\133\11\134",
			"\12\135",
			"",
			"",
			"\1\75\1\uffff\12\100\13\uffff\1\76\37\uffff\1\74",
			"\57\102\1\136\uffd0\102",
			"",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\137\25"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\22\44\1\140\7"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\141\31\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\12\44\1\142\17"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\143\6"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\25\44\1\144\4"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\10\44\1\145\21"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\146\13"+
			"\44",
			"\1\46\1\uffff\1\44\1\150\1\44\1\151\2\44\1\152\1\44\1\147\1\44\7\uffff"+
			"\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\10\44\1\153\21"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\22\44\1\154\7"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\14\44\1\156\15"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\24\44\1\157\5"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\160\25"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\24\44\1\161\5"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\163\6"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\44\1\164\30"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\165\31\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\166\16"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\167\25"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\170\26"+
			"\44",
			"\12\171",
			"\12\172",
			"\12\135\53\uffff\1\171\1\173",
			"\12\175\1\177\2\175\1\176\ufff2\175",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\u0081"+
			"\25\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\u0082"+
			"\6\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\u0083\31\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\u0084\31\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\10\44\1\u0085"+
			"\21\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\u0086"+
			"\14\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\u0087"+
			"\10\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\6\44\1\u0089\3\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
			"\44",
			"\1\46\1\uffff\2\44\1\u008a\7\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
			"\44",
			"\1\46\1\uffff\4\44\1\u008b\5\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\u008c"+
			"\13\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\u008d\31\44",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\10\44\1\u008f"+
			"\21\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\u0090\31\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\u0091"+
			"\10\44",
			"",
			"\1\46\1\uffff\1\44\1\u0093\1\44\1\u0094\2\44\1\u0095\1\44\1\u0092\1"+
			"\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\u0096"+
			"\16\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\24\44\1\u0097"+
			"\5\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\22\44\1\u0099"+
			"\7\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\12\172",
			"\1\171",
			"",
			"\12\175\1\177\2\175\1\176\ufff2\175",
			"\1\177",
			"",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\6\44\1\u009e"+
			"\23\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\27\44\1\u009f"+
			"\2\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\2\44\1\u00a0"+
			"\27\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\6\44\1\u00a1"+
			"\23\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\u00a2"+
			"\6\44",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\u00a6"+
			"\14\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\6\44\1\u00a7"+
			"\23\44",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\u00a8"+
			"\10\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\u00a9"+
			"\6\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\u00aa"+
			"\14\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\6\44\1\u00ac\3\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
			"\44",
			"\1\46\1\uffff\2\44\1\u00ad\7\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
			"\44",
			"\1\46\1\uffff\4\44\1\u00ae\5\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
			"\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\u00af"+
			"\25\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\u00b0"+
			"\16\44",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\u00b2"+
			"\25\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\u00b4"+
			"\25\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\u00b7\31\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\u00b9"+
			"\25\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\u00ba"+
			"\25\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\u00bb"+
			"\25\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\22\44\1\u00bc"+
			"\7\44",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\u00c1"+
			"\6\44",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\u00c4"+
			"\16\44",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\u00c6"+
			"\26\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\u00c7"+
			"\26\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\46\1\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
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
			return "1:1: Tokens : ( ASSIGN | AT | LEFTCURLY | RIGHTCURLY | LEFTPAREN | RIGHTPAREN | LEFTSQUARE | RIGHTSQUARE | SEMICOLON | COMMA | PLUS | MINUS | TO | TRUE | FALSE | PKG | SYNTAX | IMPORT | OPTION | MESSAGE | SERVICE | ENUM | REQUIRED | OPTIONAL | REPEATED | RPC | RETURNS | INT8 | INT16 | INT32 | INT64 | UINT8 | UINT16 | UINT32 | UINT64 | FLOAT | DOUBLE | BOOL | STRING | BYTES | DEFAULT | MAX | VOID | FULL_ID | ID | EXP | NUMDOUBLE | NUMFLOAT | NUMINT | HEX | OCTAL | DOC_COMMENT | COMMENT | WS | STRING_LITERAL );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA22_94 = input.LA(1);
						s = -1;
						if ( ((LA22_94 >= '\u0000' && LA22_94 <= '\t')||(LA22_94 >= '\u000B' && LA22_94 <= '\f')||(LA22_94 >= '\u000E' && LA22_94 <= '\uFFFF')) ) {s = 125;}
						else if ( (LA22_94=='\r') ) {s = 126;}
						else if ( (LA22_94=='\n') ) {s = 127;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA22_125 = input.LA(1);
						s = -1;
						if ( (LA22_125=='\r') ) {s = 126;}
						else if ( (LA22_125=='\n') ) {s = 127;}
						else if ( ((LA22_125 >= '\u0000' && LA22_125 <= '\t')||(LA22_125 >= '\u000B' && LA22_125 <= '\f')||(LA22_125 >= '\u000E' && LA22_125 <= '\uFFFF')) ) {s = 125;}
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA22_65 = input.LA(1);
						s = -1;
						if ( (LA22_65=='/') ) {s = 94;}
						else if ( ((LA22_65 >= '\u0000' && LA22_65 <= '.')||(LA22_65 >= '0' && LA22_65 <= '\uFFFF')) ) {s = 66;}
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
