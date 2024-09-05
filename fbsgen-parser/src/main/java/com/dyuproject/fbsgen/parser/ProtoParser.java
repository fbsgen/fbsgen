// $ANTLR 3.5.2 com/dyuproject/fbsgen/parser/ProtoParser.g 2024-09-06 00:05:43

    package com.dyuproject.fbsgen.parser;


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
		"COLON", "COMMA", "COMMENT", "DEFAULT", "DOC_COMMENT", "DOUBLE", "ENUM", 
		"ESC_SEQ", "EXP", "FALSE", "FLOAT", "FULL_ID", "HEX", "HEX_DIGIT", "ID", 
		"IMPORT", "INT16", "INT32", "INT64", "INT8", "LEFTCURLY", "LEFTPAREN", 
		"LEFTSQUARE", "MAX", "MESSAGE", "MINUS", "NUMDOUBLE", "NUMFLOAT", "NUMINT", 
		"OCTAL", "OCTAL_ESC", "OPTION", "OPTIONAL", "PKG", "PLUS", "REPEATED", 
		"REQUIRED", "RETURNS", "RIGHTCURLY", "RIGHTPAREN", "RIGHTSQUARE", "RPC", 
		"SEMICOLON", "SERVICE", "STRING", "STRING_LITERAL", "SYNTAX", "TO", "TRUE", 
		"UINT16", "UINT32", "UINT64", "UINT8", "UNICODE_ESC", "VOID", "WS"
	};
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
	@Override public String getGrammarFileName() { return "com/dyuproject/fbsgen/parser/ProtoParser.g"; }


	public static class parse_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// com/dyuproject/fbsgen/parser/ProtoParser.g:52:1: parse[Proto proto] : ( statement[proto] )+ EOF !;
	public final ProtoParser.parse_return parse(Proto proto) throws RecognitionException {
		ProtoParser.parse_return retval = new ProtoParser.parse_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope statement1 =null;

		Object EOF2_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:53:5: ( ( statement[proto] )+ EOF !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:53:9: ( statement[proto] )+ EOF !
			{
			root_0 = (Object)adaptor.nil();


			// com/dyuproject/fbsgen/parser/ProtoParser.g:53:9: ( statement[proto] )+
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:53:10: statement[proto]
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:59:1: statement[Proto proto] : ( header_syntax[proto] | header_package[proto] | header_import[proto] | message_block[proto, null] | enum_block[proto, null] | service_block[proto, null] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, proto] );
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
			// com/dyuproject/fbsgen/parser/ProtoParser.g:60:5: ( header_syntax[proto] | header_package[proto] | header_import[proto] | message_block[proto, null] | enum_block[proto, null] | service_block[proto, null] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, proto] )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:60:9: header_syntax[proto]
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:61:9: header_package[proto]
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:62:9: header_import[proto]
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:63:9: message_block[proto, null]
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:64:9: enum_block[proto, null]
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:66:9: service_block[proto, null]
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:67:9: annotation_entry[proto]
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:68:9: comment_entry[proto]
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:69:9: option_entry[proto, proto]
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:73:1: var_reserved : ( TO | PKG | SYNTAX | IMPORT | OPTION | MESSAGE | SERVICE | ENUM | REQUIRED | OPTIONAL | REPEATED | RPC | RETURNS | INT8 | INT16 | INT32 | INT64 | UINT8 | UINT16 | UINT32 | UINT64 | FLOAT | DOUBLE | BOOL | STRING | BYTES | DEFAULT | MAX | VOID );
	public final ProtoParser.var_reserved_return var_reserved() throws RecognitionException {
		ProtoParser.var_reserved_return retval = new ProtoParser.var_reserved_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set12=null;

		Object set12_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:74:5: ( TO | PKG | SYNTAX | IMPORT | OPTION | MESSAGE | SERVICE | ENUM | REQUIRED | OPTIONAL | REPEATED | RPC | RETURNS | INT8 | INT16 | INT32 | INT64 | UINT8 | UINT16 | UINT32 | UINT64 | FLOAT | DOUBLE | BOOL | STRING | BYTES | DEFAULT | MAX | VOID )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:84:1: var : ( ID | var_reserved );
	public final ProtoParser.var_return var() throws RecognitionException {
		ProtoParser.var_return retval = new ProtoParser.var_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID13=null;
		ParserRuleReturnScope var_reserved14 =null;

		Object ID13_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:85:5: ( ID | var_reserved )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:85:9: ID
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:85:14: var_reserved
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:88:1: var_full : ( FULL_ID | var );
	public final ProtoParser.var_full_return var_full() throws RecognitionException {
		ProtoParser.var_full_return retval = new ProtoParser.var_full_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FULL_ID15=null;
		ParserRuleReturnScope var16 =null;

		Object FULL_ID15_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:89:5: ( FULL_ID | var )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:89:9: FULL_ID
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:89:19: var
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:92:1: comment_entry[Proto proto] : DOC_COMMENT ;
	public final ProtoParser.comment_entry_return comment_entry(Proto proto) throws RecognitionException {
		ProtoParser.comment_entry_return retval = new ProtoParser.comment_entry_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DOC_COMMENT17=null;

		Object DOC_COMMENT17_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:93:5: ( DOC_COMMENT )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:93:9: DOC_COMMENT
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:96:1: annotation_entry[Proto proto] : AT var ( LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN )? ;
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
			// com/dyuproject/fbsgen/parser/ProtoParser.g:100:5: ( AT var ( LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN )? )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:100:9: AT var ( LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN )?
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

			if ( state.backtracking==0 ) { annotation = new Annotation((var19!=null?input.toString(var19.start,var19.stop):null), proto); }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:101:9: ( LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==LEFTPAREN) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:101:10: LEFTPAREN annotation_keyval[proto, annotation] ( COMMA annotation_keyval[proto, annotation] )* RIGHTPAREN
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

					// com/dyuproject/fbsgen/parser/ProtoParser.g:102:46: ( COMMA annotation_keyval[proto, annotation] )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==COMMA) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:102:47: COMMA annotation_keyval[proto, annotation]
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


	public static class list_val_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "list_val"
	// com/dyuproject/fbsgen/parser/ProtoParser.g:108:1: list_val[Proto proto, List<Object> list] : ( ( LEFTSQUARE list_val[proto, sub] ( COMMA list_val[proto, sub] )* RIGHTSQUARE ) | ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) ;
	public final ProtoParser.list_val_return list_val(Proto proto, List<Object> list) throws RecognitionException {
		ProtoParser.list_val_return retval = new ProtoParser.list_val_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fid=null;
		Token LEFTSQUARE25=null;
		Token COMMA27=null;
		Token RIGHTSQUARE29=null;
		Token LEFTCURLY30=null;
		Token COMMA32=null;
		Token RIGHTCURLY34=null;
		Token ID35=null;
		Token NUMFLOAT36=null;
		Token NUMINT37=null;
		Token NUMDOUBLE38=null;
		Token TRUE39=null;
		Token FALSE40=null;
		Token STRING_LITERAL41=null;
		ParserRuleReturnScope vr =null;
		ParserRuleReturnScope list_val26 =null;
		ParserRuleReturnScope list_val28 =null;
		ParserRuleReturnScope map_val31 =null;
		ParserRuleReturnScope map_val33 =null;

		Object fid_tree=null;
		Object LEFTSQUARE25_tree=null;
		Object COMMA27_tree=null;
		Object RIGHTSQUARE29_tree=null;
		Object LEFTCURLY30_tree=null;
		Object COMMA32_tree=null;
		Object RIGHTCURLY34_tree=null;
		Object ID35_tree=null;
		Object NUMFLOAT36_tree=null;
		Object NUMINT37_tree=null;
		Object NUMDOUBLE38_tree=null;
		Object TRUE39_tree=null;
		Object FALSE40_tree=null;
		Object STRING_LITERAL41_tree=null;


		    List<Object> sub = null;
		    Map<String, Object> map = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:113:5: ( ( ( LEFTSQUARE list_val[proto, sub] ( COMMA list_val[proto, sub] )* RIGHTSQUARE ) | ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:113:9: ( ( LEFTSQUARE list_val[proto, sub] ( COMMA list_val[proto, sub] )* RIGHTSQUARE ) | ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			{
			root_0 = (Object)adaptor.nil();


			// com/dyuproject/fbsgen/parser/ProtoParser.g:113:9: ( ( LEFTSQUARE list_val[proto, sub] ( COMMA list_val[proto, sub] )* RIGHTSQUARE ) | ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			int alt9=11;
			switch ( input.LA(1) ) {
			case LEFTSQUARE:
				{
				alt9=1;
				}
				break;
			case LEFTCURLY:
				{
				alt9=2;
				}
				break;
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
				alt9=3;
				}
				break;
			case ID:
				{
				alt9=4;
				}
				break;
			case FULL_ID:
				{
				alt9=5;
				}
				break;
			case NUMFLOAT:
				{
				alt9=6;
				}
				break;
			case NUMINT:
				{
				alt9=7;
				}
				break;
			case NUMDOUBLE:
				{
				alt9=8;
				}
				break;
			case TRUE:
				{
				alt9=9;
				}
				break;
			case FALSE:
				{
				alt9=10;
				}
				break;
			case STRING_LITERAL:
				{
				alt9=11;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:114:13: ( LEFTSQUARE list_val[proto, sub] ( COMMA list_val[proto, sub] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:114:13: ( LEFTSQUARE list_val[proto, sub] ( COMMA list_val[proto, sub] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:115:17: LEFTSQUARE list_val[proto, sub] ( COMMA list_val[proto, sub] )* RIGHTSQUARE
					{
					LEFTSQUARE25=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_list_val704); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSQUARE25_tree = (Object)adaptor.create(LEFTSQUARE25);
					adaptor.addChild(root_0, LEFTSQUARE25_tree);
					}

					if ( state.backtracking==0 ) {
					                    list.add((sub = new ArrayList<Object>()));
					                }
					pushFollow(FOLLOW_list_val_in_list_val724);
					list_val26=list_val(proto, sub);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val26.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:118:38: ( COMMA list_val[proto, sub] )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==COMMA) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:118:39: COMMA list_val[proto, sub]
							{
							COMMA27=(Token)match(input,COMMA,FOLLOW_COMMA_in_list_val728); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA27_tree = (Object)adaptor.create(COMMA27);
							adaptor.addChild(root_0, COMMA27_tree);
							}

							pushFollow(FOLLOW_list_val_in_list_val730);
							list_val28=list_val(proto, sub);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val28.getTree());

							}
							break;

						default :
							break loop7;
						}
					}

					RIGHTSQUARE29=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_list_val752); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSQUARE29_tree = (Object)adaptor.create(RIGHTSQUARE29);
					adaptor.addChild(root_0, RIGHTSQUARE29_tree);
					}

					}

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:122:13: ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:122:13: ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:123:17: LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY
					{
					LEFTCURLY30=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_list_val812); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTCURLY30_tree = (Object)adaptor.create(LEFTCURLY30);
					adaptor.addChild(root_0, LEFTCURLY30_tree);
					}

					if ( state.backtracking==0 ) {
					                    list.add((map = new java.util.LinkedHashMap<String, Object>()));
					                }
					pushFollow(FOLLOW_map_val_in_list_val832);
					map_val31=map_val(proto, map);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val31.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:126:37: ( COMMA map_val[proto, map] )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( (LA8_0==COMMA) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:126:38: COMMA map_val[proto, map]
							{
							COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_list_val836); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA32_tree = (Object)adaptor.create(COMMA32);
							adaptor.addChild(root_0, COMMA32_tree);
							}

							pushFollow(FOLLOW_map_val_in_list_val838);
							map_val33=map_val(proto, map);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val33.getTree());

							}
							break;

						default :
							break loop8;
						}
					}

					RIGHTCURLY34=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_list_val860); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTCURLY34_tree = (Object)adaptor.create(RIGHTCURLY34);
					adaptor.addChild(root_0, RIGHTCURLY34_tree);
					}

					}

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:129:17: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_list_val894);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) { list.add((vr!=null?input.toString(vr.start,vr.stop):null)); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:130:17: ID
					{
					ID35=(Token)match(input,ID,FOLLOW_ID_in_list_val914); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID35_tree = (Object)adaptor.create(ID35);
					adaptor.addChild(root_0, ID35_tree);
					}

					if ( state.backtracking==0 ) { proto.addRefTo(list, (ID35!=null?ID35.getText():null)); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:131:17: fid= FULL_ID
					{
					fid=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_list_val936); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					fid_tree = (Object)adaptor.create(fid);
					adaptor.addChild(root_0, fid_tree);
					}

					if ( state.backtracking==0 ) { proto.addRefTo(list, (fid!=null?fid.getText():null)); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:132:17: NUMFLOAT
					{
					NUMFLOAT36=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_list_val956); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT36_tree = (Object)adaptor.create(NUMFLOAT36);
					adaptor.addChild(root_0, NUMFLOAT36_tree);
					}

					if ( state.backtracking==0 ) { list.add(Float.valueOf((NUMFLOAT36!=null?NUMFLOAT36.getText():null))); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:133:17: NUMINT
					{
					NUMINT37=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_list_val976); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT37_tree = (Object)adaptor.create(NUMINT37);
					adaptor.addChild(root_0, NUMINT37_tree);
					}

					if ( state.backtracking==0 ) { list.add(parseNumber((NUMINT37!=null?NUMINT37.getText():null))); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:134:17: NUMDOUBLE
					{
					NUMDOUBLE38=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_list_val996); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE38_tree = (Object)adaptor.create(NUMDOUBLE38);
					adaptor.addChild(root_0, NUMDOUBLE38_tree);
					}

					if ( state.backtracking==0 ) { list.add(Double.valueOf((NUMDOUBLE38!=null?NUMDOUBLE38.getText():null))); }
					}
					break;
				case 9 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:135:17: TRUE
					{
					TRUE39=(Token)match(input,TRUE,FOLLOW_TRUE_in_list_val1016); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE39_tree = (Object)adaptor.create(TRUE39);
					adaptor.addChild(root_0, TRUE39_tree);
					}

					if ( state.backtracking==0 ) { list.add(Boolean.TRUE); }
					}
					break;
				case 10 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:136:17: FALSE
					{
					FALSE40=(Token)match(input,FALSE,FOLLOW_FALSE_in_list_val1036); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE40_tree = (Object)adaptor.create(FALSE40);
					adaptor.addChild(root_0, FALSE40_tree);
					}

					if ( state.backtracking==0 ) { list.add(Boolean.FALSE); }
					}
					break;
				case 11 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:137:17: STRING_LITERAL
					{
					STRING_LITERAL41=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_list_val1056); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL41_tree = (Object)adaptor.create(STRING_LITERAL41);
					adaptor.addChild(root_0, STRING_LITERAL41_tree);
					}

					if ( state.backtracking==0 ) { list.add(getStringFromStringLiteral((STRING_LITERAL41!=null?STRING_LITERAL41.getText():null))); }
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
	// $ANTLR end "list_val"


	public static class map_val_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "map_val"
	// com/dyuproject/fbsgen/parser/ProtoParser.g:141:1: map_val[Proto proto, Map<String, Object> map] : k= var_full COLON ( ( LEFTCURLY map_val[proto, sub] ( COMMA map_val[proto, sub] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) ;
	public final ProtoParser.map_val_return map_val(Proto proto, Map<String, Object> map) throws RecognitionException {
		ProtoParser.map_val_return retval = new ProtoParser.map_val_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fid=null;
		Token COLON42=null;
		Token LEFTCURLY43=null;
		Token COMMA45=null;
		Token RIGHTCURLY47=null;
		Token LEFTSQUARE48=null;
		Token COMMA50=null;
		Token RIGHTSQUARE52=null;
		Token ID53=null;
		Token NUMFLOAT54=null;
		Token NUMINT55=null;
		Token NUMDOUBLE56=null;
		Token TRUE57=null;
		Token FALSE58=null;
		Token STRING_LITERAL59=null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope vr =null;
		ParserRuleReturnScope map_val44 =null;
		ParserRuleReturnScope map_val46 =null;
		ParserRuleReturnScope list_val49 =null;
		ParserRuleReturnScope list_val51 =null;

		Object fid_tree=null;
		Object COLON42_tree=null;
		Object LEFTCURLY43_tree=null;
		Object COMMA45_tree=null;
		Object RIGHTCURLY47_tree=null;
		Object LEFTSQUARE48_tree=null;
		Object COMMA50_tree=null;
		Object RIGHTSQUARE52_tree=null;
		Object ID53_tree=null;
		Object NUMFLOAT54_tree=null;
		Object NUMINT55_tree=null;
		Object NUMDOUBLE56_tree=null;
		Object TRUE57_tree=null;
		Object FALSE58_tree=null;
		Object STRING_LITERAL59_tree=null;


		    Map<String, Object> sub = null;
		    List<Object> list = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:146:5: (k= var_full COLON ( ( LEFTCURLY map_val[proto, sub] ( COMMA map_val[proto, sub] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:146:9: k= var_full COLON ( ( LEFTCURLY map_val[proto, sub] ( COMMA map_val[proto, sub] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_var_full_in_map_val1096);
			k=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

			COLON42=(Token)match(input,COLON,FOLLOW_COLON_in_map_val1098); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON42_tree = (Object)adaptor.create(COLON42);
			adaptor.addChild(root_0, COLON42_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:146:26: ( ( LEFTCURLY map_val[proto, sub] ( COMMA map_val[proto, sub] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			int alt12=11;
			switch ( input.LA(1) ) {
			case LEFTCURLY:
				{
				alt12=1;
				}
				break;
			case LEFTSQUARE:
				{
				alt12=2;
				}
				break;
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
				alt12=3;
				}
				break;
			case ID:
				{
				alt12=4;
				}
				break;
			case FULL_ID:
				{
				alt12=5;
				}
				break;
			case NUMFLOAT:
				{
				alt12=6;
				}
				break;
			case NUMINT:
				{
				alt12=7;
				}
				break;
			case NUMDOUBLE:
				{
				alt12=8;
				}
				break;
			case TRUE:
				{
				alt12=9;
				}
				break;
			case FALSE:
				{
				alt12=10;
				}
				break;
			case STRING_LITERAL:
				{
				alt12=11;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:147:13: ( LEFTCURLY map_val[proto, sub] ( COMMA map_val[proto, sub] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:147:13: ( LEFTCURLY map_val[proto, sub] ( COMMA map_val[proto, sub] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:148:17: LEFTCURLY map_val[proto, sub] ( COMMA map_val[proto, sub] )* RIGHTCURLY
					{
					LEFTCURLY43=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_map_val1132); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTCURLY43_tree = (Object)adaptor.create(LEFTCURLY43);
					adaptor.addChild(root_0, LEFTCURLY43_tree);
					}

					if ( state.backtracking==0 ) {
					                    map.put((k!=null?input.toString(k.start,k.stop):null), (sub = new java.util.LinkedHashMap<String, Object>()));
					                }
					pushFollow(FOLLOW_map_val_in_map_val1152);
					map_val44=map_val(proto, sub);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val44.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:151:37: ( COMMA map_val[proto, sub] )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==COMMA) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:151:38: COMMA map_val[proto, sub]
							{
							COMMA45=(Token)match(input,COMMA,FOLLOW_COMMA_in_map_val1156); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA45_tree = (Object)adaptor.create(COMMA45);
							adaptor.addChild(root_0, COMMA45_tree);
							}

							pushFollow(FOLLOW_map_val_in_map_val1158);
							map_val46=map_val(proto, sub);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val46.getTree());

							}
							break;

						default :
							break loop10;
						}
					}

					RIGHTCURLY47=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_map_val1180); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTCURLY47_tree = (Object)adaptor.create(RIGHTCURLY47);
					adaptor.addChild(root_0, RIGHTCURLY47_tree);
					}

					}

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:155:13: ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:155:13: ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:156:17: LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE
					{
					LEFTSQUARE48=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_map_val1240); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSQUARE48_tree = (Object)adaptor.create(LEFTSQUARE48);
					adaptor.addChild(root_0, LEFTSQUARE48_tree);
					}

					if ( state.backtracking==0 ) {
					                    map.put((k!=null?input.toString(k.start,k.stop):null), (list = new ArrayList<Object>()));
					                }
					pushFollow(FOLLOW_list_val_in_map_val1260);
					list_val49=list_val(proto, list);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val49.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:159:39: ( COMMA list_val[proto, list] )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==COMMA) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:159:40: COMMA list_val[proto, list]
							{
							COMMA50=(Token)match(input,COMMA,FOLLOW_COMMA_in_map_val1264); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA50_tree = (Object)adaptor.create(COMMA50);
							adaptor.addChild(root_0, COMMA50_tree);
							}

							pushFollow(FOLLOW_list_val_in_map_val1266);
							list_val51=list_val(proto, list);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val51.getTree());

							}
							break;

						default :
							break loop11;
						}
					}

					RIGHTSQUARE52=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_map_val1288); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSQUARE52_tree = (Object)adaptor.create(RIGHTSQUARE52);
					adaptor.addChild(root_0, RIGHTSQUARE52_tree);
					}

					}

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:162:17: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_map_val1322);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), (vr!=null?input.toString(vr.start,vr.stop):null)); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:163:17: ID
					{
					ID53=(Token)match(input,ID,FOLLOW_ID_in_map_val1342); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID53_tree = (Object)adaptor.create(ID53);
					adaptor.addChild(root_0, ID53_tree);
					}

					if ( state.backtracking==0 ) { proto.putRefTo(map, (k!=null?input.toString(k.start,k.stop):null), (ID53!=null?ID53.getText():null)); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:164:17: fid= FULL_ID
					{
					fid=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_map_val1364); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					fid_tree = (Object)adaptor.create(fid);
					adaptor.addChild(root_0, fid_tree);
					}

					if ( state.backtracking==0 ) { proto.putRefTo(map, (k!=null?input.toString(k.start,k.stop):null), (fid!=null?fid.getText():null)); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:165:17: NUMFLOAT
					{
					NUMFLOAT54=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_map_val1384); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT54_tree = (Object)adaptor.create(NUMFLOAT54);
					adaptor.addChild(root_0, NUMFLOAT54_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), Float.valueOf((NUMFLOAT54!=null?NUMFLOAT54.getText():null))); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:166:17: NUMINT
					{
					NUMINT55=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_map_val1404); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT55_tree = (Object)adaptor.create(NUMINT55);
					adaptor.addChild(root_0, NUMINT55_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), parseNumber((NUMINT55!=null?NUMINT55.getText():null))); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:167:17: NUMDOUBLE
					{
					NUMDOUBLE56=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_map_val1424); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE56_tree = (Object)adaptor.create(NUMDOUBLE56);
					adaptor.addChild(root_0, NUMDOUBLE56_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), Double.valueOf((NUMDOUBLE56!=null?NUMDOUBLE56.getText():null))); }
					}
					break;
				case 9 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:168:17: TRUE
					{
					TRUE57=(Token)match(input,TRUE,FOLLOW_TRUE_in_map_val1444); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE57_tree = (Object)adaptor.create(TRUE57);
					adaptor.addChild(root_0, TRUE57_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), Boolean.TRUE); }
					}
					break;
				case 10 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:169:17: FALSE
					{
					FALSE58=(Token)match(input,FALSE,FOLLOW_FALSE_in_map_val1464); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE58_tree = (Object)adaptor.create(FALSE58);
					adaptor.addChild(root_0, FALSE58_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), Boolean.FALSE); }
					}
					break;
				case 11 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:170:17: STRING_LITERAL
					{
					STRING_LITERAL59=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_map_val1484); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL59_tree = (Object)adaptor.create(STRING_LITERAL59);
					adaptor.addChild(root_0, STRING_LITERAL59_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), getStringFromStringLiteral((STRING_LITERAL59!=null?STRING_LITERAL59.getText():null))); }
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
	// $ANTLR end "map_val"


	public static class annotation_keyval_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "annotation_keyval"
	// com/dyuproject/fbsgen/parser/ProtoParser.g:174:1: annotation_keyval[Proto proto, Annotation annotation] : k= var_full ( ASSIGN | COLON ) ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) ;
	public final ProtoParser.annotation_keyval_return annotation_keyval(Proto proto, Annotation annotation) throws RecognitionException {
		ProtoParser.annotation_keyval_return retval = new ProtoParser.annotation_keyval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fid=null;
		Token set60=null;
		Token LEFTCURLY61=null;
		Token COMMA63=null;
		Token RIGHTCURLY65=null;
		Token LEFTSQUARE66=null;
		Token COMMA68=null;
		Token RIGHTSQUARE70=null;
		Token ID71=null;
		Token NUMFLOAT72=null;
		Token NUMINT73=null;
		Token NUMDOUBLE74=null;
		Token TRUE75=null;
		Token FALSE76=null;
		Token STRING_LITERAL77=null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope vr =null;
		ParserRuleReturnScope map_val62 =null;
		ParserRuleReturnScope map_val64 =null;
		ParserRuleReturnScope list_val67 =null;
		ParserRuleReturnScope list_val69 =null;

		Object fid_tree=null;
		Object set60_tree=null;
		Object LEFTCURLY61_tree=null;
		Object COMMA63_tree=null;
		Object RIGHTCURLY65_tree=null;
		Object LEFTSQUARE66_tree=null;
		Object COMMA68_tree=null;
		Object RIGHTSQUARE70_tree=null;
		Object ID71_tree=null;
		Object NUMFLOAT72_tree=null;
		Object NUMINT73_tree=null;
		Object NUMDOUBLE74_tree=null;
		Object TRUE75_tree=null;
		Object FALSE76_tree=null;
		Object STRING_LITERAL77_tree=null;


		    Map<String, Object> map = null;
		    List<Object> list = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:179:5: (k= var_full ( ASSIGN | COLON ) ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:179:9: k= var_full ( ASSIGN | COLON ) ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_var_full_in_annotation_keyval1524);
			k=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

			set60=input.LT(1);
			if ( input.LA(1)==ASSIGN||input.LA(1)==COLON ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set60));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// com/dyuproject/fbsgen/parser/ProtoParser.g:179:35: ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			int alt15=11;
			switch ( input.LA(1) ) {
			case LEFTCURLY:
				{
				alt15=1;
				}
				break;
			case LEFTSQUARE:
				{
				alt15=2;
				}
				break;
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
				alt15=3;
				}
				break;
			case ID:
				{
				alt15=4;
				}
				break;
			case FULL_ID:
				{
				alt15=5;
				}
				break;
			case NUMFLOAT:
				{
				alt15=6;
				}
				break;
			case NUMINT:
				{
				alt15=7;
				}
				break;
			case NUMDOUBLE:
				{
				alt15=8;
				}
				break;
			case TRUE:
				{
				alt15=9;
				}
				break;
			case FALSE:
				{
				alt15=10;
				}
				break;
			case STRING_LITERAL:
				{
				alt15=11;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:180:13: ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:180:13: ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:181:17: LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY
					{
					LEFTCURLY61=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_annotation_keyval1564); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTCURLY61_tree = (Object)adaptor.create(LEFTCURLY61);
					adaptor.addChild(root_0, LEFTCURLY61_tree);
					}

					if ( state.backtracking==0 ) {
					                    annotation.put((k!=null?input.toString(k.start,k.stop):null), (map = new java.util.LinkedHashMap<String, Object>()));
					                }
					pushFollow(FOLLOW_map_val_in_annotation_keyval1584);
					map_val62=map_val(proto, map);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val62.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:184:37: ( COMMA map_val[proto, map] )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==COMMA) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:184:38: COMMA map_val[proto, map]
							{
							COMMA63=(Token)match(input,COMMA,FOLLOW_COMMA_in_annotation_keyval1588); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA63_tree = (Object)adaptor.create(COMMA63);
							adaptor.addChild(root_0, COMMA63_tree);
							}

							pushFollow(FOLLOW_map_val_in_annotation_keyval1590);
							map_val64=map_val(proto, map);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val64.getTree());

							}
							break;

						default :
							break loop13;
						}
					}

					RIGHTCURLY65=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_annotation_keyval1612); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTCURLY65_tree = (Object)adaptor.create(RIGHTCURLY65);
					adaptor.addChild(root_0, RIGHTCURLY65_tree);
					}

					}

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:188:13: ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:188:13: ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:189:17: LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE
					{
					LEFTSQUARE66=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_annotation_keyval1672); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSQUARE66_tree = (Object)adaptor.create(LEFTSQUARE66);
					adaptor.addChild(root_0, LEFTSQUARE66_tree);
					}

					if ( state.backtracking==0 ) {
					                    annotation.put((k!=null?input.toString(k.start,k.stop):null), (list = new ArrayList<Object>()));
					                }
					pushFollow(FOLLOW_list_val_in_annotation_keyval1692);
					list_val67=list_val(proto, list);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val67.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:192:39: ( COMMA list_val[proto, list] )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==COMMA) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:192:40: COMMA list_val[proto, list]
							{
							COMMA68=(Token)match(input,COMMA,FOLLOW_COMMA_in_annotation_keyval1696); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA68_tree = (Object)adaptor.create(COMMA68);
							adaptor.addChild(root_0, COMMA68_tree);
							}

							pushFollow(FOLLOW_list_val_in_annotation_keyval1698);
							list_val69=list_val(proto, list);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val69.getTree());

							}
							break;

						default :
							break loop14;
						}
					}

					RIGHTSQUARE70=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_annotation_keyval1720); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSQUARE70_tree = (Object)adaptor.create(RIGHTSQUARE70);
					adaptor.addChild(root_0, RIGHTSQUARE70_tree);
					}

					}

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:195:17: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_annotation_keyval1754);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), (vr!=null?input.toString(vr.start,vr.stop):null)); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:196:17: ID
					{
					ID71=(Token)match(input,ID,FOLLOW_ID_in_annotation_keyval1774); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID71_tree = (Object)adaptor.create(ID71);
					adaptor.addChild(root_0, ID71_tree);
					}

					if ( state.backtracking==0 ) { annotation.putRef((k!=null?input.toString(k.start,k.stop):null), (ID71!=null?ID71.getText():null)); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:197:17: fid= FULL_ID
					{
					fid=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_annotation_keyval1796); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					fid_tree = (Object)adaptor.create(fid);
					adaptor.addChild(root_0, fid_tree);
					}

					if ( state.backtracking==0 ) { annotation.putRef((k!=null?input.toString(k.start,k.stop):null), (fid!=null?fid.getText():null)); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:198:17: NUMFLOAT
					{
					NUMFLOAT72=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_annotation_keyval1816); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT72_tree = (Object)adaptor.create(NUMFLOAT72);
					adaptor.addChild(root_0, NUMFLOAT72_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Float.valueOf((NUMFLOAT72!=null?NUMFLOAT72.getText():null))); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:199:17: NUMINT
					{
					NUMINT73=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_annotation_keyval1836); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT73_tree = (Object)adaptor.create(NUMINT73);
					adaptor.addChild(root_0, NUMINT73_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), parseNumber((NUMINT73!=null?NUMINT73.getText():null))); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:200:17: NUMDOUBLE
					{
					NUMDOUBLE74=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_annotation_keyval1856); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE74_tree = (Object)adaptor.create(NUMDOUBLE74);
					adaptor.addChild(root_0, NUMDOUBLE74_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Double.valueOf((NUMDOUBLE74!=null?NUMDOUBLE74.getText():null))); }
					}
					break;
				case 9 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:201:17: TRUE
					{
					TRUE75=(Token)match(input,TRUE,FOLLOW_TRUE_in_annotation_keyval1876); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE75_tree = (Object)adaptor.create(TRUE75);
					adaptor.addChild(root_0, TRUE75_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Boolean.TRUE); }
					}
					break;
				case 10 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:202:17: FALSE
					{
					FALSE76=(Token)match(input,FALSE,FOLLOW_FALSE_in_annotation_keyval1896); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE76_tree = (Object)adaptor.create(FALSE76);
					adaptor.addChild(root_0, FALSE76_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Boolean.FALSE); }
					}
					break;
				case 11 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:203:17: STRING_LITERAL
					{
					STRING_LITERAL77=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_annotation_keyval1916); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL77_tree = (Object)adaptor.create(STRING_LITERAL77);
					adaptor.addChild(root_0, STRING_LITERAL77_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), getStringFromStringLiteral((STRING_LITERAL77!=null?STRING_LITERAL77.getText():null))); }
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:207:1: header_syntax[Proto proto] : SYNTAX ASSIGN STRING_LITERAL SEMICOLON !;
	public final ProtoParser.header_syntax_return header_syntax(Proto proto) throws RecognitionException {
		ProtoParser.header_syntax_return retval = new ProtoParser.header_syntax_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SYNTAX78=null;
		Token ASSIGN79=null;
		Token STRING_LITERAL80=null;
		Token SEMICOLON81=null;

		Object SYNTAX78_tree=null;
		Object ASSIGN79_tree=null;
		Object STRING_LITERAL80_tree=null;
		Object SEMICOLON81_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:208:5: ( SYNTAX ASSIGN STRING_LITERAL SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:208:9: SYNTAX ASSIGN STRING_LITERAL SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			SYNTAX78=(Token)match(input,SYNTAX,FOLLOW_SYNTAX_in_header_syntax1949); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SYNTAX78_tree = (Object)adaptor.create(SYNTAX78);
			adaptor.addChild(root_0, SYNTAX78_tree);
			}

			ASSIGN79=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_header_syntax1951); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN79_tree = (Object)adaptor.create(ASSIGN79);
			adaptor.addChild(root_0, ASSIGN79_tree);
			}

			STRING_LITERAL80=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_header_syntax1953); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STRING_LITERAL80_tree = (Object)adaptor.create(STRING_LITERAL80);
			adaptor.addChild(root_0, STRING_LITERAL80_tree);
			}

			SEMICOLON81=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_header_syntax1955); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			            if (!"proto2".equals(getStringFromStringLiteral((STRING_LITERAL80!=null?STRING_LITERAL80.getText():null)))) {
			                throw err(proto, "Syntax isn't proto2: '" +
			                        getStringFromStringLiteral((STRING_LITERAL80!=null?STRING_LITERAL80.getText():null))+"'");
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:218:1: header_package[Proto proto] : PKG ( FULL_ID | var ) SEMICOLON !;
	public final ProtoParser.header_package_return header_package(Proto proto) throws RecognitionException {
		ProtoParser.header_package_return retval = new ProtoParser.header_package_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PKG82=null;
		Token FULL_ID83=null;
		Token SEMICOLON85=null;
		ParserRuleReturnScope var84 =null;

		Object PKG82_tree=null;
		Object FULL_ID83_tree=null;
		Object SEMICOLON85_tree=null;


		    String value = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:222:5: ( PKG ( FULL_ID | var ) SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:222:9: PKG ( FULL_ID | var ) SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			PKG82=(Token)match(input,PKG,FOLLOW_PKG_in_header_package1984); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PKG82_tree = (Object)adaptor.create(PKG82);
			adaptor.addChild(root_0, PKG82_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:222:13: ( FULL_ID | var )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==FULL_ID) ) {
				alt16=1;
			}
			else if ( ((LA16_0 >= BOOL && LA16_0 <= BYTES)||LA16_0==DEFAULT||(LA16_0 >= DOUBLE && LA16_0 <= ENUM)||LA16_0==FLOAT||(LA16_0 >= ID && LA16_0 <= INT8)||(LA16_0 >= MAX && LA16_0 <= MESSAGE)||(LA16_0 >= OPTION && LA16_0 <= PKG)||(LA16_0 >= REPEATED && LA16_0 <= RETURNS)||LA16_0==RPC||(LA16_0 >= SERVICE && LA16_0 <= STRING)||(LA16_0 >= SYNTAX && LA16_0 <= TO)||(LA16_0 >= UINT16 && LA16_0 <= UINT8)||LA16_0==VOID) ) {
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:222:14: FULL_ID
					{
					FULL_ID83=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_header_package1987); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID83_tree = (Object)adaptor.create(FULL_ID83);
					adaptor.addChild(root_0, FULL_ID83_tree);
					}

					if ( state.backtracking==0 ) { value = (FULL_ID83!=null?FULL_ID83.getText():null); }
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:222:51: var
					{
					pushFollow(FOLLOW_var_in_header_package1993);
					var84=var();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var84.getTree());

					if ( state.backtracking==0 ) { value = (var84!=null?input.toString(var84.start,var84.stop):null); }
					}
					break;

			}

			SEMICOLON85=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_header_package1998); if (state.failed) return retval;
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:232:1: header_import[Proto proto] : IMPORT STRING_LITERAL SEMICOLON !;
	public final ProtoParser.header_import_return header_import(Proto proto) throws RecognitionException {
		ProtoParser.header_import_return retval = new ProtoParser.header_import_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IMPORT86=null;
		Token STRING_LITERAL87=null;
		Token SEMICOLON88=null;

		Object IMPORT86_tree=null;
		Object STRING_LITERAL87_tree=null;
		Object SEMICOLON88_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:233:5: ( IMPORT STRING_LITERAL SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:233:9: IMPORT STRING_LITERAL SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			IMPORT86=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_header_import2026); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IMPORT86_tree = (Object)adaptor.create(IMPORT86);
			adaptor.addChild(root_0, IMPORT86_tree);
			}

			STRING_LITERAL87=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_header_import2028); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STRING_LITERAL87_tree = (Object)adaptor.create(STRING_LITERAL87);
			adaptor.addChild(root_0, STRING_LITERAL87_tree);
			}

			SEMICOLON88=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_header_import2030); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			            proto.importProto(getStringFromStringLiteral((STRING_LITERAL87!=null?STRING_LITERAL87.getText():null)));
			            
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:240:1: option_entry[Proto proto, HasOptions ho] : OPTION ( LEFTPAREN )? k= var_full ( RIGHTPAREN )? ASSIGN ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) SEMICOLON !;
	public final ProtoParser.option_entry_return option_entry(Proto proto, HasOptions ho) throws RecognitionException {
		ProtoParser.option_entry_return retval = new ProtoParser.option_entry_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token fid=null;
		Token OPTION89=null;
		Token LEFTPAREN90=null;
		Token RIGHTPAREN91=null;
		Token ASSIGN92=null;
		Token LEFTCURLY93=null;
		Token COMMA95=null;
		Token RIGHTCURLY97=null;
		Token LEFTSQUARE98=null;
		Token COMMA100=null;
		Token RIGHTSQUARE102=null;
		Token NUMFLOAT103=null;
		Token NUMINT104=null;
		Token NUMDOUBLE105=null;
		Token TRUE106=null;
		Token FALSE107=null;
		Token STRING_LITERAL108=null;
		Token SEMICOLON109=null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope vr =null;
		ParserRuleReturnScope map_val94 =null;
		ParserRuleReturnScope map_val96 =null;
		ParserRuleReturnScope list_val99 =null;
		ParserRuleReturnScope list_val101 =null;

		Object id_tree=null;
		Object fid_tree=null;
		Object OPTION89_tree=null;
		Object LEFTPAREN90_tree=null;
		Object RIGHTPAREN91_tree=null;
		Object ASSIGN92_tree=null;
		Object LEFTCURLY93_tree=null;
		Object COMMA95_tree=null;
		Object RIGHTCURLY97_tree=null;
		Object LEFTSQUARE98_tree=null;
		Object COMMA100_tree=null;
		Object RIGHTSQUARE102_tree=null;
		Object NUMFLOAT103_tree=null;
		Object NUMINT104_tree=null;
		Object NUMDOUBLE105_tree=null;
		Object TRUE106_tree=null;
		Object FALSE107_tree=null;
		Object STRING_LITERAL108_tree=null;
		Object SEMICOLON109_tree=null;


		    Map<String, Object> map = null;
		    List<Object> list = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:245:5: ( OPTION ( LEFTPAREN )? k= var_full ( RIGHTPAREN )? ASSIGN ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:245:9: OPTION ( LEFTPAREN )? k= var_full ( RIGHTPAREN )? ASSIGN ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			OPTION89=(Token)match(input,OPTION,FOLLOW_OPTION_in_option_entry2059); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OPTION89_tree = (Object)adaptor.create(OPTION89);
			adaptor.addChild(root_0, OPTION89_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:245:16: ( LEFTPAREN )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==LEFTPAREN) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:245:16: LEFTPAREN
					{
					LEFTPAREN90=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_option_entry2061); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTPAREN90_tree = (Object)adaptor.create(LEFTPAREN90);
					adaptor.addChild(root_0, LEFTPAREN90_tree);
					}

					}
					break;

			}

			pushFollow(FOLLOW_var_full_in_option_entry2066);
			k=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

			// com/dyuproject/fbsgen/parser/ProtoParser.g:245:38: ( RIGHTPAREN )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==RIGHTPAREN) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:245:38: RIGHTPAREN
					{
					RIGHTPAREN91=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_option_entry2068); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTPAREN91_tree = (Object)adaptor.create(RIGHTPAREN91);
					adaptor.addChild(root_0, RIGHTPAREN91_tree);
					}

					}
					break;

			}

			ASSIGN92=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_option_entry2071); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN92_tree = (Object)adaptor.create(ASSIGN92);
			adaptor.addChild(root_0, ASSIGN92_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:245:57: ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			int alt21=11;
			switch ( input.LA(1) ) {
			case LEFTCURLY:
				{
				alt21=1;
				}
				break;
			case LEFTSQUARE:
				{
				alt21=2;
				}
				break;
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
				alt21=3;
				}
				break;
			case ID:
				{
				alt21=4;
				}
				break;
			case FULL_ID:
				{
				alt21=5;
				}
				break;
			case NUMFLOAT:
				{
				alt21=6;
				}
				break;
			case NUMINT:
				{
				alt21=7;
				}
				break;
			case NUMDOUBLE:
				{
				alt21=8;
				}
				break;
			case TRUE:
				{
				alt21=9;
				}
				break;
			case FALSE:
				{
				alt21=10;
				}
				break;
			case STRING_LITERAL:
				{
				alt21=11;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:246:13: ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:246:13: ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:247:17: LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY
					{
					LEFTCURLY93=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_option_entry2105); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTCURLY93_tree = (Object)adaptor.create(LEFTCURLY93);
					adaptor.addChild(root_0, LEFTCURLY93_tree);
					}

					if ( state.backtracking==0 ) {
					                    putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (map = new java.util.LinkedHashMap<String, Object>()), proto);
					                }
					pushFollow(FOLLOW_map_val_in_option_entry2125);
					map_val94=map_val(proto, map);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val94.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:250:37: ( COMMA map_val[proto, map] )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0==COMMA) ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:250:38: COMMA map_val[proto, map]
							{
							COMMA95=(Token)match(input,COMMA,FOLLOW_COMMA_in_option_entry2129); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA95_tree = (Object)adaptor.create(COMMA95);
							adaptor.addChild(root_0, COMMA95_tree);
							}

							pushFollow(FOLLOW_map_val_in_option_entry2131);
							map_val96=map_val(proto, map);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val96.getTree());

							}
							break;

						default :
							break loop19;
						}
					}

					RIGHTCURLY97=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_option_entry2153); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTCURLY97_tree = (Object)adaptor.create(RIGHTCURLY97);
					adaptor.addChild(root_0, RIGHTCURLY97_tree);
					}

					}

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:254:13: ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:254:13: ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:255:17: LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE
					{
					LEFTSQUARE98=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_option_entry2213); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSQUARE98_tree = (Object)adaptor.create(LEFTSQUARE98);
					adaptor.addChild(root_0, LEFTSQUARE98_tree);
					}

					if ( state.backtracking==0 ) {
					                    putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (list = new ArrayList<Object>()), proto);
					                }
					pushFollow(FOLLOW_list_val_in_option_entry2233);
					list_val99=list_val(proto, list);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val99.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:258:39: ( COMMA list_val[proto, list] )*
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( (LA20_0==COMMA) ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:258:40: COMMA list_val[proto, list]
							{
							COMMA100=(Token)match(input,COMMA,FOLLOW_COMMA_in_option_entry2237); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA100_tree = (Object)adaptor.create(COMMA100);
							adaptor.addChild(root_0, COMMA100_tree);
							}

							pushFollow(FOLLOW_list_val_in_option_entry2239);
							list_val101=list_val(proto, list);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val101.getTree());

							}
							break;

						default :
							break loop20;
						}
					}

					RIGHTSQUARE102=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_option_entry2261); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSQUARE102_tree = (Object)adaptor.create(RIGHTSQUARE102);
					adaptor.addChild(root_0, RIGHTSQUARE102_tree);
					}

					}

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:261:17: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_option_entry2295);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (vr!=null?input.toString(vr.start,vr.stop):null), proto); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:262:17: id= ID
					{
					id=(Token)match(input,ID,FOLLOW_ID_in_option_entry2317); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					id_tree = (Object)adaptor.create(id);
					adaptor.addChild(root_0, id_tree);
					}

					if ( state.backtracking==0 ) { putStandardOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (id!=null?id.getText():null), proto); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:263:17: fid= FULL_ID
					{
					fid=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_option_entry2339); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					fid_tree = (Object)adaptor.create(fid);
					adaptor.addChild(root_0, fid_tree);
					}

					if ( state.backtracking==0 ) { putStandardOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (fid!=null?fid.getText():null), proto); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:264:17: NUMFLOAT
					{
					NUMFLOAT103=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_option_entry2359); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT103_tree = (Object)adaptor.create(NUMFLOAT103);
					adaptor.addChild(root_0, NUMFLOAT103_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), Float.valueOf((NUMFLOAT103!=null?NUMFLOAT103.getText():null)), proto); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:265:17: NUMINT
					{
					NUMINT104=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_option_entry2379); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT104_tree = (Object)adaptor.create(NUMINT104);
					adaptor.addChild(root_0, NUMINT104_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), parseNumber((NUMINT104!=null?NUMINT104.getText():null)), proto); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:266:17: NUMDOUBLE
					{
					NUMDOUBLE105=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_option_entry2399); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE105_tree = (Object)adaptor.create(NUMDOUBLE105);
					adaptor.addChild(root_0, NUMDOUBLE105_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), Double.valueOf((NUMDOUBLE105!=null?NUMDOUBLE105.getText():null)), proto); }
					}
					break;
				case 9 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:267:17: TRUE
					{
					TRUE106=(Token)match(input,TRUE,FOLLOW_TRUE_in_option_entry2419); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE106_tree = (Object)adaptor.create(TRUE106);
					adaptor.addChild(root_0, TRUE106_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), Boolean.TRUE, proto); }
					}
					break;
				case 10 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:268:17: FALSE
					{
					FALSE107=(Token)match(input,FALSE,FOLLOW_FALSE_in_option_entry2439); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE107_tree = (Object)adaptor.create(FALSE107);
					adaptor.addChild(root_0, FALSE107_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), Boolean.FALSE, proto); }
					}
					break;
				case 11 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:269:17: STRING_LITERAL
					{
					STRING_LITERAL108=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_option_entry2459); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL108_tree = (Object)adaptor.create(STRING_LITERAL108);
					adaptor.addChild(root_0, STRING_LITERAL108_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), getStringFromStringLiteral((STRING_LITERAL108!=null?STRING_LITERAL108.getText():null)), proto); }
					}
					break;

			}

			SEMICOLON109=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_option_entry2473); if (state.failed) return retval;
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:275:1: message_block[Proto proto, Message parent] : MESSAGE ID LEFTCURLY ( message_body[proto, message] )* RIGHTCURLY ;
	public final ProtoParser.message_block_return message_block(Proto proto, Message parent) throws RecognitionException {
		ProtoParser.message_block_return retval = new ProtoParser.message_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MESSAGE110=null;
		Token ID111=null;
		Token LEFTCURLY112=null;
		Token RIGHTCURLY114=null;
		ParserRuleReturnScope message_body113 =null;

		Object MESSAGE110_tree=null;
		Object ID111_tree=null;
		Object LEFTCURLY112_tree=null;
		Object RIGHTCURLY114_tree=null;


		    Message message = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:279:5: ( MESSAGE ID LEFTCURLY ( message_body[proto, message] )* RIGHTCURLY )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:279:9: MESSAGE ID LEFTCURLY ( message_body[proto, message] )* RIGHTCURLY
			{
			root_0 = (Object)adaptor.nil();


			MESSAGE110=(Token)match(input,MESSAGE,FOLLOW_MESSAGE_in_message_block2506); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MESSAGE110_tree = (Object)adaptor.create(MESSAGE110);
			adaptor.addChild(root_0, MESSAGE110_tree);
			}

			ID111=(Token)match(input,ID,FOLLOW_ID_in_message_block2508); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID111_tree = (Object)adaptor.create(ID111);
			adaptor.addChild(root_0, ID111_tree);
			}

			if ( state.backtracking==0 ) { 
			            message = new Message((ID111!=null?ID111.getText():null), parent, proto);
			            proto.addAnnotationsTo(message);
			        }
			LEFTCURLY112=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_message_block2521); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY112_tree = (Object)adaptor.create(LEFTCURLY112);
			adaptor.addChild(root_0, LEFTCURLY112_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:283:19: ( message_body[proto, message] )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==AT||LA22_0==DOC_COMMENT||LA22_0==ENUM||LA22_0==MESSAGE||(LA22_0 >= OPTION && LA22_0 <= OPTIONAL)||(LA22_0 >= REPEATED && LA22_0 <= REQUIRED)||LA22_0==SERVICE) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:283:20: message_body[proto, message]
					{
					pushFollow(FOLLOW_message_body_in_message_block2524);
					message_body113=message_body(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_body113.getTree());

					}
					break;

				default :
					break loop22;
				}
			}

			RIGHTCURLY114=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_message_block2529); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY114_tree = (Object)adaptor.create(RIGHTCURLY114);
			adaptor.addChild(root_0, RIGHTCURLY114_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:288:1: message_body[Proto proto, Message message] : ( message_block[proto, message] | message_field[proto, message] | enum_block[proto, message] | service_block[proto, message] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, message] );
	public final ProtoParser.message_body_return message_body(Proto proto, Message message) throws RecognitionException {
		ProtoParser.message_body_return retval = new ProtoParser.message_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope message_block115 =null;
		ParserRuleReturnScope message_field116 =null;
		ParserRuleReturnScope enum_block117 =null;
		ParserRuleReturnScope service_block118 =null;
		ParserRuleReturnScope annotation_entry119 =null;
		ParserRuleReturnScope comment_entry120 =null;
		ParserRuleReturnScope option_entry121 =null;


		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:289:5: ( message_block[proto, message] | message_field[proto, message] | enum_block[proto, message] | service_block[proto, message] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, message] )
			int alt23=7;
			switch ( input.LA(1) ) {
			case MESSAGE:
				{
				alt23=1;
				}
				break;
			case OPTIONAL:
			case REPEATED:
			case REQUIRED:
				{
				alt23=2;
				}
				break;
			case ENUM:
				{
				alt23=3;
				}
				break;
			case SERVICE:
				{
				alt23=4;
				}
				break;
			case AT:
				{
				alt23=5;
				}
				break;
			case DOC_COMMENT:
				{
				alt23=6;
				}
				break;
			case OPTION:
				{
				alt23=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:289:9: message_block[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_message_block_in_message_body2552);
					message_block115=message_block(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_block115.getTree());

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:290:9: message_field[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_message_field_in_message_body2563);
					message_field116=message_field(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_field116.getTree());

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:291:9: enum_block[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_enum_block_in_message_body2574);
					enum_block117=enum_block(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_block117.getTree());

					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:292:9: service_block[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_service_block_in_message_body2585);
					service_block118=service_block(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, service_block118.getTree());

					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:295:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_message_body2606);
					annotation_entry119=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry119.getTree());

					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:296:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_message_body2617);
					comment_entry120=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry120.getTree());

					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:297:9: option_entry[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_message_body2628);
					option_entry121=option_entry(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry121.getTree());

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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:312:1: message_field[Proto proto, HasFields message] : ( OPTIONAL | REQUIRED | REPEATED ) field_type[proto, message, fieldHolder] var ASSIGN NUMINT ( field_options[proto, message, fieldHolder.field] )? ( SEMICOLON !| ignore_block ) ;
	public final ProtoParser.message_field_return message_field(Proto proto, HasFields message) throws RecognitionException {
		ProtoParser.message_field_return retval = new ProtoParser.message_field_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OPTIONAL122=null;
		Token REQUIRED123=null;
		Token REPEATED124=null;
		Token ASSIGN127=null;
		Token NUMINT128=null;
		Token SEMICOLON130=null;
		ParserRuleReturnScope field_type125 =null;
		ParserRuleReturnScope var126 =null;
		ParserRuleReturnScope field_options129 =null;
		ParserRuleReturnScope ignore_block131 =null;

		Object OPTIONAL122_tree=null;
		Object REQUIRED123_tree=null;
		Object REPEATED124_tree=null;
		Object ASSIGN127_tree=null;
		Object NUMINT128_tree=null;
		Object SEMICOLON130_tree=null;


		    Field.Modifier modifier = null;
		    FieldHolder fieldHolder = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:317:5: ( ( OPTIONAL | REQUIRED | REPEATED ) field_type[proto, message, fieldHolder] var ASSIGN NUMINT ( field_options[proto, message, fieldHolder.field] )? ( SEMICOLON !| ignore_block ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:317:9: ( OPTIONAL | REQUIRED | REPEATED ) field_type[proto, message, fieldHolder] var ASSIGN NUMINT ( field_options[proto, message, fieldHolder.field] )? ( SEMICOLON !| ignore_block )
			{
			root_0 = (Object)adaptor.nil();


			// com/dyuproject/fbsgen/parser/ProtoParser.g:317:9: ( OPTIONAL | REQUIRED | REPEATED )
			int alt24=3;
			switch ( input.LA(1) ) {
			case OPTIONAL:
				{
				alt24=1;
				}
				break;
			case REQUIRED:
				{
				alt24=2;
				}
				break;
			case REPEATED:
				{
				alt24=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:317:10: OPTIONAL
					{
					OPTIONAL122=(Token)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_message_field2676); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OPTIONAL122_tree = (Object)adaptor.create(OPTIONAL122);
					adaptor.addChild(root_0, OPTIONAL122_tree);
					}

					if ( state.backtracking==0 ) { modifier = Field.Modifier.OPTIONAL;  }
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:318:13: REQUIRED
					{
					REQUIRED123=(Token)match(input,REQUIRED,FOLLOW_REQUIRED_in_message_field2693); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					REQUIRED123_tree = (Object)adaptor.create(REQUIRED123);
					adaptor.addChild(root_0, REQUIRED123_tree);
					}

					if ( state.backtracking==0 ) { modifier = Field.Modifier.REQUIRED; }
					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:319:13: REPEATED
					{
					REPEATED124=(Token)match(input,REPEATED,FOLLOW_REPEATED_in_message_field2710); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					REPEATED124_tree = (Object)adaptor.create(REPEATED124);
					adaptor.addChild(root_0, REPEATED124_tree);
					}

					if ( state.backtracking==0 ) { modifier = Field.Modifier.REPEATED; }
					}
					break;

			}

			if ( state.backtracking==0 ) {
			            fieldHolder = new FieldHolder();
			        }
			pushFollow(FOLLOW_field_type_in_message_field2725);
			field_type125=field_type(proto, message, fieldHolder);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_type125.getTree());

			pushFollow(FOLLOW_var_in_message_field2737);
			var126=var();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var126.getTree());

			ASSIGN127=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_message_field2739); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN127_tree = (Object)adaptor.create(ASSIGN127);
			adaptor.addChild(root_0, ASSIGN127_tree);
			}

			NUMINT128=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_message_field2741); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NUMINT128_tree = (Object)adaptor.create(NUMINT128);
			adaptor.addChild(root_0, NUMINT128_tree);
			}

			if ( state.backtracking==0 ) {
			            if (fieldHolder.field != null) {
			                fieldHolder.field.modifier = modifier;
			                fieldHolder.field.name = (var126!=null?input.toString(var126.start,var126.stop):null);
			                fieldHolder.field.number = Integer.parseInt((NUMINT128!=null?NUMINT128.getText():null));
			                message.addField(fieldHolder.field);
			            }
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:331:9: ( field_options[proto, message, fieldHolder.field] )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==LEFTSQUARE) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:331:10: field_options[proto, message, fieldHolder.field]
					{
					pushFollow(FOLLOW_field_options_in_message_field2755);
					field_options129=field_options(proto, message, fieldHolder.field);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options129.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			            if (fieldHolder.field != null) {
			                proto.addAnnotationsTo(fieldHolder.field, message.getEnclosingNamespace());
			                fieldHolder.field.resolvePbType();
			            }
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:337:9: ( SEMICOLON !| ignore_block )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==SEMICOLON) ) {
				alt26=1;
			}
			else if ( (LA26_0==LEFTCURLY) ) {
				alt26=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:337:10: SEMICOLON !
					{
					SEMICOLON130=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_message_field2771); if (state.failed) return retval;
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:337:23: ignore_block
					{
					pushFollow(FOLLOW_ignore_block_in_message_field2776);
					ignore_block131=ignore_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_block131.getTree());

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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:340:1: field_type[Proto proto, HasFields message, FieldHolder fieldHolder] : ( BOOL | INT8 | UINT8 | INT16 | UINT16 | INT32 | UINT32 | INT64 | UINT64 | FLOAT | DOUBLE | STRING | BYTES | FULL_ID | ID );
	public final ProtoParser.field_type_return field_type(Proto proto, HasFields message, FieldHolder fieldHolder) throws RecognitionException {
		ProtoParser.field_type_return retval = new ProtoParser.field_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BOOL132=null;
		Token INT8133=null;
		Token UINT8134=null;
		Token INT16135=null;
		Token UINT16136=null;
		Token INT32137=null;
		Token UINT32138=null;
		Token INT64139=null;
		Token UINT64140=null;
		Token FLOAT141=null;
		Token DOUBLE142=null;
		Token STRING143=null;
		Token BYTES144=null;
		Token FULL_ID145=null;
		Token ID146=null;

		Object BOOL132_tree=null;
		Object INT8133_tree=null;
		Object UINT8134_tree=null;
		Object INT16135_tree=null;
		Object UINT16136_tree=null;
		Object INT32137_tree=null;
		Object UINT32138_tree=null;
		Object INT64139_tree=null;
		Object UINT64140_tree=null;
		Object FLOAT141_tree=null;
		Object DOUBLE142_tree=null;
		Object STRING143_tree=null;
		Object BYTES144_tree=null;
		Object FULL_ID145_tree=null;
		Object ID146_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:341:5: ( BOOL | INT8 | UINT8 | INT16 | UINT16 | INT32 | UINT32 | INT64 | UINT64 | FLOAT | DOUBLE | STRING | BYTES | FULL_ID | ID )
			int alt27=15;
			switch ( input.LA(1) ) {
			case BOOL:
				{
				alt27=1;
				}
				break;
			case INT8:
				{
				alt27=2;
				}
				break;
			case UINT8:
				{
				alt27=3;
				}
				break;
			case INT16:
				{
				alt27=4;
				}
				break;
			case UINT16:
				{
				alt27=5;
				}
				break;
			case INT32:
				{
				alt27=6;
				}
				break;
			case UINT32:
				{
				alt27=7;
				}
				break;
			case INT64:
				{
				alt27=8;
				}
				break;
			case UINT64:
				{
				alt27=9;
				}
				break;
			case FLOAT:
				{
				alt27=10;
				}
				break;
			case DOUBLE:
				{
				alt27=11;
				}
				break;
			case STRING:
				{
				alt27=12;
				}
				break;
			case BYTES:
				{
				alt27=13;
				}
				break;
			case FULL_ID:
				{
				alt27=14;
				}
				break;
			case ID:
				{
				alt27=15;
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:341:9: BOOL
					{
					root_0 = (Object)adaptor.nil();


					BOOL132=(Token)match(input,BOOL,FOLLOW_BOOL_in_field_type2802); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOL132_tree = (Object)adaptor.create(BOOL132);
					adaptor.addChild(root_0, BOOL132_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Bool()); }
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:342:9: INT8
					{
					root_0 = (Object)adaptor.nil();


					INT8133=(Token)match(input,INT8,FOLLOW_INT8_in_field_type2814); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT8133_tree = (Object)adaptor.create(INT8133);
					adaptor.addChild(root_0, INT8133_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int8()); }
					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:343:9: UINT8
					{
					root_0 = (Object)adaptor.nil();


					UINT8134=(Token)match(input,UINT8,FOLLOW_UINT8_in_field_type2826); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT8134_tree = (Object)adaptor.create(UINT8134);
					adaptor.addChild(root_0, UINT8134_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt8()); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:344:9: INT16
					{
					root_0 = (Object)adaptor.nil();


					INT16135=(Token)match(input,INT16,FOLLOW_INT16_in_field_type2838); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT16135_tree = (Object)adaptor.create(INT16135);
					adaptor.addChild(root_0, INT16135_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int16()); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:345:9: UINT16
					{
					root_0 = (Object)adaptor.nil();


					UINT16136=(Token)match(input,UINT16,FOLLOW_UINT16_in_field_type2850); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT16136_tree = (Object)adaptor.create(UINT16136);
					adaptor.addChild(root_0, UINT16136_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt16()); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:346:9: INT32
					{
					root_0 = (Object)adaptor.nil();


					INT32137=(Token)match(input,INT32,FOLLOW_INT32_in_field_type2862); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT32137_tree = (Object)adaptor.create(INT32137);
					adaptor.addChild(root_0, INT32137_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int32()); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:347:9: UINT32
					{
					root_0 = (Object)adaptor.nil();


					UINT32138=(Token)match(input,UINT32,FOLLOW_UINT32_in_field_type2874); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT32138_tree = (Object)adaptor.create(UINT32138);
					adaptor.addChild(root_0, UINT32138_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt32()); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:348:9: INT64
					{
					root_0 = (Object)adaptor.nil();


					INT64139=(Token)match(input,INT64,FOLLOW_INT64_in_field_type2886); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT64139_tree = (Object)adaptor.create(INT64139);
					adaptor.addChild(root_0, INT64139_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int64()); }
					}
					break;
				case 9 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:349:9: UINT64
					{
					root_0 = (Object)adaptor.nil();


					UINT64140=(Token)match(input,UINT64,FOLLOW_UINT64_in_field_type2898); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT64140_tree = (Object)adaptor.create(UINT64140);
					adaptor.addChild(root_0, UINT64140_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt64()); }
					}
					break;
				case 10 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:350:9: FLOAT
					{
					root_0 = (Object)adaptor.nil();


					FLOAT141=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_field_type2910); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOAT141_tree = (Object)adaptor.create(FLOAT141);
					adaptor.addChild(root_0, FLOAT141_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Float()); }
					}
					break;
				case 11 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:351:9: DOUBLE
					{
					root_0 = (Object)adaptor.nil();


					DOUBLE142=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_field_type2922); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLE142_tree = (Object)adaptor.create(DOUBLE142);
					adaptor.addChild(root_0, DOUBLE142_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Double()); }
					}
					break;
				case 12 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:352:9: STRING
					{
					root_0 = (Object)adaptor.nil();


					STRING143=(Token)match(input,STRING,FOLLOW_STRING_in_field_type2934); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING143_tree = (Object)adaptor.create(STRING143);
					adaptor.addChild(root_0, STRING143_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.String()); }
					}
					break;
				case 13 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:353:9: BYTES
					{
					root_0 = (Object)adaptor.nil();


					BYTES144=(Token)match(input,BYTES,FOLLOW_BYTES_in_field_type2946); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BYTES144_tree = (Object)adaptor.create(BYTES144);
					adaptor.addChild(root_0, BYTES144_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Bytes()); }
					}
					break;
				case 14 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:358:9: FULL_ID
					{
					root_0 = (Object)adaptor.nil();


					FULL_ID145=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_field_type2978); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID145_tree = (Object)adaptor.create(FULL_ID145);
					adaptor.addChild(root_0, FULL_ID145_tree);
					}

					if ( state.backtracking==0 ) {
					            String fullType = (FULL_ID145!=null?FULL_ID145.getText():null);
					            int lastDot = fullType.lastIndexOf('.');
					            String packageName = fullType.substring(0, lastDot);
					            String type = fullType.substring(lastDot+1);
					            fieldHolder.setField(new Field.Reference(packageName, type, message));
					        }
					}
					break;
				case 15 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:365:9: ID
					{
					root_0 = (Object)adaptor.nil();


					ID146=(Token)match(input,ID,FOLLOW_ID_in_field_type2990); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID146_tree = (Object)adaptor.create(ID146);
					adaptor.addChild(root_0, ID146_tree);
					}

					if ( state.backtracking==0 ) { 
					            String type = (ID146!=null?ID146.getText():null);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:371:1: field_options[Proto proto, HasFields message, Field field] : LEFTSQUARE field_options_keyval[proto, message, field, true] ( COMMA field_options_keyval[proto, message, field, true] )* RIGHTSQUARE ;
	public final ProtoParser.field_options_return field_options(Proto proto, HasFields message, Field field) throws RecognitionException {
		ProtoParser.field_options_return retval = new ProtoParser.field_options_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTSQUARE147=null;
		Token COMMA149=null;
		Token RIGHTSQUARE151=null;
		ParserRuleReturnScope field_options_keyval148 =null;
		ParserRuleReturnScope field_options_keyval150 =null;

		Object LEFTSQUARE147_tree=null;
		Object COMMA149_tree=null;
		Object RIGHTSQUARE151_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:372:5: ( LEFTSQUARE field_options_keyval[proto, message, field, true] ( COMMA field_options_keyval[proto, message, field, true] )* RIGHTSQUARE )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:372:9: LEFTSQUARE field_options_keyval[proto, message, field, true] ( COMMA field_options_keyval[proto, message, field, true] )* RIGHTSQUARE
			{
			root_0 = (Object)adaptor.nil();


			LEFTSQUARE147=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_field_options3017); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTSQUARE147_tree = (Object)adaptor.create(LEFTSQUARE147);
			adaptor.addChild(root_0, LEFTSQUARE147_tree);
			}

			pushFollow(FOLLOW_field_options_keyval_in_field_options3019);
			field_options_keyval148=field_options_keyval(proto, message, field, true);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval148.getTree());

			// com/dyuproject/fbsgen/parser/ProtoParser.g:373:9: ( COMMA field_options_keyval[proto, message, field, true] )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==COMMA) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:373:10: COMMA field_options_keyval[proto, message, field, true]
					{
					COMMA149=(Token)match(input,COMMA,FOLLOW_COMMA_in_field_options3032); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA149_tree = (Object)adaptor.create(COMMA149);
					adaptor.addChild(root_0, COMMA149_tree);
					}

					pushFollow(FOLLOW_field_options_keyval_in_field_options3034);
					field_options_keyval150=field_options_keyval(proto, message, field, true);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval150.getTree());

					}
					break;

				default :
					break loop28;
				}
			}

			RIGHTSQUARE151=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_field_options3039); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTSQUARE151_tree = (Object)adaptor.create(RIGHTSQUARE151);
			adaptor.addChild(root_0, RIGHTSQUARE151_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:376:1: field_options_keyval[Proto proto, HasFields message, Field field, boolean checkDefault] : key= var_full ASSIGN ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] ) ;
	public final ProtoParser.field_options_keyval_return field_options_keyval(Proto proto, HasFields message, Field field, boolean checkDefault) throws RecognitionException {
		ProtoParser.field_options_keyval_return retval = new ProtoParser.field_options_keyval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token val=null;
		Token ASSIGN152=null;
		Token LEFTCURLY153=null;
		Token COMMA155=null;
		Token RIGHTCURLY157=null;
		Token LEFTSQUARE158=null;
		Token COMMA160=null;
		Token RIGHTSQUARE162=null;
		Token STRING_LITERAL163=null;
		Token NUMFLOAT164=null;
		Token NUMINT165=null;
		Token NUMDOUBLE166=null;
		Token HEX167=null;
		Token OCTAL168=null;
		Token TRUE169=null;
		Token FALSE170=null;
		Token FULL_ID171=null;
		Token EXP172=null;
		ParserRuleReturnScope key =null;
		ParserRuleReturnScope vr =null;
		ParserRuleReturnScope map_val154 =null;
		ParserRuleReturnScope map_val156 =null;
		ParserRuleReturnScope list_val159 =null;
		ParserRuleReturnScope list_val161 =null;
		ParserRuleReturnScope signed_constant173 =null;

		Object val_tree=null;
		Object ASSIGN152_tree=null;
		Object LEFTCURLY153_tree=null;
		Object COMMA155_tree=null;
		Object RIGHTCURLY157_tree=null;
		Object LEFTSQUARE158_tree=null;
		Object COMMA160_tree=null;
		Object RIGHTSQUARE162_tree=null;
		Object STRING_LITERAL163_tree=null;
		Object NUMFLOAT164_tree=null;
		Object NUMINT165_tree=null;
		Object NUMDOUBLE166_tree=null;
		Object HEX167_tree=null;
		Object OCTAL168_tree=null;
		Object TRUE169_tree=null;
		Object FALSE170_tree=null;
		Object FULL_ID171_tree=null;
		Object EXP172_tree=null;


		    Map<String, Object> map = null;
		    List<Object> list = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:381:5: (key= var_full ASSIGN ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:381:9: key= var_full ASSIGN ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] )
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_var_full_in_field_options_keyval3071);
			key=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, key.getTree());

			ASSIGN152=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_field_options_keyval3073); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN152_tree = (Object)adaptor.create(ASSIGN152);
			adaptor.addChild(root_0, ASSIGN152_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:381:29: ( ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE ) |vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] )
			int alt31=15;
			switch ( input.LA(1) ) {
			case LEFTCURLY:
				{
				alt31=1;
				}
				break;
			case LEFTSQUARE:
				{
				alt31=2;
				}
				break;
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
				alt31=3;
				}
				break;
			case STRING_LITERAL:
				{
				alt31=4;
				}
				break;
			case NUMFLOAT:
				{
				alt31=5;
				}
				break;
			case NUMINT:
				{
				alt31=6;
				}
				break;
			case NUMDOUBLE:
				{
				alt31=7;
				}
				break;
			case HEX:
				{
				alt31=8;
				}
				break;
			case OCTAL:
				{
				alt31=9;
				}
				break;
			case TRUE:
				{
				alt31=10;
				}
				break;
			case FALSE:
				{
				alt31=11;
				}
				break;
			case ID:
				{
				alt31=12;
				}
				break;
			case FULL_ID:
				{
				alt31=13;
				}
				break;
			case EXP:
				{
				alt31=14;
				}
				break;
			case MINUS:
				{
				alt31=15;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}
			switch (alt31) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:382:5: ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:382:5: ( LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:383:9: LEFTCURLY map_val[proto, map] ( COMMA map_val[proto, map] )* RIGHTCURLY
					{
					LEFTCURLY153=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_field_options_keyval3091); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTCURLY153_tree = (Object)adaptor.create(LEFTCURLY153);
					adaptor.addChild(root_0, LEFTCURLY153_tree);
					}

					if ( state.backtracking==0 ) {
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (map = new java.util.LinkedHashMap<String, Object>()));
					        }
					pushFollow(FOLLOW_map_val_in_field_options_keyval3103);
					map_val154=map_val(proto, map);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val154.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:386:29: ( COMMA map_val[proto, map] )*
					loop29:
					while (true) {
						int alt29=2;
						int LA29_0 = input.LA(1);
						if ( (LA29_0==COMMA) ) {
							alt29=1;
						}

						switch (alt29) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:386:30: COMMA map_val[proto, map]
							{
							COMMA155=(Token)match(input,COMMA,FOLLOW_COMMA_in_field_options_keyval3107); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA155_tree = (Object)adaptor.create(COMMA155);
							adaptor.addChild(root_0, COMMA155_tree);
							}

							pushFollow(FOLLOW_map_val_in_field_options_keyval3109);
							map_val156=map_val(proto, map);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val156.getTree());

							}
							break;

						default :
							break loop29;
						}
					}

					RIGHTCURLY157=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_field_options_keyval3123); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTCURLY157_tree = (Object)adaptor.create(RIGHTCURLY157);
					adaptor.addChild(root_0, RIGHTCURLY157_tree);
					}

					}

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:390:5: ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:390:5: ( LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:391:9: LEFTSQUARE list_val[proto, list] ( COMMA list_val[proto, list] )* RIGHTSQUARE
					{
					LEFTSQUARE158=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_field_options_keyval3151); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSQUARE158_tree = (Object)adaptor.create(LEFTSQUARE158);
					adaptor.addChild(root_0, LEFTSQUARE158_tree);
					}

					if ( state.backtracking==0 ) {
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (list = new ArrayList<Object>()));
					        }
					pushFollow(FOLLOW_list_val_in_field_options_keyval3163);
					list_val159=list_val(proto, list);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val159.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:394:31: ( COMMA list_val[proto, list] )*
					loop30:
					while (true) {
						int alt30=2;
						int LA30_0 = input.LA(1);
						if ( (LA30_0==COMMA) ) {
							alt30=1;
						}

						switch (alt30) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:394:32: COMMA list_val[proto, list]
							{
							COMMA160=(Token)match(input,COMMA,FOLLOW_COMMA_in_field_options_keyval3167); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA160_tree = (Object)adaptor.create(COMMA160);
							adaptor.addChild(root_0, COMMA160_tree);
							}

							pushFollow(FOLLOW_list_val_in_field_options_keyval3169);
							list_val161=list_val(proto, list);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val161.getTree());

							}
							break;

						default :
							break loop30;
						}
					}

					RIGHTSQUARE162=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_field_options_keyval3183); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSQUARE162_tree = (Object)adaptor.create(RIGHTSQUARE162);
					adaptor.addChild(root_0, RIGHTSQUARE162_tree);
					}

					}

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:397:9: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_field_options_keyval3201);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) {
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (vr!=null?input.toString(vr.start,vr.stop):null));
					        }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:400:9: STRING_LITERAL
					{
					STRING_LITERAL163=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_field_options_keyval3214); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL163_tree = (Object)adaptor.create(STRING_LITERAL163);
					adaptor.addChild(root_0, STRING_LITERAL163_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), getStringFromStringLiteral((STRING_LITERAL163!=null?STRING_LITERAL163.getText():null)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.String || field instanceof Field.Bytes)
					                    field.defaultValue = getStringFromStringLiteral((STRING_LITERAL163!=null?STRING_LITERAL163.getText():null));
					                else
					                    throw err(field, " has an invalid string default value", proto);
					                
					                // not putting the 'default' key in the field options
					                //field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:418:9: NUMFLOAT
					{
					NUMFLOAT164=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_field_options_keyval3226); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT164_tree = (Object)adaptor.create(NUMFLOAT164);
					adaptor.addChild(root_0, NUMFLOAT164_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Float.valueOf((NUMFLOAT164!=null?NUMFLOAT164.getText():null)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Float)
					                    field.defaultValue = Float.valueOf((NUMFLOAT164!=null?NUMFLOAT164.getText():null));
					                else if (field instanceof Field.Double) 
					                    field.defaultValue = Double.valueOf((NUMFLOAT164!=null?NUMFLOAT164.getText():null));
					                else
					                    throw err(field, " has an invalid float default value", proto);
					                
					                // not putting the 'default' key in the field options
					                //field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:438:9: NUMINT
					{
					NUMINT165=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_field_options_keyval3239); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT165_tree = (Object)adaptor.create(NUMINT165);
					adaptor.addChild(root_0, NUMINT165_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), parseNumber((NUMINT165!=null?NUMINT165.getText():null)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Number) {
					                    if (field instanceof Field.Float)
					                        field.defaultValue = Float.valueOf((NUMINT165!=null?NUMINT165.getText():null));
					                    else if (field instanceof Field.Double) 
					                        field.defaultValue = Double.valueOf((NUMINT165!=null?NUMINT165.getText():null));
					                    else if (field.getClass().getSimpleName().endsWith("64"))
					                        field.defaultValue = validate(proto, field, Long.parseLong((NUMINT165!=null?NUMINT165.getText():null)));
					                    else
					                        field.defaultValue = validate(proto, field, Integer.parseInt((NUMINT165!=null?NUMINT165.getText():null)));
					                }
					                else
					                    throw err(field, " has an invalid numeric default value", proto);
					                
					                // not putting the 'default' key in the field options
					                //field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:464:9: NUMDOUBLE
					{
					NUMDOUBLE166=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_field_options_keyval3251); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE166_tree = (Object)adaptor.create(NUMDOUBLE166);
					adaptor.addChild(root_0, NUMDOUBLE166_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Double.valueOf((NUMDOUBLE166!=null?NUMDOUBLE166.getText():null)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);

					                if (field instanceof Field.Float)
					                    field.defaultValue = Float.valueOf((NUMDOUBLE166!=null?NUMDOUBLE166.getText():null));
					                else if (field instanceof Field.Double) 
					                    field.defaultValue = Double.valueOf((NUMDOUBLE166!=null?NUMDOUBLE166.getText():null));
					                else
					                    throw err(field, " has an invalid double default value", proto);
					                
					                // not putting the 'default' key in the field options
					                //field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:484:9: HEX
					{
					HEX167=(Token)match(input,HEX,FOLLOW_HEX_in_field_options_keyval3263); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					HEX167_tree = (Object)adaptor.create(HEX167);
					adaptor.addChild(root_0, HEX167_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Long.valueOf(TextFormat.parseLong(proto, field, (HEX167!=null?HEX167.getText():null), true)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Number) {
					                    if (field instanceof Field.Float)
					                        field.defaultValue = new Float(Long.decode((HEX167!=null?HEX167.getText():null)).floatValue());
					                    else if (field instanceof Field.Double) 
					                        field.defaultValue = new Double(Long.decode((HEX167!=null?HEX167.getText():null)).doubleValue());
					                    else if (field.getClass().getSimpleName().endsWith("64")) {
					                        field.defaultValue = Long.valueOf(validate(proto, field, TextFormat.parseLong(proto, field, (HEX167!=null?HEX167.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    } else {
					                        field.defaultValue = Integer.valueOf(validate(proto, field, TextFormat.parseInt(proto, field, (HEX167!=null?HEX167.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    }
					                }
					                else if (field instanceof Field.Bytes) {
					                    field.defaultValue = (HEX167!=null?HEX167.getText():null);
					                }
					                else
					                    throw err(field, " has an invalid numeric default value", proto);
					                
					                // not putting the 'default' key in the field options
					                //field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 9 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:516:9: OCTAL
					{
					OCTAL168=(Token)match(input,OCTAL,FOLLOW_OCTAL_in_field_options_keyval3275); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OCTAL168_tree = (Object)adaptor.create(OCTAL168);
					adaptor.addChild(root_0, OCTAL168_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Integer.valueOf(TextFormat.parseInt(proto, field, (OCTAL168!=null?OCTAL168.getText():null), true)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Number) {
					                    if (field instanceof Field.Float)
					                        field.defaultValue = new Float(Long.decode((OCTAL168!=null?OCTAL168.getText():null)).floatValue());
					                    else if (field instanceof Field.Double) 
					                        field.defaultValue = new Double(Long.decode((OCTAL168!=null?OCTAL168.getText():null)).doubleValue());
					                    else if (field.getClass().getSimpleName().endsWith("64")) {
					                        field.defaultValue = Long.valueOf(validate(proto, field, TextFormat.parseLong(proto, field, (OCTAL168!=null?OCTAL168.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    } else {
					                        field.defaultValue = Integer.valueOf(validate(proto, field, TextFormat.parseInt(proto, field, (OCTAL168!=null?OCTAL168.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    }
					                }
					                else
					                    throw err(field, " has an invalid numeric default value", proto);
					                
					                // not putting the 'default' key in the field options
					                //field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), field.defaultValue);
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 10 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:545:9: TRUE
					{
					TRUE169=(Token)match(input,TRUE,FOLLOW_TRUE_in_field_options_keyval3287); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE169_tree = (Object)adaptor.create(TRUE169);
					adaptor.addChild(root_0, TRUE169_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Boolean.TRUE);
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Bool)
					                    field.defaultValue = Boolean.TRUE;
					                else
					                    throw err(field, " has an invalid bool default value", proto);
					                
					                // not putting the 'default' key in the field options
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 11 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:562:9: FALSE
					{
					FALSE170=(Token)match(input,FALSE,FOLLOW_FALSE_in_field_options_keyval3303); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE170_tree = (Object)adaptor.create(FALSE170);
					adaptor.addChild(root_0, FALSE170_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Boolean.FALSE);
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Bool)
					                    field.defaultValue = Boolean.FALSE;
					                else
					                    throw err(field, " has an invalid bool default value", proto);
					                
					                // not putting the 'default' key in the field options
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 12 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:579:9: val= ID
					{
					val=(Token)match(input,ID,FOLLOW_ID_in_field_options_keyval3317); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					val_tree = (Object)adaptor.create(val);
					adaptor.addChild(root_0, val_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putStandardOption((key!=null?input.toString(key.start,key.stop):null), (val!=null?val.getText():null));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
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
					                        throw err(field, " has an invalid default value", proto);
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
					                        throw err(field, " has an invalid default value", proto);
					                }
					                
					                // not putting the 'default' key in the field options
					            }
					            else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 13 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:620:9: FULL_ID
					{
					FULL_ID171=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_field_options_keyval3329); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID171_tree = (Object)adaptor.create(FULL_ID171);
					adaptor.addChild(root_0, FULL_ID171_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putStandardOption((key!=null?input.toString(key.start,key.stop):null), (FULL_ID171!=null?FULL_ID171.getText():null));
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 14 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:627:9: EXP
					{
					EXP172=(Token)match(input,EXP,FOLLOW_EXP_in_field_options_keyval3341); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EXP172_tree = (Object)adaptor.create(EXP172);
					adaptor.addChild(root_0, EXP172_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (EXP172!=null?EXP172.getText():null));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Float)
					                    field.defaultValue = Float.valueOf((EXP172!=null?EXP172.getText():null));
					                else if (field instanceof Field.Double)
					                    field.defaultValue = Double.valueOf((EXP172!=null?EXP172.getText():null));
					                else
					                    throw err(field, " has an invalid float default value", proto);
					                
					                // not putting the 'default' key in the field options
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 15 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:646:9: signed_constant[proto, message, field, $key.text, checkDefault]
					{
					pushFollow(FOLLOW_signed_constant_in_field_options_keyval3353);
					signed_constant173=signed_constant(proto, message, field, (key!=null?input.toString(key.start,key.stop):null), checkDefault);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_constant173.getTree());

					if ( state.backtracking==0 ) {
					            // handled by signed_constant
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (signed_constant173!=null?input.toString(signed_constant173.start,signed_constant173.stop):null));
					            } else if (!checkDefault) {
					                warnDefaultKeyword(field, proto);
					            }
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:657:1: signed_constant[Proto proto, HasFields message, Field field, String key, boolean checkDefault] : MINUS ID ;
	public final ProtoParser.signed_constant_return signed_constant(Proto proto, HasFields message, Field field, String key, boolean checkDefault) throws RecognitionException {
		ProtoParser.signed_constant_return retval = new ProtoParser.signed_constant_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MINUS174=null;
		Token ID175=null;

		Object MINUS174_tree=null;
		Object ID175_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:658:5: ( MINUS ID )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:658:9: MINUS ID
			{
			root_0 = (Object)adaptor.nil();


			MINUS174=(Token)match(input,MINUS,FOLLOW_MINUS_in_signed_constant3391); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MINUS174_tree = (Object)adaptor.create(MINUS174);
			adaptor.addChild(root_0, MINUS174_tree);
			}

			ID175=(Token)match(input,ID,FOLLOW_ID_in_signed_constant3393); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID175_tree = (Object)adaptor.create(ID175);
			adaptor.addChild(root_0, ID175_tree);
			}

			if ( state.backtracking==0 ) {
			            if (checkDefault && "default".equals(key)) {
			                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
			                    throw err(field, " can only have a single default value", proto);
			                
			                String refName = (ID175!=null?ID175.getText():null);
			                if (field instanceof Field.Float) {
			                    if ("inf".equals(refName)) {
			                        field.defaultValue = Float.NEGATIVE_INFINITY;
			                        field.defaultValueConstant = "Float.NEGATIVE_INFINITY";
			                    }
			                    else
			                        throw err(field, " has an invalid float default value", proto);
			                }
			                else if (field instanceof Field.Double) {
			                    if ("inf".equals(refName)) {
			                        field.defaultValue = Double.NEGATIVE_INFINITY;
			                        field.defaultValueConstant = "Double.NEGATIVE_INFINITY";
			                    }
			                    else
			                        throw err(field, " has an invalid double default value", proto);
			                }   
			                else
			                    throw err(field, " has an invalid default value: " + refName, proto);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:686:1: enum_block[Proto proto, Message message] : ENUM ID LEFTCURLY ( enum_body[proto, message, enumGroup] )* RIGHTCURLY ( ( SEMICOLON )? ) !;
	public final ProtoParser.enum_block_return enum_block(Proto proto, Message message) throws RecognitionException {
		ProtoParser.enum_block_return retval = new ProtoParser.enum_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ENUM176=null;
		Token ID177=null;
		Token LEFTCURLY178=null;
		Token RIGHTCURLY180=null;
		Token SEMICOLON181=null;
		ParserRuleReturnScope enum_body179 =null;

		Object ENUM176_tree=null;
		Object ID177_tree=null;
		Object LEFTCURLY178_tree=null;
		Object RIGHTCURLY180_tree=null;
		Object SEMICOLON181_tree=null;


		    EnumGroup enumGroup = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:690:5: ( ENUM ID LEFTCURLY ( enum_body[proto, message, enumGroup] )* RIGHTCURLY ( ( SEMICOLON )? ) !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:690:9: ENUM ID LEFTCURLY ( enum_body[proto, message, enumGroup] )* RIGHTCURLY ( ( SEMICOLON )? ) !
			{
			root_0 = (Object)adaptor.nil();


			ENUM176=(Token)match(input,ENUM,FOLLOW_ENUM_in_enum_block3425); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ENUM176_tree = (Object)adaptor.create(ENUM176);
			adaptor.addChild(root_0, ENUM176_tree);
			}

			ID177=(Token)match(input,ID,FOLLOW_ID_in_enum_block3427); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID177_tree = (Object)adaptor.create(ID177);
			adaptor.addChild(root_0, ID177_tree);
			}

			if ( state.backtracking==0 ) { 
			            enumGroup = new EnumGroup((ID177!=null?ID177.getText():null), message, proto);
			            proto.addAnnotationsTo(enumGroup);
			        }
			LEFTCURLY178=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_enum_block3440); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY178_tree = (Object)adaptor.create(LEFTCURLY178);
			adaptor.addChild(root_0, LEFTCURLY178_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:694:19: ( enum_body[proto, message, enumGroup] )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==AT||LA32_0==DOC_COMMENT||LA32_0==ID||LA32_0==OPTION) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:694:20: enum_body[proto, message, enumGroup]
					{
					pushFollow(FOLLOW_enum_body_in_enum_block3443);
					enum_body179=enum_body(proto, message, enumGroup);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_body179.getTree());

					}
					break;

				default :
					break loop32;
				}
			}

			RIGHTCURLY180=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_enum_block3448); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY180_tree = (Object)adaptor.create(RIGHTCURLY180);
			adaptor.addChild(root_0, RIGHTCURLY180_tree);
			}

			if ( state.backtracking==0 ) {
			            proto.checkAnnotations();
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:696:11: ( ( SEMICOLON )? )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:696:12: ( SEMICOLON )?
			{
			// com/dyuproject/fbsgen/parser/ProtoParser.g:696:12: ( SEMICOLON )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==SEMICOLON) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:696:12: SEMICOLON
					{
					SEMICOLON181=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_enum_block3453); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMICOLON181_tree = (Object)adaptor.create(SEMICOLON181);
					adaptor.addChild(root_0, SEMICOLON181_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:699:1: enum_body[Proto proto, Message message, EnumGroup enumGroup] : ( enum_field[proto, message, enumGroup] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, enumGroup] );
	public final ProtoParser.enum_body_return enum_body(Proto proto, Message message, EnumGroup enumGroup) throws RecognitionException {
		ProtoParser.enum_body_return retval = new ProtoParser.enum_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope enum_field182 =null;
		ParserRuleReturnScope annotation_entry183 =null;
		ParserRuleReturnScope comment_entry184 =null;
		ParserRuleReturnScope option_entry185 =null;


		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:700:5: ( enum_field[proto, message, enumGroup] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, enumGroup] )
			int alt34=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt34=1;
				}
				break;
			case AT:
				{
				alt34=2;
				}
				break;
			case DOC_COMMENT:
				{
				alt34=3;
				}
				break;
			case OPTION:
				{
				alt34=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}
			switch (alt34) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:700:9: enum_field[proto, message, enumGroup]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_enum_field_in_enum_body3481);
					enum_field182=enum_field(proto, message, enumGroup);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_field182.getTree());

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:701:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_enum_body3492);
					annotation_entry183=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry183.getTree());

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:702:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_enum_body3503);
					comment_entry184=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry184.getTree());

					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:703:9: option_entry[proto, enumGroup]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_enum_body3514);
					option_entry185=option_entry(proto, enumGroup);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry185.getTree());

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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:706:1: enum_field[Proto proto, Message message, EnumGroup enumGroup] : ID ASSIGN NUMINT ( enum_options[proto, enumGroup, v] )? SEMICOLON !;
	public final ProtoParser.enum_field_return enum_field(Proto proto, Message message, EnumGroup enumGroup) throws RecognitionException {
		ProtoParser.enum_field_return retval = new ProtoParser.enum_field_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID186=null;
		Token ASSIGN187=null;
		Token NUMINT188=null;
		Token SEMICOLON190=null;
		ParserRuleReturnScope enum_options189 =null;

		Object ID186_tree=null;
		Object ASSIGN187_tree=null;
		Object NUMINT188_tree=null;
		Object SEMICOLON190_tree=null;


		    EnumGroup.Value v = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:710:5: ( ID ASSIGN NUMINT ( enum_options[proto, enumGroup, v] )? SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:710:9: ID ASSIGN NUMINT ( enum_options[proto, enumGroup, v] )? SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			ID186=(Token)match(input,ID,FOLLOW_ID_in_enum_field3541); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID186_tree = (Object)adaptor.create(ID186);
			adaptor.addChild(root_0, ID186_tree);
			}

			ASSIGN187=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_enum_field3543); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN187_tree = (Object)adaptor.create(ASSIGN187);
			adaptor.addChild(root_0, ASSIGN187_tree);
			}

			NUMINT188=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_enum_field3545); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NUMINT188_tree = (Object)adaptor.create(NUMINT188);
			adaptor.addChild(root_0, NUMINT188_tree);
			}

			if ( state.backtracking==0 ) {
			            v = new EnumGroup.Value((ID186!=null?ID186.getText():null), Integer.parseInt((NUMINT188!=null?NUMINT188.getText():null)), enumGroup);
			            proto.addAnnotationsTo(v);
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:713:11: ( enum_options[proto, enumGroup, v] )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==LEFTSQUARE) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:713:12: enum_options[proto, enumGroup, v]
					{
					pushFollow(FOLLOW_enum_options_in_enum_field3550);
					enum_options189=enum_options(proto, enumGroup, v);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_options189.getTree());

					}
					break;

			}

			SEMICOLON190=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_enum_field3555); if (state.failed) return retval;
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:716:1: enum_options[Proto proto, EnumGroup enumGroup, EnumGroup.Value v] : LEFTSQUARE field_options_keyval[proto, null, v.field, false] ( COMMA field_options_keyval[proto, null, v.field, false] )* RIGHTSQUARE ;
	public final ProtoParser.enum_options_return enum_options(Proto proto, EnumGroup enumGroup, EnumGroup.Value v) throws RecognitionException {
		ProtoParser.enum_options_return retval = new ProtoParser.enum_options_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTSQUARE191=null;
		Token COMMA193=null;
		Token RIGHTSQUARE195=null;
		ParserRuleReturnScope field_options_keyval192 =null;
		ParserRuleReturnScope field_options_keyval194 =null;

		Object LEFTSQUARE191_tree=null;
		Object COMMA193_tree=null;
		Object RIGHTSQUARE195_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:717:5: ( LEFTSQUARE field_options_keyval[proto, null, v.field, false] ( COMMA field_options_keyval[proto, null, v.field, false] )* RIGHTSQUARE )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:717:9: LEFTSQUARE field_options_keyval[proto, null, v.field, false] ( COMMA field_options_keyval[proto, null, v.field, false] )* RIGHTSQUARE
			{
			root_0 = (Object)adaptor.nil();


			LEFTSQUARE191=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_enum_options3578); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTSQUARE191_tree = (Object)adaptor.create(LEFTSQUARE191);
			adaptor.addChild(root_0, LEFTSQUARE191_tree);
			}

			pushFollow(FOLLOW_field_options_keyval_in_enum_options3580);
			field_options_keyval192=field_options_keyval(proto, null, v.field, false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval192.getTree());

			// com/dyuproject/fbsgen/parser/ProtoParser.g:718:9: ( COMMA field_options_keyval[proto, null, v.field, false] )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==COMMA) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:718:10: COMMA field_options_keyval[proto, null, v.field, false]
					{
					COMMA193=(Token)match(input,COMMA,FOLLOW_COMMA_in_enum_options3593); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA193_tree = (Object)adaptor.create(COMMA193);
					adaptor.addChild(root_0, COMMA193_tree);
					}

					pushFollow(FOLLOW_field_options_keyval_in_enum_options3595);
					field_options_keyval194=field_options_keyval(proto, null, v.field, false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval194.getTree());

					}
					break;

				default :
					break loop36;
				}
			}

			RIGHTSQUARE195=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_enum_options3600); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTSQUARE195_tree = (Object)adaptor.create(RIGHTSQUARE195);
			adaptor.addChild(root_0, RIGHTSQUARE195_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:721:1: service_block[Proto proto, Message message] : SERVICE ID LEFTCURLY ( service_body[proto, service] )+ RIGHTCURLY ( ( SEMICOLON )? ) !;
	public final ProtoParser.service_block_return service_block(Proto proto, Message message) throws RecognitionException {
		ProtoParser.service_block_return retval = new ProtoParser.service_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SERVICE196=null;
		Token ID197=null;
		Token LEFTCURLY198=null;
		Token RIGHTCURLY200=null;
		Token SEMICOLON201=null;
		ParserRuleReturnScope service_body199 =null;

		Object SERVICE196_tree=null;
		Object ID197_tree=null;
		Object LEFTCURLY198_tree=null;
		Object RIGHTCURLY200_tree=null;
		Object SEMICOLON201_tree=null;


		    Service service = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:725:5: ( SERVICE ID LEFTCURLY ( service_body[proto, service] )+ RIGHTCURLY ( ( SEMICOLON )? ) !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:725:9: SERVICE ID LEFTCURLY ( service_body[proto, service] )+ RIGHTCURLY ( ( SEMICOLON )? ) !
			{
			root_0 = (Object)adaptor.nil();


			SERVICE196=(Token)match(input,SERVICE,FOLLOW_SERVICE_in_service_block3630); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SERVICE196_tree = (Object)adaptor.create(SERVICE196);
			adaptor.addChild(root_0, SERVICE196_tree);
			}

			ID197=(Token)match(input,ID,FOLLOW_ID_in_service_block3632); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID197_tree = (Object)adaptor.create(ID197);
			adaptor.addChild(root_0, ID197_tree);
			}

			if ( state.backtracking==0 ) { 
			            service = new Service((ID197!=null?ID197.getText():null), message, proto); 
			            proto.addAnnotationsTo(service);
			        }
			LEFTCURLY198=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_service_block3636); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY198_tree = (Object)adaptor.create(LEFTCURLY198);
			adaptor.addChild(root_0, LEFTCURLY198_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:729:9: ( service_body[proto, service] )+
			int cnt37=0;
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( (LA37_0==AT||LA37_0==DOC_COMMENT||LA37_0==OPTION||LA37_0==RPC) ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:729:10: service_body[proto, service]
					{
					pushFollow(FOLLOW_service_body_in_service_block3647);
					service_body199=service_body(proto, service);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, service_body199.getTree());

					}
					break;

				default :
					if ( cnt37 >= 1 ) break loop37;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(37, input);
					throw eee;
				}
				cnt37++;
			}

			RIGHTCURLY200=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_service_block3652); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY200_tree = (Object)adaptor.create(RIGHTCURLY200);
			adaptor.addChild(root_0, RIGHTCURLY200_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:729:52: ( ( SEMICOLON )? )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:729:53: ( SEMICOLON )?
			{
			// com/dyuproject/fbsgen/parser/ProtoParser.g:729:53: ( SEMICOLON )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==SEMICOLON) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:729:53: SEMICOLON
					{
					SEMICOLON201=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_service_block3655); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMICOLON201_tree = (Object)adaptor.create(SEMICOLON201);
					adaptor.addChild(root_0, SEMICOLON201_tree);
					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
			            if (service.rpcMethods.isEmpty())
			                throw err(service, " must declare at least one rpc", proto);
			                
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:737:1: service_body[Proto proto, Service service] : ( rpc_block[proto, service] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, service] );
	public final ProtoParser.service_body_return service_body(Proto proto, Service service) throws RecognitionException {
		ProtoParser.service_body_return retval = new ProtoParser.service_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope rpc_block202 =null;
		ParserRuleReturnScope annotation_entry203 =null;
		ParserRuleReturnScope comment_entry204 =null;
		ParserRuleReturnScope option_entry205 =null;


		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:738:5: ( rpc_block[proto, service] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, service] )
			int alt39=4;
			switch ( input.LA(1) ) {
			case RPC:
				{
				alt39=1;
				}
				break;
			case AT:
				{
				alt39=2;
				}
				break;
			case DOC_COMMENT:
				{
				alt39=3;
				}
				break;
			case OPTION:
				{
				alt39=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}
			switch (alt39) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:738:9: rpc_block[proto, service]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_rpc_block_in_service_body3685);
					rpc_block202=rpc_block(proto, service);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rpc_block202.getTree());

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:739:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_service_body3696);
					annotation_entry203=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry203.getTree());

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:740:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_service_body3707);
					comment_entry204=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry204.getTree());

					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:741:9: option_entry[proto, service]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_service_body3718);
					option_entry205=option_entry(proto, service);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry205.getTree());

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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:744:1: rpc_block[Proto proto, Service service] : RPC n= ID LEFTPAREN (ap= FULL_ID |a= ( VOID | ID ) ) RIGHTPAREN RETURNS LEFTPAREN (rp= FULL_ID |r= ( VOID | ID ) ) RIGHTPAREN ( rpc_body_block[proto, rm] )? SEMICOLON !;
	public final ProtoParser.rpc_block_return rpc_block(Proto proto, Service service) throws RecognitionException {
		ProtoParser.rpc_block_return retval = new ProtoParser.rpc_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;
		Token ap=null;
		Token a=null;
		Token rp=null;
		Token r=null;
		Token RPC206=null;
		Token LEFTPAREN207=null;
		Token RIGHTPAREN208=null;
		Token RETURNS209=null;
		Token LEFTPAREN210=null;
		Token RIGHTPAREN211=null;
		Token SEMICOLON213=null;
		ParserRuleReturnScope rpc_body_block212 =null;

		Object n_tree=null;
		Object ap_tree=null;
		Object a_tree=null;
		Object rp_tree=null;
		Object r_tree=null;
		Object RPC206_tree=null;
		Object LEFTPAREN207_tree=null;
		Object RIGHTPAREN208_tree=null;
		Object RETURNS209_tree=null;
		Object LEFTPAREN210_tree=null;
		Object RIGHTPAREN211_tree=null;
		Object SEMICOLON213_tree=null;


		    String argName = null, argPackage = null, retName = null, retPackage = null;
		    Service.RpcMethod rm = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:749:5: ( RPC n= ID LEFTPAREN (ap= FULL_ID |a= ( VOID | ID ) ) RIGHTPAREN RETURNS LEFTPAREN (rp= FULL_ID |r= ( VOID | ID ) ) RIGHTPAREN ( rpc_body_block[proto, rm] )? SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:749:9: RPC n= ID LEFTPAREN (ap= FULL_ID |a= ( VOID | ID ) ) RIGHTPAREN RETURNS LEFTPAREN (rp= FULL_ID |r= ( VOID | ID ) ) RIGHTPAREN ( rpc_body_block[proto, rm] )? SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			RPC206=(Token)match(input,RPC,FOLLOW_RPC_in_rpc_block3749); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPC206_tree = (Object)adaptor.create(RPC206);
			adaptor.addChild(root_0, RPC206_tree);
			}

			n=(Token)match(input,ID,FOLLOW_ID_in_rpc_block3753); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			n_tree = (Object)adaptor.create(n);
			adaptor.addChild(root_0, n_tree);
			}

			LEFTPAREN207=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_rpc_block3755); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTPAREN207_tree = (Object)adaptor.create(LEFTPAREN207);
			adaptor.addChild(root_0, LEFTPAREN207_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:749:28: (ap= FULL_ID |a= ( VOID | ID ) )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==FULL_ID) ) {
				alt40=1;
			}
			else if ( (LA40_0==ID||LA40_0==VOID) ) {
				alt40=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:749:29: ap= FULL_ID
					{
					ap=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_rpc_block3760); if (state.failed) return retval;
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:754:13: a= ( VOID | ID )
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

			RIGHTPAREN208=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_rpc_block3777); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTPAREN208_tree = (Object)adaptor.create(RIGHTPAREN208);
			adaptor.addChild(root_0, RIGHTPAREN208_tree);
			}

			RETURNS209=(Token)match(input,RETURNS,FOLLOW_RETURNS_in_rpc_block3788); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RETURNS209_tree = (Object)adaptor.create(RETURNS209);
			adaptor.addChild(root_0, RETURNS209_tree);
			}

			LEFTPAREN210=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_rpc_block3790); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTPAREN210_tree = (Object)adaptor.create(LEFTPAREN210);
			adaptor.addChild(root_0, LEFTPAREN210_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:755:27: (rp= FULL_ID |r= ( VOID | ID ) )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==FULL_ID) ) {
				alt41=1;
			}
			else if ( (LA41_0==ID||LA41_0==VOID) ) {
				alt41=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:755:28: rp= FULL_ID
					{
					rp=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_rpc_block3795); if (state.failed) return retval;
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:760:13: r= ( VOID | ID )
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

			RIGHTPAREN211=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_rpc_block3812); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTPAREN211_tree = (Object)adaptor.create(RIGHTPAREN211);
			adaptor.addChild(root_0, RIGHTPAREN211_tree);
			}

			if ( state.backtracking==0 ) {
			            rm = service.addRpcMethod((n!=null?n.getText():null), argName, argPackage, retName, retPackage);
			            proto.addAnnotationsTo(rm);
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:763:11: ( rpc_body_block[proto, rm] )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==LEFTCURLY) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:763:11: rpc_body_block[proto, rm]
					{
					pushFollow(FOLLOW_rpc_body_block_in_rpc_block3816);
					rpc_body_block212=rpc_body_block(proto, rm);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rpc_body_block212.getTree());

					}
					break;

			}

			SEMICOLON213=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_rpc_block3820); if (state.failed) return retval;
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:766:1: rpc_body_block[Proto proto, Service.RpcMethod rm] : LEFTCURLY ( option_entry[proto, rm] )* RIGHTCURLY ;
	public final ProtoParser.rpc_body_block_return rpc_body_block(Proto proto, Service.RpcMethod rm) throws RecognitionException {
		ProtoParser.rpc_body_block_return retval = new ProtoParser.rpc_body_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTCURLY214=null;
		Token RIGHTCURLY216=null;
		ParserRuleReturnScope option_entry215 =null;

		Object LEFTCURLY214_tree=null;
		Object RIGHTCURLY216_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:767:5: ( LEFTCURLY ( option_entry[proto, rm] )* RIGHTCURLY )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:767:9: LEFTCURLY ( option_entry[proto, rm] )* RIGHTCURLY
			{
			root_0 = (Object)adaptor.nil();


			LEFTCURLY214=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_rpc_body_block3846); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY214_tree = (Object)adaptor.create(LEFTCURLY214);
			adaptor.addChild(root_0, LEFTCURLY214_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:767:19: ( option_entry[proto, rm] )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==OPTION) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:767:19: option_entry[proto, rm]
					{
					pushFollow(FOLLOW_option_entry_in_rpc_body_block3848);
					option_entry215=option_entry(proto, rm);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry215.getTree());

					}
					break;

				default :
					break loop43;
				}
			}

			RIGHTCURLY216=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_rpc_body_block3852); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY216_tree = (Object)adaptor.create(RIGHTCURLY216);
			adaptor.addChild(root_0, RIGHTCURLY216_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:803:1: ignore_block : LEFTCURLY ( ignore_block_body )* RIGHTCURLY ;
	public final ProtoParser.ignore_block_return ignore_block() throws RecognitionException {
		ProtoParser.ignore_block_return retval = new ProtoParser.ignore_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTCURLY217=null;
		Token RIGHTCURLY219=null;
		ParserRuleReturnScope ignore_block_body218 =null;

		Object LEFTCURLY217_tree=null;
		Object RIGHTCURLY219_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:804:5: ( LEFTCURLY ( ignore_block_body )* RIGHTCURLY )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:804:9: LEFTCURLY ( ignore_block_body )* RIGHTCURLY
			{
			root_0 = (Object)adaptor.nil();


			LEFTCURLY217=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_ignore_block3916); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY217_tree = (Object)adaptor.create(LEFTCURLY217);
			adaptor.addChild(root_0, LEFTCURLY217_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:804:19: ( ignore_block_body )*
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( ((LA44_0 >= ASSIGN && LA44_0 <= RETURNS)||(LA44_0 >= RIGHTPAREN && LA44_0 <= WS)) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:804:19: ignore_block_body
					{
					pushFollow(FOLLOW_ignore_block_body_in_ignore_block3918);
					ignore_block_body218=ignore_block_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_block_body218.getTree());

					}
					break;

				default :
					break loop44;
				}
			}

			RIGHTCURLY219=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_ignore_block3921); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY219_tree = (Object)adaptor.create(RIGHTCURLY219);
			adaptor.addChild(root_0, RIGHTCURLY219_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:807:1: ignore_block_body : ( ( LEFTCURLY )=> ignore_block |~ RIGHTCURLY );
	public final ProtoParser.ignore_block_body_return ignore_block_body() throws RecognitionException {
		ProtoParser.ignore_block_body_return retval = new ProtoParser.ignore_block_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set221=null;
		ParserRuleReturnScope ignore_block220 =null;

		Object set221_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:808:5: ( ( LEFTCURLY )=> ignore_block |~ RIGHTCURLY )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==LEFTCURLY) ) {
				int LA45_1 = input.LA(2);
				if ( (synpred1_ProtoParser()) ) {
					alt45=1;
				}
				else if ( (true) ) {
					alt45=2;
				}

			}
			else if ( ((LA45_0 >= ASSIGN && LA45_0 <= INT8)||(LA45_0 >= LEFTPAREN && LA45_0 <= RETURNS)||(LA45_0 >= RIGHTPAREN && LA45_0 <= WS)) ) {
				alt45=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:808:9: ( LEFTCURLY )=> ignore_block
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ignore_block_in_ignore_block_body3949);
					ignore_block220=ignore_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_block220.getTree());

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:809:9: ~ RIGHTCURLY
					{
					root_0 = (Object)adaptor.nil();


					set221=input.LT(1);
					if ( (input.LA(1) >= ASSIGN && input.LA(1) <= RETURNS)||(input.LA(1) >= RIGHTPAREN && input.LA(1) <= WS) ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set221));
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
		// com/dyuproject/fbsgen/parser/ProtoParser.g:808:9: ( LEFTCURLY )
		// com/dyuproject/fbsgen/parser/ProtoParser.g:808:10: LEFTCURLY
		{
		match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_synpred1_ProtoParser3945); if (state.failed) return;

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



	public static final BitSet FOLLOW_statement_in_parse178 = new BitSet(new long[]{0x0048028100805020L});
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
	public static final BitSet FOLLOW_AT_in_annotation_entry596 = new BitSet(new long[]{0x5EDA3B818FC468C0L});
	public static final BitSet FOLLOW_var_in_annotation_entry598 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_LEFTPAREN_in_annotation_entry611 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_annotation_keyval_in_annotation_entry622 = new BitSet(new long[]{0x0000800000000200L});
	public static final BitSet FOLLOW_COMMA_in_annotation_entry626 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_annotation_keyval_in_annotation_entry628 = new BitSet(new long[]{0x0000800000000200L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_annotation_entry642 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_list_val704 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_list_val724 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_list_val728 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_list_val730 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_list_val752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_list_val812 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_list_val832 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_list_val836 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_list_val838 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_list_val860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_reserved_in_list_val894 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_list_val914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_list_val936 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_list_val956 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_list_val976 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_list_val996 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_list_val1016 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_list_val1036 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_list_val1056 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_full_in_map_val1096 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COLON_in_map_val1098 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_LEFTCURLY_in_map_val1132 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_map_val1152 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_map_val1156 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_map_val1158 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_map_val1180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_map_val1240 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_map_val1260 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_map_val1264 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_map_val1266 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_map_val1288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_reserved_in_map_val1322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_map_val1342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_map_val1364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_map_val1384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_map_val1404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_map_val1424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_map_val1444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_map_val1464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_map_val1484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_full_in_annotation_keyval1524 = new BitSet(new long[]{0x0000000000000110L});
	public static final BitSet FOLLOW_set_in_annotation_keyval1526 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_LEFTCURLY_in_annotation_keyval1564 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_annotation_keyval1584 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_annotation_keyval1588 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_annotation_keyval1590 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_annotation_keyval1612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_annotation_keyval1672 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_annotation_keyval1692 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_annotation_keyval1696 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_annotation_keyval1698 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_annotation_keyval1720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_reserved_in_annotation_keyval1754 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_annotation_keyval1774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_annotation_keyval1796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_annotation_keyval1816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_annotation_keyval1836 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_annotation_keyval1856 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_annotation_keyval1876 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_annotation_keyval1896 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_annotation_keyval1916 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYNTAX_in_header_syntax1949 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_header_syntax1951 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_header_syntax1953 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_header_syntax1955 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PKG_in_header_package1984 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_FULL_ID_in_header_package1987 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_var_in_header_package1993 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_header_package1998 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_header_import2026 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_header_import2028 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_header_import2030 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTION_in_option_entry2059 = new BitSet(new long[]{0x5EDA3B81AFCC68C0L});
	public static final BitSet FOLLOW_LEFTPAREN_in_option_entry2061 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_var_full_in_option_entry2066 = new BitSet(new long[]{0x0000800000000010L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_option_entry2068 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_option_entry2071 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_LEFTCURLY_in_option_entry2105 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_option_entry2125 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_option_entry2129 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_option_entry2131 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_option_entry2153 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_option_entry2213 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_option_entry2233 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_option_entry2237 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_option_entry2239 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_option_entry2261 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_var_reserved_in_option_entry2295 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_ID_in_option_entry2317 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_FULL_ID_in_option_entry2339 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_NUMFLOAT_in_option_entry2359 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_NUMINT_in_option_entry2379 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_option_entry2399 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_TRUE_in_option_entry2419 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_FALSE_in_option_entry2439 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_option_entry2459 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_option_entry2473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MESSAGE_in_message_block2506 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_message_block2508 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_message_block2521 = new BitSet(new long[]{0x0008598100005020L});
	public static final BitSet FOLLOW_message_body_in_message_block2524 = new BitSet(new long[]{0x0008598100005020L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_message_block2529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_message_block_in_message_body2552 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_message_field_in_message_body2563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_block_in_message_body2574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_service_block_in_message_body2585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_message_body2606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_message_body2617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_message_body2628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_message_field2676 = new BitSet(new long[]{0x1E1000000F4C20C0L});
	public static final BitSet FOLLOW_REQUIRED_in_message_field2693 = new BitSet(new long[]{0x1E1000000F4C20C0L});
	public static final BitSet FOLLOW_REPEATED_in_message_field2710 = new BitSet(new long[]{0x1E1000000F4C20C0L});
	public static final BitSet FOLLOW_field_type_in_message_field2725 = new BitSet(new long[]{0x5EDA3B818FC468C0L});
	public static final BitSet FOLLOW_var_in_message_field2737 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_message_field2739 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_NUMINT_in_message_field2741 = new BitSet(new long[]{0x0004000050000000L});
	public static final BitSet FOLLOW_field_options_in_message_field2755 = new BitSet(new long[]{0x0004000010000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_message_field2771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ignore_block_in_message_field2776 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_field_type2802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT8_in_field_type2814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT8_in_field_type2826 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT16_in_field_type2838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT16_in_field_type2850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT32_in_field_type2862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT32_in_field_type2874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT64_in_field_type2886 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT64_in_field_type2898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_field_type2910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_in_field_type2922 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_field_type2934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BYTES_in_field_type2946 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_field_type2978 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_field_type2990 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_field_options3017 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_field_options3019 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_field_options3032 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_field_options3034 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_field_options3039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_full_in_field_options_keyval3071 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_field_options_keyval3073 = new BitSet(new long[]{0x5FFA3BBFDFDF68C0L});
	public static final BitSet FOLLOW_LEFTCURLY_in_field_options_keyval3091 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_field_options_keyval3103 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_field_options_keyval3107 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_field_options_keyval3109 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_field_options_keyval3123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_field_options_keyval3151 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_field_options_keyval3163 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_field_options_keyval3167 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_list_val_in_field_options_keyval3169 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_field_options_keyval3183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_reserved_in_field_options_keyval3201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_field_options_keyval3214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_field_options_keyval3226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_field_options_keyval3239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_field_options_keyval3251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HEX_in_field_options_keyval3263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OCTAL_in_field_options_keyval3275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_field_options_keyval3287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_field_options_keyval3303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_field_options_keyval3317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_field_options_keyval3329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXP_in_field_options_keyval3341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_signed_constant_in_field_options_keyval3353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_signed_constant3391 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_signed_constant3393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ENUM_in_enum_block3425 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_enum_block3427 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_enum_block3440 = new BitSet(new long[]{0x0000408000401020L});
	public static final BitSet FOLLOW_enum_body_in_enum_block3443 = new BitSet(new long[]{0x0000408000401020L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_enum_block3448 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_enum_block3453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_field_in_enum_body3481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_enum_body3492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_enum_body3503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_enum_body3514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_enum_field3541 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_enum_field3543 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_NUMINT_in_enum_field3545 = new BitSet(new long[]{0x0004000040000000L});
	public static final BitSet FOLLOW_enum_options_in_enum_field3550 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_enum_field3555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_enum_options3578 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_enum_options3580 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_enum_options3593 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_enum_options3595 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_enum_options3600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SERVICE_in_service_block3630 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_service_block3632 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_service_block3636 = new BitSet(new long[]{0x0002008000001020L});
	public static final BitSet FOLLOW_service_body_in_service_block3647 = new BitSet(new long[]{0x0002408000001020L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_service_block3652 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_service_block3655 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rpc_block_in_service_body3685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_service_body3696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_service_body3707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_service_body3718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RPC_in_rpc_block3749 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_rpc_block3753 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_rpc_block3755 = new BitSet(new long[]{0x4000000000480000L});
	public static final BitSet FOLLOW_FULL_ID_in_rpc_block3760 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_set_in_rpc_block3768 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_rpc_block3777 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RETURNS_in_rpc_block3788 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_rpc_block3790 = new BitSet(new long[]{0x4000000000480000L});
	public static final BitSet FOLLOW_FULL_ID_in_rpc_block3795 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_set_in_rpc_block3803 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_rpc_block3812 = new BitSet(new long[]{0x0004000010000000L});
	public static final BitSet FOLLOW_rpc_body_block_in_rpc_block3816 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_rpc_block3820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_rpc_body_block3846 = new BitSet(new long[]{0x0000408000000000L});
	public static final BitSet FOLLOW_option_entry_in_rpc_body_block3848 = new BitSet(new long[]{0x0000408000000000L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_rpc_body_block3852 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_ignore_block3916 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L});
	public static final BitSet FOLLOW_ignore_block_body_in_ignore_block3918 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_ignore_block3921 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ignore_block_in_ignore_block_body3949 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_ignore_block_body3959 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_synpred1_ProtoParser3945 = new BitSet(new long[]{0x0000000000000002L});
}
