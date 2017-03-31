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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENT", "RULE_STRING", "RULE_INT", "RULE_REAL", "RULE_MULTOP", "RULE_LETTER", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'def'", "'override'", "'+'", "'-'", "'<='", "'>='", "'!='", "'<>'", "'='", "'=='", "'<'", "'>'", "'select'", "'reject'", "'collect'", "'any'", "'exists'", "'forAll'", "'isUnique'", "'one'", "'sortedBy'", "'closure'", "'true'", "'false'", "'null'", "'String'", "'Integer'", "'Real'", "'Boolean'", "'behavior'", "';'", "'import'", "'as'", "'use'", "'.'", "'open'", "'class'", "'{'", "'}'", "'extends'", "','", "'('", "')'", "'@'", "':='", "'for'", "'in'", "'['", "'..'", "']'", "'if'", "'else'", "'while'", "'and'", "'or'", "'xor'", "'implies'", "'->'", "'not'", "'then'", "'endif'", "'let'", "':'", "'|'", "'Sequence{'", "'OrderedSet{'", "'::'", "'Sequence('", "'OrderedSet('"
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
    public static final int RULE_REAL=7;
    public static final int RULE_IDENT=4;
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
    public static final int RULE_STRING=5;
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
    public static final int RULE_MULTOP=8;
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


    // $ANTLR start "entryRuleaddOp"
    // InternalAle.g:679:1: entryRuleaddOp : ruleaddOp EOF ;
    public final void entryRuleaddOp() throws RecognitionException {
        try {
            // InternalAle.g:680:1: ( ruleaddOp EOF )
            // InternalAle.g:681:1: ruleaddOp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOpRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleaddOp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOpRule()); 
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
    // $ANTLR end "entryRuleaddOp"


    // $ANTLR start "ruleaddOp"
    // InternalAle.g:688:1: ruleaddOp : ( ( rule__AddOp__Alternatives ) ) ;
    public final void ruleaddOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:692:2: ( ( ( rule__AddOp__Alternatives ) ) )
            // InternalAle.g:693:2: ( ( rule__AddOp__Alternatives ) )
            {
            // InternalAle.g:693:2: ( ( rule__AddOp__Alternatives ) )
            // InternalAle.g:694:3: ( rule__AddOp__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAddOpAccess().getAlternatives()); 
            }
            // InternalAle.g:695:3: ( rule__AddOp__Alternatives )
            // InternalAle.g:695:4: rule__AddOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AddOp__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAddOpAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleaddOp"


    // $ANTLR start "entryRulecompOp"
    // InternalAle.g:704:1: entryRulecompOp : rulecompOp EOF ;
    public final void entryRulecompOp() throws RecognitionException {
        try {
            // InternalAle.g:705:1: ( rulecompOp EOF )
            // InternalAle.g:706:1: rulecompOp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompOpRule()); 
            }
            pushFollow(FOLLOW_1);
            rulecompOp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompOpRule()); 
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
    // $ANTLR end "entryRulecompOp"


    // $ANTLR start "rulecompOp"
    // InternalAle.g:713:1: rulecompOp : ( ( rule__CompOp__Alternatives ) ) ;
    public final void rulecompOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:717:2: ( ( ( rule__CompOp__Alternatives ) ) )
            // InternalAle.g:718:2: ( ( rule__CompOp__Alternatives ) )
            {
            // InternalAle.g:718:2: ( ( rule__CompOp__Alternatives ) )
            // InternalAle.g:719:3: ( rule__CompOp__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompOpAccess().getAlternatives()); 
            }
            // InternalAle.g:720:3: ( rule__CompOp__Alternatives )
            // InternalAle.g:720:4: rule__CompOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CompOp__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompOpAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulecompOp"


    // $ANTLR start "entryRulecallExp"
    // InternalAle.g:729:1: entryRulecallExp : rulecallExp EOF ;
    public final void entryRulecallExp() throws RecognitionException {
        try {
            // InternalAle.g:730:1: ( rulecallExp EOF )
            // InternalAle.g:731:1: rulecallExp EOF
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
    // InternalAle.g:738:1: rulecallExp : ( ( rule__CallExp__Alternatives ) ) ;
    public final void rulecallExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:742:2: ( ( ( rule__CallExp__Alternatives ) ) )
            // InternalAle.g:743:2: ( ( rule__CallExp__Alternatives ) )
            {
            // InternalAle.g:743:2: ( ( rule__CallExp__Alternatives ) )
            // InternalAle.g:744:3: ( rule__CallExp__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getAlternatives()); 
            }
            // InternalAle.g:745:3: ( rule__CallExp__Alternatives )
            // InternalAle.g:745:4: rule__CallExp__Alternatives
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
    // InternalAle.g:754:1: entryRulecollectionIterator : rulecollectionIterator EOF ;
    public final void entryRulecollectionIterator() throws RecognitionException {
        try {
            // InternalAle.g:755:1: ( rulecollectionIterator EOF )
            // InternalAle.g:756:1: rulecollectionIterator EOF
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
    // InternalAle.g:763:1: rulecollectionIterator : ( ( rule__CollectionIterator__Alternatives ) ) ;
    public final void rulecollectionIterator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:767:2: ( ( ( rule__CollectionIterator__Alternatives ) ) )
            // InternalAle.g:768:2: ( ( rule__CollectionIterator__Alternatives ) )
            {
            // InternalAle.g:768:2: ( ( rule__CollectionIterator__Alternatives ) )
            // InternalAle.g:769:3: ( rule__CollectionIterator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionIteratorAccess().getAlternatives()); 
            }
            // InternalAle.g:770:3: ( rule__CollectionIterator__Alternatives )
            // InternalAle.g:770:4: rule__CollectionIterator__Alternatives
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
    // InternalAle.g:779:1: entryRuleexpressionSequence : ruleexpressionSequence EOF ;
    public final void entryRuleexpressionSequence() throws RecognitionException {
        try {
            // InternalAle.g:780:1: ( ruleexpressionSequence EOF )
            // InternalAle.g:781:1: ruleexpressionSequence EOF
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
    // InternalAle.g:788:1: ruleexpressionSequence : ( ( rule__ExpressionSequence__Group__0 )? ) ;
    public final void ruleexpressionSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:792:2: ( ( ( rule__ExpressionSequence__Group__0 )? ) )
            // InternalAle.g:793:2: ( ( rule__ExpressionSequence__Group__0 )? )
            {
            // InternalAle.g:793:2: ( ( rule__ExpressionSequence__Group__0 )? )
            // InternalAle.g:794:3: ( rule__ExpressionSequence__Group__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getGroup()); 
            }
            // InternalAle.g:795:3: ( rule__ExpressionSequence__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_IDENT && LA1_0<=RULE_REAL)||LA1_0==18||(LA1_0>=37 && LA1_0<=43)||LA1_0==52||LA1_0==56||LA1_0==65||LA1_0==73||LA1_0==76||(LA1_0>=79 && LA1_0<=80)||(LA1_0>=82 && LA1_0<=83)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalAle.g:795:4: rule__ExpressionSequence__Group__0
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
    // InternalAle.g:804:1: entryRulevariableDefinition : rulevariableDefinition EOF ;
    public final void entryRulevariableDefinition() throws RecognitionException {
        try {
            // InternalAle.g:805:1: ( rulevariableDefinition EOF )
            // InternalAle.g:806:1: rulevariableDefinition EOF
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
    // InternalAle.g:813:1: rulevariableDefinition : ( ( rule__VariableDefinition__Group__0 ) ) ;
    public final void rulevariableDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:817:2: ( ( ( rule__VariableDefinition__Group__0 ) ) )
            // InternalAle.g:818:2: ( ( rule__VariableDefinition__Group__0 ) )
            {
            // InternalAle.g:818:2: ( ( rule__VariableDefinition__Group__0 ) )
            // InternalAle.g:819:3: ( rule__VariableDefinition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getGroup()); 
            }
            // InternalAle.g:820:3: ( rule__VariableDefinition__Group__0 )
            // InternalAle.g:820:4: rule__VariableDefinition__Group__0
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
    // InternalAle.g:829:1: entryRuleliteral : ruleliteral EOF ;
    public final void entryRuleliteral() throws RecognitionException {
        try {
            // InternalAle.g:830:1: ( ruleliteral EOF )
            // InternalAle.g:831:1: ruleliteral EOF
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
    // InternalAle.g:838:1: ruleliteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleliteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:842:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalAle.g:843:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalAle.g:843:2: ( ( rule__Literal__Alternatives ) )
            // InternalAle.g:844:3: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // InternalAle.g:845:3: ( rule__Literal__Alternatives )
            // InternalAle.g:845:4: rule__Literal__Alternatives
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
    // InternalAle.g:854:1: entryRuletypeLiteral : ruletypeLiteral EOF ;
    public final void entryRuletypeLiteral() throws RecognitionException {
        try {
            // InternalAle.g:855:1: ( ruletypeLiteral EOF )
            // InternalAle.g:856:1: ruletypeLiteral EOF
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
    // InternalAle.g:863:1: ruletypeLiteral : ( ( rule__TypeLiteral__Alternatives ) ) ;
    public final void ruletypeLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:867:2: ( ( ( rule__TypeLiteral__Alternatives ) ) )
            // InternalAle.g:868:2: ( ( rule__TypeLiteral__Alternatives ) )
            {
            // InternalAle.g:868:2: ( ( rule__TypeLiteral__Alternatives ) )
            // InternalAle.g:869:3: ( rule__TypeLiteral__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getAlternatives()); 
            }
            // InternalAle.g:870:3: ( rule__TypeLiteral__Alternatives )
            // InternalAle.g:870:4: rule__TypeLiteral__Alternatives
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
    // InternalAle.g:879:1: entryRuleclassifierTypeRule : ruleclassifierTypeRule EOF ;
    public final void entryRuleclassifierTypeRule() throws RecognitionException {
        try {
            // InternalAle.g:880:1: ( ruleclassifierTypeRule EOF )
            // InternalAle.g:881:1: ruleclassifierTypeRule EOF
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
    // InternalAle.g:888:1: ruleclassifierTypeRule : ( ( rule__ClassifierTypeRule__Alternatives ) ) ;
    public final void ruleclassifierTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:892:2: ( ( ( rule__ClassifierTypeRule__Alternatives ) ) )
            // InternalAle.g:893:2: ( ( rule__ClassifierTypeRule__Alternatives ) )
            {
            // InternalAle.g:893:2: ( ( rule__ClassifierTypeRule__Alternatives ) )
            // InternalAle.g:894:3: ( rule__ClassifierTypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getAlternatives()); 
            }
            // InternalAle.g:895:3: ( rule__ClassifierTypeRule__Alternatives )
            // InternalAle.g:895:4: rule__ClassifierTypeRule__Alternatives
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
    // InternalAle.g:904:1: entryRulerType : rulerType EOF ;
    public final void entryRulerType() throws RecognitionException {
        try {
            // InternalAle.g:905:1: ( rulerType EOF )
            // InternalAle.g:906:1: rulerType EOF
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
    // InternalAle.g:913:1: rulerType : ( ( rule__RType__Alternatives ) ) ;
    public final void rulerType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:917:2: ( ( ( rule__RType__Alternatives ) ) )
            // InternalAle.g:918:2: ( ( rule__RType__Alternatives ) )
            {
            // InternalAle.g:918:2: ( ( rule__RType__Alternatives ) )
            // InternalAle.g:919:3: ( rule__RType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTypeAccess().getAlternatives()); 
            }
            // InternalAle.g:920:3: ( rule__RType__Alternatives )
            // InternalAle.g:920:4: rule__RType__Alternatives
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
    // InternalAle.g:929:1: entryRulerQualified : rulerQualified EOF ;
    public final void entryRulerQualified() throws RecognitionException {
        try {
            // InternalAle.g:930:1: ( rulerQualified EOF )
            // InternalAle.g:931:1: rulerQualified EOF
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
    // InternalAle.g:938:1: rulerQualified : ( ( rule__RQualified__Group__0 ) ) ;
    public final void rulerQualified() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:942:2: ( ( ( rule__RQualified__Group__0 ) ) )
            // InternalAle.g:943:2: ( ( rule__RQualified__Group__0 ) )
            {
            // InternalAle.g:943:2: ( ( rule__RQualified__Group__0 ) )
            // InternalAle.g:944:3: ( rule__RQualified__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getGroup()); 
            }
            // InternalAle.g:945:3: ( rule__RQualified__Group__0 )
            // InternalAle.g:945:4: rule__RQualified__Group__0
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
    // InternalAle.g:953:1: rule__RClass__Alternatives : ( ( ( rule__RClass__Group_0__0 ) ) | ( ( rule__RClass__Group_1__0 ) ) );
    public final void rule__RClass__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:957:1: ( ( ( rule__RClass__Group_0__0 ) ) | ( ( rule__RClass__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==50) ) {
                alt2=1;
            }
            else if ( (LA2_0==51) ) {
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
                    // InternalAle.g:958:2: ( ( rule__RClass__Group_0__0 ) )
                    {
                    // InternalAle.g:958:2: ( ( rule__RClass__Group_0__0 ) )
                    // InternalAle.g:959:3: ( rule__RClass__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRClassAccess().getGroup_0()); 
                    }
                    // InternalAle.g:960:3: ( rule__RClass__Group_0__0 )
                    // InternalAle.g:960:4: rule__RClass__Group_0__0
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
                    // InternalAle.g:964:2: ( ( rule__RClass__Group_1__0 ) )
                    {
                    // InternalAle.g:964:2: ( ( rule__RClass__Group_1__0 ) )
                    // InternalAle.g:965:3: ( rule__RClass__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRClassAccess().getGroup_1()); 
                    }
                    // InternalAle.g:966:3: ( rule__RClass__Group_1__0 )
                    // InternalAle.g:966:4: rule__RClass__Group_1__0
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
    // InternalAle.g:974:1: rule__ROperation__Alternatives_1 : ( ( 'def' ) | ( 'override' ) );
    public final void rule__ROperation__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:978:1: ( ( 'def' ) | ( 'override' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
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
                    // InternalAle.g:979:2: ( 'def' )
                    {
                    // InternalAle.g:979:2: ( 'def' )
                    // InternalAle.g:980:3: 'def'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getROperationAccess().getDefKeyword_1_0()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getROperationAccess().getDefKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:985:2: ( 'override' )
                    {
                    // InternalAle.g:985:2: ( 'override' )
                    // InternalAle.g:986:3: 'override'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getROperationAccess().getOverrideKeyword_1_1()); 
                    }
                    match(input,16,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:995:1: rule__RStatement__Alternatives : ( ( ( rule__RStatement__Group_0__0 ) ) | ( ( rule__RStatement__Group_1__0 ) ) | ( ( rule__RStatement__Group_2__0 ) ) | ( ( rule__RStatement__Group_3__0 ) ) | ( ( rule__RStatement__Group_4__0 ) ) | ( ( rule__RStatement__Group_5__0 ) ) );
    public final void rule__RStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:999:1: ( ( ( rule__RStatement__Group_0__0 ) ) | ( ( rule__RStatement__Group_1__0 ) ) | ( ( rule__RStatement__Group_2__0 ) ) | ( ( rule__RStatement__Group_3__0 ) ) | ( ( rule__RStatement__Group_4__0 ) ) | ( ( rule__RStatement__Group_5__0 ) ) )
            int alt4=6;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalAle.g:1000:2: ( ( rule__RStatement__Group_0__0 ) )
                    {
                    // InternalAle.g:1000:2: ( ( rule__RStatement__Group_0__0 ) )
                    // InternalAle.g:1001:3: ( rule__RStatement__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1002:3: ( rule__RStatement__Group_0__0 )
                    // InternalAle.g:1002:4: rule__RStatement__Group_0__0
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
                    // InternalAle.g:1006:2: ( ( rule__RStatement__Group_1__0 ) )
                    {
                    // InternalAle.g:1006:2: ( ( rule__RStatement__Group_1__0 ) )
                    // InternalAle.g:1007:3: ( rule__RStatement__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1008:3: ( rule__RStatement__Group_1__0 )
                    // InternalAle.g:1008:4: rule__RStatement__Group_1__0
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
                    // InternalAle.g:1012:2: ( ( rule__RStatement__Group_2__0 ) )
                    {
                    // InternalAle.g:1012:2: ( ( rule__RStatement__Group_2__0 ) )
                    // InternalAle.g:1013:3: ( rule__RStatement__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_2()); 
                    }
                    // InternalAle.g:1014:3: ( rule__RStatement__Group_2__0 )
                    // InternalAle.g:1014:4: rule__RStatement__Group_2__0
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
                    // InternalAle.g:1018:2: ( ( rule__RStatement__Group_3__0 ) )
                    {
                    // InternalAle.g:1018:2: ( ( rule__RStatement__Group_3__0 ) )
                    // InternalAle.g:1019:3: ( rule__RStatement__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_3()); 
                    }
                    // InternalAle.g:1020:3: ( rule__RStatement__Group_3__0 )
                    // InternalAle.g:1020:4: rule__RStatement__Group_3__0
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
                    // InternalAle.g:1024:2: ( ( rule__RStatement__Group_4__0 ) )
                    {
                    // InternalAle.g:1024:2: ( ( rule__RStatement__Group_4__0 ) )
                    // InternalAle.g:1025:3: ( rule__RStatement__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_4()); 
                    }
                    // InternalAle.g:1026:3: ( rule__RStatement__Group_4__0 )
                    // InternalAle.g:1026:4: rule__RStatement__Group_4__0
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
                    // InternalAle.g:1030:2: ( ( rule__RStatement__Group_5__0 ) )
                    {
                    // InternalAle.g:1030:2: ( ( rule__RStatement__Group_5__0 ) )
                    // InternalAle.g:1031:3: ( rule__RStatement__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getGroup_5()); 
                    }
                    // InternalAle.g:1032:3: ( rule__RStatement__Group_5__0 )
                    // InternalAle.g:1032:4: rule__RStatement__Group_5__0
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
    // InternalAle.g:1040:1: rule__RCollection__Alternatives : ( ( ( rule__RCollection__Group_0__0 ) ) | ( ruleexpression ) );
    public final void rule__RCollection__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1044:1: ( ( ( rule__RCollection__Group_0__0 ) ) | ( ruleexpression ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==62) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_IDENT && LA5_0<=RULE_REAL)||LA5_0==18||(LA5_0>=37 && LA5_0<=43)||LA5_0==52||LA5_0==56||LA5_0==65||LA5_0==73||LA5_0==76||(LA5_0>=79 && LA5_0<=80)||(LA5_0>=82 && LA5_0<=83)) ) {
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
                    // InternalAle.g:1045:2: ( ( rule__RCollection__Group_0__0 ) )
                    {
                    // InternalAle.g:1045:2: ( ( rule__RCollection__Group_0__0 ) )
                    // InternalAle.g:1046:3: ( rule__RCollection__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRCollectionAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1047:3: ( rule__RCollection__Group_0__0 )
                    // InternalAle.g:1047:4: rule__RCollection__Group_0__0
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
                    // InternalAle.g:1051:2: ( ruleexpression )
                    {
                    // InternalAle.g:1051:2: ( ruleexpression )
                    // InternalAle.g:1052:3: ruleexpression
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
    // InternalAle.g:1061:1: rule__RecExpression__Alternatives_0 : ( ( rulenavigationSegment ) | ( ( rule__RecExpression__Group_0_1__0 ) ) | ( ( rule__RecExpression__Group_0_2__0 ) ) | ( ( rule__RecExpression__Group_0_3__0 ) ) | ( ( rule__RecExpression__Group_0_4__0 ) ) | ( ( rule__RecExpression__Group_0_5__0 ) ) | ( ( rule__RecExpression__Group_0_6__0 ) ) | ( ( rule__RecExpression__Group_0_7__0 ) ) );
    public final void rule__RecExpression__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1065:1: ( ( rulenavigationSegment ) | ( ( rule__RecExpression__Group_0_1__0 ) ) | ( ( rule__RecExpression__Group_0_2__0 ) ) | ( ( rule__RecExpression__Group_0_3__0 ) ) | ( ( rule__RecExpression__Group_0_4__0 ) ) | ( ( rule__RecExpression__Group_0_5__0 ) ) | ( ( rule__RecExpression__Group_0_6__0 ) ) | ( ( rule__RecExpression__Group_0_7__0 ) ) )
            int alt6=8;
            switch ( input.LA(1) ) {
            case 49:
            case 72:
                {
                alt6=1;
                }
                break;
            case RULE_MULTOP:
                {
                alt6=2;
                }
                break;
            case 17:
            case 18:
                {
                alt6=3;
                }
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                {
                alt6=4;
                }
                break;
            case 68:
                {
                alt6=5;
                }
                break;
            case 69:
                {
                alt6=6;
                }
                break;
            case 70:
                {
                alt6=7;
                }
                break;
            case 71:
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
                    // InternalAle.g:1066:2: ( rulenavigationSegment )
                    {
                    // InternalAle.g:1066:2: ( rulenavigationSegment )
                    // InternalAle.g:1067:3: rulenavigationSegment
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
                    // InternalAle.g:1072:2: ( ( rule__RecExpression__Group_0_1__0 ) )
                    {
                    // InternalAle.g:1072:2: ( ( rule__RecExpression__Group_0_1__0 ) )
                    // InternalAle.g:1073:3: ( rule__RecExpression__Group_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_1()); 
                    }
                    // InternalAle.g:1074:3: ( rule__RecExpression__Group_0_1__0 )
                    // InternalAle.g:1074:4: rule__RecExpression__Group_0_1__0
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
                    // InternalAle.g:1078:2: ( ( rule__RecExpression__Group_0_2__0 ) )
                    {
                    // InternalAle.g:1078:2: ( ( rule__RecExpression__Group_0_2__0 ) )
                    // InternalAle.g:1079:3: ( rule__RecExpression__Group_0_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_2()); 
                    }
                    // InternalAle.g:1080:3: ( rule__RecExpression__Group_0_2__0 )
                    // InternalAle.g:1080:4: rule__RecExpression__Group_0_2__0
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
                    // InternalAle.g:1084:2: ( ( rule__RecExpression__Group_0_3__0 ) )
                    {
                    // InternalAle.g:1084:2: ( ( rule__RecExpression__Group_0_3__0 ) )
                    // InternalAle.g:1085:3: ( rule__RecExpression__Group_0_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_3()); 
                    }
                    // InternalAle.g:1086:3: ( rule__RecExpression__Group_0_3__0 )
                    // InternalAle.g:1086:4: rule__RecExpression__Group_0_3__0
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
                    // InternalAle.g:1090:2: ( ( rule__RecExpression__Group_0_4__0 ) )
                    {
                    // InternalAle.g:1090:2: ( ( rule__RecExpression__Group_0_4__0 ) )
                    // InternalAle.g:1091:3: ( rule__RecExpression__Group_0_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_4()); 
                    }
                    // InternalAle.g:1092:3: ( rule__RecExpression__Group_0_4__0 )
                    // InternalAle.g:1092:4: rule__RecExpression__Group_0_4__0
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
                    // InternalAle.g:1096:2: ( ( rule__RecExpression__Group_0_5__0 ) )
                    {
                    // InternalAle.g:1096:2: ( ( rule__RecExpression__Group_0_5__0 ) )
                    // InternalAle.g:1097:3: ( rule__RecExpression__Group_0_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_5()); 
                    }
                    // InternalAle.g:1098:3: ( rule__RecExpression__Group_0_5__0 )
                    // InternalAle.g:1098:4: rule__RecExpression__Group_0_5__0
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
                    // InternalAle.g:1102:2: ( ( rule__RecExpression__Group_0_6__0 ) )
                    {
                    // InternalAle.g:1102:2: ( ( rule__RecExpression__Group_0_6__0 ) )
                    // InternalAle.g:1103:3: ( rule__RecExpression__Group_0_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_6()); 
                    }
                    // InternalAle.g:1104:3: ( rule__RecExpression__Group_0_6__0 )
                    // InternalAle.g:1104:4: rule__RecExpression__Group_0_6__0
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
                    // InternalAle.g:1108:2: ( ( rule__RecExpression__Group_0_7__0 ) )
                    {
                    // InternalAle.g:1108:2: ( ( rule__RecExpression__Group_0_7__0 ) )
                    // InternalAle.g:1109:3: ( rule__RecExpression__Group_0_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_7()); 
                    }
                    // InternalAle.g:1110:3: ( rule__RecExpression__Group_0_7__0 )
                    // InternalAle.g:1110:4: rule__RecExpression__Group_0_7__0
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
    // InternalAle.g:1118:1: rule__NavigationSegment__Alternatives : ( ( ( rule__NavigationSegment__Group_0__0 ) ) | ( ( rule__NavigationSegment__Group_1__0 ) ) | ( ( rule__NavigationSegment__Group_2__0 ) ) );
    public final void rule__NavigationSegment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1122:1: ( ( ( rule__NavigationSegment__Group_0__0 ) ) | ( ( rule__NavigationSegment__Group_1__0 ) ) | ( ( rule__NavigationSegment__Group_2__0 ) ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==49) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_IDENT) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==EOF||LA7_3==RULE_MULTOP||(LA7_3>=17 && LA7_3<=26)||LA7_3==45||LA7_3==49||LA7_3==53||LA7_3==55||LA7_3==57||LA7_3==59||LA7_3==61||LA7_3==66||(LA7_3>=68 && LA7_3<=72)||(LA7_3>=74 && LA7_3<=75)) ) {
                        alt7=1;
                    }
                    else if ( (LA7_3==56) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else if ( ((LA7_1>=27 && LA7_1<=36)) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==72) ) {
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
                    // InternalAle.g:1123:2: ( ( rule__NavigationSegment__Group_0__0 ) )
                    {
                    // InternalAle.g:1123:2: ( ( rule__NavigationSegment__Group_0__0 ) )
                    // InternalAle.g:1124:3: ( rule__NavigationSegment__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationSegmentAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1125:3: ( rule__NavigationSegment__Group_0__0 )
                    // InternalAle.g:1125:4: rule__NavigationSegment__Group_0__0
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
                    // InternalAle.g:1129:2: ( ( rule__NavigationSegment__Group_1__0 ) )
                    {
                    // InternalAle.g:1129:2: ( ( rule__NavigationSegment__Group_1__0 ) )
                    // InternalAle.g:1130:3: ( rule__NavigationSegment__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationSegmentAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1131:3: ( rule__NavigationSegment__Group_1__0 )
                    // InternalAle.g:1131:4: rule__NavigationSegment__Group_1__0
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
                    // InternalAle.g:1135:2: ( ( rule__NavigationSegment__Group_2__0 ) )
                    {
                    // InternalAle.g:1135:2: ( ( rule__NavigationSegment__Group_2__0 ) )
                    // InternalAle.g:1136:3: ( rule__NavigationSegment__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationSegmentAccess().getGroup_2()); 
                    }
                    // InternalAle.g:1137:3: ( rule__NavigationSegment__Group_2__0 )
                    // InternalAle.g:1137:4: rule__NavigationSegment__Group_2__0
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
    // InternalAle.g:1145:1: rule__NonLeftRecExpression__Alternatives : ( ( ( rule__NonLeftRecExpression__Group_0__0 ) ) | ( ( rule__NonLeftRecExpression__Group_1__0 ) ) | ( RULE_IDENT ) | ( ruleliteral ) | ( ( rule__NonLeftRecExpression__Group_4__0 ) ) | ( ( rule__NonLeftRecExpression__Group_5__0 ) ) | ( ( rule__NonLeftRecExpression__Group_6__0 ) ) );
    public final void rule__NonLeftRecExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1149:1: ( ( ( rule__NonLeftRecExpression__Group_0__0 ) ) | ( ( rule__NonLeftRecExpression__Group_1__0 ) ) | ( RULE_IDENT ) | ( ruleliteral ) | ( ( rule__NonLeftRecExpression__Group_4__0 ) ) | ( ( rule__NonLeftRecExpression__Group_5__0 ) ) | ( ( rule__NonLeftRecExpression__Group_6__0 ) ) )
            int alt8=7;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt8=1;
                }
                break;
            case 18:
                {
                alt8=2;
                }
                break;
            case RULE_IDENT:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==77||LA8_3==81) ) {
                    alt8=4;
                }
                else if ( (LA8_3==EOF||LA8_3==RULE_MULTOP||(LA8_3>=17 && LA8_3<=26)||LA8_3==45||LA8_3==49||LA8_3==53||LA8_3==55||LA8_3==57||LA8_3==59||LA8_3==61||LA8_3==66||(LA8_3>=68 && LA8_3<=72)||(LA8_3>=74 && LA8_3<=75)) ) {
                    alt8=3;
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
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 52:
            case 79:
            case 80:
            case 82:
            case 83:
                {
                alt8=4;
                }
                break;
            case 56:
                {
                alt8=5;
                }
                break;
            case 65:
                {
                alt8=6;
                }
                break;
            case 76:
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
                    // InternalAle.g:1150:2: ( ( rule__NonLeftRecExpression__Group_0__0 ) )
                    {
                    // InternalAle.g:1150:2: ( ( rule__NonLeftRecExpression__Group_0__0 ) )
                    // InternalAle.g:1151:3: ( rule__NonLeftRecExpression__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1152:3: ( rule__NonLeftRecExpression__Group_0__0 )
                    // InternalAle.g:1152:4: rule__NonLeftRecExpression__Group_0__0
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
                    // InternalAle.g:1156:2: ( ( rule__NonLeftRecExpression__Group_1__0 ) )
                    {
                    // InternalAle.g:1156:2: ( ( rule__NonLeftRecExpression__Group_1__0 ) )
                    // InternalAle.g:1157:3: ( rule__NonLeftRecExpression__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1158:3: ( rule__NonLeftRecExpression__Group_1__0 )
                    // InternalAle.g:1158:4: rule__NonLeftRecExpression__Group_1__0
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
                    // InternalAle.g:1162:2: ( RULE_IDENT )
                    {
                    // InternalAle.g:1162:2: ( RULE_IDENT )
                    // InternalAle.g:1163:3: RULE_IDENT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getIdentTerminalRuleCall_2()); 
                    }
                    match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonLeftRecExpressionAccess().getIdentTerminalRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1168:2: ( ruleliteral )
                    {
                    // InternalAle.g:1168:2: ( ruleliteral )
                    // InternalAle.g:1169:3: ruleliteral
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getLiteralParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleliteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNonLeftRecExpressionAccess().getLiteralParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1174:2: ( ( rule__NonLeftRecExpression__Group_4__0 ) )
                    {
                    // InternalAle.g:1174:2: ( ( rule__NonLeftRecExpression__Group_4__0 ) )
                    // InternalAle.g:1175:3: ( rule__NonLeftRecExpression__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_4()); 
                    }
                    // InternalAle.g:1176:3: ( rule__NonLeftRecExpression__Group_4__0 )
                    // InternalAle.g:1176:4: rule__NonLeftRecExpression__Group_4__0
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
                    // InternalAle.g:1180:2: ( ( rule__NonLeftRecExpression__Group_5__0 ) )
                    {
                    // InternalAle.g:1180:2: ( ( rule__NonLeftRecExpression__Group_5__0 ) )
                    // InternalAle.g:1181:3: ( rule__NonLeftRecExpression__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_5()); 
                    }
                    // InternalAle.g:1182:3: ( rule__NonLeftRecExpression__Group_5__0 )
                    // InternalAle.g:1182:4: rule__NonLeftRecExpression__Group_5__0
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
                    // InternalAle.g:1186:2: ( ( rule__NonLeftRecExpression__Group_6__0 ) )
                    {
                    // InternalAle.g:1186:2: ( ( rule__NonLeftRecExpression__Group_6__0 ) )
                    // InternalAle.g:1187:3: ( rule__NonLeftRecExpression__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6()); 
                    }
                    // InternalAle.g:1188:3: ( rule__NonLeftRecExpression__Group_6__0 )
                    // InternalAle.g:1188:4: rule__NonLeftRecExpression__Group_6__0
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


    // $ANTLR start "rule__AddOp__Alternatives"
    // InternalAle.g:1196:1: rule__AddOp__Alternatives : ( ( '+' ) | ( '-' ) );
    public final void rule__AddOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1200:1: ( ( '+' ) | ( '-' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            else if ( (LA9_0==18) ) {
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
                    // InternalAle.g:1201:2: ( '+' )
                    {
                    // InternalAle.g:1201:2: ( '+' )
                    // InternalAle.g:1202:3: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOpAccess().getPlusSignKeyword_0()); 
                    }
                    match(input,17,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAddOpAccess().getPlusSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1207:2: ( '-' )
                    {
                    // InternalAle.g:1207:2: ( '-' )
                    // InternalAle.g:1208:3: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAddOpAccess().getHyphenMinusKeyword_1()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAddOpAccess().getHyphenMinusKeyword_1()); 
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
    // $ANTLR end "rule__AddOp__Alternatives"


    // $ANTLR start "rule__CompOp__Alternatives"
    // InternalAle.g:1217:1: rule__CompOp__Alternatives : ( ( '<=' ) | ( '>=' ) | ( '!=' ) | ( '<>' ) | ( '=' ) | ( '==' ) | ( '<' ) | ( '>' ) );
    public final void rule__CompOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1221:1: ( ( '<=' ) | ( '>=' ) | ( '!=' ) | ( '<>' ) | ( '=' ) | ( '==' ) | ( '<' ) | ( '>' ) )
            int alt10=8;
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
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalAle.g:1222:2: ( '<=' )
                    {
                    // InternalAle.g:1222:2: ( '<=' )
                    // InternalAle.g:1223:3: '<='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompOpAccess().getLessThanSignEqualsSignKeyword_0()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompOpAccess().getLessThanSignEqualsSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1228:2: ( '>=' )
                    {
                    // InternalAle.g:1228:2: ( '>=' )
                    // InternalAle.g:1229:3: '>='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompOpAccess().getGreaterThanSignEqualsSignKeyword_1()); 
                    }
                    match(input,20,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompOpAccess().getGreaterThanSignEqualsSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1234:2: ( '!=' )
                    {
                    // InternalAle.g:1234:2: ( '!=' )
                    // InternalAle.g:1235:3: '!='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompOpAccess().getExclamationMarkEqualsSignKeyword_2()); 
                    }
                    match(input,21,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompOpAccess().getExclamationMarkEqualsSignKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1240:2: ( '<>' )
                    {
                    // InternalAle.g:1240:2: ( '<>' )
                    // InternalAle.g:1241:3: '<>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompOpAccess().getLessThanSignGreaterThanSignKeyword_3()); 
                    }
                    match(input,22,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompOpAccess().getLessThanSignGreaterThanSignKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1246:2: ( '=' )
                    {
                    // InternalAle.g:1246:2: ( '=' )
                    // InternalAle.g:1247:3: '='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompOpAccess().getEqualsSignKeyword_4()); 
                    }
                    match(input,23,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompOpAccess().getEqualsSignKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1252:2: ( '==' )
                    {
                    // InternalAle.g:1252:2: ( '==' )
                    // InternalAle.g:1253:3: '=='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompOpAccess().getEqualsSignEqualsSignKeyword_5()); 
                    }
                    match(input,24,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompOpAccess().getEqualsSignEqualsSignKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:1258:2: ( '<' )
                    {
                    // InternalAle.g:1258:2: ( '<' )
                    // InternalAle.g:1259:3: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompOpAccess().getLessThanSignKeyword_6()); 
                    }
                    match(input,25,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompOpAccess().getLessThanSignKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:1264:2: ( '>' )
                    {
                    // InternalAle.g:1264:2: ( '>' )
                    // InternalAle.g:1265:3: '>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompOpAccess().getGreaterThanSignKeyword_7()); 
                    }
                    match(input,26,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompOpAccess().getGreaterThanSignKeyword_7()); 
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
    // $ANTLR end "rule__CompOp__Alternatives"


    // $ANTLR start "rule__CallExp__Alternatives"
    // InternalAle.g:1274:1: rule__CallExp__Alternatives : ( ( ( rule__CallExp__Group_0__0 ) ) | ( ( rule__CallExp__Group_1__0 ) ) );
    public final void rule__CallExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1278:1: ( ( ( rule__CallExp__Group_0__0 ) ) | ( ( rule__CallExp__Group_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=27 && LA11_0<=36)) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_IDENT) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalAle.g:1279:2: ( ( rule__CallExp__Group_0__0 ) )
                    {
                    // InternalAle.g:1279:2: ( ( rule__CallExp__Group_0__0 ) )
                    // InternalAle.g:1280:3: ( rule__CallExp__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1281:3: ( rule__CallExp__Group_0__0 )
                    // InternalAle.g:1281:4: rule__CallExp__Group_0__0
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
                    // InternalAle.g:1285:2: ( ( rule__CallExp__Group_1__0 ) )
                    {
                    // InternalAle.g:1285:2: ( ( rule__CallExp__Group_1__0 ) )
                    // InternalAle.g:1286:3: ( rule__CallExp__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1287:3: ( rule__CallExp__Group_1__0 )
                    // InternalAle.g:1287:4: rule__CallExp__Group_1__0
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
    // InternalAle.g:1295:1: rule__CollectionIterator__Alternatives : ( ( 'select' ) | ( 'reject' ) | ( 'collect' ) | ( 'any' ) | ( 'exists' ) | ( 'forAll' ) | ( 'isUnique' ) | ( 'one' ) | ( 'sortedBy' ) | ( 'closure' ) );
    public final void rule__CollectionIterator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1299:1: ( ( 'select' ) | ( 'reject' ) | ( 'collect' ) | ( 'any' ) | ( 'exists' ) | ( 'forAll' ) | ( 'isUnique' ) | ( 'one' ) | ( 'sortedBy' ) | ( 'closure' ) )
            int alt12=10;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt12=1;
                }
                break;
            case 28:
                {
                alt12=2;
                }
                break;
            case 29:
                {
                alt12=3;
                }
                break;
            case 30:
                {
                alt12=4;
                }
                break;
            case 31:
                {
                alt12=5;
                }
                break;
            case 32:
                {
                alt12=6;
                }
                break;
            case 33:
                {
                alt12=7;
                }
                break;
            case 34:
                {
                alt12=8;
                }
                break;
            case 35:
                {
                alt12=9;
                }
                break;
            case 36:
                {
                alt12=10;
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
                    // InternalAle.g:1300:2: ( 'select' )
                    {
                    // InternalAle.g:1300:2: ( 'select' )
                    // InternalAle.g:1301:3: 'select'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getSelectKeyword_0()); 
                    }
                    match(input,27,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getSelectKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1306:2: ( 'reject' )
                    {
                    // InternalAle.g:1306:2: ( 'reject' )
                    // InternalAle.g:1307:3: 'reject'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getRejectKeyword_1()); 
                    }
                    match(input,28,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getRejectKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1312:2: ( 'collect' )
                    {
                    // InternalAle.g:1312:2: ( 'collect' )
                    // InternalAle.g:1313:3: 'collect'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getCollectKeyword_2()); 
                    }
                    match(input,29,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getCollectKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1318:2: ( 'any' )
                    {
                    // InternalAle.g:1318:2: ( 'any' )
                    // InternalAle.g:1319:3: 'any'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getAnyKeyword_3()); 
                    }
                    match(input,30,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getAnyKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1324:2: ( 'exists' )
                    {
                    // InternalAle.g:1324:2: ( 'exists' )
                    // InternalAle.g:1325:3: 'exists'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getExistsKeyword_4()); 
                    }
                    match(input,31,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getExistsKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1330:2: ( 'forAll' )
                    {
                    // InternalAle.g:1330:2: ( 'forAll' )
                    // InternalAle.g:1331:3: 'forAll'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getForAllKeyword_5()); 
                    }
                    match(input,32,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getForAllKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:1336:2: ( 'isUnique' )
                    {
                    // InternalAle.g:1336:2: ( 'isUnique' )
                    // InternalAle.g:1337:3: 'isUnique'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getIsUniqueKeyword_6()); 
                    }
                    match(input,33,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getIsUniqueKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:1342:2: ( 'one' )
                    {
                    // InternalAle.g:1342:2: ( 'one' )
                    // InternalAle.g:1343:3: 'one'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getOneKeyword_7()); 
                    }
                    match(input,34,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getOneKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalAle.g:1348:2: ( 'sortedBy' )
                    {
                    // InternalAle.g:1348:2: ( 'sortedBy' )
                    // InternalAle.g:1349:3: 'sortedBy'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getSortedByKeyword_8()); 
                    }
                    match(input,35,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionIteratorAccess().getSortedByKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalAle.g:1354:2: ( 'closure' )
                    {
                    // InternalAle.g:1354:2: ( 'closure' )
                    // InternalAle.g:1355:3: 'closure'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionIteratorAccess().getClosureKeyword_9()); 
                    }
                    match(input,36,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:1364:1: rule__Literal__Alternatives : ( ( RULE_STRING ) | ( RULE_INT ) | ( RULE_REAL ) | ( 'true' ) | ( 'false' ) | ( 'null' ) | ( ( rule__Literal__Group_6__0 ) ) | ( ( rule__Literal__Group_7__0 ) ) | ( ( rule__Literal__Group_8__0 ) ) | ( ( rule__Literal__Group_9__0 ) ) | ( ruletypeLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1368:1: ( ( RULE_STRING ) | ( RULE_INT ) | ( RULE_REAL ) | ( 'true' ) | ( 'false' ) | ( 'null' ) | ( ( rule__Literal__Group_6__0 ) ) | ( ( rule__Literal__Group_7__0 ) ) | ( ( rule__Literal__Group_8__0 ) ) | ( ( rule__Literal__Group_9__0 ) ) | ( ruletypeLiteral ) )
            int alt13=11;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalAle.g:1369:2: ( RULE_STRING )
                    {
                    // InternalAle.g:1369:2: ( RULE_STRING )
                    // InternalAle.g:1370:3: RULE_STRING
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
                    // InternalAle.g:1375:2: ( RULE_INT )
                    {
                    // InternalAle.g:1375:2: ( RULE_INT )
                    // InternalAle.g:1376:3: RULE_INT
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
                    // InternalAle.g:1381:2: ( RULE_REAL )
                    {
                    // InternalAle.g:1381:2: ( RULE_REAL )
                    // InternalAle.g:1382:3: RULE_REAL
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getRealTerminalRuleCall_2()); 
                    }
                    match(input,RULE_REAL,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getRealTerminalRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1387:2: ( 'true' )
                    {
                    // InternalAle.g:1387:2: ( 'true' )
                    // InternalAle.g:1388:3: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getTrueKeyword_3()); 
                    }
                    match(input,37,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getTrueKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1393:2: ( 'false' )
                    {
                    // InternalAle.g:1393:2: ( 'false' )
                    // InternalAle.g:1394:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getFalseKeyword_4()); 
                    }
                    match(input,38,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getFalseKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1399:2: ( 'null' )
                    {
                    // InternalAle.g:1399:2: ( 'null' )
                    // InternalAle.g:1400:3: 'null'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getNullKeyword_5()); 
                    }
                    match(input,39,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getNullKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalAle.g:1405:2: ( ( rule__Literal__Group_6__0 ) )
                    {
                    // InternalAle.g:1405:2: ( ( rule__Literal__Group_6__0 ) )
                    // InternalAle.g:1406:3: ( rule__Literal__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_6()); 
                    }
                    // InternalAle.g:1407:3: ( rule__Literal__Group_6__0 )
                    // InternalAle.g:1407:4: rule__Literal__Group_6__0
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
                    // InternalAle.g:1411:2: ( ( rule__Literal__Group_7__0 ) )
                    {
                    // InternalAle.g:1411:2: ( ( rule__Literal__Group_7__0 ) )
                    // InternalAle.g:1412:3: ( rule__Literal__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_7()); 
                    }
                    // InternalAle.g:1413:3: ( rule__Literal__Group_7__0 )
                    // InternalAle.g:1413:4: rule__Literal__Group_7__0
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
                    // InternalAle.g:1417:2: ( ( rule__Literal__Group_8__0 ) )
                    {
                    // InternalAle.g:1417:2: ( ( rule__Literal__Group_8__0 ) )
                    // InternalAle.g:1418:3: ( rule__Literal__Group_8__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_8()); 
                    }
                    // InternalAle.g:1419:3: ( rule__Literal__Group_8__0 )
                    // InternalAle.g:1419:4: rule__Literal__Group_8__0
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
                    // InternalAle.g:1423:2: ( ( rule__Literal__Group_9__0 ) )
                    {
                    // InternalAle.g:1423:2: ( ( rule__Literal__Group_9__0 ) )
                    // InternalAle.g:1424:3: ( rule__Literal__Group_9__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_9()); 
                    }
                    // InternalAle.g:1425:3: ( rule__Literal__Group_9__0 )
                    // InternalAle.g:1425:4: rule__Literal__Group_9__0
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
                    // InternalAle.g:1429:2: ( ruletypeLiteral )
                    {
                    // InternalAle.g:1429:2: ( ruletypeLiteral )
                    // InternalAle.g:1430:3: ruletypeLiteral
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
    // InternalAle.g:1439:1: rule__TypeLiteral__Alternatives : ( ( 'String' ) | ( 'Integer' ) | ( 'Real' ) | ( 'Boolean' ) | ( ( rule__TypeLiteral__Group_4__0 ) ) | ( ( rule__TypeLiteral__Group_5__0 ) ) | ( ruleclassifierTypeRule ) | ( ( rule__TypeLiteral__Group_7__0 ) ) );
    public final void rule__TypeLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1443:1: ( ( 'String' ) | ( 'Integer' ) | ( 'Real' ) | ( 'Boolean' ) | ( ( rule__TypeLiteral__Group_4__0 ) ) | ( ( rule__TypeLiteral__Group_5__0 ) ) | ( ruleclassifierTypeRule ) | ( ( rule__TypeLiteral__Group_7__0 ) ) )
            int alt14=8;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt14=1;
                }
                break;
            case 41:
                {
                alt14=2;
                }
                break;
            case 42:
                {
                alt14=3;
                }
                break;
            case 43:
                {
                alt14=4;
                }
                break;
            case 82:
                {
                alt14=5;
                }
                break;
            case 83:
                {
                alt14=6;
                }
                break;
            case RULE_IDENT:
                {
                alt14=7;
                }
                break;
            case 52:
                {
                alt14=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalAle.g:1444:2: ( 'String' )
                    {
                    // InternalAle.g:1444:2: ( 'String' )
                    // InternalAle.g:1445:3: 'String'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getStringKeyword_0()); 
                    }
                    match(input,40,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getStringKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1450:2: ( 'Integer' )
                    {
                    // InternalAle.g:1450:2: ( 'Integer' )
                    // InternalAle.g:1451:3: 'Integer'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getIntegerKeyword_1()); 
                    }
                    match(input,41,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getIntegerKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1456:2: ( 'Real' )
                    {
                    // InternalAle.g:1456:2: ( 'Real' )
                    // InternalAle.g:1457:3: 'Real'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getRealKeyword_2()); 
                    }
                    match(input,42,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getRealKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1462:2: ( 'Boolean' )
                    {
                    // InternalAle.g:1462:2: ( 'Boolean' )
                    // InternalAle.g:1463:3: 'Boolean'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getBooleanKeyword_3()); 
                    }
                    match(input,43,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getBooleanKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1468:2: ( ( rule__TypeLiteral__Group_4__0 ) )
                    {
                    // InternalAle.g:1468:2: ( ( rule__TypeLiteral__Group_4__0 ) )
                    // InternalAle.g:1469:3: ( rule__TypeLiteral__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_4()); 
                    }
                    // InternalAle.g:1470:3: ( rule__TypeLiteral__Group_4__0 )
                    // InternalAle.g:1470:4: rule__TypeLiteral__Group_4__0
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
                    // InternalAle.g:1474:2: ( ( rule__TypeLiteral__Group_5__0 ) )
                    {
                    // InternalAle.g:1474:2: ( ( rule__TypeLiteral__Group_5__0 ) )
                    // InternalAle.g:1475:3: ( rule__TypeLiteral__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_5()); 
                    }
                    // InternalAle.g:1476:3: ( rule__TypeLiteral__Group_5__0 )
                    // InternalAle.g:1476:4: rule__TypeLiteral__Group_5__0
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
                    // InternalAle.g:1480:2: ( ruleclassifierTypeRule )
                    {
                    // InternalAle.g:1480:2: ( ruleclassifierTypeRule )
                    // InternalAle.g:1481:3: ruleclassifierTypeRule
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_6()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleclassifierTypeRule();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalAle.g:1486:2: ( ( rule__TypeLiteral__Group_7__0 ) )
                    {
                    // InternalAle.g:1486:2: ( ( rule__TypeLiteral__Group_7__0 ) )
                    // InternalAle.g:1487:3: ( rule__TypeLiteral__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_7()); 
                    }
                    // InternalAle.g:1488:3: ( rule__TypeLiteral__Group_7__0 )
                    // InternalAle.g:1488:4: rule__TypeLiteral__Group_7__0
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
    // InternalAle.g:1496:1: rule__ClassifierTypeRule__Alternatives : ( ( ( rule__ClassifierTypeRule__Group_0__0 ) ) | ( ( rule__ClassifierTypeRule__Group_1__0 ) ) );
    public final void rule__ClassifierTypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1500:1: ( ( ( rule__ClassifierTypeRule__Group_0__0 ) ) | ( ( rule__ClassifierTypeRule__Group_1__0 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_IDENT) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==77) ) {
                    alt15=2;
                }
                else if ( (LA15_1==81) ) {
                    alt15=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalAle.g:1501:2: ( ( rule__ClassifierTypeRule__Group_0__0 ) )
                    {
                    // InternalAle.g:1501:2: ( ( rule__ClassifierTypeRule__Group_0__0 ) )
                    // InternalAle.g:1502:3: ( rule__ClassifierTypeRule__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassifierTypeRuleAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1503:3: ( rule__ClassifierTypeRule__Group_0__0 )
                    // InternalAle.g:1503:4: rule__ClassifierTypeRule__Group_0__0
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
                    // InternalAle.g:1507:2: ( ( rule__ClassifierTypeRule__Group_1__0 ) )
                    {
                    // InternalAle.g:1507:2: ( ( rule__ClassifierTypeRule__Group_1__0 ) )
                    // InternalAle.g:1508:3: ( rule__ClassifierTypeRule__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassifierTypeRuleAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1509:3: ( rule__ClassifierTypeRule__Group_1__0 )
                    // InternalAle.g:1509:4: rule__ClassifierTypeRule__Group_1__0
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
    // InternalAle.g:1517:1: rule__RType__Alternatives : ( ( rulerQualified ) | ( ruletypeLiteral ) );
    public final void rule__RType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1521:1: ( ( rulerQualified ) | ( ruletypeLiteral ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_IDENT) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==77||LA16_1==81) ) {
                    alt16=2;
                }
                else if ( (LA16_1==EOF||LA16_1==RULE_IDENT||LA16_1==49) ) {
                    alt16=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA16_0>=40 && LA16_0<=43)||LA16_0==52||(LA16_0>=82 && LA16_0<=83)) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalAle.g:1522:2: ( rulerQualified )
                    {
                    // InternalAle.g:1522:2: ( rulerQualified )
                    // InternalAle.g:1523:3: rulerQualified
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
                    // InternalAle.g:1528:2: ( ruletypeLiteral )
                    {
                    // InternalAle.g:1528:2: ( ruletypeLiteral )
                    // InternalAle.g:1529:3: ruletypeLiteral
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
    // InternalAle.g:1538:1: rule__RRoot__Group__0 : rule__RRoot__Group__0__Impl rule__RRoot__Group__1 ;
    public final void rule__RRoot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1542:1: ( rule__RRoot__Group__0__Impl rule__RRoot__Group__1 )
            // InternalAle.g:1543:2: rule__RRoot__Group__0__Impl rule__RRoot__Group__1
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
    // InternalAle.g:1550:1: rule__RRoot__Group__0__Impl : ( 'behavior' ) ;
    public final void rule__RRoot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1554:1: ( ( 'behavior' ) )
            // InternalAle.g:1555:1: ( 'behavior' )
            {
            // InternalAle.g:1555:1: ( 'behavior' )
            // InternalAle.g:1556:2: 'behavior'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getBehaviorKeyword_0()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:1565:1: rule__RRoot__Group__1 : rule__RRoot__Group__1__Impl rule__RRoot__Group__2 ;
    public final void rule__RRoot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1569:1: ( rule__RRoot__Group__1__Impl rule__RRoot__Group__2 )
            // InternalAle.g:1570:2: rule__RRoot__Group__1__Impl rule__RRoot__Group__2
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
    // InternalAle.g:1577:1: rule__RRoot__Group__1__Impl : ( rulerQualified ) ;
    public final void rule__RRoot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1581:1: ( ( rulerQualified ) )
            // InternalAle.g:1582:1: ( rulerQualified )
            {
            // InternalAle.g:1582:1: ( rulerQualified )
            // InternalAle.g:1583:2: rulerQualified
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
    // InternalAle.g:1592:1: rule__RRoot__Group__2 : rule__RRoot__Group__2__Impl rule__RRoot__Group__3 ;
    public final void rule__RRoot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1596:1: ( rule__RRoot__Group__2__Impl rule__RRoot__Group__3 )
            // InternalAle.g:1597:2: rule__RRoot__Group__2__Impl rule__RRoot__Group__3
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
    // InternalAle.g:1604:1: rule__RRoot__Group__2__Impl : ( ';' ) ;
    public final void rule__RRoot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1608:1: ( ( ';' ) )
            // InternalAle.g:1609:1: ( ';' )
            {
            // InternalAle.g:1609:1: ( ';' )
            // InternalAle.g:1610:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getSemicolonKeyword_2()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:1619:1: rule__RRoot__Group__3 : rule__RRoot__Group__3__Impl rule__RRoot__Group__4 ;
    public final void rule__RRoot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1623:1: ( rule__RRoot__Group__3__Impl rule__RRoot__Group__4 )
            // InternalAle.g:1624:2: rule__RRoot__Group__3__Impl rule__RRoot__Group__4
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
    // InternalAle.g:1631:1: rule__RRoot__Group__3__Impl : ( ( rulerImport )* ) ;
    public final void rule__RRoot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1635:1: ( ( ( rulerImport )* ) )
            // InternalAle.g:1636:1: ( ( rulerImport )* )
            {
            // InternalAle.g:1636:1: ( ( rulerImport )* )
            // InternalAle.g:1637:2: ( rulerImport )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getRImportParserRuleCall_3()); 
            }
            // InternalAle.g:1638:2: ( rulerImport )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==46) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalAle.g:1638:3: rulerImport
            	    {
            	    pushFollow(FOLLOW_6);
            	    rulerImport();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalAle.g:1646:1: rule__RRoot__Group__4 : rule__RRoot__Group__4__Impl rule__RRoot__Group__5 ;
    public final void rule__RRoot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1650:1: ( rule__RRoot__Group__4__Impl rule__RRoot__Group__5 )
            // InternalAle.g:1651:2: rule__RRoot__Group__4__Impl rule__RRoot__Group__5
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
    // InternalAle.g:1658:1: rule__RRoot__Group__4__Impl : ( ( rulerService )* ) ;
    public final void rule__RRoot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1662:1: ( ( ( rulerService )* ) )
            // InternalAle.g:1663:1: ( ( rulerService )* )
            {
            // InternalAle.g:1663:1: ( ( rulerService )* )
            // InternalAle.g:1664:2: ( rulerService )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getRServiceParserRuleCall_4()); 
            }
            // InternalAle.g:1665:2: ( rulerService )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==48) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalAle.g:1665:3: rulerService
            	    {
            	    pushFollow(FOLLOW_7);
            	    rulerService();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalAle.g:1673:1: rule__RRoot__Group__5 : rule__RRoot__Group__5__Impl ;
    public final void rule__RRoot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1677:1: ( rule__RRoot__Group__5__Impl )
            // InternalAle.g:1678:2: rule__RRoot__Group__5__Impl
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
    // InternalAle.g:1684:1: rule__RRoot__Group__5__Impl : ( ( rule__RRoot__XtendedClassesAssignment_5 )* ) ;
    public final void rule__RRoot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1688:1: ( ( ( rule__RRoot__XtendedClassesAssignment_5 )* ) )
            // InternalAle.g:1689:1: ( ( rule__RRoot__XtendedClassesAssignment_5 )* )
            {
            // InternalAle.g:1689:1: ( ( rule__RRoot__XtendedClassesAssignment_5 )* )
            // InternalAle.g:1690:2: ( rule__RRoot__XtendedClassesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getXtendedClassesAssignment_5()); 
            }
            // InternalAle.g:1691:2: ( rule__RRoot__XtendedClassesAssignment_5 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=50 && LA19_0<=51)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalAle.g:1691:3: rule__RRoot__XtendedClassesAssignment_5
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__RRoot__XtendedClassesAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalAle.g:1700:1: rule__RImport__Group__0 : rule__RImport__Group__0__Impl rule__RImport__Group__1 ;
    public final void rule__RImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1704:1: ( rule__RImport__Group__0__Impl rule__RImport__Group__1 )
            // InternalAle.g:1705:2: rule__RImport__Group__0__Impl rule__RImport__Group__1
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
    // InternalAle.g:1712:1: rule__RImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__RImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1716:1: ( ( 'import' ) )
            // InternalAle.g:1717:1: ( 'import' )
            {
            // InternalAle.g:1717:1: ( 'import' )
            // InternalAle.g:1718:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getImportKeyword_0()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:1727:1: rule__RImport__Group__1 : rule__RImport__Group__1__Impl rule__RImport__Group__2 ;
    public final void rule__RImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1731:1: ( rule__RImport__Group__1__Impl rule__RImport__Group__2 )
            // InternalAle.g:1732:2: rule__RImport__Group__1__Impl rule__RImport__Group__2
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
    // InternalAle.g:1739:1: rule__RImport__Group__1__Impl : ( rulerQualified ) ;
    public final void rule__RImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1743:1: ( ( rulerQualified ) )
            // InternalAle.g:1744:1: ( rulerQualified )
            {
            // InternalAle.g:1744:1: ( rulerQualified )
            // InternalAle.g:1745:2: rulerQualified
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
    // InternalAle.g:1754:1: rule__RImport__Group__2 : rule__RImport__Group__2__Impl rule__RImport__Group__3 ;
    public final void rule__RImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1758:1: ( rule__RImport__Group__2__Impl rule__RImport__Group__3 )
            // InternalAle.g:1759:2: rule__RImport__Group__2__Impl rule__RImport__Group__3
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
    // InternalAle.g:1766:1: rule__RImport__Group__2__Impl : ( 'as' ) ;
    public final void rule__RImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1770:1: ( ( 'as' ) )
            // InternalAle.g:1771:1: ( 'as' )
            {
            // InternalAle.g:1771:1: ( 'as' )
            // InternalAle.g:1772:2: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getAsKeyword_2()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:1781:1: rule__RImport__Group__3 : rule__RImport__Group__3__Impl rule__RImport__Group__4 ;
    public final void rule__RImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1785:1: ( rule__RImport__Group__3__Impl rule__RImport__Group__4 )
            // InternalAle.g:1786:2: rule__RImport__Group__3__Impl rule__RImport__Group__4
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
    // InternalAle.g:1793:1: rule__RImport__Group__3__Impl : ( RULE_IDENT ) ;
    public final void rule__RImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1797:1: ( ( RULE_IDENT ) )
            // InternalAle.g:1798:1: ( RULE_IDENT )
            {
            // InternalAle.g:1798:1: ( RULE_IDENT )
            // InternalAle.g:1799:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getIdentTerminalRuleCall_3()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRImportAccess().getIdentTerminalRuleCall_3()); 
            }

            }


            }

        }
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
    // InternalAle.g:1808:1: rule__RImport__Group__4 : rule__RImport__Group__4__Impl ;
    public final void rule__RImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1812:1: ( rule__RImport__Group__4__Impl )
            // InternalAle.g:1813:2: rule__RImport__Group__4__Impl
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
    // InternalAle.g:1819:1: rule__RImport__Group__4__Impl : ( ';' ) ;
    public final void rule__RImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1823:1: ( ( ';' ) )
            // InternalAle.g:1824:1: ( ';' )
            {
            // InternalAle.g:1824:1: ( ';' )
            // InternalAle.g:1825:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRImportAccess().getSemicolonKeyword_4()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:1835:1: rule__RService__Group__0 : rule__RService__Group__0__Impl rule__RService__Group__1 ;
    public final void rule__RService__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1839:1: ( rule__RService__Group__0__Impl rule__RService__Group__1 )
            // InternalAle.g:1840:2: rule__RService__Group__0__Impl rule__RService__Group__1
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
    // InternalAle.g:1847:1: rule__RService__Group__0__Impl : ( 'use' ) ;
    public final void rule__RService__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1851:1: ( ( 'use' ) )
            // InternalAle.g:1852:1: ( 'use' )
            {
            // InternalAle.g:1852:1: ( 'use' )
            // InternalAle.g:1853:2: 'use'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getUseKeyword_0()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:1862:1: rule__RService__Group__1 : rule__RService__Group__1__Impl rule__RService__Group__2 ;
    public final void rule__RService__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1866:1: ( rule__RService__Group__1__Impl rule__RService__Group__2 )
            // InternalAle.g:1867:2: rule__RService__Group__1__Impl rule__RService__Group__2
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
    // InternalAle.g:1874:1: rule__RService__Group__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RService__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1878:1: ( ( RULE_IDENT ) )
            // InternalAle.g:1879:1: ( RULE_IDENT )
            {
            // InternalAle.g:1879:1: ( RULE_IDENT )
            // InternalAle.g:1880:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getIdentTerminalRuleCall_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceAccess().getIdentTerminalRuleCall_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:1889:1: rule__RService__Group__2 : rule__RService__Group__2__Impl rule__RService__Group__3 ;
    public final void rule__RService__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1893:1: ( rule__RService__Group__2__Impl rule__RService__Group__3 )
            // InternalAle.g:1894:2: rule__RService__Group__2__Impl rule__RService__Group__3
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
    // InternalAle.g:1901:1: rule__RService__Group__2__Impl : ( ( rule__RService__Group_2__0 )* ) ;
    public final void rule__RService__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1905:1: ( ( ( rule__RService__Group_2__0 )* ) )
            // InternalAle.g:1906:1: ( ( rule__RService__Group_2__0 )* )
            {
            // InternalAle.g:1906:1: ( ( rule__RService__Group_2__0 )* )
            // InternalAle.g:1907:2: ( rule__RService__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getGroup_2()); 
            }
            // InternalAle.g:1908:2: ( rule__RService__Group_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==49) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalAle.g:1908:3: rule__RService__Group_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__RService__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalAle.g:1916:1: rule__RService__Group__3 : rule__RService__Group__3__Impl ;
    public final void rule__RService__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1920:1: ( rule__RService__Group__3__Impl )
            // InternalAle.g:1921:2: rule__RService__Group__3__Impl
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
    // InternalAle.g:1927:1: rule__RService__Group__3__Impl : ( ';' ) ;
    public final void rule__RService__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1931:1: ( ( ';' ) )
            // InternalAle.g:1932:1: ( ';' )
            {
            // InternalAle.g:1932:1: ( ';' )
            // InternalAle.g:1933:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getSemicolonKeyword_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:1943:1: rule__RService__Group_2__0 : rule__RService__Group_2__0__Impl rule__RService__Group_2__1 ;
    public final void rule__RService__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1947:1: ( rule__RService__Group_2__0__Impl rule__RService__Group_2__1 )
            // InternalAle.g:1948:2: rule__RService__Group_2__0__Impl rule__RService__Group_2__1
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
    // InternalAle.g:1955:1: rule__RService__Group_2__0__Impl : ( '.' ) ;
    public final void rule__RService__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1959:1: ( ( '.' ) )
            // InternalAle.g:1960:1: ( '.' )
            {
            // InternalAle.g:1960:1: ( '.' )
            // InternalAle.g:1961:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getFullStopKeyword_2_0()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:1970:1: rule__RService__Group_2__1 : rule__RService__Group_2__1__Impl ;
    public final void rule__RService__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1974:1: ( rule__RService__Group_2__1__Impl )
            // InternalAle.g:1975:2: rule__RService__Group_2__1__Impl
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
    // InternalAle.g:1981:1: rule__RService__Group_2__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RService__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1985:1: ( ( RULE_IDENT ) )
            // InternalAle.g:1986:1: ( RULE_IDENT )
            {
            // InternalAle.g:1986:1: ( RULE_IDENT )
            // InternalAle.g:1987:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getIdentTerminalRuleCall_2_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRServiceAccess().getIdentTerminalRuleCall_2_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:1997:1: rule__RClass__Group_0__0 : rule__RClass__Group_0__0__Impl rule__RClass__Group_0__1 ;
    public final void rule__RClass__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2001:1: ( rule__RClass__Group_0__0__Impl rule__RClass__Group_0__1 )
            // InternalAle.g:2002:2: rule__RClass__Group_0__0__Impl rule__RClass__Group_0__1
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
    // InternalAle.g:2009:1: rule__RClass__Group_0__0__Impl : ( () ) ;
    public final void rule__RClass__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2013:1: ( ( () ) )
            // InternalAle.g:2014:1: ( () )
            {
            // InternalAle.g:2014:1: ( () )
            // InternalAle.g:2015:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getROpenClassAction_0_0()); 
            }
            // InternalAle.g:2016:2: ()
            // InternalAle.g:2016:3: 
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
    // InternalAle.g:2024:1: rule__RClass__Group_0__1 : rule__RClass__Group_0__1__Impl ;
    public final void rule__RClass__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2028:1: ( rule__RClass__Group_0__1__Impl )
            // InternalAle.g:2029:2: rule__RClass__Group_0__1__Impl
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
    // InternalAle.g:2035:1: rule__RClass__Group_0__1__Impl : ( ( rule__RClass__OpenClassAssignment_0_1 ) ) ;
    public final void rule__RClass__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2039:1: ( ( ( rule__RClass__OpenClassAssignment_0_1 ) ) )
            // InternalAle.g:2040:1: ( ( rule__RClass__OpenClassAssignment_0_1 ) )
            {
            // InternalAle.g:2040:1: ( ( rule__RClass__OpenClassAssignment_0_1 ) )
            // InternalAle.g:2041:2: ( rule__RClass__OpenClassAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getOpenClassAssignment_0_1()); 
            }
            // InternalAle.g:2042:2: ( rule__RClass__OpenClassAssignment_0_1 )
            // InternalAle.g:2042:3: rule__RClass__OpenClassAssignment_0_1
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
    // InternalAle.g:2051:1: rule__RClass__Group_1__0 : rule__RClass__Group_1__0__Impl rule__RClass__Group_1__1 ;
    public final void rule__RClass__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2055:1: ( rule__RClass__Group_1__0__Impl rule__RClass__Group_1__1 )
            // InternalAle.g:2056:2: rule__RClass__Group_1__0__Impl rule__RClass__Group_1__1
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
    // InternalAle.g:2063:1: rule__RClass__Group_1__0__Impl : ( () ) ;
    public final void rule__RClass__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2067:1: ( ( () ) )
            // InternalAle.g:2068:1: ( () )
            {
            // InternalAle.g:2068:1: ( () )
            // InternalAle.g:2069:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getRNewClassAction_1_0()); 
            }
            // InternalAle.g:2070:2: ()
            // InternalAle.g:2070:3: 
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
    // InternalAle.g:2078:1: rule__RClass__Group_1__1 : rule__RClass__Group_1__1__Impl ;
    public final void rule__RClass__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2082:1: ( rule__RClass__Group_1__1__Impl )
            // InternalAle.g:2083:2: rule__RClass__Group_1__1__Impl
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
    // InternalAle.g:2089:1: rule__RClass__Group_1__1__Impl : ( ( rule__RClass__NewClassAssignment_1_1 ) ) ;
    public final void rule__RClass__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2093:1: ( ( ( rule__RClass__NewClassAssignment_1_1 ) ) )
            // InternalAle.g:2094:1: ( ( rule__RClass__NewClassAssignment_1_1 ) )
            {
            // InternalAle.g:2094:1: ( ( rule__RClass__NewClassAssignment_1_1 ) )
            // InternalAle.g:2095:2: ( rule__RClass__NewClassAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRClassAccess().getNewClassAssignment_1_1()); 
            }
            // InternalAle.g:2096:2: ( rule__RClass__NewClassAssignment_1_1 )
            // InternalAle.g:2096:3: rule__RClass__NewClassAssignment_1_1
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
    // InternalAle.g:2105:1: rule__ROpenClass__Group__0 : rule__ROpenClass__Group__0__Impl rule__ROpenClass__Group__1 ;
    public final void rule__ROpenClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2109:1: ( rule__ROpenClass__Group__0__Impl rule__ROpenClass__Group__1 )
            // InternalAle.g:2110:2: rule__ROpenClass__Group__0__Impl rule__ROpenClass__Group__1
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
    // InternalAle.g:2117:1: rule__ROpenClass__Group__0__Impl : ( 'open' ) ;
    public final void rule__ROpenClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2121:1: ( ( 'open' ) )
            // InternalAle.g:2122:1: ( 'open' )
            {
            // InternalAle.g:2122:1: ( 'open' )
            // InternalAle.g:2123:2: 'open'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getOpenKeyword_0()); 
            }
            match(input,50,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2132:1: rule__ROpenClass__Group__1 : rule__ROpenClass__Group__1__Impl rule__ROpenClass__Group__2 ;
    public final void rule__ROpenClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2136:1: ( rule__ROpenClass__Group__1__Impl rule__ROpenClass__Group__2 )
            // InternalAle.g:2137:2: rule__ROpenClass__Group__1__Impl rule__ROpenClass__Group__2
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
    // InternalAle.g:2144:1: rule__ROpenClass__Group__1__Impl : ( 'class' ) ;
    public final void rule__ROpenClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2148:1: ( ( 'class' ) )
            // InternalAle.g:2149:1: ( 'class' )
            {
            // InternalAle.g:2149:1: ( 'class' )
            // InternalAle.g:2150:2: 'class'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getClassKeyword_1()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2159:1: rule__ROpenClass__Group__2 : rule__ROpenClass__Group__2__Impl rule__ROpenClass__Group__3 ;
    public final void rule__ROpenClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2163:1: ( rule__ROpenClass__Group__2__Impl rule__ROpenClass__Group__3 )
            // InternalAle.g:2164:2: rule__ROpenClass__Group__2__Impl rule__ROpenClass__Group__3
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
    // InternalAle.g:2171:1: rule__ROpenClass__Group__2__Impl : ( ( rule__ROpenClass__NameAssignment_2 ) ) ;
    public final void rule__ROpenClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2175:1: ( ( ( rule__ROpenClass__NameAssignment_2 ) ) )
            // InternalAle.g:2176:1: ( ( rule__ROpenClass__NameAssignment_2 ) )
            {
            // InternalAle.g:2176:1: ( ( rule__ROpenClass__NameAssignment_2 ) )
            // InternalAle.g:2177:2: ( rule__ROpenClass__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getNameAssignment_2()); 
            }
            // InternalAle.g:2178:2: ( rule__ROpenClass__NameAssignment_2 )
            // InternalAle.g:2178:3: rule__ROpenClass__NameAssignment_2
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
    // InternalAle.g:2186:1: rule__ROpenClass__Group__3 : rule__ROpenClass__Group__3__Impl rule__ROpenClass__Group__4 ;
    public final void rule__ROpenClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2190:1: ( rule__ROpenClass__Group__3__Impl rule__ROpenClass__Group__4 )
            // InternalAle.g:2191:2: rule__ROpenClass__Group__3__Impl rule__ROpenClass__Group__4
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
    // InternalAle.g:2198:1: rule__ROpenClass__Group__3__Impl : ( ( rule__ROpenClass__Group_3__0 )? ) ;
    public final void rule__ROpenClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2202:1: ( ( ( rule__ROpenClass__Group_3__0 )? ) )
            // InternalAle.g:2203:1: ( ( rule__ROpenClass__Group_3__0 )? )
            {
            // InternalAle.g:2203:1: ( ( rule__ROpenClass__Group_3__0 )? )
            // InternalAle.g:2204:2: ( rule__ROpenClass__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getGroup_3()); 
            }
            // InternalAle.g:2205:2: ( rule__ROpenClass__Group_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==54) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalAle.g:2205:3: rule__ROpenClass__Group_3__0
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
    // InternalAle.g:2213:1: rule__ROpenClass__Group__4 : rule__ROpenClass__Group__4__Impl rule__ROpenClass__Group__5 ;
    public final void rule__ROpenClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2217:1: ( rule__ROpenClass__Group__4__Impl rule__ROpenClass__Group__5 )
            // InternalAle.g:2218:2: rule__ROpenClass__Group__4__Impl rule__ROpenClass__Group__5
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
    // InternalAle.g:2225:1: rule__ROpenClass__Group__4__Impl : ( '{' ) ;
    public final void rule__ROpenClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2229:1: ( ( '{' ) )
            // InternalAle.g:2230:1: ( '{' )
            {
            // InternalAle.g:2230:1: ( '{' )
            // InternalAle.g:2231:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2240:1: rule__ROpenClass__Group__5 : rule__ROpenClass__Group__5__Impl rule__ROpenClass__Group__6 ;
    public final void rule__ROpenClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2244:1: ( rule__ROpenClass__Group__5__Impl rule__ROpenClass__Group__6 )
            // InternalAle.g:2245:2: rule__ROpenClass__Group__5__Impl rule__ROpenClass__Group__6
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
    // InternalAle.g:2252:1: rule__ROpenClass__Group__5__Impl : ( ( rule__ROpenClass__AttributesAssignment_5 )* ) ;
    public final void rule__ROpenClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2256:1: ( ( ( rule__ROpenClass__AttributesAssignment_5 )* ) )
            // InternalAle.g:2257:1: ( ( rule__ROpenClass__AttributesAssignment_5 )* )
            {
            // InternalAle.g:2257:1: ( ( rule__ROpenClass__AttributesAssignment_5 )* )
            // InternalAle.g:2258:2: ( rule__ROpenClass__AttributesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getAttributesAssignment_5()); 
            }
            // InternalAle.g:2259:2: ( rule__ROpenClass__AttributesAssignment_5 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_IDENT||(LA22_0>=40 && LA22_0<=43)||LA22_0==52||(LA22_0>=82 && LA22_0<=83)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalAle.g:2259:3: rule__ROpenClass__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__ROpenClass__AttributesAssignment_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalAle.g:2267:1: rule__ROpenClass__Group__6 : rule__ROpenClass__Group__6__Impl rule__ROpenClass__Group__7 ;
    public final void rule__ROpenClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2271:1: ( rule__ROpenClass__Group__6__Impl rule__ROpenClass__Group__7 )
            // InternalAle.g:2272:2: rule__ROpenClass__Group__6__Impl rule__ROpenClass__Group__7
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
    // InternalAle.g:2279:1: rule__ROpenClass__Group__6__Impl : ( ( rule__ROpenClass__OperationsAssignment_6 )* ) ;
    public final void rule__ROpenClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2283:1: ( ( ( rule__ROpenClass__OperationsAssignment_6 )* ) )
            // InternalAle.g:2284:1: ( ( rule__ROpenClass__OperationsAssignment_6 )* )
            {
            // InternalAle.g:2284:1: ( ( rule__ROpenClass__OperationsAssignment_6 )* )
            // InternalAle.g:2285:2: ( rule__ROpenClass__OperationsAssignment_6 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getOperationsAssignment_6()); 
            }
            // InternalAle.g:2286:2: ( rule__ROpenClass__OperationsAssignment_6 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=15 && LA23_0<=16)||LA23_0==58) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalAle.g:2286:3: rule__ROpenClass__OperationsAssignment_6
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__ROpenClass__OperationsAssignment_6();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalAle.g:2294:1: rule__ROpenClass__Group__7 : rule__ROpenClass__Group__7__Impl ;
    public final void rule__ROpenClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2298:1: ( rule__ROpenClass__Group__7__Impl )
            // InternalAle.g:2299:2: rule__ROpenClass__Group__7__Impl
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
    // InternalAle.g:2305:1: rule__ROpenClass__Group__7__Impl : ( '}' ) ;
    public final void rule__ROpenClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2309:1: ( ( '}' ) )
            // InternalAle.g:2310:1: ( '}' )
            {
            // InternalAle.g:2310:1: ( '}' )
            // InternalAle.g:2311:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getRightCurlyBracketKeyword_7()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2321:1: rule__ROpenClass__Group_3__0 : rule__ROpenClass__Group_3__0__Impl rule__ROpenClass__Group_3__1 ;
    public final void rule__ROpenClass__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2325:1: ( rule__ROpenClass__Group_3__0__Impl rule__ROpenClass__Group_3__1 )
            // InternalAle.g:2326:2: rule__ROpenClass__Group_3__0__Impl rule__ROpenClass__Group_3__1
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
    // InternalAle.g:2333:1: rule__ROpenClass__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__ROpenClass__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2337:1: ( ( 'extends' ) )
            // InternalAle.g:2338:1: ( 'extends' )
            {
            // InternalAle.g:2338:1: ( 'extends' )
            // InternalAle.g:2339:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getExtendsKeyword_3_0()); 
            }
            match(input,54,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2348:1: rule__ROpenClass__Group_3__1 : rule__ROpenClass__Group_3__1__Impl rule__ROpenClass__Group_3__2 ;
    public final void rule__ROpenClass__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2352:1: ( rule__ROpenClass__Group_3__1__Impl rule__ROpenClass__Group_3__2 )
            // InternalAle.g:2353:2: rule__ROpenClass__Group_3__1__Impl rule__ROpenClass__Group_3__2
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
    // InternalAle.g:2360:1: rule__ROpenClass__Group_3__1__Impl : ( rulerQualified ) ;
    public final void rule__ROpenClass__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2364:1: ( ( rulerQualified ) )
            // InternalAle.g:2365:1: ( rulerQualified )
            {
            // InternalAle.g:2365:1: ( rulerQualified )
            // InternalAle.g:2366:2: rulerQualified
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
    // InternalAle.g:2375:1: rule__ROpenClass__Group_3__2 : rule__ROpenClass__Group_3__2__Impl ;
    public final void rule__ROpenClass__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2379:1: ( rule__ROpenClass__Group_3__2__Impl )
            // InternalAle.g:2380:2: rule__ROpenClass__Group_3__2__Impl
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
    // InternalAle.g:2386:1: rule__ROpenClass__Group_3__2__Impl : ( ( rule__ROpenClass__Group_3_2__0 )* ) ;
    public final void rule__ROpenClass__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2390:1: ( ( ( rule__ROpenClass__Group_3_2__0 )* ) )
            // InternalAle.g:2391:1: ( ( rule__ROpenClass__Group_3_2__0 )* )
            {
            // InternalAle.g:2391:1: ( ( rule__ROpenClass__Group_3_2__0 )* )
            // InternalAle.g:2392:2: ( rule__ROpenClass__Group_3_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getGroup_3_2()); 
            }
            // InternalAle.g:2393:2: ( rule__ROpenClass__Group_3_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==55) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalAle.g:2393:3: rule__ROpenClass__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__ROpenClass__Group_3_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalAle.g:2402:1: rule__ROpenClass__Group_3_2__0 : rule__ROpenClass__Group_3_2__0__Impl rule__ROpenClass__Group_3_2__1 ;
    public final void rule__ROpenClass__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2406:1: ( rule__ROpenClass__Group_3_2__0__Impl rule__ROpenClass__Group_3_2__1 )
            // InternalAle.g:2407:2: rule__ROpenClass__Group_3_2__0__Impl rule__ROpenClass__Group_3_2__1
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
    // InternalAle.g:2414:1: rule__ROpenClass__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__ROpenClass__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2418:1: ( ( ',' ) )
            // InternalAle.g:2419:1: ( ',' )
            {
            // InternalAle.g:2419:1: ( ',' )
            // InternalAle.g:2420:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2429:1: rule__ROpenClass__Group_3_2__1 : rule__ROpenClass__Group_3_2__1__Impl ;
    public final void rule__ROpenClass__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2433:1: ( rule__ROpenClass__Group_3_2__1__Impl )
            // InternalAle.g:2434:2: rule__ROpenClass__Group_3_2__1__Impl
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
    // InternalAle.g:2440:1: rule__ROpenClass__Group_3_2__1__Impl : ( rulerQualified ) ;
    public final void rule__ROpenClass__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2444:1: ( ( rulerQualified ) )
            // InternalAle.g:2445:1: ( rulerQualified )
            {
            // InternalAle.g:2445:1: ( rulerQualified )
            // InternalAle.g:2446:2: rulerQualified
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
    // InternalAle.g:2456:1: rule__RNewClass__Group__0 : rule__RNewClass__Group__0__Impl rule__RNewClass__Group__1 ;
    public final void rule__RNewClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2460:1: ( rule__RNewClass__Group__0__Impl rule__RNewClass__Group__1 )
            // InternalAle.g:2461:2: rule__RNewClass__Group__0__Impl rule__RNewClass__Group__1
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
    // InternalAle.g:2468:1: rule__RNewClass__Group__0__Impl : ( 'class' ) ;
    public final void rule__RNewClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2472:1: ( ( 'class' ) )
            // InternalAle.g:2473:1: ( 'class' )
            {
            // InternalAle.g:2473:1: ( 'class' )
            // InternalAle.g:2474:2: 'class'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getClassKeyword_0()); 
            }
            match(input,51,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2483:1: rule__RNewClass__Group__1 : rule__RNewClass__Group__1__Impl rule__RNewClass__Group__2 ;
    public final void rule__RNewClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2487:1: ( rule__RNewClass__Group__1__Impl rule__RNewClass__Group__2 )
            // InternalAle.g:2488:2: rule__RNewClass__Group__1__Impl rule__RNewClass__Group__2
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
    // InternalAle.g:2495:1: rule__RNewClass__Group__1__Impl : ( ( rule__RNewClass__NameAssignment_1 ) ) ;
    public final void rule__RNewClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2499:1: ( ( ( rule__RNewClass__NameAssignment_1 ) ) )
            // InternalAle.g:2500:1: ( ( rule__RNewClass__NameAssignment_1 ) )
            {
            // InternalAle.g:2500:1: ( ( rule__RNewClass__NameAssignment_1 ) )
            // InternalAle.g:2501:2: ( rule__RNewClass__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getNameAssignment_1()); 
            }
            // InternalAle.g:2502:2: ( rule__RNewClass__NameAssignment_1 )
            // InternalAle.g:2502:3: rule__RNewClass__NameAssignment_1
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
    // InternalAle.g:2510:1: rule__RNewClass__Group__2 : rule__RNewClass__Group__2__Impl rule__RNewClass__Group__3 ;
    public final void rule__RNewClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2514:1: ( rule__RNewClass__Group__2__Impl rule__RNewClass__Group__3 )
            // InternalAle.g:2515:2: rule__RNewClass__Group__2__Impl rule__RNewClass__Group__3
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
    // InternalAle.g:2522:1: rule__RNewClass__Group__2__Impl : ( '{' ) ;
    public final void rule__RNewClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2526:1: ( ( '{' ) )
            // InternalAle.g:2527:1: ( '{' )
            {
            // InternalAle.g:2527:1: ( '{' )
            // InternalAle.g:2528:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2537:1: rule__RNewClass__Group__3 : rule__RNewClass__Group__3__Impl rule__RNewClass__Group__4 ;
    public final void rule__RNewClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2541:1: ( rule__RNewClass__Group__3__Impl rule__RNewClass__Group__4 )
            // InternalAle.g:2542:2: rule__RNewClass__Group__3__Impl rule__RNewClass__Group__4
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
    // InternalAle.g:2549:1: rule__RNewClass__Group__3__Impl : ( ( rule__RNewClass__AttributesAssignment_3 )* ) ;
    public final void rule__RNewClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2553:1: ( ( ( rule__RNewClass__AttributesAssignment_3 )* ) )
            // InternalAle.g:2554:1: ( ( rule__RNewClass__AttributesAssignment_3 )* )
            {
            // InternalAle.g:2554:1: ( ( rule__RNewClass__AttributesAssignment_3 )* )
            // InternalAle.g:2555:2: ( rule__RNewClass__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getAttributesAssignment_3()); 
            }
            // InternalAle.g:2556:2: ( rule__RNewClass__AttributesAssignment_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_IDENT||(LA25_0>=40 && LA25_0<=43)||LA25_0==52||(LA25_0>=82 && LA25_0<=83)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalAle.g:2556:3: rule__RNewClass__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__RNewClass__AttributesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalAle.g:2564:1: rule__RNewClass__Group__4 : rule__RNewClass__Group__4__Impl rule__RNewClass__Group__5 ;
    public final void rule__RNewClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2568:1: ( rule__RNewClass__Group__4__Impl rule__RNewClass__Group__5 )
            // InternalAle.g:2569:2: rule__RNewClass__Group__4__Impl rule__RNewClass__Group__5
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
    // InternalAle.g:2576:1: rule__RNewClass__Group__4__Impl : ( ( rule__RNewClass__OperationsAssignment_4 )* ) ;
    public final void rule__RNewClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2580:1: ( ( ( rule__RNewClass__OperationsAssignment_4 )* ) )
            // InternalAle.g:2581:1: ( ( rule__RNewClass__OperationsAssignment_4 )* )
            {
            // InternalAle.g:2581:1: ( ( rule__RNewClass__OperationsAssignment_4 )* )
            // InternalAle.g:2582:2: ( rule__RNewClass__OperationsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getOperationsAssignment_4()); 
            }
            // InternalAle.g:2583:2: ( rule__RNewClass__OperationsAssignment_4 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=15 && LA26_0<=16)||LA26_0==58) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalAle.g:2583:3: rule__RNewClass__OperationsAssignment_4
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__RNewClass__OperationsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalAle.g:2591:1: rule__RNewClass__Group__5 : rule__RNewClass__Group__5__Impl ;
    public final void rule__RNewClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2595:1: ( rule__RNewClass__Group__5__Impl )
            // InternalAle.g:2596:2: rule__RNewClass__Group__5__Impl
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
    // InternalAle.g:2602:1: rule__RNewClass__Group__5__Impl : ( '}' ) ;
    public final void rule__RNewClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2606:1: ( ( '}' ) )
            // InternalAle.g:2607:1: ( '}' )
            {
            // InternalAle.g:2607:1: ( '}' )
            // InternalAle.g:2608:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2618:1: rule__ROperation__Group__0 : rule__ROperation__Group__0__Impl rule__ROperation__Group__1 ;
    public final void rule__ROperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2622:1: ( rule__ROperation__Group__0__Impl rule__ROperation__Group__1 )
            // InternalAle.g:2623:2: rule__ROperation__Group__0__Impl rule__ROperation__Group__1
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
    // InternalAle.g:2630:1: rule__ROperation__Group__0__Impl : ( ( rulerTag )* ) ;
    public final void rule__ROperation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2634:1: ( ( ( rulerTag )* ) )
            // InternalAle.g:2635:1: ( ( rulerTag )* )
            {
            // InternalAle.g:2635:1: ( ( rulerTag )* )
            // InternalAle.g:2636:2: ( rulerTag )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getRTagParserRuleCall_0()); 
            }
            // InternalAle.g:2637:2: ( rulerTag )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==58) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalAle.g:2637:3: rulerTag
            	    {
            	    pushFollow(FOLLOW_23);
            	    rulerTag();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalAle.g:2645:1: rule__ROperation__Group__1 : rule__ROperation__Group__1__Impl rule__ROperation__Group__2 ;
    public final void rule__ROperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2649:1: ( rule__ROperation__Group__1__Impl rule__ROperation__Group__2 )
            // InternalAle.g:2650:2: rule__ROperation__Group__1__Impl rule__ROperation__Group__2
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
    // InternalAle.g:2657:1: rule__ROperation__Group__1__Impl : ( ( rule__ROperation__Alternatives_1 ) ) ;
    public final void rule__ROperation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2661:1: ( ( ( rule__ROperation__Alternatives_1 ) ) )
            // InternalAle.g:2662:1: ( ( rule__ROperation__Alternatives_1 ) )
            {
            // InternalAle.g:2662:1: ( ( rule__ROperation__Alternatives_1 ) )
            // InternalAle.g:2663:2: ( rule__ROperation__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getAlternatives_1()); 
            }
            // InternalAle.g:2664:2: ( rule__ROperation__Alternatives_1 )
            // InternalAle.g:2664:3: rule__ROperation__Alternatives_1
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
    // InternalAle.g:2672:1: rule__ROperation__Group__2 : rule__ROperation__Group__2__Impl rule__ROperation__Group__3 ;
    public final void rule__ROperation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2676:1: ( rule__ROperation__Group__2__Impl rule__ROperation__Group__3 )
            // InternalAle.g:2677:2: rule__ROperation__Group__2__Impl rule__ROperation__Group__3
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
    // InternalAle.g:2684:1: rule__ROperation__Group__2__Impl : ( ( rule__ROperation__TypeAssignment_2 ) ) ;
    public final void rule__ROperation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2688:1: ( ( ( rule__ROperation__TypeAssignment_2 ) ) )
            // InternalAle.g:2689:1: ( ( rule__ROperation__TypeAssignment_2 ) )
            {
            // InternalAle.g:2689:1: ( ( rule__ROperation__TypeAssignment_2 ) )
            // InternalAle.g:2690:2: ( rule__ROperation__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getTypeAssignment_2()); 
            }
            // InternalAle.g:2691:2: ( rule__ROperation__TypeAssignment_2 )
            // InternalAle.g:2691:3: rule__ROperation__TypeAssignment_2
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
    // InternalAle.g:2699:1: rule__ROperation__Group__3 : rule__ROperation__Group__3__Impl rule__ROperation__Group__4 ;
    public final void rule__ROperation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2703:1: ( rule__ROperation__Group__3__Impl rule__ROperation__Group__4 )
            // InternalAle.g:2704:2: rule__ROperation__Group__3__Impl rule__ROperation__Group__4
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
    // InternalAle.g:2711:1: rule__ROperation__Group__3__Impl : ( ( rule__ROperation__NameAssignment_3 ) ) ;
    public final void rule__ROperation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2715:1: ( ( ( rule__ROperation__NameAssignment_3 ) ) )
            // InternalAle.g:2716:1: ( ( rule__ROperation__NameAssignment_3 ) )
            {
            // InternalAle.g:2716:1: ( ( rule__ROperation__NameAssignment_3 ) )
            // InternalAle.g:2717:2: ( rule__ROperation__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getNameAssignment_3()); 
            }
            // InternalAle.g:2718:2: ( rule__ROperation__NameAssignment_3 )
            // InternalAle.g:2718:3: rule__ROperation__NameAssignment_3
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
    // InternalAle.g:2726:1: rule__ROperation__Group__4 : rule__ROperation__Group__4__Impl rule__ROperation__Group__5 ;
    public final void rule__ROperation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2730:1: ( rule__ROperation__Group__4__Impl rule__ROperation__Group__5 )
            // InternalAle.g:2731:2: rule__ROperation__Group__4__Impl rule__ROperation__Group__5
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
    // InternalAle.g:2738:1: rule__ROperation__Group__4__Impl : ( '(' ) ;
    public final void rule__ROperation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2742:1: ( ( '(' ) )
            // InternalAle.g:2743:1: ( '(' )
            {
            // InternalAle.g:2743:1: ( '(' )
            // InternalAle.g:2744:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getLeftParenthesisKeyword_4()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2753:1: rule__ROperation__Group__5 : rule__ROperation__Group__5__Impl rule__ROperation__Group__6 ;
    public final void rule__ROperation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2757:1: ( rule__ROperation__Group__5__Impl rule__ROperation__Group__6 )
            // InternalAle.g:2758:2: rule__ROperation__Group__5__Impl rule__ROperation__Group__6
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
    // InternalAle.g:2765:1: rule__ROperation__Group__5__Impl : ( ( rule__ROperation__ParamListAssignment_5 )? ) ;
    public final void rule__ROperation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2769:1: ( ( ( rule__ROperation__ParamListAssignment_5 )? ) )
            // InternalAle.g:2770:1: ( ( rule__ROperation__ParamListAssignment_5 )? )
            {
            // InternalAle.g:2770:1: ( ( rule__ROperation__ParamListAssignment_5 )? )
            // InternalAle.g:2771:2: ( rule__ROperation__ParamListAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getParamListAssignment_5()); 
            }
            // InternalAle.g:2772:2: ( rule__ROperation__ParamListAssignment_5 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_IDENT||(LA28_0>=40 && LA28_0<=43)||LA28_0==52||(LA28_0>=82 && LA28_0<=83)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAle.g:2772:3: rule__ROperation__ParamListAssignment_5
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
    // InternalAle.g:2780:1: rule__ROperation__Group__6 : rule__ROperation__Group__6__Impl rule__ROperation__Group__7 ;
    public final void rule__ROperation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2784:1: ( rule__ROperation__Group__6__Impl rule__ROperation__Group__7 )
            // InternalAle.g:2785:2: rule__ROperation__Group__6__Impl rule__ROperation__Group__7
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
    // InternalAle.g:2792:1: rule__ROperation__Group__6__Impl : ( ')' ) ;
    public final void rule__ROperation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2796:1: ( ( ')' ) )
            // InternalAle.g:2797:1: ( ')' )
            {
            // InternalAle.g:2797:1: ( ')' )
            // InternalAle.g:2798:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2807:1: rule__ROperation__Group__7 : rule__ROperation__Group__7__Impl ;
    public final void rule__ROperation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2811:1: ( rule__ROperation__Group__7__Impl )
            // InternalAle.g:2812:2: rule__ROperation__Group__7__Impl
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
    // InternalAle.g:2818:1: rule__ROperation__Group__7__Impl : ( ( rule__ROperation__BodyAssignment_7 ) ) ;
    public final void rule__ROperation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2822:1: ( ( ( rule__ROperation__BodyAssignment_7 ) ) )
            // InternalAle.g:2823:1: ( ( rule__ROperation__BodyAssignment_7 ) )
            {
            // InternalAle.g:2823:1: ( ( rule__ROperation__BodyAssignment_7 ) )
            // InternalAle.g:2824:2: ( rule__ROperation__BodyAssignment_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getBodyAssignment_7()); 
            }
            // InternalAle.g:2825:2: ( rule__ROperation__BodyAssignment_7 )
            // InternalAle.g:2825:3: rule__ROperation__BodyAssignment_7
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
    // InternalAle.g:2834:1: rule__RTag__Group__0 : rule__RTag__Group__0__Impl rule__RTag__Group__1 ;
    public final void rule__RTag__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2838:1: ( rule__RTag__Group__0__Impl rule__RTag__Group__1 )
            // InternalAle.g:2839:2: rule__RTag__Group__0__Impl rule__RTag__Group__1
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
    // InternalAle.g:2846:1: rule__RTag__Group__0__Impl : ( '@' ) ;
    public final void rule__RTag__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2850:1: ( ( '@' ) )
            // InternalAle.g:2851:1: ( '@' )
            {
            // InternalAle.g:2851:1: ( '@' )
            // InternalAle.g:2852:2: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTagAccess().getCommercialAtKeyword_0()); 
            }
            match(input,58,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2861:1: rule__RTag__Group__1 : rule__RTag__Group__1__Impl ;
    public final void rule__RTag__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2865:1: ( rule__RTag__Group__1__Impl )
            // InternalAle.g:2866:2: rule__RTag__Group__1__Impl
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
    // InternalAle.g:2872:1: rule__RTag__Group__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RTag__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2876:1: ( ( RULE_IDENT ) )
            // InternalAle.g:2877:1: ( RULE_IDENT )
            {
            // InternalAle.g:2877:1: ( RULE_IDENT )
            // InternalAle.g:2878:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTagAccess().getIdentTerminalRuleCall_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRTagAccess().getIdentTerminalRuleCall_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:2888:1: rule__RParameters__Group__0 : rule__RParameters__Group__0__Impl rule__RParameters__Group__1 ;
    public final void rule__RParameters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2892:1: ( rule__RParameters__Group__0__Impl rule__RParameters__Group__1 )
            // InternalAle.g:2893:2: rule__RParameters__Group__0__Impl rule__RParameters__Group__1
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
    // InternalAle.g:2900:1: rule__RParameters__Group__0__Impl : ( ( rule__RParameters__ParamsAssignment_0 ) ) ;
    public final void rule__RParameters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2904:1: ( ( ( rule__RParameters__ParamsAssignment_0 ) ) )
            // InternalAle.g:2905:1: ( ( rule__RParameters__ParamsAssignment_0 ) )
            {
            // InternalAle.g:2905:1: ( ( rule__RParameters__ParamsAssignment_0 ) )
            // InternalAle.g:2906:2: ( rule__RParameters__ParamsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getParamsAssignment_0()); 
            }
            // InternalAle.g:2907:2: ( rule__RParameters__ParamsAssignment_0 )
            // InternalAle.g:2907:3: rule__RParameters__ParamsAssignment_0
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
    // InternalAle.g:2915:1: rule__RParameters__Group__1 : rule__RParameters__Group__1__Impl ;
    public final void rule__RParameters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2919:1: ( rule__RParameters__Group__1__Impl )
            // InternalAle.g:2920:2: rule__RParameters__Group__1__Impl
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
    // InternalAle.g:2926:1: rule__RParameters__Group__1__Impl : ( ( rule__RParameters__Group_1__0 )* ) ;
    public final void rule__RParameters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2930:1: ( ( ( rule__RParameters__Group_1__0 )* ) )
            // InternalAle.g:2931:1: ( ( rule__RParameters__Group_1__0 )* )
            {
            // InternalAle.g:2931:1: ( ( rule__RParameters__Group_1__0 )* )
            // InternalAle.g:2932:2: ( rule__RParameters__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getGroup_1()); 
            }
            // InternalAle.g:2933:2: ( rule__RParameters__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==55) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalAle.g:2933:3: rule__RParameters__Group_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__RParameters__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalAle.g:2942:1: rule__RParameters__Group_1__0 : rule__RParameters__Group_1__0__Impl rule__RParameters__Group_1__1 ;
    public final void rule__RParameters__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2946:1: ( rule__RParameters__Group_1__0__Impl rule__RParameters__Group_1__1 )
            // InternalAle.g:2947:2: rule__RParameters__Group_1__0__Impl rule__RParameters__Group_1__1
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
    // InternalAle.g:2954:1: rule__RParameters__Group_1__0__Impl : ( ',' ) ;
    public final void rule__RParameters__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2958:1: ( ( ',' ) )
            // InternalAle.g:2959:1: ( ',' )
            {
            // InternalAle.g:2959:1: ( ',' )
            // InternalAle.g:2960:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getCommaKeyword_1_0()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:2969:1: rule__RParameters__Group_1__1 : rule__RParameters__Group_1__1__Impl ;
    public final void rule__RParameters__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2973:1: ( rule__RParameters__Group_1__1__Impl )
            // InternalAle.g:2974:2: rule__RParameters__Group_1__1__Impl
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
    // InternalAle.g:2980:1: rule__RParameters__Group_1__1__Impl : ( ( rule__RParameters__ParamsAssignment_1_1 ) ) ;
    public final void rule__RParameters__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2984:1: ( ( ( rule__RParameters__ParamsAssignment_1_1 ) ) )
            // InternalAle.g:2985:1: ( ( rule__RParameters__ParamsAssignment_1_1 ) )
            {
            // InternalAle.g:2985:1: ( ( rule__RParameters__ParamsAssignment_1_1 ) )
            // InternalAle.g:2986:2: ( rule__RParameters__ParamsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getParamsAssignment_1_1()); 
            }
            // InternalAle.g:2987:2: ( rule__RParameters__ParamsAssignment_1_1 )
            // InternalAle.g:2987:3: rule__RParameters__ParamsAssignment_1_1
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
    // InternalAle.g:2996:1: rule__RVariable__Group__0 : rule__RVariable__Group__0__Impl rule__RVariable__Group__1 ;
    public final void rule__RVariable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3000:1: ( rule__RVariable__Group__0__Impl rule__RVariable__Group__1 )
            // InternalAle.g:3001:2: rule__RVariable__Group__0__Impl rule__RVariable__Group__1
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
    // InternalAle.g:3008:1: rule__RVariable__Group__0__Impl : ( ( rule__RVariable__TypeAssignment_0 ) ) ;
    public final void rule__RVariable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3012:1: ( ( ( rule__RVariable__TypeAssignment_0 ) ) )
            // InternalAle.g:3013:1: ( ( rule__RVariable__TypeAssignment_0 ) )
            {
            // InternalAle.g:3013:1: ( ( rule__RVariable__TypeAssignment_0 ) )
            // InternalAle.g:3014:2: ( rule__RVariable__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getTypeAssignment_0()); 
            }
            // InternalAle.g:3015:2: ( rule__RVariable__TypeAssignment_0 )
            // InternalAle.g:3015:3: rule__RVariable__TypeAssignment_0
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
    // InternalAle.g:3023:1: rule__RVariable__Group__1 : rule__RVariable__Group__1__Impl ;
    public final void rule__RVariable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3027:1: ( rule__RVariable__Group__1__Impl )
            // InternalAle.g:3028:2: rule__RVariable__Group__1__Impl
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
    // InternalAle.g:3034:1: rule__RVariable__Group__1__Impl : ( ( rule__RVariable__NameAssignment_1 ) ) ;
    public final void rule__RVariable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3038:1: ( ( ( rule__RVariable__NameAssignment_1 ) ) )
            // InternalAle.g:3039:1: ( ( rule__RVariable__NameAssignment_1 ) )
            {
            // InternalAle.g:3039:1: ( ( rule__RVariable__NameAssignment_1 ) )
            // InternalAle.g:3040:2: ( rule__RVariable__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getNameAssignment_1()); 
            }
            // InternalAle.g:3041:2: ( rule__RVariable__NameAssignment_1 )
            // InternalAle.g:3041:3: rule__RVariable__NameAssignment_1
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
    // InternalAle.g:3050:1: rule__RAttribute__Group__0 : rule__RAttribute__Group__0__Impl rule__RAttribute__Group__1 ;
    public final void rule__RAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3054:1: ( rule__RAttribute__Group__0__Impl rule__RAttribute__Group__1 )
            // InternalAle.g:3055:2: rule__RAttribute__Group__0__Impl rule__RAttribute__Group__1
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
    // InternalAle.g:3062:1: rule__RAttribute__Group__0__Impl : ( ( rule__RAttribute__TypeAssignment_0 ) ) ;
    public final void rule__RAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3066:1: ( ( ( rule__RAttribute__TypeAssignment_0 ) ) )
            // InternalAle.g:3067:1: ( ( rule__RAttribute__TypeAssignment_0 ) )
            {
            // InternalAle.g:3067:1: ( ( rule__RAttribute__TypeAssignment_0 ) )
            // InternalAle.g:3068:2: ( rule__RAttribute__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getTypeAssignment_0()); 
            }
            // InternalAle.g:3069:2: ( rule__RAttribute__TypeAssignment_0 )
            // InternalAle.g:3069:3: rule__RAttribute__TypeAssignment_0
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
    // InternalAle.g:3077:1: rule__RAttribute__Group__1 : rule__RAttribute__Group__1__Impl rule__RAttribute__Group__2 ;
    public final void rule__RAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3081:1: ( rule__RAttribute__Group__1__Impl rule__RAttribute__Group__2 )
            // InternalAle.g:3082:2: rule__RAttribute__Group__1__Impl rule__RAttribute__Group__2
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
    // InternalAle.g:3089:1: rule__RAttribute__Group__1__Impl : ( ( rule__RAttribute__NameAssignment_1 ) ) ;
    public final void rule__RAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3093:1: ( ( ( rule__RAttribute__NameAssignment_1 ) ) )
            // InternalAle.g:3094:1: ( ( rule__RAttribute__NameAssignment_1 ) )
            {
            // InternalAle.g:3094:1: ( ( rule__RAttribute__NameAssignment_1 ) )
            // InternalAle.g:3095:2: ( rule__RAttribute__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getNameAssignment_1()); 
            }
            // InternalAle.g:3096:2: ( rule__RAttribute__NameAssignment_1 )
            // InternalAle.g:3096:3: rule__RAttribute__NameAssignment_1
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
    // InternalAle.g:3104:1: rule__RAttribute__Group__2 : rule__RAttribute__Group__2__Impl rule__RAttribute__Group__3 ;
    public final void rule__RAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3108:1: ( rule__RAttribute__Group__2__Impl rule__RAttribute__Group__3 )
            // InternalAle.g:3109:2: rule__RAttribute__Group__2__Impl rule__RAttribute__Group__3
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
    // InternalAle.g:3116:1: rule__RAttribute__Group__2__Impl : ( ( rule__RAttribute__Group_2__0 )? ) ;
    public final void rule__RAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3120:1: ( ( ( rule__RAttribute__Group_2__0 )? ) )
            // InternalAle.g:3121:1: ( ( rule__RAttribute__Group_2__0 )? )
            {
            // InternalAle.g:3121:1: ( ( rule__RAttribute__Group_2__0 )? )
            // InternalAle.g:3122:2: ( rule__RAttribute__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getGroup_2()); 
            }
            // InternalAle.g:3123:2: ( rule__RAttribute__Group_2__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==59) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAle.g:3123:3: rule__RAttribute__Group_2__0
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
    // InternalAle.g:3131:1: rule__RAttribute__Group__3 : rule__RAttribute__Group__3__Impl ;
    public final void rule__RAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3135:1: ( rule__RAttribute__Group__3__Impl )
            // InternalAle.g:3136:2: rule__RAttribute__Group__3__Impl
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
    // InternalAle.g:3142:1: rule__RAttribute__Group__3__Impl : ( ';' ) ;
    public final void rule__RAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3146:1: ( ( ';' ) )
            // InternalAle.g:3147:1: ( ';' )
            {
            // InternalAle.g:3147:1: ( ';' )
            // InternalAle.g:3148:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getSemicolonKeyword_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3158:1: rule__RAttribute__Group_2__0 : rule__RAttribute__Group_2__0__Impl rule__RAttribute__Group_2__1 ;
    public final void rule__RAttribute__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3162:1: ( rule__RAttribute__Group_2__0__Impl rule__RAttribute__Group_2__1 )
            // InternalAle.g:3163:2: rule__RAttribute__Group_2__0__Impl rule__RAttribute__Group_2__1
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
    // InternalAle.g:3170:1: rule__RAttribute__Group_2__0__Impl : ( ':=' ) ;
    public final void rule__RAttribute__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3174:1: ( ( ':=' ) )
            // InternalAle.g:3175:1: ( ':=' )
            {
            // InternalAle.g:3175:1: ( ':=' )
            // InternalAle.g:3176:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getColonEqualsSignKeyword_2_0()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3185:1: rule__RAttribute__Group_2__1 : rule__RAttribute__Group_2__1__Impl ;
    public final void rule__RAttribute__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3189:1: ( rule__RAttribute__Group_2__1__Impl )
            // InternalAle.g:3190:2: rule__RAttribute__Group_2__1__Impl
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
    // InternalAle.g:3196:1: rule__RAttribute__Group_2__1__Impl : ( ( rule__RAttribute__ExprAssignment_2_1 ) ) ;
    public final void rule__RAttribute__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3200:1: ( ( ( rule__RAttribute__ExprAssignment_2_1 ) ) )
            // InternalAle.g:3201:1: ( ( rule__RAttribute__ExprAssignment_2_1 ) )
            {
            // InternalAle.g:3201:1: ( ( rule__RAttribute__ExprAssignment_2_1 ) )
            // InternalAle.g:3202:2: ( rule__RAttribute__ExprAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getExprAssignment_2_1()); 
            }
            // InternalAle.g:3203:2: ( rule__RAttribute__ExprAssignment_2_1 )
            // InternalAle.g:3203:3: rule__RAttribute__ExprAssignment_2_1
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
    // InternalAle.g:3212:1: rule__RStatement__Group_0__0 : rule__RStatement__Group_0__0__Impl rule__RStatement__Group_0__1 ;
    public final void rule__RStatement__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3216:1: ( rule__RStatement__Group_0__0__Impl rule__RStatement__Group_0__1 )
            // InternalAle.g:3217:2: rule__RStatement__Group_0__0__Impl rule__RStatement__Group_0__1
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
    // InternalAle.g:3224:1: rule__RStatement__Group_0__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3228:1: ( ( () ) )
            // InternalAle.g:3229:1: ( () )
            {
            // InternalAle.g:3229:1: ( () )
            // InternalAle.g:3230:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRValDeclAction_0_0()); 
            }
            // InternalAle.g:3231:2: ()
            // InternalAle.g:3231:3: 
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
    // InternalAle.g:3239:1: rule__RStatement__Group_0__1 : rule__RStatement__Group_0__1__Impl ;
    public final void rule__RStatement__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3243:1: ( rule__RStatement__Group_0__1__Impl )
            // InternalAle.g:3244:2: rule__RStatement__Group_0__1__Impl
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
    // InternalAle.g:3250:1: rule__RStatement__Group_0__1__Impl : ( ( rule__RStatement__StmtAssignment_0_1 ) ) ;
    public final void rule__RStatement__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3254:1: ( ( ( rule__RStatement__StmtAssignment_0_1 ) ) )
            // InternalAle.g:3255:1: ( ( rule__RStatement__StmtAssignment_0_1 ) )
            {
            // InternalAle.g:3255:1: ( ( rule__RStatement__StmtAssignment_0_1 ) )
            // InternalAle.g:3256:2: ( rule__RStatement__StmtAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getStmtAssignment_0_1()); 
            }
            // InternalAle.g:3257:2: ( rule__RStatement__StmtAssignment_0_1 )
            // InternalAle.g:3257:3: rule__RStatement__StmtAssignment_0_1
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
    // InternalAle.g:3266:1: rule__RStatement__Group_1__0 : rule__RStatement__Group_1__0__Impl rule__RStatement__Group_1__1 ;
    public final void rule__RStatement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3270:1: ( rule__RStatement__Group_1__0__Impl rule__RStatement__Group_1__1 )
            // InternalAle.g:3271:2: rule__RStatement__Group_1__0__Impl rule__RStatement__Group_1__1
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
    // InternalAle.g:3278:1: rule__RStatement__Group_1__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3282:1: ( ( () ) )
            // InternalAle.g:3283:1: ( () )
            {
            // InternalAle.g:3283:1: ( () )
            // InternalAle.g:3284:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRAssignAction_1_0()); 
            }
            // InternalAle.g:3285:2: ()
            // InternalAle.g:3285:3: 
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
    // InternalAle.g:3293:1: rule__RStatement__Group_1__1 : rule__RStatement__Group_1__1__Impl ;
    public final void rule__RStatement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3297:1: ( rule__RStatement__Group_1__1__Impl )
            // InternalAle.g:3298:2: rule__RStatement__Group_1__1__Impl
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
    // InternalAle.g:3304:1: rule__RStatement__Group_1__1__Impl : ( ( rule__RStatement__StmtAssignment_1_1 ) ) ;
    public final void rule__RStatement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3308:1: ( ( ( rule__RStatement__StmtAssignment_1_1 ) ) )
            // InternalAle.g:3309:1: ( ( rule__RStatement__StmtAssignment_1_1 ) )
            {
            // InternalAle.g:3309:1: ( ( rule__RStatement__StmtAssignment_1_1 ) )
            // InternalAle.g:3310:2: ( rule__RStatement__StmtAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getStmtAssignment_1_1()); 
            }
            // InternalAle.g:3311:2: ( rule__RStatement__StmtAssignment_1_1 )
            // InternalAle.g:3311:3: rule__RStatement__StmtAssignment_1_1
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
    // InternalAle.g:3320:1: rule__RStatement__Group_2__0 : rule__RStatement__Group_2__0__Impl rule__RStatement__Group_2__1 ;
    public final void rule__RStatement__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3324:1: ( rule__RStatement__Group_2__0__Impl rule__RStatement__Group_2__1 )
            // InternalAle.g:3325:2: rule__RStatement__Group_2__0__Impl rule__RStatement__Group_2__1
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
    // InternalAle.g:3332:1: rule__RStatement__Group_2__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3336:1: ( ( () ) )
            // InternalAle.g:3337:1: ( () )
            {
            // InternalAle.g:3337:1: ( () )
            // InternalAle.g:3338:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRForEachAction_2_0()); 
            }
            // InternalAle.g:3339:2: ()
            // InternalAle.g:3339:3: 
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
    // InternalAle.g:3347:1: rule__RStatement__Group_2__1 : rule__RStatement__Group_2__1__Impl ;
    public final void rule__RStatement__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3351:1: ( rule__RStatement__Group_2__1__Impl )
            // InternalAle.g:3352:2: rule__RStatement__Group_2__1__Impl
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
    // InternalAle.g:3358:1: rule__RStatement__Group_2__1__Impl : ( ( rule__RStatement__ForEachAssignment_2_1 ) ) ;
    public final void rule__RStatement__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3362:1: ( ( ( rule__RStatement__ForEachAssignment_2_1 ) ) )
            // InternalAle.g:3363:1: ( ( rule__RStatement__ForEachAssignment_2_1 ) )
            {
            // InternalAle.g:3363:1: ( ( rule__RStatement__ForEachAssignment_2_1 ) )
            // InternalAle.g:3364:2: ( rule__RStatement__ForEachAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getForEachAssignment_2_1()); 
            }
            // InternalAle.g:3365:2: ( rule__RStatement__ForEachAssignment_2_1 )
            // InternalAle.g:3365:3: rule__RStatement__ForEachAssignment_2_1
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
    // InternalAle.g:3374:1: rule__RStatement__Group_3__0 : rule__RStatement__Group_3__0__Impl rule__RStatement__Group_3__1 ;
    public final void rule__RStatement__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3378:1: ( rule__RStatement__Group_3__0__Impl rule__RStatement__Group_3__1 )
            // InternalAle.g:3379:2: rule__RStatement__Group_3__0__Impl rule__RStatement__Group_3__1
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
    // InternalAle.g:3386:1: rule__RStatement__Group_3__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3390:1: ( ( () ) )
            // InternalAle.g:3391:1: ( () )
            {
            // InternalAle.g:3391:1: ( () )
            // InternalAle.g:3392:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRWhileAction_3_0()); 
            }
            // InternalAle.g:3393:2: ()
            // InternalAle.g:3393:3: 
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
    // InternalAle.g:3401:1: rule__RStatement__Group_3__1 : rule__RStatement__Group_3__1__Impl ;
    public final void rule__RStatement__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3405:1: ( rule__RStatement__Group_3__1__Impl )
            // InternalAle.g:3406:2: rule__RStatement__Group_3__1__Impl
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
    // InternalAle.g:3412:1: rule__RStatement__Group_3__1__Impl : ( ( rule__RStatement__WhileAssignment_3_1 ) ) ;
    public final void rule__RStatement__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3416:1: ( ( ( rule__RStatement__WhileAssignment_3_1 ) ) )
            // InternalAle.g:3417:1: ( ( rule__RStatement__WhileAssignment_3_1 ) )
            {
            // InternalAle.g:3417:1: ( ( rule__RStatement__WhileAssignment_3_1 ) )
            // InternalAle.g:3418:2: ( rule__RStatement__WhileAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getWhileAssignment_3_1()); 
            }
            // InternalAle.g:3419:2: ( rule__RStatement__WhileAssignment_3_1 )
            // InternalAle.g:3419:3: rule__RStatement__WhileAssignment_3_1
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
    // InternalAle.g:3428:1: rule__RStatement__Group_4__0 : rule__RStatement__Group_4__0__Impl rule__RStatement__Group_4__1 ;
    public final void rule__RStatement__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3432:1: ( rule__RStatement__Group_4__0__Impl rule__RStatement__Group_4__1 )
            // InternalAle.g:3433:2: rule__RStatement__Group_4__0__Impl rule__RStatement__Group_4__1
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
    // InternalAle.g:3440:1: rule__RStatement__Group_4__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3444:1: ( ( () ) )
            // InternalAle.g:3445:1: ( () )
            {
            // InternalAle.g:3445:1: ( () )
            // InternalAle.g:3446:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRIfAction_4_0()); 
            }
            // InternalAle.g:3447:2: ()
            // InternalAle.g:3447:3: 
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
    // InternalAle.g:3455:1: rule__RStatement__Group_4__1 : rule__RStatement__Group_4__1__Impl ;
    public final void rule__RStatement__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3459:1: ( rule__RStatement__Group_4__1__Impl )
            // InternalAle.g:3460:2: rule__RStatement__Group_4__1__Impl
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
    // InternalAle.g:3466:1: rule__RStatement__Group_4__1__Impl : ( ( rule__RStatement__IfAssignment_4_1 ) ) ;
    public final void rule__RStatement__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3470:1: ( ( ( rule__RStatement__IfAssignment_4_1 ) ) )
            // InternalAle.g:3471:1: ( ( rule__RStatement__IfAssignment_4_1 ) )
            {
            // InternalAle.g:3471:1: ( ( rule__RStatement__IfAssignment_4_1 ) )
            // InternalAle.g:3472:2: ( rule__RStatement__IfAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getIfAssignment_4_1()); 
            }
            // InternalAle.g:3473:2: ( rule__RStatement__IfAssignment_4_1 )
            // InternalAle.g:3473:3: rule__RStatement__IfAssignment_4_1
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
    // InternalAle.g:3482:1: rule__RStatement__Group_5__0 : rule__RStatement__Group_5__0__Impl rule__RStatement__Group_5__1 ;
    public final void rule__RStatement__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3486:1: ( rule__RStatement__Group_5__0__Impl rule__RStatement__Group_5__1 )
            // InternalAle.g:3487:2: rule__RStatement__Group_5__0__Impl rule__RStatement__Group_5__1
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
    // InternalAle.g:3494:1: rule__RStatement__Group_5__0__Impl : ( () ) ;
    public final void rule__RStatement__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3498:1: ( ( () ) )
            // InternalAle.g:3499:1: ( () )
            {
            // InternalAle.g:3499:1: ( () )
            // InternalAle.g:3500:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getRExpressionAction_5_0()); 
            }
            // InternalAle.g:3501:2: ()
            // InternalAle.g:3501:3: 
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
    // InternalAle.g:3509:1: rule__RStatement__Group_5__1 : rule__RStatement__Group_5__1__Impl ;
    public final void rule__RStatement__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3513:1: ( rule__RStatement__Group_5__1__Impl )
            // InternalAle.g:3514:2: rule__RStatement__Group_5__1__Impl
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
    // InternalAle.g:3520:1: rule__RStatement__Group_5__1__Impl : ( ( rule__RStatement__ExprAssignment_5_1 ) ) ;
    public final void rule__RStatement__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3524:1: ( ( ( rule__RStatement__ExprAssignment_5_1 ) ) )
            // InternalAle.g:3525:1: ( ( rule__RStatement__ExprAssignment_5_1 ) )
            {
            // InternalAle.g:3525:1: ( ( rule__RStatement__ExprAssignment_5_1 ) )
            // InternalAle.g:3526:2: ( rule__RStatement__ExprAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRStatementAccess().getExprAssignment_5_1()); 
            }
            // InternalAle.g:3527:2: ( rule__RStatement__ExprAssignment_5_1 )
            // InternalAle.g:3527:3: rule__RStatement__ExprAssignment_5_1
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
    // InternalAle.g:3536:1: rule__RVarDecl__Group__0 : rule__RVarDecl__Group__0__Impl rule__RVarDecl__Group__1 ;
    public final void rule__RVarDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3540:1: ( rule__RVarDecl__Group__0__Impl rule__RVarDecl__Group__1 )
            // InternalAle.g:3541:2: rule__RVarDecl__Group__0__Impl rule__RVarDecl__Group__1
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
    // InternalAle.g:3548:1: rule__RVarDecl__Group__0__Impl : ( rulerType ) ;
    public final void rule__RVarDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3552:1: ( ( rulerType ) )
            // InternalAle.g:3553:1: ( rulerType )
            {
            // InternalAle.g:3553:1: ( rulerType )
            // InternalAle.g:3554:2: rulerType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getRTypeParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getRTypeParserRuleCall_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:3563:1: rule__RVarDecl__Group__1 : rule__RVarDecl__Group__1__Impl rule__RVarDecl__Group__2 ;
    public final void rule__RVarDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3567:1: ( rule__RVarDecl__Group__1__Impl rule__RVarDecl__Group__2 )
            // InternalAle.g:3568:2: rule__RVarDecl__Group__1__Impl rule__RVarDecl__Group__2
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
    // InternalAle.g:3575:1: rule__RVarDecl__Group__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RVarDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3579:1: ( ( RULE_IDENT ) )
            // InternalAle.g:3580:1: ( RULE_IDENT )
            {
            // InternalAle.g:3580:1: ( RULE_IDENT )
            // InternalAle.g:3581:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getIdentTerminalRuleCall_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getIdentTerminalRuleCall_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:3590:1: rule__RVarDecl__Group__2 : rule__RVarDecl__Group__2__Impl rule__RVarDecl__Group__3 ;
    public final void rule__RVarDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3594:1: ( rule__RVarDecl__Group__2__Impl rule__RVarDecl__Group__3 )
            // InternalAle.g:3595:2: rule__RVarDecl__Group__2__Impl rule__RVarDecl__Group__3
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
    // InternalAle.g:3602:1: rule__RVarDecl__Group__2__Impl : ( ( rule__RVarDecl__Group_2__0 )? ) ;
    public final void rule__RVarDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3606:1: ( ( ( rule__RVarDecl__Group_2__0 )? ) )
            // InternalAle.g:3607:1: ( ( rule__RVarDecl__Group_2__0 )? )
            {
            // InternalAle.g:3607:1: ( ( rule__RVarDecl__Group_2__0 )? )
            // InternalAle.g:3608:2: ( rule__RVarDecl__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getGroup_2()); 
            }
            // InternalAle.g:3609:2: ( rule__RVarDecl__Group_2__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==59) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAle.g:3609:3: rule__RVarDecl__Group_2__0
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
    // InternalAle.g:3617:1: rule__RVarDecl__Group__3 : rule__RVarDecl__Group__3__Impl ;
    public final void rule__RVarDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3621:1: ( rule__RVarDecl__Group__3__Impl )
            // InternalAle.g:3622:2: rule__RVarDecl__Group__3__Impl
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
    // InternalAle.g:3628:1: rule__RVarDecl__Group__3__Impl : ( ';' ) ;
    public final void rule__RVarDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3632:1: ( ( ';' ) )
            // InternalAle.g:3633:1: ( ';' )
            {
            // InternalAle.g:3633:1: ( ';' )
            // InternalAle.g:3634:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getSemicolonKeyword_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3644:1: rule__RVarDecl__Group_2__0 : rule__RVarDecl__Group_2__0__Impl rule__RVarDecl__Group_2__1 ;
    public final void rule__RVarDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3648:1: ( rule__RVarDecl__Group_2__0__Impl rule__RVarDecl__Group_2__1 )
            // InternalAle.g:3649:2: rule__RVarDecl__Group_2__0__Impl rule__RVarDecl__Group_2__1
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
    // InternalAle.g:3656:1: rule__RVarDecl__Group_2__0__Impl : ( ':=' ) ;
    public final void rule__RVarDecl__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3660:1: ( ( ':=' ) )
            // InternalAle.g:3661:1: ( ':=' )
            {
            // InternalAle.g:3661:1: ( ':=' )
            // InternalAle.g:3662:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getColonEqualsSignKeyword_2_0()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3671:1: rule__RVarDecl__Group_2__1 : rule__RVarDecl__Group_2__1__Impl ;
    public final void rule__RVarDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3675:1: ( rule__RVarDecl__Group_2__1__Impl )
            // InternalAle.g:3676:2: rule__RVarDecl__Group_2__1__Impl
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
    // InternalAle.g:3682:1: rule__RVarDecl__Group_2__1__Impl : ( ruleexpression ) ;
    public final void rule__RVarDecl__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3686:1: ( ( ruleexpression ) )
            // InternalAle.g:3687:1: ( ruleexpression )
            {
            // InternalAle.g:3687:1: ( ruleexpression )
            // InternalAle.g:3688:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getExpressionParserRuleCall_2_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVarDeclAccess().getExpressionParserRuleCall_2_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:3698:1: rule__RAssign__Group__0 : rule__RAssign__Group__0__Impl rule__RAssign__Group__1 ;
    public final void rule__RAssign__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3702:1: ( rule__RAssign__Group__0__Impl rule__RAssign__Group__1 )
            // InternalAle.g:3703:2: rule__RAssign__Group__0__Impl rule__RAssign__Group__1
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
    // InternalAle.g:3710:1: rule__RAssign__Group__0__Impl : ( ( rule__RAssign__LeftAssignment_0 ) ) ;
    public final void rule__RAssign__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3714:1: ( ( ( rule__RAssign__LeftAssignment_0 ) ) )
            // InternalAle.g:3715:1: ( ( rule__RAssign__LeftAssignment_0 ) )
            {
            // InternalAle.g:3715:1: ( ( rule__RAssign__LeftAssignment_0 ) )
            // InternalAle.g:3716:2: ( rule__RAssign__LeftAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getLeftAssignment_0()); 
            }
            // InternalAle.g:3717:2: ( rule__RAssign__LeftAssignment_0 )
            // InternalAle.g:3717:3: rule__RAssign__LeftAssignment_0
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
    // InternalAle.g:3725:1: rule__RAssign__Group__1 : rule__RAssign__Group__1__Impl rule__RAssign__Group__2 ;
    public final void rule__RAssign__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3729:1: ( rule__RAssign__Group__1__Impl rule__RAssign__Group__2 )
            // InternalAle.g:3730:2: rule__RAssign__Group__1__Impl rule__RAssign__Group__2
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
    // InternalAle.g:3737:1: rule__RAssign__Group__1__Impl : ( ':=' ) ;
    public final void rule__RAssign__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3741:1: ( ( ':=' ) )
            // InternalAle.g:3742:1: ( ':=' )
            {
            // InternalAle.g:3742:1: ( ':=' )
            // InternalAle.g:3743:2: ':='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getColonEqualsSignKeyword_1()); 
            }
            match(input,59,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3752:1: rule__RAssign__Group__2 : rule__RAssign__Group__2__Impl rule__RAssign__Group__3 ;
    public final void rule__RAssign__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3756:1: ( rule__RAssign__Group__2__Impl rule__RAssign__Group__3 )
            // InternalAle.g:3757:2: rule__RAssign__Group__2__Impl rule__RAssign__Group__3
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
    // InternalAle.g:3764:1: rule__RAssign__Group__2__Impl : ( ( rule__RAssign__RightAssignment_2 ) ) ;
    public final void rule__RAssign__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3768:1: ( ( ( rule__RAssign__RightAssignment_2 ) ) )
            // InternalAle.g:3769:1: ( ( rule__RAssign__RightAssignment_2 ) )
            {
            // InternalAle.g:3769:1: ( ( rule__RAssign__RightAssignment_2 ) )
            // InternalAle.g:3770:2: ( rule__RAssign__RightAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getRightAssignment_2()); 
            }
            // InternalAle.g:3771:2: ( rule__RAssign__RightAssignment_2 )
            // InternalAle.g:3771:3: rule__RAssign__RightAssignment_2
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
    // InternalAle.g:3779:1: rule__RAssign__Group__3 : rule__RAssign__Group__3__Impl ;
    public final void rule__RAssign__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3783:1: ( rule__RAssign__Group__3__Impl )
            // InternalAle.g:3784:2: rule__RAssign__Group__3__Impl
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
    // InternalAle.g:3790:1: rule__RAssign__Group__3__Impl : ( ';' ) ;
    public final void rule__RAssign__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3794:1: ( ( ';' ) )
            // InternalAle.g:3795:1: ( ';' )
            {
            // InternalAle.g:3795:1: ( ';' )
            // InternalAle.g:3796:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getSemicolonKeyword_3()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3806:1: rule__RForEach__Group__0 : rule__RForEach__Group__0__Impl rule__RForEach__Group__1 ;
    public final void rule__RForEach__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3810:1: ( rule__RForEach__Group__0__Impl rule__RForEach__Group__1 )
            // InternalAle.g:3811:2: rule__RForEach__Group__0__Impl rule__RForEach__Group__1
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
    // InternalAle.g:3818:1: rule__RForEach__Group__0__Impl : ( 'for' ) ;
    public final void rule__RForEach__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3822:1: ( ( 'for' ) )
            // InternalAle.g:3823:1: ( 'for' )
            {
            // InternalAle.g:3823:1: ( 'for' )
            // InternalAle.g:3824:2: 'for'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getForKeyword_0()); 
            }
            match(input,60,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3833:1: rule__RForEach__Group__1 : rule__RForEach__Group__1__Impl rule__RForEach__Group__2 ;
    public final void rule__RForEach__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3837:1: ( rule__RForEach__Group__1__Impl rule__RForEach__Group__2 )
            // InternalAle.g:3838:2: rule__RForEach__Group__1__Impl rule__RForEach__Group__2
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
    // InternalAle.g:3845:1: rule__RForEach__Group__1__Impl : ( '(' ) ;
    public final void rule__RForEach__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3849:1: ( ( '(' ) )
            // InternalAle.g:3850:1: ( '(' )
            {
            // InternalAle.g:3850:1: ( '(' )
            // InternalAle.g:3851:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3860:1: rule__RForEach__Group__2 : rule__RForEach__Group__2__Impl rule__RForEach__Group__3 ;
    public final void rule__RForEach__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3864:1: ( rule__RForEach__Group__2__Impl rule__RForEach__Group__3 )
            // InternalAle.g:3865:2: rule__RForEach__Group__2__Impl rule__RForEach__Group__3
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
    // InternalAle.g:3872:1: rule__RForEach__Group__2__Impl : ( RULE_IDENT ) ;
    public final void rule__RForEach__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3876:1: ( ( RULE_IDENT ) )
            // InternalAle.g:3877:1: ( RULE_IDENT )
            {
            // InternalAle.g:3877:1: ( RULE_IDENT )
            // InternalAle.g:3878:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getIdentTerminalRuleCall_2()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getIdentTerminalRuleCall_2()); 
            }

            }


            }

        }
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
    // InternalAle.g:3887:1: rule__RForEach__Group__3 : rule__RForEach__Group__3__Impl rule__RForEach__Group__4 ;
    public final void rule__RForEach__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3891:1: ( rule__RForEach__Group__3__Impl rule__RForEach__Group__4 )
            // InternalAle.g:3892:2: rule__RForEach__Group__3__Impl rule__RForEach__Group__4
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
    // InternalAle.g:3899:1: rule__RForEach__Group__3__Impl : ( 'in' ) ;
    public final void rule__RForEach__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3903:1: ( ( 'in' ) )
            // InternalAle.g:3904:1: ( 'in' )
            {
            // InternalAle.g:3904:1: ( 'in' )
            // InternalAle.g:3905:2: 'in'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getInKeyword_3()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3914:1: rule__RForEach__Group__4 : rule__RForEach__Group__4__Impl rule__RForEach__Group__5 ;
    public final void rule__RForEach__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3918:1: ( rule__RForEach__Group__4__Impl rule__RForEach__Group__5 )
            // InternalAle.g:3919:2: rule__RForEach__Group__4__Impl rule__RForEach__Group__5
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
    // InternalAle.g:3926:1: rule__RForEach__Group__4__Impl : ( rulerCollection ) ;
    public final void rule__RForEach__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3930:1: ( ( rulerCollection ) )
            // InternalAle.g:3931:1: ( rulerCollection )
            {
            // InternalAle.g:3931:1: ( rulerCollection )
            // InternalAle.g:3932:2: rulerCollection
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
    // InternalAle.g:3941:1: rule__RForEach__Group__5 : rule__RForEach__Group__5__Impl rule__RForEach__Group__6 ;
    public final void rule__RForEach__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3945:1: ( rule__RForEach__Group__5__Impl rule__RForEach__Group__6 )
            // InternalAle.g:3946:2: rule__RForEach__Group__5__Impl rule__RForEach__Group__6
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
    // InternalAle.g:3953:1: rule__RForEach__Group__5__Impl : ( ')' ) ;
    public final void rule__RForEach__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3957:1: ( ( ')' ) )
            // InternalAle.g:3958:1: ( ')' )
            {
            // InternalAle.g:3958:1: ( ')' )
            // InternalAle.g:3959:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:3968:1: rule__RForEach__Group__6 : rule__RForEach__Group__6__Impl ;
    public final void rule__RForEach__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3972:1: ( rule__RForEach__Group__6__Impl )
            // InternalAle.g:3973:2: rule__RForEach__Group__6__Impl
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
    // InternalAle.g:3979:1: rule__RForEach__Group__6__Impl : ( ( rule__RForEach__BlockAssignment_6 ) ) ;
    public final void rule__RForEach__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3983:1: ( ( ( rule__RForEach__BlockAssignment_6 ) ) )
            // InternalAle.g:3984:1: ( ( rule__RForEach__BlockAssignment_6 ) )
            {
            // InternalAle.g:3984:1: ( ( rule__RForEach__BlockAssignment_6 ) )
            // InternalAle.g:3985:2: ( rule__RForEach__BlockAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getBlockAssignment_6()); 
            }
            // InternalAle.g:3986:2: ( rule__RForEach__BlockAssignment_6 )
            // InternalAle.g:3986:3: rule__RForEach__BlockAssignment_6
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
    // InternalAle.g:3995:1: rule__RCollection__Group_0__0 : rule__RCollection__Group_0__0__Impl rule__RCollection__Group_0__1 ;
    public final void rule__RCollection__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3999:1: ( rule__RCollection__Group_0__0__Impl rule__RCollection__Group_0__1 )
            // InternalAle.g:4000:2: rule__RCollection__Group_0__0__Impl rule__RCollection__Group_0__1
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
    // InternalAle.g:4007:1: rule__RCollection__Group_0__0__Impl : ( '[' ) ;
    public final void rule__RCollection__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4011:1: ( ( '[' ) )
            // InternalAle.g:4012:1: ( '[' )
            {
            // InternalAle.g:4012:1: ( '[' )
            // InternalAle.g:4013:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionAccess().getLeftSquareBracketKeyword_0_0()); 
            }
            match(input,62,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4022:1: rule__RCollection__Group_0__1 : rule__RCollection__Group_0__1__Impl rule__RCollection__Group_0__2 ;
    public final void rule__RCollection__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4026:1: ( rule__RCollection__Group_0__1__Impl rule__RCollection__Group_0__2 )
            // InternalAle.g:4027:2: rule__RCollection__Group_0__1__Impl rule__RCollection__Group_0__2
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
    // InternalAle.g:4034:1: rule__RCollection__Group_0__1__Impl : ( RULE_INT ) ;
    public final void rule__RCollection__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4038:1: ( ( RULE_INT ) )
            // InternalAle.g:4039:1: ( RULE_INT )
            {
            // InternalAle.g:4039:1: ( RULE_INT )
            // InternalAle.g:4040:2: RULE_INT
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
    // InternalAle.g:4049:1: rule__RCollection__Group_0__2 : rule__RCollection__Group_0__2__Impl rule__RCollection__Group_0__3 ;
    public final void rule__RCollection__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4053:1: ( rule__RCollection__Group_0__2__Impl rule__RCollection__Group_0__3 )
            // InternalAle.g:4054:2: rule__RCollection__Group_0__2__Impl rule__RCollection__Group_0__3
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
    // InternalAle.g:4061:1: rule__RCollection__Group_0__2__Impl : ( '..' ) ;
    public final void rule__RCollection__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4065:1: ( ( '..' ) )
            // InternalAle.g:4066:1: ( '..' )
            {
            // InternalAle.g:4066:1: ( '..' )
            // InternalAle.g:4067:2: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionAccess().getFullStopFullStopKeyword_0_2()); 
            }
            match(input,63,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4076:1: rule__RCollection__Group_0__3 : rule__RCollection__Group_0__3__Impl rule__RCollection__Group_0__4 ;
    public final void rule__RCollection__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4080:1: ( rule__RCollection__Group_0__3__Impl rule__RCollection__Group_0__4 )
            // InternalAle.g:4081:2: rule__RCollection__Group_0__3__Impl rule__RCollection__Group_0__4
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
    // InternalAle.g:4088:1: rule__RCollection__Group_0__3__Impl : ( RULE_INT ) ;
    public final void rule__RCollection__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4092:1: ( ( RULE_INT ) )
            // InternalAle.g:4093:1: ( RULE_INT )
            {
            // InternalAle.g:4093:1: ( RULE_INT )
            // InternalAle.g:4094:2: RULE_INT
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
    // InternalAle.g:4103:1: rule__RCollection__Group_0__4 : rule__RCollection__Group_0__4__Impl ;
    public final void rule__RCollection__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4107:1: ( rule__RCollection__Group_0__4__Impl )
            // InternalAle.g:4108:2: rule__RCollection__Group_0__4__Impl
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
    // InternalAle.g:4114:1: rule__RCollection__Group_0__4__Impl : ( ']' ) ;
    public final void rule__RCollection__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4118:1: ( ( ']' ) )
            // InternalAle.g:4119:1: ( ']' )
            {
            // InternalAle.g:4119:1: ( ']' )
            // InternalAle.g:4120:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRCollectionAccess().getRightSquareBracketKeyword_0_4()); 
            }
            match(input,64,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4130:1: rule__RBlock__Group__0 : rule__RBlock__Group__0__Impl rule__RBlock__Group__1 ;
    public final void rule__RBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4134:1: ( rule__RBlock__Group__0__Impl rule__RBlock__Group__1 )
            // InternalAle.g:4135:2: rule__RBlock__Group__0__Impl rule__RBlock__Group__1
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
    // InternalAle.g:4142:1: rule__RBlock__Group__0__Impl : ( '{' ) ;
    public final void rule__RBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4146:1: ( ( '{' ) )
            // InternalAle.g:4147:1: ( '{' )
            {
            // InternalAle.g:4147:1: ( '{' )
            // InternalAle.g:4148:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getLeftCurlyBracketKeyword_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4157:1: rule__RBlock__Group__1 : rule__RBlock__Group__1__Impl rule__RBlock__Group__2 ;
    public final void rule__RBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4161:1: ( rule__RBlock__Group__1__Impl rule__RBlock__Group__2 )
            // InternalAle.g:4162:2: rule__RBlock__Group__1__Impl rule__RBlock__Group__2
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
    // InternalAle.g:4169:1: rule__RBlock__Group__1__Impl : ( ( rule__RBlock__Group_1__0 )? ) ;
    public final void rule__RBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4173:1: ( ( ( rule__RBlock__Group_1__0 )? ) )
            // InternalAle.g:4174:1: ( ( rule__RBlock__Group_1__0 )? )
            {
            // InternalAle.g:4174:1: ( ( rule__RBlock__Group_1__0 )? )
            // InternalAle.g:4175:2: ( rule__RBlock__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getGroup_1()); 
            }
            // InternalAle.g:4176:2: ( rule__RBlock__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_IDENT && LA32_0<=RULE_REAL)||LA32_0==18||(LA32_0>=37 && LA32_0<=43)||LA32_0==52||LA32_0==56||LA32_0==60||LA32_0==65||LA32_0==67||LA32_0==73||LA32_0==76||(LA32_0>=79 && LA32_0<=80)||(LA32_0>=82 && LA32_0<=83)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAle.g:4176:3: rule__RBlock__Group_1__0
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
    // InternalAle.g:4184:1: rule__RBlock__Group__2 : rule__RBlock__Group__2__Impl ;
    public final void rule__RBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4188:1: ( rule__RBlock__Group__2__Impl )
            // InternalAle.g:4189:2: rule__RBlock__Group__2__Impl
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
    // InternalAle.g:4195:1: rule__RBlock__Group__2__Impl : ( '}' ) ;
    public final void rule__RBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4199:1: ( ( '}' ) )
            // InternalAle.g:4200:1: ( '}' )
            {
            // InternalAle.g:4200:1: ( '}' )
            // InternalAle.g:4201:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getRightCurlyBracketKeyword_2()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4211:1: rule__RBlock__Group_1__0 : rule__RBlock__Group_1__0__Impl rule__RBlock__Group_1__1 ;
    public final void rule__RBlock__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4215:1: ( rule__RBlock__Group_1__0__Impl rule__RBlock__Group_1__1 )
            // InternalAle.g:4216:2: rule__RBlock__Group_1__0__Impl rule__RBlock__Group_1__1
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
    // InternalAle.g:4223:1: rule__RBlock__Group_1__0__Impl : ( ( rule__RBlock__StatementAssignment_1_0 ) ) ;
    public final void rule__RBlock__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4227:1: ( ( ( rule__RBlock__StatementAssignment_1_0 ) ) )
            // InternalAle.g:4228:1: ( ( rule__RBlock__StatementAssignment_1_0 ) )
            {
            // InternalAle.g:4228:1: ( ( rule__RBlock__StatementAssignment_1_0 ) )
            // InternalAle.g:4229:2: ( rule__RBlock__StatementAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getStatementAssignment_1_0()); 
            }
            // InternalAle.g:4230:2: ( rule__RBlock__StatementAssignment_1_0 )
            // InternalAle.g:4230:3: rule__RBlock__StatementAssignment_1_0
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
    // InternalAle.g:4238:1: rule__RBlock__Group_1__1 : rule__RBlock__Group_1__1__Impl ;
    public final void rule__RBlock__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4242:1: ( rule__RBlock__Group_1__1__Impl )
            // InternalAle.g:4243:2: rule__RBlock__Group_1__1__Impl
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
    // InternalAle.g:4249:1: rule__RBlock__Group_1__1__Impl : ( ( rule__RBlock__StatementAssignment_1_1 )* ) ;
    public final void rule__RBlock__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4253:1: ( ( ( rule__RBlock__StatementAssignment_1_1 )* ) )
            // InternalAle.g:4254:1: ( ( rule__RBlock__StatementAssignment_1_1 )* )
            {
            // InternalAle.g:4254:1: ( ( rule__RBlock__StatementAssignment_1_1 )* )
            // InternalAle.g:4255:2: ( rule__RBlock__StatementAssignment_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getStatementAssignment_1_1()); 
            }
            // InternalAle.g:4256:2: ( rule__RBlock__StatementAssignment_1_1 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=RULE_IDENT && LA33_0<=RULE_REAL)||LA33_0==18||(LA33_0>=37 && LA33_0<=43)||LA33_0==52||LA33_0==56||LA33_0==60||LA33_0==65||LA33_0==67||LA33_0==73||LA33_0==76||(LA33_0>=79 && LA33_0<=80)||(LA33_0>=82 && LA33_0<=83)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalAle.g:4256:3: rule__RBlock__StatementAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__RBlock__StatementAssignment_1_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalAle.g:4265:1: rule__RIf__Group__0 : rule__RIf__Group__0__Impl rule__RIf__Group__1 ;
    public final void rule__RIf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4269:1: ( rule__RIf__Group__0__Impl rule__RIf__Group__1 )
            // InternalAle.g:4270:2: rule__RIf__Group__0__Impl rule__RIf__Group__1
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
    // InternalAle.g:4277:1: rule__RIf__Group__0__Impl : ( 'if' ) ;
    public final void rule__RIf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4281:1: ( ( 'if' ) )
            // InternalAle.g:4282:1: ( 'if' )
            {
            // InternalAle.g:4282:1: ( 'if' )
            // InternalAle.g:4283:2: 'if'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getIfKeyword_0()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4292:1: rule__RIf__Group__1 : rule__RIf__Group__1__Impl rule__RIf__Group__2 ;
    public final void rule__RIf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4296:1: ( rule__RIf__Group__1__Impl rule__RIf__Group__2 )
            // InternalAle.g:4297:2: rule__RIf__Group__1__Impl rule__RIf__Group__2
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
    // InternalAle.g:4304:1: rule__RIf__Group__1__Impl : ( '(' ) ;
    public final void rule__RIf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4308:1: ( ( '(' ) )
            // InternalAle.g:4309:1: ( '(' )
            {
            // InternalAle.g:4309:1: ( '(' )
            // InternalAle.g:4310:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4319:1: rule__RIf__Group__2 : rule__RIf__Group__2__Impl rule__RIf__Group__3 ;
    public final void rule__RIf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4323:1: ( rule__RIf__Group__2__Impl rule__RIf__Group__3 )
            // InternalAle.g:4324:2: rule__RIf__Group__2__Impl rule__RIf__Group__3
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
    // InternalAle.g:4331:1: rule__RIf__Group__2__Impl : ( ( rule__RIf__ConditionAssignment_2 ) ) ;
    public final void rule__RIf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4335:1: ( ( ( rule__RIf__ConditionAssignment_2 ) ) )
            // InternalAle.g:4336:1: ( ( rule__RIf__ConditionAssignment_2 ) )
            {
            // InternalAle.g:4336:1: ( ( rule__RIf__ConditionAssignment_2 ) )
            // InternalAle.g:4337:2: ( rule__RIf__ConditionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getConditionAssignment_2()); 
            }
            // InternalAle.g:4338:2: ( rule__RIf__ConditionAssignment_2 )
            // InternalAle.g:4338:3: rule__RIf__ConditionAssignment_2
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
    // InternalAle.g:4346:1: rule__RIf__Group__3 : rule__RIf__Group__3__Impl rule__RIf__Group__4 ;
    public final void rule__RIf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4350:1: ( rule__RIf__Group__3__Impl rule__RIf__Group__4 )
            // InternalAle.g:4351:2: rule__RIf__Group__3__Impl rule__RIf__Group__4
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
    // InternalAle.g:4358:1: rule__RIf__Group__3__Impl : ( ')' ) ;
    public final void rule__RIf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4362:1: ( ( ')' ) )
            // InternalAle.g:4363:1: ( ')' )
            {
            // InternalAle.g:4363:1: ( ')' )
            // InternalAle.g:4364:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4373:1: rule__RIf__Group__4 : rule__RIf__Group__4__Impl rule__RIf__Group__5 ;
    public final void rule__RIf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4377:1: ( rule__RIf__Group__4__Impl rule__RIf__Group__5 )
            // InternalAle.g:4378:2: rule__RIf__Group__4__Impl rule__RIf__Group__5
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
    // InternalAle.g:4385:1: rule__RIf__Group__4__Impl : ( ( rule__RIf__IfBlockAssignment_4 ) ) ;
    public final void rule__RIf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4389:1: ( ( ( rule__RIf__IfBlockAssignment_4 ) ) )
            // InternalAle.g:4390:1: ( ( rule__RIf__IfBlockAssignment_4 ) )
            {
            // InternalAle.g:4390:1: ( ( rule__RIf__IfBlockAssignment_4 ) )
            // InternalAle.g:4391:2: ( rule__RIf__IfBlockAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getIfBlockAssignment_4()); 
            }
            // InternalAle.g:4392:2: ( rule__RIf__IfBlockAssignment_4 )
            // InternalAle.g:4392:3: rule__RIf__IfBlockAssignment_4
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
    // InternalAle.g:4400:1: rule__RIf__Group__5 : rule__RIf__Group__5__Impl ;
    public final void rule__RIf__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4404:1: ( rule__RIf__Group__5__Impl )
            // InternalAle.g:4405:2: rule__RIf__Group__5__Impl
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
    // InternalAle.g:4411:1: rule__RIf__Group__5__Impl : ( ( rule__RIf__Group_5__0 )? ) ;
    public final void rule__RIf__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4415:1: ( ( ( rule__RIf__Group_5__0 )? ) )
            // InternalAle.g:4416:1: ( ( rule__RIf__Group_5__0 )? )
            {
            // InternalAle.g:4416:1: ( ( rule__RIf__Group_5__0 )? )
            // InternalAle.g:4417:2: ( rule__RIf__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getGroup_5()); 
            }
            // InternalAle.g:4418:2: ( rule__RIf__Group_5__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==66) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAle.g:4418:3: rule__RIf__Group_5__0
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
    // InternalAle.g:4427:1: rule__RIf__Group_5__0 : rule__RIf__Group_5__0__Impl rule__RIf__Group_5__1 ;
    public final void rule__RIf__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4431:1: ( rule__RIf__Group_5__0__Impl rule__RIf__Group_5__1 )
            // InternalAle.g:4432:2: rule__RIf__Group_5__0__Impl rule__RIf__Group_5__1
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
    // InternalAle.g:4439:1: rule__RIf__Group_5__0__Impl : ( 'else' ) ;
    public final void rule__RIf__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4443:1: ( ( 'else' ) )
            // InternalAle.g:4444:1: ( 'else' )
            {
            // InternalAle.g:4444:1: ( 'else' )
            // InternalAle.g:4445:2: 'else'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getElseKeyword_5_0()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4454:1: rule__RIf__Group_5__1 : rule__RIf__Group_5__1__Impl ;
    public final void rule__RIf__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4458:1: ( rule__RIf__Group_5__1__Impl )
            // InternalAle.g:4459:2: rule__RIf__Group_5__1__Impl
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
    // InternalAle.g:4465:1: rule__RIf__Group_5__1__Impl : ( ( rule__RIf__ElseBlockAssignment_5_1 ) ) ;
    public final void rule__RIf__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4469:1: ( ( ( rule__RIf__ElseBlockAssignment_5_1 ) ) )
            // InternalAle.g:4470:1: ( ( rule__RIf__ElseBlockAssignment_5_1 ) )
            {
            // InternalAle.g:4470:1: ( ( rule__RIf__ElseBlockAssignment_5_1 ) )
            // InternalAle.g:4471:2: ( rule__RIf__ElseBlockAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getElseBlockAssignment_5_1()); 
            }
            // InternalAle.g:4472:2: ( rule__RIf__ElseBlockAssignment_5_1 )
            // InternalAle.g:4472:3: rule__RIf__ElseBlockAssignment_5_1
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
    // InternalAle.g:4481:1: rule__RWhile__Group__0 : rule__RWhile__Group__0__Impl rule__RWhile__Group__1 ;
    public final void rule__RWhile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4485:1: ( rule__RWhile__Group__0__Impl rule__RWhile__Group__1 )
            // InternalAle.g:4486:2: rule__RWhile__Group__0__Impl rule__RWhile__Group__1
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
    // InternalAle.g:4493:1: rule__RWhile__Group__0__Impl : ( 'while' ) ;
    public final void rule__RWhile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4497:1: ( ( 'while' ) )
            // InternalAle.g:4498:1: ( 'while' )
            {
            // InternalAle.g:4498:1: ( 'while' )
            // InternalAle.g:4499:2: 'while'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getWhileKeyword_0()); 
            }
            match(input,67,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4508:1: rule__RWhile__Group__1 : rule__RWhile__Group__1__Impl rule__RWhile__Group__2 ;
    public final void rule__RWhile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4512:1: ( rule__RWhile__Group__1__Impl rule__RWhile__Group__2 )
            // InternalAle.g:4513:2: rule__RWhile__Group__1__Impl rule__RWhile__Group__2
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
    // InternalAle.g:4520:1: rule__RWhile__Group__1__Impl : ( '(' ) ;
    public final void rule__RWhile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4524:1: ( ( '(' ) )
            // InternalAle.g:4525:1: ( '(' )
            {
            // InternalAle.g:4525:1: ( '(' )
            // InternalAle.g:4526:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4535:1: rule__RWhile__Group__2 : rule__RWhile__Group__2__Impl rule__RWhile__Group__3 ;
    public final void rule__RWhile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4539:1: ( rule__RWhile__Group__2__Impl rule__RWhile__Group__3 )
            // InternalAle.g:4540:2: rule__RWhile__Group__2__Impl rule__RWhile__Group__3
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
    // InternalAle.g:4547:1: rule__RWhile__Group__2__Impl : ( ruleexpression ) ;
    public final void rule__RWhile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4551:1: ( ( ruleexpression ) )
            // InternalAle.g:4552:1: ( ruleexpression )
            {
            // InternalAle.g:4552:1: ( ruleexpression )
            // InternalAle.g:4553:2: ruleexpression
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
    // InternalAle.g:4562:1: rule__RWhile__Group__3 : rule__RWhile__Group__3__Impl rule__RWhile__Group__4 ;
    public final void rule__RWhile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4566:1: ( rule__RWhile__Group__3__Impl rule__RWhile__Group__4 )
            // InternalAle.g:4567:2: rule__RWhile__Group__3__Impl rule__RWhile__Group__4
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
    // InternalAle.g:4574:1: rule__RWhile__Group__3__Impl : ( ')' ) ;
    public final void rule__RWhile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4578:1: ( ( ')' ) )
            // InternalAle.g:4579:1: ( ')' )
            {
            // InternalAle.g:4579:1: ( ')' )
            // InternalAle.g:4580:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4589:1: rule__RWhile__Group__4 : rule__RWhile__Group__4__Impl ;
    public final void rule__RWhile__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4593:1: ( rule__RWhile__Group__4__Impl )
            // InternalAle.g:4594:2: rule__RWhile__Group__4__Impl
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
    // InternalAle.g:4600:1: rule__RWhile__Group__4__Impl : ( ( rule__RWhile__BlockAssignment_4 ) ) ;
    public final void rule__RWhile__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4604:1: ( ( ( rule__RWhile__BlockAssignment_4 ) ) )
            // InternalAle.g:4605:1: ( ( rule__RWhile__BlockAssignment_4 ) )
            {
            // InternalAle.g:4605:1: ( ( rule__RWhile__BlockAssignment_4 ) )
            // InternalAle.g:4606:2: ( rule__RWhile__BlockAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getBlockAssignment_4()); 
            }
            // InternalAle.g:4607:2: ( rule__RWhile__BlockAssignment_4 )
            // InternalAle.g:4607:3: rule__RWhile__BlockAssignment_4
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
    // InternalAle.g:4616:1: rule__RExpression__Group__0 : rule__RExpression__Group__0__Impl rule__RExpression__Group__1 ;
    public final void rule__RExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4620:1: ( rule__RExpression__Group__0__Impl rule__RExpression__Group__1 )
            // InternalAle.g:4621:2: rule__RExpression__Group__0__Impl rule__RExpression__Group__1
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
    // InternalAle.g:4628:1: rule__RExpression__Group__0__Impl : ( ruleexpression ) ;
    public final void rule__RExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4632:1: ( ( ruleexpression ) )
            // InternalAle.g:4633:1: ( ruleexpression )
            {
            // InternalAle.g:4633:1: ( ruleexpression )
            // InternalAle.g:4634:2: ruleexpression
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
    // InternalAle.g:4643:1: rule__RExpression__Group__1 : rule__RExpression__Group__1__Impl ;
    public final void rule__RExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4647:1: ( rule__RExpression__Group__1__Impl )
            // InternalAle.g:4648:2: rule__RExpression__Group__1__Impl
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
    // InternalAle.g:4654:1: rule__RExpression__Group__1__Impl : ( ';' ) ;
    public final void rule__RExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4658:1: ( ( ';' ) )
            // InternalAle.g:4659:1: ( ';' )
            {
            // InternalAle.g:4659:1: ( ';' )
            // InternalAle.g:4660:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRExpressionAccess().getSemicolonKeyword_1()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4670:1: rule__Expression__Group__0 : rule__Expression__Group__0__Impl rule__Expression__Group__1 ;
    public final void rule__Expression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4674:1: ( rule__Expression__Group__0__Impl rule__Expression__Group__1 )
            // InternalAle.g:4675:2: rule__Expression__Group__0__Impl rule__Expression__Group__1
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
    // InternalAle.g:4682:1: rule__Expression__Group__0__Impl : ( ( rule__Expression__LeftPartAssignment_0 ) ) ;
    public final void rule__Expression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4686:1: ( ( ( rule__Expression__LeftPartAssignment_0 ) ) )
            // InternalAle.g:4687:1: ( ( rule__Expression__LeftPartAssignment_0 ) )
            {
            // InternalAle.g:4687:1: ( ( rule__Expression__LeftPartAssignment_0 ) )
            // InternalAle.g:4688:2: ( rule__Expression__LeftPartAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getLeftPartAssignment_0()); 
            }
            // InternalAle.g:4689:2: ( rule__Expression__LeftPartAssignment_0 )
            // InternalAle.g:4689:3: rule__Expression__LeftPartAssignment_0
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
    // InternalAle.g:4697:1: rule__Expression__Group__1 : rule__Expression__Group__1__Impl ;
    public final void rule__Expression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4701:1: ( rule__Expression__Group__1__Impl )
            // InternalAle.g:4702:2: rule__Expression__Group__1__Impl
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
    // InternalAle.g:4708:1: rule__Expression__Group__1__Impl : ( ( rule__Expression__RecpartAssignment_1 )? ) ;
    public final void rule__Expression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4712:1: ( ( ( rule__Expression__RecpartAssignment_1 )? ) )
            // InternalAle.g:4713:1: ( ( rule__Expression__RecpartAssignment_1 )? )
            {
            // InternalAle.g:4713:1: ( ( rule__Expression__RecpartAssignment_1 )? )
            // InternalAle.g:4714:2: ( rule__Expression__RecpartAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getRecpartAssignment_1()); 
            }
            // InternalAle.g:4715:2: ( rule__Expression__RecpartAssignment_1 )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalAle.g:4715:3: rule__Expression__RecpartAssignment_1
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
    // InternalAle.g:4724:1: rule__RecExpression__Group__0 : rule__RecExpression__Group__0__Impl rule__RecExpression__Group__1 ;
    public final void rule__RecExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4728:1: ( rule__RecExpression__Group__0__Impl rule__RecExpression__Group__1 )
            // InternalAle.g:4729:2: rule__RecExpression__Group__0__Impl rule__RecExpression__Group__1
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
    // InternalAle.g:4736:1: rule__RecExpression__Group__0__Impl : ( ( rule__RecExpression__Alternatives_0 ) ) ;
    public final void rule__RecExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4740:1: ( ( ( rule__RecExpression__Alternatives_0 ) ) )
            // InternalAle.g:4741:1: ( ( rule__RecExpression__Alternatives_0 ) )
            {
            // InternalAle.g:4741:1: ( ( rule__RecExpression__Alternatives_0 ) )
            // InternalAle.g:4742:2: ( rule__RecExpression__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getAlternatives_0()); 
            }
            // InternalAle.g:4743:2: ( rule__RecExpression__Alternatives_0 )
            // InternalAle.g:4743:3: rule__RecExpression__Alternatives_0
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
    // InternalAle.g:4751:1: rule__RecExpression__Group__1 : rule__RecExpression__Group__1__Impl ;
    public final void rule__RecExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4755:1: ( rule__RecExpression__Group__1__Impl )
            // InternalAle.g:4756:2: rule__RecExpression__Group__1__Impl
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
    // InternalAle.g:4762:1: rule__RecExpression__Group__1__Impl : ( ( rule__RecExpression__RecExpAssignment_1 )? ) ;
    public final void rule__RecExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4766:1: ( ( ( rule__RecExpression__RecExpAssignment_1 )? ) )
            // InternalAle.g:4767:1: ( ( rule__RecExpression__RecExpAssignment_1 )? )
            {
            // InternalAle.g:4767:1: ( ( rule__RecExpression__RecExpAssignment_1 )? )
            // InternalAle.g:4768:2: ( rule__RecExpression__RecExpAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getRecExpAssignment_1()); 
            }
            // InternalAle.g:4769:2: ( rule__RecExpression__RecExpAssignment_1 )?
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalAle.g:4769:3: rule__RecExpression__RecExpAssignment_1
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
    // InternalAle.g:4778:1: rule__RecExpression__Group_0_1__0 : rule__RecExpression__Group_0_1__0__Impl rule__RecExpression__Group_0_1__1 ;
    public final void rule__RecExpression__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4782:1: ( rule__RecExpression__Group_0_1__0__Impl rule__RecExpression__Group_0_1__1 )
            // InternalAle.g:4783:2: rule__RecExpression__Group_0_1__0__Impl rule__RecExpression__Group_0_1__1
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
    // InternalAle.g:4790:1: rule__RecExpression__Group_0_1__0__Impl : ( RULE_MULTOP ) ;
    public final void rule__RecExpression__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4794:1: ( ( RULE_MULTOP ) )
            // InternalAle.g:4795:1: ( RULE_MULTOP )
            {
            // InternalAle.g:4795:1: ( RULE_MULTOP )
            // InternalAle.g:4796:2: RULE_MULTOP
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getMultOpTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_MULTOP,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getMultOpTerminalRuleCall_0_1_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:4805:1: rule__RecExpression__Group_0_1__1 : rule__RecExpression__Group_0_1__1__Impl ;
    public final void rule__RecExpression__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4809:1: ( rule__RecExpression__Group_0_1__1__Impl )
            // InternalAle.g:4810:2: rule__RecExpression__Group_0_1__1__Impl
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
    // InternalAle.g:4816:1: rule__RecExpression__Group_0_1__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4820:1: ( ( ruleexpression ) )
            // InternalAle.g:4821:1: ( ruleexpression )
            {
            // InternalAle.g:4821:1: ( ruleexpression )
            // InternalAle.g:4822:2: ruleexpression
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
    // InternalAle.g:4832:1: rule__RecExpression__Group_0_2__0 : rule__RecExpression__Group_0_2__0__Impl rule__RecExpression__Group_0_2__1 ;
    public final void rule__RecExpression__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4836:1: ( rule__RecExpression__Group_0_2__0__Impl rule__RecExpression__Group_0_2__1 )
            // InternalAle.g:4837:2: rule__RecExpression__Group_0_2__0__Impl rule__RecExpression__Group_0_2__1
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
    // InternalAle.g:4844:1: rule__RecExpression__Group_0_2__0__Impl : ( ruleaddOp ) ;
    public final void rule__RecExpression__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4848:1: ( ( ruleaddOp ) )
            // InternalAle.g:4849:1: ( ruleaddOp )
            {
            // InternalAle.g:4849:1: ( ruleaddOp )
            // InternalAle.g:4850:2: ruleaddOp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getAddOpParserRuleCall_0_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleaddOp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getAddOpParserRuleCall_0_2_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:4859:1: rule__RecExpression__Group_0_2__1 : rule__RecExpression__Group_0_2__1__Impl ;
    public final void rule__RecExpression__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4863:1: ( rule__RecExpression__Group_0_2__1__Impl )
            // InternalAle.g:4864:2: rule__RecExpression__Group_0_2__1__Impl
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
    // InternalAle.g:4870:1: rule__RecExpression__Group_0_2__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4874:1: ( ( ruleexpression ) )
            // InternalAle.g:4875:1: ( ruleexpression )
            {
            // InternalAle.g:4875:1: ( ruleexpression )
            // InternalAle.g:4876:2: ruleexpression
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
    // InternalAle.g:4886:1: rule__RecExpression__Group_0_3__0 : rule__RecExpression__Group_0_3__0__Impl rule__RecExpression__Group_0_3__1 ;
    public final void rule__RecExpression__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4890:1: ( rule__RecExpression__Group_0_3__0__Impl rule__RecExpression__Group_0_3__1 )
            // InternalAle.g:4891:2: rule__RecExpression__Group_0_3__0__Impl rule__RecExpression__Group_0_3__1
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
    // InternalAle.g:4898:1: rule__RecExpression__Group_0_3__0__Impl : ( rulecompOp ) ;
    public final void rule__RecExpression__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4902:1: ( ( rulecompOp ) )
            // InternalAle.g:4903:1: ( rulecompOp )
            {
            // InternalAle.g:4903:1: ( rulecompOp )
            // InternalAle.g:4904:2: rulecompOp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getCompOpParserRuleCall_0_3_0()); 
            }
            pushFollow(FOLLOW_2);
            rulecompOp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getCompOpParserRuleCall_0_3_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:4913:1: rule__RecExpression__Group_0_3__1 : rule__RecExpression__Group_0_3__1__Impl ;
    public final void rule__RecExpression__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4917:1: ( rule__RecExpression__Group_0_3__1__Impl )
            // InternalAle.g:4918:2: rule__RecExpression__Group_0_3__1__Impl
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
    // InternalAle.g:4924:1: rule__RecExpression__Group_0_3__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4928:1: ( ( ruleexpression ) )
            // InternalAle.g:4929:1: ( ruleexpression )
            {
            // InternalAle.g:4929:1: ( ruleexpression )
            // InternalAle.g:4930:2: ruleexpression
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
    // InternalAle.g:4940:1: rule__RecExpression__Group_0_4__0 : rule__RecExpression__Group_0_4__0__Impl rule__RecExpression__Group_0_4__1 ;
    public final void rule__RecExpression__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4944:1: ( rule__RecExpression__Group_0_4__0__Impl rule__RecExpression__Group_0_4__1 )
            // InternalAle.g:4945:2: rule__RecExpression__Group_0_4__0__Impl rule__RecExpression__Group_0_4__1
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
    // InternalAle.g:4952:1: rule__RecExpression__Group_0_4__0__Impl : ( 'and' ) ;
    public final void rule__RecExpression__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4956:1: ( ( 'and' ) )
            // InternalAle.g:4957:1: ( 'and' )
            {
            // InternalAle.g:4957:1: ( 'and' )
            // InternalAle.g:4958:2: 'and'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getAndKeyword_0_4_0()); 
            }
            match(input,68,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:4967:1: rule__RecExpression__Group_0_4__1 : rule__RecExpression__Group_0_4__1__Impl ;
    public final void rule__RecExpression__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4971:1: ( rule__RecExpression__Group_0_4__1__Impl )
            // InternalAle.g:4972:2: rule__RecExpression__Group_0_4__1__Impl
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
    // InternalAle.g:4978:1: rule__RecExpression__Group_0_4__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4982:1: ( ( ruleexpression ) )
            // InternalAle.g:4983:1: ( ruleexpression )
            {
            // InternalAle.g:4983:1: ( ruleexpression )
            // InternalAle.g:4984:2: ruleexpression
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
    // InternalAle.g:4994:1: rule__RecExpression__Group_0_5__0 : rule__RecExpression__Group_0_5__0__Impl rule__RecExpression__Group_0_5__1 ;
    public final void rule__RecExpression__Group_0_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4998:1: ( rule__RecExpression__Group_0_5__0__Impl rule__RecExpression__Group_0_5__1 )
            // InternalAle.g:4999:2: rule__RecExpression__Group_0_5__0__Impl rule__RecExpression__Group_0_5__1
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
    // InternalAle.g:5006:1: rule__RecExpression__Group_0_5__0__Impl : ( 'or' ) ;
    public final void rule__RecExpression__Group_0_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5010:1: ( ( 'or' ) )
            // InternalAle.g:5011:1: ( 'or' )
            {
            // InternalAle.g:5011:1: ( 'or' )
            // InternalAle.g:5012:2: 'or'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getOrKeyword_0_5_0()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:5021:1: rule__RecExpression__Group_0_5__1 : rule__RecExpression__Group_0_5__1__Impl ;
    public final void rule__RecExpression__Group_0_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5025:1: ( rule__RecExpression__Group_0_5__1__Impl )
            // InternalAle.g:5026:2: rule__RecExpression__Group_0_5__1__Impl
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
    // InternalAle.g:5032:1: rule__RecExpression__Group_0_5__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5036:1: ( ( ruleexpression ) )
            // InternalAle.g:5037:1: ( ruleexpression )
            {
            // InternalAle.g:5037:1: ( ruleexpression )
            // InternalAle.g:5038:2: ruleexpression
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
    // InternalAle.g:5048:1: rule__RecExpression__Group_0_6__0 : rule__RecExpression__Group_0_6__0__Impl rule__RecExpression__Group_0_6__1 ;
    public final void rule__RecExpression__Group_0_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5052:1: ( rule__RecExpression__Group_0_6__0__Impl rule__RecExpression__Group_0_6__1 )
            // InternalAle.g:5053:2: rule__RecExpression__Group_0_6__0__Impl rule__RecExpression__Group_0_6__1
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
    // InternalAle.g:5060:1: rule__RecExpression__Group_0_6__0__Impl : ( 'xor' ) ;
    public final void rule__RecExpression__Group_0_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5064:1: ( ( 'xor' ) )
            // InternalAle.g:5065:1: ( 'xor' )
            {
            // InternalAle.g:5065:1: ( 'xor' )
            // InternalAle.g:5066:2: 'xor'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getXorKeyword_0_6_0()); 
            }
            match(input,70,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:5075:1: rule__RecExpression__Group_0_6__1 : rule__RecExpression__Group_0_6__1__Impl ;
    public final void rule__RecExpression__Group_0_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5079:1: ( rule__RecExpression__Group_0_6__1__Impl )
            // InternalAle.g:5080:2: rule__RecExpression__Group_0_6__1__Impl
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
    // InternalAle.g:5086:1: rule__RecExpression__Group_0_6__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5090:1: ( ( ruleexpression ) )
            // InternalAle.g:5091:1: ( ruleexpression )
            {
            // InternalAle.g:5091:1: ( ruleexpression )
            // InternalAle.g:5092:2: ruleexpression
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
    // InternalAle.g:5102:1: rule__RecExpression__Group_0_7__0 : rule__RecExpression__Group_0_7__0__Impl rule__RecExpression__Group_0_7__1 ;
    public final void rule__RecExpression__Group_0_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5106:1: ( rule__RecExpression__Group_0_7__0__Impl rule__RecExpression__Group_0_7__1 )
            // InternalAle.g:5107:2: rule__RecExpression__Group_0_7__0__Impl rule__RecExpression__Group_0_7__1
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
    // InternalAle.g:5114:1: rule__RecExpression__Group_0_7__0__Impl : ( 'implies' ) ;
    public final void rule__RecExpression__Group_0_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5118:1: ( ( 'implies' ) )
            // InternalAle.g:5119:1: ( 'implies' )
            {
            // InternalAle.g:5119:1: ( 'implies' )
            // InternalAle.g:5120:2: 'implies'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getImpliesKeyword_0_7_0()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:5129:1: rule__RecExpression__Group_0_7__1 : rule__RecExpression__Group_0_7__1__Impl ;
    public final void rule__RecExpression__Group_0_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5133:1: ( rule__RecExpression__Group_0_7__1__Impl )
            // InternalAle.g:5134:2: rule__RecExpression__Group_0_7__1__Impl
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
    // InternalAle.g:5140:1: rule__RecExpression__Group_0_7__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5144:1: ( ( ruleexpression ) )
            // InternalAle.g:5145:1: ( ruleexpression )
            {
            // InternalAle.g:5145:1: ( ruleexpression )
            // InternalAle.g:5146:2: ruleexpression
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
    // InternalAle.g:5156:1: rule__NavigationSegment__Group_0__0 : rule__NavigationSegment__Group_0__0__Impl rule__NavigationSegment__Group_0__1 ;
    public final void rule__NavigationSegment__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5160:1: ( rule__NavigationSegment__Group_0__0__Impl rule__NavigationSegment__Group_0__1 )
            // InternalAle.g:5161:2: rule__NavigationSegment__Group_0__0__Impl rule__NavigationSegment__Group_0__1
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
    // InternalAle.g:5168:1: rule__NavigationSegment__Group_0__0__Impl : ( () ) ;
    public final void rule__NavigationSegment__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5172:1: ( ( () ) )
            // InternalAle.g:5173:1: ( () )
            {
            // InternalAle.g:5173:1: ( () )
            // InternalAle.g:5174:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFinalIdentSegmentAction_0_0()); 
            }
            // InternalAle.g:5175:2: ()
            // InternalAle.g:5175:3: 
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
    // InternalAle.g:5183:1: rule__NavigationSegment__Group_0__1 : rule__NavigationSegment__Group_0__1__Impl rule__NavigationSegment__Group_0__2 ;
    public final void rule__NavigationSegment__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5187:1: ( rule__NavigationSegment__Group_0__1__Impl rule__NavigationSegment__Group_0__2 )
            // InternalAle.g:5188:2: rule__NavigationSegment__Group_0__1__Impl rule__NavigationSegment__Group_0__2
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
    // InternalAle.g:5195:1: rule__NavigationSegment__Group_0__1__Impl : ( '.' ) ;
    public final void rule__NavigationSegment__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5199:1: ( ( '.' ) )
            // InternalAle.g:5200:1: ( '.' )
            {
            // InternalAle.g:5200:1: ( '.' )
            // InternalAle.g:5201:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_0_1()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:5210:1: rule__NavigationSegment__Group_0__2 : rule__NavigationSegment__Group_0__2__Impl ;
    public final void rule__NavigationSegment__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5214:1: ( rule__NavigationSegment__Group_0__2__Impl )
            // InternalAle.g:5215:2: rule__NavigationSegment__Group_0__2__Impl
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
    // InternalAle.g:5221:1: rule__NavigationSegment__Group_0__2__Impl : ( ( rule__NavigationSegment__IdentAssignment_0_2 ) ) ;
    public final void rule__NavigationSegment__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5225:1: ( ( ( rule__NavigationSegment__IdentAssignment_0_2 ) ) )
            // InternalAle.g:5226:1: ( ( rule__NavigationSegment__IdentAssignment_0_2 ) )
            {
            // InternalAle.g:5226:1: ( ( rule__NavigationSegment__IdentAssignment_0_2 ) )
            // InternalAle.g:5227:2: ( rule__NavigationSegment__IdentAssignment_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getIdentAssignment_0_2()); 
            }
            // InternalAle.g:5228:2: ( rule__NavigationSegment__IdentAssignment_0_2 )
            // InternalAle.g:5228:3: rule__NavigationSegment__IdentAssignment_0_2
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
    // InternalAle.g:5237:1: rule__NavigationSegment__Group_1__0 : rule__NavigationSegment__Group_1__0__Impl rule__NavigationSegment__Group_1__1 ;
    public final void rule__NavigationSegment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5241:1: ( rule__NavigationSegment__Group_1__0__Impl rule__NavigationSegment__Group_1__1 )
            // InternalAle.g:5242:2: rule__NavigationSegment__Group_1__0__Impl rule__NavigationSegment__Group_1__1
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
    // InternalAle.g:5249:1: rule__NavigationSegment__Group_1__0__Impl : ( () ) ;
    public final void rule__NavigationSegment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5253:1: ( ( () ) )
            // InternalAle.g:5254:1: ( () )
            {
            // InternalAle.g:5254:1: ( () )
            // InternalAle.g:5255:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFinalIdentCallSegmentAction_1_0()); 
            }
            // InternalAle.g:5256:2: ()
            // InternalAle.g:5256:3: 
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
    // InternalAle.g:5264:1: rule__NavigationSegment__Group_1__1 : rule__NavigationSegment__Group_1__1__Impl rule__NavigationSegment__Group_1__2 ;
    public final void rule__NavigationSegment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5268:1: ( rule__NavigationSegment__Group_1__1__Impl rule__NavigationSegment__Group_1__2 )
            // InternalAle.g:5269:2: rule__NavigationSegment__Group_1__1__Impl rule__NavigationSegment__Group_1__2
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
    // InternalAle.g:5276:1: rule__NavigationSegment__Group_1__1__Impl : ( '.' ) ;
    public final void rule__NavigationSegment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5280:1: ( ( '.' ) )
            // InternalAle.g:5281:1: ( '.' )
            {
            // InternalAle.g:5281:1: ( '.' )
            // InternalAle.g:5282:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_1_1()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:5291:1: rule__NavigationSegment__Group_1__2 : rule__NavigationSegment__Group_1__2__Impl ;
    public final void rule__NavigationSegment__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5295:1: ( rule__NavigationSegment__Group_1__2__Impl )
            // InternalAle.g:5296:2: rule__NavigationSegment__Group_1__2__Impl
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
    // InternalAle.g:5302:1: rule__NavigationSegment__Group_1__2__Impl : ( ( rule__NavigationSegment__CallAssignment_1_2 ) ) ;
    public final void rule__NavigationSegment__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5306:1: ( ( ( rule__NavigationSegment__CallAssignment_1_2 ) ) )
            // InternalAle.g:5307:1: ( ( rule__NavigationSegment__CallAssignment_1_2 ) )
            {
            // InternalAle.g:5307:1: ( ( rule__NavigationSegment__CallAssignment_1_2 ) )
            // InternalAle.g:5308:2: ( rule__NavigationSegment__CallAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getCallAssignment_1_2()); 
            }
            // InternalAle.g:5309:2: ( rule__NavigationSegment__CallAssignment_1_2 )
            // InternalAle.g:5309:3: rule__NavigationSegment__CallAssignment_1_2
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
    // InternalAle.g:5318:1: rule__NavigationSegment__Group_2__0 : rule__NavigationSegment__Group_2__0__Impl rule__NavigationSegment__Group_2__1 ;
    public final void rule__NavigationSegment__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5322:1: ( rule__NavigationSegment__Group_2__0__Impl rule__NavigationSegment__Group_2__1 )
            // InternalAle.g:5323:2: rule__NavigationSegment__Group_2__0__Impl rule__NavigationSegment__Group_2__1
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
    // InternalAle.g:5330:1: rule__NavigationSegment__Group_2__0__Impl : ( () ) ;
    public final void rule__NavigationSegment__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5334:1: ( ( () ) )
            // InternalAle.g:5335:1: ( () )
            {
            // InternalAle.g:5335:1: ( () )
            // InternalAle.g:5336:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFinalCallExpSegmentAction_2_0()); 
            }
            // InternalAle.g:5337:2: ()
            // InternalAle.g:5337:3: 
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
    // InternalAle.g:5345:1: rule__NavigationSegment__Group_2__1 : rule__NavigationSegment__Group_2__1__Impl rule__NavigationSegment__Group_2__2 ;
    public final void rule__NavigationSegment__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5349:1: ( rule__NavigationSegment__Group_2__1__Impl rule__NavigationSegment__Group_2__2 )
            // InternalAle.g:5350:2: rule__NavigationSegment__Group_2__1__Impl rule__NavigationSegment__Group_2__2
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
    // InternalAle.g:5357:1: rule__NavigationSegment__Group_2__1__Impl : ( '->' ) ;
    public final void rule__NavigationSegment__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5361:1: ( ( '->' ) )
            // InternalAle.g:5362:1: ( '->' )
            {
            // InternalAle.g:5362:1: ( '->' )
            // InternalAle.g:5363:2: '->'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getHyphenMinusGreaterThanSignKeyword_2_1()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:5372:1: rule__NavigationSegment__Group_2__2 : rule__NavigationSegment__Group_2__2__Impl ;
    public final void rule__NavigationSegment__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5376:1: ( rule__NavigationSegment__Group_2__2__Impl )
            // InternalAle.g:5377:2: rule__NavigationSegment__Group_2__2__Impl
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
    // InternalAle.g:5383:1: rule__NavigationSegment__Group_2__2__Impl : ( ( rule__NavigationSegment__CallAssignment_2_2 ) ) ;
    public final void rule__NavigationSegment__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5387:1: ( ( ( rule__NavigationSegment__CallAssignment_2_2 ) ) )
            // InternalAle.g:5388:1: ( ( rule__NavigationSegment__CallAssignment_2_2 ) )
            {
            // InternalAle.g:5388:1: ( ( rule__NavigationSegment__CallAssignment_2_2 ) )
            // InternalAle.g:5389:2: ( rule__NavigationSegment__CallAssignment_2_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getCallAssignment_2_2()); 
            }
            // InternalAle.g:5390:2: ( rule__NavigationSegment__CallAssignment_2_2 )
            // InternalAle.g:5390:3: rule__NavigationSegment__CallAssignment_2_2
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
    // InternalAle.g:5399:1: rule__NonLeftRecExpression__Group_0__0 : rule__NonLeftRecExpression__Group_0__0__Impl rule__NonLeftRecExpression__Group_0__1 ;
    public final void rule__NonLeftRecExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5403:1: ( rule__NonLeftRecExpression__Group_0__0__Impl rule__NonLeftRecExpression__Group_0__1 )
            // InternalAle.g:5404:2: rule__NonLeftRecExpression__Group_0__0__Impl rule__NonLeftRecExpression__Group_0__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalAle.g:5411:1: rule__NonLeftRecExpression__Group_0__0__Impl : ( 'not' ) ;
    public final void rule__NonLeftRecExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5415:1: ( ( 'not' ) )
            // InternalAle.g:5416:1: ( 'not' )
            {
            // InternalAle.g:5416:1: ( 'not' )
            // InternalAle.g:5417:2: 'not'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getNotKeyword_0_0()); 
            }
            match(input,73,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getNotKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_0__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_0__1"
    // InternalAle.g:5426:1: rule__NonLeftRecExpression__Group_0__1 : rule__NonLeftRecExpression__Group_0__1__Impl ;
    public final void rule__NonLeftRecExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5430:1: ( rule__NonLeftRecExpression__Group_0__1__Impl )
            // InternalAle.g:5431:2: rule__NonLeftRecExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_0__1__Impl();

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
    // InternalAle.g:5437:1: rule__NonLeftRecExpression__Group_0__1__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5441:1: ( ( ruleexpression ) )
            // InternalAle.g:5442:1: ( ruleexpression )
            {
            // InternalAle.g:5442:1: ( ruleexpression )
            // InternalAle.g:5443:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_0_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__NonLeftRecExpression__Group_1__0"
    // InternalAle.g:5453:1: rule__NonLeftRecExpression__Group_1__0 : rule__NonLeftRecExpression__Group_1__0__Impl rule__NonLeftRecExpression__Group_1__1 ;
    public final void rule__NonLeftRecExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5457:1: ( rule__NonLeftRecExpression__Group_1__0__Impl rule__NonLeftRecExpression__Group_1__1 )
            // InternalAle.g:5458:2: rule__NonLeftRecExpression__Group_1__0__Impl rule__NonLeftRecExpression__Group_1__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalAle.g:5465:1: rule__NonLeftRecExpression__Group_1__0__Impl : ( '-' ) ;
    public final void rule__NonLeftRecExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5469:1: ( ( '-' ) )
            // InternalAle.g:5470:1: ( '-' )
            {
            // InternalAle.g:5470:1: ( '-' )
            // InternalAle.g:5471:2: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getHyphenMinusKeyword_1_0()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getHyphenMinusKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_1__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_1__1"
    // InternalAle.g:5480:1: rule__NonLeftRecExpression__Group_1__1 : rule__NonLeftRecExpression__Group_1__1__Impl ;
    public final void rule__NonLeftRecExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5484:1: ( rule__NonLeftRecExpression__Group_1__1__Impl )
            // InternalAle.g:5485:2: rule__NonLeftRecExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_1__1__Impl();

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
    // InternalAle.g:5491:1: rule__NonLeftRecExpression__Group_1__1__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5495:1: ( ( ruleexpression ) )
            // InternalAle.g:5496:1: ( ruleexpression )
            {
            // InternalAle.g:5496:1: ( ruleexpression )
            // InternalAle.g:5497:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_1_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__0"
    // InternalAle.g:5507:1: rule__NonLeftRecExpression__Group_4__0 : rule__NonLeftRecExpression__Group_4__0__Impl rule__NonLeftRecExpression__Group_4__1 ;
    public final void rule__NonLeftRecExpression__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5511:1: ( rule__NonLeftRecExpression__Group_4__0__Impl rule__NonLeftRecExpression__Group_4__1 )
            // InternalAle.g:5512:2: rule__NonLeftRecExpression__Group_4__0__Impl rule__NonLeftRecExpression__Group_4__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalAle.g:5519:1: rule__NonLeftRecExpression__Group_4__0__Impl : ( '(' ) ;
    public final void rule__NonLeftRecExpression__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5523:1: ( ( '(' ) )
            // InternalAle.g:5524:1: ( '(' )
            {
            // InternalAle.g:5524:1: ( '(' )
            // InternalAle.g:5525:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLeftParenthesisKeyword_4_0()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLeftParenthesisKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_4__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_4__1"
    // InternalAle.g:5534:1: rule__NonLeftRecExpression__Group_4__1 : rule__NonLeftRecExpression__Group_4__1__Impl rule__NonLeftRecExpression__Group_4__2 ;
    public final void rule__NonLeftRecExpression__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5538:1: ( rule__NonLeftRecExpression__Group_4__1__Impl rule__NonLeftRecExpression__Group_4__2 )
            // InternalAle.g:5539:2: rule__NonLeftRecExpression__Group_4__1__Impl rule__NonLeftRecExpression__Group_4__2
            {
            pushFollow(FOLLOW_35);
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
    // InternalAle.g:5546:1: rule__NonLeftRecExpression__Group_4__1__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5550:1: ( ( ruleexpression ) )
            // InternalAle.g:5551:1: ( ruleexpression )
            {
            // InternalAle.g:5551:1: ( ruleexpression )
            // InternalAle.g:5552:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_4_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_4_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:5561:1: rule__NonLeftRecExpression__Group_4__2 : rule__NonLeftRecExpression__Group_4__2__Impl ;
    public final void rule__NonLeftRecExpression__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5565:1: ( rule__NonLeftRecExpression__Group_4__2__Impl )
            // InternalAle.g:5566:2: rule__NonLeftRecExpression__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_4__2__Impl();

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
    // InternalAle.g:5572:1: rule__NonLeftRecExpression__Group_4__2__Impl : ( ')' ) ;
    public final void rule__NonLeftRecExpression__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5576:1: ( ( ')' ) )
            // InternalAle.g:5577:1: ( ')' )
            {
            // InternalAle.g:5577:1: ( ')' )
            // InternalAle.g:5578:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getRightParenthesisKeyword_4_2()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getRightParenthesisKeyword_4_2()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__0"
    // InternalAle.g:5588:1: rule__NonLeftRecExpression__Group_5__0 : rule__NonLeftRecExpression__Group_5__0__Impl rule__NonLeftRecExpression__Group_5__1 ;
    public final void rule__NonLeftRecExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5592:1: ( rule__NonLeftRecExpression__Group_5__0__Impl rule__NonLeftRecExpression__Group_5__1 )
            // InternalAle.g:5593:2: rule__NonLeftRecExpression__Group_5__0__Impl rule__NonLeftRecExpression__Group_5__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalAle.g:5600:1: rule__NonLeftRecExpression__Group_5__0__Impl : ( 'if' ) ;
    public final void rule__NonLeftRecExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5604:1: ( ( 'if' ) )
            // InternalAle.g:5605:1: ( 'if' )
            {
            // InternalAle.g:5605:1: ( 'if' )
            // InternalAle.g:5606:2: 'if'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getIfKeyword_5_0()); 
            }
            match(input,65,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getIfKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_5__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_5__1"
    // InternalAle.g:5615:1: rule__NonLeftRecExpression__Group_5__1 : rule__NonLeftRecExpression__Group_5__1__Impl rule__NonLeftRecExpression__Group_5__2 ;
    public final void rule__NonLeftRecExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5619:1: ( rule__NonLeftRecExpression__Group_5__1__Impl rule__NonLeftRecExpression__Group_5__2 )
            // InternalAle.g:5620:2: rule__NonLeftRecExpression__Group_5__1__Impl rule__NonLeftRecExpression__Group_5__2
            {
            pushFollow(FOLLOW_47);
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
    // InternalAle.g:5627:1: rule__NonLeftRecExpression__Group_5__1__Impl : ( ( rule__NonLeftRecExpression__ConditionAssignment_5_1 ) ) ;
    public final void rule__NonLeftRecExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5631:1: ( ( ( rule__NonLeftRecExpression__ConditionAssignment_5_1 ) ) )
            // InternalAle.g:5632:1: ( ( rule__NonLeftRecExpression__ConditionAssignment_5_1 ) )
            {
            // InternalAle.g:5632:1: ( ( rule__NonLeftRecExpression__ConditionAssignment_5_1 ) )
            // InternalAle.g:5633:2: ( rule__NonLeftRecExpression__ConditionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getConditionAssignment_5_1()); 
            }
            // InternalAle.g:5634:2: ( rule__NonLeftRecExpression__ConditionAssignment_5_1 )
            // InternalAle.g:5634:3: rule__NonLeftRecExpression__ConditionAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__ConditionAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getConditionAssignment_5_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:5642:1: rule__NonLeftRecExpression__Group_5__2 : rule__NonLeftRecExpression__Group_5__2__Impl rule__NonLeftRecExpression__Group_5__3 ;
    public final void rule__NonLeftRecExpression__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5646:1: ( rule__NonLeftRecExpression__Group_5__2__Impl rule__NonLeftRecExpression__Group_5__3 )
            // InternalAle.g:5647:2: rule__NonLeftRecExpression__Group_5__2__Impl rule__NonLeftRecExpression__Group_5__3
            {
            pushFollow(FOLLOW_28);
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
    // InternalAle.g:5654:1: rule__NonLeftRecExpression__Group_5__2__Impl : ( 'then' ) ;
    public final void rule__NonLeftRecExpression__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5658:1: ( ( 'then' ) )
            // InternalAle.g:5659:1: ( 'then' )
            {
            // InternalAle.g:5659:1: ( 'then' )
            // InternalAle.g:5660:2: 'then'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getThenKeyword_5_2()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getThenKeyword_5_2()); 
            }

            }


            }

        }
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
    // InternalAle.g:5669:1: rule__NonLeftRecExpression__Group_5__3 : rule__NonLeftRecExpression__Group_5__3__Impl rule__NonLeftRecExpression__Group_5__4 ;
    public final void rule__NonLeftRecExpression__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5673:1: ( rule__NonLeftRecExpression__Group_5__3__Impl rule__NonLeftRecExpression__Group_5__4 )
            // InternalAle.g:5674:2: rule__NonLeftRecExpression__Group_5__3__Impl rule__NonLeftRecExpression__Group_5__4
            {
            pushFollow(FOLLOW_42);
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
    // InternalAle.g:5681:1: rule__NonLeftRecExpression__Group_5__3__Impl : ( ( rule__NonLeftRecExpression__IfBlockAssignment_5_3 ) ) ;
    public final void rule__NonLeftRecExpression__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5685:1: ( ( ( rule__NonLeftRecExpression__IfBlockAssignment_5_3 ) ) )
            // InternalAle.g:5686:1: ( ( rule__NonLeftRecExpression__IfBlockAssignment_5_3 ) )
            {
            // InternalAle.g:5686:1: ( ( rule__NonLeftRecExpression__IfBlockAssignment_5_3 ) )
            // InternalAle.g:5687:2: ( rule__NonLeftRecExpression__IfBlockAssignment_5_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getIfBlockAssignment_5_3()); 
            }
            // InternalAle.g:5688:2: ( rule__NonLeftRecExpression__IfBlockAssignment_5_3 )
            // InternalAle.g:5688:3: rule__NonLeftRecExpression__IfBlockAssignment_5_3
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__IfBlockAssignment_5_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getIfBlockAssignment_5_3()); 
            }

            }


            }

        }
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
    // InternalAle.g:5696:1: rule__NonLeftRecExpression__Group_5__4 : rule__NonLeftRecExpression__Group_5__4__Impl rule__NonLeftRecExpression__Group_5__5 ;
    public final void rule__NonLeftRecExpression__Group_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5700:1: ( rule__NonLeftRecExpression__Group_5__4__Impl rule__NonLeftRecExpression__Group_5__5 )
            // InternalAle.g:5701:2: rule__NonLeftRecExpression__Group_5__4__Impl rule__NonLeftRecExpression__Group_5__5
            {
            pushFollow(FOLLOW_28);
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
    // InternalAle.g:5708:1: rule__NonLeftRecExpression__Group_5__4__Impl : ( 'else' ) ;
    public final void rule__NonLeftRecExpression__Group_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5712:1: ( ( 'else' ) )
            // InternalAle.g:5713:1: ( 'else' )
            {
            // InternalAle.g:5713:1: ( 'else' )
            // InternalAle.g:5714:2: 'else'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getElseKeyword_5_4()); 
            }
            match(input,66,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getElseKeyword_5_4()); 
            }

            }


            }

        }
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
    // InternalAle.g:5723:1: rule__NonLeftRecExpression__Group_5__5 : rule__NonLeftRecExpression__Group_5__5__Impl rule__NonLeftRecExpression__Group_5__6 ;
    public final void rule__NonLeftRecExpression__Group_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5727:1: ( rule__NonLeftRecExpression__Group_5__5__Impl rule__NonLeftRecExpression__Group_5__6 )
            // InternalAle.g:5728:2: rule__NonLeftRecExpression__Group_5__5__Impl rule__NonLeftRecExpression__Group_5__6
            {
            pushFollow(FOLLOW_48);
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
    // InternalAle.g:5735:1: rule__NonLeftRecExpression__Group_5__5__Impl : ( ( rule__NonLeftRecExpression__ElseBlockAssignment_5_5 ) ) ;
    public final void rule__NonLeftRecExpression__Group_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5739:1: ( ( ( rule__NonLeftRecExpression__ElseBlockAssignment_5_5 ) ) )
            // InternalAle.g:5740:1: ( ( rule__NonLeftRecExpression__ElseBlockAssignment_5_5 ) )
            {
            // InternalAle.g:5740:1: ( ( rule__NonLeftRecExpression__ElseBlockAssignment_5_5 ) )
            // InternalAle.g:5741:2: ( rule__NonLeftRecExpression__ElseBlockAssignment_5_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getElseBlockAssignment_5_5()); 
            }
            // InternalAle.g:5742:2: ( rule__NonLeftRecExpression__ElseBlockAssignment_5_5 )
            // InternalAle.g:5742:3: rule__NonLeftRecExpression__ElseBlockAssignment_5_5
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__ElseBlockAssignment_5_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getElseBlockAssignment_5_5()); 
            }

            }


            }

        }
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
    // InternalAle.g:5750:1: rule__NonLeftRecExpression__Group_5__6 : rule__NonLeftRecExpression__Group_5__6__Impl ;
    public final void rule__NonLeftRecExpression__Group_5__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5754:1: ( rule__NonLeftRecExpression__Group_5__6__Impl )
            // InternalAle.g:5755:2: rule__NonLeftRecExpression__Group_5__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_5__6__Impl();

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
    // InternalAle.g:5761:1: rule__NonLeftRecExpression__Group_5__6__Impl : ( 'endif' ) ;
    public final void rule__NonLeftRecExpression__Group_5__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5765:1: ( ( 'endif' ) )
            // InternalAle.g:5766:1: ( 'endif' )
            {
            // InternalAle.g:5766:1: ( 'endif' )
            // InternalAle.g:5767:2: 'endif'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getEndifKeyword_5_6()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getEndifKeyword_5_6()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__0"
    // InternalAle.g:5777:1: rule__NonLeftRecExpression__Group_6__0 : rule__NonLeftRecExpression__Group_6__0__Impl rule__NonLeftRecExpression__Group_6__1 ;
    public final void rule__NonLeftRecExpression__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5781:1: ( rule__NonLeftRecExpression__Group_6__0__Impl rule__NonLeftRecExpression__Group_6__1 )
            // InternalAle.g:5782:2: rule__NonLeftRecExpression__Group_6__0__Impl rule__NonLeftRecExpression__Group_6__1
            {
            pushFollow(FOLLOW_3);
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
    // InternalAle.g:5789:1: rule__NonLeftRecExpression__Group_6__0__Impl : ( 'let' ) ;
    public final void rule__NonLeftRecExpression__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5793:1: ( ( 'let' ) )
            // InternalAle.g:5794:1: ( 'let' )
            {
            // InternalAle.g:5794:1: ( 'let' )
            // InternalAle.g:5795:2: 'let'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLetKeyword_6_0()); 
            }
            match(input,76,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLetKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6__1"
    // InternalAle.g:5804:1: rule__NonLeftRecExpression__Group_6__1 : rule__NonLeftRecExpression__Group_6__1__Impl rule__NonLeftRecExpression__Group_6__2 ;
    public final void rule__NonLeftRecExpression__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5808:1: ( rule__NonLeftRecExpression__Group_6__1__Impl rule__NonLeftRecExpression__Group_6__2 )
            // InternalAle.g:5809:2: rule__NonLeftRecExpression__Group_6__1__Impl rule__NonLeftRecExpression__Group_6__2
            {
            pushFollow(FOLLOW_49);
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
    // InternalAle.g:5816:1: rule__NonLeftRecExpression__Group_6__1__Impl : ( ( rule__NonLeftRecExpression__BindingsAssignment_6_1 ) ) ;
    public final void rule__NonLeftRecExpression__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5820:1: ( ( ( rule__NonLeftRecExpression__BindingsAssignment_6_1 ) ) )
            // InternalAle.g:5821:1: ( ( rule__NonLeftRecExpression__BindingsAssignment_6_1 ) )
            {
            // InternalAle.g:5821:1: ( ( rule__NonLeftRecExpression__BindingsAssignment_6_1 ) )
            // InternalAle.g:5822:2: ( rule__NonLeftRecExpression__BindingsAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_1()); 
            }
            // InternalAle.g:5823:2: ( rule__NonLeftRecExpression__BindingsAssignment_6_1 )
            // InternalAle.g:5823:3: rule__NonLeftRecExpression__BindingsAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__BindingsAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:5831:1: rule__NonLeftRecExpression__Group_6__2 : rule__NonLeftRecExpression__Group_6__2__Impl rule__NonLeftRecExpression__Group_6__3 ;
    public final void rule__NonLeftRecExpression__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5835:1: ( rule__NonLeftRecExpression__Group_6__2__Impl rule__NonLeftRecExpression__Group_6__3 )
            // InternalAle.g:5836:2: rule__NonLeftRecExpression__Group_6__2__Impl rule__NonLeftRecExpression__Group_6__3
            {
            pushFollow(FOLLOW_49);
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
    // InternalAle.g:5843:1: rule__NonLeftRecExpression__Group_6__2__Impl : ( ( rule__NonLeftRecExpression__Group_6_2__0 )* ) ;
    public final void rule__NonLeftRecExpression__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5847:1: ( ( ( rule__NonLeftRecExpression__Group_6_2__0 )* ) )
            // InternalAle.g:5848:1: ( ( rule__NonLeftRecExpression__Group_6_2__0 )* )
            {
            // InternalAle.g:5848:1: ( ( rule__NonLeftRecExpression__Group_6_2__0 )* )
            // InternalAle.g:5849:2: ( rule__NonLeftRecExpression__Group_6_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6_2()); 
            }
            // InternalAle.g:5850:2: ( rule__NonLeftRecExpression__Group_6_2__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==55) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalAle.g:5850:3: rule__NonLeftRecExpression__Group_6_2__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__NonLeftRecExpression__Group_6_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6_2()); 
            }

            }


            }

        }
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
    // InternalAle.g:5858:1: rule__NonLeftRecExpression__Group_6__3 : rule__NonLeftRecExpression__Group_6__3__Impl rule__NonLeftRecExpression__Group_6__4 ;
    public final void rule__NonLeftRecExpression__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5862:1: ( rule__NonLeftRecExpression__Group_6__3__Impl rule__NonLeftRecExpression__Group_6__4 )
            // InternalAle.g:5863:2: rule__NonLeftRecExpression__Group_6__3__Impl rule__NonLeftRecExpression__Group_6__4
            {
            pushFollow(FOLLOW_28);
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
    // InternalAle.g:5870:1: rule__NonLeftRecExpression__Group_6__3__Impl : ( 'in' ) ;
    public final void rule__NonLeftRecExpression__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5874:1: ( ( 'in' ) )
            // InternalAle.g:5875:1: ( 'in' )
            {
            // InternalAle.g:5875:1: ( 'in' )
            // InternalAle.g:5876:2: 'in'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getInKeyword_6_3()); 
            }
            match(input,61,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getInKeyword_6_3()); 
            }

            }


            }

        }
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
    // InternalAle.g:5885:1: rule__NonLeftRecExpression__Group_6__4 : rule__NonLeftRecExpression__Group_6__4__Impl ;
    public final void rule__NonLeftRecExpression__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5889:1: ( rule__NonLeftRecExpression__Group_6__4__Impl )
            // InternalAle.g:5890:2: rule__NonLeftRecExpression__Group_6__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6__4__Impl();

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
    // InternalAle.g:5896:1: rule__NonLeftRecExpression__Group_6__4__Impl : ( ( rule__NonLeftRecExpression__LetExprAssignment_6_4 ) ) ;
    public final void rule__NonLeftRecExpression__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5900:1: ( ( ( rule__NonLeftRecExpression__LetExprAssignment_6_4 ) ) )
            // InternalAle.g:5901:1: ( ( rule__NonLeftRecExpression__LetExprAssignment_6_4 ) )
            {
            // InternalAle.g:5901:1: ( ( rule__NonLeftRecExpression__LetExprAssignment_6_4 ) )
            // InternalAle.g:5902:2: ( rule__NonLeftRecExpression__LetExprAssignment_6_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLetExprAssignment_6_4()); 
            }
            // InternalAle.g:5903:2: ( rule__NonLeftRecExpression__LetExprAssignment_6_4 )
            // InternalAle.g:5903:3: rule__NonLeftRecExpression__LetExprAssignment_6_4
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__LetExprAssignment_6_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLetExprAssignment_6_4()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__NonLeftRecExpression__Group_6_2__0"
    // InternalAle.g:5912:1: rule__NonLeftRecExpression__Group_6_2__0 : rule__NonLeftRecExpression__Group_6_2__0__Impl rule__NonLeftRecExpression__Group_6_2__1 ;
    public final void rule__NonLeftRecExpression__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5916:1: ( rule__NonLeftRecExpression__Group_6_2__0__Impl rule__NonLeftRecExpression__Group_6_2__1 )
            // InternalAle.g:5917:2: rule__NonLeftRecExpression__Group_6_2__0__Impl rule__NonLeftRecExpression__Group_6_2__1
            {
            pushFollow(FOLLOW_3);
            rule__NonLeftRecExpression__Group_6_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6_2__1();

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
    // $ANTLR end "rule__NonLeftRecExpression__Group_6_2__0"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6_2__0__Impl"
    // InternalAle.g:5924:1: rule__NonLeftRecExpression__Group_6_2__0__Impl : ( ',' ) ;
    public final void rule__NonLeftRecExpression__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5928:1: ( ( ',' ) )
            // InternalAle.g:5929:1: ( ',' )
            {
            // InternalAle.g:5929:1: ( ',' )
            // InternalAle.g:5930:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getCommaKeyword_6_2_0()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getCommaKeyword_6_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6_2__0__Impl"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6_2__1"
    // InternalAle.g:5939:1: rule__NonLeftRecExpression__Group_6_2__1 : rule__NonLeftRecExpression__Group_6_2__1__Impl ;
    public final void rule__NonLeftRecExpression__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5943:1: ( rule__NonLeftRecExpression__Group_6_2__1__Impl )
            // InternalAle.g:5944:2: rule__NonLeftRecExpression__Group_6_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__Group_6_2__1__Impl();

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
    // $ANTLR end "rule__NonLeftRecExpression__Group_6_2__1"


    // $ANTLR start "rule__NonLeftRecExpression__Group_6_2__1__Impl"
    // InternalAle.g:5950:1: rule__NonLeftRecExpression__Group_6_2__1__Impl : ( ( rule__NonLeftRecExpression__BindingsAssignment_6_2_1 ) ) ;
    public final void rule__NonLeftRecExpression__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5954:1: ( ( ( rule__NonLeftRecExpression__BindingsAssignment_6_2_1 ) ) )
            // InternalAle.g:5955:1: ( ( rule__NonLeftRecExpression__BindingsAssignment_6_2_1 ) )
            {
            // InternalAle.g:5955:1: ( ( rule__NonLeftRecExpression__BindingsAssignment_6_2_1 ) )
            // InternalAle.g:5956:2: ( rule__NonLeftRecExpression__BindingsAssignment_6_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_2_1()); 
            }
            // InternalAle.g:5957:2: ( rule__NonLeftRecExpression__BindingsAssignment_6_2_1 )
            // InternalAle.g:5957:3: rule__NonLeftRecExpression__BindingsAssignment_6_2_1
            {
            pushFollow(FOLLOW_2);
            rule__NonLeftRecExpression__BindingsAssignment_6_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__Group_6_2__1__Impl"


    // $ANTLR start "rule__Binding__Group__0"
    // InternalAle.g:5966:1: rule__Binding__Group__0 : rule__Binding__Group__0__Impl rule__Binding__Group__1 ;
    public final void rule__Binding__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5970:1: ( rule__Binding__Group__0__Impl rule__Binding__Group__1 )
            // InternalAle.g:5971:2: rule__Binding__Group__0__Impl rule__Binding__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalAle.g:5978:1: rule__Binding__Group__0__Impl : ( RULE_IDENT ) ;
    public final void rule__Binding__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5982:1: ( ( RULE_IDENT ) )
            // InternalAle.g:5983:1: ( RULE_IDENT )
            {
            // InternalAle.g:5983:1: ( RULE_IDENT )
            // InternalAle.g:5984:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getIdentTerminalRuleCall_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getIdentTerminalRuleCall_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:5993:1: rule__Binding__Group__1 : rule__Binding__Group__1__Impl rule__Binding__Group__2 ;
    public final void rule__Binding__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5997:1: ( rule__Binding__Group__1__Impl rule__Binding__Group__2 )
            // InternalAle.g:5998:2: rule__Binding__Group__1__Impl rule__Binding__Group__2
            {
            pushFollow(FOLLOW_50);
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
    // InternalAle.g:6005:1: rule__Binding__Group__1__Impl : ( ( rule__Binding__Group_1__0 )? ) ;
    public final void rule__Binding__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6009:1: ( ( ( rule__Binding__Group_1__0 )? ) )
            // InternalAle.g:6010:1: ( ( rule__Binding__Group_1__0 )? )
            {
            // InternalAle.g:6010:1: ( ( rule__Binding__Group_1__0 )? )
            // InternalAle.g:6011:2: ( rule__Binding__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getGroup_1()); 
            }
            // InternalAle.g:6012:2: ( rule__Binding__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==77) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAle.g:6012:3: rule__Binding__Group_1__0
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
    // InternalAle.g:6020:1: rule__Binding__Group__2 : rule__Binding__Group__2__Impl rule__Binding__Group__3 ;
    public final void rule__Binding__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6024:1: ( rule__Binding__Group__2__Impl rule__Binding__Group__3 )
            // InternalAle.g:6025:2: rule__Binding__Group__2__Impl rule__Binding__Group__3
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
    // InternalAle.g:6032:1: rule__Binding__Group__2__Impl : ( '=' ) ;
    public final void rule__Binding__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6036:1: ( ( '=' ) )
            // InternalAle.g:6037:1: ( '=' )
            {
            // InternalAle.g:6037:1: ( '=' )
            // InternalAle.g:6038:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getEqualsSignKeyword_2()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6047:1: rule__Binding__Group__3 : rule__Binding__Group__3__Impl ;
    public final void rule__Binding__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6051:1: ( rule__Binding__Group__3__Impl )
            // InternalAle.g:6052:2: rule__Binding__Group__3__Impl
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
    // InternalAle.g:6058:1: rule__Binding__Group__3__Impl : ( ruleexpression ) ;
    public final void rule__Binding__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6062:1: ( ( ruleexpression ) )
            // InternalAle.g:6063:1: ( ruleexpression )
            {
            // InternalAle.g:6063:1: ( ruleexpression )
            // InternalAle.g:6064:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getExpressionParserRuleCall_3()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getExpressionParserRuleCall_3()); 
            }

            }


            }

        }
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
    // InternalAle.g:6074:1: rule__Binding__Group_1__0 : rule__Binding__Group_1__0__Impl rule__Binding__Group_1__1 ;
    public final void rule__Binding__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6078:1: ( rule__Binding__Group_1__0__Impl rule__Binding__Group_1__1 )
            // InternalAle.g:6079:2: rule__Binding__Group_1__0__Impl rule__Binding__Group_1__1
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
    // InternalAle.g:6086:1: rule__Binding__Group_1__0__Impl : ( ':' ) ;
    public final void rule__Binding__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6090:1: ( ( ':' ) )
            // InternalAle.g:6091:1: ( ':' )
            {
            // InternalAle.g:6091:1: ( ':' )
            // InternalAle.g:6092:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getColonKeyword_1_0()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6101:1: rule__Binding__Group_1__1 : rule__Binding__Group_1__1__Impl ;
    public final void rule__Binding__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6105:1: ( rule__Binding__Group_1__1__Impl )
            // InternalAle.g:6106:2: rule__Binding__Group_1__1__Impl
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
    // InternalAle.g:6112:1: rule__Binding__Group_1__1__Impl : ( ruletypeLiteral ) ;
    public final void rule__Binding__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6116:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:6117:1: ( ruletypeLiteral )
            {
            // InternalAle.g:6117:1: ( ruletypeLiteral )
            // InternalAle.g:6118:2: ruletypeLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getTypeLiteralParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_2);
            ruletypeLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBindingAccess().getTypeLiteralParserRuleCall_1_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:6128:1: rule__CallExp__Group_0__0 : rule__CallExp__Group_0__0__Impl rule__CallExp__Group_0__1 ;
    public final void rule__CallExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6132:1: ( rule__CallExp__Group_0__0__Impl rule__CallExp__Group_0__1 )
            // InternalAle.g:6133:2: rule__CallExp__Group_0__0__Impl rule__CallExp__Group_0__1
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
    // InternalAle.g:6140:1: rule__CallExp__Group_0__0__Impl : ( rulecollectionIterator ) ;
    public final void rule__CallExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6144:1: ( ( rulecollectionIterator ) )
            // InternalAle.g:6145:1: ( rulecollectionIterator )
            {
            // InternalAle.g:6145:1: ( rulecollectionIterator )
            // InternalAle.g:6146:2: rulecollectionIterator
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
    // InternalAle.g:6155:1: rule__CallExp__Group_0__1 : rule__CallExp__Group_0__1__Impl rule__CallExp__Group_0__2 ;
    public final void rule__CallExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6159:1: ( rule__CallExp__Group_0__1__Impl rule__CallExp__Group_0__2 )
            // InternalAle.g:6160:2: rule__CallExp__Group_0__1__Impl rule__CallExp__Group_0__2
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
    // InternalAle.g:6167:1: rule__CallExp__Group_0__1__Impl : ( '(' ) ;
    public final void rule__CallExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6171:1: ( ( '(' ) )
            // InternalAle.g:6172:1: ( '(' )
            {
            // InternalAle.g:6172:1: ( '(' )
            // InternalAle.g:6173:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_0_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6182:1: rule__CallExp__Group_0__2 : rule__CallExp__Group_0__2__Impl rule__CallExp__Group_0__3 ;
    public final void rule__CallExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6186:1: ( rule__CallExp__Group_0__2__Impl rule__CallExp__Group_0__3 )
            // InternalAle.g:6187:2: rule__CallExp__Group_0__2__Impl rule__CallExp__Group_0__3
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
    // InternalAle.g:6194:1: rule__CallExp__Group_0__2__Impl : ( rulevariableDefinition ) ;
    public final void rule__CallExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6198:1: ( ( rulevariableDefinition ) )
            // InternalAle.g:6199:1: ( rulevariableDefinition )
            {
            // InternalAle.g:6199:1: ( rulevariableDefinition )
            // InternalAle.g:6200:2: rulevariableDefinition
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
    // InternalAle.g:6209:1: rule__CallExp__Group_0__3 : rule__CallExp__Group_0__3__Impl rule__CallExp__Group_0__4 ;
    public final void rule__CallExp__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6213:1: ( rule__CallExp__Group_0__3__Impl rule__CallExp__Group_0__4 )
            // InternalAle.g:6214:2: rule__CallExp__Group_0__3__Impl rule__CallExp__Group_0__4
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
    // InternalAle.g:6221:1: rule__CallExp__Group_0__3__Impl : ( ruleexpression ) ;
    public final void rule__CallExp__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6225:1: ( ( ruleexpression ) )
            // InternalAle.g:6226:1: ( ruleexpression )
            {
            // InternalAle.g:6226:1: ( ruleexpression )
            // InternalAle.g:6227:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getExpressionParserRuleCall_0_3()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getExpressionParserRuleCall_0_3()); 
            }

            }


            }

        }
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
    // InternalAle.g:6236:1: rule__CallExp__Group_0__4 : rule__CallExp__Group_0__4__Impl ;
    public final void rule__CallExp__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6240:1: ( rule__CallExp__Group_0__4__Impl )
            // InternalAle.g:6241:2: rule__CallExp__Group_0__4__Impl
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
    // InternalAle.g:6247:1: rule__CallExp__Group_0__4__Impl : ( ')' ) ;
    public final void rule__CallExp__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6251:1: ( ( ')' ) )
            // InternalAle.g:6252:1: ( ')' )
            {
            // InternalAle.g:6252:1: ( ')' )
            // InternalAle.g:6253:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getRightParenthesisKeyword_0_4()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6263:1: rule__CallExp__Group_1__0 : rule__CallExp__Group_1__0__Impl rule__CallExp__Group_1__1 ;
    public final void rule__CallExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6267:1: ( rule__CallExp__Group_1__0__Impl rule__CallExp__Group_1__1 )
            // InternalAle.g:6268:2: rule__CallExp__Group_1__0__Impl rule__CallExp__Group_1__1
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
    // InternalAle.g:6275:1: rule__CallExp__Group_1__0__Impl : ( RULE_IDENT ) ;
    public final void rule__CallExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6279:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6280:1: ( RULE_IDENT )
            {
            // InternalAle.g:6280:1: ( RULE_IDENT )
            // InternalAle.g:6281:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getIdentTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getIdentTerminalRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:6290:1: rule__CallExp__Group_1__1 : rule__CallExp__Group_1__1__Impl rule__CallExp__Group_1__2 ;
    public final void rule__CallExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6294:1: ( rule__CallExp__Group_1__1__Impl rule__CallExp__Group_1__2 )
            // InternalAle.g:6295:2: rule__CallExp__Group_1__1__Impl rule__CallExp__Group_1__2
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
    // InternalAle.g:6302:1: rule__CallExp__Group_1__1__Impl : ( '(' ) ;
    public final void rule__CallExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6306:1: ( ( '(' ) )
            // InternalAle.g:6307:1: ( '(' )
            {
            // InternalAle.g:6307:1: ( '(' )
            // InternalAle.g:6308:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getLeftParenthesisKeyword_1_1()); 
            }
            match(input,56,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6317:1: rule__CallExp__Group_1__2 : rule__CallExp__Group_1__2__Impl rule__CallExp__Group_1__3 ;
    public final void rule__CallExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6321:1: ( rule__CallExp__Group_1__2__Impl rule__CallExp__Group_1__3 )
            // InternalAle.g:6322:2: rule__CallExp__Group_1__2__Impl rule__CallExp__Group_1__3
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
    // InternalAle.g:6329:1: rule__CallExp__Group_1__2__Impl : ( ruleexpressionSequence ) ;
    public final void rule__CallExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6333:1: ( ( ruleexpressionSequence ) )
            // InternalAle.g:6334:1: ( ruleexpressionSequence )
            {
            // InternalAle.g:6334:1: ( ruleexpressionSequence )
            // InternalAle.g:6335:2: ruleexpressionSequence
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
    // InternalAle.g:6344:1: rule__CallExp__Group_1__3 : rule__CallExp__Group_1__3__Impl ;
    public final void rule__CallExp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6348:1: ( rule__CallExp__Group_1__3__Impl )
            // InternalAle.g:6349:2: rule__CallExp__Group_1__3__Impl
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
    // InternalAle.g:6355:1: rule__CallExp__Group_1__3__Impl : ( ')' ) ;
    public final void rule__CallExp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6359:1: ( ( ')' ) )
            // InternalAle.g:6360:1: ( ')' )
            {
            // InternalAle.g:6360:1: ( ')' )
            // InternalAle.g:6361:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getRightParenthesisKeyword_1_3()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6371:1: rule__ExpressionSequence__Group__0 : rule__ExpressionSequence__Group__0__Impl rule__ExpressionSequence__Group__1 ;
    public final void rule__ExpressionSequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6375:1: ( rule__ExpressionSequence__Group__0__Impl rule__ExpressionSequence__Group__1 )
            // InternalAle.g:6376:2: rule__ExpressionSequence__Group__0__Impl rule__ExpressionSequence__Group__1
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
    // InternalAle.g:6383:1: rule__ExpressionSequence__Group__0__Impl : ( ( rule__ExpressionSequence__SeqExprsAssignment_0 ) ) ;
    public final void rule__ExpressionSequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6387:1: ( ( ( rule__ExpressionSequence__SeqExprsAssignment_0 ) ) )
            // InternalAle.g:6388:1: ( ( rule__ExpressionSequence__SeqExprsAssignment_0 ) )
            {
            // InternalAle.g:6388:1: ( ( rule__ExpressionSequence__SeqExprsAssignment_0 ) )
            // InternalAle.g:6389:2: ( rule__ExpressionSequence__SeqExprsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getSeqExprsAssignment_0()); 
            }
            // InternalAle.g:6390:2: ( rule__ExpressionSequence__SeqExprsAssignment_0 )
            // InternalAle.g:6390:3: rule__ExpressionSequence__SeqExprsAssignment_0
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
    // InternalAle.g:6398:1: rule__ExpressionSequence__Group__1 : rule__ExpressionSequence__Group__1__Impl ;
    public final void rule__ExpressionSequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6402:1: ( rule__ExpressionSequence__Group__1__Impl )
            // InternalAle.g:6403:2: rule__ExpressionSequence__Group__1__Impl
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
    // InternalAle.g:6409:1: rule__ExpressionSequence__Group__1__Impl : ( ( rule__ExpressionSequence__Group_1__0 )* ) ;
    public final void rule__ExpressionSequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6413:1: ( ( ( rule__ExpressionSequence__Group_1__0 )* ) )
            // InternalAle.g:6414:1: ( ( rule__ExpressionSequence__Group_1__0 )* )
            {
            // InternalAle.g:6414:1: ( ( rule__ExpressionSequence__Group_1__0 )* )
            // InternalAle.g:6415:2: ( rule__ExpressionSequence__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getGroup_1()); 
            }
            // InternalAle.g:6416:2: ( rule__ExpressionSequence__Group_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==55) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalAle.g:6416:3: rule__ExpressionSequence__Group_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__ExpressionSequence__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalAle.g:6425:1: rule__ExpressionSequence__Group_1__0 : rule__ExpressionSequence__Group_1__0__Impl rule__ExpressionSequence__Group_1__1 ;
    public final void rule__ExpressionSequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6429:1: ( rule__ExpressionSequence__Group_1__0__Impl rule__ExpressionSequence__Group_1__1 )
            // InternalAle.g:6430:2: rule__ExpressionSequence__Group_1__0__Impl rule__ExpressionSequence__Group_1__1
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
    // InternalAle.g:6437:1: rule__ExpressionSequence__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ExpressionSequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6441:1: ( ( ',' ) )
            // InternalAle.g:6442:1: ( ',' )
            {
            // InternalAle.g:6442:1: ( ',' )
            // InternalAle.g:6443:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getCommaKeyword_1_0()); 
            }
            match(input,55,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6452:1: rule__ExpressionSequence__Group_1__1 : rule__ExpressionSequence__Group_1__1__Impl ;
    public final void rule__ExpressionSequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6456:1: ( rule__ExpressionSequence__Group_1__1__Impl )
            // InternalAle.g:6457:2: rule__ExpressionSequence__Group_1__1__Impl
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
    // InternalAle.g:6463:1: rule__ExpressionSequence__Group_1__1__Impl : ( ( rule__ExpressionSequence__SeqExprsAssignment_1_1 ) ) ;
    public final void rule__ExpressionSequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6467:1: ( ( ( rule__ExpressionSequence__SeqExprsAssignment_1_1 ) ) )
            // InternalAle.g:6468:1: ( ( rule__ExpressionSequence__SeqExprsAssignment_1_1 ) )
            {
            // InternalAle.g:6468:1: ( ( rule__ExpressionSequence__SeqExprsAssignment_1_1 ) )
            // InternalAle.g:6469:2: ( rule__ExpressionSequence__SeqExprsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getSeqExprsAssignment_1_1()); 
            }
            // InternalAle.g:6470:2: ( rule__ExpressionSequence__SeqExprsAssignment_1_1 )
            // InternalAle.g:6470:3: rule__ExpressionSequence__SeqExprsAssignment_1_1
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
    // InternalAle.g:6479:1: rule__VariableDefinition__Group__0 : rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 ;
    public final void rule__VariableDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6483:1: ( rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 )
            // InternalAle.g:6484:2: rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1
            {
            pushFollow(FOLLOW_51);
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
    // InternalAle.g:6491:1: rule__VariableDefinition__Group__0__Impl : ( RULE_IDENT ) ;
    public final void rule__VariableDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6495:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6496:1: ( RULE_IDENT )
            {
            // InternalAle.g:6496:1: ( RULE_IDENT )
            // InternalAle.g:6497:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getIdentTerminalRuleCall_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableDefinitionAccess().getIdentTerminalRuleCall_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:6506:1: rule__VariableDefinition__Group__1 : rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 ;
    public final void rule__VariableDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6510:1: ( rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 )
            // InternalAle.g:6511:2: rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2
            {
            pushFollow(FOLLOW_51);
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
    // InternalAle.g:6518:1: rule__VariableDefinition__Group__1__Impl : ( ( rule__VariableDefinition__Group_1__0 )? ) ;
    public final void rule__VariableDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6522:1: ( ( ( rule__VariableDefinition__Group_1__0 )? ) )
            // InternalAle.g:6523:1: ( ( rule__VariableDefinition__Group_1__0 )? )
            {
            // InternalAle.g:6523:1: ( ( rule__VariableDefinition__Group_1__0 )? )
            // InternalAle.g:6524:2: ( rule__VariableDefinition__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getGroup_1()); 
            }
            // InternalAle.g:6525:2: ( rule__VariableDefinition__Group_1__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==77) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalAle.g:6525:3: rule__VariableDefinition__Group_1__0
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
    // InternalAle.g:6533:1: rule__VariableDefinition__Group__2 : rule__VariableDefinition__Group__2__Impl ;
    public final void rule__VariableDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6537:1: ( rule__VariableDefinition__Group__2__Impl )
            // InternalAle.g:6538:2: rule__VariableDefinition__Group__2__Impl
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
    // InternalAle.g:6544:1: rule__VariableDefinition__Group__2__Impl : ( '|' ) ;
    public final void rule__VariableDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6548:1: ( ( '|' ) )
            // InternalAle.g:6549:1: ( '|' )
            {
            // InternalAle.g:6549:1: ( '|' )
            // InternalAle.g:6550:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getVerticalLineKeyword_2()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6560:1: rule__VariableDefinition__Group_1__0 : rule__VariableDefinition__Group_1__0__Impl rule__VariableDefinition__Group_1__1 ;
    public final void rule__VariableDefinition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6564:1: ( rule__VariableDefinition__Group_1__0__Impl rule__VariableDefinition__Group_1__1 )
            // InternalAle.g:6565:2: rule__VariableDefinition__Group_1__0__Impl rule__VariableDefinition__Group_1__1
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
    // InternalAle.g:6572:1: rule__VariableDefinition__Group_1__0__Impl : ( ':' ) ;
    public final void rule__VariableDefinition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6576:1: ( ( ':' ) )
            // InternalAle.g:6577:1: ( ':' )
            {
            // InternalAle.g:6577:1: ( ':' )
            // InternalAle.g:6578:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getColonKeyword_1_0()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6587:1: rule__VariableDefinition__Group_1__1 : rule__VariableDefinition__Group_1__1__Impl ;
    public final void rule__VariableDefinition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6591:1: ( rule__VariableDefinition__Group_1__1__Impl )
            // InternalAle.g:6592:2: rule__VariableDefinition__Group_1__1__Impl
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
    // InternalAle.g:6598:1: rule__VariableDefinition__Group_1__1__Impl : ( ruletypeLiteral ) ;
    public final void rule__VariableDefinition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6602:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:6603:1: ( ruletypeLiteral )
            {
            // InternalAle.g:6603:1: ( ruletypeLiteral )
            // InternalAle.g:6604:2: ruletypeLiteral
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
    // InternalAle.g:6614:1: rule__Literal__Group_6__0 : rule__Literal__Group_6__0__Impl rule__Literal__Group_6__1 ;
    public final void rule__Literal__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6618:1: ( rule__Literal__Group_6__0__Impl rule__Literal__Group_6__1 )
            // InternalAle.g:6619:2: rule__Literal__Group_6__0__Impl rule__Literal__Group_6__1
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
    // InternalAle.g:6626:1: rule__Literal__Group_6__0__Impl : ( 'Sequence{' ) ;
    public final void rule__Literal__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6630:1: ( ( 'Sequence{' ) )
            // InternalAle.g:6631:1: ( 'Sequence{' )
            {
            // InternalAle.g:6631:1: ( 'Sequence{' )
            // InternalAle.g:6632:2: 'Sequence{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getSequenceKeyword_6_0()); 
            }
            match(input,79,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6641:1: rule__Literal__Group_6__1 : rule__Literal__Group_6__1__Impl rule__Literal__Group_6__2 ;
    public final void rule__Literal__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6645:1: ( rule__Literal__Group_6__1__Impl rule__Literal__Group_6__2 )
            // InternalAle.g:6646:2: rule__Literal__Group_6__1__Impl rule__Literal__Group_6__2
            {
            pushFollow(FOLLOW_52);
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
    // InternalAle.g:6653:1: rule__Literal__Group_6__1__Impl : ( ruleexpressionSequence ) ;
    public final void rule__Literal__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6657:1: ( ( ruleexpressionSequence ) )
            // InternalAle.g:6658:1: ( ruleexpressionSequence )
            {
            // InternalAle.g:6658:1: ( ruleexpressionSequence )
            // InternalAle.g:6659:2: ruleexpressionSequence
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
    // InternalAle.g:6668:1: rule__Literal__Group_6__2 : rule__Literal__Group_6__2__Impl ;
    public final void rule__Literal__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6672:1: ( rule__Literal__Group_6__2__Impl )
            // InternalAle.g:6673:2: rule__Literal__Group_6__2__Impl
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
    // InternalAle.g:6679:1: rule__Literal__Group_6__2__Impl : ( '}' ) ;
    public final void rule__Literal__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6683:1: ( ( '}' ) )
            // InternalAle.g:6684:1: ( '}' )
            {
            // InternalAle.g:6684:1: ( '}' )
            // InternalAle.g:6685:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_6_2()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6695:1: rule__Literal__Group_7__0 : rule__Literal__Group_7__0__Impl rule__Literal__Group_7__1 ;
    public final void rule__Literal__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6699:1: ( rule__Literal__Group_7__0__Impl rule__Literal__Group_7__1 )
            // InternalAle.g:6700:2: rule__Literal__Group_7__0__Impl rule__Literal__Group_7__1
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
    // InternalAle.g:6707:1: rule__Literal__Group_7__0__Impl : ( 'OrderedSet{' ) ;
    public final void rule__Literal__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6711:1: ( ( 'OrderedSet{' ) )
            // InternalAle.g:6712:1: ( 'OrderedSet{' )
            {
            // InternalAle.g:6712:1: ( 'OrderedSet{' )
            // InternalAle.g:6713:2: 'OrderedSet{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getOrderedSetKeyword_7_0()); 
            }
            match(input,80,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6722:1: rule__Literal__Group_7__1 : rule__Literal__Group_7__1__Impl rule__Literal__Group_7__2 ;
    public final void rule__Literal__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6726:1: ( rule__Literal__Group_7__1__Impl rule__Literal__Group_7__2 )
            // InternalAle.g:6727:2: rule__Literal__Group_7__1__Impl rule__Literal__Group_7__2
            {
            pushFollow(FOLLOW_52);
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
    // InternalAle.g:6734:1: rule__Literal__Group_7__1__Impl : ( ruleexpressionSequence ) ;
    public final void rule__Literal__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6738:1: ( ( ruleexpressionSequence ) )
            // InternalAle.g:6739:1: ( ruleexpressionSequence )
            {
            // InternalAle.g:6739:1: ( ruleexpressionSequence )
            // InternalAle.g:6740:2: ruleexpressionSequence
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
    // InternalAle.g:6749:1: rule__Literal__Group_7__2 : rule__Literal__Group_7__2__Impl ;
    public final void rule__Literal__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6753:1: ( rule__Literal__Group_7__2__Impl )
            // InternalAle.g:6754:2: rule__Literal__Group_7__2__Impl
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
    // InternalAle.g:6760:1: rule__Literal__Group_7__2__Impl : ( '}' ) ;
    public final void rule__Literal__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6764:1: ( ( '}' ) )
            // InternalAle.g:6765:1: ( '}' )
            {
            // InternalAle.g:6765:1: ( '}' )
            // InternalAle.g:6766:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getRightCurlyBracketKeyword_7_2()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6776:1: rule__Literal__Group_8__0 : rule__Literal__Group_8__0__Impl rule__Literal__Group_8__1 ;
    public final void rule__Literal__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6780:1: ( rule__Literal__Group_8__0__Impl rule__Literal__Group_8__1 )
            // InternalAle.g:6781:2: rule__Literal__Group_8__0__Impl rule__Literal__Group_8__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalAle.g:6788:1: rule__Literal__Group_8__0__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6792:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6793:1: ( RULE_IDENT )
            {
            // InternalAle.g:6793:1: ( RULE_IDENT )
            // InternalAle.g:6794:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:6803:1: rule__Literal__Group_8__1 : rule__Literal__Group_8__1__Impl rule__Literal__Group_8__2 ;
    public final void rule__Literal__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6807:1: ( rule__Literal__Group_8__1__Impl rule__Literal__Group_8__2 )
            // InternalAle.g:6808:2: rule__Literal__Group_8__1__Impl rule__Literal__Group_8__2
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
    // InternalAle.g:6815:1: rule__Literal__Group_8__1__Impl : ( '::' ) ;
    public final void rule__Literal__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6819:1: ( ( '::' ) )
            // InternalAle.g:6820:1: ( '::' )
            {
            // InternalAle.g:6820:1: ( '::' )
            // InternalAle.g:6821:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getColonColonKeyword_8_1()); 
            }
            match(input,81,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6830:1: rule__Literal__Group_8__2 : rule__Literal__Group_8__2__Impl rule__Literal__Group_8__3 ;
    public final void rule__Literal__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6834:1: ( rule__Literal__Group_8__2__Impl rule__Literal__Group_8__3 )
            // InternalAle.g:6835:2: rule__Literal__Group_8__2__Impl rule__Literal__Group_8__3
            {
            pushFollow(FOLLOW_53);
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
    // InternalAle.g:6842:1: rule__Literal__Group_8__2__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6846:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6847:1: ( RULE_IDENT )
            {
            // InternalAle.g:6847:1: ( RULE_IDENT )
            // InternalAle.g:6848:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_2()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_2()); 
            }

            }


            }

        }
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
    // InternalAle.g:6857:1: rule__Literal__Group_8__3 : rule__Literal__Group_8__3__Impl rule__Literal__Group_8__4 ;
    public final void rule__Literal__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6861:1: ( rule__Literal__Group_8__3__Impl rule__Literal__Group_8__4 )
            // InternalAle.g:6862:2: rule__Literal__Group_8__3__Impl rule__Literal__Group_8__4
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
    // InternalAle.g:6869:1: rule__Literal__Group_8__3__Impl : ( '::' ) ;
    public final void rule__Literal__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6873:1: ( ( '::' ) )
            // InternalAle.g:6874:1: ( '::' )
            {
            // InternalAle.g:6874:1: ( '::' )
            // InternalAle.g:6875:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getColonColonKeyword_8_3()); 
            }
            match(input,81,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6884:1: rule__Literal__Group_8__4 : rule__Literal__Group_8__4__Impl ;
    public final void rule__Literal__Group_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6888:1: ( rule__Literal__Group_8__4__Impl )
            // InternalAle.g:6889:2: rule__Literal__Group_8__4__Impl
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
    // InternalAle.g:6895:1: rule__Literal__Group_8__4__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6899:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6900:1: ( RULE_IDENT )
            {
            // InternalAle.g:6900:1: ( RULE_IDENT )
            // InternalAle.g:6901:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_4()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_8_4()); 
            }

            }


            }

        }
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
    // InternalAle.g:6911:1: rule__Literal__Group_9__0 : rule__Literal__Group_9__0__Impl rule__Literal__Group_9__1 ;
    public final void rule__Literal__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6915:1: ( rule__Literal__Group_9__0__Impl rule__Literal__Group_9__1 )
            // InternalAle.g:6916:2: rule__Literal__Group_9__0__Impl rule__Literal__Group_9__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalAle.g:6923:1: rule__Literal__Group_9__0__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6927:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6928:1: ( RULE_IDENT )
            {
            // InternalAle.g:6928:1: ( RULE_IDENT )
            // InternalAle.g:6929:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_9_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_9_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:6938:1: rule__Literal__Group_9__1 : rule__Literal__Group_9__1__Impl rule__Literal__Group_9__2 ;
    public final void rule__Literal__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6942:1: ( rule__Literal__Group_9__1__Impl rule__Literal__Group_9__2 )
            // InternalAle.g:6943:2: rule__Literal__Group_9__1__Impl rule__Literal__Group_9__2
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
    // InternalAle.g:6950:1: rule__Literal__Group_9__1__Impl : ( '::' ) ;
    public final void rule__Literal__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6954:1: ( ( '::' ) )
            // InternalAle.g:6955:1: ( '::' )
            {
            // InternalAle.g:6955:1: ( '::' )
            // InternalAle.g:6956:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getColonColonKeyword_9_1()); 
            }
            match(input,81,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:6965:1: rule__Literal__Group_9__2 : rule__Literal__Group_9__2__Impl rule__Literal__Group_9__3 ;
    public final void rule__Literal__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6969:1: ( rule__Literal__Group_9__2__Impl rule__Literal__Group_9__3 )
            // InternalAle.g:6970:2: rule__Literal__Group_9__2__Impl rule__Literal__Group_9__3
            {
            pushFollow(FOLLOW_54);
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
    // InternalAle.g:6977:1: rule__Literal__Group_9__2__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6981:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6982:1: ( RULE_IDENT )
            {
            // InternalAle.g:6982:1: ( RULE_IDENT )
            // InternalAle.g:6983:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_9_2()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getIdentTerminalRuleCall_9_2()); 
            }

            }


            }

        }
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
    // InternalAle.g:6992:1: rule__Literal__Group_9__3 : rule__Literal__Group_9__3__Impl ;
    public final void rule__Literal__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6996:1: ( rule__Literal__Group_9__3__Impl )
            // InternalAle.g:6997:2: rule__Literal__Group_9__3__Impl
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
    // InternalAle.g:7003:1: rule__Literal__Group_9__3__Impl : ( ':' ) ;
    public final void rule__Literal__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7007:1: ( ( ':' ) )
            // InternalAle.g:7008:1: ( ':' )
            {
            // InternalAle.g:7008:1: ( ':' )
            // InternalAle.g:7009:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getColonKeyword_9_3()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__TypeLiteral__Group_4__0"
    // InternalAle.g:7019:1: rule__TypeLiteral__Group_4__0 : rule__TypeLiteral__Group_4__0__Impl rule__TypeLiteral__Group_4__1 ;
    public final void rule__TypeLiteral__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7023:1: ( rule__TypeLiteral__Group_4__0__Impl rule__TypeLiteral__Group_4__1 )
            // InternalAle.g:7024:2: rule__TypeLiteral__Group_4__0__Impl rule__TypeLiteral__Group_4__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalAle.g:7031:1: rule__TypeLiteral__Group_4__0__Impl : ( 'Sequence(' ) ;
    public final void rule__TypeLiteral__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7035:1: ( ( 'Sequence(' ) )
            // InternalAle.g:7036:1: ( 'Sequence(' )
            {
            // InternalAle.g:7036:1: ( 'Sequence(' )
            // InternalAle.g:7037:2: 'Sequence('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getSequenceKeyword_4_0()); 
            }
            match(input,82,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getSequenceKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_4__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_4__1"
    // InternalAle.g:7046:1: rule__TypeLiteral__Group_4__1 : rule__TypeLiteral__Group_4__1__Impl rule__TypeLiteral__Group_4__2 ;
    public final void rule__TypeLiteral__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7050:1: ( rule__TypeLiteral__Group_4__1__Impl rule__TypeLiteral__Group_4__2 )
            // InternalAle.g:7051:2: rule__TypeLiteral__Group_4__1__Impl rule__TypeLiteral__Group_4__2
            {
            pushFollow(FOLLOW_35);
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
    // InternalAle.g:7058:1: rule__TypeLiteral__Group_4__1__Impl : ( ruletypeLiteral ) ;
    public final void rule__TypeLiteral__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7062:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:7063:1: ( ruletypeLiteral )
            {
            // InternalAle.g:7063:1: ( ruletypeLiteral )
            // InternalAle.g:7064:2: ruletypeLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralParserRuleCall_4_1()); 
            }
            pushFollow(FOLLOW_2);
            ruletypeLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralParserRuleCall_4_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:7073:1: rule__TypeLiteral__Group_4__2 : rule__TypeLiteral__Group_4__2__Impl ;
    public final void rule__TypeLiteral__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7077:1: ( rule__TypeLiteral__Group_4__2__Impl )
            // InternalAle.g:7078:2: rule__TypeLiteral__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_4__2__Impl();

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
    // InternalAle.g:7084:1: rule__TypeLiteral__Group_4__2__Impl : ( ')' ) ;
    public final void rule__TypeLiteral__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7088:1: ( ( ')' ) )
            // InternalAle.g:7089:1: ( ')' )
            {
            // InternalAle.g:7089:1: ( ')' )
            // InternalAle.g:7090:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_4_2()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_4_2()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__TypeLiteral__Group_5__0"
    // InternalAle.g:7100:1: rule__TypeLiteral__Group_5__0 : rule__TypeLiteral__Group_5__0__Impl rule__TypeLiteral__Group_5__1 ;
    public final void rule__TypeLiteral__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7104:1: ( rule__TypeLiteral__Group_5__0__Impl rule__TypeLiteral__Group_5__1 )
            // InternalAle.g:7105:2: rule__TypeLiteral__Group_5__0__Impl rule__TypeLiteral__Group_5__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalAle.g:7112:1: rule__TypeLiteral__Group_5__0__Impl : ( 'OrderedSet(' ) ;
    public final void rule__TypeLiteral__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7116:1: ( ( 'OrderedSet(' ) )
            // InternalAle.g:7117:1: ( 'OrderedSet(' )
            {
            // InternalAle.g:7117:1: ( 'OrderedSet(' )
            // InternalAle.g:7118:2: 'OrderedSet('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getOrderedSetKeyword_5_0()); 
            }
            match(input,83,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getOrderedSetKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_5__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_5__1"
    // InternalAle.g:7127:1: rule__TypeLiteral__Group_5__1 : rule__TypeLiteral__Group_5__1__Impl rule__TypeLiteral__Group_5__2 ;
    public final void rule__TypeLiteral__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7131:1: ( rule__TypeLiteral__Group_5__1__Impl rule__TypeLiteral__Group_5__2 )
            // InternalAle.g:7132:2: rule__TypeLiteral__Group_5__1__Impl rule__TypeLiteral__Group_5__2
            {
            pushFollow(FOLLOW_35);
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
    // InternalAle.g:7139:1: rule__TypeLiteral__Group_5__1__Impl : ( ruletypeLiteral ) ;
    public final void rule__TypeLiteral__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7143:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:7144:1: ( ruletypeLiteral )
            {
            // InternalAle.g:7144:1: ( ruletypeLiteral )
            // InternalAle.g:7145:2: ruletypeLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getTypeLiteralParserRuleCall_5_1()); 
            }
            pushFollow(FOLLOW_2);
            ruletypeLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getTypeLiteralParserRuleCall_5_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:7154:1: rule__TypeLiteral__Group_5__2 : rule__TypeLiteral__Group_5__2__Impl ;
    public final void rule__TypeLiteral__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7158:1: ( rule__TypeLiteral__Group_5__2__Impl )
            // InternalAle.g:7159:2: rule__TypeLiteral__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_5__2__Impl();

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
    // InternalAle.g:7165:1: rule__TypeLiteral__Group_5__2__Impl : ( ')' ) ;
    public final void rule__TypeLiteral__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7169:1: ( ( ')' ) )
            // InternalAle.g:7170:1: ( ')' )
            {
            // InternalAle.g:7170:1: ( ')' )
            // InternalAle.g:7171:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_5_2()); 
            }
            match(input,57,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getRightParenthesisKeyword_5_2()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__TypeLiteral__Group_7__0"
    // InternalAle.g:7181:1: rule__TypeLiteral__Group_7__0 : rule__TypeLiteral__Group_7__0__Impl rule__TypeLiteral__Group_7__1 ;
    public final void rule__TypeLiteral__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7185:1: ( rule__TypeLiteral__Group_7__0__Impl rule__TypeLiteral__Group_7__1 )
            // InternalAle.g:7186:2: rule__TypeLiteral__Group_7__0__Impl rule__TypeLiteral__Group_7__1
            {
            pushFollow(FOLLOW_3);
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
    // InternalAle.g:7193:1: rule__TypeLiteral__Group_7__0__Impl : ( '{' ) ;
    public final void rule__TypeLiteral__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7197:1: ( ( '{' ) )
            // InternalAle.g:7198:1: ( '{' )
            {
            // InternalAle.g:7198:1: ( '{' )
            // InternalAle.g:7199:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getLeftCurlyBracketKeyword_7_0()); 
            }
            match(input,52,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getLeftCurlyBracketKeyword_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_7__1"
    // InternalAle.g:7208:1: rule__TypeLiteral__Group_7__1 : rule__TypeLiteral__Group_7__1__Impl rule__TypeLiteral__Group_7__2 ;
    public final void rule__TypeLiteral__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7212:1: ( rule__TypeLiteral__Group_7__1__Impl rule__TypeLiteral__Group_7__2 )
            // InternalAle.g:7213:2: rule__TypeLiteral__Group_7__1__Impl rule__TypeLiteral__Group_7__2
            {
            pushFollow(FOLLOW_55);
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
    // InternalAle.g:7220:1: rule__TypeLiteral__Group_7__1__Impl : ( ruleclassifierTypeRule ) ;
    public final void rule__TypeLiteral__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7224:1: ( ( ruleclassifierTypeRule ) )
            // InternalAle.g:7225:1: ( ruleclassifierTypeRule )
            {
            // InternalAle.g:7225:1: ( ruleclassifierTypeRule )
            // InternalAle.g:7226:2: ruleclassifierTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleclassifierTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:7235:1: rule__TypeLiteral__Group_7__2 : rule__TypeLiteral__Group_7__2__Impl rule__TypeLiteral__Group_7__3 ;
    public final void rule__TypeLiteral__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7239:1: ( rule__TypeLiteral__Group_7__2__Impl rule__TypeLiteral__Group_7__3 )
            // InternalAle.g:7240:2: rule__TypeLiteral__Group_7__2__Impl rule__TypeLiteral__Group_7__3
            {
            pushFollow(FOLLOW_55);
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
    // InternalAle.g:7247:1: rule__TypeLiteral__Group_7__2__Impl : ( ( rule__TypeLiteral__Group_7_2__0 )* ) ;
    public final void rule__TypeLiteral__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7251:1: ( ( ( rule__TypeLiteral__Group_7_2__0 )* ) )
            // InternalAle.g:7252:1: ( ( rule__TypeLiteral__Group_7_2__0 )* )
            {
            // InternalAle.g:7252:1: ( ( rule__TypeLiteral__Group_7_2__0 )* )
            // InternalAle.g:7253:2: ( rule__TypeLiteral__Group_7_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getGroup_7_2()); 
            }
            // InternalAle.g:7254:2: ( rule__TypeLiteral__Group_7_2__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==78) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalAle.g:7254:3: rule__TypeLiteral__Group_7_2__0
            	    {
            	    pushFollow(FOLLOW_56);
            	    rule__TypeLiteral__Group_7_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getGroup_7_2()); 
            }

            }


            }

        }
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
    // InternalAle.g:7262:1: rule__TypeLiteral__Group_7__3 : rule__TypeLiteral__Group_7__3__Impl ;
    public final void rule__TypeLiteral__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7266:1: ( rule__TypeLiteral__Group_7__3__Impl )
            // InternalAle.g:7267:2: rule__TypeLiteral__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7__3__Impl();

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
    // InternalAle.g:7273:1: rule__TypeLiteral__Group_7__3__Impl : ( '}' ) ;
    public final void rule__TypeLiteral__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7277:1: ( ( '}' ) )
            // InternalAle.g:7278:1: ( '}' )
            {
            // InternalAle.g:7278:1: ( '}' )
            // InternalAle.g:7279:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getRightCurlyBracketKeyword_7_3()); 
            }
            match(input,53,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getRightCurlyBracketKeyword_7_3()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__TypeLiteral__Group_7_2__0"
    // InternalAle.g:7289:1: rule__TypeLiteral__Group_7_2__0 : rule__TypeLiteral__Group_7_2__0__Impl rule__TypeLiteral__Group_7_2__1 ;
    public final void rule__TypeLiteral__Group_7_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7293:1: ( rule__TypeLiteral__Group_7_2__0__Impl rule__TypeLiteral__Group_7_2__1 )
            // InternalAle.g:7294:2: rule__TypeLiteral__Group_7_2__0__Impl rule__TypeLiteral__Group_7_2__1
            {
            pushFollow(FOLLOW_3);
            rule__TypeLiteral__Group_7_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7_2__1();

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
    // $ANTLR end "rule__TypeLiteral__Group_7_2__0"


    // $ANTLR start "rule__TypeLiteral__Group_7_2__0__Impl"
    // InternalAle.g:7301:1: rule__TypeLiteral__Group_7_2__0__Impl : ( '|' ) ;
    public final void rule__TypeLiteral__Group_7_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7305:1: ( ( '|' ) )
            // InternalAle.g:7306:1: ( '|' )
            {
            // InternalAle.g:7306:1: ( '|' )
            // InternalAle.g:7307:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getVerticalLineKeyword_7_2_0()); 
            }
            match(input,78,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getVerticalLineKeyword_7_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7_2__0__Impl"


    // $ANTLR start "rule__TypeLiteral__Group_7_2__1"
    // InternalAle.g:7316:1: rule__TypeLiteral__Group_7_2__1 : rule__TypeLiteral__Group_7_2__1__Impl ;
    public final void rule__TypeLiteral__Group_7_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7320:1: ( rule__TypeLiteral__Group_7_2__1__Impl )
            // InternalAle.g:7321:2: rule__TypeLiteral__Group_7_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeLiteral__Group_7_2__1__Impl();

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
    // $ANTLR end "rule__TypeLiteral__Group_7_2__1"


    // $ANTLR start "rule__TypeLiteral__Group_7_2__1__Impl"
    // InternalAle.g:7327:1: rule__TypeLiteral__Group_7_2__1__Impl : ( ruleclassifierTypeRule ) ;
    public final void rule__TypeLiteral__Group_7_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7331:1: ( ( ruleclassifierTypeRule ) )
            // InternalAle.g:7332:1: ( ruleclassifierTypeRule )
            {
            // InternalAle.g:7332:1: ( ruleclassifierTypeRule )
            // InternalAle.g:7333:2: ruleclassifierTypeRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_2_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleclassifierTypeRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeLiteralAccess().getClassifierTypeRuleParserRuleCall_7_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeLiteral__Group_7_2__1__Impl"


    // $ANTLR start "rule__ClassifierTypeRule__Group_0__0"
    // InternalAle.g:7343:1: rule__ClassifierTypeRule__Group_0__0 : rule__ClassifierTypeRule__Group_0__0__Impl rule__ClassifierTypeRule__Group_0__1 ;
    public final void rule__ClassifierTypeRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7347:1: ( rule__ClassifierTypeRule__Group_0__0__Impl rule__ClassifierTypeRule__Group_0__1 )
            // InternalAle.g:7348:2: rule__ClassifierTypeRule__Group_0__0__Impl rule__ClassifierTypeRule__Group_0__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalAle.g:7355:1: rule__ClassifierTypeRule__Group_0__0__Impl : ( RULE_IDENT ) ;
    public final void rule__ClassifierTypeRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7359:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7360:1: ( RULE_IDENT )
            {
            // InternalAle.g:7360:1: ( RULE_IDENT )
            // InternalAle.g:7361:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_0_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_0_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:7370:1: rule__ClassifierTypeRule__Group_0__1 : rule__ClassifierTypeRule__Group_0__1__Impl rule__ClassifierTypeRule__Group_0__2 ;
    public final void rule__ClassifierTypeRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7374:1: ( rule__ClassifierTypeRule__Group_0__1__Impl rule__ClassifierTypeRule__Group_0__2 )
            // InternalAle.g:7375:2: rule__ClassifierTypeRule__Group_0__1__Impl rule__ClassifierTypeRule__Group_0__2
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
    // InternalAle.g:7382:1: rule__ClassifierTypeRule__Group_0__1__Impl : ( '::' ) ;
    public final void rule__ClassifierTypeRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7386:1: ( ( '::' ) )
            // InternalAle.g:7387:1: ( '::' )
            {
            // InternalAle.g:7387:1: ( '::' )
            // InternalAle.g:7388:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getColonColonKeyword_0_1()); 
            }
            match(input,81,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:7397:1: rule__ClassifierTypeRule__Group_0__2 : rule__ClassifierTypeRule__Group_0__2__Impl ;
    public final void rule__ClassifierTypeRule__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7401:1: ( rule__ClassifierTypeRule__Group_0__2__Impl )
            // InternalAle.g:7402:2: rule__ClassifierTypeRule__Group_0__2__Impl
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
    // InternalAle.g:7408:1: rule__ClassifierTypeRule__Group_0__2__Impl : ( RULE_IDENT ) ;
    public final void rule__ClassifierTypeRule__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7412:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7413:1: ( RULE_IDENT )
            {
            // InternalAle.g:7413:1: ( RULE_IDENT )
            // InternalAle.g:7414:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_0_2()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_0_2()); 
            }

            }


            }

        }
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
    // InternalAle.g:7424:1: rule__ClassifierTypeRule__Group_1__0 : rule__ClassifierTypeRule__Group_1__0__Impl rule__ClassifierTypeRule__Group_1__1 ;
    public final void rule__ClassifierTypeRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7428:1: ( rule__ClassifierTypeRule__Group_1__0__Impl rule__ClassifierTypeRule__Group_1__1 )
            // InternalAle.g:7429:2: rule__ClassifierTypeRule__Group_1__0__Impl rule__ClassifierTypeRule__Group_1__1
            {
            pushFollow(FOLLOW_54);
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
    // InternalAle.g:7436:1: rule__ClassifierTypeRule__Group_1__0__Impl : ( RULE_IDENT ) ;
    public final void rule__ClassifierTypeRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7440:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7441:1: ( RULE_IDENT )
            {
            // InternalAle.g:7441:1: ( RULE_IDENT )
            // InternalAle.g:7442:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierTypeRuleAccess().getIdentTerminalRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:7451:1: rule__ClassifierTypeRule__Group_1__1 : rule__ClassifierTypeRule__Group_1__1__Impl ;
    public final void rule__ClassifierTypeRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7455:1: ( rule__ClassifierTypeRule__Group_1__1__Impl )
            // InternalAle.g:7456:2: rule__ClassifierTypeRule__Group_1__1__Impl
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
    // InternalAle.g:7462:1: rule__ClassifierTypeRule__Group_1__1__Impl : ( ':' ) ;
    public final void rule__ClassifierTypeRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7466:1: ( ( ':' ) )
            // InternalAle.g:7467:1: ( ':' )
            {
            // InternalAle.g:7467:1: ( ':' )
            // InternalAle.g:7468:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getColonKeyword_1_1()); 
            }
            match(input,77,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:7478:1: rule__RQualified__Group__0 : rule__RQualified__Group__0__Impl rule__RQualified__Group__1 ;
    public final void rule__RQualified__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7482:1: ( rule__RQualified__Group__0__Impl rule__RQualified__Group__1 )
            // InternalAle.g:7483:2: rule__RQualified__Group__0__Impl rule__RQualified__Group__1
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
    // InternalAle.g:7490:1: rule__RQualified__Group__0__Impl : ( RULE_IDENT ) ;
    public final void rule__RQualified__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7494:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7495:1: ( RULE_IDENT )
            {
            // InternalAle.g:7495:1: ( RULE_IDENT )
            // InternalAle.g:7496:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getIdentTerminalRuleCall_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRQualifiedAccess().getIdentTerminalRuleCall_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:7505:1: rule__RQualified__Group__1 : rule__RQualified__Group__1__Impl ;
    public final void rule__RQualified__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7509:1: ( rule__RQualified__Group__1__Impl )
            // InternalAle.g:7510:2: rule__RQualified__Group__1__Impl
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
    // InternalAle.g:7516:1: rule__RQualified__Group__1__Impl : ( ( rule__RQualified__Group_1__0 )* ) ;
    public final void rule__RQualified__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7520:1: ( ( ( rule__RQualified__Group_1__0 )* ) )
            // InternalAle.g:7521:1: ( ( rule__RQualified__Group_1__0 )* )
            {
            // InternalAle.g:7521:1: ( ( rule__RQualified__Group_1__0 )* )
            // InternalAle.g:7522:2: ( rule__RQualified__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getGroup_1()); 
            }
            // InternalAle.g:7523:2: ( rule__RQualified__Group_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==49) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalAle.g:7523:3: rule__RQualified__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__RQualified__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // InternalAle.g:7532:1: rule__RQualified__Group_1__0 : rule__RQualified__Group_1__0__Impl rule__RQualified__Group_1__1 ;
    public final void rule__RQualified__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7536:1: ( rule__RQualified__Group_1__0__Impl rule__RQualified__Group_1__1 )
            // InternalAle.g:7537:2: rule__RQualified__Group_1__0__Impl rule__RQualified__Group_1__1
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
    // InternalAle.g:7544:1: rule__RQualified__Group_1__0__Impl : ( '.' ) ;
    public final void rule__RQualified__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7548:1: ( ( '.' ) )
            // InternalAle.g:7549:1: ( '.' )
            {
            // InternalAle.g:7549:1: ( '.' )
            // InternalAle.g:7550:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getFullStopKeyword_1_0()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
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
    // InternalAle.g:7559:1: rule__RQualified__Group_1__1 : rule__RQualified__Group_1__1__Impl ;
    public final void rule__RQualified__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7563:1: ( rule__RQualified__Group_1__1__Impl )
            // InternalAle.g:7564:2: rule__RQualified__Group_1__1__Impl
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
    // InternalAle.g:7570:1: rule__RQualified__Group_1__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RQualified__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7574:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7575:1: ( RULE_IDENT )
            {
            // InternalAle.g:7575:1: ( RULE_IDENT )
            // InternalAle.g:7576:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getIdentTerminalRuleCall_1_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRQualifiedAccess().getIdentTerminalRuleCall_1_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:7586:1: rule__RRoot__XtendedClassesAssignment_5 : ( rulerClass ) ;
    public final void rule__RRoot__XtendedClassesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7590:1: ( ( rulerClass ) )
            // InternalAle.g:7591:2: ( rulerClass )
            {
            // InternalAle.g:7591:2: ( rulerClass )
            // InternalAle.g:7592:3: rulerClass
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
    // InternalAle.g:7601:1: rule__RClass__OpenClassAssignment_0_1 : ( rulerOpenClass ) ;
    public final void rule__RClass__OpenClassAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7605:1: ( ( rulerOpenClass ) )
            // InternalAle.g:7606:2: ( rulerOpenClass )
            {
            // InternalAle.g:7606:2: ( rulerOpenClass )
            // InternalAle.g:7607:3: rulerOpenClass
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
    // InternalAle.g:7616:1: rule__RClass__NewClassAssignment_1_1 : ( rulerNewClass ) ;
    public final void rule__RClass__NewClassAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7620:1: ( ( rulerNewClass ) )
            // InternalAle.g:7621:2: ( rulerNewClass )
            {
            // InternalAle.g:7621:2: ( rulerNewClass )
            // InternalAle.g:7622:3: rulerNewClass
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
    // InternalAle.g:7631:1: rule__ROpenClass__NameAssignment_2 : ( rulerQualified ) ;
    public final void rule__ROpenClass__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7635:1: ( ( rulerQualified ) )
            // InternalAle.g:7636:2: ( rulerQualified )
            {
            // InternalAle.g:7636:2: ( rulerQualified )
            // InternalAle.g:7637:3: rulerQualified
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
    // InternalAle.g:7646:1: rule__ROpenClass__AttributesAssignment_5 : ( rulerAttribute ) ;
    public final void rule__ROpenClass__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7650:1: ( ( rulerAttribute ) )
            // InternalAle.g:7651:2: ( rulerAttribute )
            {
            // InternalAle.g:7651:2: ( rulerAttribute )
            // InternalAle.g:7652:3: rulerAttribute
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
    // InternalAle.g:7661:1: rule__ROpenClass__OperationsAssignment_6 : ( rulerOperation ) ;
    public final void rule__ROpenClass__OperationsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7665:1: ( ( rulerOperation ) )
            // InternalAle.g:7666:2: ( rulerOperation )
            {
            // InternalAle.g:7666:2: ( rulerOperation )
            // InternalAle.g:7667:3: rulerOperation
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
    // InternalAle.g:7676:1: rule__RNewClass__NameAssignment_1 : ( rulerQualified ) ;
    public final void rule__RNewClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7680:1: ( ( rulerQualified ) )
            // InternalAle.g:7681:2: ( rulerQualified )
            {
            // InternalAle.g:7681:2: ( rulerQualified )
            // InternalAle.g:7682:3: rulerQualified
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
    // InternalAle.g:7691:1: rule__RNewClass__AttributesAssignment_3 : ( rulerAttribute ) ;
    public final void rule__RNewClass__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7695:1: ( ( rulerAttribute ) )
            // InternalAle.g:7696:2: ( rulerAttribute )
            {
            // InternalAle.g:7696:2: ( rulerAttribute )
            // InternalAle.g:7697:3: rulerAttribute
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
    // InternalAle.g:7706:1: rule__RNewClass__OperationsAssignment_4 : ( rulerOperation ) ;
    public final void rule__RNewClass__OperationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7710:1: ( ( rulerOperation ) )
            // InternalAle.g:7711:2: ( rulerOperation )
            {
            // InternalAle.g:7711:2: ( rulerOperation )
            // InternalAle.g:7712:3: rulerOperation
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
    // InternalAle.g:7721:1: rule__ROperation__TypeAssignment_2 : ( rulerType ) ;
    public final void rule__ROperation__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7725:1: ( ( rulerType ) )
            // InternalAle.g:7726:2: ( rulerType )
            {
            // InternalAle.g:7726:2: ( rulerType )
            // InternalAle.g:7727:3: rulerType
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
    // InternalAle.g:7736:1: rule__ROperation__NameAssignment_3 : ( RULE_IDENT ) ;
    public final void rule__ROperation__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7740:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7741:2: ( RULE_IDENT )
            {
            // InternalAle.g:7741:2: ( RULE_IDENT )
            // InternalAle.g:7742:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getNameIdentTerminalRuleCall_3_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getROperationAccess().getNameIdentTerminalRuleCall_3_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:7751:1: rule__ROperation__ParamListAssignment_5 : ( rulerParameters ) ;
    public final void rule__ROperation__ParamListAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7755:1: ( ( rulerParameters ) )
            // InternalAle.g:7756:2: ( rulerParameters )
            {
            // InternalAle.g:7756:2: ( rulerParameters )
            // InternalAle.g:7757:3: rulerParameters
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
    // InternalAle.g:7766:1: rule__ROperation__BodyAssignment_7 : ( rulerBlock ) ;
    public final void rule__ROperation__BodyAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7770:1: ( ( rulerBlock ) )
            // InternalAle.g:7771:2: ( rulerBlock )
            {
            // InternalAle.g:7771:2: ( rulerBlock )
            // InternalAle.g:7772:3: rulerBlock
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
    // InternalAle.g:7781:1: rule__RParameters__ParamsAssignment_0 : ( rulerVariable ) ;
    public final void rule__RParameters__ParamsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7785:1: ( ( rulerVariable ) )
            // InternalAle.g:7786:2: ( rulerVariable )
            {
            // InternalAle.g:7786:2: ( rulerVariable )
            // InternalAle.g:7787:3: rulerVariable
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
    // InternalAle.g:7796:1: rule__RParameters__ParamsAssignment_1_1 : ( rulerVariable ) ;
    public final void rule__RParameters__ParamsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7800:1: ( ( rulerVariable ) )
            // InternalAle.g:7801:2: ( rulerVariable )
            {
            // InternalAle.g:7801:2: ( rulerVariable )
            // InternalAle.g:7802:3: rulerVariable
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
    // InternalAle.g:7811:1: rule__RVariable__TypeAssignment_0 : ( rulerType ) ;
    public final void rule__RVariable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7815:1: ( ( rulerType ) )
            // InternalAle.g:7816:2: ( rulerType )
            {
            // InternalAle.g:7816:2: ( rulerType )
            // InternalAle.g:7817:3: rulerType
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
    // InternalAle.g:7826:1: rule__RVariable__NameAssignment_1 : ( RULE_IDENT ) ;
    public final void rule__RVariable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7830:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7831:2: ( RULE_IDENT )
            {
            // InternalAle.g:7831:2: ( RULE_IDENT )
            // InternalAle.g:7832:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getNameIdentTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRVariableAccess().getNameIdentTerminalRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:7841:1: rule__RAttribute__TypeAssignment_0 : ( rulerType ) ;
    public final void rule__RAttribute__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7845:1: ( ( rulerType ) )
            // InternalAle.g:7846:2: ( rulerType )
            {
            // InternalAle.g:7846:2: ( rulerType )
            // InternalAle.g:7847:3: rulerType
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
    // InternalAle.g:7856:1: rule__RAttribute__NameAssignment_1 : ( RULE_IDENT ) ;
    public final void rule__RAttribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7860:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7861:2: ( RULE_IDENT )
            {
            // InternalAle.g:7861:2: ( RULE_IDENT )
            // InternalAle.g:7862:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getNameIdentTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getNameIdentTerminalRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:7871:1: rule__RAttribute__ExprAssignment_2_1 : ( ruleexpression ) ;
    public final void rule__RAttribute__ExprAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7875:1: ( ( ruleexpression ) )
            // InternalAle.g:7876:2: ( ruleexpression )
            {
            // InternalAle.g:7876:2: ( ruleexpression )
            // InternalAle.g:7877:3: ruleexpression
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
    // InternalAle.g:7886:1: rule__RStatement__StmtAssignment_0_1 : ( rulerVarDecl ) ;
    public final void rule__RStatement__StmtAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7890:1: ( ( rulerVarDecl ) )
            // InternalAle.g:7891:2: ( rulerVarDecl )
            {
            // InternalAle.g:7891:2: ( rulerVarDecl )
            // InternalAle.g:7892:3: rulerVarDecl
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
    // InternalAle.g:7901:1: rule__RStatement__StmtAssignment_1_1 : ( rulerAssign ) ;
    public final void rule__RStatement__StmtAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7905:1: ( ( rulerAssign ) )
            // InternalAle.g:7906:2: ( rulerAssign )
            {
            // InternalAle.g:7906:2: ( rulerAssign )
            // InternalAle.g:7907:3: rulerAssign
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
    // InternalAle.g:7916:1: rule__RStatement__ForEachAssignment_2_1 : ( rulerForEach ) ;
    public final void rule__RStatement__ForEachAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7920:1: ( ( rulerForEach ) )
            // InternalAle.g:7921:2: ( rulerForEach )
            {
            // InternalAle.g:7921:2: ( rulerForEach )
            // InternalAle.g:7922:3: rulerForEach
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
    // InternalAle.g:7931:1: rule__RStatement__WhileAssignment_3_1 : ( rulerWhile ) ;
    public final void rule__RStatement__WhileAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7935:1: ( ( rulerWhile ) )
            // InternalAle.g:7936:2: ( rulerWhile )
            {
            // InternalAle.g:7936:2: ( rulerWhile )
            // InternalAle.g:7937:3: rulerWhile
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
    // InternalAle.g:7946:1: rule__RStatement__IfAssignment_4_1 : ( rulerIf ) ;
    public final void rule__RStatement__IfAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7950:1: ( ( rulerIf ) )
            // InternalAle.g:7951:2: ( rulerIf )
            {
            // InternalAle.g:7951:2: ( rulerIf )
            // InternalAle.g:7952:3: rulerIf
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
    // InternalAle.g:7961:1: rule__RStatement__ExprAssignment_5_1 : ( rulerExpression ) ;
    public final void rule__RStatement__ExprAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7965:1: ( ( rulerExpression ) )
            // InternalAle.g:7966:2: ( rulerExpression )
            {
            // InternalAle.g:7966:2: ( rulerExpression )
            // InternalAle.g:7967:3: rulerExpression
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


    // $ANTLR start "rule__RAssign__LeftAssignment_0"
    // InternalAle.g:7976:1: rule__RAssign__LeftAssignment_0 : ( ruleexpression ) ;
    public final void rule__RAssign__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7980:1: ( ( ruleexpression ) )
            // InternalAle.g:7981:2: ( ruleexpression )
            {
            // InternalAle.g:7981:2: ( ruleexpression )
            // InternalAle.g:7982:3: ruleexpression
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
    // InternalAle.g:7991:1: rule__RAssign__RightAssignment_2 : ( ruleexpression ) ;
    public final void rule__RAssign__RightAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7995:1: ( ( ruleexpression ) )
            // InternalAle.g:7996:2: ( ruleexpression )
            {
            // InternalAle.g:7996:2: ( ruleexpression )
            // InternalAle.g:7997:3: ruleexpression
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
    // InternalAle.g:8006:1: rule__RForEach__BlockAssignment_6 : ( rulerBlock ) ;
    public final void rule__RForEach__BlockAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8010:1: ( ( rulerBlock ) )
            // InternalAle.g:8011:2: ( rulerBlock )
            {
            // InternalAle.g:8011:2: ( rulerBlock )
            // InternalAle.g:8012:3: rulerBlock
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
    // InternalAle.g:8021:1: rule__RBlock__StatementAssignment_1_0 : ( rulerStatement ) ;
    public final void rule__RBlock__StatementAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8025:1: ( ( rulerStatement ) )
            // InternalAle.g:8026:2: ( rulerStatement )
            {
            // InternalAle.g:8026:2: ( rulerStatement )
            // InternalAle.g:8027:3: rulerStatement
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
    // InternalAle.g:8036:1: rule__RBlock__StatementAssignment_1_1 : ( rulerStatement ) ;
    public final void rule__RBlock__StatementAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8040:1: ( ( rulerStatement ) )
            // InternalAle.g:8041:2: ( rulerStatement )
            {
            // InternalAle.g:8041:2: ( rulerStatement )
            // InternalAle.g:8042:3: rulerStatement
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
    // InternalAle.g:8051:1: rule__RIf__ConditionAssignment_2 : ( ruleexpression ) ;
    public final void rule__RIf__ConditionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8055:1: ( ( ruleexpression ) )
            // InternalAle.g:8056:2: ( ruleexpression )
            {
            // InternalAle.g:8056:2: ( ruleexpression )
            // InternalAle.g:8057:3: ruleexpression
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
    // InternalAle.g:8066:1: rule__RIf__IfBlockAssignment_4 : ( rulerBlock ) ;
    public final void rule__RIf__IfBlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8070:1: ( ( rulerBlock ) )
            // InternalAle.g:8071:2: ( rulerBlock )
            {
            // InternalAle.g:8071:2: ( rulerBlock )
            // InternalAle.g:8072:3: rulerBlock
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
    // InternalAle.g:8081:1: rule__RIf__ElseBlockAssignment_5_1 : ( rulerBlock ) ;
    public final void rule__RIf__ElseBlockAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8085:1: ( ( rulerBlock ) )
            // InternalAle.g:8086:2: ( rulerBlock )
            {
            // InternalAle.g:8086:2: ( rulerBlock )
            // InternalAle.g:8087:3: rulerBlock
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
    // InternalAle.g:8096:1: rule__RWhile__BlockAssignment_4 : ( rulerBlock ) ;
    public final void rule__RWhile__BlockAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8100:1: ( ( rulerBlock ) )
            // InternalAle.g:8101:2: ( rulerBlock )
            {
            // InternalAle.g:8101:2: ( rulerBlock )
            // InternalAle.g:8102:3: rulerBlock
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
    // InternalAle.g:8111:1: rule__Expression__LeftPartAssignment_0 : ( rulenonLeftRecExpression ) ;
    public final void rule__Expression__LeftPartAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8115:1: ( ( rulenonLeftRecExpression ) )
            // InternalAle.g:8116:2: ( rulenonLeftRecExpression )
            {
            // InternalAle.g:8116:2: ( rulenonLeftRecExpression )
            // InternalAle.g:8117:3: rulenonLeftRecExpression
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
    // InternalAle.g:8126:1: rule__Expression__RecpartAssignment_1 : ( rulerecExpression ) ;
    public final void rule__Expression__RecpartAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8130:1: ( ( rulerecExpression ) )
            // InternalAle.g:8131:2: ( rulerecExpression )
            {
            // InternalAle.g:8131:2: ( rulerecExpression )
            // InternalAle.g:8132:3: rulerecExpression
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
    // InternalAle.g:8141:1: rule__RecExpression__RecExpAssignment_1 : ( rulerecExpression ) ;
    public final void rule__RecExpression__RecExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8145:1: ( ( rulerecExpression ) )
            // InternalAle.g:8146:2: ( rulerecExpression )
            {
            // InternalAle.g:8146:2: ( rulerecExpression )
            // InternalAle.g:8147:3: rulerecExpression
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
    // InternalAle.g:8156:1: rule__NavigationSegment__IdentAssignment_0_2 : ( RULE_IDENT ) ;
    public final void rule__NavigationSegment__IdentAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8160:1: ( ( RULE_IDENT ) )
            // InternalAle.g:8161:2: ( RULE_IDENT )
            {
            // InternalAle.g:8161:2: ( RULE_IDENT )
            // InternalAle.g:8162:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getIdentIdentTerminalRuleCall_0_2_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getIdentIdentTerminalRuleCall_0_2_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:8171:1: rule__NavigationSegment__CallAssignment_1_2 : ( rulecallExp ) ;
    public final void rule__NavigationSegment__CallAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8175:1: ( ( rulecallExp ) )
            // InternalAle.g:8176:2: ( rulecallExp )
            {
            // InternalAle.g:8176:2: ( rulecallExp )
            // InternalAle.g:8177:3: rulecallExp
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
    // InternalAle.g:8186:1: rule__NavigationSegment__CallAssignment_2_2 : ( rulecallExp ) ;
    public final void rule__NavigationSegment__CallAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8190:1: ( ( rulecallExp ) )
            // InternalAle.g:8191:2: ( rulecallExp )
            {
            // InternalAle.g:8191:2: ( rulecallExp )
            // InternalAle.g:8192:3: rulecallExp
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


    // $ANTLR start "rule__NonLeftRecExpression__ConditionAssignment_5_1"
    // InternalAle.g:8201:1: rule__NonLeftRecExpression__ConditionAssignment_5_1 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__ConditionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8205:1: ( ( ruleexpression ) )
            // InternalAle.g:8206:2: ( ruleexpression )
            {
            // InternalAle.g:8206:2: ( ruleexpression )
            // InternalAle.g:8207:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getConditionExpressionParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getConditionExpressionParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__ConditionAssignment_5_1"


    // $ANTLR start "rule__NonLeftRecExpression__IfBlockAssignment_5_3"
    // InternalAle.g:8216:1: rule__NonLeftRecExpression__IfBlockAssignment_5_3 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__IfBlockAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8220:1: ( ( ruleexpression ) )
            // InternalAle.g:8221:2: ( ruleexpression )
            {
            // InternalAle.g:8221:2: ( ruleexpression )
            // InternalAle.g:8222:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getIfBlockExpressionParserRuleCall_5_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getIfBlockExpressionParserRuleCall_5_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__IfBlockAssignment_5_3"


    // $ANTLR start "rule__NonLeftRecExpression__ElseBlockAssignment_5_5"
    // InternalAle.g:8231:1: rule__NonLeftRecExpression__ElseBlockAssignment_5_5 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__ElseBlockAssignment_5_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8235:1: ( ( ruleexpression ) )
            // InternalAle.g:8236:2: ( ruleexpression )
            {
            // InternalAle.g:8236:2: ( ruleexpression )
            // InternalAle.g:8237:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getElseBlockExpressionParserRuleCall_5_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getElseBlockExpressionParserRuleCall_5_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__ElseBlockAssignment_5_5"


    // $ANTLR start "rule__NonLeftRecExpression__BindingsAssignment_6_1"
    // InternalAle.g:8246:1: rule__NonLeftRecExpression__BindingsAssignment_6_1 : ( rulebinding ) ;
    public final void rule__NonLeftRecExpression__BindingsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8250:1: ( ( rulebinding ) )
            // InternalAle.g:8251:2: ( rulebinding )
            {
            // InternalAle.g:8251:2: ( rulebinding )
            // InternalAle.g:8252:3: rulebinding
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulebinding();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__BindingsAssignment_6_1"


    // $ANTLR start "rule__NonLeftRecExpression__BindingsAssignment_6_2_1"
    // InternalAle.g:8261:1: rule__NonLeftRecExpression__BindingsAssignment_6_2_1 : ( rulebinding ) ;
    public final void rule__NonLeftRecExpression__BindingsAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8265:1: ( ( rulebinding ) )
            // InternalAle.g:8266:2: ( rulebinding )
            {
            // InternalAle.g:8266:2: ( rulebinding )
            // InternalAle.g:8267:3: rulebinding
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulebinding();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingsBindingParserRuleCall_6_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__BindingsAssignment_6_2_1"


    // $ANTLR start "rule__NonLeftRecExpression__LetExprAssignment_6_4"
    // InternalAle.g:8276:1: rule__NonLeftRecExpression__LetExprAssignment_6_4 : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__LetExprAssignment_6_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8280:1: ( ( ruleexpression ) )
            // InternalAle.g:8281:2: ( ruleexpression )
            {
            // InternalAle.g:8281:2: ( ruleexpression )
            // InternalAle.g:8282:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getLetExprExpressionParserRuleCall_6_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getLetExprExpressionParserRuleCall_6_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NonLeftRecExpression__LetExprAssignment_6_4"


    // $ANTLR start "rule__ExpressionSequence__SeqExprsAssignment_0"
    // InternalAle.g:8291:1: rule__ExpressionSequence__SeqExprsAssignment_0 : ( ruleexpression ) ;
    public final void rule__ExpressionSequence__SeqExprsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8295:1: ( ( ruleexpression ) )
            // InternalAle.g:8296:2: ( ruleexpression )
            {
            // InternalAle.g:8296:2: ( ruleexpression )
            // InternalAle.g:8297:3: ruleexpression
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
    // InternalAle.g:8306:1: rule__ExpressionSequence__SeqExprsAssignment_1_1 : ( ruleexpression ) ;
    public final void rule__ExpressionSequence__SeqExprsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:8310:1: ( ( ruleexpression ) )
            // InternalAle.g:8311:2: ( ruleexpression )
            {
            // InternalAle.g:8311:2: ( ruleexpression )
            // InternalAle.g:8312:3: ruleexpression
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

    // $ANTLR start synpred4_InternalAle
    public final void synpred4_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:1000:2: ( ( ( rule__RStatement__Group_0__0 ) ) )
        // InternalAle.g:1000:2: ( ( rule__RStatement__Group_0__0 ) )
        {
        // InternalAle.g:1000:2: ( ( rule__RStatement__Group_0__0 ) )
        // InternalAle.g:1001:3: ( rule__RStatement__Group_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRStatementAccess().getGroup_0()); 
        }
        // InternalAle.g:1002:3: ( rule__RStatement__Group_0__0 )
        // InternalAle.g:1002:4: rule__RStatement__Group_0__0
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
        // InternalAle.g:1006:2: ( ( ( rule__RStatement__Group_1__0 ) ) )
        // InternalAle.g:1006:2: ( ( rule__RStatement__Group_1__0 ) )
        {
        // InternalAle.g:1006:2: ( ( rule__RStatement__Group_1__0 ) )
        // InternalAle.g:1007:3: ( rule__RStatement__Group_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRStatementAccess().getGroup_1()); 
        }
        // InternalAle.g:1008:3: ( rule__RStatement__Group_1__0 )
        // InternalAle.g:1008:4: rule__RStatement__Group_1__0
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
        // InternalAle.g:1024:2: ( ( ( rule__RStatement__Group_4__0 ) ) )
        // InternalAle.g:1024:2: ( ( rule__RStatement__Group_4__0 ) )
        {
        // InternalAle.g:1024:2: ( ( rule__RStatement__Group_4__0 ) )
        // InternalAle.g:1025:3: ( rule__RStatement__Group_4__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRStatementAccess().getGroup_4()); 
        }
        // InternalAle.g:1026:3: ( rule__RStatement__Group_4__0 )
        // InternalAle.g:1026:4: rule__RStatement__Group_4__0
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

    // $ANTLR start synpred80_InternalAle
    public final void synpred80_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:4715:3: ( rule__Expression__RecpartAssignment_1 )
        // InternalAle.g:4715:3: rule__Expression__RecpartAssignment_1
        {
        pushFollow(FOLLOW_2);
        rule__Expression__RecpartAssignment_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_InternalAle

    // $ANTLR start synpred81_InternalAle
    public final void synpred81_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:4769:3: ( rule__RecExpression__RecExpAssignment_1 )
        // InternalAle.g:4769:3: rule__RecExpression__RecExpAssignment_1
        {
        pushFollow(FOLLOW_2);
        rule__RecExpression__RecExpAssignment_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred81_InternalAle

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
    public final boolean synpred80_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_InternalAle_fragment(); // can never throw exception
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
    public final boolean synpred81_InternalAle() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_InternalAle_fragment(); // can never throw exception
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
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String dfa_1s = "\34\uffff";
    static final String dfa_2s = "\1\4\25\0\6\uffff";
    static final String dfa_3s = "\1\123\25\0\6\uffff";
    static final String dfa_4s = "\26\uffff\1\3\1\4\1\1\1\2\1\6\1\5";
    static final String dfa_5s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\13\1\14\1\15\12\uffff\1\12\22\uffff\1\16\1\17\1\20\1\2\1\3\1\4\1\5\10\uffff\1\10\3\uffff\1\23\3\uffff\1\26\4\uffff\1\24\1\uffff\1\27\5\uffff\1\11\2\uffff\1\25\2\uffff\1\21\1\22\1\uffff\1\6\1\7",
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
            return "995:1: rule__RStatement__Alternatives : ( ( ( rule__RStatement__Group_0__0 ) ) | ( ( rule__RStatement__Group_1__0 ) ) | ( ( rule__RStatement__Group_2__0 ) ) | ( ( rule__RStatement__Group_3__0 ) ) | ( ( rule__RStatement__Group_4__0 ) ) | ( ( rule__RStatement__Group_5__0 ) ) );";
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
    static final String dfa_9s = "\1\4\10\uffff\1\115\1\uffff\1\4\1\10\2\uffff";
    static final String dfa_10s = "\1\123\10\uffff\1\121\1\uffff\1\4\1\121\2\uffff";
    static final String dfa_11s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\2\uffff\1\12\1\11";
    static final String dfa_12s = "\17\uffff}>";
    static final String[] dfa_13s = {
            "\1\11\1\1\1\2\1\3\35\uffff\1\4\1\5\1\6\4\12\10\uffff\1\12\32\uffff\1\7\1\10\1\uffff\2\12",
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
            "\1\12\10\uffff\12\12\22\uffff\1\12\3\uffff\1\12\3\uffff\1\12\1\uffff\1\12\1\uffff\1\12\1\uffff\1\12\1\uffff\1\12\4\uffff\1\12\1\uffff\5\12\1\uffff\2\12\1\uffff\1\15\3\uffff\1\16",
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

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1364:1: rule__Literal__Alternatives : ( ( RULE_STRING ) | ( RULE_INT ) | ( RULE_REAL ) | ( 'true' ) | ( 'false' ) | ( 'null' ) | ( ( rule__Literal__Group_6__0 ) ) | ( ( rule__Literal__Group_7__0 ) ) | ( ( rule__Literal__Group_8__0 ) ) | ( ( rule__Literal__Group_9__0 ) ) | ( ruletypeLiteral ) );";
        }
    }
    static final String dfa_14s = "\24\uffff";
    static final String dfa_15s = "\1\22\23\uffff";
    static final String dfa_16s = "\1\10\21\0\2\uffff";
    static final String dfa_17s = "\1\113\21\0\2\uffff";
    static final String dfa_18s = "\22\uffff\1\2\1\1";
    static final String dfa_19s = "\1\uffff\1\2\1\12\1\20\1\15\1\5\1\3\1\17\1\4\1\1\1\16\1\13\1\0\1\14\1\6\1\7\1\10\1\11\2\uffff}>";
    static final String[] dfa_20s = {
            "\1\3\10\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\22\uffff\1\22\3\uffff\1\1\3\uffff\1\22\1\uffff\1\22\1\uffff\1\22\1\uffff\1\22\1\uffff\1\22\4\uffff\1\22\1\uffff\1\16\1\17\1\20\1\21\1\2\1\uffff\2\22",
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
            return "4715:2: ( rule__Expression__RecpartAssignment_1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_12 = input.LA(1);

                         
                        int index35_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_9 = input.LA(1);

                         
                        int index35_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_1 = input.LA(1);

                         
                        int index35_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_1);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA35_6 = input.LA(1);

                         
                        int index35_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA35_8 = input.LA(1);

                         
                        int index35_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA35_5 = input.LA(1);

                         
                        int index35_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA35_14 = input.LA(1);

                         
                        int index35_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA35_15 = input.LA(1);

                         
                        int index35_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_15);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA35_16 = input.LA(1);

                         
                        int index35_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA35_17 = input.LA(1);

                         
                        int index35_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_17);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA35_2 = input.LA(1);

                         
                        int index35_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_2);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA35_11 = input.LA(1);

                         
                        int index35_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_11);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA35_13 = input.LA(1);

                         
                        int index35_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA35_4 = input.LA(1);

                         
                        int index35_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_4);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA35_10 = input.LA(1);

                         
                        int index35_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_10);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA35_7 = input.LA(1);

                         
                        int index35_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_7);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA35_3 = input.LA(1);

                         
                        int index35_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "4769:2: ( rule__RecExpression__RecExpAssignment_1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_12 = input.LA(1);

                         
                        int index36_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_9 = input.LA(1);

                         
                        int index36_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_1 = input.LA(1);

                         
                        int index36_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_1);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA36_6 = input.LA(1);

                         
                        int index36_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA36_8 = input.LA(1);

                         
                        int index36_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA36_5 = input.LA(1);

                         
                        int index36_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA36_14 = input.LA(1);

                         
                        int index36_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA36_15 = input.LA(1);

                         
                        int index36_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_15);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA36_16 = input.LA(1);

                         
                        int index36_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA36_17 = input.LA(1);

                         
                        int index36_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_17);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA36_2 = input.LA(1);

                         
                        int index36_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_2);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA36_11 = input.LA(1);

                         
                        int index36_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_11);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA36_13 = input.LA(1);

                         
                        int index36_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA36_4 = input.LA(1);

                         
                        int index36_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_4);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA36_10 = input.LA(1);

                         
                        int index36_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_10);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA36_7 = input.LA(1);

                         
                        int index36_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_7);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA36_3 = input.LA(1);

                         
                        int index36_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000D400000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0002200000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x04300F0000018010L,0x00000000000C0000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00100F0000000012L,0x00000000000C0000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0400000000018002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0400000000018000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00100F0000000010L,0x00000000000C0000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x02100F0000000010L,0x00000000000C0000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0800200000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x01100FE0000400F0L,0x00000000000D9202L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x41100FE0000400F0L,0x00000000000D9202L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x11300FE0000400F0L,0x00000000000D920AL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x11100FE0000400F0L,0x00000000000D920AL});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x11100FE0000400F2L,0x00000000000D920AL});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0002000007FE0100L,0x00000000000001F0L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000001FF8000010L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x2080000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000800000L,0x0000000000002000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000006000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0020000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});

}