package fr.supelec.tesl.lang.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTESLLexer extends Lexer {
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

    public InternalTESLLexer() {;} 
    public InternalTESLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalTESLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalTESL.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:11:7: ( 'nongreedy' )
            // InternalTESL.g:11:9: 'nongreedy'
            {
            match("nongreedy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:12:7: ( 'periodic' )
            // InternalTESL.g:12:9: 'periodic'
            {
            match("periodic"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:13:7: ( 'offset' )
            // InternalTESL.g:13:9: 'offset'
            {
            match("offset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:14:7: ( 'sporadic' )
            // InternalTESL.g:14:9: 'sporadic'
            {
            match("sporadic"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:15:7: ( ',' )
            // InternalTESL.g:15:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:16:7: ( 'implies' )
            // InternalTESL.g:16:9: 'implies'
            {
            match("implies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:17:7: ( 'await' )
            // InternalTESL.g:17:9: 'await'
            {
            match("await"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:18:7: ( 'with' )
            // InternalTESL.g:18:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:19:7: ( 'weak' )
            // InternalTESL.g:19:9: 'weak'
            {
            match("weak"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:20:7: ( 'strong' )
            // InternalTESL.g:20:9: 'strong'
            {
            match("strong"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:21:7: ( 'reset' )
            // InternalTESL.g:21:9: 'reset'
            {
            match("reset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:22:7: ( 'on' )
            // InternalTESL.g:22:9: 'on'
            {
            match("on"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:23:7: ( 'filtered' )
            // InternalTESL.g:23:9: 'filtered'
            {
            match("filtered"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:24:7: ( 'by' )
            // InternalTESL.g:24:9: 'by'
            {
            match("by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:25:7: ( 'every' )
            // InternalTESL.g:25:9: 'every'
            {
            match("every"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:26:7: ( 'starting' )
            // InternalTESL.g:26:9: 'starting'
            {
            match("starting"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:27:7: ( 'at' )
            // InternalTESL.g:27:9: 'at'
            {
            match("at"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:28:7: ( 'immediately' )
            // InternalTESL.g:28:9: 'immediately'
            {
            match("immediately"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:29:7: ( 'delayed' )
            // InternalTESL.g:29:9: 'delayed'
            {
            match("delayed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:30:7: ( 'sustained' )
            // InternalTESL.g:30:9: 'sustained'
            {
            match("sustained"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:31:7: ( 'from' )
            // InternalTESL.g:31:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:32:7: ( 'to' )
            // InternalTESL.g:32:9: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:33:7: ( 'weakly' )
            // InternalTESL.g:33:9: 'weakly'
            {
            match("weakly"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:34:7: ( 'time' )
            // InternalTESL.g:34:9: 'time'
            {
            match("time"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:35:7: ( 'immediate' )
            // InternalTESL.g:35:9: 'immediate'
            {
            match("immediate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:36:7: ( 'let' )
            // InternalTESL.g:36:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:37:7: ( '=' )
            // InternalTESL.g:37:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:38:7: ( '$' )
            // InternalTESL.g:38:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:39:7: ( '(' )
            // InternalTESL.g:39:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:40:7: ( ')' )
            // InternalTESL.g:40:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:41:7: ( '[int ' )
            // InternalTESL.g:41:9: '[int '
            {
            match("[int "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:42:7: ( ']' )
            // InternalTESL.g:42:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:43:7: ( '[float ' )
            // InternalTESL.g:43:9: '[float '
            {
            match("[float "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:44:7: ( '[double' )
            // InternalTESL.g:44:9: '[double'
            {
            match("[double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:45:7: ( '[decimal' )
            // InternalTESL.g:45:9: '[decimal'
            {
            match("[decimal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:46:7: ( '[rational ' )
            // InternalTESL.g:46:9: '[rational '
            {
            match("[rational "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:47:7: ( 'when' )
            // InternalTESL.g:47:9: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:48:7: ( 'not' )
            // InternalTESL.g:48:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:49:7: ( 'strictly' )
            // InternalTESL.g:49:9: 'strictly'
            {
            match("strictly"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:50:7: ( 'next' )
            // InternalTESL.g:50:9: 'next'
            {
            match("next"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:51:7: ( '*' )
            // InternalTESL.g:51:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:52:7: ( 'tag' )
            // InternalTESL.g:52:9: 'tag'
            {
            match("tag"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:53:7: ( 'relation' )
            // InternalTESL.g:53:9: 'relation'
            {
            match("relation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:54:7: ( '^' )
            // InternalTESL.g:54:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:55:7: ( '+' )
            // InternalTESL.g:55:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:56:7: ( '@stop' )
            // InternalTESL.g:56:9: '@stop'
            {
            match("@stop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:57:7: ( '@tagref' )
            // InternalTESL.g:57:9: '@tagref'
            {
            match("@tagref"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:58:7: ( '@trace' )
            // InternalTESL.g:58:9: '@trace'
            {
            match("@trace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:59:7: ( '@maxstep' )
            // InternalTESL.g:59:9: '@maxstep'
            {
            match("@maxstep"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:60:7: ( '@output' )
            // InternalTESL.g:60:9: '@output'
            {
            match("@output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:61:7: ( 'vcd' )
            // InternalTESL.g:61:9: 'vcd'
            {
            match("vcd"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:62:7: ( 'tikz' )
            // InternalTESL.g:62:9: 'tikz'
            {
            match("tikz"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:63:7: ( 'svg' )
            // InternalTESL.g:63:9: 'svg'
            {
            match("svg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:64:7: ( 'select' )
            // InternalTESL.g:64:9: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:65:7: ( 'label' )
            // InternalTESL.g:65:9: 'label'
            {
            match("label"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:66:7: ( 'if' )
            // InternalTESL.g:66:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:67:7: ( 'xscale' )
            // InternalTESL.g:67:9: 'xscale'
            {
            match("xscale"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:68:7: ( 'border' )
            // InternalTESL.g:68:9: 'border'
            {
            match("border"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:69:7: ( 'css' )
            // InternalTESL.g:69:9: 'css'
            {
            match("css"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:70:7: ( 'no-default-css' )
            // InternalTESL.g:70:9: 'no-default-css'
            {
            match("no-default-css"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:71:7: ( 'javascript' )
            // InternalTESL.g:71:9: 'javascript'
            {
            match("javascript"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:72:7: ( 'standalone' )
            // InternalTESL.g:72:9: 'standalone'
            {
            match("standalone"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:73:7: ( 'overwrite' )
            // InternalTESL.g:73:9: 'overwrite'
            {
            match("overwrite"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:74:7: ( '->' )
            // InternalTESL.g:74:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:75:7: ( '@doublecalc' )
            // InternalTESL.g:75:9: '@doublecalc'
            {
            match("@doublecalc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:76:7: ( 'digits' )
            // InternalTESL.g:76:9: 'digits'
            {
            match("digits"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:77:7: ( '@dumpres' )
            // InternalTESL.g:77:9: '@dumpres'
            {
            match("@dumpres"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:78:7: ( 'U-clock' )
            // InternalTESL.g:78:9: 'U-clock'
            {
            match("U-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:79:7: ( 'unit-clock' )
            // InternalTESL.g:79:9: 'unit-clock'
            {
            match("unit-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:80:7: ( 'Z-clock' )
            // InternalTESL.g:80:9: 'Z-clock'
            {
            match("Z-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:81:7: ( 'int-clock' )
            // InternalTESL.g:81:9: 'int-clock'
            {
            match("int-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:82:7: ( 'D-clock' )
            // InternalTESL.g:82:9: 'D-clock'
            {
            match("D-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:83:7: ( 'decimal-clock' )
            // InternalTESL.g:83:9: 'decimal-clock'
            {
            match("decimal-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:84:7: ( 'Q-clock' )
            // InternalTESL.g:84:9: 'Q-clock'
            {
            match("Q-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:85:7: ( 'rational-clock' )
            // InternalTESL.g:85:9: 'rational-clock'
            {
            match("rational-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:86:7: ( 'F-clock' )
            // InternalTESL.g:86:9: 'F-clock'
            {
            match("F-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:87:7: ( 'float-clock' )
            // InternalTESL.g:87:9: 'float-clock'
            {
            match("float-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:88:7: ( 'double-clock' )
            // InternalTESL.g:88:9: 'double-clock'
            {
            match("double-clock"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:89:7: ( 'int' )
            // InternalTESL.g:89:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:90:7: ( 'decimal' )
            // InternalTESL.g:90:9: 'decimal'
            {
            match("decimal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:91:7: ( 'rational' )
            // InternalTESL.g:91:9: 'rational'
            {
            match("rational"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:92:7: ( 'double' )
            // InternalTESL.g:92:9: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:93:7: ( 'float' )
            // InternalTESL.g:93:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:94:8: ( '-' )
            // InternalTESL.g:94:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:95:8: ( '/' )
            // InternalTESL.g:95:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:96:8: ( 'round_up' )
            // InternalTESL.g:96:10: 'round_up'
            {
            match("round_up"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:97:8: ( 'round_down' )
            // InternalTESL.g:97:10: 'round_down'
            {
            match("round_down"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:98:8: ( 'round_ceil' )
            // InternalTESL.g:98:10: 'round_ceil'
            {
            match("round_ceil"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:99:8: ( 'round_floor' )
            // InternalTESL.g:99:10: 'round_floor'
            {
            match("round_floor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:100:8: ( 'round_half_up' )
            // InternalTESL.g:100:10: 'round_half_up'
            {
            match("round_half_up"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:101:8: ( 'round_half_down' )
            // InternalTESL.g:101:10: 'round_half_down'
            {
            match("round_half_down"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:102:8: ( 'round_half_even' )
            // InternalTESL.g:102:10: 'round_half_even'
            {
            match("round_half_even"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalTESL.g:3723:21: ( '0' .. '9' )
            // InternalTESL.g:3723:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_SIGN"
    public final void mRULE_SIGN() throws RecognitionException {
        try {
            // InternalTESL.g:3725:20: ( ( '+' | '-' ) )
            // InternalTESL.g:3725:22: ( '+' | '-' )
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_SIGN"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            // InternalTESL.g:3727:24: ( ( 'e' | 'E' ) ( RULE_SIGN )? ( RULE_DIGIT )+ )
            // InternalTESL.g:3727:26: ( 'e' | 'E' ) ( RULE_SIGN )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalTESL.g:3727:36: ( RULE_SIGN )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalTESL.g:3727:36: RULE_SIGN
                    {
                    mRULE_SIGN(); 

                    }
                    break;

            }

            // InternalTESL.g:3727:47: ( RULE_DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTESL.g:3727:47: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_BIG_INT"
    public final void mRULE_BIG_INT() throws RecognitionException {
        try {
            int _type = RULE_BIG_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3729:14: ( ( RULE_DIGIT )+ )
            // InternalTESL.g:3729:16: ( RULE_DIGIT )+
            {
            // InternalTESL.g:3729:16: ( RULE_DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTESL.g:3729:16: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIG_INT"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3731:12: ( ( ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? | '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )? | ( RULE_DIGIT )+ RULE_EXPONENT ) 'F' )
            // InternalTESL.g:3731:14: ( ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? | '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )? | ( RULE_DIGIT )+ RULE_EXPONENT ) 'F'
            {
            // InternalTESL.g:3731:14: ( ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? | '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )? | ( RULE_DIGIT )+ RULE_EXPONENT )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalTESL.g:3731:15: ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )?
                    {
                    // InternalTESL.g:3731:15: ( RULE_DIGIT )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalTESL.g:3731:15: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    match('.'); 
                    // InternalTESL.g:3731:31: ( RULE_DIGIT )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalTESL.g:3731:31: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // InternalTESL.g:3731:43: ( RULE_EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='E'||LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalTESL.g:3731:43: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalTESL.g:3731:58: '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )?
                    {
                    match('.'); 
                    // InternalTESL.g:3731:62: ( RULE_DIGIT )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTESL.g:3731:62: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // InternalTESL.g:3731:74: ( RULE_EXPONENT )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='E'||LA8_0=='e') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalTESL.g:3731:74: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // InternalTESL.g:3731:89: ( RULE_DIGIT )+ RULE_EXPONENT
                    {
                    // InternalTESL.g:3731:89: ( RULE_DIGIT )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalTESL.g:3731:89: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    mRULE_EXPONENT(); 

                    }
                    break;

            }

            match('F'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_BIG_DECIMAL"
    public final void mRULE_BIG_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_BIG_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3733:18: ( ( ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? | '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )? | ( RULE_DIGIT )+ RULE_EXPONENT ) )
            // InternalTESL.g:3733:20: ( ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? | '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )? | ( RULE_DIGIT )+ RULE_EXPONENT )
            {
            // InternalTESL.g:3733:20: ( ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? | '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )? | ( RULE_DIGIT )+ RULE_EXPONENT )
            int alt17=3;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalTESL.g:3733:21: ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )?
                    {
                    // InternalTESL.g:3733:21: ( RULE_DIGIT )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalTESL.g:3733:21: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    match('.'); 
                    // InternalTESL.g:3733:37: ( RULE_DIGIT )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalTESL.g:3733:37: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // InternalTESL.g:3733:49: ( RULE_EXPONENT )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalTESL.g:3733:49: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalTESL.g:3733:64: '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )?
                    {
                    match('.'); 
                    // InternalTESL.g:3733:68: ( RULE_DIGIT )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalTESL.g:3733:68: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    // InternalTESL.g:3733:80: ( RULE_EXPONENT )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='E'||LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalTESL.g:3733:80: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // InternalTESL.g:3733:95: ( RULE_DIGIT )+ RULE_EXPONENT
                    {
                    // InternalTESL.g:3733:95: ( RULE_DIGIT )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalTESL.g:3733:95: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    mRULE_EXPONENT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIG_DECIMAL"

    // $ANTLR start "RULE_RATIONAL"
    public final void mRULE_RATIONAL() throws RecognitionException {
        try {
            int _type = RULE_RATIONAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3735:15: ( '<' ( RULE_DIGIT )+ '/' ( RULE_DIGIT )+ '>' )
            // InternalTESL.g:3735:17: '<' ( RULE_DIGIT )+ '/' ( RULE_DIGIT )+ '>'
            {
            match('<'); 
            // InternalTESL.g:3735:21: ( RULE_DIGIT )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalTESL.g:3735:21: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            match('/'); 
            // InternalTESL.g:3735:37: ( RULE_DIGIT )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalTESL.g:3735:37: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RATIONAL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3737:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalTESL.g:3737:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalTESL.g:3737:11: ( '^' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='^') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTESL.g:3737:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalTESL.g:3737:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='0' && LA21_0<='9')||(LA21_0>='A' && LA21_0<='Z')||LA21_0=='_'||(LA21_0>='a' && LA21_0<='z')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalTESL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3739:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalTESL.g:3739:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalTESL.g:3739:24: ( options {greedy=false; } : . )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='*') ) {
                    int LA22_1 = input.LA(2);

                    if ( (LA22_1=='/') ) {
                        alt22=2;
                    }
                    else if ( ((LA22_1>='\u0000' && LA22_1<='.')||(LA22_1>='0' && LA22_1<='\uFFFF')) ) {
                        alt22=1;
                    }


                }
                else if ( ((LA22_0>='\u0000' && LA22_0<=')')||(LA22_0>='+' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalTESL.g:3739:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3741:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalTESL.g:3741:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalTESL.g:3741:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='\u0000' && LA23_0<='\t')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\uFFFF')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalTESL.g:3741:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // InternalTESL.g:3741:40: ( ( '\\r' )? '\\n' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='\n'||LA25_0=='\r') ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTESL.g:3741:41: ( '\\r' )? '\\n'
                    {
                    // InternalTESL.g:3741:41: ( '\\r' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='\r') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalTESL.g:3741:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3743:13: ( '\"' ( options {greedy=false; } : . )* '\"' )
            // InternalTESL.g:3743:15: '\"' ( options {greedy=false; } : . )* '\"'
            {
            match('\"'); 
            // InternalTESL.g:3743:19: ( options {greedy=false; } : . )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0=='\"') ) {
                    alt26=2;
                }
                else if ( ((LA26_0>='\u0000' && LA26_0<='!')||(LA26_0>='#' && LA26_0<='\uFFFF')) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalTESL.g:3743:47: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3745:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalTESL.g:3745:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalTESL.g:3745:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='\t' && LA27_0<='\n')||LA27_0=='\r'||LA27_0==' ') ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalTESL.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTESL.g:3747:16: ( . )
            // InternalTESL.g:3747:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalTESL.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | RULE_BIG_INT | RULE_FLOAT | RULE_BIG_DECIMAL | RULE_RATIONAL | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_STRING | RULE_WS | RULE_ANY_OTHER )
        int alt28=102;
        alt28 = dfa28.predict(input);
        switch (alt28) {
            case 1 :
                // InternalTESL.g:1:10: T__17
                {
                mT__17(); 

                }
                break;
            case 2 :
                // InternalTESL.g:1:16: T__18
                {
                mT__18(); 

                }
                break;
            case 3 :
                // InternalTESL.g:1:22: T__19
                {
                mT__19(); 

                }
                break;
            case 4 :
                // InternalTESL.g:1:28: T__20
                {
                mT__20(); 

                }
                break;
            case 5 :
                // InternalTESL.g:1:34: T__21
                {
                mT__21(); 

                }
                break;
            case 6 :
                // InternalTESL.g:1:40: T__22
                {
                mT__22(); 

                }
                break;
            case 7 :
                // InternalTESL.g:1:46: T__23
                {
                mT__23(); 

                }
                break;
            case 8 :
                // InternalTESL.g:1:52: T__24
                {
                mT__24(); 

                }
                break;
            case 9 :
                // InternalTESL.g:1:58: T__25
                {
                mT__25(); 

                }
                break;
            case 10 :
                // InternalTESL.g:1:64: T__26
                {
                mT__26(); 

                }
                break;
            case 11 :
                // InternalTESL.g:1:70: T__27
                {
                mT__27(); 

                }
                break;
            case 12 :
                // InternalTESL.g:1:76: T__28
                {
                mT__28(); 

                }
                break;
            case 13 :
                // InternalTESL.g:1:82: T__29
                {
                mT__29(); 

                }
                break;
            case 14 :
                // InternalTESL.g:1:88: T__30
                {
                mT__30(); 

                }
                break;
            case 15 :
                // InternalTESL.g:1:94: T__31
                {
                mT__31(); 

                }
                break;
            case 16 :
                // InternalTESL.g:1:100: T__32
                {
                mT__32(); 

                }
                break;
            case 17 :
                // InternalTESL.g:1:106: T__33
                {
                mT__33(); 

                }
                break;
            case 18 :
                // InternalTESL.g:1:112: T__34
                {
                mT__34(); 

                }
                break;
            case 19 :
                // InternalTESL.g:1:118: T__35
                {
                mT__35(); 

                }
                break;
            case 20 :
                // InternalTESL.g:1:124: T__36
                {
                mT__36(); 

                }
                break;
            case 21 :
                // InternalTESL.g:1:130: T__37
                {
                mT__37(); 

                }
                break;
            case 22 :
                // InternalTESL.g:1:136: T__38
                {
                mT__38(); 

                }
                break;
            case 23 :
                // InternalTESL.g:1:142: T__39
                {
                mT__39(); 

                }
                break;
            case 24 :
                // InternalTESL.g:1:148: T__40
                {
                mT__40(); 

                }
                break;
            case 25 :
                // InternalTESL.g:1:154: T__41
                {
                mT__41(); 

                }
                break;
            case 26 :
                // InternalTESL.g:1:160: T__42
                {
                mT__42(); 

                }
                break;
            case 27 :
                // InternalTESL.g:1:166: T__43
                {
                mT__43(); 

                }
                break;
            case 28 :
                // InternalTESL.g:1:172: T__44
                {
                mT__44(); 

                }
                break;
            case 29 :
                // InternalTESL.g:1:178: T__45
                {
                mT__45(); 

                }
                break;
            case 30 :
                // InternalTESL.g:1:184: T__46
                {
                mT__46(); 

                }
                break;
            case 31 :
                // InternalTESL.g:1:190: T__47
                {
                mT__47(); 

                }
                break;
            case 32 :
                // InternalTESL.g:1:196: T__48
                {
                mT__48(); 

                }
                break;
            case 33 :
                // InternalTESL.g:1:202: T__49
                {
                mT__49(); 

                }
                break;
            case 34 :
                // InternalTESL.g:1:208: T__50
                {
                mT__50(); 

                }
                break;
            case 35 :
                // InternalTESL.g:1:214: T__51
                {
                mT__51(); 

                }
                break;
            case 36 :
                // InternalTESL.g:1:220: T__52
                {
                mT__52(); 

                }
                break;
            case 37 :
                // InternalTESL.g:1:226: T__53
                {
                mT__53(); 

                }
                break;
            case 38 :
                // InternalTESL.g:1:232: T__54
                {
                mT__54(); 

                }
                break;
            case 39 :
                // InternalTESL.g:1:238: T__55
                {
                mT__55(); 

                }
                break;
            case 40 :
                // InternalTESL.g:1:244: T__56
                {
                mT__56(); 

                }
                break;
            case 41 :
                // InternalTESL.g:1:250: T__57
                {
                mT__57(); 

                }
                break;
            case 42 :
                // InternalTESL.g:1:256: T__58
                {
                mT__58(); 

                }
                break;
            case 43 :
                // InternalTESL.g:1:262: T__59
                {
                mT__59(); 

                }
                break;
            case 44 :
                // InternalTESL.g:1:268: T__60
                {
                mT__60(); 

                }
                break;
            case 45 :
                // InternalTESL.g:1:274: T__61
                {
                mT__61(); 

                }
                break;
            case 46 :
                // InternalTESL.g:1:280: T__62
                {
                mT__62(); 

                }
                break;
            case 47 :
                // InternalTESL.g:1:286: T__63
                {
                mT__63(); 

                }
                break;
            case 48 :
                // InternalTESL.g:1:292: T__64
                {
                mT__64(); 

                }
                break;
            case 49 :
                // InternalTESL.g:1:298: T__65
                {
                mT__65(); 

                }
                break;
            case 50 :
                // InternalTESL.g:1:304: T__66
                {
                mT__66(); 

                }
                break;
            case 51 :
                // InternalTESL.g:1:310: T__67
                {
                mT__67(); 

                }
                break;
            case 52 :
                // InternalTESL.g:1:316: T__68
                {
                mT__68(); 

                }
                break;
            case 53 :
                // InternalTESL.g:1:322: T__69
                {
                mT__69(); 

                }
                break;
            case 54 :
                // InternalTESL.g:1:328: T__70
                {
                mT__70(); 

                }
                break;
            case 55 :
                // InternalTESL.g:1:334: T__71
                {
                mT__71(); 

                }
                break;
            case 56 :
                // InternalTESL.g:1:340: T__72
                {
                mT__72(); 

                }
                break;
            case 57 :
                // InternalTESL.g:1:346: T__73
                {
                mT__73(); 

                }
                break;
            case 58 :
                // InternalTESL.g:1:352: T__74
                {
                mT__74(); 

                }
                break;
            case 59 :
                // InternalTESL.g:1:358: T__75
                {
                mT__75(); 

                }
                break;
            case 60 :
                // InternalTESL.g:1:364: T__76
                {
                mT__76(); 

                }
                break;
            case 61 :
                // InternalTESL.g:1:370: T__77
                {
                mT__77(); 

                }
                break;
            case 62 :
                // InternalTESL.g:1:376: T__78
                {
                mT__78(); 

                }
                break;
            case 63 :
                // InternalTESL.g:1:382: T__79
                {
                mT__79(); 

                }
                break;
            case 64 :
                // InternalTESL.g:1:388: T__80
                {
                mT__80(); 

                }
                break;
            case 65 :
                // InternalTESL.g:1:394: T__81
                {
                mT__81(); 

                }
                break;
            case 66 :
                // InternalTESL.g:1:400: T__82
                {
                mT__82(); 

                }
                break;
            case 67 :
                // InternalTESL.g:1:406: T__83
                {
                mT__83(); 

                }
                break;
            case 68 :
                // InternalTESL.g:1:412: T__84
                {
                mT__84(); 

                }
                break;
            case 69 :
                // InternalTESL.g:1:418: T__85
                {
                mT__85(); 

                }
                break;
            case 70 :
                // InternalTESL.g:1:424: T__86
                {
                mT__86(); 

                }
                break;
            case 71 :
                // InternalTESL.g:1:430: T__87
                {
                mT__87(); 

                }
                break;
            case 72 :
                // InternalTESL.g:1:436: T__88
                {
                mT__88(); 

                }
                break;
            case 73 :
                // InternalTESL.g:1:442: T__89
                {
                mT__89(); 

                }
                break;
            case 74 :
                // InternalTESL.g:1:448: T__90
                {
                mT__90(); 

                }
                break;
            case 75 :
                // InternalTESL.g:1:454: T__91
                {
                mT__91(); 

                }
                break;
            case 76 :
                // InternalTESL.g:1:460: T__92
                {
                mT__92(); 

                }
                break;
            case 77 :
                // InternalTESL.g:1:466: T__93
                {
                mT__93(); 

                }
                break;
            case 78 :
                // InternalTESL.g:1:472: T__94
                {
                mT__94(); 

                }
                break;
            case 79 :
                // InternalTESL.g:1:478: T__95
                {
                mT__95(); 

                }
                break;
            case 80 :
                // InternalTESL.g:1:484: T__96
                {
                mT__96(); 

                }
                break;
            case 81 :
                // InternalTESL.g:1:490: T__97
                {
                mT__97(); 

                }
                break;
            case 82 :
                // InternalTESL.g:1:496: T__98
                {
                mT__98(); 

                }
                break;
            case 83 :
                // InternalTESL.g:1:502: T__99
                {
                mT__99(); 

                }
                break;
            case 84 :
                // InternalTESL.g:1:508: T__100
                {
                mT__100(); 

                }
                break;
            case 85 :
                // InternalTESL.g:1:515: T__101
                {
                mT__101(); 

                }
                break;
            case 86 :
                // InternalTESL.g:1:522: T__102
                {
                mT__102(); 

                }
                break;
            case 87 :
                // InternalTESL.g:1:529: T__103
                {
                mT__103(); 

                }
                break;
            case 88 :
                // InternalTESL.g:1:536: T__104
                {
                mT__104(); 

                }
                break;
            case 89 :
                // InternalTESL.g:1:543: T__105
                {
                mT__105(); 

                }
                break;
            case 90 :
                // InternalTESL.g:1:550: T__106
                {
                mT__106(); 

                }
                break;
            case 91 :
                // InternalTESL.g:1:557: T__107
                {
                mT__107(); 

                }
                break;
            case 92 :
                // InternalTESL.g:1:564: T__108
                {
                mT__108(); 

                }
                break;
            case 93 :
                // InternalTESL.g:1:571: RULE_BIG_INT
                {
                mRULE_BIG_INT(); 

                }
                break;
            case 94 :
                // InternalTESL.g:1:584: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 95 :
                // InternalTESL.g:1:595: RULE_BIG_DECIMAL
                {
                mRULE_BIG_DECIMAL(); 

                }
                break;
            case 96 :
                // InternalTESL.g:1:612: RULE_RATIONAL
                {
                mRULE_RATIONAL(); 

                }
                break;
            case 97 :
                // InternalTESL.g:1:626: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 98 :
                // InternalTESL.g:1:634: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 99 :
                // InternalTESL.g:1:650: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 100 :
                // InternalTESL.g:1:666: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 101 :
                // InternalTESL.g:1:678: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 102 :
                // InternalTESL.g:1:686: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA10_eotS =
        "\5\uffff";
    static final String DFA10_eofS =
        "\5\uffff";
    static final String DFA10_minS =
        "\2\56\3\uffff";
    static final String DFA10_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA10_specialS =
        "\5\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "3731:14: ( ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? | '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )? | ( RULE_DIGIT )+ RULE_EXPONENT )";
        }
    }
    static final String DFA17_eotS =
        "\5\uffff";
    static final String DFA17_eofS =
        "\5\uffff";
    static final String DFA17_minS =
        "\2\56\3\uffff";
    static final String DFA17_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA17_specialS =
        "\5\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "3733:20: ( ( RULE_DIGIT )+ '.' ( RULE_DIGIT )* ( RULE_EXPONENT )? | '.' ( RULE_DIGIT )+ ( RULE_EXPONENT )? | ( RULE_DIGIT )+ RULE_EXPONENT )";
        }
    }
    static final String DFA28_eotS =
        "\1\uffff\4\57\1\uffff\12\57\4\uffff\1\54\2\uffff\1\135\1\uffff\1\54\4\57\1\151\6\57\1\162\1\163\2\54\1\uffff\1\54\2\uffff\2\57\1\uffff\2\57\1\u0081\6\57\1\uffff\1\57\1\u008b\2\57\1\u008e\11\57\1\u0099\5\57\1\u00a0\4\57\21\uffff\4\57\3\uffff\1\57\11\uffff\1\163\2\u00b5\3\uffff\1\57\1\u00b9\1\uffff\3\57\1\uffff\5\57\1\u00c4\3\57\1\uffff\1\u00c9\1\57\1\uffff\12\57\1\uffff\6\57\1\uffff\2\57\1\u00dd\1\u00de\1\57\6\uffff\1\u00e0\1\57\1\u00e2\2\57\1\uffff\2\u00b5\4\uffff\1\57\1\uffff\1\u00ea\11\57\1\uffff\3\57\2\uffff\1\57\1\u00f8\1\u00fa\1\u00fb\5\57\1\u0101\7\57\1\u0109\1\u010a\2\uffff\1\57\1\uffff\1\57\1\uffff\2\57\1\uffff\1\u00b5\1\uffff\1\u00b5\1\57\1\uffff\14\57\1\u011c\1\uffff\1\57\2\uffff\1\u011e\4\57\1\uffff\1\u0124\1\57\1\u0126\4\57\2\uffff\1\u012b\2\57\1\uffff\2\57\1\u0130\2\57\1\u0133\4\57\1\u0138\2\57\1\uffff\1\u013b\1\uffff\4\57\2\uffff\1\u0144\1\uffff\2\57\1\u0147\1\u0149\1\uffff\1\u014a\3\57\1\uffff\2\57\1\uffff\4\57\1\uffff\1\u0154\1\57\1\uffff\10\57\1\uffff\1\u015e\1\u0160\4\uffff\2\57\1\u0163\1\57\1\u0165\1\u0166\1\u0167\2\57\1\uffff\1\57\1\u016b\1\u016d\1\u016e\4\57\1\u0173\3\uffff\1\57\1\u0175\1\uffff\1\u0176\3\uffff\1\57\1\u0178\1\u017a\4\uffff\4\57\1\uffff\1\57\2\uffff\1\u0180\1\uffff\1\57\1\uffff\1\u0182\1\u0183\2\57\1\u0186\1\uffff\1\u0187\2\uffff\1\u0188\1\57\3\uffff\3\57\1\u018f\2\57\1\uffff\2\57\1\u0194\1\u0195\2\uffff";
    static final String DFA28_eofS =
        "\u0196\uffff";
    static final String DFA28_minS =
        "\1\0\2\145\1\146\1\145\1\uffff\1\146\1\164\1\145\1\141\1\151\1\157\1\166\1\145\2\141\4\uffff\1\144\2\uffff\1\101\1\uffff\1\144\1\143\2\163\1\141\1\76\1\55\1\156\4\55\1\52\1\56\2\60\1\uffff\1\0\2\uffff\1\55\1\170\1\uffff\1\162\1\146\1\60\1\145\1\157\1\141\1\163\1\147\1\154\1\uffff\1\155\1\60\1\164\1\141\1\60\1\164\1\141\1\145\1\154\1\164\1\165\1\154\2\157\1\60\1\162\1\145\1\143\1\147\1\165\1\60\1\153\1\147\1\164\1\142\6\uffff\1\145\6\uffff\1\141\2\uffff\1\157\1\144\1\143\1\163\1\166\3\uffff\1\151\10\uffff\1\53\1\56\2\60\3\uffff\1\147\1\60\1\uffff\1\164\1\151\1\163\1\uffff\2\162\1\151\1\156\1\164\1\60\1\145\1\154\1\145\1\uffff\1\55\1\151\1\uffff\1\150\1\153\1\156\1\145\1\141\1\151\1\156\1\164\1\155\1\141\1\uffff\1\144\1\162\1\141\2\151\1\142\1\uffff\1\145\1\172\2\60\1\145\6\uffff\1\60\1\141\1\60\1\141\1\164\3\60\1\53\2\uffff\1\53\1\162\1\uffff\1\60\1\157\1\145\1\167\1\141\1\156\1\143\1\164\1\144\1\141\1\uffff\1\143\1\151\1\144\2\uffff\1\164\3\60\2\164\1\157\1\144\1\145\1\60\1\164\1\145\2\171\1\155\1\164\1\154\2\60\2\uffff\1\154\1\uffff\1\154\1\uffff\1\163\1\55\4\60\1\145\1\uffff\1\144\1\164\1\162\1\144\1\147\1\164\1\151\1\141\1\151\1\164\1\145\1\151\1\60\1\uffff\1\171\2\uffff\1\60\1\151\1\156\1\137\1\162\1\uffff\1\55\1\162\1\60\1\145\1\141\1\163\1\145\2\uffff\1\60\1\145\1\143\1\uffff\1\145\1\151\1\60\2\151\1\60\1\154\1\156\1\154\1\156\1\60\1\163\1\141\1\uffff\1\60\1\uffff\1\157\1\141\1\143\1\145\2\uffff\1\60\1\uffff\1\144\1\154\1\60\1\55\1\uffff\1\60\1\162\1\144\1\143\1\uffff\1\164\1\143\1\uffff\1\171\1\147\1\157\1\145\1\uffff\1\60\1\164\1\uffff\1\156\1\154\1\160\1\157\1\145\1\154\1\141\1\144\1\uffff\1\60\1\55\4\uffff\1\151\1\171\1\60\1\145\3\60\1\156\1\144\1\uffff\1\145\1\60\1\55\1\60\1\167\1\151\1\157\1\154\1\60\3\uffff\1\160\1\60\1\uffff\1\60\3\uffff\1\145\2\60\4\uffff\1\156\1\154\1\157\1\146\1\uffff\1\164\2\uffff\1\60\1\uffff\1\171\1\uffff\2\60\1\162\1\137\1\60\1\uffff\1\60\2\uffff\1\60\1\144\3\uffff\1\160\1\157\1\166\1\60\1\167\1\145\1\uffff\2\156\2\60\2\uffff";
    static final String DFA28_maxS =
        "\1\uffff\1\157\1\145\2\166\1\uffff\1\156\1\167\1\151\1\157\1\162\1\171\1\166\2\157\1\145\4\uffff\1\162\2\uffff\1\172\1\uffff\1\164\1\143\2\163\1\141\1\76\1\55\1\156\4\55\1\57\1\145\2\71\1\uffff\1\uffff\2\uffff\1\164\1\170\1\uffff\1\162\1\146\1\172\1\145\1\157\1\162\1\163\1\147\1\154\1\uffff\1\160\1\172\1\164\1\141\1\172\1\164\1\141\1\145\1\163\1\164\1\165\1\154\2\157\1\172\1\162\1\145\1\154\1\147\1\165\1\172\1\155\1\147\1\164\1\142\6\uffff\1\157\6\uffff\1\162\2\uffff\1\165\1\144\1\143\1\163\1\166\3\uffff\1\151\10\uffff\1\71\3\145\3\uffff\1\147\1\172\1\uffff\1\164\1\151\1\163\1\uffff\2\162\1\157\1\162\1\164\1\172\1\145\1\154\1\145\1\uffff\1\172\1\151\1\uffff\1\150\1\153\1\156\1\145\1\141\1\151\1\156\1\164\1\155\1\141\1\uffff\1\144\1\162\1\141\2\151\1\142\1\uffff\1\145\3\172\1\145\6\uffff\1\172\1\141\1\172\1\141\1\164\1\71\1\106\1\145\1\71\2\uffff\1\71\1\162\1\uffff\1\172\1\157\1\145\1\167\1\141\1\156\1\143\1\164\1\144\1\141\1\uffff\1\143\1\151\1\144\2\uffff\1\164\3\172\2\164\1\157\1\144\1\145\1\172\1\164\1\145\2\171\1\155\1\164\1\154\2\172\2\uffff\1\154\1\uffff\1\154\1\uffff\1\163\1\55\1\71\1\106\1\71\1\106\1\145\1\uffff\1\144\1\164\1\162\1\144\1\147\1\164\1\151\1\141\1\151\1\164\1\145\1\151\1\172\1\uffff\1\171\2\uffff\1\172\1\151\1\156\1\137\1\162\1\uffff\1\172\1\162\1\172\1\145\1\141\1\163\1\145\2\uffff\1\172\1\145\1\143\1\uffff\1\145\1\151\1\172\2\151\1\172\1\154\1\156\1\154\1\156\1\172\1\163\1\141\1\uffff\1\172\1\uffff\1\157\1\141\1\165\1\145\2\uffff\1\172\1\uffff\1\144\1\154\2\172\1\uffff\1\172\1\162\1\144\1\143\1\uffff\1\164\1\143\1\uffff\1\171\1\147\1\157\1\145\1\uffff\1\172\1\164\1\uffff\1\156\1\154\1\160\1\157\1\145\1\154\1\141\1\144\1\uffff\2\172\4\uffff\1\151\1\171\1\172\1\145\3\172\1\156\1\144\1\uffff\1\145\3\172\1\167\1\151\1\157\1\154\1\172\3\uffff\1\160\1\172\1\uffff\1\172\3\uffff\1\145\2\172\4\uffff\1\156\1\154\1\157\1\146\1\uffff\1\164\2\uffff\1\172\1\uffff\1\171\1\uffff\2\172\1\162\1\137\1\172\1\uffff\1\172\2\uffff\1\172\1\165\3\uffff\1\160\1\157\1\166\1\172\1\167\1\145\1\uffff\2\156\2\172\2\uffff";
    static final String DFA28_acceptS =
        "\5\uffff\1\5\12\uffff\1\33\1\34\1\35\1\36\1\uffff\1\40\1\51\1\uffff\1\55\20\uffff\1\141\1\uffff\1\145\1\146\2\uffff\1\141\11\uffff\1\5\31\uffff\1\33\1\34\1\35\1\36\1\37\1\41\1\uffff\1\44\1\40\1\51\1\54\1\55\1\56\1\uffff\1\61\1\62\5\uffff\1\100\1\124\1\104\1\uffff\1\106\1\110\1\112\1\114\1\142\1\143\1\125\1\135\4\uffff\1\140\1\144\1\145\2\uffff\1\74\3\uffff\1\14\11\uffff\1\70\2\uffff\1\21\12\uffff\1\16\6\uffff\1\26\5\uffff\1\42\1\43\1\57\1\60\1\101\1\103\11\uffff\1\137\1\136\2\uffff\1\46\12\uffff\1\65\3\uffff\1\107\1\117\23\uffff\1\52\1\32\1\uffff\1\63\1\uffff\1\73\7\uffff\1\50\15\uffff\1\10\1\uffff\1\11\1\45\5\uffff\1\25\7\uffff\1\30\1\64\3\uffff\1\105\15\uffff\1\7\1\uffff\1\13\4\uffff\1\115\1\123\1\uffff\1\17\4\uffff\1\67\4\uffff\1\3\2\uffff\1\12\4\uffff\1\66\2\uffff\1\27\10\uffff\1\72\2\uffff\1\102\1\116\1\122\1\71\11\uffff\1\6\11\uffff\1\23\1\111\1\120\2\uffff\1\2\1\uffff\1\4\1\47\1\20\3\uffff\1\53\1\113\1\121\1\126\4\uffff\1\15\1\uffff\1\1\1\77\1\uffff\1\24\1\uffff\1\31\5\uffff\1\76\1\uffff\1\127\1\130\2\uffff\1\75\1\22\1\131\6\uffff\1\132\4\uffff\1\133\1\134";
    static final String DFA28_specialS =
        "\1\1\51\uffff\1\0\u016b\uffff}>";
    static final String[] DFA28_transitionS = {
            "\11\54\2\53\2\54\1\53\22\54\1\53\1\54\1\52\1\54\1\21\3\54\1\22\1\23\1\26\1\30\1\5\1\36\1\47\1\45\12\46\2\54\1\50\1\20\2\54\1\31\3\51\1\42\1\51\1\44\12\51\1\43\3\51\1\37\4\51\1\41\1\24\1\54\1\25\1\27\1\51\1\54\1\7\1\13\1\34\1\15\1\14\1\12\2\51\1\6\1\35\1\51\1\17\1\51\1\1\1\3\1\2\1\51\1\11\1\4\1\16\1\40\1\32\1\10\1\33\2\51\uff85\54",
            "\1\56\11\uffff\1\55",
            "\1\60",
            "\1\61\7\uffff\1\62\7\uffff\1\63",
            "\1\70\12\uffff\1\64\3\uffff\1\65\1\66\1\67",
            "",
            "\1\73\6\uffff\1\72\1\74",
            "\1\76\2\uffff\1\75",
            "\1\100\2\uffff\1\101\1\77",
            "\1\103\3\uffff\1\102\11\uffff\1\104",
            "\1\105\2\uffff\1\107\5\uffff\1\106",
            "\1\111\11\uffff\1\110",
            "\1\112",
            "\1\113\3\uffff\1\114\5\uffff\1\115",
            "\1\120\7\uffff\1\117\5\uffff\1\116",
            "\1\122\3\uffff\1\121",
            "",
            "",
            "",
            "",
            "\1\131\1\uffff\1\130\2\uffff\1\127\10\uffff\1\132",
            "",
            "",
            "\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\143\10\uffff\1\141\1\uffff\1\142\3\uffff\1\137\1\140",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160\4\uffff\1\161",
            "\1\166\1\uffff\12\165\13\uffff\1\164\37\uffff\1\164",
            "\12\167",
            "\12\170",
            "",
            "\0\171",
            "",
            "",
            "\1\175\100\uffff\1\173\5\uffff\1\174",
            "\1\176",
            "",
            "\1\177",
            "\1\u0080",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0082",
            "\1\u0083",
            "\1\u0085\20\uffff\1\u0084",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "",
            "\1\u008a\2\uffff\1\u0089",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u008c",
            "\1\u008d",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0093\6\uffff\1\u0092",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u009a",
            "\1\u009b",
            "\1\u009d\10\uffff\1\u009c",
            "\1\u009e",
            "\1\u009f",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00a2\1\uffff\1\u00a1",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a7\11\uffff\1\u00a6",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a8\20\uffff\1\u00a9",
            "",
            "",
            "\1\u00aa\5\uffff\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "",
            "",
            "",
            "\1\u00b0",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00b1\1\uffff\1\u00b1\2\uffff\12\u00b2",
            "\1\166\1\uffff\12\165\13\uffff\1\164\37\uffff\1\164",
            "\12\u00b3\13\uffff\1\u00b4\1\u00b6\36\uffff\1\u00b4",
            "\12\167\13\uffff\1\u00b7\1\u00b6\36\uffff\1\u00b7",
            "",
            "",
            "",
            "\1\u00b8",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00c0\5\uffff\1\u00bf",
            "\1\u00c2\3\uffff\1\u00c1",
            "\1\u00c3",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "",
            "\1\u00c8\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00ca",
            "",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "\1\u00db",
            "\1\u00dc",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00df",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00e1",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00e3",
            "\1\u00e4",
            "\12\u00b2",
            "\12\u00b2\14\uffff\1\u00b6",
            "\12\u00b3\13\uffff\1\u00b4\1\u00b6\36\uffff\1\u00b4",
            "\1\u00e5\1\uffff\1\u00e5\2\uffff\12\u00e6",
            "",
            "",
            "\1\u00e7\1\uffff\1\u00e7\2\uffff\12\u00e8",
            "\1\u00e9",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "",
            "",
            "\1\u00f7",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\13\57\1\u00f9\16\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "\1\u010b",
            "",
            "\1\u010c",
            "",
            "\1\u010d",
            "\1\u010e",
            "\12\u00e6",
            "\12\u00e6\14\uffff\1\u00b6",
            "\12\u00e8",
            "\12\u00e8\14\uffff\1\u00b6",
            "\1\u010f",
            "",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u011d",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "",
            "\1\u0123\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0125",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u012c",
            "\1\u012d",
            "",
            "\1\u012e",
            "\1\u012f",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0131",
            "\1\u0132",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0139",
            "\1\u013a",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u013c",
            "\1\u013d",
            "\1\u0140\1\u013f\1\uffff\1\u0141\1\uffff\1\u0142\14\uffff\1\u013e",
            "\1\u0143",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u0145",
            "\1\u0146",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0148\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "",
            "\1\u014e",
            "\1\u014f",
            "",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0155",
            "",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u015f\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "",
            "",
            "\1\u0161",
            "\1\u0162",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0164",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0168",
            "\1\u0169",
            "",
            "\1\u016a",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u016c\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "",
            "\1\u0174",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "",
            "\1\u0177",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\13\57\1\u0179\16\57",
            "",
            "",
            "",
            "",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "",
            "\1\u017f",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u0181",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0184",
            "\1\u0185",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u018a\1\u018b\17\uffff\1\u0189",
            "",
            "",
            "",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0190",
            "\1\u0191",
            "",
            "\1\u0192",
            "\1\u0193",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | RULE_BIG_INT | RULE_FLOAT | RULE_BIG_DECIMAL | RULE_RATIONAL | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_STRING | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_42 = input.LA(1);

                        s = -1;
                        if ( ((LA28_42>='\u0000' && LA28_42<='\uFFFF')) ) {s = 121;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_0 = input.LA(1);

                        s = -1;
                        if ( (LA28_0=='n') ) {s = 1;}

                        else if ( (LA28_0=='p') ) {s = 2;}

                        else if ( (LA28_0=='o') ) {s = 3;}

                        else if ( (LA28_0=='s') ) {s = 4;}

                        else if ( (LA28_0==',') ) {s = 5;}

                        else if ( (LA28_0=='i') ) {s = 6;}

                        else if ( (LA28_0=='a') ) {s = 7;}

                        else if ( (LA28_0=='w') ) {s = 8;}

                        else if ( (LA28_0=='r') ) {s = 9;}

                        else if ( (LA28_0=='f') ) {s = 10;}

                        else if ( (LA28_0=='b') ) {s = 11;}

                        else if ( (LA28_0=='e') ) {s = 12;}

                        else if ( (LA28_0=='d') ) {s = 13;}

                        else if ( (LA28_0=='t') ) {s = 14;}

                        else if ( (LA28_0=='l') ) {s = 15;}

                        else if ( (LA28_0=='=') ) {s = 16;}

                        else if ( (LA28_0=='$') ) {s = 17;}

                        else if ( (LA28_0=='(') ) {s = 18;}

                        else if ( (LA28_0==')') ) {s = 19;}

                        else if ( (LA28_0=='[') ) {s = 20;}

                        else if ( (LA28_0==']') ) {s = 21;}

                        else if ( (LA28_0=='*') ) {s = 22;}

                        else if ( (LA28_0=='^') ) {s = 23;}

                        else if ( (LA28_0=='+') ) {s = 24;}

                        else if ( (LA28_0=='@') ) {s = 25;}

                        else if ( (LA28_0=='v') ) {s = 26;}

                        else if ( (LA28_0=='x') ) {s = 27;}

                        else if ( (LA28_0=='c') ) {s = 28;}

                        else if ( (LA28_0=='j') ) {s = 29;}

                        else if ( (LA28_0=='-') ) {s = 30;}

                        else if ( (LA28_0=='U') ) {s = 31;}

                        else if ( (LA28_0=='u') ) {s = 32;}

                        else if ( (LA28_0=='Z') ) {s = 33;}

                        else if ( (LA28_0=='D') ) {s = 34;}

                        else if ( (LA28_0=='Q') ) {s = 35;}

                        else if ( (LA28_0=='F') ) {s = 36;}

                        else if ( (LA28_0=='/') ) {s = 37;}

                        else if ( ((LA28_0>='0' && LA28_0<='9')) ) {s = 38;}

                        else if ( (LA28_0=='.') ) {s = 39;}

                        else if ( (LA28_0=='<') ) {s = 40;}

                        else if ( ((LA28_0>='A' && LA28_0<='C')||LA28_0=='E'||(LA28_0>='G' && LA28_0<='P')||(LA28_0>='R' && LA28_0<='T')||(LA28_0>='V' && LA28_0<='Y')||LA28_0=='_'||(LA28_0>='g' && LA28_0<='h')||LA28_0=='k'||LA28_0=='m'||LA28_0=='q'||(LA28_0>='y' && LA28_0<='z')) ) {s = 41;}

                        else if ( (LA28_0=='\"') ) {s = 42;}

                        else if ( ((LA28_0>='\t' && LA28_0<='\n')||LA28_0=='\r'||LA28_0==' ') ) {s = 43;}

                        else if ( ((LA28_0>='\u0000' && LA28_0<='\b')||(LA28_0>='\u000B' && LA28_0<='\f')||(LA28_0>='\u000E' && LA28_0<='\u001F')||LA28_0=='!'||LA28_0=='#'||(LA28_0>='%' && LA28_0<='\'')||(LA28_0>=':' && LA28_0<=';')||(LA28_0>='>' && LA28_0<='?')||LA28_0=='\\'||LA28_0=='`'||(LA28_0>='{' && LA28_0<='\uFFFF')) ) {s = 44;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}