// Generated from XtdAQL.g4 by ANTLR 4.4

	package lang.core.parser;


/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XtdAQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__68=1, T__67=2, T__66=3, T__65=4, T__64=5, T__63=6, T__62=7, T__61=8, 
		T__60=9, T__59=10, T__58=11, T__57=12, T__56=13, T__55=14, T__54=15, T__53=16, 
		T__52=17, T__51=18, T__50=19, T__49=20, T__48=21, T__47=22, T__46=23, 
		T__45=24, T__44=25, T__43=26, T__42=27, T__41=28, T__40=29, T__39=30, 
		T__38=31, T__37=32, T__36=33, T__35=34, T__34=35, T__33=36, T__32=37, 
		T__31=38, T__30=39, T__29=40, T__28=41, T__27=42, T__26=43, T__25=44, 
		T__24=45, T__23=46, T__22=47, T__21=48, T__20=49, T__19=50, T__18=51, 
		T__17=52, T__16=53, T__15=54, T__14=55, T__13=56, T__12=57, T__11=58, 
		T__10=59, T__9=60, T__8=61, T__7=62, T__6=63, T__5=64, T__4=65, T__3=66, 
		T__2=67, T__1=68, T__0=69, COMMENT=70, LINECOMMENT=71, STRING=72, WS=73, 
		MultOp=74, Integer=75, Real=76, String=77, ErrorString=78, Ident=79;
	public static final String[] tokenNames = {
		"<INVALID>", "'endif'", "'use'", "'!='", "'while'", "'{'", "'::'", "'..'", 
		"'one'", "'='", "'for'", "'OrderedSet('", "'null'", "'override'", "'implies'", 
		"'('", "'closure'", "','", "'false'", "'Sequence('", "'Real'", "'reject'", 
		"'>='", "'String'", "'<'", "'forAll'", "']'", "'Sequence{'", "'@'", "'<>'", 
		"'let'", "'+'", "'then'", "'def'", "'as'", "'behavior'", "'true'", "'class'", 
		"';'", "'Integer'", "'any'", "'}'", "'extends'", "'if'", "':='", "'<='", 
		"'sortedBy'", "'isUnique'", "'collect'", "'exists'", "'.'", "'Boolean'", 
		"'->'", "'OrderedSet{'", "':'", "'['", "'|'", "'=='", "'select'", "'>'", 
		"'xor'", "'or'", "'open'", "'else'", "'in'", "')'", "'and'", "'not'", 
		"'-'", "'import'", "COMMENT", "LINECOMMENT", "STRING", "WS", "MultOp", 
		"Integer", "Real", "String", "ErrorString", "Ident"
	};
	public static final int
		RULE_rRoot = 0, RULE_rImport = 1, RULE_rService = 2, RULE_rClass = 3, 
		RULE_rOpenClass = 4, RULE_rNewClass = 5, RULE_rOperation = 6, RULE_rTag = 7, 
		RULE_rParameters = 8, RULE_rVariable = 9, RULE_rAttribute = 10, RULE_rStatement = 11, 
		RULE_rVarDecl = 12, RULE_rAssign = 13, RULE_rForEach = 14, RULE_rCollection = 15, 
		RULE_rBlock = 16, RULE_rIf = 17, RULE_rWhile = 18, RULE_rExpression = 19, 
		RULE_rType = 20, RULE_rQualified = 21, RULE_expression = 22, RULE_binding = 23, 
		RULE_addOp = 24, RULE_compOp = 25, RULE_navigationSegment = 26, RULE_callExp = 27, 
		RULE_lambdaExpression = 28, RULE_collectionIterator = 29, RULE_expressionSequence = 30, 
		RULE_variableDefinition = 31, RULE_literal = 32, RULE_typeLiteral = 33, 
		RULE_classifierTypeRule = 34;
	public static final String[] ruleNames = {
		"rRoot", "rImport", "rService", "rClass", "rOpenClass", "rNewClass", "rOperation", 
		"rTag", "rParameters", "rVariable", "rAttribute", "rStatement", "rVarDecl", 
		"rAssign", "rForEach", "rCollection", "rBlock", "rIf", "rWhile", "rExpression", 
		"rType", "rQualified", "expression", "binding", "addOp", "compOp", "navigationSegment", 
		"callExp", "lambdaExpression", "collectionIterator", "expressionSequence", 
		"variableDefinition", "literal", "typeLiteral", "classifierTypeRule"
	};

	@Override
	public String getGrammarFileName() { return "XtdAQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XtdAQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RRootContext extends ParserRuleContext {
		public List<RImportContext> rImport() {
			return getRuleContexts(RImportContext.class);
		}
		public RImportContext rImport(int i) {
			return getRuleContext(RImportContext.class,i);
		}
		public RServiceContext rService(int i) {
			return getRuleContext(RServiceContext.class,i);
		}
		public List<RServiceContext> rService() {
			return getRuleContexts(RServiceContext.class);
		}
		public RClassContext rClass(int i) {
			return getRuleContext(RClassContext.class,i);
		}
		public RQualifiedContext rQualified() {
			return getRuleContext(RQualifiedContext.class,0);
		}
		public List<RClassContext> rClass() {
			return getRuleContexts(RClassContext.class);
		}
		public RRootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rRoot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRRoot(this);
		}
	}

	public final RRootContext rRoot() throws RecognitionException {
		RRootContext _localctx = new RRootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rRoot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(T__34);
			setState(71); rQualified();
			setState(72); match(T__31);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(73); rImport();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__67) {
				{
				{
				setState(79); rService();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32 || _la==T__7) {
				{
				{
				setState(85); rClass();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RImportContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public RQualifiedContext rQualified() {
			return getRuleContext(RQualifiedContext.class,0);
		}
		public RImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRImport(this);
		}
	}

	public final RImportContext rImport() throws RecognitionException {
		RImportContext _localctx = new RImportContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); match(T__0);
			setState(92); rQualified();
			setState(93); match(T__35);
			setState(94); match(Ident);
			setState(95); match(T__31);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RServiceContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(XtdAQLParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(XtdAQLParser.Ident, i);
		}
		public RServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rService; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRService(this);
		}
	}

	public final RServiceContext rService() throws RecognitionException {
		RServiceContext _localctx = new RServiceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rService);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(T__67);
			setState(98); match(Ident);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(99); match(T__19);
				setState(100); match(Ident);
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106); match(T__31);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RClassContext extends ParserRuleContext {
		public ROpenClassContext rOpenClass() {
			return getRuleContext(ROpenClassContext.class,0);
		}
		public RNewClassContext rNewClass() {
			return getRuleContext(RNewClassContext.class,0);
		}
		public RClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRClass(this);
		}
	}

	public final RClassContext rClass() throws RecognitionException {
		RClassContext _localctx = new RClassContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rClass);
		try {
			setState(110);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(108); rOpenClass();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(109); rNewClass();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ROpenClassContext extends ParserRuleContext {
		public RQualifiedContext name;
		public RQualifiedContext rQualified(int i) {
			return getRuleContext(RQualifiedContext.class,i);
		}
		public ROperationContext rOperation(int i) {
			return getRuleContext(ROperationContext.class,i);
		}
		public List<ROperationContext> rOperation() {
			return getRuleContexts(ROperationContext.class);
		}
		public List<RAttributeContext> rAttribute() {
			return getRuleContexts(RAttributeContext.class);
		}
		public List<RQualifiedContext> rQualified() {
			return getRuleContexts(RQualifiedContext.class);
		}
		public RAttributeContext rAttribute(int i) {
			return getRuleContext(RAttributeContext.class,i);
		}
		public ROpenClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rOpenClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterROpenClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitROpenClass(this);
		}
	}

	public final ROpenClassContext rOpenClass() throws RecognitionException {
		ROpenClassContext _localctx = new ROpenClassContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rOpenClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(T__7);
			setState(113); match(T__32);
			setState(114); ((ROpenClassContext)_localctx).name = rQualified();
			setState(124);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(115); match(T__27);
				setState(116); rQualified();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__52) {
					{
					{
					setState(117); match(T__52);
					setState(118); rQualified();
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(126); match(T__64);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__64) | (1L << T__58) | (1L << T__50) | (1L << T__49) | (1L << T__46) | (1L << T__30) | (1L << T__18))) != 0) || _la==Ident) {
				{
				{
				setState(127); rAttribute();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__56) | (1L << T__41) | (1L << T__36))) != 0)) {
				{
				{
				setState(133); rOperation();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139); match(T__28);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RNewClassContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public ROperationContext rOperation(int i) {
			return getRuleContext(ROperationContext.class,i);
		}
		public List<ROperationContext> rOperation() {
			return getRuleContexts(ROperationContext.class);
		}
		public List<RAttributeContext> rAttribute() {
			return getRuleContexts(RAttributeContext.class);
		}
		public RAttributeContext rAttribute(int i) {
			return getRuleContext(RAttributeContext.class,i);
		}
		public RNewClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rNewClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRNewClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRNewClass(this);
		}
	}

	public final RNewClassContext rNewClass() throws RecognitionException {
		RNewClassContext _localctx = new RNewClassContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rNewClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(T__32);
			setState(142); ((RNewClassContext)_localctx).name = match(Ident);
			setState(143); match(T__64);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__64) | (1L << T__58) | (1L << T__50) | (1L << T__49) | (1L << T__46) | (1L << T__30) | (1L << T__18))) != 0) || _la==Ident) {
				{
				{
				setState(144); rAttribute();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__56) | (1L << T__41) | (1L << T__36))) != 0)) {
				{
				{
				setState(150); rOperation();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156); match(T__28);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ROperationContext extends ParserRuleContext {
		public RTypeContext type;
		public Token name;
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public RParametersContext rParameters() {
			return getRuleContext(RParametersContext.class,0);
		}
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RTagContext rTag(int i) {
			return getRuleContext(RTagContext.class,i);
		}
		public RBlockContext rBlock() {
			return getRuleContext(RBlockContext.class,0);
		}
		public List<RTagContext> rTag() {
			return getRuleContexts(RTagContext.class);
		}
		public ROperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterROperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitROperation(this);
		}
	}

	public final ROperationContext rOperation() throws RecognitionException {
		ROperationContext _localctx = new ROperationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__41) {
				{
				{
				setState(158); rTag();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			_la = _input.LA(1);
			if ( !(_la==T__56 || _la==T__36) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(165); ((ROperationContext)_localctx).type = rType();
			setState(166); ((ROperationContext)_localctx).name = match(Ident);
			setState(167); match(T__54);
			setState(169);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__64) | (1L << T__58) | (1L << T__50) | (1L << T__49) | (1L << T__46) | (1L << T__30) | (1L << T__18))) != 0) || _la==Ident) {
				{
				setState(168); rParameters();
				}
			}

			setState(171); match(T__4);
			setState(172); rBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RTagContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public RTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRTag(this);
		}
	}

	public final RTagContext rTag() throws RecognitionException {
		RTagContext _localctx = new RTagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(T__41);
			setState(175); match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RParametersContext extends ParserRuleContext {
		public RVariableContext rVariable(int i) {
			return getRuleContext(RVariableContext.class,i);
		}
		public List<RVariableContext> rVariable() {
			return getRuleContexts(RVariableContext.class);
		}
		public RParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRParameters(this);
		}
	}

	public final RParametersContext rParameters() throws RecognitionException {
		RParametersContext _localctx = new RParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); rVariable();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__52) {
				{
				{
				setState(178); match(T__52);
				setState(179); rVariable();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RVariableContext extends ParserRuleContext {
		public RTypeContext type;
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRVariable(this);
		}
	}

	public final RVariableContext rVariable() throws RecognitionException {
		RVariableContext _localctx = new RVariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); ((RVariableContext)_localctx).type = rType();
			setState(186); match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RAttributeContext extends ParserRuleContext {
		public RTypeContext type;
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRAttribute(this);
		}
	}

	public final RAttributeContext rAttribute() throws RecognitionException {
		RAttributeContext _localctx = new RAttributeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); ((RAttributeContext)_localctx).type = rType();
			setState(189); match(Ident);
			setState(192);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(190); match(T__25);
				setState(191); expression(0);
				}
			}

			setState(194); match(T__31);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RStatementContext extends ParserRuleContext {
		public RAssignContext rAssign() {
			return getRuleContext(RAssignContext.class,0);
		}
		public RWhileContext rWhile() {
			return getRuleContext(RWhileContext.class,0);
		}
		public RIfContext rIf() {
			return getRuleContext(RIfContext.class,0);
		}
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RVarDeclContext rVarDecl() {
			return getRuleContext(RVarDeclContext.class,0);
		}
		public RForEachContext rForEach() {
			return getRuleContext(RForEachContext.class,0);
		}
		public RStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRStatement(this);
		}
	}

	public final RStatementContext rStatement() throws RecognitionException {
		RStatementContext _localctx = new RStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rStatement);
		try {
			setState(202);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196); rVarDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197); rAssign();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(198); rForEach();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(199); rWhile();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(200); rIf();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(201); rExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RVarDeclContext extends ParserRuleContext {
		public RTypeContext type;
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRVarDecl(this);
		}
	}

	public final RVarDeclContext rVarDecl() throws RecognitionException {
		RVarDeclContext _localctx = new RVarDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); ((RVarDeclContext)_localctx).type = rType();
			setState(205); match(Ident);
			setState(208);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(206); match(T__25);
				setState(207); expression(0);
				}
			}

			setState(210); match(T__31);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RAssignContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public RAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRAssign(this);
		}
	}

	public final RAssignContext rAssign() throws RecognitionException {
		RAssignContext _localctx = new RAssignContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); expression(0);
			setState(213); match(T__25);
			setState(214); expression(0);
			setState(215); match(T__31);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RForEachContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public RCollectionContext rCollection() {
			return getRuleContext(RCollectionContext.class,0);
		}
		public RBlockContext rBlock() {
			return getRuleContext(RBlockContext.class,0);
		}
		public RForEachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rForEach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRForEach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRForEach(this);
		}
	}

	public final RForEachContext rForEach() throws RecognitionException {
		RForEachContext _localctx = new RForEachContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rForEach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); match(T__59);
			setState(218); match(T__54);
			setState(219); match(Ident);
			setState(220); match(T__5);
			setState(221); rCollection();
			setState(222); match(T__4);
			setState(223); rBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RCollectionContext extends ParserRuleContext {
		public TerminalNode Integer(int i) {
			return getToken(XtdAQLParser.Integer, i);
		}
		public List<TerminalNode> Integer() { return getTokens(XtdAQLParser.Integer); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RCollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rCollection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRCollection(this);
		}
	}

	public final RCollectionContext rCollection() throws RecognitionException {
		RCollectionContext _localctx = new RCollectionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_rCollection);
		try {
			setState(231);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(225); match(T__14);
				setState(226); match(Integer);
				setState(227); match(T__62);
				setState(228); match(Integer);
				setState(229); match(T__43);
				}
				break;
			case T__64:
			case T__58:
			case T__57:
			case T__54:
			case T__51:
			case T__50:
			case T__49:
			case T__46:
			case T__42:
			case T__39:
			case T__33:
			case T__30:
			case T__26:
			case T__18:
			case T__16:
			case T__2:
			case T__1:
			case Integer:
			case Real:
			case String:
			case ErrorString:
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(230); expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RBlockContext extends ParserRuleContext {
		public List<RStatementContext> rStatement() {
			return getRuleContexts(RStatementContext.class);
		}
		public RStatementContext rStatement(int i) {
			return getRuleContext(RStatementContext.class,i);
		}
		public RBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRBlock(this);
		}
	}

	public final RBlockContext rBlock() throws RecognitionException {
		RBlockContext _localctx = new RBlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233); match(T__64);
			setState(241);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__65) | (1L << T__64) | (1L << T__59) | (1L << T__58) | (1L << T__57) | (1L << T__54) | (1L << T__51) | (1L << T__50) | (1L << T__49) | (1L << T__46) | (1L << T__42) | (1L << T__39) | (1L << T__33) | (1L << T__30) | (1L << T__26) | (1L << T__18) | (1L << T__16))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__2 - 67)) | (1L << (T__1 - 67)) | (1L << (Integer - 67)) | (1L << (Real - 67)) | (1L << (String - 67)) | (1L << (ErrorString - 67)) | (1L << (Ident - 67)))) != 0)) {
				{
				setState(234); rStatement();
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__65) | (1L << T__64) | (1L << T__59) | (1L << T__58) | (1L << T__57) | (1L << T__54) | (1L << T__51) | (1L << T__50) | (1L << T__49) | (1L << T__46) | (1L << T__42) | (1L << T__39) | (1L << T__33) | (1L << T__30) | (1L << T__26) | (1L << T__18) | (1L << T__16))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__2 - 67)) | (1L << (T__1 - 67)) | (1L << (Integer - 67)) | (1L << (Real - 67)) | (1L << (String - 67)) | (1L << (ErrorString - 67)) | (1L << (Ident - 67)))) != 0)) {
					{
					{
					setState(235); rStatement();
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(243); match(T__28);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RIfContext extends ParserRuleContext {
		public RBlockContext rBlock(int i) {
			return getRuleContext(RBlockContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<RBlockContext> rBlock() {
			return getRuleContexts(RBlockContext.class);
		}
		public RIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRIf(this);
		}
	}

	public final RIfContext rIf() throws RecognitionException {
		RIfContext _localctx = new RIfContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245); match(T__26);
			setState(246); match(T__54);
			setState(247); expression(0);
			setState(248); match(T__4);
			setState(249); rBlock();
			setState(252);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(250); match(T__6);
				setState(251); rBlock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RWhileContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RBlockContext rBlock() {
			return getRuleContext(RBlockContext.class,0);
		}
		public RWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRWhile(this);
		}
	}

	public final RWhileContext rWhile() throws RecognitionException {
		RWhileContext _localctx = new RWhileContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(T__65);
			setState(255); match(T__54);
			setState(256); expression(0);
			setState(257); match(T__4);
			setState(258); rBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRExpression(this);
		}
	}

	public final RExpressionContext rExpression() throws RecognitionException {
		RExpressionContext _localctx = new RExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_rExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); expression(0);
			setState(261); match(T__31);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RTypeContext extends ParserRuleContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public RQualifiedContext rQualified() {
			return getRuleContext(RQualifiedContext.class,0);
		}
		public RTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRType(this);
		}
	}

	public final RTypeContext rType() throws RecognitionException {
		RTypeContext _localctx = new RTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_rType);
		try {
			setState(265);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(263); rQualified();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(264); typeLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RQualifiedContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(XtdAQLParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(XtdAQLParser.Ident, i);
		}
		public RQualifiedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rQualified; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRQualified(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRQualified(this);
		}
	}

	public final RQualifiedContext rQualified() throws RecognitionException {
		RQualifiedContext _localctx = new RQualifiedContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_rQualified);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); match(Ident);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(268); match(T__19);
				setState(269); match(Ident);
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarRefContext extends ExpressionContext {
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public VarRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitVarRef(this);
		}
	}
	public static class AddContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public AddContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitAdd(this);
		}
	}
	public static class NavContext extends ExpressionContext {
		public NavigationSegmentContext navigationSegment() {
			return getRuleContext(NavigationSegmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NavContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterNav(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitNav(this);
		}
	}
	public static class OrContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitOr(this);
		}
	}
	public static class LetExprContext extends ExpressionContext {
		public List<BindingContext> binding() {
			return getRuleContexts(BindingContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BindingContext binding(int i) {
			return getRuleContext(BindingContext.class,i);
		}
		public LetExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterLetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitLetExpr(this);
		}
	}
	public static class ConditionalContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ConditionalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitConditional(this);
		}
	}
	public static class CompContext extends ExpressionContext {
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CompContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitComp(this);
		}
	}
	public static class NotContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitNot(this);
		}
	}
	public static class MinContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MinContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitMin(this);
		}
	}
	public static class ImpliesContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ImpliesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitImplies(this);
		}
	}
	public static class MultContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MultOp() { return getToken(XtdAQLParser.MultOp, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MultContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitMult(this);
		}
	}
	public static class LitContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitLit(this);
		}
	}
	public static class AndContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitAnd(this);
		}
	}
	public static class XorContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public XorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitXor(this);
		}
	}
	public static class ParenContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitParen(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(276); match(T__2);
				setState(277); expression(14);
				}
				break;
			case 2:
				{
				_localctx = new MinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278); match(T__1);
				setState(279); expression(13);
				}
				break;
			case 3:
				{
				_localctx = new LetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(280); match(T__39);
				setState(281); binding();
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__52) {
					{
					{
					setState(282); match(T__52);
					setState(283); binding();
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(289); match(T__5);
				setState(290); expression(1);
				}
				break;
			case 4:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292); match(Ident);
				}
				break;
			case 5:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293); literal();
				}
				break;
			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294); match(T__54);
				setState(295); expression(0);
				setState(296); match(T__4);
				}
				break;
			case 7:
				{
				_localctx = new ConditionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298); match(T__26);
				setState(299); expression(0);
				setState(300); match(T__37);
				setState(301); expression(0);
				setState(302); match(T__6);
				setState(303); expression(0);
				setState(304); match(T__68);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(335);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(333);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(308);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(309); match(MultOp);
						setState(310); expression(13);
						}
						break;
					case 2:
						{
						_localctx = new AddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(311);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(312); addOp();
						setState(313); expression(12);
						}
						break;
					case 3:
						{
						_localctx = new CompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(316); compOp();
						setState(317); expression(11);
						}
						break;
					case 4:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(319);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(320); match(T__3);
						setState(321); expression(10);
						}
						break;
					case 5:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(323); match(T__8);
						setState(324); expression(9);
						}
						break;
					case 6:
						{
						_localctx = new XorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(325);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(326); match(T__9);
						setState(327); expression(8);
						}
						break;
					case 7:
						{
						_localctx = new ImpliesContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(329); match(T__55);
						setState(330); expression(7);
						}
						break;
					case 8:
						{
						_localctx = new NavContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(331);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(332); navigationSegment();
						}
						break;
					}
					} 
				}
				setState(337);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BindingContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitBinding(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338); match(Ident);
			setState(341);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(339); match(T__15);
				setState(340); typeLiteral();
				}
			}

			setState(343); match(T__60);
			setState(344); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitAddOp(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_la = _input.LA(1);
			if ( !(_la==T__38 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitCompOp(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__66) | (1L << T__60) | (1L << T__47) | (1L << T__45) | (1L << T__40) | (1L << T__24) | (1L << T__12) | (1L << T__10))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NavigationSegmentContext extends ParserRuleContext {
		public NavigationSegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_navigationSegment; }
	 
		public NavigationSegmentContext() { }
		public void copyFrom(NavigationSegmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallOrApplyContext extends NavigationSegmentContext {
		public CallExpContext callExp() {
			return getRuleContext(CallExpContext.class,0);
		}
		public CallOrApplyContext(NavigationSegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterCallOrApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitCallOrApply(this);
		}
	}
	public static class CollectionCallContext extends NavigationSegmentContext {
		public CallExpContext callExp() {
			return getRuleContext(CallExpContext.class,0);
		}
		public CollectionCallContext(NavigationSegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterCollectionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitCollectionCall(this);
		}
	}
	public static class FeatureContext extends NavigationSegmentContext {
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public FeatureContext(NavigationSegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitFeature(this);
		}
	}

	public final NavigationSegmentContext navigationSegment() throws RecognitionException {
		NavigationSegmentContext _localctx = new NavigationSegmentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_navigationSegment);
		try {
			setState(356);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new FeatureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(350); match(T__19);
				setState(351); match(Ident);
				}
				break;
			case 2:
				_localctx = new CallOrApplyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(352); match(T__19);
				setState(353); callExp();
				}
				break;
			case 3:
				_localctx = new CollectionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(354); match(T__17);
				setState(355); callExp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallExpContext extends ParserRuleContext {
		public CallExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExp; }
	 
		public CallExpContext() { }
		public void copyFrom(CallExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ServiceCallContext extends CallExpContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public ServiceCallContext(CallExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterServiceCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitServiceCall(this);
		}
	}
	public static class IterationCallContext extends CallExpContext {
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public CollectionIteratorContext collectionIterator() {
			return getRuleContext(CollectionIteratorContext.class,0);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public IterationCallContext(CallExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterIterationCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitIterationCall(this);
		}
	}

	public final CallExpContext callExp() throws RecognitionException {
		CallExpContext _localctx = new CallExpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_callExp);
		try {
			setState(369);
			switch (_input.LA(1)) {
			case T__61:
			case T__53:
			case T__48:
			case T__44:
			case T__29:
			case T__23:
			case T__22:
			case T__21:
			case T__20:
			case T__11:
				_localctx = new IterationCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(358); collectionIterator();
				setState(359); match(T__54);
				setState(360); variableDefinition();
				setState(361); lambdaExpression();
				setState(362); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ServiceCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(364); match(Ident);
				setState(365); match(T__54);
				setState(366); expressionSequence();
				setState(367); match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitLambdaExpression(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionIteratorContext extends ParserRuleContext {
		public CollectionIteratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionIterator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterCollectionIterator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitCollectionIterator(this);
		}
	}

	public final CollectionIteratorContext collectionIterator() throws RecognitionException {
		CollectionIteratorContext _localctx = new CollectionIteratorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_collectionIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__61) | (1L << T__53) | (1L << T__48) | (1L << T__44) | (1L << T__29) | (1L << T__23) | (1L << T__22) | (1L << T__21) | (1L << T__20) | (1L << T__11))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionSequenceContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterExpressionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitExpressionSequence(this);
		}
	}

	public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
		ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expressionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__64) | (1L << T__58) | (1L << T__57) | (1L << T__54) | (1L << T__51) | (1L << T__50) | (1L << T__49) | (1L << T__46) | (1L << T__42) | (1L << T__39) | (1L << T__33) | (1L << T__30) | (1L << T__26) | (1L << T__18) | (1L << T__16))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__2 - 67)) | (1L << (T__1 - 67)) | (1L << (Integer - 67)) | (1L << (Real - 67)) | (1L << (String - 67)) | (1L << (ErrorString - 67)) | (1L << (Ident - 67)))) != 0)) {
				{
				setState(375); expression(0);
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__52) {
					{
					{
					setState(376); match(T__52);
					setState(377); expression(0);
					}
					}
					setState(382);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinitionContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitVariableDefinition(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385); match(Ident);
			setState(388);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(386); match(T__15);
				setState(387); typeLiteral();
				}
			}

			setState(390); match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EnumLitContext extends LiteralContext {
		public List<TerminalNode> Ident() { return getTokens(XtdAQLParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(XtdAQLParser.Ident, i);
		}
		public EnumLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterEnumLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitEnumLit(this);
		}
	}
	public static class NullLitContext extends LiteralContext {
		public NullLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterNullLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitNullLit(this);
		}
	}
	public static class TypeLitContext extends LiteralContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public TypeLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterTypeLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitTypeLit(this);
		}
	}
	public static class IntegerLitContext extends LiteralContext {
		public TerminalNode Integer() { return getToken(XtdAQLParser.Integer, 0); }
		public IntegerLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterIntegerLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitIntegerLit(this);
		}
	}
	public static class RealLitContext extends LiteralContext {
		public TerminalNode Real() { return getToken(XtdAQLParser.Real, 0); }
		public RealLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRealLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRealLit(this);
		}
	}
	public static class ErrorEnumLitContext extends LiteralContext {
		public List<TerminalNode> Ident() { return getTokens(XtdAQLParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(XtdAQLParser.Ident, i);
		}
		public ErrorEnumLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterErrorEnumLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitErrorEnumLit(this);
		}
	}
	public static class FalseLitContext extends LiteralContext {
		public FalseLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterFalseLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitFalseLit(this);
		}
	}
	public static class TrueLitContext extends LiteralContext {
		public TrueLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterTrueLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitTrueLit(this);
		}
	}
	public static class ExplicitSetLitContext extends LiteralContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public ExplicitSetLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterExplicitSetLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitExplicitSetLit(this);
		}
	}
	public static class ExplicitSeqLitContext extends LiteralContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public ExplicitSeqLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterExplicitSeqLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitExplicitSeqLit(this);
		}
	}
	public static class ErrorStringLitContext extends LiteralContext {
		public TerminalNode ErrorString() { return getToken(XtdAQLParser.ErrorString, 0); }
		public ErrorStringLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterErrorStringLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitErrorStringLit(this);
		}
	}
	public static class StringLitContext extends LiteralContext {
		public TerminalNode String() { return getToken(XtdAQLParser.String, 0); }
		public StringLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterStringLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitStringLit(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_literal);
		try {
			setState(417);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new StringLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(392); match(String);
				}
				break;
			case 2:
				_localctx = new ErrorStringLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(393); match(ErrorString);
				}
				break;
			case 3:
				_localctx = new IntegerLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(394); match(Integer);
				}
				break;
			case 4:
				_localctx = new RealLitContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(395); match(Real);
				}
				break;
			case 5:
				_localctx = new TrueLitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(396); match(T__33);
				}
				break;
			case 6:
				_localctx = new FalseLitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(397); match(T__51);
				}
				break;
			case 7:
				_localctx = new NullLitContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(398); match(T__57);
				}
				break;
			case 8:
				_localctx = new ExplicitSeqLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(399); match(T__42);
				setState(400); expressionSequence();
				setState(401); match(T__28);
				}
				break;
			case 9:
				_localctx = new ExplicitSetLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(403); match(T__16);
				setState(404); expressionSequence();
				setState(405); match(T__28);
				}
				break;
			case 10:
				_localctx = new EnumLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(407); match(Ident);
				setState(408); match(T__63);
				setState(409); match(Ident);
				setState(410); match(T__63);
				setState(411); match(Ident);
				}
				break;
			case 11:
				_localctx = new ErrorEnumLitContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(412); match(Ident);
				setState(413); match(T__63);
				setState(414); match(Ident);
				setState(415); match(T__15);
				}
				break;
			case 12:
				_localctx = new TypeLitContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(416); typeLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeLiteralContext extends ParserRuleContext {
		public TypeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeLiteral; }
	 
		public TypeLiteralContext() { }
		public void copyFrom(TypeLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassifierSetTypeContext extends TypeLiteralContext {
		public List<ClassifierTypeRuleContext> classifierTypeRule() {
			return getRuleContexts(ClassifierTypeRuleContext.class);
		}
		public ClassifierTypeRuleContext classifierTypeRule(int i) {
			return getRuleContext(ClassifierTypeRuleContext.class,i);
		}
		public ClassifierSetTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterClassifierSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitClassifierSetType(this);
		}
	}
	public static class SetTypeContext extends TypeLiteralContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public SetTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitSetType(this);
		}
	}
	public static class SeqTypeContext extends TypeLiteralContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public SeqTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterSeqType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitSeqType(this);
		}
	}
	public static class BooleanTypeContext extends TypeLiteralContext {
		public BooleanTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitBooleanType(this);
		}
	}
	public static class RealTypeContext extends TypeLiteralContext {
		public RealTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRealType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRealType(this);
		}
	}
	public static class ClsTypeContext extends TypeLiteralContext {
		public ClassifierTypeRuleContext classifierTypeRule() {
			return getRuleContext(ClassifierTypeRuleContext.class,0);
		}
		public ClsTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterClsType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitClsType(this);
		}
	}
	public static class StrTypeContext extends TypeLiteralContext {
		public StrTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterStrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitStrType(this);
		}
	}
	public static class IntTypeContext extends TypeLiteralContext {
		public IntTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitIntType(this);
		}
	}

	public final TypeLiteralContext typeLiteral() throws RecognitionException {
		TypeLiteralContext _localctx = new TypeLiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_typeLiteral);
		int _la;
		try {
			setState(443);
			switch (_input.LA(1)) {
			case T__46:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(419); match(T__46);
				}
				break;
			case T__30:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(420); match(T__30);
				}
				break;
			case T__49:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(421); match(T__49);
				}
				break;
			case T__18:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(422); match(T__18);
				}
				break;
			case T__50:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(423); match(T__50);
				setState(424); typeLiteral();
				setState(425); match(T__4);
				}
				break;
			case T__58:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(427); match(T__58);
				setState(428); typeLiteral();
				setState(429); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ClsTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(431); classifierTypeRule();
				}
				break;
			case T__64:
				_localctx = new ClassifierSetTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(432); match(T__64);
				setState(433); classifierTypeRule();
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(434); match(T__13);
					setState(435); classifierTypeRule();
					}
					}
					setState(440);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(441); match(T__28);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassifierTypeRuleContext extends ParserRuleContext {
		public ClassifierTypeRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classifierTypeRule; }
	 
		public ClassifierTypeRuleContext() { }
		public void copyFrom(ClassifierTypeRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassifierTypeContext extends ClassifierTypeRuleContext {
		public List<TerminalNode> Ident() { return getTokens(XtdAQLParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(XtdAQLParser.Ident, i);
		}
		public ClassifierTypeContext(ClassifierTypeRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterClassifierType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitClassifierType(this);
		}
	}
	public static class ErrorClassifierTypeContext extends ClassifierTypeRuleContext {
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public ErrorClassifierTypeContext(ClassifierTypeRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterErrorClassifierType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitErrorClassifierType(this);
		}
	}

	public final ClassifierTypeRuleContext classifierTypeRule() throws RecognitionException {
		ClassifierTypeRuleContext _localctx = new ClassifierTypeRuleContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_classifierTypeRule);
		try {
			setState(450);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new ClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(445); match(Ident);
				setState(446); match(T__63);
				setState(447); match(Ident);
				}
				break;
			case 2:
				_localctx = new ErrorClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(448); match(Ident);
				setState(449); match(T__15);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 12);
		case 1: return precpred(_ctx, 11);
		case 2: return precpred(_ctx, 10);
		case 3: return precpred(_ctx, 9);
		case 4: return precpred(_ctx, 8);
		case 5: return precpred(_ctx, 7);
		case 6: return precpred(_ctx, 6);
		case 7: return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Q\u01c7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\7\2M\n\2\f\2\16\2P\13\2\3\2\7"+
		"\2S\n\2\f\2\16\2V\13\2\3\2\7\2Y\n\2\f\2\16\2\\\13\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\7\4h\n\4\f\4\16\4k\13\4\3\4\3\4\3\5\3\5\5\5q\n"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6z\n\6\f\6\16\6}\13\6\5\6\177\n\6\3\6"+
		"\3\6\7\6\u0083\n\6\f\6\16\6\u0086\13\6\3\6\7\6\u0089\n\6\f\6\16\6\u008c"+
		"\13\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u0094\n\7\f\7\16\7\u0097\13\7\3\7\7"+
		"\7\u009a\n\7\f\7\16\7\u009d\13\7\3\7\3\7\3\b\7\b\u00a2\n\b\f\b\16\b\u00a5"+
		"\13\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ac\n\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\7\n\u00b7\n\n\f\n\16\n\u00ba\13\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\5\f\u00c3\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00cd\n\r\3\16\3"+
		"\16\3\16\3\16\5\16\u00d3\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00ea\n\21\3\22\3\22\3\22\7\22\u00ef\n\22\f\22\16\22\u00f2\13\22\5\22"+
		"\u00f4\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00ff\n"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\5\26\u010c"+
		"\n\26\3\27\3\27\3\27\7\27\u0111\n\27\f\27\16\27\u0114\13\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u011f\n\30\f\30\16\30\u0122\13"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\5\30\u0135\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\7\30\u0150\n\30\f\30\16\30\u0153\13\30\3\31\3\31"+
		"\3\31\5\31\u0158\n\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u0167\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u0174\n\35\3\36\3\36\3\37\3\37\3 \3 \3 \7 \u017d"+
		"\n \f \16 \u0180\13 \5 \u0182\n \3!\3!\3!\5!\u0187\n!\3!\3!\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\5\"\u01a4\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\7#\u01b7\n#\f#\16#\u01ba\13#\3#\3#\5#\u01be\n#\3$\3$"+
		"\3$\3$\3$\5$\u01c5\n$\3$\2\3.%\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDF\2\6\4\2\17\17##\4\2!!FF\n\2\5\5\13\13\30"+
		"\30\32\32\37\37//;;==\t\2\n\n\22\22\27\27\33\33**\60\63<<\u01e8\2H\3\2"+
		"\2\2\4]\3\2\2\2\6c\3\2\2\2\bp\3\2\2\2\nr\3\2\2\2\f\u008f\3\2\2\2\16\u00a3"+
		"\3\2\2\2\20\u00b0\3\2\2\2\22\u00b3\3\2\2\2\24\u00bb\3\2\2\2\26\u00be\3"+
		"\2\2\2\30\u00cc\3\2\2\2\32\u00ce\3\2\2\2\34\u00d6\3\2\2\2\36\u00db\3\2"+
		"\2\2 \u00e9\3\2\2\2\"\u00eb\3\2\2\2$\u00f7\3\2\2\2&\u0100\3\2\2\2(\u0106"+
		"\3\2\2\2*\u010b\3\2\2\2,\u010d\3\2\2\2.\u0134\3\2\2\2\60\u0154\3\2\2\2"+
		"\62\u015c\3\2\2\2\64\u015e\3\2\2\2\66\u0166\3\2\2\28\u0173\3\2\2\2:\u0175"+
		"\3\2\2\2<\u0177\3\2\2\2>\u0181\3\2\2\2@\u0183\3\2\2\2B\u01a3\3\2\2\2D"+
		"\u01bd\3\2\2\2F\u01c4\3\2\2\2HI\7%\2\2IJ\5,\27\2JN\7(\2\2KM\5\4\3\2LK"+
		"\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OT\3\2\2\2PN\3\2\2\2QS\5\6\4\2R"+
		"Q\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UZ\3\2\2\2VT\3\2\2\2WY\5\b\5\2"+
		"XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\3\3\2\2\2\\Z\3\2\2\2]^\7G\2"+
		"\2^_\5,\27\2_`\7$\2\2`a\7Q\2\2ab\7(\2\2b\5\3\2\2\2cd\7\4\2\2di\7Q\2\2"+
		"ef\7\64\2\2fh\7Q\2\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2"+
		"ki\3\2\2\2lm\7(\2\2m\7\3\2\2\2nq\5\n\6\2oq\5\f\7\2pn\3\2\2\2po\3\2\2\2"+
		"q\t\3\2\2\2rs\7@\2\2st\7\'\2\2t~\5,\27\2uv\7,\2\2v{\5,\27\2wx\7\23\2\2"+
		"xz\5,\27\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}{\3\2"+
		"\2\2~u\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0084\7\7\2\2\u0081"+
		"\u0083\5\26\f\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3"+
		"\2\2\2\u0084\u0085\3\2\2\2\u0085\u008a\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u0089\5\16\b\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3"+
		"\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008e\7+\2\2\u008e\13\3\2\2\2\u008f\u0090\7\'\2\2\u0090\u0091\7Q\2\2"+
		"\u0091\u0095\7\7\2\2\u0092\u0094\5\26\f\2\u0093\u0092\3\2\2\2\u0094\u0097"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009b\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u009a\5\16\b\2\u0099\u0098\3\2\2\2\u009a\u009d\3"+
		"\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009e\u009f\7+\2\2\u009f\r\3\2\2\2\u00a0\u00a2\5\20\t\2"+
		"\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4"+
		"\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\t\2\2\2\u00a7"+
		"\u00a8\5*\26\2\u00a8\u00a9\7Q\2\2\u00a9\u00ab\7\21\2\2\u00aa\u00ac\5\22"+
		"\n\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ae\7C\2\2\u00ae\u00af\5\"\22\2\u00af\17\3\2\2\2\u00b0\u00b1\7\36\2"+
		"\2\u00b1\u00b2\7Q\2\2\u00b2\21\3\2\2\2\u00b3\u00b8\5\24\13\2\u00b4\u00b5"+
		"\7\23\2\2\u00b5\u00b7\5\24\13\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2"+
		"\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\23\3\2\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00bb\u00bc\5*\26\2\u00bc\u00bd\7Q\2\2\u00bd\25\3\2\2\2\u00be"+
		"\u00bf\5*\26\2\u00bf\u00c2\7Q\2\2\u00c0\u00c1\7.\2\2\u00c1\u00c3\5.\30"+
		"\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5"+
		"\7(\2\2\u00c5\27\3\2\2\2\u00c6\u00cd\5\32\16\2\u00c7\u00cd\5\34\17\2\u00c8"+
		"\u00cd\5\36\20\2\u00c9\u00cd\5&\24\2\u00ca\u00cd\5$\23\2\u00cb\u00cd\5"+
		"(\25\2\u00cc\u00c6\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cc"+
		"\u00c9\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\31\3\2\2"+
		"\2\u00ce\u00cf\5*\26\2\u00cf\u00d2\7Q\2\2\u00d0\u00d1\7.\2\2\u00d1\u00d3"+
		"\5.\30\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\7(\2\2\u00d5\33\3\2\2\2\u00d6\u00d7\5.\30\2\u00d7\u00d8\7.\2\2"+
		"\u00d8\u00d9\5.\30\2\u00d9\u00da\7(\2\2\u00da\35\3\2\2\2\u00db\u00dc\7"+
		"\f\2\2\u00dc\u00dd\7\21\2\2\u00dd\u00de\7Q\2\2\u00de\u00df\7B\2\2\u00df"+
		"\u00e0\5 \21\2\u00e0\u00e1\7C\2\2\u00e1\u00e2\5\"\22\2\u00e2\37\3\2\2"+
		"\2\u00e3\u00e4\79\2\2\u00e4\u00e5\7M\2\2\u00e5\u00e6\7\t\2\2\u00e6\u00e7"+
		"\7M\2\2\u00e7\u00ea\7\34\2\2\u00e8\u00ea\5.\30\2\u00e9\u00e3\3\2\2\2\u00e9"+
		"\u00e8\3\2\2\2\u00ea!\3\2\2\2\u00eb\u00f3\7\7\2\2\u00ec\u00f0\5\30\r\2"+
		"\u00ed\u00ef\5\30\r\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00ec\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\7+"+
		"\2\2\u00f6#\3\2\2\2\u00f7\u00f8\7-\2\2\u00f8\u00f9\7\21\2\2\u00f9\u00fa"+
		"\5.\30\2\u00fa\u00fb\7C\2\2\u00fb\u00fe\5\"\22\2\u00fc\u00fd\7A\2\2\u00fd"+
		"\u00ff\5\"\22\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff%\3\2\2\2"+
		"\u0100\u0101\7\6\2\2\u0101\u0102\7\21\2\2\u0102\u0103\5.\30\2\u0103\u0104"+
		"\7C\2\2\u0104\u0105\5\"\22\2\u0105\'\3\2\2\2\u0106\u0107\5.\30\2\u0107"+
		"\u0108\7(\2\2\u0108)\3\2\2\2\u0109\u010c\5,\27\2\u010a\u010c\5D#\2\u010b"+
		"\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c+\3\2\2\2\u010d\u0112\7Q\2\2\u010e"+
		"\u010f\7\64\2\2\u010f\u0111\7Q\2\2\u0110\u010e\3\2\2\2\u0111\u0114\3\2"+
		"\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113-\3\2\2\2\u0114\u0112"+
		"\3\2\2\2\u0115\u0116\b\30\1\2\u0116\u0117\7E\2\2\u0117\u0135\5.\30\20"+
		"\u0118\u0119\7F\2\2\u0119\u0135\5.\30\17\u011a\u011b\7 \2\2\u011b\u0120"+
		"\5\60\31\2\u011c\u011d\7\23\2\2\u011d\u011f\5\60\31\2\u011e\u011c\3\2"+
		"\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0123\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\7B\2\2\u0124\u0125\5.\30"+
		"\3\u0125\u0135\3\2\2\2\u0126\u0135\7Q\2\2\u0127\u0135\5B\"\2\u0128\u0129"+
		"\7\21\2\2\u0129\u012a\5.\30\2\u012a\u012b\7C\2\2\u012b\u0135\3\2\2\2\u012c"+
		"\u012d\7-\2\2\u012d\u012e\5.\30\2\u012e\u012f\7\"\2\2\u012f\u0130\5.\30"+
		"\2\u0130\u0131\7A\2\2\u0131\u0132\5.\30\2\u0132\u0133\7\3\2\2\u0133\u0135"+
		"\3\2\2\2\u0134\u0115\3\2\2\2\u0134\u0118\3\2\2\2\u0134\u011a\3\2\2\2\u0134"+
		"\u0126\3\2\2\2\u0134\u0127\3\2\2\2\u0134\u0128\3\2\2\2\u0134\u012c\3\2"+
		"\2\2\u0135\u0151\3\2\2\2\u0136\u0137\f\16\2\2\u0137\u0138\7L\2\2\u0138"+
		"\u0150\5.\30\17\u0139\u013a\f\r\2\2\u013a\u013b\5\62\32\2\u013b\u013c"+
		"\5.\30\16\u013c\u0150\3\2\2\2\u013d\u013e\f\f\2\2\u013e\u013f\5\64\33"+
		"\2\u013f\u0140\5.\30\r\u0140\u0150\3\2\2\2\u0141\u0142\f\13\2\2\u0142"+
		"\u0143\7D\2\2\u0143\u0150\5.\30\f\u0144\u0145\f\n\2\2\u0145\u0146\7?\2"+
		"\2\u0146\u0150\5.\30\13\u0147\u0148\f\t\2\2\u0148\u0149\7>\2\2\u0149\u0150"+
		"\5.\30\n\u014a\u014b\f\b\2\2\u014b\u014c\7\20\2\2\u014c\u0150\5.\30\t"+
		"\u014d\u014e\f\21\2\2\u014e\u0150\5\66\34\2\u014f\u0136\3\2\2\2\u014f"+
		"\u0139\3\2\2\2\u014f\u013d\3\2\2\2\u014f\u0141\3\2\2\2\u014f\u0144\3\2"+
		"\2\2\u014f\u0147\3\2\2\2\u014f\u014a\3\2\2\2\u014f\u014d\3\2\2\2\u0150"+
		"\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152/\3\2\2\2"+
		"\u0153\u0151\3\2\2\2\u0154\u0157\7Q\2\2\u0155\u0156\78\2\2\u0156\u0158"+
		"\5D#\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u015a\7\13\2\2\u015a\u015b\5.\30\2\u015b\61\3\2\2\2\u015c\u015d\t\3\2"+
		"\2\u015d\63\3\2\2\2\u015e\u015f\t\4\2\2\u015f\65\3\2\2\2\u0160\u0161\7"+
		"\64\2\2\u0161\u0167\7Q\2\2\u0162\u0163\7\64\2\2\u0163\u0167\58\35\2\u0164"+
		"\u0165\7\66\2\2\u0165\u0167\58\35\2\u0166\u0160\3\2\2\2\u0166\u0162\3"+
		"\2\2\2\u0166\u0164\3\2\2\2\u0167\67\3\2\2\2\u0168\u0169\5<\37\2\u0169"+
		"\u016a\7\21\2\2\u016a\u016b\5@!\2\u016b\u016c\5:\36\2\u016c\u016d\7C\2"+
		"\2\u016d\u0174\3\2\2\2\u016e\u016f\7Q\2\2\u016f\u0170\7\21\2\2\u0170\u0171"+
		"\5> \2\u0171\u0172\7C\2\2\u0172\u0174\3\2\2\2\u0173\u0168\3\2\2\2\u0173"+
		"\u016e\3\2\2\2\u01749\3\2\2\2\u0175\u0176\5.\30\2\u0176;\3\2\2\2\u0177"+
		"\u0178\t\5\2\2\u0178=\3\2\2\2\u0179\u017e\5.\30\2\u017a\u017b\7\23\2\2"+
		"\u017b\u017d\5.\30\2\u017c\u017a\3\2\2\2\u017d\u0180\3\2\2\2\u017e\u017c"+
		"\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0181"+
		"\u0179\3\2\2\2\u0181\u0182\3\2\2\2\u0182?\3\2\2\2\u0183\u0186\7Q\2\2\u0184"+
		"\u0185\78\2\2\u0185\u0187\5D#\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2"+
		"\2\u0187\u0188\3\2\2\2\u0188\u0189\7:\2\2\u0189A\3\2\2\2\u018a\u01a4\7"+
		"O\2\2\u018b\u01a4\7P\2\2\u018c\u01a4\7M\2\2\u018d\u01a4\7N\2\2\u018e\u01a4"+
		"\7&\2\2\u018f\u01a4\7\24\2\2\u0190\u01a4\7\16\2\2\u0191\u0192\7\35\2\2"+
		"\u0192\u0193\5> \2\u0193\u0194\7+\2\2\u0194\u01a4\3\2\2\2\u0195\u0196"+
		"\7\67\2\2\u0196\u0197\5> \2\u0197\u0198\7+\2\2\u0198\u01a4\3\2\2\2\u0199"+
		"\u019a\7Q\2\2\u019a\u019b\7\b\2\2\u019b\u019c\7Q\2\2\u019c\u019d\7\b\2"+
		"\2\u019d\u01a4\7Q\2\2\u019e\u019f\7Q\2\2\u019f\u01a0\7\b\2\2\u01a0\u01a1"+
		"\7Q\2\2\u01a1\u01a4\78\2\2\u01a2\u01a4\5D#\2\u01a3\u018a\3\2\2\2\u01a3"+
		"\u018b\3\2\2\2\u01a3\u018c\3\2\2\2\u01a3\u018d\3\2\2\2\u01a3\u018e\3\2"+
		"\2\2\u01a3\u018f\3\2\2\2\u01a3\u0190\3\2\2\2\u01a3\u0191\3\2\2\2\u01a3"+
		"\u0195\3\2\2\2\u01a3\u0199\3\2\2\2\u01a3\u019e\3\2\2\2\u01a3\u01a2\3\2"+
		"\2\2\u01a4C\3\2\2\2\u01a5\u01be\7\31\2\2\u01a6\u01be\7)\2\2\u01a7\u01be"+
		"\7\26\2\2\u01a8\u01be\7\65\2\2\u01a9\u01aa\7\25\2\2\u01aa\u01ab\5D#\2"+
		"\u01ab\u01ac\7C\2\2\u01ac\u01be\3\2\2\2\u01ad\u01ae\7\r\2\2\u01ae\u01af"+
		"\5D#\2\u01af\u01b0\7C\2\2\u01b0\u01be\3\2\2\2\u01b1\u01be\5F$\2\u01b2"+
		"\u01b3\7\7\2\2\u01b3\u01b8\5F$\2\u01b4\u01b5\7:\2\2\u01b5\u01b7\5F$\2"+
		"\u01b6\u01b4\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9"+
		"\3\2\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01bc\7+\2\2\u01bc"+
		"\u01be\3\2\2\2\u01bd\u01a5\3\2\2\2\u01bd\u01a6\3\2\2\2\u01bd\u01a7\3\2"+
		"\2\2\u01bd\u01a8\3\2\2\2\u01bd\u01a9\3\2\2\2\u01bd\u01ad\3\2\2\2\u01bd"+
		"\u01b1\3\2\2\2\u01bd\u01b2\3\2\2\2\u01beE\3\2\2\2\u01bf\u01c0\7Q\2\2\u01c0"+
		"\u01c1\7\b\2\2\u01c1\u01c5\7Q\2\2\u01c2\u01c3\7Q\2\2\u01c3\u01c5\78\2"+
		"\2\u01c4\u01bf\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5G\3\2\2\2\'NTZip{~\u0084"+
		"\u008a\u0095\u009b\u00a3\u00ab\u00b8\u00c2\u00cc\u00d2\u00e9\u00f0\u00f3"+
		"\u00fe\u010b\u0112\u0120\u0134\u014f\u0151\u0157\u0166\u0173\u017e\u0181"+
		"\u0186\u01a3\u01b8\u01bd\u01c4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}