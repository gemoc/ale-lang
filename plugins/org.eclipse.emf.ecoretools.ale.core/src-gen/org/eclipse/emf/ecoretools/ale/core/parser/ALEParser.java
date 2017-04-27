// Generated from ALE.g4 by ANTLR 4.3

/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ALEParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__74=1, T__73=2, T__72=3, T__71=4, T__70=5, T__69=6, T__68=7, T__67=8, 
		T__66=9, T__65=10, T__64=11, T__63=12, T__62=13, T__61=14, T__60=15, T__59=16, 
		T__58=17, T__57=18, T__56=19, T__55=20, T__54=21, T__53=22, T__52=23, 
		T__51=24, T__50=25, T__49=26, T__48=27, T__47=28, T__46=29, T__45=30, 
		T__44=31, T__43=32, T__42=33, T__41=34, T__40=35, T__39=36, T__38=37, 
		T__37=38, T__36=39, T__35=40, T__34=41, T__33=42, T__32=43, T__31=44, 
		T__30=45, T__29=46, T__28=47, T__27=48, T__26=49, T__25=50, T__24=51, 
		T__23=52, T__22=53, T__21=54, T__20=55, T__19=56, T__18=57, T__17=58, 
		T__16=59, T__15=60, T__14=61, T__13=62, T__12=63, T__11=64, T__10=65, 
		T__9=66, T__8=67, T__7=68, T__6=69, T__5=70, T__4=71, T__3=72, T__2=73, 
		T__1=74, T__0=75, COMMENT=76, LINECOMMENT=77, STRING=78, WS=79, MultOp=80, 
		Integer=81, Real=82, String=83, ErrorString=84, Ident=85;
	public static final String[] tokenNames = {
		"<INVALID>", "'endif'", "'default'", "'use'", "'!='", "'while'", "'{'", 
		"'::'", "'..'", "'one'", "'='", "'for'", "'OrderedSet('", "'null'", "'override'", 
		"'implies'", "'('", "'closure'", "','", "'false'", "'Sequence('", "'Real'", 
		"'unique'", "'reject'", "'>='", "'String'", "'<'", "'forAll'", "']'", 
		"'Sequence{'", "'@'", "'<>'", "'let'", "'+'", "'then'", "'def'", "'as'", 
		"'behavior'", "'true'", "'class'", "';'", "'Integer'", "'any'", "'}'", 
		"'extends'", "'if'", "':='", "'<='", "'sortedBy'", "'isUnique'", "'opposite '", 
		"'collect'", "'switch'", "'exists'", "'.'", "'Boolean'", "'->'", "'case'", 
		"'OrderedSet{'", "':'", "'['", "'|'", "'=='", "'select'", "'>'", "'contains'", 
		"'xor'", "'or'", "'open'", "'else'", "'in'", "')'", "'and'", "'not'", 
		"'-'", "'import'", "COMMENT", "LINECOMMENT", "STRING", "WS", "MultOp", 
		"Integer", "Real", "String", "ErrorString", "Ident"
	};
	public static final int
		RULE_rRoot = 0, RULE_rImport = 1, RULE_rService = 2, RULE_rClass = 3, 
		RULE_rOpenClass = 4, RULE_rNewClass = 5, RULE_rOperation = 6, RULE_rTag = 7, 
		RULE_rParameters = 8, RULE_rVariable = 9, RULE_rAttribute = 10, RULE_rCardinality = 11, 
		RULE_rOpposite = 12, RULE_rStatement = 13, RULE_rVarDecl = 14, RULE_rAssign = 15, 
		RULE_rForEach = 16, RULE_rCollection = 17, RULE_rBlock = 18, RULE_rIf = 19, 
		RULE_rWhile = 20, RULE_rExpressionStmt = 21, RULE_rExpression = 22, RULE_rType = 23, 
		RULE_rQualified = 24, RULE_rSwitch = 25, RULE_rCase = 26, RULE_expression = 27, 
		RULE_binding = 28, RULE_addOp = 29, RULE_compOp = 30, RULE_navigationSegment = 31, 
		RULE_callExp = 32, RULE_lambdaExpression = 33, RULE_collectionIterator = 34, 
		RULE_expressionSequence = 35, RULE_variableDefinition = 36, RULE_literal = 37, 
		RULE_typeLiteral = 38, RULE_classifierTypeRule = 39;
	public static final String[] ruleNames = {
		"rRoot", "rImport", "rService", "rClass", "rOpenClass", "rNewClass", "rOperation", 
		"rTag", "rParameters", "rVariable", "rAttribute", "rCardinality", "rOpposite", 
		"rStatement", "rVarDecl", "rAssign", "rForEach", "rCollection", "rBlock", 
		"rIf", "rWhile", "rExpressionStmt", "rExpression", "rType", "rQualified", 
		"rSwitch", "rCase", "expression", "binding", "addOp", "compOp", "navigationSegment", 
		"callExp", "lambdaExpression", "collectionIterator", "expressionSequence", 
		"variableDefinition", "literal", "typeLiteral", "classifierTypeRule"
	};

	@Override
	public String getGrammarFileName() { return "ALE.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ALEParser(TokenStream input) {
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RRootContext rRoot() throws RecognitionException {
		RRootContext _localctx = new RRootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rRoot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(T__38);
			setState(81); rQualified();
			setState(82); match(T__35);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(83); rImport();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__72) {
				{
				{
				setState(89); rService();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36 || _la==T__7) {
				{
				{
				setState(95); rClass();
				}
				}
				setState(100);
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RQualifiedContext rQualified() {
			return getRuleContext(RQualifiedContext.class,0);
		}
		public RImportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rImport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RImportContext rImport() throws RecognitionException {
		RImportContext _localctx = new RImportContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rImport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(T__0);
			setState(102); rQualified();
			setState(103); match(T__39);
			setState(104); match(Ident);
			setState(105); match(T__35);
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
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public RServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rService; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRService(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRService(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RServiceContext rService() throws RecognitionException {
		RServiceContext _localctx = new RServiceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rService);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); match(T__72);
			setState(108); match(Ident);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(109); match(T__21);
				setState(110); match(Ident);
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116); match(T__35);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RClassContext rClass() throws RecognitionException {
		RClassContext _localctx = new RClassContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rClass);
		try {
			setState(120);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(118); rOpenClass();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(119); rNewClass();
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterROpenClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitROpenClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitROpenClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ROpenClassContext rOpenClass() throws RecognitionException {
		ROpenClassContext _localctx = new ROpenClassContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rOpenClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(T__7);
			setState(123); match(T__36);
			setState(124); ((ROpenClassContext)_localctx).name = rQualified();
			setState(134);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(125); match(T__31);
				setState(126); rQualified();
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(127); match(T__57);
					setState(128); rQualified();
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(136); match(T__69);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__69) | (1L << T__63) | (1L << T__55) | (1L << T__54) | (1L << T__53) | (1L << T__50) | (1L << T__34) | (1L << T__25) | (1L << T__20))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__10 - 65)) | (1L << (Integer - 65)) | (1L << (Ident - 65)))) != 0)) {
				{
				{
				setState(137); rAttribute();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__61) | (1L << T__45) | (1L << T__40))) != 0)) {
				{
				{
				setState(143); rOperation();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149); match(T__32);
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRNewClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRNewClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRNewClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RNewClassContext rNewClass() throws RecognitionException {
		RNewClassContext _localctx = new RNewClassContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rNewClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(T__36);
			setState(152); ((RNewClassContext)_localctx).name = match(Ident);
			setState(153); match(T__69);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__69) | (1L << T__63) | (1L << T__55) | (1L << T__54) | (1L << T__53) | (1L << T__50) | (1L << T__34) | (1L << T__25) | (1L << T__20))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__10 - 65)) | (1L << (Integer - 65)) | (1L << (Ident - 65)))) != 0)) {
				{
				{
				setState(154); rAttribute();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__61) | (1L << T__45) | (1L << T__40))) != 0)) {
				{
				{
				setState(160); rOperation();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166); match(T__32);
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterROperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitROperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitROperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ROperationContext rOperation() throws RecognitionException {
		ROperationContext _localctx = new ROperationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__45) {
				{
				{
				setState(168); rTag();
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
			_la = _input.LA(1);
			if ( !(_la==T__61 || _la==T__40) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(175); ((ROperationContext)_localctx).type = rType();
			setState(176); ((ROperationContext)_localctx).name = match(Ident);
			setState(177); match(T__59);
			setState(179);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__69) | (1L << T__63) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__34) | (1L << T__20))) != 0) || _la==Ident) {
				{
				setState(178); rParameters();
				}
			}

			setState(181); match(T__4);
			setState(182); rBlock();
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RTagContext rTag() throws RecognitionException {
		RTagContext _localctx = new RTagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(T__45);
			setState(185); match(Ident);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RParametersContext rParameters() throws RecognitionException {
		RParametersContext _localctx = new RParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); rVariable();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__57) {
				{
				{
				setState(188); match(T__57);
				setState(189); rVariable();
				}
				}
				setState(194);
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RVariableContext rVariable() throws RecognitionException {
		RVariableContext _localctx = new RVariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); ((RVariableContext)_localctx).type = rType();
			setState(196); match(Ident);
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
		public Token modifier;
		public RCardinalityContext bounds;
		public ROppositeContext opposite;
		public RTypeContext type;
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public ROppositeContext rOpposite() {
			return getRuleContext(ROppositeContext.class,0);
		}
		public RCardinalityContext rCardinality() {
			return getRuleContext(RCardinalityContext.class,0);
		}
		public RAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RAttributeContext rAttribute() throws RecognitionException {
		RAttributeContext _localctx = new RAttributeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_la = _input.LA(1);
			if (_la==T__53 || _la==T__10) {
				{
				setState(198);
				((RAttributeContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__53 || _la==T__10) ) {
					((RAttributeContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(202);
			_la = _input.LA(1);
			if (_la==Integer) {
				{
				setState(201); ((RAttributeContext)_localctx).bounds = rCardinality();
				}
			}

			setState(205);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(204); ((RAttributeContext)_localctx).opposite = rOpposite();
				}
			}

			setState(207); ((RAttributeContext)_localctx).type = rType();
			setState(208); match(Ident);
			setState(211);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(209); match(T__29);
				setState(210); rExpression();
				}
			}

			setState(213); match(T__35);
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

	public static class RCardinalityContext extends ParserRuleContext {
		public TerminalNode Integer(int i) {
			return getToken(ALEParser.Integer, i);
		}
		public List<TerminalNode> Integer() { return getTokens(ALEParser.Integer); }
		public TerminalNode MultOp() { return getToken(ALEParser.MultOp, 0); }
		public RCardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rCardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRCardinality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRCardinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RCardinalityContext rCardinality() throws RecognitionException {
		RCardinalityContext _localctx = new RCardinalityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rCardinality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(Integer);
			setState(216); match(T__67);
			setState(217);
			_la = _input.LA(1);
			if ( !(_la==MultOp || _la==Integer) ) {
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

	public static class ROppositeContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public ROppositeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rOpposite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterROpposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitROpposite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitROpposite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ROppositeContext rOpposite() throws RecognitionException {
		ROppositeContext _localctx = new ROppositeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rOpposite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); match(T__25);
			setState(220); match(Ident);
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
		public RExpressionStmtContext rExpressionStmt() {
			return getRuleContext(RExpressionStmtContext.class,0);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RStatementContext rStatement() throws RecognitionException {
		RStatementContext _localctx = new RStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rStatement);
		try {
			setState(228);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222); rVarDecl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223); rAssign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(224); rForEach();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(225); rWhile();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(226); rIf();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(227); rExpressionStmt();
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RVarDeclContext rVarDecl() throws RecognitionException {
		RVarDeclContext _localctx = new RVarDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); ((RVarDeclContext)_localctx).type = rType();
			setState(231); match(Ident);
			setState(234);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(232); match(T__29);
				setState(233); rExpression();
				}
			}

			setState(236); match(T__35);
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
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RAssignContext rAssign() throws RecognitionException {
		RAssignContext _localctx = new RAssignContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_rAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); expression(0);
			setState(239); match(T__29);
			setState(240); rExpression();
			setState(241); match(T__35);
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRForEach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRForEach(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRForEach(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RForEachContext rForEach() throws RecognitionException {
		RForEachContext _localctx = new RForEachContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rForEach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); match(T__64);
			setState(244); match(T__59);
			setState(245); match(Ident);
			setState(246); match(T__5);
			setState(247); rCollection();
			setState(248); match(T__4);
			setState(249); rBlock();
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
			return getToken(ALEParser.Integer, i);
		}
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public List<TerminalNode> Integer() { return getTokens(ALEParser.Integer); }
		public RCollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rCollection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRCollection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRCollection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RCollectionContext rCollection() throws RecognitionException {
		RCollectionContext _localctx = new RCollectionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rCollection);
		try {
			setState(257);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(251); match(T__15);
				setState(252); match(Integer);
				setState(253); match(T__67);
				setState(254); match(Integer);
				setState(255); match(T__47);
				}
				break;
			case T__69:
			case T__63:
			case T__62:
			case T__59:
			case T__56:
			case T__55:
			case T__54:
			case T__50:
			case T__46:
			case T__43:
			case T__37:
			case T__34:
			case T__30:
			case T__23:
			case T__20:
			case T__17:
			case T__2:
			case T__1:
			case Integer:
			case Real:
			case String:
			case ErrorString:
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(256); rExpression();
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RBlockContext rBlock() throws RecognitionException {
		RBlockContext _localctx = new RBlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(T__69);
			setState(267);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__70) | (1L << T__69) | (1L << T__64) | (1L << T__63) | (1L << T__62) | (1L << T__59) | (1L << T__56) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__46) | (1L << T__43) | (1L << T__37) | (1L << T__34) | (1L << T__30) | (1L << T__23) | (1L << T__20) | (1L << T__17))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__2 - 73)) | (1L << (T__1 - 73)) | (1L << (Integer - 73)) | (1L << (Real - 73)) | (1L << (String - 73)) | (1L << (ErrorString - 73)) | (1L << (Ident - 73)))) != 0)) {
				{
				setState(260); rStatement();
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__70) | (1L << T__69) | (1L << T__64) | (1L << T__63) | (1L << T__62) | (1L << T__59) | (1L << T__56) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__46) | (1L << T__43) | (1L << T__37) | (1L << T__34) | (1L << T__30) | (1L << T__23) | (1L << T__20) | (1L << T__17))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__2 - 73)) | (1L << (T__1 - 73)) | (1L << (Integer - 73)) | (1L << (Real - 73)) | (1L << (String - 73)) | (1L << (ErrorString - 73)) | (1L << (Ident - 73)))) != 0)) {
					{
					{
					setState(261); rStatement();
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(269); match(T__32);
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
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RIfContext rIf() throws RecognitionException {
		RIfContext _localctx = new RIfContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_rIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271); match(T__30);
			setState(272); match(T__59);
			setState(273); rExpression();
			setState(274); match(T__4);
			setState(275); rBlock();
			setState(278);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(276); match(T__6);
				setState(277); rBlock();
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
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RWhileContext rWhile() throws RecognitionException {
		RWhileContext _localctx = new RWhileContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_rWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280); match(T__70);
			setState(281); match(T__59);
			setState(282); rExpression();
			setState(283); match(T__4);
			setState(284); rBlock();
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

	public static class RExpressionStmtContext extends ParserRuleContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RExpressionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rExpressionStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRExpressionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRExpressionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRExpressionStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RExpressionStmtContext rExpressionStmt() throws RecognitionException {
		RExpressionStmtContext _localctx = new RExpressionStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_rExpressionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); rExpression();
			setState(287); match(T__35);
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
		public RSwitchContext rSwitch() {
			return getRuleContext(RSwitchContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RExpressionContext rExpression() throws RecognitionException {
		RExpressionContext _localctx = new RExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_rExpression);
		try {
			setState(291);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(289); rSwitch();
				}
				break;
			case T__69:
			case T__63:
			case T__62:
			case T__59:
			case T__56:
			case T__55:
			case T__54:
			case T__50:
			case T__46:
			case T__43:
			case T__37:
			case T__34:
			case T__30:
			case T__20:
			case T__17:
			case T__2:
			case T__1:
			case Integer:
			case Real:
			case String:
			case ErrorString:
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(290); expression(0);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RTypeContext rType() throws RecognitionException {
		RTypeContext _localctx = new RTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_rType);
		try {
			setState(295);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(293); rQualified();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294); typeLiteral();
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
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public RQualifiedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rQualified; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRQualified(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRQualified(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRQualified(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RQualifiedContext rQualified() throws RecognitionException {
		RQualifiedContext _localctx = new RQualifiedContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_rQualified);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297); match(Ident);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(298); match(T__21);
				setState(299); match(Ident);
				}
				}
				setState(304);
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

	public static class RSwitchContext extends ParserRuleContext {
		public Token paramName;
		public RExpressionContext paramVal;
		public RCaseContext rCase;
		public List<RCaseContext> cases = new ArrayList<RCaseContext>();
		public RExpressionContext other;
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public RCaseContext rCase(int i) {
			return getRuleContext(RCaseContext.class,i);
		}
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public List<RCaseContext> rCase() {
			return getRuleContexts(RCaseContext.class);
		}
		public RSwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rSwitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRSwitch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRSwitch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RSwitchContext rSwitch() throws RecognitionException {
		RSwitchContext _localctx = new RSwitchContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_rSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); match(T__23);
			setState(306); match(T__59);
			setState(309);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(307); ((RSwitchContext)_localctx).paramName = match(Ident);
				setState(308); match(T__16);
				}
				break;
			}
			setState(311); ((RSwitchContext)_localctx).paramVal = rExpression();
			setState(312); match(T__4);
			setState(313); match(T__69);
			setState(315); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(314); ((RSwitchContext)_localctx).rCase = rCase();
				((RSwitchContext)_localctx).cases.add(((RSwitchContext)_localctx).rCase);
				}
				}
				setState(317); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__69) | (1L << T__63) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__34) | (1L << T__20) | (1L << T__18) | (1L << T__16))) != 0) || _la==Ident );
			setState(319); match(T__73);
			setState(320); match(T__16);
			setState(321); ((RSwitchContext)_localctx).other = rExpression();
			setState(322); match(T__32);
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

	public static class RCaseContext extends ParserRuleContext {
		public RTypeContext guard;
		public RExpressionContext match;
		public RExpressionContext value;
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public RTypeContext rType() {
			return getRuleContext(RTypeContext.class,0);
		}
		public RCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RCaseContext rCase() throws RecognitionException {
		RCaseContext _localctx = new RCaseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_rCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__69) | (1L << T__63) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__34) | (1L << T__20))) != 0) || _la==Ident) {
				{
				setState(324); ((RCaseContext)_localctx).guard = rType();
				}
			}

			setState(329);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(327); match(T__18);
				setState(328); ((RCaseContext)_localctx).match = rExpression();
				}
			}

			setState(331); match(T__16);
			setState(332); ((RCaseContext)_localctx).value = rExpression();
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public VarRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterNav(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitNav(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitNav(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterLetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitLetExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitLetExpr(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MinContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitMin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitMin(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitImplies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitImplies(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MultOp() { return getToken(ALEParser.MultOp, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MultContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitXor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitXor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(335); match(T__2);
				setState(336); expression(14);
				}
				break;

			case 2:
				{
				_localctx = new MinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(337); match(T__1);
				setState(338); expression(13);
				}
				break;

			case 3:
				{
				_localctx = new LetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(339); match(T__43);
				setState(340); binding();
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(341); match(T__57);
					setState(342); binding();
					}
					}
					setState(347);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(348); match(T__5);
				setState(349); expression(1);
				}
				break;

			case 4:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(351); match(Ident);
				}
				break;

			case 5:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(352); literal();
				}
				break;

			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(353); match(T__59);
				setState(354); expression(0);
				setState(355); match(T__4);
				}
				break;

			case 7:
				{
				_localctx = new ConditionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(357); match(T__30);
				setState(358); expression(0);
				setState(359); match(T__41);
				setState(360); expression(0);
				setState(361); match(T__6);
				setState(362); expression(0);
				setState(363); match(T__74);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(394);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(392);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(367);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(368); match(MultOp);
						setState(369); expression(13);
						}
						break;

					case 2:
						{
						_localctx = new AddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(370);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(371); addOp();
						setState(372); expression(12);
						}
						break;

					case 3:
						{
						_localctx = new CompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(374);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(375); compOp();
						setState(376); expression(11);
						}
						break;

					case 4:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(378);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(379); match(T__3);
						setState(380); expression(10);
						}
						break;

					case 5:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(381);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(382); match(T__8);
						setState(383); expression(9);
						}
						break;

					case 6:
						{
						_localctx = new XorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(384);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(385); match(T__9);
						setState(386); expression(8);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(387);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(388); match(T__60);
						setState(389); expression(7);
						}
						break;

					case 8:
						{
						_localctx = new NavContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(390);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(391); navigationSegment();
						}
						break;
					}
					} 
				}
				setState(396);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitBinding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397); match(Ident);
			setState(400);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(398); match(T__16);
				setState(399); typeLiteral();
				}
			}

			setState(402); match(T__65);
			setState(403); expression(0);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitAddOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitAddOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			_la = _input.LA(1);
			if ( !(_la==T__42 || _la==T__1) ) {
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			_la = _input.LA(1);
			if ( !(((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (T__71 - 4)) | (1L << (T__65 - 4)) | (1L << (T__51 - 4)) | (1L << (T__49 - 4)) | (1L << (T__44 - 4)) | (1L << (T__28 - 4)) | (1L << (T__13 - 4)) | (1L << (T__11 - 4)))) != 0)) ) {
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterCallOrApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitCallOrApply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitCallOrApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CollectionCallContext extends NavigationSegmentContext {
		public CallExpContext callExp() {
			return getRuleContext(CallExpContext.class,0);
		}
		public CollectionCallContext(NavigationSegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterCollectionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitCollectionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitCollectionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FeatureContext extends NavigationSegmentContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public FeatureContext(NavigationSegmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitFeature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NavigationSegmentContext navigationSegment() throws RecognitionException {
		NavigationSegmentContext _localctx = new NavigationSegmentContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_navigationSegment);
		try {
			setState(415);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new FeatureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(409); match(T__21);
				setState(410); match(Ident);
				}
				break;

			case 2:
				_localctx = new CallOrApplyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(411); match(T__21);
				setState(412); callExp();
				}
				break;

			case 3:
				_localctx = new CollectionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(413); match(T__19);
				setState(414); callExp();
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public ServiceCallContext(CallExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterServiceCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitServiceCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitServiceCall(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterIterationCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitIterationCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitIterationCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallExpContext callExp() throws RecognitionException {
		CallExpContext _localctx = new CallExpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_callExp);
		try {
			setState(428);
			switch (_input.LA(1)) {
			case T__66:
			case T__58:
			case T__52:
			case T__48:
			case T__33:
			case T__27:
			case T__26:
			case T__24:
			case T__22:
			case T__12:
				_localctx = new IterationCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(417); collectionIterator();
				setState(418); match(T__59);
				setState(419); variableDefinition();
				setState(420); lambdaExpression();
				setState(421); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ServiceCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(423); match(Ident);
				setState(424); match(T__59);
				setState(425); expressionSequence();
				setState(426); match(T__4);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitLambdaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitLambdaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430); expression(0);
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterCollectionIterator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitCollectionIterator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitCollectionIterator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionIteratorContext collectionIterator() throws RecognitionException {
		CollectionIteratorContext _localctx = new CollectionIteratorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_collectionIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__66) | (1L << T__58) | (1L << T__52) | (1L << T__48) | (1L << T__33) | (1L << T__27) | (1L << T__26) | (1L << T__24) | (1L << T__22) | (1L << T__12))) != 0)) ) {
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterExpressionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitExpressionSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitExpressionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
		ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_expressionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__69) | (1L << T__63) | (1L << T__62) | (1L << T__59) | (1L << T__56) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__46) | (1L << T__43) | (1L << T__37) | (1L << T__34) | (1L << T__30) | (1L << T__20) | (1L << T__17))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__2 - 73)) | (1L << (T__1 - 73)) | (1L << (Integer - 73)) | (1L << (Real - 73)) | (1L << (String - 73)) | (1L << (ErrorString - 73)) | (1L << (Ident - 73)))) != 0)) {
				{
				setState(434); expression(0);
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(435); match(T__57);
					setState(436); expression(0);
					}
					}
					setState(441);
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
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444); match(Ident);
			setState(447);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(445); match(T__16);
				setState(446); typeLiteral();
				}
			}

			setState(449); match(T__14);
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
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public EnumLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterEnumLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitEnumLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitEnumLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLitContext extends LiteralContext {
		public NullLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterNullLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitNullLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitNullLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeLitContext extends LiteralContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public TypeLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterTypeLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitTypeLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitTypeLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLitContext extends LiteralContext {
		public TerminalNode Integer() { return getToken(ALEParser.Integer, 0); }
		public IntegerLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterIntegerLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitIntegerLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitIntegerLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealLitContext extends LiteralContext {
		public TerminalNode Real() { return getToken(ALEParser.Real, 0); }
		public RealLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRealLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRealLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRealLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorEnumLitContext extends LiteralContext {
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public ErrorEnumLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterErrorEnumLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitErrorEnumLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitErrorEnumLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseLitContext extends LiteralContext {
		public FalseLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterFalseLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitFalseLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitFalseLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueLitContext extends LiteralContext {
		public TrueLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterTrueLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitTrueLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitTrueLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExplicitSetLitContext extends LiteralContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public ExplicitSetLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterExplicitSetLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitExplicitSetLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitExplicitSetLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExplicitSeqLitContext extends LiteralContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public ExplicitSeqLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterExplicitSeqLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitExplicitSeqLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitExplicitSeqLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorStringLitContext extends LiteralContext {
		public TerminalNode ErrorString() { return getToken(ALEParser.ErrorString, 0); }
		public ErrorStringLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterErrorStringLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitErrorStringLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitErrorStringLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLitContext extends LiteralContext {
		public TerminalNode String() { return getToken(ALEParser.String, 0); }
		public StringLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterStringLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitStringLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitStringLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_literal);
		try {
			setState(476);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new StringLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(451); match(String);
				}
				break;

			case 2:
				_localctx = new ErrorStringLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(452); match(ErrorString);
				}
				break;

			case 3:
				_localctx = new IntegerLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(453); match(Integer);
				}
				break;

			case 4:
				_localctx = new RealLitContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(454); match(Real);
				}
				break;

			case 5:
				_localctx = new TrueLitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(455); match(T__37);
				}
				break;

			case 6:
				_localctx = new FalseLitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(456); match(T__56);
				}
				break;

			case 7:
				_localctx = new NullLitContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(457); match(T__62);
				}
				break;

			case 8:
				_localctx = new ExplicitSeqLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(458); match(T__46);
				setState(459); expressionSequence();
				setState(460); match(T__32);
				}
				break;

			case 9:
				_localctx = new ExplicitSetLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(462); match(T__17);
				setState(463); expressionSequence();
				setState(464); match(T__32);
				}
				break;

			case 10:
				_localctx = new EnumLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(466); match(Ident);
				setState(467); match(T__68);
				setState(468); match(Ident);
				setState(469); match(T__68);
				setState(470); match(Ident);
				}
				break;

			case 11:
				_localctx = new ErrorEnumLitContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(471); match(Ident);
				setState(472); match(T__68);
				setState(473); match(Ident);
				setState(474); match(T__16);
				}
				break;

			case 12:
				_localctx = new TypeLitContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(475); typeLiteral();
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
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterClassifierSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitClassifierSetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitClassifierSetType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetTypeContext extends TypeLiteralContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public SetTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitSetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitSetType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeqTypeContext extends TypeLiteralContext {
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public SeqTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterSeqType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitSeqType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitSeqType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanTypeContext extends TypeLiteralContext {
		public BooleanTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitBooleanType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RealTypeContext extends TypeLiteralContext {
		public RealTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRealType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRealType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRealType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClsTypeContext extends TypeLiteralContext {
		public ClassifierTypeRuleContext classifierTypeRule() {
			return getRuleContext(ClassifierTypeRuleContext.class,0);
		}
		public ClsTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterClsType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitClsType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitClsType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrTypeContext extends TypeLiteralContext {
		public StrTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterStrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitStrType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitStrType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeLiteralContext {
		public IntTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeLiteralContext typeLiteral() throws RecognitionException {
		TypeLiteralContext _localctx = new TypeLiteralContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_typeLiteral);
		int _la;
		try {
			setState(502);
			switch (_input.LA(1)) {
			case T__50:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(478); match(T__50);
				}
				break;
			case T__34:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(479); match(T__34);
				}
				break;
			case T__54:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(480); match(T__54);
				}
				break;
			case T__20:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(481); match(T__20);
				}
				break;
			case T__55:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(482); match(T__55);
				setState(483); typeLiteral();
				setState(484); match(T__4);
				}
				break;
			case T__63:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(486); match(T__63);
				setState(487); typeLiteral();
				setState(488); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ClsTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(490); classifierTypeRule();
				}
				break;
			case T__69:
				_localctx = new ClassifierSetTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(491); match(T__69);
				setState(492); classifierTypeRule();
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(493); match(T__14);
					setState(494); classifierTypeRule();
					}
					}
					setState(499);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(500); match(T__32);
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
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
		}
		public ClassifierTypeContext(ClassifierTypeRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterClassifierType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitClassifierType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitClassifierType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorClassifierTypeContext extends ClassifierTypeRuleContext {
		public TerminalNode Ident() { return getToken(ALEParser.Ident, 0); }
		public ErrorClassifierTypeContext(ClassifierTypeRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterErrorClassifierType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitErrorClassifierType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitErrorClassifierType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassifierTypeRuleContext classifierTypeRule() throws RecognitionException {
		ClassifierTypeRuleContext _localctx = new ClassifierTypeRuleContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_classifierTypeRule);
		try {
			setState(509);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new ClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(504); match(Ident);
				setState(505); match(T__68);
				setState(506); match(Ident);
				}
				break;

			case 2:
				_localctx = new ErrorClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(507); match(Ident);
				setState(508); match(T__16);
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
		case 27: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3W\u0202\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\7\2W\n\2\f\2\16\2Z\13\2\3\2\7\2]\n\2\f\2\16\2`\13\2\3\2\7\2c\n\2\f"+
		"\2\16\2f\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4r\n\4\f\4\16"+
		"\4u\13\4\3\4\3\4\3\5\3\5\5\5{\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0084"+
		"\n\6\f\6\16\6\u0087\13\6\5\6\u0089\n\6\3\6\3\6\7\6\u008d\n\6\f\6\16\6"+
		"\u0090\13\6\3\6\7\6\u0093\n\6\f\6\16\6\u0096\13\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\7\7\u009e\n\7\f\7\16\7\u00a1\13\7\3\7\7\7\u00a4\n\7\f\7\16\7\u00a7"+
		"\13\7\3\7\3\7\3\b\7\b\u00ac\n\b\f\b\16\b\u00af\13\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u00b6\n\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u00c1\n\n\f\n"+
		"\16\n\u00c4\13\n\3\13\3\13\3\13\3\f\5\f\u00ca\n\f\3\f\5\f\u00cd\n\f\3"+
		"\f\5\f\u00d0\n\f\3\f\3\f\3\f\3\f\5\f\u00d6\n\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e7\n\17\3\20\3\20"+
		"\3\20\3\20\5\20\u00ed\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0104"+
		"\n\23\3\24\3\24\3\24\7\24\u0109\n\24\f\24\16\24\u010c\13\24\5\24\u010e"+
		"\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0119\n\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\5\30\u0126\n\30\3\31"+
		"\3\31\5\31\u012a\n\31\3\32\3\32\3\32\7\32\u012f\n\32\f\32\16\32\u0132"+
		"\13\32\3\33\3\33\3\33\3\33\5\33\u0138\n\33\3\33\3\33\3\33\3\33\6\33\u013e"+
		"\n\33\r\33\16\33\u013f\3\33\3\33\3\33\3\33\3\33\3\34\5\34\u0148\n\34\3"+
		"\34\3\34\5\34\u014c\n\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\7\35\u015a\n\35\f\35\16\35\u015d\13\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u0170\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\7\35\u018b\n\35\f\35\16\35\u018e\13\35\3\36\3\36\3\36\5\36\u0193\n\36"+
		"\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\5!\u01a2\n!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01af\n\"\3#\3#\3$\3$\3%\3%\3"+
		"%\7%\u01b8\n%\f%\16%\u01bb\13%\5%\u01bd\n%\3&\3&\3&\5&\u01c2\n&\3&\3&"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01df\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u01f2\n(\f(\16(\u01f5\13(\3(\3(\5(\u01f9"+
		"\n(\3)\3)\3)\3)\3)\5)\u0200\n)\3)\2\38*\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP\2\b\4\2\20\20%%\4\2\30\30"+
		"CC\3\2RS\4\2##LL\n\2\6\6\f\f\32\32\34\34!!\61\61@@BB\13\2\13\13\23\23"+
		"\31\31\35\35,,\62\63\65\65\67\67AA\u0226\2R\3\2\2\2\4g\3\2\2\2\6m\3\2"+
		"\2\2\bz\3\2\2\2\n|\3\2\2\2\f\u0099\3\2\2\2\16\u00ad\3\2\2\2\20\u00ba\3"+
		"\2\2\2\22\u00bd\3\2\2\2\24\u00c5\3\2\2\2\26\u00c9\3\2\2\2\30\u00d9\3\2"+
		"\2\2\32\u00dd\3\2\2\2\34\u00e6\3\2\2\2\36\u00e8\3\2\2\2 \u00f0\3\2\2\2"+
		"\"\u00f5\3\2\2\2$\u0103\3\2\2\2&\u0105\3\2\2\2(\u0111\3\2\2\2*\u011a\3"+
		"\2\2\2,\u0120\3\2\2\2.\u0125\3\2\2\2\60\u0129\3\2\2\2\62\u012b\3\2\2\2"+
		"\64\u0133\3\2\2\2\66\u0147\3\2\2\28\u016f\3\2\2\2:\u018f\3\2\2\2<\u0197"+
		"\3\2\2\2>\u0199\3\2\2\2@\u01a1\3\2\2\2B\u01ae\3\2\2\2D\u01b0\3\2\2\2F"+
		"\u01b2\3\2\2\2H\u01bc\3\2\2\2J\u01be\3\2\2\2L\u01de\3\2\2\2N\u01f8\3\2"+
		"\2\2P\u01ff\3\2\2\2RS\7\'\2\2ST\5\62\32\2TX\7*\2\2UW\5\4\3\2VU\3\2\2\2"+
		"WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y^\3\2\2\2ZX\3\2\2\2[]\5\6\4\2\\[\3\2\2"+
		"\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_d\3\2\2\2`^\3\2\2\2ac\5\b\5\2ba\3\2"+
		"\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\3\3\2\2\2fd\3\2\2\2gh\7M\2\2hi\5\62"+
		"\32\2ij\7&\2\2jk\7W\2\2kl\7*\2\2l\5\3\2\2\2mn\7\5\2\2ns\7W\2\2op\78\2"+
		"\2pr\7W\2\2qo\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2"+
		"\2vw\7*\2\2w\7\3\2\2\2x{\5\n\6\2y{\5\f\7\2zx\3\2\2\2zy\3\2\2\2{\t\3\2"+
		"\2\2|}\7F\2\2}~\7)\2\2~\u0088\5\62\32\2\177\u0080\7.\2\2\u0080\u0085\5"+
		"\62\32\2\u0081\u0082\7\24\2\2\u0082\u0084\5\62\32\2\u0083\u0081\3\2\2"+
		"\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0089"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0088\177\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008e\7\b\2\2\u008b\u008d\5\26\f\2\u008c\u008b\3"+
		"\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0094\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093\5\16\b\2\u0092\u0091\3"+
		"\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7-\2\2\u0098\13\3\2\2\2"+
		"\u0099\u009a\7)\2\2\u009a\u009b\7W\2\2\u009b\u009f\7\b\2\2\u009c\u009e"+
		"\5\26\f\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u00a5\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4"+
		"\5\16\b\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2"+
		"\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9"+
		"\7-\2\2\u00a9\r\3\2\2\2\u00aa\u00ac\5\20\t\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\t\2\2\2\u00b1\u00b2\5\60\31\2\u00b2"+
		"\u00b3\7W\2\2\u00b3\u00b5\7\22\2\2\u00b4\u00b6\5\22\n\2\u00b5\u00b4\3"+
		"\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7I\2\2\u00b8"+
		"\u00b9\5&\24\2\u00b9\17\3\2\2\2\u00ba\u00bb\7 \2\2\u00bb\u00bc\7W\2\2"+
		"\u00bc\21\3\2\2\2\u00bd\u00c2\5\24\13\2\u00be\u00bf\7\24\2\2\u00bf\u00c1"+
		"\5\24\13\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2"+
		"\u00c2\u00c3\3\2\2\2\u00c3\23\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6"+
		"\5\60\31\2\u00c6\u00c7\7W\2\2\u00c7\25\3\2\2\2\u00c8\u00ca\t\3\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00cd\5\30"+
		"\r\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00d0\5\32\16\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3"+
		"\2\2\2\u00d1\u00d2\5\60\31\2\u00d2\u00d5\7W\2\2\u00d3\u00d4\7\60\2\2\u00d4"+
		"\u00d6\5.\30\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00d8\7*\2\2\u00d8\27\3\2\2\2\u00d9\u00da\7S\2\2\u00da\u00db"+
		"\7\n\2\2\u00db\u00dc\t\4\2\2\u00dc\31\3\2\2\2\u00dd\u00de\7\64\2\2\u00de"+
		"\u00df\7W\2\2\u00df\33\3\2\2\2\u00e0\u00e7\5\36\20\2\u00e1\u00e7\5 \21"+
		"\2\u00e2\u00e7\5\"\22\2\u00e3\u00e7\5*\26\2\u00e4\u00e7\5(\25\2\u00e5"+
		"\u00e7\5,\27\2\u00e6\u00e0\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e2\3\2"+
		"\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7"+
		"\35\3\2\2\2\u00e8\u00e9\5\60\31\2\u00e9\u00ec\7W\2\2\u00ea\u00eb\7\60"+
		"\2\2\u00eb\u00ed\5.\30\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ef\7*\2\2\u00ef\37\3\2\2\2\u00f0\u00f1\58\35\2"+
		"\u00f1\u00f2\7\60\2\2\u00f2\u00f3\5.\30\2\u00f3\u00f4\7*\2\2\u00f4!\3"+
		"\2\2\2\u00f5\u00f6\7\r\2\2\u00f6\u00f7\7\22\2\2\u00f7\u00f8\7W\2\2\u00f8"+
		"\u00f9\7H\2\2\u00f9\u00fa\5$\23\2\u00fa\u00fb\7I\2\2\u00fb\u00fc\5&\24"+
		"\2\u00fc#\3\2\2\2\u00fd\u00fe\7>\2\2\u00fe\u00ff\7S\2\2\u00ff\u0100\7"+
		"\n\2\2\u0100\u0101\7S\2\2\u0101\u0104\7\36\2\2\u0102\u0104\5.\30\2\u0103"+
		"\u00fd\3\2\2\2\u0103\u0102\3\2\2\2\u0104%\3\2\2\2\u0105\u010d\7\b\2\2"+
		"\u0106\u010a\5\34\17\2\u0107\u0109\5\34\17\2\u0108\u0107\3\2\2\2\u0109"+
		"\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010e\3\2"+
		"\2\2\u010c\u010a\3\2\2\2\u010d\u0106\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0110\7-\2\2\u0110\'\3\2\2\2\u0111\u0112\7/\2\2\u0112"+
		"\u0113\7\22\2\2\u0113\u0114\5.\30\2\u0114\u0115\7I\2\2\u0115\u0118\5&"+
		"\24\2\u0116\u0117\7G\2\2\u0117\u0119\5&\24\2\u0118\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119)\3\2\2\2\u011a\u011b\7\7\2\2\u011b\u011c\7\22\2\2"+
		"\u011c\u011d\5.\30\2\u011d\u011e\7I\2\2\u011e\u011f\5&\24\2\u011f+\3\2"+
		"\2\2\u0120\u0121\5.\30\2\u0121\u0122\7*\2\2\u0122-\3\2\2\2\u0123\u0126"+
		"\5\64\33\2\u0124\u0126\58\35\2\u0125\u0123\3\2\2\2\u0125\u0124\3\2\2\2"+
		"\u0126/\3\2\2\2\u0127\u012a\5\62\32\2\u0128\u012a\5N(\2\u0129\u0127\3"+
		"\2\2\2\u0129\u0128\3\2\2\2\u012a\61\3\2\2\2\u012b\u0130\7W\2\2\u012c\u012d"+
		"\78\2\2\u012d\u012f\7W\2\2\u012e\u012c\3\2\2\2\u012f\u0132\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\63\3\2\2\2\u0132\u0130\3\2\2"+
		"\2\u0133\u0134\7\66\2\2\u0134\u0137\7\22\2\2\u0135\u0136\7W\2\2\u0136"+
		"\u0138\7=\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013a\5.\30\2\u013a\u013b\7I\2\2\u013b\u013d\7\b\2\2\u013c"+
		"\u013e\5\66\34\2\u013d\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u013d\3"+
		"\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\7\4\2\2\u0142"+
		"\u0143\7=\2\2\u0143\u0144\5.\30\2\u0144\u0145\7-\2\2\u0145\65\3\2\2\2"+
		"\u0146\u0148\5\60\31\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014b"+
		"\3\2\2\2\u0149\u014a\7;\2\2\u014a\u014c\5.\30\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\7=\2\2\u014e\u014f\5.\30"+
		"\2\u014f\67\3\2\2\2\u0150\u0151\b\35\1\2\u0151\u0152\7K\2\2\u0152\u0170"+
		"\58\35\20\u0153\u0154\7L\2\2\u0154\u0170\58\35\17\u0155\u0156\7\"\2\2"+
		"\u0156\u015b\5:\36\2\u0157\u0158\7\24\2\2\u0158\u015a\5:\36\2\u0159\u0157"+
		"\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7H\2\2\u015f\u0160\58\35"+
		"\3\u0160\u0170\3\2\2\2\u0161\u0170\7W\2\2\u0162\u0170\5L\'\2\u0163\u0164"+
		"\7\22\2\2\u0164\u0165\58\35\2\u0165\u0166\7I\2\2\u0166\u0170\3\2\2\2\u0167"+
		"\u0168\7/\2\2\u0168\u0169\58\35\2\u0169\u016a\7$\2\2\u016a\u016b\58\35"+
		"\2\u016b\u016c\7G\2\2\u016c\u016d\58\35\2\u016d\u016e\7\3\2\2\u016e\u0170"+
		"\3\2\2\2\u016f\u0150\3\2\2\2\u016f\u0153\3\2\2\2\u016f\u0155\3\2\2\2\u016f"+
		"\u0161\3\2\2\2\u016f\u0162\3\2\2\2\u016f\u0163\3\2\2\2\u016f\u0167\3\2"+
		"\2\2\u0170\u018c\3\2\2\2\u0171\u0172\f\16\2\2\u0172\u0173\7R\2\2\u0173"+
		"\u018b\58\35\17\u0174\u0175\f\r\2\2\u0175\u0176\5<\37\2\u0176\u0177\5"+
		"8\35\16\u0177\u018b\3\2\2\2\u0178\u0179\f\f\2\2\u0179\u017a\5> \2\u017a"+
		"\u017b\58\35\r\u017b\u018b\3\2\2\2\u017c\u017d\f\13\2\2\u017d\u017e\7"+
		"J\2\2\u017e\u018b\58\35\f\u017f\u0180\f\n\2\2\u0180\u0181\7E\2\2\u0181"+
		"\u018b\58\35\13\u0182\u0183\f\t\2\2\u0183\u0184\7D\2\2\u0184\u018b\58"+
		"\35\n\u0185\u0186\f\b\2\2\u0186\u0187\7\21\2\2\u0187\u018b\58\35\t\u0188"+
		"\u0189\f\21\2\2\u0189\u018b\5@!\2\u018a\u0171\3\2\2\2\u018a\u0174\3\2"+
		"\2\2\u018a\u0178\3\2\2\2\u018a\u017c\3\2\2\2\u018a\u017f\3\2\2\2\u018a"+
		"\u0182\3\2\2\2\u018a\u0185\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018e\3\2"+
		"\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d9\3\2\2\2\u018e\u018c"+
		"\3\2\2\2\u018f\u0192\7W\2\2\u0190\u0191\7=\2\2\u0191\u0193\5N(\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\7\f"+
		"\2\2\u0195\u0196\58\35\2\u0196;\3\2\2\2\u0197\u0198\t\5\2\2\u0198=\3\2"+
		"\2\2\u0199\u019a\t\6\2\2\u019a?\3\2\2\2\u019b\u019c\78\2\2\u019c\u01a2"+
		"\7W\2\2\u019d\u019e\78\2\2\u019e\u01a2\5B\"\2\u019f\u01a0\7:\2\2\u01a0"+
		"\u01a2\5B\"\2\u01a1\u019b\3\2\2\2\u01a1\u019d\3\2\2\2\u01a1\u019f\3\2"+
		"\2\2\u01a2A\3\2\2\2\u01a3\u01a4\5F$\2\u01a4\u01a5\7\22\2\2\u01a5\u01a6"+
		"\5J&\2\u01a6\u01a7\5D#\2\u01a7\u01a8\7I\2\2\u01a8\u01af\3\2\2\2\u01a9"+
		"\u01aa\7W\2\2\u01aa\u01ab\7\22\2\2\u01ab\u01ac\5H%\2\u01ac\u01ad\7I\2"+
		"\2\u01ad\u01af\3\2\2\2\u01ae\u01a3\3\2\2\2\u01ae\u01a9\3\2\2\2\u01afC"+
		"\3\2\2\2\u01b0\u01b1\58\35\2\u01b1E\3\2\2\2\u01b2\u01b3\t\7\2\2\u01b3"+
		"G\3\2\2\2\u01b4\u01b9\58\35\2\u01b5\u01b6\7\24\2\2\u01b6\u01b8\58\35\2"+
		"\u01b7\u01b5\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba"+
		"\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01b4\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bdI\3\2\2\2\u01be\u01c1\7W\2\2\u01bf\u01c0\7=\2\2\u01c0"+
		"\u01c2\5N(\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\3\2\2"+
		"\2\u01c3\u01c4\7?\2\2\u01c4K\3\2\2\2\u01c5\u01df\7U\2\2\u01c6\u01df\7"+
		"V\2\2\u01c7\u01df\7S\2\2\u01c8\u01df\7T\2\2\u01c9\u01df\7(\2\2\u01ca\u01df"+
		"\7\25\2\2\u01cb\u01df\7\17\2\2\u01cc\u01cd\7\37\2\2\u01cd\u01ce\5H%\2"+
		"\u01ce\u01cf\7-\2\2\u01cf\u01df\3\2\2\2\u01d0\u01d1\7<\2\2\u01d1\u01d2"+
		"\5H%\2\u01d2\u01d3\7-\2\2\u01d3\u01df\3\2\2\2\u01d4\u01d5\7W\2\2\u01d5"+
		"\u01d6\7\t\2\2\u01d6\u01d7\7W\2\2\u01d7\u01d8\7\t\2\2\u01d8\u01df\7W\2"+
		"\2\u01d9\u01da\7W\2\2\u01da\u01db\7\t\2\2\u01db\u01dc\7W\2\2\u01dc\u01df"+
		"\7=\2\2\u01dd\u01df\5N(\2\u01de\u01c5\3\2\2\2\u01de\u01c6\3\2\2\2\u01de"+
		"\u01c7\3\2\2\2\u01de\u01c8\3\2\2\2\u01de\u01c9\3\2\2\2\u01de\u01ca\3\2"+
		"\2\2\u01de\u01cb\3\2\2\2\u01de\u01cc\3\2\2\2\u01de\u01d0\3\2\2\2\u01de"+
		"\u01d4\3\2\2\2\u01de\u01d9\3\2\2\2\u01de\u01dd\3\2\2\2\u01dfM\3\2\2\2"+
		"\u01e0\u01f9\7\33\2\2\u01e1\u01f9\7+\2\2\u01e2\u01f9\7\27\2\2\u01e3\u01f9"+
		"\79\2\2\u01e4\u01e5\7\26\2\2\u01e5\u01e6\5N(\2\u01e6\u01e7\7I\2\2\u01e7"+
		"\u01f9\3\2\2\2\u01e8\u01e9\7\16\2\2\u01e9\u01ea\5N(\2\u01ea\u01eb\7I\2"+
		"\2\u01eb\u01f9\3\2\2\2\u01ec\u01f9\5P)\2\u01ed\u01ee\7\b\2\2\u01ee\u01f3"+
		"\5P)\2\u01ef\u01f0\7?\2\2\u01f0\u01f2\5P)\2\u01f1\u01ef\3\2\2\2\u01f2"+
		"\u01f5\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f6\3\2"+
		"\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f7\7-\2\2\u01f7\u01f9\3\2\2\2\u01f8"+
		"\u01e0\3\2\2\2\u01f8\u01e1\3\2\2\2\u01f8\u01e2\3\2\2\2\u01f8\u01e3\3\2"+
		"\2\2\u01f8\u01e4\3\2\2\2\u01f8\u01e8\3\2\2\2\u01f8\u01ec\3\2\2\2\u01f8"+
		"\u01ed\3\2\2\2\u01f9O\3\2\2\2\u01fa\u01fb\7W\2\2\u01fb\u01fc\7\t\2\2\u01fc"+
		"\u0200\7W\2\2\u01fd\u01fe\7W\2\2\u01fe\u0200\7=\2\2\u01ff\u01fa\3\2\2"+
		"\2\u01ff\u01fd\3\2\2\2\u0200Q\3\2\2\2/X^dsz\u0085\u0088\u008e\u0094\u009f"+
		"\u00a5\u00ad\u00b5\u00c2\u00c9\u00cc\u00cf\u00d5\u00e6\u00ec\u0103\u010a"+
		"\u010d\u0118\u0125\u0129\u0130\u0137\u013f\u0147\u014b\u015b\u016f\u018a"+
		"\u018c\u0192\u01a1\u01ae\u01b9\u01bc\u01c1\u01de\u01f3\u01f8\u01ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}