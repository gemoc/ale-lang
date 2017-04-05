package org.eclipse.ecoretools.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.ecoretools.services.AleGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalAleParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_REAL", "RULE_IDENT", "RULE_MULT_OP", "RULE_ADD_OP", "RULE_COMP_OP", "RULE_LETTER", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'def'", "'override'", "'select'", "'reject'", "'collect'", "'any'", "'exists'", "'forAll'", "'isUnique'", "'one'", "'sortedBy'", "'closure'", "'true'", "'false'", "'null'", "'behavior'", "';'", "'import'", "'as'", "'use'", "'.'", "'open'", "'class'", "'{'", "'}'", "'extends'", "','", "'('", "')'", "'@'", "':='", "'for'", "'in'", "'['", "'..'", "']'", "'if'", "'else'", "'while'", "'and'", "'or'", "'xor'", "'implies'", "'->'", "'not'", "'-'", "'then'", "'endif'", "'let'", "'='", "':'", "'|'", "'Sequence{'", "'OrderedSet{'", "'::'", "'String'", "'Integer'", "'Real'", "'Boolean'", "'Sequence('", "'OrderedSet('"
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
    public static final int RULE_REAL=6;
    public static final int RULE_IDENT=7;
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
    public static final int RULE_STRING=4;
    public static final int RULE_MULT_OP=8;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_COMP_OP=10;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int RULE_ADD_OP=9;
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


    	private AleGrammarAccess grammarAccess;

    	public void setGrammarAccess(AleGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRulerRoot"
    // InternalAle.g:54:1: entryRulerRoot : rulerRoot EOF ;
    public final void entryRulerRoot() throws RecognitionException {
        try {
            // InternalAle.g:55:1: ( rulerRoot EOF )
            // InternalAle.g:56:1: rulerRoot EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerRoot();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRRootRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerRoot"


    // $ANTLR start "rulerRoot"
    // InternalAle.g:63:1: rulerRoot : ( ( rule__RRoot__Group__0 ) ) ;
    public final void rulerRoot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:67:2: ( ( ( rule__RRoot__Group__0 ) ) )
            // InternalAle.g:68:2: ( ( rule__RRoot__Group__0 ) )
            {
            // InternalAle.g:68:2: ( ( rule__RRoot__Group__0 ) )
            // InternalAle.g:69:3: ( rule__RRoot__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getGroup()); 
            }
            // InternalAle.g:70:3: ( rule__RRoot__Group__0 )
            // InternalAle.g:70:4: rule__RRoot__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RRoot__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRRootAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerRoot"


    // $ANTLR start "entryRulerImport"
    // InternalAle.g:79:1: entryRulerImport : rulerImport EOF ;
    public final void entryRulerImport() throws RecognitionException {
        try {
            // InternalAle.g:80:1: ( rulerImport EOF )
            // InternalAle.g:81:1: rulerImport EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRImportRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerImport"


    // $ANTLR start "rulerImport"
    // InternalAle.g:88:1: rulerImport : ( ( rule__RImport__Group__0 ) ) ;
    public final void rulerImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:92:2: ( ( ( rule__RImport__Group__0 ) ) )
            // InternalAle.g:93:2: ( ( rule__RImport__Group__0 ) )
            {
            // InternalAle.g:93:2: ( ( rule__RImport__Group__0 ) )
            // InternalAle.g:94:3: ( rule__RImport__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getGroup()); 
            }
            // InternalAle.g:95:3: ( rule__RImport__Group__0 )
            // InternalAle.g:95:4: rule__RImport__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RImport__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRImportAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerImport"


    // $ANTLR start "entryRulerService"
    // InternalAle.g:104:1: entryRulerService : rulerService EOF ;
    public final void entryRulerService() throws RecognitionException {
        try {
            // InternalAle.g:105:1: ( rulerService EOF )
            // InternalAle.g:106:1: rulerService EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerService();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerService"


    // $ANTLR start "rulerService"
    // InternalAle.g:113:1: rulerService : ( ( rule__RService__Group__0 ) ) ;
    public final void rulerService() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:117:2: ( ( ( rule__RService__Group__0 ) ) )
            // InternalAle.g:118:2: ( ( rule__RService__Group__0 ) )
            {
            // InternalAle.g:118:2: ( ( rule__RService__Group__0 ) )
            // InternalAle.g:119:3: ( rule__RService__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getGroup()); 
            }
            // InternalAle.g:120:3: ( rule__RService__Group__0 )
            // InternalAle.g:120:4: rule__RService__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RService__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerService"


    // $ANTLR start "entryRulerClass"
    // InternalAle.g:129:1: entryRulerClass : rulerClass EOF ;
    public final void entryRulerClass() throws RecognitionException {
        try {
            // InternalAle.g:130:1: ( rulerClass EOF )
            // InternalAle.g:131:1: rulerClass EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRClassRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerClass"


    // $ANTLR start "rulerClass"
    // InternalAle.g:138:1: rulerClass : ( ( rule__RClass__Alternatives ) ) ;
    public final void rulerClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:142:2: ( ( ( rule__RClass__Alternatives ) ) )
            // InternalAle.g:143:2: ( ( rule__RClass__Alternatives ) )
            {
            // InternalAle.g:143:2: ( ( rule__RClass__Alternatives ) )
            // InternalAle.g:144:3: ( rule__RClass__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getAlternatives()); 
            }
            // InternalAle.g:145:3: ( rule__RClass__Alternatives )
            // InternalAle.g:145:4: rule__RClass__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RClass__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRClassAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerClass"


    // $ANTLR start "entryRulerOpenClass"
    // InternalAle.g:154:1: entryRulerOpenClass : rulerOpenClass EOF ;
    public final void entryRulerOpenClass() throws RecognitionException {
        try {
            // InternalAle.g:155:1: ( rulerOpenClass EOF )
            // InternalAle.g:156:1: rulerOpenClass EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerOpenClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerOpenClass"


    // $ANTLR start "rulerOpenClass"
    // InternalAle.g:163:1: rulerOpenClass : ( ( rule__ROpenClass__Group__0 ) ) ;
    public final void rulerOpenClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:167:2: ( ( ( rule__ROpenClass__Group__0 ) ) )
            // InternalAle.g:168:2: ( ( rule__ROpenClass__Group__0 ) )
            {
            // InternalAle.g:168:2: ( ( rule__ROpenClass__Group__0 ) )
            // InternalAle.g:169:3: ( rule__ROpenClass__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getGroup()); 
            }
            // InternalAle.g:170:3: ( rule__ROpenClass__Group__0 )
            // InternalAle.g:170:4: rule__ROpenClass__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerOpenClass"


    // $ANTLR start "entryRulerNewClass"
    // InternalAle.g:179:1: entryRulerNewClass : rulerNewClass EOF ;
    public final void entryRulerNewClass() throws RecognitionException {
        try {
            // InternalAle.g:180:1: ( rulerNewClass EOF )
            // InternalAle.g:181:1: rulerNewClass EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerNewClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerNewClass"


    // $ANTLR start "rulerNewClass"
    // InternalAle.g:188:1: rulerNewClass : ( ( rule__RNewClass__Group__0 ) ) ;
    public final void rulerNewClass() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:192:2: ( ( ( rule__RNewClass__Group__0 ) ) )
            // InternalAle.g:193:2: ( ( rule__RNewClass__Group__0 ) )
            {
            // InternalAle.g:193:2: ( ( rule__RNewClass__Group__0 ) )
            // InternalAle.g:194:3: ( rule__RNewClass__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getGroup()); 
            }
            // InternalAle.g:195:3: ( rule__RNewClass__Group__0 )
            // InternalAle.g:195:4: rule__RNewClass__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RNewClass__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerNewClass"


    // $ANTLR start "entryRulerOperation"
    // InternalAle.g:204:1: entryRulerOperation : rulerOperation EOF ;
    public final void entryRulerOperation() throws RecognitionException {
        try {
            // InternalAle.g:205:1: ( rulerOperation EOF )
            // InternalAle.g:206:1: rulerOperation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerOperation"


    // $ANTLR start "rulerOperation"
    // InternalAle.g:213:1: rulerOperation : ( ( rule__ROperation__Group__0 ) ) ;
    public final void rulerOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:217:2: ( ( ( rule__ROperation__Group__0 ) ) )
            // InternalAle.g:218:2: ( ( rule__ROperation__Group__0 ) )
            {
            // InternalAle.g:218:2: ( ( rule__ROperation__Group__0 ) )
            // InternalAle.g:219:3: ( rule__ROperation__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getGroup()); 
            }
            // InternalAle.g:220:3: ( rule__ROperation__Group__0 )
            // InternalAle.g:220:4: rule__ROperation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ROperation__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerOperation"


    // $ANTLR start "entryRulerTag"
    // InternalAle.g:229:1: entryRulerTag : rulerTag EOF ;
    public final void entryRulerTag() throws RecognitionException {
        try {
            // InternalAle.g:230:1: ( rulerTag EOF )
            // InternalAle.g:231:1: rulerTag EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTagRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerTag();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRTagRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerTag"


    // $ANTLR start "rulerTag"
    // InternalAle.g:238:1: rulerTag : ( ( rule__RTag__Group__0 ) ) ;
    public final void rulerTag() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:242:2: ( ( ( rule__RTag__Group__0 ) ) )
            // InternalAle.g:243:2: ( ( rule__RTag__Group__0 ) )
            {
            // InternalAle.g:243:2: ( ( rule__RTag__Group__0 ) )
            // InternalAle.g:244:3: ( rule__RTag__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTagAccess().getGroup()); 
            }
            // InternalAle.g:245:3: ( rule__RTag__Group__0 )
            // InternalAle.g:245:4: rule__RTag__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RTag__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRTagAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerTag"


    // $ANTLR start "entryRulerParameters"
    // InternalAle.g:254:1: entryRulerParameters : rulerParameters EOF ;
    public final void entryRulerParameters() throws RecognitionException {
        try {
            // InternalAle.g:255:1: ( rulerParameters EOF )
            // InternalAle.g:256:1: rulerParameters EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerParameters();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRParametersRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerParameters"


    // $ANTLR start "rulerParameters"
    // InternalAle.g:263:1: rulerParameters : ( ( rule__RParameters__Group__0 ) ) ;
    public final void rulerParameters() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:267:2: ( ( ( rule__RParameters__Group__0 ) ) )
            // InternalAle.g:268:2: ( ( rule__RParameters__Group__0 ) )
            {
            // InternalAle.g:268:2: ( ( rule__RParameters__Group__0 ) )
            // InternalAle.g:269:3: ( rule__RParameters__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getGroup()); 
            }
            // InternalAle.g:270:3: ( rule__RParameters__Group__0 )
            // InternalAle.g:270:4: rule__RParameters__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RParameters__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRParametersAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerParameters"


    // $ANTLR start "entryRulerVariable"
    // InternalAle.g:279:1: entryRulerVariable : rulerVariable EOF ;
    public final void entryRulerVariable() throws RecognitionException {
        try {
            // InternalAle.g:280:1: ( rulerVariable EOF )
            // InternalAle.g:281:1: rulerVariable EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVariableRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerVariable"


    // $ANTLR start "rulerVariable"
    // InternalAle.g:288:1: rulerVariable : ( ( rule__RVariable__Group__0 ) ) ;
    public final void rulerVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:292:2: ( ( ( rule__RVariable__Group__0 ) ) )
            // InternalAle.g:293:2: ( ( rule__RVariable__Group__0 ) )
            {
            // InternalAle.g:293:2: ( ( rule__RVariable__Group__0 ) )
            // InternalAle.g:294:3: ( rule__RVariable__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getGroup()); 
            }
            // InternalAle.g:295:3: ( rule__RVariable__Group__0 )
            // InternalAle.g:295:4: rule__RVariable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RVariable__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVariableAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerVariable"


    // $ANTLR start "entryRulerAttribute"
    // InternalAle.g:304:1: entryRulerAttribute : rulerAttribute EOF ;
    public final void entryRulerAttribute() throws RecognitionException {
        try {
            // InternalAle.g:305:1: ( rulerAttribute EOF )
            // InternalAle.g:306:1: rulerAttribute EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerAttribute();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerAttribute"


    // $ANTLR start "rulerAttribute"
    // InternalAle.g:313:1: rulerAttribute : ( ( rule__RAttribute__Group__0 ) ) ;
    public final void rulerAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:317:2: ( ( ( rule__RAttribute__Group__0 ) ) )
            // InternalAle.g:318:2: ( ( rule__RAttribute__Group__0 ) )
            {
            // InternalAle.g:318:2: ( ( rule__RAttribute__Group__0 ) )
            // InternalAle.g:319:3: ( rule__RAttribute__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getGroup()); 
            }
            // InternalAle.g:320:3: ( rule__RAttribute__Group__0 )
            // InternalAle.g:320:4: rule__RAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RAttribute__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerAttribute"


    // $ANTLR start "entryRulerStatement"
    // InternalAle.g:329:1: entryRulerStatement : rulerStatement EOF ;
    public final void entryRulerStatement() throws RecognitionException {
        try {
            // InternalAle.g:330:1: ( rulerStatement EOF )
            // InternalAle.g:331:1: rulerStatement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerStatement"


    // $ANTLR start "rulerStatement"
    // InternalAle.g:338:1: rulerStatement : ( ( rule__RStatement__Alternatives ) ) ;
    public final void rulerStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:342:2: ( ( ( rule__RStatement__Alternatives ) ) )
            // InternalAle.g:343:2: ( ( rule__RStatement__Alternatives ) )
            {
            // InternalAle.g:343:2: ( ( rule__RStatement__Alternatives ) )
            // InternalAle.g:344:3: ( rule__RStatement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getAlternatives()); 
            }
            // InternalAle.g:345:3: ( rule__RStatement__Alternatives )
            // InternalAle.g:345:4: rule__RStatement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerStatement"


    // $ANTLR start "entryRulerVarDecl"
    // InternalAle.g:354:1: entryRulerVarDecl : rulerVarDecl EOF ;
    public final void entryRulerVarDecl() throws RecognitionException {
        try {
            // InternalAle.g:355:1: ( rulerVarDecl EOF )
            // InternalAle.g:356:1: rulerVarDecl EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerVarDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerVarDecl"


    // $ANTLR start "rulerVarDecl"
    // InternalAle.g:363:1: rulerVarDecl : ( ( rule__RVarDecl__Group__0 ) ) ;
    public final void rulerVarDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:367:2: ( ( ( rule__RVarDecl__Group__0 ) ) )
            // InternalAle.g:368:2: ( ( rule__RVarDecl__Group__0 ) )
            {
            // InternalAle.g:368:2: ( ( rule__RVarDecl__Group__0 ) )
            // InternalAle.g:369:3: ( rule__RVarDecl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getGroup()); 
            }
            // InternalAle.g:370:3: ( rule__RVarDecl__Group__0 )
            // InternalAle.g:370:4: rule__RVarDecl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RVarDecl__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerVarDecl"


    // $ANTLR start "entryRulerAssign"
    // InternalAle.g:379:1: entryRulerAssign : rulerAssign EOF ;
    public final void entryRulerAssign() throws RecognitionException {
        try {
            // InternalAle.g:380:1: ( rulerAssign EOF )
            // InternalAle.g:381:1: rulerAssign EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerAssign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerAssign"


    // $ANTLR start "rulerAssign"
    // InternalAle.g:388:1: rulerAssign : ( ( rule__RAssign__Group__0 ) ) ;
    public final void rulerAssign() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:392:2: ( ( ( rule__RAssign__Group__0 ) ) )
            // InternalAle.g:393:2: ( ( rule__RAssign__Group__0 ) )
            {
            // InternalAle.g:393:2: ( ( rule__RAssign__Group__0 ) )
            // InternalAle.g:394:3: ( rule__RAssign__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getGroup()); 
            }
            // InternalAle.g:395:3: ( rule__RAssign__Group__0 )
            // InternalAle.g:395:4: rule__RAssign__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RAssign__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerAssign"


    // $ANTLR start "entryRulerForEach"
    // InternalAle.g:404:1: entryRulerForEach : rulerForEach EOF ;
    public final void entryRulerForEach() throws RecognitionException {
        try {
            // InternalAle.g:405:1: ( rulerForEach EOF )
            // InternalAle.g:406:1: rulerForEach EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerForEach();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerForEach"


    // $ANTLR start "rulerForEach"
    // InternalAle.g:413:1: rulerForEach : ( ( rule__RForEach__Group__0 ) ) ;
    public final void rulerForEach() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:417:2: ( ( ( rule__RForEach__Group__0 ) ) )
            // InternalAle.g:418:2: ( ( rule__RForEach__Group__0 ) )
            {
            // InternalAle.g:418:2: ( ( rule__RForEach__Group__0 ) )
            // InternalAle.g:419:3: ( rule__RForEach__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getGroup()); 
            }
            // InternalAle.g:420:3: ( rule__RForEach__Group__0 )
            // InternalAle.g:420:4: rule__RForEach__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RForEach__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerForEach"


    // $ANTLR start "entryRulerCollection"
    // InternalAle.g:429:1: entryRulerCollection : rulerCollection EOF ;
    public final void entryRulerCollection() throws RecognitionException {
        try {
            // InternalAle.g:430:1: ( rulerCollection EOF )
            // InternalAle.g:431:1: rulerCollection EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerCollection();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRCollectionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerCollection"


    // $ANTLR start "rulerCollection"
    // InternalAle.g:438:1: rulerCollection : ( ( rule__RCollection__Alternatives ) ) ;
    public final void rulerCollection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:442:2: ( ( ( rule__RCollection__Alternatives ) ) )
            // InternalAle.g:443:2: ( ( rule__RCollection__Alternatives ) )
            {
            // InternalAle.g:443:2: ( ( rule__RCollection__Alternatives ) )
            // InternalAle.g:444:3: ( rule__RCollection__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionAccess().getAlternatives()); 
            }
            // InternalAle.g:445:3: ( rule__RCollection__Alternatives )
            // InternalAle.g:445:4: rule__RCollection__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RCollection__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRCollectionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerCollection"


    // $ANTLR start "entryRulerBlock"
    // InternalAle.g:454:1: entryRulerBlock : rulerBlock EOF ;
    public final void entryRulerBlock() throws RecognitionException {
        try {
            // InternalAle.g:455:1: ( rulerBlock EOF )
            // InternalAle.g:456:1: rulerBlock EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerBlock"


    // $ANTLR start "rulerBlock"
    // InternalAle.g:463:1: rulerBlock : ( ( rule__RBlock__Group__0 ) ) ;
    public final void rulerBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:467:2: ( ( ( rule__RBlock__Group__0 ) ) )
            // InternalAle.g:468:2: ( ( rule__RBlock__Group__0 ) )
            {
            // InternalAle.g:468:2: ( ( rule__RBlock__Group__0 ) )
            // InternalAle.g:469:3: ( rule__RBlock__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getGroup()); 
            }
            // InternalAle.g:470:3: ( rule__RBlock__Group__0 )
            // InternalAle.g:470:4: rule__RBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RBlock__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerBlock"


    // $ANTLR start "entryRulerIf"
    // InternalAle.g:479:1: entryRulerIf : rulerIf EOF ;
    public final void entryRulerIf() throws RecognitionException {
        try {
            // InternalAle.g:480:1: ( rulerIf EOF )
            // InternalAle.g:481:1: rulerIf EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerIf();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerIf"


    // $ANTLR start "rulerIf"
    // InternalAle.g:488:1: rulerIf : ( ( rule__RIf__Group__0 ) ) ;
    public final void rulerIf() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:492:2: ( ( ( rule__RIf__Group__0 ) ) )
            // InternalAle.g:493:2: ( ( rule__RIf__Group__0 ) )
            {
            // InternalAle.g:493:2: ( ( rule__RIf__Group__0 ) )
            // InternalAle.g:494:3: ( rule__RIf__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getGroup()); 
            }
            // InternalAle.g:495:3: ( rule__RIf__Group__0 )
            // InternalAle.g:495:4: rule__RIf__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RIf__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerIf"


    // $ANTLR start "entryRulerWhile"
    // InternalAle.g:504:1: entryRulerWhile : rulerWhile EOF ;
    public final void entryRulerWhile() throws RecognitionException {
        try {
            // InternalAle.g:505:1: ( rulerWhile EOF )
            // InternalAle.g:506:1: rulerWhile EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerWhile();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRWhileRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerWhile"


    // $ANTLR start "rulerWhile"
    // InternalAle.g:513:1: rulerWhile : ( ( rule__RWhile__Group__0 ) ) ;
    public final void rulerWhile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:517:2: ( ( ( rule__RWhile__Group__0 ) ) )
            // InternalAle.g:518:2: ( ( rule__RWhile__Group__0 ) )
            {
            // InternalAle.g:518:2: ( ( rule__RWhile__Group__0 ) )
            // InternalAle.g:519:3: ( rule__RWhile__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getGroup()); 
            }
            // InternalAle.g:520:3: ( rule__RWhile__Group__0 )
            // InternalAle.g:520:4: rule__RWhile__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RWhile__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRWhileAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerWhile"


    // $ANTLR start "entryRulerExpression"
    // InternalAle.g:529:1: entryRulerExpression : rulerExpression EOF ;
    public final void entryRulerExpression() throws RecognitionException {
        try {
            // InternalAle.g:530:1: ( rulerExpression EOF )
            // InternalAle.g:531:1: rulerExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerExpression"


    // $ANTLR start "rulerExpression"
    // InternalAle.g:538:1: rulerExpression : ( ( rule__RExpression__Group__0 ) ) ;
    public final void rulerExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:542:2: ( ( ( rule__RExpression__Group__0 ) ) )
            // InternalAle.g:543:2: ( ( rule__RExpression__Group__0 ) )
            {
            // InternalAle.g:543:2: ( ( rule__RExpression__Group__0 ) )
            // InternalAle.g:544:3: ( rule__RExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRExpressionAccess().getGroup()); 
            }
            // InternalAle.g:545:3: ( rule__RExpression__Group__0 )
            // InternalAle.g:545:4: rule__RExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerExpression"


    // $ANTLR start "entryRuleexpression"
    // InternalAle.g:554:1: entryRuleexpression : ruleexpression EOF ;
    public final void entryRuleexpression() throws RecognitionException {
        try {
            // InternalAle.g:555:1: ( ruleexpression EOF )
            // InternalAle.g:556:1: ruleexpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleexpression"


    // $ANTLR start "ruleexpression"
    // InternalAle.g:563:1: ruleexpression : ( ( rule__Expression__Group__0 ) ) ;
    public final void ruleexpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:567:2: ( ( ( rule__Expression__Group__0 ) ) )
            // InternalAle.g:568:2: ( ( rule__Expression__Group__0 ) )
            {
            // InternalAle.g:568:2: ( ( rule__Expression__Group__0 ) )
            // InternalAle.g:569:3: ( rule__Expression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getGroup()); 
            }
            // InternalAle.g:570:3: ( rule__Expression__Group__0 )
            // InternalAle.g:570:4: rule__Expression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleexpression"


    // $ANTLR start "entryRulerecExpression"
    // InternalAle.g:579:1: entryRulerecExpression : rulerecExpression EOF ;
    public final void entryRulerecExpression() throws RecognitionException {
        try {
            // InternalAle.g:580:1: ( rulerecExpression EOF )
            // InternalAle.g:581:1: rulerecExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerecExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerecExpression"


    // $ANTLR start "rulerecExpression"
    // InternalAle.g:588:1: rulerecExpression : ( ( rule__RecExpression__Group__0 ) ) ;
    public final void rulerecExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:592:2: ( ( ( rule__RecExpression__Group__0 ) ) )
            // InternalAle.g:593:2: ( ( rule__RecExpression__Group__0 ) )
            {
            // InternalAle.g:593:2: ( ( rule__RecExpression__Group__0 ) )
            // InternalAle.g:594:3: ( rule__RecExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getGroup()); 
            }
            // InternalAle.g:595:3: ( rule__RecExpression__Group__0 )
            // InternalAle.g:595:4: rule__RecExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerecExpression"


    // $ANTLR start "entryRulenavigationSegment"
    // InternalAle.g:604:1: entryRulenavigationSegment : rulenavigationSegment EOF ;
    public final void entryRulenavigationSegment() throws RecognitionException {
        try {
            // InternalAle.g:605:1: ( rulenavigationSegment EOF )
            // InternalAle.g:606:1: rulenavigationSegment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentRule()); 
            }
            pushFollow(FOLLOW_1);
            rulenavigationSegment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulenavigationSegment"


    // $ANTLR start "rulenavigationSegment"
    // InternalAle.g:613:1: rulenavigationSegment : ( ( rule__NavigationSegment__Alternatives ) ) ;
    public final void rulenavigationSegment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:617:2: ( ( ( rule__NavigationSegment__Alternatives ) ) )
            // InternalAle.g:618:2: ( ( rule__NavigationSegment__Alternatives ) )
            {
            // InternalAle.g:618:2: ( ( rule__NavigationSegment__Alternatives ) )
            // InternalAle.g:619:3: ( rule__NavigationSegment__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getAlternatives()); 
            }
            // InternalAle.g:620:3: ( rule__NavigationSegment__Alternatives )
            // InternalAle.g:620:4: rule__NavigationSegment__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulenavigationSegment"


    // $ANTLR start "entryRulenonLeftRecExpression"
    // InternalAle.g:629:1: entryRulenonLeftRecExpression : rulenonLeftRecExpression EOF ;
    public final void entryRulenonLeftRecExpression() throws RecognitionException {
        try {
            // InternalAle.g:630:1: ( rulenonLeftRecExpression EOF )
            // InternalAle.g:631:1: rulenonLeftRecExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulenonLeftRecExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulenonLeftRecExpression"


    // $ANTLR start "rulenonLeftRecExpression"
    // InternalAle.g:638:1: rulenonLeftRecExpression : ( ( rule__NonLeftRecExpression__Alternatives ) ) ;
    public final void rulenonLeftRecExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:642:2: ( ( ( rule__NonLeftRecExpression__Alternatives ) ) )
            // InternalAle.g:643:2: ( ( rule__NonLeftRecExpression__Alternatives ) )
            {
            // InternalAle.g:643:2: ( ( rule__NonLeftRecExpression__Alternatives ) )
            // InternalAle.g:644:3: ( rule__NonLeftRecExpression__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getAlternatives()); 
            }
            // InternalAle.g:645:3: ( rule__NonLeftRecExpression__Alternatives )
            // InternalAle.g:645:4: rule__NonLeftRecExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulenonLeftRecExpression"


    // $ANTLR start "entryRulebinding"
    // InternalAle.g:654:1: entryRulebinding : rulebinding EOF ;
    public final void entryRulebinding() throws RecognitionException {
        try {
            // InternalAle.g:655:1: ( rulebinding EOF )
            // InternalAle.g:656:1: rulebinding EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingRule()); 
            }
            pushFollow(FOLLOW_1);
            rulebinding();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulebinding"


    // $ANTLR start "rulebinding"
    // InternalAle.g:663:1: rulebinding : ( ( rule__Binding__Group__0 ) ) ;
    public final void rulebinding() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:667:2: ( ( ( rule__Binding__Group__0 ) ) )
            // InternalAle.g:668:2: ( ( rule__Binding__Group__0 ) )
            {
            // InternalAle.g:668:2: ( ( rule__Binding__Group__0 ) )
            // InternalAle.g:669:3: ( rule__Binding__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getGroup()); 
            }
            // InternalAle.g:670:3: ( rule__Binding__Group__0 )
            // InternalAle.g:670:4: rule__Binding__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Binding__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulebinding"


    // $ANTLR start "entryRulecallExp"
    // InternalAle.g:679:1: entryRulecallExp : rulecallExp EOF ;
    public final void entryRulecallExp() throws RecognitionException {
        try {
            // InternalAle.g:680:1: ( rulecallExp EOF )
            // InternalAle.g:681:1: rulecallExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpRule()); 
            }
            pushFollow(FOLLOW_1);
            rulecallExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulecallExp"


    // $ANTLR start "rulecallExp"
    // InternalAle.g:688:1: rulecallExp : ( ( rule__CallExp__Alternatives ) ) ;
    public final void rulecallExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:692:2: ( ( ( rule__CallExp__Alternatives ) ) )
            // InternalAle.g:693:2: ( ( rule__CallExp__Alternatives ) )
            {
            // InternalAle.g:693:2: ( ( rule__CallExp__Alternatives ) )
            // InternalAle.g:694:3: ( rule__CallExp__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getAlternatives()); 
            }
            // InternalAle.g:695:3: ( rule__CallExp__Alternatives )
            // InternalAle.g:695:4: rule__CallExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CallExp__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulecallExp"


    // $ANTLR start "entryRulecollectionIterator"
    // InternalAle.g:704:1: entryRulecollectionIterator : rulecollectionIterator EOF ;
    public final void entryRulecollectionIterator() throws RecognitionException {
        try {
            // InternalAle.g:705:1: ( rulecollectionIterator EOF )
            // InternalAle.g:706:1: rulecollectionIterator EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionIteratorRule()); 
            }
            pushFollow(FOLLOW_1);
            rulecollectionIterator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionIteratorRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulecollectionIterator"


    // $ANTLR start "rulecollectionIterator"
    // InternalAle.g:713:1: rulecollectionIterator : ( ( rule__CollectionIterator__Alternatives ) ) ;
    public final void rulecollectionIterator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:717:2: ( ( ( rule__CollectionIterator__Alternatives ) ) )
            // InternalAle.g:718:2: ( ( rule__CollectionIterator__Alternatives ) )
            {
            // InternalAle.g:718:2: ( ( rule__CollectionIterator__Alternatives ) )
            // InternalAle.g:719:3: ( rule__CollectionIterator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionIteratorAccess().getAlternatives()); 
            }
            // InternalAle.g:720:3: ( rule__CollectionIterator__Alternatives )
            // InternalAle.g:720:4: rule__CollectionIterator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CollectionIterator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionIteratorAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulecollectionIterator"


    // $ANTLR start "entryRuleexpressionSequence"
    // InternalAle.g:729:1: entryRuleexpressionSequence : ruleexpressionSequence EOF ;
    public final void entryRuleexpressionSequence() throws RecognitionException {
        try {
            // InternalAle.g:730:1: ( ruleexpressionSequence EOF )
            // InternalAle.g:731:1: ruleexpressionSequence EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleexpressionSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleexpressionSequence"


    // $ANTLR start "ruleexpressionSequence"
    // InternalAle.g:738:1: ruleexpressionSequence : ( ( rule__ExpressionSequence__Group__0 )? ) ;
    public final void ruleexpressionSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:742:2: ( ( ( rule__ExpressionSequence__Group__0 )? ) )
            // InternalAle.g:743:2: ( ( rule__ExpressionSequence__Group__0 )? )
            {
            // InternalAle.g:743:2: ( ( rule__ExpressionSequence__Group__0 )? )
            // InternalAle.g:744:3: ( rule__ExpressionSequence__Group__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getGroup()); 
            }
            // InternalAle.g:745:3: ( rule__ExpressionSequence__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_IDENT)||(LA1_0>=29 && LA1_0<=31)||LA1_0==40||LA1_0==44||LA1_0==53||(LA1_0>=61 && LA1_0<=62)||LA1_0==65||(LA1_0>=69 && LA1_0<=70)||(LA1_0>=72 && LA1_0<=77)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalAle.g:745:4: rule__ExpressionSequence__Group__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExpressionSequence__Group__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleexpressionSequence"


    // $ANTLR start "entryRulevariableDefinition"
    // InternalAle.g:754:1: entryRulevariableDefinition : rulevariableDefinition EOF ;
    public final void entryRulevariableDefinition() throws RecognitionException {
        try {
            // InternalAle.g:755:1: ( rulevariableDefinition EOF )
            // InternalAle.g:756:1: rulevariableDefinition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulevariableDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDefinitionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulevariableDefinition"


    // $ANTLR start "rulevariableDefinition"
    // InternalAle.g:763:1: rulevariableDefinition : ( ( rule__VariableDefinition__Group__0 ) ) ;
    public final void rulevariableDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:767:2: ( ( ( rule__VariableDefinition__Group__0 ) ) )
            // InternalAle.g:768:2: ( ( rule__VariableDefinition__Group__0 ) )
            {
            // InternalAle.g:768:2: ( ( rule__VariableDefinition__Group__0 ) )
            // InternalAle.g:769:3: ( rule__VariableDefinition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getGroup()); 
            }
            // InternalAle.g:770:3: ( rule__VariableDefinition__Group__0 )
            // InternalAle.g:770:4: rule__VariableDefinition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VariableDefinition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDefinitionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulevariableDefinition"


    // $ANTLR start "entryRuleliteral"
    // InternalAle.g:779:1: entryRuleliteral : ruleliteral EOF ;
    public final void entryRuleliteral() throws RecognitionException {
        try {
            // InternalAle.g:780:1: ( ruleliteral EOF )
            // InternalAle.g:781:1: ruleliteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleliteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleliteral"


    // $ANTLR start "ruleliteral"
    // InternalAle.g:788:1: ruleliteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleliteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:792:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalAle.g:793:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalAle.g:793:2: ( ( rule__Literal__Alternatives ) )
            // InternalAle.g:794:3: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // InternalAle.g:795:3: ( rule__Literal__Alternatives )
            // InternalAle.g:795:4: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleliteral"


    // $ANTLR start "entryRuletypeLiteral"
    // InternalAle.g:804:1: entryRuletypeLiteral : ruletypeLiteral EOF ;
    public final void entryRuletypeLiteral() throws RecognitionException {
        try {
            // InternalAle.g:805:1: ( ruletypeLiteral EOF )
            // InternalAle.g:806:1: ruletypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruletypeLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuletypeLiteral"


    // $ANTLR start "ruletypeLiteral"
    // InternalAle.g:813:1: ruletypeLiteral : ( ( rule__TypeLiteral__Alternatives ) ) ;
    public final void ruletypeLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:817:2: ( ( ( rule__TypeLiteral__Alternatives ) ) )
            // InternalAle.g:818:2: ( ( rule__TypeLiteral__Alternatives ) )
            {
            // InternalAle.g:818:2: ( ( rule__TypeLiteral__Alternatives ) )
            // InternalAle.g:819:3: ( rule__TypeLiteral__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getAlternatives()); 
            }
            // InternalAle.g:820:3: ( rule__TypeLiteral__Alternatives )
            // InternalAle.g:820:4: rule__TypeLiteral__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruletypeLiteral"


    // $ANTLR start "entryRuleclassifierTypeRule"
    // InternalAle.g:829:1: entryRuleclassifierTypeRule : ruleclassifierTypeRule EOF ;
    public final void entryRuleclassifierTypeRule() throws RecognitionException {
        try {
            // InternalAle.g:830:1: ( ruleclassifierTypeRule EOF )
            // InternalAle.g:831:1: ruleclassifierTypeRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleclassifierTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleclassifierTypeRule"


    // $ANTLR start "ruleclassifierTypeRule"
    // InternalAle.g:838:1: ruleclassifierTypeRule : ( ( rule__ClassifierTypeRule__Alternatives ) ) ;
    public final void ruleclassifierTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:842:2: ( ( ( rule__ClassifierTypeRule__Alternatives ) ) )
            // InternalAle.g:843:2: ( ( rule__ClassifierTypeRule__Alternatives ) )
            {
            // InternalAle.g:843:2: ( ( rule__ClassifierTypeRule__Alternatives ) )
            // InternalAle.g:844:3: ( rule__ClassifierTypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getAlternatives()); 
            }
            // InternalAle.g:845:3: ( rule__ClassifierTypeRule__Alternatives )
            // InternalAle.g:845:4: rule__ClassifierTypeRule__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ClassifierTypeRule__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleclassifierTypeRule"


    // $ANTLR start "entryRulerType"
    // InternalAle.g:854:1: entryRulerType : rulerType EOF ;
    public final void entryRulerType() throws RecognitionException {
        try {
            // InternalAle.g:855:1: ( rulerType EOF )
            // InternalAle.g:856:1: rulerType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerType"


    // $ANTLR start "rulerType"
    // InternalAle.g:863:1: rulerType : ( ( rule__RType__Alternatives ) ) ;
    public final void rulerType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:867:2: ( ( ( rule__RType__Alternatives ) ) )
            // InternalAle.g:868:2: ( ( rule__RType__Alternatives ) )
            {
            // InternalAle.g:868:2: ( ( rule__RType__Alternatives ) )
            // InternalAle.g:869:3: ( rule__RType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTypeAccess().getAlternatives()); 
            }
            // InternalAle.g:870:3: ( rule__RType__Alternatives )
            // InternalAle.g:870:4: rule__RType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRTypeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerType"


    // $ANTLR start "entryRulerQualified"
    // InternalAle.g:879:1: entryRulerQualified : rulerQualified EOF ;
    public final void entryRulerQualified() throws RecognitionException {
        try {
            // InternalAle.g:880:1: ( rulerQualified EOF )
            // InternalAle.g:881:1: rulerQualified EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedRule()); 
            }
            pushFollow(FOLLOW_1);
            rulerQualified();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRQualifiedRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulerQualified"


    // $ANTLR start "rulerQualified"
    // InternalAle.g:888:1: rulerQualified : ( ( rule__RQualified__Group__0 ) ) ;
    public final void rulerQualified() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:892:2: ( ( ( rule__RQualified__Group__0 ) ) )
            // InternalAle.g:893:2: ( ( rule__RQualified__Group__0 ) )
            {
            // InternalAle.g:893:2: ( ( rule__RQualified__Group__0 ) )
            // InternalAle.g:894:3: ( rule__RQualified__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getGroup()); 
            }
            // InternalAle.g:895:3: ( rule__RQualified__Group__0 )
            // InternalAle.g:895:4: rule__RQualified__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RQualified__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRQualifiedAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulerQualified"


    // $ANTLR start "rule__RClass__Alternatives"
    // InternalAle.g:903:1: rule__RClass__Alternatives : ( ( ( rule__RClass__Group_0__0 ) ) | ( ( rule__RClass__Group_1__0 ) ) );
    public final void rule__RClass__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:907:1: ( ( ( rule__RClass__Group_0__0 ) ) | ( ( rule__RClass__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==38) ) {
                alt2=1;
            }
            else if ( (LA2_0==39) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalAle.g:908:2: ( ( rule__RClass__Group_0__0 ) )
                    {
                    // InternalAle.g:908:2: ( ( rule__RClass__Group_0__0 ) )
                    // InternalAle.g:909:3: ( rule__RClass__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRClassAccess().getGroup_0()); 
                    }
                    // InternalAle.g:910:3: ( rule__RClass__Group_0__0 )
                    // InternalAle.g:910:4: rule__RClass__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RClass__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRClassAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:914:2: ( ( rule__RClass__Group_1__0 ) )
                    {
                    // InternalAle.g:914:2: ( ( rule__RClass__Group_1__0 ) )
                    // InternalAle.g:915:3: ( rule__RClass__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRClassAccess().getGroup_1()); 
                    }
                    // InternalAle.g:916:3: ( rule__RClass__Group_1__0 )
                    // InternalAle.g:916:4: rule__RClass__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RClass__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRClassAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__Alternatives"


    // $ANTLR start "rule__ROperation__Alternatives_1"
    // InternalAle.g:924:1: rule__ROperation__Alternatives_1 : ( ( 'def' ) | ( 'override' ) );
    public final void rule__ROperation__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:928:1: ( ( 'def' ) | ( 'override' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalAle.g:929:2: ( 'def' )
                    {
                    // InternalAle.g:929:2: ( 'def' )
                    // InternalAle.g:930:3: 'def'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getROperationAccess().getDefKeyword_1_0()); 
                    }
                    match(input,17,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getROperationAccess().getDefKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:935:2: ( 'override' )
                    {
                    // InternalAle.g:935:2: ( 'override' )
                    // InternalAle.g:936:3: 'override'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getROperationAccess().getOverrideKeyword_1_1()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getROperationAccess().getOverrideKeyword_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Alternatives_1"


    // $ANTLR start "rule__RStatement__Alternatives"
    // InternalAle.g:945:1: rule__RStatement__Alternatives : ( ( ( rule__RStatement__Group_0__0 ) ) | ( ( rule__RStatement__Group_1__0 ) ) | ( ( rule__RStatement__Group_2__0 ) ) | ( ( rule__RStatement__Group_3__0 ) ) | ( ( rule__RStatement__Group_4__0 ) ) | ( ( rule__RStatement__Group_5__0 ) ) );
    public final void rule__RStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:949:1: ( ( ( rule__RStatement__Group_0__0 ) ) | ( ( rule__RStatement__Group_1__0 ) ) | ( ( rule__RStatement__Group_2__0 ) ) | ( ( rule__RStatement__Group_3__0 ) ) | ( ( rule__RStatement__Group_4__0 ) ) | ( ( rule__RStatement__Group_5__0 ) ) )
            int alt4=6;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalAle.g:950:2: ( ( rule__RStatement__Group_0__0 ) )
                    {
                    // InternalAle.g:950:2: ( ( rule__RStatement__Group_0__0 ) )
                    // InternalAle.g:951:3: ( rule__RStatement__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_0()); 
                    }
                    // InternalAle.g:952:3: ( rule__RStatement__Group_0__0 )
                    // InternalAle.g:952:4: rule__RStatement__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RStatement__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:956:2: ( ( rule__RStatement__Group_1__0 ) )
                    {
                    // InternalAle.g:956:2: ( ( rule__RStatement__Group_1__0 ) )
                    // InternalAle.g:957:3: ( rule__RStatement__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_1()); 
                    }
                    // InternalAle.g:958:3: ( rule__RStatement__Group_1__0 )
                    // InternalAle.g:958:4: rule__RStatement__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RStatement__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:962:2: ( ( rule__RStatement__Group_2__0 ) )
                    {
                    // InternalAle.g:962:2: ( ( rule__RStatement__Group_2__0 ) )
                    // InternalAle.g:963:3: ( rule__RStatement__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_2()); 
                    }
                    // InternalAle.g:964:3: ( rule__RStatement__Group_2__0 )
                    // InternalAle.g:964:4: rule__RStatement__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RStatement__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:968:2: ( ( rule__RStatement__Group_3__0 ) )
                    {
                    // InternalAle.g:968:2: ( ( rule__RStatement__Group_3__0 ) )
                    // InternalAle.g:969:3: ( rule__RStatement__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_3()); 
                    }
                    // InternalAle.g:970:3: ( rule__RStatement__Group_3__0 )
                    // InternalAle.g:970:4: rule__RStatement__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RStatement__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:974:2: ( ( rule__RStatement__Group_4__0 ) )
                    {
                    // InternalAle.g:974:2: ( ( rule__RStatement__Group_4__0 ) )
                    // InternalAle.g:975:3: ( rule__RStatement__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_4()); 
                    }
                    // InternalAle.g:976:3: ( rule__RStatement__Group_4__0 )
                    // InternalAle.g:976:4: rule__RStatement__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RStatement__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:980:2: ( ( rule__RStatement__Group_5__0 ) )
                    {
                    // InternalAle.g:980:2: ( ( rule__RStatement__Group_5__0 ) )
                    // InternalAle.g:981:3: ( rule__RStatement__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_5()); 
                    }
                    // InternalAle.g:982:3: ( rule__RStatement__Group_5__0 )
                    // InternalAle.g:982:4: rule__RStatement__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RStatement__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getGroup_5()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Alternatives"


    // $ANTLR start "rule__RCollection__Alternatives"
    // InternalAle.g:990:1: rule__RCollection__Alternatives : ( ( ( rule__RCollection__Group_0__0 ) ) | ( ruleexpression ) );
    public final void rule__RCollection__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:994:1: ( ( ( rule__RCollection__Group_0__0 ) ) | ( ruleexpression ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==50) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_IDENT)||(LA5_0>=29 && LA5_0<=31)||LA5_0==40||LA5_0==44||LA5_0==53||(LA5_0>=61 && LA5_0<=62)||LA5_0==65||(LA5_0>=69 && LA5_0<=70)||(LA5_0>=72 && LA5_0<=77)) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalAle.g:995:2: ( ( rule__RCollection__Group_0__0 ) )
                    {
                    // InternalAle.g:995:2: ( ( rule__RCollection__Group_0__0 ) )
                    // InternalAle.g:996:3: ( rule__RCollection__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRCollectionAccess().getGroup_0()); 
                    }
                    // InternalAle.g:997:3: ( rule__RCollection__Group_0__0 )
                    // InternalAle.g:997:4: rule__RCollection__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RCollection__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRCollectionAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1001:2: ( ruleexpression )
                    {
                    // InternalAle.g:1001:2: ( ruleexpression )
                    // InternalAle.g:1002:3: ruleexpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRCollectionAccess().getExpressionParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleexpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRCollectionAccess().getExpressionParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Alternatives"


    // $ANTLR start "rule__RecExpression__Alternatives_0"
    // InternalAle.g:1011:1: rule__RecExpression__Alternatives_0 : ( ( rulenavigationSegment ) | ( ( rule__RecExpression__Group_0_1__0 ) ) | ( ( rule__RecExpression__Group_0_2__0 ) ) | ( ( rule__RecExpression__Group_0_3__0 ) ) | ( ( rule__RecExpression__Group_0_4__0 ) ) | ( ( rule__RecExpression__Group_0_5__0 ) ) | ( ( rule__RecExpression__Group_0_6__0 ) ) | ( ( rule__RecExpression__Group_0_7__0 ) ) );
    public final void rule__RecExpression__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1015:1: ( ( rulenavigationSegment ) | ( ( rule__RecExpression__Group_0_1__0 ) ) | ( ( rule__RecExpression__Group_0_2__0 ) ) | ( ( rule__RecExpression__Group_0_3__0 ) ) | ( ( rule__RecExpression__Group_0_4__0 ) ) | ( ( rule__RecExpression__Group_0_5__0 ) ) | ( ( rule__RecExpression__Group_0_6__0 ) ) | ( ( rule__RecExpression__Group_0_7__0 ) ) )
            int alt6=8;
            switch ( input.LA(1) ) {
            case 37:
            case 60:
                {
                alt6=1;
                }
                break;
            case RULE_MULT_OP:
                {
                alt6=2;
                }
                break;
            case RULE_ADD_OP:
                {
                alt6=3;
                }
                break;
            case RULE_COMP_OP:
                {
                alt6=4;
                }
                break;
            case 56:
                {
                alt6=5;
                }
                break;
            case 57:
                {
                alt6=6;
                }
                break;
            case 58:
                {
                alt6=7;
                }
                break;
            case 59:
                {
                alt6=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalAle.g:1016:2: ( rulenavigationSegment )
                    {
                    // InternalAle.g:1016:2: ( rulenavigationSegment )
                    // InternalAle.g:1017:3: rulenavigationSegment
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getNavigationSegmentParserRuleCall_0_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulenavigationSegment();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRecExpressionAccess().getNavigationSegmentParserRuleCall_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1022:2: ( ( rule__RecExpression__Group_0_1__0 ) )
                    {
                    // InternalAle.g:1022:2: ( ( rule__RecExpression__Group_0_1__0 ) )
                    // InternalAle.g:1023:3: ( rule__RecExpression__Group_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_1()); 
                    }
                    // InternalAle.g:1024:3: ( rule__RecExpression__Group_0_1__0 )
                    // InternalAle.g:1024:4: rule__RecExpression__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RecExpression__Group_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRecExpressionAccess().getGroup_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1028:2: ( ( rule__RecExpression__Group_0_2__0 ) )
                    {
                    // InternalAle.g:1028:2: ( ( rule__RecExpression__Group_0_2__0 ) )
                    // InternalAle.g:1029:3: ( rule__RecExpression__Group_0_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_2()); 
                    }
                    // InternalAle.g:1030:3: ( rule__RecExpression__Group_0_2__0 )
                    // InternalAle.g:1030:4: rule__RecExpression__Group_0_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RecExpression__Group_0_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRecExpressionAccess().getGroup_0_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1034:2: ( ( rule__RecExpression__Group_0_3__0 ) )
                    {
                    // InternalAle.g:1034:2: ( ( rule__RecExpression__Group_0_3__0 ) )
                    // InternalAle.g:1035:3: ( rule__RecExpression__Group_0_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_3()); 
                    }
                    // InternalAle.g:1036:3: ( rule__RecExpression__Group_0_3__0 )
                    // InternalAle.g:1036:4: rule__RecExpression__Group_0_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RecExpression__Group_0_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRecExpressionAccess().getGroup_0_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1040:2: ( ( rule__RecExpression__Group_0_4__0 ) )
                    {
                    // InternalAle.g:1040:2: ( ( rule__RecExpression__Group_0_4__0 ) )
                    // InternalAle.g:1041:3: ( rule__RecExpression__Group_0_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_4()); 
                    }
                    // InternalAle.g:1042:3: ( rule__RecExpression__Group_0_4__0 )
                    // InternalAle.g:1042:4: rule__RecExpression__Group_0_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RecExpression__Group_0_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRecExpressionAccess().getGroup_0_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1046:2: ( ( rule__RecExpression__Group_0_5__0 ) )
                    {
                    // InternalAle.g:1046:2: ( ( rule__RecExpression__Group_0_5__0 ) )
                    // InternalAle.g:1047:3: ( rule__RecExpression__Group_0_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_5()); 
                    }
                    // InternalAle.g:1048:3: ( rule__RecExpression__Group_0_5__0 )
                    // InternalAle.g:1048:4: rule__RecExpression__Group_0_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RecExpression__Group_0_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRecExpressionAccess().getGroup_0_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:1052:2: ( ( rule__RecExpression__Group_0_6__0 ) )
                    {
                    // InternalAle.g:1052:2: ( ( rule__RecExpression__Group_0_6__0 ) )
                    // InternalAle.g:1053:3: ( rule__RecExpression__Group_0_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_6()); 
                    }
                    // InternalAle.g:1054:3: ( rule__RecExpression__Group_0_6__0 )
                    // InternalAle.g:1054:4: rule__RecExpression__Group_0_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RecExpression__Group_0_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRecExpressionAccess().getGroup_0_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:1058:2: ( ( rule__RecExpression__Group_0_7__0 ) )
                    {
                    // InternalAle.g:1058:2: ( ( rule__RecExpression__Group_0_7__0 ) )
                    // InternalAle.g:1059:3: ( rule__RecExpression__Group_0_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_7()); 
                    }
                    // InternalAle.g:1060:3: ( rule__RecExpression__Group_0_7__0 )
                    // InternalAle.g:1060:4: rule__RecExpression__Group_0_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RecExpression__Group_0_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRecExpressionAccess().getGroup_0_7()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Alternatives_0"


    // $ANTLR start "rule__NavigationSegment__Alternatives"
    // InternalAle.g:1068:1: rule__NavigationSegment__Alternatives : ( ( ( rule__NavigationSegment__Group_0__0 ) ) | ( ( rule__NavigationSegment__Group_1__0 ) ) | ( ( rule__NavigationSegment__Group_2__0 ) ) );
    public final void rule__NavigationSegment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1072:1: ( ( ( rule__NavigationSegment__Group_0__0 ) ) | ( ( rule__NavigationSegment__Group_1__0 ) ) | ( ( rule__NavigationSegment__Group_2__0 ) ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==37) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_IDENT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==44) ) {
                        alt7=2;
                    }
                    else if ( (LA7_3==EOF||(LA7_3>=RULE_MULT_OP && LA7_3<=RULE_COMP_OP)||LA7_3==33||LA7_3==37||LA7_3==41||LA7_3==43||LA7_3==45||LA7_3==47||LA7_3==49||LA7_3==54||(LA7_3>=56 && LA7_3<=60)||(LA7_3>=63 && LA7_3<=64)) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else if ( ((LA7_1>=19 && LA7_1<=28)) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==60) ) {
                alt7=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalAle.g:1073:2: ( ( rule__NavigationSegment__Group_0__0 ) )
                    {
                    // InternalAle.g:1073:2: ( ( rule__NavigationSegment__Group_0__0 ) )
                    // InternalAle.g:1074:3: ( rule__NavigationSegment__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationSegmentAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1075:3: ( rule__NavigationSegment__Group_0__0 )
                    // InternalAle.g:1075:4: rule__NavigationSegment__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NavigationSegment__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNavigationSegmentAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1079:2: ( ( rule__NavigationSegment__Group_1__0 ) )
                    {
                    // InternalAle.g:1079:2: ( ( rule__NavigationSegment__Group_1__0 ) )
                    // InternalAle.g:1080:3: ( rule__NavigationSegment__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationSegmentAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1081:3: ( rule__NavigationSegment__Group_1__0 )
                    // InternalAle.g:1081:4: rule__NavigationSegment__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NavigationSegment__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNavigationSegmentAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1085:2: ( ( rule__NavigationSegment__Group_2__0 ) )
                    {
                    // InternalAle.g:1085:2: ( ( rule__NavigationSegment__Group_2__0 ) )
                    // InternalAle.g:1086:3: ( rule__NavigationSegment__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationSegmentAccess().getGroup_2()); 
                    }
                    // InternalAle.g:1087:3: ( rule__NavigationSegment__Group_2__0 )
                    // InternalAle.g:1087:4: rule__NavigationSegment__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NavigationSegment__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNavigationSegmentAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Alternatives"


    // $ANTLR start "rule__NonLeftRecExpression__Alternatives"
    // InternalAle.g:1095:1: rule__NonLeftRecExpression__Alternatives : ( ( ( rule__NonLeftRecExpression__Group_0__0 ) ) | ( ( rule__NonLeftRecExpression__Group_1__0 ) ) | ( ( rule__NonLeftRecExpression__Group_2__0 ) ) | ( ( rule__NonLeftRecExpression__Group_3__0 ) ) | ( ( rule__NonLeftRecExpression__Group_4__0 ) ) | ( ( rule__NonLeftRecExpression__Group_5__0 ) ) | ( ( rule__NonLeftRecExpression__Group_6__0 ) ) );
    public final void rule__NonLeftRecExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1099:1: ( ( ( rule__NonLeftRecExpression__Group_0__0 ) ) | ( ( rule__NonLeftRecExpression__Group_1__0 ) ) | ( ( rule__NonLeftRecExpression__Group_2__0 ) ) | ( ( rule__NonLeftRecExpression__Group_3__0 ) ) | ( ( rule__NonLeftRecExpression__Group_4__0 ) ) | ( ( rule__NonLeftRecExpression__Group_5__0 ) ) | ( ( rule__NonLeftRecExpression__Group_6__0 ) ) )
            int alt8=7;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt8=1;
                }
                break;
            case 62:
                {
                alt8=2;
                }
                break;
            case RULE_IDENT:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==EOF||(LA8_3>=RULE_MULT_OP && LA8_3<=RULE_COMP_OP)||LA8_3==33||LA8_3==37||LA8_3==41||LA8_3==43||LA8_3==45||LA8_3==47||LA8_3==49||LA8_3==54||(LA8_3>=56 && LA8_3<=60)||(LA8_3>=63 && LA8_3<=64)) ) {
                    alt8=3;
                }
                else if ( (LA8_3==67||LA8_3==71) ) {
                    alt8=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case RULE_REAL:
            case 29:
            case 30:
            case 31:
            case 40:
            case 69:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
                {
                alt8=4;
                }
                break;
            case 44:
                {
                alt8=5;
                }
                break;
            case 53:
                {
                alt8=6;
                }
                break;
            case 65:
                {
                alt8=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalAle.g:1100:2: ( ( rule__NonLeftRecExpression__Group_0__0 ) )
                    {
                    // InternalAle.g:1100:2: ( ( rule__NonLeftRecExpression__Group_0__0 ) )
                    // InternalAle.g:1101:3: ( rule__NonLeftRecExpression__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1102:3: ( rule__NonLeftRecExpression__Group_0__0 )
                    // InternalAle.g:1102:4: rule__NonLeftRecExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NonLeftRecExpression__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonLeftRecExpressionAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1106:2: ( ( rule__NonLeftRecExpression__Group_1__0 ) )
                    {
                    // InternalAle.g:1106:2: ( ( rule__NonLeftRecExpression__Group_1__0 ) )
                    // InternalAle.g:1107:3: ( rule__NonLeftRecExpression__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1108:3: ( rule__NonLeftRecExpression__Group_1__0 )
                    // InternalAle.g:1108:4: rule__NonLeftRecExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NonLeftRecExpression__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonLeftRecExpressionAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1112:2: ( ( rule__NonLeftRecExpression__Group_2__0 ) )
                    {
                    // InternalAle.g:1112:2: ( ( rule__NonLeftRecExpression__Group_2__0 ) )
                    // InternalAle.g:1113:3: ( rule__NonLeftRecExpression__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_2()); 
                    }
                    // InternalAle.g:1114:3: ( rule__NonLeftRecExpression__Group_2__0 )
                    // InternalAle.g:1114:4: rule__NonLeftRecExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NonLeftRecExpression__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonLeftRecExpressionAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1118:2: ( ( rule__NonLeftRecExpression__Group_3__0 ) )
                    {
                    // InternalAle.g:1118:2: ( ( rule__NonLeftRecExpression__Group_3__0 ) )
                    // InternalAle.g:1119:3: ( rule__NonLeftRecExpression__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_3()); 
                    }
                    // InternalAle.g:1120:3: ( rule__NonLeftRecExpression__Group_3__0 )
                    // InternalAle.g:1120:4: rule__NonLeftRecExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NonLeftRecExpression__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonLeftRecExpressionAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1124:2: ( ( rule__NonLeftRecExpression__Group_4__0 ) )
                    {
                    // InternalAle.g:1124:2: ( ( rule__NonLeftRecExpression__Group_4__0 ) )
                    // InternalAle.g:1125:3: ( rule__NonLeftRecExpression__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_4()); 
                    }
                    // InternalAle.g:1126:3: ( rule__NonLeftRecExpression__Group_4__0 )
                    // InternalAle.g:1126:4: rule__NonLeftRecExpression__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NonLeftRecExpression__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonLeftRecExpressionAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1130:2: ( ( rule__NonLeftRecExpression__Group_5__0 ) )
                    {
                    // InternalAle.g:1130:2: ( ( rule__NonLeftRecExpression__Group_5__0 ) )
                    // InternalAle.g:1131:3: ( rule__NonLeftRecExpression__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_5()); 
                    }
                    // InternalAle.g:1132:3: ( rule__NonLeftRecExpression__Group_5__0 )
                    // InternalAle.g:1132:4: rule__NonLeftRecExpression__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NonLeftRecExpression__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonLeftRecExpressionAccess().getGroup_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:1136:2: ( ( rule__NonLeftRecExpression__Group_6__0 ) )
                    {
                    // InternalAle.g:1136:2: ( ( rule__NonLeftRecExpression__Group_6__0 ) )
                    // InternalAle.g:1137:3: ( rule__NonLeftRecExpression__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6()); 
                    }
                    // InternalAle.g:1138:3: ( rule__NonLeftRecExpression__Group_6__0 )
                    // InternalAle.g:1138:4: rule__NonLeftRecExpression__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NonLeftRecExpression__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Alternatives"


    // $ANTLR start "rule__CallExp__Alternatives"
    // InternalAle.g:1146:1: rule__CallExp__Alternatives : ( ( ( rule__CallExp__Group_0__0 ) ) | ( ( rule__CallExp__Group_1__0 ) ) );
    public final void rule__CallExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1150:1: ( ( ( rule__CallExp__Group_0__0 ) ) | ( ( rule__CallExp__Group_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=19 && LA9_0<=28)) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_IDENT) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalAle.g:1151:2: ( ( rule__CallExp__Group_0__0 ) )
                    {
                    // InternalAle.g:1151:2: ( ( rule__CallExp__Group_0__0 ) )
                    // InternalAle.g:1152:3: ( rule__CallExp__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1153:3: ( rule__CallExp__Group_0__0 )
                    // InternalAle.g:1153:4: rule__CallExp__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CallExp__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCallExpAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1157:2: ( ( rule__CallExp__Group_1__0 ) )
                    {
                    // InternalAle.g:1157:2: ( ( rule__CallExp__Group_1__0 ) )
                    // InternalAle.g:1158:3: ( rule__CallExp__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1159:3: ( rule__CallExp__Group_1__0 )
                    // InternalAle.g:1159:4: rule__CallExp__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CallExp__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCallExpAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Alternatives"


    // $ANTLR start "rule__CollectionIterator__Alternatives"
    // InternalAle.g:1167:1: rule__CollectionIterator__Alternatives : ( ( 'select' ) | ( 'reject' ) | ( 'collect' ) | ( 'any' ) | ( 'exists' ) | ( 'forAll' ) | ( 'isUnique' ) | ( 'one' ) | ( 'sortedBy' ) | ( 'closure' ) );
    public final void rule__CollectionIterator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1171:1: ( ( 'select' ) | ( 'reject' ) | ( 'collect' ) | ( 'any' ) | ( 'exists' ) | ( 'forAll' ) | ( 'isUnique' ) | ( 'one' ) | ( 'sortedBy' ) | ( 'closure' ) )
            int alt10=10;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt10=1;
                }
                break;
            case 20:
                {
                alt10=2;
                }
                break;
            case 21:
                {
                alt10=3;
                }
                break;
            case 22:
                {
                alt10=4;
                }
                break;
            case 23:
                {
                alt10=5;
                }
                break;
            case 24:
                {
                alt10=6;
                }
                break;
            case 25:
                {
                alt10=7;
                }
                break;
            case 26:
                {
                alt10=8;
                }
                break;
            case 27:
                {
                alt10=9;
                }
                break;
            case 28:
                {
                alt10=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalAle.g:1172:2: ( 'select' )
                    {
                    // InternalAle.g:1172:2: ( 'select' )
                    // InternalAle.g:1173:3: 'select'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getSelectKeyword_0()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getSelectKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1178:2: ( 'reject' )
                    {
                    // InternalAle.g:1178:2: ( 'reject' )
                    // InternalAle.g:1179:3: 'reject'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getRejectKeyword_1()); 
                    }
                    match(input,20,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getRejectKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1184:2: ( 'collect' )
                    {
                    // InternalAle.g:1184:2: ( 'collect' )
                    // InternalAle.g:1185:3: 'collect'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getCollectKeyword_2()); 
                    }
                    match(input,21,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getCollectKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1190:2: ( 'any' )
                    {
                    // InternalAle.g:1190:2: ( 'any' )
                    // InternalAle.g:1191:3: 'any'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getAnyKeyword_3()); 
                    }
                    match(input,22,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getAnyKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1196:2: ( 'exists' )
                    {
                    // InternalAle.g:1196:2: ( 'exists' )
                    // InternalAle.g:1197:3: 'exists'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getExistsKeyword_4()); 
                    }
                    match(input,23,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getExistsKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1202:2: ( 'forAll' )
                    {
                    // InternalAle.g:1202:2: ( 'forAll' )
                    // InternalAle.g:1203:3: 'forAll'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getForAllKeyword_5()); 
                    }
                    match(input,24,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getForAllKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:1208:2: ( 'isUnique' )
                    {
                    // InternalAle.g:1208:2: ( 'isUnique' )
                    // InternalAle.g:1209:3: 'isUnique'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getIsUniqueKeyword_6()); 
                    }
                    match(input,25,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getIsUniqueKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:1214:2: ( 'one' )
                    {
                    // InternalAle.g:1214:2: ( 'one' )
                    // InternalAle.g:1215:3: 'one'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getOneKeyword_7()); 
                    }
                    match(input,26,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getOneKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalAle.g:1220:2: ( 'sortedBy' )
                    {
                    // InternalAle.g:1220:2: ( 'sortedBy' )
                    // InternalAle.g:1221:3: 'sortedBy'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getSortedByKeyword_8()); 
                    }
                    match(input,27,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getSortedByKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalAle.g:1226:2: ( 'closure' )
                    {
                    // InternalAle.g:1226:2: ( 'closure' )
                    // InternalAle.g:1227:3: 'closure'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getClosureKeyword_9()); 
                    }
                    match(input,28,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getClosureKeyword_9()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalAle.g:1236:1: rule__Literal__Alternatives : ( ( RULE_STRING ) | ( RULE_INT ) | ( RULE_REAL ) | ( 'true' ) | ( 'false' ) | ( 'null' ) | ( ( rule__Literal__Group_6__0 ) ) | ( ( rule__Literal__Group_7__0 ) ) | ( ( rule__Literal__Group_8__0 ) ) | ( ( rule__Literal__Group_9__0 ) ) | ( ruletypeLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1240:1: ( ( RULE_STRING ) | ( RULE_INT ) | ( RULE_REAL ) | ( 'true' ) | ( 'false' ) | ( 'null' ) | ( ( rule__Literal__Group_6__0 ) ) | ( ( rule__Literal__Group_7__0 ) ) | ( ( rule__Literal__Group_8__0 ) ) | ( ( rule__Literal__Group_9__0 ) ) | ( ruletypeLiteral ) )
            int alt11=11;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalAle.g:1241:2: ( RULE_STRING )
                    {
                    // InternalAle.g:1241:2: ( RULE_STRING )
                    // InternalAle.g:1242:3: RULE_STRING
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1247:2: ( RULE_INT )
                    {
                    // InternalAle.g:1247:2: ( RULE_INT )
                    // InternalAle.g:1248:3: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_1()); 
                    }
                    match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1253:2: ( RULE_REAL )
                    {
                    // InternalAle.g:1253:2: ( RULE_REAL )
                    // InternalAle.g:1254:3: RULE_REAL
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getREALTerminalRuleCall_2()); 
                    }
                    match(input,RULE_REAL,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getREALTerminalRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1259:2: ( 'true' )
                    {
                    // InternalAle.g:1259:2: ( 'true' )
                    // InternalAle.g:1260:3: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getTrueKeyword_3()); 
                    }
                    match(input,29,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getTrueKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1265:2: ( 'false' )
                    {
                    // InternalAle.g:1265:2: ( 'false' )
                    // InternalAle.g:1266:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getFalseKeyword_4()); 
                    }
                    match(input,30,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getFalseKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1271:2: ( 'null' )
                    {
                    // InternalAle.g:1271:2: ( 'null' )
                    // InternalAle.g:1272:3: 'null'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getNullKeyword_5()); 
                    }
                    match(input,31,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getNullKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:1277:2: ( ( rule__Literal__Group_6__0 ) )
                    {
                    // InternalAle.g:1277:2: ( ( rule__Literal__Group_6__0 ) )
                    // InternalAle.g:1278:3: ( rule__Literal__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_6()); 
                    }
                    // InternalAle.g:1279:3: ( rule__Literal__Group_6__0 )
                    // InternalAle.g:1279:4: rule__Literal__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:1283:2: ( ( rule__Literal__Group_7__0 ) )
                    {
                    // InternalAle.g:1283:2: ( ( rule__Literal__Group_7__0 ) )
                    // InternalAle.g:1284:3: ( rule__Literal__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_7()); 
                    }
                    // InternalAle.g:1285:3: ( rule__Literal__Group_7__0 )
                    // InternalAle.g:1285:4: rule__Literal__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getGroup_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalAle.g:1289:2: ( ( rule__Literal__Group_8__0 ) )
                    {
                    // InternalAle.g:1289:2: ( ( rule__Literal__Group_8__0 ) )
                    // InternalAle.g:1290:3: ( rule__Literal__Group_8__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_8()); 
                    }
                    // InternalAle.g:1291:3: ( rule__Literal__Group_8__0 )
                    // InternalAle.g:1291:4: rule__Literal__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__Group_8__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getGroup_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalAle.g:1295:2: ( ( rule__Literal__Group_9__0 ) )
                    {
                    // InternalAle.g:1295:2: ( ( rule__Literal__Group_9__0 ) )
                    // InternalAle.g:1296:3: ( rule__Literal__Group_9__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_9()); 
                    }
                    // InternalAle.g:1297:3: ( rule__Literal__Group_9__0 )
                    // InternalAle.g:1297:4: rule__Literal__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__Group_9__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getGroup_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalAle.g:1301:2: ( ruletypeLiteral )
                    {
                    // InternalAle.g:1301:2: ( ruletypeLiteral )
                    // InternalAle.g:1302:3: ruletypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getTypeLiteralParserRuleCall_10()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getTypeLiteralParserRuleCall_10()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__TypeLiteral__Alternatives"
    // InternalAle.g:1311:1: rule__TypeLiteral__Alternatives : ( ( ( rule__TypeLiteral__Group_0__0 ) ) | ( ( rule__TypeLiteral__Group_1__0 ) ) | ( ( rule__TypeLiteral__Group_2__0 ) ) | ( ( rule__TypeLiteral__Group_3__0 ) ) | ( ( rule__TypeLiteral__Group_4__0 ) ) | ( ( rule__TypeLiteral__Group_5__0 ) ) | ( ( rule__TypeLiteral__Group_6__0 ) ) | ( ( rule__TypeLiteral__Group_7__0 ) ) );
    public final void rule__TypeLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1315:1: ( ( ( rule__TypeLiteral__Group_0__0 ) ) | ( ( rule__TypeLiteral__Group_1__0 ) ) | ( ( rule__TypeLiteral__Group_2__0 ) ) | ( ( rule__TypeLiteral__Group_3__0 ) ) | ( ( rule__TypeLiteral__Group_4__0 ) ) | ( ( rule__TypeLiteral__Group_5__0 ) ) | ( ( rule__TypeLiteral__Group_6__0 ) ) | ( ( rule__TypeLiteral__Group_7__0 ) ) )
            int alt12=8;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt12=1;
                }
                break;
            case 73:
                {
                alt12=2;
                }
                break;
            case 74:
                {
                alt12=3;
                }
                break;
            case 75:
                {
                alt12=4;
                }
                break;
            case 76:
                {
                alt12=5;
                }
                break;
            case 77:
                {
                alt12=6;
                }
                break;
            case RULE_IDENT:
                {
                alt12=7;
                }
                break;
            case 40:
                {
                alt12=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalAle.g:1316:2: ( ( rule__TypeLiteral__Group_0__0 ) )
                    {
                    // InternalAle.g:1316:2: ( ( rule__TypeLiteral__Group_0__0 ) )
                    // InternalAle.g:1317:3: ( rule__TypeLiteral__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1318:3: ( rule__TypeLiteral__Group_0__0 )
                    // InternalAle.g:1318:4: rule__TypeLiteral__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeLiteral__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1322:2: ( ( rule__TypeLiteral__Group_1__0 ) )
                    {
                    // InternalAle.g:1322:2: ( ( rule__TypeLiteral__Group_1__0 ) )
                    // InternalAle.g:1323:3: ( rule__TypeLiteral__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1324:3: ( rule__TypeLiteral__Group_1__0 )
                    // InternalAle.g:1324:4: rule__TypeLiteral__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeLiteral__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1328:2: ( ( rule__TypeLiteral__Group_2__0 ) )
                    {
                    // InternalAle.g:1328:2: ( ( rule__TypeLiteral__Group_2__0 ) )
                    // InternalAle.g:1329:3: ( rule__TypeLiteral__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_2()); 
                    }
                    // InternalAle.g:1330:3: ( rule__TypeLiteral__Group_2__0 )
                    // InternalAle.g:1330:4: rule__TypeLiteral__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeLiteral__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1334:2: ( ( rule__TypeLiteral__Group_3__0 ) )
                    {
                    // InternalAle.g:1334:2: ( ( rule__TypeLiteral__Group_3__0 ) )
                    // InternalAle.g:1335:3: ( rule__TypeLiteral__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_3()); 
                    }
                    // InternalAle.g:1336:3: ( rule__TypeLiteral__Group_3__0 )
                    // InternalAle.g:1336:4: rule__TypeLiteral__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeLiteral__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1340:2: ( ( rule__TypeLiteral__Group_4__0 ) )
                    {
                    // InternalAle.g:1340:2: ( ( rule__TypeLiteral__Group_4__0 ) )
                    // InternalAle.g:1341:3: ( rule__TypeLiteral__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_4()); 
                    }
                    // InternalAle.g:1342:3: ( rule__TypeLiteral__Group_4__0 )
                    // InternalAle.g:1342:4: rule__TypeLiteral__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeLiteral__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1346:2: ( ( rule__TypeLiteral__Group_5__0 ) )
                    {
                    // InternalAle.g:1346:2: ( ( rule__TypeLiteral__Group_5__0 ) )
                    // InternalAle.g:1347:3: ( rule__TypeLiteral__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_5()); 
                    }
                    // InternalAle.g:1348:3: ( rule__TypeLiteral__Group_5__0 )
                    // InternalAle.g:1348:4: rule__TypeLiteral__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeLiteral__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getGroup_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:1352:2: ( ( rule__TypeLiteral__Group_6__0 ) )
                    {
                    // InternalAle.g:1352:2: ( ( rule__TypeLiteral__Group_6__0 ) )
                    // InternalAle.g:1353:3: ( rule__TypeLiteral__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_6()); 
                    }
                    // InternalAle.g:1354:3: ( rule__TypeLiteral__Group_6__0 )
                    // InternalAle.g:1354:4: rule__TypeLiteral__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeLiteral__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:1358:2: ( ( rule__TypeLiteral__Group_7__0 ) )
                    {
                    // InternalAle.g:1358:2: ( ( rule__TypeLiteral__Group_7__0 ) )
                    // InternalAle.g:1359:3: ( rule__TypeLiteral__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_7()); 
                    }
                    // InternalAle.g:1360:3: ( rule__TypeLiteral__Group_7__0 )
                    // InternalAle.g:1360:4: rule__TypeLiteral__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeLiteral__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getGroup_7()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Alternatives"


    // $ANTLR start "rule__ClassifierTypeRule__Alternatives"
    // InternalAle.g:1368:1: rule__ClassifierTypeRule__Alternatives : ( ( ( rule__ClassifierTypeRule__Group_0__0 ) ) | ( ( rule__ClassifierTypeRule__Group_1__0 ) ) );
    public final void rule__ClassifierTypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1372:1: ( ( ( rule__ClassifierTypeRule__Group_0__0 ) ) | ( ( rule__ClassifierTypeRule__Group_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_IDENT) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==71) ) {
                    alt13=1;
                }
                else if ( (LA13_1==67) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalAle.g:1373:2: ( ( rule__ClassifierTypeRule__Group_0__0 ) )
                    {
                    // InternalAle.g:1373:2: ( ( rule__ClassifierTypeRule__Group_0__0 ) )
                    // InternalAle.g:1374:3: ( rule__ClassifierTypeRule__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassifierTypeRuleAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1375:3: ( rule__ClassifierTypeRule__Group_0__0 )
                    // InternalAle.g:1375:4: rule__ClassifierTypeRule__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassifierTypeRule__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassifierTypeRuleAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1379:2: ( ( rule__ClassifierTypeRule__Group_1__0 ) )
                    {
                    // InternalAle.g:1379:2: ( ( rule__ClassifierTypeRule__Group_1__0 ) )
                    // InternalAle.g:1380:3: ( rule__ClassifierTypeRule__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassifierTypeRuleAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1381:3: ( rule__ClassifierTypeRule__Group_1__0 )
                    // InternalAle.g:1381:4: rule__ClassifierTypeRule__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassifierTypeRule__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassifierTypeRuleAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Alternatives"


    // $ANTLR start "rule__RType__Alternatives"
    // InternalAle.g:1389:1: rule__RType__Alternatives : ( ( rulerQualified ) | ( ruletypeLiteral ) );
    public final void rule__RType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1393:1: ( ( rulerQualified ) | ( ruletypeLiteral ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_IDENT) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==67||LA14_1==71) ) {
                    alt14=2;
                }
                else if ( (LA14_1==EOF||LA14_1==RULE_IDENT||LA14_1==37) ) {
                    alt14=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA14_0==40||(LA14_0>=72 && LA14_0<=77)) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalAle.g:1394:2: ( rulerQualified )
                    {
                    // InternalAle.g:1394:2: ( rulerQualified )
                    // InternalAle.g:1395:3: rulerQualified
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRTypeAccess().getRQualifiedParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulerQualified();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRTypeAccess().getRQualifiedParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1400:2: ( ruletypeLiteral )
                    {
                    // InternalAle.g:1400:2: ( ruletypeLiteral )
                    // InternalAle.g:1401:3: ruletypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRTypeAccess().getTypeLiteralParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruletypeLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRTypeAccess().getTypeLiteralParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RType__Alternatives"


    // $ANTLR start "rule__RRoot__Group__0"
    // InternalAle.g:1410:1: rule__RRoot__Group__0 : rule__RRoot__Group__0__Impl rule__RRoot__Group__1 ;
    public final void rule__RRoot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1414:1: ( rule__RRoot__Group__0__Impl rule__RRoot__Group__1 )
            // InternalAle.g:1415:2: rule__RRoot__Group__0__Impl rule__RRoot__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RRoot__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RRoot__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__0"


    // $ANTLR start "rule__RRoot__Group__0__Impl"
    // InternalAle.g:1422:1: rule__RRoot__Group__0__Impl : ( 'behavior' ) ;
    public final void rule__RRoot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1426:1: ( ( 'behavior' ) )
            // InternalAle.g:1427:1: ( 'behavior' )
            {
            // InternalAle.g:1427:1: ( 'behavior' )
            // InternalAle.g:1428:2: 'behavior'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getBehaviorKeyword_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRRootAccess().getBehaviorKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__0__Impl"


    // $ANTLR start "rule__RRoot__Group__1"
    // InternalAle.g:1437:1: rule__RRoot__Group__1 : rule__RRoot__Group__1__Impl rule__RRoot__Group__2 ;
    public final void rule__RRoot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1441:1: ( rule__RRoot__Group__1__Impl rule__RRoot__Group__2 )
            // InternalAle.g:1442:2: rule__RRoot__Group__1__Impl rule__RRoot__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__RRoot__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RRoot__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__1"


    // $ANTLR start "rule__RRoot__Group__1__Impl"
    // InternalAle.g:1449:1: rule__RRoot__Group__1__Impl : ( rulerQualified ) ;
    public final void rule__RRoot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1453:1: ( ( rulerQualified ) )
            // InternalAle.g:1454:1: ( rulerQualified )
            {
            // InternalAle.g:1454:1: ( rulerQualified )
            // InternalAle.g:1455:2: rulerQualified
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getRQualifiedParserRuleCall_1()); 
            }
            pushFollow(FOLLOW_2);
            rulerQualified();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRRootAccess().getRQualifiedParserRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__1__Impl"


    // $ANTLR start "rule__RRoot__Group__2"
    // InternalAle.g:1464:1: rule__RRoot__Group__2 : rule__RRoot__Group__2__Impl rule__RRoot__Group__3 ;
    public final void rule__RRoot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1468:1: ( rule__RRoot__Group__2__Impl rule__RRoot__Group__3 )
            // InternalAle.g:1469:2: rule__RRoot__Group__2__Impl rule__RRoot__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__RRoot__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RRoot__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__2"


    // $ANTLR start "rule__RRoot__Group__2__Impl"
    // InternalAle.g:1476:1: rule__RRoot__Group__2__Impl : ( ';' ) ;
    public final void rule__RRoot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1480:1: ( ( ';' ) )
            // InternalAle.g:1481:1: ( ';' )
            {
            // InternalAle.g:1481:1: ( ';' )
            // InternalAle.g:1482:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getSemicolonKeyword_2()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRRootAccess().getSemicolonKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__2__Impl"


    // $ANTLR start "rule__RRoot__Group__3"
    // InternalAle.g:1491:1: rule__RRoot__Group__3 : rule__RRoot__Group__3__Impl rule__RRoot__Group__4 ;
    public final void rule__RRoot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1495:1: ( rule__RRoot__Group__3__Impl rule__RRoot__Group__4 )
            // InternalAle.g:1496:2: rule__RRoot__Group__3__Impl rule__RRoot__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__RRoot__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RRoot__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__3"


    // $ANTLR start "rule__RRoot__Group__3__Impl"
    // InternalAle.g:1503:1: rule__RRoot__Group__3__Impl : ( ( rulerImport )* ) ;
    public final void rule__RRoot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1507:1: ( ( ( rulerImport )* ) )
            // InternalAle.g:1508:1: ( ( rulerImport )* )
            {
            // InternalAle.g:1508:1: ( ( rulerImport )* )
            // InternalAle.g:1509:2: ( rulerImport )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getRImportParserRuleCall_3()); 
            }
            // InternalAle.g:1510:2: ( rulerImport )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==34) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalAle.g:1510:3: rulerImport
            	    {
            	    pushFollow(FOLLOW_6);
            	    rulerImport();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRRootAccess().getRImportParserRuleCall_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__3__Impl"


    // $ANTLR start "rule__RRoot__Group__4"
    // InternalAle.g:1518:1: rule__RRoot__Group__4 : rule__RRoot__Group__4__Impl rule__RRoot__Group__5 ;
    public final void rule__RRoot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1522:1: ( rule__RRoot__Group__4__Impl rule__RRoot__Group__5 )
            // InternalAle.g:1523:2: rule__RRoot__Group__4__Impl rule__RRoot__Group__5
            {
            pushFollow(FOLLOW_5);
            rule__RRoot__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RRoot__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__4"


    // $ANTLR start "rule__RRoot__Group__4__Impl"
    // InternalAle.g:1530:1: rule__RRoot__Group__4__Impl : ( ( rulerService )* ) ;
    public final void rule__RRoot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1534:1: ( ( ( rulerService )* ) )
            // InternalAle.g:1535:1: ( ( rulerService )* )
            {
            // InternalAle.g:1535:1: ( ( rulerService )* )
            // InternalAle.g:1536:2: ( rulerService )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getRServiceParserRuleCall_4()); 
            }
            // InternalAle.g:1537:2: ( rulerService )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==36) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalAle.g:1537:3: rulerService
            	    {
            	    pushFollow(FOLLOW_7);
            	    rulerService();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRRootAccess().getRServiceParserRuleCall_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__4__Impl"


    // $ANTLR start "rule__RRoot__Group__5"
    // InternalAle.g:1545:1: rule__RRoot__Group__5 : rule__RRoot__Group__5__Impl ;
    public final void rule__RRoot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1549:1: ( rule__RRoot__Group__5__Impl )
            // InternalAle.g:1550:2: rule__RRoot__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RRoot__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__5"


    // $ANTLR start "rule__RRoot__Group__5__Impl"
    // InternalAle.g:1556:1: rule__RRoot__Group__5__Impl : ( ( rule__RRoot__XtendedClassesAssignment_5 )* ) ;
    public final void rule__RRoot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1560:1: ( ( ( rule__RRoot__XtendedClassesAssignment_5 )* ) )
            // InternalAle.g:1561:1: ( ( rule__RRoot__XtendedClassesAssignment_5 )* )
            {
            // InternalAle.g:1561:1: ( ( rule__RRoot__XtendedClassesAssignment_5 )* )
            // InternalAle.g:1562:2: ( rule__RRoot__XtendedClassesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getXtendedClassesAssignment_5()); 
            }
            // InternalAle.g:1563:2: ( rule__RRoot__XtendedClassesAssignment_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=38 && LA17_0<=39)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalAle.g:1563:3: rule__RRoot__XtendedClassesAssignment_5
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__RRoot__XtendedClassesAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRRootAccess().getXtendedClassesAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__Group__5__Impl"


    // $ANTLR start "rule__RImport__Group__0"
    // InternalAle.g:1572:1: rule__RImport__Group__0 : rule__RImport__Group__0__Impl rule__RImport__Group__1 ;
    public final void rule__RImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1576:1: ( rule__RImport__Group__0__Impl rule__RImport__Group__1 )
            // InternalAle.g:1577:2: rule__RImport__Group__0__Impl rule__RImport__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RImport__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RImport__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__0"


    // $ANTLR start "rule__RImport__Group__0__Impl"
    // InternalAle.g:1584:1: rule__RImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__RImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1588:1: ( ( 'import' ) )
            // InternalAle.g:1589:1: ( 'import' )
            {
            // InternalAle.g:1589:1: ( 'import' )
            // InternalAle.g:1590:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getImportKeyword_0()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRImportAccess().getImportKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__0__Impl"


    // $ANTLR start "rule__RImport__Group__1"
    // InternalAle.g:1599:1: rule__RImport__Group__1 : rule__RImport__Group__1__Impl rule__RImport__Group__2 ;
    public final void rule__RImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1603:1: ( rule__RImport__Group__1__Impl rule__RImport__Group__2 )
            // InternalAle.g:1604:2: rule__RImport__Group__1__Impl rule__RImport__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__RImport__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RImport__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__1"


    // $ANTLR start "rule__RImport__Group__1__Impl"
    // InternalAle.g:1611:1: rule__RImport__Group__1__Impl : ( rulerQualified ) ;
    public final void rule__RImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1615:1: ( ( rulerQualified ) )
            // InternalAle.g:1616:1: ( rulerQualified )
            {
            // InternalAle.g:1616:1: ( rulerQualified )
            // InternalAle.g:1617:2: rulerQualified
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getRQualifiedParserRuleCall_1()); 
            }
            pushFollow(FOLLOW_2);
            rulerQualified();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRImportAccess().getRQualifiedParserRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__1__Impl"


    // $ANTLR start "rule__RImport__Group__2"
    // InternalAle.g:1626:1: rule__RImport__Group__2 : rule__RImport__Group__2__Impl rule__RImport__Group__3 ;
    public final void rule__RImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1630:1: ( rule__RImport__Group__2__Impl rule__RImport__Group__3 )
            // InternalAle.g:1631:2: rule__RImport__Group__2__Impl rule__RImport__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__RImport__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RImport__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__2"


    // $ANTLR start "rule__RImport__Group__2__Impl"
    // InternalAle.g:1638:1: rule__RImport__Group__2__Impl : ( 'as' ) ;
    public final void rule__RImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1642:1: ( ( 'as' ) )
            // InternalAle.g:1643:1: ( 'as' )
            {
            // InternalAle.g:1643:1: ( 'as' )
            // InternalAle.g:1644:2: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getAsKeyword_2()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRImportAccess().getAsKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__2__Impl"


    // $ANTLR start "rule__RImport__Group__3"
    // InternalAle.g:1653:1: rule__RImport__Group__3 : rule__RImport__Group__3__Impl rule__RImport__Group__4 ;
    public final void rule__RImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1657:1: ( rule__RImport__Group__3__Impl rule__RImport__Group__4 )
            // InternalAle.g:1658:2: rule__RImport__Group__3__Impl rule__RImport__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__RImport__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RImport__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__3"


    // $ANTLR start "rule__RImport__Group__3__Impl"
    // InternalAle.g:1665:1: rule__RImport__Group__3__Impl : ( RULE_IDENT ) ;
    public final void rule__RImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1669:1: ( ( RULE_IDENT ) )
            // InternalAle.g:1670:1: ( RULE_IDENT )
            {
            // InternalAle.g:1670:1: ( RULE_IDENT )
            // InternalAle.g:1671:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getIDENTTerminalRuleCall_3()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRImportAccess().getIDENTTerminalRuleCall_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__3__Impl"


    // $ANTLR start "rule__RImport__Group__4"
    // InternalAle.g:1680:1: rule__RImport__Group__4 : rule__RImport__Group__4__Impl ;
    public final void rule__RImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1684:1: ( rule__RImport__Group__4__Impl )
            // InternalAle.g:1685:2: rule__RImport__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RImport__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__4"


    // $ANTLR start "rule__RImport__Group__4__Impl"
    // InternalAle.g:1691:1: rule__RImport__Group__4__Impl : ( ';' ) ;
    public final void rule__RImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1695:1: ( ( ';' ) )
            // InternalAle.g:1696:1: ( ';' )
            {
            // InternalAle.g:1696:1: ( ';' )
            // InternalAle.g:1697:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getSemicolonKeyword_4()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRImportAccess().getSemicolonKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RImport__Group__4__Impl"


    // $ANTLR start "rule__RService__Group__0"
    // InternalAle.g:1707:1: rule__RService__Group__0 : rule__RService__Group__0__Impl rule__RService__Group__1 ;
    public final void rule__RService__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1711:1: ( rule__RService__Group__0__Impl rule__RService__Group__1 )
            // InternalAle.g:1712:2: rule__RService__Group__0__Impl rule__RService__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RService__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RService__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group__0"


    // $ANTLR start "rule__RService__Group__0__Impl"
    // InternalAle.g:1719:1: rule__RService__Group__0__Impl : ( 'use' ) ;
    public final void rule__RService__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1723:1: ( ( 'use' ) )
            // InternalAle.g:1724:1: ( 'use' )
            {
            // InternalAle.g:1724:1: ( 'use' )
            // InternalAle.g:1725:2: 'use'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getUseKeyword_0()); 
            }
            match(input,36,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceAccess().getUseKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group__0__Impl"


    // $ANTLR start "rule__RService__Group__1"
    // InternalAle.g:1734:1: rule__RService__Group__1 : rule__RService__Group__1__Impl rule__RService__Group__2 ;
    public final void rule__RService__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1738:1: ( rule__RService__Group__1__Impl rule__RService__Group__2 )
            // InternalAle.g:1739:2: rule__RService__Group__1__Impl rule__RService__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__RService__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RService__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group__1"


    // $ANTLR start "rule__RService__Group__1__Impl"
    // InternalAle.g:1746:1: rule__RService__Group__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RService__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1750:1: ( ( RULE_IDENT ) )
            // InternalAle.g:1751:1: ( RULE_IDENT )
            {
            // InternalAle.g:1751:1: ( RULE_IDENT )
            // InternalAle.g:1752:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getIDENTTerminalRuleCall_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceAccess().getIDENTTerminalRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group__1__Impl"


    // $ANTLR start "rule__RService__Group__2"
    // InternalAle.g:1761:1: rule__RService__Group__2 : rule__RService__Group__2__Impl rule__RService__Group__3 ;
    public final void rule__RService__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1765:1: ( rule__RService__Group__2__Impl rule__RService__Group__3 )
            // InternalAle.g:1766:2: rule__RService__Group__2__Impl rule__RService__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__RService__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RService__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group__2"


    // $ANTLR start "rule__RService__Group__2__Impl"
    // InternalAle.g:1773:1: rule__RService__Group__2__Impl : ( ( rule__RService__Group_2__0 )* ) ;
    public final void rule__RService__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1777:1: ( ( ( rule__RService__Group_2__0 )* ) )
            // InternalAle.g:1778:1: ( ( rule__RService__Group_2__0 )* )
            {
            // InternalAle.g:1778:1: ( ( rule__RService__Group_2__0 )* )
            // InternalAle.g:1779:2: ( rule__RService__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getGroup_2()); 
            }
            // InternalAle.g:1780:2: ( rule__RService__Group_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==37) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalAle.g:1780:3: rule__RService__Group_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__RService__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group__2__Impl"


    // $ANTLR start "rule__RService__Group__3"
    // InternalAle.g:1788:1: rule__RService__Group__3 : rule__RService__Group__3__Impl ;
    public final void rule__RService__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1792:1: ( rule__RService__Group__3__Impl )
            // InternalAle.g:1793:2: rule__RService__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RService__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group__3"


    // $ANTLR start "rule__RService__Group__3__Impl"
    // InternalAle.g:1799:1: rule__RService__Group__3__Impl : ( ';' ) ;
    public final void rule__RService__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1803:1: ( ( ';' ) )
            // InternalAle.g:1804:1: ( ';' )
            {
            // InternalAle.g:1804:1: ( ';' )
            // InternalAle.g:1805:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getSemicolonKeyword_3()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group__3__Impl"


    // $ANTLR start "rule__RService__Group_2__0"
    // InternalAle.g:1815:1: rule__RService__Group_2__0 : rule__RService__Group_2__0__Impl rule__RService__Group_2__1 ;
    public final void rule__RService__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1819:1: ( rule__RService__Group_2__0__Impl rule__RService__Group_2__1 )
            // InternalAle.g:1820:2: rule__RService__Group_2__0__Impl rule__RService__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__RService__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RService__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group_2__0"


    // $ANTLR start "rule__RService__Group_2__0__Impl"
    // InternalAle.g:1827:1: rule__RService__Group_2__0__Impl : ( '.' ) ;
    public final void rule__RService__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1831:1: ( ( '.' ) )
            // InternalAle.g:1832:1: ( '.' )
            {
            // InternalAle.g:1832:1: ( '.' )
            // InternalAle.g:1833:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getFullStopKeyword_2_0()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceAccess().getFullStopKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group_2__0__Impl"


    // $ANTLR start "rule__RService__Group_2__1"
    // InternalAle.g:1842:1: rule__RService__Group_2__1 : rule__RService__Group_2__1__Impl ;
    public final void rule__RService__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1846:1: ( rule__RService__Group_2__1__Impl )
            // InternalAle.g:1847:2: rule__RService__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RService__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group_2__1"


    // $ANTLR start "rule__RService__Group_2__1__Impl"
    // InternalAle.g:1853:1: rule__RService__Group_2__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RService__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1857:1: ( ( RULE_IDENT ) )
            // InternalAle.g:1858:1: ( RULE_IDENT )
            {
            // InternalAle.g:1858:1: ( RULE_IDENT )
            // InternalAle.g:1859:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getIDENTTerminalRuleCall_2_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceAccess().getIDENTTerminalRuleCall_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RService__Group_2__1__Impl"


    // $ANTLR start "rule__RClass__Group_0__0"
    // InternalAle.g:1869:1: rule__RClass__Group_0__0 : rule__RClass__Group_0__0__Impl rule__RClass__Group_0__1 ;
    public final void rule__RClass__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1873:1: ( rule__RClass__Group_0__0__Impl rule__RClass__Group_0__1 )
            // InternalAle.g:1874:2: rule__RClass__Group_0__0__Impl rule__RClass__Group_0__1
            {
            pushFollow(FOLLOW_12);
            rule__RClass__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RClass__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__Group_0__0"


    // $ANTLR start "rule__RClass__Group_0__0__Impl"
    // InternalAle.g:1881:1: rule__RClass__Group_0__0__Impl : ( () ) ;
    public final void rule__RClass__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1885:1: ( ( () ) )
            // InternalAle.g:1886:1: ( () )
            {
            // InternalAle.g:1886:1: ( () )
            // InternalAle.g:1887:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getROpenClassAction_0_0()); 
            }
            // InternalAle.g:1888:2: ()
            // InternalAle.g:1888:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRClassAccess().getROpenClassAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__Group_0__0__Impl"


    // $ANTLR start "rule__RClass__Group_0__1"
    // InternalAle.g:1896:1: rule__RClass__Group_0__1 : rule__RClass__Group_0__1__Impl ;
    public final void rule__RClass__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1900:1: ( rule__RClass__Group_0__1__Impl )
            // InternalAle.g:1901:2: rule__RClass__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RClass__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__Group_0__1"


    // $ANTLR start "rule__RClass__Group_0__1__Impl"
    // InternalAle.g:1907:1: rule__RClass__Group_0__1__Impl : ( ( rule__RClass__OpenClassAssignment_0_1 ) ) ;
    public final void rule__RClass__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1911:1: ( ( ( rule__RClass__OpenClassAssignment_0_1 ) ) )
            // InternalAle.g:1912:1: ( ( rule__RClass__OpenClassAssignment_0_1 ) )
            {
            // InternalAle.g:1912:1: ( ( rule__RClass__OpenClassAssignment_0_1 ) )
            // InternalAle.g:1913:2: ( rule__RClass__OpenClassAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getOpenClassAssignment_0_1()); 
            }
            // InternalAle.g:1914:2: ( rule__RClass__OpenClassAssignment_0_1 )
            // InternalAle.g:1914:3: rule__RClass__OpenClassAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__RClass__OpenClassAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRClassAccess().getOpenClassAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__Group_0__1__Impl"


    // $ANTLR start "rule__RClass__Group_1__0"
    // InternalAle.g:1923:1: rule__RClass__Group_1__0 : rule__RClass__Group_1__0__Impl rule__RClass__Group_1__1 ;
    public final void rule__RClass__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1927:1: ( rule__RClass__Group_1__0__Impl rule__RClass__Group_1__1 )
            // InternalAle.g:1928:2: rule__RClass__Group_1__0__Impl rule__RClass__Group_1__1
            {
            pushFollow(FOLLOW_13);
            rule__RClass__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RClass__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__Group_1__0"


    // $ANTLR start "rule__RClass__Group_1__0__Impl"
    // InternalAle.g:1935:1: rule__RClass__Group_1__0__Impl : ( () ) ;
    public final void rule__RClass__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1939:1: ( ( () ) )
            // InternalAle.g:1940:1: ( () )
            {
            // InternalAle.g:1940:1: ( () )
            // InternalAle.g:1941:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getRNewClassAction_1_0()); 
            }
            // InternalAle.g:1942:2: ()
            // InternalAle.g:1942:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRClassAccess().getRNewClassAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__Group_1__0__Impl"


    // $ANTLR start "rule__RClass__Group_1__1"
    // InternalAle.g:1950:1: rule__RClass__Group_1__1 : rule__RClass__Group_1__1__Impl ;
    public final void rule__RClass__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1954:1: ( rule__RClass__Group_1__1__Impl )
            // InternalAle.g:1955:2: rule__RClass__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RClass__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__Group_1__1"


    // $ANTLR start "rule__RClass__Group_1__1__Impl"
    // InternalAle.g:1961:1: rule__RClass__Group_1__1__Impl : ( ( rule__RClass__NewClassAssignment_1_1 ) ) ;
    public final void rule__RClass__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1965:1: ( ( ( rule__RClass__NewClassAssignment_1_1 ) ) )
            // InternalAle.g:1966:1: ( ( rule__RClass__NewClassAssignment_1_1 ) )
            {
            // InternalAle.g:1966:1: ( ( rule__RClass__NewClassAssignment_1_1 ) )
            // InternalAle.g:1967:2: ( rule__RClass__NewClassAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getNewClassAssignment_1_1()); 
            }
            // InternalAle.g:1968:2: ( rule__RClass__NewClassAssignment_1_1 )
            // InternalAle.g:1968:3: rule__RClass__NewClassAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__RClass__NewClassAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRClassAccess().getNewClassAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__Group_1__1__Impl"


    // $ANTLR start "rule__ROpenClass__Group__0"
    // InternalAle.g:1977:1: rule__ROpenClass__Group__0 : rule__ROpenClass__Group__0__Impl rule__ROpenClass__Group__1 ;
    public final void rule__ROpenClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1981:1: ( rule__ROpenClass__Group__0__Impl rule__ROpenClass__Group__1 )
            // InternalAle.g:1982:2: rule__ROpenClass__Group__0__Impl rule__ROpenClass__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__ROpenClass__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__0"


    // $ANTLR start "rule__ROpenClass__Group__0__Impl"
    // InternalAle.g:1989:1: rule__ROpenClass__Group__0__Impl : ( 'open' ) ;
    public final void rule__ROpenClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1993:1: ( ( 'open' ) )
            // InternalAle.g:1994:1: ( 'open' )
            {
            // InternalAle.g:1994:1: ( 'open' )
            // InternalAle.g:1995:2: 'open'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getOpenKeyword_0()); 
            }
            match(input,38,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getOpenKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__0__Impl"


    // $ANTLR start "rule__ROpenClass__Group__1"
    // InternalAle.g:2004:1: rule__ROpenClass__Group__1 : rule__ROpenClass__Group__1__Impl rule__ROpenClass__Group__2 ;
    public final void rule__ROpenClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2008:1: ( rule__ROpenClass__Group__1__Impl rule__ROpenClass__Group__2 )
            // InternalAle.g:2009:2: rule__ROpenClass__Group__1__Impl rule__ROpenClass__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__ROpenClass__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__1"


    // $ANTLR start "rule__ROpenClass__Group__1__Impl"
    // InternalAle.g:2016:1: rule__ROpenClass__Group__1__Impl : ( 'class' ) ;
    public final void rule__ROpenClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2020:1: ( ( 'class' ) )
            // InternalAle.g:2021:1: ( 'class' )
            {
            // InternalAle.g:2021:1: ( 'class' )
            // InternalAle.g:2022:2: 'class'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getClassKeyword_1()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getClassKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__1__Impl"


    // $ANTLR start "rule__ROpenClass__Group__2"
    // InternalAle.g:2031:1: rule__ROpenClass__Group__2 : rule__ROpenClass__Group__2__Impl rule__ROpenClass__Group__3 ;
    public final void rule__ROpenClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2035:1: ( rule__ROpenClass__Group__2__Impl rule__ROpenClass__Group__3 )
            // InternalAle.g:2036:2: rule__ROpenClass__Group__2__Impl rule__ROpenClass__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__ROpenClass__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__2"


    // $ANTLR start "rule__ROpenClass__Group__2__Impl"
    // InternalAle.g:2043:1: rule__ROpenClass__Group__2__Impl : ( ( rule__ROpenClass__NameAssignment_2 ) ) ;
    public final void rule__ROpenClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2047:1: ( ( ( rule__ROpenClass__NameAssignment_2 ) ) )
            // InternalAle.g:2048:1: ( ( rule__ROpenClass__NameAssignment_2 ) )
            {
            // InternalAle.g:2048:1: ( ( rule__ROpenClass__NameAssignment_2 ) )
            // InternalAle.g:2049:2: ( rule__ROpenClass__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getNameAssignment_2()); 
            }
            // InternalAle.g:2050:2: ( rule__ROpenClass__NameAssignment_2 )
            // InternalAle.g:2050:3: rule__ROpenClass__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ROpenClass__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__2__Impl"


    // $ANTLR start "rule__ROpenClass__Group__3"
    // InternalAle.g:2058:1: rule__ROpenClass__Group__3 : rule__ROpenClass__Group__3__Impl rule__ROpenClass__Group__4 ;
    public final void rule__ROpenClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2062:1: ( rule__ROpenClass__Group__3__Impl rule__ROpenClass__Group__4 )
            // InternalAle.g:2063:2: rule__ROpenClass__Group__3__Impl rule__ROpenClass__Group__4
            {
            pushFollow(FOLLOW_15);
            rule__ROpenClass__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__3"


    // $ANTLR start "rule__ROpenClass__Group__3__Impl"
    // InternalAle.g:2070:1: rule__ROpenClass__Group__3__Impl : ( ( rule__ROpenClass__Group_3__0 )? ) ;
    public final void rule__ROpenClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2074:1: ( ( ( rule__ROpenClass__Group_3__0 )? ) )
            // InternalAle.g:2075:1: ( ( rule__ROpenClass__Group_3__0 )? )
            {
            // InternalAle.g:2075:1: ( ( rule__ROpenClass__Group_3__0 )? )
            // InternalAle.g:2076:2: ( rule__ROpenClass__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getGroup_3()); 
            }
            // InternalAle.g:2077:2: ( rule__ROpenClass__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==42) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAle.g:2077:3: rule__ROpenClass__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ROpenClass__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__3__Impl"


    // $ANTLR start "rule__ROpenClass__Group__4"
    // InternalAle.g:2085:1: rule__ROpenClass__Group__4 : rule__ROpenClass__Group__4__Impl rule__ROpenClass__Group__5 ;
    public final void rule__ROpenClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2089:1: ( rule__ROpenClass__Group__4__Impl rule__ROpenClass__Group__5 )
            // InternalAle.g:2090:2: rule__ROpenClass__Group__4__Impl rule__ROpenClass__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__ROpenClass__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__4"


    // $ANTLR start "rule__ROpenClass__Group__4__Impl"
    // InternalAle.g:2097:1: rule__ROpenClass__Group__4__Impl : ( '{' ) ;
    public final void rule__ROpenClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2101:1: ( ( '{' ) )
            // InternalAle.g:2102:1: ( '{' )
            {
            // InternalAle.g:2102:1: ( '{' )
            // InternalAle.g:2103:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getLeftCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__4__Impl"


    // $ANTLR start "rule__ROpenClass__Group__5"
    // InternalAle.g:2112:1: rule__ROpenClass__Group__5 : rule__ROpenClass__Group__5__Impl rule__ROpenClass__Group__6 ;
    public final void rule__ROpenClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2116:1: ( rule__ROpenClass__Group__5__Impl rule__ROpenClass__Group__6 )
            // InternalAle.g:2117:2: rule__ROpenClass__Group__5__Impl rule__ROpenClass__Group__6
            {
            pushFollow(FOLLOW_16);
            rule__ROpenClass__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__5"


    // $ANTLR start "rule__ROpenClass__Group__5__Impl"
    // InternalAle.g:2124:1: rule__ROpenClass__Group__5__Impl : ( ( rule__ROpenClass__AttributesAssignment_5 )* ) ;
    public final void rule__ROpenClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2128:1: ( ( ( rule__ROpenClass__AttributesAssignment_5 )* ) )
            // InternalAle.g:2129:1: ( ( rule__ROpenClass__AttributesAssignment_5 )* )
            {
            // InternalAle.g:2129:1: ( ( rule__ROpenClass__AttributesAssignment_5 )* )
            // InternalAle.g:2130:2: ( rule__ROpenClass__AttributesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getAttributesAssignment_5()); 
            }
            // InternalAle.g:2131:2: ( rule__ROpenClass__AttributesAssignment_5 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_IDENT||LA20_0==40||(LA20_0>=72 && LA20_0<=77)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalAle.g:2131:3: rule__ROpenClass__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__ROpenClass__AttributesAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getAttributesAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__5__Impl"


    // $ANTLR start "rule__ROpenClass__Group__6"
    // InternalAle.g:2139:1: rule__ROpenClass__Group__6 : rule__ROpenClass__Group__6__Impl rule__ROpenClass__Group__7 ;
    public final void rule__ROpenClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2143:1: ( rule__ROpenClass__Group__6__Impl rule__ROpenClass__Group__7 )
            // InternalAle.g:2144:2: rule__ROpenClass__Group__6__Impl rule__ROpenClass__Group__7
            {
            pushFollow(FOLLOW_16);
            rule__ROpenClass__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__6"


    // $ANTLR start "rule__ROpenClass__Group__6__Impl"
    // InternalAle.g:2151:1: rule__ROpenClass__Group__6__Impl : ( ( rule__ROpenClass__OperationsAssignment_6 )* ) ;
    public final void rule__ROpenClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2155:1: ( ( ( rule__ROpenClass__OperationsAssignment_6 )* ) )
            // InternalAle.g:2156:1: ( ( rule__ROpenClass__OperationsAssignment_6 )* )
            {
            // InternalAle.g:2156:1: ( ( rule__ROpenClass__OperationsAssignment_6 )* )
            // InternalAle.g:2157:2: ( rule__ROpenClass__OperationsAssignment_6 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getOperationsAssignment_6()); 
            }
            // InternalAle.g:2158:2: ( rule__ROpenClass__OperationsAssignment_6 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=17 && LA21_0<=18)||LA21_0==46) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAle.g:2158:3: rule__ROpenClass__OperationsAssignment_6
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__ROpenClass__OperationsAssignment_6();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getOperationsAssignment_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__6__Impl"


    // $ANTLR start "rule__ROpenClass__Group__7"
    // InternalAle.g:2166:1: rule__ROpenClass__Group__7 : rule__ROpenClass__Group__7__Impl ;
    public final void rule__ROpenClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2170:1: ( rule__ROpenClass__Group__7__Impl )
            // InternalAle.g:2171:2: rule__ROpenClass__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__7"


    // $ANTLR start "rule__ROpenClass__Group__7__Impl"
    // InternalAle.g:2177:1: rule__ROpenClass__Group__7__Impl : ( '}' ) ;
    public final void rule__ROpenClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2181:1: ( ( '}' ) )
            // InternalAle.g:2182:1: ( '}' )
            {
            // InternalAle.g:2182:1: ( '}' )
            // InternalAle.g:2183:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getRightCurlyBracketKeyword_7()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getRightCurlyBracketKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group__7__Impl"


    // $ANTLR start "rule__ROpenClass__Group_3__0"
    // InternalAle.g:2193:1: rule__ROpenClass__Group_3__0 : rule__ROpenClass__Group_3__0__Impl rule__ROpenClass__Group_3__1 ;
    public final void rule__ROpenClass__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2197:1: ( rule__ROpenClass__Group_3__0__Impl rule__ROpenClass__Group_3__1 )
            // InternalAle.g:2198:2: rule__ROpenClass__Group_3__0__Impl rule__ROpenClass__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__ROpenClass__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3__0"


    // $ANTLR start "rule__ROpenClass__Group_3__0__Impl"
    // InternalAle.g:2205:1: rule__ROpenClass__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__ROpenClass__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2209:1: ( ( 'extends' ) )
            // InternalAle.g:2210:1: ( 'extends' )
            {
            // InternalAle.g:2210:1: ( 'extends' )
            // InternalAle.g:2211:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getExtendsKeyword_3_0()); 
            }
            match(input,42,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getExtendsKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3__0__Impl"


    // $ANTLR start "rule__ROpenClass__Group_3__1"
    // InternalAle.g:2220:1: rule__ROpenClass__Group_3__1 : rule__ROpenClass__Group_3__1__Impl rule__ROpenClass__Group_3__2 ;
    public final void rule__ROpenClass__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2224:1: ( rule__ROpenClass__Group_3__1__Impl rule__ROpenClass__Group_3__2 )
            // InternalAle.g:2225:2: rule__ROpenClass__Group_3__1__Impl rule__ROpenClass__Group_3__2
            {
            pushFollow(FOLLOW_19);
            rule__ROpenClass__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group_3__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3__1"


    // $ANTLR start "rule__ROpenClass__Group_3__1__Impl"
    // InternalAle.g:2232:1: rule__ROpenClass__Group_3__1__Impl : ( rulerQualified ) ;
    public final void rule__ROpenClass__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2236:1: ( ( rulerQualified ) )
            // InternalAle.g:2237:1: ( rulerQualified )
            {
            // InternalAle.g:2237:1: ( rulerQualified )
            // InternalAle.g:2238:2: rulerQualified
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getRQualifiedParserRuleCall_3_1()); 
            }
            pushFollow(FOLLOW_2);
            rulerQualified();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getRQualifiedParserRuleCall_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3__1__Impl"


    // $ANTLR start "rule__ROpenClass__Group_3__2"
    // InternalAle.g:2247:1: rule__ROpenClass__Group_3__2 : rule__ROpenClass__Group_3__2__Impl ;
    public final void rule__ROpenClass__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2251:1: ( rule__ROpenClass__Group_3__2__Impl )
            // InternalAle.g:2252:2: rule__ROpenClass__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3__2"


    // $ANTLR start "rule__ROpenClass__Group_3__2__Impl"
    // InternalAle.g:2258:1: rule__ROpenClass__Group_3__2__Impl : ( ( rule__ROpenClass__Group_3_2__0 )* ) ;
    public final void rule__ROpenClass__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2262:1: ( ( ( rule__ROpenClass__Group_3_2__0 )* ) )
            // InternalAle.g:2263:1: ( ( rule__ROpenClass__Group_3_2__0 )* )
            {
            // InternalAle.g:2263:1: ( ( rule__ROpenClass__Group_3_2__0 )* )
            // InternalAle.g:2264:2: ( rule__ROpenClass__Group_3_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getGroup_3_2()); 
            }
            // InternalAle.g:2265:2: ( rule__ROpenClass__Group_3_2__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==43) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalAle.g:2265:3: rule__ROpenClass__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__ROpenClass__Group_3_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getGroup_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3__2__Impl"


    // $ANTLR start "rule__ROpenClass__Group_3_2__0"
    // InternalAle.g:2274:1: rule__ROpenClass__Group_3_2__0 : rule__ROpenClass__Group_3_2__0__Impl rule__ROpenClass__Group_3_2__1 ;
    public final void rule__ROpenClass__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2278:1: ( rule__ROpenClass__Group_3_2__0__Impl rule__ROpenClass__Group_3_2__1 )
            // InternalAle.g:2279:2: rule__ROpenClass__Group_3_2__0__Impl rule__ROpenClass__Group_3_2__1
            {
            pushFollow(FOLLOW_3);
            rule__ROpenClass__Group_3_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group_3_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3_2__0"


    // $ANTLR start "rule__ROpenClass__Group_3_2__0__Impl"
    // InternalAle.g:2286:1: rule__ROpenClass__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__ROpenClass__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2290:1: ( ( ',' ) )
            // InternalAle.g:2291:1: ( ',' )
            {
            // InternalAle.g:2291:1: ( ',' )
            // InternalAle.g:2292:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getCommaKeyword_3_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3_2__0__Impl"


    // $ANTLR start "rule__ROpenClass__Group_3_2__1"
    // InternalAle.g:2301:1: rule__ROpenClass__Group_3_2__1 : rule__ROpenClass__Group_3_2__1__Impl ;
    public final void rule__ROpenClass__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2305:1: ( rule__ROpenClass__Group_3_2__1__Impl )
            // InternalAle.g:2306:2: rule__ROpenClass__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ROpenClass__Group_3_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3_2__1"


    // $ANTLR start "rule__ROpenClass__Group_3_2__1__Impl"
    // InternalAle.g:2312:1: rule__ROpenClass__Group_3_2__1__Impl : ( rulerQualified ) ;
    public final void rule__ROpenClass__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2316:1: ( ( rulerQualified ) )
            // InternalAle.g:2317:1: ( rulerQualified )
            {
            // InternalAle.g:2317:1: ( rulerQualified )
            // InternalAle.g:2318:2: rulerQualified
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getRQualifiedParserRuleCall_3_2_1()); 
            }
            pushFollow(FOLLOW_2);
            rulerQualified();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getRQualifiedParserRuleCall_3_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__Group_3_2__1__Impl"


    // $ANTLR start "rule__RNewClass__Group__0"
    // InternalAle.g:2328:1: rule__RNewClass__Group__0 : rule__RNewClass__Group__0__Impl rule__RNewClass__Group__1 ;
    public final void rule__RNewClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2332:1: ( rule__RNewClass__Group__0__Impl rule__RNewClass__Group__1 )
            // InternalAle.g:2333:2: rule__RNewClass__Group__0__Impl rule__RNewClass__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RNewClass__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RNewClass__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__0"


    // $ANTLR start "rule__RNewClass__Group__0__Impl"
    // InternalAle.g:2340:1: rule__RNewClass__Group__0__Impl : ( 'class' ) ;
    public final void rule__RNewClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2344:1: ( ( 'class' ) )
            // InternalAle.g:2345:1: ( 'class' )
            {
            // InternalAle.g:2345:1: ( 'class' )
            // InternalAle.g:2346:2: 'class'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getClassKeyword_0()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getClassKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__0__Impl"


    // $ANTLR start "rule__RNewClass__Group__1"
    // InternalAle.g:2355:1: rule__RNewClass__Group__1 : rule__RNewClass__Group__1__Impl rule__RNewClass__Group__2 ;
    public final void rule__RNewClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2359:1: ( rule__RNewClass__Group__1__Impl rule__RNewClass__Group__2 )
            // InternalAle.g:2360:2: rule__RNewClass__Group__1__Impl rule__RNewClass__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__RNewClass__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RNewClass__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__1"


    // $ANTLR start "rule__RNewClass__Group__1__Impl"
    // InternalAle.g:2367:1: rule__RNewClass__Group__1__Impl : ( ( rule__RNewClass__NameAssignment_1 ) ) ;
    public final void rule__RNewClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2371:1: ( ( ( rule__RNewClass__NameAssignment_1 ) ) )
            // InternalAle.g:2372:1: ( ( rule__RNewClass__NameAssignment_1 ) )
            {
            // InternalAle.g:2372:1: ( ( rule__RNewClass__NameAssignment_1 ) )
            // InternalAle.g:2373:2: ( rule__RNewClass__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getNameAssignment_1()); 
            }
            // InternalAle.g:2374:2: ( rule__RNewClass__NameAssignment_1 )
            // InternalAle.g:2374:3: rule__RNewClass__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RNewClass__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__1__Impl"


    // $ANTLR start "rule__RNewClass__Group__2"
    // InternalAle.g:2382:1: rule__RNewClass__Group__2 : rule__RNewClass__Group__2__Impl rule__RNewClass__Group__3 ;
    public final void rule__RNewClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2386:1: ( rule__RNewClass__Group__2__Impl rule__RNewClass__Group__3 )
            // InternalAle.g:2387:2: rule__RNewClass__Group__2__Impl rule__RNewClass__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__RNewClass__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RNewClass__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__2"


    // $ANTLR start "rule__RNewClass__Group__2__Impl"
    // InternalAle.g:2394:1: rule__RNewClass__Group__2__Impl : ( '{' ) ;
    public final void rule__RNewClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2398:1: ( ( '{' ) )
            // InternalAle.g:2399:1: ( '{' )
            {
            // InternalAle.g:2399:1: ( '{' )
            // InternalAle.g:2400:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__2__Impl"


    // $ANTLR start "rule__RNewClass__Group__3"
    // InternalAle.g:2409:1: rule__RNewClass__Group__3 : rule__RNewClass__Group__3__Impl rule__RNewClass__Group__4 ;
    public final void rule__RNewClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2413:1: ( rule__RNewClass__Group__3__Impl rule__RNewClass__Group__4 )
            // InternalAle.g:2414:2: rule__RNewClass__Group__3__Impl rule__RNewClass__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__RNewClass__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RNewClass__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__3"


    // $ANTLR start "rule__RNewClass__Group__3__Impl"
    // InternalAle.g:2421:1: rule__RNewClass__Group__3__Impl : ( ( rule__RNewClass__AttributesAssignment_3 )* ) ;
    public final void rule__RNewClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2425:1: ( ( ( rule__RNewClass__AttributesAssignment_3 )* ) )
            // InternalAle.g:2426:1: ( ( rule__RNewClass__AttributesAssignment_3 )* )
            {
            // InternalAle.g:2426:1: ( ( rule__RNewClass__AttributesAssignment_3 )* )
            // InternalAle.g:2427:2: ( rule__RNewClass__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getAttributesAssignment_3()); 
            }
            // InternalAle.g:2428:2: ( rule__RNewClass__AttributesAssignment_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_IDENT||LA23_0==40||(LA23_0>=72 && LA23_0<=77)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalAle.g:2428:3: rule__RNewClass__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__RNewClass__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getAttributesAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__3__Impl"


    // $ANTLR start "rule__RNewClass__Group__4"
    // InternalAle.g:2436:1: rule__RNewClass__Group__4 : rule__RNewClass__Group__4__Impl rule__RNewClass__Group__5 ;
    public final void rule__RNewClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2440:1: ( rule__RNewClass__Group__4__Impl rule__RNewClass__Group__5 )
            // InternalAle.g:2441:2: rule__RNewClass__Group__4__Impl rule__RNewClass__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__RNewClass__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RNewClass__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__4"


    // $ANTLR start "rule__RNewClass__Group__4__Impl"
    // InternalAle.g:2448:1: rule__RNewClass__Group__4__Impl : ( ( rule__RNewClass__OperationsAssignment_4 )* ) ;
    public final void rule__RNewClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2452:1: ( ( ( rule__RNewClass__OperationsAssignment_4 )* ) )
            // InternalAle.g:2453:1: ( ( rule__RNewClass__OperationsAssignment_4 )* )
            {
            // InternalAle.g:2453:1: ( ( rule__RNewClass__OperationsAssignment_4 )* )
            // InternalAle.g:2454:2: ( rule__RNewClass__OperationsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getOperationsAssignment_4()); 
            }
            // InternalAle.g:2455:2: ( rule__RNewClass__OperationsAssignment_4 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=17 && LA24_0<=18)||LA24_0==46) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalAle.g:2455:3: rule__RNewClass__OperationsAssignment_4
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__RNewClass__OperationsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getOperationsAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__4__Impl"


    // $ANTLR start "rule__RNewClass__Group__5"
    // InternalAle.g:2463:1: rule__RNewClass__Group__5 : rule__RNewClass__Group__5__Impl ;
    public final void rule__RNewClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2467:1: ( rule__RNewClass__Group__5__Impl )
            // InternalAle.g:2468:2: rule__RNewClass__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RNewClass__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__5"


    // $ANTLR start "rule__RNewClass__Group__5__Impl"
    // InternalAle.g:2474:1: rule__RNewClass__Group__5__Impl : ( '}' ) ;
    public final void rule__RNewClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2478:1: ( ( '}' ) )
            // InternalAle.g:2479:1: ( '}' )
            {
            // InternalAle.g:2479:1: ( '}' )
            // InternalAle.g:2480:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__Group__5__Impl"


    // $ANTLR start "rule__ROperation__Group__0"
    // InternalAle.g:2490:1: rule__ROperation__Group__0 : rule__ROperation__Group__0__Impl rule__ROperation__Group__1 ;
    public final void rule__ROperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2494:1: ( rule__ROperation__Group__0__Impl rule__ROperation__Group__1 )
            // InternalAle.g:2495:2: rule__ROperation__Group__0__Impl rule__ROperation__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__ROperation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROperation__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__0"


    // $ANTLR start "rule__ROperation__Group__0__Impl"
    // InternalAle.g:2502:1: rule__ROperation__Group__0__Impl : ( ( rulerTag )* ) ;
    public final void rule__ROperation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2506:1: ( ( ( rulerTag )* ) )
            // InternalAle.g:2507:1: ( ( rulerTag )* )
            {
            // InternalAle.g:2507:1: ( ( rulerTag )* )
            // InternalAle.g:2508:2: ( rulerTag )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getRTagParserRuleCall_0()); 
            }
            // InternalAle.g:2509:2: ( rulerTag )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==46) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalAle.g:2509:3: rulerTag
            	    {
            	    pushFollow(FOLLOW_23);
            	    rulerTag();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getRTagParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__0__Impl"


    // $ANTLR start "rule__ROperation__Group__1"
    // InternalAle.g:2517:1: rule__ROperation__Group__1 : rule__ROperation__Group__1__Impl rule__ROperation__Group__2 ;
    public final void rule__ROperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2521:1: ( rule__ROperation__Group__1__Impl rule__ROperation__Group__2 )
            // InternalAle.g:2522:2: rule__ROperation__Group__1__Impl rule__ROperation__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__ROperation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROperation__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__1"


    // $ANTLR start "rule__ROperation__Group__1__Impl"
    // InternalAle.g:2529:1: rule__ROperation__Group__1__Impl : ( ( rule__ROperation__Alternatives_1 ) ) ;
    public final void rule__ROperation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2533:1: ( ( ( rule__ROperation__Alternatives_1 ) ) )
            // InternalAle.g:2534:1: ( ( rule__ROperation__Alternatives_1 ) )
            {
            // InternalAle.g:2534:1: ( ( rule__ROperation__Alternatives_1 ) )
            // InternalAle.g:2535:2: ( rule__ROperation__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getAlternatives_1()); 
            }
            // InternalAle.g:2536:2: ( rule__ROperation__Alternatives_1 )
            // InternalAle.g:2536:3: rule__ROperation__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__ROperation__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__1__Impl"


    // $ANTLR start "rule__ROperation__Group__2"
    // InternalAle.g:2544:1: rule__ROperation__Group__2 : rule__ROperation__Group__2__Impl rule__ROperation__Group__3 ;
    public final void rule__ROperation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2548:1: ( rule__ROperation__Group__2__Impl rule__ROperation__Group__3 )
            // InternalAle.g:2549:2: rule__ROperation__Group__2__Impl rule__ROperation__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__ROperation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROperation__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__2"


    // $ANTLR start "rule__ROperation__Group__2__Impl"
    // InternalAle.g:2556:1: rule__ROperation__Group__2__Impl : ( ( rule__ROperation__TypeAssignment_2 ) ) ;
    public final void rule__ROperation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2560:1: ( ( ( rule__ROperation__TypeAssignment_2 ) ) )
            // InternalAle.g:2561:1: ( ( rule__ROperation__TypeAssignment_2 ) )
            {
            // InternalAle.g:2561:1: ( ( rule__ROperation__TypeAssignment_2 ) )
            // InternalAle.g:2562:2: ( rule__ROperation__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getTypeAssignment_2()); 
            }
            // InternalAle.g:2563:2: ( rule__ROperation__TypeAssignment_2 )
            // InternalAle.g:2563:3: rule__ROperation__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ROperation__TypeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getTypeAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__2__Impl"


    // $ANTLR start "rule__ROperation__Group__3"
    // InternalAle.g:2571:1: rule__ROperation__Group__3 : rule__ROperation__Group__3__Impl rule__ROperation__Group__4 ;
    public final void rule__ROperation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2575:1: ( rule__ROperation__Group__3__Impl rule__ROperation__Group__4 )
            // InternalAle.g:2576:2: rule__ROperation__Group__3__Impl rule__ROperation__Group__4
            {
            pushFollow(FOLLOW_25);
            rule__ROperation__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROperation__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__3"


    // $ANTLR start "rule__ROperation__Group__3__Impl"
    // InternalAle.g:2583:1: rule__ROperation__Group__3__Impl : ( ( rule__ROperation__NameAssignment_3 ) ) ;
    public final void rule__ROperation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2587:1: ( ( ( rule__ROperation__NameAssignment_3 ) ) )
            // InternalAle.g:2588:1: ( ( rule__ROperation__NameAssignment_3 ) )
            {
            // InternalAle.g:2588:1: ( ( rule__ROperation__NameAssignment_3 ) )
            // InternalAle.g:2589:2: ( rule__ROperation__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getNameAssignment_3()); 
            }
            // InternalAle.g:2590:2: ( rule__ROperation__NameAssignment_3 )
            // InternalAle.g:2590:3: rule__ROperation__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ROperation__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__3__Impl"


    // $ANTLR start "rule__ROperation__Group__4"
    // InternalAle.g:2598:1: rule__ROperation__Group__4 : rule__ROperation__Group__4__Impl rule__ROperation__Group__5 ;
    public final void rule__ROperation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2602:1: ( rule__ROperation__Group__4__Impl rule__ROperation__Group__5 )
            // InternalAle.g:2603:2: rule__ROperation__Group__4__Impl rule__ROperation__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__ROperation__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROperation__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__4"


    // $ANTLR start "rule__ROperation__Group__4__Impl"
    // InternalAle.g:2610:1: rule__ROperation__Group__4__Impl : ( '(' ) ;
    public final void rule__ROperation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2614:1: ( ( '(' ) )
            // InternalAle.g:2615:1: ( '(' )
            {
            // InternalAle.g:2615:1: ( '(' )
            // InternalAle.g:2616:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getLeftParenthesisKeyword_4()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getLeftParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__4__Impl"


    // $ANTLR start "rule__ROperation__Group__5"
    // InternalAle.g:2625:1: rule__ROperation__Group__5 : rule__ROperation__Group__5__Impl rule__ROperation__Group__6 ;
    public final void rule__ROperation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2629:1: ( rule__ROperation__Group__5__Impl rule__ROperation__Group__6 )
            // InternalAle.g:2630:2: rule__ROperation__Group__5__Impl rule__ROperation__Group__6
            {
            pushFollow(FOLLOW_26);
            rule__ROperation__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROperation__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__5"


    // $ANTLR start "rule__ROperation__Group__5__Impl"
    // InternalAle.g:2637:1: rule__ROperation__Group__5__Impl : ( ( rule__ROperation__ParamListAssignment_5 )? ) ;
    public final void rule__ROperation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2641:1: ( ( ( rule__ROperation__ParamListAssignment_5 )? ) )
            // InternalAle.g:2642:1: ( ( rule__ROperation__ParamListAssignment_5 )? )
            {
            // InternalAle.g:2642:1: ( ( rule__ROperation__ParamListAssignment_5 )? )
            // InternalAle.g:2643:2: ( rule__ROperation__ParamListAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getParamListAssignment_5()); 
            }
            // InternalAle.g:2644:2: ( rule__ROperation__ParamListAssignment_5 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_IDENT||LA26_0==40||(LA26_0>=72 && LA26_0<=77)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAle.g:2644:3: rule__ROperation__ParamListAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__ROperation__ParamListAssignment_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getParamListAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__5__Impl"


    // $ANTLR start "rule__ROperation__Group__6"
    // InternalAle.g:2652:1: rule__ROperation__Group__6 : rule__ROperation__Group__6__Impl rule__ROperation__Group__7 ;
    public final void rule__ROperation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2656:1: ( rule__ROperation__Group__6__Impl rule__ROperation__Group__7 )
            // InternalAle.g:2657:2: rule__ROperation__Group__6__Impl rule__ROperation__Group__7
            {
            pushFollow(FOLLOW_21);
            rule__ROperation__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ROperation__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__6"


    // $ANTLR start "rule__ROperation__Group__6__Impl"
    // InternalAle.g:2664:1: rule__ROperation__Group__6__Impl : ( ')' ) ;
    public final void rule__ROperation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2668:1: ( ( ')' ) )
            // InternalAle.g:2669:1: ( ')' )
            {
            // InternalAle.g:2669:1: ( ')' )
            // InternalAle.g:2670:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getRightParenthesisKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__6__Impl"


    // $ANTLR start "rule__ROperation__Group__7"
    // InternalAle.g:2679:1: rule__ROperation__Group__7 : rule__ROperation__Group__7__Impl ;
    public final void rule__ROperation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2683:1: ( rule__ROperation__Group__7__Impl )
            // InternalAle.g:2684:2: rule__ROperation__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ROperation__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__7"


    // $ANTLR start "rule__ROperation__Group__7__Impl"
    // InternalAle.g:2690:1: rule__ROperation__Group__7__Impl : ( ( rule__ROperation__BodyAssignment_7 ) ) ;
    public final void rule__ROperation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2694:1: ( ( ( rule__ROperation__BodyAssignment_7 ) ) )
            // InternalAle.g:2695:1: ( ( rule__ROperation__BodyAssignment_7 ) )
            {
            // InternalAle.g:2695:1: ( ( rule__ROperation__BodyAssignment_7 ) )
            // InternalAle.g:2696:2: ( rule__ROperation__BodyAssignment_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getBodyAssignment_7()); 
            }
            // InternalAle.g:2697:2: ( rule__ROperation__BodyAssignment_7 )
            // InternalAle.g:2697:3: rule__ROperation__BodyAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__ROperation__BodyAssignment_7();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getBodyAssignment_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__Group__7__Impl"


    // $ANTLR start "rule__RTag__Group__0"
    // InternalAle.g:2706:1: rule__RTag__Group__0 : rule__RTag__Group__0__Impl rule__RTag__Group__1 ;
    public final void rule__RTag__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2710:1: ( rule__RTag__Group__0__Impl rule__RTag__Group__1 )
            // InternalAle.g:2711:2: rule__RTag__Group__0__Impl rule__RTag__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RTag__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RTag__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RTag__Group__0"


    // $ANTLR start "rule__RTag__Group__0__Impl"
    // InternalAle.g:2718:1: rule__RTag__Group__0__Impl : ( '@' ) ;
    public final void rule__RTag__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2722:1: ( ( '@' ) )
            // InternalAle.g:2723:1: ( '@' )
            {
            // InternalAle.g:2723:1: ( '@' )
            // InternalAle.g:2724:2: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTagAccess().getCommercialAtKeyword_0()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRTagAccess().getCommercialAtKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RTag__Group__0__Impl"


    // $ANTLR start "rule__RTag__Group__1"
    // InternalAle.g:2733:1: rule__RTag__Group__1 : rule__RTag__Group__1__Impl ;
    public final void rule__RTag__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2737:1: ( rule__RTag__Group__1__Impl )
            // InternalAle.g:2738:2: rule__RTag__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RTag__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RTag__Group__1"


    // $ANTLR start "rule__RTag__Group__1__Impl"
    // InternalAle.g:2744:1: rule__RTag__Group__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RTag__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2748:1: ( ( RULE_IDENT ) )
            // InternalAle.g:2749:1: ( RULE_IDENT )
            {
            // InternalAle.g:2749:1: ( RULE_IDENT )
            // InternalAle.g:2750:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTagAccess().getIDENTTerminalRuleCall_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRTagAccess().getIDENTTerminalRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RTag__Group__1__Impl"


    // $ANTLR start "rule__RParameters__Group__0"
    // InternalAle.g:2760:1: rule__RParameters__Group__0 : rule__RParameters__Group__0__Impl rule__RParameters__Group__1 ;
    public final void rule__RParameters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2764:1: ( rule__RParameters__Group__0__Impl rule__RParameters__Group__1 )
            // InternalAle.g:2765:2: rule__RParameters__Group__0__Impl rule__RParameters__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__RParameters__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RParameters__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__Group__0"


    // $ANTLR start "rule__RParameters__Group__0__Impl"
    // InternalAle.g:2772:1: rule__RParameters__Group__0__Impl : ( ( rule__RParameters__ParamsAssignment_0 ) ) ;
    public final void rule__RParameters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2776:1: ( ( ( rule__RParameters__ParamsAssignment_0 ) ) )
            // InternalAle.g:2777:1: ( ( rule__RParameters__ParamsAssignment_0 ) )
            {
            // InternalAle.g:2777:1: ( ( rule__RParameters__ParamsAssignment_0 ) )
            // InternalAle.g:2778:2: ( rule__RParameters__ParamsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getParamsAssignment_0()); 
            }
            // InternalAle.g:2779:2: ( rule__RParameters__ParamsAssignment_0 )
            // InternalAle.g:2779:3: rule__RParameters__ParamsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RParameters__ParamsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRParametersAccess().getParamsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__Group__0__Impl"


    // $ANTLR start "rule__RParameters__Group__1"
    // InternalAle.g:2787:1: rule__RParameters__Group__1 : rule__RParameters__Group__1__Impl ;
    public final void rule__RParameters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2791:1: ( rule__RParameters__Group__1__Impl )
            // InternalAle.g:2792:2: rule__RParameters__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RParameters__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__Group__1"


    // $ANTLR start "rule__RParameters__Group__1__Impl"
    // InternalAle.g:2798:1: rule__RParameters__Group__1__Impl : ( ( rule__RParameters__Group_1__0 )* ) ;
    public final void rule__RParameters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2802:1: ( ( ( rule__RParameters__Group_1__0 )* ) )
            // InternalAle.g:2803:1: ( ( rule__RParameters__Group_1__0 )* )
            {
            // InternalAle.g:2803:1: ( ( rule__RParameters__Group_1__0 )* )
            // InternalAle.g:2804:2: ( rule__RParameters__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getGroup_1()); 
            }
            // InternalAle.g:2805:2: ( rule__RParameters__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==43) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalAle.g:2805:3: rule__RParameters__Group_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__RParameters__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRParametersAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__Group__1__Impl"


    // $ANTLR start "rule__RParameters__Group_1__0"
    // InternalAle.g:2814:1: rule__RParameters__Group_1__0 : rule__RParameters__Group_1__0__Impl rule__RParameters__Group_1__1 ;
    public final void rule__RParameters__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2818:1: ( rule__RParameters__Group_1__0__Impl rule__RParameters__Group_1__1 )
            // InternalAle.g:2819:2: rule__RParameters__Group_1__0__Impl rule__RParameters__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__RParameters__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RParameters__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__Group_1__0"


    // $ANTLR start "rule__RParameters__Group_1__0__Impl"
    // InternalAle.g:2826:1: rule__RParameters__Group_1__0__Impl : ( ',' ) ;
    public final void rule__RParameters__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2830:1: ( ( ',' ) )
            // InternalAle.g:2831:1: ( ',' )
            {
            // InternalAle.g:2831:1: ( ',' )
            // InternalAle.g:2832:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getCommaKeyword_1_0()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRParametersAccess().getCommaKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__Group_1__0__Impl"


    // $ANTLR start "rule__RParameters__Group_1__1"
    // InternalAle.g:2841:1: rule__RParameters__Group_1__1 : rule__RParameters__Group_1__1__Impl ;
    public final void rule__RParameters__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2845:1: ( rule__RParameters__Group_1__1__Impl )
            // InternalAle.g:2846:2: rule__RParameters__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RParameters__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__Group_1__1"


    // $ANTLR start "rule__RParameters__Group_1__1__Impl"
    // InternalAle.g:2852:1: rule__RParameters__Group_1__1__Impl : ( ( rule__RParameters__ParamsAssignment_1_1 ) ) ;
    public final void rule__RParameters__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2856:1: ( ( ( rule__RParameters__ParamsAssignment_1_1 ) ) )
            // InternalAle.g:2857:1: ( ( rule__RParameters__ParamsAssignment_1_1 ) )
            {
            // InternalAle.g:2857:1: ( ( rule__RParameters__ParamsAssignment_1_1 ) )
            // InternalAle.g:2858:2: ( rule__RParameters__ParamsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getParamsAssignment_1_1()); 
            }
            // InternalAle.g:2859:2: ( rule__RParameters__ParamsAssignment_1_1 )
            // InternalAle.g:2859:3: rule__RParameters__ParamsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__RParameters__ParamsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRParametersAccess().getParamsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__Group_1__1__Impl"


    // $ANTLR start "rule__RVariable__Group__0"
    // InternalAle.g:2868:1: rule__RVariable__Group__0 : rule__RVariable__Group__0__Impl rule__RVariable__Group__1 ;
    public final void rule__RVariable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2872:1: ( rule__RVariable__Group__0__Impl rule__RVariable__Group__1 )
            // InternalAle.g:2873:2: rule__RVariable__Group__0__Impl rule__RVariable__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RVariable__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RVariable__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVariable__Group__0"


    // $ANTLR start "rule__RVariable__Group__0__Impl"
    // InternalAle.g:2880:1: rule__RVariable__Group__0__Impl : ( ( rule__RVariable__TypeAssignment_0 ) ) ;
    public final void rule__RVariable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2884:1: ( ( ( rule__RVariable__TypeAssignment_0 ) ) )
            // InternalAle.g:2885:1: ( ( rule__RVariable__TypeAssignment_0 ) )
            {
            // InternalAle.g:2885:1: ( ( rule__RVariable__TypeAssignment_0 ) )
            // InternalAle.g:2886:2: ( rule__RVariable__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getTypeAssignment_0()); 
            }
            // InternalAle.g:2887:2: ( rule__RVariable__TypeAssignment_0 )
            // InternalAle.g:2887:3: rule__RVariable__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RVariable__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVariableAccess().getTypeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVariable__Group__0__Impl"


    // $ANTLR start "rule__RVariable__Group__1"
    // InternalAle.g:2895:1: rule__RVariable__Group__1 : rule__RVariable__Group__1__Impl ;
    public final void rule__RVariable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2899:1: ( rule__RVariable__Group__1__Impl )
            // InternalAle.g:2900:2: rule__RVariable__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RVariable__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVariable__Group__1"


    // $ANTLR start "rule__RVariable__Group__1__Impl"
    // InternalAle.g:2906:1: rule__RVariable__Group__1__Impl : ( ( rule__RVariable__NameAssignment_1 ) ) ;
    public final void rule__RVariable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2910:1: ( ( ( rule__RVariable__NameAssignment_1 ) ) )
            // InternalAle.g:2911:1: ( ( rule__RVariable__NameAssignment_1 ) )
            {
            // InternalAle.g:2911:1: ( ( rule__RVariable__NameAssignment_1 ) )
            // InternalAle.g:2912:2: ( rule__RVariable__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getNameAssignment_1()); 
            }
            // InternalAle.g:2913:2: ( rule__RVariable__NameAssignment_1 )
            // InternalAle.g:2913:3: rule__RVariable__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RVariable__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVariableAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVariable__Group__1__Impl"


    // $ANTLR start "rule__RAttribute__Group__0"
    // InternalAle.g:2922:1: rule__RAttribute__Group__0 : rule__RAttribute__Group__0__Impl rule__RAttribute__Group__1 ;
    public final void rule__RAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2926:1: ( rule__RAttribute__Group__0__Impl rule__RAttribute__Group__1 )
            // InternalAle.g:2927:2: rule__RAttribute__Group__0__Impl rule__RAttribute__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RAttribute__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RAttribute__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group__0"


    // $ANTLR start "rule__RAttribute__Group__0__Impl"
    // InternalAle.g:2934:1: rule__RAttribute__Group__0__Impl : ( ( rule__RAttribute__TypeAssignment_0 ) ) ;
    public final void rule__RAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2938:1: ( ( ( rule__RAttribute__TypeAssignment_0 ) ) )
            // InternalAle.g:2939:1: ( ( rule__RAttribute__TypeAssignment_0 ) )
            {
            // InternalAle.g:2939:1: ( ( rule__RAttribute__TypeAssignment_0 ) )
            // InternalAle.g:2940:2: ( rule__RAttribute__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getTypeAssignment_0()); 
            }
            // InternalAle.g:2941:2: ( rule__RAttribute__TypeAssignment_0 )
            // InternalAle.g:2941:3: rule__RAttribute__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RAttribute__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getTypeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group__0__Impl"


    // $ANTLR start "rule__RAttribute__Group__1"
    // InternalAle.g:2949:1: rule__RAttribute__Group__1 : rule__RAttribute__Group__1__Impl rule__RAttribute__Group__2 ;
    public final void rule__RAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2953:1: ( rule__RAttribute__Group__1__Impl rule__RAttribute__Group__2 )
            // InternalAle.g:2954:2: rule__RAttribute__Group__1__Impl rule__RAttribute__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__RAttribute__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RAttribute__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group__1"


    // $ANTLR start "rule__RAttribute__Group__1__Impl"
    // InternalAle.g:2961:1: rule__RAttribute__Group__1__Impl : ( ( rule__RAttribute__NameAssignment_1 ) ) ;
    public final void rule__RAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2965:1: ( ( ( rule__RAttribute__NameAssignment_1 ) ) )
            // InternalAle.g:2966:1: ( ( rule__RAttribute__NameAssignment_1 ) )
            {
            // InternalAle.g:2966:1: ( ( rule__RAttribute__NameAssignment_1 ) )
            // InternalAle.g:2967:2: ( rule__RAttribute__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getNameAssignment_1()); 
            }
            // InternalAle.g:2968:2: ( rule__RAttribute__NameAssignment_1 )
            // InternalAle.g:2968:3: rule__RAttribute__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RAttribute__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group__1__Impl"


    // $ANTLR start "rule__RAttribute__Group__2"
    // InternalAle.g:2976:1: rule__RAttribute__Group__2 : rule__RAttribute__Group__2__Impl rule__RAttribute__Group__3 ;
    public final void rule__RAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2980:1: ( rule__RAttribute__Group__2__Impl rule__RAttribute__Group__3 )
            // InternalAle.g:2981:2: rule__RAttribute__Group__2__Impl rule__RAttribute__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__RAttribute__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RAttribute__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group__2"


    // $ANTLR start "rule__RAttribute__Group__2__Impl"
    // InternalAle.g:2988:1: rule__RAttribute__Group__2__Impl : ( ( rule__RAttribute__Group_2__0 )? ) ;
    public final void rule__RAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2992:1: ( ( ( rule__RAttribute__Group_2__0 )? ) )
            // InternalAle.g:2993:1: ( ( rule__RAttribute__Group_2__0 )? )
            {
            // InternalAle.g:2993:1: ( ( rule__RAttribute__Group_2__0 )? )
            // InternalAle.g:2994:2: ( rule__RAttribute__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getGroup_2()); 
            }
            // InternalAle.g:2995:2: ( rule__RAttribute__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==47) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAle.g:2995:3: rule__RAttribute__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RAttribute__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group__2__Impl"


    // $ANTLR start "rule__RAttribute__Group__3"
    // InternalAle.g:3003:1: rule__RAttribute__Group__3 : rule__RAttribute__Group__3__Impl ;
    public final void rule__RAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3007:1: ( rule__RAttribute__Group__3__Impl )
            // InternalAle.g:3008:2: rule__RAttribute__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RAttribute__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group__3"


    // $ANTLR start "rule__RAttribute__Group__3__Impl"
    // InternalAle.g:3014:1: rule__RAttribute__Group__3__Impl : ( ';' ) ;
    public final void rule__RAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3018:1: ( ( ';' ) )
            // InternalAle.g:3019:1: ( ';' )
            {
            // InternalAle.g:3019:1: ( ';' )
            // InternalAle.g:3020:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getSemicolonKeyword_3()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group__3__Impl"


    // $ANTLR start "rule__RAttribute__Group_2__0"
    // InternalAle.g:3030:1: rule__RAttribute__Group_2__0 : rule__RAttribute__Group_2__0__Impl rule__RAttribute__Group_2__1 ;
    public final void rule__RAttribute__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3034:1: ( rule__RAttribute__Group_2__0__Impl rule__RAttribute__Group_2__1 )
            // InternalAle.g:3035:2: rule__RAttribute__Group_2__0__Impl rule__RAttribute__Group_2__1
            {
            pushFollow(FOLLOW_28);
            rule__RAttribute__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RAttribute__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group_2__0"


    // $ANTLR start "rule__RAttribute__Group_2__0__Impl"
    // InternalAle.g:3042:1: rule__RAttribute__Group_2__0__Impl : ( ':=' ) ;
    public final void rule__RAttribute__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3046:1: ( ( ':=' ) )
            // InternalAle.g:3047:1: ( ':=' )
            {
            // InternalAle.g:3047:1: ( ':=' )
            // InternalAle.g:3048:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getColonEqualsSignKeyword_2_0()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getColonEqualsSignKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group_2__0__Impl"


    // $ANTLR start "rule__RAttribute__Group_2__1"
    // InternalAle.g:3057:1: rule__RAttribute__Group_2__1 : rule__RAttribute__Group_2__1__Impl ;
    public final void rule__RAttribute__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3061:1: ( rule__RAttribute__Group_2__1__Impl )
            // InternalAle.g:3062:2: rule__RAttribute__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RAttribute__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group_2__1"


    // $ANTLR start "rule__RAttribute__Group_2__1__Impl"
    // InternalAle.g:3068:1: rule__RAttribute__Group_2__1__Impl : ( ( rule__RAttribute__ExprAssignment_2_1 ) ) ;
    public final void rule__RAttribute__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3072:1: ( ( ( rule__RAttribute__ExprAssignment_2_1 ) ) )
            // InternalAle.g:3073:1: ( ( rule__RAttribute__ExprAssignment_2_1 ) )
            {
            // InternalAle.g:3073:1: ( ( rule__RAttribute__ExprAssignment_2_1 ) )
            // InternalAle.g:3074:2: ( rule__RAttribute__ExprAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getExprAssignment_2_1()); 
            }
            // InternalAle.g:3075:2: ( rule__RAttribute__ExprAssignment_2_1 )
            // InternalAle.g:3075:3: rule__RAttribute__ExprAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__RAttribute__ExprAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getExprAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__Group_2__1__Impl"


    // $ANTLR start "rule__RStatement__Group_0__0"
    // InternalAle.g:3084:1: rule__RStatement__Group_0__0 : rule__RStatement__Group_0__0__Impl rule__RStatement__Group_0__1 ;
    public final void rule__RStatement__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3088:1: ( rule__RStatement__Group_0__0__Impl rule__RStatement__Group_0__1 )
            // InternalAle.g:3089:2: rule__RStatement__Group_0__0__Impl rule__RStatement__Group_0__1
            {
            pushFollow(FOLLOW_24);
            rule__RStatement__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_0__0"


    // $ANTLR start "rule__RStatement__Group_0__0__Impl"
    // InternalAle.g:3096:1: rule__RStatement__Group_0__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3100:1: ( ( () ) )
            // InternalAle.g:3101:1: ( () )
            {
            // InternalAle.g:3101:1: ( () )
            // InternalAle.g:3102:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRValDeclAction_0_0()); 
            }
            // InternalAle.g:3103:2: ()
            // InternalAle.g:3103:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getRValDeclAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_0__0__Impl"


    // $ANTLR start "rule__RStatement__Group_0__1"
    // InternalAle.g:3111:1: rule__RStatement__Group_0__1 : rule__RStatement__Group_0__1__Impl ;
    public final void rule__RStatement__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3115:1: ( rule__RStatement__Group_0__1__Impl )
            // InternalAle.g:3116:2: rule__RStatement__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_0__1"


    // $ANTLR start "rule__RStatement__Group_0__1__Impl"
    // InternalAle.g:3122:1: rule__RStatement__Group_0__1__Impl : ( ( rule__RStatement__StmtAssignment_0_1 ) ) ;
    public final void rule__RStatement__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3126:1: ( ( ( rule__RStatement__StmtAssignment_0_1 ) ) )
            // InternalAle.g:3127:1: ( ( rule__RStatement__StmtAssignment_0_1 ) )
            {
            // InternalAle.g:3127:1: ( ( rule__RStatement__StmtAssignment_0_1 ) )
            // InternalAle.g:3128:2: ( rule__RStatement__StmtAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getStmtAssignment_0_1()); 
            }
            // InternalAle.g:3129:2: ( rule__RStatement__StmtAssignment_0_1 )
            // InternalAle.g:3129:3: rule__RStatement__StmtAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__StmtAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getStmtAssignment_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_0__1__Impl"


    // $ANTLR start "rule__RStatement__Group_1__0"
    // InternalAle.g:3138:1: rule__RStatement__Group_1__0 : rule__RStatement__Group_1__0__Impl rule__RStatement__Group_1__1 ;
    public final void rule__RStatement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3142:1: ( rule__RStatement__Group_1__0__Impl rule__RStatement__Group_1__1 )
            // InternalAle.g:3143:2: rule__RStatement__Group_1__0__Impl rule__RStatement__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__RStatement__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_1__0"


    // $ANTLR start "rule__RStatement__Group_1__0__Impl"
    // InternalAle.g:3150:1: rule__RStatement__Group_1__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3154:1: ( ( () ) )
            // InternalAle.g:3155:1: ( () )
            {
            // InternalAle.g:3155:1: ( () )
            // InternalAle.g:3156:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRAssignAction_1_0()); 
            }
            // InternalAle.g:3157:2: ()
            // InternalAle.g:3157:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getRAssignAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_1__0__Impl"


    // $ANTLR start "rule__RStatement__Group_1__1"
    // InternalAle.g:3165:1: rule__RStatement__Group_1__1 : rule__RStatement__Group_1__1__Impl ;
    public final void rule__RStatement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3169:1: ( rule__RStatement__Group_1__1__Impl )
            // InternalAle.g:3170:2: rule__RStatement__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_1__1"


    // $ANTLR start "rule__RStatement__Group_1__1__Impl"
    // InternalAle.g:3176:1: rule__RStatement__Group_1__1__Impl : ( ( rule__RStatement__StmtAssignment_1_1 ) ) ;
    public final void rule__RStatement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3180:1: ( ( ( rule__RStatement__StmtAssignment_1_1 ) ) )
            // InternalAle.g:3181:1: ( ( rule__RStatement__StmtAssignment_1_1 ) )
            {
            // InternalAle.g:3181:1: ( ( rule__RStatement__StmtAssignment_1_1 ) )
            // InternalAle.g:3182:2: ( rule__RStatement__StmtAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getStmtAssignment_1_1()); 
            }
            // InternalAle.g:3183:2: ( rule__RStatement__StmtAssignment_1_1 )
            // InternalAle.g:3183:3: rule__RStatement__StmtAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__StmtAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getStmtAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_1__1__Impl"


    // $ANTLR start "rule__RStatement__Group_2__0"
    // InternalAle.g:3192:1: rule__RStatement__Group_2__0 : rule__RStatement__Group_2__0__Impl rule__RStatement__Group_2__1 ;
    public final void rule__RStatement__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3196:1: ( rule__RStatement__Group_2__0__Impl rule__RStatement__Group_2__1 )
            // InternalAle.g:3197:2: rule__RStatement__Group_2__0__Impl rule__RStatement__Group_2__1
            {
            pushFollow(FOLLOW_29);
            rule__RStatement__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_2__0"


    // $ANTLR start "rule__RStatement__Group_2__0__Impl"
    // InternalAle.g:3204:1: rule__RStatement__Group_2__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3208:1: ( ( () ) )
            // InternalAle.g:3209:1: ( () )
            {
            // InternalAle.g:3209:1: ( () )
            // InternalAle.g:3210:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRForEachAction_2_0()); 
            }
            // InternalAle.g:3211:2: ()
            // InternalAle.g:3211:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getRForEachAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_2__0__Impl"


    // $ANTLR start "rule__RStatement__Group_2__1"
    // InternalAle.g:3219:1: rule__RStatement__Group_2__1 : rule__RStatement__Group_2__1__Impl ;
    public final void rule__RStatement__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3223:1: ( rule__RStatement__Group_2__1__Impl )
            // InternalAle.g:3224:2: rule__RStatement__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_2__1"


    // $ANTLR start "rule__RStatement__Group_2__1__Impl"
    // InternalAle.g:3230:1: rule__RStatement__Group_2__1__Impl : ( ( rule__RStatement__ForEachAssignment_2_1 ) ) ;
    public final void rule__RStatement__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3234:1: ( ( ( rule__RStatement__ForEachAssignment_2_1 ) ) )
            // InternalAle.g:3235:1: ( ( rule__RStatement__ForEachAssignment_2_1 ) )
            {
            // InternalAle.g:3235:1: ( ( rule__RStatement__ForEachAssignment_2_1 ) )
            // InternalAle.g:3236:2: ( rule__RStatement__ForEachAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getForEachAssignment_2_1()); 
            }
            // InternalAle.g:3237:2: ( rule__RStatement__ForEachAssignment_2_1 )
            // InternalAle.g:3237:3: rule__RStatement__ForEachAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__ForEachAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getForEachAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_2__1__Impl"


    // $ANTLR start "rule__RStatement__Group_3__0"
    // InternalAle.g:3246:1: rule__RStatement__Group_3__0 : rule__RStatement__Group_3__0__Impl rule__RStatement__Group_3__1 ;
    public final void rule__RStatement__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3250:1: ( rule__RStatement__Group_3__0__Impl rule__RStatement__Group_3__1 )
            // InternalAle.g:3251:2: rule__RStatement__Group_3__0__Impl rule__RStatement__Group_3__1
            {
            pushFollow(FOLLOW_30);
            rule__RStatement__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_3__0"


    // $ANTLR start "rule__RStatement__Group_3__0__Impl"
    // InternalAle.g:3258:1: rule__RStatement__Group_3__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3262:1: ( ( () ) )
            // InternalAle.g:3263:1: ( () )
            {
            // InternalAle.g:3263:1: ( () )
            // InternalAle.g:3264:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRWhileAction_3_0()); 
            }
            // InternalAle.g:3265:2: ()
            // InternalAle.g:3265:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getRWhileAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_3__0__Impl"


    // $ANTLR start "rule__RStatement__Group_3__1"
    // InternalAle.g:3273:1: rule__RStatement__Group_3__1 : rule__RStatement__Group_3__1__Impl ;
    public final void rule__RStatement__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3277:1: ( rule__RStatement__Group_3__1__Impl )
            // InternalAle.g:3278:2: rule__RStatement__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_3__1"


    // $ANTLR start "rule__RStatement__Group_3__1__Impl"
    // InternalAle.g:3284:1: rule__RStatement__Group_3__1__Impl : ( ( rule__RStatement__WhileAssignment_3_1 ) ) ;
    public final void rule__RStatement__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3288:1: ( ( ( rule__RStatement__WhileAssignment_3_1 ) ) )
            // InternalAle.g:3289:1: ( ( rule__RStatement__WhileAssignment_3_1 ) )
            {
            // InternalAle.g:3289:1: ( ( rule__RStatement__WhileAssignment_3_1 ) )
            // InternalAle.g:3290:2: ( rule__RStatement__WhileAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getWhileAssignment_3_1()); 
            }
            // InternalAle.g:3291:2: ( rule__RStatement__WhileAssignment_3_1 )
            // InternalAle.g:3291:3: rule__RStatement__WhileAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__WhileAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getWhileAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_3__1__Impl"


    // $ANTLR start "rule__RStatement__Group_4__0"
    // InternalAle.g:3300:1: rule__RStatement__Group_4__0 : rule__RStatement__Group_4__0__Impl rule__RStatement__Group_4__1 ;
    public final void rule__RStatement__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3304:1: ( rule__RStatement__Group_4__0__Impl rule__RStatement__Group_4__1 )
            // InternalAle.g:3305:2: rule__RStatement__Group_4__0__Impl rule__RStatement__Group_4__1
            {
            pushFollow(FOLLOW_31);
            rule__RStatement__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_4__0"


    // $ANTLR start "rule__RStatement__Group_4__0__Impl"
    // InternalAle.g:3312:1: rule__RStatement__Group_4__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3316:1: ( ( () ) )
            // InternalAle.g:3317:1: ( () )
            {
            // InternalAle.g:3317:1: ( () )
            // InternalAle.g:3318:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRIfAction_4_0()); 
            }
            // InternalAle.g:3319:2: ()
            // InternalAle.g:3319:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getRIfAction_4_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_4__0__Impl"


    // $ANTLR start "rule__RStatement__Group_4__1"
    // InternalAle.g:3327:1: rule__RStatement__Group_4__1 : rule__RStatement__Group_4__1__Impl ;
    public final void rule__RStatement__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3331:1: ( rule__RStatement__Group_4__1__Impl )
            // InternalAle.g:3332:2: rule__RStatement__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_4__1"


    // $ANTLR start "rule__RStatement__Group_4__1__Impl"
    // InternalAle.g:3338:1: rule__RStatement__Group_4__1__Impl : ( ( rule__RStatement__IfAssignment_4_1 ) ) ;
    public final void rule__RStatement__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3342:1: ( ( ( rule__RStatement__IfAssignment_4_1 ) ) )
            // InternalAle.g:3343:1: ( ( rule__RStatement__IfAssignment_4_1 ) )
            {
            // InternalAle.g:3343:1: ( ( rule__RStatement__IfAssignment_4_1 ) )
            // InternalAle.g:3344:2: ( rule__RStatement__IfAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getIfAssignment_4_1()); 
            }
            // InternalAle.g:3345:2: ( rule__RStatement__IfAssignment_4_1 )
            // InternalAle.g:3345:3: rule__RStatement__IfAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__IfAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getIfAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_4__1__Impl"


    // $ANTLR start "rule__RStatement__Group_5__0"
    // InternalAle.g:3354:1: rule__RStatement__Group_5__0 : rule__RStatement__Group_5__0__Impl rule__RStatement__Group_5__1 ;
    public final void rule__RStatement__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3358:1: ( rule__RStatement__Group_5__0__Impl rule__RStatement__Group_5__1 )
            // InternalAle.g:3359:2: rule__RStatement__Group_5__0__Impl rule__RStatement__Group_5__1
            {
            pushFollow(FOLLOW_28);
            rule__RStatement__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_5__0"


    // $ANTLR start "rule__RStatement__Group_5__0__Impl"
    // InternalAle.g:3366:1: rule__RStatement__Group_5__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3370:1: ( ( () ) )
            // InternalAle.g:3371:1: ( () )
            {
            // InternalAle.g:3371:1: ( () )
            // InternalAle.g:3372:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRExpressionAction_5_0()); 
            }
            // InternalAle.g:3373:2: ()
            // InternalAle.g:3373:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getRExpressionAction_5_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_5__0__Impl"


    // $ANTLR start "rule__RStatement__Group_5__1"
    // InternalAle.g:3381:1: rule__RStatement__Group_5__1 : rule__RStatement__Group_5__1__Impl ;
    public final void rule__RStatement__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3385:1: ( rule__RStatement__Group_5__1__Impl )
            // InternalAle.g:3386:2: rule__RStatement__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_5__1"


    // $ANTLR start "rule__RStatement__Group_5__1__Impl"
    // InternalAle.g:3392:1: rule__RStatement__Group_5__1__Impl : ( ( rule__RStatement__ExprAssignment_5_1 ) ) ;
    public final void rule__RStatement__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3396:1: ( ( ( rule__RStatement__ExprAssignment_5_1 ) ) )
            // InternalAle.g:3397:1: ( ( rule__RStatement__ExprAssignment_5_1 ) )
            {
            // InternalAle.g:3397:1: ( ( rule__RStatement__ExprAssignment_5_1 ) )
            // InternalAle.g:3398:2: ( rule__RStatement__ExprAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getExprAssignment_5_1()); 
            }
            // InternalAle.g:3399:2: ( rule__RStatement__ExprAssignment_5_1 )
            // InternalAle.g:3399:3: rule__RStatement__ExprAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__RStatement__ExprAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getExprAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__Group_5__1__Impl"


    // $ANTLR start "rule__RVarDecl__Group__0"
    // InternalAle.g:3408:1: rule__RVarDecl__Group__0 : rule__RVarDecl__Group__0__Impl rule__RVarDecl__Group__1 ;
    public final void rule__RVarDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3412:1: ( rule__RVarDecl__Group__0__Impl rule__RVarDecl__Group__1 )
            // InternalAle.g:3413:2: rule__RVarDecl__Group__0__Impl rule__RVarDecl__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RVarDecl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RVarDecl__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group__0"


    // $ANTLR start "rule__RVarDecl__Group__0__Impl"
    // InternalAle.g:3420:1: rule__RVarDecl__Group__0__Impl : ( ( rule__RVarDecl__TypeAssignment_0 ) ) ;
    public final void rule__RVarDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3424:1: ( ( ( rule__RVarDecl__TypeAssignment_0 ) ) )
            // InternalAle.g:3425:1: ( ( rule__RVarDecl__TypeAssignment_0 ) )
            {
            // InternalAle.g:3425:1: ( ( rule__RVarDecl__TypeAssignment_0 ) )
            // InternalAle.g:3426:2: ( rule__RVarDecl__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getTypeAssignment_0()); 
            }
            // InternalAle.g:3427:2: ( rule__RVarDecl__TypeAssignment_0 )
            // InternalAle.g:3427:3: rule__RVarDecl__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RVarDecl__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getTypeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group__0__Impl"


    // $ANTLR start "rule__RVarDecl__Group__1"
    // InternalAle.g:3435:1: rule__RVarDecl__Group__1 : rule__RVarDecl__Group__1__Impl rule__RVarDecl__Group__2 ;
    public final void rule__RVarDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3439:1: ( rule__RVarDecl__Group__1__Impl rule__RVarDecl__Group__2 )
            // InternalAle.g:3440:2: rule__RVarDecl__Group__1__Impl rule__RVarDecl__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__RVarDecl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RVarDecl__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group__1"


    // $ANTLR start "rule__RVarDecl__Group__1__Impl"
    // InternalAle.g:3447:1: rule__RVarDecl__Group__1__Impl : ( ( rule__RVarDecl__IdentAssignment_1 ) ) ;
    public final void rule__RVarDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3451:1: ( ( ( rule__RVarDecl__IdentAssignment_1 ) ) )
            // InternalAle.g:3452:1: ( ( rule__RVarDecl__IdentAssignment_1 ) )
            {
            // InternalAle.g:3452:1: ( ( rule__RVarDecl__IdentAssignment_1 ) )
            // InternalAle.g:3453:2: ( rule__RVarDecl__IdentAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getIdentAssignment_1()); 
            }
            // InternalAle.g:3454:2: ( rule__RVarDecl__IdentAssignment_1 )
            // InternalAle.g:3454:3: rule__RVarDecl__IdentAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RVarDecl__IdentAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getIdentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group__1__Impl"


    // $ANTLR start "rule__RVarDecl__Group__2"
    // InternalAle.g:3462:1: rule__RVarDecl__Group__2 : rule__RVarDecl__Group__2__Impl rule__RVarDecl__Group__3 ;
    public final void rule__RVarDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3466:1: ( rule__RVarDecl__Group__2__Impl rule__RVarDecl__Group__3 )
            // InternalAle.g:3467:2: rule__RVarDecl__Group__2__Impl rule__RVarDecl__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__RVarDecl__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RVarDecl__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group__2"


    // $ANTLR start "rule__RVarDecl__Group__2__Impl"
    // InternalAle.g:3474:1: rule__RVarDecl__Group__2__Impl : ( ( rule__RVarDecl__Group_2__0 )? ) ;
    public final void rule__RVarDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3478:1: ( ( ( rule__RVarDecl__Group_2__0 )? ) )
            // InternalAle.g:3479:1: ( ( rule__RVarDecl__Group_2__0 )? )
            {
            // InternalAle.g:3479:1: ( ( rule__RVarDecl__Group_2__0 )? )
            // InternalAle.g:3480:2: ( rule__RVarDecl__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getGroup_2()); 
            }
            // InternalAle.g:3481:2: ( rule__RVarDecl__Group_2__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==47) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAle.g:3481:3: rule__RVarDecl__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RVarDecl__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group__2__Impl"


    // $ANTLR start "rule__RVarDecl__Group__3"
    // InternalAle.g:3489:1: rule__RVarDecl__Group__3 : rule__RVarDecl__Group__3__Impl ;
    public final void rule__RVarDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3493:1: ( rule__RVarDecl__Group__3__Impl )
            // InternalAle.g:3494:2: rule__RVarDecl__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RVarDecl__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group__3"


    // $ANTLR start "rule__RVarDecl__Group__3__Impl"
    // InternalAle.g:3500:1: rule__RVarDecl__Group__3__Impl : ( ';' ) ;
    public final void rule__RVarDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3504:1: ( ( ';' ) )
            // InternalAle.g:3505:1: ( ';' )
            {
            // InternalAle.g:3505:1: ( ';' )
            // InternalAle.g:3506:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getSemicolonKeyword_3()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group__3__Impl"


    // $ANTLR start "rule__RVarDecl__Group_2__0"
    // InternalAle.g:3516:1: rule__RVarDecl__Group_2__0 : rule__RVarDecl__Group_2__0__Impl rule__RVarDecl__Group_2__1 ;
    public final void rule__RVarDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3520:1: ( rule__RVarDecl__Group_2__0__Impl rule__RVarDecl__Group_2__1 )
            // InternalAle.g:3521:2: rule__RVarDecl__Group_2__0__Impl rule__RVarDecl__Group_2__1
            {
            pushFollow(FOLLOW_28);
            rule__RVarDecl__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RVarDecl__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group_2__0"


    // $ANTLR start "rule__RVarDecl__Group_2__0__Impl"
    // InternalAle.g:3528:1: rule__RVarDecl__Group_2__0__Impl : ( ':=' ) ;
    public final void rule__RVarDecl__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3532:1: ( ( ':=' ) )
            // InternalAle.g:3533:1: ( ':=' )
            {
            // InternalAle.g:3533:1: ( ':=' )
            // InternalAle.g:3534:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getColonEqualsSignKeyword_2_0()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getColonEqualsSignKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group_2__0__Impl"


    // $ANTLR start "rule__RVarDecl__Group_2__1"
    // InternalAle.g:3543:1: rule__RVarDecl__Group_2__1 : rule__RVarDecl__Group_2__1__Impl ;
    public final void rule__RVarDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3547:1: ( rule__RVarDecl__Group_2__1__Impl )
            // InternalAle.g:3548:2: rule__RVarDecl__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RVarDecl__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group_2__1"


    // $ANTLR start "rule__RVarDecl__Group_2__1__Impl"
    // InternalAle.g:3554:1: rule__RVarDecl__Group_2__1__Impl : ( ( rule__RVarDecl__ExpressionAssignment_2_1 ) ) ;
    public final void rule__RVarDecl__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3558:1: ( ( ( rule__RVarDecl__ExpressionAssignment_2_1 ) ) )
            // InternalAle.g:3559:1: ( ( rule__RVarDecl__ExpressionAssignment_2_1 ) )
            {
            // InternalAle.g:3559:1: ( ( rule__RVarDecl__ExpressionAssignment_2_1 ) )
            // InternalAle.g:3560:2: ( rule__RVarDecl__ExpressionAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getExpressionAssignment_2_1()); 
            }
            // InternalAle.g:3561:2: ( rule__RVarDecl__ExpressionAssignment_2_1 )
            // InternalAle.g:3561:3: rule__RVarDecl__ExpressionAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__RVarDecl__ExpressionAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getExpressionAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__Group_2__1__Impl"


    // $ANTLR start "rule__RAssign__Group__0"
    // InternalAle.g:3570:1: rule__RAssign__Group__0 : rule__RAssign__Group__0__Impl rule__RAssign__Group__1 ;
    public final void rule__RAssign__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3574:1: ( rule__RAssign__Group__0__Impl rule__RAssign__Group__1 )
            // InternalAle.g:3575:2: rule__RAssign__Group__0__Impl rule__RAssign__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__RAssign__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RAssign__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__Group__0"


    // $ANTLR start "rule__RAssign__Group__0__Impl"
    // InternalAle.g:3582:1: rule__RAssign__Group__0__Impl : ( ( rule__RAssign__LeftAssignment_0 ) ) ;
    public final void rule__RAssign__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3586:1: ( ( ( rule__RAssign__LeftAssignment_0 ) ) )
            // InternalAle.g:3587:1: ( ( rule__RAssign__LeftAssignment_0 ) )
            {
            // InternalAle.g:3587:1: ( ( rule__RAssign__LeftAssignment_0 ) )
            // InternalAle.g:3588:2: ( rule__RAssign__LeftAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getLeftAssignment_0()); 
            }
            // InternalAle.g:3589:2: ( rule__RAssign__LeftAssignment_0 )
            // InternalAle.g:3589:3: rule__RAssign__LeftAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RAssign__LeftAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignAccess().getLeftAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__Group__0__Impl"


    // $ANTLR start "rule__RAssign__Group__1"
    // InternalAle.g:3597:1: rule__RAssign__Group__1 : rule__RAssign__Group__1__Impl rule__RAssign__Group__2 ;
    public final void rule__RAssign__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3601:1: ( rule__RAssign__Group__1__Impl rule__RAssign__Group__2 )
            // InternalAle.g:3602:2: rule__RAssign__Group__1__Impl rule__RAssign__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__RAssign__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RAssign__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__Group__1"


    // $ANTLR start "rule__RAssign__Group__1__Impl"
    // InternalAle.g:3609:1: rule__RAssign__Group__1__Impl : ( ':=' ) ;
    public final void rule__RAssign__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3613:1: ( ( ':=' ) )
            // InternalAle.g:3614:1: ( ':=' )
            {
            // InternalAle.g:3614:1: ( ':=' )
            // InternalAle.g:3615:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getColonEqualsSignKeyword_1()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignAccess().getColonEqualsSignKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__Group__1__Impl"


    // $ANTLR start "rule__RAssign__Group__2"
    // InternalAle.g:3624:1: rule__RAssign__Group__2 : rule__RAssign__Group__2__Impl rule__RAssign__Group__3 ;
    public final void rule__RAssign__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3628:1: ( rule__RAssign__Group__2__Impl rule__RAssign__Group__3 )
            // InternalAle.g:3629:2: rule__RAssign__Group__2__Impl rule__RAssign__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__RAssign__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RAssign__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__Group__2"


    // $ANTLR start "rule__RAssign__Group__2__Impl"
    // InternalAle.g:3636:1: rule__RAssign__Group__2__Impl : ( ( rule__RAssign__RightAssignment_2 ) ) ;
    public final void rule__RAssign__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3640:1: ( ( ( rule__RAssign__RightAssignment_2 ) ) )
            // InternalAle.g:3641:1: ( ( rule__RAssign__RightAssignment_2 ) )
            {
            // InternalAle.g:3641:1: ( ( rule__RAssign__RightAssignment_2 ) )
            // InternalAle.g:3642:2: ( rule__RAssign__RightAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getRightAssignment_2()); 
            }
            // InternalAle.g:3643:2: ( rule__RAssign__RightAssignment_2 )
            // InternalAle.g:3643:3: rule__RAssign__RightAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__RAssign__RightAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignAccess().getRightAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__Group__2__Impl"


    // $ANTLR start "rule__RAssign__Group__3"
    // InternalAle.g:3651:1: rule__RAssign__Group__3 : rule__RAssign__Group__3__Impl ;
    public final void rule__RAssign__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3655:1: ( rule__RAssign__Group__3__Impl )
            // InternalAle.g:3656:2: rule__RAssign__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RAssign__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__Group__3"


    // $ANTLR start "rule__RAssign__Group__3__Impl"
    // InternalAle.g:3662:1: rule__RAssign__Group__3__Impl : ( ';' ) ;
    public final void rule__RAssign__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3666:1: ( ( ';' ) )
            // InternalAle.g:3667:1: ( ';' )
            {
            // InternalAle.g:3667:1: ( ';' )
            // InternalAle.g:3668:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getSemicolonKeyword_3()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__Group__3__Impl"


    // $ANTLR start "rule__RForEach__Group__0"
    // InternalAle.g:3678:1: rule__RForEach__Group__0 : rule__RForEach__Group__0__Impl rule__RForEach__Group__1 ;
    public final void rule__RForEach__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3682:1: ( rule__RForEach__Group__0__Impl rule__RForEach__Group__1 )
            // InternalAle.g:3683:2: rule__RForEach__Group__0__Impl rule__RForEach__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__RForEach__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RForEach__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__0"


    // $ANTLR start "rule__RForEach__Group__0__Impl"
    // InternalAle.g:3690:1: rule__RForEach__Group__0__Impl : ( 'for' ) ;
    public final void rule__RForEach__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3694:1: ( ( 'for' ) )
            // InternalAle.g:3695:1: ( 'for' )
            {
            // InternalAle.g:3695:1: ( 'for' )
            // InternalAle.g:3696:2: 'for'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getForKeyword_0()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getForKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__0__Impl"


    // $ANTLR start "rule__RForEach__Group__1"
    // InternalAle.g:3705:1: rule__RForEach__Group__1 : rule__RForEach__Group__1__Impl rule__RForEach__Group__2 ;
    public final void rule__RForEach__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3709:1: ( rule__RForEach__Group__1__Impl rule__RForEach__Group__2 )
            // InternalAle.g:3710:2: rule__RForEach__Group__1__Impl rule__RForEach__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__RForEach__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RForEach__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__1"


    // $ANTLR start "rule__RForEach__Group__1__Impl"
    // InternalAle.g:3717:1: rule__RForEach__Group__1__Impl : ( '(' ) ;
    public final void rule__RForEach__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3721:1: ( ( '(' ) )
            // InternalAle.g:3722:1: ( '(' )
            {
            // InternalAle.g:3722:1: ( '(' )
            // InternalAle.g:3723:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__1__Impl"


    // $ANTLR start "rule__RForEach__Group__2"
    // InternalAle.g:3732:1: rule__RForEach__Group__2 : rule__RForEach__Group__2__Impl rule__RForEach__Group__3 ;
    public final void rule__RForEach__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3736:1: ( rule__RForEach__Group__2__Impl rule__RForEach__Group__3 )
            // InternalAle.g:3737:2: rule__RForEach__Group__2__Impl rule__RForEach__Group__3
            {
            pushFollow(FOLLOW_33);
            rule__RForEach__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RForEach__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__2"


    // $ANTLR start "rule__RForEach__Group__2__Impl"
    // InternalAle.g:3744:1: rule__RForEach__Group__2__Impl : ( RULE_IDENT ) ;
    public final void rule__RForEach__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3748:1: ( ( RULE_IDENT ) )
            // InternalAle.g:3749:1: ( RULE_IDENT )
            {
            // InternalAle.g:3749:1: ( RULE_IDENT )
            // InternalAle.g:3750:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getIDENTTerminalRuleCall_2()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getIDENTTerminalRuleCall_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__2__Impl"


    // $ANTLR start "rule__RForEach__Group__3"
    // InternalAle.g:3759:1: rule__RForEach__Group__3 : rule__RForEach__Group__3__Impl rule__RForEach__Group__4 ;
    public final void rule__RForEach__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3763:1: ( rule__RForEach__Group__3__Impl rule__RForEach__Group__4 )
            // InternalAle.g:3764:2: rule__RForEach__Group__3__Impl rule__RForEach__Group__4
            {
            pushFollow(FOLLOW_34);
            rule__RForEach__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RForEach__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__3"


    // $ANTLR start "rule__RForEach__Group__3__Impl"
    // InternalAle.g:3771:1: rule__RForEach__Group__3__Impl : ( 'in' ) ;
    public final void rule__RForEach__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3775:1: ( ( 'in' ) )
            // InternalAle.g:3776:1: ( 'in' )
            {
            // InternalAle.g:3776:1: ( 'in' )
            // InternalAle.g:3777:2: 'in'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getInKeyword_3()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getInKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__3__Impl"


    // $ANTLR start "rule__RForEach__Group__4"
    // InternalAle.g:3786:1: rule__RForEach__Group__4 : rule__RForEach__Group__4__Impl rule__RForEach__Group__5 ;
    public final void rule__RForEach__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3790:1: ( rule__RForEach__Group__4__Impl rule__RForEach__Group__5 )
            // InternalAle.g:3791:2: rule__RForEach__Group__4__Impl rule__RForEach__Group__5
            {
            pushFollow(FOLLOW_35);
            rule__RForEach__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RForEach__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__4"


    // $ANTLR start "rule__RForEach__Group__4__Impl"
    // InternalAle.g:3798:1: rule__RForEach__Group__4__Impl : ( rulerCollection ) ;
    public final void rule__RForEach__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3802:1: ( ( rulerCollection ) )
            // InternalAle.g:3803:1: ( rulerCollection )
            {
            // InternalAle.g:3803:1: ( rulerCollection )
            // InternalAle.g:3804:2: rulerCollection
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getRCollectionParserRuleCall_4()); 
            }
            pushFollow(FOLLOW_2);
            rulerCollection();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getRCollectionParserRuleCall_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__4__Impl"


    // $ANTLR start "rule__RForEach__Group__5"
    // InternalAle.g:3813:1: rule__RForEach__Group__5 : rule__RForEach__Group__5__Impl rule__RForEach__Group__6 ;
    public final void rule__RForEach__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3817:1: ( rule__RForEach__Group__5__Impl rule__RForEach__Group__6 )
            // InternalAle.g:3818:2: rule__RForEach__Group__5__Impl rule__RForEach__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__RForEach__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RForEach__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__5"


    // $ANTLR start "rule__RForEach__Group__5__Impl"
    // InternalAle.g:3825:1: rule__RForEach__Group__5__Impl : ( ')' ) ;
    public final void rule__RForEach__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3829:1: ( ( ')' ) )
            // InternalAle.g:3830:1: ( ')' )
            {
            // InternalAle.g:3830:1: ( ')' )
            // InternalAle.g:3831:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getRightParenthesisKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__5__Impl"


    // $ANTLR start "rule__RForEach__Group__6"
    // InternalAle.g:3840:1: rule__RForEach__Group__6 : rule__RForEach__Group__6__Impl ;
    public final void rule__RForEach__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3844:1: ( rule__RForEach__Group__6__Impl )
            // InternalAle.g:3845:2: rule__RForEach__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RForEach__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__6"


    // $ANTLR start "rule__RForEach__Group__6__Impl"
    // InternalAle.g:3851:1: rule__RForEach__Group__6__Impl : ( ( rule__RForEach__BlockAssignment_6 ) ) ;
    public final void rule__RForEach__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3855:1: ( ( ( rule__RForEach__BlockAssignment_6 ) ) )
            // InternalAle.g:3856:1: ( ( rule__RForEach__BlockAssignment_6 ) )
            {
            // InternalAle.g:3856:1: ( ( rule__RForEach__BlockAssignment_6 ) )
            // InternalAle.g:3857:2: ( rule__RForEach__BlockAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getBlockAssignment_6()); 
            }
            // InternalAle.g:3858:2: ( rule__RForEach__BlockAssignment_6 )
            // InternalAle.g:3858:3: rule__RForEach__BlockAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__RForEach__BlockAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getBlockAssignment_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__Group__6__Impl"


    // $ANTLR start "rule__RCollection__Group_0__0"
    // InternalAle.g:3867:1: rule__RCollection__Group_0__0 : rule__RCollection__Group_0__0__Impl rule__RCollection__Group_0__1 ;
    public final void rule__RCollection__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3871:1: ( rule__RCollection__Group_0__0__Impl rule__RCollection__Group_0__1 )
            // InternalAle.g:3872:2: rule__RCollection__Group_0__0__Impl rule__RCollection__Group_0__1
            {
            pushFollow(FOLLOW_36);
            rule__RCollection__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RCollection__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__0"


    // $ANTLR start "rule__RCollection__Group_0__0__Impl"
    // InternalAle.g:3879:1: rule__RCollection__Group_0__0__Impl : ( '[' ) ;
    public final void rule__RCollection__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3883:1: ( ( '[' ) )
            // InternalAle.g:3884:1: ( '[' )
            {
            // InternalAle.g:3884:1: ( '[' )
            // InternalAle.g:3885:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionAccess().getLeftSquareBracketKeyword_0_0()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRCollectionAccess().getLeftSquareBracketKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__0__Impl"


    // $ANTLR start "rule__RCollection__Group_0__1"
    // InternalAle.g:3894:1: rule__RCollection__Group_0__1 : rule__RCollection__Group_0__1__Impl rule__RCollection__Group_0__2 ;
    public final void rule__RCollection__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3898:1: ( rule__RCollection__Group_0__1__Impl rule__RCollection__Group_0__2 )
            // InternalAle.g:3899:2: rule__RCollection__Group_0__1__Impl rule__RCollection__Group_0__2
            {
            pushFollow(FOLLOW_37);
            rule__RCollection__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RCollection__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__1"


    // $ANTLR start "rule__RCollection__Group_0__1__Impl"
    // InternalAle.g:3906:1: rule__RCollection__Group_0__1__Impl : ( RULE_INT ) ;
    public final void rule__RCollection__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3910:1: ( ( RULE_INT ) )
            // InternalAle.g:3911:1: ( RULE_INT )
            {
            // InternalAle.g:3911:1: ( RULE_INT )
            // InternalAle.g:3912:2: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_1()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__1__Impl"


    // $ANTLR start "rule__RCollection__Group_0__2"
    // InternalAle.g:3921:1: rule__RCollection__Group_0__2 : rule__RCollection__Group_0__2__Impl rule__RCollection__Group_0__3 ;
    public final void rule__RCollection__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3925:1: ( rule__RCollection__Group_0__2__Impl rule__RCollection__Group_0__3 )
            // InternalAle.g:3926:2: rule__RCollection__Group_0__2__Impl rule__RCollection__Group_0__3
            {
            pushFollow(FOLLOW_36);
            rule__RCollection__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RCollection__Group_0__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__2"


    // $ANTLR start "rule__RCollection__Group_0__2__Impl"
    // InternalAle.g:3933:1: rule__RCollection__Group_0__2__Impl : ( '..' ) ;
    public final void rule__RCollection__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3937:1: ( ( '..' ) )
            // InternalAle.g:3938:1: ( '..' )
            {
            // InternalAle.g:3938:1: ( '..' )
            // InternalAle.g:3939:2: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionAccess().getFullStopFullStopKeyword_0_2()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRCollectionAccess().getFullStopFullStopKeyword_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__2__Impl"


    // $ANTLR start "rule__RCollection__Group_0__3"
    // InternalAle.g:3948:1: rule__RCollection__Group_0__3 : rule__RCollection__Group_0__3__Impl rule__RCollection__Group_0__4 ;
    public final void rule__RCollection__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3952:1: ( rule__RCollection__Group_0__3__Impl rule__RCollection__Group_0__4 )
            // InternalAle.g:3953:2: rule__RCollection__Group_0__3__Impl rule__RCollection__Group_0__4
            {
            pushFollow(FOLLOW_38);
            rule__RCollection__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RCollection__Group_0__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__3"


    // $ANTLR start "rule__RCollection__Group_0__3__Impl"
    // InternalAle.g:3960:1: rule__RCollection__Group_0__3__Impl : ( RULE_INT ) ;
    public final void rule__RCollection__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3964:1: ( ( RULE_INT ) )
            // InternalAle.g:3965:1: ( RULE_INT )
            {
            // InternalAle.g:3965:1: ( RULE_INT )
            // InternalAle.g:3966:2: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_3()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRCollectionAccess().getINTTerminalRuleCall_0_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__3__Impl"


    // $ANTLR start "rule__RCollection__Group_0__4"
    // InternalAle.g:3975:1: rule__RCollection__Group_0__4 : rule__RCollection__Group_0__4__Impl ;
    public final void rule__RCollection__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3979:1: ( rule__RCollection__Group_0__4__Impl )
            // InternalAle.g:3980:2: rule__RCollection__Group_0__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RCollection__Group_0__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__4"


    // $ANTLR start "rule__RCollection__Group_0__4__Impl"
    // InternalAle.g:3986:1: rule__RCollection__Group_0__4__Impl : ( ']' ) ;
    public final void rule__RCollection__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3990:1: ( ( ']' ) )
            // InternalAle.g:3991:1: ( ']' )
            {
            // InternalAle.g:3991:1: ( ']' )
            // InternalAle.g:3992:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionAccess().getRightSquareBracketKeyword_0_4()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRCollectionAccess().getRightSquareBracketKeyword_0_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RCollection__Group_0__4__Impl"


    // $ANTLR start "rule__RBlock__Group__0"
    // InternalAle.g:4002:1: rule__RBlock__Group__0 : rule__RBlock__Group__0__Impl rule__RBlock__Group__1 ;
    public final void rule__RBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4006:1: ( rule__RBlock__Group__0__Impl rule__RBlock__Group__1 )
            // InternalAle.g:4007:2: rule__RBlock__Group__0__Impl rule__RBlock__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__RBlock__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RBlock__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group__0"


    // $ANTLR start "rule__RBlock__Group__0__Impl"
    // InternalAle.g:4014:1: rule__RBlock__Group__0__Impl : ( '{' ) ;
    public final void rule__RBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4018:1: ( ( '{' ) )
            // InternalAle.g:4019:1: ( '{' )
            {
            // InternalAle.g:4019:1: ( '{' )
            // InternalAle.g:4020:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getLeftCurlyBracketKeyword_0()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getLeftCurlyBracketKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group__0__Impl"


    // $ANTLR start "rule__RBlock__Group__1"
    // InternalAle.g:4029:1: rule__RBlock__Group__1 : rule__RBlock__Group__1__Impl rule__RBlock__Group__2 ;
    public final void rule__RBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4033:1: ( rule__RBlock__Group__1__Impl rule__RBlock__Group__2 )
            // InternalAle.g:4034:2: rule__RBlock__Group__1__Impl rule__RBlock__Group__2
            {
            pushFollow(FOLLOW_39);
            rule__RBlock__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RBlock__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group__1"


    // $ANTLR start "rule__RBlock__Group__1__Impl"
    // InternalAle.g:4041:1: rule__RBlock__Group__1__Impl : ( ( rule__RBlock__Group_1__0 )? ) ;
    public final void rule__RBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4045:1: ( ( ( rule__RBlock__Group_1__0 )? ) )
            // InternalAle.g:4046:1: ( ( rule__RBlock__Group_1__0 )? )
            {
            // InternalAle.g:4046:1: ( ( rule__RBlock__Group_1__0 )? )
            // InternalAle.g:4047:2: ( rule__RBlock__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getGroup_1()); 
            }
            // InternalAle.g:4048:2: ( rule__RBlock__Group_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_IDENT)||(LA30_0>=29 && LA30_0<=31)||LA30_0==40||LA30_0==44||LA30_0==48||LA30_0==53||LA30_0==55||(LA30_0>=61 && LA30_0<=62)||LA30_0==65||(LA30_0>=69 && LA30_0<=70)||(LA30_0>=72 && LA30_0<=77)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAle.g:4048:3: rule__RBlock__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RBlock__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group__1__Impl"


    // $ANTLR start "rule__RBlock__Group__2"
    // InternalAle.g:4056:1: rule__RBlock__Group__2 : rule__RBlock__Group__2__Impl ;
    public final void rule__RBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4060:1: ( rule__RBlock__Group__2__Impl )
            // InternalAle.g:4061:2: rule__RBlock__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RBlock__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group__2"


    // $ANTLR start "rule__RBlock__Group__2__Impl"
    // InternalAle.g:4067:1: rule__RBlock__Group__2__Impl : ( '}' ) ;
    public final void rule__RBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4071:1: ( ( '}' ) )
            // InternalAle.g:4072:1: ( '}' )
            {
            // InternalAle.g:4072:1: ( '}' )
            // InternalAle.g:4073:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getRightCurlyBracketKeyword_2()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getRightCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group__2__Impl"


    // $ANTLR start "rule__RBlock__Group_1__0"
    // InternalAle.g:4083:1: rule__RBlock__Group_1__0 : rule__RBlock__Group_1__0__Impl rule__RBlock__Group_1__1 ;
    public final void rule__RBlock__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4087:1: ( rule__RBlock__Group_1__0__Impl rule__RBlock__Group_1__1 )
            // InternalAle.g:4088:2: rule__RBlock__Group_1__0__Impl rule__RBlock__Group_1__1
            {
            pushFollow(FOLLOW_40);
            rule__RBlock__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RBlock__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group_1__0"


    // $ANTLR start "rule__RBlock__Group_1__0__Impl"
    // InternalAle.g:4095:1: rule__RBlock__Group_1__0__Impl : ( ( rule__RBlock__StatementAssignment_1_0 ) ) ;
    public final void rule__RBlock__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4099:1: ( ( ( rule__RBlock__StatementAssignment_1_0 ) ) )
            // InternalAle.g:4100:1: ( ( rule__RBlock__StatementAssignment_1_0 ) )
            {
            // InternalAle.g:4100:1: ( ( rule__RBlock__StatementAssignment_1_0 ) )
            // InternalAle.g:4101:2: ( rule__RBlock__StatementAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getStatementAssignment_1_0()); 
            }
            // InternalAle.g:4102:2: ( rule__RBlock__StatementAssignment_1_0 )
            // InternalAle.g:4102:3: rule__RBlock__StatementAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__RBlock__StatementAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getStatementAssignment_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group_1__0__Impl"


    // $ANTLR start "rule__RBlock__Group_1__1"
    // InternalAle.g:4110:1: rule__RBlock__Group_1__1 : rule__RBlock__Group_1__1__Impl ;
    public final void rule__RBlock__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4114:1: ( rule__RBlock__Group_1__1__Impl )
            // InternalAle.g:4115:2: rule__RBlock__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RBlock__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group_1__1"


    // $ANTLR start "rule__RBlock__Group_1__1__Impl"
    // InternalAle.g:4121:1: rule__RBlock__Group_1__1__Impl : ( ( rule__RBlock__StatementAssignment_1_1 )* ) ;
    public final void rule__RBlock__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4125:1: ( ( ( rule__RBlock__StatementAssignment_1_1 )* ) )
            // InternalAle.g:4126:1: ( ( rule__RBlock__StatementAssignment_1_1 )* )
            {
            // InternalAle.g:4126:1: ( ( rule__RBlock__StatementAssignment_1_1 )* )
            // InternalAle.g:4127:2: ( rule__RBlock__StatementAssignment_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getStatementAssignment_1_1()); 
            }
            // InternalAle.g:4128:2: ( rule__RBlock__StatementAssignment_1_1 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=RULE_STRING && LA31_0<=RULE_IDENT)||(LA31_0>=29 && LA31_0<=31)||LA31_0==40||LA31_0==44||LA31_0==48||LA31_0==53||LA31_0==55||(LA31_0>=61 && LA31_0<=62)||LA31_0==65||(LA31_0>=69 && LA31_0<=70)||(LA31_0>=72 && LA31_0<=77)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalAle.g:4128:3: rule__RBlock__StatementAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__RBlock__StatementAssignment_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getStatementAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__Group_1__1__Impl"


    // $ANTLR start "rule__RIf__Group__0"
    // InternalAle.g:4137:1: rule__RIf__Group__0 : rule__RIf__Group__0__Impl rule__RIf__Group__1 ;
    public final void rule__RIf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4141:1: ( rule__RIf__Group__0__Impl rule__RIf__Group__1 )
            // InternalAle.g:4142:2: rule__RIf__Group__0__Impl rule__RIf__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__RIf__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RIf__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__0"


    // $ANTLR start "rule__RIf__Group__0__Impl"
    // InternalAle.g:4149:1: rule__RIf__Group__0__Impl : ( 'if' ) ;
    public final void rule__RIf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4153:1: ( ( 'if' ) )
            // InternalAle.g:4154:1: ( 'if' )
            {
            // InternalAle.g:4154:1: ( 'if' )
            // InternalAle.g:4155:2: 'if'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getIfKeyword_0()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getIfKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__0__Impl"


    // $ANTLR start "rule__RIf__Group__1"
    // InternalAle.g:4164:1: rule__RIf__Group__1 : rule__RIf__Group__1__Impl rule__RIf__Group__2 ;
    public final void rule__RIf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4168:1: ( rule__RIf__Group__1__Impl rule__RIf__Group__2 )
            // InternalAle.g:4169:2: rule__RIf__Group__1__Impl rule__RIf__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__RIf__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RIf__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__1"


    // $ANTLR start "rule__RIf__Group__1__Impl"
    // InternalAle.g:4176:1: rule__RIf__Group__1__Impl : ( '(' ) ;
    public final void rule__RIf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4180:1: ( ( '(' ) )
            // InternalAle.g:4181:1: ( '(' )
            {
            // InternalAle.g:4181:1: ( '(' )
            // InternalAle.g:4182:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__1__Impl"


    // $ANTLR start "rule__RIf__Group__2"
    // InternalAle.g:4191:1: rule__RIf__Group__2 : rule__RIf__Group__2__Impl rule__RIf__Group__3 ;
    public final void rule__RIf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4195:1: ( rule__RIf__Group__2__Impl rule__RIf__Group__3 )
            // InternalAle.g:4196:2: rule__RIf__Group__2__Impl rule__RIf__Group__3
            {
            pushFollow(FOLLOW_35);
            rule__RIf__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RIf__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__2"


    // $ANTLR start "rule__RIf__Group__2__Impl"
    // InternalAle.g:4203:1: rule__RIf__Group__2__Impl : ( ( rule__RIf__ConditionAssignment_2 ) ) ;
    public final void rule__RIf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4207:1: ( ( ( rule__RIf__ConditionAssignment_2 ) ) )
            // InternalAle.g:4208:1: ( ( rule__RIf__ConditionAssignment_2 ) )
            {
            // InternalAle.g:4208:1: ( ( rule__RIf__ConditionAssignment_2 ) )
            // InternalAle.g:4209:2: ( rule__RIf__ConditionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getConditionAssignment_2()); 
            }
            // InternalAle.g:4210:2: ( rule__RIf__ConditionAssignment_2 )
            // InternalAle.g:4210:3: rule__RIf__ConditionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__RIf__ConditionAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getConditionAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__2__Impl"


    // $ANTLR start "rule__RIf__Group__3"
    // InternalAle.g:4218:1: rule__RIf__Group__3 : rule__RIf__Group__3__Impl rule__RIf__Group__4 ;
    public final void rule__RIf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4222:1: ( rule__RIf__Group__3__Impl rule__RIf__Group__4 )
            // InternalAle.g:4223:2: rule__RIf__Group__3__Impl rule__RIf__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__RIf__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RIf__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__3"


    // $ANTLR start "rule__RIf__Group__3__Impl"
    // InternalAle.g:4230:1: rule__RIf__Group__3__Impl : ( ')' ) ;
    public final void rule__RIf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4234:1: ( ( ')' ) )
            // InternalAle.g:4235:1: ( ')' )
            {
            // InternalAle.g:4235:1: ( ')' )
            // InternalAle.g:4236:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__3__Impl"


    // $ANTLR start "rule__RIf__Group__4"
    // InternalAle.g:4245:1: rule__RIf__Group__4 : rule__RIf__Group__4__Impl rule__RIf__Group__5 ;
    public final void rule__RIf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4249:1: ( rule__RIf__Group__4__Impl rule__RIf__Group__5 )
            // InternalAle.g:4250:2: rule__RIf__Group__4__Impl rule__RIf__Group__5
            {
            pushFollow(FOLLOW_42);
            rule__RIf__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RIf__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__4"


    // $ANTLR start "rule__RIf__Group__4__Impl"
    // InternalAle.g:4257:1: rule__RIf__Group__4__Impl : ( ( rule__RIf__IfBlockAssignment_4 ) ) ;
    public final void rule__RIf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4261:1: ( ( ( rule__RIf__IfBlockAssignment_4 ) ) )
            // InternalAle.g:4262:1: ( ( rule__RIf__IfBlockAssignment_4 ) )
            {
            // InternalAle.g:4262:1: ( ( rule__RIf__IfBlockAssignment_4 ) )
            // InternalAle.g:4263:2: ( rule__RIf__IfBlockAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getIfBlockAssignment_4()); 
            }
            // InternalAle.g:4264:2: ( rule__RIf__IfBlockAssignment_4 )
            // InternalAle.g:4264:3: rule__RIf__IfBlockAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__RIf__IfBlockAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getIfBlockAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__4__Impl"


    // $ANTLR start "rule__RIf__Group__5"
    // InternalAle.g:4272:1: rule__RIf__Group__5 : rule__RIf__Group__5__Impl ;
    public final void rule__RIf__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4276:1: ( rule__RIf__Group__5__Impl )
            // InternalAle.g:4277:2: rule__RIf__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RIf__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__5"


    // $ANTLR start "rule__RIf__Group__5__Impl"
    // InternalAle.g:4283:1: rule__RIf__Group__5__Impl : ( ( rule__RIf__Group_5__0 )? ) ;
    public final void rule__RIf__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4287:1: ( ( ( rule__RIf__Group_5__0 )? ) )
            // InternalAle.g:4288:1: ( ( rule__RIf__Group_5__0 )? )
            {
            // InternalAle.g:4288:1: ( ( rule__RIf__Group_5__0 )? )
            // InternalAle.g:4289:2: ( rule__RIf__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getGroup_5()); 
            }
            // InternalAle.g:4290:2: ( rule__RIf__Group_5__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==54) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAle.g:4290:3: rule__RIf__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RIf__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group__5__Impl"


    // $ANTLR start "rule__RIf__Group_5__0"
    // InternalAle.g:4299:1: rule__RIf__Group_5__0 : rule__RIf__Group_5__0__Impl rule__RIf__Group_5__1 ;
    public final void rule__RIf__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4303:1: ( rule__RIf__Group_5__0__Impl rule__RIf__Group_5__1 )
            // InternalAle.g:4304:2: rule__RIf__Group_5__0__Impl rule__RIf__Group_5__1
            {
            pushFollow(FOLLOW_21);
            rule__RIf__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RIf__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group_5__0"


    // $ANTLR start "rule__RIf__Group_5__0__Impl"
    // InternalAle.g:4311:1: rule__RIf__Group_5__0__Impl : ( 'else' ) ;
    public final void rule__RIf__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4315:1: ( ( 'else' ) )
            // InternalAle.g:4316:1: ( 'else' )
            {
            // InternalAle.g:4316:1: ( 'else' )
            // InternalAle.g:4317:2: 'else'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getElseKeyword_5_0()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getElseKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group_5__0__Impl"


    // $ANTLR start "rule__RIf__Group_5__1"
    // InternalAle.g:4326:1: rule__RIf__Group_5__1 : rule__RIf__Group_5__1__Impl ;
    public final void rule__RIf__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4330:1: ( rule__RIf__Group_5__1__Impl )
            // InternalAle.g:4331:2: rule__RIf__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RIf__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group_5__1"


    // $ANTLR start "rule__RIf__Group_5__1__Impl"
    // InternalAle.g:4337:1: rule__RIf__Group_5__1__Impl : ( ( rule__RIf__ElseBlockAssignment_5_1 ) ) ;
    public final void rule__RIf__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4341:1: ( ( ( rule__RIf__ElseBlockAssignment_5_1 ) ) )
            // InternalAle.g:4342:1: ( ( rule__RIf__ElseBlockAssignment_5_1 ) )
            {
            // InternalAle.g:4342:1: ( ( rule__RIf__ElseBlockAssignment_5_1 ) )
            // InternalAle.g:4343:2: ( rule__RIf__ElseBlockAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getElseBlockAssignment_5_1()); 
            }
            // InternalAle.g:4344:2: ( rule__RIf__ElseBlockAssignment_5_1 )
            // InternalAle.g:4344:3: rule__RIf__ElseBlockAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__RIf__ElseBlockAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getElseBlockAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__Group_5__1__Impl"


    // $ANTLR start "rule__RWhile__Group__0"
    // InternalAle.g:4353:1: rule__RWhile__Group__0 : rule__RWhile__Group__0__Impl rule__RWhile__Group__1 ;
    public final void rule__RWhile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4357:1: ( rule__RWhile__Group__0__Impl rule__RWhile__Group__1 )
            // InternalAle.g:4358:2: rule__RWhile__Group__0__Impl rule__RWhile__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__RWhile__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RWhile__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__0"


    // $ANTLR start "rule__RWhile__Group__0__Impl"
    // InternalAle.g:4365:1: rule__RWhile__Group__0__Impl : ( 'while' ) ;
    public final void rule__RWhile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4369:1: ( ( 'while' ) )
            // InternalAle.g:4370:1: ( 'while' )
            {
            // InternalAle.g:4370:1: ( 'while' )
            // InternalAle.g:4371:2: 'while'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getWhileKeyword_0()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRWhileAccess().getWhileKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__0__Impl"


    // $ANTLR start "rule__RWhile__Group__1"
    // InternalAle.g:4380:1: rule__RWhile__Group__1 : rule__RWhile__Group__1__Impl rule__RWhile__Group__2 ;
    public final void rule__RWhile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4384:1: ( rule__RWhile__Group__1__Impl rule__RWhile__Group__2 )
            // InternalAle.g:4385:2: rule__RWhile__Group__1__Impl rule__RWhile__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__RWhile__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RWhile__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__1"


    // $ANTLR start "rule__RWhile__Group__1__Impl"
    // InternalAle.g:4392:1: rule__RWhile__Group__1__Impl : ( '(' ) ;
    public final void rule__RWhile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4396:1: ( ( '(' ) )
            // InternalAle.g:4397:1: ( '(' )
            {
            // InternalAle.g:4397:1: ( '(' )
            // InternalAle.g:4398:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRWhileAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__1__Impl"


    // $ANTLR start "rule__RWhile__Group__2"
    // InternalAle.g:4407:1: rule__RWhile__Group__2 : rule__RWhile__Group__2__Impl rule__RWhile__Group__3 ;
    public final void rule__RWhile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4411:1: ( rule__RWhile__Group__2__Impl rule__RWhile__Group__3 )
            // InternalAle.g:4412:2: rule__RWhile__Group__2__Impl rule__RWhile__Group__3
            {
            pushFollow(FOLLOW_35);
            rule__RWhile__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RWhile__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__2"


    // $ANTLR start "rule__RWhile__Group__2__Impl"
    // InternalAle.g:4419:1: rule__RWhile__Group__2__Impl : ( ruleexpression ) ;
    public final void rule__RWhile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4423:1: ( ( ruleexpression ) )
            // InternalAle.g:4424:1: ( ruleexpression )
            {
            // InternalAle.g:4424:1: ( ruleexpression )
            // InternalAle.g:4425:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getExpressionParserRuleCall_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRWhileAccess().getExpressionParserRuleCall_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__2__Impl"


    // $ANTLR start "rule__RWhile__Group__3"
    // InternalAle.g:4434:1: rule__RWhile__Group__3 : rule__RWhile__Group__3__Impl rule__RWhile__Group__4 ;
    public final void rule__RWhile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4438:1: ( rule__RWhile__Group__3__Impl rule__RWhile__Group__4 )
            // InternalAle.g:4439:2: rule__RWhile__Group__3__Impl rule__RWhile__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__RWhile__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RWhile__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__3"


    // $ANTLR start "rule__RWhile__Group__3__Impl"
    // InternalAle.g:4446:1: rule__RWhile__Group__3__Impl : ( ')' ) ;
    public final void rule__RWhile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4450:1: ( ( ')' ) )
            // InternalAle.g:4451:1: ( ')' )
            {
            // InternalAle.g:4451:1: ( ')' )
            // InternalAle.g:4452:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRWhileAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__3__Impl"


    // $ANTLR start "rule__RWhile__Group__4"
    // InternalAle.g:4461:1: rule__RWhile__Group__4 : rule__RWhile__Group__4__Impl ;
    public final void rule__RWhile__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4465:1: ( rule__RWhile__Group__4__Impl )
            // InternalAle.g:4466:2: rule__RWhile__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RWhile__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__4"


    // $ANTLR start "rule__RWhile__Group__4__Impl"
    // InternalAle.g:4472:1: rule__RWhile__Group__4__Impl : ( ( rule__RWhile__BlockAssignment_4 ) ) ;
    public final void rule__RWhile__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4476:1: ( ( ( rule__RWhile__BlockAssignment_4 ) ) )
            // InternalAle.g:4477:1: ( ( rule__RWhile__BlockAssignment_4 ) )
            {
            // InternalAle.g:4477:1: ( ( rule__RWhile__BlockAssignment_4 ) )
            // InternalAle.g:4478:2: ( rule__RWhile__BlockAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getBlockAssignment_4()); 
            }
            // InternalAle.g:4479:2: ( rule__RWhile__BlockAssignment_4 )
            // InternalAle.g:4479:3: rule__RWhile__BlockAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__RWhile__BlockAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRWhileAccess().getBlockAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__Group__4__Impl"


    // $ANTLR start "rule__RExpression__Group__0"
    // InternalAle.g:4488:1: rule__RExpression__Group__0 : rule__RExpression__Group__0__Impl rule__RExpression__Group__1 ;
    public final void rule__RExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4492:1: ( rule__RExpression__Group__0__Impl rule__RExpression__Group__1 )
            // InternalAle.g:4493:2: rule__RExpression__Group__0__Impl rule__RExpression__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__RExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RExpression__Group__0"


    // $ANTLR start "rule__RExpression__Group__0__Impl"
    // InternalAle.g:4500:1: rule__RExpression__Group__0__Impl : ( ruleexpression ) ;
    public final void rule__RExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4504:1: ( ( ruleexpression ) )
            // InternalAle.g:4505:1: ( ruleexpression )
            {
            // InternalAle.g:4505:1: ( ruleexpression )
            // InternalAle.g:4506:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRExpressionAccess().getExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRExpressionAccess().getExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RExpression__Group__0__Impl"


    // $ANTLR start "rule__RExpression__Group__1"
    // InternalAle.g:4515:1: rule__RExpression__Group__1 : rule__RExpression__Group__1__Impl ;
    public final void rule__RExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4519:1: ( rule__RExpression__Group__1__Impl )
            // InternalAle.g:4520:2: rule__RExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RExpression__Group__1"


    // $ANTLR start "rule__RExpression__Group__1__Impl"
    // InternalAle.g:4526:1: rule__RExpression__Group__1__Impl : ( ';' ) ;
    public final void rule__RExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4530:1: ( ( ';' ) )
            // InternalAle.g:4531:1: ( ';' )
            {
            // InternalAle.g:4531:1: ( ';' )
            // InternalAle.g:4532:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRExpressionAccess().getSemicolonKeyword_1()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRExpressionAccess().getSemicolonKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RExpression__Group__1__Impl"


    // $ANTLR start "rule__Expression__Group__0"
    // InternalAle.g:4542:1: rule__Expression__Group__0 : rule__Expression__Group__0__Impl rule__Expression__Group__1 ;
    public final void rule__Expression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4546:1: ( rule__Expression__Group__0__Impl rule__Expression__Group__1 )
            // InternalAle.g:4547:2: rule__Expression__Group__0__Impl rule__Expression__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__Expression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Expression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group__0"


    // $ANTLR start "rule__Expression__Group__0__Impl"
    // InternalAle.g:4554:1: rule__Expression__Group__0__Impl : ( ( rule__Expression__LeftPartAssignment_0 ) ) ;
    public final void rule__Expression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4558:1: ( ( ( rule__Expression__LeftPartAssignment_0 ) ) )
            // InternalAle.g:4559:1: ( ( rule__Expression__LeftPartAssignment_0 ) )
            {
            // InternalAle.g:4559:1: ( ( rule__Expression__LeftPartAssignment_0 ) )
            // InternalAle.g:4560:2: ( rule__Expression__LeftPartAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getLeftPartAssignment_0()); 
            }
            // InternalAle.g:4561:2: ( rule__Expression__LeftPartAssignment_0 )
            // InternalAle.g:4561:3: rule__Expression__LeftPartAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Expression__LeftPartAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getLeftPartAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group__0__Impl"


    // $ANTLR start "rule__Expression__Group__1"
    // InternalAle.g:4569:1: rule__Expression__Group__1 : rule__Expression__Group__1__Impl ;
    public final void rule__Expression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4573:1: ( rule__Expression__Group__1__Impl )
            // InternalAle.g:4574:2: rule__Expression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group__1"


    // $ANTLR start "rule__Expression__Group__1__Impl"
    // InternalAle.g:4580:1: rule__Expression__Group__1__Impl : ( ( rule__Expression__RecpartAssignment_1 )? ) ;
    public final void rule__Expression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4584:1: ( ( ( rule__Expression__RecpartAssignment_1 )? ) )
            // InternalAle.g:4585:1: ( ( rule__Expression__RecpartAssignment_1 )? )
            {
            // InternalAle.g:4585:1: ( ( rule__Expression__RecpartAssignment_1 )? )
            // InternalAle.g:4586:2: ( rule__Expression__RecpartAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getRecpartAssignment_1()); 
            }
            // InternalAle.g:4587:2: ( rule__Expression__RecpartAssignment_1 )?
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // InternalAle.g:4587:3: rule__Expression__RecpartAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Expression__RecpartAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getRecpartAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group__1__Impl"


    // $ANTLR start "rule__RecExpression__Group__0"
    // InternalAle.g:4596:1: rule__RecExpression__Group__0 : rule__RecExpression__Group__0__Impl rule__RecExpression__Group__1 ;
    public final void rule__RecExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4600:1: ( rule__RecExpression__Group__0__Impl rule__RecExpression__Group__1 )
            // InternalAle.g:4601:2: rule__RecExpression__Group__0__Impl rule__RecExpression__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__RecExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group__0"


    // $ANTLR start "rule__RecExpression__Group__0__Impl"
    // InternalAle.g:4608:1: rule__RecExpression__Group__0__Impl : ( ( rule__RecExpression__Alternatives_0 ) ) ;
    public final void rule__RecExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4612:1: ( ( ( rule__RecExpression__Alternatives_0 ) ) )
            // InternalAle.g:4613:1: ( ( rule__RecExpression__Alternatives_0 ) )
            {
            // InternalAle.g:4613:1: ( ( rule__RecExpression__Alternatives_0 ) )
            // InternalAle.g:4614:2: ( rule__RecExpression__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getAlternatives_0()); 
            }
            // InternalAle.g:4615:2: ( rule__RecExpression__Alternatives_0 )
            // InternalAle.g:4615:3: rule__RecExpression__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group__0__Impl"


    // $ANTLR start "rule__RecExpression__Group__1"
    // InternalAle.g:4623:1: rule__RecExpression__Group__1 : rule__RecExpression__Group__1__Impl ;
    public final void rule__RecExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4627:1: ( rule__RecExpression__Group__1__Impl )
            // InternalAle.g:4628:2: rule__RecExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group__1"


    // $ANTLR start "rule__RecExpression__Group__1__Impl"
    // InternalAle.g:4634:1: rule__RecExpression__Group__1__Impl : ( ( rule__RecExpression__RecExpAssignment_1 )? ) ;
    public final void rule__RecExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4638:1: ( ( ( rule__RecExpression__RecExpAssignment_1 )? ) )
            // InternalAle.g:4639:1: ( ( rule__RecExpression__RecExpAssignment_1 )? )
            {
            // InternalAle.g:4639:1: ( ( rule__RecExpression__RecExpAssignment_1 )? )
            // InternalAle.g:4640:2: ( rule__RecExpression__RecExpAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getRecExpAssignment_1()); 
            }
            // InternalAle.g:4641:2: ( rule__RecExpression__RecExpAssignment_1 )?
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // InternalAle.g:4641:3: rule__RecExpression__RecExpAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__RecExpression__RecExpAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getRecExpAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group__1__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_1__0"
    // InternalAle.g:4650:1: rule__RecExpression__Group_0_1__0 : rule__RecExpression__Group_0_1__0__Impl rule__RecExpression__Group_0_1__1 ;
    public final void rule__RecExpression__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4654:1: ( rule__RecExpression__Group_0_1__0__Impl rule__RecExpression__Group_0_1__1 )
            // InternalAle.g:4655:2: rule__RecExpression__Group_0_1__0__Impl rule__RecExpression__Group_0_1__1
            {
            pushFollow(FOLLOW_28);
            rule__RecExpression__Group_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_1__0"


    // $ANTLR start "rule__RecExpression__Group_0_1__0__Impl"
    // InternalAle.g:4662:1: rule__RecExpression__Group_0_1__0__Impl : ( RULE_MULT_OP ) ;
    public final void rule__RecExpression__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4666:1: ( ( RULE_MULT_OP ) )
            // InternalAle.g:4667:1: ( RULE_MULT_OP )
            {
            // InternalAle.g:4667:1: ( RULE_MULT_OP )
            // InternalAle.g:4668:2: RULE_MULT_OP
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getMULT_OPTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_MULT_OP,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getMULT_OPTerminalRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_1__0__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_1__1"
    // InternalAle.g:4677:1: rule__RecExpression__Group_0_1__1 : rule__RecExpression__Group_0_1__1__Impl ;
    public final void rule__RecExpression__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4681:1: ( rule__RecExpression__Group_0_1__1__Impl )
            // InternalAle.g:4682:2: rule__RecExpression__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_1__1"


    // $ANTLR start "rule__RecExpression__Group_0_1__1__Impl"
    // InternalAle.g:4688:1: rule__RecExpression__Group_0_1__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4692:1: ( ( ruleexpression ) )
            // InternalAle.g:4693:1: ( ruleexpression )
            {
            // InternalAle.g:4693:1: ( ruleexpression )
            // InternalAle.g:4694:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_1_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_1__1__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_2__0"
    // InternalAle.g:4704:1: rule__RecExpression__Group_0_2__0 : rule__RecExpression__Group_0_2__0__Impl rule__RecExpression__Group_0_2__1 ;
    public final void rule__RecExpression__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4708:1: ( rule__RecExpression__Group_0_2__0__Impl rule__RecExpression__Group_0_2__1 )
            // InternalAle.g:4709:2: rule__RecExpression__Group_0_2__0__Impl rule__RecExpression__Group_0_2__1
            {
            pushFollow(FOLLOW_28);
            rule__RecExpression__Group_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_2__0"


    // $ANTLR start "rule__RecExpression__Group_0_2__0__Impl"
    // InternalAle.g:4716:1: rule__RecExpression__Group_0_2__0__Impl : ( RULE_ADD_OP ) ;
    public final void rule__RecExpression__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4720:1: ( ( RULE_ADD_OP ) )
            // InternalAle.g:4721:1: ( RULE_ADD_OP )
            {
            // InternalAle.g:4721:1: ( RULE_ADD_OP )
            // InternalAle.g:4722:2: RULE_ADD_OP
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getADD_OPTerminalRuleCall_0_2_0()); 
            }
            match(input,RULE_ADD_OP,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getADD_OPTerminalRuleCall_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_2__0__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_2__1"
    // InternalAle.g:4731:1: rule__RecExpression__Group_0_2__1 : rule__RecExpression__Group_0_2__1__Impl ;
    public final void rule__RecExpression__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4735:1: ( rule__RecExpression__Group_0_2__1__Impl )
            // InternalAle.g:4736:2: rule__RecExpression__Group_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_2__1"


    // $ANTLR start "rule__RecExpression__Group_0_2__1__Impl"
    // InternalAle.g:4742:1: rule__RecExpression__Group_0_2__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4746:1: ( ( ruleexpression ) )
            // InternalAle.g:4747:1: ( ruleexpression )
            {
            // InternalAle.g:4747:1: ( ruleexpression )
            // InternalAle.g:4748:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_2_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_2__1__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_3__0"
    // InternalAle.g:4758:1: rule__RecExpression__Group_0_3__0 : rule__RecExpression__Group_0_3__0__Impl rule__RecExpression__Group_0_3__1 ;
    public final void rule__RecExpression__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4762:1: ( rule__RecExpression__Group_0_3__0__Impl rule__RecExpression__Group_0_3__1 )
            // InternalAle.g:4763:2: rule__RecExpression__Group_0_3__0__Impl rule__RecExpression__Group_0_3__1
            {
            pushFollow(FOLLOW_28);
            rule__RecExpression__Group_0_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_3__0"


    // $ANTLR start "rule__RecExpression__Group_0_3__0__Impl"
    // InternalAle.g:4770:1: rule__RecExpression__Group_0_3__0__Impl : ( RULE_COMP_OP ) ;
    public final void rule__RecExpression__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4774:1: ( ( RULE_COMP_OP ) )
            // InternalAle.g:4775:1: ( RULE_COMP_OP )
            {
            // InternalAle.g:4775:1: ( RULE_COMP_OP )
            // InternalAle.g:4776:2: RULE_COMP_OP
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getCOMP_OPTerminalRuleCall_0_3_0()); 
            }
            match(input,RULE_COMP_OP,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getCOMP_OPTerminalRuleCall_0_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_3__0__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_3__1"
    // InternalAle.g:4785:1: rule__RecExpression__Group_0_3__1 : rule__RecExpression__Group_0_3__1__Impl ;
    public final void rule__RecExpression__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4789:1: ( rule__RecExpression__Group_0_3__1__Impl )
            // InternalAle.g:4790:2: rule__RecExpression__Group_0_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_3__1"


    // $ANTLR start "rule__RecExpression__Group_0_3__1__Impl"
    // InternalAle.g:4796:1: rule__RecExpression__Group_0_3__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4800:1: ( ( ruleexpression ) )
            // InternalAle.g:4801:1: ( ruleexpression )
            {
            // InternalAle.g:4801:1: ( ruleexpression )
            // InternalAle.g:4802:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_3_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_3__1__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_4__0"
    // InternalAle.g:4812:1: rule__RecExpression__Group_0_4__0 : rule__RecExpression__Group_0_4__0__Impl rule__RecExpression__Group_0_4__1 ;
    public final void rule__RecExpression__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4816:1: ( rule__RecExpression__Group_0_4__0__Impl rule__RecExpression__Group_0_4__1 )
            // InternalAle.g:4817:2: rule__RecExpression__Group_0_4__0__Impl rule__RecExpression__Group_0_4__1
            {
            pushFollow(FOLLOW_28);
            rule__RecExpression__Group_0_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_4__0"


    // $ANTLR start "rule__RecExpression__Group_0_4__0__Impl"
    // InternalAle.g:4824:1: rule__RecExpression__Group_0_4__0__Impl : ( 'and' ) ;
    public final void rule__RecExpression__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4828:1: ( ( 'and' ) )
            // InternalAle.g:4829:1: ( 'and' )
            {
            // InternalAle.g:4829:1: ( 'and' )
            // InternalAle.g:4830:2: 'and'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getAndKeyword_0_4_0()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getAndKeyword_0_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_4__0__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_4__1"
    // InternalAle.g:4839:1: rule__RecExpression__Group_0_4__1 : rule__RecExpression__Group_0_4__1__Impl ;
    public final void rule__RecExpression__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4843:1: ( rule__RecExpression__Group_0_4__1__Impl )
            // InternalAle.g:4844:2: rule__RecExpression__Group_0_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_4__1"


    // $ANTLR start "rule__RecExpression__Group_0_4__1__Impl"
    // InternalAle.g:4850:1: rule__RecExpression__Group_0_4__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4854:1: ( ( ruleexpression ) )
            // InternalAle.g:4855:1: ( ruleexpression )
            {
            // InternalAle.g:4855:1: ( ruleexpression )
            // InternalAle.g:4856:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_4_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_4__1__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_5__0"
    // InternalAle.g:4866:1: rule__RecExpression__Group_0_5__0 : rule__RecExpression__Group_0_5__0__Impl rule__RecExpression__Group_0_5__1 ;
    public final void rule__RecExpression__Group_0_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4870:1: ( rule__RecExpression__Group_0_5__0__Impl rule__RecExpression__Group_0_5__1 )
            // InternalAle.g:4871:2: rule__RecExpression__Group_0_5__0__Impl rule__RecExpression__Group_0_5__1
            {
            pushFollow(FOLLOW_28);
            rule__RecExpression__Group_0_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_5__0"


    // $ANTLR start "rule__RecExpression__Group_0_5__0__Impl"
    // InternalAle.g:4878:1: rule__RecExpression__Group_0_5__0__Impl : ( 'or' ) ;
    public final void rule__RecExpression__Group_0_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4882:1: ( ( 'or' ) )
            // InternalAle.g:4883:1: ( 'or' )
            {
            // InternalAle.g:4883:1: ( 'or' )
            // InternalAle.g:4884:2: 'or'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getOrKeyword_0_5_0()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getOrKeyword_0_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_5__0__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_5__1"
    // InternalAle.g:4893:1: rule__RecExpression__Group_0_5__1 : rule__RecExpression__Group_0_5__1__Impl ;
    public final void rule__RecExpression__Group_0_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4897:1: ( rule__RecExpression__Group_0_5__1__Impl )
            // InternalAle.g:4898:2: rule__RecExpression__Group_0_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_5__1"


    // $ANTLR start "rule__RecExpression__Group_0_5__1__Impl"
    // InternalAle.g:4904:1: rule__RecExpression__Group_0_5__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4908:1: ( ( ruleexpression ) )
            // InternalAle.g:4909:1: ( ruleexpression )
            {
            // InternalAle.g:4909:1: ( ruleexpression )
            // InternalAle.g:4910:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_5_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_5__1__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_6__0"
    // InternalAle.g:4920:1: rule__RecExpression__Group_0_6__0 : rule__RecExpression__Group_0_6__0__Impl rule__RecExpression__Group_0_6__1 ;
    public final void rule__RecExpression__Group_0_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4924:1: ( rule__RecExpression__Group_0_6__0__Impl rule__RecExpression__Group_0_6__1 )
            // InternalAle.g:4925:2: rule__RecExpression__Group_0_6__0__Impl rule__RecExpression__Group_0_6__1
            {
            pushFollow(FOLLOW_28);
            rule__RecExpression__Group_0_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_6__0"


    // $ANTLR start "rule__RecExpression__Group_0_6__0__Impl"
    // InternalAle.g:4932:1: rule__RecExpression__Group_0_6__0__Impl : ( 'xor' ) ;
    public final void rule__RecExpression__Group_0_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4936:1: ( ( 'xor' ) )
            // InternalAle.g:4937:1: ( 'xor' )
            {
            // InternalAle.g:4937:1: ( 'xor' )
            // InternalAle.g:4938:2: 'xor'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getXorKeyword_0_6_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getXorKeyword_0_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_6__0__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_6__1"
    // InternalAle.g:4947:1: rule__RecExpression__Group_0_6__1 : rule__RecExpression__Group_0_6__1__Impl ;
    public final void rule__RecExpression__Group_0_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4951:1: ( rule__RecExpression__Group_0_6__1__Impl )
            // InternalAle.g:4952:2: rule__RecExpression__Group_0_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_6__1"


    // $ANTLR start "rule__RecExpression__Group_0_6__1__Impl"
    // InternalAle.g:4958:1: rule__RecExpression__Group_0_6__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4962:1: ( ( ruleexpression ) )
            // InternalAle.g:4963:1: ( ruleexpression )
            {
            // InternalAle.g:4963:1: ( ruleexpression )
            // InternalAle.g:4964:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_6_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_6__1__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_7__0"
    // InternalAle.g:4974:1: rule__RecExpression__Group_0_7__0 : rule__RecExpression__Group_0_7__0__Impl rule__RecExpression__Group_0_7__1 ;
    public final void rule__RecExpression__Group_0_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4978:1: ( rule__RecExpression__Group_0_7__0__Impl rule__RecExpression__Group_0_7__1 )
            // InternalAle.g:4979:2: rule__RecExpression__Group_0_7__0__Impl rule__RecExpression__Group_0_7__1
            {
            pushFollow(FOLLOW_28);
            rule__RecExpression__Group_0_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_7__0"


    // $ANTLR start "rule__RecExpression__Group_0_7__0__Impl"
    // InternalAle.g:4986:1: rule__RecExpression__Group_0_7__0__Impl : ( 'implies' ) ;
    public final void rule__RecExpression__Group_0_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4990:1: ( ( 'implies' ) )
            // InternalAle.g:4991:1: ( 'implies' )
            {
            // InternalAle.g:4991:1: ( 'implies' )
            // InternalAle.g:4992:2: 'implies'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getImpliesKeyword_0_7_0()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getImpliesKeyword_0_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_7__0__Impl"


    // $ANTLR start "rule__RecExpression__Group_0_7__1"
    // InternalAle.g:5001:1: rule__RecExpression__Group_0_7__1 : rule__RecExpression__Group_0_7__1__Impl ;
    public final void rule__RecExpression__Group_0_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5005:1: ( rule__RecExpression__Group_0_7__1__Impl )
            // InternalAle.g:5006:2: rule__RecExpression__Group_0_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RecExpression__Group_0_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_7__1"


    // $ANTLR start "rule__RecExpression__Group_0_7__1__Impl"
    // InternalAle.g:5012:1: rule__RecExpression__Group_0_7__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5016:1: ( ( ruleexpression ) )
            // InternalAle.g:5017:1: ( ruleexpression )
            {
            // InternalAle.g:5017:1: ( ruleexpression )
            // InternalAle.g:5018:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_7_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getExpressionParserRuleCall_0_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__Group_0_7__1__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_0__0"
    // InternalAle.g:5028:1: rule__NavigationSegment__Group_0__0 : rule__NavigationSegment__Group_0__0__Impl rule__NavigationSegment__Group_0__1 ;
    public final void rule__NavigationSegment__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5032:1: ( rule__NavigationSegment__Group_0__0__Impl rule__NavigationSegment__Group_0__1 )
            // InternalAle.g:5033:2: rule__NavigationSegment__Group_0__0__Impl rule__NavigationSegment__Group_0__1
            {
            pushFollow(FOLLOW_44);
            rule__NavigationSegment__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_0__0"


    // $ANTLR start "rule__NavigationSegment__Group_0__0__Impl"
    // InternalAle.g:5040:1: rule__NavigationSegment__Group_0__0__Impl : ( () ) ;
    public final void rule__NavigationSegment__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5044:1: ( ( () ) )
            // InternalAle.g:5045:1: ( () )
            {
            // InternalAle.g:5045:1: ( () )
            // InternalAle.g:5046:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFinalIdentSegmentAction_0_0()); 
            }
            // InternalAle.g:5047:2: ()
            // InternalAle.g:5047:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getFinalIdentSegmentAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_0__0__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_0__1"
    // InternalAle.g:5055:1: rule__NavigationSegment__Group_0__1 : rule__NavigationSegment__Group_0__1__Impl rule__NavigationSegment__Group_0__2 ;
    public final void rule__NavigationSegment__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5059:1: ( rule__NavigationSegment__Group_0__1__Impl rule__NavigationSegment__Group_0__2 )
            // InternalAle.g:5060:2: rule__NavigationSegment__Group_0__1__Impl rule__NavigationSegment__Group_0__2
            {
            pushFollow(FOLLOW_3);
            rule__NavigationSegment__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_0__1"


    // $ANTLR start "rule__NavigationSegment__Group_0__1__Impl"
    // InternalAle.g:5067:1: rule__NavigationSegment__Group_0__1__Impl : ( '.' ) ;
    public final void rule__NavigationSegment__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5071:1: ( ( '.' ) )
            // InternalAle.g:5072:1: ( '.' )
            {
            // InternalAle.g:5072:1: ( '.' )
            // InternalAle.g:5073:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_0_1()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_0__1__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_0__2"
    // InternalAle.g:5082:1: rule__NavigationSegment__Group_0__2 : rule__NavigationSegment__Group_0__2__Impl ;
    public final void rule__NavigationSegment__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5086:1: ( rule__NavigationSegment__Group_0__2__Impl )
            // InternalAle.g:5087:2: rule__NavigationSegment__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_0__2"


    // $ANTLR start "rule__NavigationSegment__Group_0__2__Impl"
    // InternalAle.g:5093:1: rule__NavigationSegment__Group_0__2__Impl : ( ( rule__NavigationSegment__IdentAssignment_0_2 ) ) ;
    public final void rule__NavigationSegment__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5097:1: ( ( ( rule__NavigationSegment__IdentAssignment_0_2 ) ) )
            // InternalAle.g:5098:1: ( ( rule__NavigationSegment__IdentAssignment_0_2 ) )
            {
            // InternalAle.g:5098:1: ( ( rule__NavigationSegment__IdentAssignment_0_2 ) )
            // InternalAle.g:5099:2: ( rule__NavigationSegment__IdentAssignment_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getIdentAssignment_0_2()); 
            }
            // InternalAle.g:5100:2: ( rule__NavigationSegment__IdentAssignment_0_2 )
            // InternalAle.g:5100:3: rule__NavigationSegment__IdentAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__IdentAssignment_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getIdentAssignment_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_0__2__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_1__0"
    // InternalAle.g:5109:1: rule__NavigationSegment__Group_1__0 : rule__NavigationSegment__Group_1__0__Impl rule__NavigationSegment__Group_1__1 ;
    public final void rule__NavigationSegment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5113:1: ( rule__NavigationSegment__Group_1__0__Impl rule__NavigationSegment__Group_1__1 )
            // InternalAle.g:5114:2: rule__NavigationSegment__Group_1__0__Impl rule__NavigationSegment__Group_1__1
            {
            pushFollow(FOLLOW_44);
            rule__NavigationSegment__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_1__0"


    // $ANTLR start "rule__NavigationSegment__Group_1__0__Impl"
    // InternalAle.g:5121:1: rule__NavigationSegment__Group_1__0__Impl : ( () ) ;
    public final void rule__NavigationSegment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5125:1: ( ( () ) )
            // InternalAle.g:5126:1: ( () )
            {
            // InternalAle.g:5126:1: ( () )
            // InternalAle.g:5127:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFinalIdentCallSegmentAction_1_0()); 
            }
            // InternalAle.g:5128:2: ()
            // InternalAle.g:5128:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getFinalIdentCallSegmentAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_1__0__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_1__1"
    // InternalAle.g:5136:1: rule__NavigationSegment__Group_1__1 : rule__NavigationSegment__Group_1__1__Impl rule__NavigationSegment__Group_1__2 ;
    public final void rule__NavigationSegment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5140:1: ( rule__NavigationSegment__Group_1__1__Impl rule__NavigationSegment__Group_1__2 )
            // InternalAle.g:5141:2: rule__NavigationSegment__Group_1__1__Impl rule__NavigationSegment__Group_1__2
            {
            pushFollow(FOLLOW_45);
            rule__NavigationSegment__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_1__1"


    // $ANTLR start "rule__NavigationSegment__Group_1__1__Impl"
    // InternalAle.g:5148:1: rule__NavigationSegment__Group_1__1__Impl : ( '.' ) ;
    public final void rule__NavigationSegment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5152:1: ( ( '.' ) )
            // InternalAle.g:5153:1: ( '.' )
            {
            // InternalAle.g:5153:1: ( '.' )
            // InternalAle.g:5154:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_1_1()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_1__1__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_1__2"
    // InternalAle.g:5163:1: rule__NavigationSegment__Group_1__2 : rule__NavigationSegment__Group_1__2__Impl ;
    public final void rule__NavigationSegment__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5167:1: ( rule__NavigationSegment__Group_1__2__Impl )
            // InternalAle.g:5168:2: rule__NavigationSegment__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_1__2"


    // $ANTLR start "rule__NavigationSegment__Group_1__2__Impl"
    // InternalAle.g:5174:1: rule__NavigationSegment__Group_1__2__Impl : ( ( rule__NavigationSegment__CallAssignment_1_2 ) ) ;
    public final void rule__NavigationSegment__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5178:1: ( ( ( rule__NavigationSegment__CallAssignment_1_2 ) ) )
            // InternalAle.g:5179:1: ( ( rule__NavigationSegment__CallAssignment_1_2 ) )
            {
            // InternalAle.g:5179:1: ( ( rule__NavigationSegment__CallAssignment_1_2 ) )
            // InternalAle.g:5180:2: ( rule__NavigationSegment__CallAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getCallAssignment_1_2()); 
            }
            // InternalAle.g:5181:2: ( rule__NavigationSegment__CallAssignment_1_2 )
            // InternalAle.g:5181:3: rule__NavigationSegment__CallAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__CallAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getCallAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_1__2__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_2__0"
    // InternalAle.g:5190:1: rule__NavigationSegment__Group_2__0 : rule__NavigationSegment__Group_2__0__Impl rule__NavigationSegment__Group_2__1 ;
    public final void rule__NavigationSegment__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5194:1: ( rule__NavigationSegment__Group_2__0__Impl rule__NavigationSegment__Group_2__1 )
            // InternalAle.g:5195:2: rule__NavigationSegment__Group_2__0__Impl rule__NavigationSegment__Group_2__1
            {
            pushFollow(FOLLOW_46);
            rule__NavigationSegment__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_2__0"


    // $ANTLR start "rule__NavigationSegment__Group_2__0__Impl"
    // InternalAle.g:5202:1: rule__NavigationSegment__Group_2__0__Impl : ( () ) ;
    public final void rule__NavigationSegment__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5206:1: ( ( () ) )
            // InternalAle.g:5207:1: ( () )
            {
            // InternalAle.g:5207:1: ( () )
            // InternalAle.g:5208:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFinalCallExpSegmentAction_2_0()); 
            }
            // InternalAle.g:5209:2: ()
            // InternalAle.g:5209:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getFinalCallExpSegmentAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_2__0__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_2__1"
    // InternalAle.g:5217:1: rule__NavigationSegment__Group_2__1 : rule__NavigationSegment__Group_2__1__Impl rule__NavigationSegment__Group_2__2 ;
    public final void rule__NavigationSegment__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5221:1: ( rule__NavigationSegment__Group_2__1__Impl rule__NavigationSegment__Group_2__2 )
            // InternalAle.g:5222:2: rule__NavigationSegment__Group_2__1__Impl rule__NavigationSegment__Group_2__2
            {
            pushFollow(FOLLOW_45);
            rule__NavigationSegment__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_2__1"


    // $ANTLR start "rule__NavigationSegment__Group_2__1__Impl"
    // InternalAle.g:5229:1: rule__NavigationSegment__Group_2__1__Impl : ( '->' ) ;
    public final void rule__NavigationSegment__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5233:1: ( ( '->' ) )
            // InternalAle.g:5234:1: ( '->' )
            {
            // InternalAle.g:5234:1: ( '->' )
            // InternalAle.g:5235:2: '->'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getHyphenMinusGreaterThanSignKeyword_2_1()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getHyphenMinusGreaterThanSignKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_2__1__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_2__2"
    // InternalAle.g:5244:1: rule__NavigationSegment__Group_2__2 : rule__NavigationSegment__Group_2__2__Impl ;
    public final void rule__NavigationSegment__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5248:1: ( rule__NavigationSegment__Group_2__2__Impl )
            // InternalAle.g:5249:2: rule__NavigationSegment__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_2__2"


    // $ANTLR start "rule__NavigationSegment__Group_2__2__Impl"
    // InternalAle.g:5255:1: rule__NavigationSegment__Group_2__2__Impl : ( ( rule__NavigationSegment__CallAssignment_2_2 ) ) ;
    public final void rule__NavigationSegment__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5259:1: ( ( ( rule__NavigationSegment__CallAssignment_2_2 ) ) )
            // InternalAle.g:5260:1: ( ( rule__NavigationSegment__CallAssignment_2_2 ) )
            {
            // InternalAle.g:5260:1: ( ( rule__NavigationSegment__CallAssignment_2_2 ) )
            // InternalAle.g:5261:2: ( rule__NavigationSegment__CallAssignment_2_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getCallAssignment_2_2()); 
            }
            // InternalAle.g:5262:2: ( rule__NavigationSegment__CallAssignment_2_2 )
            // InternalAle.g:5262:3: rule__NavigationSegment__CallAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__CallAssignment_2_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getCallAssignment_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_2__2__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_0__0"
    // InternalAle.g:5271:1: rule__NonLeftRecExpression__Group_0__0 : rule__NonLeftRecExpression__Group_0__0__Impl rule__NonLeftRecExpression__Group_0__1 ;
    public final void rule__NonLeftRecExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5275:1: ( rule__NonLeftRecExpression__Group_0__0__Impl rule__NonLeftRecExpression__Group_0__1 )
            // InternalAle.g:5276:2: rule__NonLeftRecExpression__Group_0__0__Impl rule__NonLeftRecExpression__Group_0__1
            {
            pushFollow(FOLLOW_47);
            rule__NonLeftRecExpression__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_0__0"


    // $ANTLR start "rule__NonLeftRecExpression__Group_0__0__Impl"
    // InternalAle.g:5283:1: rule__NonLeftRecExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__NonLeftRecExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5287:1: ( ( () ) )
            // InternalAle.g:5288:1: ( () )
            {
            // InternalAle.g:5288:1: ( () )
            // InternalAle.g:5289:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getNotExpressionAction_0_0()); 
            }
            // InternalAle.g:5290:2: ()
            // InternalAle.g:5290:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getNotExpressionAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_0__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_0__1"
    // InternalAle.g:5298:1: rule__NonLeftRecExpression__Group_0__1 : rule__NonLeftRecExpression__Group_0__1__Impl rule__NonLeftRecExpression__Group_0__2 ;
    public final void rule__NonLeftRecExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5302:1: ( rule__NonLeftRecExpression__Group_0__1__Impl rule__NonLeftRecExpression__Group_0__2 )
            // InternalAle.g:5303:2: rule__NonLeftRecExpression__Group_0__1__Impl rule__NonLeftRecExpression__Group_0__2
            {
            pushFollow(FOLLOW_28);
            rule__NonLeftRecExpression__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_0__1"


    // $ANTLR start "rule__NonLeftRecExpression__Group_0__1__Impl"
    // InternalAle.g:5310:1: rule__NonLeftRecExpression__Group_0__1__Impl : ( 'not' ) ;
    public final void rule__NonLeftRecExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5314:1: ( ( 'not' ) )
            // InternalAle.g:5315:1: ( 'not' )
            {
            // InternalAle.g:5315:1: ( 'not' )
            // InternalAle.g:5316:2: 'not'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getNotKeyword_0_1()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getNotKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_0__1__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_0__2"
    // InternalAle.g:5325:1: rule__NonLeftRecExpression__Group_0__2 : rule__NonLeftRecExpression__Group_0__2__Impl ;
    public final void rule__NonLeftRecExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5329:1: ( rule__NonLeftRecExpression__Group_0__2__Impl )
            // InternalAle.g:5330:2: rule__NonLeftRecExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_0__2"


    // $ANTLR start "rule__NonLeftRecExpression__Group_0__2__Impl"
    // InternalAle.g:5336:1: rule__NonLeftRecExpression__Group_0__2__Impl : ( ( rule__NonLeftRecExpression__ExpressionAssignment_0_2 ) ) ;
    public final void rule__NonLeftRecExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5340:1: ( ( ( rule__NonLeftRecExpression__ExpressionAssignment_0_2 ) ) )
            // InternalAle.g:5341:1: ( ( rule__NonLeftRecExpression__ExpressionAssignment_0_2 ) )
            {
            // InternalAle.g:5341:1: ( ( rule__NonLeftRecExpression__ExpressionAssignment_0_2 ) )
            // InternalAle.g:5342:2: ( rule__NonLeftRecExpression__ExpressionAssignment_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionAssignment_0_2()); 
            }
            // InternalAle.g:5343:2: ( rule__NonLeftRecExpression__ExpressionAssignment_0_2 )
            // InternalAle.g:5343:3: rule__NonLeftRecExpression__ExpressionAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__ExpressionAssignment_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionAssignment_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_0__2__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_1__0"
    // InternalAle.g:5352:1: rule__NonLeftRecExpression__Group_1__0 : rule__NonLeftRecExpression__Group_1__0__Impl rule__NonLeftRecExpression__Group_1__1 ;
    public final void rule__NonLeftRecExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5356:1: ( rule__NonLeftRecExpression__Group_1__0__Impl rule__NonLeftRecExpression__Group_1__1 )
            // InternalAle.g:5357:2: rule__NonLeftRecExpression__Group_1__0__Impl rule__NonLeftRecExpression__Group_1__1
            {
            pushFollow(FOLLOW_48);
            rule__NonLeftRecExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_1__0"


    // $ANTLR start "rule__NonLeftRecExpression__Group_1__0__Impl"
    // InternalAle.g:5364:1: rule__NonLeftRecExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__NonLeftRecExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5368:1: ( ( () ) )
            // InternalAle.g:5369:1: ( () )
            {
            // InternalAle.g:5369:1: ( () )
            // InternalAle.g:5370:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getNegExpressionAction_1_0()); 
            }
            // InternalAle.g:5371:2: ()
            // InternalAle.g:5371:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getNegExpressionAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_1__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_1__1"
    // InternalAle.g:5379:1: rule__NonLeftRecExpression__Group_1__1 : rule__NonLeftRecExpression__Group_1__1__Impl rule__NonLeftRecExpression__Group_1__2 ;
    public final void rule__NonLeftRecExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5383:1: ( rule__NonLeftRecExpression__Group_1__1__Impl rule__NonLeftRecExpression__Group_1__2 )
            // InternalAle.g:5384:2: rule__NonLeftRecExpression__Group_1__1__Impl rule__NonLeftRecExpression__Group_1__2
            {
            pushFollow(FOLLOW_28);
            rule__NonLeftRecExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_1__1"


    // $ANTLR start "rule__NonLeftRecExpression__Group_1__1__Impl"
    // InternalAle.g:5391:1: rule__NonLeftRecExpression__Group_1__1__Impl : ( '-' ) ;
    public final void rule__NonLeftRecExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5395:1: ( ( '-' ) )
            // InternalAle.g:5396:1: ( '-' )
            {
            // InternalAle.g:5396:1: ( '-' )
            // InternalAle.g:5397:2: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getHyphenMinusKeyword_1_1()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getHyphenMinusKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_1__1__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_1__2"
    // InternalAle.g:5406:1: rule__NonLeftRecExpression__Group_1__2 : rule__NonLeftRecExpression__Group_1__2__Impl ;
    public final void rule__NonLeftRecExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5410:1: ( rule__NonLeftRecExpression__Group_1__2__Impl )
            // InternalAle.g:5411:2: rule__NonLeftRecExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_1__2"


    // $ANTLR start "rule__NonLeftRecExpression__Group_1__2__Impl"
    // InternalAle.g:5417:1: rule__NonLeftRecExpression__Group_1__2__Impl : ( ( rule__NonLeftRecExpression__ExpressionAssignment_1_2 ) ) ;
    public final void rule__NonLeftRecExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5421:1: ( ( ( rule__NonLeftRecExpression__ExpressionAssignment_1_2 ) ) )
            // InternalAle.g:5422:1: ( ( rule__NonLeftRecExpression__ExpressionAssignment_1_2 ) )
            {
            // InternalAle.g:5422:1: ( ( rule__NonLeftRecExpression__ExpressionAssignment_1_2 ) )
            // InternalAle.g:5423:2: ( rule__NonLeftRecExpression__ExpressionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionAssignment_1_2()); 
            }
            // InternalAle.g:5424:2: ( rule__NonLeftRecExpression__ExpressionAssignment_1_2 )
            // InternalAle.g:5424:3: rule__NonLeftRecExpression__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__ExpressionAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_1__2__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_2__0"
    // InternalAle.g:5433:1: rule__NonLeftRecExpression__Group_2__0 : rule__NonLeftRecExpression__Group_2__0__Impl rule__NonLeftRecExpression__Group_2__1 ;
    public final void rule__NonLeftRecExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5437:1: ( rule__NonLeftRecExpression__Group_2__0__Impl rule__NonLeftRecExpression__Group_2__1 )
            // InternalAle.g:5438:2: rule__NonLeftRecExpression__Group_2__0__Impl rule__NonLeftRecExpression__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__NonLeftRecExpression__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_2__0"


    // $ANTLR start "rule__NonLeftRecExpression__Group_2__0__Impl"
    // InternalAle.g:5445:1: rule__NonLeftRecExpression__Group_2__0__Impl : ( () ) ;
    public final void rule__NonLeftRecExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5449:1: ( ( () ) )
            // InternalAle.g:5450:1: ( () )
            {
            // InternalAle.g:5450:1: ( () )
            // InternalAle.g:5451:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getIdentifierExpresionAction_2_0()); 
            }
            // InternalAle.g:5452:2: ()
            // InternalAle.g:5452:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getIdentifierExpresionAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_2__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_2__1"
    // InternalAle.g:5460:1: rule__NonLeftRecExpression__Group_2__1 : rule__NonLeftRecExpression__Group_2__1__Impl ;
    public final void rule__NonLeftRecExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5464:1: ( rule__NonLeftRecExpression__Group_2__1__Impl )
            // InternalAle.g:5465:2: rule__NonLeftRecExpression__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_2__1"


    // $ANTLR start "rule__NonLeftRecExpression__Group_2__1__Impl"
    // InternalAle.g:5471:1: rule__NonLeftRecExpression__Group_2__1__Impl : ( ( rule__NonLeftRecExpression__ValueAssignment_2_1 ) ) ;
    public final void rule__NonLeftRecExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5475:1: ( ( ( rule__NonLeftRecExpression__ValueAssignment_2_1 ) ) )
            // InternalAle.g:5476:1: ( ( rule__NonLeftRecExpression__ValueAssignment_2_1 ) )
            {
            // InternalAle.g:5476:1: ( ( rule__NonLeftRecExpression__ValueAssignment_2_1 ) )
            // InternalAle.g:5477:2: ( rule__NonLeftRecExpression__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getValueAssignment_2_1()); 
            }
            // InternalAle.g:5478:2: ( rule__NonLeftRecExpression__ValueAssignment_2_1 )
            // InternalAle.g:5478:3: rule__NonLeftRecExpression__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__ValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getValueAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_2__1__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_3__0"
    // InternalAle.g:5487:1: rule__NonLeftRecExpression__Group_3__0 : rule__NonLeftRecExpression__Group_3__0__Impl rule__NonLeftRecExpression__Group_3__1 ;
    public final void rule__NonLeftRecExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5491:1: ( rule__NonLeftRecExpression__Group_3__0__Impl rule__NonLeftRecExpression__Group_3__1 )
            // InternalAle.g:5492:2: rule__NonLeftRecExpression__Group_3__0__Impl rule__NonLeftRecExpression__Group_3__1
            {
            pushFollow(FOLLOW_49);
            rule__NonLeftRecExpression__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_3__0"


    // $ANTLR start "rule__NonLeftRecExpression__Group_3__0__Impl"
    // InternalAle.g:5499:1: rule__NonLeftRecExpression__Group_3__0__Impl : ( () ) ;
    public final void rule__NonLeftRecExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5503:1: ( ( () ) )
            // InternalAle.g:5504:1: ( () )
            {
            // InternalAle.g:5504:1: ( () )
            // InternalAle.g:5505:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLiteralExpressioinAction_3_0()); 
            }
            // InternalAle.g:5506:2: ()
            // InternalAle.g:5506:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLiteralExpressioinAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_3__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_3__1"
    // InternalAle.g:5514:1: rule__NonLeftRecExpression__Group_3__1 : rule__NonLeftRecExpression__Group_3__1__Impl ;
    public final void rule__NonLeftRecExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5518:1: ( rule__NonLeftRecExpression__Group_3__1__Impl )
            // InternalAle.g:5519:2: rule__NonLeftRecExpression__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_3__1"


    // $ANTLR start "rule__NonLeftRecExpression__Group_3__1__Impl"
    // InternalAle.g:5525:1: rule__NonLeftRecExpression__Group_3__1__Impl : ( ( rule__NonLeftRecExpression__LitAssignment_3_1 ) ) ;
    public final void rule__NonLeftRecExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5529:1: ( ( ( rule__NonLeftRecExpression__LitAssignment_3_1 ) ) )
            // InternalAle.g:5530:1: ( ( rule__NonLeftRecExpression__LitAssignment_3_1 ) )
            {
            // InternalAle.g:5530:1: ( ( rule__NonLeftRecExpression__LitAssignment_3_1 ) )
            // InternalAle.g:5531:2: ( rule__NonLeftRecExpression__LitAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLitAssignment_3_1()); 
            }
            // InternalAle.g:5532:2: ( rule__NonLeftRecExpression__LitAssignment_3_1 )
            // InternalAle.g:5532:3: rule__NonLeftRecExpression__LitAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__LitAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLitAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_3__1__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__0"
    // InternalAle.g:5541:1: rule__NonLeftRecExpression__Group_4__0 : rule__NonLeftRecExpression__Group_4__0__Impl rule__NonLeftRecExpression__Group_4__1 ;
    public final void rule__NonLeftRecExpression__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5545:1: ( rule__NonLeftRecExpression__Group_4__0__Impl rule__NonLeftRecExpression__Group_4__1 )
            // InternalAle.g:5546:2: rule__NonLeftRecExpression__Group_4__0__Impl rule__NonLeftRecExpression__Group_4__1
            {
            pushFollow(FOLLOW_25);
            rule__NonLeftRecExpression__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_4__0"


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__0__Impl"
    // InternalAle.g:5553:1: rule__NonLeftRecExpression__Group_4__0__Impl : ( () ) ;
    public final void rule__NonLeftRecExpression__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5557:1: ( ( () ) )
            // InternalAle.g:5558:1: ( () )
            {
            // InternalAle.g:5558:1: ( () )
            // InternalAle.g:5559:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getParenthesisExpressionAction_4_0()); 
            }
            // InternalAle.g:5560:2: ()
            // InternalAle.g:5560:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getParenthesisExpressionAction_4_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_4__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__1"
    // InternalAle.g:5568:1: rule__NonLeftRecExpression__Group_4__1 : rule__NonLeftRecExpression__Group_4__1__Impl rule__NonLeftRecExpression__Group_4__2 ;
    public final void rule__NonLeftRecExpression__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5572:1: ( rule__NonLeftRecExpression__Group_4__1__Impl rule__NonLeftRecExpression__Group_4__2 )
            // InternalAle.g:5573:2: rule__NonLeftRecExpression__Group_4__1__Impl rule__NonLeftRecExpression__Group_4__2
            {
            pushFollow(FOLLOW_28);
            rule__NonLeftRecExpression__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_4__1"


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__1__Impl"
    // InternalAle.g:5580:1: rule__NonLeftRecExpression__Group_4__1__Impl : ( '(' ) ;
    public final void rule__NonLeftRecExpression__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5584:1: ( ( '(' ) )
            // InternalAle.g:5585:1: ( '(' )
            {
            // InternalAle.g:5585:1: ( '(' )
            // InternalAle.g:5586:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLeftParenthesisKeyword_4_1()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLeftParenthesisKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_4__1__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__2"
    // InternalAle.g:5595:1: rule__NonLeftRecExpression__Group_4__2 : rule__NonLeftRecExpression__Group_4__2__Impl rule__NonLeftRecExpression__Group_4__3 ;
    public final void rule__NonLeftRecExpression__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5599:1: ( rule__NonLeftRecExpression__Group_4__2__Impl rule__NonLeftRecExpression__Group_4__3 )
            // InternalAle.g:5600:2: rule__NonLeftRecExpression__Group_4__2__Impl rule__NonLeftRecExpression__Group_4__3
            {
            pushFollow(FOLLOW_35);
            rule__NonLeftRecExpression__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_4__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_4__2"


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__2__Impl"
    // InternalAle.g:5607:1: rule__NonLeftRecExpression__Group_4__2__Impl : ( ( rule__NonLeftRecExpression__ExpressionAssignment_4_2 ) ) ;
    public final void rule__NonLeftRecExpression__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5611:1: ( ( ( rule__NonLeftRecExpression__ExpressionAssignment_4_2 ) ) )
            // InternalAle.g:5612:1: ( ( rule__NonLeftRecExpression__ExpressionAssignment_4_2 ) )
            {
            // InternalAle.g:5612:1: ( ( rule__NonLeftRecExpression__ExpressionAssignment_4_2 ) )
            // InternalAle.g:5613:2: ( rule__NonLeftRecExpression__ExpressionAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionAssignment_4_2()); 
            }
            // InternalAle.g:5614:2: ( rule__NonLeftRecExpression__ExpressionAssignment_4_2 )
            // InternalAle.g:5614:3: rule__NonLeftRecExpression__ExpressionAssignment_4_2
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__ExpressionAssignment_4_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionAssignment_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_4__2__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__3"
    // InternalAle.g:5622:1: rule__NonLeftRecExpression__Group_4__3 : rule__NonLeftRecExpression__Group_4__3__Impl ;
    public final void rule__NonLeftRecExpression__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5626:1: ( rule__NonLeftRecExpression__Group_4__3__Impl )
            // InternalAle.g:5627:2: rule__NonLeftRecExpression__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_4__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_4__3"


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__3__Impl"
    // InternalAle.g:5633:1: rule__NonLeftRecExpression__Group_4__3__Impl : ( ')' ) ;
    public final void rule__NonLeftRecExpression__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5637:1: ( ( ')' ) )
            // InternalAle.g:5638:1: ( ')' )
            {
            // InternalAle.g:5638:1: ( ')' )
            // InternalAle.g:5639:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getRightParenthesisKeyword_4_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getRightParenthesisKeyword_4_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_4__3__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__0"
    // InternalAle.g:5649:1: rule__NonLeftRecExpression__Group_5__0 : rule__NonLeftRecExpression__Group_5__0__Impl rule__NonLeftRecExpression__Group_5__1 ;
    public final void rule__NonLeftRecExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5653:1: ( rule__NonLeftRecExpression__Group_5__0__Impl rule__NonLeftRecExpression__Group_5__1 )
            // InternalAle.g:5654:2: rule__NonLeftRecExpression__Group_5__0__Impl rule__NonLeftRecExpression__Group_5__1
            {
            pushFollow(FOLLOW_31);
            rule__NonLeftRecExpression__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__0"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__0__Impl"
    // InternalAle.g:5661:1: rule__NonLeftRecExpression__Group_5__0__Impl : ( () ) ;
    public final void rule__NonLeftRecExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5665:1: ( ( () ) )
            // InternalAle.g:5666:1: ( () )
            {
            // InternalAle.g:5666:1: ( () )
            // InternalAle.g:5667:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getIfExpressionAction_5_0()); 
            }
            // InternalAle.g:5668:2: ()
            // InternalAle.g:5668:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getIfExpressionAction_5_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__1"
    // InternalAle.g:5676:1: rule__NonLeftRecExpression__Group_5__1 : rule__NonLeftRecExpression__Group_5__1__Impl rule__NonLeftRecExpression__Group_5__2 ;
    public final void rule__NonLeftRecExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5680:1: ( rule__NonLeftRecExpression__Group_5__1__Impl rule__NonLeftRecExpression__Group_5__2 )
            // InternalAle.g:5681:2: rule__NonLeftRecExpression__Group_5__1__Impl rule__NonLeftRecExpression__Group_5__2
            {
            pushFollow(FOLLOW_28);
            rule__NonLeftRecExpression__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__1"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__1__Impl"
    // InternalAle.g:5688:1: rule__NonLeftRecExpression__Group_5__1__Impl : ( 'if' ) ;
    public final void rule__NonLeftRecExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5692:1: ( ( 'if' ) )
            // InternalAle.g:5693:1: ( 'if' )
            {
            // InternalAle.g:5693:1: ( 'if' )
            // InternalAle.g:5694:2: 'if'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getIfKeyword_5_1()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getIfKeyword_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__1__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__2"
    // InternalAle.g:5703:1: rule__NonLeftRecExpression__Group_5__2 : rule__NonLeftRecExpression__Group_5__2__Impl rule__NonLeftRecExpression__Group_5__3 ;
    public final void rule__NonLeftRecExpression__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5707:1: ( rule__NonLeftRecExpression__Group_5__2__Impl rule__NonLeftRecExpression__Group_5__3 )
            // InternalAle.g:5708:2: rule__NonLeftRecExpression__Group_5__2__Impl rule__NonLeftRecExpression__Group_5__3
            {
            pushFollow(FOLLOW_50);
            rule__NonLeftRecExpression__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_5__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__2"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__2__Impl"
    // InternalAle.g:5715:1: rule__NonLeftRecExpression__Group_5__2__Impl : ( ( rule__NonLeftRecExpression__ConditionAssignment_5_2 ) ) ;
    public final void rule__NonLeftRecExpression__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5719:1: ( ( ( rule__NonLeftRecExpression__ConditionAssignment_5_2 ) ) )
            // InternalAle.g:5720:1: ( ( rule__NonLeftRecExpression__ConditionAssignment_5_2 ) )
            {
            // InternalAle.g:5720:1: ( ( rule__NonLeftRecExpression__ConditionAssignment_5_2 ) )
            // InternalAle.g:5721:2: ( rule__NonLeftRecExpression__ConditionAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getConditionAssignment_5_2()); 
            }
            // InternalAle.g:5722:2: ( rule__NonLeftRecExpression__ConditionAssignment_5_2 )
            // InternalAle.g:5722:3: rule__NonLeftRecExpression__ConditionAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__ConditionAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getConditionAssignment_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__2__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__3"
    // InternalAle.g:5730:1: rule__NonLeftRecExpression__Group_5__3 : rule__NonLeftRecExpression__Group_5__3__Impl rule__NonLeftRecExpression__Group_5__4 ;
    public final void rule__NonLeftRecExpression__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5734:1: ( rule__NonLeftRecExpression__Group_5__3__Impl rule__NonLeftRecExpression__Group_5__4 )
            // InternalAle.g:5735:2: rule__NonLeftRecExpression__Group_5__3__Impl rule__NonLeftRecExpression__Group_5__4
            {
            pushFollow(FOLLOW_28);
            rule__NonLeftRecExpression__Group_5__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_5__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__3"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__3__Impl"
    // InternalAle.g:5742:1: rule__NonLeftRecExpression__Group_5__3__Impl : ( 'then' ) ;
    public final void rule__NonLeftRecExpression__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5746:1: ( ( 'then' ) )
            // InternalAle.g:5747:1: ( 'then' )
            {
            // InternalAle.g:5747:1: ( 'then' )
            // InternalAle.g:5748:2: 'then'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getThenKeyword_5_3()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getThenKeyword_5_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__3__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__4"
    // InternalAle.g:5757:1: rule__NonLeftRecExpression__Group_5__4 : rule__NonLeftRecExpression__Group_5__4__Impl rule__NonLeftRecExpression__Group_5__5 ;
    public final void rule__NonLeftRecExpression__Group_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5761:1: ( rule__NonLeftRecExpression__Group_5__4__Impl rule__NonLeftRecExpression__Group_5__5 )
            // InternalAle.g:5762:2: rule__NonLeftRecExpression__Group_5__4__Impl rule__NonLeftRecExpression__Group_5__5
            {
            pushFollow(FOLLOW_42);
            rule__NonLeftRecExpression__Group_5__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_5__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__4"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__4__Impl"
    // InternalAle.g:5769:1: rule__NonLeftRecExpression__Group_5__4__Impl : ( ( rule__NonLeftRecExpression__IfBlockAssignment_5_4 ) ) ;
    public final void rule__NonLeftRecExpression__Group_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5773:1: ( ( ( rule__NonLeftRecExpression__IfBlockAssignment_5_4 ) ) )
            // InternalAle.g:5774:1: ( ( rule__NonLeftRecExpression__IfBlockAssignment_5_4 ) )
            {
            // InternalAle.g:5774:1: ( ( rule__NonLeftRecExpression__IfBlockAssignment_5_4 ) )
            // InternalAle.g:5775:2: ( rule__NonLeftRecExpression__IfBlockAssignment_5_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getIfBlockAssignment_5_4()); 
            }
            // InternalAle.g:5776:2: ( rule__NonLeftRecExpression__IfBlockAssignment_5_4 )
            // InternalAle.g:5776:3: rule__NonLeftRecExpression__IfBlockAssignment_5_4
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__IfBlockAssignment_5_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getIfBlockAssignment_5_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__4__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__5"
    // InternalAle.g:5784:1: rule__NonLeftRecExpression__Group_5__5 : rule__NonLeftRecExpression__Group_5__5__Impl rule__NonLeftRecExpression__Group_5__6 ;
    public final void rule__NonLeftRecExpression__Group_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5788:1: ( rule__NonLeftRecExpression__Group_5__5__Impl rule__NonLeftRecExpression__Group_5__6 )
            // InternalAle.g:5789:2: rule__NonLeftRecExpression__Group_5__5__Impl rule__NonLeftRecExpression__Group_5__6
            {
            pushFollow(FOLLOW_28);
            rule__NonLeftRecExpression__Group_5__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_5__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__5"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__5__Impl"
    // InternalAle.g:5796:1: rule__NonLeftRecExpression__Group_5__5__Impl : ( 'else' ) ;
    public final void rule__NonLeftRecExpression__Group_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5800:1: ( ( 'else' ) )
            // InternalAle.g:5801:1: ( 'else' )
            {
            // InternalAle.g:5801:1: ( 'else' )
            // InternalAle.g:5802:2: 'else'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getElseKeyword_5_5()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getElseKeyword_5_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__5__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__6"
    // InternalAle.g:5811:1: rule__NonLeftRecExpression__Group_5__6 : rule__NonLeftRecExpression__Group_5__6__Impl rule__NonLeftRecExpression__Group_5__7 ;
    public final void rule__NonLeftRecExpression__Group_5__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5815:1: ( rule__NonLeftRecExpression__Group_5__6__Impl rule__NonLeftRecExpression__Group_5__7 )
            // InternalAle.g:5816:2: rule__NonLeftRecExpression__Group_5__6__Impl rule__NonLeftRecExpression__Group_5__7
            {
            pushFollow(FOLLOW_51);
            rule__NonLeftRecExpression__Group_5__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_5__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__6"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__6__Impl"
    // InternalAle.g:5823:1: rule__NonLeftRecExpression__Group_5__6__Impl : ( ( rule__NonLeftRecExpression__ElseBlockAssignment_5_6 ) ) ;
    public final void rule__NonLeftRecExpression__Group_5__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5827:1: ( ( ( rule__NonLeftRecExpression__ElseBlockAssignment_5_6 ) ) )
            // InternalAle.g:5828:1: ( ( rule__NonLeftRecExpression__ElseBlockAssignment_5_6 ) )
            {
            // InternalAle.g:5828:1: ( ( rule__NonLeftRecExpression__ElseBlockAssignment_5_6 ) )
            // InternalAle.g:5829:2: ( rule__NonLeftRecExpression__ElseBlockAssignment_5_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getElseBlockAssignment_5_6()); 
            }
            // InternalAle.g:5830:2: ( rule__NonLeftRecExpression__ElseBlockAssignment_5_6 )
            // InternalAle.g:5830:3: rule__NonLeftRecExpression__ElseBlockAssignment_5_6
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__ElseBlockAssignment_5_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getElseBlockAssignment_5_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__6__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__7"
    // InternalAle.g:5838:1: rule__NonLeftRecExpression__Group_5__7 : rule__NonLeftRecExpression__Group_5__7__Impl ;
    public final void rule__NonLeftRecExpression__Group_5__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5842:1: ( rule__NonLeftRecExpression__Group_5__7__Impl )
            // InternalAle.g:5843:2: rule__NonLeftRecExpression__Group_5__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_5__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__7"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__7__Impl"
    // InternalAle.g:5849:1: rule__NonLeftRecExpression__Group_5__7__Impl : ( 'endif' ) ;
    public final void rule__NonLeftRecExpression__Group_5__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5853:1: ( ( 'endif' ) )
            // InternalAle.g:5854:1: ( 'endif' )
            {
            // InternalAle.g:5854:1: ( 'endif' )
            // InternalAle.g:5855:2: 'endif'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getEndifKeyword_5_7()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getEndifKeyword_5_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__7__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__0"
    // InternalAle.g:5865:1: rule__NonLeftRecExpression__Group_6__0 : rule__NonLeftRecExpression__Group_6__0__Impl rule__NonLeftRecExpression__Group_6__1 ;
    public final void rule__NonLeftRecExpression__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5869:1: ( rule__NonLeftRecExpression__Group_6__0__Impl rule__NonLeftRecExpression__Group_6__1 )
            // InternalAle.g:5870:2: rule__NonLeftRecExpression__Group_6__0__Impl rule__NonLeftRecExpression__Group_6__1
            {
            pushFollow(FOLLOW_28);
            rule__NonLeftRecExpression__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__0"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__0__Impl"
    // InternalAle.g:5877:1: rule__NonLeftRecExpression__Group_6__0__Impl : ( () ) ;
    public final void rule__NonLeftRecExpression__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5881:1: ( ( () ) )
            // InternalAle.g:5882:1: ( () )
            {
            // InternalAle.g:5882:1: ( () )
            // InternalAle.g:5883:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLetExpressionAction_6_0()); 
            }
            // InternalAle.g:5884:2: ()
            // InternalAle.g:5884:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLetExpressionAction_6_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__1"
    // InternalAle.g:5892:1: rule__NonLeftRecExpression__Group_6__1 : rule__NonLeftRecExpression__Group_6__1__Impl rule__NonLeftRecExpression__Group_6__2 ;
    public final void rule__NonLeftRecExpression__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5896:1: ( rule__NonLeftRecExpression__Group_6__1__Impl rule__NonLeftRecExpression__Group_6__2 )
            // InternalAle.g:5897:2: rule__NonLeftRecExpression__Group_6__1__Impl rule__NonLeftRecExpression__Group_6__2
            {
            pushFollow(FOLLOW_3);
            rule__NonLeftRecExpression__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__1"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__1__Impl"
    // InternalAle.g:5904:1: rule__NonLeftRecExpression__Group_6__1__Impl : ( 'let' ) ;
    public final void rule__NonLeftRecExpression__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5908:1: ( ( 'let' ) )
            // InternalAle.g:5909:1: ( 'let' )
            {
            // InternalAle.g:5909:1: ( 'let' )
            // InternalAle.g:5910:2: 'let'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLetKeyword_6_1()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLetKeyword_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__1__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__2"
    // InternalAle.g:5919:1: rule__NonLeftRecExpression__Group_6__2 : rule__NonLeftRecExpression__Group_6__2__Impl rule__NonLeftRecExpression__Group_6__3 ;
    public final void rule__NonLeftRecExpression__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5923:1: ( rule__NonLeftRecExpression__Group_6__2__Impl rule__NonLeftRecExpression__Group_6__3 )
            // InternalAle.g:5924:2: rule__NonLeftRecExpression__Group_6__2__Impl rule__NonLeftRecExpression__Group_6__3
            {
            pushFollow(FOLLOW_52);
            rule__NonLeftRecExpression__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__2"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__2__Impl"
    // InternalAle.g:5931:1: rule__NonLeftRecExpression__Group_6__2__Impl : ( ( rule__NonLeftRecExpression__BindingsAssignment_6_2 ) ) ;
    public final void rule__NonLeftRecExpression__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5935:1: ( ( ( rule__NonLeftRecExpression__BindingsAssignment_6_2 ) ) )
            // InternalAle.g:5936:1: ( ( rule__NonLeftRecExpression__BindingsAssignment_6_2 ) )
            {
            // InternalAle.g:5936:1: ( ( rule__NonLeftRecExpression__BindingsAssignment_6_2 ) )
            // InternalAle.g:5937:2: ( rule__NonLeftRecExpression__BindingsAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_2()); 
            }
            // InternalAle.g:5938:2: ( rule__NonLeftRecExpression__BindingsAssignment_6_2 )
            // InternalAle.g:5938:3: rule__NonLeftRecExpression__BindingsAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__BindingsAssignment_6_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__2__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__3"
    // InternalAle.g:5946:1: rule__NonLeftRecExpression__Group_6__3 : rule__NonLeftRecExpression__Group_6__3__Impl rule__NonLeftRecExpression__Group_6__4 ;
    public final void rule__NonLeftRecExpression__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5950:1: ( rule__NonLeftRecExpression__Group_6__3__Impl rule__NonLeftRecExpression__Group_6__4 )
            // InternalAle.g:5951:2: rule__NonLeftRecExpression__Group_6__3__Impl rule__NonLeftRecExpression__Group_6__4
            {
            pushFollow(FOLLOW_52);
            rule__NonLeftRecExpression__Group_6__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__3"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__3__Impl"
    // InternalAle.g:5958:1: rule__NonLeftRecExpression__Group_6__3__Impl : ( ( rule__NonLeftRecExpression__Group_6_3__0 )* ) ;
    public final void rule__NonLeftRecExpression__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5962:1: ( ( ( rule__NonLeftRecExpression__Group_6_3__0 )* ) )
            // InternalAle.g:5963:1: ( ( rule__NonLeftRecExpression__Group_6_3__0 )* )
            {
            // InternalAle.g:5963:1: ( ( rule__NonLeftRecExpression__Group_6_3__0 )* )
            // InternalAle.g:5964:2: ( rule__NonLeftRecExpression__Group_6_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6_3()); 
            }
            // InternalAle.g:5965:2: ( rule__NonLeftRecExpression__Group_6_3__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==43) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalAle.g:5965:3: rule__NonLeftRecExpression__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__NonLeftRecExpression__Group_6_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__3__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__4"
    // InternalAle.g:5973:1: rule__NonLeftRecExpression__Group_6__4 : rule__NonLeftRecExpression__Group_6__4__Impl rule__NonLeftRecExpression__Group_6__5 ;
    public final void rule__NonLeftRecExpression__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5977:1: ( rule__NonLeftRecExpression__Group_6__4__Impl rule__NonLeftRecExpression__Group_6__5 )
            // InternalAle.g:5978:2: rule__NonLeftRecExpression__Group_6__4__Impl rule__NonLeftRecExpression__Group_6__5
            {
            pushFollow(FOLLOW_28);
            rule__NonLeftRecExpression__Group_6__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__4"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__4__Impl"
    // InternalAle.g:5985:1: rule__NonLeftRecExpression__Group_6__4__Impl : ( 'in' ) ;
    public final void rule__NonLeftRecExpression__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5989:1: ( ( 'in' ) )
            // InternalAle.g:5990:1: ( 'in' )
            {
            // InternalAle.g:5990:1: ( 'in' )
            // InternalAle.g:5991:2: 'in'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getInKeyword_6_4()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getInKeyword_6_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__4__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__5"
    // InternalAle.g:6000:1: rule__NonLeftRecExpression__Group_6__5 : rule__NonLeftRecExpression__Group_6__5__Impl ;
    public final void rule__NonLeftRecExpression__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6004:1: ( rule__NonLeftRecExpression__Group_6__5__Impl )
            // InternalAle.g:6005:2: rule__NonLeftRecExpression__Group_6__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__5"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__5__Impl"
    // InternalAle.g:6011:1: rule__NonLeftRecExpression__Group_6__5__Impl : ( ( rule__NonLeftRecExpression__LetExprAssignment_6_5 ) ) ;
    public final void rule__NonLeftRecExpression__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6015:1: ( ( ( rule__NonLeftRecExpression__LetExprAssignment_6_5 ) ) )
            // InternalAle.g:6016:1: ( ( rule__NonLeftRecExpression__LetExprAssignment_6_5 ) )
            {
            // InternalAle.g:6016:1: ( ( rule__NonLeftRecExpression__LetExprAssignment_6_5 ) )
            // InternalAle.g:6017:2: ( rule__NonLeftRecExpression__LetExprAssignment_6_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLetExprAssignment_6_5()); 
            }
            // InternalAle.g:6018:2: ( rule__NonLeftRecExpression__LetExprAssignment_6_5 )
            // InternalAle.g:6018:3: rule__NonLeftRecExpression__LetExprAssignment_6_5
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__LetExprAssignment_6_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLetExprAssignment_6_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__5__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6_3__0"
    // InternalAle.g:6027:1: rule__NonLeftRecExpression__Group_6_3__0 : rule__NonLeftRecExpression__Group_6_3__0__Impl rule__NonLeftRecExpression__Group_6_3__1 ;
    public final void rule__NonLeftRecExpression__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6031:1: ( rule__NonLeftRecExpression__Group_6_3__0__Impl rule__NonLeftRecExpression__Group_6_3__1 )
            // InternalAle.g:6032:2: rule__NonLeftRecExpression__Group_6_3__0__Impl rule__NonLeftRecExpression__Group_6_3__1
            {
            pushFollow(FOLLOW_3);
            rule__NonLeftRecExpression__Group_6_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6_3__0"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6_3__0__Impl"
    // InternalAle.g:6039:1: rule__NonLeftRecExpression__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__NonLeftRecExpression__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6043:1: ( ( ',' ) )
            // InternalAle.g:6044:1: ( ',' )
            {
            // InternalAle.g:6044:1: ( ',' )
            // InternalAle.g:6045:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getCommaKeyword_6_3_0()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getCommaKeyword_6_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6_3__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6_3__1"
    // InternalAle.g:6054:1: rule__NonLeftRecExpression__Group_6_3__1 : rule__NonLeftRecExpression__Group_6_3__1__Impl ;
    public final void rule__NonLeftRecExpression__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6058:1: ( rule__NonLeftRecExpression__Group_6_3__1__Impl )
            // InternalAle.g:6059:2: rule__NonLeftRecExpression__Group_6_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6_3__1"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6_3__1__Impl"
    // InternalAle.g:6065:1: rule__NonLeftRecExpression__Group_6_3__1__Impl : ( ( rule__NonLeftRecExpression__BindingsAssignment_6_3_1 ) ) ;
    public final void rule__NonLeftRecExpression__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6069:1: ( ( ( rule__NonLeftRecExpression__BindingsAssignment_6_3_1 ) ) )
            // InternalAle.g:6070:1: ( ( rule__NonLeftRecExpression__BindingsAssignment_6_3_1 ) )
            {
            // InternalAle.g:6070:1: ( ( rule__NonLeftRecExpression__BindingsAssignment_6_3_1 ) )
            // InternalAle.g:6071:2: ( rule__NonLeftRecExpression__BindingsAssignment_6_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_3_1()); 
            }
            // InternalAle.g:6072:2: ( rule__NonLeftRecExpression__BindingsAssignment_6_3_1 )
            // InternalAle.g:6072:3: rule__NonLeftRecExpression__BindingsAssignment_6_3_1
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__BindingsAssignment_6_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6_3__1__Impl"


    // $ANTLR start "rule__Binding__Group__0"
    // InternalAle.g:6081:1: rule__Binding__Group__0 : rule__Binding__Group__0__Impl rule__Binding__Group__1 ;
    public final void rule__Binding__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6085:1: ( rule__Binding__Group__0__Impl rule__Binding__Group__1 )
            // InternalAle.g:6086:2: rule__Binding__Group__0__Impl rule__Binding__Group__1
            {
            pushFollow(FOLLOW_53);
            rule__Binding__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Binding__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__0"


    // $ANTLR start "rule__Binding__Group__0__Impl"
    // InternalAle.g:6093:1: rule__Binding__Group__0__Impl : ( ( rule__Binding__IdentifierAssignment_0 ) ) ;
    public final void rule__Binding__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6097:1: ( ( ( rule__Binding__IdentifierAssignment_0 ) ) )
            // InternalAle.g:6098:1: ( ( rule__Binding__IdentifierAssignment_0 ) )
            {
            // InternalAle.g:6098:1: ( ( rule__Binding__IdentifierAssignment_0 ) )
            // InternalAle.g:6099:2: ( rule__Binding__IdentifierAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getIdentifierAssignment_0()); 
            }
            // InternalAle.g:6100:2: ( rule__Binding__IdentifierAssignment_0 )
            // InternalAle.g:6100:3: rule__Binding__IdentifierAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Binding__IdentifierAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getIdentifierAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__0__Impl"


    // $ANTLR start "rule__Binding__Group__1"
    // InternalAle.g:6108:1: rule__Binding__Group__1 : rule__Binding__Group__1__Impl rule__Binding__Group__2 ;
    public final void rule__Binding__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6112:1: ( rule__Binding__Group__1__Impl rule__Binding__Group__2 )
            // InternalAle.g:6113:2: rule__Binding__Group__1__Impl rule__Binding__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__Binding__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Binding__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__1"


    // $ANTLR start "rule__Binding__Group__1__Impl"
    // InternalAle.g:6120:1: rule__Binding__Group__1__Impl : ( ( rule__Binding__Group_1__0 )? ) ;
    public final void rule__Binding__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6124:1: ( ( ( rule__Binding__Group_1__0 )? ) )
            // InternalAle.g:6125:1: ( ( rule__Binding__Group_1__0 )? )
            {
            // InternalAle.g:6125:1: ( ( rule__Binding__Group_1__0 )? )
            // InternalAle.g:6126:2: ( rule__Binding__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getGroup_1()); 
            }
            // InternalAle.g:6127:2: ( rule__Binding__Group_1__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==67) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalAle.g:6127:3: rule__Binding__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Binding__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__1__Impl"


    // $ANTLR start "rule__Binding__Group__2"
    // InternalAle.g:6135:1: rule__Binding__Group__2 : rule__Binding__Group__2__Impl rule__Binding__Group__3 ;
    public final void rule__Binding__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6139:1: ( rule__Binding__Group__2__Impl rule__Binding__Group__3 )
            // InternalAle.g:6140:2: rule__Binding__Group__2__Impl rule__Binding__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__Binding__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Binding__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__2"


    // $ANTLR start "rule__Binding__Group__2__Impl"
    // InternalAle.g:6147:1: rule__Binding__Group__2__Impl : ( '=' ) ;
    public final void rule__Binding__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6151:1: ( ( '=' ) )
            // InternalAle.g:6152:1: ( '=' )
            {
            // InternalAle.g:6152:1: ( '=' )
            // InternalAle.g:6153:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getEqualsSignKeyword_2()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getEqualsSignKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__2__Impl"


    // $ANTLR start "rule__Binding__Group__3"
    // InternalAle.g:6162:1: rule__Binding__Group__3 : rule__Binding__Group__3__Impl ;
    public final void rule__Binding__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6166:1: ( rule__Binding__Group__3__Impl )
            // InternalAle.g:6167:2: rule__Binding__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Binding__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__3"


    // $ANTLR start "rule__Binding__Group__3__Impl"
    // InternalAle.g:6173:1: rule__Binding__Group__3__Impl : ( ( rule__Binding__ExpressionAssignment_3 ) ) ;
    public final void rule__Binding__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6177:1: ( ( ( rule__Binding__ExpressionAssignment_3 ) ) )
            // InternalAle.g:6178:1: ( ( rule__Binding__ExpressionAssignment_3 ) )
            {
            // InternalAle.g:6178:1: ( ( rule__Binding__ExpressionAssignment_3 ) )
            // InternalAle.g:6179:2: ( rule__Binding__ExpressionAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getExpressionAssignment_3()); 
            }
            // InternalAle.g:6180:2: ( rule__Binding__ExpressionAssignment_3 )
            // InternalAle.g:6180:3: rule__Binding__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Binding__ExpressionAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getExpressionAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__3__Impl"


    // $ANTLR start "rule__Binding__Group_1__0"
    // InternalAle.g:6189:1: rule__Binding__Group_1__0 : rule__Binding__Group_1__0__Impl rule__Binding__Group_1__1 ;
    public final void rule__Binding__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6193:1: ( rule__Binding__Group_1__0__Impl rule__Binding__Group_1__1 )
            // InternalAle.g:6194:2: rule__Binding__Group_1__0__Impl rule__Binding__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__Binding__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Binding__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group_1__0"


    // $ANTLR start "rule__Binding__Group_1__0__Impl"
    // InternalAle.g:6201:1: rule__Binding__Group_1__0__Impl : ( ':' ) ;
    public final void rule__Binding__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6205:1: ( ( ':' ) )
            // InternalAle.g:6206:1: ( ':' )
            {
            // InternalAle.g:6206:1: ( ':' )
            // InternalAle.g:6207:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getColonKeyword_1_0()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getColonKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group_1__0__Impl"


    // $ANTLR start "rule__Binding__Group_1__1"
    // InternalAle.g:6216:1: rule__Binding__Group_1__1 : rule__Binding__Group_1__1__Impl ;
    public final void rule__Binding__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6220:1: ( rule__Binding__Group_1__1__Impl )
            // InternalAle.g:6221:2: rule__Binding__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Binding__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group_1__1"


    // $ANTLR start "rule__Binding__Group_1__1__Impl"
    // InternalAle.g:6227:1: rule__Binding__Group_1__1__Impl : ( ( rule__Binding__TypeAssignment_1_1 ) ) ;
    public final void rule__Binding__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6231:1: ( ( ( rule__Binding__TypeAssignment_1_1 ) ) )
            // InternalAle.g:6232:1: ( ( rule__Binding__TypeAssignment_1_1 ) )
            {
            // InternalAle.g:6232:1: ( ( rule__Binding__TypeAssignment_1_1 ) )
            // InternalAle.g:6233:2: ( rule__Binding__TypeAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getTypeAssignment_1_1()); 
            }
            // InternalAle.g:6234:2: ( rule__Binding__TypeAssignment_1_1 )
            // InternalAle.g:6234:3: rule__Binding__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Binding__TypeAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getTypeAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group_1__1__Impl"


    // $ANTLR start "rule__CallExp__Group_0__0"
    // InternalAle.g:6243:1: rule__CallExp__Group_0__0 : rule__CallExp__Group_0__0__Impl rule__CallExp__Group_0__1 ;
    public final void rule__CallExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6247:1: ( rule__CallExp__Group_0__0__Impl rule__CallExp__Group_0__1 )
            // InternalAle.g:6248:2: rule__CallExp__Group_0__0__Impl rule__CallExp__Group_0__1
            {
            pushFollow(FOLLOW_25);
            rule__CallExp__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExp__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__0"


    // $ANTLR start "rule__CallExp__Group_0__0__Impl"
    // InternalAle.g:6255:1: rule__CallExp__Group_0__0__Impl : ( rulecollectionIterator ) ;
    public final void rule__CallExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6259:1: ( ( rulecollectionIterator ) )
            // InternalAle.g:6260:1: ( rulecollectionIterator )
            {
            // InternalAle.g:6260:1: ( rulecollectionIterator )
            // InternalAle.g:6261:2: rulecollectionIterator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getCollectionIteratorParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulecollectionIterator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getCollectionIteratorParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__0__Impl"


    // $ANTLR start "rule__CallExp__Group_0__1"
    // InternalAle.g:6270:1: rule__CallExp__Group_0__1 : rule__CallExp__Group_0__1__Impl rule__CallExp__Group_0__2 ;
    public final void rule__CallExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6274:1: ( rule__CallExp__Group_0__1__Impl rule__CallExp__Group_0__2 )
            // InternalAle.g:6275:2: rule__CallExp__Group_0__1__Impl rule__CallExp__Group_0__2
            {
            pushFollow(FOLLOW_3);
            rule__CallExp__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExp__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__1"


    // $ANTLR start "rule__CallExp__Group_0__1__Impl"
    // InternalAle.g:6282:1: rule__CallExp__Group_0__1__Impl : ( '(' ) ;
    public final void rule__CallExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6286:1: ( ( '(' ) )
            // InternalAle.g:6287:1: ( '(' )
            {
            // InternalAle.g:6287:1: ( '(' )
            // InternalAle.g:6288:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_0_1()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__1__Impl"


    // $ANTLR start "rule__CallExp__Group_0__2"
    // InternalAle.g:6297:1: rule__CallExp__Group_0__2 : rule__CallExp__Group_0__2__Impl rule__CallExp__Group_0__3 ;
    public final void rule__CallExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6301:1: ( rule__CallExp__Group_0__2__Impl rule__CallExp__Group_0__3 )
            // InternalAle.g:6302:2: rule__CallExp__Group_0__2__Impl rule__CallExp__Group_0__3
            {
            pushFollow(FOLLOW_28);
            rule__CallExp__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExp__Group_0__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__2"


    // $ANTLR start "rule__CallExp__Group_0__2__Impl"
    // InternalAle.g:6309:1: rule__CallExp__Group_0__2__Impl : ( rulevariableDefinition ) ;
    public final void rule__CallExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6313:1: ( ( rulevariableDefinition ) )
            // InternalAle.g:6314:1: ( rulevariableDefinition )
            {
            // InternalAle.g:6314:1: ( rulevariableDefinition )
            // InternalAle.g:6315:2: rulevariableDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getVariableDefinitionParserRuleCall_0_2()); 
            }
            pushFollow(FOLLOW_2);
            rulevariableDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getVariableDefinitionParserRuleCall_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__2__Impl"


    // $ANTLR start "rule__CallExp__Group_0__3"
    // InternalAle.g:6324:1: rule__CallExp__Group_0__3 : rule__CallExp__Group_0__3__Impl rule__CallExp__Group_0__4 ;
    public final void rule__CallExp__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6328:1: ( rule__CallExp__Group_0__3__Impl rule__CallExp__Group_0__4 )
            // InternalAle.g:6329:2: rule__CallExp__Group_0__3__Impl rule__CallExp__Group_0__4
            {
            pushFollow(FOLLOW_35);
            rule__CallExp__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExp__Group_0__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__3"


    // $ANTLR start "rule__CallExp__Group_0__3__Impl"
    // InternalAle.g:6336:1: rule__CallExp__Group_0__3__Impl : ( ( rule__CallExp__ExpressionAssignment_0_3 ) ) ;
    public final void rule__CallExp__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6340:1: ( ( ( rule__CallExp__ExpressionAssignment_0_3 ) ) )
            // InternalAle.g:6341:1: ( ( rule__CallExp__ExpressionAssignment_0_3 ) )
            {
            // InternalAle.g:6341:1: ( ( rule__CallExp__ExpressionAssignment_0_3 ) )
            // InternalAle.g:6342:2: ( rule__CallExp__ExpressionAssignment_0_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getExpressionAssignment_0_3()); 
            }
            // InternalAle.g:6343:2: ( rule__CallExp__ExpressionAssignment_0_3 )
            // InternalAle.g:6343:3: rule__CallExp__ExpressionAssignment_0_3
            {
            pushFollow(FOLLOW_2);
            rule__CallExp__ExpressionAssignment_0_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getExpressionAssignment_0_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__3__Impl"


    // $ANTLR start "rule__CallExp__Group_0__4"
    // InternalAle.g:6351:1: rule__CallExp__Group_0__4 : rule__CallExp__Group_0__4__Impl ;
    public final void rule__CallExp__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6355:1: ( rule__CallExp__Group_0__4__Impl )
            // InternalAle.g:6356:2: rule__CallExp__Group_0__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallExp__Group_0__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__4"


    // $ANTLR start "rule__CallExp__Group_0__4__Impl"
    // InternalAle.g:6362:1: rule__CallExp__Group_0__4__Impl : ( ')' ) ;
    public final void rule__CallExp__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6366:1: ( ( ')' ) )
            // InternalAle.g:6367:1: ( ')' )
            {
            // InternalAle.g:6367:1: ( ')' )
            // InternalAle.g:6368:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getRightParenthesisKeyword_0_4()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getRightParenthesisKeyword_0_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_0__4__Impl"


    // $ANTLR start "rule__CallExp__Group_1__0"
    // InternalAle.g:6378:1: rule__CallExp__Group_1__0 : rule__CallExp__Group_1__0__Impl rule__CallExp__Group_1__1 ;
    public final void rule__CallExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6382:1: ( rule__CallExp__Group_1__0__Impl rule__CallExp__Group_1__1 )
            // InternalAle.g:6383:2: rule__CallExp__Group_1__0__Impl rule__CallExp__Group_1__1
            {
            pushFollow(FOLLOW_25);
            rule__CallExp__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExp__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_1__0"


    // $ANTLR start "rule__CallExp__Group_1__0__Impl"
    // InternalAle.g:6390:1: rule__CallExp__Group_1__0__Impl : ( RULE_IDENT ) ;
    public final void rule__CallExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6394:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6395:1: ( RULE_IDENT )
            {
            // InternalAle.g:6395:1: ( RULE_IDENT )
            // InternalAle.g:6396:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getIDENTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getIDENTTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_1__0__Impl"


    // $ANTLR start "rule__CallExp__Group_1__1"
    // InternalAle.g:6405:1: rule__CallExp__Group_1__1 : rule__CallExp__Group_1__1__Impl rule__CallExp__Group_1__2 ;
    public final void rule__CallExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6409:1: ( rule__CallExp__Group_1__1__Impl rule__CallExp__Group_1__2 )
            // InternalAle.g:6410:2: rule__CallExp__Group_1__1__Impl rule__CallExp__Group_1__2
            {
            pushFollow(FOLLOW_28);
            rule__CallExp__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExp__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_1__1"


    // $ANTLR start "rule__CallExp__Group_1__1__Impl"
    // InternalAle.g:6417:1: rule__CallExp__Group_1__1__Impl : ( '(' ) ;
    public final void rule__CallExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6421:1: ( ( '(' ) )
            // InternalAle.g:6422:1: ( '(' )
            {
            // InternalAle.g:6422:1: ( '(' )
            // InternalAle.g:6423:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_1_1()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_1__1__Impl"


    // $ANTLR start "rule__CallExp__Group_1__2"
    // InternalAle.g:6432:1: rule__CallExp__Group_1__2 : rule__CallExp__Group_1__2__Impl rule__CallExp__Group_1__3 ;
    public final void rule__CallExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6436:1: ( rule__CallExp__Group_1__2__Impl rule__CallExp__Group_1__3 )
            // InternalAle.g:6437:2: rule__CallExp__Group_1__2__Impl rule__CallExp__Group_1__3
            {
            pushFollow(FOLLOW_35);
            rule__CallExp__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExp__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_1__2"


    // $ANTLR start "rule__CallExp__Group_1__2__Impl"
    // InternalAle.g:6444:1: rule__CallExp__Group_1__2__Impl : ( ruleexpressionSequence ) ;
    public final void rule__CallExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6448:1: ( ( ruleexpressionSequence ) )
            // InternalAle.g:6449:1: ( ruleexpressionSequence )
            {
            // InternalAle.g:6449:1: ( ruleexpressionSequence )
            // InternalAle.g:6450:2: ruleexpressionSequence
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getExpressionSequenceParserRuleCall_1_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpressionSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getExpressionSequenceParserRuleCall_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_1__2__Impl"


    // $ANTLR start "rule__CallExp__Group_1__3"
    // InternalAle.g:6459:1: rule__CallExp__Group_1__3 : rule__CallExp__Group_1__3__Impl ;
    public final void rule__CallExp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6463:1: ( rule__CallExp__Group_1__3__Impl )
            // InternalAle.g:6464:2: rule__CallExp__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallExp__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_1__3"


    // $ANTLR start "rule__CallExp__Group_1__3__Impl"
    // InternalAle.g:6470:1: rule__CallExp__Group_1__3__Impl : ( ')' ) ;
    public final void rule__CallExp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6474:1: ( ( ')' ) )
            // InternalAle.g:6475:1: ( ')' )
            {
            // InternalAle.g:6475:1: ( ')' )
            // InternalAle.g:6476:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getRightParenthesisKeyword_1_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getRightParenthesisKeyword_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__Group_1__3__Impl"


    // $ANTLR start "rule__ExpressionSequence__Group__0"
    // InternalAle.g:6486:1: rule__ExpressionSequence__Group__0 : rule__ExpressionSequence__Group__0__Impl rule__ExpressionSequence__Group__1 ;
    public final void rule__ExpressionSequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6490:1: ( rule__ExpressionSequence__Group__0__Impl rule__ExpressionSequence__Group__1 )
            // InternalAle.g:6491:2: rule__ExpressionSequence__Group__0__Impl rule__ExpressionSequence__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__ExpressionSequence__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExpressionSequence__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__Group__0"


    // $ANTLR start "rule__ExpressionSequence__Group__0__Impl"
    // InternalAle.g:6498:1: rule__ExpressionSequence__Group__0__Impl : ( ( rule__ExpressionSequence__SeqExprsAssignment_0 ) ) ;
    public final void rule__ExpressionSequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6502:1: ( ( ( rule__ExpressionSequence__SeqExprsAssignment_0 ) ) )
            // InternalAle.g:6503:1: ( ( rule__ExpressionSequence__SeqExprsAssignment_0 ) )
            {
            // InternalAle.g:6503:1: ( ( rule__ExpressionSequence__SeqExprsAssignment_0 ) )
            // InternalAle.g:6504:2: ( rule__ExpressionSequence__SeqExprsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getSeqExprsAssignment_0()); 
            }
            // InternalAle.g:6505:2: ( rule__ExpressionSequence__SeqExprsAssignment_0 )
            // InternalAle.g:6505:3: rule__ExpressionSequence__SeqExprsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionSequence__SeqExprsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceAccess().getSeqExprsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__Group__0__Impl"


    // $ANTLR start "rule__ExpressionSequence__Group__1"
    // InternalAle.g:6513:1: rule__ExpressionSequence__Group__1 : rule__ExpressionSequence__Group__1__Impl ;
    public final void rule__ExpressionSequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6517:1: ( rule__ExpressionSequence__Group__1__Impl )
            // InternalAle.g:6518:2: rule__ExpressionSequence__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionSequence__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__Group__1"


    // $ANTLR start "rule__ExpressionSequence__Group__1__Impl"
    // InternalAle.g:6524:1: rule__ExpressionSequence__Group__1__Impl : ( ( rule__ExpressionSequence__Group_1__0 )* ) ;
    public final void rule__ExpressionSequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6528:1: ( ( ( rule__ExpressionSequence__Group_1__0 )* ) )
            // InternalAle.g:6529:1: ( ( rule__ExpressionSequence__Group_1__0 )* )
            {
            // InternalAle.g:6529:1: ( ( rule__ExpressionSequence__Group_1__0 )* )
            // InternalAle.g:6530:2: ( rule__ExpressionSequence__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getGroup_1()); 
            }
            // InternalAle.g:6531:2: ( rule__ExpressionSequence__Group_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==43) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalAle.g:6531:3: rule__ExpressionSequence__Group_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__ExpressionSequence__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__Group__1__Impl"


    // $ANTLR start "rule__ExpressionSequence__Group_1__0"
    // InternalAle.g:6540:1: rule__ExpressionSequence__Group_1__0 : rule__ExpressionSequence__Group_1__0__Impl rule__ExpressionSequence__Group_1__1 ;
    public final void rule__ExpressionSequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6544:1: ( rule__ExpressionSequence__Group_1__0__Impl rule__ExpressionSequence__Group_1__1 )
            // InternalAle.g:6545:2: rule__ExpressionSequence__Group_1__0__Impl rule__ExpressionSequence__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__ExpressionSequence__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ExpressionSequence__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__Group_1__0"


    // $ANTLR start "rule__ExpressionSequence__Group_1__0__Impl"
    // InternalAle.g:6552:1: rule__ExpressionSequence__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ExpressionSequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6556:1: ( ( ',' ) )
            // InternalAle.g:6557:1: ( ',' )
            {
            // InternalAle.g:6557:1: ( ',' )
            // InternalAle.g:6558:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getCommaKeyword_1_0()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceAccess().getCommaKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__Group_1__0__Impl"


    // $ANTLR start "rule__ExpressionSequence__Group_1__1"
    // InternalAle.g:6567:1: rule__ExpressionSequence__Group_1__1 : rule__ExpressionSequence__Group_1__1__Impl ;
    public final void rule__ExpressionSequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6571:1: ( rule__ExpressionSequence__Group_1__1__Impl )
            // InternalAle.g:6572:2: rule__ExpressionSequence__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionSequence__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__Group_1__1"


    // $ANTLR start "rule__ExpressionSequence__Group_1__1__Impl"
    // InternalAle.g:6578:1: rule__ExpressionSequence__Group_1__1__Impl : ( ( rule__ExpressionSequence__SeqExprsAssignment_1_1 ) ) ;
    public final void rule__ExpressionSequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6582:1: ( ( ( rule__ExpressionSequence__SeqExprsAssignment_1_1 ) ) )
            // InternalAle.g:6583:1: ( ( rule__ExpressionSequence__SeqExprsAssignment_1_1 ) )
            {
            // InternalAle.g:6583:1: ( ( rule__ExpressionSequence__SeqExprsAssignment_1_1 ) )
            // InternalAle.g:6584:2: ( rule__ExpressionSequence__SeqExprsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getSeqExprsAssignment_1_1()); 
            }
            // InternalAle.g:6585:2: ( rule__ExpressionSequence__SeqExprsAssignment_1_1 )
            // InternalAle.g:6585:3: rule__ExpressionSequence__SeqExprsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ExpressionSequence__SeqExprsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceAccess().getSeqExprsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__Group_1__1__Impl"


    // $ANTLR start "rule__VariableDefinition__Group__0"
    // InternalAle.g:6594:1: rule__VariableDefinition__Group__0 : rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 ;
    public final void rule__VariableDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6598:1: ( rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 )
            // InternalAle.g:6599:2: rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1
            {
            pushFollow(FOLLOW_54);
            rule__VariableDefinition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VariableDefinition__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__0"


    // $ANTLR start "rule__VariableDefinition__Group__0__Impl"
    // InternalAle.g:6606:1: rule__VariableDefinition__Group__0__Impl : ( RULE_IDENT ) ;
    public final void rule__VariableDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6610:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6611:1: ( RULE_IDENT )
            {
            // InternalAle.g:6611:1: ( RULE_IDENT )
            // InternalAle.g:6612:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getIDENTTerminalRuleCall_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDefinitionAccess().getIDENTTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__0__Impl"


    // $ANTLR start "rule__VariableDefinition__Group__1"
    // InternalAle.g:6621:1: rule__VariableDefinition__Group__1 : rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 ;
    public final void rule__VariableDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6625:1: ( rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 )
            // InternalAle.g:6626:2: rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2
            {
            pushFollow(FOLLOW_54);
            rule__VariableDefinition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VariableDefinition__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__1"


    // $ANTLR start "rule__VariableDefinition__Group__1__Impl"
    // InternalAle.g:6633:1: rule__VariableDefinition__Group__1__Impl : ( ( rule__VariableDefinition__Group_1__0 )? ) ;
    public final void rule__VariableDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6637:1: ( ( ( rule__VariableDefinition__Group_1__0 )? ) )
            // InternalAle.g:6638:1: ( ( rule__VariableDefinition__Group_1__0 )? )
            {
            // InternalAle.g:6638:1: ( ( rule__VariableDefinition__Group_1__0 )? )
            // InternalAle.g:6639:2: ( rule__VariableDefinition__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getGroup_1()); 
            }
            // InternalAle.g:6640:2: ( rule__VariableDefinition__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==67) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAle.g:6640:3: rule__VariableDefinition__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VariableDefinition__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDefinitionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__1__Impl"


    // $ANTLR start "rule__VariableDefinition__Group__2"
    // InternalAle.g:6648:1: rule__VariableDefinition__Group__2 : rule__VariableDefinition__Group__2__Impl ;
    public final void rule__VariableDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6652:1: ( rule__VariableDefinition__Group__2__Impl )
            // InternalAle.g:6653:2: rule__VariableDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VariableDefinition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__2"


    // $ANTLR start "rule__VariableDefinition__Group__2__Impl"
    // InternalAle.g:6659:1: rule__VariableDefinition__Group__2__Impl : ( '|' ) ;
    public final void rule__VariableDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6663:1: ( ( '|' ) )
            // InternalAle.g:6664:1: ( '|' )
            {
            // InternalAle.g:6664:1: ( '|' )
            // InternalAle.g:6665:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getVerticalLineKeyword_2()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDefinitionAccess().getVerticalLineKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__2__Impl"


    // $ANTLR start "rule__VariableDefinition__Group_1__0"
    // InternalAle.g:6675:1: rule__VariableDefinition__Group_1__0 : rule__VariableDefinition__Group_1__0__Impl rule__VariableDefinition__Group_1__1 ;
    public final void rule__VariableDefinition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6679:1: ( rule__VariableDefinition__Group_1__0__Impl rule__VariableDefinition__Group_1__1 )
            // InternalAle.g:6680:2: rule__VariableDefinition__Group_1__0__Impl rule__VariableDefinition__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__VariableDefinition__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__VariableDefinition__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group_1__0"


    // $ANTLR start "rule__VariableDefinition__Group_1__0__Impl"
    // InternalAle.g:6687:1: rule__VariableDefinition__Group_1__0__Impl : ( ':' ) ;
    public final void rule__VariableDefinition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6691:1: ( ( ':' ) )
            // InternalAle.g:6692:1: ( ':' )
            {
            // InternalAle.g:6692:1: ( ':' )
            // InternalAle.g:6693:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getColonKeyword_1_0()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDefinitionAccess().getColonKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group_1__0__Impl"


    // $ANTLR start "rule__VariableDefinition__Group_1__1"
    // InternalAle.g:6702:1: rule__VariableDefinition__Group_1__1 : rule__VariableDefinition__Group_1__1__Impl ;
    public final void rule__VariableDefinition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6706:1: ( rule__VariableDefinition__Group_1__1__Impl )
            // InternalAle.g:6707:2: rule__VariableDefinition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VariableDefinition__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group_1__1"


    // $ANTLR start "rule__VariableDefinition__Group_1__1__Impl"
    // InternalAle.g:6713:1: rule__VariableDefinition__Group_1__1__Impl : ( ruletypeLiteral ) ;
    public final void rule__VariableDefinition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6717:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:6718:1: ( ruletypeLiteral )
            {
            // InternalAle.g:6718:1: ( ruletypeLiteral )
            // InternalAle.g:6719:2: ruletypeLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getTypeLiteralParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_2);
            ruletypeLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDefinitionAccess().getTypeLiteralParserRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group_1__1__Impl"


    // $ANTLR start "rule__Literal__Group_6__0"
    // InternalAle.g:6729:1: rule__Literal__Group_6__0 : rule__Literal__Group_6__0__Impl rule__Literal__Group_6__1 ;
    public final void rule__Literal__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6733:1: ( rule__Literal__Group_6__0__Impl rule__Literal__Group_6__1 )
            // InternalAle.g:6734:2: rule__Literal__Group_6__0__Impl rule__Literal__Group_6__1
            {
            pushFollow(FOLLOW_28);
            rule__Literal__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_6__0"


    // $ANTLR start "rule__Literal__Group_6__0__Impl"
    // InternalAle.g:6741:1: rule__Literal__Group_6__0__Impl : ( 'Sequence{' ) ;
    public final void rule__Literal__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6745:1: ( ( 'Sequence{' ) )
            // InternalAle.g:6746:1: ( 'Sequence{' )
            {
            // InternalAle.g:6746:1: ( 'Sequence{' )
            // InternalAle.g:6747:2: 'Sequence{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getSequenceKeyword_6_0()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getSequenceKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_6__0__Impl"


    // $ANTLR start "rule__Literal__Group_6__1"
    // InternalAle.g:6756:1: rule__Literal__Group_6__1 : rule__Literal__Group_6__1__Impl rule__Literal__Group_6__2 ;
    public final void rule__Literal__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6760:1: ( rule__Literal__Group_6__1__Impl rule__Literal__Group_6__2 )
            // InternalAle.g:6761:2: rule__Literal__Group_6__1__Impl rule__Literal__Group_6__2
            {
            pushFollow(FOLLOW_55);
            rule__Literal__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_6__1"


    // $ANTLR start "rule__Literal__Group_6__1__Impl"
    // InternalAle.g:6768:1: rule__Literal__Group_6__1__Impl : ( ruleexpressionSequence ) ;
    public final void rule__Literal__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6772:1: ( ( ruleexpressionSequence ) )
            // InternalAle.g:6773:1: ( ruleexpressionSequence )
            {
            // InternalAle.g:6773:1: ( ruleexpressionSequence )
            // InternalAle.g:6774:2: ruleexpressionSequence
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_6_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpressionSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_6__1__Impl"


    // $ANTLR start "rule__Literal__Group_6__2"
    // InternalAle.g:6783:1: rule__Literal__Group_6__2 : rule__Literal__Group_6__2__Impl ;
    public final void rule__Literal__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6787:1: ( rule__Literal__Group_6__2__Impl )
            // InternalAle.g:6788:2: rule__Literal__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_6__2"


    // $ANTLR start "rule__Literal__Group_6__2__Impl"
    // InternalAle.g:6794:1: rule__Literal__Group_6__2__Impl : ( '}' ) ;
    public final void rule__Literal__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6798:1: ( ( '}' ) )
            // InternalAle.g:6799:1: ( '}' )
            {
            // InternalAle.g:6799:1: ( '}' )
            // InternalAle.g:6800:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_6_2()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_6__2__Impl"


    // $ANTLR start "rule__Literal__Group_7__0"
    // InternalAle.g:6810:1: rule__Literal__Group_7__0 : rule__Literal__Group_7__0__Impl rule__Literal__Group_7__1 ;
    public final void rule__Literal__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6814:1: ( rule__Literal__Group_7__0__Impl rule__Literal__Group_7__1 )
            // InternalAle.g:6815:2: rule__Literal__Group_7__0__Impl rule__Literal__Group_7__1
            {
            pushFollow(FOLLOW_28);
            rule__Literal__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_7__0"


    // $ANTLR start "rule__Literal__Group_7__0__Impl"
    // InternalAle.g:6822:1: rule__Literal__Group_7__0__Impl : ( 'OrderedSet{' ) ;
    public final void rule__Literal__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6826:1: ( ( 'OrderedSet{' ) )
            // InternalAle.g:6827:1: ( 'OrderedSet{' )
            {
            // InternalAle.g:6827:1: ( 'OrderedSet{' )
            // InternalAle.g:6828:2: 'OrderedSet{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getOrderedSetKeyword_7_0()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getOrderedSetKeyword_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_7__0__Impl"


    // $ANTLR start "rule__Literal__Group_7__1"
    // InternalAle.g:6837:1: rule__Literal__Group_7__1 : rule__Literal__Group_7__1__Impl rule__Literal__Group_7__2 ;
    public final void rule__Literal__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6841:1: ( rule__Literal__Group_7__1__Impl rule__Literal__Group_7__2 )
            // InternalAle.g:6842:2: rule__Literal__Group_7__1__Impl rule__Literal__Group_7__2
            {
            pushFollow(FOLLOW_55);
            rule__Literal__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_7__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_7__1"


    // $ANTLR start "rule__Literal__Group_7__1__Impl"
    // InternalAle.g:6849:1: rule__Literal__Group_7__1__Impl : ( ruleexpressionSequence ) ;
    public final void rule__Literal__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6853:1: ( ( ruleexpressionSequence ) )
            // InternalAle.g:6854:1: ( ruleexpressionSequence )
            {
            // InternalAle.g:6854:1: ( ruleexpressionSequence )
            // InternalAle.g:6855:2: ruleexpressionSequence
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_7_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpressionSequence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getExpressionSequenceParserRuleCall_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_7__1__Impl"


    // $ANTLR start "rule__Literal__Group_7__2"
    // InternalAle.g:6864:1: rule__Literal__Group_7__2 : rule__Literal__Group_7__2__Impl ;
    public final void rule__Literal__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6868:1: ( rule__Literal__Group_7__2__Impl )
            // InternalAle.g:6869:2: rule__Literal__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Group_7__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_7__2"


    // $ANTLR start "rule__Literal__Group_7__2__Impl"
    // InternalAle.g:6875:1: rule__Literal__Group_7__2__Impl : ( '}' ) ;
    public final void rule__Literal__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6879:1: ( ( '}' ) )
            // InternalAle.g:6880:1: ( '}' )
            {
            // InternalAle.g:6880:1: ( '}' )
            // InternalAle.g:6881:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_7_2()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_7_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_7__2__Impl"


    // $ANTLR start "rule__Literal__Group_8__0"
    // InternalAle.g:6891:1: rule__Literal__Group_8__0 : rule__Literal__Group_8__0__Impl rule__Literal__Group_8__1 ;
    public final void rule__Literal__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6895:1: ( rule__Literal__Group_8__0__Impl rule__Literal__Group_8__1 )
            // InternalAle.g:6896:2: rule__Literal__Group_8__0__Impl rule__Literal__Group_8__1
            {
            pushFollow(FOLLOW_56);
            rule__Literal__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_8__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__0"


    // $ANTLR start "rule__Literal__Group_8__0__Impl"
    // InternalAle.g:6903:1: rule__Literal__Group_8__0__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6907:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6908:1: ( RULE_IDENT )
            {
            // InternalAle.g:6908:1: ( RULE_IDENT )
            // InternalAle.g:6909:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_8_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__0__Impl"


    // $ANTLR start "rule__Literal__Group_8__1"
    // InternalAle.g:6918:1: rule__Literal__Group_8__1 : rule__Literal__Group_8__1__Impl rule__Literal__Group_8__2 ;
    public final void rule__Literal__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6922:1: ( rule__Literal__Group_8__1__Impl rule__Literal__Group_8__2 )
            // InternalAle.g:6923:2: rule__Literal__Group_8__1__Impl rule__Literal__Group_8__2
            {
            pushFollow(FOLLOW_3);
            rule__Literal__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_8__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__1"


    // $ANTLR start "rule__Literal__Group_8__1__Impl"
    // InternalAle.g:6930:1: rule__Literal__Group_8__1__Impl : ( '::' ) ;
    public final void rule__Literal__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6934:1: ( ( '::' ) )
            // InternalAle.g:6935:1: ( '::' )
            {
            // InternalAle.g:6935:1: ( '::' )
            // InternalAle.g:6936:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getColonColonKeyword_8_1()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getColonColonKeyword_8_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__1__Impl"


    // $ANTLR start "rule__Literal__Group_8__2"
    // InternalAle.g:6945:1: rule__Literal__Group_8__2 : rule__Literal__Group_8__2__Impl rule__Literal__Group_8__3 ;
    public final void rule__Literal__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6949:1: ( rule__Literal__Group_8__2__Impl rule__Literal__Group_8__3 )
            // InternalAle.g:6950:2: rule__Literal__Group_8__2__Impl rule__Literal__Group_8__3
            {
            pushFollow(FOLLOW_56);
            rule__Literal__Group_8__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_8__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__2"


    // $ANTLR start "rule__Literal__Group_8__2__Impl"
    // InternalAle.g:6957:1: rule__Literal__Group_8__2__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6961:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6962:1: ( RULE_IDENT )
            {
            // InternalAle.g:6962:1: ( RULE_IDENT )
            // InternalAle.g:6963:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_8_2()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_8_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__2__Impl"


    // $ANTLR start "rule__Literal__Group_8__3"
    // InternalAle.g:6972:1: rule__Literal__Group_8__3 : rule__Literal__Group_8__3__Impl rule__Literal__Group_8__4 ;
    public final void rule__Literal__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6976:1: ( rule__Literal__Group_8__3__Impl rule__Literal__Group_8__4 )
            // InternalAle.g:6977:2: rule__Literal__Group_8__3__Impl rule__Literal__Group_8__4
            {
            pushFollow(FOLLOW_3);
            rule__Literal__Group_8__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_8__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__3"


    // $ANTLR start "rule__Literal__Group_8__3__Impl"
    // InternalAle.g:6984:1: rule__Literal__Group_8__3__Impl : ( '::' ) ;
    public final void rule__Literal__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6988:1: ( ( '::' ) )
            // InternalAle.g:6989:1: ( '::' )
            {
            // InternalAle.g:6989:1: ( '::' )
            // InternalAle.g:6990:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getColonColonKeyword_8_3()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getColonColonKeyword_8_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__3__Impl"


    // $ANTLR start "rule__Literal__Group_8__4"
    // InternalAle.g:6999:1: rule__Literal__Group_8__4 : rule__Literal__Group_8__4__Impl ;
    public final void rule__Literal__Group_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7003:1: ( rule__Literal__Group_8__4__Impl )
            // InternalAle.g:7004:2: rule__Literal__Group_8__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Group_8__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__4"


    // $ANTLR start "rule__Literal__Group_8__4__Impl"
    // InternalAle.g:7010:1: rule__Literal__Group_8__4__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7014:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7015:1: ( RULE_IDENT )
            {
            // InternalAle.g:7015:1: ( RULE_IDENT )
            // InternalAle.g:7016:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_8_4()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_8_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_8__4__Impl"


    // $ANTLR start "rule__Literal__Group_9__0"
    // InternalAle.g:7026:1: rule__Literal__Group_9__0 : rule__Literal__Group_9__0__Impl rule__Literal__Group_9__1 ;
    public final void rule__Literal__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7030:1: ( rule__Literal__Group_9__0__Impl rule__Literal__Group_9__1 )
            // InternalAle.g:7031:2: rule__Literal__Group_9__0__Impl rule__Literal__Group_9__1
            {
            pushFollow(FOLLOW_56);
            rule__Literal__Group_9__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_9__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_9__0"


    // $ANTLR start "rule__Literal__Group_9__0__Impl"
    // InternalAle.g:7038:1: rule__Literal__Group_9__0__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7042:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7043:1: ( RULE_IDENT )
            {
            // InternalAle.g:7043:1: ( RULE_IDENT )
            // InternalAle.g:7044:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_9_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_9_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_9__0__Impl"


    // $ANTLR start "rule__Literal__Group_9__1"
    // InternalAle.g:7053:1: rule__Literal__Group_9__1 : rule__Literal__Group_9__1__Impl rule__Literal__Group_9__2 ;
    public final void rule__Literal__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7057:1: ( rule__Literal__Group_9__1__Impl rule__Literal__Group_9__2 )
            // InternalAle.g:7058:2: rule__Literal__Group_9__1__Impl rule__Literal__Group_9__2
            {
            pushFollow(FOLLOW_3);
            rule__Literal__Group_9__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_9__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_9__1"


    // $ANTLR start "rule__Literal__Group_9__1__Impl"
    // InternalAle.g:7065:1: rule__Literal__Group_9__1__Impl : ( '::' ) ;
    public final void rule__Literal__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7069:1: ( ( '::' ) )
            // InternalAle.g:7070:1: ( '::' )
            {
            // InternalAle.g:7070:1: ( '::' )
            // InternalAle.g:7071:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getColonColonKeyword_9_1()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getColonColonKeyword_9_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_9__1__Impl"


    // $ANTLR start "rule__Literal__Group_9__2"
    // InternalAle.g:7080:1: rule__Literal__Group_9__2 : rule__Literal__Group_9__2__Impl rule__Literal__Group_9__3 ;
    public final void rule__Literal__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7084:1: ( rule__Literal__Group_9__2__Impl rule__Literal__Group_9__3 )
            // InternalAle.g:7085:2: rule__Literal__Group_9__2__Impl rule__Literal__Group_9__3
            {
            pushFollow(FOLLOW_57);
            rule__Literal__Group_9__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Literal__Group_9__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_9__2"


    // $ANTLR start "rule__Literal__Group_9__2__Impl"
    // InternalAle.g:7092:1: rule__Literal__Group_9__2__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7096:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7097:1: ( RULE_IDENT )
            {
            // InternalAle.g:7097:1: ( RULE_IDENT )
            // InternalAle.g:7098:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_9_2()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIDENTTerminalRuleCall_9_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_9__2__Impl"


    // $ANTLR start "rule__Literal__Group_9__3"
    // InternalAle.g:7107:1: rule__Literal__Group_9__3 : rule__Literal__Group_9__3__Impl ;
    public final void rule__Literal__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7111:1: ( rule__Literal__Group_9__3__Impl )
            // InternalAle.g:7112:2: rule__Literal__Group_9__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Group_9__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_9__3"


    // $ANTLR start "rule__Literal__Group_9__3__Impl"
    // InternalAle.g:7118:1: rule__Literal__Group_9__3__Impl : ( ':' ) ;
    public final void rule__Literal__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7122:1: ( ( ':' ) )
            // InternalAle.g:7123:1: ( ':' )
            {
            // InternalAle.g:7123:1: ( ':' )
            // InternalAle.g:7124:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getColonKeyword_9_3()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getColonKeyword_9_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_9__3__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_0__0"
    // InternalAle.g:7134:1: rule__TypeLiteral__Group_0__0 : rule__TypeLiteral__Group_0__0__Impl rule__TypeLiteral__Group_0__1 ;
    public final void rule__TypeLiteral__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7138:1: ( rule__TypeLiteral__Group_0__0__Impl rule__TypeLiteral__Group_0__1 )
            // InternalAle.g:7139:2: rule__TypeLiteral__Group_0__0__Impl rule__TypeLiteral__Group_0__1
            {
            pushFollow(FOLLOW_58);
            rule__TypeLiteral__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_0__0"


    // $ANTLR start "rule__TypeLiteral__Group_0__0__Impl"
    // InternalAle.g:7146:1: rule__TypeLiteral__Group_0__0__Impl : ( () ) ;
    public final void rule__TypeLiteral__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7150:1: ( ( () ) )
            // InternalAle.g:7151:1: ( () )
            {
            // InternalAle.g:7151:1: ( () )
            // InternalAle.g:7152:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralStringAction_0_0()); 
            }
            // InternalAle.g:7153:2: ()
            // InternalAle.g:7153:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralStringAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_0__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_0__1"
    // InternalAle.g:7161:1: rule__TypeLiteral__Group_0__1 : rule__TypeLiteral__Group_0__1__Impl ;
    public final void rule__TypeLiteral__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7165:1: ( rule__TypeLiteral__Group_0__1__Impl )
            // InternalAle.g:7166:2: rule__TypeLiteral__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_0__1"


    // $ANTLR start "rule__TypeLiteral__Group_0__1__Impl"
    // InternalAle.g:7172:1: rule__TypeLiteral__Group_0__1__Impl : ( 'String' ) ;
    public final void rule__TypeLiteral__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7176:1: ( ( 'String' ) )
            // InternalAle.g:7177:1: ( 'String' )
            {
            // InternalAle.g:7177:1: ( 'String' )
            // InternalAle.g:7178:2: 'String'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getStringKeyword_0_1()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getStringKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_0__1__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_1__0"
    // InternalAle.g:7188:1: rule__TypeLiteral__Group_1__0 : rule__TypeLiteral__Group_1__0__Impl rule__TypeLiteral__Group_1__1 ;
    public final void rule__TypeLiteral__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7192:1: ( rule__TypeLiteral__Group_1__0__Impl rule__TypeLiteral__Group_1__1 )
            // InternalAle.g:7193:2: rule__TypeLiteral__Group_1__0__Impl rule__TypeLiteral__Group_1__1
            {
            pushFollow(FOLLOW_59);
            rule__TypeLiteral__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_1__0"


    // $ANTLR start "rule__TypeLiteral__Group_1__0__Impl"
    // InternalAle.g:7200:1: rule__TypeLiteral__Group_1__0__Impl : ( () ) ;
    public final void rule__TypeLiteral__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7204:1: ( ( () ) )
            // InternalAle.g:7205:1: ( () )
            {
            // InternalAle.g:7205:1: ( () )
            // InternalAle.g:7206:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralIntegerAction_1_0()); 
            }
            // InternalAle.g:7207:2: ()
            // InternalAle.g:7207:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralIntegerAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_1__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_1__1"
    // InternalAle.g:7215:1: rule__TypeLiteral__Group_1__1 : rule__TypeLiteral__Group_1__1__Impl ;
    public final void rule__TypeLiteral__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7219:1: ( rule__TypeLiteral__Group_1__1__Impl )
            // InternalAle.g:7220:2: rule__TypeLiteral__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_1__1"


    // $ANTLR start "rule__TypeLiteral__Group_1__1__Impl"
    // InternalAle.g:7226:1: rule__TypeLiteral__Group_1__1__Impl : ( 'Integer' ) ;
    public final void rule__TypeLiteral__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7230:1: ( ( 'Integer' ) )
            // InternalAle.g:7231:1: ( 'Integer' )
            {
            // InternalAle.g:7231:1: ( 'Integer' )
            // InternalAle.g:7232:2: 'Integer'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getIntegerKeyword_1_1()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getIntegerKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_1__1__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_2__0"
    // InternalAle.g:7242:1: rule__TypeLiteral__Group_2__0 : rule__TypeLiteral__Group_2__0__Impl rule__TypeLiteral__Group_2__1 ;
    public final void rule__TypeLiteral__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7246:1: ( rule__TypeLiteral__Group_2__0__Impl rule__TypeLiteral__Group_2__1 )
            // InternalAle.g:7247:2: rule__TypeLiteral__Group_2__0__Impl rule__TypeLiteral__Group_2__1
            {
            pushFollow(FOLLOW_60);
            rule__TypeLiteral__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_2__0"


    // $ANTLR start "rule__TypeLiteral__Group_2__0__Impl"
    // InternalAle.g:7254:1: rule__TypeLiteral__Group_2__0__Impl : ( () ) ;
    public final void rule__TypeLiteral__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7258:1: ( ( () ) )
            // InternalAle.g:7259:1: ( () )
            {
            // InternalAle.g:7259:1: ( () )
            // InternalAle.g:7260:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralRealAction_2_0()); 
            }
            // InternalAle.g:7261:2: ()
            // InternalAle.g:7261:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralRealAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_2__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_2__1"
    // InternalAle.g:7269:1: rule__TypeLiteral__Group_2__1 : rule__TypeLiteral__Group_2__1__Impl ;
    public final void rule__TypeLiteral__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7273:1: ( rule__TypeLiteral__Group_2__1__Impl )
            // InternalAle.g:7274:2: rule__TypeLiteral__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_2__1"


    // $ANTLR start "rule__TypeLiteral__Group_2__1__Impl"
    // InternalAle.g:7280:1: rule__TypeLiteral__Group_2__1__Impl : ( 'Real' ) ;
    public final void rule__TypeLiteral__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7284:1: ( ( 'Real' ) )
            // InternalAle.g:7285:1: ( 'Real' )
            {
            // InternalAle.g:7285:1: ( 'Real' )
            // InternalAle.g:7286:2: 'Real'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getRealKeyword_2_1()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getRealKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_2__1__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_3__0"
    // InternalAle.g:7296:1: rule__TypeLiteral__Group_3__0 : rule__TypeLiteral__Group_3__0__Impl rule__TypeLiteral__Group_3__1 ;
    public final void rule__TypeLiteral__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7300:1: ( rule__TypeLiteral__Group_3__0__Impl rule__TypeLiteral__Group_3__1 )
            // InternalAle.g:7301:2: rule__TypeLiteral__Group_3__0__Impl rule__TypeLiteral__Group_3__1
            {
            pushFollow(FOLLOW_61);
            rule__TypeLiteral__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_3__0"


    // $ANTLR start "rule__TypeLiteral__Group_3__0__Impl"
    // InternalAle.g:7308:1: rule__TypeLiteral__Group_3__0__Impl : ( () ) ;
    public final void rule__TypeLiteral__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7312:1: ( ( () ) )
            // InternalAle.g:7313:1: ( () )
            {
            // InternalAle.g:7313:1: ( () )
            // InternalAle.g:7314:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralBooleanAction_3_0()); 
            }
            // InternalAle.g:7315:2: ()
            // InternalAle.g:7315:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralBooleanAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_3__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_3__1"
    // InternalAle.g:7323:1: rule__TypeLiteral__Group_3__1 : rule__TypeLiteral__Group_3__1__Impl ;
    public final void rule__TypeLiteral__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7327:1: ( rule__TypeLiteral__Group_3__1__Impl )
            // InternalAle.g:7328:2: rule__TypeLiteral__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_3__1"


    // $ANTLR start "rule__TypeLiteral__Group_3__1__Impl"
    // InternalAle.g:7334:1: rule__TypeLiteral__Group_3__1__Impl : ( 'Boolean' ) ;
    public final void rule__TypeLiteral__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7338:1: ( ( 'Boolean' ) )
            // InternalAle.g:7339:1: ( 'Boolean' )
            {
            // InternalAle.g:7339:1: ( 'Boolean' )
            // InternalAle.g:7340:2: 'Boolean'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getBooleanKeyword_3_1()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getBooleanKeyword_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_3__1__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_4__0"
    // InternalAle.g:7350:1: rule__TypeLiteral__Group_4__0 : rule__TypeLiteral__Group_4__0__Impl rule__TypeLiteral__Group_4__1 ;
    public final void rule__TypeLiteral__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7354:1: ( rule__TypeLiteral__Group_4__0__Impl rule__TypeLiteral__Group_4__1 )
            // InternalAle.g:7355:2: rule__TypeLiteral__Group_4__0__Impl rule__TypeLiteral__Group_4__1
            {
            pushFollow(FOLLOW_62);
            rule__TypeLiteral__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_4__0"


    // $ANTLR start "rule__TypeLiteral__Group_4__0__Impl"
    // InternalAle.g:7362:1: rule__TypeLiteral__Group_4__0__Impl : ( () ) ;
    public final void rule__TypeLiteral__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7366:1: ( ( () ) )
            // InternalAle.g:7367:1: ( () )
            {
            // InternalAle.g:7367:1: ( () )
            // InternalAle.g:7368:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralSequenceAction_4_0()); 
            }
            // InternalAle.g:7369:2: ()
            // InternalAle.g:7369:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralSequenceAction_4_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_4__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_4__1"
    // InternalAle.g:7377:1: rule__TypeLiteral__Group_4__1 : rule__TypeLiteral__Group_4__1__Impl rule__TypeLiteral__Group_4__2 ;
    public final void rule__TypeLiteral__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7381:1: ( rule__TypeLiteral__Group_4__1__Impl rule__TypeLiteral__Group_4__2 )
            // InternalAle.g:7382:2: rule__TypeLiteral__Group_4__1__Impl rule__TypeLiteral__Group_4__2
            {
            pushFollow(FOLLOW_24);
            rule__TypeLiteral__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_4__1"


    // $ANTLR start "rule__TypeLiteral__Group_4__1__Impl"
    // InternalAle.g:7389:1: rule__TypeLiteral__Group_4__1__Impl : ( 'Sequence(' ) ;
    public final void rule__TypeLiteral__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7393:1: ( ( 'Sequence(' ) )
            // InternalAle.g:7394:1: ( 'Sequence(' )
            {
            // InternalAle.g:7394:1: ( 'Sequence(' )
            // InternalAle.g:7395:2: 'Sequence('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getSequenceKeyword_4_1()); 
            }
            match(input,76,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getSequenceKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_4__1__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_4__2"
    // InternalAle.g:7404:1: rule__TypeLiteral__Group_4__2 : rule__TypeLiteral__Group_4__2__Impl rule__TypeLiteral__Group_4__3 ;
    public final void rule__TypeLiteral__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7408:1: ( rule__TypeLiteral__Group_4__2__Impl rule__TypeLiteral__Group_4__3 )
            // InternalAle.g:7409:2: rule__TypeLiteral__Group_4__2__Impl rule__TypeLiteral__Group_4__3
            {
            pushFollow(FOLLOW_35);
            rule__TypeLiteral__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_4__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_4__2"


    // $ANTLR start "rule__TypeLiteral__Group_4__2__Impl"
    // InternalAle.g:7416:1: rule__TypeLiteral__Group_4__2__Impl : ( ( rule__TypeLiteral__SubTypeAssignment_4_2 ) ) ;
    public final void rule__TypeLiteral__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7420:1: ( ( ( rule__TypeLiteral__SubTypeAssignment_4_2 ) ) )
            // InternalAle.g:7421:1: ( ( rule__TypeLiteral__SubTypeAssignment_4_2 ) )
            {
            // InternalAle.g:7421:1: ( ( rule__TypeLiteral__SubTypeAssignment_4_2 ) )
            // InternalAle.g:7422:2: ( rule__TypeLiteral__SubTypeAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getSubTypeAssignment_4_2()); 
            }
            // InternalAle.g:7423:2: ( rule__TypeLiteral__SubTypeAssignment_4_2 )
            // InternalAle.g:7423:3: rule__TypeLiteral__SubTypeAssignment_4_2
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__SubTypeAssignment_4_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getSubTypeAssignment_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_4__2__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_4__3"
    // InternalAle.g:7431:1: rule__TypeLiteral__Group_4__3 : rule__TypeLiteral__Group_4__3__Impl ;
    public final void rule__TypeLiteral__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7435:1: ( rule__TypeLiteral__Group_4__3__Impl )
            // InternalAle.g:7436:2: rule__TypeLiteral__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_4__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_4__3"


    // $ANTLR start "rule__TypeLiteral__Group_4__3__Impl"
    // InternalAle.g:7442:1: rule__TypeLiteral__Group_4__3__Impl : ( ')' ) ;
    public final void rule__TypeLiteral__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7446:1: ( ( ')' ) )
            // InternalAle.g:7447:1: ( ')' )
            {
            // InternalAle.g:7447:1: ( ')' )
            // InternalAle.g:7448:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_4_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_4_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_4__3__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_5__0"
    // InternalAle.g:7458:1: rule__TypeLiteral__Group_5__0 : rule__TypeLiteral__Group_5__0__Impl rule__TypeLiteral__Group_5__1 ;
    public final void rule__TypeLiteral__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7462:1: ( rule__TypeLiteral__Group_5__0__Impl rule__TypeLiteral__Group_5__1 )
            // InternalAle.g:7463:2: rule__TypeLiteral__Group_5__0__Impl rule__TypeLiteral__Group_5__1
            {
            pushFollow(FOLLOW_63);
            rule__TypeLiteral__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_5__0"


    // $ANTLR start "rule__TypeLiteral__Group_5__0__Impl"
    // InternalAle.g:7470:1: rule__TypeLiteral__Group_5__0__Impl : ( () ) ;
    public final void rule__TypeLiteral__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7474:1: ( ( () ) )
            // InternalAle.g:7475:1: ( () )
            {
            // InternalAle.g:7475:1: ( () )
            // InternalAle.g:7476:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralOrderedTypeSetAction_5_0()); 
            }
            // InternalAle.g:7477:2: ()
            // InternalAle.g:7477:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralOrderedTypeSetAction_5_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_5__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_5__1"
    // InternalAle.g:7485:1: rule__TypeLiteral__Group_5__1 : rule__TypeLiteral__Group_5__1__Impl rule__TypeLiteral__Group_5__2 ;
    public final void rule__TypeLiteral__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7489:1: ( rule__TypeLiteral__Group_5__1__Impl rule__TypeLiteral__Group_5__2 )
            // InternalAle.g:7490:2: rule__TypeLiteral__Group_5__1__Impl rule__TypeLiteral__Group_5__2
            {
            pushFollow(FOLLOW_24);
            rule__TypeLiteral__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_5__1"


    // $ANTLR start "rule__TypeLiteral__Group_5__1__Impl"
    // InternalAle.g:7497:1: rule__TypeLiteral__Group_5__1__Impl : ( 'OrderedSet(' ) ;
    public final void rule__TypeLiteral__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7501:1: ( ( 'OrderedSet(' ) )
            // InternalAle.g:7502:1: ( 'OrderedSet(' )
            {
            // InternalAle.g:7502:1: ( 'OrderedSet(' )
            // InternalAle.g:7503:2: 'OrderedSet('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getOrderedSetKeyword_5_1()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getOrderedSetKeyword_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_5__1__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_5__2"
    // InternalAle.g:7512:1: rule__TypeLiteral__Group_5__2 : rule__TypeLiteral__Group_5__2__Impl rule__TypeLiteral__Group_5__3 ;
    public final void rule__TypeLiteral__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7516:1: ( rule__TypeLiteral__Group_5__2__Impl rule__TypeLiteral__Group_5__3 )
            // InternalAle.g:7517:2: rule__TypeLiteral__Group_5__2__Impl rule__TypeLiteral__Group_5__3
            {
            pushFollow(FOLLOW_35);
            rule__TypeLiteral__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_5__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_5__2"


    // $ANTLR start "rule__TypeLiteral__Group_5__2__Impl"
    // InternalAle.g:7524:1: rule__TypeLiteral__Group_5__2__Impl : ( ( rule__TypeLiteral__SubTypeAssignment_5_2 ) ) ;
    public final void rule__TypeLiteral__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7528:1: ( ( ( rule__TypeLiteral__SubTypeAssignment_5_2 ) ) )
            // InternalAle.g:7529:1: ( ( rule__TypeLiteral__SubTypeAssignment_5_2 ) )
            {
            // InternalAle.g:7529:1: ( ( rule__TypeLiteral__SubTypeAssignment_5_2 ) )
            // InternalAle.g:7530:2: ( rule__TypeLiteral__SubTypeAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getSubTypeAssignment_5_2()); 
            }
            // InternalAle.g:7531:2: ( rule__TypeLiteral__SubTypeAssignment_5_2 )
            // InternalAle.g:7531:3: rule__TypeLiteral__SubTypeAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__SubTypeAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getSubTypeAssignment_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_5__2__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_5__3"
    // InternalAle.g:7539:1: rule__TypeLiteral__Group_5__3 : rule__TypeLiteral__Group_5__3__Impl ;
    public final void rule__TypeLiteral__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7543:1: ( rule__TypeLiteral__Group_5__3__Impl )
            // InternalAle.g:7544:2: rule__TypeLiteral__Group_5__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_5__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_5__3"


    // $ANTLR start "rule__TypeLiteral__Group_5__3__Impl"
    // InternalAle.g:7550:1: rule__TypeLiteral__Group_5__3__Impl : ( ')' ) ;
    public final void rule__TypeLiteral__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7554:1: ( ( ')' ) )
            // InternalAle.g:7555:1: ( ')' )
            {
            // InternalAle.g:7555:1: ( ')' )
            // InternalAle.g:7556:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_5_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_5_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_5__3__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_6__0"
    // InternalAle.g:7566:1: rule__TypeLiteral__Group_6__0 : rule__TypeLiteral__Group_6__0__Impl rule__TypeLiteral__Group_6__1 ;
    public final void rule__TypeLiteral__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7570:1: ( rule__TypeLiteral__Group_6__0__Impl rule__TypeLiteral__Group_6__1 )
            // InternalAle.g:7571:2: rule__TypeLiteral__Group_6__0__Impl rule__TypeLiteral__Group_6__1
            {
            pushFollow(FOLLOW_3);
            rule__TypeLiteral__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_6__0"


    // $ANTLR start "rule__TypeLiteral__Group_6__0__Impl"
    // InternalAle.g:7578:1: rule__TypeLiteral__Group_6__0__Impl : ( () ) ;
    public final void rule__TypeLiteral__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7582:1: ( ( () ) )
            // InternalAle.g:7583:1: ( () )
            {
            // InternalAle.g:7583:1: ( () )
            // InternalAle.g:7584:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralClassifierAction_6_0()); 
            }
            // InternalAle.g:7585:2: ()
            // InternalAle.g:7585:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralClassifierAction_6_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_6__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_6__1"
    // InternalAle.g:7593:1: rule__TypeLiteral__Group_6__1 : rule__TypeLiteral__Group_6__1__Impl ;
    public final void rule__TypeLiteral__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7597:1: ( rule__TypeLiteral__Group_6__1__Impl )
            // InternalAle.g:7598:2: rule__TypeLiteral__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_6__1"


    // $ANTLR start "rule__TypeLiteral__Group_6__1__Impl"
    // InternalAle.g:7604:1: rule__TypeLiteral__Group_6__1__Impl : ( ruleclassifierTypeRule ) ;
    public final void rule__TypeLiteral__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7608:1: ( ( ruleclassifierTypeRule ) )
            // InternalAle.g:7609:1: ( ruleclassifierTypeRule )
            {
            // InternalAle.g:7609:1: ( ruleclassifierTypeRule )
            // InternalAle.g:7610:2: ruleclassifierTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_6_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleclassifierTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_6__1__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_7__0"
    // InternalAle.g:7620:1: rule__TypeLiteral__Group_7__0 : rule__TypeLiteral__Group_7__0__Impl rule__TypeLiteral__Group_7__1 ;
    public final void rule__TypeLiteral__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7624:1: ( rule__TypeLiteral__Group_7__0__Impl rule__TypeLiteral__Group_7__1 )
            // InternalAle.g:7625:2: rule__TypeLiteral__Group_7__0__Impl rule__TypeLiteral__Group_7__1
            {
            pushFollow(FOLLOW_24);
            rule__TypeLiteral__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__0"


    // $ANTLR start "rule__TypeLiteral__Group_7__0__Impl"
    // InternalAle.g:7632:1: rule__TypeLiteral__Group_7__0__Impl : ( () ) ;
    public final void rule__TypeLiteral__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7636:1: ( ( () ) )
            // InternalAle.g:7637:1: ( () )
            {
            // InternalAle.g:7637:1: ( () )
            // InternalAle.g:7638:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralPipeAction_7_0()); 
            }
            // InternalAle.g:7639:2: ()
            // InternalAle.g:7639:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralPipeAction_7_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_7__1"
    // InternalAle.g:7647:1: rule__TypeLiteral__Group_7__1 : rule__TypeLiteral__Group_7__1__Impl rule__TypeLiteral__Group_7__2 ;
    public final void rule__TypeLiteral__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7651:1: ( rule__TypeLiteral__Group_7__1__Impl rule__TypeLiteral__Group_7__2 )
            // InternalAle.g:7652:2: rule__TypeLiteral__Group_7__1__Impl rule__TypeLiteral__Group_7__2
            {
            pushFollow(FOLLOW_3);
            rule__TypeLiteral__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__1"


    // $ANTLR start "rule__TypeLiteral__Group_7__1__Impl"
    // InternalAle.g:7659:1: rule__TypeLiteral__Group_7__1__Impl : ( '{' ) ;
    public final void rule__TypeLiteral__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7663:1: ( ( '{' ) )
            // InternalAle.g:7664:1: ( '{' )
            {
            // InternalAle.g:7664:1: ( '{' )
            // InternalAle.g:7665:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getLeftCurlyBracketKeyword_7_1()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getLeftCurlyBracketKeyword_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__1__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_7__2"
    // InternalAle.g:7674:1: rule__TypeLiteral__Group_7__2 : rule__TypeLiteral__Group_7__2__Impl rule__TypeLiteral__Group_7__3 ;
    public final void rule__TypeLiteral__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7678:1: ( rule__TypeLiteral__Group_7__2__Impl rule__TypeLiteral__Group_7__3 )
            // InternalAle.g:7679:2: rule__TypeLiteral__Group_7__2__Impl rule__TypeLiteral__Group_7__3
            {
            pushFollow(FOLLOW_64);
            rule__TypeLiteral__Group_7__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__2"


    // $ANTLR start "rule__TypeLiteral__Group_7__2__Impl"
    // InternalAle.g:7686:1: rule__TypeLiteral__Group_7__2__Impl : ( ruleclassifierTypeRule ) ;
    public final void rule__TypeLiteral__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7690:1: ( ( ruleclassifierTypeRule ) )
            // InternalAle.g:7691:1: ( ruleclassifierTypeRule )
            {
            // InternalAle.g:7691:1: ( ruleclassifierTypeRule )
            // InternalAle.g:7692:2: ruleclassifierTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleclassifierTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__2__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_7__3"
    // InternalAle.g:7701:1: rule__TypeLiteral__Group_7__3 : rule__TypeLiteral__Group_7__3__Impl rule__TypeLiteral__Group_7__4 ;
    public final void rule__TypeLiteral__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7705:1: ( rule__TypeLiteral__Group_7__3__Impl rule__TypeLiteral__Group_7__4 )
            // InternalAle.g:7706:2: rule__TypeLiteral__Group_7__3__Impl rule__TypeLiteral__Group_7__4
            {
            pushFollow(FOLLOW_64);
            rule__TypeLiteral__Group_7__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__3"


    // $ANTLR start "rule__TypeLiteral__Group_7__3__Impl"
    // InternalAle.g:7713:1: rule__TypeLiteral__Group_7__3__Impl : ( ( rule__TypeLiteral__Group_7_3__0 )* ) ;
    public final void rule__TypeLiteral__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7717:1: ( ( ( rule__TypeLiteral__Group_7_3__0 )* ) )
            // InternalAle.g:7718:1: ( ( rule__TypeLiteral__Group_7_3__0 )* )
            {
            // InternalAle.g:7718:1: ( ( rule__TypeLiteral__Group_7_3__0 )* )
            // InternalAle.g:7719:2: ( rule__TypeLiteral__Group_7_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getGroup_7_3()); 
            }
            // InternalAle.g:7720:2: ( rule__TypeLiteral__Group_7_3__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==68) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalAle.g:7720:3: rule__TypeLiteral__Group_7_3__0
            	    {
            	    pushFollow(FOLLOW_65);
            	    rule__TypeLiteral__Group_7_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getGroup_7_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__3__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_7__4"
    // InternalAle.g:7728:1: rule__TypeLiteral__Group_7__4 : rule__TypeLiteral__Group_7__4__Impl ;
    public final void rule__TypeLiteral__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7732:1: ( rule__TypeLiteral__Group_7__4__Impl )
            // InternalAle.g:7733:2: rule__TypeLiteral__Group_7__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__4"


    // $ANTLR start "rule__TypeLiteral__Group_7__4__Impl"
    // InternalAle.g:7739:1: rule__TypeLiteral__Group_7__4__Impl : ( '}' ) ;
    public final void rule__TypeLiteral__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7743:1: ( ( '}' ) )
            // InternalAle.g:7744:1: ( '}' )
            {
            // InternalAle.g:7744:1: ( '}' )
            // InternalAle.g:7745:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getRightCurlyBracketKeyword_7_4()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getRightCurlyBracketKeyword_7_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__4__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_7_3__0"
    // InternalAle.g:7755:1: rule__TypeLiteral__Group_7_3__0 : rule__TypeLiteral__Group_7_3__0__Impl rule__TypeLiteral__Group_7_3__1 ;
    public final void rule__TypeLiteral__Group_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7759:1: ( rule__TypeLiteral__Group_7_3__0__Impl rule__TypeLiteral__Group_7_3__1 )
            // InternalAle.g:7760:2: rule__TypeLiteral__Group_7_3__0__Impl rule__TypeLiteral__Group_7_3__1
            {
            pushFollow(FOLLOW_3);
            rule__TypeLiteral__Group_7_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7_3__0"


    // $ANTLR start "rule__TypeLiteral__Group_7_3__0__Impl"
    // InternalAle.g:7767:1: rule__TypeLiteral__Group_7_3__0__Impl : ( '|' ) ;
    public final void rule__TypeLiteral__Group_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7771:1: ( ( '|' ) )
            // InternalAle.g:7772:1: ( '|' )
            {
            // InternalAle.g:7772:1: ( '|' )
            // InternalAle.g:7773:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getVerticalLineKeyword_7_3_0()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getVerticalLineKeyword_7_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7_3__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_7_3__1"
    // InternalAle.g:7782:1: rule__TypeLiteral__Group_7_3__1 : rule__TypeLiteral__Group_7_3__1__Impl ;
    public final void rule__TypeLiteral__Group_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7786:1: ( rule__TypeLiteral__Group_7_3__1__Impl )
            // InternalAle.g:7787:2: rule__TypeLiteral__Group_7_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7_3__1"


    // $ANTLR start "rule__TypeLiteral__Group_7_3__1__Impl"
    // InternalAle.g:7793:1: rule__TypeLiteral__Group_7_3__1__Impl : ( ruleclassifierTypeRule ) ;
    public final void rule__TypeLiteral__Group_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7797:1: ( ( ruleclassifierTypeRule ) )
            // InternalAle.g:7798:1: ( ruleclassifierTypeRule )
            {
            // InternalAle.g:7798:1: ( ruleclassifierTypeRule )
            // InternalAle.g:7799:2: ruleclassifierTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_3_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleclassifierTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7_3__1__Impl"


    // $ANTLR start "rule__ClassifierTypeRule__Group_0__0"
    // InternalAle.g:7809:1: rule__ClassifierTypeRule__Group_0__0 : rule__ClassifierTypeRule__Group_0__0__Impl rule__ClassifierTypeRule__Group_0__1 ;
    public final void rule__ClassifierTypeRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7813:1: ( rule__ClassifierTypeRule__Group_0__0__Impl rule__ClassifierTypeRule__Group_0__1 )
            // InternalAle.g:7814:2: rule__ClassifierTypeRule__Group_0__0__Impl rule__ClassifierTypeRule__Group_0__1
            {
            pushFollow(FOLLOW_56);
            rule__ClassifierTypeRule__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassifierTypeRule__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_0__0"


    // $ANTLR start "rule__ClassifierTypeRule__Group_0__0__Impl"
    // InternalAle.g:7821:1: rule__ClassifierTypeRule__Group_0__0__Impl : ( RULE_IDENT ) ;
    public final void rule__ClassifierTypeRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7825:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7826:1: ( RULE_IDENT )
            {
            // InternalAle.g:7826:1: ( RULE_IDENT )
            // InternalAle.g:7827:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getIDENTTerminalRuleCall_0_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleAccess().getIDENTTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_0__0__Impl"


    // $ANTLR start "rule__ClassifierTypeRule__Group_0__1"
    // InternalAle.g:7836:1: rule__ClassifierTypeRule__Group_0__1 : rule__ClassifierTypeRule__Group_0__1__Impl rule__ClassifierTypeRule__Group_0__2 ;
    public final void rule__ClassifierTypeRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7840:1: ( rule__ClassifierTypeRule__Group_0__1__Impl rule__ClassifierTypeRule__Group_0__2 )
            // InternalAle.g:7841:2: rule__ClassifierTypeRule__Group_0__1__Impl rule__ClassifierTypeRule__Group_0__2
            {
            pushFollow(FOLLOW_3);
            rule__ClassifierTypeRule__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassifierTypeRule__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_0__1"


    // $ANTLR start "rule__ClassifierTypeRule__Group_0__1__Impl"
    // InternalAle.g:7848:1: rule__ClassifierTypeRule__Group_0__1__Impl : ( '::' ) ;
    public final void rule__ClassifierTypeRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7852:1: ( ( '::' ) )
            // InternalAle.g:7853:1: ( '::' )
            {
            // InternalAle.g:7853:1: ( '::' )
            // InternalAle.g:7854:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getColonColonKeyword_0_1()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleAccess().getColonColonKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_0__1__Impl"


    // $ANTLR start "rule__ClassifierTypeRule__Group_0__2"
    // InternalAle.g:7863:1: rule__ClassifierTypeRule__Group_0__2 : rule__ClassifierTypeRule__Group_0__2__Impl ;
    public final void rule__ClassifierTypeRule__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7867:1: ( rule__ClassifierTypeRule__Group_0__2__Impl )
            // InternalAle.g:7868:2: rule__ClassifierTypeRule__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassifierTypeRule__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_0__2"


    // $ANTLR start "rule__ClassifierTypeRule__Group_0__2__Impl"
    // InternalAle.g:7874:1: rule__ClassifierTypeRule__Group_0__2__Impl : ( RULE_IDENT ) ;
    public final void rule__ClassifierTypeRule__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7878:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7879:1: ( RULE_IDENT )
            {
            // InternalAle.g:7879:1: ( RULE_IDENT )
            // InternalAle.g:7880:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getIDENTTerminalRuleCall_0_2()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleAccess().getIDENTTerminalRuleCall_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_0__2__Impl"


    // $ANTLR start "rule__ClassifierTypeRule__Group_1__0"
    // InternalAle.g:7890:1: rule__ClassifierTypeRule__Group_1__0 : rule__ClassifierTypeRule__Group_1__0__Impl rule__ClassifierTypeRule__Group_1__1 ;
    public final void rule__ClassifierTypeRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7894:1: ( rule__ClassifierTypeRule__Group_1__0__Impl rule__ClassifierTypeRule__Group_1__1 )
            // InternalAle.g:7895:2: rule__ClassifierTypeRule__Group_1__0__Impl rule__ClassifierTypeRule__Group_1__1
            {
            pushFollow(FOLLOW_57);
            rule__ClassifierTypeRule__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassifierTypeRule__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_1__0"


    // $ANTLR start "rule__ClassifierTypeRule__Group_1__0__Impl"
    // InternalAle.g:7902:1: rule__ClassifierTypeRule__Group_1__0__Impl : ( RULE_IDENT ) ;
    public final void rule__ClassifierTypeRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7906:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7907:1: ( RULE_IDENT )
            {
            // InternalAle.g:7907:1: ( RULE_IDENT )
            // InternalAle.g:7908:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getIDENTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleAccess().getIDENTTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_1__0__Impl"


    // $ANTLR start "rule__ClassifierTypeRule__Group_1__1"
    // InternalAle.g:7917:1: rule__ClassifierTypeRule__Group_1__1 : rule__ClassifierTypeRule__Group_1__1__Impl ;
    public final void rule__ClassifierTypeRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7921:1: ( rule__ClassifierTypeRule__Group_1__1__Impl )
            // InternalAle.g:7922:2: rule__ClassifierTypeRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassifierTypeRule__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_1__1"


    // $ANTLR start "rule__ClassifierTypeRule__Group_1__1__Impl"
    // InternalAle.g:7928:1: rule__ClassifierTypeRule__Group_1__1__Impl : ( ':' ) ;
    public final void rule__ClassifierTypeRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7932:1: ( ( ':' ) )
            // InternalAle.g:7933:1: ( ':' )
            {
            // InternalAle.g:7933:1: ( ':' )
            // InternalAle.g:7934:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getColonKeyword_1_1()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleAccess().getColonKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassifierTypeRule__Group_1__1__Impl"


    // $ANTLR start "rule__RQualified__Group__0"
    // InternalAle.g:7944:1: rule__RQualified__Group__0 : rule__RQualified__Group__0__Impl rule__RQualified__Group__1 ;
    public final void rule__RQualified__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7948:1: ( rule__RQualified__Group__0__Impl rule__RQualified__Group__1 )
            // InternalAle.g:7949:2: rule__RQualified__Group__0__Impl rule__RQualified__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__RQualified__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RQualified__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RQualified__Group__0"


    // $ANTLR start "rule__RQualified__Group__0__Impl"
    // InternalAle.g:7956:1: rule__RQualified__Group__0__Impl : ( RULE_IDENT ) ;
    public final void rule__RQualified__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7960:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7961:1: ( RULE_IDENT )
            {
            // InternalAle.g:7961:1: ( RULE_IDENT )
            // InternalAle.g:7962:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getIDENTTerminalRuleCall_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRQualifiedAccess().getIDENTTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RQualified__Group__0__Impl"


    // $ANTLR start "rule__RQualified__Group__1"
    // InternalAle.g:7971:1: rule__RQualified__Group__1 : rule__RQualified__Group__1__Impl ;
    public final void rule__RQualified__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7975:1: ( rule__RQualified__Group__1__Impl )
            // InternalAle.g:7976:2: rule__RQualified__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RQualified__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RQualified__Group__1"


    // $ANTLR start "rule__RQualified__Group__1__Impl"
    // InternalAle.g:7982:1: rule__RQualified__Group__1__Impl : ( ( rule__RQualified__Group_1__0 )* ) ;
    public final void rule__RQualified__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7986:1: ( ( ( rule__RQualified__Group_1__0 )* ) )
            // InternalAle.g:7987:1: ( ( rule__RQualified__Group_1__0 )* )
            {
            // InternalAle.g:7987:1: ( ( rule__RQualified__Group_1__0 )* )
            // InternalAle.g:7988:2: ( rule__RQualified__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getGroup_1()); 
            }
            // InternalAle.g:7989:2: ( rule__RQualified__Group_1__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==37) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalAle.g:7989:3: rule__RQualified__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__RQualified__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRQualifiedAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RQualified__Group__1__Impl"


    // $ANTLR start "rule__RQualified__Group_1__0"
    // InternalAle.g:7998:1: rule__RQualified__Group_1__0 : rule__RQualified__Group_1__0__Impl rule__RQualified__Group_1__1 ;
    public final void rule__RQualified__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8002:1: ( rule__RQualified__Group_1__0__Impl rule__RQualified__Group_1__1 )
            // InternalAle.g:8003:2: rule__RQualified__Group_1__0__Impl rule__RQualified__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__RQualified__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RQualified__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RQualified__Group_1__0"


    // $ANTLR start "rule__RQualified__Group_1__0__Impl"
    // InternalAle.g:8010:1: rule__RQualified__Group_1__0__Impl : ( '.' ) ;
    public final void rule__RQualified__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8014:1: ( ( '.' ) )
            // InternalAle.g:8015:1: ( '.' )
            {
            // InternalAle.g:8015:1: ( '.' )
            // InternalAle.g:8016:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getFullStopKeyword_1_0()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRQualifiedAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RQualified__Group_1__0__Impl"


    // $ANTLR start "rule__RQualified__Group_1__1"
    // InternalAle.g:8025:1: rule__RQualified__Group_1__1 : rule__RQualified__Group_1__1__Impl ;
    public final void rule__RQualified__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8029:1: ( rule__RQualified__Group_1__1__Impl )
            // InternalAle.g:8030:2: rule__RQualified__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RQualified__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RQualified__Group_1__1"


    // $ANTLR start "rule__RQualified__Group_1__1__Impl"
    // InternalAle.g:8036:1: rule__RQualified__Group_1__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RQualified__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8040:1: ( ( RULE_IDENT ) )
            // InternalAle.g:8041:1: ( RULE_IDENT )
            {
            // InternalAle.g:8041:1: ( RULE_IDENT )
            // InternalAle.g:8042:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getIDENTTerminalRuleCall_1_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRQualifiedAccess().getIDENTTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RQualified__Group_1__1__Impl"


    // $ANTLR start "rule__RRoot__XtendedClassesAssignment_5"
    // InternalAle.g:8052:1: rule__RRoot__XtendedClassesAssignment_5 : ( rulerClass ) ;
    public final void rule__RRoot__XtendedClassesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8056:1: ( ( rulerClass ) )
            // InternalAle.g:8057:2: ( rulerClass )
            {
            // InternalAle.g:8057:2: ( rulerClass )
            // InternalAle.g:8058:3: rulerClass
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getXtendedClassesRClassParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRRootAccess().getXtendedClassesRClassParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RRoot__XtendedClassesAssignment_5"


    // $ANTLR start "rule__RClass__OpenClassAssignment_0_1"
    // InternalAle.g:8067:1: rule__RClass__OpenClassAssignment_0_1 : ( rulerOpenClass ) ;
    public final void rule__RClass__OpenClassAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8071:1: ( ( rulerOpenClass ) )
            // InternalAle.g:8072:2: ( rulerOpenClass )
            {
            // InternalAle.g:8072:2: ( rulerOpenClass )
            // InternalAle.g:8073:3: rulerOpenClass
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getOpenClassROpenClassParserRuleCall_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerOpenClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRClassAccess().getOpenClassROpenClassParserRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__OpenClassAssignment_0_1"


    // $ANTLR start "rule__RClass__NewClassAssignment_1_1"
    // InternalAle.g:8082:1: rule__RClass__NewClassAssignment_1_1 : ( rulerNewClass ) ;
    public final void rule__RClass__NewClassAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8086:1: ( ( rulerNewClass ) )
            // InternalAle.g:8087:2: ( rulerNewClass )
            {
            // InternalAle.g:8087:2: ( rulerNewClass )
            // InternalAle.g:8088:3: rulerNewClass
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getNewClassRNewClassParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerNewClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRClassAccess().getNewClassRNewClassParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RClass__NewClassAssignment_1_1"


    // $ANTLR start "rule__ROpenClass__NameAssignment_2"
    // InternalAle.g:8097:1: rule__ROpenClass__NameAssignment_2 : ( rulerQualified ) ;
    public final void rule__ROpenClass__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8101:1: ( ( rulerQualified ) )
            // InternalAle.g:8102:2: ( rulerQualified )
            {
            // InternalAle.g:8102:2: ( rulerQualified )
            // InternalAle.g:8103:3: rulerQualified
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getNameRQualifiedParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerQualified();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getNameRQualifiedParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__NameAssignment_2"


    // $ANTLR start "rule__ROpenClass__AttributesAssignment_5"
    // InternalAle.g:8112:1: rule__ROpenClass__AttributesAssignment_5 : ( rulerAttribute ) ;
    public final void rule__ROpenClass__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8116:1: ( ( rulerAttribute ) )
            // InternalAle.g:8117:2: ( rulerAttribute )
            {
            // InternalAle.g:8117:2: ( rulerAttribute )
            // InternalAle.g:8118:3: rulerAttribute
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getAttributesRAttributeParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerAttribute();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getAttributesRAttributeParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__AttributesAssignment_5"


    // $ANTLR start "rule__ROpenClass__OperationsAssignment_6"
    // InternalAle.g:8127:1: rule__ROpenClass__OperationsAssignment_6 : ( rulerOperation ) ;
    public final void rule__ROpenClass__OperationsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8131:1: ( ( rulerOperation ) )
            // InternalAle.g:8132:2: ( rulerOperation )
            {
            // InternalAle.g:8132:2: ( rulerOperation )
            // InternalAle.g:8133:3: rulerOperation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getOperationsROperationParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROpenClassAccess().getOperationsROperationParserRuleCall_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROpenClass__OperationsAssignment_6"


    // $ANTLR start "rule__RNewClass__NameAssignment_1"
    // InternalAle.g:8142:1: rule__RNewClass__NameAssignment_1 : ( rulerQualified ) ;
    public final void rule__RNewClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8146:1: ( ( rulerQualified ) )
            // InternalAle.g:8147:2: ( rulerQualified )
            {
            // InternalAle.g:8147:2: ( rulerQualified )
            // InternalAle.g:8148:3: rulerQualified
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getNameRQualifiedParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerQualified();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getNameRQualifiedParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__NameAssignment_1"


    // $ANTLR start "rule__RNewClass__AttributesAssignment_3"
    // InternalAle.g:8157:1: rule__RNewClass__AttributesAssignment_3 : ( rulerAttribute ) ;
    public final void rule__RNewClass__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8161:1: ( ( rulerAttribute ) )
            // InternalAle.g:8162:2: ( rulerAttribute )
            {
            // InternalAle.g:8162:2: ( rulerAttribute )
            // InternalAle.g:8163:3: rulerAttribute
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getAttributesRAttributeParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerAttribute();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getAttributesRAttributeParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__AttributesAssignment_3"


    // $ANTLR start "rule__RNewClass__OperationsAssignment_4"
    // InternalAle.g:8172:1: rule__RNewClass__OperationsAssignment_4 : ( rulerOperation ) ;
    public final void rule__RNewClass__OperationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8176:1: ( ( rulerOperation ) )
            // InternalAle.g:8177:2: ( rulerOperation )
            {
            // InternalAle.g:8177:2: ( rulerOperation )
            // InternalAle.g:8178:3: rulerOperation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getOperationsROperationParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getOperationsROperationParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RNewClass__OperationsAssignment_4"


    // $ANTLR start "rule__ROperation__TypeAssignment_2"
    // InternalAle.g:8187:1: rule__ROperation__TypeAssignment_2 : ( rulerType ) ;
    public final void rule__ROperation__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8191:1: ( ( rulerType ) )
            // InternalAle.g:8192:2: ( rulerType )
            {
            // InternalAle.g:8192:2: ( rulerType )
            // InternalAle.g:8193:3: rulerType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getTypeRTypeParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getTypeRTypeParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__TypeAssignment_2"


    // $ANTLR start "rule__ROperation__NameAssignment_3"
    // InternalAle.g:8202:1: rule__ROperation__NameAssignment_3 : ( RULE_IDENT ) ;
    public final void rule__ROperation__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8206:1: ( ( RULE_IDENT ) )
            // InternalAle.g:8207:2: ( RULE_IDENT )
            {
            // InternalAle.g:8207:2: ( RULE_IDENT )
            // InternalAle.g:8208:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getNameIDENTTerminalRuleCall_3_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getNameIDENTTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__NameAssignment_3"


    // $ANTLR start "rule__ROperation__ParamListAssignment_5"
    // InternalAle.g:8217:1: rule__ROperation__ParamListAssignment_5 : ( rulerParameters ) ;
    public final void rule__ROperation__ParamListAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8221:1: ( ( rulerParameters ) )
            // InternalAle.g:8222:2: ( rulerParameters )
            {
            // InternalAle.g:8222:2: ( rulerParameters )
            // InternalAle.g:8223:3: rulerParameters
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getParamListRParametersParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerParameters();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getParamListRParametersParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__ParamListAssignment_5"


    // $ANTLR start "rule__ROperation__BodyAssignment_7"
    // InternalAle.g:8232:1: rule__ROperation__BodyAssignment_7 : ( rulerBlock ) ;
    public final void rule__ROperation__BodyAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8236:1: ( ( rulerBlock ) )
            // InternalAle.g:8237:2: ( rulerBlock )
            {
            // InternalAle.g:8237:2: ( rulerBlock )
            // InternalAle.g:8238:3: rulerBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getBodyRBlockParserRuleCall_7_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getBodyRBlockParserRuleCall_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ROperation__BodyAssignment_7"


    // $ANTLR start "rule__RParameters__ParamsAssignment_0"
    // InternalAle.g:8247:1: rule__RParameters__ParamsAssignment_0 : ( rulerVariable ) ;
    public final void rule__RParameters__ParamsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8251:1: ( ( rulerVariable ) )
            // InternalAle.g:8252:2: ( rulerVariable )
            {
            // InternalAle.g:8252:2: ( rulerVariable )
            // InternalAle.g:8253:3: rulerVariable
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__ParamsAssignment_0"


    // $ANTLR start "rule__RParameters__ParamsAssignment_1_1"
    // InternalAle.g:8262:1: rule__RParameters__ParamsAssignment_1_1 : ( rulerVariable ) ;
    public final void rule__RParameters__ParamsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8266:1: ( ( rulerVariable ) )
            // InternalAle.g:8267:2: ( rulerVariable )
            {
            // InternalAle.g:8267:2: ( rulerVariable )
            // InternalAle.g:8268:3: rulerVariable
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRParametersAccess().getParamsRVariableParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RParameters__ParamsAssignment_1_1"


    // $ANTLR start "rule__RVariable__TypeAssignment_0"
    // InternalAle.g:8277:1: rule__RVariable__TypeAssignment_0 : ( rulerType ) ;
    public final void rule__RVariable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8281:1: ( ( rulerType ) )
            // InternalAle.g:8282:2: ( rulerType )
            {
            // InternalAle.g:8282:2: ( rulerType )
            // InternalAle.g:8283:3: rulerType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getTypeRTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVariableAccess().getTypeRTypeParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVariable__TypeAssignment_0"


    // $ANTLR start "rule__RVariable__NameAssignment_1"
    // InternalAle.g:8292:1: rule__RVariable__NameAssignment_1 : ( RULE_IDENT ) ;
    public final void rule__RVariable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8296:1: ( ( RULE_IDENT ) )
            // InternalAle.g:8297:2: ( RULE_IDENT )
            {
            // InternalAle.g:8297:2: ( RULE_IDENT )
            // InternalAle.g:8298:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getNameIDENTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVariableAccess().getNameIDENTTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVariable__NameAssignment_1"


    // $ANTLR start "rule__RAttribute__TypeAssignment_0"
    // InternalAle.g:8307:1: rule__RAttribute__TypeAssignment_0 : ( rulerType ) ;
    public final void rule__RAttribute__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8311:1: ( ( rulerType ) )
            // InternalAle.g:8312:2: ( rulerType )
            {
            // InternalAle.g:8312:2: ( rulerType )
            // InternalAle.g:8313:3: rulerType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getTypeRTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getTypeRTypeParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__TypeAssignment_0"


    // $ANTLR start "rule__RAttribute__NameAssignment_1"
    // InternalAle.g:8322:1: rule__RAttribute__NameAssignment_1 : ( RULE_IDENT ) ;
    public final void rule__RAttribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8326:1: ( ( RULE_IDENT ) )
            // InternalAle.g:8327:2: ( RULE_IDENT )
            {
            // InternalAle.g:8327:2: ( RULE_IDENT )
            // InternalAle.g:8328:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getNameIDENTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getNameIDENTTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__NameAssignment_1"


    // $ANTLR start "rule__RAttribute__ExprAssignment_2_1"
    // InternalAle.g:8337:1: rule__RAttribute__ExprAssignment_2_1 : ( ruleexpression ) ;
    public final void rule__RAttribute__ExprAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8341:1: ( ( ruleexpression ) )
            // InternalAle.g:8342:2: ( ruleexpression )
            {
            // InternalAle.g:8342:2: ( ruleexpression )
            // InternalAle.g:8343:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getExprExpressionParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getExprExpressionParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAttribute__ExprAssignment_2_1"


    // $ANTLR start "rule__RStatement__StmtAssignment_0_1"
    // InternalAle.g:8352:1: rule__RStatement__StmtAssignment_0_1 : ( rulerVarDecl ) ;
    public final void rule__RStatement__StmtAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8356:1: ( ( rulerVarDecl ) )
            // InternalAle.g:8357:2: ( rulerVarDecl )
            {
            // InternalAle.g:8357:2: ( rulerVarDecl )
            // InternalAle.g:8358:3: rulerVarDecl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getStmtRVarDeclParserRuleCall_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerVarDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getStmtRVarDeclParserRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__StmtAssignment_0_1"


    // $ANTLR start "rule__RStatement__StmtAssignment_1_1"
    // InternalAle.g:8367:1: rule__RStatement__StmtAssignment_1_1 : ( rulerAssign ) ;
    public final void rule__RStatement__StmtAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8371:1: ( ( rulerAssign ) )
            // InternalAle.g:8372:2: ( rulerAssign )
            {
            // InternalAle.g:8372:2: ( rulerAssign )
            // InternalAle.g:8373:3: rulerAssign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getStmtRAssignParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerAssign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getStmtRAssignParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__StmtAssignment_1_1"


    // $ANTLR start "rule__RStatement__ForEachAssignment_2_1"
    // InternalAle.g:8382:1: rule__RStatement__ForEachAssignment_2_1 : ( rulerForEach ) ;
    public final void rule__RStatement__ForEachAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8386:1: ( ( rulerForEach ) )
            // InternalAle.g:8387:2: ( rulerForEach )
            {
            // InternalAle.g:8387:2: ( rulerForEach )
            // InternalAle.g:8388:3: rulerForEach
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getForEachRForEachParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerForEach();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getForEachRForEachParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__ForEachAssignment_2_1"


    // $ANTLR start "rule__RStatement__WhileAssignment_3_1"
    // InternalAle.g:8397:1: rule__RStatement__WhileAssignment_3_1 : ( rulerWhile ) ;
    public final void rule__RStatement__WhileAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8401:1: ( ( rulerWhile ) )
            // InternalAle.g:8402:2: ( rulerWhile )
            {
            // InternalAle.g:8402:2: ( rulerWhile )
            // InternalAle.g:8403:3: rulerWhile
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getWhileRWhileParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerWhile();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getWhileRWhileParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__WhileAssignment_3_1"


    // $ANTLR start "rule__RStatement__IfAssignment_4_1"
    // InternalAle.g:8412:1: rule__RStatement__IfAssignment_4_1 : ( rulerIf ) ;
    public final void rule__RStatement__IfAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8416:1: ( ( rulerIf ) )
            // InternalAle.g:8417:2: ( rulerIf )
            {
            // InternalAle.g:8417:2: ( rulerIf )
            // InternalAle.g:8418:3: rulerIf
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getIfRIfParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerIf();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getIfRIfParserRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__IfAssignment_4_1"


    // $ANTLR start "rule__RStatement__ExprAssignment_5_1"
    // InternalAle.g:8427:1: rule__RStatement__ExprAssignment_5_1 : ( rulerExpression ) ;
    public final void rule__RStatement__ExprAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8431:1: ( ( rulerExpression ) )
            // InternalAle.g:8432:2: ( rulerExpression )
            {
            // InternalAle.g:8432:2: ( rulerExpression )
            // InternalAle.g:8433:3: rulerExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getExprRExpressionParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRStatementAccess().getExprRExpressionParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RStatement__ExprAssignment_5_1"


    // $ANTLR start "rule__RVarDecl__TypeAssignment_0"
    // InternalAle.g:8442:1: rule__RVarDecl__TypeAssignment_0 : ( rulerType ) ;
    public final void rule__RVarDecl__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8446:1: ( ( rulerType ) )
            // InternalAle.g:8447:2: ( rulerType )
            {
            // InternalAle.g:8447:2: ( rulerType )
            // InternalAle.g:8448:3: rulerType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getTypeRTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getTypeRTypeParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__TypeAssignment_0"


    // $ANTLR start "rule__RVarDecl__IdentAssignment_1"
    // InternalAle.g:8457:1: rule__RVarDecl__IdentAssignment_1 : ( RULE_IDENT ) ;
    public final void rule__RVarDecl__IdentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8461:1: ( ( RULE_IDENT ) )
            // InternalAle.g:8462:2: ( RULE_IDENT )
            {
            // InternalAle.g:8462:2: ( RULE_IDENT )
            // InternalAle.g:8463:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getIdentIDENTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getIdentIDENTTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__IdentAssignment_1"


    // $ANTLR start "rule__RVarDecl__ExpressionAssignment_2_1"
    // InternalAle.g:8472:1: rule__RVarDecl__ExpressionAssignment_2_1 : ( ruleexpression ) ;
    public final void rule__RVarDecl__ExpressionAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8476:1: ( ( ruleexpression ) )
            // InternalAle.g:8477:2: ( ruleexpression )
            {
            // InternalAle.g:8477:2: ( ruleexpression )
            // InternalAle.g:8478:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getExpressionExpressionParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getExpressionExpressionParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RVarDecl__ExpressionAssignment_2_1"


    // $ANTLR start "rule__RAssign__LeftAssignment_0"
    // InternalAle.g:8487:1: rule__RAssign__LeftAssignment_0 : ( ruleexpression ) ;
    public final void rule__RAssign__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8491:1: ( ( ruleexpression ) )
            // InternalAle.g:8492:2: ( ruleexpression )
            {
            // InternalAle.g:8492:2: ( ruleexpression )
            // InternalAle.g:8493:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getLeftExpressionParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignAccess().getLeftExpressionParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__LeftAssignment_0"


    // $ANTLR start "rule__RAssign__RightAssignment_2"
    // InternalAle.g:8502:1: rule__RAssign__RightAssignment_2 : ( ruleexpression ) ;
    public final void rule__RAssign__RightAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8506:1: ( ( ruleexpression ) )
            // InternalAle.g:8507:2: ( ruleexpression )
            {
            // InternalAle.g:8507:2: ( ruleexpression )
            // InternalAle.g:8508:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getRightExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignAccess().getRightExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RAssign__RightAssignment_2"


    // $ANTLR start "rule__RForEach__BlockAssignment_6"
    // InternalAle.g:8517:1: rule__RForEach__BlockAssignment_6 : ( rulerBlock ) ;
    public final void rule__RForEach__BlockAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8521:1: ( ( rulerBlock ) )
            // InternalAle.g:8522:2: ( rulerBlock )
            {
            // InternalAle.g:8522:2: ( rulerBlock )
            // InternalAle.g:8523:3: rulerBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getBlockRBlockParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getBlockRBlockParserRuleCall_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RForEach__BlockAssignment_6"


    // $ANTLR start "rule__RBlock__StatementAssignment_1_0"
    // InternalAle.g:8532:1: rule__RBlock__StatementAssignment_1_0 : ( rulerStatement ) ;
    public final void rule__RBlock__StatementAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8536:1: ( ( rulerStatement ) )
            // InternalAle.g:8537:2: ( rulerStatement )
            {
            // InternalAle.g:8537:2: ( rulerStatement )
            // InternalAle.g:8538:3: rulerStatement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getStatementRStatementParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getStatementRStatementParserRuleCall_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__StatementAssignment_1_0"


    // $ANTLR start "rule__RBlock__StatementAssignment_1_1"
    // InternalAle.g:8547:1: rule__RBlock__StatementAssignment_1_1 : ( rulerStatement ) ;
    public final void rule__RBlock__StatementAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8551:1: ( ( rulerStatement ) )
            // InternalAle.g:8552:2: ( rulerStatement )
            {
            // InternalAle.g:8552:2: ( rulerStatement )
            // InternalAle.g:8553:3: rulerStatement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getStatementRStatementParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getStatementRStatementParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RBlock__StatementAssignment_1_1"


    // $ANTLR start "rule__RIf__ConditionAssignment_2"
    // InternalAle.g:8562:1: rule__RIf__ConditionAssignment_2 : ( ruleexpression ) ;
    public final void rule__RIf__ConditionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8566:1: ( ( ruleexpression ) )
            // InternalAle.g:8567:2: ( ruleexpression )
            {
            // InternalAle.g:8567:2: ( ruleexpression )
            // InternalAle.g:8568:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getConditionExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getConditionExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__ConditionAssignment_2"


    // $ANTLR start "rule__RIf__IfBlockAssignment_4"
    // InternalAle.g:8577:1: rule__RIf__IfBlockAssignment_4 : ( rulerBlock ) ;
    public final void rule__RIf__IfBlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8581:1: ( ( rulerBlock ) )
            // InternalAle.g:8582:2: ( rulerBlock )
            {
            // InternalAle.g:8582:2: ( rulerBlock )
            // InternalAle.g:8583:3: rulerBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getIfBlockRBlockParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getIfBlockRBlockParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__IfBlockAssignment_4"


    // $ANTLR start "rule__RIf__ElseBlockAssignment_5_1"
    // InternalAle.g:8592:1: rule__RIf__ElseBlockAssignment_5_1 : ( rulerBlock ) ;
    public final void rule__RIf__ElseBlockAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8596:1: ( ( rulerBlock ) )
            // InternalAle.g:8597:2: ( rulerBlock )
            {
            // InternalAle.g:8597:2: ( rulerBlock )
            // InternalAle.g:8598:3: rulerBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getElseBlockRBlockParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getElseBlockRBlockParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RIf__ElseBlockAssignment_5_1"


    // $ANTLR start "rule__RWhile__BlockAssignment_4"
    // InternalAle.g:8607:1: rule__RWhile__BlockAssignment_4 : ( rulerBlock ) ;
    public final void rule__RWhile__BlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8611:1: ( ( rulerBlock ) )
            // InternalAle.g:8612:2: ( rulerBlock )
            {
            // InternalAle.g:8612:2: ( rulerBlock )
            // InternalAle.g:8613:3: rulerBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getBlockRBlockParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRWhileAccess().getBlockRBlockParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RWhile__BlockAssignment_4"


    // $ANTLR start "rule__Expression__LeftPartAssignment_0"
    // InternalAle.g:8622:1: rule__Expression__LeftPartAssignment_0 : ( rulenonLeftRecExpression ) ;
    public final void rule__Expression__LeftPartAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8626:1: ( ( rulenonLeftRecExpression ) )
            // InternalAle.g:8627:2: ( rulenonLeftRecExpression )
            {
            // InternalAle.g:8627:2: ( rulenonLeftRecExpression )
            // InternalAle.g:8628:3: rulenonLeftRecExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getLeftPartNonLeftRecExpressionParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulenonLeftRecExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getLeftPartNonLeftRecExpressionParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__LeftPartAssignment_0"


    // $ANTLR start "rule__Expression__RecpartAssignment_1"
    // InternalAle.g:8637:1: rule__Expression__RecpartAssignment_1 : ( rulerecExpression ) ;
    public final void rule__Expression__RecpartAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8641:1: ( ( rulerecExpression ) )
            // InternalAle.g:8642:2: ( rulerecExpression )
            {
            // InternalAle.g:8642:2: ( rulerecExpression )
            // InternalAle.g:8643:3: rulerecExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getRecpartRecExpressionParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerecExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getRecpartRecExpressionParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__RecpartAssignment_1"


    // $ANTLR start "rule__RecExpression__RecExpAssignment_1"
    // InternalAle.g:8652:1: rule__RecExpression__RecExpAssignment_1 : ( rulerecExpression ) ;
    public final void rule__RecExpression__RecExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8656:1: ( ( rulerecExpression ) )
            // InternalAle.g:8657:2: ( rulerecExpression )
            {
            // InternalAle.g:8657:2: ( rulerecExpression )
            // InternalAle.g:8658:3: rulerecExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getRecExpRecExpressionParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerecExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getRecExpRecExpressionParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecExpression__RecExpAssignment_1"


    // $ANTLR start "rule__NavigationSegment__IdentAssignment_0_2"
    // InternalAle.g:8667:1: rule__NavigationSegment__IdentAssignment_0_2 : ( RULE_IDENT ) ;
    public final void rule__NavigationSegment__IdentAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8671:1: ( ( RULE_IDENT ) )
            // InternalAle.g:8672:2: ( RULE_IDENT )
            {
            // InternalAle.g:8672:2: ( RULE_IDENT )
            // InternalAle.g:8673:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getIdentIDENTTerminalRuleCall_0_2_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getIdentIDENTTerminalRuleCall_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__IdentAssignment_0_2"


    // $ANTLR start "rule__NavigationSegment__CallAssignment_1_2"
    // InternalAle.g:8682:1: rule__NavigationSegment__CallAssignment_1_2 : ( rulecallExp ) ;
    public final void rule__NavigationSegment__CallAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8686:1: ( ( rulecallExp ) )
            // InternalAle.g:8687:2: ( rulecallExp )
            {
            // InternalAle.g:8687:2: ( rulecallExp )
            // InternalAle.g:8688:3: rulecallExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getCallCallExpParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulecallExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getCallCallExpParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__CallAssignment_1_2"


    // $ANTLR start "rule__NavigationSegment__CallAssignment_2_2"
    // InternalAle.g:8697:1: rule__NavigationSegment__CallAssignment_2_2 : ( rulecallExp ) ;
    public final void rule__NavigationSegment__CallAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8701:1: ( ( rulecallExp ) )
            // InternalAle.g:8702:2: ( rulecallExp )
            {
            // InternalAle.g:8702:2: ( rulecallExp )
            // InternalAle.g:8703:3: rulecallExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getCallCallExpParserRuleCall_2_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulecallExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getCallCallExpParserRuleCall_2_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__CallAssignment_2_2"


    // $ANTLR start "rule__NonLeftRecExpression__ExpressionAssignment_0_2"
    // InternalAle.g:8712:1: rule__NonLeftRecExpression__ExpressionAssignment_0_2 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__ExpressionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8716:1: ( ( ruleexpression ) )
            // InternalAle.g:8717:2: ( ruleexpression )
            {
            // InternalAle.g:8717:2: ( ruleexpression )
            // InternalAle.g:8718:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionExpressionParserRuleCall_0_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionExpressionParserRuleCall_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__ExpressionAssignment_0_2"


    // $ANTLR start "rule__NonLeftRecExpression__ExpressionAssignment_1_2"
    // InternalAle.g:8727:1: rule__NonLeftRecExpression__ExpressionAssignment_1_2 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8731:1: ( ( ruleexpression ) )
            // InternalAle.g:8732:2: ( ruleexpression )
            {
            // InternalAle.g:8732:2: ( ruleexpression )
            // InternalAle.g:8733:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionExpressionParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__ExpressionAssignment_1_2"


    // $ANTLR start "rule__NonLeftRecExpression__ValueAssignment_2_1"
    // InternalAle.g:8742:1: rule__NonLeftRecExpression__ValueAssignment_2_1 : ( RULE_IDENT ) ;
    public final void rule__NonLeftRecExpression__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8746:1: ( ( RULE_IDENT ) )
            // InternalAle.g:8747:2: ( RULE_IDENT )
            {
            // InternalAle.g:8747:2: ( RULE_IDENT )
            // InternalAle.g:8748:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getValueIDENTTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getValueIDENTTerminalRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__ValueAssignment_2_1"


    // $ANTLR start "rule__NonLeftRecExpression__LitAssignment_3_1"
    // InternalAle.g:8757:1: rule__NonLeftRecExpression__LitAssignment_3_1 : ( ruleliteral ) ;
    public final void rule__NonLeftRecExpression__LitAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8761:1: ( ( ruleliteral ) )
            // InternalAle.g:8762:2: ( ruleliteral )
            {
            // InternalAle.g:8762:2: ( ruleliteral )
            // InternalAle.g:8763:3: ruleliteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLitLiteralParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleliteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLitLiteralParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__LitAssignment_3_1"


    // $ANTLR start "rule__NonLeftRecExpression__ExpressionAssignment_4_2"
    // InternalAle.g:8772:1: rule__NonLeftRecExpression__ExpressionAssignment_4_2 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__ExpressionAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8776:1: ( ( ruleexpression ) )
            // InternalAle.g:8777:2: ( ruleexpression )
            {
            // InternalAle.g:8777:2: ( ruleexpression )
            // InternalAle.g:8778:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionExpressionParserRuleCall_4_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionExpressionParserRuleCall_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__ExpressionAssignment_4_2"


    // $ANTLR start "rule__NonLeftRecExpression__ConditionAssignment_5_2"
    // InternalAle.g:8787:1: rule__NonLeftRecExpression__ConditionAssignment_5_2 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__ConditionAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8791:1: ( ( ruleexpression ) )
            // InternalAle.g:8792:2: ( ruleexpression )
            {
            // InternalAle.g:8792:2: ( ruleexpression )
            // InternalAle.g:8793:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getConditionExpressionParserRuleCall_5_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getConditionExpressionParserRuleCall_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__ConditionAssignment_5_2"


    // $ANTLR start "rule__NonLeftRecExpression__IfBlockAssignment_5_4"
    // InternalAle.g:8802:1: rule__NonLeftRecExpression__IfBlockAssignment_5_4 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__IfBlockAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8806:1: ( ( ruleexpression ) )
            // InternalAle.g:8807:2: ( ruleexpression )
            {
            // InternalAle.g:8807:2: ( ruleexpression )
            // InternalAle.g:8808:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getIfBlockExpressionParserRuleCall_5_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getIfBlockExpressionParserRuleCall_5_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__IfBlockAssignment_5_4"


    // $ANTLR start "rule__NonLeftRecExpression__ElseBlockAssignment_5_6"
    // InternalAle.g:8817:1: rule__NonLeftRecExpression__ElseBlockAssignment_5_6 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__ElseBlockAssignment_5_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8821:1: ( ( ruleexpression ) )
            // InternalAle.g:8822:2: ( ruleexpression )
            {
            // InternalAle.g:8822:2: ( ruleexpression )
            // InternalAle.g:8823:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getElseBlockExpressionParserRuleCall_5_6_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getElseBlockExpressionParserRuleCall_5_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__ElseBlockAssignment_5_6"


    // $ANTLR start "rule__NonLeftRecExpression__BindingsAssignment_6_2"
    // InternalAle.g:8832:1: rule__NonLeftRecExpression__BindingsAssignment_6_2 : ( rulebinding ) ;
    public final void rule__NonLeftRecExpression__BindingsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8836:1: ( ( rulebinding ) )
            // InternalAle.g:8837:2: ( rulebinding )
            {
            // InternalAle.g:8837:2: ( rulebinding )
            // InternalAle.g:8838:3: rulebinding
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulebinding();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__BindingsAssignment_6_2"


    // $ANTLR start "rule__NonLeftRecExpression__BindingsAssignment_6_3_1"
    // InternalAle.g:8847:1: rule__NonLeftRecExpression__BindingsAssignment_6_3_1 : ( rulebinding ) ;
    public final void rule__NonLeftRecExpression__BindingsAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8851:1: ( ( rulebinding ) )
            // InternalAle.g:8852:2: ( rulebinding )
            {
            // InternalAle.g:8852:2: ( rulebinding )
            // InternalAle.g:8853:3: rulebinding
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulebinding();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__BindingsAssignment_6_3_1"


    // $ANTLR start "rule__NonLeftRecExpression__LetExprAssignment_6_5"
    // InternalAle.g:8862:1: rule__NonLeftRecExpression__LetExprAssignment_6_5 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__LetExprAssignment_6_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8866:1: ( ( ruleexpression ) )
            // InternalAle.g:8867:2: ( ruleexpression )
            {
            // InternalAle.g:8867:2: ( ruleexpression )
            // InternalAle.g:8868:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLetExprExpressionParserRuleCall_6_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLetExprExpressionParserRuleCall_6_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__LetExprAssignment_6_5"


    // $ANTLR start "rule__Binding__IdentifierAssignment_0"
    // InternalAle.g:8877:1: rule__Binding__IdentifierAssignment_0 : ( RULE_IDENT ) ;
    public final void rule__Binding__IdentifierAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8881:1: ( ( RULE_IDENT ) )
            // InternalAle.g:8882:2: ( RULE_IDENT )
            {
            // InternalAle.g:8882:2: ( RULE_IDENT )
            // InternalAle.g:8883:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getIdentifierIDENTTerminalRuleCall_0_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getIdentifierIDENTTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__IdentifierAssignment_0"


    // $ANTLR start "rule__Binding__TypeAssignment_1_1"
    // InternalAle.g:8892:1: rule__Binding__TypeAssignment_1_1 : ( ruletypeLiteral ) ;
    public final void rule__Binding__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8896:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:8897:2: ( ruletypeLiteral )
            {
            // InternalAle.g:8897:2: ( ruletypeLiteral )
            // InternalAle.g:8898:3: ruletypeLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getTypeTypeLiteralParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruletypeLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getTypeTypeLiteralParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__TypeAssignment_1_1"


    // $ANTLR start "rule__Binding__ExpressionAssignment_3"
    // InternalAle.g:8907:1: rule__Binding__ExpressionAssignment_3 : ( ruleexpression ) ;
    public final void rule__Binding__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8911:1: ( ( ruleexpression ) )
            // InternalAle.g:8912:2: ( ruleexpression )
            {
            // InternalAle.g:8912:2: ( ruleexpression )
            // InternalAle.g:8913:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getExpressionExpressionParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getExpressionExpressionParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__ExpressionAssignment_3"


    // $ANTLR start "rule__CallExp__ExpressionAssignment_0_3"
    // InternalAle.g:8922:1: rule__CallExp__ExpressionAssignment_0_3 : ( ruleexpression ) ;
    public final void rule__CallExp__ExpressionAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8926:1: ( ( ruleexpression ) )
            // InternalAle.g:8927:2: ( ruleexpression )
            {
            // InternalAle.g:8927:2: ( ruleexpression )
            // InternalAle.g:8928:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getExpressionExpressionParserRuleCall_0_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getExpressionExpressionParserRuleCall_0_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExp__ExpressionAssignment_0_3"


    // $ANTLR start "rule__ExpressionSequence__SeqExprsAssignment_0"
    // InternalAle.g:8937:1: rule__ExpressionSequence__SeqExprsAssignment_0 : ( ruleexpression ) ;
    public final void rule__ExpressionSequence__SeqExprsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8941:1: ( ( ruleexpression ) )
            // InternalAle.g:8942:2: ( ruleexpression )
            {
            // InternalAle.g:8942:2: ( ruleexpression )
            // InternalAle.g:8943:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getSeqExprsExpressionParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceAccess().getSeqExprsExpressionParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__SeqExprsAssignment_0"


    // $ANTLR start "rule__ExpressionSequence__SeqExprsAssignment_1_1"
    // InternalAle.g:8952:1: rule__ExpressionSequence__SeqExprsAssignment_1_1 : ( ruleexpression ) ;
    public final void rule__ExpressionSequence__SeqExprsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8956:1: ( ( ruleexpression ) )
            // InternalAle.g:8957:2: ( ruleexpression )
            {
            // InternalAle.g:8957:2: ( ruleexpression )
            // InternalAle.g:8958:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getSeqExprsExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceAccess().getSeqExprsExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionSequence__SeqExprsAssignment_1_1"


    // $ANTLR start "rule__TypeLiteral__SubTypeAssignment_4_2"
    // InternalAle.g:8967:1: rule__TypeLiteral__SubTypeAssignment_4_2 : ( ruletypeLiteral ) ;
    public final void rule__TypeLiteral__SubTypeAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8971:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:8972:2: ( ruletypeLiteral )
            {
            // InternalAle.g:8972:2: ( ruletypeLiteral )
            // InternalAle.g:8973:3: ruletypeLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getSubTypeTypeLiteralParserRuleCall_4_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruletypeLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getSubTypeTypeLiteralParserRuleCall_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__SubTypeAssignment_4_2"


    // $ANTLR start "rule__TypeLiteral__SubTypeAssignment_5_2"
    // InternalAle.g:8982:1: rule__TypeLiteral__SubTypeAssignment_5_2 : ( ruletypeLiteral ) ;
    public final void rule__TypeLiteral__SubTypeAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8986:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:8987:2: ( ruletypeLiteral )
            {
            // InternalAle.g:8987:2: ( ruletypeLiteral )
            // InternalAle.g:8988:3: ruletypeLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getSubTypeTypeLiteralParserRuleCall_5_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruletypeLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getSubTypeTypeLiteralParserRuleCall_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__SubTypeAssignment_5_2"

    // $ANTLR start synpred4_InternalAle
    public final void synpred4_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:950:2: ( ( ( rule__RStatement__Group_0__0 ) ) )
        // InternalAle.g:950:2: ( ( rule__RStatement__Group_0__0 ) )
        {
        // InternalAle.g:950:2: ( ( rule__RStatement__Group_0__0 ) )
        // InternalAle.g:951:3: ( rule__RStatement__Group_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRStatementAccess().getGroup_0()); 
        }
        // InternalAle.g:952:3: ( rule__RStatement__Group_0__0 )
        // InternalAle.g:952:4: rule__RStatement__Group_0__0
        {
        pushFollow(FOLLOW_2);
        rule__RStatement__Group_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred4_InternalAle

    // $ANTLR start synpred5_InternalAle
    public final void synpred5_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:956:2: ( ( ( rule__RStatement__Group_1__0 ) ) )
        // InternalAle.g:956:2: ( ( rule__RStatement__Group_1__0 ) )
        {
        // InternalAle.g:956:2: ( ( rule__RStatement__Group_1__0 ) )
        // InternalAle.g:957:3: ( rule__RStatement__Group_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRStatementAccess().getGroup_1()); 
        }
        // InternalAle.g:958:3: ( rule__RStatement__Group_1__0 )
        // InternalAle.g:958:4: rule__RStatement__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__RStatement__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5_InternalAle

    // $ANTLR start synpred8_InternalAle
    public final void synpred8_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:974:2: ( ( ( rule__RStatement__Group_4__0 ) ) )
        // InternalAle.g:974:2: ( ( rule__RStatement__Group_4__0 ) )
        {
        // InternalAle.g:974:2: ( ( rule__RStatement__Group_4__0 ) )
        // InternalAle.g:975:3: ( rule__RStatement__Group_4__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRStatementAccess().getGroup_4()); 
        }
        // InternalAle.g:976:3: ( rule__RStatement__Group_4__0 )
        // InternalAle.g:976:4: rule__RStatement__Group_4__0
        {
        pushFollow(FOLLOW_2);
        rule__RStatement__Group_4__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred8_InternalAle

    // $ANTLR start synpred72_InternalAle
    public final void synpred72_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:4587:3: ( rule__Expression__RecpartAssignment_1 )
        // InternalAle.g:4587:3: rule__Expression__RecpartAssignment_1
        {
        pushFollow(FOLLOW_2);
        rule__Expression__RecpartAssignment_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred72_InternalAle

    // $ANTLR start synpred73_InternalAle
    public final void synpred73_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:4641:3: ( rule__RecExpression__RecExpAssignment_1 )
        // InternalAle.g:4641:3: rule__RecExpression__RecExpAssignment_1
        {
        pushFollow(FOLLOW_2);
        rule__RecExpression__RecExpAssignment_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred73_InternalAle

    // Delegated rules

    public final boolean synpred8_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred73_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred73_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalAle_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA34 dfa34 = new DFA34(this);
    static final String dfa_1s = "\34\uffff";
    static final String dfa_2s = "\1\4\25\0\6\uffff";
    static final String dfa_3s = "\1\115\25\0\6\uffff";
    static final String dfa_4s = "\26\uffff\1\3\1\4\1\1\1\2\1\6\1\5";
    static final String dfa_5s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\13\1\14\1\15\1\1\25\uffff\1\16\1\17\1\20\10\uffff\1\10\3\uffff\1\23\3\uffff\1\26\4\uffff\1\24\1\uffff\1\27\5\uffff\1\11\1\12\2\uffff\1\25\3\uffff\1\21\1\22\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7",
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

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "945:1: rule__RStatement__Alternatives : ( ( ( rule__RStatement__Group_0__0 ) ) | ( ( rule__RStatement__Group_1__0 ) ) | ( ( rule__RStatement__Group_2__0 ) ) | ( ( rule__RStatement__Group_3__0 ) ) | ( ( rule__RStatement__Group_4__0 ) ) | ( ( rule__RStatement__Group_5__0 ) ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_1 = input.LA(1);

                         
                        int index4_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalAle()) ) {s = 24;}

                        else if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_2 = input.LA(1);

                         
                        int index4_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalAle()) ) {s = 24;}

                        else if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalAle()) ) {s = 24;}

                        else if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_4 = input.LA(1);

                         
                        int index4_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalAle()) ) {s = 24;}

                        else if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalAle()) ) {s = 24;}

                        else if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_6 = input.LA(1);

                         
                        int index4_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalAle()) ) {s = 24;}

                        else if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalAle()) ) {s = 24;}

                        else if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_8 = input.LA(1);

                         
                        int index4_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalAle()) ) {s = 24;}

                        else if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_9 = input.LA(1);

                         
                        int index4_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA4_10 = input.LA(1);

                         
                        int index4_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA4_11 = input.LA(1);

                         
                        int index4_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA4_12 = input.LA(1);

                         
                        int index4_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA4_13 = input.LA(1);

                         
                        int index4_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA4_14 = input.LA(1);

                         
                        int index4_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA4_15 = input.LA(1);

                         
                        int index4_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA4_16 = input.LA(1);

                         
                        int index4_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA4_17 = input.LA(1);

                         
                        int index4_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA4_18 = input.LA(1);

                         
                        int index4_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA4_19 = input.LA(1);

                         
                        int index4_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA4_20 = input.LA(1);

                         
                        int index4_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (synpred8_InternalAle()) ) {s = 27;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA4_21 = input.LA(1);

                         
                        int index4_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_InternalAle()) ) {s = 25;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index4_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\17\uffff";
    static final String dfa_8s = "\14\uffff\1\12\2\uffff";
    static final String dfa_9s = "\1\4\10\uffff\1\103\1\uffff\1\7\1\10\2\uffff";
    static final String dfa_10s = "\1\115\10\uffff\1\107\1\uffff\1\7\1\107\2\uffff";
    static final String dfa_11s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\2\uffff\1\11\1\12";
    static final String dfa_12s = "\17\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\1\2\1\3\1\11\25\uffff\1\4\1\5\1\6\10\uffff\1\12\34\uffff\1\7\1\10\1\uffff\6\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\3\uffff\1\13",
            "",
            "\1\14",
            "\3\12\26\uffff\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\1\uffff\1\12\1\uffff\1\12\1\uffff\1\12\4\uffff\1\12\1\uffff\5\12\2\uffff\2\12\2\uffff\1\16\3\uffff\1\15",
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

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1236:1: rule__Literal__Alternatives : ( ( RULE_STRING ) | ( RULE_INT ) | ( RULE_REAL ) | ( 'true' ) | ( 'false' ) | ( 'null' ) | ( ( rule__Literal__Group_6__0 ) ) | ( ( rule__Literal__Group_7__0 ) ) | ( ( rule__Literal__Group_8__0 ) ) | ( ( rule__Literal__Group_9__0 ) ) | ( ruletypeLiteral ) );";
        }
    }
    static final String dfa_14s = "\14\uffff";
    static final String dfa_15s = "\1\12\13\uffff";
    static final String dfa_16s = "\1\10\11\0\2\uffff";
    static final String dfa_17s = "\1\100\11\0\2\uffff";
    static final String dfa_18s = "\12\uffff\1\2\1\1";
    static final String dfa_19s = "\1\uffff\1\10\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff}>";
    static final String[] dfa_20s = {
            "\1\3\1\4\1\5\26\uffff\1\12\3\uffff\1\1\3\uffff\1\12\1\uffff\1\12\1\uffff\1\12\1\uffff\1\12\1\uffff\1\12\4\uffff\1\12\1\uffff\1\6\1\7\1\10\1\11\1\2\2\uffff\2\12",
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

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "4587:2: ( rule__Expression__RecpartAssignment_1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_2 = input.LA(1);

                         
                        int index33_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index33_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_3 = input.LA(1);

                         
                        int index33_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index33_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA33_4 = input.LA(1);

                         
                        int index33_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index33_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA33_5 = input.LA(1);

                         
                        int index33_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index33_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA33_6 = input.LA(1);

                         
                        int index33_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index33_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA33_7 = input.LA(1);

                         
                        int index33_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index33_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA33_8 = input.LA(1);

                         
                        int index33_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index33_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA33_9 = input.LA(1);

                         
                        int index33_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index33_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index33_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_21s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_21;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "4641:2: ( rule__RecExpression__RecExpAssignment_1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_1 = input.LA(1);

                         
                        int index34_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred73_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index34_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_2 = input.LA(1);

                         
                        int index34_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred73_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index34_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA34_3 = input.LA(1);

                         
                        int index34_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred73_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index34_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA34_4 = input.LA(1);

                         
                        int index34_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred73_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index34_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA34_5 = input.LA(1);

                         
                        int index34_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred73_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index34_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA34_6 = input.LA(1);

                         
                        int index34_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred73_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index34_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA34_7 = input.LA(1);

                         
                        int index34_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred73_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index34_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA34_8 = input.LA(1);

                         
                        int index34_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred73_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index34_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA34_9 = input.LA(1);

                         
                        int index34_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred73_InternalAle()) ) {s = 11;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index34_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000D400000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000002200000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000430000060080L,0x0000000000003F00L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000010000000082L,0x0000000000003F00L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000400000060002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000400000060000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000010000000080L,0x0000000000003F00L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000210000000080L,0x0000000000003F00L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000800200000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x60201100E00000F0L,0x0000000000003F62L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x60241100E00000F0L,0x0000000000003F62L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x60A11300E00000F0L,0x0000000000003F62L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x60A11100E00000F0L,0x0000000000003F62L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x60A11100E00000F2L,0x0000000000003F62L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x1F00002000000700L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x000000001FF80080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x1000002000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x00000100E00000F0L,0x0000000000003F60L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0002080000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});

}