/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package se.clau.intellij_msc.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.openapi.diagnostic.Logger;

import se.clau.intellij_msc.MscTypes;
import se.clau.intellij_msc.psi.MscString;
import se.clau.intellij_msc.psi.impl.MscStringImpl;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>msc-lexer.flex</tt>
 */
public class _MscLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;
  public static final int IN_BLOCK_COMMENT = 4;
  public static final int IN_LINE_COMMENT = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [7, 7, 7]
   * Total runtime size is 1928 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>14]|((ch>>7)&0x7f)]<<7)|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 68 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\103\200");

  /* The ZZ_CMAP_Y table has 256 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\53\2\1\3\22\2\1\4\37\2\1\3\237\2");

  /* The ZZ_CMAP_A table has 640 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\7\1\40\2\7\1\40\22\0\1\7\1\0\1\36\1\2\3\0\1\3\2\0\1\10\1\0\1\12\1"+
    "\20\1\23\1\1\12\0\1\24\1\11\1\17\1\22\1\21\34\0\1\15\1\37\1\16\3\0\1\30\1"+
    "\26\1\6\1\0\1\34\7\0\1\4\1\32\1\27\2\0\1\31\1\5\1\33\3\0\1\25\2\0\1\13\1\35"+
    "\1\14\7\0\1\7\32\0\1\7\337\0\1\7\177\0\13\7\35\0\2\7\5\0\1\7\57\0\1\7\40\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\1\2\1\3\1\2\1\4\1\2\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\3\2\1\13\2\2"+
    "\5\1\1\2\1\14\1\2\1\15\1\16\1\17\2\20"+
    "\1\21\1\22\2\0\1\23\1\24\1\25\1\0\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\4\1\1\0\1\41\1\42\1\43\1\44"+
    "\1\21\1\0\1\45\1\0\1\46\1\47\1\50\1\51"+
    "\1\52\1\53\1\54\1\55\1\56\1\57\3\1\1\60"+
    "\1\0\1\61\1\0\1\62\1\63\1\64\1\65\1\66";

  private static int [] zzUnpackAction() {
    int [] result = new int[89];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\41\0\102\0\143\0\204\0\245\0\306\0\347"+
    "\0\u0108\0\u0129\0\306\0\306\0\306\0\306\0\306\0\306"+
    "\0\u014a\0\u016b\0\u018c\0\u01ad\0\u01ce\0\u01ef\0\u0210\0\u0231"+
    "\0\u0252\0\u0273\0\u0294\0\u02b5\0\306\0\306\0\u02d6\0\306"+
    "\0\u02f7\0\306\0\u0318\0\u0339\0\306\0\u035a\0\u037b\0\u039c"+
    "\0\u03bd\0\u03de\0\u03ff\0\u0420\0\u0441\0\u0462\0\306\0\306"+
    "\0\u0483\0\306\0\u04a4\0\306\0\306\0\306\0\u04c5\0\u04e6"+
    "\0\u0507\0\u0528\0\u0549\0\306\0\306\0\306\0\306\0\306"+
    "\0\u056a\0\306\0\u058b\0\u05ac\0\306\0\306\0\306\0\306"+
    "\0\306\0\306\0\306\0\306\0\204\0\u05cd\0\u05ee\0\u060f"+
    "\0\306\0\u0630\0\306\0\u0651\0\204\0\204\0\204\0\u0672"+
    "\0\306";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[89];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\1\6\1\7\1\10\3\5\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\5\1\31\1\32"+
    "\1\33\2\5\1\34\1\35\1\36\1\11\36\37\1\40"+
    "\1\41\1\36\10\42\1\43\70\42\1\44\1\5\3\0"+
    "\3\5\16\0\10\5\5\0\1\7\6\0\1\45\75\0"+
    "\1\46\43\0\1\11\30\0\1\11\17\0\1\47\40\0"+
    "\1\50\1\51\1\0\1\52\1\53\1\54\34\0\1\55"+
    "\1\56\3\0\1\57\34\0\1\60\40\0\1\61\1\62"+
    "\41\0\1\63\36\0\1\64\2\0\1\65\14\0\1\5"+
    "\3\0\3\5\11\0\1\66\4\0\10\5\4\0\1\5"+
    "\3\0\3\5\16\0\2\5\1\67\5\5\4\0\1\5"+
    "\3\0\3\5\16\0\1\5\1\70\6\5\4\0\1\5"+
    "\3\0\3\5\16\0\1\5\1\71\6\5\4\0\1\5"+
    "\3\0\3\5\16\0\2\5\1\72\5\5\41\0\1\73"+
    "\3\0\36\37\34\0\1\74\1\75\1\76\2\0\1\77"+
    "\3\0\1\100\77\0\1\100\5\0\1\101\53\0\1\102"+
    "\41\0\1\103\1\104\37\0\1\105\40\0\1\106\40\0"+
    "\1\107\40\0\1\110\37\0\1\111\30\0\1\112\51\0"+
    "\1\113\42\0\1\114\15\0\1\5\3\0\3\5\16\0"+
    "\1\115\7\5\4\0\1\5\3\0\3\5\16\0\2\5"+
    "\1\116\5\5\4\0\1\5\3\0\3\5\16\0\2\5"+
    "\1\117\5\5\4\0\1\5\3\0\3\5\16\0\6\5"+
    "\1\120\1\5\41\0\1\121\11\0\1\122\53\0\1\123"+
    "\40\0\1\124\17\0\1\5\3\0\3\5\16\0\1\125"+
    "\7\5\4\0\1\5\3\0\3\5\16\0\1\126\7\5"+
    "\4\0\1\5\3\0\3\5\16\0\7\5\1\127\7\0"+
    "\1\130\56\0\1\131\26\0\1\130\30\0\1\130";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1683];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\4\0\2\1\1\11\3\1\6\11\14\1\2\11\1\1"+
    "\1\11\1\1\1\11\2\1\1\11\2\0\3\1\1\0"+
    "\3\1\2\11\1\1\1\11\1\1\3\11\4\1\1\0"+
    "\5\11\1\0\1\11\1\0\1\1\10\11\4\1\1\11"+
    "\1\0\1\11\1\0\4\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[89];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public int yyline;
    StringBuffer inString = new StringBuffer();
    final static Logger LOG = Logger.getInstance(_MscLexer.class);

    public _MscLexer() {
        this((java.io.Reader)null);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _MscLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzMarkedPosL*/);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL.charAt(zzMarkedPosL) == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL.charAt(zzMarkedPosL) == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        switch (zzLexicalState) {
            case IN_BLOCK_COMMENT: {
              yybegin(YYINITIAL); return MscTypes.COMMENT;
            }  // fall though
            case 90: break;
            case IN_LINE_COMMENT: {
              yybegin(YYINITIAL); return MscTypes.COMMENT;
            }  // fall though
            case 91: break;
            default:
        return null;
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return MscTypes.IDENTIFIER;
            } 
            // fall through
          case 55: break;
          case 2: 
            { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 56: break;
          case 3: 
            { yybegin(IN_LINE_COMMENT);
            } 
            // fall through
          case 57: break;
          case 4: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 58: break;
          case 5: 
            { return MscTypes.SEMICOLON;
            } 
            // fall through
          case 59: break;
          case 6: 
            { return MscTypes.COMMA;
            } 
            // fall through
          case 60: break;
          case 7: 
            { return MscTypes.OPEN_CURLY;
            } 
            // fall through
          case 61: break;
          case 8: 
            { return MscTypes.CLOSE_CURLY;
            } 
            // fall through
          case 62: break;
          case 9: 
            { return MscTypes.OPEN_SQUARE;
            } 
            // fall through
          case 63: break;
          case 10: 
            { return MscTypes.CLOSE_SQUARE;
            } 
            // fall through
          case 64: break;
          case 11: 
            { return MscTypes.EQUALS;
            } 
            // fall through
          case 65: break;
          case 12: 
            { inString.setLength(0); yybegin(STRING);
            } 
            // fall through
          case 66: break;
          case 13: 
            { inString.append( yytext() );
            } 
            // fall through
          case 67: break;
          case 14: 
            { yybegin(YYINITIAL); return MscTypes.STRING_LIT;
            } 
            // fall through
          case 68: break;
          case 15: 
            { inString.append('\\');
            } 
            // fall through
          case 69: break;
          case 16: 
            { 
            } 
            // fall through
          case 70: break;
          case 17: 
            { yybegin(YYINITIAL); return MscTypes.COMMENT;
            } 
            // fall through
          case 71: break;
          case 18: 
            { yybegin(IN_BLOCK_COMMENT); yypushback(2);
            } 
            // fall through
          case 72: break;
          case 19: 
            { return MscTypes.ARROW_LLA;
            } 
            // fall through
          case 73: break;
          case 20: 
            { return MscTypes.ARROW_L;
            } 
            // fall through
          case 74: break;
          case 21: 
            { return MscTypes.DARROW_L;
            } 
            // fall through
          case 75: break;
          case 22: 
            { return MscTypes.EMPHASIZED_ARROW_L;
            } 
            // fall through
          case 76: break;
          case 23: 
            { return MscTypes.LINE_DASH;
            } 
            // fall through
          case 77: break;
          case 24: 
            { return MscTypes.ARROW_R;
            } 
            // fall through
          case 78: break;
          case 25: 
            { return MscTypes.XARROW_R;
            } 
            // fall through
          case 79: break;
          case 26: 
            { return MscTypes.ARROW_RRA;
            } 
            // fall through
          case 80: break;
          case 27: 
            { return MscTypes.DARROW_R;
            } 
            // fall through
          case 81: break;
          case 28: 
            { return MscTypes.LINE_DOUBLE;
            } 
            // fall through
          case 82: break;
          case 29: 
            { return MscTypes.LINE_DOT;
            } 
            // fall through
          case 83: break;
          case 30: 
            { return MscTypes.EMPHASIZED_ARROW_R;
            } 
            // fall through
          case 84: break;
          case 31: 
            { return MscTypes.LINE_DDOT;
            } 
            // fall through
          case 85: break;
          case 32: 
            { return MscTypes.XARROW_L;
            } 
            // fall through
          case 86: break;
          case 33: 
            { inString.append('\r');
            } 
            // fall through
          case 87: break;
          case 34: 
            { inString.append('\n');
            } 
            // fall through
          case 88: break;
          case 35: 
            { inString.append('\t');
            } 
            // fall through
          case 89: break;
          case 36: 
            { inString.append('\"');
            } 
            // fall through
          case 90: break;
          case 37: 
            { return MscTypes.BROADCAST_ARROW_L;
            } 
            // fall through
          case 91: break;
          case 38: 
            { return MscTypes.ARROW_LLB;
            } 
            // fall through
          case 92: break;
          case 39: 
            { return MscTypes.BIDI_ARROW;
            } 
            // fall through
          case 93: break;
          case 40: 
            { return MscTypes.BIDI_DARROW;
            } 
            // fall through
          case 94: break;
          case 41: 
            { return MscTypes.BIDI_DOTARROW;
            } 
            // fall through
          case 95: break;
          case 42: 
            { return MscTypes.BIDI_COLARROW;
            } 
            // fall through
          case 96: break;
          case 43: 
            { return MscTypes.TRIPLE_DASH;
            } 
            // fall through
          case 97: break;
          case 44: 
            { return MscTypes.BROADCAST_ARROW_R;
            } 
            // fall through
          case 98: break;
          case 45: 
            { return MscTypes.ARROW_RRB;
            } 
            // fall through
          case 99: break;
          case 46: 
            { return MscTypes.ELLIPSIS;
            } 
            // fall through
          case 100: break;
          case 47: 
            { return MscTypes.BOX;
            } 
            // fall through
          case 101: break;
          case 48: 
            { return MscTypes.TRIPLE_BAR;
            } 
            // fall through
          case 102: break;
          case 49: 
            { return MscTypes.BIDI_ARROW2B;
            } 
            // fall through
          case 103: break;
          case 50: 
            { return MscTypes.ANGLE_BOX;
            } 
            // fall through
          case 104: break;
          case 51: 
            { return MscTypes.ROUNDED_BOX;
            } 
            // fall through
          case 105: break;
          case 52: 
            { return MscTypes.NOTE_BOX;
            } 
            // fall through
          case 106: break;
          case 53: 
            { return MscTypes.MSC_KEYWORD;
            } 
            // fall through
          case 107: break;
          case 54: 
            { return MscTypes.BIDI_ARROW2A;
            } 
            // fall through
          case 108: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
