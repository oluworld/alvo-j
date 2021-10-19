package net.alvo.v1.compiler;

import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.CharScanner;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.InputBuffer;
import antlr.LexerSharedInputState;
import antlr.NoViableAltForCharException;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.collections.impl.BitSet;
import java.io.InputStream;
import java.io.Reader;
import java.util.Hashtable;

public class AlvoLexer extends CharScanner implements AlvoTokenTypes, TokenStream {
   public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
   public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
   public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
   public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
   public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
   public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
   public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());

   public AlvoLexer(InputStream in) {
      this((InputBuffer)(new ByteBuffer(in)));
   }

   public AlvoLexer(Reader in) {
      this((InputBuffer)(new CharBuffer(in)));
   }

   public AlvoLexer(InputBuffer ib) {
      this(new LexerSharedInputState(ib));
   }

   public AlvoLexer(LexerSharedInputState state) {
      super(state);
      this.caseSensitiveLiterals = true;
      this.setCaseSensitive(true);
      this.literals = new Hashtable();
   }

   public Token nextToken() throws TokenStreamException {
      Token var1 = null;

      while(true) {
         Token _token = null;
         int _ttype = false;
         this.resetText();

         try {
            try {
               switch(this.LA(1)) {
               case '\t':
               case '\n':
               case '\f':
               case '\r':
               case ' ':
                  this.mWS_(true);
                  var1 = this._returnToken;
                  break;
               case '\u000b':
               case '\u000e':
               case '\u000f':
               case '\u0010':
               case '\u0011':
               case '\u0012':
               case '\u0013':
               case '\u0014':
               case '\u0015':
               case '\u0016':
               case '\u0017':
               case '\u0018':
               case '\u0019':
               case '\u001a':
               case '\u001b':
               case '\u001c':
               case '\u001d':
               case '\u001e':
               case '\u001f':
               case '!':
               case '#':
               case '%':
               case '&':
               case '*':
               case '+':
               case ',':
               case '-':
               case ';':
               case '<':
               case '=':
               case '>':
               case '?':
               case '@':
               case '\\':
               case '^':
               case '|':
               default:
                  if (this.LA(1) == '-' && this.LA(2) == '>') {
                     this.mTOK_ARROW(true);
                     var1 = this._returnToken;
                  } else if (this.LA(1) == '-' && this.LA(2) == '-') {
                     this.mSL_COMMENT(true);
                     var1 = this._returnToken;
                  } else {
                     if (this.LA(1) != '\uffff') {
                        throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
                     }

                     this.uponEOF();
                     this._returnToken = this.makeToken(1);
                  }
                  break;
               case '"':
                  this.mSTRING_LITERAL(true);
                  var1 = this._returnToken;
                  break;
               case '$':
               case ':':
               case 'A':
               case 'B':
               case 'C':
               case 'D':
               case 'E':
               case 'F':
               case 'G':
               case 'H':
               case 'I':
               case 'J':
               case 'K':
               case 'L':
               case 'M':
               case 'N':
               case 'O':
               case 'P':
               case 'Q':
               case 'R':
               case 'S':
               case 'T':
               case 'U':
               case 'V':
               case 'W':
               case 'X':
               case 'Y':
               case 'Z':
               case '_':
               case 'a':
               case 'b':
               case 'c':
               case 'd':
               case 'e':
               case 'f':
               case 'g':
               case 'h':
               case 'i':
               case 'j':
               case 'k':
               case 'l':
               case 'm':
               case 'n':
               case 'o':
               case 'p':
               case 'q':
               case 'r':
               case 's':
               case 't':
               case 'u':
               case 'v':
               case 'w':
               case 'x':
               case 'y':
               case 'z':
                  this.mIDENT(true);
                  var1 = this._returnToken;
                  break;
               case '\'':
                  this.mCHAR_LITERAL(true);
                  var1 = this._returnToken;
                  break;
               case '(':
                  this.mLPAREN(true);
                  var1 = this._returnToken;
                  break;
               case ')':
                  this.mRPAREN(true);
                  var1 = this._returnToken;
                  break;
               case '.':
               case '0':
               case '1':
               case '2':
               case '3':
               case '4':
               case '5':
               case '6':
               case '7':
               case '8':
               case '9':
                  this.mNUM_INT(true);
                  var1 = this._returnToken;
                  break;
               case '/':
                  this.mEVAL(true);
                  var1 = this._returnToken;
                  break;
               case '[':
                  this.mLBRACK(true);
                  var1 = this._returnToken;
                  break;
               case ']':
                  this.mRBRACK(true);
                  var1 = this._returnToken;
                  break;
               case '`':
                  this.mQUOTE(true);
                  var1 = this._returnToken;
                  break;
               case '{':
                  this.mLCURLY(true);
                  var1 = this._returnToken;
                  break;
               case '}':
                  this.mRCURLY(true);
                  var1 = this._returnToken;
               }

               if (this._returnToken != null) {
                  int _ttype = this._returnToken.getType();
                  _ttype = this.testLiteralsTable(_ttype);
                  this._returnToken.setType(_ttype);
                  return this._returnToken;
               }
            } catch (RecognitionException var5) {
               throw new TokenStreamRecognitionException(var5);
            }
         } catch (CharStreamException var6) {
            if (var6 instanceof CharStreamIOException) {
               throw new TokenStreamIOException(((CharStreamIOException)var6).io);
            }

            throw new TokenStreamException(var6.getMessage());
         }
      }
   }

   protected final void mVOCAB(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 16;
      this.matchRange('\u0003', 'ÿ');
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mWS_(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = true;
      switch(this.LA(1)) {
      case '\t':
         this.match('\t');
         break;
      case '\n':
      case '\r':
         if (this.LA(1) == '\r' && this.LA(2) == '\n') {
            this.match("\r\n");
         } else if (this.LA(1) == '\r') {
            this.match('\r');
         } else {
            if (this.LA(1) != '\n') {
               throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
            }

            this.match('\n');
         }

         this.newline();
         break;
      case '\f':
         this.match('\f');
         break;
      case ' ':
         this.match(' ');
         break;
      default:
         throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
      }

      int _ttype = -1;
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mQUOTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 18;
      this.match("`");
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mTOK_ARROW(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 19;
      this.match("->");
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mLPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 12;
      this.match('(');
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mRPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 13;
      this.match(')');
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mLBRACK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 20;
      this.match('[');
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mRBRACK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 21;
      this.match(']');
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mLCURLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 14;
      this.match('{');
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mRCURLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 15;
      this.match('}');
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mSL_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = true;
      this.match("--");

      while(_tokenSet_0.member(this.LA(1))) {
         this.match(_tokenSet_0);
      }

      switch(this.LA(1)) {
      case '\n':
         this.match('\n');
         break;
      case '\u000b':
      case '\f':
      default:
         throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
      case '\r':
         this.match('\r');
         if (this.LA(1) == '\n') {
            this.match('\n');
         }
      }

      int _ttype = -1;
      this.newline();
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mCHAR_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 23;
      this.match('\'');
      if (this.LA(1) == '\\') {
         this.mESC(false);
      } else {
         if (!_tokenSet_1.member(this.LA(1))) {
            throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
         }

         this.matchNot('\'');
      }

      this.match('\'');
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   protected final void mESC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 24;
      this.match('\\');
      switch(this.LA(1)) {
      case '"':
         this.match('"');
         break;
      case '\'':
         this.match('\'');
         break;
      case '0':
      case '1':
      case '2':
      case '3':
         this.matchRange('0', '3');
         if (this.LA(1) >= '0' && this.LA(1) <= '7' && this.LA(2) >= 3 && this.LA(2) <= 255) {
            this.matchRange('0', '7');
            if (this.LA(1) >= '0' && this.LA(1) <= '7' && this.LA(2) >= 3 && this.LA(2) <= 255) {
               this.matchRange('0', '7');
               break;
            }

            if (this.LA(1) >= 3 && this.LA(1) <= 255) {
               break;
            }

            throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
         }

         if (this.LA(1) < 3 || this.LA(1) > 255) {
            throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
         }
         break;
      case '4':
      case '5':
      case '6':
      case '7':
         this.matchRange('4', '7');
         if (this.LA(1) >= '0' && this.LA(1) <= '9' && this.LA(2) >= 3 && this.LA(2) <= 255) {
            this.matchRange('0', '9');
            break;
         } else {
            if (this.LA(1) >= 3 && this.LA(1) <= 255) {
               break;
            }

            throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
         }
      case '\\':
         this.match('\\');
         break;
      case 'b':
         this.match('b');
         break;
      case 'f':
         this.match('f');
         break;
      case 'n':
         this.match('n');
         break;
      case 'r':
         this.match('r');
         break;
      case 't':
         this.match('t');
         break;
      case 'u':
         int _cnt40;
         for(_cnt40 = 0; this.LA(1) == 'u'; ++_cnt40) {
            this.match('u');
         }

         if (_cnt40 < 1) {
            throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
         }

         this.mHEX_DIGIT(false);
         this.mHEX_DIGIT(false);
         this.mHEX_DIGIT(false);
         this.mHEX_DIGIT(false);
         break;
      default:
         throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
      }

      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mSTRING_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 10;
      this.match('"');

      while(true) {
         while(this.LA(1) != '\\') {
            if (!_tokenSet_2.member(this.LA(1))) {
               this.match('"');
               if (_createToken && _token == null && _ttype != -1) {
                  _token = this.makeToken(_ttype);
                  _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
               }

               this._returnToken = _token;
               return;
            }

            this.match(_tokenSet_2);
         }

         this.mESC(false);
      }
   }

   protected final void mHEX_DIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 25;
      switch(this.LA(1)) {
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
         this.matchRange('0', '9');
         break;
      case ':':
      case ';':
      case '<':
      case '=':
      case '>':
      case '?':
      case '@':
      case 'G':
      case 'H':
      case 'I':
      case 'J':
      case 'K':
      case 'L':
      case 'M':
      case 'N':
      case 'O':
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
      case 'T':
      case 'U':
      case 'V':
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
      case '[':
      case '\\':
      case ']':
      case '^':
      case '_':
      case '`':
      default:
         throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
      case 'A':
      case 'B':
      case 'C':
      case 'D':
      case 'E':
      case 'F':
         this.matchRange('A', 'F');
         break;
      case 'a':
      case 'b':
      case 'c':
      case 'd':
      case 'e':
      case 'f':
         this.matchRange('a', 'f');
      }

      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mIDENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 11;
      switch(this.LA(1)) {
      case '$':
         this.match('$');
         break;
      case '%':
      case '&':
      case '\'':
      case '(':
      case ')':
      case '*':
      case '+':
      case ',':
      case '-':
      case '.':
      case '/':
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
      case ';':
      case '<':
      case '=':
      case '>':
      case '?':
      case '@':
      case '[':
      case '\\':
      case ']':
      case '^':
      case '`':
      default:
         throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
      case ':':
         this.match(':');
         break;
      case 'A':
      case 'B':
      case 'C':
      case 'D':
      case 'E':
      case 'F':
      case 'G':
      case 'H':
      case 'I':
      case 'J':
      case 'K':
      case 'L':
      case 'M':
      case 'N':
      case 'O':
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
      case 'T':
      case 'U':
      case 'V':
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
         this.matchRange('A', 'Z');
         break;
      case '_':
         this.match('_');
         break;
      case 'a':
      case 'b':
      case 'c':
      case 'd':
      case 'e':
      case 'f':
      case 'g':
      case 'h':
      case 'i':
      case 'j':
      case 'k':
      case 'l':
      case 'm':
      case 'n':
      case 'o':
      case 'p':
      case 'q':
      case 'r':
      case 's':
      case 't':
      case 'u':
      case 'v':
      case 'w':
      case 'x':
      case 'y':
      case 'z':
         this.matchRange('a', 'z');
      }

      while(_tokenSet_3.member(this.LA(1))) {
         this.match(_tokenSet_3);
      }

      int _ttype = this.testLiteralsTable(_ttype);
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mNUM_INT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      byte _ttype;
      Token _token;
      int _begin;
      label175: {
         _token = null;
         _begin = this.text.length();
         _ttype = 8;
         boolean isDecimal = false;
         int _cnt65;
         switch(this.LA(1)) {
         case '.':
            this.match('.');
            _ttype = 7;
            if (this.LA(1) >= '0' && this.LA(1) <= '9') {
               for(_cnt65 = 0; this.LA(1) >= '0' && this.LA(1) <= '9'; ++_cnt65) {
                  this.matchRange('0', '9');
               }

               if (_cnt65 < 1) {
                  throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
               }

               if (this.LA(1) == 'E' || this.LA(1) == 'e') {
                  this.mEXPONENT(false);
               }

               if (_tokenSet_4.member(this.LA(1))) {
                  this.mFLOAT_SUFFIX(false);
               }

               _ttype = 6;
            }
            break label175;
         case '/':
         default:
            throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
         case '0':
         case '1':
         case '2':
         case '3':
         case '4':
         case '5':
         case '6':
         case '7':
         case '8':
         case '9':
         }

         label167:
         switch(this.LA(1)) {
         case '0':
            this.match('0');
            isDecimal = true;
            switch(this.LA(1)) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
               for(_cnt65 = 0; this.LA(1) >= '0' && this.LA(1) <= '7'; ++_cnt65) {
                  this.matchRange('0', '7');
               }

               if (_cnt65 < 1) {
                  throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
               }
               break label167;
            case 'X':
            case 'x':
               switch(this.LA(1)) {
               case 'X':
                  this.match('X');
                  break;
               case 'x':
                  this.match('x');
                  break;
               default:
                  throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
               }

               for(_cnt65 = 0; _tokenSet_5.member(this.LA(1)); ++_cnt65) {
                  this.mHEX_DIGIT(false);
               }

               if (_cnt65 < 1) {
                  throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
               }
            default:
               break label167;
            }
         case '1':
         case '2':
         case '3':
         case '4':
         case '5':
         case '6':
         case '7':
         case '8':
         case '9':
            this.matchRange('1', '9');

            while(this.LA(1) >= '0' && this.LA(1) <= '9') {
               this.matchRange('0', '9');
            }

            isDecimal = true;
            break;
         default:
            throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
         }

         if (this.LA(1) != 'L' && this.LA(1) != 'l') {
            if (_tokenSet_6.member(this.LA(1)) && isDecimal) {
               switch(this.LA(1)) {
               case '.':
                  this.match('.');

                  while(this.LA(1) >= '0' && this.LA(1) <= '9') {
                     this.matchRange('0', '9');
                  }

                  if (this.LA(1) == 'E' || this.LA(1) == 'e') {
                     this.mEXPONENT(false);
                  }

                  if (_tokenSet_4.member(this.LA(1))) {
                     this.mFLOAT_SUFFIX(false);
                  }
                  break;
               case 'D':
               case 'F':
               case 'd':
               case 'f':
                  this.mFLOAT_SUFFIX(false);
                  break;
               case 'E':
               case 'e':
                  this.mEXPONENT(false);
                  if (_tokenSet_4.member(this.LA(1))) {
                     this.mFLOAT_SUFFIX(false);
                  }
                  break;
               default:
                  throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
               }

               _ttype = 6;
            }
         } else {
            switch(this.LA(1)) {
            case 'L':
               this.match('L');
               break;
            case 'l':
               this.match('l');
               break;
            default:
               throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
            }
         }
      }

      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   protected final void mEXPONENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 26;
      switch(this.LA(1)) {
      case 'E':
         this.match('E');
         break;
      case 'e':
         this.match('e');
         break;
      default:
         throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
      }

      switch(this.LA(1)) {
      case '+':
         this.match('+');
         break;
      case ',':
      case '.':
      case '/':
      default:
         throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
      case '-':
         this.match('-');
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
      }

      int _cnt83;
      for(_cnt83 = 0; this.LA(1) >= '0' && this.LA(1) <= '9'; ++_cnt83) {
         this.matchRange('0', '9');
      }

      if (_cnt83 >= 1) {
         if (_createToken && _token == null && _ttype != -1) {
            _token = this.makeToken(_ttype);
            _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
         }

         this._returnToken = _token;
      } else {
         throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
      }
   }

   protected final void mFLOAT_SUFFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 27;
      switch(this.LA(1)) {
      case 'D':
         this.match('D');
         break;
      case 'F':
         this.match('F');
         break;
      case 'd':
         this.match('d');
         break;
      case 'f':
         this.match('f');
         break;
      default:
         throw new NoViableAltForCharException(this.LA(1), this.getFilename(), this.getLine(), this.getColumn());
      }

      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   public final void mEVAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      Token _token = null;
      int _begin = this.text.length();
      int _ttype = 9;
      this.match('/');
      this.mIDENT(false);
      if (_createToken && _token == null && _ttype != -1) {
         _token = this.makeToken(_ttype);
         _token.setText(new String(this.text.getBuffer(), _begin, this.text.length() - _begin));
      }

      this._returnToken = _token;
   }

   private static final long[] mk_tokenSet_0() {
      long[] data = new long[8];
      data[0] = -9224L;

      for(int i = 1; i <= 3; ++i) {
         data[i] = -1L;
      }

      return data;
   }

   private static final long[] mk_tokenSet_1() {
      long[] data = new long[8];
      data[0] = -549755813896L;
      data[1] = -268435457L;

      for(int i = 2; i <= 3; ++i) {
         data[i] = -1L;
      }

      return data;
   }

   private static final long[] mk_tokenSet_2() {
      long[] data = new long[8];
      data[0] = -17179869192L;
      data[1] = -268435457L;

      for(int i = 2; i <= 3; ++i) {
         data[i] = -1L;
      }

      return data;
   }

   private static final long[] mk_tokenSet_3() {
      long[] data = new long[8];
      data[0] = -2203318236680L;
      data[1] = -2305843009750564865L;

      for(int i = 2; i <= 3; ++i) {
         data[i] = -1L;
      }

      return data;
   }

   private static final long[] mk_tokenSet_4() {
      long[] data = new long[]{0L, 343597383760L, 0L, 0L, 0L};
      return data;
   }

   private static final long[] mk_tokenSet_5() {
      long[] data = new long[]{287948901175001088L, 541165879422L, 0L, 0L, 0L};
      return data;
   }

   private static final long[] mk_tokenSet_6() {
      long[] data = new long[]{70368744177664L, 481036337264L, 0L, 0L, 0L};
      return data;
   }
}
