package fr.supelec.tesl.lang.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.supelec.tesl.lang.services.TESLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTESLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_BIG_INT", "RULE_BIG_DECIMAL", "RULE_FLOAT", "RULE_RATIONAL", "RULE_STRING", "RULE_DIGIT", "RULE_SIGN", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'nongreedy'", "'periodic'", "'offset'", "'sporadic'", "','", "'implies'", "'await'", "'with'", "'weak'", "'strong'", "'reset'", "'on'", "'filtered'", "'by'", "'every'", "'starting'", "'at'", "'immediately'", "'delayed'", "'sustained'", "'from'", "'to'", "'weakly'", "'time'", "'immediate'", "'let'", "'='", "'$'", "'('", "')'", "'[int '", "']'", "'[float '", "'[double'", "'[decimal'", "'[rational '", "'when'", "'not'", "'strictly'", "'next'", "'*'", "'tag'", "'relation'", "'^'", "'+'", "'@stop'", "'@tagref'", "'@trace'", "'@maxstep'", "'@output'", "'vcd'", "'tikz'", "'svg'", "'select'", "'label'", "'if'", "'xscale'", "'border'", "'css'", "'no-default-css'", "'javascript'", "'standalone'", "'overwrite'", "'->'", "'@doublecalc'", "'digits'", "'@dumpres'", "'U-clock'", "'unit-clock'", "'Z-clock'", "'int-clock'", "'D-clock'", "'decimal-clock'", "'Q-clock'", "'rational-clock'", "'F-clock'", "'float-clock'", "'double-clock'", "'int'", "'decimal'", "'rational'", "'double'", "'float'", "'-'", "'/'", "'round_up'", "'round_down'", "'round_ceil'", "'round_floor'", "'round_half_up'", "'round_half_down'", "'round_half_even'"
    };
    public static final int T__50=50;
    public static final int RULE_SIGN=11;
    public static final int RULE_BIG_INT=5;
    public static final int T__59=59;
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
    public static final int RULE_ID=4;
    public static final int RULE_DIGIT=10;
    public static final int RULE_RATIONAL=8;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_EXPONENT=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=7;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=9;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int RULE_BIG_DECIMAL=6;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=15;
    public static final int RULE_ANY_OTHER=16;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalTESLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTESLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTESLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTESL.g"; }



     	private TESLGrammarAccess grammarAccess;
     	
        public InternalTESLParser(TokenStream input, TESLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Specification";	
       	}
       	
       	@Override
       	protected TESLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSpecification"
    // InternalTESL.g:68:1: entryRuleSpecification returns [EObject current=null] : iv_ruleSpecification= ruleSpecification EOF ;
    public final EObject entryRuleSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecification = null;


        try {
            // InternalTESL.g:69:2: (iv_ruleSpecification= ruleSpecification EOF )
            // InternalTESL.g:70:2: iv_ruleSpecification= ruleSpecification EOF
            {
             newCompositeNode(grammarAccess.getSpecificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecification=ruleSpecification();

            state._fsp--;

             current =iv_ruleSpecification; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSpecification"


    // $ANTLR start "ruleSpecification"
    // InternalTESL.g:77:1: ruleSpecification returns [EObject current=null] : ( ( (lv_decl_0_0= ruleClock ) ) | ( (lv_rel_1_0= ruleRelation ) ) | ( (lv_let_2_0= ruleLet ) ) | ( (lv_pragmas_3_0= rulePragma ) ) )* ;
    public final EObject ruleSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_decl_0_0 = null;

        EObject lv_rel_1_0 = null;

        EObject lv_let_2_0 = null;

        EObject lv_pragmas_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:80:28: ( ( ( (lv_decl_0_0= ruleClock ) ) | ( (lv_rel_1_0= ruleRelation ) ) | ( (lv_let_2_0= ruleLet ) ) | ( (lv_pragmas_3_0= rulePragma ) ) )* )
            // InternalTESL.g:81:1: ( ( (lv_decl_0_0= ruleClock ) ) | ( (lv_rel_1_0= ruleRelation ) ) | ( (lv_let_2_0= ruleLet ) ) | ( (lv_pragmas_3_0= rulePragma ) ) )*
            {
            // InternalTESL.g:81:1: ( ( (lv_decl_0_0= ruleClock ) ) | ( (lv_rel_1_0= ruleRelation ) ) | ( (lv_let_2_0= ruleLet ) ) | ( (lv_pragmas_3_0= rulePragma ) ) )*
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case 17:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                    {
                    alt1=1;
                    }
                    break;
                case RULE_ID:
                case 23:
                case 40:
                case 58:
                    {
                    alt1=2;
                    }
                    break;
                case 42:
                    {
                    alt1=3;
                    }
                    break;
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 81:
                case 83:
                    {
                    alt1=4;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // InternalTESL.g:81:2: ( (lv_decl_0_0= ruleClock ) )
            	    {
            	    // InternalTESL.g:81:2: ( (lv_decl_0_0= ruleClock ) )
            	    // InternalTESL.g:82:1: (lv_decl_0_0= ruleClock )
            	    {
            	    // InternalTESL.g:82:1: (lv_decl_0_0= ruleClock )
            	    // InternalTESL.g:83:3: lv_decl_0_0= ruleClock
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSpecificationAccess().getDeclClockParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_decl_0_0=ruleClock();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"decl",
            	            		lv_decl_0_0, 
            	            		"fr.supelec.tesl.lang.TESL.Clock");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTESL.g:100:6: ( (lv_rel_1_0= ruleRelation ) )
            	    {
            	    // InternalTESL.g:100:6: ( (lv_rel_1_0= ruleRelation ) )
            	    // InternalTESL.g:101:1: (lv_rel_1_0= ruleRelation )
            	    {
            	    // InternalTESL.g:101:1: (lv_rel_1_0= ruleRelation )
            	    // InternalTESL.g:102:3: lv_rel_1_0= ruleRelation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSpecificationAccess().getRelRelationParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_rel_1_0=ruleRelation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rel",
            	            		lv_rel_1_0, 
            	            		"fr.supelec.tesl.lang.TESL.Relation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTESL.g:119:6: ( (lv_let_2_0= ruleLet ) )
            	    {
            	    // InternalTESL.g:119:6: ( (lv_let_2_0= ruleLet ) )
            	    // InternalTESL.g:120:1: (lv_let_2_0= ruleLet )
            	    {
            	    // InternalTESL.g:120:1: (lv_let_2_0= ruleLet )
            	    // InternalTESL.g:121:3: lv_let_2_0= ruleLet
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSpecificationAccess().getLetLetParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_let_2_0=ruleLet();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"let",
            	            		lv_let_2_0, 
            	            		"fr.supelec.tesl.lang.TESL.Let");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTESL.g:138:6: ( (lv_pragmas_3_0= rulePragma ) )
            	    {
            	    // InternalTESL.g:138:6: ( (lv_pragmas_3_0= rulePragma ) )
            	    // InternalTESL.g:139:1: (lv_pragmas_3_0= rulePragma )
            	    {
            	    // InternalTESL.g:139:1: (lv_pragmas_3_0= rulePragma )
            	    // InternalTESL.g:140:3: lv_pragmas_3_0= rulePragma
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSpecificationAccess().getPragmasPragmaParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_pragmas_3_0=rulePragma();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"pragmas",
            	            		lv_pragmas_3_0, 
            	            		"fr.supelec.tesl.lang.TESL.Pragma");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecification"


    // $ANTLR start "entryRuleClock"
    // InternalTESL.g:164:1: entryRuleClock returns [EObject current=null] : iv_ruleClock= ruleClock EOF ;
    public final EObject entryRuleClock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClock = null;


        try {
            // InternalTESL.g:165:2: (iv_ruleClock= ruleClock EOF )
            // InternalTESL.g:166:2: iv_ruleClock= ruleClock EOF
            {
             newCompositeNode(grammarAccess.getClockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClock=ruleClock();

            state._fsp--;

             current =iv_ruleClock; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleClock"


    // $ANTLR start "ruleClock"
    // InternalTESL.g:173:1: ruleClock returns [EObject current=null] : ( ( (lv_nongreedy_0_0= 'nongreedy' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_qual_3_0= ruleClockQualifier ) )? ) ;
    public final EObject ruleClock() throws RecognitionException {
        EObject current = null;

        Token lv_nongreedy_0_0=null;
        Token lv_name_2_0=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_qual_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:176:28: ( ( ( (lv_nongreedy_0_0= 'nongreedy' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_qual_3_0= ruleClockQualifier ) )? ) )
            // InternalTESL.g:177:1: ( ( (lv_nongreedy_0_0= 'nongreedy' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_qual_3_0= ruleClockQualifier ) )? )
            {
            // InternalTESL.g:177:1: ( ( (lv_nongreedy_0_0= 'nongreedy' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_qual_3_0= ruleClockQualifier ) )? )
            // InternalTESL.g:177:2: ( (lv_nongreedy_0_0= 'nongreedy' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_qual_3_0= ruleClockQualifier ) )?
            {
            // InternalTESL.g:177:2: ( (lv_nongreedy_0_0= 'nongreedy' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTESL.g:178:1: (lv_nongreedy_0_0= 'nongreedy' )
                    {
                    // InternalTESL.g:178:1: (lv_nongreedy_0_0= 'nongreedy' )
                    // InternalTESL.g:179:3: lv_nongreedy_0_0= 'nongreedy'
                    {
                    lv_nongreedy_0_0=(Token)match(input,17,FOLLOW_4); 

                            newLeafNode(lv_nongreedy_0_0, grammarAccess.getClockAccess().getNongreedyNongreedyKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClockRule());
                    	        }
                           		setWithLastConsumed(current, "nongreedy", true, "nongreedy");
                    	    

                    }


                    }
                    break;

            }

            // InternalTESL.g:192:3: ( (lv_type_1_0= ruleType ) )
            // InternalTESL.g:193:1: (lv_type_1_0= ruleType )
            {
            // InternalTESL.g:193:1: (lv_type_1_0= ruleType )
            // InternalTESL.g:194:3: lv_type_1_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getClockAccess().getTypeTypeEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_5);
            lv_type_1_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClockRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"fr.supelec.tesl.lang.TESL.Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTESL.g:210:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalTESL.g:211:1: (lv_name_2_0= RULE_ID )
            {
            // InternalTESL.g:211:1: (lv_name_2_0= RULE_ID )
            // InternalTESL.g:212:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            			newLeafNode(lv_name_2_0, grammarAccess.getClockAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClockRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"fr.supelec.tesl.lang.TESL.ID");
            	    

            }


            }

            // InternalTESL.g:228:2: ( (lv_qual_3_0= ruleClockQualifier ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18||LA3_0==20) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalTESL.g:229:1: (lv_qual_3_0= ruleClockQualifier )
                    {
                    // InternalTESL.g:229:1: (lv_qual_3_0= ruleClockQualifier )
                    // InternalTESL.g:230:3: lv_qual_3_0= ruleClockQualifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getClockAccess().getQualClockQualifierParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_qual_3_0=ruleClockQualifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClockRule());
                    	        }
                           		set(
                           			current, 
                           			"qual",
                            		lv_qual_3_0, 
                            		"fr.supelec.tesl.lang.TESL.ClockQualifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClock"


    // $ANTLR start "entryRuleClockQualifier"
    // InternalTESL.g:254:1: entryRuleClockQualifier returns [EObject current=null] : iv_ruleClockQualifier= ruleClockQualifier EOF ;
    public final EObject entryRuleClockQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClockQualifier = null;


        try {
            // InternalTESL.g:255:2: (iv_ruleClockQualifier= ruleClockQualifier EOF )
            // InternalTESL.g:256:2: iv_ruleClockQualifier= ruleClockQualifier EOF
            {
             newCompositeNode(grammarAccess.getClockQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClockQualifier=ruleClockQualifier();

            state._fsp--;

             current =iv_ruleClockQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleClockQualifier"


    // $ANTLR start "ruleClockQualifier"
    // InternalTESL.g:263:1: ruleClockQualifier returns [EObject current=null] : (this_PeriodicQualifier_0= rulePeriodicQualifier | this_SporadicQualifier_1= ruleSporadicQualifier ) ;
    public final EObject ruleClockQualifier() throws RecognitionException {
        EObject current = null;

        EObject this_PeriodicQualifier_0 = null;

        EObject this_SporadicQualifier_1 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:266:28: ( (this_PeriodicQualifier_0= rulePeriodicQualifier | this_SporadicQualifier_1= ruleSporadicQualifier ) )
            // InternalTESL.g:267:1: (this_PeriodicQualifier_0= rulePeriodicQualifier | this_SporadicQualifier_1= ruleSporadicQualifier )
            {
            // InternalTESL.g:267:1: (this_PeriodicQualifier_0= rulePeriodicQualifier | this_SporadicQualifier_1= ruleSporadicQualifier )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            else if ( (LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalTESL.g:268:5: this_PeriodicQualifier_0= rulePeriodicQualifier
                    {
                     
                            newCompositeNode(grammarAccess.getClockQualifierAccess().getPeriodicQualifierParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_PeriodicQualifier_0=rulePeriodicQualifier();

                    state._fsp--;

                     
                            current = this_PeriodicQualifier_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTESL.g:278:5: this_SporadicQualifier_1= ruleSporadicQualifier
                    {
                     
                            newCompositeNode(grammarAccess.getClockQualifierAccess().getSporadicQualifierParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SporadicQualifier_1=ruleSporadicQualifier();

                    state._fsp--;

                     
                            current = this_SporadicQualifier_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClockQualifier"


    // $ANTLR start "entryRulePeriodicQualifier"
    // InternalTESL.g:294:1: entryRulePeriodicQualifier returns [EObject current=null] : iv_rulePeriodicQualifier= rulePeriodicQualifier EOF ;
    public final EObject entryRulePeriodicQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePeriodicQualifier = null;


        try {
            // InternalTESL.g:295:2: (iv_rulePeriodicQualifier= rulePeriodicQualifier EOF )
            // InternalTESL.g:296:2: iv_rulePeriodicQualifier= rulePeriodicQualifier EOF
            {
             newCompositeNode(grammarAccess.getPeriodicQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePeriodicQualifier=rulePeriodicQualifier();

            state._fsp--;

             current =iv_rulePeriodicQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePeriodicQualifier"


    // $ANTLR start "rulePeriodicQualifier"
    // InternalTESL.g:303:1: rulePeriodicQualifier returns [EObject current=null] : (otherlv_0= 'periodic' ( (lv_period_1_0= ruleExpression ) ) (otherlv_2= 'offset' ( (lv_offset_3_0= ruleExpression ) ) )? ) ;
    public final EObject rulePeriodicQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_period_1_0 = null;

        EObject lv_offset_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:306:28: ( (otherlv_0= 'periodic' ( (lv_period_1_0= ruleExpression ) ) (otherlv_2= 'offset' ( (lv_offset_3_0= ruleExpression ) ) )? ) )
            // InternalTESL.g:307:1: (otherlv_0= 'periodic' ( (lv_period_1_0= ruleExpression ) ) (otherlv_2= 'offset' ( (lv_offset_3_0= ruleExpression ) ) )? )
            {
            // InternalTESL.g:307:1: (otherlv_0= 'periodic' ( (lv_period_1_0= ruleExpression ) ) (otherlv_2= 'offset' ( (lv_offset_3_0= ruleExpression ) ) )? )
            // InternalTESL.g:307:3: otherlv_0= 'periodic' ( (lv_period_1_0= ruleExpression ) ) (otherlv_2= 'offset' ( (lv_offset_3_0= ruleExpression ) ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getPeriodicQualifierAccess().getPeriodicKeyword_0());
                
            // InternalTESL.g:311:1: ( (lv_period_1_0= ruleExpression ) )
            // InternalTESL.g:312:1: (lv_period_1_0= ruleExpression )
            {
            // InternalTESL.g:312:1: (lv_period_1_0= ruleExpression )
            // InternalTESL.g:313:3: lv_period_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getPeriodicQualifierAccess().getPeriodExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_8);
            lv_period_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPeriodicQualifierRule());
            	        }
                   		set(
                   			current, 
                   			"period",
                    		lv_period_1_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTESL.g:329:2: (otherlv_2= 'offset' ( (lv_offset_3_0= ruleExpression ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTESL.g:329:4: otherlv_2= 'offset' ( (lv_offset_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_7); 

                        	newLeafNode(otherlv_2, grammarAccess.getPeriodicQualifierAccess().getOffsetKeyword_2_0());
                        
                    // InternalTESL.g:333:1: ( (lv_offset_3_0= ruleExpression ) )
                    // InternalTESL.g:334:1: (lv_offset_3_0= ruleExpression )
                    {
                    // InternalTESL.g:334:1: (lv_offset_3_0= ruleExpression )
                    // InternalTESL.g:335:3: lv_offset_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPeriodicQualifierAccess().getOffsetExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_offset_3_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPeriodicQualifierRule());
                    	        }
                           		set(
                           			current, 
                           			"offset",
                            		lv_offset_3_0, 
                            		"fr.supelec.tesl.lang.TESL.Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePeriodicQualifier"


    // $ANTLR start "entryRuleSporadicQualifier"
    // InternalTESL.g:359:1: entryRuleSporadicQualifier returns [EObject current=null] : iv_ruleSporadicQualifier= ruleSporadicQualifier EOF ;
    public final EObject entryRuleSporadicQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSporadicQualifier = null;


        try {
            // InternalTESL.g:360:2: (iv_ruleSporadicQualifier= ruleSporadicQualifier EOF )
            // InternalTESL.g:361:2: iv_ruleSporadicQualifier= ruleSporadicQualifier EOF
            {
             newCompositeNode(grammarAccess.getSporadicQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSporadicQualifier=ruleSporadicQualifier();

            state._fsp--;

             current =iv_ruleSporadicQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSporadicQualifier"


    // $ANTLR start "ruleSporadicQualifier"
    // InternalTESL.g:368:1: ruleSporadicQualifier returns [EObject current=null] : ( () otherlv_1= 'sporadic' ( ( (lv_instants_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_instants_4_0= ruleExpression ) ) )* )? ) ;
    public final EObject ruleSporadicQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_instants_2_0 = null;

        EObject lv_instants_4_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:371:28: ( ( () otherlv_1= 'sporadic' ( ( (lv_instants_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_instants_4_0= ruleExpression ) ) )* )? ) )
            // InternalTESL.g:372:1: ( () otherlv_1= 'sporadic' ( ( (lv_instants_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_instants_4_0= ruleExpression ) ) )* )? )
            {
            // InternalTESL.g:372:1: ( () otherlv_1= 'sporadic' ( ( (lv_instants_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_instants_4_0= ruleExpression ) ) )* )? )
            // InternalTESL.g:372:2: () otherlv_1= 'sporadic' ( ( (lv_instants_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_instants_4_0= ruleExpression ) ) )* )?
            {
            // InternalTESL.g:372:2: ()
            // InternalTESL.g:373:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSporadicQualifierAccess().getSporadicQualifierAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getSporadicQualifierAccess().getSporadicKeyword_1());
                
            // InternalTESL.g:382:1: ( ( (lv_instants_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_instants_4_0= ruleExpression ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_BIG_INT && LA7_0<=RULE_RATIONAL)||LA7_0==44||LA7_0==61||LA7_0==100) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalTESL.g:382:2: ( (lv_instants_2_0= ruleValue ) ) (otherlv_3= ',' ( (lv_instants_4_0= ruleExpression ) ) )*
                    {
                    // InternalTESL.g:382:2: ( (lv_instants_2_0= ruleValue ) )
                    // InternalTESL.g:383:1: (lv_instants_2_0= ruleValue )
                    {
                    // InternalTESL.g:383:1: (lv_instants_2_0= ruleValue )
                    // InternalTESL.g:384:3: lv_instants_2_0= ruleValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getSporadicQualifierAccess().getInstantsValueParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_10);
                    lv_instants_2_0=ruleValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSporadicQualifierRule());
                    	        }
                           		add(
                           			current, 
                           			"instants",
                            		lv_instants_2_0, 
                            		"fr.supelec.tesl.lang.TESL.Value");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalTESL.g:400:2: (otherlv_3= ',' ( (lv_instants_4_0= ruleExpression ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==21) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalTESL.g:400:4: otherlv_3= ',' ( (lv_instants_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_7); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getSporadicQualifierAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalTESL.g:404:1: ( (lv_instants_4_0= ruleExpression ) )
                    	    // InternalTESL.g:405:1: (lv_instants_4_0= ruleExpression )
                    	    {
                    	    // InternalTESL.g:405:1: (lv_instants_4_0= ruleExpression )
                    	    // InternalTESL.g:406:3: lv_instants_4_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSporadicQualifierAccess().getInstantsExpressionParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_10);
                    	    lv_instants_4_0=ruleExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSporadicQualifierRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"instants",
                    	            		lv_instants_4_0, 
                    	            		"fr.supelec.tesl.lang.TESL.Expression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


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


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSporadicQualifier"


    // $ANTLR start "entryRuleRelation"
    // InternalTESL.g:430:1: entryRuleRelation returns [EObject current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final EObject entryRuleRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelation = null;


        try {
            // InternalTESL.g:431:2: (iv_ruleRelation= ruleRelation EOF )
            // InternalTESL.g:432:2: iv_ruleRelation= ruleRelation EOF
            {
             newCompositeNode(grammarAccess.getRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelation=ruleRelation();

            state._fsp--;

             current =iv_ruleRelation; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRelation"


    // $ANTLR start "ruleRelation"
    // InternalTESL.g:439:1: ruleRelation returns [EObject current=null] : (this_ImplicationRelation_0= ruleImplicationRelation | this_TagRelation_1= ruleTagRelation | this_AwaitImplication_2= ruleAwaitImplication ) ;
    public final EObject ruleRelation() throws RecognitionException {
        EObject current = null;

        EObject this_ImplicationRelation_0 = null;

        EObject this_TagRelation_1 = null;

        EObject this_AwaitImplication_2 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:442:28: ( (this_ImplicationRelation_0= ruleImplicationRelation | this_TagRelation_1= ruleTagRelation | this_AwaitImplication_2= ruleAwaitImplication ) )
            // InternalTESL.g:443:1: (this_ImplicationRelation_0= ruleImplicationRelation | this_TagRelation_1= ruleTagRelation | this_AwaitImplication_2= ruleAwaitImplication )
            {
            // InternalTESL.g:443:1: (this_ImplicationRelation_0= ruleImplicationRelation | this_TagRelation_1= ruleTagRelation | this_AwaitImplication_2= ruleAwaitImplication )
            int alt8=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case 40:
            case 58:
                {
                alt8=2;
                }
                break;
            case 23:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalTESL.g:444:5: this_ImplicationRelation_0= ruleImplicationRelation
                    {
                     
                            newCompositeNode(grammarAccess.getRelationAccess().getImplicationRelationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ImplicationRelation_0=ruleImplicationRelation();

                    state._fsp--;

                     
                            current = this_ImplicationRelation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTESL.g:454:5: this_TagRelation_1= ruleTagRelation
                    {
                     
                            newCompositeNode(grammarAccess.getRelationAccess().getTagRelationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TagRelation_1=ruleTagRelation();

                    state._fsp--;

                     
                            current = this_TagRelation_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalTESL.g:464:5: this_AwaitImplication_2= ruleAwaitImplication
                    {
                     
                            newCompositeNode(grammarAccess.getRelationAccess().getAwaitImplicationParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_AwaitImplication_2=ruleAwaitImplication();

                    state._fsp--;

                     
                            current = this_AwaitImplication_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelation"


    // $ANTLR start "entryRuleImplicationRelation"
    // InternalTESL.g:480:1: entryRuleImplicationRelation returns [EObject current=null] : iv_ruleImplicationRelation= ruleImplicationRelation EOF ;
    public final EObject entryRuleImplicationRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationRelation = null;


        try {
            // InternalTESL.g:481:2: (iv_ruleImplicationRelation= ruleImplicationRelation EOF )
            // InternalTESL.g:482:2: iv_ruleImplicationRelation= ruleImplicationRelation EOF
            {
             newCompositeNode(grammarAccess.getImplicationRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImplicationRelation=ruleImplicationRelation();

            state._fsp--;

             current =iv_ruleImplicationRelation; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleImplicationRelation"


    // $ANTLR start "ruleImplicationRelation"
    // InternalTESL.g:489:1: ruleImplicationRelation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_qual_1_0= ruleImplicationQualifier ) )? otherlv_2= 'implies' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleImplicationRelation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_qual_1_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:492:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_qual_1_0= ruleImplicationQualifier ) )? otherlv_2= 'implies' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalTESL.g:493:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_qual_1_0= ruleImplicationQualifier ) )? otherlv_2= 'implies' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalTESL.g:493:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_qual_1_0= ruleImplicationQualifier ) )? otherlv_2= 'implies' ( (otherlv_3= RULE_ID ) ) )
            // InternalTESL.g:493:2: ( (otherlv_0= RULE_ID ) ) ( (lv_qual_1_0= ruleImplicationQualifier ) )? otherlv_2= 'implies' ( (otherlv_3= RULE_ID ) )
            {
            // InternalTESL.g:493:2: ( (otherlv_0= RULE_ID ) )
            // InternalTESL.g:494:1: (otherlv_0= RULE_ID )
            {
            // InternalTESL.g:494:1: (otherlv_0= RULE_ID )
            // InternalTESL.g:495:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getImplicationRelationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            		newLeafNode(otherlv_0, grammarAccess.getImplicationRelationAccess().getSourceClockCrossReference_0_0()); 
            	

            }


            }

            // InternalTESL.g:506:2: ( (lv_qual_1_0= ruleImplicationQualifier ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==29||LA9_0==31||(LA9_0>=34 && LA9_0<=36)||LA9_0==40||LA9_0==53||(LA9_0>=55 && LA9_0<=56)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTESL.g:507:1: (lv_qual_1_0= ruleImplicationQualifier )
                    {
                    // InternalTESL.g:507:1: (lv_qual_1_0= ruleImplicationQualifier )
                    // InternalTESL.g:508:3: lv_qual_1_0= ruleImplicationQualifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getImplicationRelationAccess().getQualImplicationQualifierParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_12);
                    lv_qual_1_0=ruleImplicationQualifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImplicationRelationRule());
                    	        }
                           		set(
                           			current, 
                           			"qual",
                            		lv_qual_1_0, 
                            		"fr.supelec.tesl.lang.TESL.ImplicationQualifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,22,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getImplicationRelationAccess().getImpliesKeyword_2());
                
            // InternalTESL.g:528:1: ( (otherlv_3= RULE_ID ) )
            // InternalTESL.g:529:1: (otherlv_3= RULE_ID )
            {
            // InternalTESL.g:529:1: (otherlv_3= RULE_ID )
            // InternalTESL.g:530:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getImplicationRelationRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_3, grammarAccess.getImplicationRelationAccess().getTargetClockCrossReference_3_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplicationRelation"


    // $ANTLR start "entryRuleAwaitImplication"
    // InternalTESL.g:549:1: entryRuleAwaitImplication returns [EObject current=null] : iv_ruleAwaitImplication= ruleAwaitImplication EOF ;
    public final EObject entryRuleAwaitImplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAwaitImplication = null;


        try {
            // InternalTESL.g:550:2: (iv_ruleAwaitImplication= ruleAwaitImplication EOF )
            // InternalTESL.g:551:2: iv_ruleAwaitImplication= ruleAwaitImplication EOF
            {
             newCompositeNode(grammarAccess.getAwaitImplicationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAwaitImplication=ruleAwaitImplication();

            state._fsp--;

             current =iv_ruleAwaitImplication; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAwaitImplication"


    // $ANTLR start "ruleAwaitImplication"
    // InternalTESL.g:558:1: ruleAwaitImplication returns [EObject current=null] : (otherlv_0= 'await' ( (otherlv_1= RULE_ID ) )+ (otherlv_2= 'with' ( ( (lv_weak_3_0= 'weak' ) ) | ( (lv_strong_4_0= 'strong' ) ) ) otherlv_5= 'reset' otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= 'implies' ( (otherlv_9= RULE_ID ) ) ) ;
    public final EObject ruleAwaitImplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_weak_3_0=null;
        Token lv_strong_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:561:28: ( (otherlv_0= 'await' ( (otherlv_1= RULE_ID ) )+ (otherlv_2= 'with' ( ( (lv_weak_3_0= 'weak' ) ) | ( (lv_strong_4_0= 'strong' ) ) ) otherlv_5= 'reset' otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= 'implies' ( (otherlv_9= RULE_ID ) ) ) )
            // InternalTESL.g:562:1: (otherlv_0= 'await' ( (otherlv_1= RULE_ID ) )+ (otherlv_2= 'with' ( ( (lv_weak_3_0= 'weak' ) ) | ( (lv_strong_4_0= 'strong' ) ) ) otherlv_5= 'reset' otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= 'implies' ( (otherlv_9= RULE_ID ) ) )
            {
            // InternalTESL.g:562:1: (otherlv_0= 'await' ( (otherlv_1= RULE_ID ) )+ (otherlv_2= 'with' ( ( (lv_weak_3_0= 'weak' ) ) | ( (lv_strong_4_0= 'strong' ) ) ) otherlv_5= 'reset' otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= 'implies' ( (otherlv_9= RULE_ID ) ) )
            // InternalTESL.g:562:3: otherlv_0= 'await' ( (otherlv_1= RULE_ID ) )+ (otherlv_2= 'with' ( ( (lv_weak_3_0= 'weak' ) ) | ( (lv_strong_4_0= 'strong' ) ) ) otherlv_5= 'reset' otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) )? otherlv_8= 'implies' ( (otherlv_9= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getAwaitImplicationAccess().getAwaitKeyword_0());
                
            // InternalTESL.g:566:1: ( (otherlv_1= RULE_ID ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTESL.g:567:1: (otherlv_1= RULE_ID )
            	    {
            	    // InternalTESL.g:567:1: (otherlv_1= RULE_ID )
            	    // InternalTESL.g:568:3: otherlv_1= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAwaitImplicationRule());
            	    	        }
            	            
            	    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    		newLeafNode(otherlv_1, grammarAccess.getAwaitImplicationAccess().getMastersClockCrossReference_1_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            // InternalTESL.g:579:3: (otherlv_2= 'with' ( ( (lv_weak_3_0= 'weak' ) ) | ( (lv_strong_4_0= 'strong' ) ) ) otherlv_5= 'reset' otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTESL.g:579:5: otherlv_2= 'with' ( ( (lv_weak_3_0= 'weak' ) ) | ( (lv_strong_4_0= 'strong' ) ) ) otherlv_5= 'reset' otherlv_6= 'on' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_14); 

                        	newLeafNode(otherlv_2, grammarAccess.getAwaitImplicationAccess().getWithKeyword_2_0());
                        
                    // InternalTESL.g:583:1: ( ( (lv_weak_3_0= 'weak' ) ) | ( (lv_strong_4_0= 'strong' ) ) )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==25) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==26) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalTESL.g:583:2: ( (lv_weak_3_0= 'weak' ) )
                            {
                            // InternalTESL.g:583:2: ( (lv_weak_3_0= 'weak' ) )
                            // InternalTESL.g:584:1: (lv_weak_3_0= 'weak' )
                            {
                            // InternalTESL.g:584:1: (lv_weak_3_0= 'weak' )
                            // InternalTESL.g:585:3: lv_weak_3_0= 'weak'
                            {
                            lv_weak_3_0=(Token)match(input,25,FOLLOW_15); 

                                    newLeafNode(lv_weak_3_0, grammarAccess.getAwaitImplicationAccess().getWeakWeakKeyword_2_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAwaitImplicationRule());
                            	        }
                                   		setWithLastConsumed(current, "weak", true, "weak");
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTESL.g:599:6: ( (lv_strong_4_0= 'strong' ) )
                            {
                            // InternalTESL.g:599:6: ( (lv_strong_4_0= 'strong' ) )
                            // InternalTESL.g:600:1: (lv_strong_4_0= 'strong' )
                            {
                            // InternalTESL.g:600:1: (lv_strong_4_0= 'strong' )
                            // InternalTESL.g:601:3: lv_strong_4_0= 'strong'
                            {
                            lv_strong_4_0=(Token)match(input,26,FOLLOW_15); 

                                    newLeafNode(lv_strong_4_0, grammarAccess.getAwaitImplicationAccess().getStrongStrongKeyword_2_1_1_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAwaitImplicationRule());
                            	        }
                                   		setWithLastConsumed(current, "strong", true, "strong");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,27,FOLLOW_16); 

                        	newLeafNode(otherlv_5, grammarAccess.getAwaitImplicationAccess().getResetKeyword_2_2());
                        
                    otherlv_6=(Token)match(input,28,FOLLOW_5); 

                        	newLeafNode(otherlv_6, grammarAccess.getAwaitImplicationAccess().getOnKeyword_2_3());
                        
                    // InternalTESL.g:622:1: ( (otherlv_7= RULE_ID ) )
                    // InternalTESL.g:623:1: (otherlv_7= RULE_ID )
                    {
                    // InternalTESL.g:623:1: (otherlv_7= RULE_ID )
                    // InternalTESL.g:624:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAwaitImplicationRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_12); 

                    		newLeafNode(otherlv_7, grammarAccess.getAwaitImplicationAccess().getResetClockCrossReference_2_4_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,22,FOLLOW_5); 

                	newLeafNode(otherlv_8, grammarAccess.getAwaitImplicationAccess().getImpliesKeyword_3());
                
            // InternalTESL.g:639:1: ( (otherlv_9= RULE_ID ) )
            // InternalTESL.g:640:1: (otherlv_9= RULE_ID )
            {
            // InternalTESL.g:640:1: (otherlv_9= RULE_ID )
            // InternalTESL.g:641:3: otherlv_9= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAwaitImplicationRule());
            	        }
                    
            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_9, grammarAccess.getAwaitImplicationAccess().getTargetClockCrossReference_4_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAwaitImplication"


    // $ANTLR start "entryRuleImplicationQualifier"
    // InternalTESL.g:660:1: entryRuleImplicationQualifier returns [EObject current=null] : iv_ruleImplicationQualifier= ruleImplicationQualifier EOF ;
    public final EObject entryRuleImplicationQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationQualifier = null;


        try {
            // InternalTESL.g:661:2: (iv_ruleImplicationQualifier= ruleImplicationQualifier EOF )
            // InternalTESL.g:662:2: iv_ruleImplicationQualifier= ruleImplicationQualifier EOF
            {
             newCompositeNode(grammarAccess.getImplicationQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImplicationQualifier=ruleImplicationQualifier();

            state._fsp--;

             current =iv_ruleImplicationQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleImplicationQualifier"


    // $ANTLR start "ruleImplicationQualifier"
    // InternalTESL.g:669:1: ruleImplicationQualifier returns [EObject current=null] : (this_FilteredQualifier_0= ruleFilteredQualifier | this_EveryQualifier_1= ruleEveryQualifier | this_DelayedQualifier_2= ruleDelayedQualifier | this_SustainedQualifier_3= ruleSustainedQualifier | this_TimeDelayedQualifier_4= ruleTimeDelayedQualifier | this_WhenQualifier_5= ruleWhenQualifier | this_NextQualifier_6= ruleNextQualifier ) ;
    public final EObject ruleImplicationQualifier() throws RecognitionException {
        EObject current = null;

        EObject this_FilteredQualifier_0 = null;

        EObject this_EveryQualifier_1 = null;

        EObject this_DelayedQualifier_2 = null;

        EObject this_SustainedQualifier_3 = null;

        EObject this_TimeDelayedQualifier_4 = null;

        EObject this_WhenQualifier_5 = null;

        EObject this_NextQualifier_6 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:672:28: ( (this_FilteredQualifier_0= ruleFilteredQualifier | this_EveryQualifier_1= ruleEveryQualifier | this_DelayedQualifier_2= ruleDelayedQualifier | this_SustainedQualifier_3= ruleSustainedQualifier | this_TimeDelayedQualifier_4= ruleTimeDelayedQualifier | this_WhenQualifier_5= ruleWhenQualifier | this_NextQualifier_6= ruleNextQualifier ) )
            // InternalTESL.g:673:1: (this_FilteredQualifier_0= ruleFilteredQualifier | this_EveryQualifier_1= ruleEveryQualifier | this_DelayedQualifier_2= ruleDelayedQualifier | this_SustainedQualifier_3= ruleSustainedQualifier | this_TimeDelayedQualifier_4= ruleTimeDelayedQualifier | this_WhenQualifier_5= ruleWhenQualifier | this_NextQualifier_6= ruleNextQualifier )
            {
            // InternalTESL.g:673:1: (this_FilteredQualifier_0= ruleFilteredQualifier | this_EveryQualifier_1= ruleEveryQualifier | this_DelayedQualifier_2= ruleDelayedQualifier | this_SustainedQualifier_3= ruleSustainedQualifier | this_TimeDelayedQualifier_4= ruleTimeDelayedQualifier | this_WhenQualifier_5= ruleWhenQualifier | this_NextQualifier_6= ruleNextQualifier )
            int alt13=7;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt13=1;
                }
                break;
            case 31:
                {
                alt13=2;
                }
                break;
            case 34:
            case 35:
                {
                alt13=3;
                }
                break;
            case 36:
                {
                alt13=4;
                }
                break;
            case 40:
                {
                alt13=5;
                }
                break;
            case 53:
                {
                alt13=6;
                }
                break;
            case 55:
            case 56:
                {
                alt13=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalTESL.g:674:5: this_FilteredQualifier_0= ruleFilteredQualifier
                    {
                     
                            newCompositeNode(grammarAccess.getImplicationQualifierAccess().getFilteredQualifierParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_FilteredQualifier_0=ruleFilteredQualifier();

                    state._fsp--;

                     
                            current = this_FilteredQualifier_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTESL.g:684:5: this_EveryQualifier_1= ruleEveryQualifier
                    {
                     
                            newCompositeNode(grammarAccess.getImplicationQualifierAccess().getEveryQualifierParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_EveryQualifier_1=ruleEveryQualifier();

                    state._fsp--;

                     
                            current = this_EveryQualifier_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalTESL.g:694:5: this_DelayedQualifier_2= ruleDelayedQualifier
                    {
                     
                            newCompositeNode(grammarAccess.getImplicationQualifierAccess().getDelayedQualifierParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DelayedQualifier_2=ruleDelayedQualifier();

                    state._fsp--;

                     
                            current = this_DelayedQualifier_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalTESL.g:704:5: this_SustainedQualifier_3= ruleSustainedQualifier
                    {
                     
                            newCompositeNode(grammarAccess.getImplicationQualifierAccess().getSustainedQualifierParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SustainedQualifier_3=ruleSustainedQualifier();

                    state._fsp--;

                     
                            current = this_SustainedQualifier_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalTESL.g:714:5: this_TimeDelayedQualifier_4= ruleTimeDelayedQualifier
                    {
                     
                            newCompositeNode(grammarAccess.getImplicationQualifierAccess().getTimeDelayedQualifierParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TimeDelayedQualifier_4=ruleTimeDelayedQualifier();

                    state._fsp--;

                     
                            current = this_TimeDelayedQualifier_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalTESL.g:724:5: this_WhenQualifier_5= ruleWhenQualifier
                    {
                     
                            newCompositeNode(grammarAccess.getImplicationQualifierAccess().getWhenQualifierParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_WhenQualifier_5=ruleWhenQualifier();

                    state._fsp--;

                     
                            current = this_WhenQualifier_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalTESL.g:734:5: this_NextQualifier_6= ruleNextQualifier
                    {
                     
                            newCompositeNode(grammarAccess.getImplicationQualifierAccess().getNextQualifierParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NextQualifier_6=ruleNextQualifier();

                    state._fsp--;

                     
                            current = this_NextQualifier_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplicationQualifier"


    // $ANTLR start "entryRuleFilteredQualifier"
    // InternalTESL.g:750:1: entryRuleFilteredQualifier returns [EObject current=null] : iv_ruleFilteredQualifier= ruleFilteredQualifier EOF ;
    public final EObject entryRuleFilteredQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilteredQualifier = null;


        try {
            // InternalTESL.g:751:2: (iv_ruleFilteredQualifier= ruleFilteredQualifier EOF )
            // InternalTESL.g:752:2: iv_ruleFilteredQualifier= ruleFilteredQualifier EOF
            {
             newCompositeNode(grammarAccess.getFilteredQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilteredQualifier=ruleFilteredQualifier();

            state._fsp--;

             current =iv_ruleFilteredQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFilteredQualifier"


    // $ANTLR start "ruleFilteredQualifier"
    // InternalTESL.g:759:1: ruleFilteredQualifier returns [EObject current=null] : (otherlv_0= 'filtered' otherlv_1= 'by' ( (lv_pattern_2_0= rulePattern ) ) ) ;
    public final EObject ruleFilteredQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_pattern_2_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:762:28: ( (otherlv_0= 'filtered' otherlv_1= 'by' ( (lv_pattern_2_0= rulePattern ) ) ) )
            // InternalTESL.g:763:1: (otherlv_0= 'filtered' otherlv_1= 'by' ( (lv_pattern_2_0= rulePattern ) ) )
            {
            // InternalTESL.g:763:1: (otherlv_0= 'filtered' otherlv_1= 'by' ( (lv_pattern_2_0= rulePattern ) ) )
            // InternalTESL.g:763:3: otherlv_0= 'filtered' otherlv_1= 'by' ( (lv_pattern_2_0= rulePattern ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getFilteredQualifierAccess().getFilteredKeyword_0());
                
            otherlv_1=(Token)match(input,30,FOLLOW_7); 

                	newLeafNode(otherlv_1, grammarAccess.getFilteredQualifierAccess().getByKeyword_1());
                
            // InternalTESL.g:771:1: ( (lv_pattern_2_0= rulePattern ) )
            // InternalTESL.g:772:1: (lv_pattern_2_0= rulePattern )
            {
            // InternalTESL.g:772:1: (lv_pattern_2_0= rulePattern )
            // InternalTESL.g:773:3: lv_pattern_2_0= rulePattern
            {
             
            	        newCompositeNode(grammarAccess.getFilteredQualifierAccess().getPatternPatternParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_pattern_2_0=rulePattern();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFilteredQualifierRule());
            	        }
                   		set(
                   			current, 
                   			"pattern",
                    		lv_pattern_2_0, 
                    		"fr.supelec.tesl.lang.TESL.Pattern");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilteredQualifier"


    // $ANTLR start "entryRuleEveryQualifier"
    // InternalTESL.g:797:1: entryRuleEveryQualifier returns [EObject current=null] : iv_ruleEveryQualifier= ruleEveryQualifier EOF ;
    public final EObject entryRuleEveryQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEveryQualifier = null;


        try {
            // InternalTESL.g:798:2: (iv_ruleEveryQualifier= ruleEveryQualifier EOF )
            // InternalTESL.g:799:2: iv_ruleEveryQualifier= ruleEveryQualifier EOF
            {
             newCompositeNode(grammarAccess.getEveryQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEveryQualifier=ruleEveryQualifier();

            state._fsp--;

             current =iv_ruleEveryQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEveryQualifier"


    // $ANTLR start "ruleEveryQualifier"
    // InternalTESL.g:806:1: ruleEveryQualifier returns [EObject current=null] : (otherlv_0= 'every' ( (lv_period_1_0= ruleExpression ) ) ( ( (lv_off_2_0= 'starting' ) ) otherlv_3= 'at' ( (lv_offset_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEveryQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_off_2_0=null;
        Token otherlv_3=null;
        EObject lv_period_1_0 = null;

        EObject lv_offset_4_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:809:28: ( (otherlv_0= 'every' ( (lv_period_1_0= ruleExpression ) ) ( ( (lv_off_2_0= 'starting' ) ) otherlv_3= 'at' ( (lv_offset_4_0= ruleExpression ) ) )? ) )
            // InternalTESL.g:810:1: (otherlv_0= 'every' ( (lv_period_1_0= ruleExpression ) ) ( ( (lv_off_2_0= 'starting' ) ) otherlv_3= 'at' ( (lv_offset_4_0= ruleExpression ) ) )? )
            {
            // InternalTESL.g:810:1: (otherlv_0= 'every' ( (lv_period_1_0= ruleExpression ) ) ( ( (lv_off_2_0= 'starting' ) ) otherlv_3= 'at' ( (lv_offset_4_0= ruleExpression ) ) )? )
            // InternalTESL.g:810:3: otherlv_0= 'every' ( (lv_period_1_0= ruleExpression ) ) ( ( (lv_off_2_0= 'starting' ) ) otherlv_3= 'at' ( (lv_offset_4_0= ruleExpression ) ) )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getEveryQualifierAccess().getEveryKeyword_0());
                
            // InternalTESL.g:814:1: ( (lv_period_1_0= ruleExpression ) )
            // InternalTESL.g:815:1: (lv_period_1_0= ruleExpression )
            {
            // InternalTESL.g:815:1: (lv_period_1_0= ruleExpression )
            // InternalTESL.g:816:3: lv_period_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getEveryQualifierAccess().getPeriodExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_18);
            lv_period_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEveryQualifierRule());
            	        }
                   		set(
                   			current, 
                   			"period",
                    		lv_period_1_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTESL.g:832:2: ( ( (lv_off_2_0= 'starting' ) ) otherlv_3= 'at' ( (lv_offset_4_0= ruleExpression ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTESL.g:832:3: ( (lv_off_2_0= 'starting' ) ) otherlv_3= 'at' ( (lv_offset_4_0= ruleExpression ) )
                    {
                    // InternalTESL.g:832:3: ( (lv_off_2_0= 'starting' ) )
                    // InternalTESL.g:833:1: (lv_off_2_0= 'starting' )
                    {
                    // InternalTESL.g:833:1: (lv_off_2_0= 'starting' )
                    // InternalTESL.g:834:3: lv_off_2_0= 'starting'
                    {
                    lv_off_2_0=(Token)match(input,32,FOLLOW_19); 

                            newLeafNode(lv_off_2_0, grammarAccess.getEveryQualifierAccess().getOffStartingKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEveryQualifierRule());
                    	        }
                           		setWithLastConsumed(current, "off", true, "starting");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,33,FOLLOW_7); 

                        	newLeafNode(otherlv_3, grammarAccess.getEveryQualifierAccess().getAtKeyword_2_1());
                        
                    // InternalTESL.g:851:1: ( (lv_offset_4_0= ruleExpression ) )
                    // InternalTESL.g:852:1: (lv_offset_4_0= ruleExpression )
                    {
                    // InternalTESL.g:852:1: (lv_offset_4_0= ruleExpression )
                    // InternalTESL.g:853:3: lv_offset_4_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getEveryQualifierAccess().getOffsetExpressionParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_offset_4_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEveryQualifierRule());
                    	        }
                           		set(
                           			current, 
                           			"offset",
                            		lv_offset_4_0, 
                            		"fr.supelec.tesl.lang.TESL.Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEveryQualifier"


    // $ANTLR start "entryRuleDelayedQualifier"
    // InternalTESL.g:877:1: entryRuleDelayedQualifier returns [EObject current=null] : iv_ruleDelayedQualifier= ruleDelayedQualifier EOF ;
    public final EObject entryRuleDelayedQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelayedQualifier = null;


        try {
            // InternalTESL.g:878:2: (iv_ruleDelayedQualifier= ruleDelayedQualifier EOF )
            // InternalTESL.g:879:2: iv_ruleDelayedQualifier= ruleDelayedQualifier EOF
            {
             newCompositeNode(grammarAccess.getDelayedQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDelayedQualifier=ruleDelayedQualifier();

            state._fsp--;

             current =iv_ruleDelayedQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDelayedQualifier"


    // $ANTLR start "ruleDelayedQualifier"
    // InternalTESL.g:886:1: ruleDelayedQualifier returns [EObject current=null] : ( ( (lv_immediately_0_0= 'immediately' ) )? otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_count_3_0= ruleExpression ) ) ( ( (lv_reset_4_0= 'with' ) ) otherlv_5= 'reset' )? otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) ) ;
    public final EObject ruleDelayedQualifier() throws RecognitionException {
        EObject current = null;

        Token lv_immediately_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_reset_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_count_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:889:28: ( ( ( (lv_immediately_0_0= 'immediately' ) )? otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_count_3_0= ruleExpression ) ) ( ( (lv_reset_4_0= 'with' ) ) otherlv_5= 'reset' )? otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) ) )
            // InternalTESL.g:890:1: ( ( (lv_immediately_0_0= 'immediately' ) )? otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_count_3_0= ruleExpression ) ) ( ( (lv_reset_4_0= 'with' ) ) otherlv_5= 'reset' )? otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) )
            {
            // InternalTESL.g:890:1: ( ( (lv_immediately_0_0= 'immediately' ) )? otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_count_3_0= ruleExpression ) ) ( ( (lv_reset_4_0= 'with' ) ) otherlv_5= 'reset' )? otherlv_6= 'on' ( (otherlv_7= RULE_ID ) ) )
            // InternalTESL.g:890:2: ( (lv_immediately_0_0= 'immediately' ) )? otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_count_3_0= ruleExpression ) ) ( ( (lv_reset_4_0= 'with' ) ) otherlv_5= 'reset' )? otherlv_6= 'on' ( (otherlv_7= RULE_ID ) )
            {
            // InternalTESL.g:890:2: ( (lv_immediately_0_0= 'immediately' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTESL.g:891:1: (lv_immediately_0_0= 'immediately' )
                    {
                    // InternalTESL.g:891:1: (lv_immediately_0_0= 'immediately' )
                    // InternalTESL.g:892:3: lv_immediately_0_0= 'immediately'
                    {
                    lv_immediately_0_0=(Token)match(input,34,FOLLOW_20); 

                            newLeafNode(lv_immediately_0_0, grammarAccess.getDelayedQualifierAccess().getImmediatelyImmediatelyKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDelayedQualifierRule());
                    	        }
                           		setWithLastConsumed(current, "immediately", true, "immediately");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,35,FOLLOW_17); 

                	newLeafNode(otherlv_1, grammarAccess.getDelayedQualifierAccess().getDelayedKeyword_1());
                
            otherlv_2=(Token)match(input,30,FOLLOW_7); 

                	newLeafNode(otherlv_2, grammarAccess.getDelayedQualifierAccess().getByKeyword_2());
                
            // InternalTESL.g:913:1: ( (lv_count_3_0= ruleExpression ) )
            // InternalTESL.g:914:1: (lv_count_3_0= ruleExpression )
            {
            // InternalTESL.g:914:1: (lv_count_3_0= ruleExpression )
            // InternalTESL.g:915:3: lv_count_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getDelayedQualifierAccess().getCountExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_21);
            lv_count_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDelayedQualifierRule());
            	        }
                   		set(
                   			current, 
                   			"count",
                    		lv_count_3_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTESL.g:931:2: ( ( (lv_reset_4_0= 'with' ) ) otherlv_5= 'reset' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTESL.g:931:3: ( (lv_reset_4_0= 'with' ) ) otherlv_5= 'reset'
                    {
                    // InternalTESL.g:931:3: ( (lv_reset_4_0= 'with' ) )
                    // InternalTESL.g:932:1: (lv_reset_4_0= 'with' )
                    {
                    // InternalTESL.g:932:1: (lv_reset_4_0= 'with' )
                    // InternalTESL.g:933:3: lv_reset_4_0= 'with'
                    {
                    lv_reset_4_0=(Token)match(input,24,FOLLOW_15); 

                            newLeafNode(lv_reset_4_0, grammarAccess.getDelayedQualifierAccess().getResetWithKeyword_4_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDelayedQualifierRule());
                    	        }
                           		setWithLastConsumed(current, "reset", true, "with");
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,27,FOLLOW_16); 

                        	newLeafNode(otherlv_5, grammarAccess.getDelayedQualifierAccess().getResetKeyword_4_1());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,28,FOLLOW_5); 

                	newLeafNode(otherlv_6, grammarAccess.getDelayedQualifierAccess().getOnKeyword_5());
                
            // InternalTESL.g:954:1: ( (otherlv_7= RULE_ID ) )
            // InternalTESL.g:955:1: (otherlv_7= RULE_ID )
            {
            // InternalTESL.g:955:1: (otherlv_7= RULE_ID )
            // InternalTESL.g:956:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDelayedQualifierRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_7, grammarAccess.getDelayedQualifierAccess().getClockClockCrossReference_6_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDelayedQualifier"


    // $ANTLR start "entryRuleSustainedQualifier"
    // InternalTESL.g:975:1: entryRuleSustainedQualifier returns [EObject current=null] : iv_ruleSustainedQualifier= ruleSustainedQualifier EOF ;
    public final EObject entryRuleSustainedQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSustainedQualifier = null;


        try {
            // InternalTESL.g:976:2: (iv_ruleSustainedQualifier= ruleSustainedQualifier EOF )
            // InternalTESL.g:977:2: iv_ruleSustainedQualifier= ruleSustainedQualifier EOF
            {
             newCompositeNode(grammarAccess.getSustainedQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSustainedQualifier=ruleSustainedQualifier();

            state._fsp--;

             current =iv_ruleSustainedQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSustainedQualifier"


    // $ANTLR start "ruleSustainedQualifier"
    // InternalTESL.g:984:1: ruleSustainedQualifier returns [EObject current=null] : (otherlv_0= 'sustained' ( (lv_immediately_1_0= 'immediately' ) )? otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) ( (lv_weakly_6_0= 'weakly' ) )? ) ;
    public final EObject ruleSustainedQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_immediately_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_weakly_6_0=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:987:28: ( (otherlv_0= 'sustained' ( (lv_immediately_1_0= 'immediately' ) )? otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) ( (lv_weakly_6_0= 'weakly' ) )? ) )
            // InternalTESL.g:988:1: (otherlv_0= 'sustained' ( (lv_immediately_1_0= 'immediately' ) )? otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) ( (lv_weakly_6_0= 'weakly' ) )? )
            {
            // InternalTESL.g:988:1: (otherlv_0= 'sustained' ( (lv_immediately_1_0= 'immediately' ) )? otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) ( (lv_weakly_6_0= 'weakly' ) )? )
            // InternalTESL.g:988:3: otherlv_0= 'sustained' ( (lv_immediately_1_0= 'immediately' ) )? otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) ( (lv_weakly_6_0= 'weakly' ) )?
            {
            otherlv_0=(Token)match(input,36,FOLLOW_22); 

                	newLeafNode(otherlv_0, grammarAccess.getSustainedQualifierAccess().getSustainedKeyword_0());
                
            // InternalTESL.g:992:1: ( (lv_immediately_1_0= 'immediately' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==34) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTESL.g:993:1: (lv_immediately_1_0= 'immediately' )
                    {
                    // InternalTESL.g:993:1: (lv_immediately_1_0= 'immediately' )
                    // InternalTESL.g:994:3: lv_immediately_1_0= 'immediately'
                    {
                    lv_immediately_1_0=(Token)match(input,34,FOLLOW_23); 

                            newLeafNode(lv_immediately_1_0, grammarAccess.getSustainedQualifierAccess().getImmediatelyImmediatelyKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSustainedQualifierRule());
                    	        }
                           		setWithLastConsumed(current, "immediately", true, "immediately");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,37,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getSustainedQualifierAccess().getFromKeyword_2());
                
            // InternalTESL.g:1011:1: ( (otherlv_3= RULE_ID ) )
            // InternalTESL.g:1012:1: (otherlv_3= RULE_ID )
            {
            // InternalTESL.g:1012:1: (otherlv_3= RULE_ID )
            // InternalTESL.g:1013:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSustainedQualifierRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_24); 

            		newLeafNode(otherlv_3, grammarAccess.getSustainedQualifierAccess().getStartClockClockCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,38,FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getSustainedQualifierAccess().getToKeyword_4());
                
            // InternalTESL.g:1028:1: ( (otherlv_5= RULE_ID ) )
            // InternalTESL.g:1029:1: (otherlv_5= RULE_ID )
            {
            // InternalTESL.g:1029:1: (otherlv_5= RULE_ID )
            // InternalTESL.g:1030:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSustainedQualifierRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_25); 

            		newLeafNode(otherlv_5, grammarAccess.getSustainedQualifierAccess().getEndClockClockCrossReference_5_0()); 
            	

            }


            }

            // InternalTESL.g:1041:2: ( (lv_weakly_6_0= 'weakly' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==39) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTESL.g:1042:1: (lv_weakly_6_0= 'weakly' )
                    {
                    // InternalTESL.g:1042:1: (lv_weakly_6_0= 'weakly' )
                    // InternalTESL.g:1043:3: lv_weakly_6_0= 'weakly'
                    {
                    lv_weakly_6_0=(Token)match(input,39,FOLLOW_2); 

                            newLeafNode(lv_weakly_6_0, grammarAccess.getSustainedQualifierAccess().getWeaklyWeaklyKeyword_6_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSustainedQualifierRule());
                    	        }
                           		setWithLastConsumed(current, "weakly", true, "weakly");
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSustainedQualifier"


    // $ANTLR start "entryRuleTimeDelayedQualifier"
    // InternalTESL.g:1064:1: entryRuleTimeDelayedQualifier returns [EObject current=null] : iv_ruleTimeDelayedQualifier= ruleTimeDelayedQualifier EOF ;
    public final EObject entryRuleTimeDelayedQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeDelayedQualifier = null;


        try {
            // InternalTESL.g:1065:2: (iv_ruleTimeDelayedQualifier= ruleTimeDelayedQualifier EOF )
            // InternalTESL.g:1066:2: iv_ruleTimeDelayedQualifier= ruleTimeDelayedQualifier EOF
            {
             newCompositeNode(grammarAccess.getTimeDelayedQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeDelayedQualifier=ruleTimeDelayedQualifier();

            state._fsp--;

             current =iv_ruleTimeDelayedQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTimeDelayedQualifier"


    // $ANTLR start "ruleTimeDelayedQualifier"
    // InternalTESL.g:1073:1: ruleTimeDelayedQualifier returns [EObject current=null] : (otherlv_0= 'time' otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_delay_3_0= ruleExpression ) ) otherlv_4= 'on' ( (otherlv_5= RULE_ID ) ) ( ( (lv_reset_6_0= 'with' ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) ) ) otherlv_10= 'reset' otherlv_11= 'on' ( (otherlv_12= RULE_ID ) ) )? ) ;
    public final EObject ruleTimeDelayedQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_reset_6_0=null;
        Token lv_immReset_8_0=null;
        Token lv_strongReset_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_delay_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1076:28: ( (otherlv_0= 'time' otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_delay_3_0= ruleExpression ) ) otherlv_4= 'on' ( (otherlv_5= RULE_ID ) ) ( ( (lv_reset_6_0= 'with' ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) ) ) otherlv_10= 'reset' otherlv_11= 'on' ( (otherlv_12= RULE_ID ) ) )? ) )
            // InternalTESL.g:1077:1: (otherlv_0= 'time' otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_delay_3_0= ruleExpression ) ) otherlv_4= 'on' ( (otherlv_5= RULE_ID ) ) ( ( (lv_reset_6_0= 'with' ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) ) ) otherlv_10= 'reset' otherlv_11= 'on' ( (otherlv_12= RULE_ID ) ) )? )
            {
            // InternalTESL.g:1077:1: (otherlv_0= 'time' otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_delay_3_0= ruleExpression ) ) otherlv_4= 'on' ( (otherlv_5= RULE_ID ) ) ( ( (lv_reset_6_0= 'with' ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) ) ) otherlv_10= 'reset' otherlv_11= 'on' ( (otherlv_12= RULE_ID ) ) )? )
            // InternalTESL.g:1077:3: otherlv_0= 'time' otherlv_1= 'delayed' otherlv_2= 'by' ( (lv_delay_3_0= ruleExpression ) ) otherlv_4= 'on' ( (otherlv_5= RULE_ID ) ) ( ( (lv_reset_6_0= 'with' ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) ) ) otherlv_10= 'reset' otherlv_11= 'on' ( (otherlv_12= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_20); 

                	newLeafNode(otherlv_0, grammarAccess.getTimeDelayedQualifierAccess().getTimeKeyword_0());
                
            otherlv_1=(Token)match(input,35,FOLLOW_17); 

                	newLeafNode(otherlv_1, grammarAccess.getTimeDelayedQualifierAccess().getDelayedKeyword_1());
                
            otherlv_2=(Token)match(input,30,FOLLOW_7); 

                	newLeafNode(otherlv_2, grammarAccess.getTimeDelayedQualifierAccess().getByKeyword_2());
                
            // InternalTESL.g:1089:1: ( (lv_delay_3_0= ruleExpression ) )
            // InternalTESL.g:1090:1: (lv_delay_3_0= ruleExpression )
            {
            // InternalTESL.g:1090:1: (lv_delay_3_0= ruleExpression )
            // InternalTESL.g:1091:3: lv_delay_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getTimeDelayedQualifierAccess().getDelayExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_16);
            lv_delay_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTimeDelayedQualifierRule());
            	        }
                   		set(
                   			current, 
                   			"delay",
                    		lv_delay_3_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,28,FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getTimeDelayedQualifierAccess().getOnKeyword_4());
                
            // InternalTESL.g:1111:1: ( (otherlv_5= RULE_ID ) )
            // InternalTESL.g:1112:1: (otherlv_5= RULE_ID )
            {
            // InternalTESL.g:1112:1: (otherlv_5= RULE_ID )
            // InternalTESL.g:1113:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTimeDelayedQualifierRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_26); 

            		newLeafNode(otherlv_5, grammarAccess.getTimeDelayedQualifierAccess().getClockClockCrossReference_5_0()); 
            	

            }


            }

            // InternalTESL.g:1124:2: ( ( (lv_reset_6_0= 'with' ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) ) ) otherlv_10= 'reset' otherlv_11= 'on' ( (otherlv_12= RULE_ID ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==24) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTESL.g:1124:3: ( (lv_reset_6_0= 'with' ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) ) ) otherlv_10= 'reset' otherlv_11= 'on' ( (otherlv_12= RULE_ID ) )
                    {
                    // InternalTESL.g:1124:3: ( (lv_reset_6_0= 'with' ) )
                    // InternalTESL.g:1125:1: (lv_reset_6_0= 'with' )
                    {
                    // InternalTESL.g:1125:1: (lv_reset_6_0= 'with' )
                    // InternalTESL.g:1126:3: lv_reset_6_0= 'with'
                    {
                    lv_reset_6_0=(Token)match(input,24,FOLLOW_27); 

                            newLeafNode(lv_reset_6_0, grammarAccess.getTimeDelayedQualifierAccess().getResetWithKeyword_6_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTimeDelayedQualifierRule());
                    	        }
                           		setWithLastConsumed(current, "reset", true, "with");
                    	    

                    }


                    }

                    // InternalTESL.g:1139:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) ) )
                    // InternalTESL.g:1141:1: ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) )
                    {
                    // InternalTESL.g:1141:1: ( ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* ) )
                    // InternalTESL.g:1142:2: ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* )
                    {
                     
                    	  getUnorderedGroupHelper().enter(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1());
                    	
                    // InternalTESL.g:1145:2: ( ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )* )
                    // InternalTESL.g:1146:3: ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )*
                    {
                    // InternalTESL.g:1146:3: ( ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) ) )*
                    loop19:
                    do {
                        int alt19=3;
                        int LA19_0 = input.LA(1);

                        if ( LA19_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1(), 0) ) {
                            alt19=1;
                        }
                        else if ( LA19_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1(), 1) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalTESL.g:1148:4: ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) )
                    	    {
                    	    // InternalTESL.g:1148:4: ({...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) ) )
                    	    // InternalTESL.g:1149:5: {...}? => ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeDelayedQualifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1(), 0)");
                    	    }
                    	    // InternalTESL.g:1149:119: ( ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) ) )
                    	    // InternalTESL.g:1150:6: ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1(), 0);
                    	    	 				
                    	    // InternalTESL.g:1153:6: ({...}? => ( (lv_immReset_8_0= 'immediate' ) ) )
                    	    // InternalTESL.g:1153:7: {...}? => ( (lv_immReset_8_0= 'immediate' ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeDelayedQualifier", "true");
                    	    }
                    	    // InternalTESL.g:1153:16: ( (lv_immReset_8_0= 'immediate' ) )
                    	    // InternalTESL.g:1154:1: (lv_immReset_8_0= 'immediate' )
                    	    {
                    	    // InternalTESL.g:1154:1: (lv_immReset_8_0= 'immediate' )
                    	    // InternalTESL.g:1155:3: lv_immReset_8_0= 'immediate'
                    	    {
                    	    lv_immReset_8_0=(Token)match(input,41,FOLLOW_27); 

                    	            newLeafNode(lv_immReset_8_0, grammarAccess.getTimeDelayedQualifierAccess().getImmResetImmediateKeyword_6_1_0_0());
                    	        

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTimeDelayedQualifierRule());
                    	    	        }
                    	           		setWithLastConsumed(current, "immReset", true, "immediate");
                    	    	    

                    	    }


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTESL.g:1175:4: ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) )
                    	    {
                    	    // InternalTESL.g:1175:4: ({...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) ) )
                    	    // InternalTESL.g:1176:5: {...}? => ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeDelayedQualifier", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1(), 1)");
                    	    }
                    	    // InternalTESL.g:1176:119: ( ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) ) )
                    	    // InternalTESL.g:1177:6: ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1(), 1);
                    	    	 				
                    	    // InternalTESL.g:1180:6: ({...}? => ( (lv_strongReset_9_0= 'strong' ) ) )
                    	    // InternalTESL.g:1180:7: {...}? => ( (lv_strongReset_9_0= 'strong' ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeDelayedQualifier", "true");
                    	    }
                    	    // InternalTESL.g:1180:16: ( (lv_strongReset_9_0= 'strong' ) )
                    	    // InternalTESL.g:1181:1: (lv_strongReset_9_0= 'strong' )
                    	    {
                    	    // InternalTESL.g:1181:1: (lv_strongReset_9_0= 'strong' )
                    	    // InternalTESL.g:1182:3: lv_strongReset_9_0= 'strong'
                    	    {
                    	    lv_strongReset_9_0=(Token)match(input,26,FOLLOW_27); 

                    	            newLeafNode(lv_strongReset_9_0, grammarAccess.getTimeDelayedQualifierAccess().getStrongResetStrongKeyword_6_1_1_0());
                    	        

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTimeDelayedQualifierRule());
                    	    	        }
                    	           		setWithLastConsumed(current, "strongReset", true, "strong");
                    	    	    

                    	    }


                    	    }


                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }


                    }

                     
                    	  getUnorderedGroupHelper().leave(grammarAccess.getTimeDelayedQualifierAccess().getUnorderedGroup_6_1());
                    	

                    }

                    otherlv_10=(Token)match(input,27,FOLLOW_16); 

                        	newLeafNode(otherlv_10, grammarAccess.getTimeDelayedQualifierAccess().getResetKeyword_6_2());
                        
                    otherlv_11=(Token)match(input,28,FOLLOW_5); 

                        	newLeafNode(otherlv_11, grammarAccess.getTimeDelayedQualifierAccess().getOnKeyword_6_3());
                        
                    // InternalTESL.g:1217:1: ( (otherlv_12= RULE_ID ) )
                    // InternalTESL.g:1218:1: (otherlv_12= RULE_ID )
                    {
                    // InternalTESL.g:1218:1: (otherlv_12= RULE_ID )
                    // InternalTESL.g:1219:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTimeDelayedQualifierRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		newLeafNode(otherlv_12, grammarAccess.getTimeDelayedQualifierAccess().getResetClockClockCrossReference_6_4_0()); 
                    	

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeDelayedQualifier"


    // $ANTLR start "entryRuleLet"
    // InternalTESL.g:1238:1: entryRuleLet returns [EObject current=null] : iv_ruleLet= ruleLet EOF ;
    public final EObject entryRuleLet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLet = null;


        try {
            // InternalTESL.g:1239:2: (iv_ruleLet= ruleLet EOF )
            // InternalTESL.g:1240:2: iv_ruleLet= ruleLet EOF
            {
             newCompositeNode(grammarAccess.getLetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLet=ruleLet();

            state._fsp--;

             current =iv_ruleLet; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLet"


    // $ANTLR start "ruleLet"
    // InternalTESL.g:1247:1: ruleLet returns [EObject current=null] : (otherlv_0= 'let' ( (lv_type_1_0= ruleValueType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) ) ;
    public final EObject ruleLet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1250:28: ( (otherlv_0= 'let' ( (lv_type_1_0= ruleValueType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) ) )
            // InternalTESL.g:1251:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleValueType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) )
            {
            // InternalTESL.g:1251:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleValueType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) )
            // InternalTESL.g:1251:3: otherlv_0= 'let' ( (lv_type_1_0= ruleValueType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_28); 

                	newLeafNode(otherlv_0, grammarAccess.getLetAccess().getLetKeyword_0());
                
            // InternalTESL.g:1255:1: ( (lv_type_1_0= ruleValueType ) )
            // InternalTESL.g:1256:1: (lv_type_1_0= ruleValueType )
            {
            // InternalTESL.g:1256:1: (lv_type_1_0= ruleValueType )
            // InternalTESL.g:1257:3: lv_type_1_0= ruleValueType
            {
             
            	        newCompositeNode(grammarAccess.getLetAccess().getTypeValueTypeEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_5);
            lv_type_1_0=ruleValueType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLetRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"fr.supelec.tesl.lang.TESL.ValueType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTESL.g:1273:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalTESL.g:1274:1: (lv_name_2_0= RULE_ID )
            {
            // InternalTESL.g:1274:1: (lv_name_2_0= RULE_ID )
            // InternalTESL.g:1275:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            			newLeafNode(lv_name_2_0, grammarAccess.getLetAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLetRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"fr.supelec.tesl.lang.TESL.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,43,FOLLOW_7); 

                	newLeafNode(otherlv_3, grammarAccess.getLetAccess().getEqualsSignKeyword_3());
                
            // InternalTESL.g:1295:1: ( (lv_value_4_0= ruleExpression ) )
            // InternalTESL.g:1296:1: (lv_value_4_0= ruleExpression )
            {
            // InternalTESL.g:1296:1: (lv_value_4_0= ruleExpression )
            // InternalTESL.g:1297:3: lv_value_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getLetAccess().getValueExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLetRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLet"


    // $ANTLR start "entryRuleValue"
    // InternalTESL.g:1321:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalTESL.g:1322:2: (iv_ruleValue= ruleValue EOF )
            // InternalTESL.g:1323:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalTESL.g:1330:1: ruleValue returns [EObject current=null] : (this_IntegerValue_0= ruleIntegerValue | this_DecimalValue_1= ruleDecimalValue | this_FloatValue_2= ruleFloatValue | this_RationalValue_3= ruleRationalValue | this_LetValue_4= ruleLetValue ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerValue_0 = null;

        EObject this_DecimalValue_1 = null;

        EObject this_FloatValue_2 = null;

        EObject this_RationalValue_3 = null;

        EObject this_LetValue_4 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1333:28: ( (this_IntegerValue_0= ruleIntegerValue | this_DecimalValue_1= ruleDecimalValue | this_FloatValue_2= ruleFloatValue | this_RationalValue_3= ruleRationalValue | this_LetValue_4= ruleLetValue ) )
            // InternalTESL.g:1334:1: (this_IntegerValue_0= ruleIntegerValue | this_DecimalValue_1= ruleDecimalValue | this_FloatValue_2= ruleFloatValue | this_RationalValue_3= ruleRationalValue | this_LetValue_4= ruleLetValue )
            {
            // InternalTESL.g:1334:1: (this_IntegerValue_0= ruleIntegerValue | this_DecimalValue_1= ruleDecimalValue | this_FloatValue_2= ruleFloatValue | this_RationalValue_3= ruleRationalValue | this_LetValue_4= ruleLetValue )
            int alt21=5;
            switch ( input.LA(1) ) {
            case 61:
                {
                switch ( input.LA(2) ) {
                case RULE_BIG_INT:
                    {
                    alt21=1;
                    }
                    break;
                case RULE_RATIONAL:
                    {
                    alt21=4;
                    }
                    break;
                case RULE_BIG_DECIMAL:
                    {
                    alt21=2;
                    }
                    break;
                case RULE_FLOAT:
                    {
                    alt21=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }

                }
                break;
            case 100:
                {
                switch ( input.LA(2) ) {
                case RULE_FLOAT:
                    {
                    alt21=3;
                    }
                    break;
                case RULE_BIG_INT:
                    {
                    alt21=1;
                    }
                    break;
                case RULE_RATIONAL:
                    {
                    alt21=4;
                    }
                    break;
                case RULE_BIG_DECIMAL:
                    {
                    alt21=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_BIG_INT:
                {
                alt21=1;
                }
                break;
            case RULE_BIG_DECIMAL:
                {
                alt21=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt21=3;
                }
                break;
            case RULE_RATIONAL:
                {
                alt21=4;
                }
                break;
            case 44:
                {
                alt21=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalTESL.g:1335:5: this_IntegerValue_0= ruleIntegerValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IntegerValue_0=ruleIntegerValue();

                    state._fsp--;

                     
                            current = this_IntegerValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTESL.g:1345:5: this_DecimalValue_1= ruleDecimalValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DecimalValue_1=ruleDecimalValue();

                    state._fsp--;

                     
                            current = this_DecimalValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalTESL.g:1355:5: this_FloatValue_2= ruleFloatValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getFloatValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_FloatValue_2=ruleFloatValue();

                    state._fsp--;

                     
                            current = this_FloatValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalTESL.g:1365:5: this_RationalValue_3= ruleRationalValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getRationalValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_RationalValue_3=ruleRationalValue();

                    state._fsp--;

                     
                            current = this_RationalValue_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalTESL.g:1375:5: this_LetValue_4= ruleLetValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getLetValueParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_LetValue_4=ruleLetValue();

                    state._fsp--;

                     
                            current = this_LetValue_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleIntegerValue"
    // InternalTESL.g:1391:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // InternalTESL.g:1392:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // InternalTESL.g:1393:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
             newCompositeNode(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;

             current =iv_ruleIntegerValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIntegerValue"


    // $ANTLR start "ruleIntegerValue"
    // InternalTESL.g:1400:1: ruleIntegerValue returns [EObject current=null] : ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_INT ) ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Enumerator lv_sign_0_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1403:28: ( ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_INT ) ) ) )
            // InternalTESL.g:1404:1: ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_INT ) ) )
            {
            // InternalTESL.g:1404:1: ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_INT ) ) )
            // InternalTESL.g:1404:2: ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_INT ) )
            {
            // InternalTESL.g:1404:2: ( (lv_sign_0_0= ruleOpTerm ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==61||LA22_0==100) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTESL.g:1405:1: (lv_sign_0_0= ruleOpTerm )
                    {
                    // InternalTESL.g:1405:1: (lv_sign_0_0= ruleOpTerm )
                    // InternalTESL.g:1406:3: lv_sign_0_0= ruleOpTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerValueAccess().getSignOpTermEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_sign_0_0=ruleOpTerm();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIntegerValueRule());
                    	        }
                           		set(
                           			current, 
                           			"sign",
                            		lv_sign_0_0, 
                            		"fr.supelec.tesl.lang.TESL.OpTerm");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalTESL.g:1422:3: ( (lv_value_1_0= RULE_BIG_INT ) )
            // InternalTESL.g:1423:1: (lv_value_1_0= RULE_BIG_INT )
            {
            // InternalTESL.g:1423:1: (lv_value_1_0= RULE_BIG_INT )
            // InternalTESL.g:1424:3: lv_value_1_0= RULE_BIG_INT
            {
            lv_value_1_0=(Token)match(input,RULE_BIG_INT,FOLLOW_2); 

            			newLeafNode(lv_value_1_0, grammarAccess.getIntegerValueAccess().getValueBIG_INTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntegerValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"fr.supelec.tesl.lang.TESL.BIG_INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerValue"


    // $ANTLR start "entryRuleDecimalValue"
    // InternalTESL.g:1448:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalTESL.g:1449:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalTESL.g:1450:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;

             current =iv_ruleDecimalValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDecimalValue"


    // $ANTLR start "ruleDecimalValue"
    // InternalTESL.g:1457:1: ruleDecimalValue returns [EObject current=null] : ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_DECIMAL ) ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Enumerator lv_sign_0_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1460:28: ( ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_DECIMAL ) ) ) )
            // InternalTESL.g:1461:1: ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_DECIMAL ) ) )
            {
            // InternalTESL.g:1461:1: ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_DECIMAL ) ) )
            // InternalTESL.g:1461:2: ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_BIG_DECIMAL ) )
            {
            // InternalTESL.g:1461:2: ( (lv_sign_0_0= ruleOpTerm ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==61||LA23_0==100) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTESL.g:1462:1: (lv_sign_0_0= ruleOpTerm )
                    {
                    // InternalTESL.g:1462:1: (lv_sign_0_0= ruleOpTerm )
                    // InternalTESL.g:1463:3: lv_sign_0_0= ruleOpTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getDecimalValueAccess().getSignOpTermEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_31);
                    lv_sign_0_0=ruleOpTerm();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDecimalValueRule());
                    	        }
                           		set(
                           			current, 
                           			"sign",
                            		lv_sign_0_0, 
                            		"fr.supelec.tesl.lang.TESL.OpTerm");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalTESL.g:1479:3: ( (lv_value_1_0= RULE_BIG_DECIMAL ) )
            // InternalTESL.g:1480:1: (lv_value_1_0= RULE_BIG_DECIMAL )
            {
            // InternalTESL.g:1480:1: (lv_value_1_0= RULE_BIG_DECIMAL )
            // InternalTESL.g:1481:3: lv_value_1_0= RULE_BIG_DECIMAL
            {
            lv_value_1_0=(Token)match(input,RULE_BIG_DECIMAL,FOLLOW_2); 

            			newLeafNode(lv_value_1_0, grammarAccess.getDecimalValueAccess().getValueBIG_DECIMALTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDecimalValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"fr.supelec.tesl.lang.TESL.BIG_DECIMAL");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecimalValue"


    // $ANTLR start "entryRuleFloatValue"
    // InternalTESL.g:1505:1: entryRuleFloatValue returns [EObject current=null] : iv_ruleFloatValue= ruleFloatValue EOF ;
    public final EObject entryRuleFloatValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatValue = null;


        try {
            // InternalTESL.g:1506:2: (iv_ruleFloatValue= ruleFloatValue EOF )
            // InternalTESL.g:1507:2: iv_ruleFloatValue= ruleFloatValue EOF
            {
             newCompositeNode(grammarAccess.getFloatValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatValue=ruleFloatValue();

            state._fsp--;

             current =iv_ruleFloatValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFloatValue"


    // $ANTLR start "ruleFloatValue"
    // InternalTESL.g:1514:1: ruleFloatValue returns [EObject current=null] : ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleFloatValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Enumerator lv_sign_0_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1517:28: ( ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_FLOAT ) ) ) )
            // InternalTESL.g:1518:1: ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_FLOAT ) ) )
            {
            // InternalTESL.g:1518:1: ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_FLOAT ) ) )
            // InternalTESL.g:1518:2: ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_FLOAT ) )
            {
            // InternalTESL.g:1518:2: ( (lv_sign_0_0= ruleOpTerm ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==61||LA24_0==100) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalTESL.g:1519:1: (lv_sign_0_0= ruleOpTerm )
                    {
                    // InternalTESL.g:1519:1: (lv_sign_0_0= ruleOpTerm )
                    // InternalTESL.g:1520:3: lv_sign_0_0= ruleOpTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getFloatValueAccess().getSignOpTermEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_32);
                    lv_sign_0_0=ruleOpTerm();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFloatValueRule());
                    	        }
                           		set(
                           			current, 
                           			"sign",
                            		lv_sign_0_0, 
                            		"fr.supelec.tesl.lang.TESL.OpTerm");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalTESL.g:1536:3: ( (lv_value_1_0= RULE_FLOAT ) )
            // InternalTESL.g:1537:1: (lv_value_1_0= RULE_FLOAT )
            {
            // InternalTESL.g:1537:1: (lv_value_1_0= RULE_FLOAT )
            // InternalTESL.g:1538:3: lv_value_1_0= RULE_FLOAT
            {
            lv_value_1_0=(Token)match(input,RULE_FLOAT,FOLLOW_2); 

            			newLeafNode(lv_value_1_0, grammarAccess.getFloatValueAccess().getValueFLOATTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFloatValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"fr.supelec.tesl.lang.TESL.FLOAT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatValue"


    // $ANTLR start "entryRuleRationalValue"
    // InternalTESL.g:1562:1: entryRuleRationalValue returns [EObject current=null] : iv_ruleRationalValue= ruleRationalValue EOF ;
    public final EObject entryRuleRationalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRationalValue = null;


        try {
            // InternalTESL.g:1563:2: (iv_ruleRationalValue= ruleRationalValue EOF )
            // InternalTESL.g:1564:2: iv_ruleRationalValue= ruleRationalValue EOF
            {
             newCompositeNode(grammarAccess.getRationalValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRationalValue=ruleRationalValue();

            state._fsp--;

             current =iv_ruleRationalValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRationalValue"


    // $ANTLR start "ruleRationalValue"
    // InternalTESL.g:1571:1: ruleRationalValue returns [EObject current=null] : ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_RATIONAL ) ) ) ;
    public final EObject ruleRationalValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Enumerator lv_sign_0_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1574:28: ( ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_RATIONAL ) ) ) )
            // InternalTESL.g:1575:1: ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_RATIONAL ) ) )
            {
            // InternalTESL.g:1575:1: ( ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_RATIONAL ) ) )
            // InternalTESL.g:1575:2: ( (lv_sign_0_0= ruleOpTerm ) )? ( (lv_value_1_0= RULE_RATIONAL ) )
            {
            // InternalTESL.g:1575:2: ( (lv_sign_0_0= ruleOpTerm ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==61||LA25_0==100) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTESL.g:1576:1: (lv_sign_0_0= ruleOpTerm )
                    {
                    // InternalTESL.g:1576:1: (lv_sign_0_0= ruleOpTerm )
                    // InternalTESL.g:1577:3: lv_sign_0_0= ruleOpTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getRationalValueAccess().getSignOpTermEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_33);
                    lv_sign_0_0=ruleOpTerm();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRationalValueRule());
                    	        }
                           		set(
                           			current, 
                           			"sign",
                            		lv_sign_0_0, 
                            		"fr.supelec.tesl.lang.TESL.OpTerm");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalTESL.g:1593:3: ( (lv_value_1_0= RULE_RATIONAL ) )
            // InternalTESL.g:1594:1: (lv_value_1_0= RULE_RATIONAL )
            {
            // InternalTESL.g:1594:1: (lv_value_1_0= RULE_RATIONAL )
            // InternalTESL.g:1595:3: lv_value_1_0= RULE_RATIONAL
            {
            lv_value_1_0=(Token)match(input,RULE_RATIONAL,FOLLOW_2); 

            			newLeafNode(lv_value_1_0, grammarAccess.getRationalValueAccess().getValueRATIONALTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRationalValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"fr.supelec.tesl.lang.TESL.RATIONAL");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRationalValue"


    // $ANTLR start "entryRuleLetValue"
    // InternalTESL.g:1619:1: entryRuleLetValue returns [EObject current=null] : iv_ruleLetValue= ruleLetValue EOF ;
    public final EObject entryRuleLetValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetValue = null;


        try {
            // InternalTESL.g:1620:2: (iv_ruleLetValue= ruleLetValue EOF )
            // InternalTESL.g:1621:2: iv_ruleLetValue= ruleLetValue EOF
            {
             newCompositeNode(grammarAccess.getLetValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLetValue=ruleLetValue();

            state._fsp--;

             current =iv_ruleLetValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLetValue"


    // $ANTLR start "ruleLetValue"
    // InternalTESL.g:1628:1: ruleLetValue returns [EObject current=null] : (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleLetValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:1631:28: ( (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalTESL.g:1632:1: (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalTESL.g:1632:1: (otherlv_0= '$' ( (otherlv_1= RULE_ID ) ) )
            // InternalTESL.g:1632:3: otherlv_0= '$' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getLetValueAccess().getDollarSignKeyword_0());
                
            // InternalTESL.g:1636:1: ( (otherlv_1= RULE_ID ) )
            // InternalTESL.g:1637:1: (otherlv_1= RULE_ID )
            {
            // InternalTESL.g:1637:1: (otherlv_1= RULE_ID )
            // InternalTESL.g:1638:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLetValueRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_1, grammarAccess.getLetValueAccess().getRefLetCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLetValue"


    // $ANTLR start "entryRuleExpression"
    // InternalTESL.g:1657:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalTESL.g:1658:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalTESL.g:1659:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalTESL.g:1666:1: ruleExpression returns [EObject current=null] : this_Term_0= ruleTerm ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Term_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1669:28: (this_Term_0= ruleTerm )
            // InternalTESL.g:1671:5: this_Term_0= ruleTerm
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getTermParserRuleCall()); 
                
            pushFollow(FOLLOW_2);
            this_Term_0=ruleTerm();

            state._fsp--;

             
                    current = this_Term_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleTerm"
    // InternalTESL.g:1687:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalTESL.g:1688:2: (iv_ruleTerm= ruleTerm EOF )
            // InternalTESL.g:1689:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalTESL.g:1696:1: ruleTerm returns [EObject current=null] : (this_Factor_0= ruleFactor ( () ( (lv_op_2_0= ruleOpTerm ) ) ( (lv_right_3_0= ruleFactor ) ) )* ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Factor_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1699:28: ( (this_Factor_0= ruleFactor ( () ( (lv_op_2_0= ruleOpTerm ) ) ( (lv_right_3_0= ruleFactor ) ) )* ) )
            // InternalTESL.g:1700:1: (this_Factor_0= ruleFactor ( () ( (lv_op_2_0= ruleOpTerm ) ) ( (lv_right_3_0= ruleFactor ) ) )* )
            {
            // InternalTESL.g:1700:1: (this_Factor_0= ruleFactor ( () ( (lv_op_2_0= ruleOpTerm ) ) ( (lv_right_3_0= ruleFactor ) ) )* )
            // InternalTESL.g:1701:5: this_Factor_0= ruleFactor ( () ( (lv_op_2_0= ruleOpTerm ) ) ( (lv_right_3_0= ruleFactor ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getTermAccess().getFactorParserRuleCall_0()); 
                
            pushFollow(FOLLOW_34);
            this_Factor_0=ruleFactor();

            state._fsp--;

             
                    current = this_Factor_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalTESL.g:1709:1: ( () ( (lv_op_2_0= ruleOpTerm ) ) ( (lv_right_3_0= ruleFactor ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==61||LA26_0==100) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalTESL.g:1709:2: () ( (lv_op_2_0= ruleOpTerm ) ) ( (lv_right_3_0= ruleFactor ) )
            	    {
            	    // InternalTESL.g:1709:2: ()
            	    // InternalTESL.g:1710:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getTermAccess().getBinOpLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // InternalTESL.g:1715:2: ( (lv_op_2_0= ruleOpTerm ) )
            	    // InternalTESL.g:1716:1: (lv_op_2_0= ruleOpTerm )
            	    {
            	    // InternalTESL.g:1716:1: (lv_op_2_0= ruleOpTerm )
            	    // InternalTESL.g:1717:3: lv_op_2_0= ruleOpTerm
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTermAccess().getOpOpTermEnumRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_op_2_0=ruleOpTerm();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTermRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"op",
            	            		lv_op_2_0, 
            	            		"fr.supelec.tesl.lang.TESL.OpTerm");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // InternalTESL.g:1733:2: ( (lv_right_3_0= ruleFactor ) )
            	    // InternalTESL.g:1734:1: (lv_right_3_0= ruleFactor )
            	    {
            	    // InternalTESL.g:1734:1: (lv_right_3_0= ruleFactor )
            	    // InternalTESL.g:1735:3: lv_right_3_0= ruleFactor
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTermAccess().getRightFactorParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_34);
            	    lv_right_3_0=ruleFactor();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTermRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"fr.supelec.tesl.lang.TESL.Factor");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleFactor"
    // InternalTESL.g:1759:1: entryRuleFactor returns [EObject current=null] : iv_ruleFactor= ruleFactor EOF ;
    public final EObject entryRuleFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFactor = null;


        try {
            // InternalTESL.g:1760:2: (iv_ruleFactor= ruleFactor EOF )
            // InternalTESL.g:1761:2: iv_ruleFactor= ruleFactor EOF
            {
             newCompositeNode(grammarAccess.getFactorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFactor=ruleFactor();

            state._fsp--;

             current =iv_ruleFactor; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFactor"


    // $ANTLR start "ruleFactor"
    // InternalTESL.g:1768:1: ruleFactor returns [EObject current=null] : (this_BasicExpr_0= ruleBasicExpr ( () ( (lv_op_2_0= ruleOpFact ) ) ( (lv_right_3_0= ruleBasicExpr ) ) )* ) ;
    public final EObject ruleFactor() throws RecognitionException {
        EObject current = null;

        EObject this_BasicExpr_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1771:28: ( (this_BasicExpr_0= ruleBasicExpr ( () ( (lv_op_2_0= ruleOpFact ) ) ( (lv_right_3_0= ruleBasicExpr ) ) )* ) )
            // InternalTESL.g:1772:1: (this_BasicExpr_0= ruleBasicExpr ( () ( (lv_op_2_0= ruleOpFact ) ) ( (lv_right_3_0= ruleBasicExpr ) ) )* )
            {
            // InternalTESL.g:1772:1: (this_BasicExpr_0= ruleBasicExpr ( () ( (lv_op_2_0= ruleOpFact ) ) ( (lv_right_3_0= ruleBasicExpr ) ) )* )
            // InternalTESL.g:1773:5: this_BasicExpr_0= ruleBasicExpr ( () ( (lv_op_2_0= ruleOpFact ) ) ( (lv_right_3_0= ruleBasicExpr ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getFactorAccess().getBasicExprParserRuleCall_0()); 
                
            pushFollow(FOLLOW_35);
            this_BasicExpr_0=ruleBasicExpr();

            state._fsp--;

             
                    current = this_BasicExpr_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalTESL.g:1781:1: ( () ( (lv_op_2_0= ruleOpFact ) ) ( (lv_right_3_0= ruleBasicExpr ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==57) ) {
                    int LA27_2 = input.LA(2);

                    if ( ((LA27_2>=RULE_BIG_INT && LA27_2<=RULE_RATIONAL)||(LA27_2>=44 && LA27_2<=45)||LA27_2==47||(LA27_2>=49 && LA27_2<=52)||LA27_2==61||LA27_2==100) ) {
                        alt27=1;
                    }


                }
                else if ( (LA27_0==101) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalTESL.g:1781:2: () ( (lv_op_2_0= ruleOpFact ) ) ( (lv_right_3_0= ruleBasicExpr ) )
            	    {
            	    // InternalTESL.g:1781:2: ()
            	    // InternalTESL.g:1782:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getFactorAccess().getBinOpLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // InternalTESL.g:1787:2: ( (lv_op_2_0= ruleOpFact ) )
            	    // InternalTESL.g:1788:1: (lv_op_2_0= ruleOpFact )
            	    {
            	    // InternalTESL.g:1788:1: (lv_op_2_0= ruleOpFact )
            	    // InternalTESL.g:1789:3: lv_op_2_0= ruleOpFact
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFactorAccess().getOpOpFactEnumRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_op_2_0=ruleOpFact();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFactorRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"op",
            	            		lv_op_2_0, 
            	            		"fr.supelec.tesl.lang.TESL.OpFact");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // InternalTESL.g:1805:2: ( (lv_right_3_0= ruleBasicExpr ) )
            	    // InternalTESL.g:1806:1: (lv_right_3_0= ruleBasicExpr )
            	    {
            	    // InternalTESL.g:1806:1: (lv_right_3_0= ruleBasicExpr )
            	    // InternalTESL.g:1807:3: lv_right_3_0= ruleBasicExpr
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFactorAccess().getRightBasicExprParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_35);
            	    lv_right_3_0=ruleBasicExpr();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFactorRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"fr.supelec.tesl.lang.TESL.BasicExpr");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFactor"


    // $ANTLR start "entryRuleBasicExpr"
    // InternalTESL.g:1831:1: entryRuleBasicExpr returns [EObject current=null] : iv_ruleBasicExpr= ruleBasicExpr EOF ;
    public final EObject entryRuleBasicExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicExpr = null;


        try {
            // InternalTESL.g:1832:2: (iv_ruleBasicExpr= ruleBasicExpr EOF )
            // InternalTESL.g:1833:2: iv_ruleBasicExpr= ruleBasicExpr EOF
            {
             newCompositeNode(grammarAccess.getBasicExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBasicExpr=ruleBasicExpr();

            state._fsp--;

             current =iv_ruleBasicExpr; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleBasicExpr"


    // $ANTLR start "ruleBasicExpr"
    // InternalTESL.g:1840:1: ruleBasicExpr returns [EObject current=null] : (this_Value_0= ruleValue | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_Cast_4= ruleCast ) ;
    public final EObject ruleBasicExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_Value_0 = null;

        EObject this_Expression_2 = null;

        EObject this_Cast_4 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1843:28: ( (this_Value_0= ruleValue | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_Cast_4= ruleCast ) )
            // InternalTESL.g:1844:1: (this_Value_0= ruleValue | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_Cast_4= ruleCast )
            {
            // InternalTESL.g:1844:1: (this_Value_0= ruleValue | (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' ) | this_Cast_4= ruleCast )
            int alt28=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_INT:
            case RULE_BIG_DECIMAL:
            case RULE_FLOAT:
            case RULE_RATIONAL:
            case 44:
            case 61:
            case 100:
                {
                alt28=1;
                }
                break;
            case 45:
                {
                alt28=2;
                }
                break;
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalTESL.g:1845:5: this_Value_0= ruleValue
                    {
                     
                            newCompositeNode(grammarAccess.getBasicExprAccess().getValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Value_0=ruleValue();

                    state._fsp--;

                     
                            current = this_Value_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTESL.g:1854:6: (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' )
                    {
                    // InternalTESL.g:1854:6: (otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')' )
                    // InternalTESL.g:1854:8: otherlv_1= '(' this_Expression_2= ruleExpression otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,45,FOLLOW_7); 

                        	newLeafNode(otherlv_1, grammarAccess.getBasicExprAccess().getLeftParenthesisKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getBasicExprAccess().getExpressionParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_36);
                    this_Expression_2=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_2; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_3=(Token)match(input,46,FOLLOW_2); 

                        	newLeafNode(otherlv_3, grammarAccess.getBasicExprAccess().getRightParenthesisKeyword_1_2());
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalTESL.g:1873:5: this_Cast_4= ruleCast
                    {
                     
                            newCompositeNode(grammarAccess.getBasicExprAccess().getCastParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Cast_4=ruleCast();

                    state._fsp--;

                     
                            current = this_Cast_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicExpr"


    // $ANTLR start "entryRuleCast"
    // InternalTESL.g:1889:1: entryRuleCast returns [EObject current=null] : iv_ruleCast= ruleCast EOF ;
    public final EObject entryRuleCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCast = null;


        try {
            // InternalTESL.g:1890:2: (iv_ruleCast= ruleCast EOF )
            // InternalTESL.g:1891:2: iv_ruleCast= ruleCast EOF
            {
             newCompositeNode(grammarAccess.getCastRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCast=ruleCast();

            state._fsp--;

             current =iv_ruleCast; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCast"


    // $ANTLR start "ruleCast"
    // InternalTESL.g:1898:1: ruleCast returns [EObject current=null] : (this_IntCast_0= ruleIntCast | this_DecimalCast_1= ruleDecimalCast | this_FloatCast_2= ruleFloatCast | this_RationalCast_3= ruleRationalCast ) ;
    public final EObject ruleCast() throws RecognitionException {
        EObject current = null;

        EObject this_IntCast_0 = null;

        EObject this_DecimalCast_1 = null;

        EObject this_FloatCast_2 = null;

        EObject this_RationalCast_3 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1901:28: ( (this_IntCast_0= ruleIntCast | this_DecimalCast_1= ruleDecimalCast | this_FloatCast_2= ruleFloatCast | this_RationalCast_3= ruleRationalCast ) )
            // InternalTESL.g:1902:1: (this_IntCast_0= ruleIntCast | this_DecimalCast_1= ruleDecimalCast | this_FloatCast_2= ruleFloatCast | this_RationalCast_3= ruleRationalCast )
            {
            // InternalTESL.g:1902:1: (this_IntCast_0= ruleIntCast | this_DecimalCast_1= ruleDecimalCast | this_FloatCast_2= ruleFloatCast | this_RationalCast_3= ruleRationalCast )
            int alt29=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt29=1;
                }
                break;
            case 51:
                {
                alt29=2;
                }
                break;
            case 49:
            case 50:
                {
                alt29=3;
                }
                break;
            case 52:
                {
                alt29=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalTESL.g:1903:5: this_IntCast_0= ruleIntCast
                    {
                     
                            newCompositeNode(grammarAccess.getCastAccess().getIntCastParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IntCast_0=ruleIntCast();

                    state._fsp--;

                     
                            current = this_IntCast_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTESL.g:1913:5: this_DecimalCast_1= ruleDecimalCast
                    {
                     
                            newCompositeNode(grammarAccess.getCastAccess().getDecimalCastParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DecimalCast_1=ruleDecimalCast();

                    state._fsp--;

                     
                            current = this_DecimalCast_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalTESL.g:1923:5: this_FloatCast_2= ruleFloatCast
                    {
                     
                            newCompositeNode(grammarAccess.getCastAccess().getFloatCastParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_FloatCast_2=ruleFloatCast();

                    state._fsp--;

                     
                            current = this_FloatCast_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalTESL.g:1933:5: this_RationalCast_3= ruleRationalCast
                    {
                     
                            newCompositeNode(grammarAccess.getCastAccess().getRationalCastParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_RationalCast_3=ruleRationalCast();

                    state._fsp--;

                     
                            current = this_RationalCast_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCast"


    // $ANTLR start "entryRuleIntCast"
    // InternalTESL.g:1949:1: entryRuleIntCast returns [EObject current=null] : iv_ruleIntCast= ruleIntCast EOF ;
    public final EObject entryRuleIntCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntCast = null;


        try {
            // InternalTESL.g:1950:2: (iv_ruleIntCast= ruleIntCast EOF )
            // InternalTESL.g:1951:2: iv_ruleIntCast= ruleIntCast EOF
            {
             newCompositeNode(grammarAccess.getIntCastRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntCast=ruleIntCast();

            state._fsp--;

             current =iv_ruleIntCast; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIntCast"


    // $ANTLR start "ruleIntCast"
    // InternalTESL.g:1958:1: ruleIntCast returns [EObject current=null] : (otherlv_0= '[int ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleIntCast() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:1961:28: ( (otherlv_0= '[int ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' ) )
            // InternalTESL.g:1962:1: (otherlv_0= '[int ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' )
            {
            // InternalTESL.g:1962:1: (otherlv_0= '[int ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' )
            // InternalTESL.g:1962:3: otherlv_0= '[int ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getIntCastAccess().getIntKeyword_0());
                
            // InternalTESL.g:1966:1: ( (lv_expr_1_0= ruleExpression ) )
            // InternalTESL.g:1967:1: (lv_expr_1_0= ruleExpression )
            {
            // InternalTESL.g:1967:1: (lv_expr_1_0= ruleExpression )
            // InternalTESL.g:1968:3: lv_expr_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIntCastAccess().getExprExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_37);
            lv_expr_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntCastRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_1_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,48,FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getIntCastAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntCast"


    // $ANTLR start "entryRuleFloatCast"
    // InternalTESL.g:1996:1: entryRuleFloatCast returns [EObject current=null] : iv_ruleFloatCast= ruleFloatCast EOF ;
    public final EObject entryRuleFloatCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatCast = null;


        try {
            // InternalTESL.g:1997:2: (iv_ruleFloatCast= ruleFloatCast EOF )
            // InternalTESL.g:1998:2: iv_ruleFloatCast= ruleFloatCast EOF
            {
             newCompositeNode(grammarAccess.getFloatCastRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatCast=ruleFloatCast();

            state._fsp--;

             current =iv_ruleFloatCast; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFloatCast"


    // $ANTLR start "ruleFloatCast"
    // InternalTESL.g:2005:1: ruleFloatCast returns [EObject current=null] : ( (otherlv_0= '[float ' | otherlv_1= '[double' ) ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ']' ) ;
    public final EObject ruleFloatCast() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:2008:28: ( ( (otherlv_0= '[float ' | otherlv_1= '[double' ) ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ']' ) )
            // InternalTESL.g:2009:1: ( (otherlv_0= '[float ' | otherlv_1= '[double' ) ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ']' )
            {
            // InternalTESL.g:2009:1: ( (otherlv_0= '[float ' | otherlv_1= '[double' ) ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ']' )
            // InternalTESL.g:2009:2: (otherlv_0= '[float ' | otherlv_1= '[double' ) ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ']'
            {
            // InternalTESL.g:2009:2: (otherlv_0= '[float ' | otherlv_1= '[double' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==49) ) {
                alt30=1;
            }
            else if ( (LA30_0==50) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalTESL.g:2009:4: otherlv_0= '[float '
                    {
                    otherlv_0=(Token)match(input,49,FOLLOW_7); 

                        	newLeafNode(otherlv_0, grammarAccess.getFloatCastAccess().getFloatKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // InternalTESL.g:2014:7: otherlv_1= '[double'
                    {
                    otherlv_1=(Token)match(input,50,FOLLOW_7); 

                        	newLeafNode(otherlv_1, grammarAccess.getFloatCastAccess().getDoubleKeyword_0_1());
                        

                    }
                    break;

            }

            // InternalTESL.g:2018:2: ( (lv_expr_2_0= ruleExpression ) )
            // InternalTESL.g:2019:1: (lv_expr_2_0= ruleExpression )
            {
            // InternalTESL.g:2019:1: (lv_expr_2_0= ruleExpression )
            // InternalTESL.g:2020:3: lv_expr_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getFloatCastAccess().getExprExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_37);
            lv_expr_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFloatCastRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_2_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,48,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getFloatCastAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatCast"


    // $ANTLR start "entryRuleDecimalCast"
    // InternalTESL.g:2048:1: entryRuleDecimalCast returns [EObject current=null] : iv_ruleDecimalCast= ruleDecimalCast EOF ;
    public final EObject entryRuleDecimalCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalCast = null;


        try {
            // InternalTESL.g:2049:2: (iv_ruleDecimalCast= ruleDecimalCast EOF )
            // InternalTESL.g:2050:2: iv_ruleDecimalCast= ruleDecimalCast EOF
            {
             newCompositeNode(grammarAccess.getDecimalCastRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimalCast=ruleDecimalCast();

            state._fsp--;

             current =iv_ruleDecimalCast; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDecimalCast"


    // $ANTLR start "ruleDecimalCast"
    // InternalTESL.g:2057:1: ruleDecimalCast returns [EObject current=null] : (otherlv_0= '[decimal' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleDecimalCast() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:2060:28: ( (otherlv_0= '[decimal' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' ) )
            // InternalTESL.g:2061:1: (otherlv_0= '[decimal' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' )
            {
            // InternalTESL.g:2061:1: (otherlv_0= '[decimal' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' )
            // InternalTESL.g:2061:3: otherlv_0= '[decimal' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getDecimalCastAccess().getDecimalKeyword_0());
                
            // InternalTESL.g:2065:1: ( (lv_expr_1_0= ruleExpression ) )
            // InternalTESL.g:2066:1: (lv_expr_1_0= ruleExpression )
            {
            // InternalTESL.g:2066:1: (lv_expr_1_0= ruleExpression )
            // InternalTESL.g:2067:3: lv_expr_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getDecimalCastAccess().getExprExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_37);
            lv_expr_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDecimalCastRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_1_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,48,FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getDecimalCastAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecimalCast"


    // $ANTLR start "entryRuleRationalCast"
    // InternalTESL.g:2095:1: entryRuleRationalCast returns [EObject current=null] : iv_ruleRationalCast= ruleRationalCast EOF ;
    public final EObject entryRuleRationalCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRationalCast = null;


        try {
            // InternalTESL.g:2096:2: (iv_ruleRationalCast= ruleRationalCast EOF )
            // InternalTESL.g:2097:2: iv_ruleRationalCast= ruleRationalCast EOF
            {
             newCompositeNode(grammarAccess.getRationalCastRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRationalCast=ruleRationalCast();

            state._fsp--;

             current =iv_ruleRationalCast; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRationalCast"


    // $ANTLR start "ruleRationalCast"
    // InternalTESL.g:2104:1: ruleRationalCast returns [EObject current=null] : (otherlv_0= '[rational ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' ) ;
    public final EObject ruleRationalCast() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:2107:28: ( (otherlv_0= '[rational ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' ) )
            // InternalTESL.g:2108:1: (otherlv_0= '[rational ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' )
            {
            // InternalTESL.g:2108:1: (otherlv_0= '[rational ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']' )
            // InternalTESL.g:2108:3: otherlv_0= '[rational ' ( (lv_expr_1_0= ruleExpression ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getRationalCastAccess().getRationalKeyword_0());
                
            // InternalTESL.g:2112:1: ( (lv_expr_1_0= ruleExpression ) )
            // InternalTESL.g:2113:1: (lv_expr_1_0= ruleExpression )
            {
            // InternalTESL.g:2113:1: (lv_expr_1_0= ruleExpression )
            // InternalTESL.g:2114:3: lv_expr_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getRationalCastAccess().getExprExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_37);
            lv_expr_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRationalCastRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_1_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,48,FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getRationalCastAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRationalCast"


    // $ANTLR start "entryRuleWhenQualifier"
    // InternalTESL.g:2142:1: entryRuleWhenQualifier returns [EObject current=null] : iv_ruleWhenQualifier= ruleWhenQualifier EOF ;
    public final EObject entryRuleWhenQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhenQualifier = null;


        try {
            // InternalTESL.g:2143:2: (iv_ruleWhenQualifier= ruleWhenQualifier EOF )
            // InternalTESL.g:2144:2: iv_ruleWhenQualifier= ruleWhenQualifier EOF
            {
             newCompositeNode(grammarAccess.getWhenQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWhenQualifier=ruleWhenQualifier();

            state._fsp--;

             current =iv_ruleWhenQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleWhenQualifier"


    // $ANTLR start "ruleWhenQualifier"
    // InternalTESL.g:2151:1: ruleWhenQualifier returns [EObject current=null] : (otherlv_0= 'when' ( (lv_not_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleWhenQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_not_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:2154:28: ( (otherlv_0= 'when' ( (lv_not_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) ) )
            // InternalTESL.g:2155:1: (otherlv_0= 'when' ( (lv_not_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalTESL.g:2155:1: (otherlv_0= 'when' ( (lv_not_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) ) )
            // InternalTESL.g:2155:3: otherlv_0= 'when' ( (lv_not_1_0= 'not' ) )? ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_38); 

                	newLeafNode(otherlv_0, grammarAccess.getWhenQualifierAccess().getWhenKeyword_0());
                
            // InternalTESL.g:2159:1: ( (lv_not_1_0= 'not' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==54) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalTESL.g:2160:1: (lv_not_1_0= 'not' )
                    {
                    // InternalTESL.g:2160:1: (lv_not_1_0= 'not' )
                    // InternalTESL.g:2161:3: lv_not_1_0= 'not'
                    {
                    lv_not_1_0=(Token)match(input,54,FOLLOW_5); 

                            newLeafNode(lv_not_1_0, grammarAccess.getWhenQualifierAccess().getNotNotKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWhenQualifierRule());
                    	        }
                           		setWithLastConsumed(current, "not", true, "not");
                    	    

                    }


                    }
                    break;

            }

            // InternalTESL.g:2174:3: ( (otherlv_2= RULE_ID ) )
            // InternalTESL.g:2175:1: (otherlv_2= RULE_ID )
            {
            // InternalTESL.g:2175:1: (otherlv_2= RULE_ID )
            // InternalTESL.g:2176:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getWhenQualifierRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_2, grammarAccess.getWhenQualifierAccess().getClockClockCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhenQualifier"


    // $ANTLR start "entryRuleNextQualifier"
    // InternalTESL.g:2195:1: entryRuleNextQualifier returns [EObject current=null] : iv_ruleNextQualifier= ruleNextQualifier EOF ;
    public final EObject entryRuleNextQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextQualifier = null;


        try {
            // InternalTESL.g:2196:2: (iv_ruleNextQualifier= ruleNextQualifier EOF )
            // InternalTESL.g:2197:2: iv_ruleNextQualifier= ruleNextQualifier EOF
            {
             newCompositeNode(grammarAccess.getNextQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNextQualifier=ruleNextQualifier();

            state._fsp--;

             current =iv_ruleNextQualifier; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNextQualifier"


    // $ANTLR start "ruleNextQualifier"
    // InternalTESL.g:2204:1: ruleNextQualifier returns [EObject current=null] : ( ( (lv_strict_0_0= 'strictly' ) )? otherlv_1= 'next' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleNextQualifier() throws RecognitionException {
        EObject current = null;

        Token lv_strict_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:2207:28: ( ( ( (lv_strict_0_0= 'strictly' ) )? otherlv_1= 'next' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalTESL.g:2208:1: ( ( (lv_strict_0_0= 'strictly' ) )? otherlv_1= 'next' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalTESL.g:2208:1: ( ( (lv_strict_0_0= 'strictly' ) )? otherlv_1= 'next' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) )
            // InternalTESL.g:2208:2: ( (lv_strict_0_0= 'strictly' ) )? otherlv_1= 'next' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) )
            {
            // InternalTESL.g:2208:2: ( (lv_strict_0_0= 'strictly' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==55) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTESL.g:2209:1: (lv_strict_0_0= 'strictly' )
                    {
                    // InternalTESL.g:2209:1: (lv_strict_0_0= 'strictly' )
                    // InternalTESL.g:2210:3: lv_strict_0_0= 'strictly'
                    {
                    lv_strict_0_0=(Token)match(input,55,FOLLOW_39); 

                            newLeafNode(lv_strict_0_0, grammarAccess.getNextQualifierAccess().getStrictStrictlyKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNextQualifierRule());
                    	        }
                           		setWithLastConsumed(current, "strict", true, "strictly");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,56,FOLLOW_24); 

                	newLeafNode(otherlv_1, grammarAccess.getNextQualifierAccess().getNextKeyword_1());
                
            otherlv_2=(Token)match(input,38,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getNextQualifierAccess().getToKeyword_2());
                
            // InternalTESL.g:2231:1: ( (otherlv_3= RULE_ID ) )
            // InternalTESL.g:2232:1: (otherlv_3= RULE_ID )
            {
            // InternalTESL.g:2232:1: (otherlv_3= RULE_ID )
            // InternalTESL.g:2233:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNextQualifierRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_3, grammarAccess.getNextQualifierAccess().getClockClockCrossReference_3_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNextQualifier"


    // $ANTLR start "entryRulePattern"
    // InternalTESL.g:2252:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalTESL.g:2253:2: (iv_rulePattern= rulePattern EOF )
            // InternalTESL.g:2254:2: iv_rulePattern= rulePattern EOF
            {
             newCompositeNode(grammarAccess.getPatternRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePattern=rulePattern();

            state._fsp--;

             current =iv_rulePattern; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalTESL.g:2261:1: rulePattern returns [EObject current=null] : ( ( (lv_skip_0_0= ruleExpression ) ) otherlv_1= ',' ( (lv_keep_2_0= ruleExpression ) ) ( ( (lv_rep_3_0= '(' ) ) ( (lv_repskip_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_repkeep_6_0= ruleExpression ) ) otherlv_7= ')' otherlv_8= '*' )? ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_rep_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_skip_0_0 = null;

        EObject lv_keep_2_0 = null;

        EObject lv_repskip_4_0 = null;

        EObject lv_repkeep_6_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:2264:28: ( ( ( (lv_skip_0_0= ruleExpression ) ) otherlv_1= ',' ( (lv_keep_2_0= ruleExpression ) ) ( ( (lv_rep_3_0= '(' ) ) ( (lv_repskip_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_repkeep_6_0= ruleExpression ) ) otherlv_7= ')' otherlv_8= '*' )? ) )
            // InternalTESL.g:2265:1: ( ( (lv_skip_0_0= ruleExpression ) ) otherlv_1= ',' ( (lv_keep_2_0= ruleExpression ) ) ( ( (lv_rep_3_0= '(' ) ) ( (lv_repskip_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_repkeep_6_0= ruleExpression ) ) otherlv_7= ')' otherlv_8= '*' )? )
            {
            // InternalTESL.g:2265:1: ( ( (lv_skip_0_0= ruleExpression ) ) otherlv_1= ',' ( (lv_keep_2_0= ruleExpression ) ) ( ( (lv_rep_3_0= '(' ) ) ( (lv_repskip_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_repkeep_6_0= ruleExpression ) ) otherlv_7= ')' otherlv_8= '*' )? )
            // InternalTESL.g:2265:2: ( (lv_skip_0_0= ruleExpression ) ) otherlv_1= ',' ( (lv_keep_2_0= ruleExpression ) ) ( ( (lv_rep_3_0= '(' ) ) ( (lv_repskip_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_repkeep_6_0= ruleExpression ) ) otherlv_7= ')' otherlv_8= '*' )?
            {
            // InternalTESL.g:2265:2: ( (lv_skip_0_0= ruleExpression ) )
            // InternalTESL.g:2266:1: (lv_skip_0_0= ruleExpression )
            {
            // InternalTESL.g:2266:1: (lv_skip_0_0= ruleExpression )
            // InternalTESL.g:2267:3: lv_skip_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getPatternAccess().getSkipExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_40);
            lv_skip_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPatternRule());
            	        }
                   		set(
                   			current, 
                   			"skip",
                    		lv_skip_0_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_7); 

                	newLeafNode(otherlv_1, grammarAccess.getPatternAccess().getCommaKeyword_1());
                
            // InternalTESL.g:2287:1: ( (lv_keep_2_0= ruleExpression ) )
            // InternalTESL.g:2288:1: (lv_keep_2_0= ruleExpression )
            {
            // InternalTESL.g:2288:1: (lv_keep_2_0= ruleExpression )
            // InternalTESL.g:2289:3: lv_keep_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getPatternAccess().getKeepExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_41);
            lv_keep_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPatternRule());
            	        }
                   		set(
                   			current, 
                   			"keep",
                    		lv_keep_2_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTESL.g:2305:2: ( ( (lv_rep_3_0= '(' ) ) ( (lv_repskip_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_repkeep_6_0= ruleExpression ) ) otherlv_7= ')' otherlv_8= '*' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==45) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalTESL.g:2305:3: ( (lv_rep_3_0= '(' ) ) ( (lv_repskip_4_0= ruleExpression ) ) otherlv_5= ',' ( (lv_repkeep_6_0= ruleExpression ) ) otherlv_7= ')' otherlv_8= '*'
                    {
                    // InternalTESL.g:2305:3: ( (lv_rep_3_0= '(' ) )
                    // InternalTESL.g:2306:1: (lv_rep_3_0= '(' )
                    {
                    // InternalTESL.g:2306:1: (lv_rep_3_0= '(' )
                    // InternalTESL.g:2307:3: lv_rep_3_0= '('
                    {
                    lv_rep_3_0=(Token)match(input,45,FOLLOW_7); 

                            newLeafNode(lv_rep_3_0, grammarAccess.getPatternAccess().getRepLeftParenthesisKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPatternRule());
                    	        }
                           		setWithLastConsumed(current, "rep", true, "(");
                    	    

                    }


                    }

                    // InternalTESL.g:2320:2: ( (lv_repskip_4_0= ruleExpression ) )
                    // InternalTESL.g:2321:1: (lv_repskip_4_0= ruleExpression )
                    {
                    // InternalTESL.g:2321:1: (lv_repskip_4_0= ruleExpression )
                    // InternalTESL.g:2322:3: lv_repskip_4_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPatternAccess().getRepskipExpressionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_40);
                    lv_repskip_4_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPatternRule());
                    	        }
                           		set(
                           			current, 
                           			"repskip",
                            		lv_repskip_4_0, 
                            		"fr.supelec.tesl.lang.TESL.Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,21,FOLLOW_7); 

                        	newLeafNode(otherlv_5, grammarAccess.getPatternAccess().getCommaKeyword_3_2());
                        
                    // InternalTESL.g:2342:1: ( (lv_repkeep_6_0= ruleExpression ) )
                    // InternalTESL.g:2343:1: (lv_repkeep_6_0= ruleExpression )
                    {
                    // InternalTESL.g:2343:1: (lv_repkeep_6_0= ruleExpression )
                    // InternalTESL.g:2344:3: lv_repkeep_6_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPatternAccess().getRepkeepExpressionParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FOLLOW_36);
                    lv_repkeep_6_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPatternRule());
                    	        }
                           		set(
                           			current, 
                           			"repkeep",
                            		lv_repkeep_6_0, 
                            		"fr.supelec.tesl.lang.TESL.Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,46,FOLLOW_42); 

                        	newLeafNode(otherlv_7, grammarAccess.getPatternAccess().getRightParenthesisKeyword_3_4());
                        
                    otherlv_8=(Token)match(input,57,FOLLOW_2); 

                        	newLeafNode(otherlv_8, grammarAccess.getPatternAccess().getAsteriskKeyword_3_5());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleTagRelation"
    // InternalTESL.g:2376:1: entryRuleTagRelation returns [EObject current=null] : iv_ruleTagRelation= ruleTagRelation EOF ;
    public final EObject entryRuleTagRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTagRelation = null;


        try {
            // InternalTESL.g:2377:2: (iv_ruleTagRelation= ruleTagRelation EOF )
            // InternalTESL.g:2378:2: iv_ruleTagRelation= ruleTagRelation EOF
            {
             newCompositeNode(grammarAccess.getTagRelationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTagRelation=ruleTagRelation();

            state._fsp--;

             current =iv_ruleTagRelation; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTagRelation"


    // $ANTLR start "ruleTagRelation"
    // InternalTESL.g:2385:1: ruleTagRelation returns [EObject current=null] : ( (otherlv_0= 'tag' otherlv_1= 'relation' ( (lv_expr_2_0= ruleTagExpr ) ) ) | (otherlv_3= 'time' otherlv_4= 'relation' ( (lv_expr_5_0= ruleTagExpr ) ) ) ) ;
    public final EObject ruleTagRelation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expr_2_0 = null;

        EObject lv_expr_5_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:2388:28: ( ( (otherlv_0= 'tag' otherlv_1= 'relation' ( (lv_expr_2_0= ruleTagExpr ) ) ) | (otherlv_3= 'time' otherlv_4= 'relation' ( (lv_expr_5_0= ruleTagExpr ) ) ) ) )
            // InternalTESL.g:2389:1: ( (otherlv_0= 'tag' otherlv_1= 'relation' ( (lv_expr_2_0= ruleTagExpr ) ) ) | (otherlv_3= 'time' otherlv_4= 'relation' ( (lv_expr_5_0= ruleTagExpr ) ) ) )
            {
            // InternalTESL.g:2389:1: ( (otherlv_0= 'tag' otherlv_1= 'relation' ( (lv_expr_2_0= ruleTagExpr ) ) ) | (otherlv_3= 'time' otherlv_4= 'relation' ( (lv_expr_5_0= ruleTagExpr ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==58) ) {
                alt34=1;
            }
            else if ( (LA34_0==40) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalTESL.g:2389:2: (otherlv_0= 'tag' otherlv_1= 'relation' ( (lv_expr_2_0= ruleTagExpr ) ) )
                    {
                    // InternalTESL.g:2389:2: (otherlv_0= 'tag' otherlv_1= 'relation' ( (lv_expr_2_0= ruleTagExpr ) ) )
                    // InternalTESL.g:2389:4: otherlv_0= 'tag' otherlv_1= 'relation' ( (lv_expr_2_0= ruleTagExpr ) )
                    {
                    otherlv_0=(Token)match(input,58,FOLLOW_43); 

                        	newLeafNode(otherlv_0, grammarAccess.getTagRelationAccess().getTagKeyword_0_0());
                        
                    otherlv_1=(Token)match(input,59,FOLLOW_5); 

                        	newLeafNode(otherlv_1, grammarAccess.getTagRelationAccess().getRelationKeyword_0_1());
                        
                    // InternalTESL.g:2397:1: ( (lv_expr_2_0= ruleTagExpr ) )
                    // InternalTESL.g:2398:1: (lv_expr_2_0= ruleTagExpr )
                    {
                    // InternalTESL.g:2398:1: (lv_expr_2_0= ruleTagExpr )
                    // InternalTESL.g:2399:3: lv_expr_2_0= ruleTagExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getTagRelationAccess().getExprTagExprParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_expr_2_0=ruleTagExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTagRelationRule());
                    	        }
                           		set(
                           			current, 
                           			"expr",
                            		lv_expr_2_0, 
                            		"fr.supelec.tesl.lang.TESL.TagExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTESL.g:2416:6: (otherlv_3= 'time' otherlv_4= 'relation' ( (lv_expr_5_0= ruleTagExpr ) ) )
                    {
                    // InternalTESL.g:2416:6: (otherlv_3= 'time' otherlv_4= 'relation' ( (lv_expr_5_0= ruleTagExpr ) ) )
                    // InternalTESL.g:2416:8: otherlv_3= 'time' otherlv_4= 'relation' ( (lv_expr_5_0= ruleTagExpr ) )
                    {
                    otherlv_3=(Token)match(input,40,FOLLOW_43); 

                        	newLeafNode(otherlv_3, grammarAccess.getTagRelationAccess().getTimeKeyword_1_0());
                        
                    otherlv_4=(Token)match(input,59,FOLLOW_5); 

                        	newLeafNode(otherlv_4, grammarAccess.getTagRelationAccess().getRelationKeyword_1_1());
                        
                    // InternalTESL.g:2424:1: ( (lv_expr_5_0= ruleTagExpr ) )
                    // InternalTESL.g:2425:1: (lv_expr_5_0= ruleTagExpr )
                    {
                    // InternalTESL.g:2425:1: (lv_expr_5_0= ruleTagExpr )
                    // InternalTESL.g:2426:3: lv_expr_5_0= ruleTagExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getTagRelationAccess().getExprTagExprParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_expr_5_0=ruleTagExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTagRelationRule());
                    	        }
                           		set(
                           			current, 
                           			"expr",
                            		lv_expr_5_0, 
                            		"fr.supelec.tesl.lang.TESL.TagExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTagRelation"


    // $ANTLR start "entryRuleTagExpr"
    // InternalTESL.g:2450:1: entryRuleTagExpr returns [EObject current=null] : iv_ruleTagExpr= ruleTagExpr EOF ;
    public final EObject entryRuleTagExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTagExpr = null;


        try {
            // InternalTESL.g:2451:2: (iv_ruleTagExpr= ruleTagExpr EOF )
            // InternalTESL.g:2452:2: iv_ruleTagExpr= ruleTagExpr EOF
            {
             newCompositeNode(grammarAccess.getTagExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTagExpr=ruleTagExpr();

            state._fsp--;

             current =iv_ruleTagExpr; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTagExpr"


    // $ANTLR start "ruleTagExpr"
    // InternalTESL.g:2459:1: ruleTagExpr returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( (lv_valueA_3_0= ruleExpression ) ) otherlv_4= '*' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '^' ( (lv_valueN_7_0= ruleBasicExpr ) ) )? (otherlv_8= '+' ( (lv_valueB_9_0= ruleExpression ) ) )? ) ;
    public final EObject ruleTagExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_valueA_3_0 = null;

        EObject lv_valueN_7_0 = null;

        EObject lv_valueB_9_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:2462:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( (lv_valueA_3_0= ruleExpression ) ) otherlv_4= '*' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '^' ( (lv_valueN_7_0= ruleBasicExpr ) ) )? (otherlv_8= '+' ( (lv_valueB_9_0= ruleExpression ) ) )? ) )
            // InternalTESL.g:2463:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( (lv_valueA_3_0= ruleExpression ) ) otherlv_4= '*' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '^' ( (lv_valueN_7_0= ruleBasicExpr ) ) )? (otherlv_8= '+' ( (lv_valueB_9_0= ruleExpression ) ) )? )
            {
            // InternalTESL.g:2463:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( (lv_valueA_3_0= ruleExpression ) ) otherlv_4= '*' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '^' ( (lv_valueN_7_0= ruleBasicExpr ) ) )? (otherlv_8= '+' ( (lv_valueB_9_0= ruleExpression ) ) )? )
            // InternalTESL.g:2463:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( ( (lv_valueA_3_0= ruleExpression ) ) otherlv_4= '*' )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '^' ( (lv_valueN_7_0= ruleBasicExpr ) ) )? (otherlv_8= '+' ( (lv_valueB_9_0= ruleExpression ) ) )?
            {
            // InternalTESL.g:2463:2: ()
            // InternalTESL.g:2464:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTagExprAccess().getTagExprAction_0(),
                        current);
                

            }

            // InternalTESL.g:2469:2: ( (otherlv_1= RULE_ID ) )
            // InternalTESL.g:2470:1: (otherlv_1= RULE_ID )
            {
            // InternalTESL.g:2470:1: (otherlv_1= RULE_ID )
            // InternalTESL.g:2471:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTagExprRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_29); 

            		newLeafNode(otherlv_1, grammarAccess.getTagExprAccess().getClockYClockCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_44); 

                	newLeafNode(otherlv_2, grammarAccess.getTagExprAccess().getEqualsSignKeyword_2());
                
            // InternalTESL.g:2486:1: ( ( (lv_valueA_3_0= ruleExpression ) ) otherlv_4= '*' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_BIG_INT && LA35_0<=RULE_RATIONAL)||(LA35_0>=44 && LA35_0<=45)||LA35_0==47||(LA35_0>=49 && LA35_0<=52)||LA35_0==61||LA35_0==100) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalTESL.g:2486:2: ( (lv_valueA_3_0= ruleExpression ) ) otherlv_4= '*'
                    {
                    // InternalTESL.g:2486:2: ( (lv_valueA_3_0= ruleExpression ) )
                    // InternalTESL.g:2487:1: (lv_valueA_3_0= ruleExpression )
                    {
                    // InternalTESL.g:2487:1: (lv_valueA_3_0= ruleExpression )
                    // InternalTESL.g:2488:3: lv_valueA_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getTagExprAccess().getValueAExpressionParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_42);
                    lv_valueA_3_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTagExprRule());
                    	        }
                           		set(
                           			current, 
                           			"valueA",
                            		lv_valueA_3_0, 
                            		"fr.supelec.tesl.lang.TESL.Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,57,FOLLOW_5); 

                        	newLeafNode(otherlv_4, grammarAccess.getTagExprAccess().getAsteriskKeyword_3_1());
                        

                    }
                    break;

            }

            // InternalTESL.g:2508:3: ( (otherlv_5= RULE_ID ) )
            // InternalTESL.g:2509:1: (otherlv_5= RULE_ID )
            {
            // InternalTESL.g:2509:1: (otherlv_5= RULE_ID )
            // InternalTESL.g:2510:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTagExprRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_45); 

            		newLeafNode(otherlv_5, grammarAccess.getTagExprAccess().getClockXClockCrossReference_4_0()); 
            	

            }


            }

            // InternalTESL.g:2521:2: (otherlv_6= '^' ( (lv_valueN_7_0= ruleBasicExpr ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==60) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalTESL.g:2521:4: otherlv_6= '^' ( (lv_valueN_7_0= ruleBasicExpr ) )
                    {
                    otherlv_6=(Token)match(input,60,FOLLOW_7); 

                        	newLeafNode(otherlv_6, grammarAccess.getTagExprAccess().getCircumflexAccentKeyword_5_0());
                        
                    // InternalTESL.g:2525:1: ( (lv_valueN_7_0= ruleBasicExpr ) )
                    // InternalTESL.g:2526:1: (lv_valueN_7_0= ruleBasicExpr )
                    {
                    // InternalTESL.g:2526:1: (lv_valueN_7_0= ruleBasicExpr )
                    // InternalTESL.g:2527:3: lv_valueN_7_0= ruleBasicExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getTagExprAccess().getValueNBasicExprParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_46);
                    lv_valueN_7_0=ruleBasicExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTagExprRule());
                    	        }
                           		set(
                           			current, 
                           			"valueN",
                            		lv_valueN_7_0, 
                            		"fr.supelec.tesl.lang.TESL.BasicExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalTESL.g:2543:4: (otherlv_8= '+' ( (lv_valueB_9_0= ruleExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==61) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalTESL.g:2543:6: otherlv_8= '+' ( (lv_valueB_9_0= ruleExpression ) )
                    {
                    otherlv_8=(Token)match(input,61,FOLLOW_7); 

                        	newLeafNode(otherlv_8, grammarAccess.getTagExprAccess().getPlusSignKeyword_6_0());
                        
                    // InternalTESL.g:2547:1: ( (lv_valueB_9_0= ruleExpression ) )
                    // InternalTESL.g:2548:1: (lv_valueB_9_0= ruleExpression )
                    {
                    // InternalTESL.g:2548:1: (lv_valueB_9_0= ruleExpression )
                    // InternalTESL.g:2549:3: lv_valueB_9_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getTagExprAccess().getValueBExpressionParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_valueB_9_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTagExprRule());
                    	        }
                           		set(
                           			current, 
                           			"valueB",
                            		lv_valueB_9_0, 
                            		"fr.supelec.tesl.lang.TESL.Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTagExpr"


    // $ANTLR start "entryRulePragma"
    // InternalTESL.g:2573:1: entryRulePragma returns [EObject current=null] : iv_rulePragma= rulePragma EOF ;
    public final EObject entryRulePragma() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragma = null;


        try {
            // InternalTESL.g:2574:2: (iv_rulePragma= rulePragma EOF )
            // InternalTESL.g:2575:2: iv_rulePragma= rulePragma EOF
            {
             newCompositeNode(grammarAccess.getPragmaRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePragma=rulePragma();

            state._fsp--;

             current =iv_rulePragma; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePragma"


    // $ANTLR start "rulePragma"
    // InternalTESL.g:2582:1: rulePragma returns [EObject current=null] : (this_StopPragma_0= ruleStopPragma | this_TagrefPragma_1= ruleTagrefPragma | this_TracePragma_2= ruleTracePragma | this_MaxstepPragma_3= ruleMaxstepPragma | this_OutputPragma_4= ruleOutputPragma | this_DoubleCalcPragma_5= ruleDoubleCalcPragma | this_DumpResultPragma_6= ruleDumpResultPragma ) ;
    public final EObject rulePragma() throws RecognitionException {
        EObject current = null;

        EObject this_StopPragma_0 = null;

        EObject this_TagrefPragma_1 = null;

        EObject this_TracePragma_2 = null;

        EObject this_MaxstepPragma_3 = null;

        EObject this_OutputPragma_4 = null;

        EObject this_DoubleCalcPragma_5 = null;

        EObject this_DumpResultPragma_6 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:2585:28: ( (this_StopPragma_0= ruleStopPragma | this_TagrefPragma_1= ruleTagrefPragma | this_TracePragma_2= ruleTracePragma | this_MaxstepPragma_3= ruleMaxstepPragma | this_OutputPragma_4= ruleOutputPragma | this_DoubleCalcPragma_5= ruleDoubleCalcPragma | this_DumpResultPragma_6= ruleDumpResultPragma ) )
            // InternalTESL.g:2586:1: (this_StopPragma_0= ruleStopPragma | this_TagrefPragma_1= ruleTagrefPragma | this_TracePragma_2= ruleTracePragma | this_MaxstepPragma_3= ruleMaxstepPragma | this_OutputPragma_4= ruleOutputPragma | this_DoubleCalcPragma_5= ruleDoubleCalcPragma | this_DumpResultPragma_6= ruleDumpResultPragma )
            {
            // InternalTESL.g:2586:1: (this_StopPragma_0= ruleStopPragma | this_TagrefPragma_1= ruleTagrefPragma | this_TracePragma_2= ruleTracePragma | this_MaxstepPragma_3= ruleMaxstepPragma | this_OutputPragma_4= ruleOutputPragma | this_DoubleCalcPragma_5= ruleDoubleCalcPragma | this_DumpResultPragma_6= ruleDumpResultPragma )
            int alt38=7;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt38=1;
                }
                break;
            case 63:
                {
                alt38=2;
                }
                break;
            case 64:
                {
                alt38=3;
                }
                break;
            case 65:
                {
                alt38=4;
                }
                break;
            case 66:
                {
                alt38=5;
                }
                break;
            case 81:
                {
                alt38=6;
                }
                break;
            case 83:
                {
                alt38=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalTESL.g:2587:5: this_StopPragma_0= ruleStopPragma
                    {
                     
                            newCompositeNode(grammarAccess.getPragmaAccess().getStopPragmaParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_StopPragma_0=ruleStopPragma();

                    state._fsp--;

                     
                            current = this_StopPragma_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTESL.g:2597:5: this_TagrefPragma_1= ruleTagrefPragma
                    {
                     
                            newCompositeNode(grammarAccess.getPragmaAccess().getTagrefPragmaParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TagrefPragma_1=ruleTagrefPragma();

                    state._fsp--;

                     
                            current = this_TagrefPragma_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalTESL.g:2607:5: this_TracePragma_2= ruleTracePragma
                    {
                     
                            newCompositeNode(grammarAccess.getPragmaAccess().getTracePragmaParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TracePragma_2=ruleTracePragma();

                    state._fsp--;

                     
                            current = this_TracePragma_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalTESL.g:2617:5: this_MaxstepPragma_3= ruleMaxstepPragma
                    {
                     
                            newCompositeNode(grammarAccess.getPragmaAccess().getMaxstepPragmaParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_MaxstepPragma_3=ruleMaxstepPragma();

                    state._fsp--;

                     
                            current = this_MaxstepPragma_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalTESL.g:2627:5: this_OutputPragma_4= ruleOutputPragma
                    {
                     
                            newCompositeNode(grammarAccess.getPragmaAccess().getOutputPragmaParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_OutputPragma_4=ruleOutputPragma();

                    state._fsp--;

                     
                            current = this_OutputPragma_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalTESL.g:2637:5: this_DoubleCalcPragma_5= ruleDoubleCalcPragma
                    {
                     
                            newCompositeNode(grammarAccess.getPragmaAccess().getDoubleCalcPragmaParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DoubleCalcPragma_5=ruleDoubleCalcPragma();

                    state._fsp--;

                     
                            current = this_DoubleCalcPragma_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalTESL.g:2647:5: this_DumpResultPragma_6= ruleDumpResultPragma
                    {
                     
                            newCompositeNode(grammarAccess.getPragmaAccess().getDumpResultPragmaParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DumpResultPragma_6=ruleDumpResultPragma();

                    state._fsp--;

                     
                            current = this_DumpResultPragma_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePragma"


    // $ANTLR start "entryRuleStopPragma"
    // InternalTESL.g:2663:1: entryRuleStopPragma returns [EObject current=null] : iv_ruleStopPragma= ruleStopPragma EOF ;
    public final EObject entryRuleStopPragma() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopPragma = null;


        try {
            // InternalTESL.g:2664:2: (iv_ruleStopPragma= ruleStopPragma EOF )
            // InternalTESL.g:2665:2: iv_ruleStopPragma= ruleStopPragma EOF
            {
             newCompositeNode(grammarAccess.getStopPragmaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStopPragma=ruleStopPragma();

            state._fsp--;

             current =iv_ruleStopPragma; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleStopPragma"


    // $ANTLR start "ruleStopPragma"
    // InternalTESL.g:2672:1: ruleStopPragma returns [EObject current=null] : (otherlv_0= '@stop' otherlv_1= 'when' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleStopPragma() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:2675:28: ( (otherlv_0= '@stop' otherlv_1= 'when' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalTESL.g:2676:1: (otherlv_0= '@stop' otherlv_1= 'when' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalTESL.g:2676:1: (otherlv_0= '@stop' otherlv_1= 'when' ( (otherlv_2= RULE_ID ) ) )
            // InternalTESL.g:2676:3: otherlv_0= '@stop' otherlv_1= 'when' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_47); 

                	newLeafNode(otherlv_0, grammarAccess.getStopPragmaAccess().getStopKeyword_0());
                
            otherlv_1=(Token)match(input,53,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getStopPragmaAccess().getWhenKeyword_1());
                
            // InternalTESL.g:2684:1: ( (otherlv_2= RULE_ID ) )
            // InternalTESL.g:2685:1: (otherlv_2= RULE_ID )
            {
            // InternalTESL.g:2685:1: (otherlv_2= RULE_ID )
            // InternalTESL.g:2686:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStopPragmaRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_2, grammarAccess.getStopPragmaAccess().getClockClockCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStopPragma"


    // $ANTLR start "entryRuleTagrefPragma"
    // InternalTESL.g:2705:1: entryRuleTagrefPragma returns [EObject current=null] : iv_ruleTagrefPragma= ruleTagrefPragma EOF ;
    public final EObject entryRuleTagrefPragma() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTagrefPragma = null;


        try {
            // InternalTESL.g:2706:2: (iv_ruleTagrefPragma= ruleTagrefPragma EOF )
            // InternalTESL.g:2707:2: iv_ruleTagrefPragma= ruleTagrefPragma EOF
            {
             newCompositeNode(grammarAccess.getTagrefPragmaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTagrefPragma=ruleTagrefPragma();

            state._fsp--;

             current =iv_ruleTagrefPragma; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTagrefPragma"


    // $ANTLR start "ruleTagrefPragma"
    // InternalTESL.g:2714:1: ruleTagrefPragma returns [EObject current=null] : (otherlv_0= '@tagref' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTagrefPragma() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:2717:28: ( (otherlv_0= '@tagref' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalTESL.g:2718:1: (otherlv_0= '@tagref' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalTESL.g:2718:1: (otherlv_0= '@tagref' ( (otherlv_1= RULE_ID ) ) )
            // InternalTESL.g:2718:3: otherlv_0= '@tagref' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getTagrefPragmaAccess().getTagrefKeyword_0());
                
            // InternalTESL.g:2722:1: ( (otherlv_1= RULE_ID ) )
            // InternalTESL.g:2723:1: (otherlv_1= RULE_ID )
            {
            // InternalTESL.g:2723:1: (otherlv_1= RULE_ID )
            // InternalTESL.g:2724:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTagrefPragmaRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_1, grammarAccess.getTagrefPragmaAccess().getClockClockCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTagrefPragma"


    // $ANTLR start "entryRuleTracePragma"
    // InternalTESL.g:2743:1: entryRuleTracePragma returns [EObject current=null] : iv_ruleTracePragma= ruleTracePragma EOF ;
    public final EObject entryRuleTracePragma() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTracePragma = null;


        try {
            // InternalTESL.g:2744:2: (iv_ruleTracePragma= ruleTracePragma EOF )
            // InternalTESL.g:2745:2: iv_ruleTracePragma= ruleTracePragma EOF
            {
             newCompositeNode(grammarAccess.getTracePragmaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTracePragma=ruleTracePragma();

            state._fsp--;

             current =iv_ruleTracePragma; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTracePragma"


    // $ANTLR start "ruleTracePragma"
    // InternalTESL.g:2752:1: ruleTracePragma returns [EObject current=null] : (otherlv_0= '@trace' ( (lv_kinds_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_kinds_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleTracePragma() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_kinds_1_0=null;
        Token otherlv_2=null;
        Token lv_kinds_3_0=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:2755:28: ( (otherlv_0= '@trace' ( (lv_kinds_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_kinds_3_0= RULE_ID ) ) )* ) )
            // InternalTESL.g:2756:1: (otherlv_0= '@trace' ( (lv_kinds_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_kinds_3_0= RULE_ID ) ) )* )
            {
            // InternalTESL.g:2756:1: (otherlv_0= '@trace' ( (lv_kinds_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_kinds_3_0= RULE_ID ) ) )* )
            // InternalTESL.g:2756:3: otherlv_0= '@trace' ( (lv_kinds_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_kinds_3_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,64,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getTracePragmaAccess().getTraceKeyword_0());
                
            // InternalTESL.g:2760:1: ( (lv_kinds_1_0= RULE_ID ) )
            // InternalTESL.g:2761:1: (lv_kinds_1_0= RULE_ID )
            {
            // InternalTESL.g:2761:1: (lv_kinds_1_0= RULE_ID )
            // InternalTESL.g:2762:3: lv_kinds_1_0= RULE_ID
            {
            lv_kinds_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            			newLeafNode(lv_kinds_1_0, grammarAccess.getTracePragmaAccess().getKindsIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTracePragmaRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"kinds",
                    		lv_kinds_1_0, 
                    		"fr.supelec.tesl.lang.TESL.ID");
            	    

            }


            }

            // InternalTESL.g:2778:2: (otherlv_2= ',' ( (lv_kinds_3_0= RULE_ID ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==21) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalTESL.g:2778:4: otherlv_2= ',' ( (lv_kinds_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,21,FOLLOW_5); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTracePragmaAccess().getCommaKeyword_2_0());
            	        
            	    // InternalTESL.g:2782:1: ( (lv_kinds_3_0= RULE_ID ) )
            	    // InternalTESL.g:2783:1: (lv_kinds_3_0= RULE_ID )
            	    {
            	    // InternalTESL.g:2783:1: (lv_kinds_3_0= RULE_ID )
            	    // InternalTESL.g:2784:3: lv_kinds_3_0= RULE_ID
            	    {
            	    lv_kinds_3_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            	    			newLeafNode(lv_kinds_3_0, grammarAccess.getTracePragmaAccess().getKindsIDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTracePragmaRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"kinds",
            	            		lv_kinds_3_0, 
            	            		"fr.supelec.tesl.lang.TESL.ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTracePragma"


    // $ANTLR start "entryRuleMaxstepPragma"
    // InternalTESL.g:2808:1: entryRuleMaxstepPragma returns [EObject current=null] : iv_ruleMaxstepPragma= ruleMaxstepPragma EOF ;
    public final EObject entryRuleMaxstepPragma() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxstepPragma = null;


        try {
            // InternalTESL.g:2809:2: (iv_ruleMaxstepPragma= ruleMaxstepPragma EOF )
            // InternalTESL.g:2810:2: iv_ruleMaxstepPragma= ruleMaxstepPragma EOF
            {
             newCompositeNode(grammarAccess.getMaxstepPragmaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxstepPragma=ruleMaxstepPragma();

            state._fsp--;

             current =iv_ruleMaxstepPragma; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMaxstepPragma"


    // $ANTLR start "ruleMaxstepPragma"
    // InternalTESL.g:2817:1: ruleMaxstepPragma returns [EObject current=null] : (otherlv_0= '@maxstep' ( (lv_value_1_0= ruleExpression ) ) ) ;
    public final EObject ruleMaxstepPragma() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:2820:28: ( (otherlv_0= '@maxstep' ( (lv_value_1_0= ruleExpression ) ) ) )
            // InternalTESL.g:2821:1: (otherlv_0= '@maxstep' ( (lv_value_1_0= ruleExpression ) ) )
            {
            // InternalTESL.g:2821:1: (otherlv_0= '@maxstep' ( (lv_value_1_0= ruleExpression ) ) )
            // InternalTESL.g:2821:3: otherlv_0= '@maxstep' ( (lv_value_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,65,FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getMaxstepPragmaAccess().getMaxstepKeyword_0());
                
            // InternalTESL.g:2825:1: ( (lv_value_1_0= ruleExpression ) )
            // InternalTESL.g:2826:1: (lv_value_1_0= ruleExpression )
            {
            // InternalTESL.g:2826:1: (lv_value_1_0= ruleExpression )
            // InternalTESL.g:2827:3: lv_value_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getMaxstepPragmaAccess().getValueExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMaxstepPragmaRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"fr.supelec.tesl.lang.TESL.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxstepPragma"


    // $ANTLR start "entryRuleOutputPragma"
    // InternalTESL.g:2851:1: entryRuleOutputPragma returns [EObject current=null] : iv_ruleOutputPragma= ruleOutputPragma EOF ;
    public final EObject entryRuleOutputPragma() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputPragma = null;


        try {
            // InternalTESL.g:2852:2: (iv_ruleOutputPragma= ruleOutputPragma EOF )
            // InternalTESL.g:2853:2: iv_ruleOutputPragma= ruleOutputPragma EOF
            {
             newCompositeNode(grammarAccess.getOutputPragmaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutputPragma=ruleOutputPragma();

            state._fsp--;

             current =iv_ruleOutputPragma; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOutputPragma"


    // $ANTLR start "ruleOutputPragma"
    // InternalTESL.g:2860:1: ruleOutputPragma returns [EObject current=null] : ( () otherlv_1= '@output' ( ( (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' ) ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleOutputPragma() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_type_2_1=null;
        Token lv_type_2_2=null;
        Token lv_type_2_3=null;
        Token lv_selection_4_0=null;
        Token otherlv_6=null;
        Token lv_window_8_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token lv_xscaled_17_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token lv_border_21_0=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token lv_css_24_0=null;
        Token lv_nodefcss_25_0=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token lv_jvs_28_0=null;
        Token lv_standalone_29_0=null;
        Token lv_overwrite_30_0=null;
        EObject lv_selectedClocks_5_0 = null;

        EObject lv_selectedClocks_7_0 = null;

        EObject lv_from_9_0 = null;

        EObject lv_to_11_0 = null;

        EObject lv_xscale_18_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:2863:28: ( ( () otherlv_1= '@output' ( ( (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' ) ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* ) ) ) ) )
            // InternalTESL.g:2864:1: ( () otherlv_1= '@output' ( ( (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' ) ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* ) ) ) )
            {
            // InternalTESL.g:2864:1: ( () otherlv_1= '@output' ( ( (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' ) ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* ) ) ) )
            // InternalTESL.g:2864:2: () otherlv_1= '@output' ( ( (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' ) ) ) ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* ) ) )
            {
            // InternalTESL.g:2864:2: ()
            // InternalTESL.g:2865:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOutputPragmaAccess().getOutputPragmaAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,66,FOLLOW_48); 

                	newLeafNode(otherlv_1, grammarAccess.getOutputPragmaAccess().getOutputKeyword_1());
                
            // InternalTESL.g:2874:1: ( ( (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' ) ) )
            // InternalTESL.g:2875:1: ( (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' ) )
            {
            // InternalTESL.g:2875:1: ( (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' ) )
            // InternalTESL.g:2876:1: (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' )
            {
            // InternalTESL.g:2876:1: (lv_type_2_1= 'vcd' | lv_type_2_2= 'tikz' | lv_type_2_3= 'svg' )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt40=1;
                }
                break;
            case 68:
                {
                alt40=2;
                }
                break;
            case 69:
                {
                alt40=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalTESL.g:2877:3: lv_type_2_1= 'vcd'
                    {
                    lv_type_2_1=(Token)match(input,67,FOLLOW_49); 

                            newLeafNode(lv_type_2_1, grammarAccess.getOutputPragmaAccess().getTypeVcdKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_2_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalTESL.g:2889:8: lv_type_2_2= 'tikz'
                    {
                    lv_type_2_2=(Token)match(input,68,FOLLOW_49); 

                            newLeafNode(lv_type_2_2, grammarAccess.getOutputPragmaAccess().getTypeTikzKeyword_2_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_2_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalTESL.g:2901:8: lv_type_2_3= 'svg'
                    {
                    lv_type_2_3=(Token)match(input,69,FOLLOW_49); 

                            newLeafNode(lv_type_2_3, grammarAccess.getOutputPragmaAccess().getTypeSvgKeyword_2_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_2_3, null);
                    	    

                    }
                    break;

            }


            }


            }

            // InternalTESL.g:2916:2: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* ) ) )
            // InternalTESL.g:2918:1: ( ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* ) )
            {
            // InternalTESL.g:2918:1: ( ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* ) )
            // InternalTESL.g:2919:2: ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	
            // InternalTESL.g:2922:2: ( ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )* )
            // InternalTESL.g:2923:3: ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )*
            {
            // InternalTESL.g:2923:3: ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )*
            loop44:
            do {
                int alt44=10;
                alt44 = dfa44.predict(input);
                switch (alt44) {
            	case 1 :
            	    // InternalTESL.g:2925:4: ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) )
            	    {
            	    // InternalTESL.g:2925:4: ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) )
            	    // InternalTESL.g:2926:5: {...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalTESL.g:2926:109: ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) )
            	    // InternalTESL.g:2927:6: ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // InternalTESL.g:2930:6: ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) )
            	    // InternalTESL.g:2930:7: {...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "true");
            	    }
            	    // InternalTESL.g:2930:16: ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* )
            	    // InternalTESL.g:2930:17: ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )*
            	    {
            	    // InternalTESL.g:2930:17: ( (lv_selection_4_0= 'select' ) )
            	    // InternalTESL.g:2931:1: (lv_selection_4_0= 'select' )
            	    {
            	    // InternalTESL.g:2931:1: (lv_selection_4_0= 'select' )
            	    // InternalTESL.g:2932:3: lv_selection_4_0= 'select'
            	    {
            	    lv_selection_4_0=(Token)match(input,70,FOLLOW_5); 

            	            newLeafNode(lv_selection_4_0, grammarAccess.getOutputPragmaAccess().getSelectionSelectKeyword_3_0_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		setWithLastConsumed(current, "selection", true, "select");
            	    	    

            	    }


            	    }

            	    // InternalTESL.g:2945:2: ( (lv_selectedClocks_5_0= ruleClockItem ) )
            	    // InternalTESL.g:2946:1: (lv_selectedClocks_5_0= ruleClockItem )
            	    {
            	    // InternalTESL.g:2946:1: (lv_selectedClocks_5_0= ruleClockItem )
            	    // InternalTESL.g:2947:3: lv_selectedClocks_5_0= ruleClockItem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOutputPragmaAccess().getSelectedClocksClockItemParserRuleCall_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_50);
            	    lv_selectedClocks_5_0=ruleClockItem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"selectedClocks",
            	            		lv_selectedClocks_5_0, 
            	            		"fr.supelec.tesl.lang.TESL.ClockItem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // InternalTESL.g:2963:2: (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )*
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==21) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // InternalTESL.g:2963:4: otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) )
            	    	    {
            	    	    otherlv_6=(Token)match(input,21,FOLLOW_5); 

            	    	        	newLeafNode(otherlv_6, grammarAccess.getOutputPragmaAccess().getCommaKeyword_3_0_2_0());
            	    	        
            	    	    // InternalTESL.g:2967:1: ( (lv_selectedClocks_7_0= ruleClockItem ) )
            	    	    // InternalTESL.g:2968:1: (lv_selectedClocks_7_0= ruleClockItem )
            	    	    {
            	    	    // InternalTESL.g:2968:1: (lv_selectedClocks_7_0= ruleClockItem )
            	    	    // InternalTESL.g:2969:3: lv_selectedClocks_7_0= ruleClockItem
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getOutputPragmaAccess().getSelectedClocksClockItemParserRuleCall_3_0_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_50);
            	    	    lv_selectedClocks_7_0=ruleClockItem();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getOutputPragmaRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"selectedClocks",
            	    	            		lv_selectedClocks_7_0, 
            	    	            		"fr.supelec.tesl.lang.TESL.ClockItem");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop41;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTESL.g:2992:4: ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) )
            	    {
            	    // InternalTESL.g:2992:4: ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) )
            	    // InternalTESL.g:2993:5: {...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalTESL.g:2993:109: ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) )
            	    // InternalTESL.g:2994:6: ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // InternalTESL.g:2997:6: ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) )
            	    // InternalTESL.g:2997:7: {...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "true");
            	    }
            	    // InternalTESL.g:2997:16: ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) )
            	    // InternalTESL.g:2997:17: ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) )
            	    {
            	    // InternalTESL.g:2997:17: ( (lv_window_8_0= 'from' ) )
            	    // InternalTESL.g:2998:1: (lv_window_8_0= 'from' )
            	    {
            	    // InternalTESL.g:2998:1: (lv_window_8_0= 'from' )
            	    // InternalTESL.g:2999:3: lv_window_8_0= 'from'
            	    {
            	    lv_window_8_0=(Token)match(input,37,FOLLOW_7); 

            	            newLeafNode(lv_window_8_0, grammarAccess.getOutputPragmaAccess().getWindowFromKeyword_3_1_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		setWithLastConsumed(current, "window", true, "from");
            	    	    

            	    }


            	    }

            	    // InternalTESL.g:3012:2: ( (lv_from_9_0= ruleExpression ) )
            	    // InternalTESL.g:3013:1: (lv_from_9_0= ruleExpression )
            	    {
            	    // InternalTESL.g:3013:1: (lv_from_9_0= ruleExpression )
            	    // InternalTESL.g:3014:3: lv_from_9_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOutputPragmaAccess().getFromExpressionParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_24);
            	    lv_from_9_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"from",
            	            		lv_from_9_0, 
            	            		"fr.supelec.tesl.lang.TESL.Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_10=(Token)match(input,38,FOLLOW_7); 

            	        	newLeafNode(otherlv_10, grammarAccess.getOutputPragmaAccess().getToKeyword_3_1_2());
            	        
            	    // InternalTESL.g:3034:1: ( (lv_to_11_0= ruleExpression ) )
            	    // InternalTESL.g:3035:1: (lv_to_11_0= ruleExpression )
            	    {
            	    // InternalTESL.g:3035:1: (lv_to_11_0= ruleExpression )
            	    // InternalTESL.g:3036:3: lv_to_11_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOutputPragmaAccess().getToExpressionParserRuleCall_3_1_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_49);
            	    lv_to_11_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"to",
            	            		lv_to_11_0, 
            	            		"fr.supelec.tesl.lang.TESL.Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTESL.g:3059:4: ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) )
            	    {
            	    // InternalTESL.g:3059:4: ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) )
            	    // InternalTESL.g:3060:5: {...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalTESL.g:3060:109: ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) )
            	    // InternalTESL.g:3061:6: ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // InternalTESL.g:3064:6: ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) )
            	    // InternalTESL.g:3064:7: {...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "true");
            	    }
            	    // InternalTESL.g:3064:16: (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* )
            	    // InternalTESL.g:3064:18: otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )*
            	    {
            	    otherlv_12=(Token)match(input,71,FOLLOW_51); 

            	        	newLeafNode(otherlv_12, grammarAccess.getOutputPragmaAccess().getLabelKeyword_3_2_0());
            	        
            	    otherlv_13=(Token)match(input,72,FOLLOW_5); 

            	        	newLeafNode(otherlv_13, grammarAccess.getOutputPragmaAccess().getIfKeyword_3_2_1());
            	        
            	    // InternalTESL.g:3072:1: ( (otherlv_14= RULE_ID ) )
            	    // InternalTESL.g:3073:1: (otherlv_14= RULE_ID )
            	    {
            	    // InternalTESL.g:3073:1: (otherlv_14= RULE_ID )
            	    // InternalTESL.g:3074:3: otherlv_14= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	        }
            	            
            	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_50); 

            	    		newLeafNode(otherlv_14, grammarAccess.getOutputPragmaAccess().getLabelifClockCrossReference_3_2_2_0()); 
            	    	

            	    }


            	    }

            	    // InternalTESL.g:3085:2: (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )*
            	    loop42:
            	    do {
            	        int alt42=2;
            	        int LA42_0 = input.LA(1);

            	        if ( (LA42_0==21) ) {
            	            alt42=1;
            	        }


            	        switch (alt42) {
            	    	case 1 :
            	    	    // InternalTESL.g:3085:4: otherlv_15= ',' ( (otherlv_16= RULE_ID ) )
            	    	    {
            	    	    otherlv_15=(Token)match(input,21,FOLLOW_5); 

            	    	        	newLeafNode(otherlv_15, grammarAccess.getOutputPragmaAccess().getCommaKeyword_3_2_3_0());
            	    	        
            	    	    // InternalTESL.g:3089:1: ( (otherlv_16= RULE_ID ) )
            	    	    // InternalTESL.g:3090:1: (otherlv_16= RULE_ID )
            	    	    {
            	    	    // InternalTESL.g:3090:1: (otherlv_16= RULE_ID )
            	    	    // InternalTESL.g:3091:3: otherlv_16= RULE_ID
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	    	        }
            	    	            
            	    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_50); 

            	    	    		newLeafNode(otherlv_16, grammarAccess.getOutputPragmaAccess().getLabelifClockCrossReference_3_2_3_1_0()); 
            	    	    	

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop42;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTESL.g:3109:4: ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) )
            	    {
            	    // InternalTESL.g:3109:4: ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) )
            	    // InternalTESL.g:3110:5: {...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalTESL.g:3110:109: ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) )
            	    // InternalTESL.g:3111:6: ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // InternalTESL.g:3114:6: ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) )
            	    // InternalTESL.g:3114:7: {...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "true");
            	    }
            	    // InternalTESL.g:3114:16: ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) )
            	    // InternalTESL.g:3114:17: ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) )
            	    {
            	    // InternalTESL.g:3114:17: ( (lv_xscaled_17_0= 'xscale' ) )
            	    // InternalTESL.g:3115:1: (lv_xscaled_17_0= 'xscale' )
            	    {
            	    // InternalTESL.g:3115:1: (lv_xscaled_17_0= 'xscale' )
            	    // InternalTESL.g:3116:3: lv_xscaled_17_0= 'xscale'
            	    {
            	    lv_xscaled_17_0=(Token)match(input,73,FOLLOW_7); 

            	            newLeafNode(lv_xscaled_17_0, grammarAccess.getOutputPragmaAccess().getXscaledXscaleKeyword_3_3_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		setWithLastConsumed(current, "xscaled", true, "xscale");
            	    	    

            	    }


            	    }

            	    // InternalTESL.g:3129:2: ( (lv_xscale_18_0= ruleExpression ) )
            	    // InternalTESL.g:3130:1: (lv_xscale_18_0= ruleExpression )
            	    {
            	    // InternalTESL.g:3130:1: (lv_xscale_18_0= ruleExpression )
            	    // InternalTESL.g:3131:3: lv_xscale_18_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOutputPragmaAccess().getXscaleExpressionParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_49);
            	    lv_xscale_18_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"xscale",
            	            		lv_xscale_18_0, 
            	            		"fr.supelec.tesl.lang.TESL.Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalTESL.g:3154:4: ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalTESL.g:3154:4: ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) )
            	    // InternalTESL.g:3155:5: {...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalTESL.g:3155:109: ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) )
            	    // InternalTESL.g:3156:6: ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // InternalTESL.g:3159:6: ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) )
            	    // InternalTESL.g:3159:7: {...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "true");
            	    }
            	    // InternalTESL.g:3159:16: (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) )
            	    // InternalTESL.g:3159:18: otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) )
            	    {
            	    otherlv_19=(Token)match(input,74,FOLLOW_29); 

            	        	newLeafNode(otherlv_19, grammarAccess.getOutputPragmaAccess().getBorderKeyword_3_4_0());
            	        
            	    otherlv_20=(Token)match(input,43,FOLLOW_52); 

            	        	newLeafNode(otherlv_20, grammarAccess.getOutputPragmaAccess().getEqualsSignKeyword_3_4_1());
            	        
            	    // InternalTESL.g:3167:1: ( (lv_border_21_0= RULE_STRING ) )
            	    // InternalTESL.g:3168:1: (lv_border_21_0= RULE_STRING )
            	    {
            	    // InternalTESL.g:3168:1: (lv_border_21_0= RULE_STRING )
            	    // InternalTESL.g:3169:3: lv_border_21_0= RULE_STRING
            	    {
            	    lv_border_21_0=(Token)match(input,RULE_STRING,FOLLOW_49); 

            	    			newLeafNode(lv_border_21_0, grammarAccess.getOutputPragmaAccess().getBorderSTRINGTerminalRuleCall_3_4_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"border",
            	            		lv_border_21_0, 
            	            		"fr.supelec.tesl.lang.TESL.STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalTESL.g:3192:4: ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalTESL.g:3192:4: ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) )
            	    // InternalTESL.g:3193:5: {...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalTESL.g:3193:109: ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) )
            	    // InternalTESL.g:3194:6: ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // InternalTESL.g:3197:6: ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) )
            	    // InternalTESL.g:3197:7: {...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "true");
            	    }
            	    // InternalTESL.g:3197:16: (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) )
            	    // InternalTESL.g:3197:18: otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) )
            	    {
            	    otherlv_22=(Token)match(input,75,FOLLOW_29); 

            	        	newLeafNode(otherlv_22, grammarAccess.getOutputPragmaAccess().getCssKeyword_3_5_0());
            	        
            	    otherlv_23=(Token)match(input,43,FOLLOW_52); 

            	        	newLeafNode(otherlv_23, grammarAccess.getOutputPragmaAccess().getEqualsSignKeyword_3_5_1());
            	        
            	    // InternalTESL.g:3205:1: ( (lv_css_24_0= RULE_STRING ) )
            	    // InternalTESL.g:3206:1: (lv_css_24_0= RULE_STRING )
            	    {
            	    // InternalTESL.g:3206:1: (lv_css_24_0= RULE_STRING )
            	    // InternalTESL.g:3207:3: lv_css_24_0= RULE_STRING
            	    {
            	    lv_css_24_0=(Token)match(input,RULE_STRING,FOLLOW_49); 

            	    			newLeafNode(lv_css_24_0, grammarAccess.getOutputPragmaAccess().getCssSTRINGTerminalRuleCall_3_5_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"css",
            	            		lv_css_24_0, 
            	            		"fr.supelec.tesl.lang.TESL.STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalTESL.g:3230:4: ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) )
            	    {
            	    // InternalTESL.g:3230:4: ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) )
            	    // InternalTESL.g:3231:5: {...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalTESL.g:3231:109: ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) )
            	    // InternalTESL.g:3232:6: ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // InternalTESL.g:3235:6: ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) )
            	    // InternalTESL.g:3235:7: {...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "true");
            	    }
            	    // InternalTESL.g:3235:16: ( (lv_nodefcss_25_0= 'no-default-css' ) )
            	    // InternalTESL.g:3236:1: (lv_nodefcss_25_0= 'no-default-css' )
            	    {
            	    // InternalTESL.g:3236:1: (lv_nodefcss_25_0= 'no-default-css' )
            	    // InternalTESL.g:3237:3: lv_nodefcss_25_0= 'no-default-css'
            	    {
            	    lv_nodefcss_25_0=(Token)match(input,76,FOLLOW_49); 

            	            newLeafNode(lv_nodefcss_25_0, grammarAccess.getOutputPragmaAccess().getNodefcssNoDefaultCssKeyword_3_6_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		setWithLastConsumed(current, "nodefcss", true, "no-default-css");
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalTESL.g:3257:4: ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalTESL.g:3257:4: ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) )
            	    // InternalTESL.g:3258:5: {...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalTESL.g:3258:109: ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) )
            	    // InternalTESL.g:3259:6: ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 7);
            	    	 				
            	    // InternalTESL.g:3262:6: ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) )
            	    // InternalTESL.g:3262:7: {...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "true");
            	    }
            	    // InternalTESL.g:3262:16: (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) )
            	    // InternalTESL.g:3262:18: otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) )
            	    {
            	    otherlv_26=(Token)match(input,77,FOLLOW_29); 

            	        	newLeafNode(otherlv_26, grammarAccess.getOutputPragmaAccess().getJavascriptKeyword_3_7_0());
            	        
            	    otherlv_27=(Token)match(input,43,FOLLOW_52); 

            	        	newLeafNode(otherlv_27, grammarAccess.getOutputPragmaAccess().getEqualsSignKeyword_3_7_1());
            	        
            	    // InternalTESL.g:3270:1: ( (lv_jvs_28_0= RULE_STRING ) )
            	    // InternalTESL.g:3271:1: (lv_jvs_28_0= RULE_STRING )
            	    {
            	    // InternalTESL.g:3271:1: (lv_jvs_28_0= RULE_STRING )
            	    // InternalTESL.g:3272:3: lv_jvs_28_0= RULE_STRING
            	    {
            	    lv_jvs_28_0=(Token)match(input,RULE_STRING,FOLLOW_49); 

            	    			newLeafNode(lv_jvs_28_0, grammarAccess.getOutputPragmaAccess().getJvsSTRINGTerminalRuleCall_3_7_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"jvs",
            	            		lv_jvs_28_0, 
            	            		"fr.supelec.tesl.lang.TESL.STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalTESL.g:3295:4: ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) )
            	    {
            	    // InternalTESL.g:3295:4: ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) )
            	    // InternalTESL.g:3296:5: {...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalTESL.g:3296:109: ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) )
            	    // InternalTESL.g:3297:6: ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 8);
            	    	 				
            	    // InternalTESL.g:3300:6: ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) )
            	    // InternalTESL.g:3300:7: {...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleOutputPragma", "true");
            	    }
            	    // InternalTESL.g:3300:16: ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? )
            	    // InternalTESL.g:3300:17: ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )?
            	    {
            	    // InternalTESL.g:3300:17: ( (lv_standalone_29_0= 'standalone' ) )
            	    // InternalTESL.g:3301:1: (lv_standalone_29_0= 'standalone' )
            	    {
            	    // InternalTESL.g:3301:1: (lv_standalone_29_0= 'standalone' )
            	    // InternalTESL.g:3302:3: lv_standalone_29_0= 'standalone'
            	    {
            	    lv_standalone_29_0=(Token)match(input,78,FOLLOW_53); 

            	            newLeafNode(lv_standalone_29_0, grammarAccess.getOutputPragmaAccess().getStandaloneStandaloneKeyword_3_8_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	    	        }
            	           		setWithLastConsumed(current, "standalone", true, "standalone");
            	    	    

            	    }


            	    }

            	    // InternalTESL.g:3315:2: ( (lv_overwrite_30_0= 'overwrite' ) )?
            	    int alt43=2;
            	    int LA43_0 = input.LA(1);

            	    if ( (LA43_0==79) ) {
            	        alt43=1;
            	    }
            	    switch (alt43) {
            	        case 1 :
            	            // InternalTESL.g:3316:1: (lv_overwrite_30_0= 'overwrite' )
            	            {
            	            // InternalTESL.g:3316:1: (lv_overwrite_30_0= 'overwrite' )
            	            // InternalTESL.g:3317:3: lv_overwrite_30_0= 'overwrite'
            	            {
            	            lv_overwrite_30_0=(Token)match(input,79,FOLLOW_49); 

            	                    newLeafNode(lv_overwrite_30_0, grammarAccess.getOutputPragmaAccess().getOverwriteOverwriteKeyword_3_8_1_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getOutputPragmaRule());
            	            	        }
            	                   		setWithLastConsumed(current, "overwrite", true, "overwrite");
            	            	    

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3());
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputPragma"


    // $ANTLR start "entryRuleClockItem"
    // InternalTESL.g:3352:1: entryRuleClockItem returns [EObject current=null] : iv_ruleClockItem= ruleClockItem EOF ;
    public final EObject entryRuleClockItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClockItem = null;


        try {
            // InternalTESL.g:3353:2: (iv_ruleClockItem= ruleClockItem EOF )
            // InternalTESL.g:3354:2: iv_ruleClockItem= ruleClockItem EOF
            {
             newCompositeNode(grammarAccess.getClockItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClockItem=ruleClockItem();

            state._fsp--;

             current =iv_ruleClockItem; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleClockItem"


    // $ANTLR start "ruleClockItem"
    // InternalTESL.g:3361:1: ruleClockItem returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (lv_newName_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleClockItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_newName_2_0=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:3364:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (lv_newName_2_0= RULE_ID ) ) )? ) )
            // InternalTESL.g:3365:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (lv_newName_2_0= RULE_ID ) ) )? )
            {
            // InternalTESL.g:3365:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (lv_newName_2_0= RULE_ID ) ) )? )
            // InternalTESL.g:3365:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (lv_newName_2_0= RULE_ID ) ) )?
            {
            // InternalTESL.g:3365:2: ( (otherlv_0= RULE_ID ) )
            // InternalTESL.g:3366:1: (otherlv_0= RULE_ID )
            {
            // InternalTESL.g:3366:1: (otherlv_0= RULE_ID )
            // InternalTESL.g:3367:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getClockItemRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_54); 

            		newLeafNode(otherlv_0, grammarAccess.getClockItemAccess().getClockClockCrossReference_0_0()); 
            	

            }


            }

            // InternalTESL.g:3378:2: (otherlv_1= '->' ( (lv_newName_2_0= RULE_ID ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==80) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalTESL.g:3378:4: otherlv_1= '->' ( (lv_newName_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,80,FOLLOW_5); 

                        	newLeafNode(otherlv_1, grammarAccess.getClockItemAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                        
                    // InternalTESL.g:3382:1: ( (lv_newName_2_0= RULE_ID ) )
                    // InternalTESL.g:3383:1: (lv_newName_2_0= RULE_ID )
                    {
                    // InternalTESL.g:3383:1: (lv_newName_2_0= RULE_ID )
                    // InternalTESL.g:3384:3: lv_newName_2_0= RULE_ID
                    {
                    lv_newName_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			newLeafNode(lv_newName_2_0, grammarAccess.getClockItemAccess().getNewNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClockItemRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"newName",
                            		lv_newName_2_0, 
                            		"fr.supelec.tesl.lang.TESL.ID");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClockItem"


    // $ANTLR start "entryRuleDoubleCalcPragma"
    // InternalTESL.g:3408:1: entryRuleDoubleCalcPragma returns [EObject current=null] : iv_ruleDoubleCalcPragma= ruleDoubleCalcPragma EOF ;
    public final EObject entryRuleDoubleCalcPragma() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleCalcPragma = null;


        try {
            // InternalTESL.g:3409:2: (iv_ruleDoubleCalcPragma= ruleDoubleCalcPragma EOF )
            // InternalTESL.g:3410:2: iv_ruleDoubleCalcPragma= ruleDoubleCalcPragma EOF
            {
             newCompositeNode(grammarAccess.getDoubleCalcPragmaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDoubleCalcPragma=ruleDoubleCalcPragma();

            state._fsp--;

             current =iv_ruleDoubleCalcPragma; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDoubleCalcPragma"


    // $ANTLR start "ruleDoubleCalcPragma"
    // InternalTESL.g:3417:1: ruleDoubleCalcPragma returns [EObject current=null] : (otherlv_0= '@doublecalc' otherlv_1= 'digits' otherlv_2= '=' ( (lv_num_digits_3_0= RULE_BIG_INT ) ) ( ( (lv_round_4_0= '(' ) ) ( (lv_rounding_mode_5_0= ruleROUNDING_MODE ) ) otherlv_6= ')' )? ) ;
    public final EObject ruleDoubleCalcPragma() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_num_digits_3_0=null;
        Token lv_round_4_0=null;
        Token otherlv_6=null;
        Enumerator lv_rounding_mode_5_0 = null;


         enterRule(); 
            
        try {
            // InternalTESL.g:3420:28: ( (otherlv_0= '@doublecalc' otherlv_1= 'digits' otherlv_2= '=' ( (lv_num_digits_3_0= RULE_BIG_INT ) ) ( ( (lv_round_4_0= '(' ) ) ( (lv_rounding_mode_5_0= ruleROUNDING_MODE ) ) otherlv_6= ')' )? ) )
            // InternalTESL.g:3421:1: (otherlv_0= '@doublecalc' otherlv_1= 'digits' otherlv_2= '=' ( (lv_num_digits_3_0= RULE_BIG_INT ) ) ( ( (lv_round_4_0= '(' ) ) ( (lv_rounding_mode_5_0= ruleROUNDING_MODE ) ) otherlv_6= ')' )? )
            {
            // InternalTESL.g:3421:1: (otherlv_0= '@doublecalc' otherlv_1= 'digits' otherlv_2= '=' ( (lv_num_digits_3_0= RULE_BIG_INT ) ) ( ( (lv_round_4_0= '(' ) ) ( (lv_rounding_mode_5_0= ruleROUNDING_MODE ) ) otherlv_6= ')' )? )
            // InternalTESL.g:3421:3: otherlv_0= '@doublecalc' otherlv_1= 'digits' otherlv_2= '=' ( (lv_num_digits_3_0= RULE_BIG_INT ) ) ( ( (lv_round_4_0= '(' ) ) ( (lv_rounding_mode_5_0= ruleROUNDING_MODE ) ) otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,81,FOLLOW_55); 

                	newLeafNode(otherlv_0, grammarAccess.getDoubleCalcPragmaAccess().getDoublecalcKeyword_0());
                
            otherlv_1=(Token)match(input,82,FOLLOW_29); 

                	newLeafNode(otherlv_1, grammarAccess.getDoubleCalcPragmaAccess().getDigitsKeyword_1());
                
            otherlv_2=(Token)match(input,43,FOLLOW_30); 

                	newLeafNode(otherlv_2, grammarAccess.getDoubleCalcPragmaAccess().getEqualsSignKeyword_2());
                
            // InternalTESL.g:3433:1: ( (lv_num_digits_3_0= RULE_BIG_INT ) )
            // InternalTESL.g:3434:1: (lv_num_digits_3_0= RULE_BIG_INT )
            {
            // InternalTESL.g:3434:1: (lv_num_digits_3_0= RULE_BIG_INT )
            // InternalTESL.g:3435:3: lv_num_digits_3_0= RULE_BIG_INT
            {
            lv_num_digits_3_0=(Token)match(input,RULE_BIG_INT,FOLLOW_41); 

            			newLeafNode(lv_num_digits_3_0, grammarAccess.getDoubleCalcPragmaAccess().getNum_digitsBIG_INTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDoubleCalcPragmaRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"num_digits",
                    		lv_num_digits_3_0, 
                    		"fr.supelec.tesl.lang.TESL.BIG_INT");
            	    

            }


            }

            // InternalTESL.g:3451:2: ( ( (lv_round_4_0= '(' ) ) ( (lv_rounding_mode_5_0= ruleROUNDING_MODE ) ) otherlv_6= ')' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==45) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalTESL.g:3451:3: ( (lv_round_4_0= '(' ) ) ( (lv_rounding_mode_5_0= ruleROUNDING_MODE ) ) otherlv_6= ')'
                    {
                    // InternalTESL.g:3451:3: ( (lv_round_4_0= '(' ) )
                    // InternalTESL.g:3452:1: (lv_round_4_0= '(' )
                    {
                    // InternalTESL.g:3452:1: (lv_round_4_0= '(' )
                    // InternalTESL.g:3453:3: lv_round_4_0= '('
                    {
                    lv_round_4_0=(Token)match(input,45,FOLLOW_56); 

                            newLeafNode(lv_round_4_0, grammarAccess.getDoubleCalcPragmaAccess().getRoundLeftParenthesisKeyword_4_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDoubleCalcPragmaRule());
                    	        }
                           		setWithLastConsumed(current, "round", true, "(");
                    	    

                    }


                    }

                    // InternalTESL.g:3466:2: ( (lv_rounding_mode_5_0= ruleROUNDING_MODE ) )
                    // InternalTESL.g:3467:1: (lv_rounding_mode_5_0= ruleROUNDING_MODE )
                    {
                    // InternalTESL.g:3467:1: (lv_rounding_mode_5_0= ruleROUNDING_MODE )
                    // InternalTESL.g:3468:3: lv_rounding_mode_5_0= ruleROUNDING_MODE
                    {
                     
                    	        newCompositeNode(grammarAccess.getDoubleCalcPragmaAccess().getRounding_modeROUNDING_MODEEnumRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_36);
                    lv_rounding_mode_5_0=ruleROUNDING_MODE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDoubleCalcPragmaRule());
                    	        }
                           		set(
                           			current, 
                           			"rounding_mode",
                            		lv_rounding_mode_5_0, 
                            		"fr.supelec.tesl.lang.TESL.ROUNDING_MODE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,46,FOLLOW_2); 

                        	newLeafNode(otherlv_6, grammarAccess.getDoubleCalcPragmaAccess().getRightParenthesisKeyword_4_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleCalcPragma"


    // $ANTLR start "entryRuleDumpResultPragma"
    // InternalTESL.g:3496:1: entryRuleDumpResultPragma returns [EObject current=null] : iv_ruleDumpResultPragma= ruleDumpResultPragma EOF ;
    public final EObject entryRuleDumpResultPragma() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDumpResultPragma = null;


        try {
            // InternalTESL.g:3497:2: (iv_ruleDumpResultPragma= ruleDumpResultPragma EOF )
            // InternalTESL.g:3498:2: iv_ruleDumpResultPragma= ruleDumpResultPragma EOF
            {
             newCompositeNode(grammarAccess.getDumpResultPragmaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDumpResultPragma=ruleDumpResultPragma();

            state._fsp--;

             current =iv_ruleDumpResultPragma; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDumpResultPragma"


    // $ANTLR start "ruleDumpResultPragma"
    // InternalTESL.g:3505:1: ruleDumpResultPragma returns [EObject current=null] : ( () otherlv_1= '@dumpres' ) ;
    public final EObject ruleDumpResultPragma() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalTESL.g:3508:28: ( ( () otherlv_1= '@dumpres' ) )
            // InternalTESL.g:3509:1: ( () otherlv_1= '@dumpres' )
            {
            // InternalTESL.g:3509:1: ( () otherlv_1= '@dumpres' )
            // InternalTESL.g:3509:2: () otherlv_1= '@dumpres'
            {
            // InternalTESL.g:3509:2: ()
            // InternalTESL.g:3510:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDumpResultPragmaAccess().getDumpResultPragmaAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,83,FOLLOW_2); 

                	newLeafNode(otherlv_1, grammarAccess.getDumpResultPragmaAccess().getDumpresKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDumpResultPragma"


    // $ANTLR start "ruleType"
    // InternalTESL.g:3527:1: ruleType returns [Enumerator current=null] : ( (enumLiteral_0= 'U-clock' ) | (enumLiteral_1= 'unit-clock' ) | (enumLiteral_2= 'Z-clock' ) | (enumLiteral_3= 'int-clock' ) | (enumLiteral_4= 'D-clock' ) | (enumLiteral_5= 'decimal-clock' ) | (enumLiteral_6= 'Q-clock' ) | (enumLiteral_7= 'rational-clock' ) | (enumLiteral_8= 'F-clock' ) | (enumLiteral_9= 'float-clock' ) | (enumLiteral_10= 'double-clock' ) ) ;
    public final Enumerator ruleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;

         enterRule(); 
        try {
            // InternalTESL.g:3529:28: ( ( (enumLiteral_0= 'U-clock' ) | (enumLiteral_1= 'unit-clock' ) | (enumLiteral_2= 'Z-clock' ) | (enumLiteral_3= 'int-clock' ) | (enumLiteral_4= 'D-clock' ) | (enumLiteral_5= 'decimal-clock' ) | (enumLiteral_6= 'Q-clock' ) | (enumLiteral_7= 'rational-clock' ) | (enumLiteral_8= 'F-clock' ) | (enumLiteral_9= 'float-clock' ) | (enumLiteral_10= 'double-clock' ) ) )
            // InternalTESL.g:3530:1: ( (enumLiteral_0= 'U-clock' ) | (enumLiteral_1= 'unit-clock' ) | (enumLiteral_2= 'Z-clock' ) | (enumLiteral_3= 'int-clock' ) | (enumLiteral_4= 'D-clock' ) | (enumLiteral_5= 'decimal-clock' ) | (enumLiteral_6= 'Q-clock' ) | (enumLiteral_7= 'rational-clock' ) | (enumLiteral_8= 'F-clock' ) | (enumLiteral_9= 'float-clock' ) | (enumLiteral_10= 'double-clock' ) )
            {
            // InternalTESL.g:3530:1: ( (enumLiteral_0= 'U-clock' ) | (enumLiteral_1= 'unit-clock' ) | (enumLiteral_2= 'Z-clock' ) | (enumLiteral_3= 'int-clock' ) | (enumLiteral_4= 'D-clock' ) | (enumLiteral_5= 'decimal-clock' ) | (enumLiteral_6= 'Q-clock' ) | (enumLiteral_7= 'rational-clock' ) | (enumLiteral_8= 'F-clock' ) | (enumLiteral_9= 'float-clock' ) | (enumLiteral_10= 'double-clock' ) )
            int alt47=11;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt47=1;
                }
                break;
            case 85:
                {
                alt47=2;
                }
                break;
            case 86:
                {
                alt47=3;
                }
                break;
            case 87:
                {
                alt47=4;
                }
                break;
            case 88:
                {
                alt47=5;
                }
                break;
            case 89:
                {
                alt47=6;
                }
                break;
            case 90:
                {
                alt47=7;
                }
                break;
            case 91:
                {
                alt47=8;
                }
                break;
            case 92:
                {
                alt47=9;
                }
                break;
            case 93:
                {
                alt47=10;
                }
                break;
            case 94:
                {
                alt47=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalTESL.g:3530:2: (enumLiteral_0= 'U-clock' )
                    {
                    // InternalTESL.g:3530:2: (enumLiteral_0= 'U-clock' )
                    // InternalTESL.g:3530:4: enumLiteral_0= 'U-clock'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTUNITEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getTypeAccess().getTUNITEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalTESL.g:3536:6: (enumLiteral_1= 'unit-clock' )
                    {
                    // InternalTESL.g:3536:6: (enumLiteral_1= 'unit-clock' )
                    // InternalTESL.g:3536:8: enumLiteral_1= 'unit-clock'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTUNITEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getTypeAccess().getTUNITEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalTESL.g:3542:6: (enumLiteral_2= 'Z-clock' )
                    {
                    // InternalTESL.g:3542:6: (enumLiteral_2= 'Z-clock' )
                    // InternalTESL.g:3542:8: enumLiteral_2= 'Z-clock'
                    {
                    enumLiteral_2=(Token)match(input,86,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTINTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getTypeAccess().getTINTEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalTESL.g:3548:6: (enumLiteral_3= 'int-clock' )
                    {
                    // InternalTESL.g:3548:6: (enumLiteral_3= 'int-clock' )
                    // InternalTESL.g:3548:8: enumLiteral_3= 'int-clock'
                    {
                    enumLiteral_3=(Token)match(input,87,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTINTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getTypeAccess().getTINTEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalTESL.g:3554:6: (enumLiteral_4= 'D-clock' )
                    {
                    // InternalTESL.g:3554:6: (enumLiteral_4= 'D-clock' )
                    // InternalTESL.g:3554:8: enumLiteral_4= 'D-clock'
                    {
                    enumLiteral_4=(Token)match(input,88,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTDECEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getTypeAccess().getTDECEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalTESL.g:3560:6: (enumLiteral_5= 'decimal-clock' )
                    {
                    // InternalTESL.g:3560:6: (enumLiteral_5= 'decimal-clock' )
                    // InternalTESL.g:3560:8: enumLiteral_5= 'decimal-clock'
                    {
                    enumLiteral_5=(Token)match(input,89,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTDECEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getTypeAccess().getTDECEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalTESL.g:3566:6: (enumLiteral_6= 'Q-clock' )
                    {
                    // InternalTESL.g:3566:6: (enumLiteral_6= 'Q-clock' )
                    // InternalTESL.g:3566:8: enumLiteral_6= 'Q-clock'
                    {
                    enumLiteral_6=(Token)match(input,90,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTRATEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getTypeAccess().getTRATEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalTESL.g:3572:6: (enumLiteral_7= 'rational-clock' )
                    {
                    // InternalTESL.g:3572:6: (enumLiteral_7= 'rational-clock' )
                    // InternalTESL.g:3572:8: enumLiteral_7= 'rational-clock'
                    {
                    enumLiteral_7=(Token)match(input,91,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTRATEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getTypeAccess().getTRATEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalTESL.g:3578:6: (enumLiteral_8= 'F-clock' )
                    {
                    // InternalTESL.g:3578:6: (enumLiteral_8= 'F-clock' )
                    // InternalTESL.g:3578:8: enumLiteral_8= 'F-clock'
                    {
                    enumLiteral_8=(Token)match(input,92,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTFLOATEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getTypeAccess().getTFLOATEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalTESL.g:3584:6: (enumLiteral_9= 'float-clock' )
                    {
                    // InternalTESL.g:3584:6: (enumLiteral_9= 'float-clock' )
                    // InternalTESL.g:3584:8: enumLiteral_9= 'float-clock'
                    {
                    enumLiteral_9=(Token)match(input,93,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTFLOATEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getTypeAccess().getTFLOATEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // InternalTESL.g:3590:6: (enumLiteral_10= 'double-clock' )
                    {
                    // InternalTESL.g:3590:6: (enumLiteral_10= 'double-clock' )
                    // InternalTESL.g:3590:8: enumLiteral_10= 'double-clock'
                    {
                    enumLiteral_10=(Token)match(input,94,FOLLOW_2); 

                            current = grammarAccess.getTypeAccess().getTFLOATEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getTypeAccess().getTFLOATEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "ruleValueType"
    // InternalTESL.g:3600:1: ruleValueType returns [Enumerator current=null] : ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'decimal' ) | (enumLiteral_2= 'rational' ) | (enumLiteral_3= 'double' ) | (enumLiteral_4= 'float' ) ) ;
    public final Enumerator ruleValueType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // InternalTESL.g:3602:28: ( ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'decimal' ) | (enumLiteral_2= 'rational' ) | (enumLiteral_3= 'double' ) | (enumLiteral_4= 'float' ) ) )
            // InternalTESL.g:3603:1: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'decimal' ) | (enumLiteral_2= 'rational' ) | (enumLiteral_3= 'double' ) | (enumLiteral_4= 'float' ) )
            {
            // InternalTESL.g:3603:1: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'decimal' ) | (enumLiteral_2= 'rational' ) | (enumLiteral_3= 'double' ) | (enumLiteral_4= 'float' ) )
            int alt48=5;
            switch ( input.LA(1) ) {
            case 95:
                {
                alt48=1;
                }
                break;
            case 96:
                {
                alt48=2;
                }
                break;
            case 97:
                {
                alt48=3;
                }
                break;
            case 98:
                {
                alt48=4;
                }
                break;
            case 99:
                {
                alt48=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalTESL.g:3603:2: (enumLiteral_0= 'int' )
                    {
                    // InternalTESL.g:3603:2: (enumLiteral_0= 'int' )
                    // InternalTESL.g:3603:4: enumLiteral_0= 'int'
                    {
                    enumLiteral_0=(Token)match(input,95,FOLLOW_2); 

                            current = grammarAccess.getValueTypeAccess().getTINTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getValueTypeAccess().getTINTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalTESL.g:3609:6: (enumLiteral_1= 'decimal' )
                    {
                    // InternalTESL.g:3609:6: (enumLiteral_1= 'decimal' )
                    // InternalTESL.g:3609:8: enumLiteral_1= 'decimal'
                    {
                    enumLiteral_1=(Token)match(input,96,FOLLOW_2); 

                            current = grammarAccess.getValueTypeAccess().getTDECEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getValueTypeAccess().getTDECEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalTESL.g:3615:6: (enumLiteral_2= 'rational' )
                    {
                    // InternalTESL.g:3615:6: (enumLiteral_2= 'rational' )
                    // InternalTESL.g:3615:8: enumLiteral_2= 'rational'
                    {
                    enumLiteral_2=(Token)match(input,97,FOLLOW_2); 

                            current = grammarAccess.getValueTypeAccess().getTRATEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getValueTypeAccess().getTRATEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalTESL.g:3621:6: (enumLiteral_3= 'double' )
                    {
                    // InternalTESL.g:3621:6: (enumLiteral_3= 'double' )
                    // InternalTESL.g:3621:8: enumLiteral_3= 'double'
                    {
                    enumLiteral_3=(Token)match(input,98,FOLLOW_2); 

                            current = grammarAccess.getValueTypeAccess().getTFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getValueTypeAccess().getTFLOATEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalTESL.g:3627:6: (enumLiteral_4= 'float' )
                    {
                    // InternalTESL.g:3627:6: (enumLiteral_4= 'float' )
                    // InternalTESL.g:3627:8: enumLiteral_4= 'float'
                    {
                    enumLiteral_4=(Token)match(input,99,FOLLOW_2); 

                            current = grammarAccess.getValueTypeAccess().getTFLOATEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getValueTypeAccess().getTFLOATEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueType"


    // $ANTLR start "ruleOpTerm"
    // InternalTESL.g:3637:1: ruleOpTerm returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleOpTerm() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalTESL.g:3639:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalTESL.g:3640:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalTESL.g:3640:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==61) ) {
                alt49=1;
            }
            else if ( (LA49_0==100) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalTESL.g:3640:2: (enumLiteral_0= '+' )
                    {
                    // InternalTESL.g:3640:2: (enumLiteral_0= '+' )
                    // InternalTESL.g:3640:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,61,FOLLOW_2); 

                            current = grammarAccess.getOpTermAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOpTermAccess().getPLUSEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalTESL.g:3646:6: (enumLiteral_1= '-' )
                    {
                    // InternalTESL.g:3646:6: (enumLiteral_1= '-' )
                    // InternalTESL.g:3646:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,100,FOLLOW_2); 

                            current = grammarAccess.getOpTermAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOpTermAccess().getMINUSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpTerm"


    // $ANTLR start "ruleOpFact"
    // InternalTESL.g:3656:1: ruleOpFact returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) ) ;
    public final Enumerator ruleOpFact() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalTESL.g:3658:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) ) )
            // InternalTESL.g:3659:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) )
            {
            // InternalTESL.g:3659:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==57) ) {
                alt50=1;
            }
            else if ( (LA50_0==101) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalTESL.g:3659:2: (enumLiteral_0= '*' )
                    {
                    // InternalTESL.g:3659:2: (enumLiteral_0= '*' )
                    // InternalTESL.g:3659:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); 

                            current = grammarAccess.getOpFactAccess().getTIMESEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOpFactAccess().getTIMESEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalTESL.g:3665:6: (enumLiteral_1= '/' )
                    {
                    // InternalTESL.g:3665:6: (enumLiteral_1= '/' )
                    // InternalTESL.g:3665:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,101,FOLLOW_2); 

                            current = grammarAccess.getOpFactAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOpFactAccess().getDIVEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpFact"


    // $ANTLR start "ruleROUNDING_MODE"
    // InternalTESL.g:3675:1: ruleROUNDING_MODE returns [Enumerator current=null] : ( (enumLiteral_0= 'round_up' ) | (enumLiteral_1= 'round_down' ) | (enumLiteral_2= 'round_ceil' ) | (enumLiteral_3= 'round_floor' ) | (enumLiteral_4= 'round_half_up' ) | (enumLiteral_5= 'round_half_down' ) | (enumLiteral_6= 'round_half_even' ) ) ;
    public final Enumerator ruleROUNDING_MODE() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;

         enterRule(); 
        try {
            // InternalTESL.g:3677:28: ( ( (enumLiteral_0= 'round_up' ) | (enumLiteral_1= 'round_down' ) | (enumLiteral_2= 'round_ceil' ) | (enumLiteral_3= 'round_floor' ) | (enumLiteral_4= 'round_half_up' ) | (enumLiteral_5= 'round_half_down' ) | (enumLiteral_6= 'round_half_even' ) ) )
            // InternalTESL.g:3678:1: ( (enumLiteral_0= 'round_up' ) | (enumLiteral_1= 'round_down' ) | (enumLiteral_2= 'round_ceil' ) | (enumLiteral_3= 'round_floor' ) | (enumLiteral_4= 'round_half_up' ) | (enumLiteral_5= 'round_half_down' ) | (enumLiteral_6= 'round_half_even' ) )
            {
            // InternalTESL.g:3678:1: ( (enumLiteral_0= 'round_up' ) | (enumLiteral_1= 'round_down' ) | (enumLiteral_2= 'round_ceil' ) | (enumLiteral_3= 'round_floor' ) | (enumLiteral_4= 'round_half_up' ) | (enumLiteral_5= 'round_half_down' ) | (enumLiteral_6= 'round_half_even' ) )
            int alt51=7;
            switch ( input.LA(1) ) {
            case 102:
                {
                alt51=1;
                }
                break;
            case 103:
                {
                alt51=2;
                }
                break;
            case 104:
                {
                alt51=3;
                }
                break;
            case 105:
                {
                alt51=4;
                }
                break;
            case 106:
                {
                alt51=5;
                }
                break;
            case 107:
                {
                alt51=6;
                }
                break;
            case 108:
                {
                alt51=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalTESL.g:3678:2: (enumLiteral_0= 'round_up' )
                    {
                    // InternalTESL.g:3678:2: (enumLiteral_0= 'round_up' )
                    // InternalTESL.g:3678:4: enumLiteral_0= 'round_up'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); 

                            current = grammarAccess.getROUNDING_MODEAccess().getROUND_UPEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getROUNDING_MODEAccess().getROUND_UPEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalTESL.g:3684:6: (enumLiteral_1= 'round_down' )
                    {
                    // InternalTESL.g:3684:6: (enumLiteral_1= 'round_down' )
                    // InternalTESL.g:3684:8: enumLiteral_1= 'round_down'
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); 

                            current = grammarAccess.getROUNDING_MODEAccess().getROUND_DOWNEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getROUNDING_MODEAccess().getROUND_DOWNEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalTESL.g:3690:6: (enumLiteral_2= 'round_ceil' )
                    {
                    // InternalTESL.g:3690:6: (enumLiteral_2= 'round_ceil' )
                    // InternalTESL.g:3690:8: enumLiteral_2= 'round_ceil'
                    {
                    enumLiteral_2=(Token)match(input,104,FOLLOW_2); 

                            current = grammarAccess.getROUNDING_MODEAccess().getROUND_CEILINGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getROUNDING_MODEAccess().getROUND_CEILINGEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalTESL.g:3696:6: (enumLiteral_3= 'round_floor' )
                    {
                    // InternalTESL.g:3696:6: (enumLiteral_3= 'round_floor' )
                    // InternalTESL.g:3696:8: enumLiteral_3= 'round_floor'
                    {
                    enumLiteral_3=(Token)match(input,105,FOLLOW_2); 

                            current = grammarAccess.getROUNDING_MODEAccess().getROUND_FLOOREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getROUNDING_MODEAccess().getROUND_FLOOREnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalTESL.g:3702:6: (enumLiteral_4= 'round_half_up' )
                    {
                    // InternalTESL.g:3702:6: (enumLiteral_4= 'round_half_up' )
                    // InternalTESL.g:3702:8: enumLiteral_4= 'round_half_up'
                    {
                    enumLiteral_4=(Token)match(input,106,FOLLOW_2); 

                            current = grammarAccess.getROUNDING_MODEAccess().getROUND_HALF_UPEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getROUNDING_MODEAccess().getROUND_HALF_UPEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalTESL.g:3708:6: (enumLiteral_5= 'round_half_down' )
                    {
                    // InternalTESL.g:3708:6: (enumLiteral_5= 'round_half_down' )
                    // InternalTESL.g:3708:8: enumLiteral_5= 'round_half_down'
                    {
                    enumLiteral_5=(Token)match(input,107,FOLLOW_2); 

                            current = grammarAccess.getROUNDING_MODEAccess().getROUND_HALF_DOWNEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getROUNDING_MODEAccess().getROUND_HALF_DOWNEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalTESL.g:3714:6: (enumLiteral_6= 'round_half_even' )
                    {
                    // InternalTESL.g:3714:6: (enumLiteral_6= 'round_half_even' )
                    // InternalTESL.g:3714:8: enumLiteral_6= 'round_half_even'
                    {
                    enumLiteral_6=(Token)match(input,108,FOLLOW_2); 

                            current = grammarAccess.getROUNDING_MODEAccess().getROUND_HALF_EVENEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getROUNDING_MODEAccess().getROUND_HALF_EVENEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleROUNDING_MODE"

    // Delegated rules


    protected DFA44 dfa44 = new DFA44(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\1\12\uffff";
    static final String dfa_3s = "\1\4\12\uffff";
    static final String dfa_4s = "\1\136\12\uffff";
    static final String dfa_5s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_6s = "\1\0\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\14\uffff\1\1\5\uffff\1\1\15\uffff\1\3\2\uffff\1\1\1\uffff\1\1\17\uffff\1\1\3\uffff\5\1\3\uffff\1\2\1\4\1\uffff\1\5\1\6\1\7\1\10\1\11\1\12\2\uffff\1\1\1\uffff\14\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 2923:3: ( ({...}? => ( ({...}? => ( ( (lv_selection_4_0= 'select' ) ) ( (lv_selectedClocks_5_0= ruleClockItem ) ) (otherlv_6= ',' ( (lv_selectedClocks_7_0= ruleClockItem ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_window_8_0= 'from' ) ) ( (lv_from_9_0= ruleExpression ) ) otherlv_10= 'to' ( (lv_to_11_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'label' otherlv_13= 'if' ( (otherlv_14= RULE_ID ) ) (otherlv_15= ',' ( (otherlv_16= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xscaled_17_0= 'xscale' ) ) ( (lv_xscale_18_0= ruleExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'border' otherlv_20= '=' ( (lv_border_21_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= 'css' otherlv_23= '=' ( (lv_css_24_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_nodefcss_25_0= 'no-default-css' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'javascript' otherlv_27= '=' ( (lv_jvs_28_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_standalone_29_0= 'standalone' ) ) ( (lv_overwrite_30_0= 'overwrite' ) )? ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_0 = input.LA(1);

                         
                        int index44_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA44_0==EOF||LA44_0==RULE_ID||LA44_0==17||LA44_0==23||LA44_0==40||LA44_0==42||LA44_0==58||(LA44_0>=62 && LA44_0<=66)||LA44_0==81||(LA44_0>=83 && LA44_0<=94)) ) {s = 1;}

                        else if ( LA44_0 == 70 && getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA44_0 == 37 && getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA44_0 == 71 && getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA44_0 == 73 && getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA44_0 == 74 && getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA44_0 == 75 && getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA44_0 == 76 && getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA44_0 == 77 && getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA44_0 == 78 && getUnorderedGroupHelper().canSelect(grammarAccess.getOutputPragmaAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                         
                        input.seek(index44_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 44, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xC400050000820012L,0x000000007FFA0007L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020000L,0x000000007FF00000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x201EB000000001E0L,0x0000001000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x20001000000001E2L,0x0000001000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x01A0011CA0400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001400010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000002000C000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000F80000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x2000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0200000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x201EB000000001F0L,0x0000001000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000002000000002L,0x0000000000007EC0L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000002000200002L,0x0000000000007EC0L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000002000000002L,0x000000000000FEC0L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x00001FC000000000L});

}
