// $ANTLR 3.5.2 com/dyuproject/fbsgen/parser/ProtoParser.g 2023-06-07 19:36:46

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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:108:1: list_val[List<Object> list] : ( ( LEFTSQUARE list_val[sub] ( COMMA list_val[sub] )* RIGHTSQUARE ) | ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) ;
	public final ProtoParser.list_val_return list_val(List<Object> list) throws RecognitionException {
		ProtoParser.list_val_return retval = new ProtoParser.list_val_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTSQUARE25=null;
		Token COMMA27=null;
		Token RIGHTSQUARE29=null;
		Token LEFTCURLY30=null;
		Token COMMA32=null;
		Token RIGHTCURLY34=null;
		Token NUMFLOAT35=null;
		Token NUMINT36=null;
		Token NUMDOUBLE37=null;
		Token TRUE38=null;
		Token FALSE39=null;
		Token STRING_LITERAL40=null;
		ParserRuleReturnScope list_val26 =null;
		ParserRuleReturnScope list_val28 =null;
		ParserRuleReturnScope map_val31 =null;
		ParserRuleReturnScope map_val33 =null;

		Object LEFTSQUARE25_tree=null;
		Object COMMA27_tree=null;
		Object RIGHTSQUARE29_tree=null;
		Object LEFTCURLY30_tree=null;
		Object COMMA32_tree=null;
		Object RIGHTCURLY34_tree=null;
		Object NUMFLOAT35_tree=null;
		Object NUMINT36_tree=null;
		Object NUMDOUBLE37_tree=null;
		Object TRUE38_tree=null;
		Object FALSE39_tree=null;
		Object STRING_LITERAL40_tree=null;


		    List<Object> sub = null;
		    Map<String, Object> map = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:113:5: ( ( ( LEFTSQUARE list_val[sub] ( COMMA list_val[sub] )* RIGHTSQUARE ) | ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:113:9: ( ( LEFTSQUARE list_val[sub] ( COMMA list_val[sub] )* RIGHTSQUARE ) | ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			{
			root_0 = (Object)adaptor.nil();


			// com/dyuproject/fbsgen/parser/ProtoParser.g:113:9: ( ( LEFTSQUARE list_val[sub] ( COMMA list_val[sub] )* RIGHTSQUARE ) | ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			int alt9=8;
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
			case NUMFLOAT:
				{
				alt9=3;
				}
				break;
			case NUMINT:
				{
				alt9=4;
				}
				break;
			case NUMDOUBLE:
				{
				alt9=5;
				}
				break;
			case TRUE:
				{
				alt9=6;
				}
				break;
			case FALSE:
				{
				alt9=7;
				}
				break;
			case STRING_LITERAL:
				{
				alt9=8;
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:114:13: ( LEFTSQUARE list_val[sub] ( COMMA list_val[sub] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:114:13: ( LEFTSQUARE list_val[sub] ( COMMA list_val[sub] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:115:17: LEFTSQUARE list_val[sub] ( COMMA list_val[sub] )* RIGHTSQUARE
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
					list_val26=list_val(sub);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val26.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:118:31: ( COMMA list_val[sub] )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==COMMA) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:118:32: COMMA list_val[sub]
							{
							COMMA27=(Token)match(input,COMMA,FOLLOW_COMMA_in_list_val728); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA27_tree = (Object)adaptor.create(COMMA27);
							adaptor.addChild(root_0, COMMA27_tree);
							}

							pushFollow(FOLLOW_list_val_in_list_val730);
							list_val28=list_val(sub);
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:122:13: ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:122:13: ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:123:17: LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY
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
					map_val31=map_val(map);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val31.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:126:30: ( COMMA map_val[map] )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( (LA8_0==COMMA) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:126:31: COMMA map_val[map]
							{
							COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_list_val836); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA32_tree = (Object)adaptor.create(COMMA32);
							adaptor.addChild(root_0, COMMA32_tree);
							}

							pushFollow(FOLLOW_map_val_in_list_val838);
							map_val33=map_val(map);
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:129:17: NUMFLOAT
					{
					NUMFLOAT35=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_list_val892); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT35_tree = (Object)adaptor.create(NUMFLOAT35);
					adaptor.addChild(root_0, NUMFLOAT35_tree);
					}

					if ( state.backtracking==0 ) { list.add(Float.valueOf((NUMFLOAT35!=null?NUMFLOAT35.getText():null))); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:130:17: NUMINT
					{
					NUMINT36=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_list_val912); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT36_tree = (Object)adaptor.create(NUMINT36);
					adaptor.addChild(root_0, NUMINT36_tree);
					}

					if ( state.backtracking==0 ) { list.add(parseNumber((NUMINT36!=null?NUMINT36.getText():null))); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:131:17: NUMDOUBLE
					{
					NUMDOUBLE37=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_list_val932); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE37_tree = (Object)adaptor.create(NUMDOUBLE37);
					adaptor.addChild(root_0, NUMDOUBLE37_tree);
					}

					if ( state.backtracking==0 ) { list.add(Double.valueOf((NUMDOUBLE37!=null?NUMDOUBLE37.getText():null))); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:132:17: TRUE
					{
					TRUE38=(Token)match(input,TRUE,FOLLOW_TRUE_in_list_val952); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE38_tree = (Object)adaptor.create(TRUE38);
					adaptor.addChild(root_0, TRUE38_tree);
					}

					if ( state.backtracking==0 ) { list.add(Boolean.TRUE); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:133:17: FALSE
					{
					FALSE39=(Token)match(input,FALSE,FOLLOW_FALSE_in_list_val972); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE39_tree = (Object)adaptor.create(FALSE39);
					adaptor.addChild(root_0, FALSE39_tree);
					}

					if ( state.backtracking==0 ) { list.add(Boolean.FALSE); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:134:17: STRING_LITERAL
					{
					STRING_LITERAL40=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_list_val992); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL40_tree = (Object)adaptor.create(STRING_LITERAL40);
					adaptor.addChild(root_0, STRING_LITERAL40_tree);
					}

					if ( state.backtracking==0 ) { list.add(getStringFromStringLiteral((STRING_LITERAL40!=null?STRING_LITERAL40.getText():null))); }
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:138:1: map_val[Map<String, Object> map] : k= var_full COLON ( ( LEFTCURLY map_val[sub] ( COMMA map_val[sub] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) ;
	public final ProtoParser.map_val_return map_val(Map<String, Object> map) throws RecognitionException {
		ProtoParser.map_val_return retval = new ProtoParser.map_val_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COLON41=null;
		Token LEFTCURLY42=null;
		Token COMMA44=null;
		Token RIGHTCURLY46=null;
		Token LEFTSQUARE47=null;
		Token COMMA49=null;
		Token RIGHTSQUARE51=null;
		Token NUMFLOAT52=null;
		Token NUMINT53=null;
		Token NUMDOUBLE54=null;
		Token TRUE55=null;
		Token FALSE56=null;
		Token STRING_LITERAL57=null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope map_val43 =null;
		ParserRuleReturnScope map_val45 =null;
		ParserRuleReturnScope list_val48 =null;
		ParserRuleReturnScope list_val50 =null;

		Object COLON41_tree=null;
		Object LEFTCURLY42_tree=null;
		Object COMMA44_tree=null;
		Object RIGHTCURLY46_tree=null;
		Object LEFTSQUARE47_tree=null;
		Object COMMA49_tree=null;
		Object RIGHTSQUARE51_tree=null;
		Object NUMFLOAT52_tree=null;
		Object NUMINT53_tree=null;
		Object NUMDOUBLE54_tree=null;
		Object TRUE55_tree=null;
		Object FALSE56_tree=null;
		Object STRING_LITERAL57_tree=null;


		    Map<String, Object> sub = null;
		    List<Object> list = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:143:5: (k= var_full COLON ( ( LEFTCURLY map_val[sub] ( COMMA map_val[sub] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:143:9: k= var_full COLON ( ( LEFTCURLY map_val[sub] ( COMMA map_val[sub] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_var_full_in_map_val1032);
			k=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

			COLON41=(Token)match(input,COLON,FOLLOW_COLON_in_map_val1034); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON41_tree = (Object)adaptor.create(COLON41);
			adaptor.addChild(root_0, COLON41_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:143:26: ( ( LEFTCURLY map_val[sub] ( COMMA map_val[sub] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			int alt12=8;
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
			case NUMFLOAT:
				{
				alt12=3;
				}
				break;
			case NUMINT:
				{
				alt12=4;
				}
				break;
			case NUMDOUBLE:
				{
				alt12=5;
				}
				break;
			case TRUE:
				{
				alt12=6;
				}
				break;
			case FALSE:
				{
				alt12=7;
				}
				break;
			case STRING_LITERAL:
				{
				alt12=8;
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:144:13: ( LEFTCURLY map_val[sub] ( COMMA map_val[sub] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:144:13: ( LEFTCURLY map_val[sub] ( COMMA map_val[sub] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:145:17: LEFTCURLY map_val[sub] ( COMMA map_val[sub] )* RIGHTCURLY
					{
					LEFTCURLY42=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_map_val1068); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTCURLY42_tree = (Object)adaptor.create(LEFTCURLY42);
					adaptor.addChild(root_0, LEFTCURLY42_tree);
					}

					if ( state.backtracking==0 ) {
					                    map.put((k!=null?input.toString(k.start,k.stop):null), (sub = new java.util.LinkedHashMap<String, Object>()));
					                }
					pushFollow(FOLLOW_map_val_in_map_val1088);
					map_val43=map_val(sub);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val43.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:148:30: ( COMMA map_val[sub] )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==COMMA) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:148:31: COMMA map_val[sub]
							{
							COMMA44=(Token)match(input,COMMA,FOLLOW_COMMA_in_map_val1092); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA44_tree = (Object)adaptor.create(COMMA44);
							adaptor.addChild(root_0, COMMA44_tree);
							}

							pushFollow(FOLLOW_map_val_in_map_val1094);
							map_val45=map_val(sub);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val45.getTree());

							}
							break;

						default :
							break loop10;
						}
					}

					RIGHTCURLY46=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_map_val1116); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTCURLY46_tree = (Object)adaptor.create(RIGHTCURLY46);
					adaptor.addChild(root_0, RIGHTCURLY46_tree);
					}

					}

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:152:13: ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:152:13: ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:153:17: LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE
					{
					LEFTSQUARE47=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_map_val1176); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSQUARE47_tree = (Object)adaptor.create(LEFTSQUARE47);
					adaptor.addChild(root_0, LEFTSQUARE47_tree);
					}

					if ( state.backtracking==0 ) {
					                    map.put((k!=null?input.toString(k.start,k.stop):null), (list = new ArrayList<Object>()));
					                }
					pushFollow(FOLLOW_list_val_in_map_val1196);
					list_val48=list_val(list);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val48.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:156:32: ( COMMA list_val[list] )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==COMMA) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:156:33: COMMA list_val[list]
							{
							COMMA49=(Token)match(input,COMMA,FOLLOW_COMMA_in_map_val1200); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA49_tree = (Object)adaptor.create(COMMA49);
							adaptor.addChild(root_0, COMMA49_tree);
							}

							pushFollow(FOLLOW_list_val_in_map_val1202);
							list_val50=list_val(list);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val50.getTree());

							}
							break;

						default :
							break loop11;
						}
					}

					RIGHTSQUARE51=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_map_val1224); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSQUARE51_tree = (Object)adaptor.create(RIGHTSQUARE51);
					adaptor.addChild(root_0, RIGHTSQUARE51_tree);
					}

					}

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:159:17: NUMFLOAT
					{
					NUMFLOAT52=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_map_val1256); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT52_tree = (Object)adaptor.create(NUMFLOAT52);
					adaptor.addChild(root_0, NUMFLOAT52_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), Float.valueOf((NUMFLOAT52!=null?NUMFLOAT52.getText():null))); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:160:17: NUMINT
					{
					NUMINT53=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_map_val1276); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT53_tree = (Object)adaptor.create(NUMINT53);
					adaptor.addChild(root_0, NUMINT53_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), parseNumber((NUMINT53!=null?NUMINT53.getText():null))); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:161:17: NUMDOUBLE
					{
					NUMDOUBLE54=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_map_val1296); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE54_tree = (Object)adaptor.create(NUMDOUBLE54);
					adaptor.addChild(root_0, NUMDOUBLE54_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), Double.valueOf((NUMDOUBLE54!=null?NUMDOUBLE54.getText():null))); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:162:17: TRUE
					{
					TRUE55=(Token)match(input,TRUE,FOLLOW_TRUE_in_map_val1316); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE55_tree = (Object)adaptor.create(TRUE55);
					adaptor.addChild(root_0, TRUE55_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), Boolean.TRUE); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:163:17: FALSE
					{
					FALSE56=(Token)match(input,FALSE,FOLLOW_FALSE_in_map_val1336); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE56_tree = (Object)adaptor.create(FALSE56);
					adaptor.addChild(root_0, FALSE56_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), Boolean.FALSE); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:164:17: STRING_LITERAL
					{
					STRING_LITERAL57=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_map_val1356); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL57_tree = (Object)adaptor.create(STRING_LITERAL57);
					adaptor.addChild(root_0, STRING_LITERAL57_tree);
					}

					if ( state.backtracking==0 ) { map.put((k!=null?input.toString(k.start,k.stop):null), getStringFromStringLiteral((STRING_LITERAL57!=null?STRING_LITERAL57.getText():null))); }
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:168:1: annotation_keyval[Proto proto, Annotation annotation] : k= var_full ( ASSIGN | COLON ) ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) ;
	public final ProtoParser.annotation_keyval_return annotation_keyval(Proto proto, Annotation annotation) throws RecognitionException {
		ProtoParser.annotation_keyval_return retval = new ProtoParser.annotation_keyval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token fid=null;
		Token set58=null;
		Token LEFTCURLY59=null;
		Token COMMA61=null;
		Token RIGHTCURLY63=null;
		Token LEFTSQUARE64=null;
		Token COMMA66=null;
		Token RIGHTSQUARE68=null;
		Token ID69=null;
		Token NUMFLOAT70=null;
		Token NUMINT71=null;
		Token NUMDOUBLE72=null;
		Token TRUE73=null;
		Token FALSE74=null;
		Token STRING_LITERAL75=null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope vr =null;
		ParserRuleReturnScope map_val60 =null;
		ParserRuleReturnScope map_val62 =null;
		ParserRuleReturnScope list_val65 =null;
		ParserRuleReturnScope list_val67 =null;

		Object fid_tree=null;
		Object set58_tree=null;
		Object LEFTCURLY59_tree=null;
		Object COMMA61_tree=null;
		Object RIGHTCURLY63_tree=null;
		Object LEFTSQUARE64_tree=null;
		Object COMMA66_tree=null;
		Object RIGHTSQUARE68_tree=null;
		Object ID69_tree=null;
		Object NUMFLOAT70_tree=null;
		Object NUMINT71_tree=null;
		Object NUMDOUBLE72_tree=null;
		Object TRUE73_tree=null;
		Object FALSE74_tree=null;
		Object STRING_LITERAL75_tree=null;


		    Map<String, Object> map = null;
		    List<Object> list = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:173:5: (k= var_full ( ASSIGN | COLON ) ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:173:9: k= var_full ( ASSIGN | COLON ) ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_var_full_in_annotation_keyval1396);
			k=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

			set58=input.LT(1);
			if ( input.LA(1)==ASSIGN||input.LA(1)==COLON ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set58));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// com/dyuproject/fbsgen/parser/ProtoParser.g:173:35: ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved | ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:174:13: ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:174:13: ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:175:17: LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY
					{
					LEFTCURLY59=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_annotation_keyval1436); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTCURLY59_tree = (Object)adaptor.create(LEFTCURLY59);
					adaptor.addChild(root_0, LEFTCURLY59_tree);
					}

					if ( state.backtracking==0 ) {
					                    annotation.put((k!=null?input.toString(k.start,k.stop):null), (map = new java.util.LinkedHashMap<String, Object>()));
					                }
					pushFollow(FOLLOW_map_val_in_annotation_keyval1456);
					map_val60=map_val(map);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val60.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:178:30: ( COMMA map_val[map] )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==COMMA) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:178:31: COMMA map_val[map]
							{
							COMMA61=(Token)match(input,COMMA,FOLLOW_COMMA_in_annotation_keyval1460); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA61_tree = (Object)adaptor.create(COMMA61);
							adaptor.addChild(root_0, COMMA61_tree);
							}

							pushFollow(FOLLOW_map_val_in_annotation_keyval1462);
							map_val62=map_val(map);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val62.getTree());

							}
							break;

						default :
							break loop13;
						}
					}

					RIGHTCURLY63=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_annotation_keyval1484); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTCURLY63_tree = (Object)adaptor.create(RIGHTCURLY63);
					adaptor.addChild(root_0, RIGHTCURLY63_tree);
					}

					}

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:182:13: ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:182:13: ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:183:17: LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE
					{
					LEFTSQUARE64=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_annotation_keyval1544); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSQUARE64_tree = (Object)adaptor.create(LEFTSQUARE64);
					adaptor.addChild(root_0, LEFTSQUARE64_tree);
					}

					if ( state.backtracking==0 ) {
					                    annotation.put((k!=null?input.toString(k.start,k.stop):null), (list = new ArrayList<Object>()));
					                }
					pushFollow(FOLLOW_list_val_in_annotation_keyval1564);
					list_val65=list_val(list);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val65.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:186:32: ( COMMA list_val[list] )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==COMMA) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:186:33: COMMA list_val[list]
							{
							COMMA66=(Token)match(input,COMMA,FOLLOW_COMMA_in_annotation_keyval1568); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA66_tree = (Object)adaptor.create(COMMA66);
							adaptor.addChild(root_0, COMMA66_tree);
							}

							pushFollow(FOLLOW_list_val_in_annotation_keyval1570);
							list_val67=list_val(list);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val67.getTree());

							}
							break;

						default :
							break loop14;
						}
					}

					RIGHTSQUARE68=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_annotation_keyval1592); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSQUARE68_tree = (Object)adaptor.create(RIGHTSQUARE68);
					adaptor.addChild(root_0, RIGHTSQUARE68_tree);
					}

					}

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:189:17: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_annotation_keyval1626);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), (vr!=null?input.toString(vr.start,vr.stop):null)); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:190:17: ID
					{
					ID69=(Token)match(input,ID,FOLLOW_ID_in_annotation_keyval1646); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID69_tree = (Object)adaptor.create(ID69);
					adaptor.addChild(root_0, ID69_tree);
					}

					if ( state.backtracking==0 ) { annotation.putRef((k!=null?input.toString(k.start,k.stop):null), (ID69!=null?ID69.getText():null)); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:191:17: fid= FULL_ID
					{
					fid=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_annotation_keyval1668); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					fid_tree = (Object)adaptor.create(fid);
					adaptor.addChild(root_0, fid_tree);
					}

					if ( state.backtracking==0 ) { annotation.putRef((k!=null?input.toString(k.start,k.stop):null), (fid!=null?fid.getText():null)); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:192:17: NUMFLOAT
					{
					NUMFLOAT70=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_annotation_keyval1688); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT70_tree = (Object)adaptor.create(NUMFLOAT70);
					adaptor.addChild(root_0, NUMFLOAT70_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Float.valueOf((NUMFLOAT70!=null?NUMFLOAT70.getText():null))); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:193:17: NUMINT
					{
					NUMINT71=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_annotation_keyval1708); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT71_tree = (Object)adaptor.create(NUMINT71);
					adaptor.addChild(root_0, NUMINT71_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), parseNumber((NUMINT71!=null?NUMINT71.getText():null))); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:194:17: NUMDOUBLE
					{
					NUMDOUBLE72=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_annotation_keyval1728); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE72_tree = (Object)adaptor.create(NUMDOUBLE72);
					adaptor.addChild(root_0, NUMDOUBLE72_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Double.valueOf((NUMDOUBLE72!=null?NUMDOUBLE72.getText():null))); }
					}
					break;
				case 9 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:195:17: TRUE
					{
					TRUE73=(Token)match(input,TRUE,FOLLOW_TRUE_in_annotation_keyval1748); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE73_tree = (Object)adaptor.create(TRUE73);
					adaptor.addChild(root_0, TRUE73_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Boolean.TRUE); }
					}
					break;
				case 10 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:196:17: FALSE
					{
					FALSE74=(Token)match(input,FALSE,FOLLOW_FALSE_in_annotation_keyval1768); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE74_tree = (Object)adaptor.create(FALSE74);
					adaptor.addChild(root_0, FALSE74_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), Boolean.FALSE); }
					}
					break;
				case 11 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:197:17: STRING_LITERAL
					{
					STRING_LITERAL75=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_annotation_keyval1788); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL75_tree = (Object)adaptor.create(STRING_LITERAL75);
					adaptor.addChild(root_0, STRING_LITERAL75_tree);
					}

					if ( state.backtracking==0 ) { annotation.put((k!=null?input.toString(k.start,k.stop):null), getStringFromStringLiteral((STRING_LITERAL75!=null?STRING_LITERAL75.getText():null))); }
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:201:1: header_syntax[Proto proto] : SYNTAX ASSIGN STRING_LITERAL SEMICOLON !;
	public final ProtoParser.header_syntax_return header_syntax(Proto proto) throws RecognitionException {
		ProtoParser.header_syntax_return retval = new ProtoParser.header_syntax_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SYNTAX76=null;
		Token ASSIGN77=null;
		Token STRING_LITERAL78=null;
		Token SEMICOLON79=null;

		Object SYNTAX76_tree=null;
		Object ASSIGN77_tree=null;
		Object STRING_LITERAL78_tree=null;
		Object SEMICOLON79_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:202:5: ( SYNTAX ASSIGN STRING_LITERAL SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:202:9: SYNTAX ASSIGN STRING_LITERAL SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			SYNTAX76=(Token)match(input,SYNTAX,FOLLOW_SYNTAX_in_header_syntax1821); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SYNTAX76_tree = (Object)adaptor.create(SYNTAX76);
			adaptor.addChild(root_0, SYNTAX76_tree);
			}

			ASSIGN77=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_header_syntax1823); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN77_tree = (Object)adaptor.create(ASSIGN77);
			adaptor.addChild(root_0, ASSIGN77_tree);
			}

			STRING_LITERAL78=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_header_syntax1825); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STRING_LITERAL78_tree = (Object)adaptor.create(STRING_LITERAL78);
			adaptor.addChild(root_0, STRING_LITERAL78_tree);
			}

			SEMICOLON79=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_header_syntax1827); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			            if (!"proto2".equals(getStringFromStringLiteral((STRING_LITERAL78!=null?STRING_LITERAL78.getText():null)))) {
			                throw err(proto, "Syntax isn't proto2: '" +
			                        getStringFromStringLiteral((STRING_LITERAL78!=null?STRING_LITERAL78.getText():null))+"'");
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:212:1: header_package[Proto proto] : PKG ( FULL_ID | var ) SEMICOLON !;
	public final ProtoParser.header_package_return header_package(Proto proto) throws RecognitionException {
		ProtoParser.header_package_return retval = new ProtoParser.header_package_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PKG80=null;
		Token FULL_ID81=null;
		Token SEMICOLON83=null;
		ParserRuleReturnScope var82 =null;

		Object PKG80_tree=null;
		Object FULL_ID81_tree=null;
		Object SEMICOLON83_tree=null;


		    String value = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:216:5: ( PKG ( FULL_ID | var ) SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:216:9: PKG ( FULL_ID | var ) SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			PKG80=(Token)match(input,PKG,FOLLOW_PKG_in_header_package1856); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PKG80_tree = (Object)adaptor.create(PKG80);
			adaptor.addChild(root_0, PKG80_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:216:13: ( FULL_ID | var )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:216:14: FULL_ID
					{
					FULL_ID81=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_header_package1859); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID81_tree = (Object)adaptor.create(FULL_ID81);
					adaptor.addChild(root_0, FULL_ID81_tree);
					}

					if ( state.backtracking==0 ) { value = (FULL_ID81!=null?FULL_ID81.getText():null); }
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:216:51: var
					{
					pushFollow(FOLLOW_var_in_header_package1865);
					var82=var();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var82.getTree());

					if ( state.backtracking==0 ) { value = (var82!=null?input.toString(var82.start,var82.stop):null); }
					}
					break;

			}

			SEMICOLON83=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_header_package1870); if (state.failed) return retval;
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:226:1: header_import[Proto proto] : IMPORT STRING_LITERAL SEMICOLON !;
	public final ProtoParser.header_import_return header_import(Proto proto) throws RecognitionException {
		ProtoParser.header_import_return retval = new ProtoParser.header_import_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IMPORT84=null;
		Token STRING_LITERAL85=null;
		Token SEMICOLON86=null;

		Object IMPORT84_tree=null;
		Object STRING_LITERAL85_tree=null;
		Object SEMICOLON86_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:227:5: ( IMPORT STRING_LITERAL SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:227:9: IMPORT STRING_LITERAL SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			IMPORT84=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_header_import1898); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IMPORT84_tree = (Object)adaptor.create(IMPORT84);
			adaptor.addChild(root_0, IMPORT84_tree);
			}

			STRING_LITERAL85=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_header_import1900); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STRING_LITERAL85_tree = (Object)adaptor.create(STRING_LITERAL85);
			adaptor.addChild(root_0, STRING_LITERAL85_tree);
			}

			SEMICOLON86=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_header_import1902); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			            proto.importProto(getStringFromStringLiteral((STRING_LITERAL85!=null?STRING_LITERAL85.getText():null)));
			            
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:234:1: option_entry[Proto proto, HasOptions ho] : OPTION ( LEFTPAREN )? k= var_full ( RIGHTPAREN )? ASSIGN ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) SEMICOLON !;
	public final ProtoParser.option_entry_return option_entry(Proto proto, HasOptions ho) throws RecognitionException {
		ProtoParser.option_entry_return retval = new ProtoParser.option_entry_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token fid=null;
		Token OPTION87=null;
		Token LEFTPAREN88=null;
		Token RIGHTPAREN89=null;
		Token ASSIGN90=null;
		Token LEFTCURLY91=null;
		Token COMMA93=null;
		Token RIGHTCURLY95=null;
		Token LEFTSQUARE96=null;
		Token COMMA98=null;
		Token RIGHTSQUARE100=null;
		Token NUMFLOAT101=null;
		Token NUMINT102=null;
		Token NUMDOUBLE103=null;
		Token TRUE104=null;
		Token FALSE105=null;
		Token STRING_LITERAL106=null;
		Token SEMICOLON107=null;
		ParserRuleReturnScope k =null;
		ParserRuleReturnScope vr =null;
		ParserRuleReturnScope map_val92 =null;
		ParserRuleReturnScope map_val94 =null;
		ParserRuleReturnScope list_val97 =null;
		ParserRuleReturnScope list_val99 =null;

		Object id_tree=null;
		Object fid_tree=null;
		Object OPTION87_tree=null;
		Object LEFTPAREN88_tree=null;
		Object RIGHTPAREN89_tree=null;
		Object ASSIGN90_tree=null;
		Object LEFTCURLY91_tree=null;
		Object COMMA93_tree=null;
		Object RIGHTCURLY95_tree=null;
		Object LEFTSQUARE96_tree=null;
		Object COMMA98_tree=null;
		Object RIGHTSQUARE100_tree=null;
		Object NUMFLOAT101_tree=null;
		Object NUMINT102_tree=null;
		Object NUMDOUBLE103_tree=null;
		Object TRUE104_tree=null;
		Object FALSE105_tree=null;
		Object STRING_LITERAL106_tree=null;
		Object SEMICOLON107_tree=null;


		    Map<String, Object> map = null;
		    List<Object> list = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:239:5: ( OPTION ( LEFTPAREN )? k= var_full ( RIGHTPAREN )? ASSIGN ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:239:9: OPTION ( LEFTPAREN )? k= var_full ( RIGHTPAREN )? ASSIGN ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL ) SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			OPTION87=(Token)match(input,OPTION,FOLLOW_OPTION_in_option_entry1931); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OPTION87_tree = (Object)adaptor.create(OPTION87);
			adaptor.addChild(root_0, OPTION87_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:239:16: ( LEFTPAREN )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==LEFTPAREN) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:239:16: LEFTPAREN
					{
					LEFTPAREN88=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_option_entry1933); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTPAREN88_tree = (Object)adaptor.create(LEFTPAREN88);
					adaptor.addChild(root_0, LEFTPAREN88_tree);
					}

					}
					break;

			}

			pushFollow(FOLLOW_var_full_in_option_entry1938);
			k=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

			// com/dyuproject/fbsgen/parser/ProtoParser.g:239:38: ( RIGHTPAREN )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==RIGHTPAREN) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:239:38: RIGHTPAREN
					{
					RIGHTPAREN89=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_option_entry1940); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTPAREN89_tree = (Object)adaptor.create(RIGHTPAREN89);
					adaptor.addChild(root_0, RIGHTPAREN89_tree);
					}

					}
					break;

			}

			ASSIGN90=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_option_entry1943); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN90_tree = (Object)adaptor.create(ASSIGN90);
			adaptor.addChild(root_0, ASSIGN90_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:239:57: ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved |id= ID |fid= FULL_ID | NUMFLOAT | NUMINT | NUMDOUBLE | TRUE | FALSE | STRING_LITERAL )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:240:13: ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:240:13: ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:241:17: LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY
					{
					LEFTCURLY91=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_option_entry1977); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTCURLY91_tree = (Object)adaptor.create(LEFTCURLY91);
					adaptor.addChild(root_0, LEFTCURLY91_tree);
					}

					if ( state.backtracking==0 ) {
					                    putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (map = new java.util.LinkedHashMap<String, Object>()), proto);
					                }
					pushFollow(FOLLOW_map_val_in_option_entry1997);
					map_val92=map_val(map);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val92.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:244:30: ( COMMA map_val[map] )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0==COMMA) ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:244:31: COMMA map_val[map]
							{
							COMMA93=(Token)match(input,COMMA,FOLLOW_COMMA_in_option_entry2001); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA93_tree = (Object)adaptor.create(COMMA93);
							adaptor.addChild(root_0, COMMA93_tree);
							}

							pushFollow(FOLLOW_map_val_in_option_entry2003);
							map_val94=map_val(map);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val94.getTree());

							}
							break;

						default :
							break loop19;
						}
					}

					RIGHTCURLY95=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_option_entry2025); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTCURLY95_tree = (Object)adaptor.create(RIGHTCURLY95);
					adaptor.addChild(root_0, RIGHTCURLY95_tree);
					}

					}

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:248:13: ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:248:13: ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:249:17: LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE
					{
					LEFTSQUARE96=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_option_entry2085); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSQUARE96_tree = (Object)adaptor.create(LEFTSQUARE96);
					adaptor.addChild(root_0, LEFTSQUARE96_tree);
					}

					if ( state.backtracking==0 ) {
					                    putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (list = new ArrayList<Object>()), proto);
					                }
					pushFollow(FOLLOW_list_val_in_option_entry2105);
					list_val97=list_val(list);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val97.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:252:32: ( COMMA list_val[list] )*
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( (LA20_0==COMMA) ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:252:33: COMMA list_val[list]
							{
							COMMA98=(Token)match(input,COMMA,FOLLOW_COMMA_in_option_entry2109); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA98_tree = (Object)adaptor.create(COMMA98);
							adaptor.addChild(root_0, COMMA98_tree);
							}

							pushFollow(FOLLOW_list_val_in_option_entry2111);
							list_val99=list_val(list);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val99.getTree());

							}
							break;

						default :
							break loop20;
						}
					}

					RIGHTSQUARE100=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_option_entry2133); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSQUARE100_tree = (Object)adaptor.create(RIGHTSQUARE100);
					adaptor.addChild(root_0, RIGHTSQUARE100_tree);
					}

					}

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:255:17: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_option_entry2167);
					vr=var_reserved();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vr.getTree());

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (vr!=null?input.toString(vr.start,vr.stop):null), proto); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:256:17: id= ID
					{
					id=(Token)match(input,ID,FOLLOW_ID_in_option_entry2189); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					id_tree = (Object)adaptor.create(id);
					adaptor.addChild(root_0, id_tree);
					}

					if ( state.backtracking==0 ) { putStandardOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (id!=null?id.getText():null), proto); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:257:17: fid= FULL_ID
					{
					fid=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_option_entry2211); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					fid_tree = (Object)adaptor.create(fid);
					adaptor.addChild(root_0, fid_tree);
					}

					if ( state.backtracking==0 ) { putStandardOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), (fid!=null?fid.getText():null), proto); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:258:17: NUMFLOAT
					{
					NUMFLOAT101=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_option_entry2231); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT101_tree = (Object)adaptor.create(NUMFLOAT101);
					adaptor.addChild(root_0, NUMFLOAT101_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), Float.valueOf((NUMFLOAT101!=null?NUMFLOAT101.getText():null)), proto); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:259:17: NUMINT
					{
					NUMINT102=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_option_entry2251); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT102_tree = (Object)adaptor.create(NUMINT102);
					adaptor.addChild(root_0, NUMINT102_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), parseNumber((NUMINT102!=null?NUMINT102.getText():null)), proto); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:260:17: NUMDOUBLE
					{
					NUMDOUBLE103=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_option_entry2271); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE103_tree = (Object)adaptor.create(NUMDOUBLE103);
					adaptor.addChild(root_0, NUMDOUBLE103_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), Double.valueOf((NUMDOUBLE103!=null?NUMDOUBLE103.getText():null)), proto); }
					}
					break;
				case 9 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:261:17: TRUE
					{
					TRUE104=(Token)match(input,TRUE,FOLLOW_TRUE_in_option_entry2291); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE104_tree = (Object)adaptor.create(TRUE104);
					adaptor.addChild(root_0, TRUE104_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), Boolean.TRUE, proto); }
					}
					break;
				case 10 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:262:17: FALSE
					{
					FALSE105=(Token)match(input,FALSE,FOLLOW_FALSE_in_option_entry2311); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE105_tree = (Object)adaptor.create(FALSE105);
					adaptor.addChild(root_0, FALSE105_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), Boolean.FALSE, proto); }
					}
					break;
				case 11 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:263:17: STRING_LITERAL
					{
					STRING_LITERAL106=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_option_entry2331); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL106_tree = (Object)adaptor.create(STRING_LITERAL106);
					adaptor.addChild(root_0, STRING_LITERAL106_tree);
					}

					if ( state.backtracking==0 ) { putExtraOptionTo(ho, (k!=null?input.toString(k.start,k.stop):null), getStringFromStringLiteral((STRING_LITERAL106!=null?STRING_LITERAL106.getText():null)), proto); }
					}
					break;

			}

			SEMICOLON107=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_option_entry2345); if (state.failed) return retval;
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:269:1: message_block[Proto proto, Message parent] : MESSAGE ID LEFTCURLY ( message_body[proto, message] )* RIGHTCURLY ;
	public final ProtoParser.message_block_return message_block(Proto proto, Message parent) throws RecognitionException {
		ProtoParser.message_block_return retval = new ProtoParser.message_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MESSAGE108=null;
		Token ID109=null;
		Token LEFTCURLY110=null;
		Token RIGHTCURLY112=null;
		ParserRuleReturnScope message_body111 =null;

		Object MESSAGE108_tree=null;
		Object ID109_tree=null;
		Object LEFTCURLY110_tree=null;
		Object RIGHTCURLY112_tree=null;


		    Message message = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:273:5: ( MESSAGE ID LEFTCURLY ( message_body[proto, message] )* RIGHTCURLY )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:273:9: MESSAGE ID LEFTCURLY ( message_body[proto, message] )* RIGHTCURLY
			{
			root_0 = (Object)adaptor.nil();


			MESSAGE108=(Token)match(input,MESSAGE,FOLLOW_MESSAGE_in_message_block2378); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MESSAGE108_tree = (Object)adaptor.create(MESSAGE108);
			adaptor.addChild(root_0, MESSAGE108_tree);
			}

			ID109=(Token)match(input,ID,FOLLOW_ID_in_message_block2380); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID109_tree = (Object)adaptor.create(ID109);
			adaptor.addChild(root_0, ID109_tree);
			}

			if ( state.backtracking==0 ) { 
			            message = new Message((ID109!=null?ID109.getText():null), parent, proto);
			            proto.addAnnotationsTo(message);
			        }
			LEFTCURLY110=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_message_block2393); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY110_tree = (Object)adaptor.create(LEFTCURLY110);
			adaptor.addChild(root_0, LEFTCURLY110_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:277:19: ( message_body[proto, message] )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==AT||LA22_0==DOC_COMMENT||LA22_0==ENUM||LA22_0==MESSAGE||(LA22_0 >= OPTION && LA22_0 <= OPTIONAL)||(LA22_0 >= REPEATED && LA22_0 <= REQUIRED)||LA22_0==SERVICE) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:277:20: message_body[proto, message]
					{
					pushFollow(FOLLOW_message_body_in_message_block2396);
					message_body111=message_body(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_body111.getTree());

					}
					break;

				default :
					break loop22;
				}
			}

			RIGHTCURLY112=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_message_block2401); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY112_tree = (Object)adaptor.create(RIGHTCURLY112);
			adaptor.addChild(root_0, RIGHTCURLY112_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:282:1: message_body[Proto proto, Message message] : ( message_block[proto, message] | message_field[proto, message] | enum_block[proto, message] | service_block[proto, message] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, message] );
	public final ProtoParser.message_body_return message_body(Proto proto, Message message) throws RecognitionException {
		ProtoParser.message_body_return retval = new ProtoParser.message_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope message_block113 =null;
		ParserRuleReturnScope message_field114 =null;
		ParserRuleReturnScope enum_block115 =null;
		ParserRuleReturnScope service_block116 =null;
		ParserRuleReturnScope annotation_entry117 =null;
		ParserRuleReturnScope comment_entry118 =null;
		ParserRuleReturnScope option_entry119 =null;


		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:283:5: ( message_block[proto, message] | message_field[proto, message] | enum_block[proto, message] | service_block[proto, message] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, message] )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:283:9: message_block[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_message_block_in_message_body2424);
					message_block113=message_block(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_block113.getTree());

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:284:9: message_field[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_message_field_in_message_body2435);
					message_field114=message_field(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, message_field114.getTree());

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:285:9: enum_block[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_enum_block_in_message_body2446);
					enum_block115=enum_block(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_block115.getTree());

					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:286:9: service_block[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_service_block_in_message_body2457);
					service_block116=service_block(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, service_block116.getTree());

					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:289:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_message_body2478);
					annotation_entry117=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry117.getTree());

					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:290:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_message_body2489);
					comment_entry118=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry118.getTree());

					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:291:9: option_entry[proto, message]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_message_body2500);
					option_entry119=option_entry(proto, message);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry119.getTree());

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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:306:1: message_field[Proto proto, HasFields message] : ( OPTIONAL | REQUIRED | REPEATED ) field_type[proto, message, fieldHolder] var ASSIGN NUMINT ( field_options[proto, message, fieldHolder.field] )? ( SEMICOLON !| ignore_block ) ;
	public final ProtoParser.message_field_return message_field(Proto proto, HasFields message) throws RecognitionException {
		ProtoParser.message_field_return retval = new ProtoParser.message_field_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OPTIONAL120=null;
		Token REQUIRED121=null;
		Token REPEATED122=null;
		Token ASSIGN125=null;
		Token NUMINT126=null;
		Token SEMICOLON128=null;
		ParserRuleReturnScope field_type123 =null;
		ParserRuleReturnScope var124 =null;
		ParserRuleReturnScope field_options127 =null;
		ParserRuleReturnScope ignore_block129 =null;

		Object OPTIONAL120_tree=null;
		Object REQUIRED121_tree=null;
		Object REPEATED122_tree=null;
		Object ASSIGN125_tree=null;
		Object NUMINT126_tree=null;
		Object SEMICOLON128_tree=null;


		    Field.Modifier modifier = null;
		    FieldHolder fieldHolder = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:311:5: ( ( OPTIONAL | REQUIRED | REPEATED ) field_type[proto, message, fieldHolder] var ASSIGN NUMINT ( field_options[proto, message, fieldHolder.field] )? ( SEMICOLON !| ignore_block ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:311:9: ( OPTIONAL | REQUIRED | REPEATED ) field_type[proto, message, fieldHolder] var ASSIGN NUMINT ( field_options[proto, message, fieldHolder.field] )? ( SEMICOLON !| ignore_block )
			{
			root_0 = (Object)adaptor.nil();


			// com/dyuproject/fbsgen/parser/ProtoParser.g:311:9: ( OPTIONAL | REQUIRED | REPEATED )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:311:10: OPTIONAL
					{
					OPTIONAL120=(Token)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_message_field2548); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OPTIONAL120_tree = (Object)adaptor.create(OPTIONAL120);
					adaptor.addChild(root_0, OPTIONAL120_tree);
					}

					if ( state.backtracking==0 ) { modifier = Field.Modifier.OPTIONAL;  }
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:312:13: REQUIRED
					{
					REQUIRED121=(Token)match(input,REQUIRED,FOLLOW_REQUIRED_in_message_field2565); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					REQUIRED121_tree = (Object)adaptor.create(REQUIRED121);
					adaptor.addChild(root_0, REQUIRED121_tree);
					}

					if ( state.backtracking==0 ) { modifier = Field.Modifier.REQUIRED; }
					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:313:13: REPEATED
					{
					REPEATED122=(Token)match(input,REPEATED,FOLLOW_REPEATED_in_message_field2582); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					REPEATED122_tree = (Object)adaptor.create(REPEATED122);
					adaptor.addChild(root_0, REPEATED122_tree);
					}

					if ( state.backtracking==0 ) { modifier = Field.Modifier.REPEATED; }
					}
					break;

			}

			if ( state.backtracking==0 ) {
			            fieldHolder = new FieldHolder();
			        }
			pushFollow(FOLLOW_field_type_in_message_field2597);
			field_type123=field_type(proto, message, fieldHolder);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_type123.getTree());

			pushFollow(FOLLOW_var_in_message_field2609);
			var124=var();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var124.getTree());

			ASSIGN125=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_message_field2611); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN125_tree = (Object)adaptor.create(ASSIGN125);
			adaptor.addChild(root_0, ASSIGN125_tree);
			}

			NUMINT126=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_message_field2613); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NUMINT126_tree = (Object)adaptor.create(NUMINT126);
			adaptor.addChild(root_0, NUMINT126_tree);
			}

			if ( state.backtracking==0 ) {
			            if (fieldHolder.field != null) {
			                fieldHolder.field.modifier = modifier;
			                fieldHolder.field.name = (var124!=null?input.toString(var124.start,var124.stop):null);
			                fieldHolder.field.number = Integer.parseInt((NUMINT126!=null?NUMINT126.getText():null));
			                message.addField(fieldHolder.field);
			            }
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:325:9: ( field_options[proto, message, fieldHolder.field] )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==LEFTSQUARE) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:325:10: field_options[proto, message, fieldHolder.field]
					{
					pushFollow(FOLLOW_field_options_in_message_field2627);
					field_options127=field_options(proto, message, fieldHolder.field);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options127.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			            if (fieldHolder.field != null) {
			                proto.addAnnotationsTo(fieldHolder.field, message.getEnclosingNamespace());
			                fieldHolder.field.resolvePbType();
			            }
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:331:9: ( SEMICOLON !| ignore_block )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:331:10: SEMICOLON !
					{
					SEMICOLON128=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_message_field2643); if (state.failed) return retval;
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:331:23: ignore_block
					{
					pushFollow(FOLLOW_ignore_block_in_message_field2648);
					ignore_block129=ignore_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_block129.getTree());

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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:334:1: field_type[Proto proto, HasFields message, FieldHolder fieldHolder] : ( BOOL | INT8 | UINT8 | INT16 | UINT16 | INT32 | UINT32 | INT64 | UINT64 | FLOAT | DOUBLE | STRING | BYTES | FULL_ID | ID );
	public final ProtoParser.field_type_return field_type(Proto proto, HasFields message, FieldHolder fieldHolder) throws RecognitionException {
		ProtoParser.field_type_return retval = new ProtoParser.field_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BOOL130=null;
		Token INT8131=null;
		Token UINT8132=null;
		Token INT16133=null;
		Token UINT16134=null;
		Token INT32135=null;
		Token UINT32136=null;
		Token INT64137=null;
		Token UINT64138=null;
		Token FLOAT139=null;
		Token DOUBLE140=null;
		Token STRING141=null;
		Token BYTES142=null;
		Token FULL_ID143=null;
		Token ID144=null;

		Object BOOL130_tree=null;
		Object INT8131_tree=null;
		Object UINT8132_tree=null;
		Object INT16133_tree=null;
		Object UINT16134_tree=null;
		Object INT32135_tree=null;
		Object UINT32136_tree=null;
		Object INT64137_tree=null;
		Object UINT64138_tree=null;
		Object FLOAT139_tree=null;
		Object DOUBLE140_tree=null;
		Object STRING141_tree=null;
		Object BYTES142_tree=null;
		Object FULL_ID143_tree=null;
		Object ID144_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:335:5: ( BOOL | INT8 | UINT8 | INT16 | UINT16 | INT32 | UINT32 | INT64 | UINT64 | FLOAT | DOUBLE | STRING | BYTES | FULL_ID | ID )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:335:9: BOOL
					{
					root_0 = (Object)adaptor.nil();


					BOOL130=(Token)match(input,BOOL,FOLLOW_BOOL_in_field_type2674); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOL130_tree = (Object)adaptor.create(BOOL130);
					adaptor.addChild(root_0, BOOL130_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Bool()); }
					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:336:9: INT8
					{
					root_0 = (Object)adaptor.nil();


					INT8131=(Token)match(input,INT8,FOLLOW_INT8_in_field_type2686); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT8131_tree = (Object)adaptor.create(INT8131);
					adaptor.addChild(root_0, INT8131_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int8()); }
					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:337:9: UINT8
					{
					root_0 = (Object)adaptor.nil();


					UINT8132=(Token)match(input,UINT8,FOLLOW_UINT8_in_field_type2698); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT8132_tree = (Object)adaptor.create(UINT8132);
					adaptor.addChild(root_0, UINT8132_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt8()); }
					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:338:9: INT16
					{
					root_0 = (Object)adaptor.nil();


					INT16133=(Token)match(input,INT16,FOLLOW_INT16_in_field_type2710); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT16133_tree = (Object)adaptor.create(INT16133);
					adaptor.addChild(root_0, INT16133_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int16()); }
					}
					break;
				case 5 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:339:9: UINT16
					{
					root_0 = (Object)adaptor.nil();


					UINT16134=(Token)match(input,UINT16,FOLLOW_UINT16_in_field_type2722); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT16134_tree = (Object)adaptor.create(UINT16134);
					adaptor.addChild(root_0, UINT16134_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt16()); }
					}
					break;
				case 6 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:340:9: INT32
					{
					root_0 = (Object)adaptor.nil();


					INT32135=(Token)match(input,INT32,FOLLOW_INT32_in_field_type2734); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT32135_tree = (Object)adaptor.create(INT32135);
					adaptor.addChild(root_0, INT32135_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int32()); }
					}
					break;
				case 7 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:341:9: UINT32
					{
					root_0 = (Object)adaptor.nil();


					UINT32136=(Token)match(input,UINT32,FOLLOW_UINT32_in_field_type2746); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT32136_tree = (Object)adaptor.create(UINT32136);
					adaptor.addChild(root_0, UINT32136_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt32()); }
					}
					break;
				case 8 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:342:9: INT64
					{
					root_0 = (Object)adaptor.nil();


					INT64137=(Token)match(input,INT64,FOLLOW_INT64_in_field_type2758); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT64137_tree = (Object)adaptor.create(INT64137);
					adaptor.addChild(root_0, INT64137_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Int64()); }
					}
					break;
				case 9 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:343:9: UINT64
					{
					root_0 = (Object)adaptor.nil();


					UINT64138=(Token)match(input,UINT64,FOLLOW_UINT64_in_field_type2770); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UINT64138_tree = (Object)adaptor.create(UINT64138);
					adaptor.addChild(root_0, UINT64138_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.UInt64()); }
					}
					break;
				case 10 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:344:9: FLOAT
					{
					root_0 = (Object)adaptor.nil();


					FLOAT139=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_field_type2782); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOAT139_tree = (Object)adaptor.create(FLOAT139);
					adaptor.addChild(root_0, FLOAT139_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Float()); }
					}
					break;
				case 11 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:345:9: DOUBLE
					{
					root_0 = (Object)adaptor.nil();


					DOUBLE140=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_field_type2794); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLE140_tree = (Object)adaptor.create(DOUBLE140);
					adaptor.addChild(root_0, DOUBLE140_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Double()); }
					}
					break;
				case 12 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:346:9: STRING
					{
					root_0 = (Object)adaptor.nil();


					STRING141=(Token)match(input,STRING,FOLLOW_STRING_in_field_type2806); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING141_tree = (Object)adaptor.create(STRING141);
					adaptor.addChild(root_0, STRING141_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.String()); }
					}
					break;
				case 13 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:347:9: BYTES
					{
					root_0 = (Object)adaptor.nil();


					BYTES142=(Token)match(input,BYTES,FOLLOW_BYTES_in_field_type2818); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BYTES142_tree = (Object)adaptor.create(BYTES142);
					adaptor.addChild(root_0, BYTES142_tree);
					}

					if ( state.backtracking==0 ) { fieldHolder.setField(new Field.Bytes()); }
					}
					break;
				case 14 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:352:9: FULL_ID
					{
					root_0 = (Object)adaptor.nil();


					FULL_ID143=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_field_type2850); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID143_tree = (Object)adaptor.create(FULL_ID143);
					adaptor.addChild(root_0, FULL_ID143_tree);
					}

					if ( state.backtracking==0 ) {
					            String fullType = (FULL_ID143!=null?FULL_ID143.getText():null);
					            int lastDot = fullType.lastIndexOf('.');
					            String packageName = fullType.substring(0, lastDot);
					            String type = fullType.substring(lastDot+1);
					            fieldHolder.setField(new Field.Reference(packageName, type, message));
					        }
					}
					break;
				case 15 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:359:9: ID
					{
					root_0 = (Object)adaptor.nil();


					ID144=(Token)match(input,ID,FOLLOW_ID_in_field_type2862); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID144_tree = (Object)adaptor.create(ID144);
					adaptor.addChild(root_0, ID144_tree);
					}

					if ( state.backtracking==0 ) { 
					            String type = (ID144!=null?ID144.getText():null);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:365:1: field_options[Proto proto, HasFields message, Field field] : LEFTSQUARE field_options_keyval[proto, message, field, true] ( COMMA field_options_keyval[proto, message, field, true] )* RIGHTSQUARE ;
	public final ProtoParser.field_options_return field_options(Proto proto, HasFields message, Field field) throws RecognitionException {
		ProtoParser.field_options_return retval = new ProtoParser.field_options_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTSQUARE145=null;
		Token COMMA147=null;
		Token RIGHTSQUARE149=null;
		ParserRuleReturnScope field_options_keyval146 =null;
		ParserRuleReturnScope field_options_keyval148 =null;

		Object LEFTSQUARE145_tree=null;
		Object COMMA147_tree=null;
		Object RIGHTSQUARE149_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:366:5: ( LEFTSQUARE field_options_keyval[proto, message, field, true] ( COMMA field_options_keyval[proto, message, field, true] )* RIGHTSQUARE )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:366:9: LEFTSQUARE field_options_keyval[proto, message, field, true] ( COMMA field_options_keyval[proto, message, field, true] )* RIGHTSQUARE
			{
			root_0 = (Object)adaptor.nil();


			LEFTSQUARE145=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_field_options2889); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTSQUARE145_tree = (Object)adaptor.create(LEFTSQUARE145);
			adaptor.addChild(root_0, LEFTSQUARE145_tree);
			}

			pushFollow(FOLLOW_field_options_keyval_in_field_options2891);
			field_options_keyval146=field_options_keyval(proto, message, field, true);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval146.getTree());

			// com/dyuproject/fbsgen/parser/ProtoParser.g:367:9: ( COMMA field_options_keyval[proto, message, field, true] )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==COMMA) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:367:10: COMMA field_options_keyval[proto, message, field, true]
					{
					COMMA147=(Token)match(input,COMMA,FOLLOW_COMMA_in_field_options2904); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA147_tree = (Object)adaptor.create(COMMA147);
					adaptor.addChild(root_0, COMMA147_tree);
					}

					pushFollow(FOLLOW_field_options_keyval_in_field_options2906);
					field_options_keyval148=field_options_keyval(proto, message, field, true);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval148.getTree());

					}
					break;

				default :
					break loop28;
				}
			}

			RIGHTSQUARE149=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_field_options2911); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTSQUARE149_tree = (Object)adaptor.create(RIGHTSQUARE149);
			adaptor.addChild(root_0, RIGHTSQUARE149_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:370:1: field_options_keyval[Proto proto, HasFields message, Field field, boolean checkDefault] : key= var_full ASSIGN ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] ) ;
	public final ProtoParser.field_options_keyval_return field_options_keyval(Proto proto, HasFields message, Field field, boolean checkDefault) throws RecognitionException {
		ProtoParser.field_options_keyval_return retval = new ProtoParser.field_options_keyval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token val=null;
		Token ASSIGN150=null;
		Token LEFTCURLY151=null;
		Token COMMA153=null;
		Token RIGHTCURLY155=null;
		Token LEFTSQUARE156=null;
		Token COMMA158=null;
		Token RIGHTSQUARE160=null;
		Token STRING_LITERAL161=null;
		Token NUMFLOAT162=null;
		Token NUMINT163=null;
		Token NUMDOUBLE164=null;
		Token HEX165=null;
		Token OCTAL166=null;
		Token TRUE167=null;
		Token FALSE168=null;
		Token FULL_ID169=null;
		Token EXP170=null;
		ParserRuleReturnScope key =null;
		ParserRuleReturnScope vr =null;
		ParserRuleReturnScope map_val152 =null;
		ParserRuleReturnScope map_val154 =null;
		ParserRuleReturnScope list_val157 =null;
		ParserRuleReturnScope list_val159 =null;
		ParserRuleReturnScope signed_constant171 =null;

		Object val_tree=null;
		Object ASSIGN150_tree=null;
		Object LEFTCURLY151_tree=null;
		Object COMMA153_tree=null;
		Object RIGHTCURLY155_tree=null;
		Object LEFTSQUARE156_tree=null;
		Object COMMA158_tree=null;
		Object RIGHTSQUARE160_tree=null;
		Object STRING_LITERAL161_tree=null;
		Object NUMFLOAT162_tree=null;
		Object NUMINT163_tree=null;
		Object NUMDOUBLE164_tree=null;
		Object HEX165_tree=null;
		Object OCTAL166_tree=null;
		Object TRUE167_tree=null;
		Object FALSE168_tree=null;
		Object FULL_ID169_tree=null;
		Object EXP170_tree=null;


		    Map<String, Object> map = null;
		    List<Object> list = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:375:5: (key= var_full ASSIGN ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] ) )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:375:9: key= var_full ASSIGN ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] )
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_var_full_in_field_options_keyval2943);
			key=var_full();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, key.getTree());

			ASSIGN150=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_field_options_keyval2945); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN150_tree = (Object)adaptor.create(ASSIGN150);
			adaptor.addChild(root_0, ASSIGN150_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:375:29: ( ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY ) | ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE ) |vr= var_reserved | STRING_LITERAL | NUMFLOAT | NUMINT | NUMDOUBLE | HEX | OCTAL | TRUE | FALSE |val= ID | FULL_ID | EXP | signed_constant[proto, message, field, $key.text, checkDefault] )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:376:5: ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:376:5: ( LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:377:9: LEFTCURLY map_val[map] ( COMMA map_val[map] )* RIGHTCURLY
					{
					LEFTCURLY151=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_field_options_keyval2963); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTCURLY151_tree = (Object)adaptor.create(LEFTCURLY151);
					adaptor.addChild(root_0, LEFTCURLY151_tree);
					}

					if ( state.backtracking==0 ) {
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (map = new java.util.LinkedHashMap<String, Object>()));
					        }
					pushFollow(FOLLOW_map_val_in_field_options_keyval2975);
					map_val152=map_val(map);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val152.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:380:22: ( COMMA map_val[map] )*
					loop29:
					while (true) {
						int alt29=2;
						int LA29_0 = input.LA(1);
						if ( (LA29_0==COMMA) ) {
							alt29=1;
						}

						switch (alt29) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:380:23: COMMA map_val[map]
							{
							COMMA153=(Token)match(input,COMMA,FOLLOW_COMMA_in_field_options_keyval2979); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA153_tree = (Object)adaptor.create(COMMA153);
							adaptor.addChild(root_0, COMMA153_tree);
							}

							pushFollow(FOLLOW_map_val_in_field_options_keyval2981);
							map_val154=map_val(map);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, map_val154.getTree());

							}
							break;

						default :
							break loop29;
						}
					}

					RIGHTCURLY155=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_field_options_keyval2995); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTCURLY155_tree = (Object)adaptor.create(RIGHTCURLY155);
					adaptor.addChild(root_0, RIGHTCURLY155_tree);
					}

					}

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:384:5: ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE )
					{
					// com/dyuproject/fbsgen/parser/ProtoParser.g:384:5: ( LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE )
					// com/dyuproject/fbsgen/parser/ProtoParser.g:385:9: LEFTSQUARE list_val[list] ( COMMA list_val[list] )* RIGHTSQUARE
					{
					LEFTSQUARE156=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_field_options_keyval3023); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFTSQUARE156_tree = (Object)adaptor.create(LEFTSQUARE156);
					adaptor.addChild(root_0, LEFTSQUARE156_tree);
					}

					if ( state.backtracking==0 ) {
					            field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (list = new ArrayList<Object>()));
					        }
					pushFollow(FOLLOW_list_val_in_field_options_keyval3035);
					list_val157=list_val(list);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val157.getTree());

					// com/dyuproject/fbsgen/parser/ProtoParser.g:388:24: ( COMMA list_val[list] )*
					loop30:
					while (true) {
						int alt30=2;
						int LA30_0 = input.LA(1);
						if ( (LA30_0==COMMA) ) {
							alt30=1;
						}

						switch (alt30) {
						case 1 :
							// com/dyuproject/fbsgen/parser/ProtoParser.g:388:25: COMMA list_val[list]
							{
							COMMA158=(Token)match(input,COMMA,FOLLOW_COMMA_in_field_options_keyval3039); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA158_tree = (Object)adaptor.create(COMMA158);
							adaptor.addChild(root_0, COMMA158_tree);
							}

							pushFollow(FOLLOW_list_val_in_field_options_keyval3041);
							list_val159=list_val(list);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, list_val159.getTree());

							}
							break;

						default :
							break loop30;
						}
					}

					RIGHTSQUARE160=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_field_options_keyval3055); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHTSQUARE160_tree = (Object)adaptor.create(RIGHTSQUARE160);
					adaptor.addChild(root_0, RIGHTSQUARE160_tree);
					}

					}

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:391:9: vr= var_reserved
					{
					pushFollow(FOLLOW_var_reserved_in_field_options_keyval3073);
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:394:9: STRING_LITERAL
					{
					STRING_LITERAL161=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_field_options_keyval3086); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STRING_LITERAL161_tree = (Object)adaptor.create(STRING_LITERAL161);
					adaptor.addChild(root_0, STRING_LITERAL161_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), getStringFromStringLiteral((STRING_LITERAL161!=null?STRING_LITERAL161.getText():null)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.String || field instanceof Field.Bytes)
					                    field.defaultValue = getStringFromStringLiteral((STRING_LITERAL161!=null?STRING_LITERAL161.getText():null));
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:412:9: NUMFLOAT
					{
					NUMFLOAT162=(Token)match(input,NUMFLOAT,FOLLOW_NUMFLOAT_in_field_options_keyval3098); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMFLOAT162_tree = (Object)adaptor.create(NUMFLOAT162);
					adaptor.addChild(root_0, NUMFLOAT162_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Float.valueOf((NUMFLOAT162!=null?NUMFLOAT162.getText():null)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Float)
					                    field.defaultValue = Float.valueOf((NUMFLOAT162!=null?NUMFLOAT162.getText():null));
					                else if (field instanceof Field.Double) 
					                    field.defaultValue = Double.valueOf((NUMFLOAT162!=null?NUMFLOAT162.getText():null));
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:432:9: NUMINT
					{
					NUMINT163=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_field_options_keyval3111); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMINT163_tree = (Object)adaptor.create(NUMINT163);
					adaptor.addChild(root_0, NUMINT163_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), parseNumber((NUMINT163!=null?NUMINT163.getText():null)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Number) {
					                    if (field instanceof Field.Float)
					                        field.defaultValue = Float.valueOf((NUMINT163!=null?NUMINT163.getText():null));
					                    else if (field instanceof Field.Double) 
					                        field.defaultValue = Double.valueOf((NUMINT163!=null?NUMINT163.getText():null));
					                    else if (field.getClass().getSimpleName().endsWith("64"))
					                        field.defaultValue = validate(proto, field, Long.parseLong((NUMINT163!=null?NUMINT163.getText():null)));
					                    else
					                        field.defaultValue = validate(proto, field, Integer.parseInt((NUMINT163!=null?NUMINT163.getText():null)));
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:458:9: NUMDOUBLE
					{
					NUMDOUBLE164=(Token)match(input,NUMDOUBLE,FOLLOW_NUMDOUBLE_in_field_options_keyval3123); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMDOUBLE164_tree = (Object)adaptor.create(NUMDOUBLE164);
					adaptor.addChild(root_0, NUMDOUBLE164_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Double.valueOf((NUMDOUBLE164!=null?NUMDOUBLE164.getText():null)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);

					                if (field instanceof Field.Float)
					                    field.defaultValue = Float.valueOf((NUMDOUBLE164!=null?NUMDOUBLE164.getText():null));
					                else if (field instanceof Field.Double) 
					                    field.defaultValue = Double.valueOf((NUMDOUBLE164!=null?NUMDOUBLE164.getText():null));
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:478:9: HEX
					{
					HEX165=(Token)match(input,HEX,FOLLOW_HEX_in_field_options_keyval3135); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					HEX165_tree = (Object)adaptor.create(HEX165);
					adaptor.addChild(root_0, HEX165_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Long.valueOf(TextFormat.parseLong(proto, field, (HEX165!=null?HEX165.getText():null), true)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Number) {
					                    if (field instanceof Field.Float)
					                        field.defaultValue = new Float(Long.decode((HEX165!=null?HEX165.getText():null)).floatValue());
					                    else if (field instanceof Field.Double) 
					                        field.defaultValue = new Double(Long.decode((HEX165!=null?HEX165.getText():null)).doubleValue());
					                    else if (field.getClass().getSimpleName().endsWith("64")) {
					                        field.defaultValue = Long.valueOf(validate(proto, field, TextFormat.parseLong(proto, field, (HEX165!=null?HEX165.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    } else {
					                        field.defaultValue = Integer.valueOf(validate(proto, field, TextFormat.parseInt(proto, field, (HEX165!=null?HEX165.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    }
					                }
					                else if (field instanceof Field.Bytes) {
					                    field.defaultValue = (HEX165!=null?HEX165.getText():null);
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:510:9: OCTAL
					{
					OCTAL166=(Token)match(input,OCTAL,FOLLOW_OCTAL_in_field_options_keyval3147); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OCTAL166_tree = (Object)adaptor.create(OCTAL166);
					adaptor.addChild(root_0, OCTAL166_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), Integer.valueOf(TextFormat.parseInt(proto, field, (OCTAL166!=null?OCTAL166.getText():null), true)));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Number) {
					                    if (field instanceof Field.Float)
					                        field.defaultValue = new Float(Long.decode((OCTAL166!=null?OCTAL166.getText():null)).floatValue());
					                    else if (field instanceof Field.Double) 
					                        field.defaultValue = new Double(Long.decode((OCTAL166!=null?OCTAL166.getText():null)).doubleValue());
					                    else if (field.getClass().getSimpleName().endsWith("64")) {
					                        field.defaultValue = Long.valueOf(validate(proto, field, TextFormat.parseLong(proto, field, (OCTAL166!=null?OCTAL166.getText():null), 
					                                field.getClass().getSimpleName().charAt(0) != 'U')));
					                    } else {
					                        field.defaultValue = Integer.valueOf(validate(proto, field, TextFormat.parseInt(proto, field, (OCTAL166!=null?OCTAL166.getText():null), 
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:539:9: TRUE
					{
					TRUE167=(Token)match(input,TRUE,FOLLOW_TRUE_in_field_options_keyval3159); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE167_tree = (Object)adaptor.create(TRUE167);
					adaptor.addChild(root_0, TRUE167_tree);
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:556:9: FALSE
					{
					FALSE168=(Token)match(input,FALSE,FOLLOW_FALSE_in_field_options_keyval3175); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE168_tree = (Object)adaptor.create(FALSE168);
					adaptor.addChild(root_0, FALSE168_tree);
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:573:9: val= ID
					{
					val=(Token)match(input,ID,FOLLOW_ID_in_field_options_keyval3189); if (state.failed) return retval;
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:614:9: FULL_ID
					{
					FULL_ID169=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_field_options_keyval3201); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL_ID169_tree = (Object)adaptor.create(FULL_ID169);
					adaptor.addChild(root_0, FULL_ID169_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putStandardOption((key!=null?input.toString(key.start,key.stop):null), (FULL_ID169!=null?FULL_ID169.getText():null));
					            } else {
					                warnDefaultKeyword(field, proto);
					            }
					        }
					}
					break;
				case 14 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:621:9: EXP
					{
					EXP170=(Token)match(input,EXP,FOLLOW_EXP_in_field_options_keyval3213); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EXP170_tree = (Object)adaptor.create(EXP170);
					adaptor.addChild(root_0, EXP170_tree);
					}

					if ( state.backtracking==0 ) {
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (EXP170!=null?EXP170.getText():null));
					            } else if (checkDefault) {
					                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
					                    throw err(field, " can only have a single default value", proto);
					                
					                if (field instanceof Field.Float)
					                    field.defaultValue = Float.valueOf((EXP170!=null?EXP170.getText():null));
					                else if (field instanceof Field.Double)
					                    field.defaultValue = Double.valueOf((EXP170!=null?EXP170.getText():null));
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:640:9: signed_constant[proto, message, field, $key.text, checkDefault]
					{
					pushFollow(FOLLOW_signed_constant_in_field_options_keyval3225);
					signed_constant171=signed_constant(proto, message, field, (key!=null?input.toString(key.start,key.stop):null), checkDefault);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_constant171.getTree());

					if ( state.backtracking==0 ) {
					            // handled by signed_constant
					            if (!"default".equals((key!=null?input.toString(key.start,key.stop):null))) {
					                field.putExtraOption((key!=null?input.toString(key.start,key.stop):null), (signed_constant171!=null?input.toString(signed_constant171.start,signed_constant171.stop):null));
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:651:1: signed_constant[Proto proto, HasFields message, Field field, String key, boolean checkDefault] : MINUS ID ;
	public final ProtoParser.signed_constant_return signed_constant(Proto proto, HasFields message, Field field, String key, boolean checkDefault) throws RecognitionException {
		ProtoParser.signed_constant_return retval = new ProtoParser.signed_constant_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MINUS172=null;
		Token ID173=null;

		Object MINUS172_tree=null;
		Object ID173_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:652:5: ( MINUS ID )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:652:9: MINUS ID
			{
			root_0 = (Object)adaptor.nil();


			MINUS172=(Token)match(input,MINUS,FOLLOW_MINUS_in_signed_constant3263); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MINUS172_tree = (Object)adaptor.create(MINUS172);
			adaptor.addChild(root_0, MINUS172_tree);
			}

			ID173=(Token)match(input,ID,FOLLOW_ID_in_signed_constant3265); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID173_tree = (Object)adaptor.create(ID173);
			adaptor.addChild(root_0, ID173_tree);
			}

			if ( state.backtracking==0 ) {
			            if (checkDefault && "default".equals(key)) {
			                if (field.defaultValue != null || field.modifier == Field.Modifier.REPEATED)
			                    throw err(field, " can only have a single default value", proto);
			                
			                String refName = (ID173!=null?ID173.getText():null);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:680:1: enum_block[Proto proto, Message message] : ENUM ID LEFTCURLY ( enum_body[proto, message, enumGroup] )* RIGHTCURLY ( ( SEMICOLON )? ) !;
	public final ProtoParser.enum_block_return enum_block(Proto proto, Message message) throws RecognitionException {
		ProtoParser.enum_block_return retval = new ProtoParser.enum_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ENUM174=null;
		Token ID175=null;
		Token LEFTCURLY176=null;
		Token RIGHTCURLY178=null;
		Token SEMICOLON179=null;
		ParserRuleReturnScope enum_body177 =null;

		Object ENUM174_tree=null;
		Object ID175_tree=null;
		Object LEFTCURLY176_tree=null;
		Object RIGHTCURLY178_tree=null;
		Object SEMICOLON179_tree=null;


		    EnumGroup enumGroup = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:684:5: ( ENUM ID LEFTCURLY ( enum_body[proto, message, enumGroup] )* RIGHTCURLY ( ( SEMICOLON )? ) !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:684:9: ENUM ID LEFTCURLY ( enum_body[proto, message, enumGroup] )* RIGHTCURLY ( ( SEMICOLON )? ) !
			{
			root_0 = (Object)adaptor.nil();


			ENUM174=(Token)match(input,ENUM,FOLLOW_ENUM_in_enum_block3297); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ENUM174_tree = (Object)adaptor.create(ENUM174);
			adaptor.addChild(root_0, ENUM174_tree);
			}

			ID175=(Token)match(input,ID,FOLLOW_ID_in_enum_block3299); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID175_tree = (Object)adaptor.create(ID175);
			adaptor.addChild(root_0, ID175_tree);
			}

			if ( state.backtracking==0 ) { 
			            enumGroup = new EnumGroup((ID175!=null?ID175.getText():null), message, proto);
			            proto.addAnnotationsTo(enumGroup);
			        }
			LEFTCURLY176=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_enum_block3312); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY176_tree = (Object)adaptor.create(LEFTCURLY176);
			adaptor.addChild(root_0, LEFTCURLY176_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:688:19: ( enum_body[proto, message, enumGroup] )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==AT||LA32_0==DOC_COMMENT||LA32_0==ID||LA32_0==OPTION) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:688:20: enum_body[proto, message, enumGroup]
					{
					pushFollow(FOLLOW_enum_body_in_enum_block3315);
					enum_body177=enum_body(proto, message, enumGroup);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_body177.getTree());

					}
					break;

				default :
					break loop32;
				}
			}

			RIGHTCURLY178=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_enum_block3320); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY178_tree = (Object)adaptor.create(RIGHTCURLY178);
			adaptor.addChild(root_0, RIGHTCURLY178_tree);
			}

			if ( state.backtracking==0 ) {
			            proto.checkAnnotations();
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:690:11: ( ( SEMICOLON )? )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:690:12: ( SEMICOLON )?
			{
			// com/dyuproject/fbsgen/parser/ProtoParser.g:690:12: ( SEMICOLON )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==SEMICOLON) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:690:12: SEMICOLON
					{
					SEMICOLON179=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_enum_block3325); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMICOLON179_tree = (Object)adaptor.create(SEMICOLON179);
					adaptor.addChild(root_0, SEMICOLON179_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:693:1: enum_body[Proto proto, Message message, EnumGroup enumGroup] : ( enum_field[proto, message, enumGroup] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, enumGroup] );
	public final ProtoParser.enum_body_return enum_body(Proto proto, Message message, EnumGroup enumGroup) throws RecognitionException {
		ProtoParser.enum_body_return retval = new ProtoParser.enum_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope enum_field180 =null;
		ParserRuleReturnScope annotation_entry181 =null;
		ParserRuleReturnScope comment_entry182 =null;
		ParserRuleReturnScope option_entry183 =null;


		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:694:5: ( enum_field[proto, message, enumGroup] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, enumGroup] )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:694:9: enum_field[proto, message, enumGroup]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_enum_field_in_enum_body3353);
					enum_field180=enum_field(proto, message, enumGroup);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_field180.getTree());

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:695:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_enum_body3364);
					annotation_entry181=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry181.getTree());

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:696:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_enum_body3375);
					comment_entry182=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry182.getTree());

					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:697:9: option_entry[proto, enumGroup]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_enum_body3386);
					option_entry183=option_entry(proto, enumGroup);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry183.getTree());

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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:700:1: enum_field[Proto proto, Message message, EnumGroup enumGroup] : ID ASSIGN NUMINT ( enum_options[proto, enumGroup, v] )? SEMICOLON !;
	public final ProtoParser.enum_field_return enum_field(Proto proto, Message message, EnumGroup enumGroup) throws RecognitionException {
		ProtoParser.enum_field_return retval = new ProtoParser.enum_field_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID184=null;
		Token ASSIGN185=null;
		Token NUMINT186=null;
		Token SEMICOLON188=null;
		ParserRuleReturnScope enum_options187 =null;

		Object ID184_tree=null;
		Object ASSIGN185_tree=null;
		Object NUMINT186_tree=null;
		Object SEMICOLON188_tree=null;


		    EnumGroup.Value v = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:704:5: ( ID ASSIGN NUMINT ( enum_options[proto, enumGroup, v] )? SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:704:9: ID ASSIGN NUMINT ( enum_options[proto, enumGroup, v] )? SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			ID184=(Token)match(input,ID,FOLLOW_ID_in_enum_field3413); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID184_tree = (Object)adaptor.create(ID184);
			adaptor.addChild(root_0, ID184_tree);
			}

			ASSIGN185=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_enum_field3415); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSIGN185_tree = (Object)adaptor.create(ASSIGN185);
			adaptor.addChild(root_0, ASSIGN185_tree);
			}

			NUMINT186=(Token)match(input,NUMINT,FOLLOW_NUMINT_in_enum_field3417); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NUMINT186_tree = (Object)adaptor.create(NUMINT186);
			adaptor.addChild(root_0, NUMINT186_tree);
			}

			if ( state.backtracking==0 ) {
			            v = new EnumGroup.Value((ID184!=null?ID184.getText():null), Integer.parseInt((NUMINT186!=null?NUMINT186.getText():null)), enumGroup);
			            proto.addAnnotationsTo(v);
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:707:11: ( enum_options[proto, enumGroup, v] )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==LEFTSQUARE) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:707:12: enum_options[proto, enumGroup, v]
					{
					pushFollow(FOLLOW_enum_options_in_enum_field3422);
					enum_options187=enum_options(proto, enumGroup, v);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_options187.getTree());

					}
					break;

			}

			SEMICOLON188=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_enum_field3427); if (state.failed) return retval;
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:710:1: enum_options[Proto proto, EnumGroup enumGroup, EnumGroup.Value v] : LEFTSQUARE field_options_keyval[proto, null, v.field, false] ( COMMA field_options_keyval[proto, null, v.field, false] )* RIGHTSQUARE ;
	public final ProtoParser.enum_options_return enum_options(Proto proto, EnumGroup enumGroup, EnumGroup.Value v) throws RecognitionException {
		ProtoParser.enum_options_return retval = new ProtoParser.enum_options_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTSQUARE189=null;
		Token COMMA191=null;
		Token RIGHTSQUARE193=null;
		ParserRuleReturnScope field_options_keyval190 =null;
		ParserRuleReturnScope field_options_keyval192 =null;

		Object LEFTSQUARE189_tree=null;
		Object COMMA191_tree=null;
		Object RIGHTSQUARE193_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:711:5: ( LEFTSQUARE field_options_keyval[proto, null, v.field, false] ( COMMA field_options_keyval[proto, null, v.field, false] )* RIGHTSQUARE )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:711:9: LEFTSQUARE field_options_keyval[proto, null, v.field, false] ( COMMA field_options_keyval[proto, null, v.field, false] )* RIGHTSQUARE
			{
			root_0 = (Object)adaptor.nil();


			LEFTSQUARE189=(Token)match(input,LEFTSQUARE,FOLLOW_LEFTSQUARE_in_enum_options3450); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTSQUARE189_tree = (Object)adaptor.create(LEFTSQUARE189);
			adaptor.addChild(root_0, LEFTSQUARE189_tree);
			}

			pushFollow(FOLLOW_field_options_keyval_in_enum_options3452);
			field_options_keyval190=field_options_keyval(proto, null, v.field, false);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval190.getTree());

			// com/dyuproject/fbsgen/parser/ProtoParser.g:712:9: ( COMMA field_options_keyval[proto, null, v.field, false] )*
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==COMMA) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:712:10: COMMA field_options_keyval[proto, null, v.field, false]
					{
					COMMA191=(Token)match(input,COMMA,FOLLOW_COMMA_in_enum_options3465); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COMMA191_tree = (Object)adaptor.create(COMMA191);
					adaptor.addChild(root_0, COMMA191_tree);
					}

					pushFollow(FOLLOW_field_options_keyval_in_enum_options3467);
					field_options_keyval192=field_options_keyval(proto, null, v.field, false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_options_keyval192.getTree());

					}
					break;

				default :
					break loop36;
				}
			}

			RIGHTSQUARE193=(Token)match(input,RIGHTSQUARE,FOLLOW_RIGHTSQUARE_in_enum_options3472); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTSQUARE193_tree = (Object)adaptor.create(RIGHTSQUARE193);
			adaptor.addChild(root_0, RIGHTSQUARE193_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:715:1: service_block[Proto proto, Message message] : SERVICE ID LEFTCURLY ( service_body[proto, service] )+ RIGHTCURLY ( ( SEMICOLON )? ) !;
	public final ProtoParser.service_block_return service_block(Proto proto, Message message) throws RecognitionException {
		ProtoParser.service_block_return retval = new ProtoParser.service_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SERVICE194=null;
		Token ID195=null;
		Token LEFTCURLY196=null;
		Token RIGHTCURLY198=null;
		Token SEMICOLON199=null;
		ParserRuleReturnScope service_body197 =null;

		Object SERVICE194_tree=null;
		Object ID195_tree=null;
		Object LEFTCURLY196_tree=null;
		Object RIGHTCURLY198_tree=null;
		Object SEMICOLON199_tree=null;


		    Service service = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:719:5: ( SERVICE ID LEFTCURLY ( service_body[proto, service] )+ RIGHTCURLY ( ( SEMICOLON )? ) !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:719:9: SERVICE ID LEFTCURLY ( service_body[proto, service] )+ RIGHTCURLY ( ( SEMICOLON )? ) !
			{
			root_0 = (Object)adaptor.nil();


			SERVICE194=(Token)match(input,SERVICE,FOLLOW_SERVICE_in_service_block3502); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SERVICE194_tree = (Object)adaptor.create(SERVICE194);
			adaptor.addChild(root_0, SERVICE194_tree);
			}

			ID195=(Token)match(input,ID,FOLLOW_ID_in_service_block3504); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID195_tree = (Object)adaptor.create(ID195);
			adaptor.addChild(root_0, ID195_tree);
			}

			if ( state.backtracking==0 ) { 
			            service = new Service((ID195!=null?ID195.getText():null), message, proto); 
			            proto.addAnnotationsTo(service);
			        }
			LEFTCURLY196=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_service_block3508); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY196_tree = (Object)adaptor.create(LEFTCURLY196);
			adaptor.addChild(root_0, LEFTCURLY196_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:723:9: ( service_body[proto, service] )+
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:723:10: service_body[proto, service]
					{
					pushFollow(FOLLOW_service_body_in_service_block3519);
					service_body197=service_body(proto, service);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, service_body197.getTree());

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

			RIGHTCURLY198=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_service_block3524); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY198_tree = (Object)adaptor.create(RIGHTCURLY198);
			adaptor.addChild(root_0, RIGHTCURLY198_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:723:52: ( ( SEMICOLON )? )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:723:53: ( SEMICOLON )?
			{
			// com/dyuproject/fbsgen/parser/ProtoParser.g:723:53: ( SEMICOLON )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==SEMICOLON) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:723:53: SEMICOLON
					{
					SEMICOLON199=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_service_block3527); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SEMICOLON199_tree = (Object)adaptor.create(SEMICOLON199);
					adaptor.addChild(root_0, SEMICOLON199_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:731:1: service_body[Proto proto, Service service] : ( rpc_block[proto, service] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, service] );
	public final ProtoParser.service_body_return service_body(Proto proto, Service service) throws RecognitionException {
		ProtoParser.service_body_return retval = new ProtoParser.service_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope rpc_block200 =null;
		ParserRuleReturnScope annotation_entry201 =null;
		ParserRuleReturnScope comment_entry202 =null;
		ParserRuleReturnScope option_entry203 =null;


		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:732:5: ( rpc_block[proto, service] | annotation_entry[proto] | comment_entry[proto] | option_entry[proto, service] )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:732:9: rpc_block[proto, service]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_rpc_block_in_service_body3557);
					rpc_block200=rpc_block(proto, service);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rpc_block200.getTree());

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:733:9: annotation_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_annotation_entry_in_service_body3568);
					annotation_entry201=annotation_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, annotation_entry201.getTree());

					}
					break;
				case 3 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:734:9: comment_entry[proto]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_comment_entry_in_service_body3579);
					comment_entry202=comment_entry(proto);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, comment_entry202.getTree());

					}
					break;
				case 4 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:735:9: option_entry[proto, service]
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_option_entry_in_service_body3590);
					option_entry203=option_entry(proto, service);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry203.getTree());

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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:738:1: rpc_block[Proto proto, Service service] : RPC n= ID LEFTPAREN (ap= FULL_ID |a= ( VOID | ID ) ) RIGHTPAREN RETURNS LEFTPAREN (rp= FULL_ID |r= ( VOID | ID ) ) RIGHTPAREN ( rpc_body_block[proto, rm] )? SEMICOLON !;
	public final ProtoParser.rpc_block_return rpc_block(Proto proto, Service service) throws RecognitionException {
		ProtoParser.rpc_block_return retval = new ProtoParser.rpc_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;
		Token ap=null;
		Token a=null;
		Token rp=null;
		Token r=null;
		Token RPC204=null;
		Token LEFTPAREN205=null;
		Token RIGHTPAREN206=null;
		Token RETURNS207=null;
		Token LEFTPAREN208=null;
		Token RIGHTPAREN209=null;
		Token SEMICOLON211=null;
		ParserRuleReturnScope rpc_body_block210 =null;

		Object n_tree=null;
		Object ap_tree=null;
		Object a_tree=null;
		Object rp_tree=null;
		Object r_tree=null;
		Object RPC204_tree=null;
		Object LEFTPAREN205_tree=null;
		Object RIGHTPAREN206_tree=null;
		Object RETURNS207_tree=null;
		Object LEFTPAREN208_tree=null;
		Object RIGHTPAREN209_tree=null;
		Object SEMICOLON211_tree=null;


		    String argName = null, argPackage = null, retName = null, retPackage = null;
		    Service.RpcMethod rm = null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:743:5: ( RPC n= ID LEFTPAREN (ap= FULL_ID |a= ( VOID | ID ) ) RIGHTPAREN RETURNS LEFTPAREN (rp= FULL_ID |r= ( VOID | ID ) ) RIGHTPAREN ( rpc_body_block[proto, rm] )? SEMICOLON !)
			// com/dyuproject/fbsgen/parser/ProtoParser.g:743:9: RPC n= ID LEFTPAREN (ap= FULL_ID |a= ( VOID | ID ) ) RIGHTPAREN RETURNS LEFTPAREN (rp= FULL_ID |r= ( VOID | ID ) ) RIGHTPAREN ( rpc_body_block[proto, rm] )? SEMICOLON !
			{
			root_0 = (Object)adaptor.nil();


			RPC204=(Token)match(input,RPC,FOLLOW_RPC_in_rpc_block3621); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPC204_tree = (Object)adaptor.create(RPC204);
			adaptor.addChild(root_0, RPC204_tree);
			}

			n=(Token)match(input,ID,FOLLOW_ID_in_rpc_block3625); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			n_tree = (Object)adaptor.create(n);
			adaptor.addChild(root_0, n_tree);
			}

			LEFTPAREN205=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_rpc_block3627); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTPAREN205_tree = (Object)adaptor.create(LEFTPAREN205);
			adaptor.addChild(root_0, LEFTPAREN205_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:743:28: (ap= FULL_ID |a= ( VOID | ID ) )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:743:29: ap= FULL_ID
					{
					ap=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_rpc_block3632); if (state.failed) return retval;
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:748:13: a= ( VOID | ID )
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

			RIGHTPAREN206=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_rpc_block3649); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTPAREN206_tree = (Object)adaptor.create(RIGHTPAREN206);
			adaptor.addChild(root_0, RIGHTPAREN206_tree);
			}

			RETURNS207=(Token)match(input,RETURNS,FOLLOW_RETURNS_in_rpc_block3660); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RETURNS207_tree = (Object)adaptor.create(RETURNS207);
			adaptor.addChild(root_0, RETURNS207_tree);
			}

			LEFTPAREN208=(Token)match(input,LEFTPAREN,FOLLOW_LEFTPAREN_in_rpc_block3662); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTPAREN208_tree = (Object)adaptor.create(LEFTPAREN208);
			adaptor.addChild(root_0, LEFTPAREN208_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:749:27: (rp= FULL_ID |r= ( VOID | ID ) )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:749:28: rp= FULL_ID
					{
					rp=(Token)match(input,FULL_ID,FOLLOW_FULL_ID_in_rpc_block3667); if (state.failed) return retval;
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:754:13: r= ( VOID | ID )
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

			RIGHTPAREN209=(Token)match(input,RIGHTPAREN,FOLLOW_RIGHTPAREN_in_rpc_block3684); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTPAREN209_tree = (Object)adaptor.create(RIGHTPAREN209);
			adaptor.addChild(root_0, RIGHTPAREN209_tree);
			}

			if ( state.backtracking==0 ) {
			            rm = service.addRpcMethod((n!=null?n.getText():null), argName, argPackage, retName, retPackage);
			            proto.addAnnotationsTo(rm);
			        }
			// com/dyuproject/fbsgen/parser/ProtoParser.g:757:11: ( rpc_body_block[proto, rm] )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==LEFTCURLY) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:757:11: rpc_body_block[proto, rm]
					{
					pushFollow(FOLLOW_rpc_body_block_in_rpc_block3688);
					rpc_body_block210=rpc_body_block(proto, rm);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rpc_body_block210.getTree());

					}
					break;

			}

			SEMICOLON211=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_rpc_block3692); if (state.failed) return retval;
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:760:1: rpc_body_block[Proto proto, Service.RpcMethod rm] : LEFTCURLY ( option_entry[proto, rm] )* RIGHTCURLY ;
	public final ProtoParser.rpc_body_block_return rpc_body_block(Proto proto, Service.RpcMethod rm) throws RecognitionException {
		ProtoParser.rpc_body_block_return retval = new ProtoParser.rpc_body_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTCURLY212=null;
		Token RIGHTCURLY214=null;
		ParserRuleReturnScope option_entry213 =null;

		Object LEFTCURLY212_tree=null;
		Object RIGHTCURLY214_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:761:5: ( LEFTCURLY ( option_entry[proto, rm] )* RIGHTCURLY )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:761:9: LEFTCURLY ( option_entry[proto, rm] )* RIGHTCURLY
			{
			root_0 = (Object)adaptor.nil();


			LEFTCURLY212=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_rpc_body_block3718); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY212_tree = (Object)adaptor.create(LEFTCURLY212);
			adaptor.addChild(root_0, LEFTCURLY212_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:761:19: ( option_entry[proto, rm] )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==OPTION) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:761:19: option_entry[proto, rm]
					{
					pushFollow(FOLLOW_option_entry_in_rpc_body_block3720);
					option_entry213=option_entry(proto, rm);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, option_entry213.getTree());

					}
					break;

				default :
					break loop43;
				}
			}

			RIGHTCURLY214=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_rpc_body_block3724); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY214_tree = (Object)adaptor.create(RIGHTCURLY214);
			adaptor.addChild(root_0, RIGHTCURLY214_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:797:1: ignore_block : LEFTCURLY ( ignore_block_body )* RIGHTCURLY ;
	public final ProtoParser.ignore_block_return ignore_block() throws RecognitionException {
		ProtoParser.ignore_block_return retval = new ProtoParser.ignore_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFTCURLY215=null;
		Token RIGHTCURLY217=null;
		ParserRuleReturnScope ignore_block_body216 =null;

		Object LEFTCURLY215_tree=null;
		Object RIGHTCURLY217_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:798:5: ( LEFTCURLY ( ignore_block_body )* RIGHTCURLY )
			// com/dyuproject/fbsgen/parser/ProtoParser.g:798:9: LEFTCURLY ( ignore_block_body )* RIGHTCURLY
			{
			root_0 = (Object)adaptor.nil();


			LEFTCURLY215=(Token)match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_ignore_block3788); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFTCURLY215_tree = (Object)adaptor.create(LEFTCURLY215);
			adaptor.addChild(root_0, LEFTCURLY215_tree);
			}

			// com/dyuproject/fbsgen/parser/ProtoParser.g:798:19: ( ignore_block_body )*
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( ((LA44_0 >= ASSIGN && LA44_0 <= RETURNS)||(LA44_0 >= RIGHTPAREN && LA44_0 <= WS)) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:798:19: ignore_block_body
					{
					pushFollow(FOLLOW_ignore_block_body_in_ignore_block3790);
					ignore_block_body216=ignore_block_body();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_block_body216.getTree());

					}
					break;

				default :
					break loop44;
				}
			}

			RIGHTCURLY217=(Token)match(input,RIGHTCURLY,FOLLOW_RIGHTCURLY_in_ignore_block3793); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHTCURLY217_tree = (Object)adaptor.create(RIGHTCURLY217);
			adaptor.addChild(root_0, RIGHTCURLY217_tree);
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
	// com/dyuproject/fbsgen/parser/ProtoParser.g:801:1: ignore_block_body : ( ( LEFTCURLY )=> ignore_block |~ RIGHTCURLY );
	public final ProtoParser.ignore_block_body_return ignore_block_body() throws RecognitionException {
		ProtoParser.ignore_block_body_return retval = new ProtoParser.ignore_block_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set219=null;
		ParserRuleReturnScope ignore_block218 =null;

		Object set219_tree=null;

		try {
			// com/dyuproject/fbsgen/parser/ProtoParser.g:802:5: ( ( LEFTCURLY )=> ignore_block |~ RIGHTCURLY )
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
					// com/dyuproject/fbsgen/parser/ProtoParser.g:802:9: ( LEFTCURLY )=> ignore_block
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ignore_block_in_ignore_block_body3821);
					ignore_block218=ignore_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ignore_block218.getTree());

					}
					break;
				case 2 :
					// com/dyuproject/fbsgen/parser/ProtoParser.g:803:9: ~ RIGHTCURLY
					{
					root_0 = (Object)adaptor.nil();


					set219=input.LT(1);
					if ( (input.LA(1) >= ASSIGN && input.LA(1) <= RETURNS)||(input.LA(1) >= RIGHTPAREN && input.LA(1) <= WS) ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set219));
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
		// com/dyuproject/fbsgen/parser/ProtoParser.g:802:9: ( LEFTCURLY )
		// com/dyuproject/fbsgen/parser/ProtoParser.g:802:10: LEFTCURLY
		{
		match(input,LEFTCURLY,FOLLOW_LEFTCURLY_in_synpred1_ProtoParser3817); if (state.failed) return;

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
	public static final BitSet FOLLOW_LEFTSQUARE_in_list_val704 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_list_val724 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_list_val728 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_list_val730 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_list_val752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_list_val812 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_list_val832 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_list_val836 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_list_val838 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_list_val860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_list_val892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_list_val912 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_list_val932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_list_val952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_list_val972 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_list_val992 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_full_in_map_val1032 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COLON_in_map_val1034 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_map_val1068 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_map_val1088 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_map_val1092 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_map_val1094 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_map_val1116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_map_val1176 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_map_val1196 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_map_val1200 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_map_val1202 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_map_val1224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_map_val1256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_map_val1276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_map_val1296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_map_val1316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_map_val1336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_map_val1356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_full_in_annotation_keyval1396 = new BitSet(new long[]{0x0000000000000110L});
	public static final BitSet FOLLOW_set_in_annotation_keyval1398 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_LEFTCURLY_in_annotation_keyval1436 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_annotation_keyval1456 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_annotation_keyval1460 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_annotation_keyval1462 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_annotation_keyval1484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_annotation_keyval1544 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_annotation_keyval1564 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_annotation_keyval1568 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_annotation_keyval1570 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_annotation_keyval1592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_reserved_in_annotation_keyval1626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_annotation_keyval1646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_annotation_keyval1668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_annotation_keyval1688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_annotation_keyval1708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_annotation_keyval1728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_annotation_keyval1748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_annotation_keyval1768 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_annotation_keyval1788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SYNTAX_in_header_syntax1821 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_header_syntax1823 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_header_syntax1825 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_header_syntax1827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PKG_in_header_package1856 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_FULL_ID_in_header_package1859 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_var_in_header_package1865 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_header_package1870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_header_import1898 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_header_import1900 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_header_import1902 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTION_in_option_entry1931 = new BitSet(new long[]{0x5EDA3B81AFCC68C0L});
	public static final BitSet FOLLOW_LEFTPAREN_in_option_entry1933 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_var_full_in_option_entry1938 = new BitSet(new long[]{0x0000800000000010L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_option_entry1940 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_option_entry1943 = new BitSet(new long[]{0x5FFA3B9DDFCE68C0L});
	public static final BitSet FOLLOW_LEFTCURLY_in_option_entry1977 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_option_entry1997 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_option_entry2001 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_option_entry2003 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_option_entry2025 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_option_entry2085 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_option_entry2105 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_option_entry2109 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_option_entry2111 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_option_entry2133 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_var_reserved_in_option_entry2167 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_ID_in_option_entry2189 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_FULL_ID_in_option_entry2211 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_NUMFLOAT_in_option_entry2231 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_NUMINT_in_option_entry2251 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_option_entry2271 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_TRUE_in_option_entry2291 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_FALSE_in_option_entry2311 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_option_entry2331 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_option_entry2345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MESSAGE_in_message_block2378 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_message_block2380 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_message_block2393 = new BitSet(new long[]{0x0008598100005020L});
	public static final BitSet FOLLOW_message_body_in_message_block2396 = new BitSet(new long[]{0x0008598100005020L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_message_block2401 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_message_block_in_message_body2424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_message_field_in_message_body2435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_block_in_message_body2446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_service_block_in_message_body2457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_message_body2478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_message_body2489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_message_body2500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_message_field2548 = new BitSet(new long[]{0x1E1000000F4C20C0L});
	public static final BitSet FOLLOW_REQUIRED_in_message_field2565 = new BitSet(new long[]{0x1E1000000F4C20C0L});
	public static final BitSet FOLLOW_REPEATED_in_message_field2582 = new BitSet(new long[]{0x1E1000000F4C20C0L});
	public static final BitSet FOLLOW_field_type_in_message_field2597 = new BitSet(new long[]{0x5EDA3B818FC468C0L});
	public static final BitSet FOLLOW_var_in_message_field2609 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_message_field2611 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_NUMINT_in_message_field2613 = new BitSet(new long[]{0x0004000050000000L});
	public static final BitSet FOLLOW_field_options_in_message_field2627 = new BitSet(new long[]{0x0004000010000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_message_field2643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ignore_block_in_message_field2648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_field_type2674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT8_in_field_type2686 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT8_in_field_type2698 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT16_in_field_type2710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT16_in_field_type2722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT32_in_field_type2734 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT32_in_field_type2746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT64_in_field_type2758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UINT64_in_field_type2770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_field_type2782 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_in_field_type2794 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_field_type2806 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BYTES_in_field_type2818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_field_type2850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_field_type2862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_field_options2889 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_field_options2891 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_field_options2904 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_field_options2906 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_field_options2911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_full_in_field_options_keyval2943 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_field_options_keyval2945 = new BitSet(new long[]{0x5FFA3BBFDFDF68C0L});
	public static final BitSet FOLLOW_LEFTCURLY_in_field_options_keyval2963 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_field_options_keyval2975 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_COMMA_in_field_options_keyval2979 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_map_val_in_field_options_keyval2981 = new BitSet(new long[]{0x0000400000000200L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_field_options_keyval2995 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_field_options_keyval3023 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_field_options_keyval3035 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_field_options_keyval3039 = new BitSet(new long[]{0x0120001C50020000L});
	public static final BitSet FOLLOW_list_val_in_field_options_keyval3041 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_field_options_keyval3055 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_reserved_in_field_options_keyval3073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_field_options_keyval3086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMFLOAT_in_field_options_keyval3098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMINT_in_field_options_keyval3111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMDOUBLE_in_field_options_keyval3123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HEX_in_field_options_keyval3135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OCTAL_in_field_options_keyval3147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_field_options_keyval3159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_field_options_keyval3175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_field_options_keyval3189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_ID_in_field_options_keyval3201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXP_in_field_options_keyval3213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_signed_constant_in_field_options_keyval3225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_signed_constant3263 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_signed_constant3265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ENUM_in_enum_block3297 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_enum_block3299 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_enum_block3312 = new BitSet(new long[]{0x0000408000401020L});
	public static final BitSet FOLLOW_enum_body_in_enum_block3315 = new BitSet(new long[]{0x0000408000401020L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_enum_block3320 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_enum_block3325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_field_in_enum_body3353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_enum_body3364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_enum_body3375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_enum_body3386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_enum_field3413 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSIGN_in_enum_field3415 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_NUMINT_in_enum_field3417 = new BitSet(new long[]{0x0004000040000000L});
	public static final BitSet FOLLOW_enum_options_in_enum_field3422 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_enum_field3427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTSQUARE_in_enum_options3450 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_enum_options3452 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_COMMA_in_enum_options3465 = new BitSet(new long[]{0x5EDA3B818FCC68C0L});
	public static final BitSet FOLLOW_field_options_keyval_in_enum_options3467 = new BitSet(new long[]{0x0001000000000200L});
	public static final BitSet FOLLOW_RIGHTSQUARE_in_enum_options3472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SERVICE_in_service_block3502 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_service_block3504 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LEFTCURLY_in_service_block3508 = new BitSet(new long[]{0x0002008000001020L});
	public static final BitSet FOLLOW_service_body_in_service_block3519 = new BitSet(new long[]{0x0002408000001020L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_service_block3524 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_service_block3527 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rpc_block_in_service_body3557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_annotation_entry_in_service_body3568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_entry_in_service_body3579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_option_entry_in_service_body3590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RPC_in_rpc_block3621 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_rpc_block3625 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_rpc_block3627 = new BitSet(new long[]{0x4000000000480000L});
	public static final BitSet FOLLOW_FULL_ID_in_rpc_block3632 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_set_in_rpc_block3640 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_rpc_block3649 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RETURNS_in_rpc_block3660 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LEFTPAREN_in_rpc_block3662 = new BitSet(new long[]{0x4000000000480000L});
	public static final BitSet FOLLOW_FULL_ID_in_rpc_block3667 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_set_in_rpc_block3675 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RIGHTPAREN_in_rpc_block3684 = new BitSet(new long[]{0x0004000010000000L});
	public static final BitSet FOLLOW_rpc_body_block_in_rpc_block3688 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_rpc_block3692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_rpc_body_block3718 = new BitSet(new long[]{0x0000408000000000L});
	public static final BitSet FOLLOW_option_entry_in_rpc_body_block3720 = new BitSet(new long[]{0x0000408000000000L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_rpc_body_block3724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_ignore_block3788 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L});
	public static final BitSet FOLLOW_ignore_block_body_in_ignore_block3790 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L});
	public static final BitSet FOLLOW_RIGHTCURLY_in_ignore_block3793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ignore_block_in_ignore_block_body3821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_ignore_block_body3831 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTCURLY_in_synpred1_ProtoParser3817 = new BitSet(new long[]{0x0000000000000002L});
}
