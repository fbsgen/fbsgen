// $ANTLR 3.5.2 io/protostuff/fbsgen/parser/ProtoParser.g 2014-09-08 21:38:56

    package io.protostuff.fbsgen.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ProtoParser extends AbstractParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "AT", "BOOL", "BYTES", 
		"COMMA", "COMMENT", "DEFAULT", "DOC_COMMENT", "DOUBLE", "ENUM", "ESC_SEQ", 
		"EXP", "FALSE", "FLOAT", "FULL_ID", "HEX", "HEX_DIGIT", "ID", "IMPORT", 
		"INT16", "INT32", "INT64", "INT8", "LEFTCURLY", "LEFTPAREN", "LEFTSQUARE", 
		"MAX", "MESSAGE", "MINUS", "NUMDOUBLE", "NUMFLOAT", "NUMINT", "OCTAL", 
		"OCTAL_ESC", "OPTION", "OPTIONAL", "PKG", "PLUS", "REPEATED", "REQUIRED", 
		"RETURNS", "RIGHTCURLY", "RIGHTPAREN", "RIGHTSQUARE", "RPC", "SEMICOLON", 
		"SERVICE", "STRING", "STRING_LITERAL", "SYNTAX", "TO", "TRUE", "UINT16", 
		"UINT32", "UINT64", "UINT8", "UNICODE_ESC", "VOID", "WS"
	};
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
	public AbstractParser[] getDelegates() {
		return new AbstractParser[] {};
	}

	// delegators


	public ProtoParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ProtoParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ProtoParser.tokenNames; }
	@Override public String getGrammarFileName() { return "io/protostuff/fbsgen/parser/ProtoParser.g"; }


	public static class parse_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// io/protostuff/fbsgen/parser/ProtoParser.g:52:1: parse[Proto proto] : ( statement[proto] )+ EOF !;
	public final ProtoParser.parse_return parse(Proto proto) throws RecognitionException {
		ProtoParser.parse_return retval = new ProtoParser.parse_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope statement1 =null;

		Object EOF2_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:53:5: ( ( statement[proto] )+ EOF !)
			// io/protostuff/fbsgen/parser/ProtoParser.g:53:9: ( statement[proto] )+ EOF !
			{
			root_0 = (Object)adaptor.nil();


			// io/protostuff/fbsgen/parser/ProtoParser.g:53:9: ( statement[proto] )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==AT||LA1_0==DOC_COMMENT||LA1_0==ENUM||LA1_0==IMPORT||LA1_0==MESSAGE||LA1_0==OPTION||LA1_0==PKG||LA1_0==SERVICE||LA1_0==SYNTAX) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:53:10: statement[proto]
					{
					pushFollow(FOLLOW_statement_in_parse178);
					statement1=statement(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement1.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse183); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			            proto.checkAnnotations();
			            proto.postParse();
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parse"


	public static class statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// io/protostuff/fbsgen/parser/ProtoParser.g:59:1: statement[Proto proto] : ( header_syntax[proto] | header_package[proto] | header_import[proto] | message_block[proto, null] | enum_block[proto, null] | service_block[proto, null] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, proto] );
	public final ProtoParser.statement_return statement(Proto proto) throws RecognitionException {
		ProtoParser.statement_return retval = new ProtoParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope header_syntax3 =null;
		ParserRuleReturnScope header_package4 =null;
		ParserRuleReturnScope header_import5 =null;
		ParserRuleReturnScope message_block6 =null;
		ParserRuleReturnScope enum_block7 =null;
		ParserRuleReturnScope service_block8 =null;
		ParserRuleReturnScope annotation_entry9 =null;
		ParserRuleReturnScope comment_entry10 =null;
		ParserRuleReturnScope option_entry11 =null;


		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:60:5: ( header_syntax[proto] | header_package[proto] | header_import[proto] | message_block[proto, null] | enum_block[proto, null] | service_block[proto, null] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, proto] )
			int alt2=9;
			switch ( input.LA(1) ) {
			case SYNTAX:
				{
				alt2=1;
				}
				break;
			case PKG:
				{
				alt2=2;
				}
				break;
			case IMPORT:
				{
				alt2=3;
				}
				break;
			case MESSAGE:
				{
				alt2=4;
				}
				break;
			case ENUM:
				{
				alt2=5;
				}
				break;
			case SERVICE:
				{
				alt2=6;
				}
				break;
			case AT:
				{
				alt2=7;
				}
				break;
			case DOC_COMMENT:
				{
				alt2=8;
				}
				break;
			case OPTION:
				{
				alt2=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:60:9: header_syntax[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_header_syntax_in_statement211);
					header_syntax3=header_syntax(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, header_syntax3.getTree());

					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:61:9: header_package[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_header_package_in_statement222);
					header_package4=header_package(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, header_package4.getTree());

					}
					break;
				case 3 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:62:9: header_import[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_header_import_in_statement233);
					header_import5=header_import(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, header_import5.getTree());

					}
					break;
				case 4 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:63:9: message_block[proto, null]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_message_block_in_statement244);
					message_block6=message_block(proto, null);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_block6.getTree());

					}
					break;
				case 5 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:64:9: enum_block[proto, null]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_enum_block_in_statement255);
					enum_block7=enum_block(proto, null);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_block7.getTree());

					}
					break;
				case 6 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:66:9: service_block[proto, null]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_service_block_in_statement271);
					service_block8=service_block(proto, null);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, service_block8.getTree());

					}
					break;
				case 7 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:67:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_statement282);
					annotation_entry9=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry9.getTree());

					}
					break;
				case 8 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:68:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_statement293);
					comment_entry10=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry10.getTree());

					}
					break;
				case 9 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:69:9: option_entry[proto, proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_statement304);
					option_entry11=option_entry(proto, proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry11.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class var_reserved_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_reserved"
	// io/protostuff/fbsgen/parser/ProtoParser.g:73:1: var_reserved : ( TO | PKG | SYNTAX | IMPORT | OPTION | MESSAGE | SERVICE | ENUM | REQUIRED | OPTIONAL | REPEATED | RPC | RETURNS | INT8 | INT16 | INT32 | INT64 | UINT8 | UINT16 | UINT32 | UINT64 | FLOAT | DOUBLE | BOOL | STRING | BYTES | DEFAULT | MAX | VOID );
	public final ProtoParser.var_reserved_return var_reserved() throws RecognitionException {
		ProtoParser.var_reserved_return retval = new ProtoParser.var_reserved_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set12=null;

		Object set12_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:74:5: ( TO | PKG | SYNTAX | IMPORT | OPTION | MESSAGE | SERVICE | ENUM | REQUIRED | OPTIONAL | REPEATED | RPC | RETURNS | INT8 | INT16 | INT32 | INT64 | UINT8 | UINT16 | UINT32 | UINT64 | FLOAT | DOUBLE | BOOL | STRING | BYTES | DEFAULT | MAX | VOID )
			// io/protostuff/fbsgen/parser/ProtoParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set12=input.LT(1);
			if ( (input.LA(1) >= BOOL && input.LA(1) <= BYTES)||input.LA(1)==DEFAULT||(input.LA(1) >= DOUBLE && input.LA(1) <= ENUM)||input.LA(1)==FLOAT||(input.LA(1) >= IMPORT && input.LA(1) <= INT8)||(input.LA(1) >= MAX && input.LA(1) <= MESSAGE)||(input.LA(1) >= OPTION && input.LA(1) <= PKG)||(input.LA(1) >= REPEATED && input.LA(1) <= RETURNS)||input.LA(1)==RPC||(input.LA(1) >= SERVICE && input.LA(1) <= STRING)||(input.LA(1) >= SYNTAX && input.LA(1) <= TO)||(input.LA(1) >= UINT16 && input.LA(1) <= UINT8)||input.LA(1)==VOID ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set12));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var_reserved"


	public static class var_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var"
	// io/protostuff/fbsgen/parser/ProtoParser.g:84:1: var : ( ID | var_reserved );
	public final ProtoParser.var_return var() throws RecognitionException {
		ProtoParser.var_return retval = new ProtoParser.var_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID13=null;
		ParserRuleReturnScope var_reserved14 =null;

		Object ID13_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:85:5: ( ID | var_reserved )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ID) ) {
				alt3=1;
			}
			else if ( ((LA3_0 >= BOOL && LA3_0 <= BYTES)||LA3_0==DEFAULT||(LA3_0 >= DOUBLE && LA3_0 <= ENUM)||LA3_0==FLOAT||(LA3_0 >= IMPORT && LA3_0 <= INT8)||(LA3_0 >= MAX && LA3_0 <= MESSAGE)||(LA3_0 >= OPTION && LA3_0 <= PKG)||(LA3_0 >= REPEATED && LA3_0 <= RETURNS)||LA3_0==RPC||(LA3_0 >= SERVICE && LA3_0 <= STRING)||(LA3_0 >= SYNTAX && LA3_0 <= TO)||(LA3_0 >= UINT16 && LA3_0 <= UINT8)||LA3_0==VOID) ) {
				alt3=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:85:9: ID
					{
					root_0 = (Object)adaptor.nil();


					ID13=(Token)match(input,ID,FOLLOW_ID_in_var520); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID13_tree = (Object)adaptor.create(ID13);
					adaptor.addChild(root_0, ID13_tree);
					}

					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:85:14: var_reserved
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_var_reserved_in_var524);
					var_reserved14=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_reserved14.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var"


	public static class var_full_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_full"
	// io/protostuff/fbsgen/parser/ProtoParser.g:88:1: var_full : ( FULL_ID | var );
	public final ProtoParser.var_full_return var_full() throws RecognitionException {
		ProtoParser.var_full_return retval = new ProtoParser.var_full_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FULL_ID15=null;
		ParserRuleReturnScope var16 =null;

		Object FULL_ID15_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:89:5: ( FULL_ID | var )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==FULL_ID) ) {
				alt4=1;
			}
			else if ( ((LA4_0 >= BOOL && LA4_0 <= BYTES)||LA4_0==DEFAULT||(LA4_0 >= DOUBLE && LA4_0 <= ENUM)||LA4_0==FLOAT||(LA4_0 >= ID && LA4_0 <= INT8)||(LA4_0 >= MAX && LA4_0 <= MESSAGE)||(LA4_0 >= OPTION && LA4_0 <= PKG)||(LA4_0 >= REPEATED && LA4_0 <= RETURNS)||LA4_0==RPC||(LA4_0 >= SERVICE && LA4_0 <= STRING)||(LA4_0 >= SYNTAX && LA4_0 <= TO)||(LA4_0 >= UINT16 && LA4_0 <= UINT8)||LA4_0==VOID) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:89:9: FULL_ID
					{
					root_0 = (Object)adaptor.nil();


					FULL_ID15=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_var_full543); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID15_tree = (Object)adaptor.create(FULL_ID15);
					adaptor.addChild(root_0, FULL_ID15_tree);
					}

					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:89:19: var
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_var_in_var_full547);
					var16=var();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var16.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var_full"


	public static class comment_entry_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "comment_entry"
	// io/protostuff/fbsgen/parser/ProtoParser.g:92:1: comment_entry[Proto proto] : DOC_COMMENT ;
	public final ProtoParser.comment_entry_return comment_entry(Proto proto) throws RecognitionException {
		ProtoParser.comment_entry_return retval = new ProtoParser.comment_entry_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DOC_COMMENT17=null;

		Object DOC_COMMENT17_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:93:5: ( DOC_COMMENT )
			// io/protostuff/fbsgen/parser/ProtoParser.g:93:9: DOC_COMMENT
			{
			root_0 = (Object)adaptor.nil();


			DOC_COMMENT17=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_comment_entry568); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DOC_COMMENT17_tree = (Object)adaptor.create(DOC_COMMENT17);
			adaptor.addChild(root_0, DOC_COMMENT17_tree);
			}

			if ( state.backtracking==0 ) { proto.addComment((DOC_COMMENT17!=null?DOC_COMMENT17.getText():null)); }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comment_entry"


	public static class annotation_entry_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "annotation_entry"
	// io/protostuff/fbsgen/parser/ProtoParser.g:96:1: annotation_entry[Proto proto] : AT var ( LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN )? ;
	public final ProtoParser.annotation_entry_return annotation_entry(Proto proto) throws RecognitionException {
		ProtoParser.annotation_entry_return retval = new ProtoParser.annotation_entry_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AT18=null;
		Token LEFTPAREN20=null;
		Token COMMA22=null;
		Token RIGHTPAREN24=null;
		ParserRuleReturnScope var19 =null;
		ParserRuleReturnScope annotation_keyval21 =null;
		ParserRuleReturnScope annotation_keyval23 =null;

		Object AT18_tree=null;
		Object LEFTPAREN20_tree=null;
		Object COMMA22_tree=null;
		Object RIGHTPAREN24_tree=null;


		    Annotation annotation = null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:100:5: ( AT var ( LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN )? )
			// io/protostuff/fbsgen/parser/ProtoParser.g:100:9: AT var ( LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN )?
			{
			root_0 = (Object)adaptor.nil();


			AT18=(Token)match(input,AT,FOLLOW_AT_in_annotation_entry596); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			AT18_tree = (Object)adaptor.create(AT18);
			adaptor.addChild(root_0, AT18_tree);
			}

			pushFollow(FOLLOW_var_in_annotation_entry598);
			var19=var();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var19.getTree());

			if ( state.backtracking==0 ) { annotation = new Annotation((var19!=null?input.toString(var19.start,var19.stop):null)); }
			// io/protostuff/fbsgen/parser/ProtoParser.g:101:9: ( LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==LEFTPAREN) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:101:10: LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN
					{
					LEFTPAREN20=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_annotation_entry611); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTPAREN20_tree = (Object)adaptor.create(LEFTPAREN20);
					adaptor.addChild(root_0, LEFTPAREN20_tree);
					}

					pushFollow(FOLLOW_annotation_keyval_in_annotation_entry622);
					annotation_keyval21=annotation_keyval(proto, annotation);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_keyval21.getTree());

					// io/protostuff/fbsgen/parser/ProtoParser.g:102:46: ( COMMA annotation_keyval[proto, annotation] )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==COMMA) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// io/protostuff/fbsgen/parser/ProtoParser.g:102:47: COMMA annotation_keyval[proto, annotation]
							{
							COMMA22=(Token)match(input,COMMA,FOLLOW_COMMA_in_annotation_entry626); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA22_tree = (Object)adaptor.create(COMMA22);
							adaptor.addChild(root_0, COMMA22_tree);
							}

							pushFollow(FOLLOW_annotation_keyval_in_annotation_entry628);
							annotation_keyval23=annotation_keyval(proto, annotation);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_keyval23.getTree());

							}
							break;

						default :
							break loop5;
						}
					}

					RIGHTPAREN24=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_annotation_entry642); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTPAREN24_tree = (Object)adaptor.create(RIGHTPAREN24);
					adaptor.addChild(root_0, RIGHTPAREN24_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			            proto.add(annotation);
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "annotation_entry"


	public static class annotation_keyval_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "annotation_keyval"
	// io/protostuff/fbsgen/parser/ProtoParser.g:108:1: annotation_keyval[Proto proto, Annotation annotation] : k= var_full ASSIGN (vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) ;
	public final ProtoParser.annotation_keyval_return annotation_keyval(Proto proto, Annotation annotation) throws RecognitionException {
		ProtoParser.annotation_keyval_return retval = new ProtoParser.annotation_keyval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fid=null;
		Token ASSIGN25=null;
		Token ID26=null;
		Token NUMFLOAT27=null;
		Token NUMINT28=null;
		Token NUMDOUBLE29=null;
		Token TRUE30=null;
		Token FALSE31=null;
		Token STRING_LITERAL32=null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope vr =null;

		Object fid_tree=null;
		Object ASSIGN25_tree=null;
		Object ID26_tree=null;
		Object NUMFLOAT27_tree=null;
		Object NUMINT28_tree=null;
		Object NUMDOUBLE29_tree=null;
		Object TRUE30_tree=null;
		Object FALSE31_tree=null;
		Object STRING_LITERAL32_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:109:5: (k= var_full ASSIGN (vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) )
			// io/protostuff/fbsgen/parser/ProtoParser.g:109:9: k= var_full ASSIGN (vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_var_full_in_annotation_keyval669);
			k=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

			ASSIGN25=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_annotation_keyval671); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN25_tree = (Object)adaptor.create(ASSIGN25);
			adaptor.addChild(root_0, ASSIGN25_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:109:27: (vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			int alt7=9;
			switch ( input.LA(1) ) {
			case BOOL:
			case BYTES:
			case DEFAULT:
			case DOUBLE:
			case ENUM:
			case FLOAT:
			case IMPORT:
			case INT16:
			case INT32:
			case INT64:
			case INT8:
			case MAX:
			case MESSAGE:
			case OPTION:
			case OPTIONAL:
			case PKG:
			case REPEATED:
			case REQUIRED:
			case RETURNS:
			case RPC:
			case SERVICE:
			case STRING:
			case SYNTAX:
			case TO:
			case UINT16:
			case UINT32:
			case UINT64:
			case UINT8:
			case VOID:
				{
				alt7=1;
				}
				break;
			case ID:
				{
				alt7=2;
				}
				break;
			case FULL_ID:
				{
				alt7=3;
				}
				break;
			case NUMFLOAT:
				{
				alt7=4;
				}
				break;
			case NUMINT:
				{
				alt7=5;
				}
				break;
			case NUMDOUBLE:
				{
				alt7=6;
				}
				break;
			case TRUE:
				{
				alt7=7;
				}
				break;
			case FALSE:
				{
				alt7=8;
				}
				break;
			case STRING_LITERAL:
				{
				alt7=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:110:17: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_annotation_keyval693);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), (vr!=null?input.toString(vr.start,vr.stop):null)); }
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:111:17: ID
					{
					ID26=(Token)match(input,ID,FOLLOW_ID_in_annotation_keyval713); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID26_tree = (Object)adaptor.create(ID26);
					adaptor.addChild(root_0, ID26_tree);
					}

					if ( state.backtracking==0 ) { annotation.putRef((k!=null?input.toString(k.start,k.stop):null), (ID26!=null?ID26.getText():null)); }
					}
					break;
				case 3 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:112:17: fid= FULL_ID
					{
					fid=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_annotation_keyval735); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					fid_tree = (Object)adaptor.create(fid);
					adaptor.addChild(root_0, fid_tree);
					}

					if ( state.backtracking==0 ) { annotation.putRef((k!=null?input.toString(k.start,k.stop):null), (fid!=null?fid.getText():null)); }
					}
					break;
				case 4 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:113:17: NUMFLOAT
					{
					NUMFLOAT27=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_annotation_keyval755); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT27_tree = (Object)adaptor.create(NUMFLOAT27);
					adaptor.addChild(root_0, NUMFLOAT27_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Float.valueOf((NUMFLOAT27!=null?NUMFLOAT27.getText():null))); }
					}
					break;
				case 5 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:114:17: NUMINT
					{
					NUMINT28=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_annotation_keyval775); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT28_tree = (Object)adaptor.create(NUMINT28);
					adaptor.addChild(root_0, NUMINT28_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Integer.valueOf((NUMINT28!=null?NUMINT28.getText():null))); }
					}
					break;
				case 6 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:115:17: NUMDOUBLE
					{
					NUMDOUBLE29=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_annotation_keyval795); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE29_tree = (Object)adaptor.create(NUMDOUBLE29);
					adaptor.addChild(root_0, NUMDOUBLE29_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Double.valueOf((NUMDOUBLE29!=null?NUMDOUBLE29.getText():null))); }
					}
					break;
				case 7 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:116:17: TRUE
					{
					TRUE30=(Token)match(input,TRUE,FOLLOW_TRUE_in_annotation_keyval815); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE30_tree = (Object)adaptor.create(TRUE30);
					adaptor.addChild(root_0, TRUE30_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Boolean.TRUE); }
					}
					break;
				case 8 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:117:17: FALSE
					{
					FALSE31=(Token)match(input,FALSE,FOLLOW_FALSE_in_annotation_keyval835); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE31_tree = (Object)adaptor.create(FALSE31);
					adaptor.addChild(root_0, FALSE31_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Boolean.FALSE); }
					}
					break;
				case 9 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:118:17: STRING_LITERAL
					{
					STRING_LITERAL32=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_annotation_keyval855); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL32_tree = (Object)adaptor.create(STRING_LITERAL32);
					adaptor.addChild(root_0, STRING_LITERAL32_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), getStringFromStringLiteral((STRING_LITERAL32!=null?STRING_LITERAL32.getText():null))); }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "annotation_keyval"


	public static class header_syntax_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "header_syntax"
	// io/protostuff/fbsgen/parser/ProtoParser.g:122:1: header_syntax[Proto proto] : SYNTAX ASSIGN STRING_LITERAL SEMICOLON !;
	public final ProtoParser.header_syntax_return header_syntax(Proto proto) throws RecognitionException {
		ProtoParser.header_syntax_return retval = new ProtoParser.header_syntax_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SYNTAX33=null;
		Token ASSIGN34=null;
		Token STRING_LITERAL35=null;
		Token SEMICOLON36=null;

		Object SYNTAX33_tree=null;
		Object ASSIGN34_tree=null;
		Object STRING_LITERAL35_tree=null;
		Object SEMICOLON36_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:123:5: ( SYNTAX ASSIGN STRING_LITERAL SEMICOLON !)
			// io/protostuff/fbsgen/parser/ProtoParser.g:123:9: SYNTAX ASSIGN STRING_LITERAL SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			SYNTAX33=(Token)match(input,SYNTAX,FOLLOW_SYNTAX_in_header_syntax888); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SYNTAX33_tree = (Object)adaptor.create(SYNTAX33);
			adaptor.addChild(root_0, SYNTAX33_tree);
			}

			ASSIGN34=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_header_syntax890); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN34_tree = (Object)adaptor.create(ASSIGN34);
			adaptor.addChild(root_0, ASSIGN34_tree);
			}

			STRING_LITERAL35=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_header_syntax892); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STRING_LITERAL35_tree = (Object)adaptor.create(STRING_LITERAL35);
			adaptor.addChild(root_0, STRING_LITERAL35_tree);
			}

			SEMICOLON36=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_header_syntax894); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			            if (!"proto2".equals(getStringFromStringLiteral((STRING_LITERAL35!=null?STRING_LITERAL35.getText():null)))) {
			                throw err(proto, "Syntax isn't proto2: '" +
			                        getStringFromStringLiteral((STRING_LITERAL35!=null?STRING_LITERAL35.getText():null))+"'");
			            }
			            
			            proto.checkAnnotations();
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "header_syntax"


	public static class header_package_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "header_package"
	// io/protostuff/fbsgen/parser/ProtoParser.g:133:1: header_package[Proto proto] : PKG ( FULL_ID | var ) SEMICOLON !;
	public final ProtoParser.header_package_return header_package(Proto proto) throws RecognitionException {
		ProtoParser.header_package_return retval = new ProtoParser.header_package_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PKG37=null;
		Token FULL_ID38=null;
		Token SEMICOLON40=null;
		ParserRuleReturnScope var39 =null;

		Object PKG37_tree=null;
		Object FULL_ID38_tree=null;
		Object SEMICOLON40_tree=null;


		    String value = null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:137:5: ( PKG ( FULL_ID | var ) SEMICOLON !)
			// io/protostuff/fbsgen/parser/ProtoParser.g:137:9: PKG ( FULL_ID | var ) SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			PKG37=(Token)match(input,PKG,FOLLOW_PKG_in_header_package923); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PKG37_tree = (Object)adaptor.create(PKG37);
			adaptor.addChild(root_0, PKG37_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:137:13: ( FULL_ID | var )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==FULL_ID) ) {
				alt8=1;
			}
			else if ( ((LA8_0 >= BOOL && LA8_0 <= BYTES)||LA8_0==DEFAULT||(LA8_0 >= DOUBLE && LA8_0 <= ENUM)||LA8_0==FLOAT||(LA8_0 >= ID && LA8_0 <= INT8)||(LA8_0 >= MAX && LA8_0 <= MESSAGE)||(LA8_0 >= OPTION && LA8_0 <= PKG)||(LA8_0 >= REPEATED && LA8_0 <= RETURNS)||LA8_0==RPC||(LA8_0 >= SERVICE && LA8_0 <= STRING)||(LA8_0 >= SYNTAX && LA8_0 <= TO)||(LA8_0 >= UINT16 && LA8_0 <= UINT8)||LA8_0==VOID) ) {
				alt8=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:137:14: FULL_ID
					{
					FULL_ID38=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_header_package926); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID38_tree = (Object)adaptor.create(FULL_ID38);
					adaptor.addChild(root_0, FULL_ID38_tree);
					}

					if ( state.backtracking==0 ) { value = (FULL_ID38!=null?FULL_ID38.getText():null); }
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:137:51: var
					{
					pushFollow(FOLLOW_var_in_header_package932);
					var39=var();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var39.getTree());

					if ( state.backtracking==0 ) { value = (var39!=null?input.toString(var39.start,var39.stop):null); }
					}
					break;

			}

			SEMICOLON40=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_header_package937); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			            if (proto.getPackageName() != null)
			                throw err(proto, "Multiple package definitions.");
			            
			            proto.setPackageName(value);
			            
			            proto.checkAnnotations();
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "header_package"


	public static class header_import_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "header_import"
	// io/protostuff/fbsgen/parser/ProtoParser.g:147:1: header_import[Proto proto] : IMPORT STRING_LITERAL SEMICOLON !;
	public final ProtoParser.header_import_return header_import(Proto proto) throws RecognitionException {
		ProtoParser.header_import_return retval = new ProtoParser.header_import_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IMPORT41=null;
		Token STRING_LITERAL42=null;
		Token SEMICOLON43=null;

		Object IMPORT41_tree=null;
		Object STRING_LITERAL42_tree=null;
		Object SEMICOLON43_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:148:5: ( IMPORT STRING_LITERAL SEMICOLON !)
			// io/protostuff/fbsgen/parser/ProtoParser.g:148:9: IMPORT STRING_LITERAL SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			IMPORT41=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_header_import965); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IMPORT41_tree = (Object)adaptor.create(IMPORT41);
			adaptor.addChild(root_0, IMPORT41_tree);
			}

			STRING_LITERAL42=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_header_import967); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STRING_LITERAL42_tree = (Object)adaptor.create(STRING_LITERAL42);
			adaptor.addChild(root_0, STRING_LITERAL42_tree);
			}

			SEMICOLON43=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_header_import969); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			            proto.importProto(getStringFromStringLiteral((STRING_LITERAL42!=null?STRING_LITERAL42.getText():null)));
			            
			            proto.checkAnnotations();
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "header_import"


	public static class option_entry_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "option_entry"
	// io/protostuff/fbsgen/parser/ProtoParser.g:155:1: option_entry[Proto proto, HasOptions ho] : OPTION ( LEFTPAREN )? k= var_full ( RIGHTPAREN )? ASSIGN (vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) SEMICOLON !;
	public final ProtoParser.option_entry_return option_entry(Proto proto, HasOptions ho) throws RecognitionException {
		ProtoParser.option_entry_return retval = new ProtoParser.option_entry_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token fid=null;
		Token OPTION44=null;
		Token LEFTPAREN45=null;
		Token RIGHTPAREN46=null;
		Token ASSIGN47=null;
		Token NUMFLOAT48=null;
		Token NUMINT49=null;
		Token NUMDOUBLE50=null;
		Token TRUE51=null;
		Token FALSE52=null;
		Token STRING_LITERAL53=null;
		Token SEMICOLON54=null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope vr =null;

		Object id_tree=null;
		Object fid_tree=null;
		Object OPTION44_tree=null;
		Object LEFTPAREN45_tree=null;
		Object RIGHTPAREN46_tree=null;
		Object ASSIGN47_tree=null;
		Object NUMFLOAT48_tree=null;
		Object NUMINT49_tree=null;
		Object NUMDOUBLE50_tree=null;
		Object TRUE51_tree=null;
		Object FALSE52_tree=null;
		Object STRING_LITERAL53_tree=null;
		Object SEMICOLON54_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:156:5: ( OPTION ( LEFTPAREN )? k= var_full ( RIGHTPAREN )? ASSIGN (vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) SEMICOLON !)
			// io/protostuff/fbsgen/parser/ProtoParser.g:156:9: OPTION ( LEFTPAREN )? k= var_full ( RIGHTPAREN )? ASSIGN (vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			OPTION44=(Token)match(input,OPTION,FOLLOW_OPTION_in_option_entry993); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OPTION44_tree = (Object)adaptor.create(OPTION44);
			adaptor.addChild(root_0, OPTION44_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:156:16: ( LEFTPAREN )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==LEFTPAREN) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:156:16: LEFTPAREN
					{
					LEFTPAREN45=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_option_entry995); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTPAREN45_tree = (Object)adaptor.create(LEFTPAREN45);
					adaptor.addChild(root_0, LEFTPAREN45_tree);
					}

					}
					break;

			}

			pushFollow(FOLLOW_var_full_in_option_entry1000);
			k=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

			// io/protostuff/fbsgen/parser/ProtoParser.g:156:38: ( RIGHTPAREN )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==RIGHTPAREN) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:156:38: RIGHTPAREN
					{
					RIGHTPAREN46=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_option_entry1002); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTPAREN46_tree = (Object)adaptor.create(RIGHTPAREN46);
					adaptor.addChild(root_0, RIGHTPAREN46_tree);
					}

					}
					break;

			}

			ASSIGN47=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_option_entry1005); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN47_tree = (Object)adaptor.create(ASSIGN47);
			adaptor.addChild(root_0, ASSIGN47_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:156:57: (vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			int alt11=9;
			switch ( input.LA(1) ) {
			case BOOL:
			case BYTES:
			case DEFAULT:
			case DOUBLE:
			case ENUM:
			case FLOAT:
			case IMPORT:
			case INT16:
			case INT32:
			case INT64:
			case INT8:
			case MAX:
			case MESSAGE:
			case OPTION:
			case OPTIONAL:
			case PKG:
			case REPEATED:
			case REQUIRED:
			case RETURNS:
			case RPC:
			case SERVICE:
			case STRING:
			case SYNTAX:
			case TO:
			case UINT16:
			case UINT32:
			case UINT64:
			case UINT8:
			case VOID:
				{
				alt11=1;
				}
				break;
			case ID:
				{
				alt11=2;
				}
				break;
			case FULL_ID:
				{
				alt11=3;
				}
				break;
			case NUMFLOAT:
				{
				alt11=4;
				}
				break;
			case NUMINT:
				{
				alt11=5;
				}
				break;
			case NUMDOUBLE:
				{
				alt11=6;
				}
				break;
			case TRUE:
				{
				alt11=7;
				}
				break;
			case FALSE:
				{
				alt11=8;
				}
				break;
			case STRING_LITERAL:
				{
				alt11=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:157:17: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_option_entry1027);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) { ho.putExtraOption((k!=null?input.toString(k.start,k.stop):null), (vr!=null?input.toString(vr.start,vr.stop):null)); }
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:158:17: id= ID
					{
					id=(Token)match(input,ID,FOLLOW_ID_in_option_entry1049); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					id_tree = (Object)adaptor.create(id);
					adaptor.addChild(root_0, id_tree);
					}

					if ( state.backtracking==0 ) { ho.putStandardOption((k!=null?input.toString(k.start,k.stop):null), (id!=null?id.getText():null)); }
					}
					break;
				case 3 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:159:17: fid= FULL_ID
					{
					fid=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_option_entry1071); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					fid_tree = (Object)adaptor.create(fid);
					adaptor.addChild(root_0, fid_tree);
					}

					if ( state.backtracking==0 ) { ho.putStandardOption((k!=null?input.toString(k.start,k.stop):null), (fid!=null?fid.getText():null)); }
					}
					break;
				case 4 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:160:17: NUMFLOAT
					{
					NUMFLOAT48=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_option_entry1091); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT48_tree = (Object)adaptor.create(NUMFLOAT48);
					adaptor.addChild(root_0, NUMFLOAT48_tree);
					}

					if ( state.backtracking==0 ) { ho.putExtraOption((k!=null?input.toString(k.start,k.stop):null), Float.valueOf((NUMFLOAT48!=null?NUMFLOAT48.getText():null))); }
					}
					break;
				case 5 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:161:17: NUMINT
					{
					NUMINT49=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_option_entry1111); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT49_tree = (Object)adaptor.create(NUMINT49);
					adaptor.addChild(root_0, NUMINT49_tree);
					}

					if ( state.backtracking==0 ) { ho.putExtraOption((k!=null?input.toString(k.start,k.stop):null), Integer.valueOf((NUMINT49!=null?NUMINT49.getText():null))); }
					}
					break;
				case 6 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:162:17: NUMDOUBLE
					{
					NUMDOUBLE50=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_option_entry1131); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE50_tree = (Object)adaptor.create(NUMDOUBLE50);
					adaptor.addChild(root_0, NUMDOUBLE50_tree);
					}

					if ( state.backtracking==0 ) { ho.putExtraOption((k!=null?input.toString(k.start,k.stop):null), Double.valueOf((NUMDOUBLE50!=null?NUMDOUBLE50.getText():null))); }
					}
					break;
				case 7 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:163:17: TRUE
					{
					TRUE51=(Token)match(input,TRUE,FOLLOW_TRUE_in_option_entry1151); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE51_tree = (Object)adaptor.create(TRUE51);
					adaptor.addChild(root_0, TRUE51_tree);
					}

					if ( state.backtracking==0 ) { ho.putExtraOption((k!=null?input.toString(k.start,k.stop):null), Boolean.TRUE); }
					}
					break;
				case 8 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:164:17: FALSE
					{
					FALSE52=(Token)match(input,FALSE,FOLLOW_FALSE_in_option_entry1171); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE52_tree = (Object)adaptor.create(FALSE52);
					adaptor.addChild(root_0, FALSE52_tree);
					}

					if ( state.backtracking==0 ) { ho.putExtraOption((k!=null?input.toString(k.start,k.stop):null), Boolean.FALSE); }
					}
					break;
				case 9 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:165:17: STRING_LITERAL
					{
					STRING_LITERAL53=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_option_entry1191); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL53_tree = (Object)adaptor.create(STRING_LITERAL53);
					adaptor.addChild(root_0, STRING_LITERAL53_tree);
					}

					if ( state.backtracking==0 ) { ho.putExtraOption((k!=null?input.toString(k.start,k.stop):null), getStringFromStringLiteral((STRING_LITERAL53!=null?STRING_LITERAL53.getText():null))); }
					}
					break;

			}

			SEMICOLON54=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_option_entry1205); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			            proto.checkAnnotations();
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "option_entry"


	public static class message_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "message_block"
	// io/protostuff/fbsgen/parser/ProtoParser.g:171:1: message_block[Proto proto, Message parent] : MESSAGE ID LEFTCURLY ( message_body[proto, message] )* RIGHTCURLY ;
	public final ProtoParser.message_block_return message_block(Proto proto, Message parent) throws RecognitionException {
		ProtoParser.message_block_return retval = new ProtoParser.message_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MESSAGE55=null;
		Token ID56=null;
		Token LEFTCURLY57=null;
		Token RIGHTCURLY59=null;
		ParserRuleReturnScope message_body58 =null;

		Object MESSAGE55_tree=null;
		Object ID56_tree=null;
		Object LEFTCURLY57_tree=null;
		Object RIGHTCURLY59_tree=null;


		    Message message = null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:175:5: ( MESSAGE ID LEFTCURLY ( message_body[proto, message] )* RIGHTCURLY )
			// io/protostuff/fbsgen/parser/ProtoParser.g:175:9: MESSAGE ID LEFTCURLY ( message_body[proto, message] )* RIGHTCURLY
			{
			root_0 = (Object)adaptor.nil();


			MESSAGE55=(Token)match(input,MESSAGE,FOLLOW_MESSAGE_in_message_block1238); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MESSAGE55_tree = (Object)adaptor.create(MESSAGE55);
			adaptor.addChild(root_0, MESSAGE55_tree);
			}

			ID56=(Token)match(input,ID,FOLLOW_ID_in_message_block1240); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID56_tree = (Object)adaptor.create(ID56);
			adaptor.addChild(root_0, ID56_tree);
			}

			if ( state.backtracking==0 ) { 
			            message = new Message((ID56!=null?ID56.getText():null), parent, proto);
			            proto.addAnnotationsTo(message);
			        }
			LEFTCURLY57=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_message_block1253); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY57_tree = (Object)adaptor.create(LEFTCURLY57);
			adaptor.addChild(root_0, LEFTCURLY57_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:179:19: ( message_body[proto, message] )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==AT||LA12_0==DOC_COMMENT||LA12_0==ENUM||LA12_0==MESSAGE||(LA12_0 >= OPTION && LA12_0 <= OPTIONAL)||(LA12_0 >= REPEATED && LA12_0 <= REQUIRED)||LA12_0==SERVICE) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:179:20: message_body[proto, message]
					{
					pushFollow(FOLLOW_message_body_in_message_block1256);
					message_body58=message_body(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_body58.getTree());

					}
					break;

				default :
					break loop12;
				}
			}

			RIGHTCURLY59=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_message_block1261); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY59_tree = (Object)adaptor.create(RIGHTCURLY59);
			adaptor.addChild(root_0, RIGHTCURLY59_tree);
			}

			if ( state.backtracking==0 ) {
			            proto.checkAnnotations();
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "message_block"


	public static class message_body_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "message_body"
	// io/protostuff/fbsgen/parser/ProtoParser.g:184:1: message_body[Proto proto, Message message] : ( message_block[proto, message] | message_field[proto, message] | enum_block[proto, message] | service_block[proto, message] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, message] );
	public final ProtoParser.message_body_return message_body(Proto proto, Message message) throws RecognitionException {
		ProtoParser.message_body_return retval = new ProtoParser.message_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope message_block60 =null;
		ParserRuleReturnScope message_field61 =null;
		ParserRuleReturnScope enum_block62 =null;
		ParserRuleReturnScope service_block63 =null;
		ParserRuleReturnScope annotation_entry64 =null;
		ParserRuleReturnScope comment_entry65 =null;
		ParserRuleReturnScope option_entry66 =null;


		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:185:5: ( message_block[proto, message] | message_field[proto, message] | enum_block[proto, message] | service_block[proto, message] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, message] )
			int alt13=7;
			switch ( input.LA(1) ) {
			case MESSAGE:
				{
				alt13=1;
				}
				break;
			case OPTIONAL:
			case REPEATED:
			case REQUIRED:
				{
				alt13=2;
				}
				break;
			case ENUM:
				{
				alt13=3;
				}
				break;
			case SERVICE:
				{
				alt13=4;
				}
				break;
			case AT:
				{
				alt13=5;
				}
				break;
			case DOC_COMMENT:
				{
				alt13=6;
				}
				break;
			case OPTION:
				{
				alt13=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:185:9: message_block[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_message_block_in_message_body1284);
					message_block60=message_block(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_block60.getTree());

					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:186:9: message_field[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_message_field_in_message_body1295);
					message_field61=message_field(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_field61.getTree());

					}
					break;
				case 3 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:187:9: enum_block[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_enum_block_in_message_body1306);
					enum_block62=enum_block(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_block62.getTree());

					}
					break;
				case 4 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:188:9: service_block[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_service_block_in_message_body1317);
					service_block63=service_block(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, service_block63.getTree());

					}
					break;
				case 5 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:191:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_message_body1338);
					annotation_entry64=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry64.getTree());

					}
					break;
				case 6 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:192:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_message_body1349);
					comment_entry65=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry65.getTree());

					}
					break;
				case 7 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:193:9: option_entry[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_message_body1360);
					option_entry66=option_entry(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry66.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "message_body"


	public static class message_field_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "message_field"
	// io/protostuff/fbsgen/parser/ProtoParser.g:208:1: message_field[Proto proto, HasFields message] : ( OPTIONAL | REQUIRED | REPEATED ) field_type[proto, message, fieldHolder] var ASSIGN NUMINT ( field_options[proto, message, fieldHolder.field] )? ( SEMICOLON !| ignore_block ) ;
	public final ProtoParser.message_field_return message_field(Proto proto, HasFields message) throws RecognitionException {
		ProtoParser.message_field_return retval = new ProtoParser.message_field_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OPTIONAL67=null;
		Token REQUIRED68=null;
		Token REPEATED69=null;
		Token ASSIGN72=null;
		Token NUMINT73=null;
		Token SEMICOLON75=null;
		ParserRuleReturnScope field_type70 =null;
		ParserRuleReturnScope var71 =null;
		ParserRuleReturnScope field_options74 =null;
		ParserRuleReturnScope ignore_block76 =null;

		Object OPTIONAL67_tree=null;
		Object REQUIRED68_tree=null;
		Object REPEATED69_tree=null;
		Object ASSIGN72_tree=null;
		Object NUMINT73_tree=null;
		Object SEMICOLON75_tree=null;


		    Field.Modifier modifier = null;
		    FieldHolder fieldHolder = null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:213:5: ( ( OPTIONAL | REQUIRED | REPEATED ) field_type[proto, message, fieldHolder] var ASSIGN NUMINT ( field_options[proto, message, fieldHolder.field] )? ( SEMICOLON !| ignore_block ) )
			// io/protostuff/fbsgen/parser/ProtoParser.g:213:9: ( OPTIONAL | REQUIRED | REPEATED ) field_type[proto, message, fieldHolder] var ASSIGN NUMINT ( field_options[proto, message, fieldHolder.field] )? ( SEMICOLON !| ignore_block )
			{
			root_0 = (Object)adaptor.nil();


			// io/protostuff/fbsgen/parser/ProtoParser.g:213:9: ( OPTIONAL | REQUIRED | REPEATED )
			int alt14=3;
			switch ( input.LA(1) ) {
			case OPTIONAL:
				{
				alt14=1;
				}
				break;
			case REQUIRED:
				{
				alt14=2;
				}
				break;
			case REPEATED:
				{
				alt14=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:213:10: OPTIONAL
					{
					OPTIONAL67=(Token)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_message_field1408); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OPTIONAL67_tree = (Object)adaptor.create(OPTIONAL67);
					adaptor.addChild(root_0, OPTIONAL67_tree);
					}

					if ( state.backtracking==0 ) { modifier = Field.Modifier.OPTIONAL;  }
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:214:13: REQUIRED
					{
					REQUIRED68=(Token)match(input,REQUIRED,FOLLOW_REQUIRED_in_message_field1425); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					REQUIRED68_tree = (Object)adaptor.create(REQUIRED68);
					adaptor.addChild(root_0, REQUIRED68_tree);
					}

					if ( state.backtracking==0 ) { modifier = Field.Modifier.REQUIRED; }
					}
					break;
				case 3 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:215:13: REPEATED
					{
					REPEATED69=(Token)match(input,REPEATED,FOLLOW_REPEATED_in_message_field1442); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					REPEATED69_tree = (Object)adaptor.create(REPEATED69);
					adaptor.addChild(root_0, REPEATED69_tree);
					}

					if ( state.backtracking==0 ) { modifier = Field.Modifier.REPEATED; }
					}
					break;

			}

			if ( state.backtracking==0 ) {
			            fieldHolder = new FieldHolder();
			        }
			pushFollow(FOLLOW_field_type_in_message_field1457);
			field_type70=field_type(proto, message, fieldHolder);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_type70.getTree());

			pushFollow(FOLLOW_var_in_message_field1469);
			var71=var();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var71.getTree());

			ASSIGN72=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_message_field1471); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN72_tree = (Object)adaptor.create(ASSIGN72);
			adaptor.addChild(root_0, ASSIGN72_tree);
			}

			NUMINT73=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_message_field1473); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NUMINT73_tree = (Object)adaptor.create(NUMINT73);
			adaptor.addChild(root_0, NUMINT73_tree);
			}

			if ( state.backtracking==0 ) {
			            if (fieldHolder.field != null) {
			                fieldHolder.field.modifier = modifier;
			                fieldHolder.field.name = (var71!=null?input.toString(var71.start,var71.stop):null);
			                fieldHolder.field.number = Integer.parseInt((NUMINT73!=null?NUMINT73.getText():null));
			            }
			        }
			// io/protostuff/fbsgen/parser/ProtoParser.g:226:9: ( field_options[proto, message, fieldHolder.field] )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==LEFTSQUARE) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:226:10: field_options[proto, message, fieldHolder.field]
					{
					pushFollow(FOLLOW_field_options_in_message_field1487);
					field_options74=field_options(proto, message, fieldHolder.field);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options74.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			            if (fieldHolder.field != null) {
			                proto.addAnnotationsTo(fieldHolder.field, message.getEnclosingNamespace());
			                message.addField(fieldHolder.field);
			            }
			        }
			// io/protostuff/fbsgen/parser/ProtoParser.g:232:9: ( SEMICOLON !| ignore_block )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==SEMICOLON) ) {
				alt16=1;
			}
			else if ( (LA16_0==LEFTCURLY) ) {
				alt16=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:232:10: SEMICOLON !
					{
					SEMICOLON75=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_message_field1503); if (state.failed) return retval;
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:232:23: ignore_block
					{
					pushFollow(FOLLOW_ignore_block_in_message_field1508);
					ignore_block76=ignore_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_block76.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "message_field"


	public static class field_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "field_type"
	// io/protostuff/fbsgen/parser/ProtoParser.g:235:1: field_type[Proto proto, HasFields message, FieldHolder fieldHolder] : ( BOOL | INT8 | UINT8 | INT16 | UINT16 | INT32 | UINT32 | INT64 | UINT64 | FLOAT | DOUBLE | STRING | BYTES | FULL_ID | ID );
	public final ProtoParser.field_type_return field_type(Proto proto, HasFields message, FieldHolder fieldHolder) throws RecognitionException {
		ProtoParser.field_type_return retval = new ProtoParser.field_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BOOL77=null;
		Token INT878=null;
		Token UINT879=null;
		Token INT1680=null;
		Token UINT1681=null;
		Token INT3282=null;
		Token UINT3283=null;
		Token INT6484=null;
		Token UINT6485=null;
		Token FLOAT86=null;
		Token DOUBLE87=null;
		Token STRING88=null;
		Token BYTES89=null;
		Token FULL_ID90=null;
		Token ID91=null;

		Object BOOL77_tree=null;
		Object INT878_tree=null;
		Object UINT879_tree=null;
		Object INT1680_tree=null;
		Object UINT1681_tree=null;
		Object INT3282_tree=null;
		Object UINT3283_tree=null;
		Object INT6484_tree=null;
		Object UINT6485_tree=null;
		Object FLOAT86_tree=null;
		Object DOUBLE87_tree=null;
		Object STRING88_tree=null;
		Object BYTES89_tree=null;
		Object FULL_ID90_tree=null;
		Object ID91_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:236:5: ( BOOL | INT8 | UINT8 | INT16 | UINT16 | INT32 | UINT32 | INT64 | UINT64 | FLOAT | DOUBLE | STRING | BYTES | FULL_ID | ID )
			int alt17=15;
			switch ( input.LA(1) ) {
			case BOOL:
				{
				alt17=1;
				}
				break;
			case INT8:
				{
				alt17=2;
				}
				break;
			case UINT8:
				{
				alt17=3;
				}
				break;
			case INT16:
				{
				alt17=4;
				}
				break;
			case UINT16:
				{
				alt17=5;
				}
				break;
			case INT32:
				{
				alt17=6;
				}
				break;
			case UINT32:
				{
				alt17=7;
				}
				break;
			case INT64:
				{
				alt17=8;
				}
				break;
			case UINT64:
				{
				alt17=9;
				}
				break;
			case FLOAT:
				{
				alt17=10;
				}
				break;
			case DOUBLE:
				{
				alt17=11;
				}
				break;
			case STRING:
				{
				alt17=12;
				}
				break;
			case BYTES:
				{
				alt17=13;
				}
				break;
			case FULL_ID:
				{
				alt17=14;
				}
				break;
			case ID:
				{
				alt17=15;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:236:9: BOOL
					{
					root_0 = (Object)adaptor.nil();


					BOOL77=(Token)match(input,BOOL,FOLLOW_BOOL_in_field_type1534); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOL77_tree = (Object)adaptor.create(BOOL77);
					adaptor.addChild(root_0, BOOL77_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Bool()); }
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:237:9: INT8
					{
					root_0 = (Object)adaptor.nil();


					INT878=(Token)match(input,INT8,FOLLOW_INT8_in_field_type1546); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT878_tree = (Object)adaptor.create(INT878);
					adaptor.addChild(root_0, INT878_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int8()); }
					}
					break;
				case 3 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:238:9: UINT8
					{
					root_0 = (Object)adaptor.nil();


					UINT879=(Token)match(input,UINT8,FOLLOW_UINT8_in_field_type1558); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT879_tree = (Object)adaptor.create(UINT879);
					adaptor.addChild(root_0, UINT879_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt8()); }
					}
					break;
				case 4 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:239:9: INT16
					{
					root_0 = (Object)adaptor.nil();


					INT1680=(Token)match(input,INT16,FOLLOW_INT16_in_field_type1570); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT1680_tree = (Object)adaptor.create(INT1680);
					adaptor.addChild(root_0, INT1680_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int16()); }
					}
					break;
				case 5 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:240:9: UINT16
					{
					root_0 = (Object)adaptor.nil();


					UINT1681=(Token)match(input,UINT16,FOLLOW_UINT16_in_field_type1582); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT1681_tree = (Object)adaptor.create(UINT1681);
					adaptor.addChild(root_0, UINT1681_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt16()); }
					}
					break;
				case 6 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:241:9: INT32
					{
					root_0 = (Object)adaptor.nil();


					INT3282=(Token)match(input,INT32,FOLLOW_INT32_in_field_type1594); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT3282_tree = (Object)adaptor.create(INT3282);
					adaptor.addChild(root_0, INT3282_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int32()); }
					}
					break;
				case 7 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:242:9: UINT32
					{
					root_0 = (Object)adaptor.nil();


					UINT3283=(Token)match(input,UINT32,FOLLOW_UINT32_in_field_type1606); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT3283_tree = (Object)adaptor.create(UINT3283);
					adaptor.addChild(root_0, UINT3283_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt32()); }
					}
					break;
				case 8 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:243:9: INT64
					{
					root_0 = (Object)adaptor.nil();


					INT6484=(Token)match(input,INT64,FOLLOW_INT64_in_field_type1618); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT6484_tree = (Object)adaptor.create(INT6484);
					adaptor.addChild(root_0, INT6484_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int64()); }
					}
					break;
				case 9 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:244:9: UINT64
					{
					root_0 = (Object)adaptor.nil();


					UINT6485=(Token)match(input,UINT64,FOLLOW_UINT64_in_field_type1630); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT6485_tree = (Object)adaptor.create(UINT6485);
					adaptor.addChild(root_0, UINT6485_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt64()); }
					}
					break;
				case 10 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:245:9: FLOAT
					{
					root_0 = (Object)adaptor.nil();


					FLOAT86=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_field_type1642); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOAT86_tree = (Object)adaptor.create(FLOAT86);
					adaptor.addChild(root_0, FLOAT86_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Float()); }
					}
					break;
				case 11 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:246:9: DOUBLE
					{
					root_0 = (Object)adaptor.nil();


					DOUBLE87=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_field_type1654); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLE87_tree = (Object)adaptor.create(DOUBLE87);
					adaptor.addChild(root_0, DOUBLE87_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Double()); }
					}
					break;
				case 12 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:247:9: STRING
					{
					root_0 = (Object)adaptor.nil();


					STRING88=(Token)match(input,STRING,FOLLOW_STRING_in_field_type1666); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING88_tree = (Object)adaptor.create(STRING88);
					adaptor.addChild(root_0, STRING88_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.String()); }
					}
					break;
				case 13 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:248:9: BYTES
					{
					root_0 = (Object)adaptor.nil();


					BYTES89=(Token)match(input,BYTES,FOLLOW_BYTES_in_field_type1678); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BYTES89_tree = (Object)adaptor.create(BYTES89);
					adaptor.addChild(root_0, BYTES89_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Bytes()); }
					}
					break;
				case 14 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:253:9: FULL_ID
					{
					root_0 = (Object)adaptor.nil();


					FULL_ID90=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_field_type1710); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID90_tree = (Object)adaptor.create(FULL_ID90);
					adaptor.addChild(root_0, FULL_ID90_tree);
					}

					if ( state.backtracking==0 ) {
					            String fullType = (FULL_ID90!=null?FULL_ID90.getText():null);
					            int lastDot = fullType.lastIndexOf('.');
					            String packageName = fullType.substring(0, lastDot);
					            String type = fullType.substring(lastDot+1);
					            fieldHolder.setField(new Field.Reference(packageName, type, message));
					        }
					}
					break;
				case 15 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:260:9: ID
					{
					root_0 = (Object)adaptor.nil();


					ID91=(Token)match(input,ID,FOLLOW_ID_in_field_type1722); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID91_tree = (Object)adaptor.create(ID91);
					adaptor.addChild(root_0, ID91_tree);
					}

					if ( state.backtracking==0 ) { 
					            String type = (ID91!=null?ID91.getText():null);
					            fieldHolder.setField(new Field.Reference(null, type, message));
					        }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "field_type"


	public static class field_options_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "field_options"
	// io/protostuff/fbsgen/parser/ProtoParser.g:266:1: field_options[Proto proto, HasFields message, Field field] : LEFTSQUARE field_options_keyval[proto, message, field, true] ( COMMA field_options_keyval[proto, message, field, true] )* RIGHTSQUARE ;
	public final ProtoParser.field_options_return field_options(Proto proto, HasFields message, Field field) throws RecognitionException {
		ProtoParser.field_options_return retval = new ProtoParser.field_options_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTSQUARE92=null;
		Token COMMA94=null;
		Token RIGHTSQUARE96=null;
		ParserRuleReturnScope field_options_keyval93 =null;
		ParserRuleReturnScope field_options_keyval95 =null;

		Object LEFTSQUARE92_tree=null;
		Object COMMA94_tree=null;
		Object RIGHTSQUARE96_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:267:5: ( LEFTSQUARE field_options_keyval[proto, message, field, true] ( COMMA field_options_keyval[proto, message, field, true] )* RIGHTSQUARE )
			// io/protostuff/fbsgen/parser/ProtoParser.g:267:9: LEFTSQUARE field_options_keyval[proto, message, field, true] ( COMMA field_options_keyval[proto, message, field, true] )* RIGHTSQUARE
			{
			root_0 = (Object)adaptor.nil();


			LEFTSQUARE92=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_field_options1749); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTSQUARE92_tree = (Object)adaptor.create(LEFTSQUARE92);
			adaptor.addChild(root_0, LEFTSQUARE92_tree);
			}

			pushFollow(FOLLOW_field_options_keyval_in_field_options1751);
			field_options_keyval93=field_options_keyval(proto, message, field, true);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval93.getTree());

			// io/protostuff/fbsgen/parser/ProtoParser.g:268:9: ( COMMA field_options_keyval[proto, message, field, true] )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==COMMA) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:268:10: COMMA field_options_keyval[proto, message, field, true]
					{
					COMMA94=(Token)match(input,COMMA,FOLLOW_COMMA_in_field_options1764); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA94_tree = (Object)adaptor.create(COMMA94);
					adaptor.addChild(root_0, COMMA94_tree);
					}

					pushFollow(FOLLOW_field_options_keyval_in_field_options1766);
					field_options_keyval95=field_options_keyval(proto, message, field, true);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval95.getTree());

					}
					break;

				default :
					break loop18;
				}
			}

			RIGHTSQUARE96=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_field_options1771); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTSQUARE96_tree = (Object)adaptor.create(RIGHTSQUARE96);
			adaptor.addChild(root_0, RIGHTSQUARE96_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "field_options"


	public static class field_options_keyval_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "field_options_keyval"
	// io/protostuff/fbsgen/parser/ProtoParser.g:271:1: field_options_keyval[Proto proto, HasFields message, Field field, boolean checkDefault] : key= var_full ASSIGN (vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] ) ;
	public final ProtoParser.field_options_keyval_return field_options_keyval(Proto proto, HasFields message, Field field, boolean checkDefault) throws RecognitionException {
		ProtoParser.field_options_keyval_return retval = new ProtoParser.field_options_keyval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token val=null;
		Token ASSIGN97=null;
		Token STRING_LITERAL98=null;
		Token NUMFLOAT99=null;
		Token NUMINT100=null;
		Token NUMDOUBLE101=null;
		Token HEX102=null;
		Token OCTAL103=null;
		Token TRUE104=null;
		Token FALSE105=null;
		Token FULL_ID106=null;
		Token EXP107=null;
		ParserRuleReturnScope key =null;
		ParserRuleReturnScope vr =null;
		ParserRuleReturnScope signed_constant108 =null;

		Object val_tree=null;
		Object ASSIGN97_tree=null;
		Object STRING_LITERAL98_tree=null;
		Object NUMFLOAT99_tree=null;
		Object NUMINT100_tree=null;
		Object NUMDOUBLE101_tree=null;
		Object HEX102_tree=null;
		Object OCTAL103_tree=null;
		Object TRUE104_tree=null;
		Object FALSE105_tree=null;
		Object FULL_ID106_tree=null;
		Object EXP107_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:272:5: (key= var_full ASSIGN (vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] ) )
			// io/protostuff/fbsgen/parser/ProtoParser.g:272:9: key= var_full ASSIGN (vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] )
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_var_full_in_field_options_keyval1798);
			key=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, key.getTree());

			ASSIGN97=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_field_options_keyval1800); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN97_tree = (Object)adaptor.create(ASSIGN97);
			adaptor.addChild(root_0, ASSIGN97_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:272:29: (vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] )
			int alt19=13;
			switch ( input.LA(1) ) {
			case BOOL:
			case BYTES:
			case DEFAULT:
			case DOUBLE:
			case ENUM:
			case FLOAT:
			case IMPORT:
			case INT16:
			case INT32:
			case INT64:
			case INT8:
			case MAX:
			case MESSAGE:
			case OPTION:
			case OPTIONAL:
			case PKG:
			case REPEATED:
			case REQUIRED:
			case RETURNS:
			case RPC:
			case SERVICE:
			case STRING:
			case SYNTAX:
			case TO:
			case UINT16:
			case UINT32:
			case UINT64:
			case UINT8:
			case VOID:
				{
				alt19=1;
				}
				break;
			case STRING_LITERAL:
				{
				alt19=2;
				}
				break;
			case NUMFLOAT:
				{
				alt19=3;
				}
				break;
			case NUMINT:
				{
				alt19=4;
				}
				break;
			case NUMDOUBLE:
				{
				alt19=5;
				}
				break;
			case HEX:
				{
				alt19=6;
				}
				break;
			case OCTAL:
				{
				alt19=7;
				}
				break;
			case TRUE:
				{
				alt19=8;
				}
				break;
			case FALSE:
				{
				alt19=9;
				}
				break;
			case ID:
				{
				alt19=10;
				}
				break;
			case FULL_ID:
				{
				alt19=11;
				}
				break;
			case EXP:
				{
				alt19=12;
				}
				break;
			case MINUS:
				{
				alt19=13;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:272:30: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_field_options_keyval1805);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) {
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (vr!=null?input.toString(vr.start,vr.stop):null));
					        }
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:275:9: STRING_LITERAL
					{
					STRING_LITERAL98=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_field_options_keyval1818); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL98_tree = (Object)adaptor.create(STRING_LITERAL98);
					adaptor.addChild(root_0, STRING_LITERAL98_tree);
					}

					if ( state.backtracking==0 ) {
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");
					                
					                if (field instanceof Field.String)
					                    field.defaultValue = getStringFromStringLiteral((STRING_LITERAL98!=null?STRING_LITERAL98.getText():null));
					                else if (field instanceof Field.Bytes)
					                    field.defaultValue = getBytesFromStringLiteral((STRING_LITERAL98!=null?STRING_LITERAL98.getText():null));
					                else
					                    throw err(proto, "Invalid string default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
					                
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), getStringFromStringLiteral((STRING_LITERAL98!=null?STRING_LITERAL98.getText():null)));
					            }
					        }
					}
					break;
				case 3 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:292:9: NUMFLOAT
					{
					NUMFLOAT99=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_field_options_keyval1830); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT99_tree = (Object)adaptor.create(NUMFLOAT99);
					adaptor.addChild(root_0, NUMFLOAT99_tree);
					}

					if ( state.backtracking==0 ) {
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");
					                
					                if (field instanceof Field.Float)
					                    field.defaultValue = Float.valueOf((NUMFLOAT99!=null?NUMFLOAT99.getText():null));
					                else if (field instanceof Field.Double) 
					                    field.defaultValue = Double.valueOf((NUMFLOAT99!=null?NUMFLOAT99.getText():null));
					                else
					                    throw err(proto, "Invalid float default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
					                
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Float.valueOf((NUMFLOAT99!=null?NUMFLOAT99.getText():null)));
					            }
					        }
					}
					break;
				case 4 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:309:9: NUMINT
					{
					NUMINT100=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_field_options_keyval1843); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT100_tree = (Object)adaptor.create(NUMINT100);
					adaptor.addChild(root_0, NUMINT100_tree);
					}

					if ( state.backtracking==0 ) {
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");
					                
					                if (field instanceof Field.Number) {
					                    if (field instanceof Field.Float)
					                        field.defaultValue = Float.valueOf((NUMINT100!=null?NUMINT100.getText():null));
					                    else if (field instanceof Field.Double) 
					                        field.defaultValue = Double.valueOf((NUMINT100!=null?NUMINT100.getText():null));
					                    else if (field.getClass().getSimpleName().endsWith("64"))
					                        field.defaultValue = validate(proto, field, Long.parseLong((NUMINT100!=null?NUMINT100.getText():null)));
					                    else
					                        field.defaultValue = validate(proto, field, Integer.parseInt((NUMINT100!=null?NUMINT100.getText():null)));
					                }
					                else
					                    throw err(proto, "Invalid numeric default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
					                
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Integer.valueOf((NUMINT100!=null?NUMINT100.getText():null)));
					            }
					        }
					}
					break;
				case 5 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:332:9: NUMDOUBLE
					{
					NUMDOUBLE101=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_field_options_keyval1855); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE101_tree = (Object)adaptor.create(NUMDOUBLE101);
					adaptor.addChild(root_0, NUMDOUBLE101_tree);
					}

					if ( state.backtracking==0 ) {
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");

					                if (field instanceof Field.Float)
					                    field.defaultValue = Float.valueOf((NUMDOUBLE101!=null?NUMDOUBLE101.getText():null));
					                else if (field instanceof Field.Double) 
					                    field.defaultValue = Double.valueOf((NUMDOUBLE101!=null?NUMDOUBLE101.getText():null));
					                else
					                    throw err(proto, "Invalid numeric default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
					                
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Double.valueOf((NUMDOUBLE101!=null?NUMDOUBLE101.getText():null)));
					            }
					        }
					}
					break;
				case 6 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:349:9: HEX
					{
					HEX102=(Token)match(input,HEX,FOLLOW_HEX_in_field_options_keyval1867); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					HEX102_tree = (Object)adaptor.create(HEX102);
					adaptor.addChild(root_0, HEX102_tree);
					}

					if ( state.backtracking==0 ) {
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");
					                
					                if (field instanceof Field.Number) {
					                    if (field instanceof Field.Float)
					                        field.defaultValue = new Float(Long.decode((HEX102!=null?HEX102.getText():null)).floatValue());
					                    else if (field instanceof Field.Double) 
					                        field.defaultValue = new Double(Long.decode((HEX102!=null?HEX102.getText():null)).doubleValue());
					                    else if (field.getClass().getSimpleName().endsWith("64")) {
					                        field.defaultValue = Long.valueOf(validate(proto, field, TextFormat.parseLong(proto, field, (HEX102!=null?HEX102.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    } else {
					                        field.defaultValue = Integer.valueOf(validate(proto, field, TextFormat.parseInt(proto, field, (HEX102!=null?HEX102.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    }
					                }
					                else if (field instanceof Field.Bytes) {
					                    field.defaultValue = getBytesFromHexString(proto, (HEX102!=null?HEX102.getText():null));
					                }
					                else
					                    throw err(proto, "Invalid numeric default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
					                
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Long.valueOf(TextFormat.parseLong(proto, field, (HEX102!=null?HEX102.getText():null), true)));
					            }
					        }
					}
					break;
				case 7 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:378:9: OCTAL
					{
					OCTAL103=(Token)match(input,OCTAL,FOLLOW_OCTAL_in_field_options_keyval1879); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OCTAL103_tree = (Object)adaptor.create(OCTAL103);
					adaptor.addChild(root_0, OCTAL103_tree);
					}

					if ( state.backtracking==0 ) {
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");
					                
					                if (field instanceof Field.Number) {
					                    if (field instanceof Field.Float)
					                        field.defaultValue = new Float(Long.decode((OCTAL103!=null?OCTAL103.getText():null)).floatValue());
					                    else if (field instanceof Field.Double) 
					                        field.defaultValue = new Double(Long.decode((OCTAL103!=null?OCTAL103.getText():null)).doubleValue());
					                    else if (field.getClass().getSimpleName().endsWith("64")) {
					                        field.defaultValue = Long.valueOf(validate(proto, field, TextFormat.parseLong(proto, field, (OCTAL103!=null?OCTAL103.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    } else {
					                        field.defaultValue = Integer.valueOf(validate(proto, field, TextFormat.parseInt(proto, field, (OCTAL103!=null?OCTAL103.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    }
					                }
					                else
					                    throw err(proto, "Invalid numeric default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
					                
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Integer.valueOf(TextFormat.parseInt(proto, field, (OCTAL103!=null?OCTAL103.getText():null), true)));
					            }
					        }
					}
					break;
				case 8 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:404:9: TRUE
					{
					TRUE104=(Token)match(input,TRUE,FOLLOW_TRUE_in_field_options_keyval1891); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE104_tree = (Object)adaptor.create(TRUE104);
					adaptor.addChild(root_0, TRUE104_tree);
					}

					if ( state.backtracking==0 ) {
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");
					                
					                if (field instanceof Field.Bool)
					                    field.defaultValue = Boolean.TRUE;
					                else
					                    throw err(proto, "invalid boolean default value for the non-boolean field: " + field.getClass().getSimpleName() + " " + field.name);
					            }
					            
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Boolean.TRUE);
					        }
					}
					break;
				case 9 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:417:9: FALSE
					{
					FALSE105=(Token)match(input,FALSE,FOLLOW_FALSE_in_field_options_keyval1907); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE105_tree = (Object)adaptor.create(FALSE105);
					adaptor.addChild(root_0, FALSE105_tree);
					}

					if ( state.backtracking==0 ) {
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");
					                
					                if (field instanceof Field.Bool)
					                    field.defaultValue = Boolean.FALSE;
					                else
					                    throw err(proto, "invalid boolean default value for the non-boolean field: " + field.getClass().getSimpleName() + " " + field.name);
					            }
					            
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Boolean.FALSE);
					        }
					}
					break;
				case 10 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:430:9: val= ID
					{
					val=(Token)match(input,ID,FOLLOW_ID_in_field_options_keyval1921); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					val_tree = (Object)adaptor.create(val);
					adaptor.addChild(root_0, val_tree);
					}

					if ( state.backtracking==0 ) {
					            boolean refOption = false;
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");
					                
					                String refName = (val!=null?val.getText():null);
					                if (field instanceof Field.Reference)
					                    field.defaultValue = refName;
					                else if (field instanceof Field.Float) {
					                    if ("inf".equals(refName)) {
					                        field.defaultValue = Float.POSITIVE_INFINITY;
					                        field.defaultValueConstant = "Float.POSITIVE_INFINITY";
					                    }
					                    else if ("nan".equals(refName)) {
					                        field.defaultValue = Float.NaN;
					                        field.defaultValueConstant = "Float.NaN";
					                    }
					                    else
					                        throw err(proto, "Invalid float default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
					                }
					                else if (field instanceof Field.Double) {
					                    if ("inf".equals(refName)) {
					                        field.defaultValue = Double.POSITIVE_INFINITY;
					                        field.defaultValueConstant = "Double.POSITIVE_INFINITY";
					                    }
					                    else if ("nan".equals(refName)) {
					                        field.defaultValue = Double.NaN;
					                        field.defaultValueConstant = "Double.NaN";
					                    }
					                    else
					                        throw err(proto, "Invalid double default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
					                }   
					                else {
					                    refOption = true;
					                    //throw err(proto, "invalid field value '" + refName + "' for the field: " + field.getClass().getSimpleName() + " " + field.name);
					                }
					            }
					            else {
					                refOption = true;
					            }
					            
					            if (refOption)
					                field.putStandardOption((key!=null?input.toString(key.start,key.stop):null), (val!=null?val.getText():null));
					            else
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (val!=null?val.getText():null));
					        }
					}
					break;
				case 11 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:477:9: FULL_ID
					{
					FULL_ID106=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_field_options_keyval1933); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID106_tree = (Object)adaptor.create(FULL_ID106);
					adaptor.addChild(root_0, FULL_ID106_tree);
					}

					if ( state.backtracking==0 ) {
					            field.putStandardOption((key!=null?input.toString(key.start,key.stop):null), (FULL_ID106!=null?FULL_ID106.getText():null));
					        }
					}
					break;
				case 12 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:480:9: EXP
					{
					EXP107=(Token)match(input,EXP,FOLLOW_EXP_in_field_options_keyval1945); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EXP107_tree = (Object)adaptor.create(EXP107);
					adaptor.addChild(root_0, EXP107_tree);
					}

					if ( state.backtracking==0 ) {
					            if (checkDefault && "default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(proto, "a field can only have a single default value");
					                
					                if (field instanceof Field.Float)
					                    field.defaultValue = Float.valueOf((EXP107!=null?EXP107.getText():null));
					                else if (field instanceof Field.Double) 
					                    field.defaultValue = Double.valueOf((EXP107!=null?EXP107.getText():null));
					                else
					                    throw err(proto, "Invalid float default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
					            }
					            
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (EXP107!=null?EXP107.getText():null));
					        }
					}
					break;
				case 13 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:495:9: signed_constant[proto, message, field, $key.text, checkDefault]
					{
					pushFollow(FOLLOW_signed_constant_in_field_options_keyval1957);
					signed_constant108=signed_constant(proto, message, field, (key!=null?input.toString(key.start,key.stop):null), checkDefault);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_constant108.getTree());

					if ( state.backtracking==0 ) {
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (signed_constant108!=null?input.toString(signed_constant108.start,signed_constant108.stop):null));
					        }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "field_options_keyval"


	public static class signed_constant_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "signed_constant"
	// io/protostuff/fbsgen/parser/ProtoParser.g:501:1: signed_constant[Proto proto, HasFields message, Field field, String key, boolean checkDefault] : MINUS ID ;
	public final ProtoParser.signed_constant_return signed_constant(Proto proto, HasFields message, Field field, String key, boolean checkDefault) throws RecognitionException {
		ProtoParser.signed_constant_return retval = new ProtoParser.signed_constant_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MINUS109=null;
		Token ID110=null;

		Object MINUS109_tree=null;
		Object ID110_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:502:5: ( MINUS ID )
			// io/protostuff/fbsgen/parser/ProtoParser.g:502:9: MINUS ID
			{
			root_0 = (Object)adaptor.nil();


			MINUS109=(Token)match(input,MINUS,FOLLOW_MINUS_in_signed_constant1995); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MINUS109_tree = (Object)adaptor.create(MINUS109);
			adaptor.addChild(root_0, MINUS109_tree);
			}

			ID110=(Token)match(input,ID,FOLLOW_ID_in_signed_constant1997); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID110_tree = (Object)adaptor.create(ID110);
			adaptor.addChild(root_0, ID110_tree);
			}

			if ( state.backtracking==0 ) {
			            if (checkDefault && "default".equals(key)) {
			                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
			                    throw err(proto, "a field can only have a single default value");
			                
			                String refName = (ID110!=null?ID110.getText():null);
			                if (field instanceof Field.Float) {
			                    if ("inf".equals(refName)) {
			                        field.defaultValue = Float.NEGATIVE_INFINITY;
			                        field.defaultValueConstant = "Float.NEGATIVE_INFINITY";
			                    }
			                    else
			                        throw err(proto, "Invalid float default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
			                }
			                else if (field instanceof Field.Double) {
			                    if ("inf".equals(refName)) {
			                        field.defaultValue = Double.NEGATIVE_INFINITY;
			                        field.defaultValueConstant = "Double.NEGATIVE_INFINITY";
			                    }
			                    else
			                        throw err(proto, "Invalid double default value for the field: " + field.getClass().getSimpleName() + " " + field.name);
			                }   
			                else
			                    throw err(proto, "invalid field value '" + refName + "' for the field: " + field.getClass().getSimpleName() + " " + field.name);
			            }
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "signed_constant"


	public static class enum_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "enum_block"
	// io/protostuff/fbsgen/parser/ProtoParser.g:530:1: enum_block[Proto proto, Message message] : ENUM ID LEFTCURLY ( enum_body[proto, message, enumGroup] )* RIGHTCURLY ( ( SEMICOLON )? ) !;
	public final ProtoParser.enum_block_return enum_block(Proto proto, Message message) throws RecognitionException {
		ProtoParser.enum_block_return retval = new ProtoParser.enum_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ENUM111=null;
		Token ID112=null;
		Token LEFTCURLY113=null;
		Token RIGHTCURLY115=null;
		Token SEMICOLON116=null;
		ParserRuleReturnScope enum_body114 =null;

		Object ENUM111_tree=null;
		Object ID112_tree=null;
		Object LEFTCURLY113_tree=null;
		Object RIGHTCURLY115_tree=null;
		Object SEMICOLON116_tree=null;


		    EnumGroup enumGroup = null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:534:5: ( ENUM ID LEFTCURLY ( enum_body[proto, message, enumGroup] )* RIGHTCURLY ( ( SEMICOLON )? ) !)
			// io/protostuff/fbsgen/parser/ProtoParser.g:534:9: ENUM ID LEFTCURLY ( enum_body[proto, message, enumGroup] )* RIGHTCURLY ( ( SEMICOLON )? ) !
			{
			root_0 = (Object)adaptor.nil();


			ENUM111=(Token)match(input,ENUM,FOLLOW_ENUM_in_enum_block2029); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ENUM111_tree = (Object)adaptor.create(ENUM111);
			adaptor.addChild(root_0, ENUM111_tree);
			}

			ID112=(Token)match(input,ID,FOLLOW_ID_in_enum_block2031); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID112_tree = (Object)adaptor.create(ID112);
			adaptor.addChild(root_0, ID112_tree);
			}

			if ( state.backtracking==0 ) { 
			            enumGroup = new EnumGroup((ID112!=null?ID112.getText():null), message, proto);
			            proto.addAnnotationsTo(enumGroup);
			        }
			LEFTCURLY113=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_enum_block2044); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY113_tree = (Object)adaptor.create(LEFTCURLY113);
			adaptor.addChild(root_0, LEFTCURLY113_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:538:19: ( enum_body[proto, message, enumGroup] )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==AT||LA20_0==DOC_COMMENT||LA20_0==ID||LA20_0==OPTION) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:538:20: enum_body[proto, message, enumGroup]
					{
					pushFollow(FOLLOW_enum_body_in_enum_block2047);
					enum_body114=enum_body(proto, message, enumGroup);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_body114.getTree());

					}
					break;

				default :
					break loop20;
				}
			}

			RIGHTCURLY115=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_enum_block2052); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY115_tree = (Object)adaptor.create(RIGHTCURLY115);
			adaptor.addChild(root_0, RIGHTCURLY115_tree);
			}

			if ( state.backtracking==0 ) {
			            proto.checkAnnotations();
			        }
			// io/protostuff/fbsgen/parser/ProtoParser.g:540:11: ( ( SEMICOLON )? )
			// io/protostuff/fbsgen/parser/ProtoParser.g:540:12: ( SEMICOLON )?
			{
			// io/protostuff/fbsgen/parser/ProtoParser.g:540:12: ( SEMICOLON )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==SEMICOLON) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:540:12: SEMICOLON
					{
					SEMICOLON116=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_enum_block2057); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMICOLON116_tree = (Object)adaptor.create(SEMICOLON116);
					adaptor.addChild(root_0, SEMICOLON116_tree);
					}

					}
					break;

			}

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "enum_block"


	public static class enum_body_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "enum_body"
	// io/protostuff/fbsgen/parser/ProtoParser.g:543:1: enum_body[Proto proto, Message message, EnumGroup enumGroup] : ( enum_field[proto, message, enumGroup] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, enumGroup] );
	public final ProtoParser.enum_body_return enum_body(Proto proto, Message message, EnumGroup enumGroup) throws RecognitionException {
		ProtoParser.enum_body_return retval = new ProtoParser.enum_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope enum_field117 =null;
		ParserRuleReturnScope annotation_entry118 =null;
		ParserRuleReturnScope comment_entry119 =null;
		ParserRuleReturnScope option_entry120 =null;


		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:544:5: ( enum_field[proto, message, enumGroup] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, enumGroup] )
			int alt22=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt22=1;
				}
				break;
			case AT:
				{
				alt22=2;
				}
				break;
			case DOC_COMMENT:
				{
				alt22=3;
				}
				break;
			case OPTION:
				{
				alt22=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:544:9: enum_field[proto, message, enumGroup]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_enum_field_in_enum_body2085);
					enum_field117=enum_field(proto, message, enumGroup);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_field117.getTree());

					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:545:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_enum_body2096);
					annotation_entry118=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry118.getTree());

					}
					break;
				case 3 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:546:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_enum_body2107);
					comment_entry119=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry119.getTree());

					}
					break;
				case 4 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:547:9: option_entry[proto, enumGroup]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_enum_body2118);
					option_entry120=option_entry(proto, enumGroup);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry120.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "enum_body"


	public static class enum_field_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "enum_field"
	// io/protostuff/fbsgen/parser/ProtoParser.g:550:1: enum_field[Proto proto, Message message, EnumGroup enumGroup] : ID ASSIGN NUMINT ( enum_options[proto, enumGroup, v] )? SEMICOLON !;
	public final ProtoParser.enum_field_return enum_field(Proto proto, Message message, EnumGroup enumGroup) throws RecognitionException {
		ProtoParser.enum_field_return retval = new ProtoParser.enum_field_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID121=null;
		Token ASSIGN122=null;
		Token NUMINT123=null;
		Token SEMICOLON125=null;
		ParserRuleReturnScope enum_options124 =null;

		Object ID121_tree=null;
		Object ASSIGN122_tree=null;
		Object NUMINT123_tree=null;
		Object SEMICOLON125_tree=null;


		    EnumGroup.Value v = null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:554:5: ( ID ASSIGN NUMINT ( enum_options[proto, enumGroup, v] )? SEMICOLON !)
			// io/protostuff/fbsgen/parser/ProtoParser.g:554:9: ID ASSIGN NUMINT ( enum_options[proto, enumGroup, v] )? SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			ID121=(Token)match(input,ID,FOLLOW_ID_in_enum_field2145); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID121_tree = (Object)adaptor.create(ID121);
			adaptor.addChild(root_0, ID121_tree);
			}

			ASSIGN122=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_enum_field2147); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN122_tree = (Object)adaptor.create(ASSIGN122);
			adaptor.addChild(root_0, ASSIGN122_tree);
			}

			NUMINT123=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_enum_field2149); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NUMINT123_tree = (Object)adaptor.create(NUMINT123);
			adaptor.addChild(root_0, NUMINT123_tree);
			}

			if ( state.backtracking==0 ) {
			            v = new EnumGroup.Value((ID121!=null?ID121.getText():null), Integer.parseInt((NUMINT123!=null?NUMINT123.getText():null)), enumGroup);
			            proto.addAnnotationsTo(v);
			        }
			// io/protostuff/fbsgen/parser/ProtoParser.g:557:11: ( enum_options[proto, enumGroup, v] )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==LEFTSQUARE) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:557:12: enum_options[proto, enumGroup, v]
					{
					pushFollow(FOLLOW_enum_options_in_enum_field2154);
					enum_options124=enum_options(proto, enumGroup, v);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_options124.getTree());

					}
					break;

			}

			SEMICOLON125=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_enum_field2159); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "enum_field"


	public static class enum_options_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "enum_options"
	// io/protostuff/fbsgen/parser/ProtoParser.g:560:1: enum_options[Proto proto, EnumGroup enumGroup, EnumGroup.Value v] : LEFTSQUARE field_options_keyval[proto, null, v.field, false] ( COMMA field_options_keyval[proto, null, v.field, false] )* RIGHTSQUARE ;
	public final ProtoParser.enum_options_return enum_options(Proto proto, EnumGroup enumGroup, EnumGroup.Value v) throws RecognitionException {
		ProtoParser.enum_options_return retval = new ProtoParser.enum_options_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTSQUARE126=null;
		Token COMMA128=null;
		Token RIGHTSQUARE130=null;
		ParserRuleReturnScope field_options_keyval127 =null;
		ParserRuleReturnScope field_options_keyval129 =null;

		Object LEFTSQUARE126_tree=null;
		Object COMMA128_tree=null;
		Object RIGHTSQUARE130_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:561:5: ( LEFTSQUARE field_options_keyval[proto, null, v.field, false] ( COMMA field_options_keyval[proto, null, v.field, false] )* RIGHTSQUARE )
			// io/protostuff/fbsgen/parser/ProtoParser.g:561:9: LEFTSQUARE field_options_keyval[proto, null, v.field, false] ( COMMA field_options_keyval[proto, null, v.field, false] )* RIGHTSQUARE
			{
			root_0 = (Object)adaptor.nil();


			LEFTSQUARE126=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_enum_options2182); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTSQUARE126_tree = (Object)adaptor.create(LEFTSQUARE126);
			adaptor.addChild(root_0, LEFTSQUARE126_tree);
			}

			pushFollow(FOLLOW_field_options_keyval_in_enum_options2184);
			field_options_keyval127=field_options_keyval(proto, null, v.field, false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval127.getTree());

			// io/protostuff/fbsgen/parser/ProtoParser.g:562:9: ( COMMA field_options_keyval[proto, null, v.field, false] )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==COMMA) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:562:10: COMMA field_options_keyval[proto, null, v.field, false]
					{
					COMMA128=(Token)match(input,COMMA,FOLLOW_COMMA_in_enum_options2197); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA128_tree = (Object)adaptor.create(COMMA128);
					adaptor.addChild(root_0, COMMA128_tree);
					}

					pushFollow(FOLLOW_field_options_keyval_in_enum_options2199);
					field_options_keyval129=field_options_keyval(proto, null, v.field, false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval129.getTree());

					}
					break;

				default :
					break loop24;
				}
			}

			RIGHTSQUARE130=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_enum_options2204); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTSQUARE130_tree = (Object)adaptor.create(RIGHTSQUARE130);
			adaptor.addChild(root_0, RIGHTSQUARE130_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "enum_options"


	public static class service_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "service_block"
	// io/protostuff/fbsgen/parser/ProtoParser.g:565:1: service_block[Proto proto, Message message] : SERVICE ID LEFTCURLY ( service_body[proto, service] )+ RIGHTCURLY ( ( SEMICOLON )? ) !;
	public final ProtoParser.service_block_return service_block(Proto proto, Message message) throws RecognitionException {
		ProtoParser.service_block_return retval = new ProtoParser.service_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SERVICE131=null;
		Token ID132=null;
		Token LEFTCURLY133=null;
		Token RIGHTCURLY135=null;
		Token SEMICOLON136=null;
		ParserRuleReturnScope service_body134 =null;

		Object SERVICE131_tree=null;
		Object ID132_tree=null;
		Object LEFTCURLY133_tree=null;
		Object RIGHTCURLY135_tree=null;
		Object SEMICOLON136_tree=null;


		    Service service = null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:569:5: ( SERVICE ID LEFTCURLY ( service_body[proto, service] )+ RIGHTCURLY ( ( SEMICOLON )? ) !)
			// io/protostuff/fbsgen/parser/ProtoParser.g:569:9: SERVICE ID LEFTCURLY ( service_body[proto, service] )+ RIGHTCURLY ( ( SEMICOLON )? ) !
			{
			root_0 = (Object)adaptor.nil();


			SERVICE131=(Token)match(input,SERVICE,FOLLOW_SERVICE_in_service_block2234); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SERVICE131_tree = (Object)adaptor.create(SERVICE131);
			adaptor.addChild(root_0, SERVICE131_tree);
			}

			ID132=(Token)match(input,ID,FOLLOW_ID_in_service_block2236); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID132_tree = (Object)adaptor.create(ID132);
			adaptor.addChild(root_0, ID132_tree);
			}

			if ( state.backtracking==0 ) { 
			            service = new Service((ID132!=null?ID132.getText():null), message, proto); 
			            proto.addAnnotationsTo(service);
			        }
			LEFTCURLY133=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_service_block2240); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY133_tree = (Object)adaptor.create(LEFTCURLY133);
			adaptor.addChild(root_0, LEFTCURLY133_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:573:9: ( service_body[proto, service] )+
			int cnt25=0;
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==AT||LA25_0==DOC_COMMENT||LA25_0==OPTION||LA25_0==RPC) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:573:10: service_body[proto, service]
					{
					pushFollow(FOLLOW_service_body_in_service_block2251);
					service_body134=service_body(proto, service);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, service_body134.getTree());

					}
					break;

				default :
					if ( cnt25 >= 1 ) break loop25;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(25, input);
					throw eee;
				}
				cnt25++;
			}

			RIGHTCURLY135=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_service_block2256); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY135_tree = (Object)adaptor.create(RIGHTCURLY135);
			adaptor.addChild(root_0, RIGHTCURLY135_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:573:52: ( ( SEMICOLON )? )
			// io/protostuff/fbsgen/parser/ProtoParser.g:573:53: ( SEMICOLON )?
			{
			// io/protostuff/fbsgen/parser/ProtoParser.g:573:53: ( SEMICOLON )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==SEMICOLON) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:573:53: SEMICOLON
					{
					SEMICOLON136=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_service_block2259); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMICOLON136_tree = (Object)adaptor.create(SEMICOLON136);
					adaptor.addChild(root_0, SEMICOLON136_tree);
					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
			            if (service.rpcMethods.isEmpty())
			                throw err(proto, "Empty Service block: " + service.getName());
			                
			            proto.checkAnnotations();
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "service_block"


	public static class service_body_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "service_body"
	// io/protostuff/fbsgen/parser/ProtoParser.g:581:1: service_body[Proto proto, Service service] : ( rpc_block[proto, service] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, service] );
	public final ProtoParser.service_body_return service_body(Proto proto, Service service) throws RecognitionException {
		ProtoParser.service_body_return retval = new ProtoParser.service_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope rpc_block137 =null;
		ParserRuleReturnScope annotation_entry138 =null;
		ParserRuleReturnScope comment_entry139 =null;
		ParserRuleReturnScope option_entry140 =null;


		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:582:5: ( rpc_block[proto, service] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, service] )
			int alt27=4;
			switch ( input.LA(1) ) {
			case RPC:
				{
				alt27=1;
				}
				break;
			case AT:
				{
				alt27=2;
				}
				break;
			case DOC_COMMENT:
				{
				alt27=3;
				}
				break;
			case OPTION:
				{
				alt27=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}
			switch (alt27) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:582:9: rpc_block[proto, service]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_rpc_block_in_service_body2289);
					rpc_block137=rpc_block(proto, service);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rpc_block137.getTree());

					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:583:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_service_body2300);
					annotation_entry138=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry138.getTree());

					}
					break;
				case 3 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:584:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_service_body2311);
					comment_entry139=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry139.getTree());

					}
					break;
				case 4 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:585:9: option_entry[proto, service]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_service_body2322);
					option_entry140=option_entry(proto, service);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry140.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "service_body"


	public static class rpc_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rpc_block"
	// io/protostuff/fbsgen/parser/ProtoParser.g:588:1: rpc_block[Proto proto, Service service] : RPC n= ID LEFTPAREN (ap= FULL_ID |a= ( VOID | ID ) ) RIGHTPAREN RETURNS LEFTPAREN (rp= FULL_ID |r= ( VOID | ID ) ) RIGHTPAREN ( rpc_body_block[proto, rm] )? SEMICOLON !;
	public final ProtoParser.rpc_block_return rpc_block(Proto proto, Service service) throws RecognitionException {
		ProtoParser.rpc_block_return retval = new ProtoParser.rpc_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;
		Token ap=null;
		Token a=null;
		Token rp=null;
		Token r=null;
		Token RPC141=null;
		Token LEFTPAREN142=null;
		Token RIGHTPAREN143=null;
		Token RETURNS144=null;
		Token LEFTPAREN145=null;
		Token RIGHTPAREN146=null;
		Token SEMICOLON148=null;
		ParserRuleReturnScope rpc_body_block147 =null;

		Object n_tree=null;
		Object ap_tree=null;
		Object a_tree=null;
		Object rp_tree=null;
		Object r_tree=null;
		Object RPC141_tree=null;
		Object LEFTPAREN142_tree=null;
		Object RIGHTPAREN143_tree=null;
		Object RETURNS144_tree=null;
		Object LEFTPAREN145_tree=null;
		Object RIGHTPAREN146_tree=null;
		Object SEMICOLON148_tree=null;


		    String argName = null, argPackage = null, retName = null, retPackage = null;
		    Service.RpcMethod rm = null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:593:5: ( RPC n= ID LEFTPAREN (ap= FULL_ID |a= ( VOID | ID ) ) RIGHTPAREN RETURNS LEFTPAREN (rp= FULL_ID |r= ( VOID | ID ) ) RIGHTPAREN ( rpc_body_block[proto, rm] )? SEMICOLON !)
			// io/protostuff/fbsgen/parser/ProtoParser.g:593:9: RPC n= ID LEFTPAREN (ap= FULL_ID |a= ( VOID | ID ) ) RIGHTPAREN RETURNS LEFTPAREN (rp= FULL_ID |r= ( VOID | ID ) ) RIGHTPAREN ( rpc_body_block[proto, rm] )? SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			RPC141=(Token)match(input,RPC,FOLLOW_RPC_in_rpc_block2353); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPC141_tree = (Object)adaptor.create(RPC141);
			adaptor.addChild(root_0, RPC141_tree);
			}

			n=(Token)match(input,ID,FOLLOW_ID_in_rpc_block2357); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			n_tree = (Object)adaptor.create(n);
			adaptor.addChild(root_0, n_tree);
			}

			LEFTPAREN142=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_rpc_block2359); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTPAREN142_tree = (Object)adaptor.create(LEFTPAREN142);
			adaptor.addChild(root_0, LEFTPAREN142_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:593:28: (ap= FULL_ID |a= ( VOID | ID ) )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==FULL_ID) ) {
				alt28=1;
			}
			else if ( (LA28_0==ID||LA28_0==VOID) ) {
				alt28=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:593:29: ap= FULL_ID
					{
					ap=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_rpc_block2364); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ap_tree = (Object)adaptor.create(ap);
					adaptor.addChild(root_0, ap_tree);
					}

					if ( state.backtracking==0 ) {  
					            String argFull = (ap!=null?ap.getText():null);
					            int lastDot = argFull.lastIndexOf('.');
					            argPackage = argFull.substring(0, lastDot); 
					            argName = argFull.substring(lastDot+1);
					        }
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:598:13: a= ( VOID | ID )
					{
					a=input.LT(1);
					if ( input.LA(1)==ID||input.LA(1)==VOID ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(a));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					if ( state.backtracking==0 ) { argName = (a!=null?a.getText():null); }
					}
					break;

			}

			RIGHTPAREN143=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_rpc_block2381); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTPAREN143_tree = (Object)adaptor.create(RIGHTPAREN143);
			adaptor.addChild(root_0, RIGHTPAREN143_tree);
			}

			RETURNS144=(Token)match(input,RETURNS,FOLLOW_RETURNS_in_rpc_block2392); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RETURNS144_tree = (Object)adaptor.create(RETURNS144);
			adaptor.addChild(root_0, RETURNS144_tree);
			}

			LEFTPAREN145=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_rpc_block2394); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTPAREN145_tree = (Object)adaptor.create(LEFTPAREN145);
			adaptor.addChild(root_0, LEFTPAREN145_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:599:27: (rp= FULL_ID |r= ( VOID | ID ) )
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==FULL_ID) ) {
				alt29=1;
			}
			else if ( (LA29_0==ID||LA29_0==VOID) ) {
				alt29=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:599:28: rp= FULL_ID
					{
					rp=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_rpc_block2399); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					rp_tree = (Object)adaptor.create(rp);
					adaptor.addChild(root_0, rp_tree);
					}

					if ( state.backtracking==0 ) {  
					            String retFull = (rp!=null?rp.getText():null);
					            int lastDot = retFull.lastIndexOf('.');
					            retPackage = retFull.substring(0, lastDot); 
					            retName = retFull.substring(lastDot+1);
					        }
					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:604:13: r= ( VOID | ID )
					{
					r=input.LT(1);
					if ( input.LA(1)==ID||input.LA(1)==VOID ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(r));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					if ( state.backtracking==0 ) { retName = (r!=null?r.getText():null); }
					}
					break;

			}

			RIGHTPAREN146=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_rpc_block2416); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTPAREN146_tree = (Object)adaptor.create(RIGHTPAREN146);
			adaptor.addChild(root_0, RIGHTPAREN146_tree);
			}

			if ( state.backtracking==0 ) {
			            rm = service.addRpcMethod((n!=null?n.getText():null), argName, argPackage, retName, retPackage);
			            proto.addAnnotationsTo(rm);
			        }
			// io/protostuff/fbsgen/parser/ProtoParser.g:607:11: ( rpc_body_block[proto, rm] )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==LEFTCURLY) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:607:11: rpc_body_block[proto, rm]
					{
					pushFollow(FOLLOW_rpc_body_block_in_rpc_block2420);
					rpc_body_block147=rpc_body_block(proto, rm);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rpc_body_block147.getTree());

					}
					break;

			}

			SEMICOLON148=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_rpc_block2424); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rpc_block"


	public static class rpc_body_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rpc_body_block"
	// io/protostuff/fbsgen/parser/ProtoParser.g:610:1: rpc_body_block[Proto proto, Service.RpcMethod rm] : LEFTCURLY ( option_entry[proto, rm] )* RIGHTCURLY ;
	public final ProtoParser.rpc_body_block_return rpc_body_block(Proto proto, Service.RpcMethod rm) throws RecognitionException {
		ProtoParser.rpc_body_block_return retval = new ProtoParser.rpc_body_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTCURLY149=null;
		Token RIGHTCURLY151=null;
		ParserRuleReturnScope option_entry150 =null;

		Object LEFTCURLY149_tree=null;
		Object RIGHTCURLY151_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:611:5: ( LEFTCURLY ( option_entry[proto, rm] )* RIGHTCURLY )
			// io/protostuff/fbsgen/parser/ProtoParser.g:611:9: LEFTCURLY ( option_entry[proto, rm] )* RIGHTCURLY
			{
			root_0 = (Object)adaptor.nil();


			LEFTCURLY149=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_rpc_body_block2450); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY149_tree = (Object)adaptor.create(LEFTCURLY149);
			adaptor.addChild(root_0, LEFTCURLY149_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:611:19: ( option_entry[proto, rm] )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==OPTION) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:611:19: option_entry[proto, rm]
					{
					pushFollow(FOLLOW_option_entry_in_rpc_body_block2452);
					option_entry150=option_entry(proto, rm);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry150.getTree());

					}
					break;

				default :
					break loop31;
				}
			}

			RIGHTCURLY151=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_rpc_body_block2456); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY151_tree = (Object)adaptor.create(RIGHTCURLY151);
			adaptor.addChild(root_0, RIGHTCURLY151_tree);
			}

			if ( state.backtracking==0 ) {
			            proto.checkAnnotations();
			        }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rpc_body_block"


	public static class ignore_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ignore_block"
	// io/protostuff/fbsgen/parser/ProtoParser.g:647:1: ignore_block : LEFTCURLY ( ignore_block_body )* RIGHTCURLY ;
	public final ProtoParser.ignore_block_return ignore_block() throws RecognitionException {
		ProtoParser.ignore_block_return retval = new ProtoParser.ignore_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTCURLY152=null;
		Token RIGHTCURLY154=null;
		ParserRuleReturnScope ignore_block_body153 =null;

		Object LEFTCURLY152_tree=null;
		Object RIGHTCURLY154_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:648:5: ( LEFTCURLY ( ignore_block_body )* RIGHTCURLY )
			// io/protostuff/fbsgen/parser/ProtoParser.g:648:9: LEFTCURLY ( ignore_block_body )* RIGHTCURLY
			{
			root_0 = (Object)adaptor.nil();


			LEFTCURLY152=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_ignore_block2520); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY152_tree = (Object)adaptor.create(LEFTCURLY152);
			adaptor.addChild(root_0, LEFTCURLY152_tree);
			}

			// io/protostuff/fbsgen/parser/ProtoParser.g:648:19: ( ignore_block_body )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( ((LA32_0 >= ASSIGN && LA32_0 <= RETURNS)||(LA32_0 >= RIGHTPAREN && LA32_0 <= WS)) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:648:19: ignore_block_body
					{
					pushFollow(FOLLOW_ignore_block_body_in_ignore_block2522);
					ignore_block_body153=ignore_block_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_block_body153.getTree());

					}
					break;

				default :
					break loop32;
				}
			}

			RIGHTCURLY154=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_ignore_block2525); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY154_tree = (Object)adaptor.create(RIGHTCURLY154);
			adaptor.addChild(root_0, RIGHTCURLY154_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ignore_block"


	public static class ignore_block_body_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ignore_block_body"
	// io/protostuff/fbsgen/parser/ProtoParser.g:651:1: ignore_block_body : ( ( LEFTCURLY )=> ignore_block |~ RIGHTCURLY );
	public final ProtoParser.ignore_block_body_return ignore_block_body() throws RecognitionException {
		ProtoParser.ignore_block_body_return retval = new ProtoParser.ignore_block_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set156=null;
		ParserRuleReturnScope ignore_block155 =null;

		Object set156_tree=null;

		try {
			// io/protostuff/fbsgen/parser/ProtoParser.g:652:5: ( ( LEFTCURLY )=> ignore_block |~ RIGHTCURLY )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==LEFTCURLY) ) {
				int LA33_1 = input.LA(2);
				if ( (synpred1_ProtoParser()) ) {
					alt33=1;
				}
				else if ( (true) ) {
					alt33=2;
				}

			}
			else if ( ((LA33_0 >= ASSIGN && LA33_0 <= INT8)||(LA33_0 >= LEFTPAREN && LA33_0 <= RETURNS)||(LA33_0 >= RIGHTPAREN && LA33_0 <= WS)) ) {
				alt33=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:652:9: ( LEFTCURLY )=> ignore_block
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ignore_block_in_ignore_block_body2553);
					ignore_block155=ignore_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_block155.getTree());

					}
					break;
				case 2 :
					// io/protostuff/fbsgen/parser/ProtoParser.g:653:9: ~ RIGHTCURLY
					{
					root_0 = (Object)adaptor.nil();


					set156=input.LT(1);
					if ( (input.LA(1) >= ASSIGN && input.LA(1) <= RETURNS)||(input.LA(1) >= RIGHTPAREN && input.LA(1) <= WS) ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set156));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ignore_block_body"

	// $ANTLR start synpred1_ProtoParser
	public final void synpred1_ProtoParser_fragment() throws RecognitionException {
		// io/protostuff/fbsgen/parser/ProtoParser.g:652:9: ( LEFTCURLY )
		// io/protostuff/fbsgen/parser/ProtoParser.g:652:10: LEFTCURLY
		{
		match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_synpred1_ProtoParser2549); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_ProtoParser

	// Delegated rules

	public final boolean synpred1_ProtoParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_ProtoParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_statement_in_parse178 = new BitSet(new long[]{0x0024014080402820L});
	public static final BitSet FOLLOW_EOF_in_parse183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_header_syntax_in_statement211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_header_package_in_statement222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_header_import_in_statement233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_message_block_in_statement244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_block_in_statement255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_service_block_in_statement271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_statement282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_statement293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_statement304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_var520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_reserved_in_var524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_var_full543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_in_var_full547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOC_COMMENT_in_comment_entry568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AT_in_annotation_entry596 = new BitSet(new long[]{0x2F6D1DC0C7E234C0L});
	public static final BitSet FOLLOW_var_in_annotation_entry598 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_LEFTPAREN_in_annotation_entry611 = new BitSet(new long[]{0x2F6D1DC0C7E634C0L});
	public static final BitSet FOLLOW_annotation_keyval_in_annotation_entry622 = new BitSet(new long[]{0x0000400000000100L});
	public static final BitSet FOLLOW_COMMA_in_annotation_entry626 = new BitSet(new long[]{0x2F6D1DC0C7E634C0L});
	public static final BitSet FOLLOW_annotation_keyval_in_annotation_entry628 = new BitSet(new long[]{0x0000400000000100L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_annotation_entry642 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_full_in_annotation_keyval669 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_annotation_keyval671 = new BitSet(new long[]{0x2FFD1DCEC7E734C0L});
	public static final BitSet FOLLOW_var_reserved_in_annotation_keyval693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_annotation_keyval713 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_annotation_keyval735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_annotation_keyval755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_annotation_keyval775 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_annotation_keyval795 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_annotation_keyval815 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_annotation_keyval835 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_annotation_keyval855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYNTAX_in_header_syntax888 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_header_syntax890 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_header_syntax892 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_header_syntax894 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PKG_in_header_package923 = new BitSet(new long[]{0x2F6D1DC0C7E634C0L});
	public static final BitSet FOLLOW_FULL_ID_in_header_package926 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_var_in_header_package932 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_header_package937 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_header_import965 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_header_import967 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_header_import969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTION_in_option_entry993 = new BitSet(new long[]{0x2F6D1DC0D7E634C0L});
	public static final BitSet FOLLOW_LEFTPAREN_in_option_entry995 = new BitSet(new long[]{0x2F6D1DC0C7E634C0L});
	public static final BitSet FOLLOW_var_full_in_option_entry1000 = new BitSet(new long[]{0x0000400000000010L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_option_entry1002 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_option_entry1005 = new BitSet(new long[]{0x2FFD1DCEC7E734C0L});
	public static final BitSet FOLLOW_var_reserved_in_option_entry1027 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_ID_in_option_entry1049 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_FULL_ID_in_option_entry1071 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_NUMFLOAT_in_option_entry1091 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_NUMINT_in_option_entry1111 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_option_entry1131 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_TRUE_in_option_entry1151 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_FALSE_in_option_entry1171 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_option_entry1191 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_option_entry1205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MESSAGE_in_message_block1238 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_message_block1240 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_message_block1253 = new BitSet(new long[]{0x00042CC080002820L});
	public static final BitSet FOLLOW_message_body_in_message_block1256 = new BitSet(new long[]{0x00042CC080002820L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_message_block1261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_message_block_in_message_body1284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_message_field_in_message_body1295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_block_in_message_body1306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_service_block_in_message_body1317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_message_body1338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_message_body1349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_message_body1360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_message_field1408 = new BitSet(new long[]{0x0F08000007A610C0L});
	public static final BitSet FOLLOW_REQUIRED_in_message_field1425 = new BitSet(new long[]{0x0F08000007A610C0L});
	public static final BitSet FOLLOW_REPEATED_in_message_field1442 = new BitSet(new long[]{0x0F08000007A610C0L});
	public static final BitSet FOLLOW_field_type_in_message_field1457 = new BitSet(new long[]{0x2F6D1DC0C7E234C0L});
	public static final BitSet FOLLOW_var_in_message_field1469 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_message_field1471 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_NUMINT_in_message_field1473 = new BitSet(new long[]{0x0002000028000000L});
	public static final BitSet FOLLOW_field_options_in_message_field1487 = new BitSet(new long[]{0x0002000008000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_message_field1503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ignore_block_in_message_field1508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_field_type1534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT8_in_field_type1546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT8_in_field_type1558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT16_in_field_type1570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT16_in_field_type1582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT32_in_field_type1594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT32_in_field_type1606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT64_in_field_type1618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT64_in_field_type1630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_field_type1642 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_in_field_type1654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_field_type1666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BYTES_in_field_type1678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_field_type1710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_field_type1722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_field_options1749 = new BitSet(new long[]{0x2F6D1DC0C7E634C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_field_options1751 = new BitSet(new long[]{0x0000800000000100L});
	public static final BitSet FOLLOW_COMMA_in_field_options1764 = new BitSet(new long[]{0x2F6D1DC0C7E634C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_field_options1766 = new BitSet(new long[]{0x0000800000000100L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_field_options1771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_full_in_field_options_keyval1798 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_field_options_keyval1800 = new BitSet(new long[]{0x2FFD1DDFC7EFB4C0L});
	public static final BitSet FOLLOW_var_reserved_in_field_options_keyval1805 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_field_options_keyval1818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_field_options_keyval1830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_field_options_keyval1843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_field_options_keyval1855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HEX_in_field_options_keyval1867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OCTAL_in_field_options_keyval1879 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_field_options_keyval1891 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_field_options_keyval1907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_field_options_keyval1921 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_field_options_keyval1933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXP_in_field_options_keyval1945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_signed_constant_in_field_options_keyval1957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_signed_constant1995 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_signed_constant1997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ENUM_in_enum_block2029 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_enum_block2031 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_enum_block2044 = new BitSet(new long[]{0x0000204000200820L});
	public static final BitSet FOLLOW_enum_body_in_enum_block2047 = new BitSet(new long[]{0x0000204000200820L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_enum_block2052 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_enum_block2057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_field_in_enum_body2085 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_enum_body2096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_enum_body2107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_enum_body2118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_enum_field2145 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_enum_field2147 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_NUMINT_in_enum_field2149 = new BitSet(new long[]{0x0002000020000000L});
	public static final BitSet FOLLOW_enum_options_in_enum_field2154 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_enum_field2159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_enum_options2182 = new BitSet(new long[]{0x2F6D1DC0C7E634C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_enum_options2184 = new BitSet(new long[]{0x0000800000000100L});
	public static final BitSet FOLLOW_COMMA_in_enum_options2197 = new BitSet(new long[]{0x2F6D1DC0C7E634C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_enum_options2199 = new BitSet(new long[]{0x0000800000000100L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_enum_options2204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SERVICE_in_service_block2234 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_service_block2236 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_service_block2240 = new BitSet(new long[]{0x0001004000000820L});
	public static final BitSet FOLLOW_service_body_in_service_block2251 = new BitSet(new long[]{0x0001204000000820L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_service_block2256 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_service_block2259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rpc_block_in_service_body2289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_service_body2300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_service_body2311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_service_body2322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RPC_in_rpc_block2353 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_rpc_block2357 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_rpc_block2359 = new BitSet(new long[]{0x2000000000240000L});
	public static final BitSet FOLLOW_FULL_ID_in_rpc_block2364 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_set_in_rpc_block2372 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_rpc_block2381 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RETURNS_in_rpc_block2392 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_rpc_block2394 = new BitSet(new long[]{0x2000000000240000L});
	public static final BitSet FOLLOW_FULL_ID_in_rpc_block2399 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_set_in_rpc_block2407 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_rpc_block2416 = new BitSet(new long[]{0x0002000008000000L});
	public static final BitSet FOLLOW_rpc_body_block_in_rpc_block2420 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_rpc_block2424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_rpc_body_block2450 = new BitSet(new long[]{0x0000204000000000L});
	public static final BitSet FOLLOW_option_entry_in_rpc_body_block2452 = new BitSet(new long[]{0x0000204000000000L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_rpc_body_block2456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_ignore_block2520 = new BitSet(new long[]{0x7FFFFFFFFFFFFFF0L});
	public static final BitSet FOLLOW_ignore_block_body_in_ignore_block2522 = new BitSet(new long[]{0x7FFFFFFFFFFFFFF0L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_ignore_block2525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ignore_block_in_ignore_block_body2553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_ignore_block_body2563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_synpred1_ProtoParser2549 = new BitSet(new long[]{0x0000000000000002L});
}
