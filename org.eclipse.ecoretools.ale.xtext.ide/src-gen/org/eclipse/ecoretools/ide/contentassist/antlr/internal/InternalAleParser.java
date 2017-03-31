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


    // $ANTLR start "entryRulelambdaExpression"
    // InternalAle.g:754:1: entryRulelambdaExpression : rulelambdaExpression EOF ;
    public final void entryRulelambdaExpression() throws RecognitionException {
        try {
            // InternalAle.g:755:1: ( rulelambdaExpression EOF )
            // InternalAle.g:756:1: rulelambdaExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLambdaExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            rulelambdaExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLambdaExpressionRule()); 
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
    // $ANTLR end "entryRulelambdaExpression"


    // $ANTLR start "rulelambdaExpression"
    // InternalAle.g:763:1: rulelambdaExpression : ( ruleexpression ) ;
    public final void rulelambdaExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:767:2: ( ( ruleexpression ) )
            // InternalAle.g:768:2: ( ruleexpression )
            {
            // InternalAle.g:768:2: ( ruleexpression )
            // InternalAle.g:769:3: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLambdaExpressionAccess().getExpressionParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLambdaExpressionAccess().getExpressionParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulelambdaExpression"


    // $ANTLR start "entryRulecollectionIterator"
    // InternalAle.g:779:1: entryRulecollectionIterator : rulecollectionIterator EOF ;
    public final void entryRulecollectionIterator() throws RecognitionException {
        try {
            // InternalAle.g:780:1: ( rulecollectionIterator EOF )
            // InternalAle.g:781:1: rulecollectionIterator EOF
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
    // InternalAle.g:788:1: rulecollectionIterator : ( ( rule__CollectionIterator__Alternatives ) ) ;
    public final void rulecollectionIterator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:792:2: ( ( ( rule__CollectionIterator__Alternatives ) ) )
            // InternalAle.g:793:2: ( ( rule__CollectionIterator__Alternatives ) )
            {
            // InternalAle.g:793:2: ( ( rule__CollectionIterator__Alternatives ) )
            // InternalAle.g:794:3: ( rule__CollectionIterator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionIteratorAccess().getAlternatives()); 
            }
            // InternalAle.g:795:3: ( rule__CollectionIterator__Alternatives )
            // InternalAle.g:795:4: rule__CollectionIterator__Alternatives
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
    // InternalAle.g:804:1: entryRuleexpressionSequence : ruleexpressionSequence EOF ;
    public final void entryRuleexpressionSequence() throws RecognitionException {
        try {
            // InternalAle.g:805:1: ( ruleexpressionSequence EOF )
            // InternalAle.g:806:1: ruleexpressionSequence EOF
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
    // InternalAle.g:813:1: ruleexpressionSequence : ( ( rule__ExpressionSequence__Group__0 )? ) ;
    public final void ruleexpressionSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:817:2: ( ( ( rule__ExpressionSequence__Group__0 )? ) )
            // InternalAle.g:818:2: ( ( rule__ExpressionSequence__Group__0 )? )
            {
            // InternalAle.g:818:2: ( ( rule__ExpressionSequence__Group__0 )? )
            // InternalAle.g:819:3: ( rule__ExpressionSequence__Group__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getGroup()); 
            }
            // InternalAle.g:820:3: ( rule__ExpressionSequence__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_IDENT && LA1_0<=RULE_REAL)||LA1_0==18||(LA1_0>=37 && LA1_0<=43)||LA1_0==52||LA1_0==56||LA1_0==65||LA1_0==73||LA1_0==76||(LA1_0>=79 && LA1_0<=80)||(LA1_0>=82 && LA1_0<=83)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalAle.g:820:4: rule__ExpressionSequence__Group__0
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
    // InternalAle.g:829:1: entryRulevariableDefinition : rulevariableDefinition EOF ;
    public final void entryRulevariableDefinition() throws RecognitionException {
        try {
            // InternalAle.g:830:1: ( rulevariableDefinition EOF )
            // InternalAle.g:831:1: rulevariableDefinition EOF
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
    // InternalAle.g:838:1: rulevariableDefinition : ( ( rule__VariableDefinition__Group__0 ) ) ;
    public final void rulevariableDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:842:2: ( ( ( rule__VariableDefinition__Group__0 ) ) )
            // InternalAle.g:843:2: ( ( rule__VariableDefinition__Group__0 ) )
            {
            // InternalAle.g:843:2: ( ( rule__VariableDefinition__Group__0 ) )
            // InternalAle.g:844:3: ( rule__VariableDefinition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getGroup()); 
            }
            // InternalAle.g:845:3: ( rule__VariableDefinition__Group__0 )
            // InternalAle.g:845:4: rule__VariableDefinition__Group__0
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
    // InternalAle.g:854:1: entryRuleliteral : ruleliteral EOF ;
    public final void entryRuleliteral() throws RecognitionException {
        try {
            // InternalAle.g:855:1: ( ruleliteral EOF )
            // InternalAle.g:856:1: ruleliteral EOF
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
    // InternalAle.g:863:1: ruleliteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleliteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:867:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalAle.g:868:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalAle.g:868:2: ( ( rule__Literal__Alternatives ) )
            // InternalAle.g:869:3: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // InternalAle.g:870:3: ( rule__Literal__Alternatives )
            // InternalAle.g:870:4: rule__Literal__Alternatives
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
    // InternalAle.g:879:1: entryRuletypeLiteral : ruletypeLiteral EOF ;
    public final void entryRuletypeLiteral() throws RecognitionException {
        try {
            // InternalAle.g:880:1: ( ruletypeLiteral EOF )
            // InternalAle.g:881:1: ruletypeLiteral EOF
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
    // InternalAle.g:888:1: ruletypeLiteral : ( ( rule__TypeLiteral__Alternatives ) ) ;
    public final void ruletypeLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:892:2: ( ( ( rule__TypeLiteral__Alternatives ) ) )
            // InternalAle.g:893:2: ( ( rule__TypeLiteral__Alternatives ) )
            {
            // InternalAle.g:893:2: ( ( rule__TypeLiteral__Alternatives ) )
            // InternalAle.g:894:3: ( rule__TypeLiteral__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getAlternatives()); 
            }
            // InternalAle.g:895:3: ( rule__TypeLiteral__Alternatives )
            // InternalAle.g:895:4: rule__TypeLiteral__Alternatives
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
    // InternalAle.g:904:1: entryRuleclassifierTypeRule : ruleclassifierTypeRule EOF ;
    public final void entryRuleclassifierTypeRule() throws RecognitionException {
        try {
            // InternalAle.g:905:1: ( ruleclassifierTypeRule EOF )
            // InternalAle.g:906:1: ruleclassifierTypeRule EOF
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
    // InternalAle.g:913:1: ruleclassifierTypeRule : ( ( rule__ClassifierTypeRule__Alternatives ) ) ;
    public final void ruleclassifierTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:917:2: ( ( ( rule__ClassifierTypeRule__Alternatives ) ) )
            // InternalAle.g:918:2: ( ( rule__ClassifierTypeRule__Alternatives ) )
            {
            // InternalAle.g:918:2: ( ( rule__ClassifierTypeRule__Alternatives ) )
            // InternalAle.g:919:3: ( rule__ClassifierTypeRule__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierTypeRuleAccess().getAlternatives()); 
            }
            // InternalAle.g:920:3: ( rule__ClassifierTypeRule__Alternatives )
            // InternalAle.g:920:4: rule__ClassifierTypeRule__Alternatives
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
    // InternalAle.g:929:1: entryRulerType : rulerType EOF ;
    public final void entryRulerType() throws RecognitionException {
        try {
            // InternalAle.g:930:1: ( rulerType EOF )
            // InternalAle.g:931:1: rulerType EOF
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
    // InternalAle.g:938:1: rulerType : ( ( rule__RType__Alternatives ) ) ;
    public final void rulerType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:942:2: ( ( ( rule__RType__Alternatives ) ) )
            // InternalAle.g:943:2: ( ( rule__RType__Alternatives ) )
            {
            // InternalAle.g:943:2: ( ( rule__RType__Alternatives ) )
            // InternalAle.g:944:3: ( rule__RType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRTypeAccess().getAlternatives()); 
            }
            // InternalAle.g:945:3: ( rule__RType__Alternatives )
            // InternalAle.g:945:4: rule__RType__Alternatives
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
    // InternalAle.g:954:1: entryRulerQualified : rulerQualified EOF ;
    public final void entryRulerQualified() throws RecognitionException {
        try {
            // InternalAle.g:955:1: ( rulerQualified EOF )
            // InternalAle.g:956:1: rulerQualified EOF
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
    // InternalAle.g:963:1: rulerQualified : ( ( rule__RQualified__Group__0 ) ) ;
    public final void rulerQualified() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:967:2: ( ( ( rule__RQualified__Group__0 ) ) )
            // InternalAle.g:968:2: ( ( rule__RQualified__Group__0 ) )
            {
            // InternalAle.g:968:2: ( ( rule__RQualified__Group__0 ) )
            // InternalAle.g:969:3: ( rule__RQualified__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getGroup()); 
            }
            // InternalAle.g:970:3: ( rule__RQualified__Group__0 )
            // InternalAle.g:970:4: rule__RQualified__Group__0
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
    // InternalAle.g:978:1: rule__RClass__Alternatives : ( ( rulerOpenClass ) | ( rulerNewClass ) );
    public final void rule__RClass__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:982:1: ( ( rulerOpenClass ) | ( rulerNewClass ) )
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
                    // InternalAle.g:983:2: ( rulerOpenClass )
                    {
                    // InternalAle.g:983:2: ( rulerOpenClass )
                    // InternalAle.g:984:3: rulerOpenClass
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRClassAccess().getROpenClassParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulerOpenClass();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRClassAccess().getROpenClassParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:989:2: ( rulerNewClass )
                    {
                    // InternalAle.g:989:2: ( rulerNewClass )
                    // InternalAle.g:990:3: rulerNewClass
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRClassAccess().getRNewClassParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulerNewClass();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRClassAccess().getRNewClassParserRuleCall_1()); 
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
    // InternalAle.g:999:1: rule__ROperation__Alternatives_1 : ( ( 'def' ) | ( 'override' ) );
    public final void rule__ROperation__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1003:1: ( ( 'def' ) | ( 'override' ) )
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
                    // InternalAle.g:1004:2: ( 'def' )
                    {
                    // InternalAle.g:1004:2: ( 'def' )
                    // InternalAle.g:1005:3: 'def'
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
                    // InternalAle.g:1010:2: ( 'override' )
                    {
                    // InternalAle.g:1010:2: ( 'override' )
                    // InternalAle.g:1011:3: 'override'
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
    // InternalAle.g:1020:1: rule__RStatement__Alternatives : ( ( rulerVarDecl ) | ( rulerAssign ) | ( rulerForEach ) | ( rulerWhile ) | ( rulerIf ) | ( rulerExpression ) );
    public final void rule__RStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1024:1: ( ( rulerVarDecl ) | ( rulerAssign ) | ( rulerForEach ) | ( rulerWhile ) | ( rulerIf ) | ( rulerExpression ) )
            int alt4=6;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalAle.g:1025:2: ( rulerVarDecl )
                    {
                    // InternalAle.g:1025:2: ( rulerVarDecl )
                    // InternalAle.g:1026:3: rulerVarDecl
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getRVarDeclParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulerVarDecl();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getRVarDeclParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAle.g:1031:2: ( rulerAssign )
                    {
                    // InternalAle.g:1031:2: ( rulerAssign )
                    // InternalAle.g:1032:3: rulerAssign
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getRAssignParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulerAssign();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getRAssignParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAle.g:1037:2: ( rulerForEach )
                    {
                    // InternalAle.g:1037:2: ( rulerForEach )
                    // InternalAle.g:1038:3: rulerForEach
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getRForEachParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulerForEach();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getRForEachParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAle.g:1043:2: ( rulerWhile )
                    {
                    // InternalAle.g:1043:2: ( rulerWhile )
                    // InternalAle.g:1044:3: rulerWhile
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getRWhileParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulerWhile();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getRWhileParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAle.g:1049:2: ( rulerIf )
                    {
                    // InternalAle.g:1049:2: ( rulerIf )
                    // InternalAle.g:1050:3: rulerIf
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getRIfParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulerIf();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getRIfParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAle.g:1055:2: ( rulerExpression )
                    {
                    // InternalAle.g:1055:2: ( rulerExpression )
                    // InternalAle.g:1056:3: rulerExpression
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRStatementAccess().getRExpressionParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_2);
                    rulerExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRStatementAccess().getRExpressionParserRuleCall_5()); 
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
    // InternalAle.g:1065:1: rule__RCollection__Alternatives : ( ( ( rule__RCollection__Group_0__0 ) ) | ( ruleexpression ) );
    public final void rule__RCollection__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1069:1: ( ( ( rule__RCollection__Group_0__0 ) ) | ( ruleexpression ) )
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
                    // InternalAle.g:1070:2: ( ( rule__RCollection__Group_0__0 ) )
                    {
                    // InternalAle.g:1070:2: ( ( rule__RCollection__Group_0__0 ) )
                    // InternalAle.g:1071:3: ( rule__RCollection__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRCollectionAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1072:3: ( rule__RCollection__Group_0__0 )
                    // InternalAle.g:1072:4: rule__RCollection__Group_0__0
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
                    // InternalAle.g:1076:2: ( ruleexpression )
                    {
                    // InternalAle.g:1076:2: ( ruleexpression )
                    // InternalAle.g:1077:3: ruleexpression
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
    // InternalAle.g:1086:1: rule__RecExpression__Alternatives_0 : ( ( rulenavigationSegment ) | ( ( rule__RecExpression__Group_0_1__0 ) ) | ( ( rule__RecExpression__Group_0_2__0 ) ) | ( ( rule__RecExpression__Group_0_3__0 ) ) | ( ( rule__RecExpression__Group_0_4__0 ) ) | ( ( rule__RecExpression__Group_0_5__0 ) ) | ( ( rule__RecExpression__Group_0_6__0 ) ) | ( ( rule__RecExpression__Group_0_7__0 ) ) );
    public final void rule__RecExpression__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1090:1: ( ( rulenavigationSegment ) | ( ( rule__RecExpression__Group_0_1__0 ) ) | ( ( rule__RecExpression__Group_0_2__0 ) ) | ( ( rule__RecExpression__Group_0_3__0 ) ) | ( ( rule__RecExpression__Group_0_4__0 ) ) | ( ( rule__RecExpression__Group_0_5__0 ) ) | ( ( rule__RecExpression__Group_0_6__0 ) ) | ( ( rule__RecExpression__Group_0_7__0 ) ) )
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
                    // InternalAle.g:1091:2: ( rulenavigationSegment )
                    {
                    // InternalAle.g:1091:2: ( rulenavigationSegment )
                    // InternalAle.g:1092:3: rulenavigationSegment
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
                    // InternalAle.g:1097:2: ( ( rule__RecExpression__Group_0_1__0 ) )
                    {
                    // InternalAle.g:1097:2: ( ( rule__RecExpression__Group_0_1__0 ) )
                    // InternalAle.g:1098:3: ( rule__RecExpression__Group_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_1()); 
                    }
                    // InternalAle.g:1099:3: ( rule__RecExpression__Group_0_1__0 )
                    // InternalAle.g:1099:4: rule__RecExpression__Group_0_1__0
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
                    // InternalAle.g:1103:2: ( ( rule__RecExpression__Group_0_2__0 ) )
                    {
                    // InternalAle.g:1103:2: ( ( rule__RecExpression__Group_0_2__0 ) )
                    // InternalAle.g:1104:3: ( rule__RecExpression__Group_0_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_2()); 
                    }
                    // InternalAle.g:1105:3: ( rule__RecExpression__Group_0_2__0 )
                    // InternalAle.g:1105:4: rule__RecExpression__Group_0_2__0
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
                    // InternalAle.g:1109:2: ( ( rule__RecExpression__Group_0_3__0 ) )
                    {
                    // InternalAle.g:1109:2: ( ( rule__RecExpression__Group_0_3__0 ) )
                    // InternalAle.g:1110:3: ( rule__RecExpression__Group_0_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_3()); 
                    }
                    // InternalAle.g:1111:3: ( rule__RecExpression__Group_0_3__0 )
                    // InternalAle.g:1111:4: rule__RecExpression__Group_0_3__0
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
                    // InternalAle.g:1115:2: ( ( rule__RecExpression__Group_0_4__0 ) )
                    {
                    // InternalAle.g:1115:2: ( ( rule__RecExpression__Group_0_4__0 ) )
                    // InternalAle.g:1116:3: ( rule__RecExpression__Group_0_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_4()); 
                    }
                    // InternalAle.g:1117:3: ( rule__RecExpression__Group_0_4__0 )
                    // InternalAle.g:1117:4: rule__RecExpression__Group_0_4__0
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
                    // InternalAle.g:1121:2: ( ( rule__RecExpression__Group_0_5__0 ) )
                    {
                    // InternalAle.g:1121:2: ( ( rule__RecExpression__Group_0_5__0 ) )
                    // InternalAle.g:1122:3: ( rule__RecExpression__Group_0_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_5()); 
                    }
                    // InternalAle.g:1123:3: ( rule__RecExpression__Group_0_5__0 )
                    // InternalAle.g:1123:4: rule__RecExpression__Group_0_5__0
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
                    // InternalAle.g:1127:2: ( ( rule__RecExpression__Group_0_6__0 ) )
                    {
                    // InternalAle.g:1127:2: ( ( rule__RecExpression__Group_0_6__0 ) )
                    // InternalAle.g:1128:3: ( rule__RecExpression__Group_0_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_6()); 
                    }
                    // InternalAle.g:1129:3: ( rule__RecExpression__Group_0_6__0 )
                    // InternalAle.g:1129:4: rule__RecExpression__Group_0_6__0
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
                    // InternalAle.g:1133:2: ( ( rule__RecExpression__Group_0_7__0 ) )
                    {
                    // InternalAle.g:1133:2: ( ( rule__RecExpression__Group_0_7__0 ) )
                    // InternalAle.g:1134:3: ( rule__RecExpression__Group_0_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRecExpressionAccess().getGroup_0_7()); 
                    }
                    // InternalAle.g:1135:3: ( rule__RecExpression__Group_0_7__0 )
                    // InternalAle.g:1135:4: rule__RecExpression__Group_0_7__0
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
    // InternalAle.g:1143:1: rule__NavigationSegment__Alternatives : ( ( ( rule__NavigationSegment__Group_0__0 ) ) | ( ( rule__NavigationSegment__Group_1__0 ) ) | ( ( rule__NavigationSegment__Group_2__0 ) ) );
    public final void rule__NavigationSegment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1147:1: ( ( ( rule__NavigationSegment__Group_0__0 ) ) | ( ( rule__NavigationSegment__Group_1__0 ) ) | ( ( rule__NavigationSegment__Group_2__0 ) ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==49) ) {
                int LA7_1 = input.LA(2);

                if ( ((LA7_1>=27 && LA7_1<=36)) ) {
                    alt7=2;
                }
                else if ( (LA7_1==RULE_IDENT) ) {
                    int LA7_4 = input.LA(3);

                    if ( (LA7_4==56) ) {
                        alt7=2;
                    }
                    else if ( (LA7_4==EOF||LA7_4==RULE_MULTOP||(LA7_4>=17 && LA7_4<=26)||LA7_4==45||LA7_4==49||LA7_4==53||LA7_4==55||LA7_4==57||LA7_4==59||LA7_4==61||LA7_4==66||(LA7_4>=68 && LA7_4<=72)||(LA7_4>=74 && LA7_4<=75)) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 4, input);

                        throw nvae;
                    }
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
                    // InternalAle.g:1148:2: ( ( rule__NavigationSegment__Group_0__0 ) )
                    {
                    // InternalAle.g:1148:2: ( ( rule__NavigationSegment__Group_0__0 ) )
                    // InternalAle.g:1149:3: ( rule__NavigationSegment__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationSegmentAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1150:3: ( rule__NavigationSegment__Group_0__0 )
                    // InternalAle.g:1150:4: rule__NavigationSegment__Group_0__0
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
                    // InternalAle.g:1154:2: ( ( rule__NavigationSegment__Group_1__0 ) )
                    {
                    // InternalAle.g:1154:2: ( ( rule__NavigationSegment__Group_1__0 ) )
                    // InternalAle.g:1155:3: ( rule__NavigationSegment__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationSegmentAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1156:3: ( rule__NavigationSegment__Group_1__0 )
                    // InternalAle.g:1156:4: rule__NavigationSegment__Group_1__0
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
                    // InternalAle.g:1160:2: ( ( rule__NavigationSegment__Group_2__0 ) )
                    {
                    // InternalAle.g:1160:2: ( ( rule__NavigationSegment__Group_2__0 ) )
                    // InternalAle.g:1161:3: ( rule__NavigationSegment__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationSegmentAccess().getGroup_2()); 
                    }
                    // InternalAle.g:1162:3: ( rule__NavigationSegment__Group_2__0 )
                    // InternalAle.g:1162:4: rule__NavigationSegment__Group_2__0
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
    // InternalAle.g:1170:1: rule__NonLeftRecExpression__Alternatives : ( ( ( rule__NonLeftRecExpression__Group_0__0 ) ) | ( ( rule__NonLeftRecExpression__Group_1__0 ) ) | ( RULE_IDENT ) | ( ruleliteral ) | ( ( rule__NonLeftRecExpression__Group_4__0 ) ) | ( ( rule__NonLeftRecExpression__Group_5__0 ) ) | ( ( rule__NonLeftRecExpression__Group_6__0 ) ) );
    public final void rule__NonLeftRecExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1174:1: ( ( ( rule__NonLeftRecExpression__Group_0__0 ) ) | ( ( rule__NonLeftRecExpression__Group_1__0 ) ) | ( RULE_IDENT ) | ( ruleliteral ) | ( ( rule__NonLeftRecExpression__Group_4__0 ) ) | ( ( rule__NonLeftRecExpression__Group_5__0 ) ) | ( ( rule__NonLeftRecExpression__Group_6__0 ) ) )
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
                    // InternalAle.g:1175:2: ( ( rule__NonLeftRecExpression__Group_0__0 ) )
                    {
                    // InternalAle.g:1175:2: ( ( rule__NonLeftRecExpression__Group_0__0 ) )
                    // InternalAle.g:1176:3: ( rule__NonLeftRecExpression__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1177:3: ( rule__NonLeftRecExpression__Group_0__0 )
                    // InternalAle.g:1177:4: rule__NonLeftRecExpression__Group_0__0
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
                    // InternalAle.g:1181:2: ( ( rule__NonLeftRecExpression__Group_1__0 ) )
                    {
                    // InternalAle.g:1181:2: ( ( rule__NonLeftRecExpression__Group_1__0 ) )
                    // InternalAle.g:1182:3: ( rule__NonLeftRecExpression__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1183:3: ( rule__NonLeftRecExpression__Group_1__0 )
                    // InternalAle.g:1183:4: rule__NonLeftRecExpression__Group_1__0
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
                    // InternalAle.g:1187:2: ( RULE_IDENT )
                    {
                    // InternalAle.g:1187:2: ( RULE_IDENT )
                    // InternalAle.g:1188:3: RULE_IDENT
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
                    // InternalAle.g:1193:2: ( ruleliteral )
                    {
                    // InternalAle.g:1193:2: ( ruleliteral )
                    // InternalAle.g:1194:3: ruleliteral
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
                    // InternalAle.g:1199:2: ( ( rule__NonLeftRecExpression__Group_4__0 ) )
                    {
                    // InternalAle.g:1199:2: ( ( rule__NonLeftRecExpression__Group_4__0 ) )
                    // InternalAle.g:1200:3: ( rule__NonLeftRecExpression__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_4()); 
                    }
                    // InternalAle.g:1201:3: ( rule__NonLeftRecExpression__Group_4__0 )
                    // InternalAle.g:1201:4: rule__NonLeftRecExpression__Group_4__0
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
                    // InternalAle.g:1205:2: ( ( rule__NonLeftRecExpression__Group_5__0 ) )
                    {
                    // InternalAle.g:1205:2: ( ( rule__NonLeftRecExpression__Group_5__0 ) )
                    // InternalAle.g:1206:3: ( rule__NonLeftRecExpression__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_5()); 
                    }
                    // InternalAle.g:1207:3: ( rule__NonLeftRecExpression__Group_5__0 )
                    // InternalAle.g:1207:4: rule__NonLeftRecExpression__Group_5__0
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
                    // InternalAle.g:1211:2: ( ( rule__NonLeftRecExpression__Group_6__0 ) )
                    {
                    // InternalAle.g:1211:2: ( ( rule__NonLeftRecExpression__Group_6__0 ) )
                    // InternalAle.g:1212:3: ( rule__NonLeftRecExpression__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6()); 
                    }
                    // InternalAle.g:1213:3: ( rule__NonLeftRecExpression__Group_6__0 )
                    // InternalAle.g:1213:4: rule__NonLeftRecExpression__Group_6__0
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
    // InternalAle.g:1221:1: rule__AddOp__Alternatives : ( ( '+' ) | ( '-' ) );
    public final void rule__AddOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1225:1: ( ( '+' ) | ( '-' ) )
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
                    // InternalAle.g:1226:2: ( '+' )
                    {
                    // InternalAle.g:1226:2: ( '+' )
                    // InternalAle.g:1227:3: '+'
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
                    // InternalAle.g:1232:2: ( '-' )
                    {
                    // InternalAle.g:1232:2: ( '-' )
                    // InternalAle.g:1233:3: '-'
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
    // InternalAle.g:1242:1: rule__CompOp__Alternatives : ( ( '<=' ) | ( '>=' ) | ( '!=' ) | ( '<>' ) | ( '=' ) | ( '==' ) | ( '<' ) | ( '>' ) );
    public final void rule__CompOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1246:1: ( ( '<=' ) | ( '>=' ) | ( '!=' ) | ( '<>' ) | ( '=' ) | ( '==' ) | ( '<' ) | ( '>' ) )
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
                    // InternalAle.g:1247:2: ( '<=' )
                    {
                    // InternalAle.g:1247:2: ( '<=' )
                    // InternalAle.g:1248:3: '<='
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
                    // InternalAle.g:1253:2: ( '>=' )
                    {
                    // InternalAle.g:1253:2: ( '>=' )
                    // InternalAle.g:1254:3: '>='
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
                    // InternalAle.g:1259:2: ( '!=' )
                    {
                    // InternalAle.g:1259:2: ( '!=' )
                    // InternalAle.g:1260:3: '!='
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
                    // InternalAle.g:1265:2: ( '<>' )
                    {
                    // InternalAle.g:1265:2: ( '<>' )
                    // InternalAle.g:1266:3: '<>'
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
                    // InternalAle.g:1271:2: ( '=' )
                    {
                    // InternalAle.g:1271:2: ( '=' )
                    // InternalAle.g:1272:3: '='
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
                    // InternalAle.g:1277:2: ( '==' )
                    {
                    // InternalAle.g:1277:2: ( '==' )
                    // InternalAle.g:1278:3: '=='
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
                    // InternalAle.g:1283:2: ( '<' )
                    {
                    // InternalAle.g:1283:2: ( '<' )
                    // InternalAle.g:1284:3: '<'
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
                    // InternalAle.g:1289:2: ( '>' )
                    {
                    // InternalAle.g:1289:2: ( '>' )
                    // InternalAle.g:1290:3: '>'
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
    // InternalAle.g:1299:1: rule__CallExp__Alternatives : ( ( ( rule__CallExp__Group_0__0 ) ) | ( ( rule__CallExp__Group_1__0 ) ) );
    public final void rule__CallExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1303:1: ( ( ( rule__CallExp__Group_0__0 ) ) | ( ( rule__CallExp__Group_1__0 ) ) )
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
                    // InternalAle.g:1304:2: ( ( rule__CallExp__Group_0__0 ) )
                    {
                    // InternalAle.g:1304:2: ( ( rule__CallExp__Group_0__0 ) )
                    // InternalAle.g:1305:3: ( rule__CallExp__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1306:3: ( rule__CallExp__Group_0__0 )
                    // InternalAle.g:1306:4: rule__CallExp__Group_0__0
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
                    // InternalAle.g:1310:2: ( ( rule__CallExp__Group_1__0 ) )
                    {
                    // InternalAle.g:1310:2: ( ( rule__CallExp__Group_1__0 ) )
                    // InternalAle.g:1311:3: ( rule__CallExp__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1312:3: ( rule__CallExp__Group_1__0 )
                    // InternalAle.g:1312:4: rule__CallExp__Group_1__0
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
    // InternalAle.g:1320:1: rule__CollectionIterator__Alternatives : ( ( 'select' ) | ( 'reject' ) | ( 'collect' ) | ( 'any' ) | ( 'exists' ) | ( 'forAll' ) | ( 'isUnique' ) | ( 'one' ) | ( 'sortedBy' ) | ( 'closure' ) );
    public final void rule__CollectionIterator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1324:1: ( ( 'select' ) | ( 'reject' ) | ( 'collect' ) | ( 'any' ) | ( 'exists' ) | ( 'forAll' ) | ( 'isUnique' ) | ( 'one' ) | ( 'sortedBy' ) | ( 'closure' ) )
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
                    // InternalAle.g:1325:2: ( 'select' )
                    {
                    // InternalAle.g:1325:2: ( 'select' )
                    // InternalAle.g:1326:3: 'select'
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
                    // InternalAle.g:1331:2: ( 'reject' )
                    {
                    // InternalAle.g:1331:2: ( 'reject' )
                    // InternalAle.g:1332:3: 'reject'
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
                    // InternalAle.g:1337:2: ( 'collect' )
                    {
                    // InternalAle.g:1337:2: ( 'collect' )
                    // InternalAle.g:1338:3: 'collect'
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
                    // InternalAle.g:1343:2: ( 'any' )
                    {
                    // InternalAle.g:1343:2: ( 'any' )
                    // InternalAle.g:1344:3: 'any'
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
                    // InternalAle.g:1349:2: ( 'exists' )
                    {
                    // InternalAle.g:1349:2: ( 'exists' )
                    // InternalAle.g:1350:3: 'exists'
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
                    // InternalAle.g:1355:2: ( 'forAll' )
                    {
                    // InternalAle.g:1355:2: ( 'forAll' )
                    // InternalAle.g:1356:3: 'forAll'
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
                    // InternalAle.g:1361:2: ( 'isUnique' )
                    {
                    // InternalAle.g:1361:2: ( 'isUnique' )
                    // InternalAle.g:1362:3: 'isUnique'
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
                    // InternalAle.g:1367:2: ( 'one' )
                    {
                    // InternalAle.g:1367:2: ( 'one' )
                    // InternalAle.g:1368:3: 'one'
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
                    // InternalAle.g:1373:2: ( 'sortedBy' )
                    {
                    // InternalAle.g:1373:2: ( 'sortedBy' )
                    // InternalAle.g:1374:3: 'sortedBy'
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
                    // InternalAle.g:1379:2: ( 'closure' )
                    {
                    // InternalAle.g:1379:2: ( 'closure' )
                    // InternalAle.g:1380:3: 'closure'
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
    // InternalAle.g:1389:1: rule__Literal__Alternatives : ( ( RULE_STRING ) | ( RULE_INT ) | ( RULE_REAL ) | ( 'true' ) | ( 'false' ) | ( 'null' ) | ( ( rule__Literal__Group_6__0 ) ) | ( ( rule__Literal__Group_7__0 ) ) | ( ( rule__Literal__Group_8__0 ) ) | ( ( rule__Literal__Group_9__0 ) ) | ( ruletypeLiteral ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1393:1: ( ( RULE_STRING ) | ( RULE_INT ) | ( RULE_REAL ) | ( 'true' ) | ( 'false' ) | ( 'null' ) | ( ( rule__Literal__Group_6__0 ) ) | ( ( rule__Literal__Group_7__0 ) ) | ( ( rule__Literal__Group_8__0 ) ) | ( ( rule__Literal__Group_9__0 ) ) | ( ruletypeLiteral ) )
            int alt13=11;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalAle.g:1394:2: ( RULE_STRING )
                    {
                    // InternalAle.g:1394:2: ( RULE_STRING )
                    // InternalAle.g:1395:3: RULE_STRING
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
                    // InternalAle.g:1400:2: ( RULE_INT )
                    {
                    // InternalAle.g:1400:2: ( RULE_INT )
                    // InternalAle.g:1401:3: RULE_INT
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
                    // InternalAle.g:1406:2: ( RULE_REAL )
                    {
                    // InternalAle.g:1406:2: ( RULE_REAL )
                    // InternalAle.g:1407:3: RULE_REAL
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
                    // InternalAle.g:1412:2: ( 'true' )
                    {
                    // InternalAle.g:1412:2: ( 'true' )
                    // InternalAle.g:1413:3: 'true'
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
                    // InternalAle.g:1418:2: ( 'false' )
                    {
                    // InternalAle.g:1418:2: ( 'false' )
                    // InternalAle.g:1419:3: 'false'
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
                    // InternalAle.g:1424:2: ( 'null' )
                    {
                    // InternalAle.g:1424:2: ( 'null' )
                    // InternalAle.g:1425:3: 'null'
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
                    // InternalAle.g:1430:2: ( ( rule__Literal__Group_6__0 ) )
                    {
                    // InternalAle.g:1430:2: ( ( rule__Literal__Group_6__0 ) )
                    // InternalAle.g:1431:3: ( rule__Literal__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_6()); 
                    }
                    // InternalAle.g:1432:3: ( rule__Literal__Group_6__0 )
                    // InternalAle.g:1432:4: rule__Literal__Group_6__0
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
                    // InternalAle.g:1436:2: ( ( rule__Literal__Group_7__0 ) )
                    {
                    // InternalAle.g:1436:2: ( ( rule__Literal__Group_7__0 ) )
                    // InternalAle.g:1437:3: ( rule__Literal__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_7()); 
                    }
                    // InternalAle.g:1438:3: ( rule__Literal__Group_7__0 )
                    // InternalAle.g:1438:4: rule__Literal__Group_7__0
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
                    // InternalAle.g:1442:2: ( ( rule__Literal__Group_8__0 ) )
                    {
                    // InternalAle.g:1442:2: ( ( rule__Literal__Group_8__0 ) )
                    // InternalAle.g:1443:3: ( rule__Literal__Group_8__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_8()); 
                    }
                    // InternalAle.g:1444:3: ( rule__Literal__Group_8__0 )
                    // InternalAle.g:1444:4: rule__Literal__Group_8__0
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
                    // InternalAle.g:1448:2: ( ( rule__Literal__Group_9__0 ) )
                    {
                    // InternalAle.g:1448:2: ( ( rule__Literal__Group_9__0 ) )
                    // InternalAle.g:1449:3: ( rule__Literal__Group_9__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getGroup_9()); 
                    }
                    // InternalAle.g:1450:3: ( rule__Literal__Group_9__0 )
                    // InternalAle.g:1450:4: rule__Literal__Group_9__0
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
                    // InternalAle.g:1454:2: ( ruletypeLiteral )
                    {
                    // InternalAle.g:1454:2: ( ruletypeLiteral )
                    // InternalAle.g:1455:3: ruletypeLiteral
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
    // InternalAle.g:1464:1: rule__TypeLiteral__Alternatives : ( ( 'String' ) | ( 'Integer' ) | ( 'Real' ) | ( 'Boolean' ) | ( ( rule__TypeLiteral__Group_4__0 ) ) | ( ( rule__TypeLiteral__Group_5__0 ) ) | ( ruleclassifierTypeRule ) | ( ( rule__TypeLiteral__Group_7__0 ) ) );
    public final void rule__TypeLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1468:1: ( ( 'String' ) | ( 'Integer' ) | ( 'Real' ) | ( 'Boolean' ) | ( ( rule__TypeLiteral__Group_4__0 ) ) | ( ( rule__TypeLiteral__Group_5__0 ) ) | ( ruleclassifierTypeRule ) | ( ( rule__TypeLiteral__Group_7__0 ) ) )
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
                    // InternalAle.g:1469:2: ( 'String' )
                    {
                    // InternalAle.g:1469:2: ( 'String' )
                    // InternalAle.g:1470:3: 'String'
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
                    // InternalAle.g:1475:2: ( 'Integer' )
                    {
                    // InternalAle.g:1475:2: ( 'Integer' )
                    // InternalAle.g:1476:3: 'Integer'
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
                    // InternalAle.g:1481:2: ( 'Real' )
                    {
                    // InternalAle.g:1481:2: ( 'Real' )
                    // InternalAle.g:1482:3: 'Real'
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
                    // InternalAle.g:1487:2: ( 'Boolean' )
                    {
                    // InternalAle.g:1487:2: ( 'Boolean' )
                    // InternalAle.g:1488:3: 'Boolean'
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
                    // InternalAle.g:1493:2: ( ( rule__TypeLiteral__Group_4__0 ) )
                    {
                    // InternalAle.g:1493:2: ( ( rule__TypeLiteral__Group_4__0 ) )
                    // InternalAle.g:1494:3: ( rule__TypeLiteral__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_4()); 
                    }
                    // InternalAle.g:1495:3: ( rule__TypeLiteral__Group_4__0 )
                    // InternalAle.g:1495:4: rule__TypeLiteral__Group_4__0
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
                    // InternalAle.g:1499:2: ( ( rule__TypeLiteral__Group_5__0 ) )
                    {
                    // InternalAle.g:1499:2: ( ( rule__TypeLiteral__Group_5__0 ) )
                    // InternalAle.g:1500:3: ( rule__TypeLiteral__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_5()); 
                    }
                    // InternalAle.g:1501:3: ( rule__TypeLiteral__Group_5__0 )
                    // InternalAle.g:1501:4: rule__TypeLiteral__Group_5__0
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
                    // InternalAle.g:1505:2: ( ruleclassifierTypeRule )
                    {
                    // InternalAle.g:1505:2: ( ruleclassifierTypeRule )
                    // InternalAle.g:1506:3: ruleclassifierTypeRule
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
                    // InternalAle.g:1511:2: ( ( rule__TypeLiteral__Group_7__0 ) )
                    {
                    // InternalAle.g:1511:2: ( ( rule__TypeLiteral__Group_7__0 ) )
                    // InternalAle.g:1512:3: ( rule__TypeLiteral__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeLiteralAccess().getGroup_7()); 
                    }
                    // InternalAle.g:1513:3: ( rule__TypeLiteral__Group_7__0 )
                    // InternalAle.g:1513:4: rule__TypeLiteral__Group_7__0
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
    // InternalAle.g:1521:1: rule__ClassifierTypeRule__Alternatives : ( ( ( rule__ClassifierTypeRule__Group_0__0 ) ) | ( ( rule__ClassifierTypeRule__Group_1__0 ) ) );
    public final void rule__ClassifierTypeRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1525:1: ( ( ( rule__ClassifierTypeRule__Group_0__0 ) ) | ( ( rule__ClassifierTypeRule__Group_1__0 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_IDENT) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==81) ) {
                    alt15=1;
                }
                else if ( (LA15_1==77) ) {
                    alt15=2;
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
                    // InternalAle.g:1526:2: ( ( rule__ClassifierTypeRule__Group_0__0 ) )
                    {
                    // InternalAle.g:1526:2: ( ( rule__ClassifierTypeRule__Group_0__0 ) )
                    // InternalAle.g:1527:3: ( rule__ClassifierTypeRule__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassifierTypeRuleAccess().getGroup_0()); 
                    }
                    // InternalAle.g:1528:3: ( rule__ClassifierTypeRule__Group_0__0 )
                    // InternalAle.g:1528:4: rule__ClassifierTypeRule__Group_0__0
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
                    // InternalAle.g:1532:2: ( ( rule__ClassifierTypeRule__Group_1__0 ) )
                    {
                    // InternalAle.g:1532:2: ( ( rule__ClassifierTypeRule__Group_1__0 ) )
                    // InternalAle.g:1533:3: ( rule__ClassifierTypeRule__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassifierTypeRuleAccess().getGroup_1()); 
                    }
                    // InternalAle.g:1534:3: ( rule__ClassifierTypeRule__Group_1__0 )
                    // InternalAle.g:1534:4: rule__ClassifierTypeRule__Group_1__0
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
    // InternalAle.g:1542:1: rule__RType__Alternatives : ( ( rulerQualified ) | ( ruletypeLiteral ) );
    public final void rule__RType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1546:1: ( ( rulerQualified ) | ( ruletypeLiteral ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_IDENT) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==EOF||LA16_1==RULE_IDENT||LA16_1==49) ) {
                    alt16=1;
                }
                else if ( (LA16_1==77||LA16_1==81) ) {
                    alt16=2;
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
                    // InternalAle.g:1547:2: ( rulerQualified )
                    {
                    // InternalAle.g:1547:2: ( rulerQualified )
                    // InternalAle.g:1548:3: rulerQualified
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
                    // InternalAle.g:1553:2: ( ruletypeLiteral )
                    {
                    // InternalAle.g:1553:2: ( ruletypeLiteral )
                    // InternalAle.g:1554:3: ruletypeLiteral
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
    // InternalAle.g:1563:1: rule__RRoot__Group__0 : rule__RRoot__Group__0__Impl rule__RRoot__Group__1 ;
    public final void rule__RRoot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1567:1: ( rule__RRoot__Group__0__Impl rule__RRoot__Group__1 )
            // InternalAle.g:1568:2: rule__RRoot__Group__0__Impl rule__RRoot__Group__1
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
    // InternalAle.g:1575:1: rule__RRoot__Group__0__Impl : ( 'behavior' ) ;
    public final void rule__RRoot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1579:1: ( ( 'behavior' ) )
            // InternalAle.g:1580:1: ( 'behavior' )
            {
            // InternalAle.g:1580:1: ( 'behavior' )
            // InternalAle.g:1581:2: 'behavior'
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
    // InternalAle.g:1590:1: rule__RRoot__Group__1 : rule__RRoot__Group__1__Impl rule__RRoot__Group__2 ;
    public final void rule__RRoot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1594:1: ( rule__RRoot__Group__1__Impl rule__RRoot__Group__2 )
            // InternalAle.g:1595:2: rule__RRoot__Group__1__Impl rule__RRoot__Group__2
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
    // InternalAle.g:1602:1: rule__RRoot__Group__1__Impl : ( rulerQualified ) ;
    public final void rule__RRoot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1606:1: ( ( rulerQualified ) )
            // InternalAle.g:1607:1: ( rulerQualified )
            {
            // InternalAle.g:1607:1: ( rulerQualified )
            // InternalAle.g:1608:2: rulerQualified
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
    // InternalAle.g:1617:1: rule__RRoot__Group__2 : rule__RRoot__Group__2__Impl rule__RRoot__Group__3 ;
    public final void rule__RRoot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1621:1: ( rule__RRoot__Group__2__Impl rule__RRoot__Group__3 )
            // InternalAle.g:1622:2: rule__RRoot__Group__2__Impl rule__RRoot__Group__3
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
    // InternalAle.g:1629:1: rule__RRoot__Group__2__Impl : ( ';' ) ;
    public final void rule__RRoot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1633:1: ( ( ';' ) )
            // InternalAle.g:1634:1: ( ';' )
            {
            // InternalAle.g:1634:1: ( ';' )
            // InternalAle.g:1635:2: ';'
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
    // InternalAle.g:1644:1: rule__RRoot__Group__3 : rule__RRoot__Group__3__Impl rule__RRoot__Group__4 ;
    public final void rule__RRoot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1648:1: ( rule__RRoot__Group__3__Impl rule__RRoot__Group__4 )
            // InternalAle.g:1649:2: rule__RRoot__Group__3__Impl rule__RRoot__Group__4
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
    // InternalAle.g:1656:1: rule__RRoot__Group__3__Impl : ( ( rulerImport )* ) ;
    public final void rule__RRoot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1660:1: ( ( ( rulerImport )* ) )
            // InternalAle.g:1661:1: ( ( rulerImport )* )
            {
            // InternalAle.g:1661:1: ( ( rulerImport )* )
            // InternalAle.g:1662:2: ( rulerImport )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getRImportParserRuleCall_3()); 
            }
            // InternalAle.g:1663:2: ( rulerImport )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==46) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalAle.g:1663:3: rulerImport
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
    // InternalAle.g:1671:1: rule__RRoot__Group__4 : rule__RRoot__Group__4__Impl rule__RRoot__Group__5 ;
    public final void rule__RRoot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1675:1: ( rule__RRoot__Group__4__Impl rule__RRoot__Group__5 )
            // InternalAle.g:1676:2: rule__RRoot__Group__4__Impl rule__RRoot__Group__5
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
    // InternalAle.g:1683:1: rule__RRoot__Group__4__Impl : ( ( rulerService )* ) ;
    public final void rule__RRoot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1687:1: ( ( ( rulerService )* ) )
            // InternalAle.g:1688:1: ( ( rulerService )* )
            {
            // InternalAle.g:1688:1: ( ( rulerService )* )
            // InternalAle.g:1689:2: ( rulerService )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getRServiceParserRuleCall_4()); 
            }
            // InternalAle.g:1690:2: ( rulerService )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==48) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalAle.g:1690:3: rulerService
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
    // InternalAle.g:1698:1: rule__RRoot__Group__5 : rule__RRoot__Group__5__Impl ;
    public final void rule__RRoot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1702:1: ( rule__RRoot__Group__5__Impl )
            // InternalAle.g:1703:2: rule__RRoot__Group__5__Impl
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
    // InternalAle.g:1709:1: rule__RRoot__Group__5__Impl : ( ( rule__RRoot__XtendedClassesAssignment_5 )* ) ;
    public final void rule__RRoot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1713:1: ( ( ( rule__RRoot__XtendedClassesAssignment_5 )* ) )
            // InternalAle.g:1714:1: ( ( rule__RRoot__XtendedClassesAssignment_5 )* )
            {
            // InternalAle.g:1714:1: ( ( rule__RRoot__XtendedClassesAssignment_5 )* )
            // InternalAle.g:1715:2: ( rule__RRoot__XtendedClassesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRRootAccess().getXtendedClassesAssignment_5()); 
            }
            // InternalAle.g:1716:2: ( rule__RRoot__XtendedClassesAssignment_5 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=50 && LA19_0<=51)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalAle.g:1716:3: rule__RRoot__XtendedClassesAssignment_5
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
    // InternalAle.g:1725:1: rule__RImport__Group__0 : rule__RImport__Group__0__Impl rule__RImport__Group__1 ;
    public final void rule__RImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1729:1: ( rule__RImport__Group__0__Impl rule__RImport__Group__1 )
            // InternalAle.g:1730:2: rule__RImport__Group__0__Impl rule__RImport__Group__1
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
    // InternalAle.g:1737:1: rule__RImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__RImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1741:1: ( ( 'import' ) )
            // InternalAle.g:1742:1: ( 'import' )
            {
            // InternalAle.g:1742:1: ( 'import' )
            // InternalAle.g:1743:2: 'import'
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
    // InternalAle.g:1752:1: rule__RImport__Group__1 : rule__RImport__Group__1__Impl rule__RImport__Group__2 ;
    public final void rule__RImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1756:1: ( rule__RImport__Group__1__Impl rule__RImport__Group__2 )
            // InternalAle.g:1757:2: rule__RImport__Group__1__Impl rule__RImport__Group__2
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
    // InternalAle.g:1764:1: rule__RImport__Group__1__Impl : ( rulerQualified ) ;
    public final void rule__RImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1768:1: ( ( rulerQualified ) )
            // InternalAle.g:1769:1: ( rulerQualified )
            {
            // InternalAle.g:1769:1: ( rulerQualified )
            // InternalAle.g:1770:2: rulerQualified
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
    // InternalAle.g:1779:1: rule__RImport__Group__2 : rule__RImport__Group__2__Impl rule__RImport__Group__3 ;
    public final void rule__RImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1783:1: ( rule__RImport__Group__2__Impl rule__RImport__Group__3 )
            // InternalAle.g:1784:2: rule__RImport__Group__2__Impl rule__RImport__Group__3
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
    // InternalAle.g:1791:1: rule__RImport__Group__2__Impl : ( 'as' ) ;
    public final void rule__RImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1795:1: ( ( 'as' ) )
            // InternalAle.g:1796:1: ( 'as' )
            {
            // InternalAle.g:1796:1: ( 'as' )
            // InternalAle.g:1797:2: 'as'
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
    // InternalAle.g:1806:1: rule__RImport__Group__3 : rule__RImport__Group__3__Impl rule__RImport__Group__4 ;
    public final void rule__RImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1810:1: ( rule__RImport__Group__3__Impl rule__RImport__Group__4 )
            // InternalAle.g:1811:2: rule__RImport__Group__3__Impl rule__RImport__Group__4
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
    // InternalAle.g:1818:1: rule__RImport__Group__3__Impl : ( RULE_IDENT ) ;
    public final void rule__RImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1822:1: ( ( RULE_IDENT ) )
            // InternalAle.g:1823:1: ( RULE_IDENT )
            {
            // InternalAle.g:1823:1: ( RULE_IDENT )
            // InternalAle.g:1824:2: RULE_IDENT
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
    // InternalAle.g:1833:1: rule__RImport__Group__4 : rule__RImport__Group__4__Impl ;
    public final void rule__RImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1837:1: ( rule__RImport__Group__4__Impl )
            // InternalAle.g:1838:2: rule__RImport__Group__4__Impl
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
    // InternalAle.g:1844:1: rule__RImport__Group__4__Impl : ( ';' ) ;
    public final void rule__RImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1848:1: ( ( ';' ) )
            // InternalAle.g:1849:1: ( ';' )
            {
            // InternalAle.g:1849:1: ( ';' )
            // InternalAle.g:1850:2: ';'
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
    // InternalAle.g:1860:1: rule__RService__Group__0 : rule__RService__Group__0__Impl rule__RService__Group__1 ;
    public final void rule__RService__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1864:1: ( rule__RService__Group__0__Impl rule__RService__Group__1 )
            // InternalAle.g:1865:2: rule__RService__Group__0__Impl rule__RService__Group__1
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
    // InternalAle.g:1872:1: rule__RService__Group__0__Impl : ( 'use' ) ;
    public final void rule__RService__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1876:1: ( ( 'use' ) )
            // InternalAle.g:1877:1: ( 'use' )
            {
            // InternalAle.g:1877:1: ( 'use' )
            // InternalAle.g:1878:2: 'use'
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
    // InternalAle.g:1887:1: rule__RService__Group__1 : rule__RService__Group__1__Impl rule__RService__Group__2 ;
    public final void rule__RService__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1891:1: ( rule__RService__Group__1__Impl rule__RService__Group__2 )
            // InternalAle.g:1892:2: rule__RService__Group__1__Impl rule__RService__Group__2
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
    // InternalAle.g:1899:1: rule__RService__Group__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RService__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1903:1: ( ( RULE_IDENT ) )
            // InternalAle.g:1904:1: ( RULE_IDENT )
            {
            // InternalAle.g:1904:1: ( RULE_IDENT )
            // InternalAle.g:1905:2: RULE_IDENT
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
    // InternalAle.g:1914:1: rule__RService__Group__2 : rule__RService__Group__2__Impl rule__RService__Group__3 ;
    public final void rule__RService__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1918:1: ( rule__RService__Group__2__Impl rule__RService__Group__3 )
            // InternalAle.g:1919:2: rule__RService__Group__2__Impl rule__RService__Group__3
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
    // InternalAle.g:1926:1: rule__RService__Group__2__Impl : ( ( rule__RService__Group_2__0 )* ) ;
    public final void rule__RService__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1930:1: ( ( ( rule__RService__Group_2__0 )* ) )
            // InternalAle.g:1931:1: ( ( rule__RService__Group_2__0 )* )
            {
            // InternalAle.g:1931:1: ( ( rule__RService__Group_2__0 )* )
            // InternalAle.g:1932:2: ( rule__RService__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRServiceAccess().getGroup_2()); 
            }
            // InternalAle.g:1933:2: ( rule__RService__Group_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==49) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalAle.g:1933:3: rule__RService__Group_2__0
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
    // InternalAle.g:1941:1: rule__RService__Group__3 : rule__RService__Group__3__Impl ;
    public final void rule__RService__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1945:1: ( rule__RService__Group__3__Impl )
            // InternalAle.g:1946:2: rule__RService__Group__3__Impl
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
    // InternalAle.g:1952:1: rule__RService__Group__3__Impl : ( ';' ) ;
    public final void rule__RService__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1956:1: ( ( ';' ) )
            // InternalAle.g:1957:1: ( ';' )
            {
            // InternalAle.g:1957:1: ( ';' )
            // InternalAle.g:1958:2: ';'
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
    // InternalAle.g:1968:1: rule__RService__Group_2__0 : rule__RService__Group_2__0__Impl rule__RService__Group_2__1 ;
    public final void rule__RService__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1972:1: ( rule__RService__Group_2__0__Impl rule__RService__Group_2__1 )
            // InternalAle.g:1973:2: rule__RService__Group_2__0__Impl rule__RService__Group_2__1
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
    // InternalAle.g:1980:1: rule__RService__Group_2__0__Impl : ( '.' ) ;
    public final void rule__RService__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1984:1: ( ( '.' ) )
            // InternalAle.g:1985:1: ( '.' )
            {
            // InternalAle.g:1985:1: ( '.' )
            // InternalAle.g:1986:2: '.'
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
    // InternalAle.g:1995:1: rule__RService__Group_2__1 : rule__RService__Group_2__1__Impl ;
    public final void rule__RService__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:1999:1: ( rule__RService__Group_2__1__Impl )
            // InternalAle.g:2000:2: rule__RService__Group_2__1__Impl
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
    // InternalAle.g:2006:1: rule__RService__Group_2__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RService__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2010:1: ( ( RULE_IDENT ) )
            // InternalAle.g:2011:1: ( RULE_IDENT )
            {
            // InternalAle.g:2011:1: ( RULE_IDENT )
            // InternalAle.g:2012:2: RULE_IDENT
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


    // $ANTLR start "rule__ROpenClass__Group__0"
    // InternalAle.g:2022:1: rule__ROpenClass__Group__0 : rule__ROpenClass__Group__0__Impl rule__ROpenClass__Group__1 ;
    public final void rule__ROpenClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2026:1: ( rule__ROpenClass__Group__0__Impl rule__ROpenClass__Group__1 )
            // InternalAle.g:2027:2: rule__ROpenClass__Group__0__Impl rule__ROpenClass__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalAle.g:2034:1: rule__ROpenClass__Group__0__Impl : ( 'open' ) ;
    public final void rule__ROpenClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2038:1: ( ( 'open' ) )
            // InternalAle.g:2039:1: ( 'open' )
            {
            // InternalAle.g:2039:1: ( 'open' )
            // InternalAle.g:2040:2: 'open'
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
    // InternalAle.g:2049:1: rule__ROpenClass__Group__1 : rule__ROpenClass__Group__1__Impl rule__ROpenClass__Group__2 ;
    public final void rule__ROpenClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2053:1: ( rule__ROpenClass__Group__1__Impl rule__ROpenClass__Group__2 )
            // InternalAle.g:2054:2: rule__ROpenClass__Group__1__Impl rule__ROpenClass__Group__2
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
    // InternalAle.g:2061:1: rule__ROpenClass__Group__1__Impl : ( 'class' ) ;
    public final void rule__ROpenClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2065:1: ( ( 'class' ) )
            // InternalAle.g:2066:1: ( 'class' )
            {
            // InternalAle.g:2066:1: ( 'class' )
            // InternalAle.g:2067:2: 'class'
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
    // InternalAle.g:2076:1: rule__ROpenClass__Group__2 : rule__ROpenClass__Group__2__Impl rule__ROpenClass__Group__3 ;
    public final void rule__ROpenClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2080:1: ( rule__ROpenClass__Group__2__Impl rule__ROpenClass__Group__3 )
            // InternalAle.g:2081:2: rule__ROpenClass__Group__2__Impl rule__ROpenClass__Group__3
            {
            pushFollow(FOLLOW_13);
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
    // InternalAle.g:2088:1: rule__ROpenClass__Group__2__Impl : ( ( rule__ROpenClass__NameAssignment_2 ) ) ;
    public final void rule__ROpenClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2092:1: ( ( ( rule__ROpenClass__NameAssignment_2 ) ) )
            // InternalAle.g:2093:1: ( ( rule__ROpenClass__NameAssignment_2 ) )
            {
            // InternalAle.g:2093:1: ( ( rule__ROpenClass__NameAssignment_2 ) )
            // InternalAle.g:2094:2: ( rule__ROpenClass__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getNameAssignment_2()); 
            }
            // InternalAle.g:2095:2: ( rule__ROpenClass__NameAssignment_2 )
            // InternalAle.g:2095:3: rule__ROpenClass__NameAssignment_2
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
    // InternalAle.g:2103:1: rule__ROpenClass__Group__3 : rule__ROpenClass__Group__3__Impl rule__ROpenClass__Group__4 ;
    public final void rule__ROpenClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2107:1: ( rule__ROpenClass__Group__3__Impl rule__ROpenClass__Group__4 )
            // InternalAle.g:2108:2: rule__ROpenClass__Group__3__Impl rule__ROpenClass__Group__4
            {
            pushFollow(FOLLOW_13);
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
    // InternalAle.g:2115:1: rule__ROpenClass__Group__3__Impl : ( ( rule__ROpenClass__Group_3__0 )? ) ;
    public final void rule__ROpenClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2119:1: ( ( ( rule__ROpenClass__Group_3__0 )? ) )
            // InternalAle.g:2120:1: ( ( rule__ROpenClass__Group_3__0 )? )
            {
            // InternalAle.g:2120:1: ( ( rule__ROpenClass__Group_3__0 )? )
            // InternalAle.g:2121:2: ( rule__ROpenClass__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getGroup_3()); 
            }
            // InternalAle.g:2122:2: ( rule__ROpenClass__Group_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==54) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalAle.g:2122:3: rule__ROpenClass__Group_3__0
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
    // InternalAle.g:2130:1: rule__ROpenClass__Group__4 : rule__ROpenClass__Group__4__Impl rule__ROpenClass__Group__5 ;
    public final void rule__ROpenClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2134:1: ( rule__ROpenClass__Group__4__Impl rule__ROpenClass__Group__5 )
            // InternalAle.g:2135:2: rule__ROpenClass__Group__4__Impl rule__ROpenClass__Group__5
            {
            pushFollow(FOLLOW_14);
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
    // InternalAle.g:2142:1: rule__ROpenClass__Group__4__Impl : ( '{' ) ;
    public final void rule__ROpenClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2146:1: ( ( '{' ) )
            // InternalAle.g:2147:1: ( '{' )
            {
            // InternalAle.g:2147:1: ( '{' )
            // InternalAle.g:2148:2: '{'
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
    // InternalAle.g:2157:1: rule__ROpenClass__Group__5 : rule__ROpenClass__Group__5__Impl rule__ROpenClass__Group__6 ;
    public final void rule__ROpenClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2161:1: ( rule__ROpenClass__Group__5__Impl rule__ROpenClass__Group__6 )
            // InternalAle.g:2162:2: rule__ROpenClass__Group__5__Impl rule__ROpenClass__Group__6
            {
            pushFollow(FOLLOW_14);
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
    // InternalAle.g:2169:1: rule__ROpenClass__Group__5__Impl : ( ( rule__ROpenClass__AttributesAssignment_5 )* ) ;
    public final void rule__ROpenClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2173:1: ( ( ( rule__ROpenClass__AttributesAssignment_5 )* ) )
            // InternalAle.g:2174:1: ( ( rule__ROpenClass__AttributesAssignment_5 )* )
            {
            // InternalAle.g:2174:1: ( ( rule__ROpenClass__AttributesAssignment_5 )* )
            // InternalAle.g:2175:2: ( rule__ROpenClass__AttributesAssignment_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getAttributesAssignment_5()); 
            }
            // InternalAle.g:2176:2: ( rule__ROpenClass__AttributesAssignment_5 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_IDENT||(LA22_0>=40 && LA22_0<=43)||LA22_0==52||(LA22_0>=82 && LA22_0<=83)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalAle.g:2176:3: rule__ROpenClass__AttributesAssignment_5
            	    {
            	    pushFollow(FOLLOW_15);
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
    // InternalAle.g:2184:1: rule__ROpenClass__Group__6 : rule__ROpenClass__Group__6__Impl rule__ROpenClass__Group__7 ;
    public final void rule__ROpenClass__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2188:1: ( rule__ROpenClass__Group__6__Impl rule__ROpenClass__Group__7 )
            // InternalAle.g:2189:2: rule__ROpenClass__Group__6__Impl rule__ROpenClass__Group__7
            {
            pushFollow(FOLLOW_14);
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
    // InternalAle.g:2196:1: rule__ROpenClass__Group__6__Impl : ( ( rule__ROpenClass__OperationsAssignment_6 )* ) ;
    public final void rule__ROpenClass__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2200:1: ( ( ( rule__ROpenClass__OperationsAssignment_6 )* ) )
            // InternalAle.g:2201:1: ( ( rule__ROpenClass__OperationsAssignment_6 )* )
            {
            // InternalAle.g:2201:1: ( ( rule__ROpenClass__OperationsAssignment_6 )* )
            // InternalAle.g:2202:2: ( rule__ROpenClass__OperationsAssignment_6 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getOperationsAssignment_6()); 
            }
            // InternalAle.g:2203:2: ( rule__ROpenClass__OperationsAssignment_6 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=15 && LA23_0<=16)||LA23_0==58) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalAle.g:2203:3: rule__ROpenClass__OperationsAssignment_6
            	    {
            	    pushFollow(FOLLOW_16);
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
    // InternalAle.g:2211:1: rule__ROpenClass__Group__7 : rule__ROpenClass__Group__7__Impl ;
    public final void rule__ROpenClass__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2215:1: ( rule__ROpenClass__Group__7__Impl )
            // InternalAle.g:2216:2: rule__ROpenClass__Group__7__Impl
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
    // InternalAle.g:2222:1: rule__ROpenClass__Group__7__Impl : ( '}' ) ;
    public final void rule__ROpenClass__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2226:1: ( ( '}' ) )
            // InternalAle.g:2227:1: ( '}' )
            {
            // InternalAle.g:2227:1: ( '}' )
            // InternalAle.g:2228:2: '}'
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
    // InternalAle.g:2238:1: rule__ROpenClass__Group_3__0 : rule__ROpenClass__Group_3__0__Impl rule__ROpenClass__Group_3__1 ;
    public final void rule__ROpenClass__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2242:1: ( rule__ROpenClass__Group_3__0__Impl rule__ROpenClass__Group_3__1 )
            // InternalAle.g:2243:2: rule__ROpenClass__Group_3__0__Impl rule__ROpenClass__Group_3__1
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
    // InternalAle.g:2250:1: rule__ROpenClass__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__ROpenClass__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2254:1: ( ( 'extends' ) )
            // InternalAle.g:2255:1: ( 'extends' )
            {
            // InternalAle.g:2255:1: ( 'extends' )
            // InternalAle.g:2256:2: 'extends'
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
    // InternalAle.g:2265:1: rule__ROpenClass__Group_3__1 : rule__ROpenClass__Group_3__1__Impl rule__ROpenClass__Group_3__2 ;
    public final void rule__ROpenClass__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2269:1: ( rule__ROpenClass__Group_3__1__Impl rule__ROpenClass__Group_3__2 )
            // InternalAle.g:2270:2: rule__ROpenClass__Group_3__1__Impl rule__ROpenClass__Group_3__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalAle.g:2277:1: rule__ROpenClass__Group_3__1__Impl : ( rulerQualified ) ;
    public final void rule__ROpenClass__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2281:1: ( ( rulerQualified ) )
            // InternalAle.g:2282:1: ( rulerQualified )
            {
            // InternalAle.g:2282:1: ( rulerQualified )
            // InternalAle.g:2283:2: rulerQualified
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
    // InternalAle.g:2292:1: rule__ROpenClass__Group_3__2 : rule__ROpenClass__Group_3__2__Impl ;
    public final void rule__ROpenClass__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2296:1: ( rule__ROpenClass__Group_3__2__Impl )
            // InternalAle.g:2297:2: rule__ROpenClass__Group_3__2__Impl
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
    // InternalAle.g:2303:1: rule__ROpenClass__Group_3__2__Impl : ( ( rule__ROpenClass__Group_3_2__0 )* ) ;
    public final void rule__ROpenClass__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2307:1: ( ( ( rule__ROpenClass__Group_3_2__0 )* ) )
            // InternalAle.g:2308:1: ( ( rule__ROpenClass__Group_3_2__0 )* )
            {
            // InternalAle.g:2308:1: ( ( rule__ROpenClass__Group_3_2__0 )* )
            // InternalAle.g:2309:2: ( rule__ROpenClass__Group_3_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROpenClassAccess().getGroup_3_2()); 
            }
            // InternalAle.g:2310:2: ( rule__ROpenClass__Group_3_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==55) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalAle.g:2310:3: rule__ROpenClass__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_18);
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
    // InternalAle.g:2319:1: rule__ROpenClass__Group_3_2__0 : rule__ROpenClass__Group_3_2__0__Impl rule__ROpenClass__Group_3_2__1 ;
    public final void rule__ROpenClass__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2323:1: ( rule__ROpenClass__Group_3_2__0__Impl rule__ROpenClass__Group_3_2__1 )
            // InternalAle.g:2324:2: rule__ROpenClass__Group_3_2__0__Impl rule__ROpenClass__Group_3_2__1
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
    // InternalAle.g:2331:1: rule__ROpenClass__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__ROpenClass__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2335:1: ( ( ',' ) )
            // InternalAle.g:2336:1: ( ',' )
            {
            // InternalAle.g:2336:1: ( ',' )
            // InternalAle.g:2337:2: ','
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
    // InternalAle.g:2346:1: rule__ROpenClass__Group_3_2__1 : rule__ROpenClass__Group_3_2__1__Impl ;
    public final void rule__ROpenClass__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2350:1: ( rule__ROpenClass__Group_3_2__1__Impl )
            // InternalAle.g:2351:2: rule__ROpenClass__Group_3_2__1__Impl
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
    // InternalAle.g:2357:1: rule__ROpenClass__Group_3_2__1__Impl : ( rulerQualified ) ;
    public final void rule__ROpenClass__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2361:1: ( ( rulerQualified ) )
            // InternalAle.g:2362:1: ( rulerQualified )
            {
            // InternalAle.g:2362:1: ( rulerQualified )
            // InternalAle.g:2363:2: rulerQualified
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
    // InternalAle.g:2373:1: rule__RNewClass__Group__0 : rule__RNewClass__Group__0__Impl rule__RNewClass__Group__1 ;
    public final void rule__RNewClass__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2377:1: ( rule__RNewClass__Group__0__Impl rule__RNewClass__Group__1 )
            // InternalAle.g:2378:2: rule__RNewClass__Group__0__Impl rule__RNewClass__Group__1
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
    // InternalAle.g:2385:1: rule__RNewClass__Group__0__Impl : ( 'class' ) ;
    public final void rule__RNewClass__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2389:1: ( ( 'class' ) )
            // InternalAle.g:2390:1: ( 'class' )
            {
            // InternalAle.g:2390:1: ( 'class' )
            // InternalAle.g:2391:2: 'class'
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
    // InternalAle.g:2400:1: rule__RNewClass__Group__1 : rule__RNewClass__Group__1__Impl rule__RNewClass__Group__2 ;
    public final void rule__RNewClass__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2404:1: ( rule__RNewClass__Group__1__Impl rule__RNewClass__Group__2 )
            // InternalAle.g:2405:2: rule__RNewClass__Group__1__Impl rule__RNewClass__Group__2
            {
            pushFollow(FOLLOW_19);
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
    // InternalAle.g:2412:1: rule__RNewClass__Group__1__Impl : ( ( rule__RNewClass__NameAssignment_1 ) ) ;
    public final void rule__RNewClass__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2416:1: ( ( ( rule__RNewClass__NameAssignment_1 ) ) )
            // InternalAle.g:2417:1: ( ( rule__RNewClass__NameAssignment_1 ) )
            {
            // InternalAle.g:2417:1: ( ( rule__RNewClass__NameAssignment_1 ) )
            // InternalAle.g:2418:2: ( rule__RNewClass__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getNameAssignment_1()); 
            }
            // InternalAle.g:2419:2: ( rule__RNewClass__NameAssignment_1 )
            // InternalAle.g:2419:3: rule__RNewClass__NameAssignment_1
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
    // InternalAle.g:2427:1: rule__RNewClass__Group__2 : rule__RNewClass__Group__2__Impl rule__RNewClass__Group__3 ;
    public final void rule__RNewClass__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2431:1: ( rule__RNewClass__Group__2__Impl rule__RNewClass__Group__3 )
            // InternalAle.g:2432:2: rule__RNewClass__Group__2__Impl rule__RNewClass__Group__3
            {
            pushFollow(FOLLOW_14);
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
    // InternalAle.g:2439:1: rule__RNewClass__Group__2__Impl : ( '{' ) ;
    public final void rule__RNewClass__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2443:1: ( ( '{' ) )
            // InternalAle.g:2444:1: ( '{' )
            {
            // InternalAle.g:2444:1: ( '{' )
            // InternalAle.g:2445:2: '{'
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
    // InternalAle.g:2454:1: rule__RNewClass__Group__3 : rule__RNewClass__Group__3__Impl rule__RNewClass__Group__4 ;
    public final void rule__RNewClass__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2458:1: ( rule__RNewClass__Group__3__Impl rule__RNewClass__Group__4 )
            // InternalAle.g:2459:2: rule__RNewClass__Group__3__Impl rule__RNewClass__Group__4
            {
            pushFollow(FOLLOW_14);
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
    // InternalAle.g:2466:1: rule__RNewClass__Group__3__Impl : ( ( rule__RNewClass__AttributesAssignment_3 )* ) ;
    public final void rule__RNewClass__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2470:1: ( ( ( rule__RNewClass__AttributesAssignment_3 )* ) )
            // InternalAle.g:2471:1: ( ( rule__RNewClass__AttributesAssignment_3 )* )
            {
            // InternalAle.g:2471:1: ( ( rule__RNewClass__AttributesAssignment_3 )* )
            // InternalAle.g:2472:2: ( rule__RNewClass__AttributesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getAttributesAssignment_3()); 
            }
            // InternalAle.g:2473:2: ( rule__RNewClass__AttributesAssignment_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_IDENT||(LA25_0>=40 && LA25_0<=43)||LA25_0==52||(LA25_0>=82 && LA25_0<=83)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalAle.g:2473:3: rule__RNewClass__AttributesAssignment_3
            	    {
            	    pushFollow(FOLLOW_15);
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
    // InternalAle.g:2481:1: rule__RNewClass__Group__4 : rule__RNewClass__Group__4__Impl rule__RNewClass__Group__5 ;
    public final void rule__RNewClass__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2485:1: ( rule__RNewClass__Group__4__Impl rule__RNewClass__Group__5 )
            // InternalAle.g:2486:2: rule__RNewClass__Group__4__Impl rule__RNewClass__Group__5
            {
            pushFollow(FOLLOW_14);
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
    // InternalAle.g:2493:1: rule__RNewClass__Group__4__Impl : ( ( rule__RNewClass__OperationsAssignment_4 )* ) ;
    public final void rule__RNewClass__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2497:1: ( ( ( rule__RNewClass__OperationsAssignment_4 )* ) )
            // InternalAle.g:2498:1: ( ( rule__RNewClass__OperationsAssignment_4 )* )
            {
            // InternalAle.g:2498:1: ( ( rule__RNewClass__OperationsAssignment_4 )* )
            // InternalAle.g:2499:2: ( rule__RNewClass__OperationsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getOperationsAssignment_4()); 
            }
            // InternalAle.g:2500:2: ( rule__RNewClass__OperationsAssignment_4 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=15 && LA26_0<=16)||LA26_0==58) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalAle.g:2500:3: rule__RNewClass__OperationsAssignment_4
            	    {
            	    pushFollow(FOLLOW_16);
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
    // InternalAle.g:2508:1: rule__RNewClass__Group__5 : rule__RNewClass__Group__5__Impl ;
    public final void rule__RNewClass__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2512:1: ( rule__RNewClass__Group__5__Impl )
            // InternalAle.g:2513:2: rule__RNewClass__Group__5__Impl
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
    // InternalAle.g:2519:1: rule__RNewClass__Group__5__Impl : ( '}' ) ;
    public final void rule__RNewClass__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2523:1: ( ( '}' ) )
            // InternalAle.g:2524:1: ( '}' )
            {
            // InternalAle.g:2524:1: ( '}' )
            // InternalAle.g:2525:2: '}'
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
    // InternalAle.g:2535:1: rule__ROperation__Group__0 : rule__ROperation__Group__0__Impl rule__ROperation__Group__1 ;
    public final void rule__ROperation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2539:1: ( rule__ROperation__Group__0__Impl rule__ROperation__Group__1 )
            // InternalAle.g:2540:2: rule__ROperation__Group__0__Impl rule__ROperation__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalAle.g:2547:1: rule__ROperation__Group__0__Impl : ( ( rulerTag )* ) ;
    public final void rule__ROperation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2551:1: ( ( ( rulerTag )* ) )
            // InternalAle.g:2552:1: ( ( rulerTag )* )
            {
            // InternalAle.g:2552:1: ( ( rulerTag )* )
            // InternalAle.g:2553:2: ( rulerTag )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getRTagParserRuleCall_0()); 
            }
            // InternalAle.g:2554:2: ( rulerTag )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==58) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalAle.g:2554:3: rulerTag
            	    {
            	    pushFollow(FOLLOW_21);
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
    // InternalAle.g:2562:1: rule__ROperation__Group__1 : rule__ROperation__Group__1__Impl rule__ROperation__Group__2 ;
    public final void rule__ROperation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2566:1: ( rule__ROperation__Group__1__Impl rule__ROperation__Group__2 )
            // InternalAle.g:2567:2: rule__ROperation__Group__1__Impl rule__ROperation__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalAle.g:2574:1: rule__ROperation__Group__1__Impl : ( ( rule__ROperation__Alternatives_1 ) ) ;
    public final void rule__ROperation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2578:1: ( ( ( rule__ROperation__Alternatives_1 ) ) )
            // InternalAle.g:2579:1: ( ( rule__ROperation__Alternatives_1 ) )
            {
            // InternalAle.g:2579:1: ( ( rule__ROperation__Alternatives_1 ) )
            // InternalAle.g:2580:2: ( rule__ROperation__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getAlternatives_1()); 
            }
            // InternalAle.g:2581:2: ( rule__ROperation__Alternatives_1 )
            // InternalAle.g:2581:3: rule__ROperation__Alternatives_1
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
    // InternalAle.g:2589:1: rule__ROperation__Group__2 : rule__ROperation__Group__2__Impl rule__ROperation__Group__3 ;
    public final void rule__ROperation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2593:1: ( rule__ROperation__Group__2__Impl rule__ROperation__Group__3 )
            // InternalAle.g:2594:2: rule__ROperation__Group__2__Impl rule__ROperation__Group__3
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
    // InternalAle.g:2601:1: rule__ROperation__Group__2__Impl : ( ( rule__ROperation__TypeAssignment_2 ) ) ;
    public final void rule__ROperation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2605:1: ( ( ( rule__ROperation__TypeAssignment_2 ) ) )
            // InternalAle.g:2606:1: ( ( rule__ROperation__TypeAssignment_2 ) )
            {
            // InternalAle.g:2606:1: ( ( rule__ROperation__TypeAssignment_2 ) )
            // InternalAle.g:2607:2: ( rule__ROperation__TypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getTypeAssignment_2()); 
            }
            // InternalAle.g:2608:2: ( rule__ROperation__TypeAssignment_2 )
            // InternalAle.g:2608:3: rule__ROperation__TypeAssignment_2
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
    // InternalAle.g:2616:1: rule__ROperation__Group__3 : rule__ROperation__Group__3__Impl rule__ROperation__Group__4 ;
    public final void rule__ROperation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2620:1: ( rule__ROperation__Group__3__Impl rule__ROperation__Group__4 )
            // InternalAle.g:2621:2: rule__ROperation__Group__3__Impl rule__ROperation__Group__4
            {
            pushFollow(FOLLOW_23);
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
    // InternalAle.g:2628:1: rule__ROperation__Group__3__Impl : ( ( rule__ROperation__NameAssignment_3 ) ) ;
    public final void rule__ROperation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2632:1: ( ( ( rule__ROperation__NameAssignment_3 ) ) )
            // InternalAle.g:2633:1: ( ( rule__ROperation__NameAssignment_3 ) )
            {
            // InternalAle.g:2633:1: ( ( rule__ROperation__NameAssignment_3 ) )
            // InternalAle.g:2634:2: ( rule__ROperation__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getNameAssignment_3()); 
            }
            // InternalAle.g:2635:2: ( rule__ROperation__NameAssignment_3 )
            // InternalAle.g:2635:3: rule__ROperation__NameAssignment_3
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
    // InternalAle.g:2643:1: rule__ROperation__Group__4 : rule__ROperation__Group__4__Impl rule__ROperation__Group__5 ;
    public final void rule__ROperation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2647:1: ( rule__ROperation__Group__4__Impl rule__ROperation__Group__5 )
            // InternalAle.g:2648:2: rule__ROperation__Group__4__Impl rule__ROperation__Group__5
            {
            pushFollow(FOLLOW_24);
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
    // InternalAle.g:2655:1: rule__ROperation__Group__4__Impl : ( '(' ) ;
    public final void rule__ROperation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2659:1: ( ( '(' ) )
            // InternalAle.g:2660:1: ( '(' )
            {
            // InternalAle.g:2660:1: ( '(' )
            // InternalAle.g:2661:2: '('
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
    // InternalAle.g:2670:1: rule__ROperation__Group__5 : rule__ROperation__Group__5__Impl rule__ROperation__Group__6 ;
    public final void rule__ROperation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2674:1: ( rule__ROperation__Group__5__Impl rule__ROperation__Group__6 )
            // InternalAle.g:2675:2: rule__ROperation__Group__5__Impl rule__ROperation__Group__6
            {
            pushFollow(FOLLOW_24);
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
    // InternalAle.g:2682:1: rule__ROperation__Group__5__Impl : ( ( rule__ROperation__ParamListAssignment_5 )? ) ;
    public final void rule__ROperation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2686:1: ( ( ( rule__ROperation__ParamListAssignment_5 )? ) )
            // InternalAle.g:2687:1: ( ( rule__ROperation__ParamListAssignment_5 )? )
            {
            // InternalAle.g:2687:1: ( ( rule__ROperation__ParamListAssignment_5 )? )
            // InternalAle.g:2688:2: ( rule__ROperation__ParamListAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getParamListAssignment_5()); 
            }
            // InternalAle.g:2689:2: ( rule__ROperation__ParamListAssignment_5 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_IDENT||(LA28_0>=40 && LA28_0<=43)||LA28_0==52||(LA28_0>=82 && LA28_0<=83)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAle.g:2689:3: rule__ROperation__ParamListAssignment_5
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
    // InternalAle.g:2697:1: rule__ROperation__Group__6 : rule__ROperation__Group__6__Impl rule__ROperation__Group__7 ;
    public final void rule__ROperation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2701:1: ( rule__ROperation__Group__6__Impl rule__ROperation__Group__7 )
            // InternalAle.g:2702:2: rule__ROperation__Group__6__Impl rule__ROperation__Group__7
            {
            pushFollow(FOLLOW_19);
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
    // InternalAle.g:2709:1: rule__ROperation__Group__6__Impl : ( ')' ) ;
    public final void rule__ROperation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2713:1: ( ( ')' ) )
            // InternalAle.g:2714:1: ( ')' )
            {
            // InternalAle.g:2714:1: ( ')' )
            // InternalAle.g:2715:2: ')'
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
    // InternalAle.g:2724:1: rule__ROperation__Group__7 : rule__ROperation__Group__7__Impl ;
    public final void rule__ROperation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2728:1: ( rule__ROperation__Group__7__Impl )
            // InternalAle.g:2729:2: rule__ROperation__Group__7__Impl
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
    // InternalAle.g:2735:1: rule__ROperation__Group__7__Impl : ( ( rule__ROperation__BodyAssignment_7 ) ) ;
    public final void rule__ROperation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2739:1: ( ( ( rule__ROperation__BodyAssignment_7 ) ) )
            // InternalAle.g:2740:1: ( ( rule__ROperation__BodyAssignment_7 ) )
            {
            // InternalAle.g:2740:1: ( ( rule__ROperation__BodyAssignment_7 ) )
            // InternalAle.g:2741:2: ( rule__ROperation__BodyAssignment_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getROperationAccess().getBodyAssignment_7()); 
            }
            // InternalAle.g:2742:2: ( rule__ROperation__BodyAssignment_7 )
            // InternalAle.g:2742:3: rule__ROperation__BodyAssignment_7
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
    // InternalAle.g:2751:1: rule__RTag__Group__0 : rule__RTag__Group__0__Impl rule__RTag__Group__1 ;
    public final void rule__RTag__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2755:1: ( rule__RTag__Group__0__Impl rule__RTag__Group__1 )
            // InternalAle.g:2756:2: rule__RTag__Group__0__Impl rule__RTag__Group__1
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
    // InternalAle.g:2763:1: rule__RTag__Group__0__Impl : ( '@' ) ;
    public final void rule__RTag__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2767:1: ( ( '@' ) )
            // InternalAle.g:2768:1: ( '@' )
            {
            // InternalAle.g:2768:1: ( '@' )
            // InternalAle.g:2769:2: '@'
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
    // InternalAle.g:2778:1: rule__RTag__Group__1 : rule__RTag__Group__1__Impl ;
    public final void rule__RTag__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2782:1: ( rule__RTag__Group__1__Impl )
            // InternalAle.g:2783:2: rule__RTag__Group__1__Impl
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
    // InternalAle.g:2789:1: rule__RTag__Group__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RTag__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2793:1: ( ( RULE_IDENT ) )
            // InternalAle.g:2794:1: ( RULE_IDENT )
            {
            // InternalAle.g:2794:1: ( RULE_IDENT )
            // InternalAle.g:2795:2: RULE_IDENT
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
    // InternalAle.g:2805:1: rule__RParameters__Group__0 : rule__RParameters__Group__0__Impl rule__RParameters__Group__1 ;
    public final void rule__RParameters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2809:1: ( rule__RParameters__Group__0__Impl rule__RParameters__Group__1 )
            // InternalAle.g:2810:2: rule__RParameters__Group__0__Impl rule__RParameters__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalAle.g:2817:1: rule__RParameters__Group__0__Impl : ( ( rule__RParameters__ParamsAssignment_0 ) ) ;
    public final void rule__RParameters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2821:1: ( ( ( rule__RParameters__ParamsAssignment_0 ) ) )
            // InternalAle.g:2822:1: ( ( rule__RParameters__ParamsAssignment_0 ) )
            {
            // InternalAle.g:2822:1: ( ( rule__RParameters__ParamsAssignment_0 ) )
            // InternalAle.g:2823:2: ( rule__RParameters__ParamsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getParamsAssignment_0()); 
            }
            // InternalAle.g:2824:2: ( rule__RParameters__ParamsAssignment_0 )
            // InternalAle.g:2824:3: rule__RParameters__ParamsAssignment_0
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
    // InternalAle.g:2832:1: rule__RParameters__Group__1 : rule__RParameters__Group__1__Impl ;
    public final void rule__RParameters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2836:1: ( rule__RParameters__Group__1__Impl )
            // InternalAle.g:2837:2: rule__RParameters__Group__1__Impl
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
    // InternalAle.g:2843:1: rule__RParameters__Group__1__Impl : ( ( rule__RParameters__Group_1__0 )* ) ;
    public final void rule__RParameters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2847:1: ( ( ( rule__RParameters__Group_1__0 )* ) )
            // InternalAle.g:2848:1: ( ( rule__RParameters__Group_1__0 )* )
            {
            // InternalAle.g:2848:1: ( ( rule__RParameters__Group_1__0 )* )
            // InternalAle.g:2849:2: ( rule__RParameters__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getGroup_1()); 
            }
            // InternalAle.g:2850:2: ( rule__RParameters__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==55) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalAle.g:2850:3: rule__RParameters__Group_1__0
            	    {
            	    pushFollow(FOLLOW_18);
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
    // InternalAle.g:2859:1: rule__RParameters__Group_1__0 : rule__RParameters__Group_1__0__Impl rule__RParameters__Group_1__1 ;
    public final void rule__RParameters__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2863:1: ( rule__RParameters__Group_1__0__Impl rule__RParameters__Group_1__1 )
            // InternalAle.g:2864:2: rule__RParameters__Group_1__0__Impl rule__RParameters__Group_1__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalAle.g:2871:1: rule__RParameters__Group_1__0__Impl : ( ',' ) ;
    public final void rule__RParameters__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2875:1: ( ( ',' ) )
            // InternalAle.g:2876:1: ( ',' )
            {
            // InternalAle.g:2876:1: ( ',' )
            // InternalAle.g:2877:2: ','
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
    // InternalAle.g:2886:1: rule__RParameters__Group_1__1 : rule__RParameters__Group_1__1__Impl ;
    public final void rule__RParameters__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2890:1: ( rule__RParameters__Group_1__1__Impl )
            // InternalAle.g:2891:2: rule__RParameters__Group_1__1__Impl
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
    // InternalAle.g:2897:1: rule__RParameters__Group_1__1__Impl : ( ( rule__RParameters__ParamsAssignment_1_1 ) ) ;
    public final void rule__RParameters__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2901:1: ( ( ( rule__RParameters__ParamsAssignment_1_1 ) ) )
            // InternalAle.g:2902:1: ( ( rule__RParameters__ParamsAssignment_1_1 ) )
            {
            // InternalAle.g:2902:1: ( ( rule__RParameters__ParamsAssignment_1_1 ) )
            // InternalAle.g:2903:2: ( rule__RParameters__ParamsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRParametersAccess().getParamsAssignment_1_1()); 
            }
            // InternalAle.g:2904:2: ( rule__RParameters__ParamsAssignment_1_1 )
            // InternalAle.g:2904:3: rule__RParameters__ParamsAssignment_1_1
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
    // InternalAle.g:2913:1: rule__RVariable__Group__0 : rule__RVariable__Group__0__Impl rule__RVariable__Group__1 ;
    public final void rule__RVariable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2917:1: ( rule__RVariable__Group__0__Impl rule__RVariable__Group__1 )
            // InternalAle.g:2918:2: rule__RVariable__Group__0__Impl rule__RVariable__Group__1
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
    // InternalAle.g:2925:1: rule__RVariable__Group__0__Impl : ( ( rule__RVariable__TypeAssignment_0 ) ) ;
    public final void rule__RVariable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2929:1: ( ( ( rule__RVariable__TypeAssignment_0 ) ) )
            // InternalAle.g:2930:1: ( ( rule__RVariable__TypeAssignment_0 ) )
            {
            // InternalAle.g:2930:1: ( ( rule__RVariable__TypeAssignment_0 ) )
            // InternalAle.g:2931:2: ( rule__RVariable__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getTypeAssignment_0()); 
            }
            // InternalAle.g:2932:2: ( rule__RVariable__TypeAssignment_0 )
            // InternalAle.g:2932:3: rule__RVariable__TypeAssignment_0
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
    // InternalAle.g:2940:1: rule__RVariable__Group__1 : rule__RVariable__Group__1__Impl ;
    public final void rule__RVariable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2944:1: ( rule__RVariable__Group__1__Impl )
            // InternalAle.g:2945:2: rule__RVariable__Group__1__Impl
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
    // InternalAle.g:2951:1: rule__RVariable__Group__1__Impl : ( ( rule__RVariable__NameAssignment_1 ) ) ;
    public final void rule__RVariable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2955:1: ( ( ( rule__RVariable__NameAssignment_1 ) ) )
            // InternalAle.g:2956:1: ( ( rule__RVariable__NameAssignment_1 ) )
            {
            // InternalAle.g:2956:1: ( ( rule__RVariable__NameAssignment_1 ) )
            // InternalAle.g:2957:2: ( rule__RVariable__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVariableAccess().getNameAssignment_1()); 
            }
            // InternalAle.g:2958:2: ( rule__RVariable__NameAssignment_1 )
            // InternalAle.g:2958:3: rule__RVariable__NameAssignment_1
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
    // InternalAle.g:2967:1: rule__RAttribute__Group__0 : rule__RAttribute__Group__0__Impl rule__RAttribute__Group__1 ;
    public final void rule__RAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2971:1: ( rule__RAttribute__Group__0__Impl rule__RAttribute__Group__1 )
            // InternalAle.g:2972:2: rule__RAttribute__Group__0__Impl rule__RAttribute__Group__1
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
    // InternalAle.g:2979:1: rule__RAttribute__Group__0__Impl : ( ( rule__RAttribute__TypeAssignment_0 ) ) ;
    public final void rule__RAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2983:1: ( ( ( rule__RAttribute__TypeAssignment_0 ) ) )
            // InternalAle.g:2984:1: ( ( rule__RAttribute__TypeAssignment_0 ) )
            {
            // InternalAle.g:2984:1: ( ( rule__RAttribute__TypeAssignment_0 ) )
            // InternalAle.g:2985:2: ( rule__RAttribute__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getTypeAssignment_0()); 
            }
            // InternalAle.g:2986:2: ( rule__RAttribute__TypeAssignment_0 )
            // InternalAle.g:2986:3: rule__RAttribute__TypeAssignment_0
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
    // InternalAle.g:2994:1: rule__RAttribute__Group__1 : rule__RAttribute__Group__1__Impl rule__RAttribute__Group__2 ;
    public final void rule__RAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:2998:1: ( rule__RAttribute__Group__1__Impl rule__RAttribute__Group__2 )
            // InternalAle.g:2999:2: rule__RAttribute__Group__1__Impl rule__RAttribute__Group__2
            {
            pushFollow(FOLLOW_25);
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
    // InternalAle.g:3006:1: rule__RAttribute__Group__1__Impl : ( ( rule__RAttribute__NameAssignment_1 ) ) ;
    public final void rule__RAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3010:1: ( ( ( rule__RAttribute__NameAssignment_1 ) ) )
            // InternalAle.g:3011:1: ( ( rule__RAttribute__NameAssignment_1 ) )
            {
            // InternalAle.g:3011:1: ( ( rule__RAttribute__NameAssignment_1 ) )
            // InternalAle.g:3012:2: ( rule__RAttribute__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getNameAssignment_1()); 
            }
            // InternalAle.g:3013:2: ( rule__RAttribute__NameAssignment_1 )
            // InternalAle.g:3013:3: rule__RAttribute__NameAssignment_1
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
    // InternalAle.g:3021:1: rule__RAttribute__Group__2 : rule__RAttribute__Group__2__Impl rule__RAttribute__Group__3 ;
    public final void rule__RAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3025:1: ( rule__RAttribute__Group__2__Impl rule__RAttribute__Group__3 )
            // InternalAle.g:3026:2: rule__RAttribute__Group__2__Impl rule__RAttribute__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalAle.g:3033:1: rule__RAttribute__Group__2__Impl : ( ( rule__RAttribute__Group_2__0 )? ) ;
    public final void rule__RAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3037:1: ( ( ( rule__RAttribute__Group_2__0 )? ) )
            // InternalAle.g:3038:1: ( ( rule__RAttribute__Group_2__0 )? )
            {
            // InternalAle.g:3038:1: ( ( rule__RAttribute__Group_2__0 )? )
            // InternalAle.g:3039:2: ( rule__RAttribute__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getGroup_2()); 
            }
            // InternalAle.g:3040:2: ( rule__RAttribute__Group_2__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==59) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAle.g:3040:3: rule__RAttribute__Group_2__0
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
    // InternalAle.g:3048:1: rule__RAttribute__Group__3 : rule__RAttribute__Group__3__Impl ;
    public final void rule__RAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3052:1: ( rule__RAttribute__Group__3__Impl )
            // InternalAle.g:3053:2: rule__RAttribute__Group__3__Impl
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
    // InternalAle.g:3059:1: rule__RAttribute__Group__3__Impl : ( ';' ) ;
    public final void rule__RAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3063:1: ( ( ';' ) )
            // InternalAle.g:3064:1: ( ';' )
            {
            // InternalAle.g:3064:1: ( ';' )
            // InternalAle.g:3065:2: ';'
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
    // InternalAle.g:3075:1: rule__RAttribute__Group_2__0 : rule__RAttribute__Group_2__0__Impl rule__RAttribute__Group_2__1 ;
    public final void rule__RAttribute__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3079:1: ( rule__RAttribute__Group_2__0__Impl rule__RAttribute__Group_2__1 )
            // InternalAle.g:3080:2: rule__RAttribute__Group_2__0__Impl rule__RAttribute__Group_2__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:3087:1: rule__RAttribute__Group_2__0__Impl : ( ':=' ) ;
    public final void rule__RAttribute__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3091:1: ( ( ':=' ) )
            // InternalAle.g:3092:1: ( ':=' )
            {
            // InternalAle.g:3092:1: ( ':=' )
            // InternalAle.g:3093:2: ':='
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
    // InternalAle.g:3102:1: rule__RAttribute__Group_2__1 : rule__RAttribute__Group_2__1__Impl ;
    public final void rule__RAttribute__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3106:1: ( rule__RAttribute__Group_2__1__Impl )
            // InternalAle.g:3107:2: rule__RAttribute__Group_2__1__Impl
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
    // InternalAle.g:3113:1: rule__RAttribute__Group_2__1__Impl : ( ruleexpression ) ;
    public final void rule__RAttribute__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3117:1: ( ( ruleexpression ) )
            // InternalAle.g:3118:1: ( ruleexpression )
            {
            // InternalAle.g:3118:1: ( ruleexpression )
            // InternalAle.g:3119:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAttributeAccess().getExpressionParserRuleCall_2_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAttributeAccess().getExpressionParserRuleCall_2_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__RVarDecl__Group__0"
    // InternalAle.g:3129:1: rule__RVarDecl__Group__0 : rule__RVarDecl__Group__0__Impl rule__RVarDecl__Group__1 ;
    public final void rule__RVarDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3133:1: ( rule__RVarDecl__Group__0__Impl rule__RVarDecl__Group__1 )
            // InternalAle.g:3134:2: rule__RVarDecl__Group__0__Impl rule__RVarDecl__Group__1
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
    // InternalAle.g:3141:1: rule__RVarDecl__Group__0__Impl : ( rulerType ) ;
    public final void rule__RVarDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3145:1: ( ( rulerType ) )
            // InternalAle.g:3146:1: ( rulerType )
            {
            // InternalAle.g:3146:1: ( rulerType )
            // InternalAle.g:3147:2: rulerType
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
    // InternalAle.g:3156:1: rule__RVarDecl__Group__1 : rule__RVarDecl__Group__1__Impl rule__RVarDecl__Group__2 ;
    public final void rule__RVarDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3160:1: ( rule__RVarDecl__Group__1__Impl rule__RVarDecl__Group__2 )
            // InternalAle.g:3161:2: rule__RVarDecl__Group__1__Impl rule__RVarDecl__Group__2
            {
            pushFollow(FOLLOW_25);
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
    // InternalAle.g:3168:1: rule__RVarDecl__Group__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RVarDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3172:1: ( ( RULE_IDENT ) )
            // InternalAle.g:3173:1: ( RULE_IDENT )
            {
            // InternalAle.g:3173:1: ( RULE_IDENT )
            // InternalAle.g:3174:2: RULE_IDENT
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
    // InternalAle.g:3183:1: rule__RVarDecl__Group__2 : rule__RVarDecl__Group__2__Impl rule__RVarDecl__Group__3 ;
    public final void rule__RVarDecl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3187:1: ( rule__RVarDecl__Group__2__Impl rule__RVarDecl__Group__3 )
            // InternalAle.g:3188:2: rule__RVarDecl__Group__2__Impl rule__RVarDecl__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalAle.g:3195:1: rule__RVarDecl__Group__2__Impl : ( ( rule__RVarDecl__Group_2__0 )? ) ;
    public final void rule__RVarDecl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3199:1: ( ( ( rule__RVarDecl__Group_2__0 )? ) )
            // InternalAle.g:3200:1: ( ( rule__RVarDecl__Group_2__0 )? )
            {
            // InternalAle.g:3200:1: ( ( rule__RVarDecl__Group_2__0 )? )
            // InternalAle.g:3201:2: ( rule__RVarDecl__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRVarDeclAccess().getGroup_2()); 
            }
            // InternalAle.g:3202:2: ( rule__RVarDecl__Group_2__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==59) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAle.g:3202:3: rule__RVarDecl__Group_2__0
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
    // InternalAle.g:3210:1: rule__RVarDecl__Group__3 : rule__RVarDecl__Group__3__Impl ;
    public final void rule__RVarDecl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3214:1: ( rule__RVarDecl__Group__3__Impl )
            // InternalAle.g:3215:2: rule__RVarDecl__Group__3__Impl
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
    // InternalAle.g:3221:1: rule__RVarDecl__Group__3__Impl : ( ';' ) ;
    public final void rule__RVarDecl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3225:1: ( ( ';' ) )
            // InternalAle.g:3226:1: ( ';' )
            {
            // InternalAle.g:3226:1: ( ';' )
            // InternalAle.g:3227:2: ';'
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
    // InternalAle.g:3237:1: rule__RVarDecl__Group_2__0 : rule__RVarDecl__Group_2__0__Impl rule__RVarDecl__Group_2__1 ;
    public final void rule__RVarDecl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3241:1: ( rule__RVarDecl__Group_2__0__Impl rule__RVarDecl__Group_2__1 )
            // InternalAle.g:3242:2: rule__RVarDecl__Group_2__0__Impl rule__RVarDecl__Group_2__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:3249:1: rule__RVarDecl__Group_2__0__Impl : ( ':=' ) ;
    public final void rule__RVarDecl__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3253:1: ( ( ':=' ) )
            // InternalAle.g:3254:1: ( ':=' )
            {
            // InternalAle.g:3254:1: ( ':=' )
            // InternalAle.g:3255:2: ':='
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
    // InternalAle.g:3264:1: rule__RVarDecl__Group_2__1 : rule__RVarDecl__Group_2__1__Impl ;
    public final void rule__RVarDecl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3268:1: ( rule__RVarDecl__Group_2__1__Impl )
            // InternalAle.g:3269:2: rule__RVarDecl__Group_2__1__Impl
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
    // InternalAle.g:3275:1: rule__RVarDecl__Group_2__1__Impl : ( ruleexpression ) ;
    public final void rule__RVarDecl__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3279:1: ( ( ruleexpression ) )
            // InternalAle.g:3280:1: ( ruleexpression )
            {
            // InternalAle.g:3280:1: ( ruleexpression )
            // InternalAle.g:3281:2: ruleexpression
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
    // InternalAle.g:3291:1: rule__RAssign__Group__0 : rule__RAssign__Group__0__Impl rule__RAssign__Group__1 ;
    public final void rule__RAssign__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3295:1: ( rule__RAssign__Group__0__Impl rule__RAssign__Group__1 )
            // InternalAle.g:3296:2: rule__RAssign__Group__0__Impl rule__RAssign__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalAle.g:3303:1: rule__RAssign__Group__0__Impl : ( ruleexpression ) ;
    public final void rule__RAssign__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3307:1: ( ( ruleexpression ) )
            // InternalAle.g:3308:1: ( ruleexpression )
            {
            // InternalAle.g:3308:1: ( ruleexpression )
            // InternalAle.g:3309:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignAccess().getExpressionParserRuleCall_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:3318:1: rule__RAssign__Group__1 : rule__RAssign__Group__1__Impl rule__RAssign__Group__2 ;
    public final void rule__RAssign__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3322:1: ( rule__RAssign__Group__1__Impl rule__RAssign__Group__2 )
            // InternalAle.g:3323:2: rule__RAssign__Group__1__Impl rule__RAssign__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:3330:1: rule__RAssign__Group__1__Impl : ( ':=' ) ;
    public final void rule__RAssign__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3334:1: ( ( ':=' ) )
            // InternalAle.g:3335:1: ( ':=' )
            {
            // InternalAle.g:3335:1: ( ':=' )
            // InternalAle.g:3336:2: ':='
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
    // InternalAle.g:3345:1: rule__RAssign__Group__2 : rule__RAssign__Group__2__Impl rule__RAssign__Group__3 ;
    public final void rule__RAssign__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3349:1: ( rule__RAssign__Group__2__Impl rule__RAssign__Group__3 )
            // InternalAle.g:3350:2: rule__RAssign__Group__2__Impl rule__RAssign__Group__3
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
    // InternalAle.g:3357:1: rule__RAssign__Group__2__Impl : ( ruleexpression ) ;
    public final void rule__RAssign__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3361:1: ( ( ruleexpression ) )
            // InternalAle.g:3362:1: ( ruleexpression )
            {
            // InternalAle.g:3362:1: ( ruleexpression )
            // InternalAle.g:3363:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRAssignAccess().getExpressionParserRuleCall_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRAssignAccess().getExpressionParserRuleCall_2()); 
            }

            }


            }

        }
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
    // InternalAle.g:3372:1: rule__RAssign__Group__3 : rule__RAssign__Group__3__Impl ;
    public final void rule__RAssign__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3376:1: ( rule__RAssign__Group__3__Impl )
            // InternalAle.g:3377:2: rule__RAssign__Group__3__Impl
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
    // InternalAle.g:3383:1: rule__RAssign__Group__3__Impl : ( ';' ) ;
    public final void rule__RAssign__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3387:1: ( ( ';' ) )
            // InternalAle.g:3388:1: ( ';' )
            {
            // InternalAle.g:3388:1: ( ';' )
            // InternalAle.g:3389:2: ';'
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
    // InternalAle.g:3399:1: rule__RForEach__Group__0 : rule__RForEach__Group__0__Impl rule__RForEach__Group__1 ;
    public final void rule__RForEach__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3403:1: ( rule__RForEach__Group__0__Impl rule__RForEach__Group__1 )
            // InternalAle.g:3404:2: rule__RForEach__Group__0__Impl rule__RForEach__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalAle.g:3411:1: rule__RForEach__Group__0__Impl : ( 'for' ) ;
    public final void rule__RForEach__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3415:1: ( ( 'for' ) )
            // InternalAle.g:3416:1: ( 'for' )
            {
            // InternalAle.g:3416:1: ( 'for' )
            // InternalAle.g:3417:2: 'for'
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
    // InternalAle.g:3426:1: rule__RForEach__Group__1 : rule__RForEach__Group__1__Impl rule__RForEach__Group__2 ;
    public final void rule__RForEach__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3430:1: ( rule__RForEach__Group__1__Impl rule__RForEach__Group__2 )
            // InternalAle.g:3431:2: rule__RForEach__Group__1__Impl rule__RForEach__Group__2
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
    // InternalAle.g:3438:1: rule__RForEach__Group__1__Impl : ( '(' ) ;
    public final void rule__RForEach__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3442:1: ( ( '(' ) )
            // InternalAle.g:3443:1: ( '(' )
            {
            // InternalAle.g:3443:1: ( '(' )
            // InternalAle.g:3444:2: '('
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
    // InternalAle.g:3453:1: rule__RForEach__Group__2 : rule__RForEach__Group__2__Impl rule__RForEach__Group__3 ;
    public final void rule__RForEach__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3457:1: ( rule__RForEach__Group__2__Impl rule__RForEach__Group__3 )
            // InternalAle.g:3458:2: rule__RForEach__Group__2__Impl rule__RForEach__Group__3
            {
            pushFollow(FOLLOW_28);
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
    // InternalAle.g:3465:1: rule__RForEach__Group__2__Impl : ( RULE_IDENT ) ;
    public final void rule__RForEach__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3469:1: ( ( RULE_IDENT ) )
            // InternalAle.g:3470:1: ( RULE_IDENT )
            {
            // InternalAle.g:3470:1: ( RULE_IDENT )
            // InternalAle.g:3471:2: RULE_IDENT
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
    // InternalAle.g:3480:1: rule__RForEach__Group__3 : rule__RForEach__Group__3__Impl rule__RForEach__Group__4 ;
    public final void rule__RForEach__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3484:1: ( rule__RForEach__Group__3__Impl rule__RForEach__Group__4 )
            // InternalAle.g:3485:2: rule__RForEach__Group__3__Impl rule__RForEach__Group__4
            {
            pushFollow(FOLLOW_29);
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
    // InternalAle.g:3492:1: rule__RForEach__Group__3__Impl : ( 'in' ) ;
    public final void rule__RForEach__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3496:1: ( ( 'in' ) )
            // InternalAle.g:3497:1: ( 'in' )
            {
            // InternalAle.g:3497:1: ( 'in' )
            // InternalAle.g:3498:2: 'in'
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
    // InternalAle.g:3507:1: rule__RForEach__Group__4 : rule__RForEach__Group__4__Impl rule__RForEach__Group__5 ;
    public final void rule__RForEach__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3511:1: ( rule__RForEach__Group__4__Impl rule__RForEach__Group__5 )
            // InternalAle.g:3512:2: rule__RForEach__Group__4__Impl rule__RForEach__Group__5
            {
            pushFollow(FOLLOW_30);
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
    // InternalAle.g:3519:1: rule__RForEach__Group__4__Impl : ( rulerCollection ) ;
    public final void rule__RForEach__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3523:1: ( ( rulerCollection ) )
            // InternalAle.g:3524:1: ( rulerCollection )
            {
            // InternalAle.g:3524:1: ( rulerCollection )
            // InternalAle.g:3525:2: rulerCollection
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
    // InternalAle.g:3534:1: rule__RForEach__Group__5 : rule__RForEach__Group__5__Impl rule__RForEach__Group__6 ;
    public final void rule__RForEach__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3538:1: ( rule__RForEach__Group__5__Impl rule__RForEach__Group__6 )
            // InternalAle.g:3539:2: rule__RForEach__Group__5__Impl rule__RForEach__Group__6
            {
            pushFollow(FOLLOW_19);
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
    // InternalAle.g:3546:1: rule__RForEach__Group__5__Impl : ( ')' ) ;
    public final void rule__RForEach__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3550:1: ( ( ')' ) )
            // InternalAle.g:3551:1: ( ')' )
            {
            // InternalAle.g:3551:1: ( ')' )
            // InternalAle.g:3552:2: ')'
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
    // InternalAle.g:3561:1: rule__RForEach__Group__6 : rule__RForEach__Group__6__Impl ;
    public final void rule__RForEach__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3565:1: ( rule__RForEach__Group__6__Impl )
            // InternalAle.g:3566:2: rule__RForEach__Group__6__Impl
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
    // InternalAle.g:3572:1: rule__RForEach__Group__6__Impl : ( rulerBlock ) ;
    public final void rule__RForEach__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3576:1: ( ( rulerBlock ) )
            // InternalAle.g:3577:1: ( rulerBlock )
            {
            // InternalAle.g:3577:1: ( rulerBlock )
            // InternalAle.g:3578:2: rulerBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRForEachAccess().getRBlockParserRuleCall_6()); 
            }
            pushFollow(FOLLOW_2);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRForEachAccess().getRBlockParserRuleCall_6()); 
            }

            }


            }

        }
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
    // InternalAle.g:3588:1: rule__RCollection__Group_0__0 : rule__RCollection__Group_0__0__Impl rule__RCollection__Group_0__1 ;
    public final void rule__RCollection__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3592:1: ( rule__RCollection__Group_0__0__Impl rule__RCollection__Group_0__1 )
            // InternalAle.g:3593:2: rule__RCollection__Group_0__0__Impl rule__RCollection__Group_0__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalAle.g:3600:1: rule__RCollection__Group_0__0__Impl : ( '[' ) ;
    public final void rule__RCollection__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3604:1: ( ( '[' ) )
            // InternalAle.g:3605:1: ( '[' )
            {
            // InternalAle.g:3605:1: ( '[' )
            // InternalAle.g:3606:2: '['
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
    // InternalAle.g:3615:1: rule__RCollection__Group_0__1 : rule__RCollection__Group_0__1__Impl rule__RCollection__Group_0__2 ;
    public final void rule__RCollection__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3619:1: ( rule__RCollection__Group_0__1__Impl rule__RCollection__Group_0__2 )
            // InternalAle.g:3620:2: rule__RCollection__Group_0__1__Impl rule__RCollection__Group_0__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalAle.g:3627:1: rule__RCollection__Group_0__1__Impl : ( RULE_INT ) ;
    public final void rule__RCollection__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3631:1: ( ( RULE_INT ) )
            // InternalAle.g:3632:1: ( RULE_INT )
            {
            // InternalAle.g:3632:1: ( RULE_INT )
            // InternalAle.g:3633:2: RULE_INT
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
    // InternalAle.g:3642:1: rule__RCollection__Group_0__2 : rule__RCollection__Group_0__2__Impl rule__RCollection__Group_0__3 ;
    public final void rule__RCollection__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3646:1: ( rule__RCollection__Group_0__2__Impl rule__RCollection__Group_0__3 )
            // InternalAle.g:3647:2: rule__RCollection__Group_0__2__Impl rule__RCollection__Group_0__3
            {
            pushFollow(FOLLOW_31);
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
    // InternalAle.g:3654:1: rule__RCollection__Group_0__2__Impl : ( '..' ) ;
    public final void rule__RCollection__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3658:1: ( ( '..' ) )
            // InternalAle.g:3659:1: ( '..' )
            {
            // InternalAle.g:3659:1: ( '..' )
            // InternalAle.g:3660:2: '..'
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
    // InternalAle.g:3669:1: rule__RCollection__Group_0__3 : rule__RCollection__Group_0__3__Impl rule__RCollection__Group_0__4 ;
    public final void rule__RCollection__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3673:1: ( rule__RCollection__Group_0__3__Impl rule__RCollection__Group_0__4 )
            // InternalAle.g:3674:2: rule__RCollection__Group_0__3__Impl rule__RCollection__Group_0__4
            {
            pushFollow(FOLLOW_33);
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
    // InternalAle.g:3681:1: rule__RCollection__Group_0__3__Impl : ( RULE_INT ) ;
    public final void rule__RCollection__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3685:1: ( ( RULE_INT ) )
            // InternalAle.g:3686:1: ( RULE_INT )
            {
            // InternalAle.g:3686:1: ( RULE_INT )
            // InternalAle.g:3687:2: RULE_INT
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
    // InternalAle.g:3696:1: rule__RCollection__Group_0__4 : rule__RCollection__Group_0__4__Impl ;
    public final void rule__RCollection__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3700:1: ( rule__RCollection__Group_0__4__Impl )
            // InternalAle.g:3701:2: rule__RCollection__Group_0__4__Impl
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
    // InternalAle.g:3707:1: rule__RCollection__Group_0__4__Impl : ( ']' ) ;
    public final void rule__RCollection__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3711:1: ( ( ']' ) )
            // InternalAle.g:3712:1: ( ']' )
            {
            // InternalAle.g:3712:1: ( ']' )
            // InternalAle.g:3713:2: ']'
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
    // InternalAle.g:3723:1: rule__RBlock__Group__0 : rule__RBlock__Group__0__Impl rule__RBlock__Group__1 ;
    public final void rule__RBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3727:1: ( rule__RBlock__Group__0__Impl rule__RBlock__Group__1 )
            // InternalAle.g:3728:2: rule__RBlock__Group__0__Impl rule__RBlock__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalAle.g:3735:1: rule__RBlock__Group__0__Impl : ( '{' ) ;
    public final void rule__RBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3739:1: ( ( '{' ) )
            // InternalAle.g:3740:1: ( '{' )
            {
            // InternalAle.g:3740:1: ( '{' )
            // InternalAle.g:3741:2: '{'
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
    // InternalAle.g:3750:1: rule__RBlock__Group__1 : rule__RBlock__Group__1__Impl rule__RBlock__Group__2 ;
    public final void rule__RBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3754:1: ( rule__RBlock__Group__1__Impl rule__RBlock__Group__2 )
            // InternalAle.g:3755:2: rule__RBlock__Group__1__Impl rule__RBlock__Group__2
            {
            pushFollow(FOLLOW_34);
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
    // InternalAle.g:3762:1: rule__RBlock__Group__1__Impl : ( ( rule__RBlock__Group_1__0 )? ) ;
    public final void rule__RBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3766:1: ( ( ( rule__RBlock__Group_1__0 )? ) )
            // InternalAle.g:3767:1: ( ( rule__RBlock__Group_1__0 )? )
            {
            // InternalAle.g:3767:1: ( ( rule__RBlock__Group_1__0 )? )
            // InternalAle.g:3768:2: ( rule__RBlock__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getGroup_1()); 
            }
            // InternalAle.g:3769:2: ( rule__RBlock__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_IDENT && LA32_0<=RULE_REAL)||LA32_0==18||(LA32_0>=37 && LA32_0<=43)||LA32_0==52||LA32_0==56||LA32_0==60||LA32_0==65||LA32_0==67||LA32_0==73||LA32_0==76||(LA32_0>=79 && LA32_0<=80)||(LA32_0>=82 && LA32_0<=83)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAle.g:3769:3: rule__RBlock__Group_1__0
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
    // InternalAle.g:3777:1: rule__RBlock__Group__2 : rule__RBlock__Group__2__Impl ;
    public final void rule__RBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3781:1: ( rule__RBlock__Group__2__Impl )
            // InternalAle.g:3782:2: rule__RBlock__Group__2__Impl
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
    // InternalAle.g:3788:1: rule__RBlock__Group__2__Impl : ( '}' ) ;
    public final void rule__RBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3792:1: ( ( '}' ) )
            // InternalAle.g:3793:1: ( '}' )
            {
            // InternalAle.g:3793:1: ( '}' )
            // InternalAle.g:3794:2: '}'
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
    // InternalAle.g:3804:1: rule__RBlock__Group_1__0 : rule__RBlock__Group_1__0__Impl rule__RBlock__Group_1__1 ;
    public final void rule__RBlock__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3808:1: ( rule__RBlock__Group_1__0__Impl rule__RBlock__Group_1__1 )
            // InternalAle.g:3809:2: rule__RBlock__Group_1__0__Impl rule__RBlock__Group_1__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalAle.g:3816:1: rule__RBlock__Group_1__0__Impl : ( rulerStatement ) ;
    public final void rule__RBlock__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3820:1: ( ( rulerStatement ) )
            // InternalAle.g:3821:1: ( rulerStatement )
            {
            // InternalAle.g:3821:1: ( rulerStatement )
            // InternalAle.g:3822:2: rulerStatement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getRStatementParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulerStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getRStatementParserRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:3831:1: rule__RBlock__Group_1__1 : rule__RBlock__Group_1__1__Impl ;
    public final void rule__RBlock__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3835:1: ( rule__RBlock__Group_1__1__Impl )
            // InternalAle.g:3836:2: rule__RBlock__Group_1__1__Impl
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
    // InternalAle.g:3842:1: rule__RBlock__Group_1__1__Impl : ( ( rulerStatement )* ) ;
    public final void rule__RBlock__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3846:1: ( ( ( rulerStatement )* ) )
            // InternalAle.g:3847:1: ( ( rulerStatement )* )
            {
            // InternalAle.g:3847:1: ( ( rulerStatement )* )
            // InternalAle.g:3848:2: ( rulerStatement )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRBlockAccess().getRStatementParserRuleCall_1_1()); 
            }
            // InternalAle.g:3849:2: ( rulerStatement )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=RULE_IDENT && LA33_0<=RULE_REAL)||LA33_0==18||(LA33_0>=37 && LA33_0<=43)||LA33_0==52||LA33_0==56||LA33_0==60||LA33_0==65||LA33_0==67||LA33_0==73||LA33_0==76||(LA33_0>=79 && LA33_0<=80)||(LA33_0>=82 && LA33_0<=83)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalAle.g:3849:3: rulerStatement
            	    {
            	    pushFollow(FOLLOW_36);
            	    rulerStatement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRBlockAccess().getRStatementParserRuleCall_1_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:3858:1: rule__RIf__Group__0 : rule__RIf__Group__0__Impl rule__RIf__Group__1 ;
    public final void rule__RIf__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3862:1: ( rule__RIf__Group__0__Impl rule__RIf__Group__1 )
            // InternalAle.g:3863:2: rule__RIf__Group__0__Impl rule__RIf__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalAle.g:3870:1: rule__RIf__Group__0__Impl : ( 'if' ) ;
    public final void rule__RIf__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3874:1: ( ( 'if' ) )
            // InternalAle.g:3875:1: ( 'if' )
            {
            // InternalAle.g:3875:1: ( 'if' )
            // InternalAle.g:3876:2: 'if'
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
    // InternalAle.g:3885:1: rule__RIf__Group__1 : rule__RIf__Group__1__Impl rule__RIf__Group__2 ;
    public final void rule__RIf__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3889:1: ( rule__RIf__Group__1__Impl rule__RIf__Group__2 )
            // InternalAle.g:3890:2: rule__RIf__Group__1__Impl rule__RIf__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:3897:1: rule__RIf__Group__1__Impl : ( '(' ) ;
    public final void rule__RIf__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3901:1: ( ( '(' ) )
            // InternalAle.g:3902:1: ( '(' )
            {
            // InternalAle.g:3902:1: ( '(' )
            // InternalAle.g:3903:2: '('
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
    // InternalAle.g:3912:1: rule__RIf__Group__2 : rule__RIf__Group__2__Impl rule__RIf__Group__3 ;
    public final void rule__RIf__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3916:1: ( rule__RIf__Group__2__Impl rule__RIf__Group__3 )
            // InternalAle.g:3917:2: rule__RIf__Group__2__Impl rule__RIf__Group__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalAle.g:3924:1: rule__RIf__Group__2__Impl : ( ruleexpression ) ;
    public final void rule__RIf__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3928:1: ( ( ruleexpression ) )
            // InternalAle.g:3929:1: ( ruleexpression )
            {
            // InternalAle.g:3929:1: ( ruleexpression )
            // InternalAle.g:3930:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getExpressionParserRuleCall_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getExpressionParserRuleCall_2()); 
            }

            }


            }

        }
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
    // InternalAle.g:3939:1: rule__RIf__Group__3 : rule__RIf__Group__3__Impl rule__RIf__Group__4 ;
    public final void rule__RIf__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3943:1: ( rule__RIf__Group__3__Impl rule__RIf__Group__4 )
            // InternalAle.g:3944:2: rule__RIf__Group__3__Impl rule__RIf__Group__4
            {
            pushFollow(FOLLOW_19);
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
    // InternalAle.g:3951:1: rule__RIf__Group__3__Impl : ( ')' ) ;
    public final void rule__RIf__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3955:1: ( ( ')' ) )
            // InternalAle.g:3956:1: ( ')' )
            {
            // InternalAle.g:3956:1: ( ')' )
            // InternalAle.g:3957:2: ')'
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
    // InternalAle.g:3966:1: rule__RIf__Group__4 : rule__RIf__Group__4__Impl rule__RIf__Group__5 ;
    public final void rule__RIf__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3970:1: ( rule__RIf__Group__4__Impl rule__RIf__Group__5 )
            // InternalAle.g:3971:2: rule__RIf__Group__4__Impl rule__RIf__Group__5
            {
            pushFollow(FOLLOW_37);
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
    // InternalAle.g:3978:1: rule__RIf__Group__4__Impl : ( rulerBlock ) ;
    public final void rule__RIf__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3982:1: ( ( rulerBlock ) )
            // InternalAle.g:3983:1: ( rulerBlock )
            {
            // InternalAle.g:3983:1: ( rulerBlock )
            // InternalAle.g:3984:2: rulerBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getRBlockParserRuleCall_4()); 
            }
            pushFollow(FOLLOW_2);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getRBlockParserRuleCall_4()); 
            }

            }


            }

        }
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
    // InternalAle.g:3993:1: rule__RIf__Group__5 : rule__RIf__Group__5__Impl ;
    public final void rule__RIf__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:3997:1: ( rule__RIf__Group__5__Impl )
            // InternalAle.g:3998:2: rule__RIf__Group__5__Impl
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
    // InternalAle.g:4004:1: rule__RIf__Group__5__Impl : ( ( rule__RIf__Group_5__0 )? ) ;
    public final void rule__RIf__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4008:1: ( ( ( rule__RIf__Group_5__0 )? ) )
            // InternalAle.g:4009:1: ( ( rule__RIf__Group_5__0 )? )
            {
            // InternalAle.g:4009:1: ( ( rule__RIf__Group_5__0 )? )
            // InternalAle.g:4010:2: ( rule__RIf__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getGroup_5()); 
            }
            // InternalAle.g:4011:2: ( rule__RIf__Group_5__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==66) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAle.g:4011:3: rule__RIf__Group_5__0
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
    // InternalAle.g:4020:1: rule__RIf__Group_5__0 : rule__RIf__Group_5__0__Impl rule__RIf__Group_5__1 ;
    public final void rule__RIf__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4024:1: ( rule__RIf__Group_5__0__Impl rule__RIf__Group_5__1 )
            // InternalAle.g:4025:2: rule__RIf__Group_5__0__Impl rule__RIf__Group_5__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalAle.g:4032:1: rule__RIf__Group_5__0__Impl : ( 'else' ) ;
    public final void rule__RIf__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4036:1: ( ( 'else' ) )
            // InternalAle.g:4037:1: ( 'else' )
            {
            // InternalAle.g:4037:1: ( 'else' )
            // InternalAle.g:4038:2: 'else'
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
    // InternalAle.g:4047:1: rule__RIf__Group_5__1 : rule__RIf__Group_5__1__Impl ;
    public final void rule__RIf__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4051:1: ( rule__RIf__Group_5__1__Impl )
            // InternalAle.g:4052:2: rule__RIf__Group_5__1__Impl
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
    // InternalAle.g:4058:1: rule__RIf__Group_5__1__Impl : ( rulerBlock ) ;
    public final void rule__RIf__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4062:1: ( ( rulerBlock ) )
            // InternalAle.g:4063:1: ( rulerBlock )
            {
            // InternalAle.g:4063:1: ( rulerBlock )
            // InternalAle.g:4064:2: rulerBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRIfAccess().getRBlockParserRuleCall_5_1()); 
            }
            pushFollow(FOLLOW_2);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRIfAccess().getRBlockParserRuleCall_5_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:4074:1: rule__RWhile__Group__0 : rule__RWhile__Group__0__Impl rule__RWhile__Group__1 ;
    public final void rule__RWhile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4078:1: ( rule__RWhile__Group__0__Impl rule__RWhile__Group__1 )
            // InternalAle.g:4079:2: rule__RWhile__Group__0__Impl rule__RWhile__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalAle.g:4086:1: rule__RWhile__Group__0__Impl : ( 'while' ) ;
    public final void rule__RWhile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4090:1: ( ( 'while' ) )
            // InternalAle.g:4091:1: ( 'while' )
            {
            // InternalAle.g:4091:1: ( 'while' )
            // InternalAle.g:4092:2: 'while'
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
    // InternalAle.g:4101:1: rule__RWhile__Group__1 : rule__RWhile__Group__1__Impl rule__RWhile__Group__2 ;
    public final void rule__RWhile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4105:1: ( rule__RWhile__Group__1__Impl rule__RWhile__Group__2 )
            // InternalAle.g:4106:2: rule__RWhile__Group__1__Impl rule__RWhile__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4113:1: rule__RWhile__Group__1__Impl : ( '(' ) ;
    public final void rule__RWhile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4117:1: ( ( '(' ) )
            // InternalAle.g:4118:1: ( '(' )
            {
            // InternalAle.g:4118:1: ( '(' )
            // InternalAle.g:4119:2: '('
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
    // InternalAle.g:4128:1: rule__RWhile__Group__2 : rule__RWhile__Group__2__Impl rule__RWhile__Group__3 ;
    public final void rule__RWhile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4132:1: ( rule__RWhile__Group__2__Impl rule__RWhile__Group__3 )
            // InternalAle.g:4133:2: rule__RWhile__Group__2__Impl rule__RWhile__Group__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalAle.g:4140:1: rule__RWhile__Group__2__Impl : ( ruleexpression ) ;
    public final void rule__RWhile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4144:1: ( ( ruleexpression ) )
            // InternalAle.g:4145:1: ( ruleexpression )
            {
            // InternalAle.g:4145:1: ( ruleexpression )
            // InternalAle.g:4146:2: ruleexpression
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
    // InternalAle.g:4155:1: rule__RWhile__Group__3 : rule__RWhile__Group__3__Impl rule__RWhile__Group__4 ;
    public final void rule__RWhile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4159:1: ( rule__RWhile__Group__3__Impl rule__RWhile__Group__4 )
            // InternalAle.g:4160:2: rule__RWhile__Group__3__Impl rule__RWhile__Group__4
            {
            pushFollow(FOLLOW_19);
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
    // InternalAle.g:4167:1: rule__RWhile__Group__3__Impl : ( ')' ) ;
    public final void rule__RWhile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4171:1: ( ( ')' ) )
            // InternalAle.g:4172:1: ( ')' )
            {
            // InternalAle.g:4172:1: ( ')' )
            // InternalAle.g:4173:2: ')'
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
    // InternalAle.g:4182:1: rule__RWhile__Group__4 : rule__RWhile__Group__4__Impl ;
    public final void rule__RWhile__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4186:1: ( rule__RWhile__Group__4__Impl )
            // InternalAle.g:4187:2: rule__RWhile__Group__4__Impl
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
    // InternalAle.g:4193:1: rule__RWhile__Group__4__Impl : ( rulerBlock ) ;
    public final void rule__RWhile__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4197:1: ( ( rulerBlock ) )
            // InternalAle.g:4198:1: ( rulerBlock )
            {
            // InternalAle.g:4198:1: ( rulerBlock )
            // InternalAle.g:4199:2: rulerBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRWhileAccess().getRBlockParserRuleCall_4()); 
            }
            pushFollow(FOLLOW_2);
            rulerBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRWhileAccess().getRBlockParserRuleCall_4()); 
            }

            }


            }

        }
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
    // InternalAle.g:4209:1: rule__RExpression__Group__0 : rule__RExpression__Group__0__Impl rule__RExpression__Group__1 ;
    public final void rule__RExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4213:1: ( rule__RExpression__Group__0__Impl rule__RExpression__Group__1 )
            // InternalAle.g:4214:2: rule__RExpression__Group__0__Impl rule__RExpression__Group__1
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
    // InternalAle.g:4221:1: rule__RExpression__Group__0__Impl : ( ruleexpression ) ;
    public final void rule__RExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4225:1: ( ( ruleexpression ) )
            // InternalAle.g:4226:1: ( ruleexpression )
            {
            // InternalAle.g:4226:1: ( ruleexpression )
            // InternalAle.g:4227:2: ruleexpression
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
    // InternalAle.g:4236:1: rule__RExpression__Group__1 : rule__RExpression__Group__1__Impl ;
    public final void rule__RExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4240:1: ( rule__RExpression__Group__1__Impl )
            // InternalAle.g:4241:2: rule__RExpression__Group__1__Impl
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
    // InternalAle.g:4247:1: rule__RExpression__Group__1__Impl : ( ';' ) ;
    public final void rule__RExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4251:1: ( ( ';' ) )
            // InternalAle.g:4252:1: ( ';' )
            {
            // InternalAle.g:4252:1: ( ';' )
            // InternalAle.g:4253:2: ';'
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
    // InternalAle.g:4263:1: rule__Expression__Group__0 : rule__Expression__Group__0__Impl rule__Expression__Group__1 ;
    public final void rule__Expression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4267:1: ( rule__Expression__Group__0__Impl rule__Expression__Group__1 )
            // InternalAle.g:4268:2: rule__Expression__Group__0__Impl rule__Expression__Group__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalAle.g:4275:1: rule__Expression__Group__0__Impl : ( rulenonLeftRecExpression ) ;
    public final void rule__Expression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4279:1: ( ( rulenonLeftRecExpression ) )
            // InternalAle.g:4280:1: ( rulenonLeftRecExpression )
            {
            // InternalAle.g:4280:1: ( rulenonLeftRecExpression )
            // InternalAle.g:4281:2: rulenonLeftRecExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getNonLeftRecExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulenonLeftRecExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getNonLeftRecExpressionParserRuleCall_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:4290:1: rule__Expression__Group__1 : rule__Expression__Group__1__Impl ;
    public final void rule__Expression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4294:1: ( rule__Expression__Group__1__Impl )
            // InternalAle.g:4295:2: rule__Expression__Group__1__Impl
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
    // InternalAle.g:4301:1: rule__Expression__Group__1__Impl : ( ( rulerecExpression )? ) ;
    public final void rule__Expression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4305:1: ( ( ( rulerecExpression )? ) )
            // InternalAle.g:4306:1: ( ( rulerecExpression )? )
            {
            // InternalAle.g:4306:1: ( ( rulerecExpression )? )
            // InternalAle.g:4307:2: ( rulerecExpression )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getRecExpressionParserRuleCall_1()); 
            }
            // InternalAle.g:4308:2: ( rulerecExpression )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalAle.g:4308:3: rulerecExpression
                    {
                    pushFollow(FOLLOW_2);
                    rulerecExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getRecExpressionParserRuleCall_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:4317:1: rule__RecExpression__Group__0 : rule__RecExpression__Group__0__Impl rule__RecExpression__Group__1 ;
    public final void rule__RecExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4321:1: ( rule__RecExpression__Group__0__Impl rule__RecExpression__Group__1 )
            // InternalAle.g:4322:2: rule__RecExpression__Group__0__Impl rule__RecExpression__Group__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalAle.g:4329:1: rule__RecExpression__Group__0__Impl : ( ( rule__RecExpression__Alternatives_0 ) ) ;
    public final void rule__RecExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4333:1: ( ( ( rule__RecExpression__Alternatives_0 ) ) )
            // InternalAle.g:4334:1: ( ( rule__RecExpression__Alternatives_0 ) )
            {
            // InternalAle.g:4334:1: ( ( rule__RecExpression__Alternatives_0 ) )
            // InternalAle.g:4335:2: ( rule__RecExpression__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getAlternatives_0()); 
            }
            // InternalAle.g:4336:2: ( rule__RecExpression__Alternatives_0 )
            // InternalAle.g:4336:3: rule__RecExpression__Alternatives_0
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
    // InternalAle.g:4344:1: rule__RecExpression__Group__1 : rule__RecExpression__Group__1__Impl ;
    public final void rule__RecExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4348:1: ( rule__RecExpression__Group__1__Impl )
            // InternalAle.g:4349:2: rule__RecExpression__Group__1__Impl
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
    // InternalAle.g:4355:1: rule__RecExpression__Group__1__Impl : ( ( rulerecExpression )? ) ;
    public final void rule__RecExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4359:1: ( ( ( rulerecExpression )? ) )
            // InternalAle.g:4360:1: ( ( rulerecExpression )? )
            {
            // InternalAle.g:4360:1: ( ( rulerecExpression )? )
            // InternalAle.g:4361:2: ( rulerecExpression )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRecExpressionAccess().getRecExpressionParserRuleCall_1()); 
            }
            // InternalAle.g:4362:2: ( rulerecExpression )?
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalAle.g:4362:3: rulerecExpression
                    {
                    pushFollow(FOLLOW_2);
                    rulerecExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRecExpressionAccess().getRecExpressionParserRuleCall_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:4371:1: rule__RecExpression__Group_0_1__0 : rule__RecExpression__Group_0_1__0__Impl rule__RecExpression__Group_0_1__1 ;
    public final void rule__RecExpression__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4375:1: ( rule__RecExpression__Group_0_1__0__Impl rule__RecExpression__Group_0_1__1 )
            // InternalAle.g:4376:2: rule__RecExpression__Group_0_1__0__Impl rule__RecExpression__Group_0_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4383:1: rule__RecExpression__Group_0_1__0__Impl : ( RULE_MULTOP ) ;
    public final void rule__RecExpression__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4387:1: ( ( RULE_MULTOP ) )
            // InternalAle.g:4388:1: ( RULE_MULTOP )
            {
            // InternalAle.g:4388:1: ( RULE_MULTOP )
            // InternalAle.g:4389:2: RULE_MULTOP
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
    // InternalAle.g:4398:1: rule__RecExpression__Group_0_1__1 : rule__RecExpression__Group_0_1__1__Impl ;
    public final void rule__RecExpression__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4402:1: ( rule__RecExpression__Group_0_1__1__Impl )
            // InternalAle.g:4403:2: rule__RecExpression__Group_0_1__1__Impl
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
    // InternalAle.g:4409:1: rule__RecExpression__Group_0_1__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4413:1: ( ( ruleexpression ) )
            // InternalAle.g:4414:1: ( ruleexpression )
            {
            // InternalAle.g:4414:1: ( ruleexpression )
            // InternalAle.g:4415:2: ruleexpression
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
    // InternalAle.g:4425:1: rule__RecExpression__Group_0_2__0 : rule__RecExpression__Group_0_2__0__Impl rule__RecExpression__Group_0_2__1 ;
    public final void rule__RecExpression__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4429:1: ( rule__RecExpression__Group_0_2__0__Impl rule__RecExpression__Group_0_2__1 )
            // InternalAle.g:4430:2: rule__RecExpression__Group_0_2__0__Impl rule__RecExpression__Group_0_2__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4437:1: rule__RecExpression__Group_0_2__0__Impl : ( ruleaddOp ) ;
    public final void rule__RecExpression__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4441:1: ( ( ruleaddOp ) )
            // InternalAle.g:4442:1: ( ruleaddOp )
            {
            // InternalAle.g:4442:1: ( ruleaddOp )
            // InternalAle.g:4443:2: ruleaddOp
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
    // InternalAle.g:4452:1: rule__RecExpression__Group_0_2__1 : rule__RecExpression__Group_0_2__1__Impl ;
    public final void rule__RecExpression__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4456:1: ( rule__RecExpression__Group_0_2__1__Impl )
            // InternalAle.g:4457:2: rule__RecExpression__Group_0_2__1__Impl
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
    // InternalAle.g:4463:1: rule__RecExpression__Group_0_2__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4467:1: ( ( ruleexpression ) )
            // InternalAle.g:4468:1: ( ruleexpression )
            {
            // InternalAle.g:4468:1: ( ruleexpression )
            // InternalAle.g:4469:2: ruleexpression
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
    // InternalAle.g:4479:1: rule__RecExpression__Group_0_3__0 : rule__RecExpression__Group_0_3__0__Impl rule__RecExpression__Group_0_3__1 ;
    public final void rule__RecExpression__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4483:1: ( rule__RecExpression__Group_0_3__0__Impl rule__RecExpression__Group_0_3__1 )
            // InternalAle.g:4484:2: rule__RecExpression__Group_0_3__0__Impl rule__RecExpression__Group_0_3__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4491:1: rule__RecExpression__Group_0_3__0__Impl : ( rulecompOp ) ;
    public final void rule__RecExpression__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4495:1: ( ( rulecompOp ) )
            // InternalAle.g:4496:1: ( rulecompOp )
            {
            // InternalAle.g:4496:1: ( rulecompOp )
            // InternalAle.g:4497:2: rulecompOp
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
    // InternalAle.g:4506:1: rule__RecExpression__Group_0_3__1 : rule__RecExpression__Group_0_3__1__Impl ;
    public final void rule__RecExpression__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4510:1: ( rule__RecExpression__Group_0_3__1__Impl )
            // InternalAle.g:4511:2: rule__RecExpression__Group_0_3__1__Impl
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
    // InternalAle.g:4517:1: rule__RecExpression__Group_0_3__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4521:1: ( ( ruleexpression ) )
            // InternalAle.g:4522:1: ( ruleexpression )
            {
            // InternalAle.g:4522:1: ( ruleexpression )
            // InternalAle.g:4523:2: ruleexpression
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
    // InternalAle.g:4533:1: rule__RecExpression__Group_0_4__0 : rule__RecExpression__Group_0_4__0__Impl rule__RecExpression__Group_0_4__1 ;
    public final void rule__RecExpression__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4537:1: ( rule__RecExpression__Group_0_4__0__Impl rule__RecExpression__Group_0_4__1 )
            // InternalAle.g:4538:2: rule__RecExpression__Group_0_4__0__Impl rule__RecExpression__Group_0_4__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4545:1: rule__RecExpression__Group_0_4__0__Impl : ( 'and' ) ;
    public final void rule__RecExpression__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4549:1: ( ( 'and' ) )
            // InternalAle.g:4550:1: ( 'and' )
            {
            // InternalAle.g:4550:1: ( 'and' )
            // InternalAle.g:4551:2: 'and'
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
    // InternalAle.g:4560:1: rule__RecExpression__Group_0_4__1 : rule__RecExpression__Group_0_4__1__Impl ;
    public final void rule__RecExpression__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4564:1: ( rule__RecExpression__Group_0_4__1__Impl )
            // InternalAle.g:4565:2: rule__RecExpression__Group_0_4__1__Impl
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
    // InternalAle.g:4571:1: rule__RecExpression__Group_0_4__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4575:1: ( ( ruleexpression ) )
            // InternalAle.g:4576:1: ( ruleexpression )
            {
            // InternalAle.g:4576:1: ( ruleexpression )
            // InternalAle.g:4577:2: ruleexpression
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
    // InternalAle.g:4587:1: rule__RecExpression__Group_0_5__0 : rule__RecExpression__Group_0_5__0__Impl rule__RecExpression__Group_0_5__1 ;
    public final void rule__RecExpression__Group_0_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4591:1: ( rule__RecExpression__Group_0_5__0__Impl rule__RecExpression__Group_0_5__1 )
            // InternalAle.g:4592:2: rule__RecExpression__Group_0_5__0__Impl rule__RecExpression__Group_0_5__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4599:1: rule__RecExpression__Group_0_5__0__Impl : ( 'or' ) ;
    public final void rule__RecExpression__Group_0_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4603:1: ( ( 'or' ) )
            // InternalAle.g:4604:1: ( 'or' )
            {
            // InternalAle.g:4604:1: ( 'or' )
            // InternalAle.g:4605:2: 'or'
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
    // InternalAle.g:4614:1: rule__RecExpression__Group_0_5__1 : rule__RecExpression__Group_0_5__1__Impl ;
    public final void rule__RecExpression__Group_0_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4618:1: ( rule__RecExpression__Group_0_5__1__Impl )
            // InternalAle.g:4619:2: rule__RecExpression__Group_0_5__1__Impl
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
    // InternalAle.g:4625:1: rule__RecExpression__Group_0_5__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4629:1: ( ( ruleexpression ) )
            // InternalAle.g:4630:1: ( ruleexpression )
            {
            // InternalAle.g:4630:1: ( ruleexpression )
            // InternalAle.g:4631:2: ruleexpression
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
    // InternalAle.g:4641:1: rule__RecExpression__Group_0_6__0 : rule__RecExpression__Group_0_6__0__Impl rule__RecExpression__Group_0_6__1 ;
    public final void rule__RecExpression__Group_0_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4645:1: ( rule__RecExpression__Group_0_6__0__Impl rule__RecExpression__Group_0_6__1 )
            // InternalAle.g:4646:2: rule__RecExpression__Group_0_6__0__Impl rule__RecExpression__Group_0_6__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4653:1: rule__RecExpression__Group_0_6__0__Impl : ( 'xor' ) ;
    public final void rule__RecExpression__Group_0_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4657:1: ( ( 'xor' ) )
            // InternalAle.g:4658:1: ( 'xor' )
            {
            // InternalAle.g:4658:1: ( 'xor' )
            // InternalAle.g:4659:2: 'xor'
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
    // InternalAle.g:4668:1: rule__RecExpression__Group_0_6__1 : rule__RecExpression__Group_0_6__1__Impl ;
    public final void rule__RecExpression__Group_0_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4672:1: ( rule__RecExpression__Group_0_6__1__Impl )
            // InternalAle.g:4673:2: rule__RecExpression__Group_0_6__1__Impl
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
    // InternalAle.g:4679:1: rule__RecExpression__Group_0_6__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4683:1: ( ( ruleexpression ) )
            // InternalAle.g:4684:1: ( ruleexpression )
            {
            // InternalAle.g:4684:1: ( ruleexpression )
            // InternalAle.g:4685:2: ruleexpression
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
    // InternalAle.g:4695:1: rule__RecExpression__Group_0_7__0 : rule__RecExpression__Group_0_7__0__Impl rule__RecExpression__Group_0_7__1 ;
    public final void rule__RecExpression__Group_0_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4699:1: ( rule__RecExpression__Group_0_7__0__Impl rule__RecExpression__Group_0_7__1 )
            // InternalAle.g:4700:2: rule__RecExpression__Group_0_7__0__Impl rule__RecExpression__Group_0_7__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4707:1: rule__RecExpression__Group_0_7__0__Impl : ( 'implies' ) ;
    public final void rule__RecExpression__Group_0_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4711:1: ( ( 'implies' ) )
            // InternalAle.g:4712:1: ( 'implies' )
            {
            // InternalAle.g:4712:1: ( 'implies' )
            // InternalAle.g:4713:2: 'implies'
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
    // InternalAle.g:4722:1: rule__RecExpression__Group_0_7__1 : rule__RecExpression__Group_0_7__1__Impl ;
    public final void rule__RecExpression__Group_0_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4726:1: ( rule__RecExpression__Group_0_7__1__Impl )
            // InternalAle.g:4727:2: rule__RecExpression__Group_0_7__1__Impl
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
    // InternalAle.g:4733:1: rule__RecExpression__Group_0_7__1__Impl : ( ruleexpression ) ;
    public final void rule__RecExpression__Group_0_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4737:1: ( ( ruleexpression ) )
            // InternalAle.g:4738:1: ( ruleexpression )
            {
            // InternalAle.g:4738:1: ( ruleexpression )
            // InternalAle.g:4739:2: ruleexpression
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
    // InternalAle.g:4749:1: rule__NavigationSegment__Group_0__0 : rule__NavigationSegment__Group_0__0__Impl rule__NavigationSegment__Group_0__1 ;
    public final void rule__NavigationSegment__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4753:1: ( rule__NavigationSegment__Group_0__0__Impl rule__NavigationSegment__Group_0__1 )
            // InternalAle.g:4754:2: rule__NavigationSegment__Group_0__0__Impl rule__NavigationSegment__Group_0__1
            {
            pushFollow(FOLLOW_3);
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
    // InternalAle.g:4761:1: rule__NavigationSegment__Group_0__0__Impl : ( '.' ) ;
    public final void rule__NavigationSegment__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4765:1: ( ( '.' ) )
            // InternalAle.g:4766:1: ( '.' )
            {
            // InternalAle.g:4766:1: ( '.' )
            // InternalAle.g:4767:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_0_0()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_0__0__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_0__1"
    // InternalAle.g:4776:1: rule__NavigationSegment__Group_0__1 : rule__NavigationSegment__Group_0__1__Impl ;
    public final void rule__NavigationSegment__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4780:1: ( rule__NavigationSegment__Group_0__1__Impl )
            // InternalAle.g:4781:2: rule__NavigationSegment__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalAle.g:4787:1: rule__NavigationSegment__Group_0__1__Impl : ( RULE_IDENT ) ;
    public final void rule__NavigationSegment__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4791:1: ( ( RULE_IDENT ) )
            // InternalAle.g:4792:1: ( RULE_IDENT )
            {
            // InternalAle.g:4792:1: ( RULE_IDENT )
            // InternalAle.g:4793:2: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getIdentTerminalRuleCall_0_1()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getIdentTerminalRuleCall_0_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__NavigationSegment__Group_1__0"
    // InternalAle.g:4803:1: rule__NavigationSegment__Group_1__0 : rule__NavigationSegment__Group_1__0__Impl rule__NavigationSegment__Group_1__1 ;
    public final void rule__NavigationSegment__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4807:1: ( rule__NavigationSegment__Group_1__0__Impl rule__NavigationSegment__Group_1__1 )
            // InternalAle.g:4808:2: rule__NavigationSegment__Group_1__0__Impl rule__NavigationSegment__Group_1__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalAle.g:4815:1: rule__NavigationSegment__Group_1__0__Impl : ( '.' ) ;
    public final void rule__NavigationSegment__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4819:1: ( ( '.' ) )
            // InternalAle.g:4820:1: ( '.' )
            {
            // InternalAle.g:4820:1: ( '.' )
            // InternalAle.g:4821:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_1_0()); 
            }
            match(input,49,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_1__0__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_1__1"
    // InternalAle.g:4830:1: rule__NavigationSegment__Group_1__1 : rule__NavigationSegment__Group_1__1__Impl ;
    public final void rule__NavigationSegment__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4834:1: ( rule__NavigationSegment__Group_1__1__Impl )
            // InternalAle.g:4835:2: rule__NavigationSegment__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalAle.g:4841:1: rule__NavigationSegment__Group_1__1__Impl : ( rulecallExp ) ;
    public final void rule__NavigationSegment__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4845:1: ( ( rulecallExp ) )
            // InternalAle.g:4846:1: ( rulecallExp )
            {
            // InternalAle.g:4846:1: ( rulecallExp )
            // InternalAle.g:4847:2: rulecallExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getCallExpParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_2);
            rulecallExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getCallExpParserRuleCall_1_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__NavigationSegment__Group_2__0"
    // InternalAle.g:4857:1: rule__NavigationSegment__Group_2__0 : rule__NavigationSegment__Group_2__0__Impl rule__NavigationSegment__Group_2__1 ;
    public final void rule__NavigationSegment__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4861:1: ( rule__NavigationSegment__Group_2__0__Impl rule__NavigationSegment__Group_2__1 )
            // InternalAle.g:4862:2: rule__NavigationSegment__Group_2__0__Impl rule__NavigationSegment__Group_2__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalAle.g:4869:1: rule__NavigationSegment__Group_2__0__Impl : ( '->' ) ;
    public final void rule__NavigationSegment__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4873:1: ( ( '->' ) )
            // InternalAle.g:4874:1: ( '->' )
            {
            // InternalAle.g:4874:1: ( '->' )
            // InternalAle.g:4875:2: '->'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getHyphenMinusGreaterThanSignKeyword_2_0()); 
            }
            match(input,72,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getHyphenMinusGreaterThanSignKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationSegment__Group_2__0__Impl"


    // $ANTLR start "rule__NavigationSegment__Group_2__1"
    // InternalAle.g:4884:1: rule__NavigationSegment__Group_2__1 : rule__NavigationSegment__Group_2__1__Impl ;
    public final void rule__NavigationSegment__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4888:1: ( rule__NavigationSegment__Group_2__1__Impl )
            // InternalAle.g:4889:2: rule__NavigationSegment__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavigationSegment__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalAle.g:4895:1: rule__NavigationSegment__Group_2__1__Impl : ( rulecallExp ) ;
    public final void rule__NavigationSegment__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4899:1: ( ( rulecallExp ) )
            // InternalAle.g:4900:1: ( rulecallExp )
            {
            // InternalAle.g:4900:1: ( rulecallExp )
            // InternalAle.g:4901:2: rulecallExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationSegmentAccess().getCallExpParserRuleCall_2_1()); 
            }
            pushFollow(FOLLOW_2);
            rulecallExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationSegmentAccess().getCallExpParserRuleCall_2_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__NonLeftRecExpression__Group_0__0"
    // InternalAle.g:4911:1: rule__NonLeftRecExpression__Group_0__0 : rule__NonLeftRecExpression__Group_0__0__Impl rule__NonLeftRecExpression__Group_0__1 ;
    public final void rule__NonLeftRecExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4915:1: ( rule__NonLeftRecExpression__Group_0__0__Impl rule__NonLeftRecExpression__Group_0__1 )
            // InternalAle.g:4916:2: rule__NonLeftRecExpression__Group_0__0__Impl rule__NonLeftRecExpression__Group_0__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4923:1: rule__NonLeftRecExpression__Group_0__0__Impl : ( 'not' ) ;
    public final void rule__NonLeftRecExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4927:1: ( ( 'not' ) )
            // InternalAle.g:4928:1: ( 'not' )
            {
            // InternalAle.g:4928:1: ( 'not' )
            // InternalAle.g:4929:2: 'not'
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
    // InternalAle.g:4938:1: rule__NonLeftRecExpression__Group_0__1 : rule__NonLeftRecExpression__Group_0__1__Impl ;
    public final void rule__NonLeftRecExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4942:1: ( rule__NonLeftRecExpression__Group_0__1__Impl )
            // InternalAle.g:4943:2: rule__NonLeftRecExpression__Group_0__1__Impl
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
    // InternalAle.g:4949:1: rule__NonLeftRecExpression__Group_0__1__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4953:1: ( ( ruleexpression ) )
            // InternalAle.g:4954:1: ( ruleexpression )
            {
            // InternalAle.g:4954:1: ( ruleexpression )
            // InternalAle.g:4955:2: ruleexpression
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
    // InternalAle.g:4965:1: rule__NonLeftRecExpression__Group_1__0 : rule__NonLeftRecExpression__Group_1__0__Impl rule__NonLeftRecExpression__Group_1__1 ;
    public final void rule__NonLeftRecExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4969:1: ( rule__NonLeftRecExpression__Group_1__0__Impl rule__NonLeftRecExpression__Group_1__1 )
            // InternalAle.g:4970:2: rule__NonLeftRecExpression__Group_1__0__Impl rule__NonLeftRecExpression__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:4977:1: rule__NonLeftRecExpression__Group_1__0__Impl : ( '-' ) ;
    public final void rule__NonLeftRecExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4981:1: ( ( '-' ) )
            // InternalAle.g:4982:1: ( '-' )
            {
            // InternalAle.g:4982:1: ( '-' )
            // InternalAle.g:4983:2: '-'
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
    // InternalAle.g:4992:1: rule__NonLeftRecExpression__Group_1__1 : rule__NonLeftRecExpression__Group_1__1__Impl ;
    public final void rule__NonLeftRecExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:4996:1: ( rule__NonLeftRecExpression__Group_1__1__Impl )
            // InternalAle.g:4997:2: rule__NonLeftRecExpression__Group_1__1__Impl
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
    // InternalAle.g:5003:1: rule__NonLeftRecExpression__Group_1__1__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5007:1: ( ( ruleexpression ) )
            // InternalAle.g:5008:1: ( ruleexpression )
            {
            // InternalAle.g:5008:1: ( ruleexpression )
            // InternalAle.g:5009:2: ruleexpression
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
    // InternalAle.g:5019:1: rule__NonLeftRecExpression__Group_4__0 : rule__NonLeftRecExpression__Group_4__0__Impl rule__NonLeftRecExpression__Group_4__1 ;
    public final void rule__NonLeftRecExpression__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5023:1: ( rule__NonLeftRecExpression__Group_4__0__Impl rule__NonLeftRecExpression__Group_4__1 )
            // InternalAle.g:5024:2: rule__NonLeftRecExpression__Group_4__0__Impl rule__NonLeftRecExpression__Group_4__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:5031:1: rule__NonLeftRecExpression__Group_4__0__Impl : ( '(' ) ;
    public final void rule__NonLeftRecExpression__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5035:1: ( ( '(' ) )
            // InternalAle.g:5036:1: ( '(' )
            {
            // InternalAle.g:5036:1: ( '(' )
            // InternalAle.g:5037:2: '('
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
    // InternalAle.g:5046:1: rule__NonLeftRecExpression__Group_4__1 : rule__NonLeftRecExpression__Group_4__1__Impl rule__NonLeftRecExpression__Group_4__2 ;
    public final void rule__NonLeftRecExpression__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5050:1: ( rule__NonLeftRecExpression__Group_4__1__Impl rule__NonLeftRecExpression__Group_4__2 )
            // InternalAle.g:5051:2: rule__NonLeftRecExpression__Group_4__1__Impl rule__NonLeftRecExpression__Group_4__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalAle.g:5058:1: rule__NonLeftRecExpression__Group_4__1__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5062:1: ( ( ruleexpression ) )
            // InternalAle.g:5063:1: ( ruleexpression )
            {
            // InternalAle.g:5063:1: ( ruleexpression )
            // InternalAle.g:5064:2: ruleexpression
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
    // InternalAle.g:5073:1: rule__NonLeftRecExpression__Group_4__2 : rule__NonLeftRecExpression__Group_4__2__Impl ;
    public final void rule__NonLeftRecExpression__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5077:1: ( rule__NonLeftRecExpression__Group_4__2__Impl )
            // InternalAle.g:5078:2: rule__NonLeftRecExpression__Group_4__2__Impl
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
    // InternalAle.g:5084:1: rule__NonLeftRecExpression__Group_4__2__Impl : ( ')' ) ;
    public final void rule__NonLeftRecExpression__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5088:1: ( ( ')' ) )
            // InternalAle.g:5089:1: ( ')' )
            {
            // InternalAle.g:5089:1: ( ')' )
            // InternalAle.g:5090:2: ')'
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
    // InternalAle.g:5100:1: rule__NonLeftRecExpression__Group_5__0 : rule__NonLeftRecExpression__Group_5__0__Impl rule__NonLeftRecExpression__Group_5__1 ;
    public final void rule__NonLeftRecExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5104:1: ( rule__NonLeftRecExpression__Group_5__0__Impl rule__NonLeftRecExpression__Group_5__1 )
            // InternalAle.g:5105:2: rule__NonLeftRecExpression__Group_5__0__Impl rule__NonLeftRecExpression__Group_5__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:5112:1: rule__NonLeftRecExpression__Group_5__0__Impl : ( 'if' ) ;
    public final void rule__NonLeftRecExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5116:1: ( ( 'if' ) )
            // InternalAle.g:5117:1: ( 'if' )
            {
            // InternalAle.g:5117:1: ( 'if' )
            // InternalAle.g:5118:2: 'if'
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
    // InternalAle.g:5127:1: rule__NonLeftRecExpression__Group_5__1 : rule__NonLeftRecExpression__Group_5__1__Impl rule__NonLeftRecExpression__Group_5__2 ;
    public final void rule__NonLeftRecExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5131:1: ( rule__NonLeftRecExpression__Group_5__1__Impl rule__NonLeftRecExpression__Group_5__2 )
            // InternalAle.g:5132:2: rule__NonLeftRecExpression__Group_5__1__Impl rule__NonLeftRecExpression__Group_5__2
            {
            pushFollow(FOLLOW_40);
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
    // InternalAle.g:5139:1: rule__NonLeftRecExpression__Group_5__1__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5143:1: ( ( ruleexpression ) )
            // InternalAle.g:5144:1: ( ruleexpression )
            {
            // InternalAle.g:5144:1: ( ruleexpression )
            // InternalAle.g:5145:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:5154:1: rule__NonLeftRecExpression__Group_5__2 : rule__NonLeftRecExpression__Group_5__2__Impl rule__NonLeftRecExpression__Group_5__3 ;
    public final void rule__NonLeftRecExpression__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5158:1: ( rule__NonLeftRecExpression__Group_5__2__Impl rule__NonLeftRecExpression__Group_5__3 )
            // InternalAle.g:5159:2: rule__NonLeftRecExpression__Group_5__2__Impl rule__NonLeftRecExpression__Group_5__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:5166:1: rule__NonLeftRecExpression__Group_5__2__Impl : ( 'then' ) ;
    public final void rule__NonLeftRecExpression__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5170:1: ( ( 'then' ) )
            // InternalAle.g:5171:1: ( 'then' )
            {
            // InternalAle.g:5171:1: ( 'then' )
            // InternalAle.g:5172:2: 'then'
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
    // InternalAle.g:5181:1: rule__NonLeftRecExpression__Group_5__3 : rule__NonLeftRecExpression__Group_5__3__Impl rule__NonLeftRecExpression__Group_5__4 ;
    public final void rule__NonLeftRecExpression__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5185:1: ( rule__NonLeftRecExpression__Group_5__3__Impl rule__NonLeftRecExpression__Group_5__4 )
            // InternalAle.g:5186:2: rule__NonLeftRecExpression__Group_5__3__Impl rule__NonLeftRecExpression__Group_5__4
            {
            pushFollow(FOLLOW_37);
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
    // InternalAle.g:5193:1: rule__NonLeftRecExpression__Group_5__3__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5197:1: ( ( ruleexpression ) )
            // InternalAle.g:5198:1: ( ruleexpression )
            {
            // InternalAle.g:5198:1: ( ruleexpression )
            // InternalAle.g:5199:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_3()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_3()); 
            }

            }


            }

        }
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
    // InternalAle.g:5208:1: rule__NonLeftRecExpression__Group_5__4 : rule__NonLeftRecExpression__Group_5__4__Impl rule__NonLeftRecExpression__Group_5__5 ;
    public final void rule__NonLeftRecExpression__Group_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5212:1: ( rule__NonLeftRecExpression__Group_5__4__Impl rule__NonLeftRecExpression__Group_5__5 )
            // InternalAle.g:5213:2: rule__NonLeftRecExpression__Group_5__4__Impl rule__NonLeftRecExpression__Group_5__5
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:5220:1: rule__NonLeftRecExpression__Group_5__4__Impl : ( 'else' ) ;
    public final void rule__NonLeftRecExpression__Group_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5224:1: ( ( 'else' ) )
            // InternalAle.g:5225:1: ( 'else' )
            {
            // InternalAle.g:5225:1: ( 'else' )
            // InternalAle.g:5226:2: 'else'
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
    // InternalAle.g:5235:1: rule__NonLeftRecExpression__Group_5__5 : rule__NonLeftRecExpression__Group_5__5__Impl rule__NonLeftRecExpression__Group_5__6 ;
    public final void rule__NonLeftRecExpression__Group_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5239:1: ( rule__NonLeftRecExpression__Group_5__5__Impl rule__NonLeftRecExpression__Group_5__6 )
            // InternalAle.g:5240:2: rule__NonLeftRecExpression__Group_5__5__Impl rule__NonLeftRecExpression__Group_5__6
            {
            pushFollow(FOLLOW_41);
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
    // InternalAle.g:5247:1: rule__NonLeftRecExpression__Group_5__5__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5251:1: ( ( ruleexpression ) )
            // InternalAle.g:5252:1: ( ruleexpression )
            {
            // InternalAle.g:5252:1: ( ruleexpression )
            // InternalAle.g:5253:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_5()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_5_5()); 
            }

            }


            }

        }
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
    // InternalAle.g:5262:1: rule__NonLeftRecExpression__Group_5__6 : rule__NonLeftRecExpression__Group_5__6__Impl ;
    public final void rule__NonLeftRecExpression__Group_5__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5266:1: ( rule__NonLeftRecExpression__Group_5__6__Impl )
            // InternalAle.g:5267:2: rule__NonLeftRecExpression__Group_5__6__Impl
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
    // InternalAle.g:5273:1: rule__NonLeftRecExpression__Group_5__6__Impl : ( 'endif' ) ;
    public final void rule__NonLeftRecExpression__Group_5__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5277:1: ( ( 'endif' ) )
            // InternalAle.g:5278:1: ( 'endif' )
            {
            // InternalAle.g:5278:1: ( 'endif' )
            // InternalAle.g:5279:2: 'endif'
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
    // InternalAle.g:5289:1: rule__NonLeftRecExpression__Group_6__0 : rule__NonLeftRecExpression__Group_6__0__Impl rule__NonLeftRecExpression__Group_6__1 ;
    public final void rule__NonLeftRecExpression__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5293:1: ( rule__NonLeftRecExpression__Group_6__0__Impl rule__NonLeftRecExpression__Group_6__1 )
            // InternalAle.g:5294:2: rule__NonLeftRecExpression__Group_6__0__Impl rule__NonLeftRecExpression__Group_6__1
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
    // InternalAle.g:5301:1: rule__NonLeftRecExpression__Group_6__0__Impl : ( 'let' ) ;
    public final void rule__NonLeftRecExpression__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5305:1: ( ( 'let' ) )
            // InternalAle.g:5306:1: ( 'let' )
            {
            // InternalAle.g:5306:1: ( 'let' )
            // InternalAle.g:5307:2: 'let'
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
    // InternalAle.g:5316:1: rule__NonLeftRecExpression__Group_6__1 : rule__NonLeftRecExpression__Group_6__1__Impl rule__NonLeftRecExpression__Group_6__2 ;
    public final void rule__NonLeftRecExpression__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5320:1: ( rule__NonLeftRecExpression__Group_6__1__Impl rule__NonLeftRecExpression__Group_6__2 )
            // InternalAle.g:5321:2: rule__NonLeftRecExpression__Group_6__1__Impl rule__NonLeftRecExpression__Group_6__2
            {
            pushFollow(FOLLOW_42);
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
    // InternalAle.g:5328:1: rule__NonLeftRecExpression__Group_6__1__Impl : ( rulebinding ) ;
    public final void rule__NonLeftRecExpression__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5332:1: ( ( rulebinding ) )
            // InternalAle.g:5333:1: ( rulebinding )
            {
            // InternalAle.g:5333:1: ( rulebinding )
            // InternalAle.g:5334:2: rulebinding
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingParserRuleCall_6_1()); 
            }
            pushFollow(FOLLOW_2);
            rulebinding();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingParserRuleCall_6_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:5343:1: rule__NonLeftRecExpression__Group_6__2 : rule__NonLeftRecExpression__Group_6__2__Impl rule__NonLeftRecExpression__Group_6__3 ;
    public final void rule__NonLeftRecExpression__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5347:1: ( rule__NonLeftRecExpression__Group_6__2__Impl rule__NonLeftRecExpression__Group_6__3 )
            // InternalAle.g:5348:2: rule__NonLeftRecExpression__Group_6__2__Impl rule__NonLeftRecExpression__Group_6__3
            {
            pushFollow(FOLLOW_42);
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
    // InternalAle.g:5355:1: rule__NonLeftRecExpression__Group_6__2__Impl : ( ( rule__NonLeftRecExpression__Group_6_2__0 )* ) ;
    public final void rule__NonLeftRecExpression__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5359:1: ( ( ( rule__NonLeftRecExpression__Group_6_2__0 )* ) )
            // InternalAle.g:5360:1: ( ( rule__NonLeftRecExpression__Group_6_2__0 )* )
            {
            // InternalAle.g:5360:1: ( ( rule__NonLeftRecExpression__Group_6_2__0 )* )
            // InternalAle.g:5361:2: ( rule__NonLeftRecExpression__Group_6_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6_2()); 
            }
            // InternalAle.g:5362:2: ( rule__NonLeftRecExpression__Group_6_2__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==55) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalAle.g:5362:3: rule__NonLeftRecExpression__Group_6_2__0
            	    {
            	    pushFollow(FOLLOW_18);
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
    // InternalAle.g:5370:1: rule__NonLeftRecExpression__Group_6__3 : rule__NonLeftRecExpression__Group_6__3__Impl rule__NonLeftRecExpression__Group_6__4 ;
    public final void rule__NonLeftRecExpression__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5374:1: ( rule__NonLeftRecExpression__Group_6__3__Impl rule__NonLeftRecExpression__Group_6__4 )
            // InternalAle.g:5375:2: rule__NonLeftRecExpression__Group_6__3__Impl rule__NonLeftRecExpression__Group_6__4
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:5382:1: rule__NonLeftRecExpression__Group_6__3__Impl : ( 'in' ) ;
    public final void rule__NonLeftRecExpression__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5386:1: ( ( 'in' ) )
            // InternalAle.g:5387:1: ( 'in' )
            {
            // InternalAle.g:5387:1: ( 'in' )
            // InternalAle.g:5388:2: 'in'
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
    // InternalAle.g:5397:1: rule__NonLeftRecExpression__Group_6__4 : rule__NonLeftRecExpression__Group_6__4__Impl ;
    public final void rule__NonLeftRecExpression__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5401:1: ( rule__NonLeftRecExpression__Group_6__4__Impl )
            // InternalAle.g:5402:2: rule__NonLeftRecExpression__Group_6__4__Impl
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
    // InternalAle.g:5408:1: rule__NonLeftRecExpression__Group_6__4__Impl : ( ruleexpression ) ;
    public final void rule__NonLeftRecExpression__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5412:1: ( ( ruleexpression ) )
            // InternalAle.g:5413:1: ( ruleexpression )
            {
            // InternalAle.g:5413:1: ( ruleexpression )
            // InternalAle.g:5414:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_6_4()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getExpressionParserRuleCall_6_4()); 
            }

            }


            }

        }
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
    // InternalAle.g:5424:1: rule__NonLeftRecExpression__Group_6_2__0 : rule__NonLeftRecExpression__Group_6_2__0__Impl rule__NonLeftRecExpression__Group_6_2__1 ;
    public final void rule__NonLeftRecExpression__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5428:1: ( rule__NonLeftRecExpression__Group_6_2__0__Impl rule__NonLeftRecExpression__Group_6_2__1 )
            // InternalAle.g:5429:2: rule__NonLeftRecExpression__Group_6_2__0__Impl rule__NonLeftRecExpression__Group_6_2__1
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
    // InternalAle.g:5436:1: rule__NonLeftRecExpression__Group_6_2__0__Impl : ( ',' ) ;
    public final void rule__NonLeftRecExpression__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5440:1: ( ( ',' ) )
            // InternalAle.g:5441:1: ( ',' )
            {
            // InternalAle.g:5441:1: ( ',' )
            // InternalAle.g:5442:2: ','
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
    // InternalAle.g:5451:1: rule__NonLeftRecExpression__Group_6_2__1 : rule__NonLeftRecExpression__Group_6_2__1__Impl ;
    public final void rule__NonLeftRecExpression__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5455:1: ( rule__NonLeftRecExpression__Group_6_2__1__Impl )
            // InternalAle.g:5456:2: rule__NonLeftRecExpression__Group_6_2__1__Impl
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
    // InternalAle.g:5462:1: rule__NonLeftRecExpression__Group_6_2__1__Impl : ( rulebinding ) ;
    public final void rule__NonLeftRecExpression__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5466:1: ( ( rulebinding ) )
            // InternalAle.g:5467:1: ( rulebinding )
            {
            // InternalAle.g:5467:1: ( rulebinding )
            // InternalAle.g:5468:2: rulebinding
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNonLeftRecExpressionAccess().getBindingParserRuleCall_6_2_1()); 
            }
            pushFollow(FOLLOW_2);
            rulebinding();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNonLeftRecExpressionAccess().getBindingParserRuleCall_6_2_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:5478:1: rule__Binding__Group__0 : rule__Binding__Group__0__Impl rule__Binding__Group__1 ;
    public final void rule__Binding__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5482:1: ( rule__Binding__Group__0__Impl rule__Binding__Group__1 )
            // InternalAle.g:5483:2: rule__Binding__Group__0__Impl rule__Binding__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalAle.g:5490:1: rule__Binding__Group__0__Impl : ( RULE_IDENT ) ;
    public final void rule__Binding__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5494:1: ( ( RULE_IDENT ) )
            // InternalAle.g:5495:1: ( RULE_IDENT )
            {
            // InternalAle.g:5495:1: ( RULE_IDENT )
            // InternalAle.g:5496:2: RULE_IDENT
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
    // InternalAle.g:5505:1: rule__Binding__Group__1 : rule__Binding__Group__1__Impl rule__Binding__Group__2 ;
    public final void rule__Binding__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5509:1: ( rule__Binding__Group__1__Impl rule__Binding__Group__2 )
            // InternalAle.g:5510:2: rule__Binding__Group__1__Impl rule__Binding__Group__2
            {
            pushFollow(FOLLOW_43);
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
    // InternalAle.g:5517:1: rule__Binding__Group__1__Impl : ( ( rule__Binding__Group_1__0 )? ) ;
    public final void rule__Binding__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5521:1: ( ( ( rule__Binding__Group_1__0 )? ) )
            // InternalAle.g:5522:1: ( ( rule__Binding__Group_1__0 )? )
            {
            // InternalAle.g:5522:1: ( ( rule__Binding__Group_1__0 )? )
            // InternalAle.g:5523:2: ( rule__Binding__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBindingAccess().getGroup_1()); 
            }
            // InternalAle.g:5524:2: ( rule__Binding__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==77) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAle.g:5524:3: rule__Binding__Group_1__0
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
    // InternalAle.g:5532:1: rule__Binding__Group__2 : rule__Binding__Group__2__Impl rule__Binding__Group__3 ;
    public final void rule__Binding__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5536:1: ( rule__Binding__Group__2__Impl rule__Binding__Group__3 )
            // InternalAle.g:5537:2: rule__Binding__Group__2__Impl rule__Binding__Group__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:5544:1: rule__Binding__Group__2__Impl : ( '=' ) ;
    public final void rule__Binding__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5548:1: ( ( '=' ) )
            // InternalAle.g:5549:1: ( '=' )
            {
            // InternalAle.g:5549:1: ( '=' )
            // InternalAle.g:5550:2: '='
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
    // InternalAle.g:5559:1: rule__Binding__Group__3 : rule__Binding__Group__3__Impl ;
    public final void rule__Binding__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5563:1: ( rule__Binding__Group__3__Impl )
            // InternalAle.g:5564:2: rule__Binding__Group__3__Impl
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
    // InternalAle.g:5570:1: rule__Binding__Group__3__Impl : ( ruleexpression ) ;
    public final void rule__Binding__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5574:1: ( ( ruleexpression ) )
            // InternalAle.g:5575:1: ( ruleexpression )
            {
            // InternalAle.g:5575:1: ( ruleexpression )
            // InternalAle.g:5576:2: ruleexpression
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
    // InternalAle.g:5586:1: rule__Binding__Group_1__0 : rule__Binding__Group_1__0__Impl rule__Binding__Group_1__1 ;
    public final void rule__Binding__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5590:1: ( rule__Binding__Group_1__0__Impl rule__Binding__Group_1__1 )
            // InternalAle.g:5591:2: rule__Binding__Group_1__0__Impl rule__Binding__Group_1__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalAle.g:5598:1: rule__Binding__Group_1__0__Impl : ( ':' ) ;
    public final void rule__Binding__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5602:1: ( ( ':' ) )
            // InternalAle.g:5603:1: ( ':' )
            {
            // InternalAle.g:5603:1: ( ':' )
            // InternalAle.g:5604:2: ':'
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
    // InternalAle.g:5613:1: rule__Binding__Group_1__1 : rule__Binding__Group_1__1__Impl ;
    public final void rule__Binding__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5617:1: ( rule__Binding__Group_1__1__Impl )
            // InternalAle.g:5618:2: rule__Binding__Group_1__1__Impl
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
    // InternalAle.g:5624:1: rule__Binding__Group_1__1__Impl : ( ruletypeLiteral ) ;
    public final void rule__Binding__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5628:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:5629:1: ( ruletypeLiteral )
            {
            // InternalAle.g:5629:1: ( ruletypeLiteral )
            // InternalAle.g:5630:2: ruletypeLiteral
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
    // InternalAle.g:5640:1: rule__CallExp__Group_0__0 : rule__CallExp__Group_0__0__Impl rule__CallExp__Group_0__1 ;
    public final void rule__CallExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5644:1: ( rule__CallExp__Group_0__0__Impl rule__CallExp__Group_0__1 )
            // InternalAle.g:5645:2: rule__CallExp__Group_0__0__Impl rule__CallExp__Group_0__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalAle.g:5652:1: rule__CallExp__Group_0__0__Impl : ( rulecollectionIterator ) ;
    public final void rule__CallExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5656:1: ( ( rulecollectionIterator ) )
            // InternalAle.g:5657:1: ( rulecollectionIterator )
            {
            // InternalAle.g:5657:1: ( rulecollectionIterator )
            // InternalAle.g:5658:2: rulecollectionIterator
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
    // InternalAle.g:5667:1: rule__CallExp__Group_0__1 : rule__CallExp__Group_0__1__Impl rule__CallExp__Group_0__2 ;
    public final void rule__CallExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5671:1: ( rule__CallExp__Group_0__1__Impl rule__CallExp__Group_0__2 )
            // InternalAle.g:5672:2: rule__CallExp__Group_0__1__Impl rule__CallExp__Group_0__2
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
    // InternalAle.g:5679:1: rule__CallExp__Group_0__1__Impl : ( '(' ) ;
    public final void rule__CallExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5683:1: ( ( '(' ) )
            // InternalAle.g:5684:1: ( '(' )
            {
            // InternalAle.g:5684:1: ( '(' )
            // InternalAle.g:5685:2: '('
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
    // InternalAle.g:5694:1: rule__CallExp__Group_0__2 : rule__CallExp__Group_0__2__Impl rule__CallExp__Group_0__3 ;
    public final void rule__CallExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5698:1: ( rule__CallExp__Group_0__2__Impl rule__CallExp__Group_0__3 )
            // InternalAle.g:5699:2: rule__CallExp__Group_0__2__Impl rule__CallExp__Group_0__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:5706:1: rule__CallExp__Group_0__2__Impl : ( rulevariableDefinition ) ;
    public final void rule__CallExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5710:1: ( ( rulevariableDefinition ) )
            // InternalAle.g:5711:1: ( rulevariableDefinition )
            {
            // InternalAle.g:5711:1: ( rulevariableDefinition )
            // InternalAle.g:5712:2: rulevariableDefinition
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
    // InternalAle.g:5721:1: rule__CallExp__Group_0__3 : rule__CallExp__Group_0__3__Impl rule__CallExp__Group_0__4 ;
    public final void rule__CallExp__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5725:1: ( rule__CallExp__Group_0__3__Impl rule__CallExp__Group_0__4 )
            // InternalAle.g:5726:2: rule__CallExp__Group_0__3__Impl rule__CallExp__Group_0__4
            {
            pushFollow(FOLLOW_30);
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
    // InternalAle.g:5733:1: rule__CallExp__Group_0__3__Impl : ( rulelambdaExpression ) ;
    public final void rule__CallExp__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5737:1: ( ( rulelambdaExpression ) )
            // InternalAle.g:5738:1: ( rulelambdaExpression )
            {
            // InternalAle.g:5738:1: ( rulelambdaExpression )
            // InternalAle.g:5739:2: rulelambdaExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpAccess().getLambdaExpressionParserRuleCall_0_3()); 
            }
            pushFollow(FOLLOW_2);
            rulelambdaExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpAccess().getLambdaExpressionParserRuleCall_0_3()); 
            }

            }


            }

        }
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
    // InternalAle.g:5748:1: rule__CallExp__Group_0__4 : rule__CallExp__Group_0__4__Impl ;
    public final void rule__CallExp__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5752:1: ( rule__CallExp__Group_0__4__Impl )
            // InternalAle.g:5753:2: rule__CallExp__Group_0__4__Impl
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
    // InternalAle.g:5759:1: rule__CallExp__Group_0__4__Impl : ( ')' ) ;
    public final void rule__CallExp__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5763:1: ( ( ')' ) )
            // InternalAle.g:5764:1: ( ')' )
            {
            // InternalAle.g:5764:1: ( ')' )
            // InternalAle.g:5765:2: ')'
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
    // InternalAle.g:5775:1: rule__CallExp__Group_1__0 : rule__CallExp__Group_1__0__Impl rule__CallExp__Group_1__1 ;
    public final void rule__CallExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5779:1: ( rule__CallExp__Group_1__0__Impl rule__CallExp__Group_1__1 )
            // InternalAle.g:5780:2: rule__CallExp__Group_1__0__Impl rule__CallExp__Group_1__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalAle.g:5787:1: rule__CallExp__Group_1__0__Impl : ( RULE_IDENT ) ;
    public final void rule__CallExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5791:1: ( ( RULE_IDENT ) )
            // InternalAle.g:5792:1: ( RULE_IDENT )
            {
            // InternalAle.g:5792:1: ( RULE_IDENT )
            // InternalAle.g:5793:2: RULE_IDENT
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
    // InternalAle.g:5802:1: rule__CallExp__Group_1__1 : rule__CallExp__Group_1__1__Impl rule__CallExp__Group_1__2 ;
    public final void rule__CallExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5806:1: ( rule__CallExp__Group_1__1__Impl rule__CallExp__Group_1__2 )
            // InternalAle.g:5807:2: rule__CallExp__Group_1__1__Impl rule__CallExp__Group_1__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:5814:1: rule__CallExp__Group_1__1__Impl : ( '(' ) ;
    public final void rule__CallExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5818:1: ( ( '(' ) )
            // InternalAle.g:5819:1: ( '(' )
            {
            // InternalAle.g:5819:1: ( '(' )
            // InternalAle.g:5820:2: '('
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
    // InternalAle.g:5829:1: rule__CallExp__Group_1__2 : rule__CallExp__Group_1__2__Impl rule__CallExp__Group_1__3 ;
    public final void rule__CallExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5833:1: ( rule__CallExp__Group_1__2__Impl rule__CallExp__Group_1__3 )
            // InternalAle.g:5834:2: rule__CallExp__Group_1__2__Impl rule__CallExp__Group_1__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalAle.g:5841:1: rule__CallExp__Group_1__2__Impl : ( ruleexpressionSequence ) ;
    public final void rule__CallExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5845:1: ( ( ruleexpressionSequence ) )
            // InternalAle.g:5846:1: ( ruleexpressionSequence )
            {
            // InternalAle.g:5846:1: ( ruleexpressionSequence )
            // InternalAle.g:5847:2: ruleexpressionSequence
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
    // InternalAle.g:5856:1: rule__CallExp__Group_1__3 : rule__CallExp__Group_1__3__Impl ;
    public final void rule__CallExp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5860:1: ( rule__CallExp__Group_1__3__Impl )
            // InternalAle.g:5861:2: rule__CallExp__Group_1__3__Impl
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
    // InternalAle.g:5867:1: rule__CallExp__Group_1__3__Impl : ( ')' ) ;
    public final void rule__CallExp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5871:1: ( ( ')' ) )
            // InternalAle.g:5872:1: ( ')' )
            {
            // InternalAle.g:5872:1: ( ')' )
            // InternalAle.g:5873:2: ')'
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
    // InternalAle.g:5883:1: rule__ExpressionSequence__Group__0 : rule__ExpressionSequence__Group__0__Impl rule__ExpressionSequence__Group__1 ;
    public final void rule__ExpressionSequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5887:1: ( rule__ExpressionSequence__Group__0__Impl rule__ExpressionSequence__Group__1 )
            // InternalAle.g:5888:2: rule__ExpressionSequence__Group__0__Impl rule__ExpressionSequence__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalAle.g:5895:1: rule__ExpressionSequence__Group__0__Impl : ( ruleexpression ) ;
    public final void rule__ExpressionSequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5899:1: ( ( ruleexpression ) )
            // InternalAle.g:5900:1: ( ruleexpression )
            {
            // InternalAle.g:5900:1: ( ruleexpression )
            // InternalAle.g:5901:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceAccess().getExpressionParserRuleCall_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:5910:1: rule__ExpressionSequence__Group__1 : rule__ExpressionSequence__Group__1__Impl ;
    public final void rule__ExpressionSequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5914:1: ( rule__ExpressionSequence__Group__1__Impl )
            // InternalAle.g:5915:2: rule__ExpressionSequence__Group__1__Impl
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
    // InternalAle.g:5921:1: rule__ExpressionSequence__Group__1__Impl : ( ( rule__ExpressionSequence__Group_1__0 )* ) ;
    public final void rule__ExpressionSequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5925:1: ( ( ( rule__ExpressionSequence__Group_1__0 )* ) )
            // InternalAle.g:5926:1: ( ( rule__ExpressionSequence__Group_1__0 )* )
            {
            // InternalAle.g:5926:1: ( ( rule__ExpressionSequence__Group_1__0 )* )
            // InternalAle.g:5927:2: ( rule__ExpressionSequence__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getGroup_1()); 
            }
            // InternalAle.g:5928:2: ( rule__ExpressionSequence__Group_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==55) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalAle.g:5928:3: rule__ExpressionSequence__Group_1__0
            	    {
            	    pushFollow(FOLLOW_18);
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
    // InternalAle.g:5937:1: rule__ExpressionSequence__Group_1__0 : rule__ExpressionSequence__Group_1__0__Impl rule__ExpressionSequence__Group_1__1 ;
    public final void rule__ExpressionSequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5941:1: ( rule__ExpressionSequence__Group_1__0__Impl rule__ExpressionSequence__Group_1__1 )
            // InternalAle.g:5942:2: rule__ExpressionSequence__Group_1__0__Impl rule__ExpressionSequence__Group_1__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:5949:1: rule__ExpressionSequence__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ExpressionSequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5953:1: ( ( ',' ) )
            // InternalAle.g:5954:1: ( ',' )
            {
            // InternalAle.g:5954:1: ( ',' )
            // InternalAle.g:5955:2: ','
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
    // InternalAle.g:5964:1: rule__ExpressionSequence__Group_1__1 : rule__ExpressionSequence__Group_1__1__Impl ;
    public final void rule__ExpressionSequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5968:1: ( rule__ExpressionSequence__Group_1__1__Impl )
            // InternalAle.g:5969:2: rule__ExpressionSequence__Group_1__1__Impl
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
    // InternalAle.g:5975:1: rule__ExpressionSequence__Group_1__1__Impl : ( ruleexpression ) ;
    public final void rule__ExpressionSequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5979:1: ( ( ruleexpression ) )
            // InternalAle.g:5980:1: ( ruleexpression )
            {
            // InternalAle.g:5980:1: ( ruleexpression )
            // InternalAle.g:5981:2: ruleexpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionSequenceAccess().getExpressionParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleexpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionSequenceAccess().getExpressionParserRuleCall_1_1()); 
            }

            }


            }

        }
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
    // InternalAle.g:5991:1: rule__VariableDefinition__Group__0 : rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 ;
    public final void rule__VariableDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:5995:1: ( rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 )
            // InternalAle.g:5996:2: rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalAle.g:6003:1: rule__VariableDefinition__Group__0__Impl : ( RULE_IDENT ) ;
    public final void rule__VariableDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6007:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6008:1: ( RULE_IDENT )
            {
            // InternalAle.g:6008:1: ( RULE_IDENT )
            // InternalAle.g:6009:2: RULE_IDENT
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
    // InternalAle.g:6018:1: rule__VariableDefinition__Group__1 : rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 ;
    public final void rule__VariableDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6022:1: ( rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 )
            // InternalAle.g:6023:2: rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2
            {
            pushFollow(FOLLOW_44);
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
    // InternalAle.g:6030:1: rule__VariableDefinition__Group__1__Impl : ( ( rule__VariableDefinition__Group_1__0 )? ) ;
    public final void rule__VariableDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6034:1: ( ( ( rule__VariableDefinition__Group_1__0 )? ) )
            // InternalAle.g:6035:1: ( ( rule__VariableDefinition__Group_1__0 )? )
            {
            // InternalAle.g:6035:1: ( ( rule__VariableDefinition__Group_1__0 )? )
            // InternalAle.g:6036:2: ( rule__VariableDefinition__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableDefinitionAccess().getGroup_1()); 
            }
            // InternalAle.g:6037:2: ( rule__VariableDefinition__Group_1__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==77) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalAle.g:6037:3: rule__VariableDefinition__Group_1__0
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
    // InternalAle.g:6045:1: rule__VariableDefinition__Group__2 : rule__VariableDefinition__Group__2__Impl ;
    public final void rule__VariableDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6049:1: ( rule__VariableDefinition__Group__2__Impl )
            // InternalAle.g:6050:2: rule__VariableDefinition__Group__2__Impl
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
    // InternalAle.g:6056:1: rule__VariableDefinition__Group__2__Impl : ( '|' ) ;
    public final void rule__VariableDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6060:1: ( ( '|' ) )
            // InternalAle.g:6061:1: ( '|' )
            {
            // InternalAle.g:6061:1: ( '|' )
            // InternalAle.g:6062:2: '|'
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
    // InternalAle.g:6072:1: rule__VariableDefinition__Group_1__0 : rule__VariableDefinition__Group_1__0__Impl rule__VariableDefinition__Group_1__1 ;
    public final void rule__VariableDefinition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6076:1: ( rule__VariableDefinition__Group_1__0__Impl rule__VariableDefinition__Group_1__1 )
            // InternalAle.g:6077:2: rule__VariableDefinition__Group_1__0__Impl rule__VariableDefinition__Group_1__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalAle.g:6084:1: rule__VariableDefinition__Group_1__0__Impl : ( ':' ) ;
    public final void rule__VariableDefinition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6088:1: ( ( ':' ) )
            // InternalAle.g:6089:1: ( ':' )
            {
            // InternalAle.g:6089:1: ( ':' )
            // InternalAle.g:6090:2: ':'
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
    // InternalAle.g:6099:1: rule__VariableDefinition__Group_1__1 : rule__VariableDefinition__Group_1__1__Impl ;
    public final void rule__VariableDefinition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6103:1: ( rule__VariableDefinition__Group_1__1__Impl )
            // InternalAle.g:6104:2: rule__VariableDefinition__Group_1__1__Impl
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
    // InternalAle.g:6110:1: rule__VariableDefinition__Group_1__1__Impl : ( ruletypeLiteral ) ;
    public final void rule__VariableDefinition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6114:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:6115:1: ( ruletypeLiteral )
            {
            // InternalAle.g:6115:1: ( ruletypeLiteral )
            // InternalAle.g:6116:2: ruletypeLiteral
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
    // InternalAle.g:6126:1: rule__Literal__Group_6__0 : rule__Literal__Group_6__0__Impl rule__Literal__Group_6__1 ;
    public final void rule__Literal__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6130:1: ( rule__Literal__Group_6__0__Impl rule__Literal__Group_6__1 )
            // InternalAle.g:6131:2: rule__Literal__Group_6__0__Impl rule__Literal__Group_6__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:6138:1: rule__Literal__Group_6__0__Impl : ( 'Sequence{' ) ;
    public final void rule__Literal__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6142:1: ( ( 'Sequence{' ) )
            // InternalAle.g:6143:1: ( 'Sequence{' )
            {
            // InternalAle.g:6143:1: ( 'Sequence{' )
            // InternalAle.g:6144:2: 'Sequence{'
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
    // InternalAle.g:6153:1: rule__Literal__Group_6__1 : rule__Literal__Group_6__1__Impl rule__Literal__Group_6__2 ;
    public final void rule__Literal__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6157:1: ( rule__Literal__Group_6__1__Impl rule__Literal__Group_6__2 )
            // InternalAle.g:6158:2: rule__Literal__Group_6__1__Impl rule__Literal__Group_6__2
            {
            pushFollow(FOLLOW_45);
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
    // InternalAle.g:6165:1: rule__Literal__Group_6__1__Impl : ( ruleexpressionSequence ) ;
    public final void rule__Literal__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6169:1: ( ( ruleexpressionSequence ) )
            // InternalAle.g:6170:1: ( ruleexpressionSequence )
            {
            // InternalAle.g:6170:1: ( ruleexpressionSequence )
            // InternalAle.g:6171:2: ruleexpressionSequence
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
    // InternalAle.g:6180:1: rule__Literal__Group_6__2 : rule__Literal__Group_6__2__Impl ;
    public final void rule__Literal__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6184:1: ( rule__Literal__Group_6__2__Impl )
            // InternalAle.g:6185:2: rule__Literal__Group_6__2__Impl
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
    // InternalAle.g:6191:1: rule__Literal__Group_6__2__Impl : ( '}' ) ;
    public final void rule__Literal__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6195:1: ( ( '}' ) )
            // InternalAle.g:6196:1: ( '}' )
            {
            // InternalAle.g:6196:1: ( '}' )
            // InternalAle.g:6197:2: '}'
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
    // InternalAle.g:6207:1: rule__Literal__Group_7__0 : rule__Literal__Group_7__0__Impl rule__Literal__Group_7__1 ;
    public final void rule__Literal__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6211:1: ( rule__Literal__Group_7__0__Impl rule__Literal__Group_7__1 )
            // InternalAle.g:6212:2: rule__Literal__Group_7__0__Impl rule__Literal__Group_7__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAle.g:6219:1: rule__Literal__Group_7__0__Impl : ( 'OrderedSet{' ) ;
    public final void rule__Literal__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6223:1: ( ( 'OrderedSet{' ) )
            // InternalAle.g:6224:1: ( 'OrderedSet{' )
            {
            // InternalAle.g:6224:1: ( 'OrderedSet{' )
            // InternalAle.g:6225:2: 'OrderedSet{'
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
    // InternalAle.g:6234:1: rule__Literal__Group_7__1 : rule__Literal__Group_7__1__Impl rule__Literal__Group_7__2 ;
    public final void rule__Literal__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6238:1: ( rule__Literal__Group_7__1__Impl rule__Literal__Group_7__2 )
            // InternalAle.g:6239:2: rule__Literal__Group_7__1__Impl rule__Literal__Group_7__2
            {
            pushFollow(FOLLOW_45);
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
    // InternalAle.g:6246:1: rule__Literal__Group_7__1__Impl : ( ruleexpressionSequence ) ;
    public final void rule__Literal__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6250:1: ( ( ruleexpressionSequence ) )
            // InternalAle.g:6251:1: ( ruleexpressionSequence )
            {
            // InternalAle.g:6251:1: ( ruleexpressionSequence )
            // InternalAle.g:6252:2: ruleexpressionSequence
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
    // InternalAle.g:6261:1: rule__Literal__Group_7__2 : rule__Literal__Group_7__2__Impl ;
    public final void rule__Literal__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6265:1: ( rule__Literal__Group_7__2__Impl )
            // InternalAle.g:6266:2: rule__Literal__Group_7__2__Impl
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
    // InternalAle.g:6272:1: rule__Literal__Group_7__2__Impl : ( '}' ) ;
    public final void rule__Literal__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6276:1: ( ( '}' ) )
            // InternalAle.g:6277:1: ( '}' )
            {
            // InternalAle.g:6277:1: ( '}' )
            // InternalAle.g:6278:2: '}'
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
    // InternalAle.g:6288:1: rule__Literal__Group_8__0 : rule__Literal__Group_8__0__Impl rule__Literal__Group_8__1 ;
    public final void rule__Literal__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6292:1: ( rule__Literal__Group_8__0__Impl rule__Literal__Group_8__1 )
            // InternalAle.g:6293:2: rule__Literal__Group_8__0__Impl rule__Literal__Group_8__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalAle.g:6300:1: rule__Literal__Group_8__0__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6304:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6305:1: ( RULE_IDENT )
            {
            // InternalAle.g:6305:1: ( RULE_IDENT )
            // InternalAle.g:6306:2: RULE_IDENT
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
    // InternalAle.g:6315:1: rule__Literal__Group_8__1 : rule__Literal__Group_8__1__Impl rule__Literal__Group_8__2 ;
    public final void rule__Literal__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6319:1: ( rule__Literal__Group_8__1__Impl rule__Literal__Group_8__2 )
            // InternalAle.g:6320:2: rule__Literal__Group_8__1__Impl rule__Literal__Group_8__2
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
    // InternalAle.g:6327:1: rule__Literal__Group_8__1__Impl : ( '::' ) ;
    public final void rule__Literal__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6331:1: ( ( '::' ) )
            // InternalAle.g:6332:1: ( '::' )
            {
            // InternalAle.g:6332:1: ( '::' )
            // InternalAle.g:6333:2: '::'
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
    // InternalAle.g:6342:1: rule__Literal__Group_8__2 : rule__Literal__Group_8__2__Impl rule__Literal__Group_8__3 ;
    public final void rule__Literal__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6346:1: ( rule__Literal__Group_8__2__Impl rule__Literal__Group_8__3 )
            // InternalAle.g:6347:2: rule__Literal__Group_8__2__Impl rule__Literal__Group_8__3
            {
            pushFollow(FOLLOW_46);
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
    // InternalAle.g:6354:1: rule__Literal__Group_8__2__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6358:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6359:1: ( RULE_IDENT )
            {
            // InternalAle.g:6359:1: ( RULE_IDENT )
            // InternalAle.g:6360:2: RULE_IDENT
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
    // InternalAle.g:6369:1: rule__Literal__Group_8__3 : rule__Literal__Group_8__3__Impl rule__Literal__Group_8__4 ;
    public final void rule__Literal__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6373:1: ( rule__Literal__Group_8__3__Impl rule__Literal__Group_8__4 )
            // InternalAle.g:6374:2: rule__Literal__Group_8__3__Impl rule__Literal__Group_8__4
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
    // InternalAle.g:6381:1: rule__Literal__Group_8__3__Impl : ( '::' ) ;
    public final void rule__Literal__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6385:1: ( ( '::' ) )
            // InternalAle.g:6386:1: ( '::' )
            {
            // InternalAle.g:6386:1: ( '::' )
            // InternalAle.g:6387:2: '::'
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
    // InternalAle.g:6396:1: rule__Literal__Group_8__4 : rule__Literal__Group_8__4__Impl ;
    public final void rule__Literal__Group_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6400:1: ( rule__Literal__Group_8__4__Impl )
            // InternalAle.g:6401:2: rule__Literal__Group_8__4__Impl
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
    // InternalAle.g:6407:1: rule__Literal__Group_8__4__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6411:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6412:1: ( RULE_IDENT )
            {
            // InternalAle.g:6412:1: ( RULE_IDENT )
            // InternalAle.g:6413:2: RULE_IDENT
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
    // InternalAle.g:6423:1: rule__Literal__Group_9__0 : rule__Literal__Group_9__0__Impl rule__Literal__Group_9__1 ;
    public final void rule__Literal__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6427:1: ( rule__Literal__Group_9__0__Impl rule__Literal__Group_9__1 )
            // InternalAle.g:6428:2: rule__Literal__Group_9__0__Impl rule__Literal__Group_9__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalAle.g:6435:1: rule__Literal__Group_9__0__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6439:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6440:1: ( RULE_IDENT )
            {
            // InternalAle.g:6440:1: ( RULE_IDENT )
            // InternalAle.g:6441:2: RULE_IDENT
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
    // InternalAle.g:6450:1: rule__Literal__Group_9__1 : rule__Literal__Group_9__1__Impl rule__Literal__Group_9__2 ;
    public final void rule__Literal__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6454:1: ( rule__Literal__Group_9__1__Impl rule__Literal__Group_9__2 )
            // InternalAle.g:6455:2: rule__Literal__Group_9__1__Impl rule__Literal__Group_9__2
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
    // InternalAle.g:6462:1: rule__Literal__Group_9__1__Impl : ( '::' ) ;
    public final void rule__Literal__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6466:1: ( ( '::' ) )
            // InternalAle.g:6467:1: ( '::' )
            {
            // InternalAle.g:6467:1: ( '::' )
            // InternalAle.g:6468:2: '::'
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
    // InternalAle.g:6477:1: rule__Literal__Group_9__2 : rule__Literal__Group_9__2__Impl rule__Literal__Group_9__3 ;
    public final void rule__Literal__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6481:1: ( rule__Literal__Group_9__2__Impl rule__Literal__Group_9__3 )
            // InternalAle.g:6482:2: rule__Literal__Group_9__2__Impl rule__Literal__Group_9__3
            {
            pushFollow(FOLLOW_47);
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
    // InternalAle.g:6489:1: rule__Literal__Group_9__2__Impl : ( RULE_IDENT ) ;
    public final void rule__Literal__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6493:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6494:1: ( RULE_IDENT )
            {
            // InternalAle.g:6494:1: ( RULE_IDENT )
            // InternalAle.g:6495:2: RULE_IDENT
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
    // InternalAle.g:6504:1: rule__Literal__Group_9__3 : rule__Literal__Group_9__3__Impl ;
    public final void rule__Literal__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6508:1: ( rule__Literal__Group_9__3__Impl )
            // InternalAle.g:6509:2: rule__Literal__Group_9__3__Impl
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
    // InternalAle.g:6515:1: rule__Literal__Group_9__3__Impl : ( ':' ) ;
    public final void rule__Literal__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6519:1: ( ( ':' ) )
            // InternalAle.g:6520:1: ( ':' )
            {
            // InternalAle.g:6520:1: ( ':' )
            // InternalAle.g:6521:2: ':'
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
    // InternalAle.g:6531:1: rule__TypeLiteral__Group_4__0 : rule__TypeLiteral__Group_4__0__Impl rule__TypeLiteral__Group_4__1 ;
    public final void rule__TypeLiteral__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6535:1: ( rule__TypeLiteral__Group_4__0__Impl rule__TypeLiteral__Group_4__1 )
            // InternalAle.g:6536:2: rule__TypeLiteral__Group_4__0__Impl rule__TypeLiteral__Group_4__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalAle.g:6543:1: rule__TypeLiteral__Group_4__0__Impl : ( 'Sequence(' ) ;
    public final void rule__TypeLiteral__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6547:1: ( ( 'Sequence(' ) )
            // InternalAle.g:6548:1: ( 'Sequence(' )
            {
            // InternalAle.g:6548:1: ( 'Sequence(' )
            // InternalAle.g:6549:2: 'Sequence('
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
    // InternalAle.g:6558:1: rule__TypeLiteral__Group_4__1 : rule__TypeLiteral__Group_4__1__Impl rule__TypeLiteral__Group_4__2 ;
    public final void rule__TypeLiteral__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6562:1: ( rule__TypeLiteral__Group_4__1__Impl rule__TypeLiteral__Group_4__2 )
            // InternalAle.g:6563:2: rule__TypeLiteral__Group_4__1__Impl rule__TypeLiteral__Group_4__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalAle.g:6570:1: rule__TypeLiteral__Group_4__1__Impl : ( ruletypeLiteral ) ;
    public final void rule__TypeLiteral__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6574:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:6575:1: ( ruletypeLiteral )
            {
            // InternalAle.g:6575:1: ( ruletypeLiteral )
            // InternalAle.g:6576:2: ruletypeLiteral
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
    // InternalAle.g:6585:1: rule__TypeLiteral__Group_4__2 : rule__TypeLiteral__Group_4__2__Impl ;
    public final void rule__TypeLiteral__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6589:1: ( rule__TypeLiteral__Group_4__2__Impl )
            // InternalAle.g:6590:2: rule__TypeLiteral__Group_4__2__Impl
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
    // InternalAle.g:6596:1: rule__TypeLiteral__Group_4__2__Impl : ( ')' ) ;
    public final void rule__TypeLiteral__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6600:1: ( ( ')' ) )
            // InternalAle.g:6601:1: ( ')' )
            {
            // InternalAle.g:6601:1: ( ')' )
            // InternalAle.g:6602:2: ')'
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
    // InternalAle.g:6612:1: rule__TypeLiteral__Group_5__0 : rule__TypeLiteral__Group_5__0__Impl rule__TypeLiteral__Group_5__1 ;
    public final void rule__TypeLiteral__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6616:1: ( rule__TypeLiteral__Group_5__0__Impl rule__TypeLiteral__Group_5__1 )
            // InternalAle.g:6617:2: rule__TypeLiteral__Group_5__0__Impl rule__TypeLiteral__Group_5__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalAle.g:6624:1: rule__TypeLiteral__Group_5__0__Impl : ( 'OrderedSet(' ) ;
    public final void rule__TypeLiteral__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6628:1: ( ( 'OrderedSet(' ) )
            // InternalAle.g:6629:1: ( 'OrderedSet(' )
            {
            // InternalAle.g:6629:1: ( 'OrderedSet(' )
            // InternalAle.g:6630:2: 'OrderedSet('
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
    // InternalAle.g:6639:1: rule__TypeLiteral__Group_5__1 : rule__TypeLiteral__Group_5__1__Impl rule__TypeLiteral__Group_5__2 ;
    public final void rule__TypeLiteral__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6643:1: ( rule__TypeLiteral__Group_5__1__Impl rule__TypeLiteral__Group_5__2 )
            // InternalAle.g:6644:2: rule__TypeLiteral__Group_5__1__Impl rule__TypeLiteral__Group_5__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalAle.g:6651:1: rule__TypeLiteral__Group_5__1__Impl : ( ruletypeLiteral ) ;
    public final void rule__TypeLiteral__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6655:1: ( ( ruletypeLiteral ) )
            // InternalAle.g:6656:1: ( ruletypeLiteral )
            {
            // InternalAle.g:6656:1: ( ruletypeLiteral )
            // InternalAle.g:6657:2: ruletypeLiteral
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
    // InternalAle.g:6666:1: rule__TypeLiteral__Group_5__2 : rule__TypeLiteral__Group_5__2__Impl ;
    public final void rule__TypeLiteral__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6670:1: ( rule__TypeLiteral__Group_5__2__Impl )
            // InternalAle.g:6671:2: rule__TypeLiteral__Group_5__2__Impl
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
    // InternalAle.g:6677:1: rule__TypeLiteral__Group_5__2__Impl : ( ')' ) ;
    public final void rule__TypeLiteral__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6681:1: ( ( ')' ) )
            // InternalAle.g:6682:1: ( ')' )
            {
            // InternalAle.g:6682:1: ( ')' )
            // InternalAle.g:6683:2: ')'
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
    // InternalAle.g:6693:1: rule__TypeLiteral__Group_7__0 : rule__TypeLiteral__Group_7__0__Impl rule__TypeLiteral__Group_7__1 ;
    public final void rule__TypeLiteral__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6697:1: ( rule__TypeLiteral__Group_7__0__Impl rule__TypeLiteral__Group_7__1 )
            // InternalAle.g:6698:2: rule__TypeLiteral__Group_7__0__Impl rule__TypeLiteral__Group_7__1
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
    // InternalAle.g:6705:1: rule__TypeLiteral__Group_7__0__Impl : ( '{' ) ;
    public final void rule__TypeLiteral__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6709:1: ( ( '{' ) )
            // InternalAle.g:6710:1: ( '{' )
            {
            // InternalAle.g:6710:1: ( '{' )
            // InternalAle.g:6711:2: '{'
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
    // InternalAle.g:6720:1: rule__TypeLiteral__Group_7__1 : rule__TypeLiteral__Group_7__1__Impl rule__TypeLiteral__Group_7__2 ;
    public final void rule__TypeLiteral__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6724:1: ( rule__TypeLiteral__Group_7__1__Impl rule__TypeLiteral__Group_7__2 )
            // InternalAle.g:6725:2: rule__TypeLiteral__Group_7__1__Impl rule__TypeLiteral__Group_7__2
            {
            pushFollow(FOLLOW_48);
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
    // InternalAle.g:6732:1: rule__TypeLiteral__Group_7__1__Impl : ( ruleclassifierTypeRule ) ;
    public final void rule__TypeLiteral__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6736:1: ( ( ruleclassifierTypeRule ) )
            // InternalAle.g:6737:1: ( ruleclassifierTypeRule )
            {
            // InternalAle.g:6737:1: ( ruleclassifierTypeRule )
            // InternalAle.g:6738:2: ruleclassifierTypeRule
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
    // InternalAle.g:6747:1: rule__TypeLiteral__Group_7__2 : rule__TypeLiteral__Group_7__2__Impl rule__TypeLiteral__Group_7__3 ;
    public final void rule__TypeLiteral__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6751:1: ( rule__TypeLiteral__Group_7__2__Impl rule__TypeLiteral__Group_7__3 )
            // InternalAle.g:6752:2: rule__TypeLiteral__Group_7__2__Impl rule__TypeLiteral__Group_7__3
            {
            pushFollow(FOLLOW_48);
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
    // InternalAle.g:6759:1: rule__TypeLiteral__Group_7__2__Impl : ( ( rule__TypeLiteral__Group_7_2__0 )* ) ;
    public final void rule__TypeLiteral__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6763:1: ( ( ( rule__TypeLiteral__Group_7_2__0 )* ) )
            // InternalAle.g:6764:1: ( ( rule__TypeLiteral__Group_7_2__0 )* )
            {
            // InternalAle.g:6764:1: ( ( rule__TypeLiteral__Group_7_2__0 )* )
            // InternalAle.g:6765:2: ( rule__TypeLiteral__Group_7_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeLiteralAccess().getGroup_7_2()); 
            }
            // InternalAle.g:6766:2: ( rule__TypeLiteral__Group_7_2__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==78) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalAle.g:6766:3: rule__TypeLiteral__Group_7_2__0
            	    {
            	    pushFollow(FOLLOW_49);
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
    // InternalAle.g:6774:1: rule__TypeLiteral__Group_7__3 : rule__TypeLiteral__Group_7__3__Impl ;
    public final void rule__TypeLiteral__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6778:1: ( rule__TypeLiteral__Group_7__3__Impl )
            // InternalAle.g:6779:2: rule__TypeLiteral__Group_7__3__Impl
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
    // InternalAle.g:6785:1: rule__TypeLiteral__Group_7__3__Impl : ( '}' ) ;
    public final void rule__TypeLiteral__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6789:1: ( ( '}' ) )
            // InternalAle.g:6790:1: ( '}' )
            {
            // InternalAle.g:6790:1: ( '}' )
            // InternalAle.g:6791:2: '}'
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
    // InternalAle.g:6801:1: rule__TypeLiteral__Group_7_2__0 : rule__TypeLiteral__Group_7_2__0__Impl rule__TypeLiteral__Group_7_2__1 ;
    public final void rule__TypeLiteral__Group_7_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6805:1: ( rule__TypeLiteral__Group_7_2__0__Impl rule__TypeLiteral__Group_7_2__1 )
            // InternalAle.g:6806:2: rule__TypeLiteral__Group_7_2__0__Impl rule__TypeLiteral__Group_7_2__1
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
    // InternalAle.g:6813:1: rule__TypeLiteral__Group_7_2__0__Impl : ( '|' ) ;
    public final void rule__TypeLiteral__Group_7_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6817:1: ( ( '|' ) )
            // InternalAle.g:6818:1: ( '|' )
            {
            // InternalAle.g:6818:1: ( '|' )
            // InternalAle.g:6819:2: '|'
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
    // InternalAle.g:6828:1: rule__TypeLiteral__Group_7_2__1 : rule__TypeLiteral__Group_7_2__1__Impl ;
    public final void rule__TypeLiteral__Group_7_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6832:1: ( rule__TypeLiteral__Group_7_2__1__Impl )
            // InternalAle.g:6833:2: rule__TypeLiteral__Group_7_2__1__Impl
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
    // InternalAle.g:6839:1: rule__TypeLiteral__Group_7_2__1__Impl : ( ruleclassifierTypeRule ) ;
    public final void rule__TypeLiteral__Group_7_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6843:1: ( ( ruleclassifierTypeRule ) )
            // InternalAle.g:6844:1: ( ruleclassifierTypeRule )
            {
            // InternalAle.g:6844:1: ( ruleclassifierTypeRule )
            // InternalAle.g:6845:2: ruleclassifierTypeRule
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
    // InternalAle.g:6855:1: rule__ClassifierTypeRule__Group_0__0 : rule__ClassifierTypeRule__Group_0__0__Impl rule__ClassifierTypeRule__Group_0__1 ;
    public final void rule__ClassifierTypeRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6859:1: ( rule__ClassifierTypeRule__Group_0__0__Impl rule__ClassifierTypeRule__Group_0__1 )
            // InternalAle.g:6860:2: rule__ClassifierTypeRule__Group_0__0__Impl rule__ClassifierTypeRule__Group_0__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalAle.g:6867:1: rule__ClassifierTypeRule__Group_0__0__Impl : ( RULE_IDENT ) ;
    public final void rule__ClassifierTypeRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6871:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6872:1: ( RULE_IDENT )
            {
            // InternalAle.g:6872:1: ( RULE_IDENT )
            // InternalAle.g:6873:2: RULE_IDENT
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
    // InternalAle.g:6882:1: rule__ClassifierTypeRule__Group_0__1 : rule__ClassifierTypeRule__Group_0__1__Impl rule__ClassifierTypeRule__Group_0__2 ;
    public final void rule__ClassifierTypeRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6886:1: ( rule__ClassifierTypeRule__Group_0__1__Impl rule__ClassifierTypeRule__Group_0__2 )
            // InternalAle.g:6887:2: rule__ClassifierTypeRule__Group_0__1__Impl rule__ClassifierTypeRule__Group_0__2
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
    // InternalAle.g:6894:1: rule__ClassifierTypeRule__Group_0__1__Impl : ( '::' ) ;
    public final void rule__ClassifierTypeRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6898:1: ( ( '::' ) )
            // InternalAle.g:6899:1: ( '::' )
            {
            // InternalAle.g:6899:1: ( '::' )
            // InternalAle.g:6900:2: '::'
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
    // InternalAle.g:6909:1: rule__ClassifierTypeRule__Group_0__2 : rule__ClassifierTypeRule__Group_0__2__Impl ;
    public final void rule__ClassifierTypeRule__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6913:1: ( rule__ClassifierTypeRule__Group_0__2__Impl )
            // InternalAle.g:6914:2: rule__ClassifierTypeRule__Group_0__2__Impl
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
    // InternalAle.g:6920:1: rule__ClassifierTypeRule__Group_0__2__Impl : ( RULE_IDENT ) ;
    public final void rule__ClassifierTypeRule__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6924:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6925:1: ( RULE_IDENT )
            {
            // InternalAle.g:6925:1: ( RULE_IDENT )
            // InternalAle.g:6926:2: RULE_IDENT
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
    // InternalAle.g:6936:1: rule__ClassifierTypeRule__Group_1__0 : rule__ClassifierTypeRule__Group_1__0__Impl rule__ClassifierTypeRule__Group_1__1 ;
    public final void rule__ClassifierTypeRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6940:1: ( rule__ClassifierTypeRule__Group_1__0__Impl rule__ClassifierTypeRule__Group_1__1 )
            // InternalAle.g:6941:2: rule__ClassifierTypeRule__Group_1__0__Impl rule__ClassifierTypeRule__Group_1__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalAle.g:6948:1: rule__ClassifierTypeRule__Group_1__0__Impl : ( RULE_IDENT ) ;
    public final void rule__ClassifierTypeRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6952:1: ( ( RULE_IDENT ) )
            // InternalAle.g:6953:1: ( RULE_IDENT )
            {
            // InternalAle.g:6953:1: ( RULE_IDENT )
            // InternalAle.g:6954:2: RULE_IDENT
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
    // InternalAle.g:6963:1: rule__ClassifierTypeRule__Group_1__1 : rule__ClassifierTypeRule__Group_1__1__Impl ;
    public final void rule__ClassifierTypeRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6967:1: ( rule__ClassifierTypeRule__Group_1__1__Impl )
            // InternalAle.g:6968:2: rule__ClassifierTypeRule__Group_1__1__Impl
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
    // InternalAle.g:6974:1: rule__ClassifierTypeRule__Group_1__1__Impl : ( ':' ) ;
    public final void rule__ClassifierTypeRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6978:1: ( ( ':' ) )
            // InternalAle.g:6979:1: ( ':' )
            {
            // InternalAle.g:6979:1: ( ':' )
            // InternalAle.g:6980:2: ':'
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
    // InternalAle.g:6990:1: rule__RQualified__Group__0 : rule__RQualified__Group__0__Impl rule__RQualified__Group__1 ;
    public final void rule__RQualified__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:6994:1: ( rule__RQualified__Group__0__Impl rule__RQualified__Group__1 )
            // InternalAle.g:6995:2: rule__RQualified__Group__0__Impl rule__RQualified__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalAle.g:7002:1: rule__RQualified__Group__0__Impl : ( RULE_IDENT ) ;
    public final void rule__RQualified__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7006:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7007:1: ( RULE_IDENT )
            {
            // InternalAle.g:7007:1: ( RULE_IDENT )
            // InternalAle.g:7008:2: RULE_IDENT
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
    // InternalAle.g:7017:1: rule__RQualified__Group__1 : rule__RQualified__Group__1__Impl ;
    public final void rule__RQualified__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7021:1: ( rule__RQualified__Group__1__Impl )
            // InternalAle.g:7022:2: rule__RQualified__Group__1__Impl
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
    // InternalAle.g:7028:1: rule__RQualified__Group__1__Impl : ( ( rule__RQualified__Group_1__0 )* ) ;
    public final void rule__RQualified__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7032:1: ( ( ( rule__RQualified__Group_1__0 )* ) )
            // InternalAle.g:7033:1: ( ( rule__RQualified__Group_1__0 )* )
            {
            // InternalAle.g:7033:1: ( ( rule__RQualified__Group_1__0 )* )
            // InternalAle.g:7034:2: ( rule__RQualified__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRQualifiedAccess().getGroup_1()); 
            }
            // InternalAle.g:7035:2: ( rule__RQualified__Group_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==49) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalAle.g:7035:3: rule__RQualified__Group_1__0
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
    // InternalAle.g:7044:1: rule__RQualified__Group_1__0 : rule__RQualified__Group_1__0__Impl rule__RQualified__Group_1__1 ;
    public final void rule__RQualified__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7048:1: ( rule__RQualified__Group_1__0__Impl rule__RQualified__Group_1__1 )
            // InternalAle.g:7049:2: rule__RQualified__Group_1__0__Impl rule__RQualified__Group_1__1
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
    // InternalAle.g:7056:1: rule__RQualified__Group_1__0__Impl : ( '.' ) ;
    public final void rule__RQualified__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7060:1: ( ( '.' ) )
            // InternalAle.g:7061:1: ( '.' )
            {
            // InternalAle.g:7061:1: ( '.' )
            // InternalAle.g:7062:2: '.'
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
    // InternalAle.g:7071:1: rule__RQualified__Group_1__1 : rule__RQualified__Group_1__1__Impl ;
    public final void rule__RQualified__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7075:1: ( rule__RQualified__Group_1__1__Impl )
            // InternalAle.g:7076:2: rule__RQualified__Group_1__1__Impl
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
    // InternalAle.g:7082:1: rule__RQualified__Group_1__1__Impl : ( RULE_IDENT ) ;
    public final void rule__RQualified__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7086:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7087:1: ( RULE_IDENT )
            {
            // InternalAle.g:7087:1: ( RULE_IDENT )
            // InternalAle.g:7088:2: RULE_IDENT
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
    // InternalAle.g:7098:1: rule__RRoot__XtendedClassesAssignment_5 : ( rulerClass ) ;
    public final void rule__RRoot__XtendedClassesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7102:1: ( ( rulerClass ) )
            // InternalAle.g:7103:2: ( rulerClass )
            {
            // InternalAle.g:7103:2: ( rulerClass )
            // InternalAle.g:7104:3: rulerClass
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


    // $ANTLR start "rule__ROpenClass__NameAssignment_2"
    // InternalAle.g:7113:1: rule__ROpenClass__NameAssignment_2 : ( rulerQualified ) ;
    public final void rule__ROpenClass__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7117:1: ( ( rulerQualified ) )
            // InternalAle.g:7118:2: ( rulerQualified )
            {
            // InternalAle.g:7118:2: ( rulerQualified )
            // InternalAle.g:7119:3: rulerQualified
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
    // InternalAle.g:7128:1: rule__ROpenClass__AttributesAssignment_5 : ( rulerAttribute ) ;
    public final void rule__ROpenClass__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7132:1: ( ( rulerAttribute ) )
            // InternalAle.g:7133:2: ( rulerAttribute )
            {
            // InternalAle.g:7133:2: ( rulerAttribute )
            // InternalAle.g:7134:3: rulerAttribute
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
    // InternalAle.g:7143:1: rule__ROpenClass__OperationsAssignment_6 : ( rulerOperation ) ;
    public final void rule__ROpenClass__OperationsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7147:1: ( ( rulerOperation ) )
            // InternalAle.g:7148:2: ( rulerOperation )
            {
            // InternalAle.g:7148:2: ( rulerOperation )
            // InternalAle.g:7149:3: rulerOperation
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
    // InternalAle.g:7158:1: rule__RNewClass__NameAssignment_1 : ( RULE_IDENT ) ;
    public final void rule__RNewClass__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7162:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7163:2: ( RULE_IDENT )
            {
            // InternalAle.g:7163:2: ( RULE_IDENT )
            // InternalAle.g:7164:3: RULE_IDENT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRNewClassAccess().getNameIdentTerminalRuleCall_1_0()); 
            }
            match(input,RULE_IDENT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRNewClassAccess().getNameIdentTerminalRuleCall_1_0()); 
            }

            }


            }

        }
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
    // InternalAle.g:7173:1: rule__RNewClass__AttributesAssignment_3 : ( rulerAttribute ) ;
    public final void rule__RNewClass__AttributesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7177:1: ( ( rulerAttribute ) )
            // InternalAle.g:7178:2: ( rulerAttribute )
            {
            // InternalAle.g:7178:2: ( rulerAttribute )
            // InternalAle.g:7179:3: rulerAttribute
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
    // InternalAle.g:7188:1: rule__RNewClass__OperationsAssignment_4 : ( rulerOperation ) ;
    public final void rule__RNewClass__OperationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7192:1: ( ( rulerOperation ) )
            // InternalAle.g:7193:2: ( rulerOperation )
            {
            // InternalAle.g:7193:2: ( rulerOperation )
            // InternalAle.g:7194:3: rulerOperation
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
    // InternalAle.g:7203:1: rule__ROperation__TypeAssignment_2 : ( rulerType ) ;
    public final void rule__ROperation__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7207:1: ( ( rulerType ) )
            // InternalAle.g:7208:2: ( rulerType )
            {
            // InternalAle.g:7208:2: ( rulerType )
            // InternalAle.g:7209:3: rulerType
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
    // InternalAle.g:7218:1: rule__ROperation__NameAssignment_3 : ( RULE_IDENT ) ;
    public final void rule__ROperation__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7222:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7223:2: ( RULE_IDENT )
            {
            // InternalAle.g:7223:2: ( RULE_IDENT )
            // InternalAle.g:7224:3: RULE_IDENT
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
    // InternalAle.g:7233:1: rule__ROperation__ParamListAssignment_5 : ( rulerParameters ) ;
    public final void rule__ROperation__ParamListAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7237:1: ( ( rulerParameters ) )
            // InternalAle.g:7238:2: ( rulerParameters )
            {
            // InternalAle.g:7238:2: ( rulerParameters )
            // InternalAle.g:7239:3: rulerParameters
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
    // InternalAle.g:7248:1: rule__ROperation__BodyAssignment_7 : ( rulerBlock ) ;
    public final void rule__ROperation__BodyAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7252:1: ( ( rulerBlock ) )
            // InternalAle.g:7253:2: ( rulerBlock )
            {
            // InternalAle.g:7253:2: ( rulerBlock )
            // InternalAle.g:7254:3: rulerBlock
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
    // InternalAle.g:7263:1: rule__RParameters__ParamsAssignment_0 : ( rulerVariable ) ;
    public final void rule__RParameters__ParamsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7267:1: ( ( rulerVariable ) )
            // InternalAle.g:7268:2: ( rulerVariable )
            {
            // InternalAle.g:7268:2: ( rulerVariable )
            // InternalAle.g:7269:3: rulerVariable
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
    // InternalAle.g:7278:1: rule__RParameters__ParamsAssignment_1_1 : ( rulerVariable ) ;
    public final void rule__RParameters__ParamsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7282:1: ( ( rulerVariable ) )
            // InternalAle.g:7283:2: ( rulerVariable )
            {
            // InternalAle.g:7283:2: ( rulerVariable )
            // InternalAle.g:7284:3: rulerVariable
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
    // InternalAle.g:7293:1: rule__RVariable__TypeAssignment_0 : ( rulerType ) ;
    public final void rule__RVariable__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7297:1: ( ( rulerType ) )
            // InternalAle.g:7298:2: ( rulerType )
            {
            // InternalAle.g:7298:2: ( rulerType )
            // InternalAle.g:7299:3: rulerType
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
    // InternalAle.g:7308:1: rule__RVariable__NameAssignment_1 : ( RULE_IDENT ) ;
    public final void rule__RVariable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7312:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7313:2: ( RULE_IDENT )
            {
            // InternalAle.g:7313:2: ( RULE_IDENT )
            // InternalAle.g:7314:3: RULE_IDENT
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
    // InternalAle.g:7323:1: rule__RAttribute__TypeAssignment_0 : ( rulerType ) ;
    public final void rule__RAttribute__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7327:1: ( ( rulerType ) )
            // InternalAle.g:7328:2: ( rulerType )
            {
            // InternalAle.g:7328:2: ( rulerType )
            // InternalAle.g:7329:3: rulerType
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
    // InternalAle.g:7338:1: rule__RAttribute__NameAssignment_1 : ( RULE_IDENT ) ;
    public final void rule__RAttribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAle.g:7342:1: ( ( RULE_IDENT ) )
            // InternalAle.g:7343:2: ( RULE_IDENT )
            {
            // InternalAle.g:7343:2: ( RULE_IDENT )
            // InternalAle.g:7344:3: RULE_IDENT
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

    // $ANTLR start synpred4_InternalAle
    public final void synpred4_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:1025:2: ( ( rulerVarDecl ) )
        // InternalAle.g:1025:2: ( rulerVarDecl )
        {
        // InternalAle.g:1025:2: ( rulerVarDecl )
        // InternalAle.g:1026:3: rulerVarDecl
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRStatementAccess().getRVarDeclParserRuleCall_0()); 
        }
        pushFollow(FOLLOW_2);
        rulerVarDecl();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalAle

    // $ANTLR start synpred5_InternalAle
    public final void synpred5_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:1031:2: ( ( rulerAssign ) )
        // InternalAle.g:1031:2: ( rulerAssign )
        {
        // InternalAle.g:1031:2: ( rulerAssign )
        // InternalAle.g:1032:3: rulerAssign
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRStatementAccess().getRAssignParserRuleCall_1()); 
        }
        pushFollow(FOLLOW_2);
        rulerAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalAle

    // $ANTLR start synpred8_InternalAle
    public final void synpred8_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:1049:2: ( ( rulerIf ) )
        // InternalAle.g:1049:2: ( rulerIf )
        {
        // InternalAle.g:1049:2: ( rulerIf )
        // InternalAle.g:1050:3: rulerIf
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRStatementAccess().getRIfParserRuleCall_4()); 
        }
        pushFollow(FOLLOW_2);
        rulerIf();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalAle

    // $ANTLR start synpred80_InternalAle
    public final void synpred80_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:4308:3: ( rulerecExpression )
        // InternalAle.g:4308:3: rulerecExpression
        {
        pushFollow(FOLLOW_2);
        rulerecExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_InternalAle

    // $ANTLR start synpred81_InternalAle
    public final void synpred81_InternalAle_fragment() throws RecognitionException {   
        // InternalAle.g:4362:3: ( rulerecExpression )
        // InternalAle.g:4362:3: rulerecExpression
        {
        pushFollow(FOLLOW_2);
        rulerecExpression();

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
            return "1020:1: rule__RStatement__Alternatives : ( ( rulerVarDecl ) | ( rulerAssign ) | ( rulerForEach ) | ( rulerWhile ) | ( rulerIf ) | ( rulerExpression ) );";
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
            return "1389:1: rule__Literal__Alternatives : ( ( RULE_STRING ) | ( RULE_INT ) | ( RULE_REAL ) | ( 'true' ) | ( 'false' ) | ( 'null' ) | ( ( rule__Literal__Group_6__0 ) ) | ( ( rule__Literal__Group_7__0 ) ) | ( ( rule__Literal__Group_8__0 ) ) | ( ( rule__Literal__Group_9__0 ) ) | ( ruletypeLiteral ) );";
        }
    }
    static final String dfa_14s = "\24\uffff";
    static final String dfa_15s = "\1\22\23\uffff";
    static final String dfa_16s = "\1\10\21\0\2\uffff";
    static final String dfa_17s = "\1\113\21\0\2\uffff";
    static final String dfa_18s = "\22\uffff\1\2\1\1";
    static final String dfa_19s = "\1\uffff\1\7\1\13\1\11\1\6\1\14\1\12\1\4\1\20\1\10\1\5\1\16\1\15\1\17\1\0\1\1\1\2\1\3\2\uffff}>";
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
            return "4308:2: ( rulerecExpression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_14 = input.LA(1);

                         
                        int index35_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_14);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_15 = input.LA(1);

                         
                        int index35_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_16 = input.LA(1);

                         
                        int index35_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_16);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA35_17 = input.LA(1);

                         
                        int index35_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_17);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA35_7 = input.LA(1);

                         
                        int index35_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA35_10 = input.LA(1);

                         
                        int index35_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA35_4 = input.LA(1);

                         
                        int index35_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA35_1 = input.LA(1);

                         
                        int index35_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_1);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA35_9 = input.LA(1);

                         
                        int index35_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA35_3 = input.LA(1);

                         
                        int index35_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA35_6 = input.LA(1);

                         
                        int index35_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_6);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA35_2 = input.LA(1);

                         
                        int index35_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_2);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA35_5 = input.LA(1);

                         
                        int index35_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_5);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA35_12 = input.LA(1);

                         
                        int index35_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_12);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA35_11 = input.LA(1);

                         
                        int index35_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_11);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA35_13 = input.LA(1);

                         
                        int index35_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_13);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA35_8 = input.LA(1);

                         
                        int index35_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_8);
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
            return "4362:2: ( rulerecExpression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_14 = input.LA(1);

                         
                        int index36_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_14);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_15 = input.LA(1);

                         
                        int index36_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_16 = input.LA(1);

                         
                        int index36_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_16);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA36_17 = input.LA(1);

                         
                        int index36_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_17);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA36_7 = input.LA(1);

                         
                        int index36_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA36_10 = input.LA(1);

                         
                        int index36_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA36_4 = input.LA(1);

                         
                        int index36_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA36_1 = input.LA(1);

                         
                        int index36_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_1);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA36_9 = input.LA(1);

                         
                        int index36_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA36_3 = input.LA(1);

                         
                        int index36_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA36_6 = input.LA(1);

                         
                        int index36_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_6);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA36_2 = input.LA(1);

                         
                        int index36_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_2);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA36_5 = input.LA(1);

                         
                        int index36_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_5);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA36_12 = input.LA(1);

                         
                        int index36_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_12);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA36_11 = input.LA(1);

                         
                        int index36_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_11);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA36_13 = input.LA(1);

                         
                        int index36_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_13);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA36_8 = input.LA(1);

                         
                        int index36_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_InternalAle()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index36_8);
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
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x04300F0000018010L,0x00000000000C0000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00100F0000000012L,0x00000000000C0000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0400000000018002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0400000000018000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00100F0000000010L,0x00000000000C0000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x02100F0000000010L,0x00000000000C0000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0800200000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x01100FE0000400F0L,0x00000000000D9202L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x41100FE0000400F0L,0x00000000000D9202L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x11300FE0000400F0L,0x00000000000D920AL});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x11100FE0000400F0L,0x00000000000D920AL});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x11100FE0000400F2L,0x00000000000D920AL});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0002000007FE0100L,0x00000000000001F0L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000001FF8000010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x2080000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000800000L,0x0000000000002000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000006000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0020000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0002000000000000L});

}