package net.alvo.v1.compiler;

import antlr.LLkParser;
import antlr.NoViableAltException;
import antlr.ParserSharedInputState;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenBuffer;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.collections.impl.BitSet;
import net.alvo.v1.AToken;
import net.alvo.v1.AlvoL;
import net.alvo.v1.AlvoRuntime;

public class AlvoParser extends LLkParser implements AlvoTokenTypes {
   public AlvoRuntime rt;
   public static final String[] _tokenNames = new String[]{"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "PROCEDURE_CALL", "EXPR_LIST", "NUM_FLOAT", "DOT", "NUM_INT", "EVAL", "STRING_LITERAL", "IDENT", "LPAREN", "RPAREN", "LCURLY", "RCURLY", "VOCAB", "WS_", "QUOTE", "TOK_ARROW", "LBRACK", "RBRACK", "SL_COMMENT", "CHAR_LITERAL", "ESC", "HEX_DIGIT", "EXPONENT", "FLOAT_SUFFIX"};
   public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());

   AToken bb(Token at) {
      return new AToken(at.getText(), at.getColumn(), at.getLine());
   }

   protected AlvoParser(TokenBuffer tokenBuf, int k) {
      super(tokenBuf, k);
      this.tokenNames = _tokenNames;
   }

   public AlvoParser(TokenBuffer tokenBuf) {
      this((TokenBuffer)tokenBuf, 2);
   }

   protected AlvoParser(TokenStream lexer, int k) {
      super(lexer, k);
      this.tokenNames = _tokenNames;
   }

   public AlvoParser(TokenStream lexer) {
      this((TokenStream)lexer, 2);
   }

   public AlvoParser(ParserSharedInputState state) {
      super(state, 2);
      this.tokenNames = _tokenNames;
   }

   public final void program(AlvoL l) throws RecognitionException, TokenStreamException {
      while(_tokenSet_0.member(this.LA(1))) {
         this.alvo_expr(l);
      }

   }

   public final void alvo_expr(AlvoL l) throws RecognitionException, TokenStreamException {
      switch(this.LA(1)) {
      case 6:
      case 8:
      case 9:
      case 10:
      case 11:
         this.primitive(l);
         break;
      case 7:
      case 13:
      default:
         throw new NoViableAltException(this.LT(1), this.getFilename());
      case 12:
         this.list(l);
         break;
      case 14:
         this.lazy(l);
      }

   }

   public final void body(AlvoL l) throws RecognitionException, TokenStreamException {
      while(_tokenSet_0.member(this.LA(1))) {
         this.alvo_expr(l);
      }

   }

   public final void lazy(AlvoL l) throws RecognitionException, TokenStreamException {
      Token st = null;
      Token et = null;
      st = this.LT(1);
      this.match(14);
      l.lazy_start(this.bb(st));
      this.body(l);
      et = this.LT(1);
      this.match(15);
      l.lazy_end(this.bb(et));
   }

   public final void list(AlvoL l) throws RecognitionException, TokenStreamException {
      Token st = null;
      Token et = null;
      st = this.LT(1);
      this.match(12);
      l.list_start(this.bb(st));
      this.body(l);
      et = this.LT(1);
      this.match(13);
      l.list_end(this.bb(et));
   }

   public final void primitive(AlvoL l) throws RecognitionException, TokenStreamException {
      Token ni = null;
      Token nf = null;
      Token ev = null;
      switch(this.LA(1)) {
      case 6:
         nf = this.LT(1);
         this.match(6);
         l.num_float(this.bb(nf));
         break;
      case 7:
      default:
         throw new NoViableAltException(this.LT(1), this.getFilename());
      case 8:
         ni = this.LT(1);
         this.match(8);
         l.num_int(this.bb(ni));
         break;
      case 9:
         ev = this.LT(1);
         this.match(9);
         l.eval(this.bb(ev));
         break;
      case 10:
         this.string_literal(l);
         break;
      case 11:
         this.ident(l);
      }

   }

   public final void string_literal(AlvoL l) throws RecognitionException, TokenStreamException {
      Token sl = null;
      sl = this.LT(1);
      this.match(10);
      l.string_lit(this.bb(sl));
   }

   public final void ident(AlvoL l) throws RecognitionException, TokenStreamException {
      Token id = null;
      id = this.LT(1);
      this.match(11);
      l.ident(this.bb(id));
   }

   private static final long[] mk_tokenSet_0() {
      long[] data = new long[]{24384L, 0L};
      return data;
   }
}
