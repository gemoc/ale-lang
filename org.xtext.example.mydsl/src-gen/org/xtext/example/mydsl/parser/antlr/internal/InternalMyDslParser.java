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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENT", "RULE_INT", "RULE_MULTOP", "RULE_STRING", "RULE_REAL", "RULE_LETTER", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'behavior'", "';'", "'import'", "'as'", "'use'", "'.'", "'open'", "'class'", "'extends'", "','", "'{'", "'}'", "'def'", "'override'", "'('", "')'", "'@'", "':='", "'for'", "'in'", "'['", "'..'", "']'", "'if'", "'else'", "'while'", "'and'", "'or'", "'xor'", "'implies'", "'->'", "'not'", "'-'", "'then'", "'endif'", "'let'", "':'", "'='", "'+'", "'<='", "'>='", "'!='", "'<>'", "'=='", "'<'", "'>'", "'select'", "'reject'", "'collect'", "'any'", "'exists'", "'forAll'", "'isUnique'", "'one'", "'sortedBy'", "'closure'", "'|'", "'true'", "'false'", "'null'", "'Sequence{'", "'OrderedSet{'", "'::'", "'String'", "'Integer'", "'Real'", "'Boolean'", "'Sequence('", "'OrderedSet('"
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
    public static final int RULE_IDENT=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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
    public static final int RULE_STRING=7;
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
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_LETTER=9;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_MULTOP=6;
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
    // InternalMyDsl.g:77:1: rulerRoot returns [EObject current=null] : (otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )* ) ;
    public final EObject rulerRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_xtendedClasses_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:83:2: ( (otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )* ) )
            // InternalMyDsl.g:84:2: (otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )* )
            {
            // InternalMyDsl.g:84:2: (otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )* )
            // InternalMyDsl.g:85:3: otherlv_0= 'behavior' rulerQualified otherlv_2= ';' ( rulerImport )* ( rulerService )* ( (lv_xtendedClasses_5_0= rulerClass ) )*
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
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
            otherlv_2=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRRootAccess().getSemicolonKeyword_2());
              		
            }
            // InternalMyDsl.g:103:3: ( rulerImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDsl.g:104:4: rulerImport
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

            // InternalMyDsl.g:115:3: ( rulerService )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyDsl.g:116:4: rulerService
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

            // InternalMyDsl.g:127:3: ( (lv_xtendedClasses_5_0= rulerClass ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=21 && LA3_0<=22)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMyDsl.g:128:4: (lv_xtendedClasses_5_0= rulerClass )
            	    {
            	    // InternalMyDsl.g:128:4: (lv_xtendedClasses_5_0= rulerClass )
            	    // InternalMyDsl.g:129:5: lv_xtendedClasses_5_0= rulerClass
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
    // InternalMyDsl.g:150:1: entryRulerImport returns [String current=null] : iv_rulerImport= rulerImport EOF ;
    public final String entryRulerImport() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerImport = null;


        try {
            // InternalMyDsl.g:150:47: (iv_rulerImport= rulerImport EOF )
            // InternalMyDsl.g:151:2: iv_rulerImport= rulerImport EOF
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
    // InternalMyDsl.g:157:1: rulerImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_Ident_3= RULE_IDENT kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerImport() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_3=null;
        AntlrDatatypeRuleToken this_rQualified_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:163:2: ( (kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_Ident_3= RULE_IDENT kw= ';' ) )
            // InternalMyDsl.g:164:2: (kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_Ident_3= RULE_IDENT kw= ';' )
            {
            // InternalMyDsl.g:164:2: (kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_Ident_3= RULE_IDENT kw= ';' )
            // InternalMyDsl.g:165:3: kw= 'import' this_rQualified_1= rulerQualified kw= 'as' this_Ident_3= RULE_IDENT kw= ';'
            {
            kw=(Token)match(input,17,FOLLOW_3); if (state.failed) return current;
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
            kw=(Token)match(input,18,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRImportAccess().getAsKeyword_2());
              		
            }
            this_Ident_3=(Token)match(input,RULE_IDENT,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_3);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_3, grammarAccess.getRImportAccess().getIdentTerminalRuleCall_3());
              		
            }
            kw=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:201:1: entryRulerService returns [String current=null] : iv_rulerService= rulerService EOF ;
    public final String entryRulerService() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerService = null;


        try {
            // InternalMyDsl.g:201:48: (iv_rulerService= rulerService EOF )
            // InternalMyDsl.g:202:2: iv_rulerService= rulerService EOF
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
    // InternalMyDsl.g:208:1: rulerService returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerService() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_1=null;
        Token this_Ident_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:214:2: ( (kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';' ) )
            // InternalMyDsl.g:215:2: (kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';' )
            {
            // InternalMyDsl.g:215:2: (kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';' )
            // InternalMyDsl.g:216:3: kw= 'use' this_Ident_1= RULE_IDENT (kw= '.' this_Ident_3= RULE_IDENT )* kw= ';'
            {
            kw=(Token)match(input,19,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRServiceAccess().getUseKeyword_0());
              		
            }
            this_Ident_1=(Token)match(input,RULE_IDENT,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_1, grammarAccess.getRServiceAccess().getIdentTerminalRuleCall_1());
              		
            }
            // InternalMyDsl.g:228:3: (kw= '.' this_Ident_3= RULE_IDENT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMyDsl.g:229:4: kw= '.' this_Ident_3= RULE_IDENT
            	    {
            	    kw=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getRServiceAccess().getFullStopKeyword_2_0());
            	      			
            	    }
            	    this_Ident_3=(Token)match(input,RULE_IDENT,FOLLOW_9); if (state.failed) return current;
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

            kw=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:251:1: entryRulerClass returns [EObject current=null] : iv_rulerClass= rulerClass EOF ;
    public final EObject entryRulerClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerClass = null;


        try {
            // InternalMyDsl.g:251:47: (iv_rulerClass= rulerClass EOF )
            // InternalMyDsl.g:252:2: iv_rulerClass= rulerClass EOF
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
    // InternalMyDsl.g:258:1: rulerClass returns [EObject current=null] : (this_rOpenClass_0= rulerOpenClass | this_rNewClass_1= rulerNewClass ) ;
    public final EObject rulerClass() throws RecognitionException {
        EObject current = null;

        EObject this_rOpenClass_0 = null;

        EObject this_rNewClass_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:264:2: ( (this_rOpenClass_0= rulerOpenClass | this_rNewClass_1= rulerNewClass ) )
            // InternalMyDsl.g:265:2: (this_rOpenClass_0= rulerOpenClass | this_rNewClass_1= rulerNewClass )
            {
            // InternalMyDsl.g:265:2: (this_rOpenClass_0= rulerOpenClass | this_rNewClass_1= rulerNewClass )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            else if ( (LA5_0==22) ) {
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
                    // InternalMyDsl.g:266:3: this_rOpenClass_0= rulerOpenClass
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRClassAccess().getROpenClassParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_rOpenClass_0=rulerOpenClass();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_rOpenClass_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:278:3: this_rNewClass_1= rulerNewClass
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRClassAccess().getRNewClassParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_rNewClass_1=rulerNewClass();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_rNewClass_1;
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
    // $ANTLR end "rulerClass"


    // $ANTLR start "entryRulerOpenClass"
    // InternalMyDsl.g:293:1: entryRulerOpenClass returns [EObject current=null] : iv_rulerOpenClass= rulerOpenClass EOF ;
    public final EObject entryRulerOpenClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerOpenClass = null;


        try {
            // InternalMyDsl.g:293:51: (iv_rulerOpenClass= rulerOpenClass EOF )
            // InternalMyDsl.g:294:2: iv_rulerOpenClass= rulerOpenClass EOF
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
    // InternalMyDsl.g:300:1: rulerOpenClass returns [EObject current=null] : (otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= RULE_IDENT ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}' ) ;
    public final EObject rulerOpenClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_attributes_8_0 = null;

        EObject lv_operations_9_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:306:2: ( (otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= RULE_IDENT ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}' ) )
            // InternalMyDsl.g:307:2: (otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= RULE_IDENT ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}' )
            {
            // InternalMyDsl.g:307:2: (otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= RULE_IDENT ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}' )
            // InternalMyDsl.g:308:3: otherlv_0= 'open' otherlv_1= 'class' ( (lv_name_2_0= RULE_IDENT ) ) (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )? otherlv_7= '{' ( (lv_attributes_8_0= rulerAttribute ) )* ( (lv_operations_9_0= rulerOperation ) )* otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getROpenClassAccess().getOpenKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,22,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getROpenClassAccess().getClassKeyword_1());
              		
            }
            // InternalMyDsl.g:316:3: ( (lv_name_2_0= RULE_IDENT ) )
            // InternalMyDsl.g:317:4: (lv_name_2_0= RULE_IDENT )
            {
            // InternalMyDsl.g:317:4: (lv_name_2_0= RULE_IDENT )
            // InternalMyDsl.g:318:5: lv_name_2_0= RULE_IDENT
            {
            lv_name_2_0=(Token)match(input,RULE_IDENT,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getROpenClassAccess().getNameIdentTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getROpenClassRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.xtext.example.mydsl.MyDsl.Ident");
              				
            }

            }


            }

            // InternalMyDsl.g:334:3: (otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==23) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMyDsl.g:335:4: otherlv_3= 'extends' rulerQualified (otherlv_5= ',' rulerQualified )*
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); if (state.failed) return current;
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
                    // InternalMyDsl.g:349:4: (otherlv_5= ',' rulerQualified )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==24) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalMyDsl.g:350:5: otherlv_5= ',' rulerQualified
                    	    {
                    	    otherlv_5=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getROpenClassAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalMyDsl.g:370:3: ( (lv_attributes_8_0= rulerAttribute ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_IDENT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMyDsl.g:371:4: (lv_attributes_8_0= rulerAttribute )
            	    {
            	    // InternalMyDsl.g:371:4: (lv_attributes_8_0= rulerAttribute )
            	    // InternalMyDsl.g:372:5: lv_attributes_8_0= rulerAttribute
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
            	      						"org.xtext.example.mydsl.MyDsl.rAttribute");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalMyDsl.g:389:3: ( (lv_operations_9_0= rulerOperation ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=27 && LA9_0<=28)||LA9_0==31) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMyDsl.g:390:4: (lv_operations_9_0= rulerOperation )
            	    {
            	    // InternalMyDsl.g:390:4: (lv_operations_9_0= rulerOperation )
            	    // InternalMyDsl.g:391:5: lv_operations_9_0= rulerOperation
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
            	      						"org.xtext.example.mydsl.MyDsl.rOperation");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_10=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:416:1: entryRulerNewClass returns [EObject current=null] : iv_rulerNewClass= rulerNewClass EOF ;
    public final EObject entryRulerNewClass() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerNewClass = null;


        try {
            // InternalMyDsl.g:416:50: (iv_rulerNewClass= rulerNewClass EOF )
            // InternalMyDsl.g:417:2: iv_rulerNewClass= rulerNewClass EOF
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
    // InternalMyDsl.g:423:1: rulerNewClass returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' ) ;
    public final EObject rulerNewClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_operations_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:429:2: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' ) )
            // InternalMyDsl.g:430:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' )
            {
            // InternalMyDsl.g:430:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}' )
            // InternalMyDsl.g:431:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_IDENT ) ) otherlv_2= '{' ( (lv_attributes_3_0= rulerAttribute ) )* ( (lv_operations_4_0= rulerOperation ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRNewClassAccess().getClassKeyword_0());
              		
            }
            // InternalMyDsl.g:435:3: ( (lv_name_1_0= RULE_IDENT ) )
            // InternalMyDsl.g:436:4: (lv_name_1_0= RULE_IDENT )
            {
            // InternalMyDsl.g:436:4: (lv_name_1_0= RULE_IDENT )
            // InternalMyDsl.g:437:5: lv_name_1_0= RULE_IDENT
            {
            lv_name_1_0=(Token)match(input,RULE_IDENT,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRNewClassAccess().getNameIdentTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRNewClassRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.xtext.example.mydsl.MyDsl.Ident");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRNewClassAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalMyDsl.g:457:3: ( (lv_attributes_3_0= rulerAttribute ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_IDENT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMyDsl.g:458:4: (lv_attributes_3_0= rulerAttribute )
            	    {
            	    // InternalMyDsl.g:458:4: (lv_attributes_3_0= rulerAttribute )
            	    // InternalMyDsl.g:459:5: lv_attributes_3_0= rulerAttribute
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
            	      						"org.xtext.example.mydsl.MyDsl.rAttribute");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalMyDsl.g:476:3: ( (lv_operations_4_0= rulerOperation ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=27 && LA11_0<=28)||LA11_0==31) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMyDsl.g:477:4: (lv_operations_4_0= rulerOperation )
            	    {
            	    // InternalMyDsl.g:477:4: (lv_operations_4_0= rulerOperation )
            	    // InternalMyDsl.g:478:5: lv_operations_4_0= rulerOperation
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
            	      						"org.xtext.example.mydsl.MyDsl.rOperation");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_5=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:503:1: entryRulerOperation returns [EObject current=null] : iv_rulerOperation= rulerOperation EOF ;
    public final EObject entryRulerOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerOperation = null;


        try {
            // InternalMyDsl.g:503:51: (iv_rulerOperation= rulerOperation EOF )
            // InternalMyDsl.g:504:2: iv_rulerOperation= rulerOperation EOF
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
    // InternalMyDsl.g:510:1: rulerOperation returns [EObject current=null] : ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) ) ;
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
            // InternalMyDsl.g:516:2: ( ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) ) )
            // InternalMyDsl.g:517:2: ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) )
            {
            // InternalMyDsl.g:517:2: ( ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) ) )
            // InternalMyDsl.g:518:3: ( rulerTag )* (otherlv_1= 'def' | otherlv_2= 'override' ) ( (lv_type_3_0= RULE_IDENT ) ) ( (lv_name_4_0= RULE_IDENT ) ) otherlv_5= '(' ( (lv_paramList_6_0= rulerParameters ) )? otherlv_7= ')' ( (lv_body_8_0= rulerBlock ) )
            {
            // InternalMyDsl.g:518:3: ( rulerTag )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==31) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMyDsl.g:519:4: rulerTag
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

            // InternalMyDsl.g:530:3: (otherlv_1= 'def' | otherlv_2= 'override' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            else if ( (LA13_0==28) ) {
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
                    // InternalMyDsl.g:531:4: otherlv_1= 'def'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getROperationAccess().getDefKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:536:4: otherlv_2= 'override'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getROperationAccess().getOverrideKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalMyDsl.g:541:3: ( (lv_type_3_0= RULE_IDENT ) )
            // InternalMyDsl.g:542:4: (lv_type_3_0= RULE_IDENT )
            {
            // InternalMyDsl.g:542:4: (lv_type_3_0= RULE_IDENT )
            // InternalMyDsl.g:543:5: lv_type_3_0= RULE_IDENT
            {
            lv_type_3_0=(Token)match(input,RULE_IDENT,FOLLOW_3); if (state.failed) return current;
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

            // InternalMyDsl.g:559:3: ( (lv_name_4_0= RULE_IDENT ) )
            // InternalMyDsl.g:560:4: (lv_name_4_0= RULE_IDENT )
            {
            // InternalMyDsl.g:560:4: (lv_name_4_0= RULE_IDENT )
            // InternalMyDsl.g:561:5: lv_name_4_0= RULE_IDENT
            {
            lv_name_4_0=(Token)match(input,RULE_IDENT,FOLLOW_17); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,29,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getROperationAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalMyDsl.g:581:3: ( (lv_paramList_6_0= rulerParameters ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_IDENT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMyDsl.g:582:4: (lv_paramList_6_0= rulerParameters )
                    {
                    // InternalMyDsl.g:582:4: (lv_paramList_6_0= rulerParameters )
                    // InternalMyDsl.g:583:5: lv_paramList_6_0= rulerParameters
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getROperationAccess().getParamListRParametersParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_19);
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

            otherlv_7=(Token)match(input,30,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getROperationAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalMyDsl.g:604:3: ( (lv_body_8_0= rulerBlock ) )
            // InternalMyDsl.g:605:4: (lv_body_8_0= rulerBlock )
            {
            // InternalMyDsl.g:605:4: (lv_body_8_0= rulerBlock )
            // InternalMyDsl.g:606:5: lv_body_8_0= rulerBlock
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
    // InternalMyDsl.g:627:1: entryRulerTag returns [String current=null] : iv_rulerTag= rulerTag EOF ;
    public final String entryRulerTag() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerTag = null;


        try {
            // InternalMyDsl.g:627:44: (iv_rulerTag= rulerTag EOF )
            // InternalMyDsl.g:628:2: iv_rulerTag= rulerTag EOF
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
    // InternalMyDsl.g:634:1: rulerTag returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '@' this_Ident_1= RULE_IDENT ) ;
    public final AntlrDatatypeRuleToken rulerTag() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:640:2: ( (kw= '@' this_Ident_1= RULE_IDENT ) )
            // InternalMyDsl.g:641:2: (kw= '@' this_Ident_1= RULE_IDENT )
            {
            // InternalMyDsl.g:641:2: (kw= '@' this_Ident_1= RULE_IDENT )
            // InternalMyDsl.g:642:3: kw= '@' this_Ident_1= RULE_IDENT
            {
            kw=(Token)match(input,31,FOLLOW_3); if (state.failed) return current;
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
    // InternalMyDsl.g:658:1: entryRulerParameters returns [EObject current=null] : iv_rulerParameters= rulerParameters EOF ;
    public final EObject entryRulerParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerParameters = null;


        try {
            // InternalMyDsl.g:658:52: (iv_rulerParameters= rulerParameters EOF )
            // InternalMyDsl.g:659:2: iv_rulerParameters= rulerParameters EOF
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
    // InternalMyDsl.g:665:1: rulerParameters returns [EObject current=null] : ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* ) ;
    public final EObject rulerParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_params_0_0 = null;

        EObject lv_params_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:671:2: ( ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* ) )
            // InternalMyDsl.g:672:2: ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* )
            {
            // InternalMyDsl.g:672:2: ( ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )* )
            // InternalMyDsl.g:673:3: ( (lv_params_0_0= rulerVariable ) ) (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )*
            {
            // InternalMyDsl.g:673:3: ( (lv_params_0_0= rulerVariable ) )
            // InternalMyDsl.g:674:4: (lv_params_0_0= rulerVariable )
            {
            // InternalMyDsl.g:674:4: (lv_params_0_0= rulerVariable )
            // InternalMyDsl.g:675:5: lv_params_0_0= rulerVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_20);
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

            // InternalMyDsl.g:692:3: (otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMyDsl.g:693:4: otherlv_1= ',' ( (lv_params_2_0= rulerVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getRParametersAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalMyDsl.g:697:4: ( (lv_params_2_0= rulerVariable ) )
            	    // InternalMyDsl.g:698:5: (lv_params_2_0= rulerVariable )
            	    {
            	    // InternalMyDsl.g:698:5: (lv_params_2_0= rulerVariable )
            	    // InternalMyDsl.g:699:6: lv_params_2_0= rulerVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
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
    // InternalMyDsl.g:721:1: entryRulerVariable returns [EObject current=null] : iv_rulerVariable= rulerVariable EOF ;
    public final EObject entryRulerVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerVariable = null;


        try {
            // InternalMyDsl.g:721:50: (iv_rulerVariable= rulerVariable EOF )
            // InternalMyDsl.g:722:2: iv_rulerVariable= rulerVariable EOF
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
    // InternalMyDsl.g:728:1: rulerVariable returns [EObject current=null] : ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) ) ;
    public final EObject rulerVariable() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:734:2: ( ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) ) )
            // InternalMyDsl.g:735:2: ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) )
            {
            // InternalMyDsl.g:735:2: ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) )
            // InternalMyDsl.g:736:3: ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) )
            {
            // InternalMyDsl.g:736:3: ( (lv_type_0_0= RULE_IDENT ) )
            // InternalMyDsl.g:737:4: (lv_type_0_0= RULE_IDENT )
            {
            // InternalMyDsl.g:737:4: (lv_type_0_0= RULE_IDENT )
            // InternalMyDsl.g:738:5: lv_type_0_0= RULE_IDENT
            {
            lv_type_0_0=(Token)match(input,RULE_IDENT,FOLLOW_3); if (state.failed) return current;
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

            // InternalMyDsl.g:754:3: ( (lv_name_1_0= RULE_IDENT ) )
            // InternalMyDsl.g:755:4: (lv_name_1_0= RULE_IDENT )
            {
            // InternalMyDsl.g:755:4: (lv_name_1_0= RULE_IDENT )
            // InternalMyDsl.g:756:5: lv_name_1_0= RULE_IDENT
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
    // InternalMyDsl.g:776:1: entryRulerAttribute returns [EObject current=null] : iv_rulerAttribute= rulerAttribute EOF ;
    public final EObject entryRulerAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerAttribute = null;


        try {
            // InternalMyDsl.g:776:51: (iv_rulerAttribute= rulerAttribute EOF )
            // InternalMyDsl.g:777:2: iv_rulerAttribute= rulerAttribute EOF
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
    // InternalMyDsl.g:783:1: rulerAttribute returns [EObject current=null] : ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ruleexpression )? otherlv_4= ';' ) ;
    public final EObject rulerAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:789:2: ( ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ruleexpression )? otherlv_4= ';' ) )
            // InternalMyDsl.g:790:2: ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ruleexpression )? otherlv_4= ';' )
            {
            // InternalMyDsl.g:790:2: ( ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ruleexpression )? otherlv_4= ';' )
            // InternalMyDsl.g:791:3: ( (lv_type_0_0= RULE_IDENT ) ) ( (lv_name_1_0= RULE_IDENT ) ) (otherlv_2= ':=' ruleexpression )? otherlv_4= ';'
            {
            // InternalMyDsl.g:791:3: ( (lv_type_0_0= RULE_IDENT ) )
            // InternalMyDsl.g:792:4: (lv_type_0_0= RULE_IDENT )
            {
            // InternalMyDsl.g:792:4: (lv_type_0_0= RULE_IDENT )
            // InternalMyDsl.g:793:5: lv_type_0_0= RULE_IDENT
            {
            lv_type_0_0=(Token)match(input,RULE_IDENT,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_type_0_0, grammarAccess.getRAttributeAccess().getTypeIdentTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRAttributeRule());
              					}
              					setWithLastConsumed(
              						current,
              						"type",
              						lv_type_0_0,
              						"org.xtext.example.mydsl.MyDsl.Ident");
              				
            }

            }


            }

            // InternalMyDsl.g:809:3: ( (lv_name_1_0= RULE_IDENT ) )
            // InternalMyDsl.g:810:4: (lv_name_1_0= RULE_IDENT )
            {
            // InternalMyDsl.g:810:4: (lv_name_1_0= RULE_IDENT )
            // InternalMyDsl.g:811:5: lv_name_1_0= RULE_IDENT
            {
            lv_name_1_0=(Token)match(input,RULE_IDENT,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRAttributeAccess().getNameIdentTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRAttributeRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.xtext.example.mydsl.MyDsl.Ident");
              				
            }

            }


            }

            // InternalMyDsl.g:827:3: (otherlv_2= ':=' ruleexpression )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==32) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMyDsl.g:828:4: otherlv_2= ':=' ruleexpression
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRAttributeAccess().getColonEqualsSignKeyword_2_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRAttributeAccess().getExpressionParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_4);
                    ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:851:1: entryRulerStatement returns [String current=null] : iv_rulerStatement= rulerStatement EOF ;
    public final String entryRulerStatement() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerStatement = null;


        try {
            // InternalMyDsl.g:851:50: (iv_rulerStatement= rulerStatement EOF )
            // InternalMyDsl.g:852:2: iv_rulerStatement= rulerStatement EOF
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
    // InternalMyDsl.g:858:1: rulerStatement returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression ) ;
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
            // InternalMyDsl.g:864:2: ( (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression ) )
            // InternalMyDsl.g:865:2: (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression )
            {
            // InternalMyDsl.g:865:2: (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression )
            int alt17=6;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:866:3: this_rVarDecl_0= rulerVarDecl
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
                    // InternalMyDsl.g:877:3: this_rAssign_1= rulerAssign
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
                    // InternalMyDsl.g:888:3: this_rForEach_2= rulerForEach
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
                    // InternalMyDsl.g:899:3: this_rWhile_3= rulerWhile
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
                    // InternalMyDsl.g:910:3: this_rIf_4= rulerIf
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
                    // InternalMyDsl.g:921:3: this_rExpression_5= rulerExpression
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
    // InternalMyDsl.g:935:1: entryRulerVarDecl returns [String current=null] : iv_rulerVarDecl= rulerVarDecl EOF ;
    public final String entryRulerVarDecl() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerVarDecl = null;


        try {
            // InternalMyDsl.g:935:48: (iv_rulerVarDecl= rulerVarDecl EOF )
            // InternalMyDsl.g:936:2: iv_rulerVarDecl= rulerVarDecl EOF
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
    // InternalMyDsl.g:942:1: rulerVarDecl returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerVarDecl() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token this_Ident_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_expression_3 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:948:2: ( (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' ) )
            // InternalMyDsl.g:949:2: (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' )
            {
            // InternalMyDsl.g:949:2: (this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';' )
            // InternalMyDsl.g:950:3: this_Ident_0= RULE_IDENT this_Ident_1= RULE_IDENT (kw= ':=' this_expression_3= ruleexpression )? kw= ';'
            {
            this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_0, grammarAccess.getRVarDeclAccess().getIdentTerminalRuleCall_0());
              		
            }
            this_Ident_1=(Token)match(input,RULE_IDENT,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_1, grammarAccess.getRVarDeclAccess().getIdentTerminalRuleCall_1());
              		
            }
            // InternalMyDsl.g:964:3: (kw= ':=' this_expression_3= ruleexpression )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMyDsl.g:965:4: kw= ':=' this_expression_3= ruleexpression
                    {
                    kw=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRVarDeclAccess().getColonEqualsSignKeyword_2_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRVarDeclAccess().getExpressionParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_4);
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

            kw=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:990:1: entryRulerAssign returns [String current=null] : iv_rulerAssign= rulerAssign EOF ;
    public final String entryRulerAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerAssign = null;


        try {
            // InternalMyDsl.g:990:47: (iv_rulerAssign= rulerAssign EOF )
            // InternalMyDsl.g:991:2: iv_rulerAssign= rulerAssign EOF
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
    // InternalMyDsl.g:997:1: rulerAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_0 = null;

        AntlrDatatypeRuleToken this_expression_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1003:2: ( (this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';' ) )
            // InternalMyDsl.g:1004:2: (this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';' )
            {
            // InternalMyDsl.g:1004:2: (this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';' )
            // InternalMyDsl.g:1005:3: this_expression_0= ruleexpression kw= ':=' this_expression_2= ruleexpression kw= ';'
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRAssignAccess().getExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_23);
            this_expression_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_expression_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRAssignAccess().getColonEqualsSignKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRAssignAccess().getExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_4);
            this_expression_2=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_expression_2);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:1039:1: entryRulerForEach returns [String current=null] : iv_rulerForEach= rulerForEach EOF ;
    public final String entryRulerForEach() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerForEach = null;


        try {
            // InternalMyDsl.g:1039:48: (iv_rulerForEach= rulerForEach EOF )
            // InternalMyDsl.g:1040:2: iv_rulerForEach= rulerForEach EOF
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
    // InternalMyDsl.g:1046:1: rulerForEach returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock ) ;
    public final AntlrDatatypeRuleToken rulerForEach() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_2=null;
        AntlrDatatypeRuleToken this_rCollection_4 = null;

        AntlrDatatypeRuleToken this_rBlock_6 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1052:2: ( (kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock ) )
            // InternalMyDsl.g:1053:2: (kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock )
            {
            // InternalMyDsl.g:1053:2: (kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock )
            // InternalMyDsl.g:1054:3: kw= 'for' kw= '(' this_Ident_2= RULE_IDENT kw= 'in' this_rCollection_4= rulerCollection kw= ')' this_rBlock_6= rulerBlock
            {
            kw=(Token)match(input,33,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRForEachAccess().getForKeyword_0());
              		
            }
            kw=(Token)match(input,29,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRForEachAccess().getLeftParenthesisKeyword_1());
              		
            }
            this_Ident_2=(Token)match(input,RULE_IDENT,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_2, grammarAccess.getRForEachAccess().getIdentTerminalRuleCall_2());
              		
            }
            kw=(Token)match(input,34,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRForEachAccess().getInKeyword_3());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRForEachAccess().getRCollectionParserRuleCall_4());
              		
            }
            pushFollow(FOLLOW_19);
            this_rCollection_4=rulerCollection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_rCollection_4);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,30,FOLLOW_15); if (state.failed) return current;
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
    // InternalMyDsl.g:1105:1: entryRulerCollection returns [String current=null] : iv_rulerCollection= rulerCollection EOF ;
    public final String entryRulerCollection() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerCollection = null;


        try {
            // InternalMyDsl.g:1105:51: (iv_rulerCollection= rulerCollection EOF )
            // InternalMyDsl.g:1106:2: iv_rulerCollection= rulerCollection EOF
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
    // InternalMyDsl.g:1112:1: rulerCollection returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' ) | this_expression_5= ruleexpression ) ;
    public final AntlrDatatypeRuleToken rulerCollection() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_expression_5 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1118:2: ( ( (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' ) | this_expression_5= ruleexpression ) )
            // InternalMyDsl.g:1119:2: ( (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' ) | this_expression_5= ruleexpression )
            {
            // InternalMyDsl.g:1119:2: ( (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' ) | this_expression_5= ruleexpression )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=RULE_IDENT && LA19_0<=RULE_INT)||(LA19_0>=RULE_STRING && LA19_0<=RULE_REAL)||LA19_0==25||LA19_0==29||LA19_0==38||(LA19_0>=46 && LA19_0<=47)||LA19_0==50||(LA19_0>=72 && LA19_0<=76)||(LA19_0>=78 && LA19_0<=83)) ) {
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
                    // InternalMyDsl.g:1120:3: (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' )
                    {
                    // InternalMyDsl.g:1120:3: (kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']' )
                    // InternalMyDsl.g:1121:4: kw= '[' this_INT_1= RULE_INT kw= '..' this_INT_3= RULE_INT kw= ']'
                    {
                    kw=(Token)match(input,35,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRCollectionAccess().getLeftSquareBracketKeyword_0_0());
                      			
                    }
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_1, grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_1());
                      			
                    }
                    kw=(Token)match(input,36,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRCollectionAccess().getFullStopFullStopKeyword_0_2());
                      			
                    }
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_3, grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_3());
                      			
                    }
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getRCollectionAccess().getRightSquareBracketKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1152:3: this_expression_5= ruleexpression
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
    // InternalMyDsl.g:1166:1: entryRulerBlock returns [String current=null] : iv_rulerBlock= rulerBlock EOF ;
    public final String entryRulerBlock() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerBlock = null;


        try {
            // InternalMyDsl.g:1166:46: (iv_rulerBlock= rulerBlock EOF )
            // InternalMyDsl.g:1167:2: iv_rulerBlock= rulerBlock EOF
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
    // InternalMyDsl.g:1173:1: rulerBlock returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}' ) ;
    public final AntlrDatatypeRuleToken rulerBlock() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_rStatement_1 = null;

        AntlrDatatypeRuleToken this_rStatement_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1179:2: ( (kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}' ) )
            // InternalMyDsl.g:1180:2: (kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}' )
            {
            // InternalMyDsl.g:1180:2: (kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}' )
            // InternalMyDsl.g:1181:3: kw= '{' (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )? kw= '}'
            {
            kw=(Token)match(input,25,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRBlockAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalMyDsl.g:1186:3: (this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_IDENT && LA21_0<=RULE_INT)||(LA21_0>=RULE_STRING && LA21_0<=RULE_REAL)||LA21_0==25||LA21_0==29||LA21_0==33||LA21_0==38||LA21_0==40||(LA21_0>=46 && LA21_0<=47)||LA21_0==50||(LA21_0>=72 && LA21_0<=76)||(LA21_0>=78 && LA21_0<=83)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:1187:4: this_rStatement_1= rulerStatement (this_rStatement_2= rulerStatement )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRBlockAccess().getRStatementParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_29);
                    this_rStatement_1=rulerStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_rStatement_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyDsl.g:1197:4: (this_rStatement_2= rulerStatement )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=RULE_IDENT && LA20_0<=RULE_INT)||(LA20_0>=RULE_STRING && LA20_0<=RULE_REAL)||LA20_0==25||LA20_0==29||LA20_0==33||LA20_0==38||LA20_0==40||(LA20_0>=46 && LA20_0<=47)||LA20_0==50||(LA20_0>=72 && LA20_0<=76)||(LA20_0>=78 && LA20_0<=83)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalMyDsl.g:1198:5: this_rStatement_2= rulerStatement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getRBlockAccess().getRStatementParserRuleCall_1_1());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_29);
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
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:1219:1: entryRulerIf returns [String current=null] : iv_rulerIf= rulerIf EOF ;
    public final String entryRulerIf() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerIf = null;


        try {
            // InternalMyDsl.g:1219:43: (iv_rulerIf= rulerIf EOF )
            // InternalMyDsl.g:1220:2: iv_rulerIf= rulerIf EOF
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
    // InternalMyDsl.g:1226:1: rulerIf returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )? ) ;
    public final AntlrDatatypeRuleToken rulerIf() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_2 = null;

        AntlrDatatypeRuleToken this_rBlock_4 = null;

        AntlrDatatypeRuleToken this_rBlock_6 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1232:2: ( (kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )? ) )
            // InternalMyDsl.g:1233:2: (kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )? )
            {
            // InternalMyDsl.g:1233:2: (kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )? )
            // InternalMyDsl.g:1234:3: kw= 'if' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock (kw= 'else' this_rBlock_6= rulerBlock )?
            {
            kw=(Token)match(input,38,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRIfAccess().getIfKeyword_0());
              		
            }
            kw=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRIfAccess().getLeftParenthesisKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRIfAccess().getExpressionParserRuleCall_2());
              		
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
            kw=(Token)match(input,30,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRIfAccess().getRightParenthesisKeyword_3());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRIfAccess().getRBlockParserRuleCall_4());
              		
            }
            pushFollow(FOLLOW_30);
            this_rBlock_4=rulerBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_rBlock_4);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyDsl.g:1269:3: (kw= 'else' this_rBlock_6= rulerBlock )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==39) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:1270:4: kw= 'else' this_rBlock_6= rulerBlock
                    {
                    kw=(Token)match(input,39,FOLLOW_15); if (state.failed) return current;
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
    // InternalMyDsl.g:1290:1: entryRulerWhile returns [String current=null] : iv_rulerWhile= rulerWhile EOF ;
    public final String entryRulerWhile() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerWhile = null;


        try {
            // InternalMyDsl.g:1290:46: (iv_rulerWhile= rulerWhile EOF )
            // InternalMyDsl.g:1291:2: iv_rulerWhile= rulerWhile EOF
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
    // InternalMyDsl.g:1297:1: rulerWhile returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock ) ;
    public final AntlrDatatypeRuleToken rulerWhile() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_2 = null;

        AntlrDatatypeRuleToken this_rBlock_4 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1303:2: ( (kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock ) )
            // InternalMyDsl.g:1304:2: (kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock )
            {
            // InternalMyDsl.g:1304:2: (kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock )
            // InternalMyDsl.g:1305:3: kw= 'while' kw= '(' this_expression_2= ruleexpression kw= ')' this_rBlock_4= rulerBlock
            {
            kw=(Token)match(input,40,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRWhileAccess().getWhileKeyword_0());
              		
            }
            kw=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRWhileAccess().getLeftParenthesisKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRWhileAccess().getExpressionParserRuleCall_2());
              		
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
            kw=(Token)match(input,30,FOLLOW_15); if (state.failed) return current;
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
    // InternalMyDsl.g:1344:1: entryRulerExpression returns [String current=null] : iv_rulerExpression= rulerExpression EOF ;
    public final String entryRulerExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerExpression = null;


        try {
            // InternalMyDsl.g:1344:51: (iv_rulerExpression= rulerExpression EOF )
            // InternalMyDsl.g:1345:2: iv_rulerExpression= rulerExpression EOF
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
    // InternalMyDsl.g:1351:1: rulerExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_expression_0= ruleexpression kw= ';' ) ;
    public final AntlrDatatypeRuleToken rulerExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1357:2: ( (this_expression_0= ruleexpression kw= ';' ) )
            // InternalMyDsl.g:1358:2: (this_expression_0= ruleexpression kw= ';' )
            {
            // InternalMyDsl.g:1358:2: (this_expression_0= ruleexpression kw= ';' )
            // InternalMyDsl.g:1359:3: this_expression_0= ruleexpression kw= ';'
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRExpressionAccess().getExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_4);
            this_expression_0=ruleexpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_expression_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:1378:1: entryRuleexpression returns [String current=null] : iv_ruleexpression= ruleexpression EOF ;
    public final String entryRuleexpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleexpression = null;


        try {
            // InternalMyDsl.g:1378:50: (iv_ruleexpression= ruleexpression EOF )
            // InternalMyDsl.g:1379:2: iv_ruleexpression= ruleexpression EOF
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
    // InternalMyDsl.g:1385:1: ruleexpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )? ) ;
    public final AntlrDatatypeRuleToken ruleexpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_nonLeftRecExpression_0 = null;

        AntlrDatatypeRuleToken this_recExpression_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1391:2: ( (this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )? ) )
            // InternalMyDsl.g:1392:2: (this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )? )
            {
            // InternalMyDsl.g:1392:2: (this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )? )
            // InternalMyDsl.g:1393:3: this_nonLeftRecExpression_0= rulenonLeftRecExpression (this_recExpression_1= rulerecExpression )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExpressionAccess().getNonLeftRecExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_nonLeftRecExpression_0=rulenonLeftRecExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_nonLeftRecExpression_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMyDsl.g:1403:3: (this_recExpression_1= rulerecExpression )?
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:1404:4: this_recExpression_1= rulerecExpression
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
    // InternalMyDsl.g:1419:1: entryRulerecExpression returns [String current=null] : iv_rulerecExpression= rulerecExpression EOF ;
    public final String entryRulerecExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerecExpression = null;


        try {
            // InternalMyDsl.g:1419:53: (iv_rulerecExpression= rulerecExpression EOF )
            // InternalMyDsl.g:1420:2: iv_rulerecExpression= rulerecExpression EOF
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
    // InternalMyDsl.g:1426:1: rulerecExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )? ) ;
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
            // InternalMyDsl.g:1432:2: ( ( (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )? ) )
            // InternalMyDsl.g:1433:2: ( (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )? )
            {
            // InternalMyDsl.g:1433:2: ( (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )? )
            // InternalMyDsl.g:1434:3: (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) ) (this_recExpression_15= rulerecExpression )?
            {
            // InternalMyDsl.g:1434:3: (this_navigationSegment_0= rulenavigationSegment | (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression ) | (this_addOp_3= ruleaddOp this_expression_4= ruleexpression ) | (this_compOp_5= rulecompOp this_expression_6= ruleexpression ) | (kw= 'and' this_expression_8= ruleexpression ) | (kw= 'or' this_expression_10= ruleexpression ) | (kw= 'xor' this_expression_12= ruleexpression ) | (kw= 'implies' this_expression_14= ruleexpression ) )
            int alt24=8;
            switch ( input.LA(1) ) {
            case 20:
            case 45:
                {
                alt24=1;
                }
                break;
            case RULE_MULTOP:
                {
                alt24=2;
                }
                break;
            case 47:
            case 53:
                {
                alt24=3;
                }
                break;
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
                {
                alt24=4;
                }
                break;
            case 41:
                {
                alt24=5;
                }
                break;
            case 42:
                {
                alt24=6;
                }
                break;
            case 43:
                {
                alt24=7;
                }
                break;
            case 44:
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
                    // InternalMyDsl.g:1435:4: this_navigationSegment_0= rulenavigationSegment
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRecExpressionAccess().getNavigationSegmentParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_31);
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
                    // InternalMyDsl.g:1446:4: (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression )
                    {
                    // InternalMyDsl.g:1446:4: (this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression )
                    // InternalMyDsl.g:1447:5: this_MultOp_1= RULE_MULTOP this_expression_2= ruleexpression
                    {
                    this_MultOp_1=(Token)match(input,RULE_MULTOP,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(this_MultOp_1);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_MultOp_1, grammarAccess.getRecExpressionAccess().getMultOpTerminalRuleCall_0_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_1_1());
                      				
                    }
                    pushFollow(FOLLOW_31);
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
                    // InternalMyDsl.g:1466:4: (this_addOp_3= ruleaddOp this_expression_4= ruleexpression )
                    {
                    // InternalMyDsl.g:1466:4: (this_addOp_3= ruleaddOp this_expression_4= ruleexpression )
                    // InternalMyDsl.g:1467:5: this_addOp_3= ruleaddOp this_expression_4= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getAddOpParserRuleCall_0_2_0());
                      				
                    }
                    pushFollow(FOLLOW_22);
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
                    pushFollow(FOLLOW_31);
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
                    // InternalMyDsl.g:1489:4: (this_compOp_5= rulecompOp this_expression_6= ruleexpression )
                    {
                    // InternalMyDsl.g:1489:4: (this_compOp_5= rulecompOp this_expression_6= ruleexpression )
                    // InternalMyDsl.g:1490:5: this_compOp_5= rulecompOp this_expression_6= ruleexpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getCompOpParserRuleCall_0_3_0());
                      				
                    }
                    pushFollow(FOLLOW_22);
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
                    pushFollow(FOLLOW_31);
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
                    // InternalMyDsl.g:1512:4: (kw= 'and' this_expression_8= ruleexpression )
                    {
                    // InternalMyDsl.g:1512:4: (kw= 'and' this_expression_8= ruleexpression )
                    // InternalMyDsl.g:1513:5: kw= 'and' this_expression_8= ruleexpression
                    {
                    kw=(Token)match(input,41,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getRecExpressionAccess().getAndKeyword_0_4_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_4_1());
                      				
                    }
                    pushFollow(FOLLOW_31);
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
                    // InternalMyDsl.g:1530:4: (kw= 'or' this_expression_10= ruleexpression )
                    {
                    // InternalMyDsl.g:1530:4: (kw= 'or' this_expression_10= ruleexpression )
                    // InternalMyDsl.g:1531:5: kw= 'or' this_expression_10= ruleexpression
                    {
                    kw=(Token)match(input,42,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getRecExpressionAccess().getOrKeyword_0_5_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_5_1());
                      				
                    }
                    pushFollow(FOLLOW_31);
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
                    // InternalMyDsl.g:1548:4: (kw= 'xor' this_expression_12= ruleexpression )
                    {
                    // InternalMyDsl.g:1548:4: (kw= 'xor' this_expression_12= ruleexpression )
                    // InternalMyDsl.g:1549:5: kw= 'xor' this_expression_12= ruleexpression
                    {
                    kw=(Token)match(input,43,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getRecExpressionAccess().getXorKeyword_0_6_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_6_1());
                      				
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

                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:1566:4: (kw= 'implies' this_expression_14= ruleexpression )
                    {
                    // InternalMyDsl.g:1566:4: (kw= 'implies' this_expression_14= ruleexpression )
                    // InternalMyDsl.g:1567:5: kw= 'implies' this_expression_14= ruleexpression
                    {
                    kw=(Token)match(input,44,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current.merge(kw);
                      					newLeafNode(kw, grammarAccess.getRecExpressionAccess().getImpliesKeyword_0_7_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_7_1());
                      				
                    }
                    pushFollow(FOLLOW_31);
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

            // InternalMyDsl.g:1584:3: (this_recExpression_15= rulerecExpression )?
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:1585:4: this_recExpression_15= rulerecExpression
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
    // InternalMyDsl.g:1600:1: entryRulenavigationSegment returns [String current=null] : iv_rulenavigationSegment= rulenavigationSegment EOF ;
    public final String entryRulenavigationSegment() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulenavigationSegment = null;


        try {
            // InternalMyDsl.g:1600:57: (iv_rulenavigationSegment= rulenavigationSegment EOF )
            // InternalMyDsl.g:1601:2: iv_rulenavigationSegment= rulenavigationSegment EOF
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
    // InternalMyDsl.g:1607:1: rulenavigationSegment returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '.' this_Ident_1= RULE_IDENT ) | (kw= '.' this_callExp_3= rulecallExp ) | (kw= '->' this_callExp_5= rulecallExp ) ) ;
    public final AntlrDatatypeRuleToken rulenavigationSegment() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_Ident_1=null;
        AntlrDatatypeRuleToken this_callExp_3 = null;

        AntlrDatatypeRuleToken this_callExp_5 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1613:2: ( ( (kw= '.' this_Ident_1= RULE_IDENT ) | (kw= '.' this_callExp_3= rulecallExp ) | (kw= '->' this_callExp_5= rulecallExp ) ) )
            // InternalMyDsl.g:1614:2: ( (kw= '.' this_Ident_1= RULE_IDENT ) | (kw= '.' this_callExp_3= rulecallExp ) | (kw= '->' this_callExp_5= rulecallExp ) )
            {
            // InternalMyDsl.g:1614:2: ( (kw= '.' this_Ident_1= RULE_IDENT ) | (kw= '.' this_callExp_3= rulecallExp ) | (kw= '->' this_callExp_5= rulecallExp ) )
            int alt26=3;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==20) ) {
                int LA26_1 = input.LA(2);

                if ( ((LA26_1>=61 && LA26_1<=70)) ) {
                    alt26=2;
                }
                else if ( (LA26_1==RULE_IDENT) ) {
                    int LA26_4 = input.LA(3);

                    if ( (LA26_4==29) ) {
                        alt26=2;
                    }
                    else if ( (LA26_4==EOF||LA26_4==RULE_MULTOP||LA26_4==16||LA26_4==20||LA26_4==24||LA26_4==26||LA26_4==30||LA26_4==32||LA26_4==34||LA26_4==39||(LA26_4>=41 && LA26_4<=45)||(LA26_4>=47 && LA26_4<=49)||(LA26_4>=52 && LA26_4<=60)) ) {
                        alt26=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA26_0==45) ) {
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
                    // InternalMyDsl.g:1615:3: (kw= '.' this_Ident_1= RULE_IDENT )
                    {
                    // InternalMyDsl.g:1615:3: (kw= '.' this_Ident_1= RULE_IDENT )
                    // InternalMyDsl.g:1616:4: kw= '.' this_Ident_1= RULE_IDENT
                    {
                    kw=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
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
                    // InternalMyDsl.g:1630:3: (kw= '.' this_callExp_3= rulecallExp )
                    {
                    // InternalMyDsl.g:1630:3: (kw= '.' this_callExp_3= rulecallExp )
                    // InternalMyDsl.g:1631:4: kw= '.' this_callExp_3= rulecallExp
                    {
                    kw=(Token)match(input,20,FOLLOW_32); if (state.failed) return current;
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
                    // InternalMyDsl.g:1648:3: (kw= '->' this_callExp_5= rulecallExp )
                    {
                    // InternalMyDsl.g:1648:3: (kw= '->' this_callExp_5= rulecallExp )
                    // InternalMyDsl.g:1649:4: kw= '->' this_callExp_5= rulecallExp
                    {
                    kw=(Token)match(input,45,FOLLOW_32); if (state.failed) return current;
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
    // InternalMyDsl.g:1669:1: entryRulenonLeftRecExpression returns [String current=null] : iv_rulenonLeftRecExpression= rulenonLeftRecExpression EOF ;
    public final String entryRulenonLeftRecExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulenonLeftRecExpression = null;


        try {
            // InternalMyDsl.g:1669:60: (iv_rulenonLeftRecExpression= rulenonLeftRecExpression EOF )
            // InternalMyDsl.g:1670:2: iv_rulenonLeftRecExpression= rulenonLeftRecExpression EOF
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
    // InternalMyDsl.g:1676:1: rulenonLeftRecExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'not' this_expression_1= ruleexpression ) | (kw= '-' this_expression_3= ruleexpression ) | this_Ident_4= RULE_IDENT | this_literal_5= ruleliteral | (kw= '(' this_expression_7= ruleexpression kw= ')' ) | (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' ) | (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression ) ) ;
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
            // InternalMyDsl.g:1682:2: ( ( (kw= 'not' this_expression_1= ruleexpression ) | (kw= '-' this_expression_3= ruleexpression ) | this_Ident_4= RULE_IDENT | this_literal_5= ruleliteral | (kw= '(' this_expression_7= ruleexpression kw= ')' ) | (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' ) | (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression ) ) )
            // InternalMyDsl.g:1683:2: ( (kw= 'not' this_expression_1= ruleexpression ) | (kw= '-' this_expression_3= ruleexpression ) | this_Ident_4= RULE_IDENT | this_literal_5= ruleliteral | (kw= '(' this_expression_7= ruleexpression kw= ')' ) | (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' ) | (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression ) )
            {
            // InternalMyDsl.g:1683:2: ( (kw= 'not' this_expression_1= ruleexpression ) | (kw= '-' this_expression_3= ruleexpression ) | this_Ident_4= RULE_IDENT | this_literal_5= ruleliteral | (kw= '(' this_expression_7= ruleexpression kw= ')' ) | (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' ) | (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression ) )
            int alt28=7;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt28=1;
                }
                break;
            case 47:
                {
                alt28=2;
                }
                break;
            case RULE_IDENT:
                {
                int LA28_3 = input.LA(2);

                if ( (LA28_3==EOF||LA28_3==RULE_MULTOP||LA28_3==16||LA28_3==20||LA28_3==24||LA28_3==26||LA28_3==30||LA28_3==32||LA28_3==34||LA28_3==39||(LA28_3>=41 && LA28_3<=45)||(LA28_3>=47 && LA28_3<=49)||(LA28_3>=52 && LA28_3<=60)) ) {
                    alt28=3;
                }
                else if ( (LA28_3==51||LA28_3==77) ) {
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
            case 25:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
                {
                alt28=4;
                }
                break;
            case 29:
                {
                alt28=5;
                }
                break;
            case 38:
                {
                alt28=6;
                }
                break;
            case 50:
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
                    // InternalMyDsl.g:1684:3: (kw= 'not' this_expression_1= ruleexpression )
                    {
                    // InternalMyDsl.g:1684:3: (kw= 'not' this_expression_1= ruleexpression )
                    // InternalMyDsl.g:1685:4: kw= 'not' this_expression_1= ruleexpression
                    {
                    kw=(Token)match(input,46,FOLLOW_22); if (state.failed) return current;
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
                    // InternalMyDsl.g:1702:3: (kw= '-' this_expression_3= ruleexpression )
                    {
                    // InternalMyDsl.g:1702:3: (kw= '-' this_expression_3= ruleexpression )
                    // InternalMyDsl.g:1703:4: kw= '-' this_expression_3= ruleexpression
                    {
                    kw=(Token)match(input,47,FOLLOW_22); if (state.failed) return current;
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
                    // InternalMyDsl.g:1720:3: this_Ident_4= RULE_IDENT
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
                    // InternalMyDsl.g:1728:3: this_literal_5= ruleliteral
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
                    // InternalMyDsl.g:1739:3: (kw= '(' this_expression_7= ruleexpression kw= ')' )
                    {
                    // InternalMyDsl.g:1739:3: (kw= '(' this_expression_7= ruleexpression kw= ')' )
                    // InternalMyDsl.g:1740:4: kw= '(' this_expression_7= ruleexpression kw= ')'
                    {
                    kw=(Token)match(input,29,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_4_1());
                      			
                    }
                    pushFollow(FOLLOW_19);
                    this_expression_7=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_7);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getRightParenthesisKeyword_4_2());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:1762:3: (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' )
                    {
                    // InternalMyDsl.g:1762:3: (kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif' )
                    // InternalMyDsl.g:1763:4: kw= 'if' this_expression_10= ruleexpression kw= 'then' this_expression_12= ruleexpression kw= 'else' this_expression_14= ruleexpression kw= 'endif'
                    {
                    kw=(Token)match(input,38,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getIfKeyword_5_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_1());
                      			
                    }
                    pushFollow(FOLLOW_33);
                    this_expression_10=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_10);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,48,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getThenKeyword_5_2());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_3());
                      			
                    }
                    pushFollow(FOLLOW_34);
                    this_expression_12=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_12);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,39,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getElseKeyword_5_4());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_5());
                      			
                    }
                    pushFollow(FOLLOW_35);
                    this_expression_14=ruleexpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expression_14);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getEndifKeyword_5_6());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:1815:3: (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression )
                    {
                    // InternalMyDsl.g:1815:3: (kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression )
                    // InternalMyDsl.g:1816:4: kw= 'let' this_binding_17= rulebinding (kw= ',' this_binding_19= rulebinding )* kw= 'in' this_expression_21= ruleexpression
                    {
                    kw=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getLetKeyword_6_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getBindingParserRuleCall_6_1());
                      			
                    }
                    pushFollow(FOLLOW_36);
                    this_binding_17=rulebinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_binding_17);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyDsl.g:1831:4: (kw= ',' this_binding_19= rulebinding )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==24) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalMyDsl.g:1832:5: kw= ',' this_binding_19= rulebinding
                    	    {
                    	    kw=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(kw);
                    	      					newLeafNode(kw, grammarAccess.getNonLeftRecExpressionAccess().getCommaKeyword_6_2_0());
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getNonLeftRecExpressionAccess().getBindingParserRuleCall_6_2_1());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_36);
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
                    	    break loop27;
                        }
                    } while (true);

                    kw=(Token)match(input,34,FOLLOW_22); if (state.failed) return current;
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
    // InternalMyDsl.g:1868:1: entryRulebinding returns [String current=null] : iv_rulebinding= rulebinding EOF ;
    public final String entryRulebinding() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulebinding = null;


        try {
            // InternalMyDsl.g:1868:47: (iv_rulebinding= rulebinding EOF )
            // InternalMyDsl.g:1869:2: iv_rulebinding= rulebinding EOF
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
    // InternalMyDsl.g:1875:1: rulebinding returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression ) ;
    public final AntlrDatatypeRuleToken rulebinding() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_typeLiteral_2 = null;

        AntlrDatatypeRuleToken this_expression_4 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1881:2: ( (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression ) )
            // InternalMyDsl.g:1882:2: (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression )
            {
            // InternalMyDsl.g:1882:2: (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression )
            // InternalMyDsl.g:1883:3: this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '=' this_expression_4= ruleexpression
            {
            this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_0, grammarAccess.getBindingAccess().getIdentTerminalRuleCall_0());
              		
            }
            // InternalMyDsl.g:1890:3: (kw= ':' this_typeLiteral_2= ruletypeLiteral )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==51) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:1891:4: kw= ':' this_typeLiteral_2= ruletypeLiteral
                    {
                    kw=(Token)match(input,51,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getBindingAccess().getColonKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBindingAccess().getTypeLiteralParserRuleCall_1_1());
                      			
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

            kw=(Token)match(input,52,FOLLOW_22); if (state.failed) return current;
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
    // InternalMyDsl.g:1926:1: entryRuleaddOp returns [String current=null] : iv_ruleaddOp= ruleaddOp EOF ;
    public final String entryRuleaddOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleaddOp = null;


        try {
            // InternalMyDsl.g:1926:45: (iv_ruleaddOp= ruleaddOp EOF )
            // InternalMyDsl.g:1927:2: iv_ruleaddOp= ruleaddOp EOF
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
    // InternalMyDsl.g:1933:1: ruleaddOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleaddOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1939:2: ( (kw= '+' | kw= '-' ) )
            // InternalMyDsl.g:1940:2: (kw= '+' | kw= '-' )
            {
            // InternalMyDsl.g:1940:2: (kw= '+' | kw= '-' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==53) ) {
                alt30=1;
            }
            else if ( (LA30_0==47) ) {
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
                    // InternalMyDsl.g:1941:3: kw= '+'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAddOpAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1947:3: kw= '-'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:1956:1: entryRulecompOp returns [String current=null] : iv_rulecompOp= rulecompOp EOF ;
    public final String entryRulecompOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulecompOp = null;


        try {
            // InternalMyDsl.g:1956:46: (iv_rulecompOp= rulecompOp EOF )
            // InternalMyDsl.g:1957:2: iv_rulecompOp= rulecompOp EOF
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
    // InternalMyDsl.g:1963:1: rulecompOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<=' | kw= '>=' | kw= '!=' | kw= '<>' | kw= '=' | kw= '==' | kw= '<' | kw= '>' ) ;
    public final AntlrDatatypeRuleToken rulecompOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1969:2: ( (kw= '<=' | kw= '>=' | kw= '!=' | kw= '<>' | kw= '=' | kw= '==' | kw= '<' | kw= '>' ) )
            // InternalMyDsl.g:1970:2: (kw= '<=' | kw= '>=' | kw= '!=' | kw= '<>' | kw= '=' | kw= '==' | kw= '<' | kw= '>' )
            {
            // InternalMyDsl.g:1970:2: (kw= '<=' | kw= '>=' | kw= '!=' | kw= '<>' | kw= '=' | kw= '==' | kw= '<' | kw= '>' )
            int alt31=8;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt31=1;
                }
                break;
            case 55:
                {
                alt31=2;
                }
                break;
            case 56:
                {
                alt31=3;
                }
                break;
            case 57:
                {
                alt31=4;
                }
                break;
            case 52:
                {
                alt31=5;
                }
                break;
            case 58:
                {
                alt31=6;
                }
                break;
            case 59:
                {
                alt31=7;
                }
                break;
            case 60:
                {
                alt31=8;
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
                    // InternalMyDsl.g:1971:3: kw= '<='
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getLessThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1977:3: kw= '>='
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getGreaterThanSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1983:3: kw= '!='
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getExclamationMarkEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1989:3: kw= '<>'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getLessThanSignGreaterThanSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:1995:3: kw= '='
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2001:3: kw= '=='
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getEqualsSignEqualsSignKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:2007:3: kw= '<'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCompOpAccess().getLessThanSignKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:2013:3: kw= '>'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:2022:1: entryRulecallExp returns [String current=null] : iv_rulecallExp= rulecallExp EOF ;
    public final String entryRulecallExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulecallExp = null;


        try {
            // InternalMyDsl.g:2022:47: (iv_rulecallExp= rulecallExp EOF )
            // InternalMyDsl.g:2023:2: iv_rulecallExp= rulecallExp EOF
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
    // InternalMyDsl.g:2029:1: rulecallExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' ) | (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' ) ) ;
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
            // InternalMyDsl.g:2035:2: ( ( (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' ) | (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' ) ) )
            // InternalMyDsl.g:2036:2: ( (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' ) | (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' ) )
            {
            // InternalMyDsl.g:2036:2: ( (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' ) | (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=61 && LA32_0<=70)) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_IDENT) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:2037:3: (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' )
                    {
                    // InternalMyDsl.g:2037:3: (this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')' )
                    // InternalMyDsl.g:2038:4: this_collectionIterator_0= rulecollectionIterator kw= '(' this_variableDefinition_2= rulevariableDefinition this_lambdaExpression_3= rulelambdaExpression kw= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getCollectionIteratorParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_17);
                    this_collectionIterator_0=rulecollectionIterator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_collectionIterator_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,29,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getVariableDefinitionParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_22);
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
                    pushFollow(FOLLOW_19);
                    this_lambdaExpression_3=rulelambdaExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_lambdaExpression_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getCallExpAccess().getRightParenthesisKeyword_0_4());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2080:3: (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' )
                    {
                    // InternalMyDsl.g:2080:3: (this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')' )
                    // InternalMyDsl.g:2081:4: this_Ident_5= RULE_IDENT kw= '(' this_expressionSequence_7= ruleexpressionSequence kw= ')'
                    {
                    this_Ident_5=(Token)match(input,RULE_IDENT,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_5);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_5, grammarAccess.getCallExpAccess().getIdentTerminalRuleCall_1_0());
                      			
                    }
                    kw=(Token)match(input,29,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_1_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCallExpAccess().getExpressionSequenceParserRuleCall_1_2());
                      			
                    }
                    pushFollow(FOLLOW_19);
                    this_expressionSequence_7=ruleexpressionSequence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expressionSequence_7);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:2113:1: entryRulelambdaExpression returns [String current=null] : iv_rulelambdaExpression= rulelambdaExpression EOF ;
    public final String entryRulelambdaExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulelambdaExpression = null;


        try {
            // InternalMyDsl.g:2113:56: (iv_rulelambdaExpression= rulelambdaExpression EOF )
            // InternalMyDsl.g:2114:2: iv_rulelambdaExpression= rulelambdaExpression EOF
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
    // InternalMyDsl.g:2120:1: rulelambdaExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_expression_0= ruleexpression ;
    public final AntlrDatatypeRuleToken rulelambdaExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_expression_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2126:2: (this_expression_0= ruleexpression )
            // InternalMyDsl.g:2127:2: this_expression_0= ruleexpression
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
    // InternalMyDsl.g:2140:1: entryRulecollectionIterator returns [String current=null] : iv_rulecollectionIterator= rulecollectionIterator EOF ;
    public final String entryRulecollectionIterator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulecollectionIterator = null;


        try {
            // InternalMyDsl.g:2140:58: (iv_rulecollectionIterator= rulecollectionIterator EOF )
            // InternalMyDsl.g:2141:2: iv_rulecollectionIterator= rulecollectionIterator EOF
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
    // InternalMyDsl.g:2147:1: rulecollectionIterator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' ) ;
    public final AntlrDatatypeRuleToken rulecollectionIterator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2153:2: ( (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' ) )
            // InternalMyDsl.g:2154:2: (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' )
            {
            // InternalMyDsl.g:2154:2: (kw= 'select' | kw= 'reject' | kw= 'collect' | kw= 'any' | kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'one' | kw= 'sortedBy' | kw= 'closure' )
            int alt33=10;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt33=1;
                }
                break;
            case 62:
                {
                alt33=2;
                }
                break;
            case 63:
                {
                alt33=3;
                }
                break;
            case 64:
                {
                alt33=4;
                }
                break;
            case 65:
                {
                alt33=5;
                }
                break;
            case 66:
                {
                alt33=6;
                }
                break;
            case 67:
                {
                alt33=7;
                }
                break;
            case 68:
                {
                alt33=8;
                }
                break;
            case 69:
                {
                alt33=9;
                }
                break;
            case 70:
                {
                alt33=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalMyDsl.g:2155:3: kw= 'select'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getSelectKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2161:3: kw= 'reject'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getRejectKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2167:3: kw= 'collect'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getCollectKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2173:3: kw= 'any'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getAnyKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2179:3: kw= 'exists'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getExistsKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2185:3: kw= 'forAll'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getForAllKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:2191:3: kw= 'isUnique'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getIsUniqueKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:2197:3: kw= 'one'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getOneKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:2203:3: kw= 'sortedBy'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getCollectionIteratorAccess().getSortedByKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:2209:3: kw= 'closure'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:2218:1: entryRuleexpressionSequence returns [String current=null] : iv_ruleexpressionSequence= ruleexpressionSequence EOF ;
    public final String entryRuleexpressionSequence() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleexpressionSequence = null;


        try {
            // InternalMyDsl.g:2218:58: (iv_ruleexpressionSequence= ruleexpressionSequence EOF )
            // InternalMyDsl.g:2219:2: iv_ruleexpressionSequence= ruleexpressionSequence EOF
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
    // InternalMyDsl.g:2225:1: ruleexpressionSequence returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )* )? ;
    public final AntlrDatatypeRuleToken ruleexpressionSequence() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_expression_0 = null;

        AntlrDatatypeRuleToken this_expression_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2231:2: ( (this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )* )? )
            // InternalMyDsl.g:2232:2: (this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )* )?
            {
            // InternalMyDsl.g:2232:2: (this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_IDENT && LA35_0<=RULE_INT)||(LA35_0>=RULE_STRING && LA35_0<=RULE_REAL)||LA35_0==25||LA35_0==29||LA35_0==38||(LA35_0>=46 && LA35_0<=47)||LA35_0==50||(LA35_0>=72 && LA35_0<=76)||(LA35_0>=78 && LA35_0<=83)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMyDsl.g:2233:3: this_expression_0= ruleexpression (kw= ',' this_expression_2= ruleexpression )*
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionSequenceAccess().getExpressionParserRuleCall_0());
                      		
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
                    // InternalMyDsl.g:2243:3: (kw= ',' this_expression_2= ruleexpression )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==24) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalMyDsl.g:2244:4: kw= ',' this_expression_2= ruleexpression
                    	    {
                    	    kw=(Token)match(input,24,FOLLOW_22); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      				current.merge(kw);
                    	      				newLeafNode(kw, grammarAccess.getExpressionSequenceAccess().getCommaKeyword_1_0());
                    	      			
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      				newCompositeNode(grammarAccess.getExpressionSequenceAccess().getExpressionParserRuleCall_1_1());
                    	      			
                    	    }
                    	    pushFollow(FOLLOW_20);
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
                    	    break loop34;
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
    // InternalMyDsl.g:2264:1: entryRulevariableDefinition returns [String current=null] : iv_rulevariableDefinition= rulevariableDefinition EOF ;
    public final String entryRulevariableDefinition() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulevariableDefinition = null;


        try {
            // InternalMyDsl.g:2264:58: (iv_rulevariableDefinition= rulevariableDefinition EOF )
            // InternalMyDsl.g:2265:2: iv_rulevariableDefinition= rulevariableDefinition EOF
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
    // InternalMyDsl.g:2271:1: rulevariableDefinition returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|' ) ;
    public final AntlrDatatypeRuleToken rulevariableDefinition() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_typeLiteral_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2277:2: ( (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|' ) )
            // InternalMyDsl.g:2278:2: (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|' )
            {
            // InternalMyDsl.g:2278:2: (this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|' )
            // InternalMyDsl.g:2279:3: this_Ident_0= RULE_IDENT (kw= ':' this_typeLiteral_2= ruletypeLiteral )? kw= '|'
            {
            this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_0, grammarAccess.getVariableDefinitionAccess().getIdentTerminalRuleCall_0());
              		
            }
            // InternalMyDsl.g:2286:3: (kw= ':' this_typeLiteral_2= ruletypeLiteral )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==51) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMyDsl.g:2287:4: kw= ':' this_typeLiteral_2= ruletypeLiteral
                    {
                    kw=(Token)match(input,51,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getVariableDefinitionAccess().getColonKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getVariableDefinitionAccess().getTypeLiteralParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_42);
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

            kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:2312:1: entryRuleliteral returns [String current=null] : iv_ruleliteral= ruleliteral EOF ;
    public final String entryRuleliteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleliteral = null;


        try {
            // InternalMyDsl.g:2312:47: (iv_ruleliteral= ruleliteral EOF )
            // InternalMyDsl.g:2313:2: iv_ruleliteral= ruleliteral EOF
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
    // InternalMyDsl.g:2319:1: ruleliteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral ) ;
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
            // InternalMyDsl.g:2325:2: ( (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral ) )
            // InternalMyDsl.g:2326:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral )
            {
            // InternalMyDsl.g:2326:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral )
            int alt37=11;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // InternalMyDsl.g:2327:3: this_STRING_0= RULE_STRING
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
                    // InternalMyDsl.g:2335:3: this_INT_1= RULE_INT
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
                    // InternalMyDsl.g:2343:3: this_Real_2= RULE_REAL
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
                    // InternalMyDsl.g:2351:3: kw= 'true'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLiteralAccess().getTrueKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2357:3: kw= 'false'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLiteralAccess().getFalseKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2363:3: kw= 'null'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLiteralAccess().getNullKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:2369:3: (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' )
                    {
                    // InternalMyDsl.g:2369:3: (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' )
                    // InternalMyDsl.g:2370:4: kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}'
                    {
                    kw=(Token)match(input,75,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getSequenceKeyword_6_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_6_1());
                      			
                    }
                    pushFollow(FOLLOW_44);
                    this_expressionSequence_7=ruleexpressionSequence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expressionSequence_7);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_6_2());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:2392:3: (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' )
                    {
                    // InternalMyDsl.g:2392:3: (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' )
                    // InternalMyDsl.g:2393:4: kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}'
                    {
                    kw=(Token)match(input,76,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getOrderedSetKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_44);
                    this_expressionSequence_10=ruleexpressionSequence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_expressionSequence_10);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_7_2());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:2415:3: (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT )
                    {
                    // InternalMyDsl.g:2415:3: (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT )
                    // InternalMyDsl.g:2416:4: this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT
                    {
                    this_Ident_12=(Token)match(input,RULE_IDENT,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_12);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_12, grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_0());
                      			
                    }
                    kw=(Token)match(input,77,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getColonColonKeyword_8_1());
                      			
                    }
                    this_Ident_14=(Token)match(input,RULE_IDENT,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_14);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_14, grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_2());
                      			
                    }
                    kw=(Token)match(input,77,FOLLOW_3); if (state.failed) return current;
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
                    // InternalMyDsl.g:2449:3: (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' )
                    {
                    // InternalMyDsl.g:2449:3: (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' )
                    // InternalMyDsl.g:2450:4: this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':'
                    {
                    this_Ident_17=(Token)match(input,RULE_IDENT,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_17);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_17, grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_9_0());
                      			
                    }
                    kw=(Token)match(input,77,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getColonColonKeyword_9_1());
                      			
                    }
                    this_Ident_19=(Token)match(input,RULE_IDENT,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_19);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_19, grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_9_2());
                      			
                    }
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLiteralAccess().getColonKeyword_9_3());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:2476:3: this_typeLiteral_21= ruletypeLiteral
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
    // InternalMyDsl.g:2490:1: entryRuletypeLiteral returns [String current=null] : iv_ruletypeLiteral= ruletypeLiteral EOF ;
    public final String entryRuletypeLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruletypeLiteral = null;


        try {
            // InternalMyDsl.g:2490:51: (iv_ruletypeLiteral= ruletypeLiteral EOF )
            // InternalMyDsl.g:2491:2: iv_ruletypeLiteral= ruletypeLiteral EOF
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
    // InternalMyDsl.g:2497:1: ruletypeLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'String' | kw= 'Integer' | kw= 'Real' | kw= 'Boolean' | (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' ) | (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' ) | this_classifierTypeRule_10= ruleclassifierTypeRule | (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' ) ) ;
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
            // InternalMyDsl.g:2503:2: ( (kw= 'String' | kw= 'Integer' | kw= 'Real' | kw= 'Boolean' | (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' ) | (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' ) | this_classifierTypeRule_10= ruleclassifierTypeRule | (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' ) ) )
            // InternalMyDsl.g:2504:2: (kw= 'String' | kw= 'Integer' | kw= 'Real' | kw= 'Boolean' | (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' ) | (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' ) | this_classifierTypeRule_10= ruleclassifierTypeRule | (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' ) )
            {
            // InternalMyDsl.g:2504:2: (kw= 'String' | kw= 'Integer' | kw= 'Real' | kw= 'Boolean' | (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' ) | (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' ) | this_classifierTypeRule_10= ruleclassifierTypeRule | (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' ) )
            int alt39=8;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt39=1;
                }
                break;
            case 79:
                {
                alt39=2;
                }
                break;
            case 80:
                {
                alt39=3;
                }
                break;
            case 81:
                {
                alt39=4;
                }
                break;
            case 82:
                {
                alt39=5;
                }
                break;
            case 83:
                {
                alt39=6;
                }
                break;
            case RULE_IDENT:
                {
                alt39=7;
                }
                break;
            case 25:
                {
                alt39=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalMyDsl.g:2505:3: kw= 'String'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getStringKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2511:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getIntegerKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2517:3: kw= 'Real'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getRealKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2523:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getBooleanKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2529:3: (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' )
                    {
                    // InternalMyDsl.g:2529:3: (kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')' )
                    // InternalMyDsl.g:2530:4: kw= 'Sequence(' this_typeLiteral_5= ruletypeLiteral kw= ')'
                    {
                    kw=(Token)match(input,82,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getSequenceKeyword_4_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTypeLiteralAccess().getTypeLiteralParserRuleCall_4_1());
                      			
                    }
                    pushFollow(FOLLOW_19);
                    this_typeLiteral_5=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_typeLiteral_5);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_4_2());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2552:3: (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' )
                    {
                    // InternalMyDsl.g:2552:3: (kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')' )
                    // InternalMyDsl.g:2553:4: kw= 'OrderedSet(' this_typeLiteral_8= ruletypeLiteral kw= ')'
                    {
                    kw=(Token)match(input,83,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getOrderedSetKeyword_5_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTypeLiteralAccess().getTypeLiteralParserRuleCall_5_1());
                      			
                    }
                    pushFollow(FOLLOW_19);
                    this_typeLiteral_8=ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_typeLiteral_8);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_5_2());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:2575:3: this_classifierTypeRule_10= ruleclassifierTypeRule
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
                    // InternalMyDsl.g:2586:3: (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' )
                    {
                    // InternalMyDsl.g:2586:3: (kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}' )
                    // InternalMyDsl.g:2587:4: kw= '{' this_classifierTypeRule_12= ruleclassifierTypeRule (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )* kw= '}'
                    {
                    kw=(Token)match(input,25,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getLeftCurlyBracketKeyword_7_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_1());
                      			
                    }
                    pushFollow(FOLLOW_47);
                    this_classifierTypeRule_12=ruleclassifierTypeRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_classifierTypeRule_12);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalMyDsl.g:2602:4: (kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==71) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalMyDsl.g:2603:5: kw= '|' this_classifierTypeRule_14= ruleclassifierTypeRule
                    	    {
                    	    kw=(Token)match(input,71,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(kw);
                    	      					newLeafNode(kw, grammarAccess.getTypeLiteralAccess().getVerticalLineKeyword_7_2_0());
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_2_1());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_47);
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
                    	    break loop38;
                        }
                    } while (true);

                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
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
    // InternalMyDsl.g:2629:1: entryRuleclassifierTypeRule returns [String current=null] : iv_ruleclassifierTypeRule= ruleclassifierTypeRule EOF ;
    public final String entryRuleclassifierTypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleclassifierTypeRule = null;


        try {
            // InternalMyDsl.g:2629:58: (iv_ruleclassifierTypeRule= ruleclassifierTypeRule EOF )
            // InternalMyDsl.g:2630:2: iv_ruleclassifierTypeRule= ruleclassifierTypeRule EOF
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
    // InternalMyDsl.g:2636:1: ruleclassifierTypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT ) | (this_Ident_3= RULE_IDENT kw= ':' ) ) ;
    public final AntlrDatatypeRuleToken ruleclassifierTypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token kw=null;
        Token this_Ident_2=null;
        Token this_Ident_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2642:2: ( ( (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT ) | (this_Ident_3= RULE_IDENT kw= ':' ) ) )
            // InternalMyDsl.g:2643:2: ( (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT ) | (this_Ident_3= RULE_IDENT kw= ':' ) )
            {
            // InternalMyDsl.g:2643:2: ( (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT ) | (this_Ident_3= RULE_IDENT kw= ':' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_IDENT) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==77) ) {
                    alt40=1;
                }
                else if ( (LA40_1==51) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalMyDsl.g:2644:3: (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT )
                    {
                    // InternalMyDsl.g:2644:3: (this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT )
                    // InternalMyDsl.g:2645:4: this_Ident_0= RULE_IDENT kw= '::' this_Ident_2= RULE_IDENT
                    {
                    this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_0, grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_0_0());
                      			
                    }
                    kw=(Token)match(input,77,FOLLOW_3); if (state.failed) return current;
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
                    // InternalMyDsl.g:2666:3: (this_Ident_3= RULE_IDENT kw= ':' )
                    {
                    // InternalMyDsl.g:2666:3: (this_Ident_3= RULE_IDENT kw= ':' )
                    // InternalMyDsl.g:2667:4: this_Ident_3= RULE_IDENT kw= ':'
                    {
                    this_Ident_3=(Token)match(input,RULE_IDENT,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_Ident_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_Ident_3, grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_1_0());
                      			
                    }
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRulerQualified"
    // InternalMyDsl.g:2684:1: entryRulerQualified returns [String current=null] : iv_rulerQualified= rulerQualified EOF ;
    public final String entryRulerQualified() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulerQualified = null;


        try {
            // InternalMyDsl.g:2684:50: (iv_rulerQualified= rulerQualified EOF )
            // InternalMyDsl.g:2685:2: iv_rulerQualified= rulerQualified EOF
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
    // InternalMyDsl.g:2691:1: rulerQualified returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Ident_0= RULE_IDENT (kw= '.' this_Ident_2= RULE_IDENT )* ) ;
    public final AntlrDatatypeRuleToken rulerQualified() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_Ident_0=null;
        Token kw=null;
        Token this_Ident_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2697:2: ( (this_Ident_0= RULE_IDENT (kw= '.' this_Ident_2= RULE_IDENT )* ) )
            // InternalMyDsl.g:2698:2: (this_Ident_0= RULE_IDENT (kw= '.' this_Ident_2= RULE_IDENT )* )
            {
            // InternalMyDsl.g:2698:2: (this_Ident_0= RULE_IDENT (kw= '.' this_Ident_2= RULE_IDENT )* )
            // InternalMyDsl.g:2699:3: this_Ident_0= RULE_IDENT (kw= '.' this_Ident_2= RULE_IDENT )*
            {
            this_Ident_0=(Token)match(input,RULE_IDENT,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_Ident_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_Ident_0, grammarAccess.getRQualifiedAccess().getIdentTerminalRuleCall_0());
              		
            }
            // InternalMyDsl.g:2706:3: (kw= '.' this_Ident_2= RULE_IDENT )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==20) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalMyDsl.g:2707:4: kw= '.' this_Ident_2= RULE_IDENT
            	    {
            	    kw=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getRQualifiedAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_Ident_2=(Token)match(input,RULE_IDENT,FOLLOW_48); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_Ident_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_Ident_2, grammarAccess.getRQualifiedAccess().getIdentTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
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

    // $ANTLR start synpred17_InternalMyDsl
    public final void synpred17_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_rVarDecl_0 = null;


        // InternalMyDsl.g:866:3: (this_rVarDecl_0= rulerVarDecl )
        // InternalMyDsl.g:866:3: this_rVarDecl_0= rulerVarDecl
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
    // $ANTLR end synpred17_InternalMyDsl

    // $ANTLR start synpred18_InternalMyDsl
    public final void synpred18_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_rAssign_1 = null;


        // InternalMyDsl.g:877:3: (this_rAssign_1= rulerAssign )
        // InternalMyDsl.g:877:3: this_rAssign_1= rulerAssign
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
    // $ANTLR end synpred18_InternalMyDsl

    // $ANTLR start synpred21_InternalMyDsl
    public final void synpred21_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_rIf_4 = null;


        // InternalMyDsl.g:910:3: (this_rIf_4= rulerIf )
        // InternalMyDsl.g:910:3: this_rIf_4= rulerIf
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
    // $ANTLR end synpred21_InternalMyDsl

    // $ANTLR start synpred27_InternalMyDsl
    public final void synpred27_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_recExpression_1 = null;


        // InternalMyDsl.g:1404:4: (this_recExpression_1= rulerecExpression )
        // InternalMyDsl.g:1404:4: this_recExpression_1= rulerecExpression
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
    // $ANTLR end synpred27_InternalMyDsl

    // $ANTLR start synpred35_InternalMyDsl
    public final void synpred35_InternalMyDsl_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken this_recExpression_15 = null;


        // InternalMyDsl.g:1585:4: (this_recExpression_15= rulerecExpression )
        // InternalMyDsl.g:1585:4: this_recExpression_15= rulerecExpression
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
    // $ANTLR end synpred35_InternalMyDsl

    // Delegated rules

    public final boolean synpred21_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalMyDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalMyDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalMyDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalMyDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalMyDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalMyDsl_fragment(); // can never throw exception
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
    protected DFA37 dfa37 = new DFA37(this);
    static final String dfa_1s = "\34\uffff";
    static final String dfa_2s = "\1\4\25\0\6\uffff";
    static final String dfa_3s = "\1\123\25\0\6\uffff";
    static final String dfa_4s = "\26\uffff\1\3\1\4\1\1\1\2\1\6\1\5";
    static final String dfa_5s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\5\1\uffff\1\4\1\6\20\uffff\1\22\3\uffff\1\23\3\uffff\1\26\4\uffff\1\24\1\uffff\1\27\5\uffff\1\2\1\3\2\uffff\1\25\25\uffff\1\7\1\10\1\11\1\12\1\13\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21",
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
            return "865:2: (this_rVarDecl_0= rulerVarDecl | this_rAssign_1= rulerAssign | this_rForEach_2= rulerForEach | this_rWhile_3= rulerWhile | this_rIf_4= rulerIf | this_rExpression_5= rulerExpression )";
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
                        if ( (synpred17_InternalMyDsl()) ) {s = 24;}

                        else if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_2 = input.LA(1);

                         
                        int index17_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_3 = input.LA(1);

                         
                        int index17_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_4 = input.LA(1);

                         
                        int index17_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_5 = input.LA(1);

                         
                        int index17_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_6 = input.LA(1);

                         
                        int index17_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_7 = input.LA(1);

                         
                        int index17_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_8 = input.LA(1);

                         
                        int index17_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_9 = input.LA(1);

                         
                        int index17_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_10 = input.LA(1);

                         
                        int index17_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_11 = input.LA(1);

                         
                        int index17_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_12 = input.LA(1);

                         
                        int index17_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_13 = input.LA(1);

                         
                        int index17_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_14 = input.LA(1);

                         
                        int index17_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_15 = input.LA(1);

                         
                        int index17_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_16 = input.LA(1);

                         
                        int index17_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_17 = input.LA(1);

                         
                        int index17_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_18 = input.LA(1);

                         
                        int index17_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_19 = input.LA(1);

                         
                        int index17_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_20 = input.LA(1);

                         
                        int index17_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

                        else if ( (synpred21_InternalMyDsl()) ) {s = 27;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_21 = input.LA(1);

                         
                        int index17_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalMyDsl()) ) {s = 25;}

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
    static final String dfa_7s = "\24\uffff";
    static final String dfa_8s = "\1\22\23\uffff";
    static final String dfa_9s = "\1\6\21\0\2\uffff";
    static final String dfa_10s = "\1\74\21\0\2\uffff";
    static final String dfa_11s = "\22\uffff\1\2\1\1";
    static final String dfa_12s = "\1\uffff\1\14\1\3\1\11\1\16\1\0\1\17\1\20\1\12\1\13\1\6\1\10\1\1\1\7\1\4\1\15\1\5\1\2\2\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\11\uffff\1\22\3\uffff\1\1\3\uffff\1\22\1\uffff\1\22\3\uffff\1\22\1\uffff\1\22\1\uffff\1\22\4\uffff\1\22\1\uffff\1\16\1\17\1\20\1\21\1\2\1\uffff\1\5\2\22\2\uffff\1\12\1\4\1\6\1\7\1\10\1\11\1\13\1\14\1\15",
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
            return "1403:3: (this_recExpression_1= rulerecExpression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_5 = input.LA(1);

                         
                        int index23_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_12 = input.LA(1);

                         
                        int index23_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_17 = input.LA(1);

                         
                        int index23_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_17);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_2 = input.LA(1);

                         
                        int index23_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_14 = input.LA(1);

                         
                        int index23_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_14);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_16 = input.LA(1);

                         
                        int index23_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_10 = input.LA(1);

                         
                        int index23_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_13 = input.LA(1);

                         
                        int index23_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_13);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_11 = input.LA(1);

                         
                        int index23_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_3 = input.LA(1);

                         
                        int index23_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA23_8 = input.LA(1);

                         
                        int index23_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_8);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA23_9 = input.LA(1);

                         
                        int index23_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA23_1 = input.LA(1);

                         
                        int index23_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_1);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA23_15 = input.LA(1);

                         
                        int index23_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_15);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA23_4 = input.LA(1);

                         
                        int index23_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_4);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA23_6 = input.LA(1);

                         
                        int index23_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_6);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA23_7 = input.LA(1);

                         
                        int index23_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index23_7);
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
            return "1584:3: (this_recExpression_15= rulerecExpression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_12 = input.LA(1);

                         
                        int index25_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_17 = input.LA(1);

                         
                        int index25_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_17);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_2 = input.LA(1);

                         
                        int index25_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_14 = input.LA(1);

                         
                        int index25_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_14);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_16 = input.LA(1);

                         
                        int index25_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_10 = input.LA(1);

                         
                        int index25_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_13 = input.LA(1);

                         
                        int index25_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_13);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_11 = input.LA(1);

                         
                        int index25_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA25_8 = input.LA(1);

                         
                        int index25_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_8);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA25_9 = input.LA(1);

                         
                        int index25_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA25_1 = input.LA(1);

                         
                        int index25_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_1);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA25_15 = input.LA(1);

                         
                        int index25_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_15);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA25_4 = input.LA(1);

                         
                        int index25_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_4);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalMyDsl()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index25_7);
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
    static final String dfa_16s = "\1\4\10\uffff\1\63\1\uffff\1\4\1\6\2\uffff";
    static final String dfa_17s = "\1\123\10\uffff\1\115\1\uffff\1\4\1\115\2\uffff";
    static final String dfa_18s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\2\uffff\1\11\1\12";
    static final String dfa_19s = "\17\uffff}>";
    static final String[] dfa_20s = {
            "\1\11\1\2\1\uffff\1\1\1\3\20\uffff\1\12\56\uffff\1\4\1\5\1\6\1\7\1\10\1\uffff\6\12",
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
            "\1\12\11\uffff\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\3\uffff\1\12\1\uffff\1\12\1\uffff\1\12\4\uffff\1\12\1\uffff\5\12\1\uffff\3\12\1\uffff\1\16\11\12\20\uffff\1\15",
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

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "2326:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_Real_2= RULE_REAL | kw= 'true' | kw= 'false' | kw= 'null' | (kw= 'Sequence{' this_expressionSequence_7= ruleexpressionSequence kw= '}' ) | (kw= 'OrderedSet{' this_expressionSequence_10= ruleexpressionSequence kw= '}' ) | (this_Ident_12= RULE_IDENT kw= '::' this_Ident_14= RULE_IDENT kw= '::' this_Ident_16= RULE_IDENT ) | (this_Ident_17= RULE_IDENT kw= '::' this_Ident_19= RULE_IDENT kw= ':' ) | this_typeLiteral_21= ruletypeLiteral )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000006A0002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000680002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000009C000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000009C000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000098000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000100010000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0004C040220001B0L,0x00000000000FDF00L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0004C048220001B0L,0x00000000000FDF00L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0004C142260001B0L,0x00000000000FDF00L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x1FF0BE0000100042L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0xE000000000000010L,0x000000000000007FL});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00000000020001B0L,0x00000000000FDF00L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0004C040620001B0L,0x00000000000FDF00L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0004C040260001B0L,0x00000000000FDF00L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000100002L});

}