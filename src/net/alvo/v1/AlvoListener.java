package net.alvo.v1;

public interface AlvoListener {
   /** @deprecated */
   void eval(AEvalableToken var1, ExecutionContext var2);

   void num_int(AToken var1);

   void num_float(AToken var1);

   void string_lit(AToken var1);

   void ident(AToken var1);

   AlvoObject pop();

   void push(AlvoObject var1);
}
