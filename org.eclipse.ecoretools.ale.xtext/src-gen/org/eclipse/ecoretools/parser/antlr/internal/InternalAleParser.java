package org.eclipse.ecoretools.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.ecoretools.services.AleGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalAleParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENT", "RULE_INT", "RULE_MULT_OP", "RULE_ADD_OP", "RULE_COMP_OP", "RULE_STRING", "RULE_REAL", "RULE_LETTER", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'behavior'", "';'", "'import'", "'as'", "'use'", "'.'", "'open'", "'class'", "'extends'", "','", "'{'", "'}'", "'def'", "'override'", "'('", "')'", "'@'", "':='", "'for'", "'in'", "'['", "'..'", "']'", "'if'", "'else'", "'while'", "'and'", "'or'", "'xor'", "'implies'", "'->'", "'not'", "'-'", "'then'", "'endif'", "'let'", "':'", "'='", "'select'", "'reject'", "'collect'", "'any'", "'exists'", "'forAll'", "'isUnique'", "'one'", "'sortedBy'", "'closure'", "'|'", "'true'", "'false'", "'null'", "'Sequence{'", "'OrderedSet{'", "'::'", "'String'", "'Integer'", "'Real'", "'Boolean'", "'Sequence('", "'OrderedSet('"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__59=59;
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
    public static final int RULE_ID=12;
    public static final int RULE_REAL=10;
    public static final int RULE_IDENT=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=13;
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
    public static final int RULE_MULT_OP=6;
    public static final int RULE_STRING=9;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_COMP_OP=8;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int RULE_ADD_OP=7;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int RULE_WS=15;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_LETTER=11;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalAleParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAleParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAleParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAle.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private AleGrammarAccess grammarAccess;

        public InternalAleParser(TokenStream input, AleGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "rRoot";
       	}

       	@Override
       	protected AleGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulerRoot"
    // InternalAle.g:70:1: entryRulerRoot returns [EObject current=null] : iv_rulerRoot= rulerRoot EOF ;
    public final EObject entryRulerRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerRoot = null;


        try {
            // InternalAle.g:70:46: (iv_rulerRoot= rulerRoot EOF )
            // InternalAle.g:71:2: iv_rulerRoot= rulerRoot EOF
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
    // InternalAle.g:77:1: rulerRoot returns [EObject current=null] : (otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )* ) ;
    public final EObject rulerRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_xtendedClasses_5_0 = null;



        	enterRule();

        try {
            // InternalAle.g:83:2: ( (otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )* ) )
            // InternalAle.g:84:2: (otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )* )
            {
            // InternalAle.g:84:2: (otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )* )
            // InternalAle.g:85:3: otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )*
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRRootAccess().getBehaviorKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRRootAccess().getRQualifiedParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_4);
            rulerQualified();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,18,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRRootAccess().getSemicolonKeyword_2());
              		
            }
            // InternalAle.g:103:3: ( rulerImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==19) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAle.g:104:4: rulerImport
            	    {
            	    if ( state.backtracking==0 ) {

            	      				/* */
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getRRootAccess().getRImportParserRuleCall_3());
            	      			
            	    }
            	    pushFollow(FOLLOW_5);
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

            // InternalAle.g:115:3: ( rulerService )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==21) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalAle.g:116:4: rulerService
            	    {
            	    if ( state.backtracking==0 ) {

            	      				/* */
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getRRootAccess().getRServiceParserRuleCall_4());
            	      			
            	    }
            	    pushFollow(FOLLOW_6);
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

            // InternalAle.g:127:3: ( (lv_xtendedClasses_5_0= rulerClass ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=23 && LA3_0<=24)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAle.g:128:4: (lv_xtendedClasses_5_0= rulerClass )
            	    {
            	    // InternalAle.g:128:4: (lv_xtendedClasses_5_0= rulerClass )
            	    // InternalAle.g:129:5: lv_xtendedClasses_5_0= rulerClass
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRRootAccess().getXtendedClassesRClassParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_xtendedClasses_5_0=rulerClass();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRRootRule());
            	      					}
            	      					add(
            	      						current,
            	      						"xtendedClasses",
            	      						lv_xtendedClasses_5_0,
            	      						"org.eclipse.ecoretools.Ale.rClass");
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
    // InternalAle.g:150:1: entryRulerImport returns [String current=null] : iv_rulerImport= rulerImport EOF ;
    public final String entryRulerImport() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerImport = null;


        try {
            // InternalAle.g:150:47: (iv_rulerImport= rulerImport EOF )
            // InternalAle.g:151:2: iv_rulerImport= rulerImport EOF
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
    // InternalAle.g:157:1: rulerImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_IDENT_3= RULE_IDENT kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerImport() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_IDENT_3=null;
        AntlrDatatypeRuleToken this_rQualified_1 = null;



        	enterRule();

        try {
            // InternalAle.g:163:2: ( (kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_IDENT_3= RULE_IDENT kw= ';' ) )
            // InternalAle.g:164:2: (kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_IDENT_3= RULE_IDENT kw= ';' )
            {
            // InternalAle.g:164:2: (kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_IDENT_3= RULE_IDENT kw= ';' )
            // InternalAle.g:165:3: kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_IDENT_3= RULE_IDENT kw= ';'
            {
            kw=(Token)match(input,19,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRImportAccess().getImportKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRImportAccess().getRQualifiedParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_8);
            this_rQualified_1=rulerQualified();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_rQualified_1);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRImportAccess().getAsKeyword_2());
              		
            }
            this_IDENT_3=(Token)match(input,RULE_IDENT,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_IDENT_3);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_IDENT_3, grammarAccess.getRImportAccess().getIDENTTerminalRuleCall_3());
              		
            }
            kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRImportAccess().getSemicolonKeyword_4());
              		
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
    // InternalAle.g:201:1: entryRulerService returns [String current=null] : iv_rulerService= rulerService EOF ;
    public final String entryRulerService() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerService = null;


        try {
            // InternalAle.g:201:48: (iv_rulerService= rulerService EOF )
            // InternalAle.g:202:2: iv_rulerService= rulerService EOF
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
    // InternalAle.g:208:1: rulerService returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'use' this_IDENT_1= RULE_IDENT (kw= '.' this_IDENT_3= RULE_IDENT )* kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerService() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_IDENT_1=null;
        Token this_IDENT_3=null;


        	enterRule();

        try {
            // InternalAle.g:214:2: ( (kw= 'use' this_IDENT_1= RULE_IDENT (kw= '.' this_IDENT_3= RULE_IDENT )* kw= ';' ) )
            // InternalAle.g:215:2: (kw= 'use' this_IDENT_1= RULE_IDENT (kw= '.' this_IDENT_3= RULE_IDENT )* kw= ';' )
            {
            // InternalAle.g:215:2: (kw= 'use' this_IDENT_1= RULE_IDENT (kw= '.' this_IDENT_3= RULE_IDENT )* kw= ';' )
            // InternalAle.g:216:3: kw= 'use' this_IDENT_1= RULE_IDENT (kw= '.' this_IDENT_3= RULE_IDENT )* kw= ';'
            {
            kw=(Token)match(input,21,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRServiceAccess().getUseKeyword_0());
              		
            }
            this_IDENT_1=(Token)match(input,RULE_IDENT,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_IDENT_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_IDENT_1, grammarAccess.getRServiceAccess().getIDENTTerminalRuleCall_1());
              		
            }
            // InternalAle.g:228:3: (kw= '.' this_IDENT_3= RULE_IDENT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==22) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalAle.g:229:4: kw= '.' this_IDENT_3= RULE_IDENT
            	    {
            	    kw=(Token)match(input,22,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getRServiceAccess().getFullStopKeyword_2_0());
            	      			
            	    }
            	    this_IDENT_3=(Token)match(input,RULE_IDENT,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_IDENT_3);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_IDENT_3, grammarAccess.getRServiceAccess().getIDENTTerminalRuleCall_2_1());
            	      			
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
    // InternalAle.g:251:1: entryRulerClass returns [EObject current=null] : iv_rulerClass= rulerClass EOF ;
    public final EObject entryRulerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerClass = null;


        try {
            // InternalAle.g:251:47: (iv_rulerClass= rulerClass EOF )
            // InternalAle.g:252:2: iv_rulerClass= rulerClass EOF
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
    // InternalAle.g:258:1: rulerClass returns [EObject current=null] : ( ( () ( (lv_openClass_1_0= rulerOpenClass ) ) ) | ( () ( (lv_newClass_3_0= rulerNewClass ) ) ) ) ;
    public final EObject rulerClass() throws RecognitionException {
        EObject current = null;

        EObject lv_openClass_1_0 = null;

        EObject lv_newClass_3_0 = null;



        	enterRule();

        try {
            // InternalAle.g:264:2: ( ( ( () ( (lv_openClass_1_0= rulerOpenClass ) ) ) | ( () ( (lv_newClass_3_0= rulerNewClass ) ) ) ) )
            // InternalAle.g:265:2: ( ( () ( (lv_openClass_1_0= rulerOpenClass ) ) ) | ( () ( (lv_newClass_3_0= rulerNewClass ) ) ) )
            {
            // InternalAle.g:265:2: ( ( () ( (lv_openClass_1_0= rulerOpenClass ) ) ) | ( () ( (lv_newClass_3_0= rulerNewClass ) ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            else if ( (LA5_0==24) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalAle.g:266:3: ( () ( (lv_openClass_1_0= rulerOpenClass ) ) )
                    {
                    // InternalAle.g:266:3: ( () ( (lv_openClass_1_0= rulerOpenClass ) ) )
                    // InternalAle.g:267:4: () ( (lv_openClass_1_0= rulerOpenClass ) )
                    {
                    // InternalAle.g:267:4: ()
                    // InternalAle.g:268:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRClassAccess().getROpenClassAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:277:4: ( (lv_openClass_1_0= rulerOpenClass ) )
                    // InternalAle.g:278:5: (lv_openClass_1_0= rulerOpenClass )
                    {
                    // InternalAle.g:278:5: (lv_openClass_1_0= rulerOpenClass )
                    // InternalAle.g:279:6: lv_openClass_1_0= rulerOpenClass
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRClassAccess().getOpenClassROpenClassParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_openClass_1_0=rulerOpenClass();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRClassRule());
                      						}
                      						set(
                      							current,
                      							"openClass",
                      							lv_openClass_1_0,
                      							"org.eclipse.ecoretools.Ale.rOpenClass");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:298:3: ( () ( (lv_newClass_3_0= rulerNewClass ) ) )
                    {
                    // InternalAle.g:298:3: ( () ( (lv_newClass_3_0= rulerNewClass ) ) )
                    // InternalAle.g:299:4: () ( (lv_newClass_3_0= rulerNewClass ) )
                    {
                    // InternalAle.g:299:4: ()
                    // InternalAle.g:300:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRClassAccess().getRNewClassAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:309:4: ( (lv_newClass_3_0= rulerNewClass ) )
                    // InternalAle.g:310:5: (lv_newClass_3_0= rulerNewClass )
                    {
                    // InternalAle.g:310:5: (lv_newClass_3_0= rulerNewClass )
                    // InternalAle.g:311:6: lv_newClass_3_0= rulerNewClass
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRClassAccess().getNewClassRNewClassParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_newClass_3_0=rulerNewClass();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRClassRule());
                      						}
                      						set(
                      							current,
                      							"newClass",
                      							lv_newClass_3_0,
                      							"org.eclipse.ecoretools.Ale.rNewClass");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


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
    // $ANTLR end "rulerClass"


    // $ANTLR start "entryRulerOpenClass"
    // InternalAle.g:333:1: entryRulerOpenClass returns [EObject current=null] : iv_rulerOpenClass= rulerOpenClass EOF ;
    public final EObject entryRulerOpenClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerOpenClass = null;


        try {
            // InternalAle.g:333:51: (iv_rulerOpenClass= rulerOpenClass EOF )
            // InternalAle.g:334:2: iv_rulerOpenClass= rulerOpenClass EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getROpenClassRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerOpenClass=rulerOpenClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerOpenClass; 
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
    // $ANTLR end "entryRulerOpenClass"


    // $ANTLR start "rulerOpenClass"
    // InternalAle.g:340:1: rulerOpenClass returns [EObject current=null] : (otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= rulerQualified ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}' ) ;
    public final EObject rulerOpenClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_attributes_8_0 = null;

        EObject lv_operations_9_0 = null;



        	enterRule();

        try {
            // InternalAle.g:346:2: ( (otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= rulerQualified ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}' ) )
            // InternalAle.g:347:2: (otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= rulerQualified ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}' )
            {
            // InternalAle.g:347:2: (otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= rulerQualified ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}' )
            // InternalAle.g:348:3: otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= rulerQualified ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getROpenClassAccess().getOpenKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getROpenClassAccess().getClassKeyword_1());
              		
            }
            // InternalAle.g:356:3: ( (lv_name_2_0= rulerQualified ) )
            // InternalAle.g:357:4: (lv_name_2_0= rulerQualified )
            {
            // InternalAle.g:357:4: (lv_name_2_0= rulerQualified )
            // InternalAle.g:358:5: lv_name_2_0= rulerQualified
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getROpenClassAccess().getNameRQualifiedParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_name_2_0=rulerQualified();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getROpenClassRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.ecoretools.Ale.rQualified");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAle.g:375:3: (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAle.g:376:4: otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )*
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getROpenClassAccess().getExtendsKeyword_3_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getROpenClassAccess().getRQualifiedParserRuleCall_3_1());
                      			
                    }
                    pushFollow(FOLLOW_12);
                    rulerQualified();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalAle.g:390:4: (otherlv_5= ',' rulerQualified )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==26) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalAle.g:391:5: otherlv_5= ',' rulerQualified
                    	    {
                    	    otherlv_5=(Token)match(input,26,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getROpenClassAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					/* */
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getROpenClassAccess().getRQualifiedParserRuleCall_3_2_1());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_12);
                    	    rulerQualified();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					afterParserOrEnumRuleCall();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,27,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getROpenClassAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalAle.g:411:3: ( (lv_attributes_8_0= rulerAttribute ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_IDENT||LA8_0==27||(LA8_0>=72 && LA8_0<=77)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalAle.g:412:4: (lv_attributes_8_0= rulerAttribute )
            	    {
            	    // InternalAle.g:412:4: (lv_attributes_8_0= rulerAttribute )
            	    // InternalAle.g:413:5: lv_attributes_8_0= rulerAttribute
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getROpenClassAccess().getAttributesRAttributeParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_attributes_8_0=rulerAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getROpenClassRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attributes",
            	      						lv_attributes_8_0,
            	      						"org.eclipse.ecoretools.Ale.rAttribute");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalAle.g:430:3: ( (lv_operations_9_0= rulerOperation ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=29 && LA9_0<=30)||LA9_0==33) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAle.g:431:4: (lv_operations_9_0= rulerOperation )
            	    {
            	    // InternalAle.g:431:4: (lv_operations_9_0= rulerOperation )
            	    // InternalAle.g:432:5: lv_operations_9_0= rulerOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getROpenClassAccess().getOperationsROperationParserRuleCall_6_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_operations_9_0=rulerOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getROpenClassRule());
            	      					}
            	      					add(
            	      						current,
            	      						"operations",
            	      						lv_operations_9_0,
            	      						"org.eclipse.ecoretools.Ale.rOperation");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_10=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getROpenClassAccess().getRightCurlyBracketKeyword_7());
              		
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
    // $ANTLR end "rulerOpenClass"


    // $ANTLR start "entryRulerNewClass"
    // InternalAle.g:457:1: entryRulerNewClass returns [EObject current=null] : iv_rulerNewClass= rulerNewClass EOF ;
    public final EObject entryRulerNewClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerNewClass = null;


        try {
            // InternalAle.g:457:50: (iv_rulerNewClass= rulerNewClass EOF )
            // InternalAle.g:458:2: iv_rulerNewClass= rulerNewClass EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRNewClassRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerNewClass=rulerNewClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerNewClass; 
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
    // $ANTLR end "entryRulerNewClass"


    // $ANTLR start "rulerNewClass"
    // InternalAle.g:464:1: rulerNewClass returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= rulerQualified ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' ) ;
    public final EObject rulerNewClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_attributes_3_0 = null;

        EObject lv_operations_4_0 = null;



        	enterRule();

        try {
            // InternalAle.g:470:2: ( (otherlv_0= 'class' ( (lv_name_1_0= rulerQualified ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' ) )
            // InternalAle.g:471:2: (otherlv_0= 'class' ( (lv_name_1_0= rulerQualified ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' )
            {
            // InternalAle.g:471:2: (otherlv_0= 'class' ( (lv_name_1_0= rulerQualified ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' )
            // InternalAle.g:472:3: otherlv_0= 'class' ( (lv_name_1_0= rulerQualified ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRNewClassAccess().getClassKeyword_0());
              		
            }
            // InternalAle.g:476:3: ( (lv_name_1_0= rulerQualified ) )
            // InternalAle.g:477:4: (lv_name_1_0= rulerQualified )
            {
            // InternalAle.g:477:4: (lv_name_1_0= rulerQualified )
            // InternalAle.g:478:5: lv_name_1_0= rulerQualified
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRNewClassAccess().getNameRQualifiedParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_name_1_0=rulerQualified();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRNewClassRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.ecoretools.Ale.rQualified");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRNewClassAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalAle.g:499:3: ( (lv_attributes_3_0= rulerAttribute ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_IDENT||LA10_0==27||(LA10_0>=72 && LA10_0<=77)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalAle.g:500:4: (lv_attributes_3_0= rulerAttribute )
            	    {
            	    // InternalAle.g:500:4: (lv_attributes_3_0= rulerAttribute )
            	    // InternalAle.g:501:5: lv_attributes_3_0= rulerAttribute
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRNewClassAccess().getAttributesRAttributeParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_attributes_3_0=rulerAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRNewClassRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attributes",
            	      						lv_attributes_3_0,
            	      						"org.eclipse.ecoretools.Ale.rAttribute");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalAle.g:518:3: ( (lv_operations_4_0= rulerOperation ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=29 && LA11_0<=30)||LA11_0==33) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAle.g:519:4: (lv_operations_4_0= rulerOperation )
            	    {
            	    // InternalAle.g:519:4: (lv_operations_4_0= rulerOperation )
            	    // InternalAle.g:520:5: lv_operations_4_0= rulerOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRNewClassAccess().getOperationsROperationParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_operations_4_0=rulerOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRNewClassRule());
            	      					}
            	      					add(
            	      						current,
            	      						"operations",
            	      						lv_operations_4_0,
            	      						"org.eclipse.ecoretools.Ale.rOperation");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_5=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRNewClassAccess().getRightCurlyBracketKeyword_5());
              		
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
    // $ANTLR end "rulerNewClass"


    // $ANTLR start "entryRulerOperation"
    // InternalAle.g:545:1: entryRulerOperation returns [EObject current=null] : iv_rulerOperation= rulerOperation EOF ;
    public final EObject entryRulerOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerOperation = null;


        try {
            // InternalAle.g:545:51: (iv_rulerOperation= rulerOperation EOF )
            // InternalAle.g:546:2: iv_rulerOperation= rulerOperation EOF
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
    // InternalAle.g:552:1: rulerOperation returns [EObject current=null] : ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= rulerType ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) ) ;
    public final EObject rulerOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_type_3_0 = null;

        EObject lv_paramList_6_0 = null;

        EObject lv_body_8_0 = null;



        	enterRule();

        try {
            // InternalAle.g:558:2: ( ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= rulerType ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) ) )
            // InternalAle.g:559:2: ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= rulerType ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) )
            {
            // InternalAle.g:559:2: ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= rulerType ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) )
            // InternalAle.g:560:3: ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= rulerType ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) )
            {
            // InternalAle.g:560:3: ( rulerTag )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==33) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAle.g:561:4: rulerTag
            	    {
            	    if ( state.backtracking==0 ) {

            	      				/* */
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getROperationAccess().getRTagParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_16);
            	    rulerTag();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalAle.g:572:3: (otherlv_1= 'def' | otherlv_2= 'override' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==29) ) {
                alt13=1;
            }
            else if ( (LA13_0==30) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalAle.g:573:4: otherlv_1= 'def'
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getROperationAccess().getDefKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalAle.g:578:4: otherlv_2= 'override'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getROperationAccess().getOverrideKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalAle.g:583:3: ( (lv_type_3_0= rulerType ) )
            // InternalAle.g:584:4: (lv_type_3_0= rulerType )
            {
            // InternalAle.g:584:4: (lv_type_3_0= rulerType )
            // InternalAle.g:585:5: lv_type_3_0= rulerType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getROperationAccess().getTypeRTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_3_0=rulerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getROperationRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_3_0,
              						"org.eclipse.ecoretools.Ale.rType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAle.g:602:3: ( (lv_name_4_0= RULE_IDENT ) )
            // InternalAle.g:603:4: (lv_name_4_0= RULE_IDENT )
            {
            // InternalAle.g:603:4: (lv_name_4_0= RULE_IDENT )
            // InternalAle.g:604:5: lv_name_4_0= RULE_IDENT
            {
            lv_name_4_0=(Token)match(input,RULE_IDENT,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getROperationAccess().getNameIDENTTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getROperationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.ecoretools.Ale.IDENT");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,31,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getROperationAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalAle.g:624:3: ( (lv_paramList_6_0= rulerParameters ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_IDENT||LA14_0==27||(LA14_0>=72 && LA14_0<=77)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAle.g:625:4: (lv_paramList_6_0= rulerParameters )
                    {
                    // InternalAle.g:625:4: (lv_paramList_6_0= rulerParameters )
                    // InternalAle.g:626:5: lv_paramList_6_0= rulerParameters
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getROperationAccess().getParamListRParametersParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
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
                      						"org.eclipse.ecoretools.Ale.rParameters");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,32,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getROperationAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalAle.g:647:3: ( (lv_body_8_0= rulerBlock ) )
            // InternalAle.g:648:4: (lv_body_8_0= rulerBlock )
            {
            // InternalAle.g:648:4: (lv_body_8_0= rulerBlock )
            // InternalAle.g:649:5: lv_body_8_0= rulerBlock
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
              						"org.eclipse.ecoretools.Ale.rBlock");
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
    // InternalAle.g:670:1: entryRulerTag returns [String current=null] : iv_rulerTag= rulerTag EOF ;
    public final String entryRulerTag() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerTag = null;


        try {
            // InternalAle.g:670:44: (iv_rulerTag= rulerTag EOF )
            // InternalAle.g:671:2: iv_rulerTag= rulerTag EOF
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
    // InternalAle.g:677:1: rulerTag returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '@' this_IDENT_1= RULE_IDENT ) ;
    public final AntlrDatatypeRuleToken rulerTag() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_IDENT_1=null;


        	enterRule();

        try {
            // InternalAle.g:683:2: ( (kw= '@' this_IDENT_1= RULE_IDENT ) )
            // InternalAle.g:684:2: (kw= '@' this_IDENT_1= RULE_IDENT )
            {
            // InternalAle.g:684:2: (kw= '@' this_IDENT_1= RULE_IDENT )
            // InternalAle.g:685:3: kw= '@' this_IDENT_1= RULE_IDENT
            {
            kw=(Token)match(input,33,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRTagAccess().getCommercialAtKeyword_0());
              		
            }
            this_IDENT_1=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_IDENT_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_IDENT_1, grammarAccess.getRTagAccess().getIDENTTerminalRuleCall_1());
              		
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
    // InternalAle.g:701:1: entryRulerParameters returns [EObject current=null] : iv_rulerParameters= rulerParameters EOF ;
    public final EObject entryRulerParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerParameters = null;


        try {
            // InternalAle.g:701:52: (iv_rulerParameters= rulerParameters EOF )
            // InternalAle.g:702:2: iv_rulerParameters= rulerParameters EOF
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
    // InternalAle.g:708:1: rulerParameters returns [EObject current=null] : ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* ) ;
    public final EObject rulerParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_params_0_0 = null;

        EObject lv_params_2_0 = null;



        	enterRule();

        try {
            // InternalAle.g:714:2: ( ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* ) )
            // InternalAle.g:715:2: ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* )
            {
            // InternalAle.g:715:2: ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* )
            // InternalAle.g:716:3: ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )*
            {
            // InternalAle.g:716:3: ( (lv_params_0_0= rulerVariable ) )
            // InternalAle.g:717:4: (lv_params_0_0= rulerVariable )
            {
            // InternalAle.g:717:4: (lv_params_0_0= rulerVariable )
            // InternalAle.g:718:5: lv_params_0_0= rulerVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_21);
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
              						"org.eclipse.ecoretools.Ale.rVariable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAle.g:735:3: (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==26) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalAle.g:736:4: otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getRParametersAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalAle.g:740:4: ( (lv_params_2_0= rulerVariable ) )
            	    // InternalAle.g:741:5: (lv_params_2_0= rulerVariable )
            	    {
            	    // InternalAle.g:741:5: (lv_params_2_0= rulerVariable )
            	    // InternalAle.g:742:6: lv_params_2_0= rulerVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
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
            	      							"org.eclipse.ecoretools.Ale.rVariable");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalAle.g:764:1: entryRulerVariable returns [EObject current=null] : iv_rulerVariable= rulerVariable EOF ;
    public final EObject entryRulerVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerVariable = null;


        try {
            // InternalAle.g:764:50: (iv_rulerVariable= rulerVariable EOF )
            // InternalAle.g:765:2: iv_rulerVariable= rulerVariable EOF
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
    // InternalAle.g:771:1: rulerVariable returns [EObject current=null] : ( ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) ) ) ;
    public final EObject rulerVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalAle.g:777:2: ( ( ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) ) ) )
            // InternalAle.g:778:2: ( ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) ) )
            {
            // InternalAle.g:778:2: ( ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) ) )
            // InternalAle.g:779:3: ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) )
            {
            // InternalAle.g:779:3: ( (lv_type_0_0= rulerType ) )
            // InternalAle.g:780:4: (lv_type_0_0= rulerType )
            {
            // InternalAle.g:780:4: (lv_type_0_0= rulerType )
            // InternalAle.g:781:5: lv_type_0_0= rulerType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRVariableAccess().getTypeRTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=rulerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"org.eclipse.ecoretools.Ale.rType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAle.g:798:3: ( (lv_name_1_0= RULE_IDENT ) )
            // InternalAle.g:799:4: (lv_name_1_0= RULE_IDENT )
            {
            // InternalAle.g:799:4: (lv_name_1_0= RULE_IDENT )
            // InternalAle.g:800:5: lv_name_1_0= RULE_IDENT
            {
            lv_name_1_0=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRVariableAccess().getNameIDENTTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.ecoretools.Ale.IDENT");
              				
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
    // InternalAle.g:820:1: entryRulerAttribute returns [EObject current=null] : iv_rulerAttribute= rulerAttribute EOF ;
    public final EObject entryRulerAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerAttribute = null;


        try {
            // InternalAle.g:820:51: (iv_rulerAttribute= rulerAttribute EOF )
            // InternalAle.g:821:2: iv_rulerAttribute= rulerAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerAttribute=rulerAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerAttribute; 
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
    // InternalAle.g:827:1: rulerAttribute returns [EObject current=null] : ( ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expr_3_0= ruleexpression ) ) )? otherlv_4= ';' ) ;
    public final EObject rulerAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_0_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalAle.g:833:2: ( ( ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expr_3_0= ruleexpression ) ) )? otherlv_4= ';' ) )
            // InternalAle.g:834:2: ( ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expr_3_0= ruleexpression ) ) )? otherlv_4= ';' )
            {
            // InternalAle.g:834:2: ( ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expr_3_0= ruleexpression ) ) )? otherlv_4= ';' )
            // InternalAle.g:835:3: ( (lv_type_0_0= rulerType ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expr_3_0= ruleexpression ) ) )? otherlv_4= ';'
            {
            // InternalAle.g:835:3: ( (lv_type_0_0= rulerType ) )
            // InternalAle.g:836:4: (lv_type_0_0= rulerType )
            {
            // InternalAle.g:836:4: (lv_type_0_0= rulerType )
            // InternalAle.g:837:5: lv_type_0_0= rulerType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRAttributeAccess().getTypeRTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=rulerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRAttributeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"org.eclipse.ecoretools.Ale.rType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAle.g:854:3: ( (lv_name_1_0= RULE_IDENT ) )
            // InternalAle.g:855:4: (lv_name_1_0= RULE_IDENT )
            {
            // InternalAle.g:855:4: (lv_name_1_0= RULE_IDENT )
            // InternalAle.g:856:5: lv_name_1_0= RULE_IDENT
            {
            lv_name_1_0=(Token)match(input,RULE_IDENT,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRAttributeAccess().getNameIDENTTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRAttributeRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.ecoretools.Ale.IDENT");
              				
            }

            }


            }

            // InternalAle.g:872:3: (otherlv_2= ':=' ( (lv_expr_3_0= ruleexpression ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==34) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAle.g:873:4: otherlv_2= ':=' ( (lv_expr_3_0= ruleexpression ) )
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRAttributeAccess().getColonEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalAle.g:877:4: ( (lv_expr_3_0= ruleexpression ) )
                    // InternalAle.g:878:5: (lv_expr_3_0= ruleexpression )
                    {
                    // InternalAle.g:878:5: (lv_expr_3_0= ruleexpression )
                    // InternalAle.g:879:6: lv_expr_3_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRAttributeAccess().getExprExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_expr_3_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRAttributeRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_3_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRAttributeAccess().getSemicolonKeyword_3());
              		
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
    // InternalAle.g:905:1: entryRulerStatement returns [EObject current=null] : iv_rulerStatement= rulerStatement EOF ;
    public final EObject entryRulerStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerStatement = null;


        try {
            // InternalAle.g:905:51: (iv_rulerStatement= rulerStatement EOF )
            // InternalAle.g:906:2: iv_rulerStatement= rulerStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerStatement=rulerStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerStatement; 
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
    // InternalAle.g:912:1: rulerStatement returns [EObject current=null] : ( ( () ( (lv_stmt_1_0= rulerVarDecl ) ) ) | ( () ( (lv_stmt_3_0= rulerAssign ) ) ) | ( () ( (lv_forEach_5_0= rulerForEach ) ) ) | ( () ( (lv_while_7_0= rulerWhile ) ) ) | ( () ( (lv_if_9_0= rulerIf ) ) ) | ( () ( (lv_expr_11_0= rulerExpression ) ) ) ) ;
    public final EObject rulerStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_stmt_1_0 = null;

        EObject lv_stmt_3_0 = null;

        EObject lv_forEach_5_0 = null;

        EObject lv_while_7_0 = null;

        EObject lv_if_9_0 = null;

        EObject lv_expr_11_0 = null;



        	enterRule();

        try {
            // InternalAle.g:918:2: ( ( ( () ( (lv_stmt_1_0= rulerVarDecl ) ) ) | ( () ( (lv_stmt_3_0= rulerAssign ) ) ) | ( () ( (lv_forEach_5_0= rulerForEach ) ) ) | ( () ( (lv_while_7_0= rulerWhile ) ) ) | ( () ( (lv_if_9_0= rulerIf ) ) ) | ( () ( (lv_expr_11_0= rulerExpression ) ) ) ) )
            // InternalAle.g:919:2: ( ( () ( (lv_stmt_1_0= rulerVarDecl ) ) ) | ( () ( (lv_stmt_3_0= rulerAssign ) ) ) | ( () ( (lv_forEach_5_0= rulerForEach ) ) ) | ( () ( (lv_while_7_0= rulerWhile ) ) ) | ( () ( (lv_if_9_0= rulerIf ) ) ) | ( () ( (lv_expr_11_0= rulerExpression ) ) ) )
            {
            // InternalAle.g:919:2: ( ( () ( (lv_stmt_1_0= rulerVarDecl ) ) ) | ( () ( (lv_stmt_3_0= rulerAssign ) ) ) | ( () ( (lv_forEach_5_0= rulerForEach ) ) ) | ( () ( (lv_while_7_0= rulerWhile ) ) ) | ( () ( (lv_if_9_0= rulerIf ) ) ) | ( () ( (lv_expr_11_0= rulerExpression ) ) ) )
            int alt17=6;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalAle.g:920:3: ( () ( (lv_stmt_1_0= rulerVarDecl ) ) )
                    {
                    // InternalAle.g:920:3: ( () ( (lv_stmt_1_0= rulerVarDecl ) ) )
                    // InternalAle.g:921:4: () ( (lv_stmt_1_0= rulerVarDecl ) )
                    {
                    // InternalAle.g:921:4: ()
                    // InternalAle.g:922:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRStatementAccess().getRValDeclAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:931:4: ( (lv_stmt_1_0= rulerVarDecl ) )
                    // InternalAle.g:932:5: (lv_stmt_1_0= rulerVarDecl )
                    {
                    // InternalAle.g:932:5: (lv_stmt_1_0= rulerVarDecl )
                    // InternalAle.g:933:6: lv_stmt_1_0= rulerVarDecl
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRStatementAccess().getStmtRVarDeclParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_stmt_1_0=rulerVarDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRStatementRule());
                      						}
                      						set(
                      							current,
                      							"stmt",
                      							lv_stmt_1_0,
                      							"org.eclipse.ecoretools.Ale.rVarDecl");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:952:3: ( () ( (lv_stmt_3_0= rulerAssign ) ) )
                    {
                    // InternalAle.g:952:3: ( () ( (lv_stmt_3_0= rulerAssign ) ) )
                    // InternalAle.g:953:4: () ( (lv_stmt_3_0= rulerAssign ) )
                    {
                    // InternalAle.g:953:4: ()
                    // InternalAle.g:954:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRStatementAccess().getRAssignAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:963:4: ( (lv_stmt_3_0= rulerAssign ) )
                    // InternalAle.g:964:5: (lv_stmt_3_0= rulerAssign )
                    {
                    // InternalAle.g:964:5: (lv_stmt_3_0= rulerAssign )
                    // InternalAle.g:965:6: lv_stmt_3_0= rulerAssign
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRStatementAccess().getStmtRAssignParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_stmt_3_0=rulerAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRStatementRule());
                      						}
                      						set(
                      							current,
                      							"stmt",
                      							lv_stmt_3_0,
                      							"org.eclipse.ecoretools.Ale.rAssign");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:984:3: ( () ( (lv_forEach_5_0= rulerForEach ) ) )
                    {
                    // InternalAle.g:984:3: ( () ( (lv_forEach_5_0= rulerForEach ) ) )
                    // InternalAle.g:985:4: () ( (lv_forEach_5_0= rulerForEach ) )
                    {
                    // InternalAle.g:985:4: ()
                    // InternalAle.g:986:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRStatementAccess().getRForEachAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:995:4: ( (lv_forEach_5_0= rulerForEach ) )
                    // InternalAle.g:996:5: (lv_forEach_5_0= rulerForEach )
                    {
                    // InternalAle.g:996:5: (lv_forEach_5_0= rulerForEach )
                    // InternalAle.g:997:6: lv_forEach_5_0= rulerForEach
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRStatementAccess().getForEachRForEachParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_forEach_5_0=rulerForEach();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRStatementRule());
                      						}
                      						set(
                      							current,
                      							"forEach",
                      							lv_forEach_5_0,
                      							"org.eclipse.ecoretools.Ale.rForEach");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1016:3: ( () ( (lv_while_7_0= rulerWhile ) ) )
                    {
                    // InternalAle.g:1016:3: ( () ( (lv_while_7_0= rulerWhile ) ) )
                    // InternalAle.g:1017:4: () ( (lv_while_7_0= rulerWhile ) )
                    {
                    // InternalAle.g:1017:4: ()
                    // InternalAle.g:1018:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRStatementAccess().getRWhileAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:1027:4: ( (lv_while_7_0= rulerWhile ) )
                    // InternalAle.g:1028:5: (lv_while_7_0= rulerWhile )
                    {
                    // InternalAle.g:1028:5: (lv_while_7_0= rulerWhile )
                    // InternalAle.g:1029:6: lv_while_7_0= rulerWhile
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRStatementAccess().getWhileRWhileParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_while_7_0=rulerWhile();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRStatementRule());
                      						}
                      						set(
                      							current,
                      							"while",
                      							lv_while_7_0,
                      							"org.eclipse.ecoretools.Ale.rWhile");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1048:3: ( () ( (lv_if_9_0= rulerIf ) ) )
                    {
                    // InternalAle.g:1048:3: ( () ( (lv_if_9_0= rulerIf ) ) )
                    // InternalAle.g:1049:4: () ( (lv_if_9_0= rulerIf ) )
                    {
                    // InternalAle.g:1049:4: ()
                    // InternalAle.g:1050:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRStatementAccess().getRIfAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:1059:4: ( (lv_if_9_0= rulerIf ) )
                    // InternalAle.g:1060:5: (lv_if_9_0= rulerIf )
                    {
                    // InternalAle.g:1060:5: (lv_if_9_0= rulerIf )
                    // InternalAle.g:1061:6: lv_if_9_0= rulerIf
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRStatementAccess().getIfRIfParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_if_9_0=rulerIf();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRStatementRule());
                      						}
                      						set(
                      							current,
                      							"if",
                      							lv_if_9_0,
                      							"org.eclipse.ecoretools.Ale.rIf");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1080:3: ( () ( (lv_expr_11_0= rulerExpression ) ) )
                    {
                    // InternalAle.g:1080:3: ( () ( (lv_expr_11_0= rulerExpression ) ) )
                    // InternalAle.g:1081:4: () ( (lv_expr_11_0= rulerExpression ) )
                    {
                    // InternalAle.g:1081:4: ()
                    // InternalAle.g:1082:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRStatementAccess().getRExpressionAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:1091:4: ( (lv_expr_11_0= rulerExpression ) )
                    // InternalAle.g:1092:5: (lv_expr_11_0= rulerExpression )
                    {
                    // InternalAle.g:1092:5: (lv_expr_11_0= rulerExpression )
                    // InternalAle.g:1093:6: lv_expr_11_0= rulerExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRStatementAccess().getExprRExpressionParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_11_0=rulerExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRStatementRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_11_0,
                      							"org.eclipse.ecoretools.Ale.rExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


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
    // $ANTLR end "rulerStatement"


    // $ANTLR start "entryRulerVarDecl"
    // InternalAle.g:1115:1: entryRulerVarDecl returns [EObject current=null] : iv_rulerVarDecl= rulerVarDecl EOF ;
    public final EObject entryRulerVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerVarDecl = null;


        try {
            // InternalAle.g:1115:49: (iv_rulerVarDecl= rulerVarDecl EOF )
            // InternalAle.g:1116:2: iv_rulerVarDecl= rulerVarDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRVarDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerVarDecl=rulerVarDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerVarDecl; 
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
    // InternalAle.g:1122:1: rulerVarDecl returns [EObject current=null] : ( ( (lv_type_0_0= rulerType ) ) ( (lv_ident_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expression_3_0= ruleexpression ) ) )? otherlv_4= ';' ) ;
    public final EObject rulerVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_ident_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_0_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1128:2: ( ( ( (lv_type_0_0= rulerType ) ) ( (lv_ident_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expression_3_0= ruleexpression ) ) )? otherlv_4= ';' ) )
            // InternalAle.g:1129:2: ( ( (lv_type_0_0= rulerType ) ) ( (lv_ident_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expression_3_0= ruleexpression ) ) )? otherlv_4= ';' )
            {
            // InternalAle.g:1129:2: ( ( (lv_type_0_0= rulerType ) ) ( (lv_ident_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expression_3_0= ruleexpression ) ) )? otherlv_4= ';' )
            // InternalAle.g:1130:3: ( (lv_type_0_0= rulerType ) ) ( (lv_ident_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ( (lv_expression_3_0= ruleexpression ) ) )? otherlv_4= ';'
            {
            // InternalAle.g:1130:3: ( (lv_type_0_0= rulerType ) )
            // InternalAle.g:1131:4: (lv_type_0_0= rulerType )
            {
            // InternalAle.g:1131:4: (lv_type_0_0= rulerType )
            // InternalAle.g:1132:5: lv_type_0_0= rulerType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRVarDeclAccess().getTypeRTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=rulerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRVarDeclRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"org.eclipse.ecoretools.Ale.rType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAle.g:1149:3: ( (lv_ident_1_0= RULE_IDENT ) )
            // InternalAle.g:1150:4: (lv_ident_1_0= RULE_IDENT )
            {
            // InternalAle.g:1150:4: (lv_ident_1_0= RULE_IDENT )
            // InternalAle.g:1151:5: lv_ident_1_0= RULE_IDENT
            {
            lv_ident_1_0=(Token)match(input,RULE_IDENT,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_ident_1_0, grammarAccess.getRVarDeclAccess().getIdentIDENTTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRVarDeclRule());
              					}
              					setWithLastConsumed(
              						current,
              						"ident",
              						lv_ident_1_0,
              						"org.eclipse.ecoretools.Ale.IDENT");
              				
            }

            }


            }

            // InternalAle.g:1167:3: (otherlv_2= ':=' ( (lv_expression_3_0= ruleexpression ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==34) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAle.g:1168:4: otherlv_2= ':=' ( (lv_expression_3_0= ruleexpression ) )
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRVarDeclAccess().getColonEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalAle.g:1172:4: ( (lv_expression_3_0= ruleexpression ) )
                    // InternalAle.g:1173:5: (lv_expression_3_0= ruleexpression )
                    {
                    // InternalAle.g:1173:5: (lv_expression_3_0= ruleexpression )
                    // InternalAle.g:1174:6: lv_expression_3_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRVarDeclAccess().getExpressionExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_expression_3_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRVarDeclRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_3_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRVarDeclAccess().getSemicolonKeyword_3());
              		
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
    // InternalAle.g:1200:1: entryRulerAssign returns [EObject current=null] : iv_rulerAssign= rulerAssign EOF ;
    public final EObject entryRulerAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerAssign = null;


        try {
            // InternalAle.g:1200:48: (iv_rulerAssign= rulerAssign EOF )
            // InternalAle.g:1201:2: iv_rulerAssign= rulerAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerAssign=rulerAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerAssign; 
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
    // InternalAle.g:1207:1: rulerAssign returns [EObject current=null] : ( ( (lv_left_0_0= ruleexpression ) ) otherlv_1= ':=' ( (lv_right_2_0= ruleexpression ) ) otherlv_3= ';' ) ;
    public final EObject rulerAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1213:2: ( ( ( (lv_left_0_0= ruleexpression ) ) otherlv_1= ':=' ( (lv_right_2_0= ruleexpression ) ) otherlv_3= ';' ) )
            // InternalAle.g:1214:2: ( ( (lv_left_0_0= ruleexpression ) ) otherlv_1= ':=' ( (lv_right_2_0= ruleexpression ) ) otherlv_3= ';' )
            {
            // InternalAle.g:1214:2: ( ( (lv_left_0_0= ruleexpression ) ) otherlv_1= ':=' ( (lv_right_2_0= ruleexpression ) ) otherlv_3= ';' )
            // InternalAle.g:1215:3: ( (lv_left_0_0= ruleexpression ) ) otherlv_1= ':=' ( (lv_right_2_0= ruleexpression ) ) otherlv_3= ';'
            {
            // InternalAle.g:1215:3: ( (lv_left_0_0= ruleexpression ) )
            // InternalAle.g:1216:4: (lv_left_0_0= ruleexpression )
            {
            // InternalAle.g:1216:4: (lv_left_0_0= ruleexpression )
            // InternalAle.g:1217:5: lv_left_0_0= ruleexpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRAssignAccess().getLeftExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_left_0_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRAssignRule());
              					}
              					set(
              						current,
              						"left",
              						lv_left_0_0,
              						"org.eclipse.ecoretools.Ale.expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRAssignAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalAle.g:1238:3: ( (lv_right_2_0= ruleexpression ) )
            // InternalAle.g:1239:4: (lv_right_2_0= ruleexpression )
            {
            // InternalAle.g:1239:4: (lv_right_2_0= ruleexpression )
            // InternalAle.g:1240:5: lv_right_2_0= ruleexpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRAssignAccess().getRightExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_right_2_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRAssignRule());
              					}
              					set(
              						current,
              						"right",
              						lv_right_2_0,
              						"org.eclipse.ecoretools.Ale.expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRAssignAccess().getSemicolonKeyword_3());
              		
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
    // InternalAle.g:1265:1: entryRulerForEach returns [EObject current=null] : iv_rulerForEach= rulerForEach EOF ;
    public final EObject entryRulerForEach() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerForEach = null;


        try {
            // InternalAle.g:1265:49: (iv_rulerForEach= rulerForEach EOF )
            // InternalAle.g:1266:2: iv_rulerForEach= rulerForEach EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRForEachRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerForEach=rulerForEach();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerForEach; 
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
    // InternalAle.g:1272:1: rulerForEach returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' this_IDENT_2= RULE_IDENT otherlv_3= 'in' this_rCollection_4= rulerCollection otherlv_5= ')' ( (lv_block_6_0= rulerBlock ) ) ) ;
    public final EObject rulerForEach() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_IDENT_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_rCollection_4 = null;

        EObject lv_block_6_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1278:2: ( (otherlv_0= 'for' otherlv_1= '(' this_IDENT_2= RULE_IDENT otherlv_3= 'in' this_rCollection_4= rulerCollection otherlv_5= ')' ( (lv_block_6_0= rulerBlock ) ) ) )
            // InternalAle.g:1279:2: (otherlv_0= 'for' otherlv_1= '(' this_IDENT_2= RULE_IDENT otherlv_3= 'in' this_rCollection_4= rulerCollection otherlv_5= ')' ( (lv_block_6_0= rulerBlock ) ) )
            {
            // InternalAle.g:1279:2: (otherlv_0= 'for' otherlv_1= '(' this_IDENT_2= RULE_IDENT otherlv_3= 'in' this_rCollection_4= rulerCollection otherlv_5= ')' ( (lv_block_6_0= rulerBlock ) ) )
            // InternalAle.g:1280:3: otherlv_0= 'for' otherlv_1= '(' this_IDENT_2= RULE_IDENT otherlv_3= 'in' this_rCollection_4= rulerCollection otherlv_5= ')' ( (lv_block_6_0= rulerBlock ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRForEachAccess().getForKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,31,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRForEachAccess().getLeftParenthesisKeyword_1());
              		
            }
            this_IDENT_2=(Token)match(input,RULE_IDENT,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_IDENT_2, grammarAccess.getRForEachAccess().getIDENTTerminalRuleCall_2());
              		
            }
            otherlv_3=(Token)match(input,36,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRForEachAccess().getInKeyword_3());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRForEachAccess().getRCollectionParserRuleCall_4());
              		
            }
            pushFollow(FOLLOW_20);
            this_rCollection_4=rulerCollection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_rCollection_4;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_5=(Token)match(input,32,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRForEachAccess().getRightParenthesisKeyword_5());
              		
            }
            // InternalAle.g:1311:3: ( (lv_block_6_0= rulerBlock ) )
            // InternalAle.g:1312:4: (lv_block_6_0= rulerBlock )
            {
            // InternalAle.g:1312:4: (lv_block_6_0= rulerBlock )
            // InternalAle.g:1313:5: lv_block_6_0= rulerBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRForEachAccess().getBlockRBlockParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_6_0=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRForEachRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_6_0,
              						"org.eclipse.ecoretools.Ale.rBlock");
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
    // $ANTLR end "rulerForEach"


    // $ANTLR start "entryRulerCollection"
    // InternalAle.g:1334:1: entryRulerCollection returns [EObject current=null] : iv_rulerCollection= rulerCollection EOF ;
    public final EObject entryRulerCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerCollection = null;


        try {
            // InternalAle.g:1334:52: (iv_rulerCollection= rulerCollection EOF )
            // InternalAle.g:1335:2: iv_rulerCollection= rulerCollection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRCollectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerCollection=rulerCollection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerCollection; 
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
    // InternalAle.g:1341:1: rulerCollection returns [EObject current=null] : ( (otherlv_0= '[' this_INT_1= RULE_INT otherlv_2= '..' this_INT_3= RULE_INT otherlv_4= ']' ) | this_expression_5= ruleexpression ) ;
    public final EObject rulerCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_INT_1=null;
        Token otherlv_2=null;
        Token this_INT_3=null;
        Token otherlv_4=null;
        EObject this_expression_5 = null;



        	enterRule();

        try {
            // InternalAle.g:1347:2: ( ( (otherlv_0= '[' this_INT_1= RULE_INT otherlv_2= '..' this_INT_3= RULE_INT otherlv_4= ']' ) | this_expression_5= ruleexpression ) )
            // InternalAle.g:1348:2: ( (otherlv_0= '[' this_INT_1= RULE_INT otherlv_2= '..' this_INT_3= RULE_INT otherlv_4= ']' ) | this_expression_5= ruleexpression )
            {
            // InternalAle.g:1348:2: ( (otherlv_0= '[' this_INT_1= RULE_INT otherlv_2= '..' this_INT_3= RULE_INT otherlv_4= ']' ) | this_expression_5= ruleexpression )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=RULE_IDENT && LA19_0<=RULE_INT)||(LA19_0>=RULE_STRING && LA19_0<=RULE_REAL)||LA19_0==27||LA19_0==31||LA19_0==40||(LA19_0>=48 && LA19_0<=49)||LA19_0==52||(LA19_0>=66 && LA19_0<=70)||(LA19_0>=72 && LA19_0<=77)) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalAle.g:1349:3: (otherlv_0= '[' this_INT_1= RULE_INT otherlv_2= '..' this_INT_3= RULE_INT otherlv_4= ']' )
                    {
                    // InternalAle.g:1349:3: (otherlv_0= '[' this_INT_1= RULE_INT otherlv_2= '..' this_INT_3= RULE_INT otherlv_4= ']' )
                    // InternalAle.g:1350:4: otherlv_0= '[' this_INT_1= RULE_INT otherlv_2= '..' this_INT_3= RULE_INT otherlv_4= ']'
                    {
                    otherlv_0=(Token)match(input,37,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getRCollectionAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_1, grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_1());
                      			
                    }
                    otherlv_2=(Token)match(input,38,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRCollectionAccess().getFullStopFullStopKeyword_0_2());
                      			
                    }
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_3, grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_3());
                      			
                    }
                    otherlv_4=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getRCollectionAccess().getRightSquareBracketKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1372:3: this_expression_5= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRCollectionAccess().getExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_expression_5=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_expression_5;
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
    // InternalAle.g:1387:1: entryRulerBlock returns [EObject current=null] : iv_rulerBlock= rulerBlock EOF ;
    public final EObject entryRulerBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerBlock = null;


        try {
            // InternalAle.g:1387:47: (iv_rulerBlock= rulerBlock EOF )
            // InternalAle.g:1388:2: iv_rulerBlock= rulerBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerBlock=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerBlock; 
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
    // InternalAle.g:1394:1: rulerBlock returns [EObject current=null] : (otherlv_0= '{' ( ( (lv_statement_1_0= rulerStatement ) ) ( (lv_statement_2_0= rulerStatement ) )* )? otherlv_3= '}' ) ;
    public final EObject rulerBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_statement_1_0 = null;

        EObject lv_statement_2_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1400:2: ( (otherlv_0= '{' ( ( (lv_statement_1_0= rulerStatement ) ) ( (lv_statement_2_0= rulerStatement ) )* )? otherlv_3= '}' ) )
            // InternalAle.g:1401:2: (otherlv_0= '{' ( ( (lv_statement_1_0= rulerStatement ) ) ( (lv_statement_2_0= rulerStatement ) )* )? otherlv_3= '}' )
            {
            // InternalAle.g:1401:2: (otherlv_0= '{' ( ( (lv_statement_1_0= rulerStatement ) ) ( (lv_statement_2_0= rulerStatement ) )* )? otherlv_3= '}' )
            // InternalAle.g:1402:3: otherlv_0= '{' ( ( (lv_statement_1_0= rulerStatement ) ) ( (lv_statement_2_0= rulerStatement ) )* )? otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRBlockAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalAle.g:1406:3: ( ( (lv_statement_1_0= rulerStatement ) ) ( (lv_statement_2_0= rulerStatement ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_IDENT && LA21_0<=RULE_INT)||(LA21_0>=RULE_STRING && LA21_0<=RULE_REAL)||LA21_0==27||LA21_0==31||LA21_0==35||LA21_0==40||LA21_0==42||(LA21_0>=48 && LA21_0<=49)||LA21_0==52||(LA21_0>=66 && LA21_0<=70)||(LA21_0>=72 && LA21_0<=77)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalAle.g:1407:4: ( (lv_statement_1_0= rulerStatement ) ) ( (lv_statement_2_0= rulerStatement ) )*
                    {
                    // InternalAle.g:1407:4: ( (lv_statement_1_0= rulerStatement ) )
                    // InternalAle.g:1408:5: (lv_statement_1_0= rulerStatement )
                    {
                    // InternalAle.g:1408:5: (lv_statement_1_0= rulerStatement )
                    // InternalAle.g:1409:6: lv_statement_1_0= rulerStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRBlockAccess().getStatementRStatementParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
                    lv_statement_1_0=rulerStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRBlockRule());
                      						}
                      						add(
                      							current,
                      							"statement",
                      							lv_statement_1_0,
                      							"org.eclipse.ecoretools.Ale.rStatement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalAle.g:1426:4: ( (lv_statement_2_0= rulerStatement ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=RULE_IDENT && LA20_0<=RULE_INT)||(LA20_0>=RULE_STRING && LA20_0<=RULE_REAL)||LA20_0==27||LA20_0==31||LA20_0==35||LA20_0==40||LA20_0==42||(LA20_0>=48 && LA20_0<=49)||LA20_0==52||(LA20_0>=66 && LA20_0<=70)||(LA20_0>=72 && LA20_0<=77)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalAle.g:1427:5: (lv_statement_2_0= rulerStatement )
                    	    {
                    	    // InternalAle.g:1427:5: (lv_statement_2_0= rulerStatement )
                    	    // InternalAle.g:1428:6: lv_statement_2_0= rulerStatement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getRBlockAccess().getStatementRStatementParserRuleCall_1_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_30);
                    	    lv_statement_2_0=rulerStatement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getRBlockRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"statement",
                    	      							lv_statement_2_0,
                    	      							"org.eclipse.ecoretools.Ale.rStatement");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_3=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRBlockAccess().getRightCurlyBracketKeyword_2());
              		
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
    // InternalAle.g:1454:1: entryRulerIf returns [EObject current=null] : iv_rulerIf= rulerIf EOF ;
    public final EObject entryRulerIf() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerIf = null;


        try {
            // InternalAle.g:1454:44: (iv_rulerIf= rulerIf EOF )
            // InternalAle.g:1455:2: iv_rulerIf= rulerIf EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRIfRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerIf=rulerIf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerIf; 
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
    // InternalAle.g:1461:1: rulerIf returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleexpression ) ) otherlv_3= ')' ( (lv_ifBlock_4_0= rulerBlock ) ) (otherlv_5= 'else' ( (lv_elseBlock_6_0= rulerBlock ) ) )? ) ;
    public final EObject rulerIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_condition_2_0 = null;

        EObject lv_ifBlock_4_0 = null;

        EObject lv_elseBlock_6_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1467:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleexpression ) ) otherlv_3= ')' ( (lv_ifBlock_4_0= rulerBlock ) ) (otherlv_5= 'else' ( (lv_elseBlock_6_0= rulerBlock ) ) )? ) )
            // InternalAle.g:1468:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleexpression ) ) otherlv_3= ')' ( (lv_ifBlock_4_0= rulerBlock ) ) (otherlv_5= 'else' ( (lv_elseBlock_6_0= rulerBlock ) ) )? )
            {
            // InternalAle.g:1468:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleexpression ) ) otherlv_3= ')' ( (lv_ifBlock_4_0= rulerBlock ) ) (otherlv_5= 'else' ( (lv_elseBlock_6_0= rulerBlock ) ) )? )
            // InternalAle.g:1469:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_condition_2_0= ruleexpression ) ) otherlv_3= ')' ( (lv_ifBlock_4_0= rulerBlock ) ) (otherlv_5= 'else' ( (lv_elseBlock_6_0= rulerBlock ) ) )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRIfAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRIfAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalAle.g:1477:3: ( (lv_condition_2_0= ruleexpression ) )
            // InternalAle.g:1478:4: (lv_condition_2_0= ruleexpression )
            {
            // InternalAle.g:1478:4: (lv_condition_2_0= ruleexpression )
            // InternalAle.g:1479:5: lv_condition_2_0= ruleexpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRIfAccess().getConditionExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_20);
            lv_condition_2_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRIfRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_2_0,
              						"org.eclipse.ecoretools.Ale.expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,32,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRIfAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalAle.g:1500:3: ( (lv_ifBlock_4_0= rulerBlock ) )
            // InternalAle.g:1501:4: (lv_ifBlock_4_0= rulerBlock )
            {
            // InternalAle.g:1501:4: (lv_ifBlock_4_0= rulerBlock )
            // InternalAle.g:1502:5: lv_ifBlock_4_0= rulerBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRIfAccess().getIfBlockRBlockParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_31);
            lv_ifBlock_4_0=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRIfRule());
              					}
              					set(
              						current,
              						"ifBlock",
              						lv_ifBlock_4_0,
              						"org.eclipse.ecoretools.Ale.rBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAle.g:1519:3: (otherlv_5= 'else' ( (lv_elseBlock_6_0= rulerBlock ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==41) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAle.g:1520:4: otherlv_5= 'else' ( (lv_elseBlock_6_0= rulerBlock ) )
                    {
                    otherlv_5=(Token)match(input,41,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getRIfAccess().getElseKeyword_5_0());
                      			
                    }
                    // InternalAle.g:1524:4: ( (lv_elseBlock_6_0= rulerBlock ) )
                    // InternalAle.g:1525:5: (lv_elseBlock_6_0= rulerBlock )
                    {
                    // InternalAle.g:1525:5: (lv_elseBlock_6_0= rulerBlock )
                    // InternalAle.g:1526:6: lv_elseBlock_6_0= rulerBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRIfAccess().getElseBlockRBlockParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_elseBlock_6_0=rulerBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRIfRule());
                      						}
                      						set(
                      							current,
                      							"elseBlock",
                      							lv_elseBlock_6_0,
                      							"org.eclipse.ecoretools.Ale.rBlock");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


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
    // InternalAle.g:1548:1: entryRulerWhile returns [EObject current=null] : iv_rulerWhile= rulerWhile EOF ;
    public final EObject entryRulerWhile() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerWhile = null;


        try {
            // InternalAle.g:1548:47: (iv_rulerWhile= rulerWhile EOF )
            // InternalAle.g:1549:2: iv_rulerWhile= rulerWhile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRWhileRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerWhile=rulerWhile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerWhile; 
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
    // InternalAle.g:1555:1: rulerWhile returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' this_expression_2= ruleexpression otherlv_3= ')' ( (lv_block_4_0= rulerBlock ) ) ) ;
    public final EObject rulerWhile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_expression_2 = null;

        EObject lv_block_4_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1561:2: ( (otherlv_0= 'while' otherlv_1= '(' this_expression_2= ruleexpression otherlv_3= ')' ( (lv_block_4_0= rulerBlock ) ) ) )
            // InternalAle.g:1562:2: (otherlv_0= 'while' otherlv_1= '(' this_expression_2= ruleexpression otherlv_3= ')' ( (lv_block_4_0= rulerBlock ) ) )
            {
            // InternalAle.g:1562:2: (otherlv_0= 'while' otherlv_1= '(' this_expression_2= ruleexpression otherlv_3= ')' ( (lv_block_4_0= rulerBlock ) ) )
            // InternalAle.g:1563:3: otherlv_0= 'while' otherlv_1= '(' this_expression_2= ruleexpression otherlv_3= ')' ( (lv_block_4_0= rulerBlock ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRWhileAccess().getWhileKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRWhileAccess().getLeftParenthesisKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRWhileAccess().getExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_20);
            this_expression_2=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_expression_2;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_3=(Token)match(input,32,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRWhileAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalAle.g:1586:3: ( (lv_block_4_0= rulerBlock ) )
            // InternalAle.g:1587:4: (lv_block_4_0= rulerBlock )
            {
            // InternalAle.g:1587:4: (lv_block_4_0= rulerBlock )
            // InternalAle.g:1588:5: lv_block_4_0= rulerBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRWhileAccess().getBlockRBlockParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_4_0=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRWhileRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_4_0,
              						"org.eclipse.ecoretools.Ale.rBlock");
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
    // $ANTLR end "rulerWhile"


    // $ANTLR start "entryRulerExpression"
    // InternalAle.g:1609:1: entryRulerExpression returns [EObject current=null] : iv_rulerExpression= rulerExpression EOF ;
    public final EObject entryRulerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerExpression = null;


        try {
            // InternalAle.g:1609:52: (iv_rulerExpression= rulerExpression EOF )
            // InternalAle.g:1610:2: iv_rulerExpression= rulerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerExpression=rulerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerExpression; 
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
    // InternalAle.g:1616:1: rulerExpression returns [EObject current=null] : (this_expression_0= ruleexpression otherlv_1= ';' ) ;
    public final EObject rulerExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_expression_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1622:2: ( (this_expression_0= ruleexpression otherlv_1= ';' ) )
            // InternalAle.g:1623:2: (this_expression_0= ruleexpression otherlv_1= ';' )
            {
            // InternalAle.g:1623:2: (this_expression_0= ruleexpression otherlv_1= ';' )
            // InternalAle.g:1624:3: this_expression_0= ruleexpression otherlv_1= ';'
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRExpressionAccess().getExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_4);
            this_expression_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_expression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_1=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRExpressionAccess().getSemicolonKeyword_1());
              		
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
    // InternalAle.g:1643:1: entryRuleexpression returns [EObject current=null] : iv_ruleexpression= ruleexpression EOF ;
    public final EObject entryRuleexpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpression = null;


        try {
            // InternalAle.g:1643:51: (iv_ruleexpression= ruleexpression EOF )
            // InternalAle.g:1644:2: iv_ruleexpression= ruleexpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleexpression=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleexpression; 
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
    // InternalAle.g:1650:1: ruleexpression returns [EObject current=null] : ( ( (lv_leftPart_0_0= rulenonLeftRecExpression ) ) ( (lv_recpart_1_0= rulerecExpression ) )? ) ;
    public final EObject ruleexpression() throws RecognitionException {
        EObject current = null;

        EObject lv_leftPart_0_0 = null;

        EObject lv_recpart_1_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1656:2: ( ( ( (lv_leftPart_0_0= rulenonLeftRecExpression ) ) ( (lv_recpart_1_0= rulerecExpression ) )? ) )
            // InternalAle.g:1657:2: ( ( (lv_leftPart_0_0= rulenonLeftRecExpression ) ) ( (lv_recpart_1_0= rulerecExpression ) )? )
            {
            // InternalAle.g:1657:2: ( ( (lv_leftPart_0_0= rulenonLeftRecExpression ) ) ( (lv_recpart_1_0= rulerecExpression ) )? )
            // InternalAle.g:1658:3: ( (lv_leftPart_0_0= rulenonLeftRecExpression ) ) ( (lv_recpart_1_0= rulerecExpression ) )?
            {
            // InternalAle.g:1658:3: ( (lv_leftPart_0_0= rulenonLeftRecExpression ) )
            // InternalAle.g:1659:4: (lv_leftPart_0_0= rulenonLeftRecExpression )
            {
            // InternalAle.g:1659:4: (lv_leftPart_0_0= rulenonLeftRecExpression )
            // InternalAle.g:1660:5: lv_leftPart_0_0= rulenonLeftRecExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionAccess().getLeftPartNonLeftRecExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_32);
            lv_leftPart_0_0=rulenonLeftRecExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExpressionRule());
              					}
              					set(
              						current,
              						"leftPart",
              						lv_leftPart_0_0,
              						"org.eclipse.ecoretools.Ale.nonLeftRecExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAle.g:1677:3: ( (lv_recpart_1_0= rulerecExpression ) )?
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalAle.g:1678:4: (lv_recpart_1_0= rulerecExpression )
                    {
                    // InternalAle.g:1678:4: (lv_recpart_1_0= rulerecExpression )
                    // InternalAle.g:1679:5: lv_recpart_1_0= rulerecExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getExpressionAccess().getRecpartRecExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_recpart_1_0=rulerecExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getExpressionRule());
                      					}
                      					set(
                      						current,
                      						"recpart",
                      						lv_recpart_1_0,
                      						"org.eclipse.ecoretools.Ale.recExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

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
    // InternalAle.g:1700:1: entryRulerecExpression returns [EObject current=null] : iv_rulerecExpression= rulerecExpression EOF ;
    public final EObject entryRulerecExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerecExpression = null;


        try {
            // InternalAle.g:1700:54: (iv_rulerecExpression= rulerecExpression EOF )
            // InternalAle.g:1701:2: iv_rulerecExpression= rulerecExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerecExpression=rulerecExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerecExpression; 
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
    // InternalAle.g:1707:1: rulerecExpression returns [EObject current=null] : ( (this_navigationSegment_0= rulenavigationSegment | (this_MULT_OP_1= RULE_MULT_OP this_expression_2= ruleexpression ) | (this_ADD_OP_3= RULE_ADD_OP this_expression_4= ruleexpression ) | (this_COMP_OP_5= RULE_COMP_OP this_expression_6= ruleexpression ) | (otherlv_7= 'and' this_expression_8= ruleexpression ) | (otherlv_9= 'or' this_expression_10= ruleexpression ) | (otherlv_11= 'xor' this_expression_12= ruleexpression ) | (otherlv_13= 'implies' this_expression_14= ruleexpression ) ) ( (lv_recExp_15_0= rulerecExpression ) )? ) ;
    public final EObject rulerecExpression() throws RecognitionException {
        EObject current = null;

        Token this_MULT_OP_1=null;
        Token this_ADD_OP_3=null;
        Token this_COMP_OP_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject this_navigationSegment_0 = null;

        EObject this_expression_2 = null;

        EObject this_expression_4 = null;

        EObject this_expression_6 = null;

        EObject this_expression_8 = null;

        EObject this_expression_10 = null;

        EObject this_expression_12 = null;

        EObject this_expression_14 = null;

        EObject lv_recExp_15_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1713:2: ( ( (this_navigationSegment_0= rulenavigationSegment | (this_MULT_OP_1= RULE_MULT_OP this_expression_2= ruleexpression ) | (this_ADD_OP_3= RULE_ADD_OP this_expression_4= ruleexpression ) | (this_COMP_OP_5= RULE_COMP_OP this_expression_6= ruleexpression ) | (otherlv_7= 'and' this_expression_8= ruleexpression ) | (otherlv_9= 'or' this_expression_10= ruleexpression ) | (otherlv_11= 'xor' this_expression_12= ruleexpression ) | (otherlv_13= 'implies' this_expression_14= ruleexpression ) ) ( (lv_recExp_15_0= rulerecExpression ) )? ) )
            // InternalAle.g:1714:2: ( (this_navigationSegment_0= rulenavigationSegment | (this_MULT_OP_1= RULE_MULT_OP this_expression_2= ruleexpression ) | (this_ADD_OP_3= RULE_ADD_OP this_expression_4= ruleexpression ) | (this_COMP_OP_5= RULE_COMP_OP this_expression_6= ruleexpression ) | (otherlv_7= 'and' this_expression_8= ruleexpression ) | (otherlv_9= 'or' this_expression_10= ruleexpression ) | (otherlv_11= 'xor' this_expression_12= ruleexpression ) | (otherlv_13= 'implies' this_expression_14= ruleexpression ) ) ( (lv_recExp_15_0= rulerecExpression ) )? )
            {
            // InternalAle.g:1714:2: ( (this_navigationSegment_0= rulenavigationSegment | (this_MULT_OP_1= RULE_MULT_OP this_expression_2= ruleexpression ) | (this_ADD_OP_3= RULE_ADD_OP this_expression_4= ruleexpression ) | (this_COMP_OP_5= RULE_COMP_OP this_expression_6= ruleexpression ) | (otherlv_7= 'and' this_expression_8= ruleexpression ) | (otherlv_9= 'or' this_expression_10= ruleexpression ) | (otherlv_11= 'xor' this_expression_12= ruleexpression ) | (otherlv_13= 'implies' this_expression_14= ruleexpression ) ) ( (lv_recExp_15_0= rulerecExpression ) )? )
            // InternalAle.g:1715:3: (this_navigationSegment_0= rulenavigationSegment | (this_MULT_OP_1= RULE_MULT_OP this_expression_2= ruleexpression ) | (this_ADD_OP_3= RULE_ADD_OP this_expression_4= ruleexpression ) | (this_COMP_OP_5= RULE_COMP_OP this_expression_6= ruleexpression ) | (otherlv_7= 'and' this_expression_8= ruleexpression ) | (otherlv_9= 'or' this_expression_10= ruleexpression ) | (otherlv_11= 'xor' this_expression_12= ruleexpression ) | (otherlv_13= 'implies' this_expression_14= ruleexpression ) ) ( (lv_recExp_15_0= rulerecExpression ) )?
            {
            // InternalAle.g:1715:3: (this_navigationSegment_0= rulenavigationSegment | (this_MULT_OP_1= RULE_MULT_OP this_expression_2= ruleexpression ) | (this_ADD_OP_3= RULE_ADD_OP this_expression_4= ruleexpression ) | (this_COMP_OP_5= RULE_COMP_OP this_expression_6= ruleexpression ) | (otherlv_7= 'and' this_expression_8= ruleexpression ) | (otherlv_9= 'or' this_expression_10= ruleexpression ) | (otherlv_11= 'xor' this_expression_12= ruleexpression ) | (otherlv_13= 'implies' this_expression_14= ruleexpression ) )
            int alt24=8;
            switch ( input.LA(1) ) {
            case 22:
            case 47:
                {
                alt24=1;
                }
                break;
            case RULE_MULT_OP:
                {
                alt24=2;
                }
                break;
            case RULE_ADD_OP:
                {
                alt24=3;
                }
                break;
            case RULE_COMP_OP:
                {
                alt24=4;
                }
                break;
            case 43:
                {
                alt24=5;
                }
                break;
            case 44:
                {
                alt24=6;
                }
                break;
            case 45:
                {
                alt24=7;
                }
                break;
            case 46:
                {
                alt24=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalAle.g:1716:4: this_navigationSegment_0= rulenavigationSegment
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRecExpressionAccess().getNavigationSegmentParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_32);
                    this_navigationSegment_0=rulenavigationSegment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_navigationSegment_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalAle.g:1728:4: (this_MULT_OP_1= RULE_MULT_OP this_expression_2= ruleexpression )
                    {
                    // InternalAle.g:1728:4: (this_MULT_OP_1= RULE_MULT_OP this_expression_2= ruleexpression )
                    // InternalAle.g:1729:5: this_MULT_OP_1= RULE_MULT_OP this_expression_2= ruleexpression
                    {
                    this_MULT_OP_1=(Token)match(input,RULE_MULT_OP,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_MULT_OP_1, grammarAccess.getRecExpressionAccess().getMULT_OPTerminalRuleCall_0_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_1_1());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    this_expression_2=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_expression_2;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1746:4: (this_ADD_OP_3= RULE_ADD_OP this_expression_4= ruleexpression )
                    {
                    // InternalAle.g:1746:4: (this_ADD_OP_3= RULE_ADD_OP this_expression_4= ruleexpression )
                    // InternalAle.g:1747:5: this_ADD_OP_3= RULE_ADD_OP this_expression_4= ruleexpression
                    {
                    this_ADD_OP_3=(Token)match(input,RULE_ADD_OP,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_ADD_OP_3, grammarAccess.getRecExpressionAccess().getADD_OPTerminalRuleCall_0_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_2_1());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    this_expression_4=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_expression_4;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1764:4: (this_COMP_OP_5= RULE_COMP_OP this_expression_6= ruleexpression )
                    {
                    // InternalAle.g:1764:4: (this_COMP_OP_5= RULE_COMP_OP this_expression_6= ruleexpression )
                    // InternalAle.g:1765:5: this_COMP_OP_5= RULE_COMP_OP this_expression_6= ruleexpression
                    {
                    this_COMP_OP_5=(Token)match(input,RULE_COMP_OP,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_COMP_OP_5, grammarAccess.getRecExpressionAccess().getCOMP_OPTerminalRuleCall_0_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_3_1());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    this_expression_6=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_expression_6;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1782:4: (otherlv_7= 'and' this_expression_8= ruleexpression )
                    {
                    // InternalAle.g:1782:4: (otherlv_7= 'and' this_expression_8= ruleexpression )
                    // InternalAle.g:1783:5: otherlv_7= 'and' this_expression_8= ruleexpression
                    {
                    otherlv_7=(Token)match(input,43,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getRecExpressionAccess().getAndKeyword_0_4_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_4_1());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    this_expression_8=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_expression_8;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1800:4: (otherlv_9= 'or' this_expression_10= ruleexpression )
                    {
                    // InternalAle.g:1800:4: (otherlv_9= 'or' this_expression_10= ruleexpression )
                    // InternalAle.g:1801:5: otherlv_9= 'or' this_expression_10= ruleexpression
                    {
                    otherlv_9=(Token)match(input,44,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_9, grammarAccess.getRecExpressionAccess().getOrKeyword_0_5_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_5_1());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    this_expression_10=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_expression_10;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:1818:4: (otherlv_11= 'xor' this_expression_12= ruleexpression )
                    {
                    // InternalAle.g:1818:4: (otherlv_11= 'xor' this_expression_12= ruleexpression )
                    // InternalAle.g:1819:5: otherlv_11= 'xor' this_expression_12= ruleexpression
                    {
                    otherlv_11=(Token)match(input,45,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getRecExpressionAccess().getXorKeyword_0_6_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_6_1());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    this_expression_12=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_expression_12;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:1836:4: (otherlv_13= 'implies' this_expression_14= ruleexpression )
                    {
                    // InternalAle.g:1836:4: (otherlv_13= 'implies' this_expression_14= ruleexpression )
                    // InternalAle.g:1837:5: otherlv_13= 'implies' this_expression_14= ruleexpression
                    {
                    otherlv_13=(Token)match(input,46,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getRecExpressionAccess().getImpliesKeyword_0_7_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_7_1());
                      				
                    }
                    pushFollow(FOLLOW_32);
                    this_expression_14=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_expression_14;
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalAle.g:1854:3: ( (lv_recExp_15_0= rulerecExpression ) )?
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalAle.g:1855:4: (lv_recExp_15_0= rulerecExpression )
                    {
                    // InternalAle.g:1855:4: (lv_recExp_15_0= rulerecExpression )
                    // InternalAle.g:1856:5: lv_recExp_15_0= rulerecExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getRecExpRecExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_recExp_15_0=rulerecExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRecExpressionRule());
                      					}
                      					set(
                      						current,
                      						"recExp",
                      						lv_recExp_15_0,
                      						"org.eclipse.ecoretools.Ale.recExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

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
    // InternalAle.g:1877:1: entryRulenavigationSegment returns [EObject current=null] : iv_rulenavigationSegment= rulenavigationSegment EOF ;
    public final EObject entryRulenavigationSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulenavigationSegment = null;


        try {
            // InternalAle.g:1877:58: (iv_rulenavigationSegment= rulenavigationSegment EOF )
            // InternalAle.g:1878:2: iv_rulenavigationSegment= rulenavigationSegment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationSegmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulenavigationSegment=rulenavigationSegment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulenavigationSegment; 
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
    // InternalAle.g:1884:1: rulenavigationSegment returns [EObject current=null] : ( ( () otherlv_1= '.' ( (lv_ident_2_0= RULE_IDENT ) ) ) | ( () otherlv_4= '.' ( (lv_call_5_0= rulecallExp ) ) ) | ( () otherlv_7= '->' ( (lv_call_8_0= rulecallExp ) ) ) ) ;
    public final EObject rulenavigationSegment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_ident_2_0=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_call_5_0 = null;

        EObject lv_call_8_0 = null;



        	enterRule();

        try {
            // InternalAle.g:1890:2: ( ( ( () otherlv_1= '.' ( (lv_ident_2_0= RULE_IDENT ) ) ) | ( () otherlv_4= '.' ( (lv_call_5_0= rulecallExp ) ) ) | ( () otherlv_7= '->' ( (lv_call_8_0= rulecallExp ) ) ) ) )
            // InternalAle.g:1891:2: ( ( () otherlv_1= '.' ( (lv_ident_2_0= RULE_IDENT ) ) ) | ( () otherlv_4= '.' ( (lv_call_5_0= rulecallExp ) ) ) | ( () otherlv_7= '->' ( (lv_call_8_0= rulecallExp ) ) ) )
            {
            // InternalAle.g:1891:2: ( ( () otherlv_1= '.' ( (lv_ident_2_0= RULE_IDENT ) ) ) | ( () otherlv_4= '.' ( (lv_call_5_0= rulecallExp ) ) ) | ( () otherlv_7= '->' ( (lv_call_8_0= rulecallExp ) ) ) )
            int alt26=3;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==22) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==RULE_IDENT) ) {
                    int LA26_3 = input.LA(3);

                    if ( (LA26_3==31) ) {
                        alt26=2;
                    }
                    else if ( (LA26_3==EOF||(LA26_3>=RULE_MULT_OP && LA26_3<=RULE_COMP_OP)||LA26_3==18||LA26_3==22||LA26_3==26||LA26_3==28||LA26_3==32||LA26_3==34||LA26_3==36||LA26_3==41||(LA26_3>=43 && LA26_3<=47)||(LA26_3>=50 && LA26_3<=51)) ) {
                        alt26=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 3, input);

                        throw nvae;
                    }
                }
                else if ( ((LA26_1>=55 && LA26_1<=64)) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA26_0==47) ) {
                alt26=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalAle.g:1892:3: ( () otherlv_1= '.' ( (lv_ident_2_0= RULE_IDENT ) ) )
                    {
                    // InternalAle.g:1892:3: ( () otherlv_1= '.' ( (lv_ident_2_0= RULE_IDENT ) ) )
                    // InternalAle.g:1893:4: () otherlv_1= '.' ( (lv_ident_2_0= RULE_IDENT ) )
                    {
                    // InternalAle.g:1893:4: ()
                    // InternalAle.g:1894:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNavigationSegmentAccess().getFinalIdentSegmentAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,22,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_0_1());
                      			
                    }
                    // InternalAle.g:1907:4: ( (lv_ident_2_0= RULE_IDENT ) )
                    // InternalAle.g:1908:5: (lv_ident_2_0= RULE_IDENT )
                    {
                    // InternalAle.g:1908:5: (lv_ident_2_0= RULE_IDENT )
                    // InternalAle.g:1909:6: lv_ident_2_0= RULE_IDENT
                    {
                    lv_ident_2_0=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_ident_2_0, grammarAccess.getNavigationSegmentAccess().getIdentIDENTTerminalRuleCall_0_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getNavigationSegmentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"ident",
                      							lv_ident_2_0,
                      							"org.eclipse.ecoretools.Ale.IDENT");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1927:3: ( () otherlv_4= '.' ( (lv_call_5_0= rulecallExp ) ) )
                    {
                    // InternalAle.g:1927:3: ( () otherlv_4= '.' ( (lv_call_5_0= rulecallExp ) ) )
                    // InternalAle.g:1928:4: () otherlv_4= '.' ( (lv_call_5_0= rulecallExp ) )
                    {
                    // InternalAle.g:1928:4: ()
                    // InternalAle.g:1929:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNavigationSegmentAccess().getFinalIdentCallSegmentAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,22,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_1_1());
                      			
                    }
                    // InternalAle.g:1942:4: ( (lv_call_5_0= rulecallExp ) )
                    // InternalAle.g:1943:5: (lv_call_5_0= rulecallExp )
                    {
                    // InternalAle.g:1943:5: (lv_call_5_0= rulecallExp )
                    // InternalAle.g:1944:6: lv_call_5_0= rulecallExp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNavigationSegmentAccess().getCallCallExpParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_call_5_0=rulecallExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNavigationSegmentRule());
                      						}
                      						set(
                      							current,
                      							"call",
                      							lv_call_5_0,
                      							"org.eclipse.ecoretools.Ale.callExp");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1963:3: ( () otherlv_7= '->' ( (lv_call_8_0= rulecallExp ) ) )
                    {
                    // InternalAle.g:1963:3: ( () otherlv_7= '->' ( (lv_call_8_0= rulecallExp ) ) )
                    // InternalAle.g:1964:4: () otherlv_7= '->' ( (lv_call_8_0= rulecallExp ) )
                    {
                    // InternalAle.g:1964:4: ()
                    // InternalAle.g:1965:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNavigationSegmentAccess().getFinalCallExpSegmentAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,47,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getNavigationSegmentAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
                      			
                    }
                    // InternalAle.g:1978:4: ( (lv_call_8_0= rulecallExp ) )
                    // InternalAle.g:1979:5: (lv_call_8_0= rulecallExp )
                    {
                    // InternalAle.g:1979:5: (lv_call_8_0= rulecallExp )
                    // InternalAle.g:1980:6: lv_call_8_0= rulecallExp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNavigationSegmentAccess().getCallCallExpParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_call_8_0=rulecallExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNavigationSegmentRule());
                      						}
                      						set(
                      							current,
                      							"call",
                      							lv_call_8_0,
                      							"org.eclipse.ecoretools.Ale.callExp");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


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
    // InternalAle.g:2002:1: entryRulenonLeftRecExpression returns [EObject current=null] : iv_rulenonLeftRecExpression= rulenonLeftRecExpression EOF ;
    public final EObject entryRulenonLeftRecExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulenonLeftRecExpression = null;


        try {
            // InternalAle.g:2002:61: (iv_rulenonLeftRecExpression= rulenonLeftRecExpression EOF )
            // InternalAle.g:2003:2: iv_rulenonLeftRecExpression= rulenonLeftRecExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNonLeftRecExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulenonLeftRecExpression=rulenonLeftRecExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulenonLeftRecExpression; 
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
    // InternalAle.g:2009:1: rulenonLeftRecExpression returns [EObject current=null] : ( ( () otherlv_1= 'not' ( (lv_expression_2_0= ruleexpression ) ) ) | ( () otherlv_4= '-' ( (lv_expression_5_0= ruleexpression ) ) ) | ( () ( (lv_value_7_0= RULE_IDENT ) ) ) | ( () ( (lv_lit_9_0= ruleliteral ) ) ) | ( () otherlv_11= '(' ( (lv_expression_12_0= ruleexpression ) ) otherlv_13= ')' ) | ( () otherlv_15= 'if' ( (lv_condition_16_0= ruleexpression ) ) otherlv_17= 'then' ( (lv_ifBlock_18_0= ruleexpression ) ) otherlv_19= 'else' ( (lv_elseBlock_20_0= ruleexpression ) ) otherlv_21= 'endif' ) | ( () otherlv_23= 'let' ( (lv_bindings_24_0= rulebinding ) ) (otherlv_25= ',' ( (lv_bindings_26_0= rulebinding ) ) )* otherlv_27= 'in' ( (lv_letExpr_28_0= ruleexpression ) ) ) ) ;
    public final EObject rulenonLeftRecExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_value_7_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        EObject lv_expression_2_0 = null;

        EObject lv_expression_5_0 = null;

        EObject lv_lit_9_0 = null;

        EObject lv_expression_12_0 = null;

        EObject lv_condition_16_0 = null;

        EObject lv_ifBlock_18_0 = null;

        EObject lv_elseBlock_20_0 = null;

        EObject lv_bindings_24_0 = null;

        EObject lv_bindings_26_0 = null;

        EObject lv_letExpr_28_0 = null;



        	enterRule();

        try {
            // InternalAle.g:2015:2: ( ( ( () otherlv_1= 'not' ( (lv_expression_2_0= ruleexpression ) ) ) | ( () otherlv_4= '-' ( (lv_expression_5_0= ruleexpression ) ) ) | ( () ( (lv_value_7_0= RULE_IDENT ) ) ) | ( () ( (lv_lit_9_0= ruleliteral ) ) ) | ( () otherlv_11= '(' ( (lv_expression_12_0= ruleexpression ) ) otherlv_13= ')' ) | ( () otherlv_15= 'if' ( (lv_condition_16_0= ruleexpression ) ) otherlv_17= 'then' ( (lv_ifBlock_18_0= ruleexpression ) ) otherlv_19= 'else' ( (lv_elseBlock_20_0= ruleexpression ) ) otherlv_21= 'endif' ) | ( () otherlv_23= 'let' ( (lv_bindings_24_0= rulebinding ) ) (otherlv_25= ',' ( (lv_bindings_26_0= rulebinding ) ) )* otherlv_27= 'in' ( (lv_letExpr_28_0= ruleexpression ) ) ) ) )
            // InternalAle.g:2016:2: ( ( () otherlv_1= 'not' ( (lv_expression_2_0= ruleexpression ) ) ) | ( () otherlv_4= '-' ( (lv_expression_5_0= ruleexpression ) ) ) | ( () ( (lv_value_7_0= RULE_IDENT ) ) ) | ( () ( (lv_lit_9_0= ruleliteral ) ) ) | ( () otherlv_11= '(' ( (lv_expression_12_0= ruleexpression ) ) otherlv_13= ')' ) | ( () otherlv_15= 'if' ( (lv_condition_16_0= ruleexpression ) ) otherlv_17= 'then' ( (lv_ifBlock_18_0= ruleexpression ) ) otherlv_19= 'else' ( (lv_elseBlock_20_0= ruleexpression ) ) otherlv_21= 'endif' ) | ( () otherlv_23= 'let' ( (lv_bindings_24_0= rulebinding ) ) (otherlv_25= ',' ( (lv_bindings_26_0= rulebinding ) ) )* otherlv_27= 'in' ( (lv_letExpr_28_0= ruleexpression ) ) ) )
            {
            // InternalAle.g:2016:2: ( ( () otherlv_1= 'not' ( (lv_expression_2_0= ruleexpression ) ) ) | ( () otherlv_4= '-' ( (lv_expression_5_0= ruleexpression ) ) ) | ( () ( (lv_value_7_0= RULE_IDENT ) ) ) | ( () ( (lv_lit_9_0= ruleliteral ) ) ) | ( () otherlv_11= '(' ( (lv_expression_12_0= ruleexpression ) ) otherlv_13= ')' ) | ( () otherlv_15= 'if' ( (lv_condition_16_0= ruleexpression ) ) otherlv_17= 'then' ( (lv_ifBlock_18_0= ruleexpression ) ) otherlv_19= 'else' ( (lv_elseBlock_20_0= ruleexpression ) ) otherlv_21= 'endif' ) | ( () otherlv_23= 'let' ( (lv_bindings_24_0= rulebinding ) ) (otherlv_25= ',' ( (lv_bindings_26_0= rulebinding ) ) )* otherlv_27= 'in' ( (lv_letExpr_28_0= ruleexpression ) ) ) )
            int alt28=7;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt28=1;
                }
                break;
            case 49:
                {
                alt28=2;
                }
                break;
            case RULE_IDENT:
                {
                int LA28_3 = input.LA(2);

                if ( (LA28_3==EOF||(LA28_3>=RULE_MULT_OP && LA28_3<=RULE_COMP_OP)||LA28_3==18||LA28_3==22||LA28_3==26||LA28_3==28||LA28_3==32||LA28_3==34||LA28_3==36||LA28_3==41||(LA28_3>=43 && LA28_3<=47)||(LA28_3>=50 && LA28_3<=51)) ) {
                    alt28=3;
                }
                else if ( (LA28_3==53||LA28_3==71) ) {
                    alt28=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_REAL:
            case 27:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
                {
                alt28=4;
                }
                break;
            case 31:
                {
                alt28=5;
                }
                break;
            case 40:
                {
                alt28=6;
                }
                break;
            case 52:
                {
                alt28=7;
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
                    // InternalAle.g:2017:3: ( () otherlv_1= 'not' ( (lv_expression_2_0= ruleexpression ) ) )
                    {
                    // InternalAle.g:2017:3: ( () otherlv_1= 'not' ( (lv_expression_2_0= ruleexpression ) ) )
                    // InternalAle.g:2018:4: () otherlv_1= 'not' ( (lv_expression_2_0= ruleexpression ) )
                    {
                    // InternalAle.g:2018:4: ()
                    // InternalAle.g:2019:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNonLeftRecExpressionAccess().getNotExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,48,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getNonLeftRecExpressionAccess().getNotKeyword_0_1());
                      			
                    }
                    // InternalAle.g:2032:4: ( (lv_expression_2_0= ruleexpression ) )
                    // InternalAle.g:2033:5: (lv_expression_2_0= ruleexpression )
                    {
                    // InternalAle.g:2033:5: (lv_expression_2_0= ruleexpression )
                    // InternalAle.g:2034:6: lv_expression_2_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_2_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:2053:3: ( () otherlv_4= '-' ( (lv_expression_5_0= ruleexpression ) ) )
                    {
                    // InternalAle.g:2053:3: ( () otherlv_4= '-' ( (lv_expression_5_0= ruleexpression ) ) )
                    // InternalAle.g:2054:4: () otherlv_4= '-' ( (lv_expression_5_0= ruleexpression ) )
                    {
                    // InternalAle.g:2054:4: ()
                    // InternalAle.g:2055:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNonLeftRecExpressionAccess().getNegExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,49,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getNonLeftRecExpressionAccess().getHyphenMinusKeyword_1_1());
                      			
                    }
                    // InternalAle.g:2068:4: ( (lv_expression_5_0= ruleexpression ) )
                    // InternalAle.g:2069:5: (lv_expression_5_0= ruleexpression )
                    {
                    // InternalAle.g:2069:5: (lv_expression_5_0= ruleexpression )
                    // InternalAle.g:2070:6: lv_expression_5_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_5_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_5_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:2089:3: ( () ( (lv_value_7_0= RULE_IDENT ) ) )
                    {
                    // InternalAle.g:2089:3: ( () ( (lv_value_7_0= RULE_IDENT ) ) )
                    // InternalAle.g:2090:4: () ( (lv_value_7_0= RULE_IDENT ) )
                    {
                    // InternalAle.g:2090:4: ()
                    // InternalAle.g:2091:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNonLeftRecExpressionAccess().getIdentifierExpresionAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:2100:4: ( (lv_value_7_0= RULE_IDENT ) )
                    // InternalAle.g:2101:5: (lv_value_7_0= RULE_IDENT )
                    {
                    // InternalAle.g:2101:5: (lv_value_7_0= RULE_IDENT )
                    // InternalAle.g:2102:6: lv_value_7_0= RULE_IDENT
                    {
                    lv_value_7_0=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_7_0, grammarAccess.getNonLeftRecExpressionAccess().getValueIDENTTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_7_0,
                      							"org.eclipse.ecoretools.Ale.IDENT");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:2120:3: ( () ( (lv_lit_9_0= ruleliteral ) ) )
                    {
                    // InternalAle.g:2120:3: ( () ( (lv_lit_9_0= ruleliteral ) ) )
                    // InternalAle.g:2121:4: () ( (lv_lit_9_0= ruleliteral ) )
                    {
                    // InternalAle.g:2121:4: ()
                    // InternalAle.g:2122:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNonLeftRecExpressionAccess().getLiteralExpressioinAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAle.g:2131:4: ( (lv_lit_9_0= ruleliteral ) )
                    // InternalAle.g:2132:5: (lv_lit_9_0= ruleliteral )
                    {
                    // InternalAle.g:2132:5: (lv_lit_9_0= ruleliteral )
                    // InternalAle.g:2133:6: lv_lit_9_0= ruleliteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getLitLiteralParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_lit_9_0=ruleliteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						set(
                      							current,
                      							"lit",
                      							lv_lit_9_0,
                      							"org.eclipse.ecoretools.Ale.literal");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:2152:3: ( () otherlv_11= '(' ( (lv_expression_12_0= ruleexpression ) ) otherlv_13= ')' )
                    {
                    // InternalAle.g:2152:3: ( () otherlv_11= '(' ( (lv_expression_12_0= ruleexpression ) ) otherlv_13= ')' )
                    // InternalAle.g:2153:4: () otherlv_11= '(' ( (lv_expression_12_0= ruleexpression ) ) otherlv_13= ')'
                    {
                    // InternalAle.g:2153:4: ()
                    // InternalAle.g:2154:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNonLeftRecExpressionAccess().getParenthesisExpressionAction_4_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_11=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getNonLeftRecExpressionAccess().getLeftParenthesisKeyword_4_1());
                      			
                    }
                    // InternalAle.g:2167:4: ( (lv_expression_12_0= ruleexpression ) )
                    // InternalAle.g:2168:5: (lv_expression_12_0= ruleexpression )
                    {
                    // InternalAle.g:2168:5: (lv_expression_12_0= ruleexpression )
                    // InternalAle.g:2169:6: lv_expression_12_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionExpressionParserRuleCall_4_2_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
                    lv_expression_12_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_12_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getNonLeftRecExpressionAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:2192:3: ( () otherlv_15= 'if' ( (lv_condition_16_0= ruleexpression ) ) otherlv_17= 'then' ( (lv_ifBlock_18_0= ruleexpression ) ) otherlv_19= 'else' ( (lv_elseBlock_20_0= ruleexpression ) ) otherlv_21= 'endif' )
                    {
                    // InternalAle.g:2192:3: ( () otherlv_15= 'if' ( (lv_condition_16_0= ruleexpression ) ) otherlv_17= 'then' ( (lv_ifBlock_18_0= ruleexpression ) ) otherlv_19= 'else' ( (lv_elseBlock_20_0= ruleexpression ) ) otherlv_21= 'endif' )
                    // InternalAle.g:2193:4: () otherlv_15= 'if' ( (lv_condition_16_0= ruleexpression ) ) otherlv_17= 'then' ( (lv_ifBlock_18_0= ruleexpression ) ) otherlv_19= 'else' ( (lv_elseBlock_20_0= ruleexpression ) ) otherlv_21= 'endif'
                    {
                    // InternalAle.g:2193:4: ()
                    // InternalAle.g:2194:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNonLeftRecExpressionAccess().getIfExpressionAction_5_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_15=(Token)match(input,40,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getNonLeftRecExpressionAccess().getIfKeyword_5_1());
                      			
                    }
                    // InternalAle.g:2207:4: ( (lv_condition_16_0= ruleexpression ) )
                    // InternalAle.g:2208:5: (lv_condition_16_0= ruleexpression )
                    {
                    // InternalAle.g:2208:5: (lv_condition_16_0= ruleexpression )
                    // InternalAle.g:2209:6: lv_condition_16_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getConditionExpressionParserRuleCall_5_2_0());
                      					
                    }
                    pushFollow(FOLLOW_34);
                    lv_condition_16_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						set(
                      							current,
                      							"condition",
                      							lv_condition_16_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_17=(Token)match(input,50,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getNonLeftRecExpressionAccess().getThenKeyword_5_3());
                      			
                    }
                    // InternalAle.g:2230:4: ( (lv_ifBlock_18_0= ruleexpression ) )
                    // InternalAle.g:2231:5: (lv_ifBlock_18_0= ruleexpression )
                    {
                    // InternalAle.g:2231:5: (lv_ifBlock_18_0= ruleexpression )
                    // InternalAle.g:2232:6: lv_ifBlock_18_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getIfBlockExpressionParserRuleCall_5_4_0());
                      					
                    }
                    pushFollow(FOLLOW_35);
                    lv_ifBlock_18_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						set(
                      							current,
                      							"ifBlock",
                      							lv_ifBlock_18_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_19=(Token)match(input,41,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getNonLeftRecExpressionAccess().getElseKeyword_5_5());
                      			
                    }
                    // InternalAle.g:2253:4: ( (lv_elseBlock_20_0= ruleexpression ) )
                    // InternalAle.g:2254:5: (lv_elseBlock_20_0= ruleexpression )
                    {
                    // InternalAle.g:2254:5: (lv_elseBlock_20_0= ruleexpression )
                    // InternalAle.g:2255:6: lv_elseBlock_20_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getElseBlockExpressionParserRuleCall_5_6_0());
                      					
                    }
                    pushFollow(FOLLOW_36);
                    lv_elseBlock_20_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						set(
                      							current,
                      							"elseBlock",
                      							lv_elseBlock_20_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_21=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getNonLeftRecExpressionAccess().getEndifKeyword_5_7());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:2278:3: ( () otherlv_23= 'let' ( (lv_bindings_24_0= rulebinding ) ) (otherlv_25= ',' ( (lv_bindings_26_0= rulebinding ) ) )* otherlv_27= 'in' ( (lv_letExpr_28_0= ruleexpression ) ) )
                    {
                    // InternalAle.g:2278:3: ( () otherlv_23= 'let' ( (lv_bindings_24_0= rulebinding ) ) (otherlv_25= ',' ( (lv_bindings_26_0= rulebinding ) ) )* otherlv_27= 'in' ( (lv_letExpr_28_0= ruleexpression ) ) )
                    // InternalAle.g:2279:4: () otherlv_23= 'let' ( (lv_bindings_24_0= rulebinding ) ) (otherlv_25= ',' ( (lv_bindings_26_0= rulebinding ) ) )* otherlv_27= 'in' ( (lv_letExpr_28_0= ruleexpression ) )
                    {
                    // InternalAle.g:2279:4: ()
                    // InternalAle.g:2280:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNonLeftRecExpressionAccess().getLetExpressionAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_23=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_23, grammarAccess.getNonLeftRecExpressionAccess().getLetKeyword_6_1());
                      			
                    }
                    // InternalAle.g:2293:4: ( (lv_bindings_24_0= rulebinding ) )
                    // InternalAle.g:2294:5: (lv_bindings_24_0= rulebinding )
                    {
                    // InternalAle.g:2294:5: (lv_bindings_24_0= rulebinding )
                    // InternalAle.g:2295:6: lv_bindings_24_0= rulebinding
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_2_0());
                      					
                    }
                    pushFollow(FOLLOW_37);
                    lv_bindings_24_0=rulebinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						add(
                      							current,
                      							"bindings",
                      							lv_bindings_24_0,
                      							"org.eclipse.ecoretools.Ale.binding");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalAle.g:2312:4: (otherlv_25= ',' ( (lv_bindings_26_0= rulebinding ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==26) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalAle.g:2313:5: otherlv_25= ',' ( (lv_bindings_26_0= rulebinding ) )
                    	    {
                    	    otherlv_25=(Token)match(input,26,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_25, grammarAccess.getNonLeftRecExpressionAccess().getCommaKeyword_6_3_0());
                    	      				
                    	    }
                    	    // InternalAle.g:2317:5: ( (lv_bindings_26_0= rulebinding ) )
                    	    // InternalAle.g:2318:6: (lv_bindings_26_0= rulebinding )
                    	    {
                    	    // InternalAle.g:2318:6: (lv_bindings_26_0= rulebinding )
                    	    // InternalAle.g:2319:7: lv_bindings_26_0= rulebinding
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_37);
                    	    lv_bindings_26_0=rulebinding();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"bindings",
                    	      								lv_bindings_26_0,
                    	      								"org.eclipse.ecoretools.Ale.binding");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,36,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_27, grammarAccess.getNonLeftRecExpressionAccess().getInKeyword_6_4());
                      			
                    }
                    // InternalAle.g:2341:4: ( (lv_letExpr_28_0= ruleexpression ) )
                    // InternalAle.g:2342:5: (lv_letExpr_28_0= ruleexpression )
                    {
                    // InternalAle.g:2342:5: (lv_letExpr_28_0= ruleexpression )
                    // InternalAle.g:2343:6: lv_letExpr_28_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getLetExprExpressionParserRuleCall_6_5_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_letExpr_28_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNonLeftRecExpressionRule());
                      						}
                      						set(
                      							current,
                      							"letExpr",
                      							lv_letExpr_28_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


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
    // InternalAle.g:2365:1: entryRulebinding returns [EObject current=null] : iv_rulebinding= rulebinding EOF ;
    public final EObject entryRulebinding() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebinding = null;


        try {
            // InternalAle.g:2365:48: (iv_rulebinding= rulebinding EOF )
            // InternalAle.g:2366:2: iv_rulebinding= rulebinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulebinding=rulebinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulebinding; 
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
    // InternalAle.g:2372:1: rulebinding returns [EObject current=null] : ( ( (lv_identifier_0_0= RULE_IDENT ) ) (otherlv_1= ':' ( (lv_type_2_0= ruletypeLiteral ) ) )? otherlv_3= '=' ( (lv_expression_4_0= ruleexpression ) ) ) ;
    public final EObject rulebinding() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalAle.g:2378:2: ( ( ( (lv_identifier_0_0= RULE_IDENT ) ) (otherlv_1= ':' ( (lv_type_2_0= ruletypeLiteral ) ) )? otherlv_3= '=' ( (lv_expression_4_0= ruleexpression ) ) ) )
            // InternalAle.g:2379:2: ( ( (lv_identifier_0_0= RULE_IDENT ) ) (otherlv_1= ':' ( (lv_type_2_0= ruletypeLiteral ) ) )? otherlv_3= '=' ( (lv_expression_4_0= ruleexpression ) ) )
            {
            // InternalAle.g:2379:2: ( ( (lv_identifier_0_0= RULE_IDENT ) ) (otherlv_1= ':' ( (lv_type_2_0= ruletypeLiteral ) ) )? otherlv_3= '=' ( (lv_expression_4_0= ruleexpression ) ) )
            // InternalAle.g:2380:3: ( (lv_identifier_0_0= RULE_IDENT ) ) (otherlv_1= ':' ( (lv_type_2_0= ruletypeLiteral ) ) )? otherlv_3= '=' ( (lv_expression_4_0= ruleexpression ) )
            {
            // InternalAle.g:2380:3: ( (lv_identifier_0_0= RULE_IDENT ) )
            // InternalAle.g:2381:4: (lv_identifier_0_0= RULE_IDENT )
            {
            // InternalAle.g:2381:4: (lv_identifier_0_0= RULE_IDENT )
            // InternalAle.g:2382:5: lv_identifier_0_0= RULE_IDENT
            {
            lv_identifier_0_0=(Token)match(input,RULE_IDENT,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_identifier_0_0, grammarAccess.getBindingAccess().getIdentifierIDENTTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBindingRule());
              					}
              					setWithLastConsumed(
              						current,
              						"identifier",
              						lv_identifier_0_0,
              						"org.eclipse.ecoretools.Ale.IDENT");
              				
            }

            }


            }

            // InternalAle.g:2398:3: (otherlv_1= ':' ( (lv_type_2_0= ruletypeLiteral ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==53) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAle.g:2399:4: otherlv_1= ':' ( (lv_type_2_0= ruletypeLiteral ) )
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getBindingAccess().getColonKeyword_1_0());
                      			
                    }
                    // InternalAle.g:2403:4: ( (lv_type_2_0= ruletypeLiteral ) )
                    // InternalAle.g:2404:5: (lv_type_2_0= ruletypeLiteral )
                    {
                    // InternalAle.g:2404:5: (lv_type_2_0= ruletypeLiteral )
                    // InternalAle.g:2405:6: lv_type_2_0= ruletypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBindingAccess().getTypeTypeLiteralParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_39);
                    lv_type_2_0=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBindingRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_2_0,
                      							"org.eclipse.ecoretools.Ale.typeLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,54,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBindingAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalAle.g:2427:3: ( (lv_expression_4_0= ruleexpression ) )
            // InternalAle.g:2428:4: (lv_expression_4_0= ruleexpression )
            {
            // InternalAle.g:2428:4: (lv_expression_4_0= ruleexpression )
            // InternalAle.g:2429:5: lv_expression_4_0= ruleexpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBindingAccess().getExpressionExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_4_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBindingRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_4_0,
              						"org.eclipse.ecoretools.Ale.expression");
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
    // $ANTLR end "rulebinding"


    // $ANTLR start "entryRulecallExp"
    // InternalAle.g:2450:1: entryRulecallExp returns [EObject current=null] : iv_rulecallExp= rulecallExp EOF ;
    public final EObject entryRulecallExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecallExp = null;


        try {
            // InternalAle.g:2450:48: (iv_rulecallExp= rulecallExp EOF )
            // InternalAle.g:2451:2: iv_rulecallExp= rulecallExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallExpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulecallExp=rulecallExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulecallExp; 
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
    // InternalAle.g:2457:1: rulecallExp returns [EObject current=null] : ( ( rulecollectionIterator otherlv_1= '(' this_variableDefinition_2= rulevariableDefinition ( (lv_expression_3_0= ruleexpression ) ) otherlv_4= ')' ) | (this_IDENT_5= RULE_IDENT otherlv_6= '(' this_expressionSequence_7= ruleexpressionSequence otherlv_8= ')' ) ) ;
    public final EObject rulecallExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token this_IDENT_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_variableDefinition_2 = null;

        EObject lv_expression_3_0 = null;

        EObject this_expressionSequence_7 = null;



        	enterRule();

        try {
            // InternalAle.g:2463:2: ( ( ( rulecollectionIterator otherlv_1= '(' this_variableDefinition_2= rulevariableDefinition ( (lv_expression_3_0= ruleexpression ) ) otherlv_4= ')' ) | (this_IDENT_5= RULE_IDENT otherlv_6= '(' this_expressionSequence_7= ruleexpressionSequence otherlv_8= ')' ) ) )
            // InternalAle.g:2464:2: ( ( rulecollectionIterator otherlv_1= '(' this_variableDefinition_2= rulevariableDefinition ( (lv_expression_3_0= ruleexpression ) ) otherlv_4= ')' ) | (this_IDENT_5= RULE_IDENT otherlv_6= '(' this_expressionSequence_7= ruleexpressionSequence otherlv_8= ')' ) )
            {
            // InternalAle.g:2464:2: ( ( rulecollectionIterator otherlv_1= '(' this_variableDefinition_2= rulevariableDefinition ( (lv_expression_3_0= ruleexpression ) ) otherlv_4= ')' ) | (this_IDENT_5= RULE_IDENT otherlv_6= '(' this_expressionSequence_7= ruleexpressionSequence otherlv_8= ')' ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=55 && LA30_0<=64)) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_IDENT) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalAle.g:2465:3: ( rulecollectionIterator otherlv_1= '(' this_variableDefinition_2= rulevariableDefinition ( (lv_expression_3_0= ruleexpression ) ) otherlv_4= ')' )
                    {
                    // InternalAle.g:2465:3: ( rulecollectionIterator otherlv_1= '(' this_variableDefinition_2= rulevariableDefinition ( (lv_expression_3_0= ruleexpression ) ) otherlv_4= ')' )
                    // InternalAle.g:2466:4: rulecollectionIterator otherlv_1= '(' this_variableDefinition_2= rulevariableDefinition ( (lv_expression_3_0= ruleexpression ) ) otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getCollectionIteratorParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_18);
                    rulecollectionIterator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_1=(Token)match(input,31,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getVariableDefinitionParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_23);
                    this_variableDefinition_2=rulevariableDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_variableDefinition_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalAle.g:2491:4: ( (lv_expression_3_0= ruleexpression ) )
                    // InternalAle.g:2492:5: (lv_expression_3_0= ruleexpression )
                    {
                    // InternalAle.g:2492:5: (lv_expression_3_0= ruleexpression )
                    // InternalAle.g:2493:6: lv_expression_3_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCallExpAccess().getExpressionExpressionParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
                    lv_expression_3_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCallExpRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_3_0,
                      							"org.eclipse.ecoretools.Ale.expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getCallExpAccess().getRightParenthesisKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:2516:3: (this_IDENT_5= RULE_IDENT otherlv_6= '(' this_expressionSequence_7= ruleexpressionSequence otherlv_8= ')' )
                    {
                    // InternalAle.g:2516:3: (this_IDENT_5= RULE_IDENT otherlv_6= '(' this_expressionSequence_7= ruleexpressionSequence otherlv_8= ')' )
                    // InternalAle.g:2517:4: this_IDENT_5= RULE_IDENT otherlv_6= '(' this_expressionSequence_7= ruleexpressionSequence otherlv_8= ')'
                    {
                    this_IDENT_5=(Token)match(input,RULE_IDENT,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IDENT_5, grammarAccess.getCallExpAccess().getIDENTTerminalRuleCall_1_0());
                      			
                    }
                    otherlv_6=(Token)match(input,31,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_1_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getExpressionSequenceParserRuleCall_1_2());
                      			
                    }
                    pushFollow(FOLLOW_20);
                    this_expressionSequence_7=ruleexpressionSequence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_expressionSequence_7;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_8=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getCallExpAccess().getRightParenthesisKeyword_1_3());
                      			
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


    // $ANTLR start "entryRulecollectionIterator"
    // InternalAle.g:2545:1: entryRulecollectionIterator returns [String current=null] : iv_rulecollectionIterator= rulecollectionIterator EOF ;
    public final String entryRulecollectionIterator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulecollectionIterator = null;


        try {
            // InternalAle.g:2545:58: (iv_rulecollectionIterator= rulecollectionIterator EOF )
            // InternalAle.g:2546:2: iv_rulecollectionIterator= rulecollectionIterator EOF
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
    // InternalAle.g:2552:1: rulecollectionIterator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' ) ;
    public final AntlrDatatypeRuleToken rulecollectionIterator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAle.g:2558:2: ( (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' ) )
            // InternalAle.g:2559:2: (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' )
            {
            // InternalAle.g:2559:2: (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' )
            int alt31=10;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt31=1;
                }
                break;
            case 56:
                {
                alt31=2;
                }
                break;
            case 57:
                {
                alt31=3;
                }
                break;
            case 58:
                {
                alt31=4;
                }
                break;
            case 59:
                {
                alt31=5;
                }
                break;
            case 60:
                {
                alt31=6;
                }
                break;
            case 61:
                {
                alt31=7;
                }
                break;
            case 62:
                {
                alt31=8;
                }
                break;
            case 63:
                {
                alt31=9;
                }
                break;
            case 64:
                {
                alt31=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalAle.g:2560:3: kw= 'select'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getSelectKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAle.g:2566:3: kw= 'reject'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getRejectKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalAle.g:2572:3: kw= 'collect'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getCollectKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalAle.g:2578:3: kw= 'any'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getAnyKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalAle.g:2584:3: kw= 'exists'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getExistsKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalAle.g:2590:3: kw= 'forAll'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getForAllKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalAle.g:2596:3: kw= 'isUnique'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getIsUniqueKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalAle.g:2602:3: kw= 'one'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getOneKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalAle.g:2608:3: kw= 'sortedBy'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getSortedByKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalAle.g:2614:3: kw= 'closure'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
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
    // InternalAle.g:2623:1: entryRuleexpressionSequence returns [EObject current=null] : iv_ruleexpressionSequence= ruleexpressionSequence EOF ;
    public final EObject entryRuleexpressionSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexpressionSequence = null;


        try {
            // InternalAle.g:2623:59: (iv_ruleexpressionSequence= ruleexpressionSequence EOF )
            // InternalAle.g:2624:2: iv_ruleexpressionSequence= ruleexpressionSequence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleexpressionSequence=ruleexpressionSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleexpressionSequence; 
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
    // InternalAle.g:2630:1: ruleexpressionSequence returns [EObject current=null] : ( ( (lv_seqExprs_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_seqExprs_2_0= ruleexpression ) ) )* )? ;
    public final EObject ruleexpressionSequence() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_seqExprs_0_0 = null;

        EObject lv_seqExprs_2_0 = null;



        	enterRule();

        try {
            // InternalAle.g:2636:2: ( ( ( (lv_seqExprs_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_seqExprs_2_0= ruleexpression ) ) )* )? )
            // InternalAle.g:2637:2: ( ( (lv_seqExprs_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_seqExprs_2_0= ruleexpression ) ) )* )?
            {
            // InternalAle.g:2637:2: ( ( (lv_seqExprs_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_seqExprs_2_0= ruleexpression ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_IDENT && LA33_0<=RULE_INT)||(LA33_0>=RULE_STRING && LA33_0<=RULE_REAL)||LA33_0==27||LA33_0==31||LA33_0==40||(LA33_0>=48 && LA33_0<=49)||LA33_0==52||(LA33_0>=66 && LA33_0<=70)||(LA33_0>=72 && LA33_0<=77)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAle.g:2638:3: ( (lv_seqExprs_0_0= ruleexpression ) ) (otherlv_1= ',' ( (lv_seqExprs_2_0= ruleexpression ) ) )*
                    {
                    // InternalAle.g:2638:3: ( (lv_seqExprs_0_0= ruleexpression ) )
                    // InternalAle.g:2639:4: (lv_seqExprs_0_0= ruleexpression )
                    {
                    // InternalAle.g:2639:4: (lv_seqExprs_0_0= ruleexpression )
                    // InternalAle.g:2640:5: lv_seqExprs_0_0= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getExpressionSequenceAccess().getSeqExprsExpressionParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_21);
                    lv_seqExprs_0_0=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getExpressionSequenceRule());
                      					}
                      					add(
                      						current,
                      						"seqExprs",
                      						lv_seqExprs_0_0,
                      						"org.eclipse.ecoretools.Ale.expression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }

                    // InternalAle.g:2657:3: (otherlv_1= ',' ( (lv_seqExprs_2_0= ruleexpression ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==26) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalAle.g:2658:4: otherlv_1= ',' ( (lv_seqExprs_2_0= ruleexpression ) )
                    	    {
                    	    otherlv_1=(Token)match(input,26,FOLLOW_23); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      				newLeafNode(otherlv_1, grammarAccess.getExpressionSequenceAccess().getCommaKeyword_1_0());
                    	      			
                    	    }
                    	    // InternalAle.g:2662:4: ( (lv_seqExprs_2_0= ruleexpression ) )
                    	    // InternalAle.g:2663:5: (lv_seqExprs_2_0= ruleexpression )
                    	    {
                    	    // InternalAle.g:2663:5: (lv_seqExprs_2_0= ruleexpression )
                    	    // InternalAle.g:2664:6: lv_seqExprs_2_0= ruleexpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getExpressionSequenceAccess().getSeqExprsExpressionParserRuleCall_1_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_21);
                    	    lv_seqExprs_2_0=ruleexpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getExpressionSequenceRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"seqExprs",
                    	      							lv_seqExprs_2_0,
                    	      							"org.eclipse.ecoretools.Ale.expression");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
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
    // InternalAle.g:2686:1: entryRulevariableDefinition returns [EObject current=null] : iv_rulevariableDefinition= rulevariableDefinition EOF ;
    public final EObject entryRulevariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulevariableDefinition = null;


        try {
            // InternalAle.g:2686:59: (iv_rulevariableDefinition= rulevariableDefinition EOF )
            // InternalAle.g:2687:2: iv_rulevariableDefinition= rulevariableDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulevariableDefinition=rulevariableDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulevariableDefinition; 
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
    // InternalAle.g:2693:1: rulevariableDefinition returns [EObject current=null] : (this_IDENT_0= RULE_IDENT (otherlv_1= ':' this_typeLiteral_2= ruletypeLiteral )? otherlv_3= '|' ) ;
    public final EObject rulevariableDefinition() throws RecognitionException {
        EObject current = null;

        Token this_IDENT_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_typeLiteral_2 = null;



        	enterRule();

        try {
            // InternalAle.g:2699:2: ( (this_IDENT_0= RULE_IDENT (otherlv_1= ':' this_typeLiteral_2= ruletypeLiteral )? otherlv_3= '|' ) )
            // InternalAle.g:2700:2: (this_IDENT_0= RULE_IDENT (otherlv_1= ':' this_typeLiteral_2= ruletypeLiteral )? otherlv_3= '|' )
            {
            // InternalAle.g:2700:2: (this_IDENT_0= RULE_IDENT (otherlv_1= ':' this_typeLiteral_2= ruletypeLiteral )? otherlv_3= '|' )
            // InternalAle.g:2701:3: this_IDENT_0= RULE_IDENT (otherlv_1= ':' this_typeLiteral_2= ruletypeLiteral )? otherlv_3= '|'
            {
            this_IDENT_0=(Token)match(input,RULE_IDENT,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_IDENT_0, grammarAccess.getVariableDefinitionAccess().getIDENTTerminalRuleCall_0());
              		
            }
            // InternalAle.g:2705:3: (otherlv_1= ':' this_typeLiteral_2= ruletypeLiteral )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==53) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAle.g:2706:4: otherlv_1= ':' this_typeLiteral_2= ruletypeLiteral
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getVariableDefinitionAccess().getColonKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getVariableDefinitionAccess().getTypeLiteralParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_42);
                    this_typeLiteral_2=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_typeLiteral_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_3=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getVariableDefinitionAccess().getVerticalLineKeyword_2());
              		
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
    // InternalAle.g:2730:1: entryRuleliteral returns [EObject current=null] : iv_ruleliteral= ruleliteral EOF ;
    public final EObject entryRuleliteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleliteral = null;


        try {
            // InternalAle.g:2730:48: (iv_ruleliteral= ruleliteral EOF )
            // InternalAle.g:2731:2: iv_ruleliteral= ruleliteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleliteral=ruleliteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleliteral; 
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
    // InternalAle.g:2737:1: ruleliteral returns [EObject current=null] : (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_REAL_2= RULE_REAL | otherlv_3= 'true' | otherlv_4= 'false' | otherlv_5= 'null' | (otherlv_6= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence otherlv_8= '}' ) | (otherlv_9= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence otherlv_11= '}' ) | (this_IDENT_12= RULE_IDENT otherlv_13= '::' this_IDENT_14= RULE_IDENT otherlv_15= '::' this_IDENT_16= RULE_IDENT ) | (this_IDENT_17= RULE_IDENT otherlv_18= '::' this_IDENT_19= RULE_IDENT otherlv_20= ':' ) | this_typeLiteral_21= ruletypeLiteral ) ;
    public final EObject ruleliteral() throws RecognitionException {
        EObject current = null;

        Token this_STRING_0=null;
        Token this_INT_1=null;
        Token this_REAL_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token this_IDENT_12=null;
        Token otherlv_13=null;
        Token this_IDENT_14=null;
        Token otherlv_15=null;
        Token this_IDENT_16=null;
        Token this_IDENT_17=null;
        Token otherlv_18=null;
        Token this_IDENT_19=null;
        Token otherlv_20=null;
        EObject this_expressionSequence_7 = null;

        EObject this_expressionSequence_10 = null;

        EObject this_typeLiteral_21 = null;



        	enterRule();

        try {
            // InternalAle.g:2743:2: ( (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_REAL_2= RULE_REAL | otherlv_3= 'true' | otherlv_4= 'false' | otherlv_5= 'null' | (otherlv_6= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence otherlv_8= '}' ) | (otherlv_9= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence otherlv_11= '}' ) | (this_IDENT_12= RULE_IDENT otherlv_13= '::' this_IDENT_14= RULE_IDENT otherlv_15= '::' this_IDENT_16= RULE_IDENT ) | (this_IDENT_17= RULE_IDENT otherlv_18= '::' this_IDENT_19= RULE_IDENT otherlv_20= ':' ) | this_typeLiteral_21= ruletypeLiteral ) )
            // InternalAle.g:2744:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_REAL_2= RULE_REAL | otherlv_3= 'true' | otherlv_4= 'false' | otherlv_5= 'null' | (otherlv_6= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence otherlv_8= '}' ) | (otherlv_9= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence otherlv_11= '}' ) | (this_IDENT_12= RULE_IDENT otherlv_13= '::' this_IDENT_14= RULE_IDENT otherlv_15= '::' this_IDENT_16= RULE_IDENT ) | (this_IDENT_17= RULE_IDENT otherlv_18= '::' this_IDENT_19= RULE_IDENT otherlv_20= ':' ) | this_typeLiteral_21= ruletypeLiteral )
            {
            // InternalAle.g:2744:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_REAL_2= RULE_REAL | otherlv_3= 'true' | otherlv_4= 'false' | otherlv_5= 'null' | (otherlv_6= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence otherlv_8= '}' ) | (otherlv_9= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence otherlv_11= '}' ) | (this_IDENT_12= RULE_IDENT otherlv_13= '::' this_IDENT_14= RULE_IDENT otherlv_15= '::' this_IDENT_16= RULE_IDENT ) | (this_IDENT_17= RULE_IDENT otherlv_18= '::' this_IDENT_19= RULE_IDENT otherlv_20= ':' ) | this_typeLiteral_21= ruletypeLiteral )
            int alt35=11;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalAle.g:2745:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_0, grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAle.g:2750:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_INT_1, grammarAccess.getLiteralAccess().getINTTerminalRuleCall_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalAle.g:2755:3: this_REAL_2= RULE_REAL
                    {
                    this_REAL_2=(Token)match(input,RULE_REAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_REAL_2, grammarAccess.getLiteralAccess().getREALTerminalRuleCall_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalAle.g:2760:3: otherlv_3= 'true'
                    {
                    otherlv_3=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(otherlv_3, grammarAccess.getLiteralAccess().getTrueKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalAle.g:2765:3: otherlv_4= 'false'
                    {
                    otherlv_4=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(otherlv_4, grammarAccess.getLiteralAccess().getFalseKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalAle.g:2770:3: otherlv_5= 'null'
                    {
                    otherlv_5=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(otherlv_5, grammarAccess.getLiteralAccess().getNullKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalAle.g:2775:3: (otherlv_6= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence otherlv_8= '}' )
                    {
                    // InternalAle.g:2775:3: (otherlv_6= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence otherlv_8= '}' )
                    // InternalAle.g:2776:4: otherlv_6= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,69,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getLiteralAccess().getSequenceKeyword_6_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_6_1());
                      			
                    }
                    pushFollow(FOLLOW_44);
                    this_expressionSequence_7=ruleexpressionSequence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_expressionSequence_7;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_8=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_6_2());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:2797:3: (otherlv_9= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence otherlv_11= '}' )
                    {
                    // InternalAle.g:2797:3: (otherlv_9= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence otherlv_11= '}' )
                    // InternalAle.g:2798:4: otherlv_9= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence otherlv_11= '}'
                    {
                    otherlv_9=(Token)match(input,70,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getLiteralAccess().getOrderedSetKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_44);
                    this_expressionSequence_10=ruleexpressionSequence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_expressionSequence_10;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_11=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_7_2());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalAle.g:2819:3: (this_IDENT_12= RULE_IDENT otherlv_13= '::' this_IDENT_14= RULE_IDENT otherlv_15= '::' this_IDENT_16= RULE_IDENT )
                    {
                    // InternalAle.g:2819:3: (this_IDENT_12= RULE_IDENT otherlv_13= '::' this_IDENT_14= RULE_IDENT otherlv_15= '::' this_IDENT_16= RULE_IDENT )
                    // InternalAle.g:2820:4: this_IDENT_12= RULE_IDENT otherlv_13= '::' this_IDENT_14= RULE_IDENT otherlv_15= '::' this_IDENT_16= RULE_IDENT
                    {
                    this_IDENT_12=(Token)match(input,RULE_IDENT,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IDENT_12, grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_8_0());
                      			
                    }
                    otherlv_13=(Token)match(input,71,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getLiteralAccess().getColonColonKeyword_8_1());
                      			
                    }
                    this_IDENT_14=(Token)match(input,RULE_IDENT,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IDENT_14, grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_8_2());
                      			
                    }
                    otherlv_15=(Token)match(input,71,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getLiteralAccess().getColonColonKeyword_8_3());
                      			
                    }
                    this_IDENT_16=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IDENT_16, grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_8_4());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalAle.g:2842:3: (this_IDENT_17= RULE_IDENT otherlv_18= '::' this_IDENT_19= RULE_IDENT otherlv_20= ':' )
                    {
                    // InternalAle.g:2842:3: (this_IDENT_17= RULE_IDENT otherlv_18= '::' this_IDENT_19= RULE_IDENT otherlv_20= ':' )
                    // InternalAle.g:2843:4: this_IDENT_17= RULE_IDENT otherlv_18= '::' this_IDENT_19= RULE_IDENT otherlv_20= ':'
                    {
                    this_IDENT_17=(Token)match(input,RULE_IDENT,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IDENT_17, grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_9_0());
                      			
                    }
                    otherlv_18=(Token)match(input,71,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getLiteralAccess().getColonColonKeyword_9_1());
                      			
                    }
                    this_IDENT_19=(Token)match(input,RULE_IDENT,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IDENT_19, grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_9_2());
                      			
                    }
                    otherlv_20=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getLiteralAccess().getColonKeyword_9_3());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalAle.g:2861:3: this_typeLiteral_21= ruletypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getTypeLiteralParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_typeLiteral_21=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_typeLiteral_21;
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
    // InternalAle.g:2876:1: entryRuletypeLiteral returns [EObject current=null] : iv_ruletypeLiteral= ruletypeLiteral EOF ;
    public final EObject entryRuletypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletypeLiteral = null;


        try {
            // InternalAle.g:2876:52: (iv_ruletypeLiteral= ruletypeLiteral EOF )
            // InternalAle.g:2877:2: iv_ruletypeLiteral= ruletypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruletypeLiteral=ruletypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruletypeLiteral; 
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
    // InternalAle.g:2883:1: ruletypeLiteral returns [EObject current=null] : ( ( () otherlv_1= 'String' ) | ( () otherlv_3= 'Integer' ) | ( () otherlv_5= 'Real' ) | ( () otherlv_7= 'Boolean' ) | ( () otherlv_9= 'Sequence(' ( (lv_subType_10_0= ruletypeLiteral ) ) otherlv_11= ')' ) | ( () otherlv_13= 'OrderedSet(' ( (lv_subType_14_0= ruletypeLiteral ) ) otherlv_15= ')' ) | ( () ruleclassifierTypeRule ) | ( () otherlv_19= '{' ruleclassifierTypeRule (otherlv_21= '|' ruleclassifierTypeRule )* otherlv_23= '}' ) ) ;
    public final EObject ruletypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_subType_10_0 = null;

        EObject lv_subType_14_0 = null;



        	enterRule();

        try {
            // InternalAle.g:2889:2: ( ( ( () otherlv_1= 'String' ) | ( () otherlv_3= 'Integer' ) | ( () otherlv_5= 'Real' ) | ( () otherlv_7= 'Boolean' ) | ( () otherlv_9= 'Sequence(' ( (lv_subType_10_0= ruletypeLiteral ) ) otherlv_11= ')' ) | ( () otherlv_13= 'OrderedSet(' ( (lv_subType_14_0= ruletypeLiteral ) ) otherlv_15= ')' ) | ( () ruleclassifierTypeRule ) | ( () otherlv_19= '{' ruleclassifierTypeRule (otherlv_21= '|' ruleclassifierTypeRule )* otherlv_23= '}' ) ) )
            // InternalAle.g:2890:2: ( ( () otherlv_1= 'String' ) | ( () otherlv_3= 'Integer' ) | ( () otherlv_5= 'Real' ) | ( () otherlv_7= 'Boolean' ) | ( () otherlv_9= 'Sequence(' ( (lv_subType_10_0= ruletypeLiteral ) ) otherlv_11= ')' ) | ( () otherlv_13= 'OrderedSet(' ( (lv_subType_14_0= ruletypeLiteral ) ) otherlv_15= ')' ) | ( () ruleclassifierTypeRule ) | ( () otherlv_19= '{' ruleclassifierTypeRule (otherlv_21= '|' ruleclassifierTypeRule )* otherlv_23= '}' ) )
            {
            // InternalAle.g:2890:2: ( ( () otherlv_1= 'String' ) | ( () otherlv_3= 'Integer' ) | ( () otherlv_5= 'Real' ) | ( () otherlv_7= 'Boolean' ) | ( () otherlv_9= 'Sequence(' ( (lv_subType_10_0= ruletypeLiteral ) ) otherlv_11= ')' ) | ( () otherlv_13= 'OrderedSet(' ( (lv_subType_14_0= ruletypeLiteral ) ) otherlv_15= ')' ) | ( () ruleclassifierTypeRule ) | ( () otherlv_19= '{' ruleclassifierTypeRule (otherlv_21= '|' ruleclassifierTypeRule )* otherlv_23= '}' ) )
            int alt37=8;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt37=1;
                }
                break;
            case 73:
                {
                alt37=2;
                }
                break;
            case 74:
                {
                alt37=3;
                }
                break;
            case 75:
                {
                alt37=4;
                }
                break;
            case 76:
                {
                alt37=5;
                }
                break;
            case 77:
                {
                alt37=6;
                }
                break;
            case RULE_IDENT:
                {
                alt37=7;
                }
                break;
            case 27:
                {
                alt37=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalAle.g:2891:3: ( () otherlv_1= 'String' )
                    {
                    // InternalAle.g:2891:3: ( () otherlv_1= 'String' )
                    // InternalAle.g:2892:4: () otherlv_1= 'String'
                    {
                    // InternalAle.g:2892:4: ()
                    // InternalAle.g:2893:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeLiteralAccess().getTypeLiteralStringAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeLiteralAccess().getStringKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:2908:3: ( () otherlv_3= 'Integer' )
                    {
                    // InternalAle.g:2908:3: ( () otherlv_3= 'Integer' )
                    // InternalAle.g:2909:4: () otherlv_3= 'Integer'
                    {
                    // InternalAle.g:2909:4: ()
                    // InternalAle.g:2910:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeLiteralAccess().getTypeLiteralIntegerAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getTypeLiteralAccess().getIntegerKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:2925:3: ( () otherlv_5= 'Real' )
                    {
                    // InternalAle.g:2925:3: ( () otherlv_5= 'Real' )
                    // InternalAle.g:2926:4: () otherlv_5= 'Real'
                    {
                    // InternalAle.g:2926:4: ()
                    // InternalAle.g:2927:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeLiteralAccess().getTypeLiteralRealAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getTypeLiteralAccess().getRealKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:2942:3: ( () otherlv_7= 'Boolean' )
                    {
                    // InternalAle.g:2942:3: ( () otherlv_7= 'Boolean' )
                    // InternalAle.g:2943:4: () otherlv_7= 'Boolean'
                    {
                    // InternalAle.g:2943:4: ()
                    // InternalAle.g:2944:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeLiteralAccess().getTypeLiteralBooleanAction_3_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getTypeLiteralAccess().getBooleanKeyword_3_1());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:2959:3: ( () otherlv_9= 'Sequence(' ( (lv_subType_10_0= ruletypeLiteral ) ) otherlv_11= ')' )
                    {
                    // InternalAle.g:2959:3: ( () otherlv_9= 'Sequence(' ( (lv_subType_10_0= ruletypeLiteral ) ) otherlv_11= ')' )
                    // InternalAle.g:2960:4: () otherlv_9= 'Sequence(' ( (lv_subType_10_0= ruletypeLiteral ) ) otherlv_11= ')'
                    {
                    // InternalAle.g:2960:4: ()
                    // InternalAle.g:2961:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeLiteralAccess().getTypeLiteralSequenceAction_4_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_9=(Token)match(input,76,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getTypeLiteralAccess().getSequenceKeyword_4_1());
                      			
                    }
                    // InternalAle.g:2974:4: ( (lv_subType_10_0= ruletypeLiteral ) )
                    // InternalAle.g:2975:5: (lv_subType_10_0= ruletypeLiteral )
                    {
                    // InternalAle.g:2975:5: (lv_subType_10_0= ruletypeLiteral )
                    // InternalAle.g:2976:6: lv_subType_10_0= ruletypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeLiteralAccess().getSubTypeTypeLiteralParserRuleCall_4_2_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
                    lv_subType_10_0=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypeLiteralRule());
                      						}
                      						set(
                      							current,
                      							"subType",
                      							lv_subType_10_0,
                      							"org.eclipse.ecoretools.Ale.typeLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_11=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:2999:3: ( () otherlv_13= 'OrderedSet(' ( (lv_subType_14_0= ruletypeLiteral ) ) otherlv_15= ')' )
                    {
                    // InternalAle.g:2999:3: ( () otherlv_13= 'OrderedSet(' ( (lv_subType_14_0= ruletypeLiteral ) ) otherlv_15= ')' )
                    // InternalAle.g:3000:4: () otherlv_13= 'OrderedSet(' ( (lv_subType_14_0= ruletypeLiteral ) ) otherlv_15= ')'
                    {
                    // InternalAle.g:3000:4: ()
                    // InternalAle.g:3001:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeLiteralAccess().getTypeLiteralOrderedTypeSetAction_5_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_13=(Token)match(input,77,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getTypeLiteralAccess().getOrderedSetKeyword_5_1());
                      			
                    }
                    // InternalAle.g:3014:4: ( (lv_subType_14_0= ruletypeLiteral ) )
                    // InternalAle.g:3015:5: (lv_subType_14_0= ruletypeLiteral )
                    {
                    // InternalAle.g:3015:5: (lv_subType_14_0= ruletypeLiteral )
                    // InternalAle.g:3016:6: lv_subType_14_0= ruletypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeLiteralAccess().getSubTypeTypeLiteralParserRuleCall_5_2_0());
                      					
                    }
                    pushFollow(FOLLOW_20);
                    lv_subType_14_0=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypeLiteralRule());
                      						}
                      						set(
                      							current,
                      							"subType",
                      							lv_subType_14_0,
                      							"org.eclipse.ecoretools.Ale.typeLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_15=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_5_3());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:3039:3: ( () ruleclassifierTypeRule )
                    {
                    // InternalAle.g:3039:3: ( () ruleclassifierTypeRule )
                    // InternalAle.g:3040:4: () ruleclassifierTypeRule
                    {
                    // InternalAle.g:3040:4: ()
                    // InternalAle.g:3041:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeLiteralAccess().getTypeLiteralClassifierAction_6_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_6_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    ruleclassifierTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:3062:3: ( () otherlv_19= '{' ruleclassifierTypeRule (otherlv_21= '|' ruleclassifierTypeRule )* otherlv_23= '}' )
                    {
                    // InternalAle.g:3062:3: ( () otherlv_19= '{' ruleclassifierTypeRule (otherlv_21= '|' ruleclassifierTypeRule )* otherlv_23= '}' )
                    // InternalAle.g:3063:4: () otherlv_19= '{' ruleclassifierTypeRule (otherlv_21= '|' ruleclassifierTypeRule )* otherlv_23= '}'
                    {
                    // InternalAle.g:3063:4: ()
                    // InternalAle.g:3064:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeLiteralAccess().getTypeLiteralPipeAction_7_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_19=(Token)match(input,27,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getTypeLiteralAccess().getLeftCurlyBracketKeyword_7_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_2());
                      			
                    }
                    pushFollow(FOLLOW_47);
                    ruleclassifierTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalAle.g:3087:4: (otherlv_21= '|' ruleclassifierTypeRule )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==65) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalAle.g:3088:5: otherlv_21= '|' ruleclassifierTypeRule
                    	    {
                    	    otherlv_21=(Token)match(input,65,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_21, grammarAccess.getTypeLiteralAccess().getVerticalLineKeyword_7_3_0());
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					/* */
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_3_1());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_47);
                    	    ruleclassifierTypeRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					afterParserOrEnumRuleCall();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_23, grammarAccess.getTypeLiteralAccess().getRightCurlyBracketKeyword_7_4());
                      			
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
    // InternalAle.g:3112:1: entryRuleclassifierTypeRule returns [String current=null] : iv_ruleclassifierTypeRule= ruleclassifierTypeRule EOF ;
    public final String entryRuleclassifierTypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleclassifierTypeRule = null;


        try {
            // InternalAle.g:3112:58: (iv_ruleclassifierTypeRule= ruleclassifierTypeRule EOF )
            // InternalAle.g:3113:2: iv_ruleclassifierTypeRule= ruleclassifierTypeRule EOF
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
    // InternalAle.g:3119:1: ruleclassifierTypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_IDENT_0= RULE_IDENT kw= '::' this_IDENT_2= RULE_IDENT ) | (this_IDENT_3= RULE_IDENT kw= ':' ) ) ;
    public final AntlrDatatypeRuleToken ruleclassifierTypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENT_0=null;
        Token kw=null;
        Token this_IDENT_2=null;
        Token this_IDENT_3=null;


        	enterRule();

        try {
            // InternalAle.g:3125:2: ( ( (this_IDENT_0= RULE_IDENT kw= '::' this_IDENT_2= RULE_IDENT ) | (this_IDENT_3= RULE_IDENT kw= ':' ) ) )
            // InternalAle.g:3126:2: ( (this_IDENT_0= RULE_IDENT kw= '::' this_IDENT_2= RULE_IDENT ) | (this_IDENT_3= RULE_IDENT kw= ':' ) )
            {
            // InternalAle.g:3126:2: ( (this_IDENT_0= RULE_IDENT kw= '::' this_IDENT_2= RULE_IDENT ) | (this_IDENT_3= RULE_IDENT kw= ':' ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_IDENT) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==71) ) {
                    alt38=1;
                }
                else if ( (LA38_1==53) ) {
                    alt38=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalAle.g:3127:3: (this_IDENT_0= RULE_IDENT kw= '::' this_IDENT_2= RULE_IDENT )
                    {
                    // InternalAle.g:3127:3: (this_IDENT_0= RULE_IDENT kw= '::' this_IDENT_2= RULE_IDENT )
                    // InternalAle.g:3128:4: this_IDENT_0= RULE_IDENT kw= '::' this_IDENT_2= RULE_IDENT
                    {
                    this_IDENT_0=(Token)match(input,RULE_IDENT,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_IDENT_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IDENT_0, grammarAccess.getClassifierTypeRuleAccess().getIDENTTerminalRuleCall_0_0());
                      			
                    }
                    kw=(Token)match(input,71,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getClassifierTypeRuleAccess().getColonColonKeyword_0_1());
                      			
                    }
                    this_IDENT_2=(Token)match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_IDENT_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IDENT_2, grammarAccess.getClassifierTypeRuleAccess().getIDENTTerminalRuleCall_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:3149:3: (this_IDENT_3= RULE_IDENT kw= ':' )
                    {
                    // InternalAle.g:3149:3: (this_IDENT_3= RULE_IDENT kw= ':' )
                    // InternalAle.g:3150:4: this_IDENT_3= RULE_IDENT kw= ':'
                    {
                    this_IDENT_3=(Token)match(input,RULE_IDENT,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_IDENT_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IDENT_3, grammarAccess.getClassifierTypeRuleAccess().getIDENTTerminalRuleCall_1_0());
                      			
                    }
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRulerType"
    // InternalAle.g:3167:1: entryRulerType returns [EObject current=null] : iv_rulerType= rulerType EOF ;
    public final EObject entryRulerType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerType = null;


        try {
            // InternalAle.g:3167:46: (iv_rulerType= rulerType EOF )
            // InternalAle.g:3168:2: iv_rulerType= rulerType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerType=rulerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerType; 
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
    // $ANTLR end "entryRulerType"


    // $ANTLR start "rulerType"
    // InternalAle.g:3174:1: rulerType returns [EObject current=null] : ( rulerQualified | this_typeLiteral_1= ruletypeLiteral ) ;
    public final EObject rulerType() throws RecognitionException {
        EObject current = null;

        EObject this_typeLiteral_1 = null;



        	enterRule();

        try {
            // InternalAle.g:3180:2: ( ( rulerQualified | this_typeLiteral_1= ruletypeLiteral ) )
            // InternalAle.g:3181:2: ( rulerQualified | this_typeLiteral_1= ruletypeLiteral )
            {
            // InternalAle.g:3181:2: ( rulerQualified | this_typeLiteral_1= ruletypeLiteral )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_IDENT) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==53||LA39_1==71) ) {
                    alt39=2;
                }
                else if ( (LA39_1==EOF||LA39_1==RULE_IDENT||LA39_1==22) ) {
                    alt39=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA39_0==27||(LA39_0>=72 && LA39_0<=77)) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalAle.g:3182:3: rulerQualified
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRTypeAccess().getRQualifiedParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    rulerQualified();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAle.g:3193:3: this_typeLiteral_1= ruletypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRTypeAccess().getTypeLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_typeLiteral_1=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_typeLiteral_1;
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
    // $ANTLR end "rulerType"


    // $ANTLR start "entryRulerQualified"
    // InternalAle.g:3208:1: entryRulerQualified returns [String current=null] : iv_rulerQualified= rulerQualified EOF ;
    public final String entryRulerQualified() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerQualified = null;


        try {
            // InternalAle.g:3208:50: (iv_rulerQualified= rulerQualified EOF )
            // InternalAle.g:3209:2: iv_rulerQualified= rulerQualified EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRQualifiedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulerQualified=rulerQualified();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulerQualified.getText(); 
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
    // $ANTLR end "entryRulerQualified"


    // $ANTLR start "rulerQualified"
    // InternalAle.g:3215:1: rulerQualified returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IDENT_0= RULE_IDENT (kw= '.' this_IDENT_2= RULE_IDENT )* ) ;
    public final AntlrDatatypeRuleToken rulerQualified() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IDENT_0=null;
        Token kw=null;
        Token this_IDENT_2=null;


        	enterRule();

        try {
            // InternalAle.g:3221:2: ( (this_IDENT_0= RULE_IDENT (kw= '.' this_IDENT_2= RULE_IDENT )* ) )
            // InternalAle.g:3222:2: (this_IDENT_0= RULE_IDENT (kw= '.' this_IDENT_2= RULE_IDENT )* )
            {
            // InternalAle.g:3222:2: (this_IDENT_0= RULE_IDENT (kw= '.' this_IDENT_2= RULE_IDENT )* )
            // InternalAle.g:3223:3: this_IDENT_0= RULE_IDENT (kw= '.' this_IDENT_2= RULE_IDENT )*
            {
            this_IDENT_0=(Token)match(input,RULE_IDENT,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_IDENT_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_IDENT_0, grammarAccess.getRQualifiedAccess().getIDENTTerminalRuleCall_0());
              		
            }
            // InternalAle.g:3230:3: (kw= '.' this_IDENT_2= RULE_IDENT )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==22) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalAle.g:3231:4: kw= '.' this_IDENT_2= RULE_IDENT
            	    {
            	    kw=(Token)match(input,22,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getRQualifiedAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_IDENT_2=(Token)match(input,RULE_IDENT,FOLLOW_48); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_IDENT_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_IDENT_2, grammarAccess.getRQualifiedAccess().getIDENTTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
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
    // $ANTLR end "rulerQualified"

    // $ANTLR start synpred17_InternalAle
    public final void synpred17_InternalAle_fragment() throws RecognitionException {   
        EObject lv_stmt_1_0 = null;


        // InternalAle.g:920:3: ( ( () ( (lv_stmt_1_0= rulerVarDecl ) ) ) )
        // InternalAle.g:920:3: ( () ( (lv_stmt_1_0= rulerVarDecl ) ) )
        {
        // InternalAle.g:920:3: ( () ( (lv_stmt_1_0= rulerVarDecl ) ) )
        // InternalAle.g:921:4: () ( (lv_stmt_1_0= rulerVarDecl ) )
        {
        // InternalAle.g:921:4: ()
        // InternalAle.g:922:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalAle.g:931:4: ( (lv_stmt_1_0= rulerVarDecl ) )
        // InternalAle.g:932:5: (lv_stmt_1_0= rulerVarDecl )
        {
        // InternalAle.g:932:5: (lv_stmt_1_0= rulerVarDecl )
        // InternalAle.g:933:6: lv_stmt_1_0= rulerVarDecl
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRStatementAccess().getStmtRVarDeclParserRuleCall_0_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_stmt_1_0=rulerVarDecl();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred17_InternalAle

    // $ANTLR start synpred18_InternalAle
    public final void synpred18_InternalAle_fragment() throws RecognitionException {   
        EObject lv_stmt_3_0 = null;


        // InternalAle.g:952:3: ( ( () ( (lv_stmt_3_0= rulerAssign ) ) ) )
        // InternalAle.g:952:3: ( () ( (lv_stmt_3_0= rulerAssign ) ) )
        {
        // InternalAle.g:952:3: ( () ( (lv_stmt_3_0= rulerAssign ) ) )
        // InternalAle.g:953:4: () ( (lv_stmt_3_0= rulerAssign ) )
        {
        // InternalAle.g:953:4: ()
        // InternalAle.g:954:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalAle.g:963:4: ( (lv_stmt_3_0= rulerAssign ) )
        // InternalAle.g:964:5: (lv_stmt_3_0= rulerAssign )
        {
        // InternalAle.g:964:5: (lv_stmt_3_0= rulerAssign )
        // InternalAle.g:965:6: lv_stmt_3_0= rulerAssign
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRStatementAccess().getStmtRAssignParserRuleCall_1_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_stmt_3_0=rulerAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred18_InternalAle

    // $ANTLR start synpred21_InternalAle
    public final void synpred21_InternalAle_fragment() throws RecognitionException {   
        EObject lv_if_9_0 = null;


        // InternalAle.g:1048:3: ( ( () ( (lv_if_9_0= rulerIf ) ) ) )
        // InternalAle.g:1048:3: ( () ( (lv_if_9_0= rulerIf ) ) )
        {
        // InternalAle.g:1048:3: ( () ( (lv_if_9_0= rulerIf ) ) )
        // InternalAle.g:1049:4: () ( (lv_if_9_0= rulerIf ) )
        {
        // InternalAle.g:1049:4: ()
        // InternalAle.g:1050:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalAle.g:1059:4: ( (lv_if_9_0= rulerIf ) )
        // InternalAle.g:1060:5: (lv_if_9_0= rulerIf )
        {
        // InternalAle.g:1060:5: (lv_if_9_0= rulerIf )
        // InternalAle.g:1061:6: lv_if_9_0= rulerIf
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRStatementAccess().getIfRIfParserRuleCall_4_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_if_9_0=rulerIf();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred21_InternalAle

    // $ANTLR start synpred27_InternalAle
    public final void synpred27_InternalAle_fragment() throws RecognitionException {   
        EObject lv_recpart_1_0 = null;


        // InternalAle.g:1678:4: ( (lv_recpart_1_0= rulerecExpression ) )
        // InternalAle.g:1678:4: (lv_recpart_1_0= rulerecExpression )
        {
        // InternalAle.g:1678:4: (lv_recpart_1_0= rulerecExpression )
        // InternalAle.g:1679:5: lv_recpart_1_0= rulerecExpression
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getExpressionAccess().getRecpartRecExpressionParserRuleCall_1_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_recpart_1_0=rulerecExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred27_InternalAle

    // $ANTLR start synpred35_InternalAle
    public final void synpred35_InternalAle_fragment() throws RecognitionException {   
        EObject lv_recExp_15_0 = null;


        // InternalAle.g:1855:4: ( (lv_recExp_15_0= rulerecExpression ) )
        // InternalAle.g:1855:4: (lv_recExp_15_0= rulerecExpression )
        {
        // InternalAle.g:1855:4: (lv_recExp_15_0= rulerecExpression )
        // InternalAle.g:1856:5: lv_recExp_15_0= rulerecExpression
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getRecExpressionAccess().getRecExpRecExpressionParserRuleCall_1_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_recExp_15_0=rulerecExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred35_InternalAle

    // Delegated rules

    public final boolean synpred17_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA17 dfa17 = new DFA17(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA35 dfa35 = new DFA35(this);
    static final String dfa_1s = "\34\uffff";
    static final String dfa_2s = "\1\4\25\0\6\uffff";
    static final String dfa_3s = "\1\115\25\0\6\uffff";
    static final String dfa_4s = "\26\uffff\1\3\1\4\1\1\1\2\1\6\1\5";
    static final String dfa_5s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\14\3\uffff\1\13\1\15\20\uffff\1\10\3\uffff\1\23\3\uffff\1\26\4\uffff\1\24\1\uffff\1\27\5\uffff\1\11\1\12\2\uffff\1\25\15\uffff\1\16\1\17\1\20\1\21\1\22\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7",
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

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "919:2: ( ( () ( (lv_stmt_1_0= rulerVarDecl ) ) ) | ( () ( (lv_stmt_3_0= rulerAssign ) ) ) | ( () ( (lv_forEach_5_0= rulerForEach ) ) ) | ( () ( (lv_while_7_0= rulerWhile ) ) ) | ( () ( (lv_if_9_0= rulerIf ) ) ) | ( () ( (lv_expr_11_0= rulerExpression ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_1 = input.LA(1);

                         
                        int index17_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalAle()) ) {s = 24;}

                        else if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_2 = input.LA(1);

                         
                        int index17_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalAle()) ) {s = 24;}

                        else if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_3 = input.LA(1);

                         
                        int index17_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalAle()) ) {s = 24;}

                        else if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_4 = input.LA(1);

                         
                        int index17_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalAle()) ) {s = 24;}

                        else if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_5 = input.LA(1);

                         
                        int index17_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalAle()) ) {s = 24;}

                        else if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_6 = input.LA(1);

                         
                        int index17_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalAle()) ) {s = 24;}

                        else if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_7 = input.LA(1);

                         
                        int index17_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalAle()) ) {s = 24;}

                        else if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_8 = input.LA(1);

                         
                        int index17_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalAle()) ) {s = 24;}

                        else if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_9 = input.LA(1);

                         
                        int index17_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_10 = input.LA(1);

                         
                        int index17_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_11 = input.LA(1);

                         
                        int index17_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_12 = input.LA(1);

                         
                        int index17_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_13 = input.LA(1);

                         
                        int index17_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_14 = input.LA(1);

                         
                        int index17_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_15 = input.LA(1);

                         
                        int index17_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_16 = input.LA(1);

                         
                        int index17_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_17 = input.LA(1);

                         
                        int index17_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_18 = input.LA(1);

                         
                        int index17_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_19 = input.LA(1);

                         
                        int index17_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_20 = input.LA(1);

                         
                        int index17_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (synpred21_InternalAle()) ) {s = 27;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_21 = input.LA(1);

                         
                        int index17_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\14\uffff";
    static final String dfa_8s = "\1\12\13\uffff";
    static final String dfa_9s = "\1\6\11\0\2\uffff";
    static final String dfa_10s = "\1\63\11\0\2\uffff";
    static final String dfa_11s = "\12\uffff\1\2\1\1";
    static final String dfa_12s = "\1\uffff\1\1\1\10\1\2\1\3\1\4\1\5\1\6\1\7\1\0\2\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\1\4\1\5\11\uffff\1\12\3\uffff\1\1\3\uffff\1\12\1\uffff\1\12\3\uffff\1\12\1\uffff\1\12\1\uffff\1\12\4\uffff\1\12\1\uffff\1\6\1\7\1\10\1\11\1\2\2\uffff\2\12",
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

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1677:3: ( (lv_recpart_1_0= rulerecExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_9 = input.LA(1);

                         
                        int index23_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index23_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_1 = input.LA(1);

                         
                        int index23_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index23_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_3 = input.LA(1);

                         
                        int index23_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index23_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_4 = input.LA(1);

                         
                        int index23_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index23_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_5 = input.LA(1);

                         
                        int index23_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index23_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_6 = input.LA(1);

                         
                        int index23_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index23_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_7 = input.LA(1);

                         
                        int index23_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index23_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_8 = input.LA(1);

                         
                        int index23_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index23_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_2 = input.LA(1);

                         
                        int index23_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index23_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1854:3: ( (lv_recExp_15_0= rulerecExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_9 = input.LA(1);

                         
                        int index25_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index25_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_1 = input.LA(1);

                         
                        int index25_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index25_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_4 = input.LA(1);

                         
                        int index25_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index25_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index25_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_8 = input.LA(1);

                         
                        int index25_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index25_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_2 = input.LA(1);

                         
                        int index25_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index25_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_14s = "\17\uffff";
    static final String dfa_15s = "\14\uffff\1\12\2\uffff";
    static final String dfa_16s = "\1\4\10\uffff\1\65\1\uffff\1\4\1\6\2\uffff";
    static final String dfa_17s = "\1\115\10\uffff\1\107\1\uffff\1\4\1\107\2\uffff";
    static final String dfa_18s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\2\uffff\1\11\1\12";
    static final String dfa_19s = "\17\uffff}>";
    static final String[] dfa_20s = {
            "\1\11\1\2\3\uffff\1\1\1\3\20\uffff\1\12\46\uffff\1\4\1\5\1\6\1\7\1\10\1\uffff\6\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\21\uffff\1\13",
            "",
            "\1\14",
            "\3\12\11\uffff\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\3\uffff\1\12\1\uffff\1\12\1\uffff\1\12\4\uffff\1\12\1\uffff\5\12\2\uffff\2\12\1\uffff\1\16\21\uffff\1\15",
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

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "2744:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_REAL_2= RULE_REAL | otherlv_3= 'true' | otherlv_4= 'false' | otherlv_5= 'null' | (otherlv_6= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence otherlv_8= '}' ) | (otherlv_9= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence otherlv_11= '}' ) | (this_IDENT_12= RULE_IDENT otherlv_13= '::' this_IDENT_14= RULE_IDENT otherlv_15= '::' this_IDENT_16= RULE_IDENT ) | (this_IDENT_17= RULE_IDENT otherlv_18= '::' this_IDENT_19= RULE_IDENT otherlv_20= ':' ) | this_typeLiteral_21= ruletypeLiteral )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000001A80002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001A00002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000278000010L,0x0000000000003F00L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000270000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000260000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000010L,0x0000000000003F00L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000108000010L,0x0000000000003F00L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000400040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0013010088000630L,0x0000000000003F7CL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0013012088000630L,0x0000000000003F7CL});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0013050898000630L,0x0000000000003F7CL});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000F800004001C2L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0xFF80000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001004000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0013010188000630L,0x0000000000003F7CL});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0013010098000630L,0x0000000000003F7CL});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000400002L});

}