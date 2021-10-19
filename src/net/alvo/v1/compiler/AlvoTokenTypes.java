package net.alvo.v1.compiler;

public interface AlvoTokenTypes {
   int EOF = 1;
   int NULL_TREE_LOOKAHEAD = 3;
   int PROCEDURE_CALL = 4;
   int EXPR_LIST = 5;
   int NUM_FLOAT = 6;
   int DOT = 7;
   int NUM_INT = 8;
   int EVAL = 9;
   int STRING_LITERAL = 10;
   int IDENT = 11;
   int LPAREN = 12;
   int RPAREN = 13;
   int LCURLY = 14;
   int RCURLY = 15;
   int VOCAB = 16;
   int WS_ = 17;
   int QUOTE = 18;
   int TOK_ARROW = 19;
   int LBRACK = 20;
   int RBRACK = 21;
   int SL_COMMENT = 22;
   int CHAR_LITERAL = 23;
   int ESC = 24;
   int HEX_DIGIT = 25;
   int EXPONENT = 26;
   int FLOAT_SUFFIX = 27;
}
