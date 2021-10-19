// $ANTLR 2.7.4: "alvo.g" -> "AlvoLexer.java"$

package net.alvo.v1.compiler;

import net.alvo.v1.*;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class AlvoLexer extends antlr.CharScanner implements AlvoTokenTypes, TokenStream
{
   public AlvoLexer(InputStream in) {
      this(new ByteBuffer(in));
   }
   public AlvoLexer(Reader in) {
      this(new CharBuffer(in));
   }
   public AlvoLexer(InputBuffer ib) {
      this(new LexerSharedInputState(ib));
   }
   public AlvoLexer(LexerSharedInputState state) {
      super(state);
      caseSensitiveLiterals = true;
      setCaseSensitive(true);
      literals = new Hashtable();
   }

   public Token nextToken() throws TokenStreamException {
      Token theRetToken=null;
      tryAgain:
      for (;;) {
         Token _token = null;
         int _ttype = Token.INVALID_TYPE;
         resetText();
         try {   // for char stream error handling
            try {   // for lexical error handling
               switch ( LA(1)) {
               case '\t':  case '\n':  case '\u000c':  case '\r':
               case ' ':
               {
                  mWS_(true);
                  theRetToken=_returnToken;
                  break;
               }
               case '`':
               {
                  mQUOTE(true);
                  theRetToken=_returnToken;
                  break;
               }
               case '(':
               {
                  mLPAREN(true);
                  theRetToken=_returnToken;
                  break;
               }
               case ')':
               {
                  mRPAREN(true);
                  theRetToken=_returnToken;
                  break;
               }
               case '[':
               {
                  mLBRACK(true);
                  theRetToken=_returnToken;
                  break;
               }
               case ']':
               {
                  mRBRACK(true);
                  theRetToken=_returnToken;
                  break;
               }
               case '{':
               {
                  mLCURLY(true);
                  theRetToken=_returnToken;
                  break;
               }


               case '}':
               {
                  mRCURLY(true);
                  theRetToken=_returnToken;
                  break;
               }
               case '\'':
               {
                  mCHAR_LITERAL(true);
                  theRetToken=_returnToken;
                  break;
               }
               case '"':
               {
                  mSTRING_LITERAL(true);
                  theRetToken=_returnToken;
                  break;
               }
               case '$':  case ':':  case 'A':  case 'B':
               case 'C':  case 'D':  case 'E':  case 'F':
               case 'G':  case 'H':  case 'I':  case 'J':
               case 'K':  case 'L':  case 'M':  case 'N':
               case 'O':  case 'P':  case 'Q':  case 'R':
               case 'S':  case 'T':  case 'U':  case 'V':
               case 'W':  case 'X':  case 'Y':  case 'Z':
               case '_':  case 'a':  case 'b':  case 'c':
               case 'd':  case 'e':  case 'f':  case 'g':
               case 'h':  case 'i':  case 'j':  case 'k':
               case 'l':  case 'm':  case 'n':  case 'o':
               case 'p':  case 'q':  case 'r':  case 's':
               case 't':  case 'u':  case 'v':  case 'w':
               case 'x':  case 'y':  case 'z':
               {
                  mIDENT(true);
                  theRetToken=_returnToken;
                  break;
               }
               case '.':  case '0':  case '1':  case '2':
               case '3':  case '4':  case '5':  case '6':
               case '7':  case '8':  case '9':
               {
                  mNUM_INT(true);
                  theRetToken=_returnToken;
                  break;
               }
               case '/':
               {
                  mEVAL(true);
                  theRetToken=_returnToken;
                  break;
               }
               default:
                  if ((LA(1)=='-') && (LA(2)=='>')) {
                     mTOK_ARROW(true);
                     theRetToken=_returnToken;
                  }
                  else if ((LA(1)=='-') && (LA(2)=='-')) {
                     mSL_COMMENT(true);
                     theRetToken=_returnToken;
                  }
                  else {
                     if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
                     else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
                  }
               }
               if ( _returnToken==null ) continue tryAgain; // found SKIP token
               _ttype = _returnToken.getType();
               _ttype = testLiteralsTable(_ttype);
               _returnToken.setType(_ttype);
               return _returnToken;
            }
            catch (RecognitionException e) {
               throw new TokenStreamRecognitionException(e);
            }
         }
         catch (CharStreamException cse) {
            if ( cse instanceof CharStreamIOException ) {
               throw new TokenStreamIOException(((CharStreamIOException)cse).io);
            }
            else {
               throw new TokenStreamException(cse.getMessage());
            }
         }
      }
   }

   protected final void mVOCAB(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = VOCAB;
      int _saveIndex;

      matchRange('\3','\377');
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mWS_(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();


      _ttype = WS_;
      int _saveIndex;

      {
         switch ( LA(1)) {
         case ' ':
         {
            match(' ');
            break;
         }
         case '\t':
         {
            match('\t');
            break;
         }
         case '\u000c':
         {
            match('\f');
            break;
         }
         case '\n':  case '\r':
         {
            {
               if ((LA(1)=='\r') && (LA(2)=='\n')) {
                  match("\r\n");
               }
               else if ((LA(1)=='\r') && (true)) {
                  match('\r');
               }
               else if ((LA(1)=='\n')) {
                  match('\n');
               }
               else {
                  throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
               }

            }
            newline();
            break;
         }
         default:
         {
            throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
         }
         }
      }
      _ttype = Token.SKIP;
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mQUOTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = QUOTE;
      int _saveIndex;

      match("`");
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mTOK_ARROW(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = TOK_ARROW;
      int _saveIndex;

      match("->");
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mLPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = LPAREN;
      int _saveIndex;

      match('(');
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mRPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = RPAREN;
      int _saveIndex;

      match(')');
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);


         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mLBRACK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = LBRACK;
      int _saveIndex;

      match('[');
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mRBRACK(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = RBRACK;
      int _saveIndex;

      match(']');
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mLCURLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = LCURLY;
      int _saveIndex;

      match('{');
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mRCURLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = RCURLY;
      int _saveIndex;

      match('}');
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mSL_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = SL_COMMENT;
      int _saveIndex;

      match("--");
      {
         _loop28:
         do {
            if ((_tokenSet_0.member(LA(1)))) {
               {
                  match(_tokenSet_0);
               }
            }
            else {
               break _loop28;
            }

         } while (true);
      }
      {
         switch ( LA(1)) {
         case '\n':
         {
            match('\n');
            break;
         }
         case '\r':
         {
            match('\r');
            {
               if ((LA(1)=='\n')) {
                  match('\n');
               }
               else {
               }

            }
            break;
         }
         default:
         {
            throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
         }


         }
      }
      _ttype = Token.SKIP; newline();
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mCHAR_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = CHAR_LITERAL;
      int _saveIndex;

      match('\'');
      {
         if ((LA(1)=='\\')) {
            mESC(false);
         }
         else if ((_tokenSet_1.member(LA(1)))) {
            matchNot('\'');
         }
         else {
            throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
         }

      }
      match('\'');
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   protected final void mESC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = ESC;
      int _saveIndex;

      match('\\');
      {
         switch ( LA(1)) {
         case 'n':
         {
            match('n');
            break;
         }
         case 'r':
         {
            match('r');
            break;
         }
         case 't':
         {
            match('t');
            break;
         }
         case 'b':
         {
            match('b');
            break;
         }
         case 'f':
         {
            match('f');
            break;
         }
         case '"':
         {
            match('"');
            break;
         }
         case '\'':
         {
            match('\'');
            break;
         }
         case '\\':
         {
            match('\\');
            break;
         }
         case 'u':
         {
            {
               int _cnt40=0;
               _loop40:
               do {
                  if ((LA(1)=='u')) {
                     match('u');
                  }
                  else {
                     if ( _cnt40>=1 ) { break _loop40; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
                  }

                  _cnt40++;
               } while (true);
            }
            mHEX_DIGIT(false);


            mHEX_DIGIT(false);
            mHEX_DIGIT(false);
            mHEX_DIGIT(false);
            break;
         }
         case '0':  case '1':  case '2':  case '3':
         {
            {
               matchRange('0','3');
            }
            {
               if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
                  {
                     matchRange('0','7');
                  }
                  {
                     if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
                        matchRange('0','7');
                     }
                     else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true)) {
                     }
                     else {
                        throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
                     }

                  }
               }
               else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true)) {
               }
               else {
                  throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
               }

            }
            break;
         }
         case '4':  case '5':  case '6':  case '7':
         {
            {
               matchRange('4','7');
            }
            {
               if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
                  {
                     matchRange('0','9');
                  }
               }
               else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && (true)) {
               }
               else {
                  throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
               }

            }
            break;
         }
         default:
         {
            throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
         }
         }
      }
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mSTRING_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = STRING_LITERAL;
      int _saveIndex;

      match('"');
      {
         _loop36:
         do {
            if ((LA(1)=='\\')) {
               mESC(false);
            }
            else if ((_tokenSet_2.member(LA(1)))) {
               {
                  match(_tokenSet_2);
               }
            }
            else {
               break _loop36;
            }

         } while (true);
      }
      match('"');
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   protected final void mHEX_DIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {


      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = HEX_DIGIT;
      int _saveIndex;

      {
         switch ( LA(1)) {
         case '0':  case '1':  case '2':  case '3':
         case '4':  case '5':  case '6':  case '7':
         case '8':  case '9':
         {
            matchRange('0','9');
            break;
         }
         case 'A':  case 'B':  case 'C':  case 'D':
         case 'E':  case 'F':
         {
            matchRange('A','F');
            break;
         }
         case 'a':  case 'b':  case 'c':  case 'd':
         case 'e':  case 'f':
         {
            matchRange('a','f');
            break;
         }
         default:
         {
            throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
         }
         }
      }
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mIDENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = IDENT;
      int _saveIndex;

      {
         switch ( LA(1)) {
         case 'a':  case 'b':  case 'c':  case 'd':
         case 'e':  case 'f':  case 'g':  case 'h':
         case 'i':  case 'j':  case 'k':  case 'l':
         case 'm':  case 'n':  case 'o':  case 'p':
         case 'q':  case 'r':  case 's':  case 't':
         case 'u':  case 'v':  case 'w':  case 'x':
         case 'y':  case 'z':
         {
            matchRange('a','z');
            break;
         }
         case 'A':  case 'B':  case 'C':  case 'D':
         case 'E':  case 'F':  case 'G':  case 'H':
         case 'I':  case 'J':  case 'K':  case 'L':
         case 'M':  case 'N':  case 'O':  case 'P':
         case 'Q':  case 'R':  case 'S':  case 'T':
         case 'U':  case 'V':  case 'W':  case 'X':
         case 'Y':  case 'Z':
         {
            matchRange('A','Z');
            break;
         }
         case '_':
         {
            match('_');
            break;
         }
         case '$':
         {
            match('$');
            break;
         }
         case ':':
         {
            match(':');
            break;
         }
         default:
         {
            throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
         }
         }
      }
      {
         _loop54:
         do {
            if ((_tokenSet_3.member(LA(1)))) {
               {
                  match(_tokenSet_3);
               }
            }
            else {
               break _loop54;
            }

         } while (true);


      }
      _ttype = testLiteralsTable(_ttype);
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mNUM_INT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = NUM_INT;
      int _saveIndex;
      boolean isDecimal=false;

      switch ( LA(1)) {
      case '.':
      {
         match('.');
         _ttype = DOT;
         {
            if (((LA(1) >= '0' && LA(1) <= '9'))) {
               {
                  int _cnt58=0;
                  _loop58:
                  do {
                     if (((LA(1) >= '0' && LA(1) <= '9'))) {
                        matchRange('0','9');
                     }
                     else {
                        if ( _cnt58>=1 ) { break _loop58; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
                     }

                     _cnt58++;
                  } while (true);
               }
               {
                  if ((LA(1)=='E'||LA(1)=='e')) {
                     mEXPONENT(false);
                  }
                  else {
                  }

               }
               {
                  if ((_tokenSet_4.member(LA(1)))) {
                     mFLOAT_SUFFIX(false);
                  }
                  else {
                  }

               }
               _ttype = NUM_FLOAT;
            }
            else {
            }

         }
         break;
      }
      case '0':  case '1':  case '2':  case '3':
      case '4':  case '5':  case '6':  case '7':
      case '8':  case '9':
      {
         {
            switch ( LA(1)) {
            case '0':
            {
               match('0');
               isDecimal = true;
               {
                  switch ( LA(1)) {
                  case 'X':  case 'x':
                  {
                     {
                        switch ( LA(1)) {
                        case 'x':
                        {
                           match('x');
                           break;
                        }
                        case 'X':
                        {
                           match('X');
                           break;
                        }
                        default:
                        {
                           throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
                        }
                        }
                     }
                     {
                        int _cnt65=0;
                        _loop65:
                        do {
                           if ((_tokenSet_5.member(LA(1))) && (true)) {
                              mHEX_DIGIT(false);
                           }
                           else {
                              if ( _cnt65>=1 ) { break _loop65; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}


                           }

                           _cnt65++;
                        } while (true);
                     }
                     break;
                  }
                  case '0':  case '1':  case '2':  case '3':
                  case '4':  case '5':  case '6':  case '7':
                  {
                     {
                        int _cnt67=0;
                        _loop67:
                        do {
                           if (((LA(1) >= '0' && LA(1) <= '7'))) {
                              matchRange('0','7');
                           }
                           else {
                              if ( _cnt67>=1 ) { break _loop67; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
                           }

                           _cnt67++;
                        } while (true);
                     }
                     break;
                  }
                  default:
                  {
                  }
                  }
               }
               break;
            }
            case '1':  case '2':  case '3':  case '4':
            case '5':  case '6':  case '7':  case '8':
            case '9':
            {
               {
                  matchRange('1','9');
               }
               {
                  _loop70:
                  do {
                     if (((LA(1) >= '0' && LA(1) <= '9'))) {
                        matchRange('0','9');
                     }
                     else {
                        break _loop70;
                     }

                  } while (true);
               }
               isDecimal=true;
               break;
            }
            default:
            {
               throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
            }
            }
         }
         {
            if ((LA(1)=='L'||LA(1)=='l')) {
               {
                  switch ( LA(1)) {
                  case 'l':
                  {
                     match('l');
                     break;
                  }
                  case 'L':
                  {
                     match('L');
                     break;
                  }
                  default:
                  {
                     throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
                  }
                  }
               }
            }
            else if (((_tokenSet_6.member(LA(1))))&&(isDecimal)) {
               {
                  switch ( LA(1)) {
                  case '.':
                  {
                     match('.');
                     {
                        _loop75:
                        do {
                           if (((LA(1) >= '0' && LA(1) <= '9'))) {
                              matchRange('0','9');
                           }
                           else {
                              break _loop75;
                           }

                        } while (true);
                     }
                     {


                        if ((LA(1)=='E'||LA(1)=='e')) {
                           mEXPONENT(false);
                        }
                        else {
                        }

                     }
                     {
                        if ((_tokenSet_4.member(LA(1)))) {
                           mFLOAT_SUFFIX(false);
                        }
                        else {
                        }

                     }
                     break;
                  }
                  case 'E':  case 'e':
                  {
                     mEXPONENT(false);
                     {
                        if ((_tokenSet_4.member(LA(1)))) {
                           mFLOAT_SUFFIX(false);
                        }
                        else {
                        }

                     }
                     break;
                  }
                  case 'D':  case 'F':  case 'd':  case 'f':
                  {
                     mFLOAT_SUFFIX(false);
                     break;
                  }
                  default:
                  {
                     throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
                  }
                  }
               }
               _ttype = NUM_FLOAT;
            }
            else {
            }

         }
         break;
      }
      default:
      {
         throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
      }
      }
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   protected final void mEXPONENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = EXPONENT;
      int _saveIndex;

      {
         switch ( LA(1)) {
         case 'e':
         {
            match('e');
            break;
         }
         case 'E':
         {
            match('E');
            break;
         }
         default:
         {
            throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
         }
         }
      }
      {
         switch ( LA(1)) {
         case '+':
         {
            match('+');
            break;
         }
         case '-':
         {
            match('-');
            break;
         }
         case '0':  case '1':  case '2':  case '3':
         case '4':  case '5':  case '6':  case '7':
         case '8':  case '9':
         {
            break;


         }
         default:
         {
            throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
         }
         }
      }
      {
         int _cnt83=0;
         _loop83:
         do {
            if (((LA(1) >= '0' && LA(1) <= '9'))) {
               matchRange('0','9');
            }
            else {
               if ( _cnt83>=1 ) { break _loop83; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
            }

            _cnt83++;
         } while (true);
      }
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   protected final void mFLOAT_SUFFIX(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = FLOAT_SUFFIX;
      int _saveIndex;

      switch ( LA(1)) {
      case 'f':
      {
         match('f');
         break;
      }
      case 'F':
      {
         match('F');
         break;
      }
      case 'd':
      {
         match('d');
         break;
      }
      case 'D':
      {
         match('D');
         break;
      }
      default:
      {
         throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
      }
      }
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }

   public final void mEVAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
      int _ttype; Token _token=null; int _begin=text.length();
      _ttype = EVAL;
      int _saveIndex;

      match('/');
      mIDENT(false);
      if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
         _token = makeToken(_ttype);
         _token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
      }
      _returnToken = _token;
   }


   private static final long[] mk_tokenSet_0() {
      long[] data = new long[8];
      data[0]=-9224L;
      for (int i = 1; i<=3; i++) { data[i]=-1L; }
      return data;
   }
   public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
   private static final long[] mk_tokenSet_1() {
      long[] data = new long[8];
      data[0]=-549755813896L;
      data[1]=-268435457L;
      for (int i = 2; i<=3; i++) { data[i]=-1L; }
      return data;
   }
   public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
   private static final long[] mk_tokenSet_2() {
      long[] data = new long[8];
      data[0]=-17179869192L;
      data[1]=-268435457L;
      for (int i = 2; i<=3; i++) { data[i]=-1L; }


      return data;
   }
   public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
   private static final long[] mk_tokenSet_3() {
      long[] data = new long[8];
      data[0]=-2203318236680L;
      data[1]=-2305843009750564865L;
      for (int i = 2; i<=3; i++) { data[i]=-1L; }
      return data;
   }
   public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
   private static final long[] mk_tokenSet_4() {
      long[] data = { 0L, 343597383760L, 0L, 0L, 0L};
      return data;
   }
   public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
   private static final long[] mk_tokenSet_5() {
      long[] data = { 287948901175001088L, 541165879422L, 0L, 0L, 0L};
      return data;
   }
   public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
   private static final long[] mk_tokenSet_6() {
      long[] data = { 70368744177664L, 481036337264L, 0L, 0L, 0L};
      return data;
   }
   public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());

}
