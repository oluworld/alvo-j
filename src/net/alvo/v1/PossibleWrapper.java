package net.alvo.v1;

import java.lang.reflect.Method;
import net.alvo.v1.types.AEval;

class PossibleWrapper implements IAlvoPossible {
   private IAlvoPossibleTarget myWrappedObject;
   private static final Class[] CLZ = new Class[]{AEval.class, AlvoRuntime.class, ExecutionContext.class};
   // $FF: synthetic field
   static Class class$0;
   // $FF: synthetic field
   static Class class$1;
   // $FF: synthetic field
   static Class class$2;

   public void eval(AEvalableToken aet, ExecutionContext ctx) {
      Method meth = null;
      String during = "<not-reached>";

      try {
         during = "access";
         meth = this.getMethodFor(aet);
         if (meth != null) {
            during = "invocation";
            ctx.rt().enter_frame("<native> for " + aet.tokenText(), aet.getToken().line, aet.getToken().column);
            meth.invoke(this.myWrappedObject, aet, ctx.rt(), ctx);
         }
      } catch (Exception var6) {
         ctx.cl().err(var6, var6.getClass().getName(), during);
      }

      ctx.keeptrying = meth == null;
   }

   private Method getMethod(String evalName) {
      Method meth = null;

      try {
         meth = this.myWrappedObject.getClass().getDeclaredMethod(evalName, CLZ);
      } catch (NoSuchMethodException var4) {
      }

      return meth;
   }

   private Method getMethodFor(AEvalableToken aEval) {
      String s = "eval_" + aEval.getToken().getText().substring(1);
      if (s.endsWith("?")) {
         s = s.substring(1, s.length() - 1) + "_p";
      }

      return this.getMethod(s);
   }

   public PossibleWrapper(IAlvoPossibleTarget aWrapped) {
      this.myWrappedObject = aWrapped;
   }
}
