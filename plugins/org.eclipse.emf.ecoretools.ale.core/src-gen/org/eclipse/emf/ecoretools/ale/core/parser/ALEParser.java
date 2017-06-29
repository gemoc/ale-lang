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
		T__76=1, T__75=2, T__74=3, T__73=4, T__72=5, T__71=6, T__70=7, T__69=8, 
		T__68=9, T__67=10, T__66=11, T__65=12, T__64=13, T__63=14, T__62=15, T__61=16, 
		T__60=17, T__59=18, T__58=19, T__57=20, T__56=21, T__55=22, T__54=23, 
		T__53=24, T__52=25, T__51=26, T__50=27, T__49=28, T__48=29, T__47=30, 
		T__46=31, T__45=32, T__44=33, T__43=34, T__42=35, T__41=36, T__40=37, 
		T__39=38, T__38=39, T__37=40, T__36=41, T__35=42, T__34=43, T__33=44, 
		T__32=45, T__31=46, T__30=47, T__29=48, T__28=49, T__27=50, T__26=51, 
		T__25=52, T__24=53, T__23=54, T__22=55, T__21=56, T__20=57, T__19=58, 
		T__18=59, T__17=60, T__16=61, T__15=62, T__14=63, T__13=64, T__12=65, 
		T__11=66, T__10=67, T__9=68, T__8=69, T__7=70, T__6=71, T__5=72, T__4=73, 
		T__3=74, T__2=75, T__1=76, T__0=77, COMMENT=78, LINECOMMENT=79, STRING=80, 
		WS=81, MultOp=82, Integer=83, Real=84, String=85, ErrorString=86, Ident=87;
	public static final String[] tokenNames = {
		"<INVALID>", "'endif'", "'default'", "'+='", "'use'", "'!='", "'while'", 
		"'{'", "'::'", "'..'", "'one'", "'='", "'for'", "'OrderedSet('", "'null'", 
		"'override'", "'implies'", "'('", "'closure'", "'-='", "','", "'false'", 
		"'Sequence('", "'Real'", "'unique'", "'reject'", "'>='", "'String'", "'<'", 
		"'forAll'", "']'", "'Sequence{'", "'@'", "'<>'", "'let'", "'+'", "'then'", 
		"'def'", "'as'", "'behavior'", "'true'", "'class'", "';'", "'Integer'", 
		"'any'", "'}'", "'extends'", "'if'", "':='", "'<='", "'sortedBy'", "'isUnique'", 
		"'opposite '", "'collect'", "'switch'", "'exists'", "'.'", "'Boolean'", 
		"'->'", "'case'", "'OrderedSet{'", "':'", "'['", "'|'", "'=='", "'select'", 
		"'>'", "'contains'", "'xor'", "'or'", "'open'", "'else'", "'in'", "')'", 
		"'and'", "'not'", "'-'", "'import'", "COMMENT", "LINECOMMENT", "STRING", 
		"WS", "MultOp", "Integer", "Real", "String", "ErrorString", "Ident"
	};
	public static final int
		RULE_rRoot = 0, RULE_rImport = 1, RULE_rService = 2, RULE_rClass = 3, 
		RULE_rOpenClass = 4, RULE_rNewClass = 5, RULE_rOperation = 6, RULE_rTag = 7, 
		RULE_rParameters = 8, RULE_rVariable = 9, RULE_rAttribute = 10, RULE_rCardinality = 11, 
		RULE_rOpposite = 12, RULE_rStatement = 13, RULE_rVarDecl = 14, RULE_rAssign = 15, 
		RULE_rInsert = 16, RULE_rRemove = 17, RULE_rForEach = 18, RULE_rCollection = 19, 
		RULE_rBlock = 20, RULE_rIf = 21, RULE_rWhile = 22, RULE_rExpressionStmt = 23, 
		RULE_rExpression = 24, RULE_rType = 25, RULE_rQualified = 26, RULE_rSwitch = 27, 
		RULE_rCase = 28, RULE_expression = 29, RULE_binding = 30, RULE_addOp = 31, 
		RULE_compOp = 32, RULE_navigationSegment = 33, RULE_callExp = 34, RULE_lambdaExpression = 35, 
		RULE_collectionIterator = 36, RULE_expressionSequence = 37, RULE_variableDefinition = 38, 
		RULE_literal = 39, RULE_typeLiteral = 40, RULE_classifierTypeRule = 41;
	public static final String[] ruleNames = {
		"rRoot", "rImport", "rService", "rClass", "rOpenClass", "rNewClass", "rOperation", 
		"rTag", "rParameters", "rVariable", "rAttribute", "rCardinality", "rOpposite", 
		"rStatement", "rVarDecl", "rAssign", "rInsert", "rRemove", "rForEach", 
		"rCollection", "rBlock", "rIf", "rWhile", "rExpressionStmt", "rExpression", 
		"rType", "rQualified", "rSwitch", "rCase", "expression", "binding", "addOp", 
		"compOp", "navigationSegment", "callExp", "lambdaExpression", "collectionIterator", 
		"expressionSequence", "variableDefinition", "literal", "typeLiteral", 
		"classifierTypeRule"
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
			setState(84); match(T__38);
			setState(85); rQualified();
			setState(86); match(T__35);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(87); rImport();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__73) {
				{
				{
				setState(93); rService();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36 || _la==T__7) {
				{
				{
				setState(99); rClass();
				}
				}
				setState(104);
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
			setState(105); match(T__0);
			setState(106); rQualified();
			setState(107); match(T__39);
			setState(108); match(Ident);
			setState(109); match(T__35);
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
			setState(111); match(T__73);
			setState(112); match(Ident);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(113); match(T__21);
				setState(114); match(Ident);
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120); match(T__35);
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
			setState(124);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); rOpenClass();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(123); rNewClass();
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
			setState(126); match(T__7);
			setState(127); match(T__36);
			setState(128); ((ROpenClassContext)_localctx).name = rQualified();
			setState(138);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(129); match(T__31);
				setState(130); rQualified();
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(131); match(T__57);
					setState(132); rQualified();
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(140); match(T__70);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__70) | (1L << T__64) | (1L << T__55) | (1L << T__54) | (1L << T__53) | (1L << T__50) | (1L << T__34) | (1L << T__25) | (1L << T__20))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__10 - 67)) | (1L << (Integer - 67)) | (1L << (Ident - 67)))) != 0)) {
				{
				{
				setState(141); rAttribute();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__45) | (1L << T__40))) != 0)) {
				{
				{
				setState(147); rOperation();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153); match(T__32);
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
			setState(155); match(T__36);
			setState(156); ((RNewClassContext)_localctx).name = match(Ident);
			setState(157); match(T__70);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__70) | (1L << T__64) | (1L << T__55) | (1L << T__54) | (1L << T__53) | (1L << T__50) | (1L << T__34) | (1L << T__25) | (1L << T__20))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__10 - 67)) | (1L << (Integer - 67)) | (1L << (Ident - 67)))) != 0)) {
				{
				{
				setState(158); rAttribute();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__45) | (1L << T__40))) != 0)) {
				{
				{
				setState(164); rOperation();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170); match(T__32);
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
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__45) {
				{
				{
				setState(172); rTag();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			_la = _input.LA(1);
			if ( !(_la==T__62 || _la==T__40) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(179); ((ROperationContext)_localctx).type = rType();
			setState(180); ((ROperationContext)_localctx).name = match(Ident);
			setState(181); match(T__60);
			setState(183);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__70) | (1L << T__64) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__34) | (1L << T__20))) != 0) || _la==Ident) {
				{
				setState(182); rParameters();
				}
			}

			setState(185); match(T__4);
			setState(186); rBlock();
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
			setState(188); match(T__45);
			setState(189); match(Ident);
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
			setState(191); rVariable();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__57) {
				{
				{
				setState(192); match(T__57);
				setState(193); rVariable();
				}
				}
				setState(198);
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
			setState(199); ((RVariableContext)_localctx).type = rType();
			setState(200); match(Ident);
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
			setState(203);
			_la = _input.LA(1);
			if (_la==T__53 || _la==T__10) {
				{
				setState(202);
				((RAttributeContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__53 || _la==T__10) ) {
					((RAttributeContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(206);
			_la = _input.LA(1);
			if (_la==Integer) {
				{
				setState(205); ((RAttributeContext)_localctx).bounds = rCardinality();
				}
			}

			setState(209);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(208); ((RAttributeContext)_localctx).opposite = rOpposite();
				}
			}

			setState(211); ((RAttributeContext)_localctx).type = rType();
			setState(212); match(Ident);
			setState(215);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(213); match(T__29);
				setState(214); rExpression();
				}
			}

			setState(217); match(T__35);
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
			setState(219); match(Integer);
			setState(220); match(T__68);
			setState(221);
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
			setState(223); match(T__25);
			setState(224); match(Ident);
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
		public RInsertContext rInsert() {
			return getRuleContext(RInsertContext.class,0);
		}
		public RIfContext rIf() {
			return getRuleContext(RIfContext.class,0);
		}
		public RExpressionStmtContext rExpressionStmt() {
			return getRuleContext(RExpressionStmtContext.class,0);
		}
		public RRemoveContext rRemove() {
			return getRuleContext(RRemoveContext.class,0);
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
			setState(234);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226); rVarDecl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227); rAssign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(228); rInsert();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(229); rRemove();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(230); rForEach();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(231); rWhile();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(232); rIf();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(233); rExpressionStmt();
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
			setState(236); ((RVarDeclContext)_localctx).type = rType();
			setState(237); match(Ident);
			setState(240);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(238); match(T__29);
				setState(239); rExpression();
				}
			}

			setState(242); match(T__35);
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
			setState(244); expression(0);
			setState(245); match(T__29);
			setState(246); rExpression();
			setState(247); match(T__35);
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

	public static class RInsertContext extends ParserRuleContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RInsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rInsert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRInsert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRInsert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RInsertContext rInsert() throws RecognitionException {
		RInsertContext _localctx = new RInsertContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rInsert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249); expression(0);
			setState(250); match(T__74);
			setState(251); rExpression();
			setState(252); match(T__35);
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

	public static class RRemoveContext extends ParserRuleContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RRemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rRemove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).enterRRemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ALEListener ) ((ALEListener)listener).exitRRemove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ALEVisitor ) return ((ALEVisitor<? extends T>)visitor).visitRRemove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RRemoveContext rRemove() throws RecognitionException {
		RRemoveContext _localctx = new RRemoveContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rRemove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); expression(0);
			setState(255); match(T__58);
			setState(256); rExpression();
			setState(257); match(T__35);
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
		enterRule(_localctx, 36, RULE_rForEach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(T__65);
			setState(260); match(T__60);
			setState(261); match(Ident);
			setState(262); match(T__5);
			setState(263); rCollection();
			setState(264); match(T__4);
			setState(265); rBlock();
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
		enterRule(_localctx, 38, RULE_rCollection);
		try {
			setState(273);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(267); match(T__15);
				setState(268); match(Integer);
				setState(269); match(T__68);
				setState(270); match(Integer);
				setState(271); match(T__47);
				}
				break;
			case T__70:
			case T__64:
			case T__63:
			case T__60:
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
				setState(272); rExpression();
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
		enterRule(_localctx, 40, RULE_rBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); match(T__70);
			setState(283);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__71) | (1L << T__70) | (1L << T__65) | (1L << T__64) | (1L << T__63) | (1L << T__60) | (1L << T__56) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__46) | (1L << T__43) | (1L << T__37) | (1L << T__34) | (1L << T__30) | (1L << T__23) | (1L << T__20) | (1L << T__17))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__2 - 75)) | (1L << (T__1 - 75)) | (1L << (Integer - 75)) | (1L << (Real - 75)) | (1L << (String - 75)) | (1L << (ErrorString - 75)) | (1L << (Ident - 75)))) != 0)) {
				{
				setState(276); rStatement();
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__71) | (1L << T__70) | (1L << T__65) | (1L << T__64) | (1L << T__63) | (1L << T__60) | (1L << T__56) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__46) | (1L << T__43) | (1L << T__37) | (1L << T__34) | (1L << T__30) | (1L << T__23) | (1L << T__20) | (1L << T__17))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__2 - 75)) | (1L << (T__1 - 75)) | (1L << (Integer - 75)) | (1L << (Real - 75)) | (1L << (String - 75)) | (1L << (ErrorString - 75)) | (1L << (Ident - 75)))) != 0)) {
					{
					{
					setState(277); rStatement();
					}
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(285); match(T__32);
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
		enterRule(_localctx, 42, RULE_rIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); match(T__30);
			setState(288); match(T__60);
			setState(289); rExpression();
			setState(290); match(T__4);
			setState(291); rBlock();
			setState(294);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(292); match(T__6);
				setState(293); rBlock();
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
		enterRule(_localctx, 44, RULE_rWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296); match(T__71);
			setState(297); match(T__60);
			setState(298); rExpression();
			setState(299); match(T__4);
			setState(300); rBlock();
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
		enterRule(_localctx, 46, RULE_rExpressionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302); rExpression();
			setState(303); match(T__35);
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
		enterRule(_localctx, 48, RULE_rExpression);
		try {
			setState(307);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(305); rSwitch();
				}
				break;
			case T__70:
			case T__64:
			case T__63:
			case T__60:
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
				setState(306); expression(0);
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
		public List<TerminalNode> Ident() { return getTokens(ALEParser.Ident); }
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public TerminalNode Ident(int i) {
			return getToken(ALEParser.Ident, i);
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
		enterRule(_localctx, 50, RULE_rType);
		int _la;
		try {
			setState(318);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309); typeLiteral();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310); match(Ident);
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__69) {
					{
					{
					setState(311); match(T__69);
					setState(312); match(Ident);
					}
					}
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		enterRule(_localctx, 52, RULE_rQualified);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320); match(Ident);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(321); match(T__21);
				setState(322); match(Ident);
				}
				}
				setState(327);
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
		enterRule(_localctx, 54, RULE_rSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328); match(T__23);
			setState(329); match(T__60);
			setState(332);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(330); ((RSwitchContext)_localctx).paramName = match(Ident);
				setState(331); match(T__16);
				}
				break;
			}
			setState(334); ((RSwitchContext)_localctx).paramVal = rExpression();
			setState(335); match(T__4);
			setState(336); match(T__70);
			setState(338); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(337); ((RSwitchContext)_localctx).rCase = rCase();
				((RSwitchContext)_localctx).cases.add(((RSwitchContext)_localctx).rCase);
				}
				}
				setState(340); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__70) | (1L << T__64) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__34) | (1L << T__20) | (1L << T__18) | (1L << T__16))) != 0) || _la==Ident );
			setState(342); match(T__75);
			setState(343); match(T__16);
			setState(344); ((RSwitchContext)_localctx).other = rExpression();
			setState(345); match(T__32);
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
		enterRule(_localctx, 56, RULE_rCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__70) | (1L << T__64) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__34) | (1L << T__20))) != 0) || _la==Ident) {
				{
				setState(347); ((RCaseContext)_localctx).guard = rType();
				}
			}

			setState(352);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(350); match(T__18);
				setState(351); ((RCaseContext)_localctx).match = rExpression();
				}
			}

			setState(354); match(T__16);
			setState(355); ((RCaseContext)_localctx).value = rExpression();
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(358); match(T__2);
				setState(359); expression(14);
				}
				break;

			case 2:
				{
				_localctx = new MinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(360); match(T__1);
				setState(361); expression(13);
				}
				break;

			case 3:
				{
				_localctx = new LetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(362); match(T__43);
				setState(363); binding();
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(364); match(T__57);
					setState(365); binding();
					}
					}
					setState(370);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(371); match(T__5);
				setState(372); expression(1);
				}
				break;

			case 4:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(374); match(Ident);
				}
				break;

			case 5:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(375); literal();
				}
				break;

			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(376); match(T__60);
				setState(377); expression(0);
				setState(378); match(T__4);
				}
				break;

			case 7:
				{
				_localctx = new ConditionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(380); match(T__30);
				setState(381); expression(0);
				setState(382); match(T__41);
				setState(383); expression(0);
				setState(384); match(T__6);
				setState(385); expression(0);
				setState(386); match(T__76);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(417);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(415);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(390);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(391); match(MultOp);
						setState(392); expression(13);
						}
						break;

					case 2:
						{
						_localctx = new AddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(393);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(394); addOp();
						setState(395); expression(12);
						}
						break;

					case 3:
						{
						_localctx = new CompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(397);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(398); compOp();
						setState(399); expression(11);
						}
						break;

					case 4:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(401);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(402); match(T__3);
						setState(403); expression(10);
						}
						break;

					case 5:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(404);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(405); match(T__8);
						setState(406); expression(9);
						}
						break;

					case 6:
						{
						_localctx = new XorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(407);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(408); match(T__9);
						setState(409); expression(8);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(410);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(411); match(T__61);
						setState(412); expression(7);
						}
						break;

					case 8:
						{
						_localctx = new NavContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(413);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(414); navigationSegment();
						}
						break;
					}
					} 
				}
				setState(419);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		enterRule(_localctx, 60, RULE_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420); match(Ident);
			setState(423);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(421); match(T__16);
				setState(422); typeLiteral();
				}
			}

			setState(425); match(T__66);
			setState(426); expression(0);
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
		enterRule(_localctx, 62, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
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
		enterRule(_localctx, 64, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			_la = _input.LA(1);
			if ( !(((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (T__72 - 5)) | (1L << (T__66 - 5)) | (1L << (T__51 - 5)) | (1L << (T__49 - 5)) | (1L << (T__44 - 5)) | (1L << (T__28 - 5)) | (1L << (T__13 - 5)) | (1L << (T__11 - 5)))) != 0)) ) {
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
		enterRule(_localctx, 66, RULE_navigationSegment);
		try {
			setState(438);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new FeatureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(432); match(T__21);
				setState(433); match(Ident);
				}
				break;

			case 2:
				_localctx = new CallOrApplyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(434); match(T__21);
				setState(435); callExp();
				}
				break;

			case 3:
				_localctx = new CollectionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(436); match(T__19);
				setState(437); callExp();
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
		enterRule(_localctx, 68, RULE_callExp);
		try {
			setState(451);
			switch (_input.LA(1)) {
			case T__67:
			case T__59:
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
				setState(440); collectionIterator();
				setState(441); match(T__60);
				setState(442); variableDefinition();
				setState(443); lambdaExpression();
				setState(444); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ServiceCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(446); match(Ident);
				setState(447); match(T__60);
				setState(448); expressionSequence();
				setState(449); match(T__4);
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
		enterRule(_localctx, 70, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453); expression(0);
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
		enterRule(_localctx, 72, RULE_collectionIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_la = _input.LA(1);
			if ( !(((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__67 - 10)) | (1L << (T__59 - 10)) | (1L << (T__52 - 10)) | (1L << (T__48 - 10)) | (1L << (T__33 - 10)) | (1L << (T__27 - 10)) | (1L << (T__26 - 10)) | (1L << (T__24 - 10)) | (1L << (T__22 - 10)) | (1L << (T__12 - 10)))) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_expressionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__70) | (1L << T__64) | (1L << T__63) | (1L << T__60) | (1L << T__56) | (1L << T__55) | (1L << T__54) | (1L << T__50) | (1L << T__46) | (1L << T__43) | (1L << T__37) | (1L << T__34) | (1L << T__30) | (1L << T__20) | (1L << T__17))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__2 - 75)) | (1L << (T__1 - 75)) | (1L << (Integer - 75)) | (1L << (Real - 75)) | (1L << (String - 75)) | (1L << (ErrorString - 75)) | (1L << (Ident - 75)))) != 0)) {
				{
				setState(457); expression(0);
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__57) {
					{
					{
					setState(458); match(T__57);
					setState(459); expression(0);
					}
					}
					setState(464);
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
		enterRule(_localctx, 76, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467); match(Ident);
			setState(470);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(468); match(T__16);
				setState(469); typeLiteral();
				}
			}

			setState(472); match(T__14);
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
		enterRule(_localctx, 78, RULE_literal);
		try {
			setState(499);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new StringLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(474); match(String);
				}
				break;

			case 2:
				_localctx = new ErrorStringLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(475); match(ErrorString);
				}
				break;

			case 3:
				_localctx = new IntegerLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(476); match(Integer);
				}
				break;

			case 4:
				_localctx = new RealLitContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(477); match(Real);
				}
				break;

			case 5:
				_localctx = new TrueLitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(478); match(T__37);
				}
				break;

			case 6:
				_localctx = new FalseLitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(479); match(T__56);
				}
				break;

			case 7:
				_localctx = new NullLitContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(480); match(T__63);
				}
				break;

			case 8:
				_localctx = new ExplicitSeqLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(481); match(T__46);
				setState(482); expressionSequence();
				setState(483); match(T__32);
				}
				break;

			case 9:
				_localctx = new ExplicitSetLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(485); match(T__17);
				setState(486); expressionSequence();
				setState(487); match(T__32);
				}
				break;

			case 10:
				_localctx = new EnumLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(489); match(Ident);
				setState(490); match(T__69);
				setState(491); match(Ident);
				setState(492); match(T__69);
				setState(493); match(Ident);
				}
				break;

			case 11:
				_localctx = new ErrorEnumLitContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(494); match(Ident);
				setState(495); match(T__69);
				setState(496); match(Ident);
				setState(497); match(T__16);
				}
				break;

			case 12:
				_localctx = new TypeLitContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(498); typeLiteral();
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
		enterRule(_localctx, 80, RULE_typeLiteral);
		int _la;
		try {
			setState(525);
			switch (_input.LA(1)) {
			case T__50:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(501); match(T__50);
				}
				break;
			case T__34:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(502); match(T__34);
				}
				break;
			case T__54:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(503); match(T__54);
				}
				break;
			case T__20:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(504); match(T__20);
				}
				break;
			case T__55:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(505); match(T__55);
				setState(506); typeLiteral();
				setState(507); match(T__4);
				}
				break;
			case T__64:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(509); match(T__64);
				setState(510); typeLiteral();
				setState(511); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ClsTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(513); classifierTypeRule();
				}
				break;
			case T__70:
				_localctx = new ClassifierSetTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(514); match(T__70);
				setState(515); classifierTypeRule();
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(516); match(T__14);
					setState(517); classifierTypeRule();
					}
					}
					setState(522);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(523); match(T__32);
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
		enterRule(_localctx, 82, RULE_classifierTypeRule);
		try {
			setState(532);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new ClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(527); match(Ident);
				setState(528); match(T__69);
				setState(529); match(Ident);
				}
				break;

			case 2:
				_localctx = new ErrorClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(530); match(Ident);
				setState(531); match(T__16);
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
		case 29: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Y\u0219\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\7\2[\n\2\f\2\16\2^\13\2\3\2\7\2a\n\2\f\2\16\2d\13\2\3\2"+
		"\7\2g\n\2\f\2\16\2j\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4v"+
		"\n\4\f\4\16\4y\13\4\3\4\3\4\3\5\3\5\5\5\177\n\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6\u0088\n\6\f\6\16\6\u008b\13\6\5\6\u008d\n\6\3\6\3\6\7\6\u0091"+
		"\n\6\f\6\16\6\u0094\13\6\3\6\7\6\u0097\n\6\f\6\16\6\u009a\13\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\7\7\u00a2\n\7\f\7\16\7\u00a5\13\7\3\7\7\7\u00a8\n\7\f"+
		"\7\16\7\u00ab\13\7\3\7\3\7\3\b\7\b\u00b0\n\b\f\b\16\b\u00b3\13\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00ba\n\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u00c5"+
		"\n\n\f\n\16\n\u00c8\13\n\3\13\3\13\3\13\3\f\5\f\u00ce\n\f\3\f\5\f\u00d1"+
		"\n\f\3\f\5\f\u00d4\n\f\3\f\3\f\3\f\3\f\5\f\u00da\n\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ed"+
		"\n\17\3\20\3\20\3\20\3\20\5\20\u00f3\n\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0114\n\25"+
		"\3\26\3\26\3\26\7\26\u0119\n\26\f\26\16\26\u011c\13\26\5\26\u011e\n\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0129\n\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\5\32\u0136\n\32\3\33\3\33"+
		"\3\33\3\33\7\33\u013c\n\33\f\33\16\33\u013f\13\33\5\33\u0141\n\33\3\34"+
		"\3\34\3\34\7\34\u0146\n\34\f\34\16\34\u0149\13\34\3\35\3\35\3\35\3\35"+
		"\5\35\u014f\n\35\3\35\3\35\3\35\3\35\6\35\u0155\n\35\r\35\16\35\u0156"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\5\36\u015f\n\36\3\36\3\36\5\36\u0163\n"+
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0171"+
		"\n\37\f\37\16\37\u0174\13\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0187\n\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u01a2\n\37\f\37\16"+
		"\37\u01a5\13\37\3 \3 \3 \5 \u01aa\n \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3#\5#\u01b9\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u01c6\n$\3%\3"+
		"%\3&\3&\3\'\3\'\3\'\7\'\u01cf\n\'\f\'\16\'\u01d2\13\'\5\'\u01d4\n\'\3"+
		"(\3(\3(\5(\u01d9\n(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01f6\n)\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u0209\n*\f*\16*\u020c\13*\3*\3*\5*\u0210"+
		"\n*\3+\3+\3+\3+\3+\5+\u0217\n+\3+\2\3<,\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT\2\b\4\2\21\21\'\'\4\2\32"+
		"\32EE\3\2TU\4\2%%NN\n\2\7\7\r\r\34\34\36\36##\63\63BBDD\13\2\f\f\24\24"+
		"\33\33\37\37..\64\65\67\6799CC\u023e\2V\3\2\2\2\4k\3\2\2\2\6q\3\2\2\2"+
		"\b~\3\2\2\2\n\u0080\3\2\2\2\f\u009d\3\2\2\2\16\u00b1\3\2\2\2\20\u00be"+
		"\3\2\2\2\22\u00c1\3\2\2\2\24\u00c9\3\2\2\2\26\u00cd\3\2\2\2\30\u00dd\3"+
		"\2\2\2\32\u00e1\3\2\2\2\34\u00ec\3\2\2\2\36\u00ee\3\2\2\2 \u00f6\3\2\2"+
		"\2\"\u00fb\3\2\2\2$\u0100\3\2\2\2&\u0105\3\2\2\2(\u0113\3\2\2\2*\u0115"+
		"\3\2\2\2,\u0121\3\2\2\2.\u012a\3\2\2\2\60\u0130\3\2\2\2\62\u0135\3\2\2"+
		"\2\64\u0140\3\2\2\2\66\u0142\3\2\2\28\u014a\3\2\2\2:\u015e\3\2\2\2<\u0186"+
		"\3\2\2\2>\u01a6\3\2\2\2@\u01ae\3\2\2\2B\u01b0\3\2\2\2D\u01b8\3\2\2\2F"+
		"\u01c5\3\2\2\2H\u01c7\3\2\2\2J\u01c9\3\2\2\2L\u01d3\3\2\2\2N\u01d5\3\2"+
		"\2\2P\u01f5\3\2\2\2R\u020f\3\2\2\2T\u0216\3\2\2\2VW\7)\2\2WX\5\66\34\2"+
		"X\\\7,\2\2Y[\5\4\3\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]b\3\2\2"+
		"\2^\\\3\2\2\2_a\5\6\4\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ch\3\2"+
		"\2\2db\3\2\2\2eg\5\b\5\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\3\3"+
		"\2\2\2jh\3\2\2\2kl\7O\2\2lm\5\66\34\2mn\7(\2\2no\7Y\2\2op\7,\2\2p\5\3"+
		"\2\2\2qr\7\6\2\2rw\7Y\2\2st\7:\2\2tv\7Y\2\2us\3\2\2\2vy\3\2\2\2wu\3\2"+
		"\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7,\2\2{\7\3\2\2\2|\177\5\n\6\2}\177"+
		"\5\f\7\2~|\3\2\2\2~}\3\2\2\2\177\t\3\2\2\2\u0080\u0081\7H\2\2\u0081\u0082"+
		"\7+\2\2\u0082\u008c\5\66\34\2\u0083\u0084\7\60\2\2\u0084\u0089\5\66\34"+
		"\2\u0085\u0086\7\26\2\2\u0086\u0088\5\66\34\2\u0087\u0085\3\2\2\2\u0088"+
		"\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008d\3\2"+
		"\2\2\u008b\u0089\3\2\2\2\u008c\u0083\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u0092\7\t\2\2\u008f\u0091\5\26\f\2\u0090\u008f\3"+
		"\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0098\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097\5\16\b\2\u0096\u0095\3"+
		"\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7/\2\2\u009c\13\3\2\2\2"+
		"\u009d\u009e\7+\2\2\u009e\u009f\7Y\2\2\u009f\u00a3\7\t\2\2\u00a0\u00a2"+
		"\5\26\f\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2"+
		"\u00a3\u00a4\3\2\2\2\u00a4\u00a9\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a8"+
		"\5\16\b\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2"+
		"\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad"+
		"\7/\2\2\u00ad\r\3\2\2\2\u00ae\u00b0\5\20\t\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\t\2\2\2\u00b5\u00b6\5\64\33\2\u00b6"+
		"\u00b7\7Y\2\2\u00b7\u00b9\7\23\2\2\u00b8\u00ba\5\22\n\2\u00b9\u00b8\3"+
		"\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7K\2\2\u00bc"+
		"\u00bd\5*\26\2\u00bd\17\3\2\2\2\u00be\u00bf\7\"\2\2\u00bf\u00c0\7Y\2\2"+
		"\u00c0\21\3\2\2\2\u00c1\u00c6\5\24\13\2\u00c2\u00c3\7\26\2\2\u00c3\u00c5"+
		"\5\24\13\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2"+
		"\u00c6\u00c7\3\2\2\2\u00c7\23\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca"+
		"\5\64\33\2\u00ca\u00cb\7Y\2\2\u00cb\25\3\2\2\2\u00cc\u00ce\t\3\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00d1\5\30"+
		"\r\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00d4\5\32\16\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3"+
		"\2\2\2\u00d5\u00d6\5\64\33\2\u00d6\u00d9\7Y\2\2\u00d7\u00d8\7\62\2\2\u00d8"+
		"\u00da\5\62\32\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3"+
		"\2\2\2\u00db\u00dc\7,\2\2\u00dc\27\3\2\2\2\u00dd\u00de\7U\2\2\u00de\u00df"+
		"\7\13\2\2\u00df\u00e0\t\4\2\2\u00e0\31\3\2\2\2\u00e1\u00e2\7\66\2\2\u00e2"+
		"\u00e3\7Y\2\2\u00e3\33\3\2\2\2\u00e4\u00ed\5\36\20\2\u00e5\u00ed\5 \21"+
		"\2\u00e6\u00ed\5\"\22\2\u00e7\u00ed\5$\23\2\u00e8\u00ed\5&\24\2\u00e9"+
		"\u00ed\5.\30\2\u00ea\u00ed\5,\27\2\u00eb\u00ed\5\60\31\2\u00ec\u00e4\3"+
		"\2\2\2\u00ec\u00e5\3\2\2\2\u00ec\u00e6\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ec"+
		"\u00e8\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2"+
		"\2\2\u00ed\35\3\2\2\2\u00ee\u00ef\5\64\33\2\u00ef\u00f2\7Y\2\2\u00f0\u00f1"+
		"\7\62\2\2\u00f1\u00f3\5\62\32\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2"+
		"\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7,\2\2\u00f5\37\3\2\2\2\u00f6\u00f7"+
		"\5<\37\2\u00f7\u00f8\7\62\2\2\u00f8\u00f9\5\62\32\2\u00f9\u00fa\7,\2\2"+
		"\u00fa!\3\2\2\2\u00fb\u00fc\5<\37\2\u00fc\u00fd\7\5\2\2\u00fd\u00fe\5"+
		"\62\32\2\u00fe\u00ff\7,\2\2\u00ff#\3\2\2\2\u0100\u0101\5<\37\2\u0101\u0102"+
		"\7\25\2\2\u0102\u0103\5\62\32\2\u0103\u0104\7,\2\2\u0104%\3\2\2\2\u0105"+
		"\u0106\7\16\2\2\u0106\u0107\7\23\2\2\u0107\u0108\7Y\2\2\u0108\u0109\7"+
		"J\2\2\u0109\u010a\5(\25\2\u010a\u010b\7K\2\2\u010b\u010c\5*\26\2\u010c"+
		"\'\3\2\2\2\u010d\u010e\7@\2\2\u010e\u010f\7U\2\2\u010f\u0110\7\13\2\2"+
		"\u0110\u0111\7U\2\2\u0111\u0114\7 \2\2\u0112\u0114\5\62\32\2\u0113\u010d"+
		"\3\2\2\2\u0113\u0112\3\2\2\2\u0114)\3\2\2\2\u0115\u011d\7\t\2\2\u0116"+
		"\u011a\5\34\17\2\u0117\u0119\5\34\17\2\u0118\u0117\3\2\2\2\u0119\u011c"+
		"\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011e\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011d\u0116\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2"+
		"\2\2\u011f\u0120\7/\2\2\u0120+\3\2\2\2\u0121\u0122\7\61\2\2\u0122\u0123"+
		"\7\23\2\2\u0123\u0124\5\62\32\2\u0124\u0125\7K\2\2\u0125\u0128\5*\26\2"+
		"\u0126\u0127\7I\2\2\u0127\u0129\5*\26\2\u0128\u0126\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129-\3\2\2\2\u012a\u012b\7\b\2\2\u012b\u012c\7\23\2\2\u012c"+
		"\u012d\5\62\32\2\u012d\u012e\7K\2\2\u012e\u012f\5*\26\2\u012f/\3\2\2\2"+
		"\u0130\u0131\5\62\32\2\u0131\u0132\7,\2\2\u0132\61\3\2\2\2\u0133\u0136"+
		"\58\35\2\u0134\u0136\5<\37\2\u0135\u0133\3\2\2\2\u0135\u0134\3\2\2\2\u0136"+
		"\63\3\2\2\2\u0137\u0141\5R*\2\u0138\u013d\7Y\2\2\u0139\u013a\7\n\2\2\u013a"+
		"\u013c\7Y\2\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u0140"+
		"\u0137\3\2\2\2\u0140\u0138\3\2\2\2\u0141\65\3\2\2\2\u0142\u0147\7Y\2\2"+
		"\u0143\u0144\7:\2\2\u0144\u0146\7Y\2\2\u0145\u0143\3\2\2\2\u0146\u0149"+
		"\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\67\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u014a\u014b\78\2\2\u014b\u014e\7\23\2\2\u014c\u014d\7Y"+
		"\2\2\u014d\u014f\7?\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u0151\5\62\32\2\u0151\u0152\7K\2\2\u0152\u0154\7"+
		"\t\2\2\u0153\u0155\5:\36\2\u0154\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\7\4"+
		"\2\2\u0159\u015a\7?\2\2\u015a\u015b\5\62\32\2\u015b\u015c\7/\2\2\u015c"+
		"9\3\2\2\2\u015d\u015f\5\64\33\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2"+
		"\2\u015f\u0162\3\2\2\2\u0160\u0161\7=\2\2\u0161\u0163\5\62\32\2\u0162"+
		"\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\7?"+
		"\2\2\u0165\u0166\5\62\32\2\u0166;\3\2\2\2\u0167\u0168\b\37\1\2\u0168\u0169"+
		"\7M\2\2\u0169\u0187\5<\37\20\u016a\u016b\7N\2\2\u016b\u0187\5<\37\17\u016c"+
		"\u016d\7$\2\2\u016d\u0172\5> \2\u016e\u016f\7\26\2\2\u016f\u0171\5> \2"+
		"\u0170\u016e\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173"+
		"\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176\7J\2\2\u0176"+
		"\u0177\5<\37\3\u0177\u0187\3\2\2\2\u0178\u0187\7Y\2\2\u0179\u0187\5P)"+
		"\2\u017a\u017b\7\23\2\2\u017b\u017c\5<\37\2\u017c\u017d\7K\2\2\u017d\u0187"+
		"\3\2\2\2\u017e\u017f\7\61\2\2\u017f\u0180\5<\37\2\u0180\u0181\7&\2\2\u0181"+
		"\u0182\5<\37\2\u0182\u0183\7I\2\2\u0183\u0184\5<\37\2\u0184\u0185\7\3"+
		"\2\2\u0185\u0187\3\2\2\2\u0186\u0167\3\2\2\2\u0186\u016a\3\2\2\2\u0186"+
		"\u016c\3\2\2\2\u0186\u0178\3\2\2\2\u0186\u0179\3\2\2\2\u0186\u017a\3\2"+
		"\2\2\u0186\u017e\3\2\2\2\u0187\u01a3\3\2\2\2\u0188\u0189\f\16\2\2\u0189"+
		"\u018a\7T\2\2\u018a\u01a2\5<\37\17\u018b\u018c\f\r\2\2\u018c\u018d\5@"+
		"!\2\u018d\u018e\5<\37\16\u018e\u01a2\3\2\2\2\u018f\u0190\f\f\2\2\u0190"+
		"\u0191\5B\"\2\u0191\u0192\5<\37\r\u0192\u01a2\3\2\2\2\u0193\u0194\f\13"+
		"\2\2\u0194\u0195\7L\2\2\u0195\u01a2\5<\37\f\u0196\u0197\f\n\2\2\u0197"+
		"\u0198\7G\2\2\u0198\u01a2\5<\37\13\u0199\u019a\f\t\2\2\u019a\u019b\7F"+
		"\2\2\u019b\u01a2\5<\37\n\u019c\u019d\f\b\2\2\u019d\u019e\7\22\2\2\u019e"+
		"\u01a2\5<\37\t\u019f\u01a0\f\21\2\2\u01a0\u01a2\5D#\2\u01a1\u0188\3\2"+
		"\2\2\u01a1\u018b\3\2\2\2\u01a1\u018f\3\2\2\2\u01a1\u0193\3\2\2\2\u01a1"+
		"\u0196\3\2\2\2\u01a1\u0199\3\2\2\2\u01a1\u019c\3\2\2\2\u01a1\u019f\3\2"+
		"\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"=\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a9\7Y\2\2\u01a7\u01a8\7?\2\2\u01a8"+
		"\u01aa\5R*\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2"+
		"\2\u01ab\u01ac\7\r\2\2\u01ac\u01ad\5<\37\2\u01ad?\3\2\2\2\u01ae\u01af"+
		"\t\5\2\2\u01afA\3\2\2\2\u01b0\u01b1\t\6\2\2\u01b1C\3\2\2\2\u01b2\u01b3"+
		"\7:\2\2\u01b3\u01b9\7Y\2\2\u01b4\u01b5\7:\2\2\u01b5\u01b9\5F$\2\u01b6"+
		"\u01b7\7<\2\2\u01b7\u01b9\5F$\2\u01b8\u01b2\3\2\2\2\u01b8\u01b4\3\2\2"+
		"\2\u01b8\u01b6\3\2\2\2\u01b9E\3\2\2\2\u01ba\u01bb\5J&\2\u01bb\u01bc\7"+
		"\23\2\2\u01bc\u01bd\5N(\2\u01bd\u01be\5H%\2\u01be\u01bf\7K\2\2\u01bf\u01c6"+
		"\3\2\2\2\u01c0\u01c1\7Y\2\2\u01c1\u01c2\7\23\2\2\u01c2\u01c3\5L\'\2\u01c3"+
		"\u01c4\7K\2\2\u01c4\u01c6\3\2\2\2\u01c5\u01ba\3\2\2\2\u01c5\u01c0\3\2"+
		"\2\2\u01c6G\3\2\2\2\u01c7\u01c8\5<\37\2\u01c8I\3\2\2\2\u01c9\u01ca\t\7"+
		"\2\2\u01caK\3\2\2\2\u01cb\u01d0\5<\37\2\u01cc\u01cd\7\26\2\2\u01cd\u01cf"+
		"\5<\37\2\u01ce\u01cc\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01cb\3\2"+
		"\2\2\u01d3\u01d4\3\2\2\2\u01d4M\3\2\2\2\u01d5\u01d8\7Y\2\2\u01d6\u01d7"+
		"\7?\2\2\u01d7\u01d9\5R*\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\3\2\2\2\u01da\u01db\7A\2\2\u01dbO\3\2\2\2\u01dc\u01f6\7W\2\2\u01dd"+
		"\u01f6\7X\2\2\u01de\u01f6\7U\2\2\u01df\u01f6\7V\2\2\u01e0\u01f6\7*\2\2"+
		"\u01e1\u01f6\7\27\2\2\u01e2\u01f6\7\20\2\2\u01e3\u01e4\7!\2\2\u01e4\u01e5"+
		"\5L\'\2\u01e5\u01e6\7/\2\2\u01e6\u01f6\3\2\2\2\u01e7\u01e8\7>\2\2\u01e8"+
		"\u01e9\5L\'\2\u01e9\u01ea\7/\2\2\u01ea\u01f6\3\2\2\2\u01eb\u01ec\7Y\2"+
		"\2\u01ec\u01ed\7\n\2\2\u01ed\u01ee\7Y\2\2\u01ee\u01ef\7\n\2\2\u01ef\u01f6"+
		"\7Y\2\2\u01f0\u01f1\7Y\2\2\u01f1\u01f2\7\n\2\2\u01f2\u01f3\7Y\2\2\u01f3"+
		"\u01f6\7?\2\2\u01f4\u01f6\5R*\2\u01f5\u01dc\3\2\2\2\u01f5\u01dd\3\2\2"+
		"\2\u01f5\u01de\3\2\2\2\u01f5\u01df\3\2\2\2\u01f5\u01e0\3\2\2\2\u01f5\u01e1"+
		"\3\2\2\2\u01f5\u01e2\3\2\2\2\u01f5\u01e3\3\2\2\2\u01f5\u01e7\3\2\2\2\u01f5"+
		"\u01eb\3\2\2\2\u01f5\u01f0\3\2\2\2\u01f5\u01f4\3\2\2\2\u01f6Q\3\2\2\2"+
		"\u01f7\u0210\7\35\2\2\u01f8\u0210\7-\2\2\u01f9\u0210\7\31\2\2\u01fa\u0210"+
		"\7;\2\2\u01fb\u01fc\7\30\2\2\u01fc\u01fd\5R*\2\u01fd\u01fe\7K\2\2\u01fe"+
		"\u0210\3\2\2\2\u01ff\u0200\7\17\2\2\u0200\u0201\5R*\2\u0201\u0202\7K\2"+
		"\2\u0202\u0210\3\2\2\2\u0203\u0210\5T+\2\u0204\u0205\7\t\2\2\u0205\u020a"+
		"\5T+\2\u0206\u0207\7A\2\2\u0207\u0209\5T+\2\u0208\u0206\3\2\2\2\u0209"+
		"\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\3\2"+
		"\2\2\u020c\u020a\3\2\2\2\u020d\u020e\7/\2\2\u020e\u0210\3\2\2\2\u020f"+
		"\u01f7\3\2\2\2\u020f\u01f8\3\2\2\2\u020f\u01f9\3\2\2\2\u020f\u01fa\3\2"+
		"\2\2\u020f\u01fb\3\2\2\2\u020f\u01ff\3\2\2\2\u020f\u0203\3\2\2\2\u020f"+
		"\u0204\3\2\2\2\u0210S\3\2\2\2\u0211\u0212\7Y\2\2\u0212\u0213\7\n\2\2\u0213"+
		"\u0217\7Y\2\2\u0214\u0215\7Y\2\2\u0215\u0217\7?\2\2\u0216\u0211\3\2\2"+
		"\2\u0216\u0214\3\2\2\2\u0217U\3\2\2\2\60\\bhw~\u0089\u008c\u0092\u0098"+
		"\u00a3\u00a9\u00b1\u00b9\u00c6\u00cd\u00d0\u00d3\u00d9\u00ec\u00f2\u0113"+
		"\u011a\u011d\u0128\u0135\u013d\u0140\u0147\u014e\u0156\u015e\u0162\u0172"+
		"\u0186\u01a1\u01a3\u01a9\u01b8\u01c5\u01d0\u01d3\u01d8\u01f5\u020a\u020f"+
		"\u0216";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}