// Generated from XtdAQL.g4 by ANTLR 4.3
package parser;
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
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, ID=20, WS=21, COMMENT=22, LINECOMMENT=23, Expression=24, 
		STRING=25;
	public static final String[] tokenNames = {
		"<INVALID>", "'add'", "'remove'", "'def'", "'class'", "'while'", "';'", 
		"'{'", "'='", "'}'", "'if'", "'for'", "'else'", "'in'", "'('", "'put'", 
		"')'", "','", "'import'", "'.'", "ID", "WS", "COMMENT", "LINECOMMENT", 
		"Expression", "STRING"
	};
	public static final int
		RULE_rRoot = 0, RULE_rImports = 1, RULE_rClass = 2, RULE_rOperation = 3, 
		RULE_rParameters = 4, RULE_rVariable = 5, RULE_rStatement = 6, RULE_rAssign = 7, 
		RULE_rSet = 8, RULE_rInsert = 9, RULE_rRemove = 10, RULE_rPut = 11, RULE_rForEach = 12, 
		RULE_rBlock = 13, RULE_rIf = 14, RULE_rWhile = 15;
	public static final String[] ruleNames = {
		"rRoot", "rImports", "rClass", "rOperation", "rParameters", "rVariable", 
		"rStatement", "rAssign", "rSet", "rInsert", "rRemove", "rPut", "rForEach", 
		"rBlock", "rIf", "rWhile"
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
			setState(32); rImports();
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(33); rClass();
				}
				}
				setState(38);
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(39); match(T__1);
				setState(40); match(STRING);
				}
				}
				setState(45);
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
		public TerminalNode ID() { return getToken(XtdAQLParser.ID, 0); }
		public ROperationContext rOperation(int i) {
			return getRuleContext(ROperationContext.class,i);
		}
		public List<ROperationContext> rOperation() {
			return getRuleContexts(ROperationContext.class);
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
			setState(46); match(T__15);
			setState(47); match(ID);
			setState(48); match(T__12);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(49); rOperation();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55); match(T__10);
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
		public TerminalNode ID() { return getToken(XtdAQLParser.ID, 0); }
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
			setState(57); match(T__16);
			setState(58); match(ID);
			setState(59); match(T__5);
			setState(61);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(60); rParameters();
				}
			}

			setState(63); match(T__3);
			setState(64); rBlock();
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
			setState(66); rVariable();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(67); match(T__2);
				setState(68); rVariable();
				}
				}
				setState(73);
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
		public List<TerminalNode> ID() { return getTokens(XtdAQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(XtdAQLParser.ID, i);
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
			setState(74); match(ID);
			setState(75); match(ID);
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
		public RStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rStatement; }
	 
		public RStatementContext() { }
		public void copyFrom(RStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SetContext extends RStatementContext {
		public RSetContext rSet() {
			return getRuleContext(RSetContext.class,0);
		}
		public SetContext(RStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends RStatementContext {
		public RAssignContext rAssign() {
			return getRuleContext(RAssignContext.class,0);
		}
		public AssignContext(RStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RemoveContext extends RStatementContext {
		public RRemoveContext rRemove() {
			return getRuleContext(RRemoveContext.class,0);
		}
		public RemoveContext(RStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRemove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRemove(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends RStatementContext {
		public RWhileContext rWhile() {
			return getRuleContext(RWhileContext.class,0);
		}
		public WhileContext(RStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertContext extends RStatementContext {
		public RInsertContext rInsert() {
			return getRuleContext(RInsertContext.class,0);
		}
		public InsertContext(RStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitInsert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitInsert(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpContext extends RStatementContext {
		public TerminalNode Expression() { return getToken(XtdAQLParser.Expression, 0); }
		public ExpContext(RStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends RStatementContext {
		public RIfContext rIf() {
			return getRuleContext(RIfContext.class,0);
		}
		public IfContext(RStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PutContext extends RStatementContext {
		public RPutContext rPut() {
			return getRuleContext(RPutContext.class,0);
		}
		public PutContext(RStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterPut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitPut(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitPut(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForEachContext extends RStatementContext {
		public RForEachContext rForEach() {
			return getRuleContext(RForEachContext.class,0);
		}
		public ForEachContext(RStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterForEach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitForEach(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitForEach(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RStatementContext rStatement() throws RecognitionException {
		RStatementContext _localctx = new RStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rStatement);
		try {
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77); rAssign();
				}
				break;

			case 2:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78); rSet();
				}
				break;

			case 3:
				_localctx = new InsertContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79); rInsert();
				}
				break;

			case 4:
				_localctx = new RemoveContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(80); rRemove();
				}
				break;

			case 5:
				_localctx = new PutContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(81); rPut();
				}
				break;

			case 6:
				_localctx = new ForEachContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(82); rForEach();
				}
				break;

			case 7:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(83); rWhile();
				}
				break;

			case 8:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(84); rIf();
				}
				break;

			case 9:
				_localctx = new ExpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(85); match(Expression);
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

	public static class RAssignContext extends ParserRuleContext {
		public TerminalNode Expression() { return getToken(XtdAQLParser.Expression, 0); }
		public TerminalNode ID() { return getToken(XtdAQLParser.ID, 0); }
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
		enterRule(_localctx, 14, RULE_rAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(ID);
			setState(89); match(T__11);
			setState(90); match(Expression);
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

	public static class RSetContext extends ParserRuleContext {
		public List<TerminalNode> Expression() { return getTokens(XtdAQLParser.Expression); }
		public TerminalNode ID() { return getToken(XtdAQLParser.ID, 0); }
		public TerminalNode Expression(int i) {
			return getToken(XtdAQLParser.Expression, i);
		}
		public RSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RSetContext rSet() throws RecognitionException {
		RSetContext _localctx = new RSetContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); match(Expression);
			setState(93); match(T__0);
			setState(94); match(ID);
			setState(95); match(T__11);
			setState(96); match(Expression);
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
		public List<TerminalNode> Expression() { return getTokens(XtdAQLParser.Expression); }
		public TerminalNode ID() { return getToken(XtdAQLParser.ID, 0); }
		public TerminalNode Expression(int i) {
			return getToken(XtdAQLParser.Expression, i);
		}
		public RInsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rInsert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRInsert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRInsert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RInsertContext rInsert() throws RecognitionException {
		RInsertContext _localctx = new RInsertContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rInsert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(Expression);
			setState(99); match(T__0);
			setState(100); match(ID);
			setState(101); match(T__0);
			setState(102); match(T__18);
			setState(103); match(T__5);
			setState(104); match(Expression);
			setState(105); match(T__3);
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
		public List<TerminalNode> Expression() { return getTokens(XtdAQLParser.Expression); }
		public TerminalNode ID() { return getToken(XtdAQLParser.ID, 0); }
		public TerminalNode Expression(int i) {
			return getToken(XtdAQLParser.Expression, i);
		}
		public RRemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rRemove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRRemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRRemove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRRemove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RRemoveContext rRemove() throws RecognitionException {
		RRemoveContext _localctx = new RRemoveContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rRemove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); match(Expression);
			setState(108); match(T__0);
			setState(109); match(ID);
			setState(110); match(T__0);
			setState(111); match(T__17);
			setState(112); match(T__5);
			setState(113); match(Expression);
			setState(114); match(T__3);
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

	public static class RPutContext extends ParserRuleContext {
		public List<TerminalNode> Expression() { return getTokens(XtdAQLParser.Expression); }
		public TerminalNode ID() { return getToken(XtdAQLParser.ID, 0); }
		public TerminalNode Expression(int i) {
			return getToken(XtdAQLParser.Expression, i);
		}
		public RPutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rPut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).enterRPut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XtdAQLListener ) ((XtdAQLListener)listener).exitRPut(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XtdAQLVisitor ) return ((XtdAQLVisitor<? extends T>)visitor).visitRPut(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RPutContext rPut() throws RecognitionException {
		RPutContext _localctx = new RPutContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rPut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(Expression);
			setState(117); match(T__0);
			setState(118); match(ID);
			setState(119); match(T__0);
			setState(120); match(T__4);
			setState(121); match(T__5);
			setState(122); match(Expression);
			setState(123); match(T__2);
			setState(124); match(Expression);
			setState(125); match(T__3);
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
		public TerminalNode Expression() { return getToken(XtdAQLParser.Expression, 0); }
		public TerminalNode ID() { return getToken(XtdAQLParser.ID, 0); }
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
		enterRule(_localctx, 24, RULE_rForEach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(T__8);
			setState(128); match(T__5);
			setState(129); match(ID);
			setState(130); match(T__6);
			setState(131); match(Expression);
			setState(132); match(T__3);
			setState(133); rBlock();
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
		enterRule(_localctx, 26, RULE_rBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); match(T__12);
			setState(146);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__9) | (1L << T__8) | (1L << ID) | (1L << Expression))) != 0)) {
				{
				setState(136); rStatement();
				setState(137); match(T__13);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__9) | (1L << T__8) | (1L << ID) | (1L << Expression))) != 0)) {
					{
					{
					setState(138); rStatement();
					setState(139); match(T__13);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(148); match(T__10);
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
		public TerminalNode Expression() { return getToken(XtdAQLParser.Expression, 0); }
		public RBlockContext rBlock(int i) {
			return getRuleContext(RBlockContext.class,i);
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
		enterRule(_localctx, 28, RULE_rIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(T__9);
			setState(151); match(T__5);
			setState(152); match(Expression);
			setState(153); match(T__3);
			setState(154); rBlock();
			setState(157);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(155); match(T__7);
				setState(156); rBlock();
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
		public TerminalNode Expression() { return getToken(XtdAQLParser.Expression, 0); }
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
		enterRule(_localctx, 30, RULE_rWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(T__14);
			setState(160); match(T__5);
			setState(161); match(Expression);
			setState(162); match(T__3);
			setState(163); rBlock();
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u00a8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\4\3\4\3\4\3"+
		"\4\7\4\65\n\4\f\4\16\48\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5@\n\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\bY\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0090\n\17"+
		"\f\17\16\17\u0093\13\17\5\17\u0095\n\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00a0\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\2\2"+
		"\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\u00a7\2\"\3\2\2\2\4-\3"+
		"\2\2\2\6\60\3\2\2\2\b;\3\2\2\2\nD\3\2\2\2\fL\3\2\2\2\16X\3\2\2\2\20Z\3"+
		"\2\2\2\22^\3\2\2\2\24d\3\2\2\2\26m\3\2\2\2\30v\3\2\2\2\32\u0081\3\2\2"+
		"\2\34\u0089\3\2\2\2\36\u0098\3\2\2\2 \u00a1\3\2\2\2\"&\5\4\3\2#%\5\6\4"+
		"\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\3\3\2\2\2(&\3\2\2\2)*\7"+
		"\24\2\2*,\7\33\2\2+)\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\5\3\2\2\2"+
		"/-\3\2\2\2\60\61\7\6\2\2\61\62\7\26\2\2\62\66\7\t\2\2\63\65\5\b\5\2\64"+
		"\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3"+
		"\2\2\29:\7\13\2\2:\7\3\2\2\2;<\7\5\2\2<=\7\26\2\2=?\7\20\2\2>@\5\n\6\2"+
		"?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\22\2\2BC\5\34\17\2C\t\3\2\2\2DI\5\f"+
		"\7\2EF\7\23\2\2FH\5\f\7\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\13"+
		"\3\2\2\2KI\3\2\2\2LM\7\26\2\2MN\7\26\2\2N\r\3\2\2\2OY\5\20\t\2PY\5\22"+
		"\n\2QY\5\24\13\2RY\5\26\f\2SY\5\30\r\2TY\5\32\16\2UY\5 \21\2VY\5\36\20"+
		"\2WY\7\32\2\2XO\3\2\2\2XP\3\2\2\2XQ\3\2\2\2XR\3\2\2\2XS\3\2\2\2XT\3\2"+
		"\2\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\17\3\2\2\2Z[\7\26\2\2[\\\7\n\2\2\\"+
		"]\7\32\2\2]\21\3\2\2\2^_\7\32\2\2_`\7\25\2\2`a\7\26\2\2ab\7\n\2\2bc\7"+
		"\32\2\2c\23\3\2\2\2de\7\32\2\2ef\7\25\2\2fg\7\26\2\2gh\7\25\2\2hi\7\3"+
		"\2\2ij\7\20\2\2jk\7\32\2\2kl\7\22\2\2l\25\3\2\2\2mn\7\32\2\2no\7\25\2"+
		"\2op\7\26\2\2pq\7\25\2\2qr\7\4\2\2rs\7\20\2\2st\7\32\2\2tu\7\22\2\2u\27"+
		"\3\2\2\2vw\7\32\2\2wx\7\25\2\2xy\7\26\2\2yz\7\25\2\2z{\7\21\2\2{|\7\20"+
		"\2\2|}\7\32\2\2}~\7\23\2\2~\177\7\32\2\2\177\u0080\7\22\2\2\u0080\31\3"+
		"\2\2\2\u0081\u0082\7\r\2\2\u0082\u0083\7\20\2\2\u0083\u0084\7\26\2\2\u0084"+
		"\u0085\7\17\2\2\u0085\u0086\7\32\2\2\u0086\u0087\7\22\2\2\u0087\u0088"+
		"\5\34\17\2\u0088\33\3\2\2\2\u0089\u0094\7\t\2\2\u008a\u008b\5\16\b\2\u008b"+
		"\u0091\7\b\2\2\u008c\u008d\5\16\b\2\u008d\u008e\7\b\2\2\u008e\u0090\3"+
		"\2\2\2\u008f\u008c\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u008a\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\7\13\2\2\u0097"+
		"\35\3\2\2\2\u0098\u0099\7\f\2\2\u0099\u009a\7\20\2\2\u009a\u009b\7\32"+
		"\2\2\u009b\u009c\7\22\2\2\u009c\u009f\5\34\17\2\u009d\u009e\7\16\2\2\u009e"+
		"\u00a0\5\34\17\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\37\3\2"+
		"\2\2\u00a1\u00a2\7\7\2\2\u00a2\u00a3\7\20\2\2\u00a3\u00a4\7\32\2\2\u00a4"+
		"\u00a5\7\22\2\2\u00a5\u00a6\5\34\17\2\u00a6!\3\2\2\2\13&-\66?IX\u0091"+
		"\u0094\u009f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}