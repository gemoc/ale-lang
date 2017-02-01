// Generated from XtdAQL.g4 by ANTLR 4.3
package parser;

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
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__59=1, T__58=2, T__57=3, T__56=4, T__55=5, T__54=6, T__53=7, T__52=8, 
		T__51=9, T__50=10, T__49=11, T__48=12, T__47=13, T__46=14, T__45=15, T__44=16, 
		T__43=17, T__42=18, T__41=19, T__40=20, T__39=21, T__38=22, T__37=23, 
		T__36=24, T__35=25, T__34=26, T__33=27, T__32=28, T__31=29, T__30=30, 
		T__29=31, T__28=32, T__27=33, T__26=34, T__25=35, T__24=36, T__23=37, 
		T__22=38, T__21=39, T__20=40, T__19=41, T__18=42, T__17=43, T__16=44, 
		T__15=45, T__14=46, T__13=47, T__12=48, T__11=49, T__10=50, T__9=51, T__8=52, 
		T__7=53, T__6=54, T__5=55, T__4=56, T__3=57, T__2=58, T__1=59, T__0=60, 
		COMMENT=61, LINECOMMENT=62, STRING=63, WS=64, MultOp=65, Integer=66, Real=67, 
		String=68, ErrorString=69, Ident=70;
	public static final String[] tokenNames = {
		"<INVALID>", "'endif'", "'!='", "'while'", "'{'", "'::'", "'one'", "'='", 
		"'for'", "'OrderedSet('", "'null'", "'implies'", "'('", "'closure'", "','", 
		"'false'", "'Sequence('", "'Real'", "'reject'", "'>='", "'String'", "'<'", 
		"'forAll'", "'Sequence{'", "'<>'", "'let'", "'+'", "'then'", "'@main'", 
		"'def'", "'true'", "'class'", "';'", "'Integer'", "'any'", "'}'", "'if'", 
		"':='", "'<='", "'sortedBy'", "'isUnique'", "'collect'", "'exists'", "'.'", 
		"'Boolean'", "'->'", "'OrderedSet{'", "':'", "'|'", "'=='", "'select'", 
		"'>'", "'xor'", "'or'", "'else'", "'in'", "')'", "'and'", "'not'", "'-'", 
		"'import'", "COMMENT", "LINECOMMENT", "STRING", "WS", "MultOp", "Integer", 
		"Real", "String", "ErrorString", "Ident"
	};
	public static final int
		RULE_rRoot = 0, RULE_rImports = 1, RULE_rClass = 2, RULE_rOperation = 3, 
		RULE_rParameters = 4, RULE_rVariable = 5, RULE_rAttribute = 6, RULE_rStatement = 7, 
		RULE_rVarDecl = 8, RULE_rAssign = 9, RULE_rForEach = 10, RULE_rBlock = 11, 
		RULE_rIf = 12, RULE_rWhile = 13, RULE_rExpression = 14, RULE_expression = 15, 
		RULE_binding = 16, RULE_addOp = 17, RULE_compOp = 18, RULE_navigationSegment = 19, 
		RULE_callExp = 20, RULE_lambdaExpression = 21, RULE_collectionIterator = 22, 
		RULE_expressionSequence = 23, RULE_variableDefinition = 24, RULE_literal = 25, 
		RULE_typeLiteral = 26, RULE_classifierTypeRule = 27;
	public static final String[] ruleNames = {
		"rRoot", "rImports", "rClass", "rOperation", "rParameters", "rVariable", 
		"rAttribute", "rStatement", "rVarDecl", "rAssign", "rForEach", "rBlock", 
		"rIf", "rWhile", "rExpression", "expression", "binding", "addOp", "compOp", 
		"navigationSegment", "callExp", "lambdaExpression", "collectionIterator", 
		"expressionSequence", "variableDefinition", "literal", "typeLiteral", 
		"classifierTypeRule"
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
		public RClassContext rClass(int i) {
			return getRuleContext(RClassContext.class,i);
		}
		public RImportsContext rImports() {
			return getRuleContext(RImportsContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRRoot(this);
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
			setState(56); rImports();
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(57); rClass();
				}
				}
				setState(62);
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

	public static class RImportsContext extends ParserRuleContext {
		public TerminalNode STRING(int i) {
			return getToken(XtdAQLParser.STRING, i);
		}
		public List<TerminalNode> STRING() { return getTokens(XtdAQLParser.STRING); }
		public RImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rImports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RImportsContext rImports() throws RecognitionException {
		RImportsContext _localctx = new RImportsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rImports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(63); match(T__0);
				setState(64); match(STRING);
				}
				}
				setState(69);
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

	public static class RClassContext extends ParserRuleContext {
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RClassContext rClass() throws RecognitionException {
		RClassContext _localctx = new RClassContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(T__29);
			setState(71); match(Ident);
			setState(72); match(T__56);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Ident) {
				{
				{
				setState(73); rAttribute();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32 || _la==T__31) {
				{
				{
				setState(79); rOperation();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85); match(T__25);
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
		public TerminalNode Ident() { return getToken(XtdAQLParser.Ident, 0); }
		public RParametersContext rParameters() {
			return getRuleContext(RParametersContext.class,0);
		}
		public RBlockContext rBlock() {
			return getRuleContext(RBlockContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitROperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ROperationContext rOperation() throws RecognitionException {
		ROperationContext _localctx = new ROperationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(87); match(T__32);
				}
			}

			setState(90); match(T__31);
			setState(91); match(Ident);
			setState(92); match(T__48);
			setState(94);
			_la = _input.LA(1);
			if (_la==Ident) {
				{
				setState(93); rParameters();
				}
			}

			setState(96); match(T__4);
			setState(97); rBlock();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RParametersContext rParameters() throws RecognitionException {
		RParametersContext _localctx = new RParametersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); rVariable();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__46) {
				{
				{
				setState(100); match(T__46);
				setState(101); rVariable();
				}
				}
				setState(106);
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
		public List<TerminalNode> Ident() { return getTokens(XtdAQLParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(XtdAQLParser.Ident, i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RVariableContext rVariable() throws RecognitionException {
		RVariableContext _localctx = new RVariableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); match(Ident);
			setState(108); match(Ident);
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
		public List<TerminalNode> Ident() { return getTokens(XtdAQLParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(XtdAQLParser.Ident, i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RAttributeContext rAttribute() throws RecognitionException {
		RAttributeContext _localctx = new RAttributeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(Ident);
			setState(111); match(Ident);
			setState(114);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(112); match(T__23);
				setState(113); expression(0);
				}
			}

			setState(116); match(T__28);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RStatementContext rStatement() throws RecognitionException {
		RStatementContext _localctx = new RStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rStatement);
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118); rVarDecl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119); rAssign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120); rForEach();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(121); rWhile();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(122); rIf();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(123); rExpression();
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
		public List<TerminalNode> Ident() { return getTokens(XtdAQLParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(XtdAQLParser.Ident, i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RVarDeclContext rVarDecl() throws RecognitionException {
		RVarDeclContext _localctx = new RVarDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rVarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(Ident);
			setState(127); match(Ident);
			{
			setState(128); match(T__23);
			setState(129); expression(0);
			}
			setState(131); match(T__28);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RAssignContext rAssign() throws RecognitionException {
		RAssignContext _localctx = new RAssignContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); expression(0);
			setState(134); match(T__23);
			setState(135); expression(0);
			setState(136); match(T__28);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRForEach(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RForEachContext rForEach() throws RecognitionException {
		RForEachContext _localctx = new RForEachContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rForEach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(T__52);
			setState(139); match(T__48);
			setState(140); match(Ident);
			setState(141); match(T__5);
			setState(142); expression(0);
			setState(143); match(T__4);
			setState(144); rBlock();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RBlockContext rBlock() throws RecognitionException {
		RBlockContext _localctx = new RBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(T__56);
			setState(154);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__57) | (1L << T__56) | (1L << T__52) | (1L << T__51) | (1L << T__50) | (1L << T__48) | (1L << T__45) | (1L << T__44) | (1L << T__43) | (1L << T__40) | (1L << T__37) | (1L << T__35) | (1L << T__30) | (1L << T__27) | (1L << T__24) | (1L << T__16) | (1L << T__14) | (1L << T__2) | (1L << T__1))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (Integer - 66)) | (1L << (Real - 66)) | (1L << (String - 66)) | (1L << (ErrorString - 66)) | (1L << (Ident - 66)))) != 0)) {
				{
				setState(147); rStatement();
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__57) | (1L << T__56) | (1L << T__52) | (1L << T__51) | (1L << T__50) | (1L << T__48) | (1L << T__45) | (1L << T__44) | (1L << T__43) | (1L << T__40) | (1L << T__37) | (1L << T__35) | (1L << T__30) | (1L << T__27) | (1L << T__24) | (1L << T__16) | (1L << T__14) | (1L << T__2) | (1L << T__1))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (Integer - 66)) | (1L << (Real - 66)) | (1L << (String - 66)) | (1L << (ErrorString - 66)) | (1L << (Ident - 66)))) != 0)) {
					{
					{
					setState(148); rStatement();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(156); match(T__25);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RIfContext rIf() throws RecognitionException {
		RIfContext _localctx = new RIfContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); match(T__24);
			setState(159); match(T__48);
			setState(160); expression(0);
			setState(161); match(T__4);
			setState(162); rBlock();
			setState(165);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(163); match(T__6);
				setState(164); rBlock();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RWhileContext rWhile() throws RecognitionException {
		RWhileContext _localctx = new RWhileContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); match(T__57);
			setState(168); match(T__48);
			setState(169); expression(0);
			setState(170); match(T__4);
			setState(171); rBlock();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RExpressionContext rExpression() throws RecognitionException {
		RExpressionContext _localctx = new RExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); expression(0);
			setState(174); match(T__28);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitVarRef(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitAdd(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterNav(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitNav(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitNav(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitOr(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterLetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitLetExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitLetExpr(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitConditional(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitComp(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitNot(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitMin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitMin(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitImplies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitImplies(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitMult(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitLit(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitAnd(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitXor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitXor(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitParen(this);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(177); match(T__2);
				setState(178); expression(14);
				}
				break;

			case 2:
				{
				_localctx = new MinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179); match(T__1);
				setState(180); expression(13);
				}
				break;

			case 3:
				{
				_localctx = new LetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181); match(T__35);
				setState(182); binding();
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__46) {
					{
					{
					setState(183); match(T__46);
					setState(184); binding();
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(190); match(T__5);
				setState(191); expression(1);
				}
				break;

			case 4:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193); match(Ident);
				}
				break;

			case 5:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194); literal();
				}
				break;

			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195); match(T__48);
				setState(196); expression(0);
				setState(197); match(T__4);
				}
				break;

			case 7:
				{
				_localctx = new ConditionalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199); match(T__24);
				setState(200); expression(0);
				setState(201); match(T__33);
				setState(202); expression(0);
				setState(203); match(T__6);
				setState(204); expression(0);
				setState(205); match(T__59);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(234);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(210); match(MultOp);
						setState(211); expression(13);
						}
						break;

					case 2:
						{
						_localctx = new AddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(212);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(213); addOp();
						setState(214); expression(12);
						}
						break;

					case 3:
						{
						_localctx = new CompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(217); compOp();
						setState(218); expression(11);
						}
						break;

					case 4:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(221); match(T__3);
						setState(222); expression(10);
						}
						break;

					case 5:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(224); match(T__7);
						setState(225); expression(9);
						}
						break;

					case 6:
						{
						_localctx = new XorContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(227); match(T__8);
						setState(228); expression(8);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(230); match(T__49);
						setState(231); expression(7);
						}
						break;

					case 8:
						{
						_localctx = new NavContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(232);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(233); navigationSegment();
						}
						break;
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(Ident);
			setState(242);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(240); match(T__13);
				setState(241); typeLiteral();
				}
			}

			setState(244); match(T__53);
			setState(245); expression(0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitAddOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_la = _input.LA(1);
			if ( !(_la==T__34 || _la==T__1) ) {
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__58) | (1L << T__53) | (1L << T__41) | (1L << T__39) | (1L << T__36) | (1L << T__22) | (1L << T__11) | (1L << T__9))) != 0)) ) {
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitCallOrApply(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterCollectionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitCollectionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitCollectionCall(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NavigationSegmentContext navigationSegment() throws RecognitionException {
		NavigationSegmentContext _localctx = new NavigationSegmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_navigationSegment);
		try {
			setState(257);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new FeatureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(251); match(T__17);
				setState(252); match(Ident);
				}
				break;

			case 2:
				_localctx = new CallOrApplyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(253); match(T__17);
				setState(254); callExp();
				}
				break;

			case 3:
				_localctx = new CollectionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(255); match(T__15);
				setState(256); callExp();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitServiceCall(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterIterationCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitIterationCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitIterationCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallExpContext callExp() throws RecognitionException {
		CallExpContext _localctx = new CallExpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_callExp);
		try {
			setState(270);
			switch (_input.LA(1)) {
			case T__54:
			case T__47:
			case T__42:
			case T__38:
			case T__26:
			case T__21:
			case T__20:
			case T__19:
			case T__18:
			case T__10:
				_localctx = new IterationCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259); collectionIterator();
				setState(260); match(T__48);
				setState(261); variableDefinition();
				setState(262); lambdaExpression();
				setState(263); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ServiceCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265); match(Ident);
				setState(266); match(T__48);
				setState(267); expressionSequence();
				setState(268); match(T__4);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitLambdaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); expression(0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitCollectionIterator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionIteratorContext collectionIterator() throws RecognitionException {
		CollectionIteratorContext _localctx = new CollectionIteratorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_collectionIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__54) | (1L << T__47) | (1L << T__42) | (1L << T__38) | (1L << T__26) | (1L << T__21) | (1L << T__20) | (1L << T__19) | (1L << T__18) | (1L << T__10))) != 0)) ) {
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitExpressionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
		ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expressionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__56) | (1L << T__51) | (1L << T__50) | (1L << T__48) | (1L << T__45) | (1L << T__44) | (1L << T__43) | (1L << T__40) | (1L << T__37) | (1L << T__35) | (1L << T__30) | (1L << T__27) | (1L << T__24) | (1L << T__16) | (1L << T__14) | (1L << T__2) | (1L << T__1))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (Integer - 66)) | (1L << (Real - 66)) | (1L << (String - 66)) | (1L << (ErrorString - 66)) | (1L << (Ident - 66)))) != 0)) {
				{
				setState(276); expression(0);
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__46) {
					{
					{
					setState(277); match(T__46);
					setState(278); expression(0);
					}
					}
					setState(283);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); match(Ident);
			setState(289);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(287); match(T__13);
				setState(288); typeLiteral();
				}
			}

			setState(291); match(T__12);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitEnumLit(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitNullLit(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterTypeLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitTypeLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitTypeLit(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitIntegerLit(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRealLit(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitErrorEnumLit(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitFalseLit(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitTrueLit(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterExplicitSetLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitExplicitSetLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitExplicitSetLit(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterExplicitSeqLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitExplicitSeqLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitExplicitSeqLit(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitErrorStringLit(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitStringLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_literal);
		try {
			setState(318);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new StringLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(293); match(String);
				}
				break;

			case 2:
				_localctx = new ErrorStringLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(294); match(ErrorString);
				}
				break;

			case 3:
				_localctx = new IntegerLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(295); match(Integer);
				}
				break;

			case 4:
				_localctx = new RealLitContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(296); match(Real);
				}
				break;

			case 5:
				_localctx = new TrueLitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(297); match(T__30);
				}
				break;

			case 6:
				_localctx = new FalseLitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(298); match(T__45);
				}
				break;

			case 7:
				_localctx = new NullLitContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(299); match(T__50);
				}
				break;

			case 8:
				_localctx = new ExplicitSeqLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(300); match(T__37);
				setState(301); expressionSequence();
				setState(302); match(T__25);
				}
				break;

			case 9:
				_localctx = new ExplicitSetLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(304); match(T__14);
				setState(305); expressionSequence();
				setState(306); match(T__25);
				}
				break;

			case 10:
				_localctx = new EnumLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(308); match(Ident);
				setState(309); match(T__55);
				setState(310); match(Ident);
				setState(311); match(T__55);
				setState(312); match(Ident);
				}
				break;

			case 11:
				_localctx = new ErrorEnumLitContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(313); match(Ident);
				setState(314); match(T__55);
				setState(315); match(Ident);
				setState(316); match(T__13);
				}
				break;

			case 12:
				_localctx = new TypeLitContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(317); typeLiteral();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitClassifierSetType(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitSetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitSetType(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterSeqType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitSeqType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitSeqType(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitBooleanType(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRealType(this);
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
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterClsType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitClsType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitClsType(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitStrType(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeLiteralContext typeLiteral() throws RecognitionException {
		TypeLiteralContext _localctx = new TypeLiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_typeLiteral);
		int _la;
		try {
			setState(344);
			switch (_input.LA(1)) {
			case T__40:
				_localctx = new StrTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(320); match(T__40);
				}
				break;
			case T__27:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(321); match(T__27);
				}
				break;
			case T__43:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(322); match(T__43);
				}
				break;
			case T__16:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(323); match(T__16);
				}
				break;
			case T__44:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(324); match(T__44);
				setState(325); typeLiteral();
				setState(326); match(T__4);
				}
				break;
			case T__51:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(328); match(T__51);
				setState(329); typeLiteral();
				setState(330); match(T__4);
				}
				break;
			case Ident:
				_localctx = new ClsTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(332); classifierTypeRule();
				}
				break;
			case T__56:
				_localctx = new ClassifierSetTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(333); match(T__56);
				setState(334); classifierTypeRule();
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(335); match(T__12);
					setState(336); classifierTypeRule();
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(342); match(T__25);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitClassifierType(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitErrorClassifierType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassifierTypeRuleContext classifierTypeRule() throws RecognitionException {
		ClassifierTypeRuleContext _localctx = new ClassifierTypeRuleContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_classifierTypeRule);
		try {
			setState(351);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new ClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(346); match(Ident);
				setState(347); match(T__55);
				setState(348); match(Ident);
				}
				break;

			case 2:
				_localctx = new ErrorClassifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(349); match(Ident);
				setState(350); match(T__13);
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
		case 15: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3H\u0164\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\7\2=\n\2\f\2\16\2@\13"+
		"\2\3\3\3\3\7\3D\n\3\f\3\16\3G\13\3\3\4\3\4\3\4\3\4\7\4M\n\4\f\4\16\4P"+
		"\13\4\3\4\7\4S\n\4\f\4\16\4V\13\4\3\4\3\4\3\5\5\5[\n\5\3\5\3\5\3\5\3\5"+
		"\5\5a\n\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6i\n\6\f\6\16\6l\13\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\5\bu\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\177\n\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u0098\n\r\f\r\16\r\u009b\13\r\5\r\u009d"+
		"\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a8\n\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\7\21\u00bc\n\21\f\21\16\21\u00bf\13\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5"+
		"\21\u00d2\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\7\21\u00ed\n\21\f\21\16\21\u00f0\13\21\3\22\3\22\3\22\5\22\u00f5\n\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u0104\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u0111\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\7\31\u011a\n\31\f\31\16"+
		"\31\u011d\13\31\5\31\u011f\n\31\3\32\3\32\3\32\5\32\u0124\n\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0141"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\7\34\u0154\n\34\f\34\16\34\u0157\13\34\3\34\3\34"+
		"\5\34\u015b\n\34\3\35\3\35\3\35\3\35\3\35\5\35\u0162\n\35\3\35\2\3 \36"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\5\4\2"+
		"\34\34==\n\2\4\4\t\t\25\25\27\27\32\32((\63\63\65\65\t\2\b\b\17\17\24"+
		"\24\30\30$$),\64\64\u0181\2:\3\2\2\2\4E\3\2\2\2\6H\3\2\2\2\bZ\3\2\2\2"+
		"\ne\3\2\2\2\fm\3\2\2\2\16p\3\2\2\2\20~\3\2\2\2\22\u0080\3\2\2\2\24\u0087"+
		"\3\2\2\2\26\u008c\3\2\2\2\30\u0094\3\2\2\2\32\u00a0\3\2\2\2\34\u00a9\3"+
		"\2\2\2\36\u00af\3\2\2\2 \u00d1\3\2\2\2\"\u00f1\3\2\2\2$\u00f9\3\2\2\2"+
		"&\u00fb\3\2\2\2(\u0103\3\2\2\2*\u0110\3\2\2\2,\u0112\3\2\2\2.\u0114\3"+
		"\2\2\2\60\u011e\3\2\2\2\62\u0120\3\2\2\2\64\u0140\3\2\2\2\66\u015a\3\2"+
		"\2\28\u0161\3\2\2\2:>\5\4\3\2;=\5\6\4\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2"+
		">?\3\2\2\2?\3\3\2\2\2@>\3\2\2\2AB\7>\2\2BD\7A\2\2CA\3\2\2\2DG\3\2\2\2"+
		"EC\3\2\2\2EF\3\2\2\2F\5\3\2\2\2GE\3\2\2\2HI\7!\2\2IJ\7H\2\2JN\7\6\2\2"+
		"KM\5\16\b\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OT\3\2\2\2PN\3\2\2"+
		"\2QS\5\b\5\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2"+
		"\2WX\7%\2\2X\7\3\2\2\2Y[\7\36\2\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7"+
		"\37\2\2]^\7H\2\2^`\7\16\2\2_a\5\n\6\2`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc"+
		"\7:\2\2cd\5\30\r\2d\t\3\2\2\2ej\5\f\7\2fg\7\20\2\2gi\5\f\7\2hf\3\2\2\2"+
		"il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\13\3\2\2\2lj\3\2\2\2mn\7H\2\2no\7H\2\2"+
		"o\r\3\2\2\2pq\7H\2\2qt\7H\2\2rs\7\'\2\2su\5 \21\2tr\3\2\2\2tu\3\2\2\2"+
		"uv\3\2\2\2vw\7\"\2\2w\17\3\2\2\2x\177\5\22\n\2y\177\5\24\13\2z\177\5\26"+
		"\f\2{\177\5\34\17\2|\177\5\32\16\2}\177\5\36\20\2~x\3\2\2\2~y\3\2\2\2"+
		"~z\3\2\2\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\21\3\2\2\2\u0080\u0081\7"+
		"H\2\2\u0081\u0082\7H\2\2\u0082\u0083\7\'\2\2\u0083\u0084\5 \21\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\7\"\2\2\u0086\23\3\2\2\2\u0087\u0088\5 \21"+
		"\2\u0088\u0089\7\'\2\2\u0089\u008a\5 \21\2\u008a\u008b\7\"\2\2\u008b\25"+
		"\3\2\2\2\u008c\u008d\7\n\2\2\u008d\u008e\7\16\2\2\u008e\u008f\7H\2\2\u008f"+
		"\u0090\79\2\2\u0090\u0091\5 \21\2\u0091\u0092\7:\2\2\u0092\u0093\5\30"+
		"\r\2\u0093\27\3\2\2\2\u0094\u009c\7\6\2\2\u0095\u0099\5\20\t\2\u0096\u0098"+
		"\5\20\t\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u0095"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7%\2\2\u009f"+
		"\31\3\2\2\2\u00a0\u00a1\7&\2\2\u00a1\u00a2\7\16\2\2\u00a2\u00a3\5 \21"+
		"\2\u00a3\u00a4\7:\2\2\u00a4\u00a7\5\30\r\2\u00a5\u00a6\78\2\2\u00a6\u00a8"+
		"\5\30\r\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\33\3\2\2\2\u00a9"+
		"\u00aa\7\5\2\2\u00aa\u00ab\7\16\2\2\u00ab\u00ac\5 \21\2\u00ac\u00ad\7"+
		":\2\2\u00ad\u00ae\5\30\r\2\u00ae\35\3\2\2\2\u00af\u00b0\5 \21\2\u00b0"+
		"\u00b1\7\"\2\2\u00b1\37\3\2\2\2\u00b2\u00b3\b\21\1\2\u00b3\u00b4\7<\2"+
		"\2\u00b4\u00d2\5 \21\20\u00b5\u00b6\7=\2\2\u00b6\u00d2\5 \21\17\u00b7"+
		"\u00b8\7\33\2\2\u00b8\u00bd\5\"\22\2\u00b9\u00ba\7\20\2\2\u00ba\u00bc"+
		"\5\"\22\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2"+
		"\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1"+
		"\79\2\2\u00c1\u00c2\5 \21\3\u00c2\u00d2\3\2\2\2\u00c3\u00d2\7H\2\2\u00c4"+
		"\u00d2\5\64\33\2\u00c5\u00c6\7\16\2\2\u00c6\u00c7\5 \21\2\u00c7\u00c8"+
		"\7:\2\2\u00c8\u00d2\3\2\2\2\u00c9\u00ca\7&\2\2\u00ca\u00cb\5 \21\2\u00cb"+
		"\u00cc\7\35\2\2\u00cc\u00cd\5 \21\2\u00cd\u00ce\78\2\2\u00ce\u00cf\5 "+
		"\21\2\u00cf\u00d0\7\3\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00b2\3\2\2\2\u00d1"+
		"\u00b5\3\2\2\2\u00d1\u00b7\3\2\2\2\u00d1\u00c3\3\2\2\2\u00d1\u00c4\3\2"+
		"\2\2\u00d1\u00c5\3\2\2\2\u00d1\u00c9\3\2\2\2\u00d2\u00ee\3\2\2\2\u00d3"+
		"\u00d4\f\16\2\2\u00d4\u00d5\7C\2\2\u00d5\u00ed\5 \21\17\u00d6\u00d7\f"+
		"\r\2\2\u00d7\u00d8\5$\23\2\u00d8\u00d9\5 \21\16\u00d9\u00ed\3\2\2\2\u00da"+
		"\u00db\f\f\2\2\u00db\u00dc\5&\24\2\u00dc\u00dd\5 \21\r\u00dd\u00ed\3\2"+
		"\2\2\u00de\u00df\f\13\2\2\u00df\u00e0\7;\2\2\u00e0\u00ed\5 \21\f\u00e1"+
		"\u00e2\f\n\2\2\u00e2\u00e3\7\67\2\2\u00e3\u00ed\5 \21\13\u00e4\u00e5\f"+
		"\t\2\2\u00e5\u00e6\7\66\2\2\u00e6\u00ed\5 \21\n\u00e7\u00e8\f\b\2\2\u00e8"+
		"\u00e9\7\r\2\2\u00e9\u00ed\5 \21\t\u00ea\u00eb\f\21\2\2\u00eb\u00ed\5"+
		"(\25\2\u00ec\u00d3\3\2\2\2\u00ec\u00d6\3\2\2\2\u00ec\u00da\3\2\2\2\u00ec"+
		"\u00de\3\2\2\2\u00ec\u00e1\3\2\2\2\u00ec\u00e4\3\2\2\2\u00ec\u00e7\3\2"+
		"\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef!\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f4\7H\2\2\u00f2"+
		"\u00f3\7\61\2\2\u00f3\u00f5\5\66\34\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\t\2\2\u00f7\u00f8\5 \21\2\u00f8"+
		"#\3\2\2\2\u00f9\u00fa\t\2\2\2\u00fa%\3\2\2\2\u00fb\u00fc\t\3\2\2\u00fc"+
		"\'\3\2\2\2\u00fd\u00fe\7-\2\2\u00fe\u0104\7H\2\2\u00ff\u0100\7-\2\2\u0100"+
		"\u0104\5*\26\2\u0101\u0102\7/\2\2\u0102\u0104\5*\26\2\u0103\u00fd\3\2"+
		"\2\2\u0103\u00ff\3\2\2\2\u0103\u0101\3\2\2\2\u0104)\3\2\2\2\u0105\u0106"+
		"\5.\30\2\u0106\u0107\7\16\2\2\u0107\u0108\5\62\32\2\u0108\u0109\5,\27"+
		"\2\u0109\u010a\7:\2\2\u010a\u0111\3\2\2\2\u010b\u010c\7H\2\2\u010c\u010d"+
		"\7\16\2\2\u010d\u010e\5\60\31\2\u010e\u010f\7:\2\2\u010f\u0111\3\2\2\2"+
		"\u0110\u0105\3\2\2\2\u0110\u010b\3\2\2\2\u0111+\3\2\2\2\u0112\u0113\5"+
		" \21\2\u0113-\3\2\2\2\u0114\u0115\t\4\2\2\u0115/\3\2\2\2\u0116\u011b\5"+
		" \21\2\u0117\u0118\7\20\2\2\u0118\u011a\5 \21\2\u0119\u0117\3\2\2\2\u011a"+
		"\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011f\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011e\u0116\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\61\3\2\2\2\u0120\u0123\7H\2\2\u0121\u0122\7\61\2\2\u0122\u0124\5\66\34"+
		"\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126"+
		"\7\62\2\2\u0126\63\3\2\2\2\u0127\u0141\7F\2\2\u0128\u0141\7G\2\2\u0129"+
		"\u0141\7D\2\2\u012a\u0141\7E\2\2\u012b\u0141\7 \2\2\u012c\u0141\7\21\2"+
		"\2\u012d\u0141\7\f\2\2\u012e\u012f\7\31\2\2\u012f\u0130\5\60\31\2\u0130"+
		"\u0131\7%\2\2\u0131\u0141\3\2\2\2\u0132\u0133\7\60\2\2\u0133\u0134\5\60"+
		"\31\2\u0134\u0135\7%\2\2\u0135\u0141\3\2\2\2\u0136\u0137\7H\2\2\u0137"+
		"\u0138\7\7\2\2\u0138\u0139\7H\2\2\u0139\u013a\7\7\2\2\u013a\u0141\7H\2"+
		"\2\u013b\u013c\7H\2\2\u013c\u013d\7\7\2\2\u013d\u013e\7H\2\2\u013e\u0141"+
		"\7\61\2\2\u013f\u0141\5\66\34\2\u0140\u0127\3\2\2\2\u0140\u0128\3\2\2"+
		"\2\u0140\u0129\3\2\2\2\u0140\u012a\3\2\2\2\u0140\u012b\3\2\2\2\u0140\u012c"+
		"\3\2\2\2\u0140\u012d\3\2\2\2\u0140\u012e\3\2\2\2\u0140\u0132\3\2\2\2\u0140"+
		"\u0136\3\2\2\2\u0140\u013b\3\2\2\2\u0140\u013f\3\2\2\2\u0141\65\3\2\2"+
		"\2\u0142\u015b\7\26\2\2\u0143\u015b\7#\2\2\u0144\u015b\7\23\2\2\u0145"+
		"\u015b\7.\2\2\u0146\u0147\7\22\2\2\u0147\u0148\5\66\34\2\u0148\u0149\7"+
		":\2\2\u0149\u015b\3\2\2\2\u014a\u014b\7\13\2\2\u014b\u014c\5\66\34\2\u014c"+
		"\u014d\7:\2\2\u014d\u015b\3\2\2\2\u014e\u015b\58\35\2\u014f\u0150\7\6"+
		"\2\2\u0150\u0155\58\35\2\u0151\u0152\7\62\2\2\u0152\u0154\58\35\2\u0153"+
		"\u0151\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\7%\2\2\u0159"+
		"\u015b\3\2\2\2\u015a\u0142\3\2\2\2\u015a\u0143\3\2\2\2\u015a\u0144\3\2"+
		"\2\2\u015a\u0145\3\2\2\2\u015a\u0146\3\2\2\2\u015a\u014a\3\2\2\2\u015a"+
		"\u014e\3\2\2\2\u015a\u014f\3\2\2\2\u015b\67\3\2\2\2\u015c\u015d\7H\2\2"+
		"\u015d\u015e\7\7\2\2\u015e\u0162\7H\2\2\u015f\u0160\7H\2\2\u0160\u0162"+
		"\7\61\2\2\u0161\u015c\3\2\2\2\u0161\u015f\3\2\2\2\u01629\3\2\2\2\34>E"+
		"NTZ`jt~\u0099\u009c\u00a7\u00bd\u00d1\u00ec\u00ee\u00f4\u0103\u0110\u011b"+
		"\u011e\u0123\u0140\u0155\u015a\u0161";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}