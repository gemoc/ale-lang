package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_IDENT", "RULE_INT", "RULE_MULTOP", "RULE_REAL", "RULE_LETTER", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'use'", "'.'", "';'", "'class'", "'{'", "'}'", "'def'", "'override'", "'('", "')'", "'@'", "','", "':='", "'for'", "'in'", "'['", "'..'", "']'", "'if'", "'else'", "'while'", "'and'", "'or'", "'xor'", "'implies'", "'->'", "'not'", "'-'", "'then'", "'endif'", "'let'", "':'", "'='", "'+'", "'<='", "'>='", "'!='", "'<>'", "'=='", "'<'", "'>'", "'select'", "'reject'", "'collect'", "'any'", "'exists'", "'forAll'", "'isUnique'", "'one'", "'sortedBy'", "'closure'", "'|'", "'true'", "'false'", "'null'", "'Sequence{'", "'OrderedSet{'", "'::'", "'String'", "'Integer'", "'Real'", "'Boolean'", "'Sequence('", "'OrderedSet('"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=10;
    public static final int RULE_REAL=8;
    public static final int RULE_IDENT=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_LETTER=9;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_MULTOP=7;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "rRoot";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulerRoot"
    // InternalMyDsl.g:70:1: entryRulerRoot returns [EObject current=null] : iv_rulerRoot= rulerRoot EOF ;
    public final EObject entryRulerRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerRoot = null;


        try {
            // InternalMyDsl.g:70:46: (iv_rulerRoot= rulerRoot EOF )
            // InternalMyDsl.g:71:2: iv_rulerRoot= rulerRoot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRRootRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerRoot=rulerRoot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerRoot; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerRoot"


    // $ANTLR start "rulerRoot"
    // InternalMyDsl.g:77:1: rulerRoot returns [EObject current=null] : ( ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_2_0= rulerClass ) )* ) ;
    public final EObject rulerRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_xtendedClasses_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:83:2: ( ( ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_2_0= rulerClass ) )* ) )
            // InternalMyDsl.g:84:2: ( ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_2_0= rulerClass ) )* )
            {
            // InternalMyDsl.g:84:2: ( ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_2_0= rulerClass ) )* )
            // InternalMyDsl.g:85:3: ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_2_0= rulerClass ) )*
            {
            // InternalMyDsl.g:85:3: ( rulerImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDsl.g:86:4: rulerImport
            	    {
            	    if ( state.backtracking==0 ) {

            	      				/* */
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getRRootAccess().getRImportParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    rulerImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalMyDsl.g:97:3: ( rulerService )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyDsl.g:98:4: rulerService
            	    {
            	    if ( state.backtracking==0 ) {

            	      				/* */
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getRRootAccess().getRServiceParserRuleCall_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_4);
            	    rulerService();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalMyDsl.g:109:3: ( (lv_xtendedClasses_2_0= rulerClass ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMyDsl.g:110:4: (lv_xtendedClasses_2_0= rulerClass )
            	    {
            	    // InternalMyDsl.g:110:4: (lv_xtendedClasses_2_0= rulerClass )
            	    // InternalMyDsl.g:111:5: lv_xtendedClasses_2_0= rulerClass
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRRootAccess().getXtendedClassesRClassParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_xtendedClasses_2_0=rulerClass();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRRootRule());
            	      					}
            	      					add(
            	      						current,
            	      						"xtendedClasses",
            	      						lv_xtendedClasses_2_0,
            	      						"org.xtext.example.mydsl.MyDsl.rClass");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerRoot"


    // $ANTLR start "entryRulerImport"
    // InternalMyDsl.g:132:1: entryRulerImport returns [String current=null] : iv_rulerImport= rulerImport EOF ;
    public final String entryRulerImport() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerImport = null;


        try {
            // InternalMyDsl.g:132:47: (iv_rulerImport= rulerImport EOF )
            // InternalMyDsl.g:133:2: iv_rulerImport= rulerImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerImport=rulerImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerImport.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerImport"


    // $ANTLR start "rulerImport"
    // InternalMyDsl.g:139:1: rulerImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'import' this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken rulerImport() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_STRING_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:145:2: ( (kw= 'import' this_STRING_1= RULE_STRING ) )
            // InternalMyDsl.g:146:2: (kw= 'import' this_STRING_1= RULE_STRING )
            {
            // InternalMyDsl.g:146:2: (kw= 'import' this_STRING_1= RULE_STRING )
            // InternalMyDsl.g:147:3: kw= 'import' this_STRING_1= RULE_STRING
            {
            kw=(Token)match(input,15,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRImportAccess().getImportKeyword_0());
              		
            }
            this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_STRING_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_STRING_1, grammarAccess.getRImportAccess().getSTRINGTerminalRuleCall_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerImport"


    // $ANTLR start "entryRulerService"
    // InternalMyDsl.g:163:1: entryRulerService returns [String current=null] : iv_rulerService= rulerService EOF ;
    public final String entryRulerService() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerService = null;


        try {
            // InternalMyDsl.g:163:48: (iv_rulerService= rulerService EOF )
            // InternalMyDsl.g:164:2: iv_rulerService= rulerService EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRServiceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerService=rulerService();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerService.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerService"


    // $ANTLR start "rulerService"
    // InternalMyDsl.g:170:1: rulerService returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerService() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_1=null;
        Token this_Ident_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:176:2: ( (kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';' ) )
            // InternalMyDsl.g:177:2: (kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';' )
            {
            // InternalMyDsl.g:177:2: (kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';' )
            // InternalMyDsl.g:178:3: kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';'
            {
            kw=(Token)match(input,16,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRServiceAccess().getUseKeyword_0());
              		
            }
            this_Ident_1=(Token)match(input,RULE_IDENT,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_1, grammarAccess.getRServiceAccess().getIdentTerminalRuleCall_1());
              		
            }
            // InternalMyDsl.g:190:3: (kw= '.' this_Ident_3= RULE_IDENT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMyDsl.g:191:4: kw= '.' this_Ident_3= RULE_IDENT
            	    {
            	    kw=(Token)match(input,17,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getRServiceAccess().getFullStopKeyword_2_0());
            	      			
            	    }
            	    this_Ident_3=(Token)match(input,RULE_IDENT,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_Ident_3);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_Ident_3, grammarAccess.getRServiceAccess().getIdentTerminalRuleCall_2_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRServiceAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerService"


    // $ANTLR start "entryRulerClass"
    // InternalMyDsl.g:213:1: entryRulerClass returns [EObject current=null] : iv_rulerClass= rulerClass EOF ;
    public final EObject entryRulerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerClass = null;


        try {
            // InternalMyDsl.g:213:47: (iv_rulerClass= rulerClass EOF )
            // InternalMyDsl.g:214:2: iv_rulerClass= rulerClass EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRClassRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerClass=rulerClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerClass; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerClass"


    // $ANTLR start "rulerClass"
    // InternalMyDsl.g:220:1: rulerClass returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' ) ;
    public final EObject rulerClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_attributes_3_0 = null;

        EObject lv_operations_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:226:2: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' ) )
            // InternalMyDsl.g:227:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' )
            {
            // InternalMyDsl.g:227:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' )
            // InternalMyDsl.g:228:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRClassAccess().getClassKeyword_0());
              		
            }
            // InternalMyDsl.g:232:3: ( (lv_name_1_0= RULE_IDENT ) )
            // InternalMyDsl.g:233:4: (lv_name_1_0= RULE_IDENT )
            {
            // InternalMyDsl.g:233:4: (lv_name_1_0= RULE_IDENT )
            // InternalMyDsl.g:234:5: lv_name_1_0= RULE_IDENT
            {
            lv_name_1_0=(Token)match(input,RULE_IDENT,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRClassAccess().getNameIdentTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRClassRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.xtext.example.mydsl.MyDsl.Ident");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRClassAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalMyDsl.g:254:3: ( (lv_attributes_3_0= rulerAttribute ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_IDENT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMyDsl.g:255:4: (lv_attributes_3_0= rulerAttribute )
            	    {
            	    // InternalMyDsl.g:255:4: (lv_attributes_3_0= rulerAttribute )
            	    // InternalMyDsl.g:256:5: lv_attributes_3_0= rulerAttribute
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRClassAccess().getAttributesRAttributeParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_attributes_3_0=rulerAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRClassRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attributes",
            	      						lv_attributes_3_0,
            	      						"org.xtext.example.mydsl.MyDsl.rAttribute");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalMyDsl.g:273:3: ( (lv_operations_4_0= rulerOperation ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=22 && LA6_0<=23)||LA6_0==26) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMyDsl.g:274:4: (lv_operations_4_0= rulerOperation )
            	    {
            	    // InternalMyDsl.g:274:4: (lv_operations_4_0= rulerOperation )
            	    // InternalMyDsl.g:275:5: lv_operations_4_0= rulerOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRClassAccess().getOperationsROperationParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_operations_4_0=rulerOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRClassRule());
            	      					}
            	      					add(
            	      						current,
            	      						"operations",
            	      						lv_operations_4_0,
            	      						"org.xtext.example.mydsl.MyDsl.rOperation");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_5=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRClassAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerClass"


    // $ANTLR start "entryRulerOperation"
    // InternalMyDsl.g:300:1: entryRulerOperation returns [EObject current=null] : iv_rulerOperation= rulerOperation EOF ;
    public final EObject entryRulerOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerOperation = null;


        try {
            // InternalMyDsl.g:300:51: (iv_rulerOperation= rulerOperation EOF )
            // InternalMyDsl.g:301:2: iv_rulerOperation= rulerOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getROperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerOperation=rulerOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerOperation"


    // $ANTLR start "rulerOperation"
    // InternalMyDsl.g:307:1: rulerOperation returns [EObject current=null] : ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) ) ;
    public final EObject rulerOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_paramList_6_0 = null;

        AntlrDatatypeRuleToken lv_body_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:313:2: ( ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) ) )
            // InternalMyDsl.g:314:2: ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) )
            {
            // InternalMyDsl.g:314:2: ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) )
            // InternalMyDsl.g:315:3: ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) )
            {
            // InternalMyDsl.g:315:3: ( rulerTag )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==26) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMyDsl.g:316:4: rulerTag
            	    {
            	    if ( state.backtracking==0 ) {

            	      				/* */
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getROperationAccess().getRTagParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_12);
            	    rulerTag();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalMyDsl.g:327:3: (otherlv_1= 'def' | otherlv_2= 'override' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            else if ( (LA8_0==23) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:328:4: otherlv_1= 'def'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getROperationAccess().getDefKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:333:4: otherlv_2= 'override'
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getROperationAccess().getOverrideKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalMyDsl.g:338:3: ( (lv_type_3_0= RULE_IDENT ) )
            // InternalMyDsl.g:339:4: (lv_type_3_0= RULE_IDENT )
            {
            // InternalMyDsl.g:339:4: (lv_type_3_0= RULE_IDENT )
            // InternalMyDsl.g:340:5: lv_type_3_0= RULE_IDENT
            {
            lv_type_3_0=(Token)match(input,RULE_IDENT,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_type_3_0, grammarAccess.getROperationAccess().getTypeIdentTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getROperationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"type",
              						lv_type_3_0,
              						"org.xtext.example.mydsl.MyDsl.Ident");
              				
            }

            }


            }

            // InternalMyDsl.g:356:3: ( (lv_name_4_0= RULE_IDENT ) )
            // InternalMyDsl.g:357:4: (lv_name_4_0= RULE_IDENT )
            {
            // InternalMyDsl.g:357:4: (lv_name_4_0= RULE_IDENT )
            // InternalMyDsl.g:358:5: lv_name_4_0= RULE_IDENT
            {
            lv_name_4_0=(Token)match(input,RULE_IDENT,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getROperationAccess().getNameIdentTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getROperationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.xtext.example.mydsl.MyDsl.Ident");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getROperationAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalMyDsl.g:378:3: ( (lv_paramList_6_0= rulerParameters ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_IDENT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMyDsl.g:379:4: (lv_paramList_6_0= rulerParameters )
                    {
                    // InternalMyDsl.g:379:4: (lv_paramList_6_0= rulerParameters )
                    // InternalMyDsl.g:380:5: lv_paramList_6_0= rulerParameters
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getROperationAccess().getParamListRParametersParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_15);
                    lv_paramList_6_0=rulerParameters();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getROperationRule());
                      					}
                      					add(
                      						current,
                      						"paramList",
                      						lv_paramList_6_0,
                      						"org.xtext.example.mydsl.MyDsl.rParameters");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getROperationAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalMyDsl.g:401:3: ( (lv_body_8_0= rulerBlock ) )
            // InternalMyDsl.g:402:4: (lv_body_8_0= rulerBlock )
            {
            // InternalMyDsl.g:402:4: (lv_body_8_0= rulerBlock )
            // InternalMyDsl.g:403:5: lv_body_8_0= rulerBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getROperationAccess().getBodyRBlockParserRuleCall_7_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_8_0=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getROperationRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_8_0,
              						"org.xtext.example.mydsl.MyDsl.rBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerOperation"


    // $ANTLR start "entryRulerTag"
    // InternalMyDsl.g:424:1: entryRulerTag returns [String current=null] : iv_rulerTag= rulerTag EOF ;
    public final String entryRulerTag() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerTag = null;


        try {
            // InternalMyDsl.g:424:44: (iv_rulerTag= rulerTag EOF )
            // InternalMyDsl.g:425:2: iv_rulerTag= rulerTag EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRTagRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerTag=rulerTag();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerTag.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerTag"


    // $ANTLR start "rulerTag"
    // InternalMyDsl.g:431:1: rulerTag returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '@' this_Ident_1= RULE_IDENT ) ;
    public final AntlrDatatypeRuleToken rulerTag() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:437:2: ( (kw= '@' this_Ident_1= RULE_IDENT ) )
            // InternalMyDsl.g:438:2: (kw= '@' this_Ident_1= RULE_IDENT )
            {
            // InternalMyDsl.g:438:2: (kw= '@' this_Ident_1= RULE_IDENT )
            // InternalMyDsl.g:439:3: kw= '@' this_Ident_1= RULE_IDENT
            {
            kw=(Token)match(input,26,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRTagAccess().getCommercialAtKeyword_0());
              		
            }
            this_Ident_1=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_1, grammarAccess.getRTagAccess().getIdentTerminalRuleCall_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerTag"


    // $ANTLR start "entryRulerParameters"
    // InternalMyDsl.g:455:1: entryRulerParameters returns [EObject current=null] : iv_rulerParameters= rulerParameters EOF ;
    public final EObject entryRulerParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerParameters = null;


        try {
            // InternalMyDsl.g:455:52: (iv_rulerParameters= rulerParameters EOF )
            // InternalMyDsl.g:456:2: iv_rulerParameters= rulerParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRParametersRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerParameters=rulerParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerParameters; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerParameters"


    // $ANTLR start "rulerParameters"
    // InternalMyDsl.g:462:1: rulerParameters returns [EObject current=null] : ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* ) ;
    public final EObject rulerParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_params_0_0 = null;

        EObject lv_params_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:468:2: ( ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* ) )
            // InternalMyDsl.g:469:2: ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* )
            {
            // InternalMyDsl.g:469:2: ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* )
            // InternalMyDsl.g:470:3: ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )*
            {
            // InternalMyDsl.g:470:3: ( (lv_params_0_0= rulerVariable ) )
            // InternalMyDsl.g:471:4: (lv_params_0_0= rulerVariable )
            {
            // InternalMyDsl.g:471:4: (lv_params_0_0= rulerVariable )
            // InternalMyDsl.g:472:5: lv_params_0_0= rulerVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_params_0_0=rulerVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRParametersRule());
              					}
              					add(
              						current,
              						"params",
              						lv_params_0_0,
              						"org.xtext.example.mydsl.MyDsl.rVariable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMyDsl.g:489:3: (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==27) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMyDsl.g:490:4: otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,27,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getRParametersAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalMyDsl.g:494:4: ( (lv_params_2_0= rulerVariable ) )
            	    // InternalMyDsl.g:495:5: (lv_params_2_0= rulerVariable )
            	    {
            	    // InternalMyDsl.g:495:5: (lv_params_2_0= rulerVariable )
            	    // InternalMyDsl.g:496:6: lv_params_2_0= rulerVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_params_2_0=rulerVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRParametersRule());
            	      						}
            	      						add(
            	      							current,
            	      							"params",
            	      							lv_params_2_0,
            	      							"org.xtext.example.mydsl.MyDsl.rVariable");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerParameters"


    // $ANTLR start "entryRulerVariable"
    // InternalMyDsl.g:518:1: entryRulerVariable returns [EObject current=null] : iv_rulerVariable= rulerVariable EOF ;
    public final EObject entryRulerVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerVariable = null;


        try {
            // InternalMyDsl.g:518:50: (iv_rulerVariable= rulerVariable EOF )
            // InternalMyDsl.g:519:2: iv_rulerVariable= rulerVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerVariable=rulerVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerVariable"


    // $ANTLR start "rulerVariable"
    // InternalMyDsl.g:525:1: rulerVariable returns [EObject current=null] : ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) ) ;
    public final EObject rulerVariable() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:531:2: ( ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) ) )
            // InternalMyDsl.g:532:2: ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) )
            {
            // InternalMyDsl.g:532:2: ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) )
            // InternalMyDsl.g:533:3: ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) )
            {
            // InternalMyDsl.g:533:3: ( (lv_type_0_0= RULE_IDENT ) )
            // InternalMyDsl.g:534:4: (lv_type_0_0= RULE_IDENT )
            {
            // InternalMyDsl.g:534:4: (lv_type_0_0= RULE_IDENT )
            // InternalMyDsl.g:535:5: lv_type_0_0= RULE_IDENT
            {
            lv_type_0_0=(Token)match(input,RULE_IDENT,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_type_0_0, grammarAccess.getRVariableAccess().getTypeIdentTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"type",
              						lv_type_0_0,
              						"org.xtext.example.mydsl.MyDsl.Ident");
              				
            }

            }


            }

            // InternalMyDsl.g:551:3: ( (lv_name_1_0= RULE_IDENT ) )
            // InternalMyDsl.g:552:4: (lv_name_1_0= RULE_IDENT )
            {
            // InternalMyDsl.g:552:4: (lv_name_1_0= RULE_IDENT )
            // InternalMyDsl.g:553:5: lv_name_1_0= RULE_IDENT
            {
            lv_name_1_0=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRVariableAccess().getNameIdentTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.xtext.example.mydsl.MyDsl.Ident");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerVariable"


    // $ANTLR start "entryRulerAttribute"
    // InternalMyDsl.g:573:1: entryRulerAttribute returns [String current=null] : iv_rulerAttribute= rulerAttribute EOF ;
    public final String entryRulerAttribute() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerAttribute = null;


        try {
            // InternalMyDsl.g:573:50: (iv_rulerAttribute= rulerAttribute EOF )
            // InternalMyDsl.g:574:2: iv_rulerAttribute= rulerAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerAttribute=rulerAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerAttribute.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerAttribute"


    // $ANTLR start "rulerAttribute"
    // InternalMyDsl.g:580:1: rulerAttribute returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerAttribute() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token this_Ident_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_expression_3 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:586:2: ( (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' ) )
            // InternalMyDsl.g:587:2: (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' )
            {
            // InternalMyDsl.g:587:2: (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' )
            // InternalMyDsl.g:588:3: this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';'
            {
            this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_0, grammarAccess.getRAttributeAccess().getIdentTerminalRuleCall_0());
              		
            }
            this_Ident_1=(Token)match(input,RULE_IDENT,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_1, grammarAccess.getRAttributeAccess().getIdentTerminalRuleCall_1());
              		
            }
            // InternalMyDsl.g:602:3: (kw= ':=' this_expression_3= ruleexpression )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:603:4: kw= ':=' this_expression_3= ruleexpression
                    {
                    kw=(Token)match(input,28,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRAttributeAccess().getColonEqualsSignKeyword_2_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRAttributeAccess().getExpressionParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_19);
                    this_expression_3=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRAttributeAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerAttribute"


    // $ANTLR start "entryRulerStatement"
    // InternalMyDsl.g:628:1: entryRulerStatement returns [String current=null] : iv_rulerStatement= rulerStatement EOF ;
    public final String entryRulerStatement() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerStatement = null;


        try {
            // InternalMyDsl.g:628:50: (iv_rulerStatement= rulerStatement EOF )
            // InternalMyDsl.g:629:2: iv_rulerStatement= rulerStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerStatement=rulerStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerStatement.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerStatement"


    // $ANTLR start "rulerStatement"
    // InternalMyDsl.g:635:1: rulerStatement returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression ) ;
    public final AntlrDatatypeRuleToken rulerStatement() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_rVarDecl_0 = null;

        AntlrDatatypeRuleToken this_rAssign_1 = null;

        AntlrDatatypeRuleToken this_rForEach_2 = null;

        AntlrDatatypeRuleToken this_rWhile_3 = null;

        AntlrDatatypeRuleToken this_rIf_4 = null;

        AntlrDatatypeRuleToken this_rExpression_5 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:641:2: ( (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression ) )
            // InternalMyDsl.g:642:2: (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression )
            {
            // InternalMyDsl.g:642:2: (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression )
            int alt12=6;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalMyDsl.g:643:3: this_rVarDecl_0= rulerVarDecl
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRStatementAccess().getRVarDeclParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_rVarDecl_0=rulerVarDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_rVarDecl_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:654:3: this_rAssign_1= rulerAssign
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRStatementAccess().getRAssignParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_rAssign_1=rulerAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_rAssign_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:665:3: this_rForEach_2= rulerForEach
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRStatementAccess().getRForEachParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_rForEach_2=rulerForEach();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_rForEach_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:676:3: this_rWhile_3= rulerWhile
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRStatementAccess().getRWhileParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_rWhile_3=rulerWhile();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_rWhile_3);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:687:3: this_rIf_4= rulerIf
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRStatementAccess().getRIfParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_rIf_4=rulerIf();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_rIf_4);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:698:3: this_rExpression_5= rulerExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRStatementAccess().getRExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_rExpression_5=rulerExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_rExpression_5);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerStatement"


    // $ANTLR start "entryRulerVarDecl"
    // InternalMyDsl.g:712:1: entryRulerVarDecl returns [String current=null] : iv_rulerVarDecl= rulerVarDecl EOF ;
    public final String entryRulerVarDecl() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerVarDecl = null;


        try {
            // InternalMyDsl.g:712:48: (iv_rulerVarDecl= rulerVarDecl EOF )
            // InternalMyDsl.g:713:2: iv_rulerVarDecl= rulerVarDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRVarDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerVarDecl=rulerVarDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerVarDecl.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerVarDecl"


    // $ANTLR start "rulerVarDecl"
    // InternalMyDsl.g:719:1: rulerVarDecl returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerVarDecl() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token this_Ident_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_expression_3 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:725:2: ( (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' ) )
            // InternalMyDsl.g:726:2: (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' )
            {
            // InternalMyDsl.g:726:2: (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' )
            // InternalMyDsl.g:727:3: this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';'
            {
            this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_0, grammarAccess.getRVarDeclAccess().getIdentTerminalRuleCall_0());
              		
            }
            this_Ident_1=(Token)match(input,RULE_IDENT,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_1, grammarAccess.getRVarDeclAccess().getIdentTerminalRuleCall_1());
              		
            }
            // InternalMyDsl.g:741:3: (kw= ':=' this_expression_3= ruleexpression )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==28) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:742:4: kw= ':=' this_expression_3= ruleexpression
                    {
                    kw=(Token)match(input,28,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRVarDeclAccess().getColonEqualsSignKeyword_2_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRVarDeclAccess().getExpressionParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_19);
                    this_expression_3=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRVarDeclAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerVarDecl"


    // $ANTLR start "entryRulerAssign"
    // InternalMyDsl.g:767:1: entryRulerAssign returns [String current=null] : iv_rulerAssign= rulerAssign EOF ;
    public final String entryRulerAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerAssign = null;


        try {
            // InternalMyDsl.g:767:47: (iv_rulerAssign= rulerAssign EOF )
            // InternalMyDsl.g:768:2: iv_rulerAssign= rulerAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerAssign=rulerAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerAssign.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerAssign"


    // $ANTLR start "rulerAssign"
    // InternalMyDsl.g:774:1: rulerAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_0 = null;

        AntlrDatatypeRuleToken this_expression_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:780:2: ( (this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';' ) )
            // InternalMyDsl.g:781:2: (this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';' )
            {
            // InternalMyDsl.g:781:2: (this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';' )
            // InternalMyDsl.g:782:3: this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';'
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRAssignAccess().getExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_20);
            this_expression_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_expression_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,28,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRAssignAccess().getColonEqualsSignKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRAssignAccess().getExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_19);
            this_expression_2=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_expression_2);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRAssignAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerAssign"


    // $ANTLR start "entryRulerForEach"
    // InternalMyDsl.g:816:1: entryRulerForEach returns [String current=null] : iv_rulerForEach= rulerForEach EOF ;
    public final String entryRulerForEach() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerForEach = null;


        try {
            // InternalMyDsl.g:816:48: (iv_rulerForEach= rulerForEach EOF )
            // InternalMyDsl.g:817:2: iv_rulerForEach= rulerForEach EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRForEachRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerForEach=rulerForEach();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerForEach.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerForEach"


    // $ANTLR start "rulerForEach"
    // InternalMyDsl.g:823:1: rulerForEach returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock ) ;
    public final AntlrDatatypeRuleToken rulerForEach() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_2=null;
        AntlrDatatypeRuleToken this_rCollection_4 = null;

        AntlrDatatypeRuleToken this_rBlock_6 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:829:2: ( (kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock ) )
            // InternalMyDsl.g:830:2: (kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock )
            {
            // InternalMyDsl.g:830:2: (kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock )
            // InternalMyDsl.g:831:3: kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock
            {
            kw=(Token)match(input,29,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRForEachAccess().getForKeyword_0());
              		
            }
            kw=(Token)match(input,24,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRForEachAccess().getLeftParenthesisKeyword_1());
              		
            }
            this_Ident_2=(Token)match(input,RULE_IDENT,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_2, grammarAccess.getRForEachAccess().getIdentTerminalRuleCall_2());
              		
            }
            kw=(Token)match(input,30,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRForEachAccess().getInKeyword_3());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRForEachAccess().getRCollectionParserRuleCall_4());
              		
            }
            pushFollow(FOLLOW_15);
            this_rCollection_4=rulerCollection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_rCollection_4);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRForEachAccess().getRightParenthesisKeyword_5());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRForEachAccess().getRBlockParserRuleCall_6());
              		
            }
            pushFollow(FOLLOW_2);
            this_rBlock_6=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_rBlock_6);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerForEach"


    // $ANTLR start "entryRulerCollection"
    // InternalMyDsl.g:882:1: entryRulerCollection returns [String current=null] : iv_rulerCollection= rulerCollection EOF ;
    public final String entryRulerCollection() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerCollection = null;


        try {
            // InternalMyDsl.g:882:51: (iv_rulerCollection= rulerCollection EOF )
            // InternalMyDsl.g:883:2: iv_rulerCollection= rulerCollection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRCollectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerCollection=rulerCollection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerCollection.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerCollection"


    // $ANTLR start "rulerCollection"
    // InternalMyDsl.g:889:1: rulerCollection returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' ) | this_expression_5= ruleexpression ) ;
    public final AntlrDatatypeRuleToken rulerCollection() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_expression_5 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:895:2: ( ( (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' ) | this_expression_5= ruleexpression ) )
            // InternalMyDsl.g:896:2: ( (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' ) | this_expression_5= ruleexpression )
            {
            // InternalMyDsl.g:896:2: ( (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' ) | this_expression_5= ruleexpression )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==31) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_INT)||LA14_0==RULE_REAL||LA14_0==20||LA14_0==24||LA14_0==34||(LA14_0>=42 && LA14_0<=43)||LA14_0==46||(LA14_0>=68 && LA14_0<=72)||(LA14_0>=74 && LA14_0<=79)) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalMyDsl.g:897:3: (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' )
                    {
                    // InternalMyDsl.g:897:3: (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' )
                    // InternalMyDsl.g:898:4: kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']'
                    {
                    kw=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRCollectionAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_1, grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_1());
                      			
                    }
                    kw=(Token)match(input,32,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRCollectionAccess().getFullStopFullStopKeyword_0_2());
                      			
                    }
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_3, grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_3());
                      			
                    }
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRCollectionAccess().getRightSquareBracketKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:929:3: this_expression_5= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRCollectionAccess().getExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_expression_5=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_expression_5);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerCollection"


    // $ANTLR start "entryRulerBlock"
    // InternalMyDsl.g:943:1: entryRulerBlock returns [String current=null] : iv_rulerBlock= rulerBlock EOF ;
    public final String entryRulerBlock() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerBlock = null;


        try {
            // InternalMyDsl.g:943:46: (iv_rulerBlock= rulerBlock EOF )
            // InternalMyDsl.g:944:2: iv_rulerBlock= rulerBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerBlock=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerBlock.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerBlock"


    // $ANTLR start "rulerBlock"
    // InternalMyDsl.g:950:1: rulerBlock returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}' ) ;
    public final AntlrDatatypeRuleToken rulerBlock() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_rStatement_1 = null;

        AntlrDatatypeRuleToken this_rStatement_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:956:2: ( (kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}' ) )
            // InternalMyDsl.g:957:2: (kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}' )
            {
            // InternalMyDsl.g:957:2: (kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}' )
            // InternalMyDsl.g:958:3: kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}'
            {
            kw=(Token)match(input,20,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRBlockAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalMyDsl.g:963:3: (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_INT)||LA16_0==RULE_REAL||LA16_0==20||LA16_0==24||LA16_0==29||LA16_0==34||LA16_0==36||(LA16_0>=42 && LA16_0<=43)||LA16_0==46||(LA16_0>=68 && LA16_0<=72)||(LA16_0>=74 && LA16_0<=79)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMyDsl.g:964:4: this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRBlockAccess().getRStatementParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_26);
                    this_rStatement_1=rulerStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_rStatement_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyDsl.g:974:4: (this_rStatement_2= rulerStatement )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_INT)||LA15_0==RULE_REAL||LA15_0==20||LA15_0==24||LA15_0==29||LA15_0==34||LA15_0==36||(LA15_0>=42 && LA15_0<=43)||LA15_0==46||(LA15_0>=68 && LA15_0<=72)||(LA15_0>=74 && LA15_0<=79)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalMyDsl.g:975:5: this_rStatement_2= rulerStatement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getRBlockAccess().getRStatementParserRuleCall_1_1());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_26);
                    	    this_rStatement_2=rulerStatement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(this_rStatement_2);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					afterParserOrEnumRuleCall();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRBlockAccess().getRightCurlyBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerBlock"


    // $ANTLR start "entryRulerIf"
    // InternalMyDsl.g:996:1: entryRulerIf returns [String current=null] : iv_rulerIf= rulerIf EOF ;
    public final String entryRulerIf() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerIf = null;


        try {
            // InternalMyDsl.g:996:43: (iv_rulerIf= rulerIf EOF )
            // InternalMyDsl.g:997:2: iv_rulerIf= rulerIf EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRIfRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerIf=rulerIf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerIf.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerIf"


    // $ANTLR start "rulerIf"
    // InternalMyDsl.g:1003:1: rulerIf returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )? ) ;
    public final AntlrDatatypeRuleToken rulerIf() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_2 = null;

        AntlrDatatypeRuleToken this_rBlock_4 = null;

        AntlrDatatypeRuleToken this_rBlock_6 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1009:2: ( (kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )? ) )
            // InternalMyDsl.g:1010:2: (kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )? )
            {
            // InternalMyDsl.g:1010:2: (kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )? )
            // InternalMyDsl.g:1011:3: kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )?
            {
            kw=(Token)match(input,34,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRIfAccess().getIfKeyword_0());
              		
            }
            kw=(Token)match(input,24,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRIfAccess().getLeftParenthesisKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRIfAccess().getExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_15);
            this_expression_2=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_expression_2);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRIfAccess().getRightParenthesisKeyword_3());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRIfAccess().getRBlockParserRuleCall_4());
              		
            }
            pushFollow(FOLLOW_27);
            this_rBlock_4=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_rBlock_4);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyDsl.g:1046:3: (kw= 'else' this_rBlock_6= rulerBlock )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==35) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:1047:4: kw= 'else' this_rBlock_6= rulerBlock
                    {
                    kw=(Token)match(input,35,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRIfAccess().getElseKeyword_5_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRIfAccess().getRBlockParserRuleCall_5_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_rBlock_6=rulerBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_rBlock_6);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerIf"


    // $ANTLR start "entryRulerWhile"
    // InternalMyDsl.g:1067:1: entryRulerWhile returns [String current=null] : iv_rulerWhile= rulerWhile EOF ;
    public final String entryRulerWhile() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerWhile = null;


        try {
            // InternalMyDsl.g:1067:46: (iv_rulerWhile= rulerWhile EOF )
            // InternalMyDsl.g:1068:2: iv_rulerWhile= rulerWhile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRWhileRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerWhile=rulerWhile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerWhile.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerWhile"


    // $ANTLR start "rulerWhile"
    // InternalMyDsl.g:1074:1: rulerWhile returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock ) ;
    public final AntlrDatatypeRuleToken rulerWhile() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_2 = null;

        AntlrDatatypeRuleToken this_rBlock_4 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1080:2: ( (kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock ) )
            // InternalMyDsl.g:1081:2: (kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock )
            {
            // InternalMyDsl.g:1081:2: (kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock )
            // InternalMyDsl.g:1082:3: kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock
            {
            kw=(Token)match(input,36,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRWhileAccess().getWhileKeyword_0());
              		
            }
            kw=(Token)match(input,24,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRWhileAccess().getLeftParenthesisKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRWhileAccess().getExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_15);
            this_expression_2=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_expression_2);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,25,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRWhileAccess().getRightParenthesisKeyword_3());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRWhileAccess().getRBlockParserRuleCall_4());
              		
            }
            pushFollow(FOLLOW_2);
            this_rBlock_4=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_rBlock_4);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerWhile"


    // $ANTLR start "entryRulerExpression"
    // InternalMyDsl.g:1121:1: entryRulerExpression returns [String current=null] : iv_rulerExpression= rulerExpression EOF ;
    public final String entryRulerExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerExpression = null;


        try {
            // InternalMyDsl.g:1121:51: (iv_rulerExpression= rulerExpression EOF )
            // InternalMyDsl.g:1122:2: iv_rulerExpression= rulerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerExpression=rulerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerExpression.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerExpression"


    // $ANTLR start "rulerExpression"
    // InternalMyDsl.g:1128:1: rulerExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_expression_0= ruleexpression kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1134:2: ( (this_expression_0= ruleexpression kw= ';' ) )
            // InternalMyDsl.g:1135:2: (this_expression_0= ruleexpression kw= ';' )
            {
            // InternalMyDsl.g:1135:2: (this_expression_0= ruleexpression kw= ';' )
            // InternalMyDsl.g:1136:3: this_expression_0= ruleexpression kw= ';'
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRExpressionAccess().getExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_19);
            this_expression_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_expression_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRExpressionAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerExpression"


    // $ANTLR start "entryRuleexpression"
    // InternalMyDsl.g:1155:1: entryRuleexpression returns [String current=null] : iv_ruleexpression= ruleexpression EOF ;
    public final String entryRuleexpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleexpression = null;


        try {
            // InternalMyDsl.g:1155:50: (iv_ruleexpression= ruleexpression EOF )
            // InternalMyDsl.g:1156:2: iv_ruleexpression= ruleexpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleexpression=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleexpression.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleexpression"


    // $ANTLR start "ruleexpression"
    // InternalMyDsl.g:1162:1: ruleexpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )? ) ;
    public final AntlrDatatypeRuleToken ruleexpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_nonLeftRecExpression_0 = null;

        AntlrDatatypeRuleToken this_recExpression_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1168:2: ( (this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )? ) )
            // InternalMyDsl.g:1169:2: (this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )? )
            {
            // InternalMyDsl.g:1169:2: (this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )? )
            // InternalMyDsl.g:1170:3: this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExpressionAccess().getNonLeftRecExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_28);
            this_nonLeftRecExpression_0=rulenonLeftRecExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_nonLeftRecExpression_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyDsl.g:1180:3: (this_recExpression_1= rulerecExpression )?
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalMyDsl.g:1181:4: this_recExpression_1= rulerecExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getExpressionAccess().getRecExpressionParserRuleCall_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_recExpression_1=rulerecExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_recExpression_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleexpression"


    // $ANTLR start "entryRulerecExpression"
    // InternalMyDsl.g:1196:1: entryRulerecExpression returns [String current=null] : iv_rulerecExpression= rulerecExpression EOF ;
    public final String entryRulerecExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerecExpression = null;


        try {
            // InternalMyDsl.g:1196:53: (iv_rulerecExpression= rulerecExpression EOF )
            // InternalMyDsl.g:1197:2: iv_rulerecExpression= rulerecExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerecExpression=rulerecExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerecExpression.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulerecExpression"


    // $ANTLR start "rulerecExpression"
    // InternalMyDsl.g:1203:1: rulerecExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )? ) ;
    public final AntlrDatatypeRuleToken rulerecExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MultOp_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_navigationSegment_0 = null;

        AntlrDatatypeRuleToken this_expression_2 = null;

        AntlrDatatypeRuleToken this_addOp_3 = null;

        AntlrDatatypeRuleToken this_expression_4 = null;

        AntlrDatatypeRuleToken this_compOp_5 = null;

        AntlrDatatypeRuleToken this_expression_6 = null;

        AntlrDatatypeRuleToken this_expression_8 = null;

        AntlrDatatypeRuleToken this_expression_10 = null;

        AntlrDatatypeRuleToken this_expression_12 = null;

        AntlrDatatypeRuleToken this_expression_14 = null;

        AntlrDatatypeRuleToken this_recExpression_15 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1209:2: ( ( (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )? ) )
            // InternalMyDsl.g:1210:2: ( (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )? )
            {
            // InternalMyDsl.g:1210:2: ( (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )? )
            // InternalMyDsl.g:1211:3: (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )?
            {
            // InternalMyDsl.g:1211:3: (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) )
            int alt19=8;
            switch ( input.LA(1) ) {
            case 17:
            case 41:
                {
                alt19=1;
                }
                break;
            case RULE_MULTOP:
                {
                alt19=2;
                }
                break;
            case 43:
            case 49:
                {
                alt19=3;
                }
                break;
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
                {
                alt19=4;
                }
                break;
            case 37:
                {
                alt19=5;
                }
                break;
            case 38:
                {
                alt19=6;
                }
                break;
            case 39:
                {
                alt19=7;
                }
                break;
            case 40:
                {
                alt19=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalMyDsl.g:1212:4: this_navigationSegment_0= rulenavigationSegment
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRecExpressionAccess().getNavigationSegmentParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_28);
                    this_navigationSegment_0=rulenavigationSegment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_navigationSegment_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1223:4: (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression )
                    {
                    // InternalMyDsl.g:1223:4: (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression )
                    // InternalMyDsl.g:1224:5: this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression
                    {
                    this_MultOp_1=(Token)match(input,RULE_MULTOP,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_MultOp_1);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_MultOp_1, grammarAccess.getRecExpressionAccess().getMultOpTerminalRuleCall_0_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_1_1());
                      				
                    }
                    pushFollow(FOLLOW_28);
                    this_expression_2=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_expression_2);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1243:4: (this_addOp_3= ruleaddOp this_expression_4= ruleexpression )
                    {
                    // InternalMyDsl.g:1243:4: (this_addOp_3= ruleaddOp this_expression_4= ruleexpression )
                    // InternalMyDsl.g:1244:5: this_addOp_3= ruleaddOp this_expression_4= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getAddOpParserRuleCall_0_2_0());
                      				
                    }
                    pushFollow(FOLLOW_18);
                    this_addOp_3=ruleaddOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_addOp_3);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_2_1());
                      				
                    }
                    pushFollow(FOLLOW_28);
                    this_expression_4=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_expression_4);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1266:4: (this_compOp_5= rulecompOp this_expression_6= ruleexpression )
                    {
                    // InternalMyDsl.g:1266:4: (this_compOp_5= rulecompOp this_expression_6= ruleexpression )
                    // InternalMyDsl.g:1267:5: this_compOp_5= rulecompOp this_expression_6= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getCompOpParserRuleCall_0_3_0());
                      				
                    }
                    pushFollow(FOLLOW_18);
                    this_compOp_5=rulecompOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_compOp_5);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_3_1());
                      				
                    }
                    pushFollow(FOLLOW_28);
                    this_expression_6=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_expression_6);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:1289:4: (kw= 'and' this_expression_8= ruleexpression )
                    {
                    // InternalMyDsl.g:1289:4: (kw= 'and' this_expression_8= ruleexpression )
                    // InternalMyDsl.g:1290:5: kw= 'and' this_expression_8= ruleexpression
                    {
                    kw=(Token)match(input,37,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getRecExpressionAccess().getAndKeyword_0_4_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_4_1());
                      				
                    }
                    pushFollow(FOLLOW_28);
                    this_expression_8=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_expression_8);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:1307:4: (kw= 'or' this_expression_10= ruleexpression )
                    {
                    // InternalMyDsl.g:1307:4: (kw= 'or' this_expression_10= ruleexpression )
                    // InternalMyDsl.g:1308:5: kw= 'or' this_expression_10= ruleexpression
                    {
                    kw=(Token)match(input,38,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getRecExpressionAccess().getOrKeyword_0_5_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_5_1());
                      				
                    }
                    pushFollow(FOLLOW_28);
                    this_expression_10=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_expression_10);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:1325:4: (kw= 'xor' this_expression_12= ruleexpression )
                    {
                    // InternalMyDsl.g:1325:4: (kw= 'xor' this_expression_12= ruleexpression )
                    // InternalMyDsl.g:1326:5: kw= 'xor' this_expression_12= ruleexpression
                    {
                    kw=(Token)match(input,39,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getRecExpressionAccess().getXorKeyword_0_6_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_6_1());
                      				
                    }
                    pushFollow(FOLLOW_28);
                    this_expression_12=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_expression_12);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:1343:4: (kw= 'implies' this_expression_14= ruleexpression )
                    {
                    // InternalMyDsl.g:1343:4: (kw= 'implies' this_expression_14= ruleexpression )
                    // InternalMyDsl.g:1344:5: kw= 'implies' this_expression_14= ruleexpression
                    {
                    kw=(Token)match(input,40,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getRecExpressionAccess().getImpliesKeyword_0_7_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_7_1());
                      				
                    }
                    pushFollow(FOLLOW_28);
                    this_expression_14=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_expression_14);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1361:3: (this_recExpression_15= rulerecExpression )?
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalMyDsl.g:1362:4: this_recExpression_15= rulerecExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRecExpressionAccess().getRecExpressionParserRuleCall_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_recExpression_15=rulerecExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_recExpression_15);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerecExpression"


    // $ANTLR start "entryRulenavigationSegment"
    // InternalMyDsl.g:1377:1: entryRulenavigationSegment returns [String current=null] : iv_rulenavigationSegment= rulenavigationSegment EOF ;
    public final String entryRulenavigationSegment() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulenavigationSegment = null;


        try {
            // InternalMyDsl.g:1377:57: (iv_rulenavigationSegment= rulenavigationSegment EOF )
            // InternalMyDsl.g:1378:2: iv_rulenavigationSegment= rulenavigationSegment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationSegmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulenavigationSegment=rulenavigationSegment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulenavigationSegment.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulenavigationSegment"


    // $ANTLR start "rulenavigationSegment"
    // InternalMyDsl.g:1384:1: rulenavigationSegment returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '.' this_Ident_1= RULE_IDENT ) | (kw= '.' this_callExp_3= rulecallExp ) | (kw= '->' this_callExp_5= rulecallExp ) ) ;
    public final AntlrDatatypeRuleToken rulenavigationSegment() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_1=null;
        AntlrDatatypeRuleToken this_callExp_3 = null;

        AntlrDatatypeRuleToken this_callExp_5 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1390:2: ( ( (kw= '.' this_Ident_1= RULE_IDENT ) | (kw= '.' this_callExp_3= rulecallExp ) | (kw= '->' this_callExp_5= rulecallExp ) ) )
            // InternalMyDsl.g:1391:2: ( (kw= '.' this_Ident_1= RULE_IDENT ) | (kw= '.' this_callExp_3= rulecallExp ) | (kw= '->' this_callExp_5= rulecallExp ) )
            {
            // InternalMyDsl.g:1391:2: ( (kw= '.' this_Ident_1= RULE_IDENT ) | (kw= '.' this_callExp_3= rulecallExp ) | (kw= '->' this_callExp_5= rulecallExp ) )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                int LA21_1 = input.LA(2);

                if ( ((LA21_1>=57 && LA21_1<=66)) ) {
                    alt21=2;
                }
                else if ( (LA21_1==RULE_IDENT) ) {
                    int LA21_4 = input.LA(3);

                    if ( (LA21_4==EOF||LA21_4==RULE_MULTOP||(LA21_4>=17 && LA21_4<=18)||LA21_4==21||LA21_4==25||(LA21_4>=27 && LA21_4<=28)||LA21_4==30||LA21_4==35||(LA21_4>=37 && LA21_4<=41)||(LA21_4>=43 && LA21_4<=45)||(LA21_4>=48 && LA21_4<=56)) ) {
                        alt21=1;
                    }
                    else if ( (LA21_4==24) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA21_0==41) ) {
                alt21=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:1392:3: (kw= '.' this_Ident_1= RULE_IDENT )
                    {
                    // InternalMyDsl.g:1392:3: (kw= '.' this_Ident_1= RULE_IDENT )
                    // InternalMyDsl.g:1393:4: kw= '.' this_Ident_1= RULE_IDENT
                    {
                    kw=(Token)match(input,17,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_0_0());
                      			
                    }
                    this_Ident_1=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_1, grammarAccess.getNavigationSegmentAccess().getIdentTerminalRuleCall_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1407:3: (kw= '.' this_callExp_3= rulecallExp )
                    {
                    // InternalMyDsl.g:1407:3: (kw= '.' this_callExp_3= rulecallExp )
                    // InternalMyDsl.g:1408:4: kw= '.' this_callExp_3= rulecallExp
                    {
                    kw=(Token)match(input,17,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNavigationSegmentAccess().getCallExpParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_callExp_3=rulecallExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_callExp_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1425:3: (kw= '->' this_callExp_5= rulecallExp )
                    {
                    // InternalMyDsl.g:1425:3: (kw= '->' this_callExp_5= rulecallExp )
                    // InternalMyDsl.g:1426:4: kw= '->' this_callExp_5= rulecallExp
                    {
                    kw=(Token)match(input,41,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNavigationSegmentAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNavigationSegmentAccess().getCallExpParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_callExp_5=rulecallExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_callExp_5);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulenavigationSegment"


    // $ANTLR start "entryRulenonLeftRecExpression"
    // InternalMyDsl.g:1446:1: entryRulenonLeftRecExpression returns [String current=null] : iv_rulenonLeftRecExpression= rulenonLeftRecExpression EOF ;
    public final String entryRulenonLeftRecExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulenonLeftRecExpression = null;


        try {
            // InternalMyDsl.g:1446:60: (iv_rulenonLeftRecExpression= rulenonLeftRecExpression EOF )
            // InternalMyDsl.g:1447:2: iv_rulenonLeftRecExpression= rulenonLeftRecExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNonLeftRecExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulenonLeftRecExpression=rulenonLeftRecExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulenonLeftRecExpression.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulenonLeftRecExpression"


    // $ANTLR start "rulenonLeftRecExpression"
    // InternalMyDsl.g:1453:1: rulenonLeftRecExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'not' this_expression_1= ruleexpression ) | (kw= '-' this_expression_3= ruleexpression ) | this_Ident_4= RULE_IDENT | this_literal_5= ruleliteral | (kw= '(' this_expression_7= ruleexpression kw= ')' ) | (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' ) | (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression ) ) ;
    public final AntlrDatatypeRuleToken rulenonLeftRecExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_4=null;
        AntlrDatatypeRuleToken this_expression_1 = null;

        AntlrDatatypeRuleToken this_expression_3 = null;

        AntlrDatatypeRuleToken this_literal_5 = null;

        AntlrDatatypeRuleToken this_expression_7 = null;

        AntlrDatatypeRuleToken this_expression_10 = null;

        AntlrDatatypeRuleToken this_expression_12 = null;

        AntlrDatatypeRuleToken this_expression_14 = null;

        AntlrDatatypeRuleToken this_binding_17 = null;

        AntlrDatatypeRuleToken this_binding_19 = null;

        AntlrDatatypeRuleToken this_expression_21 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1459:2: ( ( (kw= 'not' this_expression_1= ruleexpression ) | (kw= '-' this_expression_3= ruleexpression ) | this_Ident_4= RULE_IDENT | this_literal_5= ruleliteral | (kw= '(' this_expression_7= ruleexpression kw= ')' ) | (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' ) | (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression ) ) )
            // InternalMyDsl.g:1460:2: ( (kw= 'not' this_expression_1= ruleexpression ) | (kw= '-' this_expression_3= ruleexpression ) | this_Ident_4= RULE_IDENT | this_literal_5= ruleliteral | (kw= '(' this_expression_7= ruleexpression kw= ')' ) | (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' ) | (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression ) )
            {
            // InternalMyDsl.g:1460:2: ( (kw= 'not' this_expression_1= ruleexpression ) | (kw= '-' this_expression_3= ruleexpression ) | this_Ident_4= RULE_IDENT | this_literal_5= ruleliteral | (kw= '(' this_expression_7= ruleexpression kw= ')' ) | (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' ) | (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression ) )
            int alt23=7;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt23=1;
                }
                break;
            case 43:
                {
                alt23=2;
                }
                break;
            case RULE_IDENT:
                {
                int LA23_3 = input.LA(2);

                if ( (LA23_3==47||LA23_3==73) ) {
                    alt23=4;
                }
                else if ( (LA23_3==EOF||LA23_3==RULE_MULTOP||(LA23_3>=17 && LA23_3<=18)||LA23_3==21||LA23_3==25||(LA23_3>=27 && LA23_3<=28)||LA23_3==30||LA23_3==35||(LA23_3>=37 && LA23_3<=41)||(LA23_3>=43 && LA23_3<=45)||(LA23_3>=48 && LA23_3<=56)) ) {
                    alt23=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case RULE_REAL:
            case 20:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                {
                alt23=4;
                }
                break;
            case 24:
                {
                alt23=5;
                }
                break;
            case 34:
                {
                alt23=6;
                }
                break;
            case 46:
                {
                alt23=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:1461:3: (kw= 'not' this_expression_1= ruleexpression )
                    {
                    // InternalMyDsl.g:1461:3: (kw= 'not' this_expression_1= ruleexpression )
                    // InternalMyDsl.g:1462:4: kw= 'not' this_expression_1= ruleexpression
                    {
                    kw=(Token)match(input,42,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getNotKeyword_0_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_expression_1=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1479:3: (kw= '-' this_expression_3= ruleexpression )
                    {
                    // InternalMyDsl.g:1479:3: (kw= '-' this_expression_3= ruleexpression )
                    // InternalMyDsl.g:1480:4: kw= '-' this_expression_3= ruleexpression
                    {
                    kw=(Token)match(input,43,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getHyphenMinusKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_expression_3=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1497:3: this_Ident_4= RULE_IDENT
                    {
                    this_Ident_4=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_Ident_4);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_Ident_4, grammarAccess.getNonLeftRecExpressionAccess().getIdentTerminalRuleCall_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1505:3: this_literal_5= ruleliteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_literal_5=ruleliteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_literal_5);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:1516:3: (kw= '(' this_expression_7= ruleexpression kw= ')' )
                    {
                    // InternalMyDsl.g:1516:3: (kw= '(' this_expression_7= ruleexpression kw= ')' )
                    // InternalMyDsl.g:1517:4: kw= '(' this_expression_7= ruleexpression kw= ')'
                    {
                    kw=(Token)match(input,24,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_4_1());
                      			
                    }
                    pushFollow(FOLLOW_15);
                    this_expression_7=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_7);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getRightParenthesisKeyword_4_2());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:1539:3: (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' )
                    {
                    // InternalMyDsl.g:1539:3: (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' )
                    // InternalMyDsl.g:1540:4: kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif'
                    {
                    kw=(Token)match(input,34,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getIfKeyword_5_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_1());
                      			
                    }
                    pushFollow(FOLLOW_30);
                    this_expression_10=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_10);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,44,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getThenKeyword_5_2());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_3());
                      			
                    }
                    pushFollow(FOLLOW_31);
                    this_expression_12=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_12);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,35,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getElseKeyword_5_4());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_5());
                      			
                    }
                    pushFollow(FOLLOW_32);
                    this_expression_14=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_14);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getEndifKeyword_5_6());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:1592:3: (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression )
                    {
                    // InternalMyDsl.g:1592:3: (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression )
                    // InternalMyDsl.g:1593:4: kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression
                    {
                    kw=(Token)match(input,46,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getLetKeyword_6_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getBindingParserRuleCall_6_1());
                      			
                    }
                    pushFollow(FOLLOW_33);
                    this_binding_17=rulebinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_binding_17);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyDsl.g:1608:4: (kw= ',' this_binding_19= rulebinding )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==27) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalMyDsl.g:1609:5: kw= ',' this_binding_19= rulebinding
                    	    {
                    	    kw=(Token)match(input,27,FOLLOW_7); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(kw);
                    	      					newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getCommaKeyword_6_2_0());
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getBindingParserRuleCall_6_2_1());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_33);
                    	    this_binding_19=rulebinding();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(this_binding_19);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					afterParserOrEnumRuleCall();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    kw=(Token)match(input,30,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getInKeyword_6_3());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_6_4());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_expression_21=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_21);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulenonLeftRecExpression"


    // $ANTLR start "entryRulebinding"
    // InternalMyDsl.g:1645:1: entryRulebinding returns [String current=null] : iv_rulebinding= rulebinding EOF ;
    public final String entryRulebinding() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulebinding = null;


        try {
            // InternalMyDsl.g:1645:47: (iv_rulebinding= rulebinding EOF )
            // InternalMyDsl.g:1646:2: iv_rulebinding= rulebinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulebinding=rulebinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulebinding.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebinding"


    // $ANTLR start "rulebinding"
    // InternalMyDsl.g:1652:1: rulebinding returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression ) ;
    public final AntlrDatatypeRuleToken rulebinding() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_typeLiteral_2 = null;

        AntlrDatatypeRuleToken this_expression_4 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1658:2: ( (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression ) )
            // InternalMyDsl.g:1659:2: (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression )
            {
            // InternalMyDsl.g:1659:2: (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression )
            // InternalMyDsl.g:1660:3: this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression
            {
            this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_0, grammarAccess.getBindingAccess().getIdentTerminalRuleCall_0());
              		
            }
            // InternalMyDsl.g:1667:3: (kw= ':' this_typeLiteral_2= ruletypeLiteral )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==47) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMyDsl.g:1668:4: kw= ':' this_typeLiteral_2= ruletypeLiteral
                    {
                    kw=(Token)match(input,47,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getBindingAccess().getColonKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBindingAccess().getTypeLiteralParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_36);
                    this_typeLiteral_2=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_typeLiteral_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,48,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getBindingAccess().getEqualsSignKeyword_2());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBindingAccess().getExpressionParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_2);
            this_expression_4=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_expression_4);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebinding"


    // $ANTLR start "entryRuleaddOp"
    // InternalMyDsl.g:1703:1: entryRuleaddOp returns [String current=null] : iv_ruleaddOp= ruleaddOp EOF ;
    public final String entryRuleaddOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleaddOp = null;


        try {
            // InternalMyDsl.g:1703:45: (iv_ruleaddOp= ruleaddOp EOF )
            // InternalMyDsl.g:1704:2: iv_ruleaddOp= ruleaddOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleaddOp=ruleaddOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleaddOp.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleaddOp"


    // $ANTLR start "ruleaddOp"
    // InternalMyDsl.g:1710:1: ruleaddOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleaddOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1716:2: ( (kw= '+' | kw= '-' ) )
            // InternalMyDsl.g:1717:2: (kw= '+' | kw= '-' )
            {
            // InternalMyDsl.g:1717:2: (kw= '+' | kw= '-' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==49) ) {
                alt25=1;
            }
            else if ( (LA25_0==43) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:1718:3: kw= '+'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAddOpAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1724:3: kw= '-'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAddOpAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleaddOp"


    // $ANTLR start "entryRulecompOp"
    // InternalMyDsl.g:1733:1: entryRulecompOp returns [String current=null] : iv_rulecompOp= rulecompOp EOF ;
    public final String entryRulecompOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulecompOp = null;


        try {
            // InternalMyDsl.g:1733:46: (iv_rulecompOp= rulecompOp EOF )
            // InternalMyDsl.g:1734:2: iv_rulecompOp= rulecompOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulecompOp=rulecompOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulecompOp.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecompOp"


    // $ANTLR start "rulecompOp"
    // InternalMyDsl.g:1740:1: rulecompOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<=' | kw= '>=' | kw= '!=' | kw= '<>' | kw= '=' | kw= '==' | kw= '<' | kw= '>' ) ;
    public final AntlrDatatypeRuleToken rulecompOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1746:2: ( (kw= '<=' | kw= '>=' | kw= '!=' | kw= '<>' | kw= '=' | kw= '==' | kw= '<' | kw= '>' ) )
            // InternalMyDsl.g:1747:2: (kw= '<=' | kw= '>=' | kw= '!=' | kw= '<>' | kw= '=' | kw= '==' | kw= '<' | kw= '>' )
            {
            // InternalMyDsl.g:1747:2: (kw= '<=' | kw= '>=' | kw= '!=' | kw= '<>' | kw= '=' | kw= '==' | kw= '<' | kw= '>' )
            int alt26=8;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt26=1;
                }
                break;
            case 51:
                {
                alt26=2;
                }
                break;
            case 52:
                {
                alt26=3;
                }
                break;
            case 53:
                {
                alt26=4;
                }
                break;
            case 48:
                {
                alt26=5;
                }
                break;
            case 54:
                {
                alt26=6;
                }
                break;
            case 55:
                {
                alt26=7;
                }
                break;
            case 56:
                {
                alt26=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:1748:3: kw= '<='
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getLessThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1754:3: kw= '>='
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getGreaterThanSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1760:3: kw= '!='
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getExclamationMarkEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1766:3: kw= '<>'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getLessThanSignGreaterThanSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:1772:3: kw= '='
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:1778:3: kw= '=='
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getEqualsSignEqualsSignKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:1784:3: kw= '<'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getLessThanSignKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:1790:3: kw= '>'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getGreaterThanSignKeyword_7());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecompOp"


    // $ANTLR start "entryRulecallExp"
    // InternalMyDsl.g:1799:1: entryRulecallExp returns [String current=null] : iv_rulecallExp= rulecallExp EOF ;
    public final String entryRulecallExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulecallExp = null;


        try {
            // InternalMyDsl.g:1799:47: (iv_rulecallExp= rulecallExp EOF )
            // InternalMyDsl.g:1800:2: iv_rulecallExp= rulecallExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallExpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulecallExp=rulecallExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulecallExp.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecallExp"


    // $ANTLR start "rulecallExp"
    // InternalMyDsl.g:1806:1: rulecallExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' ) | (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' ) ) ;
    public final AntlrDatatypeRuleToken rulecallExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_5=null;
        AntlrDatatypeRuleToken this_collectionIterator_0 = null;

        AntlrDatatypeRuleToken this_variableDefinition_2 = null;

        AntlrDatatypeRuleToken this_lambdaExpression_3 = null;

        AntlrDatatypeRuleToken this_expressionSequence_7 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1812:2: ( ( (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' ) | (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' ) ) )
            // InternalMyDsl.g:1813:2: ( (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' ) | (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' ) )
            {
            // InternalMyDsl.g:1813:2: ( (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' ) | (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=57 && LA27_0<=66)) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_IDENT) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalMyDsl.g:1814:3: (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' )
                    {
                    // InternalMyDsl.g:1814:3: (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' )
                    // InternalMyDsl.g:1815:4: this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getCollectionIteratorParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_13);
                    this_collectionIterator_0=rulecollectionIterator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_collectionIterator_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,24,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getVariableDefinitionParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_18);
                    this_variableDefinition_2=rulevariableDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_variableDefinition_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getLambdaExpressionParserRuleCall_0_3());
                      			
                    }
                    pushFollow(FOLLOW_15);
                    this_lambdaExpression_3=rulelambdaExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_lambdaExpression_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getCallExpAccess().getRightParenthesisKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1857:3: (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' )
                    {
                    // InternalMyDsl.g:1857:3: (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' )
                    // InternalMyDsl.g:1858:4: this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')'
                    {
                    this_Ident_5=(Token)match(input,RULE_IDENT,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_5);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_5, grammarAccess.getCallExpAccess().getIdentTerminalRuleCall_1_0());
                      			
                    }
                    kw=(Token)match(input,24,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_1_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getExpressionSequenceParserRuleCall_1_2());
                      			
                    }
                    pushFollow(FOLLOW_15);
                    this_expressionSequence_7=ruleexpressionSequence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expressionSequence_7);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getCallExpAccess().getRightParenthesisKeyword_1_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecallExp"


    // $ANTLR start "entryRulelambdaExpression"
    // InternalMyDsl.g:1890:1: entryRulelambdaExpression returns [String current=null] : iv_rulelambdaExpression= rulelambdaExpression EOF ;
    public final String entryRulelambdaExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulelambdaExpression = null;


        try {
            // InternalMyDsl.g:1890:56: (iv_rulelambdaExpression= rulelambdaExpression EOF )
            // InternalMyDsl.g:1891:2: iv_rulelambdaExpression= rulelambdaExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulelambdaExpression=rulelambdaExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulelambdaExpression.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulelambdaExpression"


    // $ANTLR start "rulelambdaExpression"
    // InternalMyDsl.g:1897:1: rulelambdaExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_expression_0= ruleexpression ;
    public final AntlrDatatypeRuleToken rulelambdaExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_expression_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1903:2: (this_expression_0= ruleexpression )
            // InternalMyDsl.g:1904:2: this_expression_0= ruleexpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getLambdaExpressionAccess().getExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_expression_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_expression_0);
              	
            }
            if ( state.backtracking==0 ) {

              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulelambdaExpression"


    // $ANTLR start "entryRulecollectionIterator"
    // InternalMyDsl.g:1917:1: entryRulecollectionIterator returns [String current=null] : iv_rulecollectionIterator= rulecollectionIterator EOF ;
    public final String entryRulecollectionIterator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulecollectionIterator = null;


        try {
            // InternalMyDsl.g:1917:58: (iv_rulecollectionIterator= rulecollectionIterator EOF )
            // InternalMyDsl.g:1918:2: iv_rulecollectionIterator= rulecollectionIterator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionIteratorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulecollectionIterator=rulecollectionIterator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulecollectionIterator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecollectionIterator"


    // $ANTLR start "rulecollectionIterator"
    // InternalMyDsl.g:1924:1: rulecollectionIterator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' ) ;
    public final AntlrDatatypeRuleToken rulecollectionIterator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1930:2: ( (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' ) )
            // InternalMyDsl.g:1931:2: (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' )
            {
            // InternalMyDsl.g:1931:2: (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' )
            int alt28=10;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt28=1;
                }
                break;
            case 58:
                {
                alt28=2;
                }
                break;
            case 59:
                {
                alt28=3;
                }
                break;
            case 60:
                {
                alt28=4;
                }
                break;
            case 61:
                {
                alt28=5;
                }
                break;
            case 62:
                {
                alt28=6;
                }
                break;
            case 63:
                {
                alt28=7;
                }
                break;
            case 64:
                {
                alt28=8;
                }
                break;
            case 65:
                {
                alt28=9;
                }
                break;
            case 66:
                {
                alt28=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalMyDsl.g:1932:3: kw= 'select'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getSelectKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1938:3: kw= 'reject'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getRejectKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1944:3: kw= 'collect'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getCollectKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1950:3: kw= 'any'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getAnyKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:1956:3: kw= 'exists'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getExistsKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:1962:3: kw= 'forAll'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getForAllKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:1968:3: kw= 'isUnique'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getIsUniqueKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:1974:3: kw= 'one'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getOneKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:1980:3: kw= 'sortedBy'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getSortedByKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:1986:3: kw= 'closure'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getClosureKeyword_9());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecollectionIterator"


    // $ANTLR start "entryRuleexpressionSequence"
    // InternalMyDsl.g:1995:1: entryRuleexpressionSequence returns [String current=null] : iv_ruleexpressionSequence= ruleexpressionSequence EOF ;
    public final String entryRuleexpressionSequence() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleexpressionSequence = null;


        try {
            // InternalMyDsl.g:1995:58: (iv_ruleexpressionSequence= ruleexpressionSequence EOF )
            // InternalMyDsl.g:1996:2: iv_ruleexpressionSequence= ruleexpressionSequence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleexpressionSequence=ruleexpressionSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleexpressionSequence.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleexpressionSequence"


    // $ANTLR start "ruleexpressionSequence"
    // InternalMyDsl.g:2002:1: ruleexpressionSequence returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )* )? ;
    public final AntlrDatatypeRuleToken ruleexpressionSequence() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_0 = null;

        AntlrDatatypeRuleToken this_expression_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2008:2: ( (this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )* )? )
            // InternalMyDsl.g:2009:2: (this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )* )?
            {
            // InternalMyDsl.g:2009:2: (this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_INT)||LA30_0==RULE_REAL||LA30_0==20||LA30_0==24||LA30_0==34||(LA30_0>=42 && LA30_0<=43)||LA30_0==46||(LA30_0>=68 && LA30_0<=72)||(LA30_0>=74 && LA30_0<=79)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMyDsl.g:2010:3: this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )*
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionSequenceAccess().getExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_16);
                    this_expression_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_expression_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }
                    // InternalMyDsl.g:2020:3: (kw= ',' this_expression_2= ruleexpression )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==27) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalMyDsl.g:2021:4: kw= ',' this_expression_2= ruleexpression
                    	    {
                    	    kw=(Token)match(input,27,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      				current.merge(kw);
                    	      				newLeafNode(kw, grammarAccess.getExpressionSequenceAccess().getCommaKeyword_1_0());
                    	      			
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      				newCompositeNode(grammarAccess.getExpressionSequenceAccess().getExpressionParserRuleCall_1_1());
                    	      			
                    	    }
                    	    pushFollow(FOLLOW_16);
                    	    this_expression_2=ruleexpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      				current.merge(this_expression_2);
                    	      			
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      				afterParserOrEnumRuleCall();
                    	      			
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleexpressionSequence"


    // $ANTLR start "entryRulevariableDefinition"
    // InternalMyDsl.g:2041:1: entryRulevariableDefinition returns [String current=null] : iv_rulevariableDefinition= rulevariableDefinition EOF ;
    public final String entryRulevariableDefinition() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulevariableDefinition = null;


        try {
            // InternalMyDsl.g:2041:58: (iv_rulevariableDefinition= rulevariableDefinition EOF )
            // InternalMyDsl.g:2042:2: iv_rulevariableDefinition= rulevariableDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulevariableDefinition=rulevariableDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulevariableDefinition.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulevariableDefinition"


    // $ANTLR start "rulevariableDefinition"
    // InternalMyDsl.g:2048:1: rulevariableDefinition returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|' ) ;
    public final AntlrDatatypeRuleToken rulevariableDefinition() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_typeLiteral_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2054:2: ( (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|' ) )
            // InternalMyDsl.g:2055:2: (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|' )
            {
            // InternalMyDsl.g:2055:2: (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|' )
            // InternalMyDsl.g:2056:3: this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|'
            {
            this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_0, grammarAccess.getVariableDefinitionAccess().getIdentTerminalRuleCall_0());
              		
            }
            // InternalMyDsl.g:2063:3: (kw= ':' this_typeLiteral_2= ruletypeLiteral )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==47) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMyDsl.g:2064:4: kw= ':' this_typeLiteral_2= ruletypeLiteral
                    {
                    kw=(Token)match(input,47,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getVariableDefinitionAccess().getColonKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getVariableDefinitionAccess().getTypeLiteralParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_39);
                    this_typeLiteral_2=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_typeLiteral_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getVariableDefinitionAccess().getVerticalLineKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulevariableDefinition"


    // $ANTLR start "entryRuleliteral"
    // InternalMyDsl.g:2089:1: entryRuleliteral returns [String current=null] : iv_ruleliteral= ruleliteral EOF ;
    public final String entryRuleliteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleliteral = null;


        try {
            // InternalMyDsl.g:2089:47: (iv_ruleliteral= ruleliteral EOF )
            // InternalMyDsl.g:2090:2: iv_ruleliteral= ruleliteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleliteral=ruleliteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleliteral.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleliteral"


    // $ANTLR start "ruleliteral"
    // InternalMyDsl.g:2096:1: ruleliteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral ) ;
    public final AntlrDatatypeRuleToken ruleliteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_INT_1=null;
        Token this_Real_2=null;
        Token kw=null;
        Token this_Ident_12=null;
        Token this_Ident_14=null;
        Token this_Ident_16=null;
        Token this_Ident_17=null;
        Token this_Ident_19=null;
        AntlrDatatypeRuleToken this_expressionSequence_7 = null;

        AntlrDatatypeRuleToken this_expressionSequence_10 = null;

        AntlrDatatypeRuleToken this_typeLiteral_21 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2102:2: ( (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral ) )
            // InternalMyDsl.g:2103:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral )
            {
            // InternalMyDsl.g:2103:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral )
            int alt32=11;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:2104:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STRING_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_0, grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2112:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_INT_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_INT_1, grammarAccess.getLiteralAccess().getINTTerminalRuleCall_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2120:3: this_Real_2= RULE_REAL
                    {
                    this_Real_2=(Token)match(input,RULE_REAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_Real_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_Real_2, grammarAccess.getLiteralAccess().getRealTerminalRuleCall_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2128:3: kw= 'true'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLiteralAccess().getTrueKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2134:3: kw= 'false'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLiteralAccess().getFalseKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2140:3: kw= 'null'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLiteralAccess().getNullKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:2146:3: (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' )
                    {
                    // InternalMyDsl.g:2146:3: (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' )
                    // InternalMyDsl.g:2147:4: kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}'
                    {
                    kw=(Token)match(input,71,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getSequenceKeyword_6_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_6_1());
                      			
                    }
                    pushFollow(FOLLOW_41);
                    this_expressionSequence_7=ruleexpressionSequence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expressionSequence_7);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_6_2());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:2169:3: (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' )
                    {
                    // InternalMyDsl.g:2169:3: (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' )
                    // InternalMyDsl.g:2170:4: kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}'
                    {
                    kw=(Token)match(input,72,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getOrderedSetKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_41);
                    this_expressionSequence_10=ruleexpressionSequence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expressionSequence_10);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_7_2());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:2192:3: (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT )
                    {
                    // InternalMyDsl.g:2192:3: (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT )
                    // InternalMyDsl.g:2193:4: this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT
                    {
                    this_Ident_12=(Token)match(input,RULE_IDENT,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_12);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_12, grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_0());
                      			
                    }
                    kw=(Token)match(input,73,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getColonColonKeyword_8_1());
                      			
                    }
                    this_Ident_14=(Token)match(input,RULE_IDENT,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_14);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_14, grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_2());
                      			
                    }
                    kw=(Token)match(input,73,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getColonColonKeyword_8_3());
                      			
                    }
                    this_Ident_16=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_16);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_16, grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_4());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:2226:3: (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' )
                    {
                    // InternalMyDsl.g:2226:3: (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' )
                    // InternalMyDsl.g:2227:4: this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':'
                    {
                    this_Ident_17=(Token)match(input,RULE_IDENT,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_17);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_17, grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_9_0());
                      			
                    }
                    kw=(Token)match(input,73,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getColonColonKeyword_9_1());
                      			
                    }
                    this_Ident_19=(Token)match(input,RULE_IDENT,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_19);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_19, grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_9_2());
                      			
                    }
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getColonKeyword_9_3());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:2253:3: this_typeLiteral_21= ruletypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getTypeLiteralParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_typeLiteral_21=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_typeLiteral_21);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleliteral"


    // $ANTLR start "entryRuletypeLiteral"
    // InternalMyDsl.g:2267:1: entryRuletypeLiteral returns [String current=null] : iv_ruletypeLiteral= ruletypeLiteral EOF ;
    public final String entryRuletypeLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruletypeLiteral = null;


        try {
            // InternalMyDsl.g:2267:51: (iv_ruletypeLiteral= ruletypeLiteral EOF )
            // InternalMyDsl.g:2268:2: iv_ruletypeLiteral= ruletypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruletypeLiteral=ruletypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruletypeLiteral.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuletypeLiteral"


    // $ANTLR start "ruletypeLiteral"
    // InternalMyDsl.g:2274:1: ruletypeLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'String' | kw= 'Integer' | kw= 'Real' | kw= 'Boolean' | (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' ) | (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' ) | this_classifierTypeRule_10= ruleclassifierTypeRule | (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' ) ) ;
    public final AntlrDatatypeRuleToken ruletypeLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_typeLiteral_5 = null;

        AntlrDatatypeRuleToken this_typeLiteral_8 = null;

        AntlrDatatypeRuleToken this_classifierTypeRule_10 = null;

        AntlrDatatypeRuleToken this_classifierTypeRule_12 = null;

        AntlrDatatypeRuleToken this_classifierTypeRule_14 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2280:2: ( (kw= 'String' | kw= 'Integer' | kw= 'Real' | kw= 'Boolean' | (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' ) | (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' ) | this_classifierTypeRule_10= ruleclassifierTypeRule | (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' ) ) )
            // InternalMyDsl.g:2281:2: (kw= 'String' | kw= 'Integer' | kw= 'Real' | kw= 'Boolean' | (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' ) | (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' ) | this_classifierTypeRule_10= ruleclassifierTypeRule | (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' ) )
            {
            // InternalMyDsl.g:2281:2: (kw= 'String' | kw= 'Integer' | kw= 'Real' | kw= 'Boolean' | (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' ) | (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' ) | this_classifierTypeRule_10= ruleclassifierTypeRule | (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' ) )
            int alt34=8;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt34=1;
                }
                break;
            case 75:
                {
                alt34=2;
                }
                break;
            case 76:
                {
                alt34=3;
                }
                break;
            case 77:
                {
                alt34=4;
                }
                break;
            case 78:
                {
                alt34=5;
                }
                break;
            case 79:
                {
                alt34=6;
                }
                break;
            case RULE_IDENT:
                {
                alt34=7;
                }
                break;
            case 20:
                {
                alt34=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalMyDsl.g:2282:3: kw= 'String'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getStringKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2288:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getIntegerKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2294:3: kw= 'Real'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getRealKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2300:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getBooleanKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2306:3: (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' )
                    {
                    // InternalMyDsl.g:2306:3: (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' )
                    // InternalMyDsl.g:2307:4: kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')'
                    {
                    kw=(Token)match(input,78,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getSequenceKeyword_4_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTypeLiteralAccess().getTypeLiteralParserRuleCall_4_1());
                      			
                    }
                    pushFollow(FOLLOW_15);
                    this_typeLiteral_5=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_typeLiteral_5);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_4_2());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2329:3: (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' )
                    {
                    // InternalMyDsl.g:2329:3: (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' )
                    // InternalMyDsl.g:2330:4: kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')'
                    {
                    kw=(Token)match(input,79,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getOrderedSetKeyword_5_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTypeLiteralAccess().getTypeLiteralParserRuleCall_5_1());
                      			
                    }
                    pushFollow(FOLLOW_15);
                    this_typeLiteral_8=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_typeLiteral_8);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_5_2());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:2352:3: this_classifierTypeRule_10= ruleclassifierTypeRule
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_classifierTypeRule_10=ruleclassifierTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_classifierTypeRule_10);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:2363:3: (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' )
                    {
                    // InternalMyDsl.g:2363:3: (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' )
                    // InternalMyDsl.g:2364:4: kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}'
                    {
                    kw=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getLeftCurlyBracketKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_44);
                    this_classifierTypeRule_12=ruleclassifierTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_classifierTypeRule_12);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyDsl.g:2379:4: (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==67) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalMyDsl.g:2380:5: kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule
                    	    {
                    	    kw=(Token)match(input,67,FOLLOW_7); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(kw);
                    	      					newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getVerticalLineKeyword_7_2_0());
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_2_1());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_44);
                    	    this_classifierTypeRule_14=ruleclassifierTypeRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(this_classifierTypeRule_14);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					afterParserOrEnumRuleCall();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getRightCurlyBracketKeyword_7_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruletypeLiteral"


    // $ANTLR start "entryRuleclassifierTypeRule"
    // InternalMyDsl.g:2406:1: entryRuleclassifierTypeRule returns [String current=null] : iv_ruleclassifierTypeRule= ruleclassifierTypeRule EOF ;
    public final String entryRuleclassifierTypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleclassifierTypeRule = null;


        try {
            // InternalMyDsl.g:2406:58: (iv_ruleclassifierTypeRule= ruleclassifierTypeRule EOF )
            // InternalMyDsl.g:2407:2: iv_ruleclassifierTypeRule= ruleclassifierTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassifierTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleclassifierTypeRule=ruleclassifierTypeRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleclassifierTypeRule.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleclassifierTypeRule"


    // $ANTLR start "ruleclassifierTypeRule"
    // InternalMyDsl.g:2413:1: ruleclassifierTypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT ) | (this_Ident_3= RULE_IDENT kw= ':' ) ) ;
    public final AntlrDatatypeRuleToken ruleclassifierTypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token kw=null;
        Token this_Ident_2=null;
        Token this_Ident_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2419:2: ( ( (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT ) | (this_Ident_3= RULE_IDENT kw= ':' ) ) )
            // InternalMyDsl.g:2420:2: ( (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT ) | (this_Ident_3= RULE_IDENT kw= ':' ) )
            {
            // InternalMyDsl.g:2420:2: ( (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT ) | (this_Ident_3= RULE_IDENT kw= ':' ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_IDENT) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==73) ) {
                    alt35=1;
                }
                else if ( (LA35_1==47) ) {
                    alt35=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalMyDsl.g:2421:3: (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT )
                    {
                    // InternalMyDsl.g:2421:3: (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT )
                    // InternalMyDsl.g:2422:4: this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT
                    {
                    this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_0, grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_0_0());
                      			
                    }
                    kw=(Token)match(input,73,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getClassifierTypeRuleAccess().getColonColonKeyword_0_1());
                      			
                    }
                    this_Ident_2=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_2, grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2443:3: (this_Ident_3= RULE_IDENT kw= ':' )
                    {
                    // InternalMyDsl.g:2443:3: (this_Ident_3= RULE_IDENT kw= ':' )
                    // InternalMyDsl.g:2444:4: this_Ident_3= RULE_IDENT kw= ':'
                    {
                    this_Ident_3=(Token)match(input,RULE_IDENT,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_3, grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_1_0());
                      			
                    }
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getClassifierTypeRuleAccess().getColonKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleclassifierTypeRule"

    // $ANTLR start synpred12_InternalMyDsl
    public final void synpred12_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_rVarDecl_0 = null;


        // InternalMyDsl.g:643:3: (this_rVarDecl_0= rulerVarDecl )
        // InternalMyDsl.g:643:3: this_rVarDecl_0= rulerVarDecl
        {
        if ( state.backtracking==0 ) {

          			newCompositeNode(grammarAccess.getRStatementAccess().getRVarDeclParserRuleCall_0());
          		
        }
        pushFollow(FOLLOW_2);
        this_rVarDecl_0=rulerVarDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalMyDsl

    // $ANTLR start synpred13_InternalMyDsl
    public final void synpred13_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_rAssign_1 = null;


        // InternalMyDsl.g:654:3: (this_rAssign_1= rulerAssign )
        // InternalMyDsl.g:654:3: this_rAssign_1= rulerAssign
        {
        if ( state.backtracking==0 ) {

          			newCompositeNode(grammarAccess.getRStatementAccess().getRAssignParserRuleCall_1());
          		
        }
        pushFollow(FOLLOW_2);
        this_rAssign_1=rulerAssign();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalMyDsl

    // $ANTLR start synpred16_InternalMyDsl
    public final void synpred16_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_rIf_4 = null;


        // InternalMyDsl.g:687:3: (this_rIf_4= rulerIf )
        // InternalMyDsl.g:687:3: this_rIf_4= rulerIf
        {
        if ( state.backtracking==0 ) {

          			newCompositeNode(grammarAccess.getRStatementAccess().getRIfParserRuleCall_4());
          		
        }
        pushFollow(FOLLOW_2);
        this_rIf_4=rulerIf();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalMyDsl

    // $ANTLR start synpred22_InternalMyDsl
    public final void synpred22_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_recExpression_1 = null;


        // InternalMyDsl.g:1181:4: (this_recExpression_1= rulerecExpression )
        // InternalMyDsl.g:1181:4: this_recExpression_1= rulerecExpression
        {
        if ( state.backtracking==0 ) {

          				newCompositeNode(grammarAccess.getExpressionAccess().getRecExpressionParserRuleCall_1());
          			
        }
        pushFollow(FOLLOW_2);
        this_recExpression_1=rulerecExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalMyDsl

    // $ANTLR start synpred30_InternalMyDsl
    public final void synpred30_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_recExpression_15 = null;


        // InternalMyDsl.g:1362:4: (this_recExpression_15= rulerecExpression )
        // InternalMyDsl.g:1362:4: this_recExpression_15= rulerecExpression
        {
        if ( state.backtracking==0 ) {

          				newCompositeNode(grammarAccess.getRecExpressionAccess().getRecExpressionParserRuleCall_1());
          			
        }
        pushFollow(FOLLOW_2);
        this_recExpression_15=rulerecExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalMyDsl

    // Delegated rules

    public final boolean synpred13_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalMyDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalMyDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalMyDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalMyDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalMyDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA32 dfa32 = new DFA32(this);
    static final String dfa_1s = "\34\uffff";
    static final String dfa_2s = "\1\4\25\0\6\uffff";
    static final String dfa_3s = "\1\117\25\0\6\uffff";
    static final String dfa_4s = "\26\uffff\1\3\1\4\1\1\1\2\1\6\1\5";
    static final String dfa_5s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\4\1\1\1\5\1\uffff\1\6\13\uffff\1\22\3\uffff\1\23\4\uffff\1\26\4\uffff\1\24\1\uffff\1\27\5\uffff\1\2\1\3\2\uffff\1\25\25\uffff\1\7\1\10\1\11\1\12\1\13\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "642:2: (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_1 = input.LA(1);

                         
                        int index12_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalMyDsl()) ) {s = 24;}

                        else if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_2 = input.LA(1);

                         
                        int index12_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_3 = input.LA(1);

                         
                        int index12_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_4 = input.LA(1);

                         
                        int index12_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA12_5 = input.LA(1);

                         
                        int index12_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA12_6 = input.LA(1);

                         
                        int index12_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA12_7 = input.LA(1);

                         
                        int index12_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA12_8 = input.LA(1);

                         
                        int index12_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA12_9 = input.LA(1);

                         
                        int index12_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA12_10 = input.LA(1);

                         
                        int index12_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA12_11 = input.LA(1);

                         
                        int index12_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA12_12 = input.LA(1);

                         
                        int index12_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA12_13 = input.LA(1);

                         
                        int index12_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA12_14 = input.LA(1);

                         
                        int index12_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA12_15 = input.LA(1);

                         
                        int index12_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA12_16 = input.LA(1);

                         
                        int index12_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA12_17 = input.LA(1);

                         
                        int index12_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA12_18 = input.LA(1);

                         
                        int index12_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA12_19 = input.LA(1);

                         
                        int index12_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA12_20 = input.LA(1);

                         
                        int index12_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (synpred16_InternalMyDsl()) ) {s = 27;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA12_21 = input.LA(1);

                         
                        int index12_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index12_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\24\uffff";
    static final String dfa_8s = "\1\22\23\uffff";
    static final String dfa_9s = "\1\7\21\0\2\uffff";
    static final String dfa_10s = "\1\70\21\0\2\uffff";
    static final String dfa_11s = "\22\uffff\1\2\1\1";
    static final String dfa_12s = "\1\uffff\1\0\1\14\1\20\1\11\1\15\1\12\1\13\1\5\1\10\1\1\1\3\1\16\1\2\1\6\1\17\1\7\1\4\2\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\11\uffff\1\1\1\22\2\uffff\1\22\3\uffff\1\22\1\uffff\2\22\1\uffff\1\22\4\uffff\1\22\1\uffff\1\16\1\17\1\20\1\21\1\2\1\uffff\1\5\2\22\2\uffff\1\12\1\4\1\6\1\7\1\10\1\11\1\13\1\14\1\15",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1180:3: (this_recExpression_1= rulerecExpression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_1 = input.LA(1);

                         
                        int index18_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_10 = input.LA(1);

                         
                        int index18_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_13 = input.LA(1);

                         
                        int index18_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_11 = input.LA(1);

                         
                        int index18_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_17 = input.LA(1);

                         
                        int index18_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_17);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_8 = input.LA(1);

                         
                        int index18_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_14 = input.LA(1);

                         
                        int index18_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_16 = input.LA(1);

                         
                        int index18_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA18_9 = input.LA(1);

                         
                        int index18_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA18_4 = input.LA(1);

                         
                        int index18_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_4);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA18_6 = input.LA(1);

                         
                        int index18_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_6);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA18_7 = input.LA(1);

                         
                        int index18_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_7);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA18_2 = input.LA(1);

                         
                        int index18_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_2);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA18_5 = input.LA(1);

                         
                        int index18_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_5);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA18_12 = input.LA(1);

                         
                        int index18_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_12);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA18_15 = input.LA(1);

                         
                        int index18_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_15);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA18_3 = input.LA(1);

                         
                        int index18_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index18_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1361:3: (this_recExpression_15= rulerecExpression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_1 = input.LA(1);

                         
                        int index20_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_10 = input.LA(1);

                         
                        int index20_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_13 = input.LA(1);

                         
                        int index20_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_11 = input.LA(1);

                         
                        int index20_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_17 = input.LA(1);

                         
                        int index20_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_17);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_8 = input.LA(1);

                         
                        int index20_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_14 = input.LA(1);

                         
                        int index20_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_16 = input.LA(1);

                         
                        int index20_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA20_9 = input.LA(1);

                         
                        int index20_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA20_4 = input.LA(1);

                         
                        int index20_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_4);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA20_6 = input.LA(1);

                         
                        int index20_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_6);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA20_7 = input.LA(1);

                         
                        int index20_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_7);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA20_2 = input.LA(1);

                         
                        int index20_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_2);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA20_5 = input.LA(1);

                         
                        int index20_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_5);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA20_12 = input.LA(1);

                         
                        int index20_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_12);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA20_15 = input.LA(1);

                         
                        int index20_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_15);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_14s = "\17\uffff";
    static final String dfa_15s = "\14\uffff\1\12\2\uffff";
    static final String dfa_16s = "\1\4\10\uffff\1\57\1\uffff\1\5\1\7\2\uffff";
    static final String dfa_17s = "\1\117\10\uffff\1\111\1\uffff\1\5\1\111\2\uffff";
    static final String dfa_18s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\2\uffff\1\12\1\11";
    static final String dfa_19s = "\17\uffff}>";
    static final String[] dfa_20s = {
            "\1\1\1\11\1\2\1\uffff\1\3\13\uffff\1\12\57\uffff\1\4\1\5\1\6\1\7\1\10\1\uffff\6\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\31\uffff\1\13",
            "",
            "\1\14",
            "\1\12\11\uffff\2\12\2\uffff\1\12\3\uffff\1\12\1\uffff\2\12\1\uffff\1\12\4\uffff\1\12\1\uffff\5\12\1\uffff\3\12\1\uffff\1\15\11\12\20\uffff\1\16",
            "",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "2103:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000098002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004E00020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004E00000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000004C00000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00004C0401100170L,0x000000000000FDF0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00004C0481100170L,0x000000000000FDF0L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00004C1421300170L,0x000000000000FDF0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x01FF0BE000020082L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xFE00000000000020L,0x0000000000000007L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000100170L,0x000000000000FDF0L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00004C0403100170L,0x000000000000FDF0L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00004C0401300170L,0x000000000000FDF0L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000008L});

}