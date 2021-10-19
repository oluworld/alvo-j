package net.alvo.v1.util;

import net.alvo.util.UT;
import net.alvo.v1.AEvalableToken;
import net.alvo.v1.AlvoListener;
import net.alvo.v1.AlvoObject;
import net.alvo.v1.AlvoRuntime;
import net.alvo.v1.ExecutionContext;
import net.alvo.util.Assert;

public class CL {
   private final AEvalableToken v;
   private final AlvoListener aal;
   private final AlvoRuntime rt;
   private final ExecutionContext ctx;
   public String eval_failure = null;
   AlvoObject eval_result = null;

   public CL(AEvalableToken aV, AlvoListener aAal, AlvoRuntime arc, ExecutionContext aCtx) {
      this.v = aV;
      this.rt = arc;
      this.aal = aAal;
      this.ctx = aCtx;
   }

   void reset() {
      this.eval_failure = null;
      this.eval_result = null;
   }

   public void process(boolean eres) {
      if (eres && this.eval_failure == null) {
         this.ok();
      } else {
         Assert.check("!eres", !eres);
         this.bad();
      }

   }

   public void ok() {
      if (this.eval_result != null) {
         this.aal.push(this.eval_result);
      }

   }

   public void bad() {
      Assert.precondition("error_set", this.eval_failure != null);
      ExecutionContext.evalError(this.v, this.ctx, this);
   }

   public boolean err(String aString) {
      this.eval_failure = aString;
      return false;
   }

   public void err(Exception aException, String exceptionName, String duringAction) {
      aException.printStackTrace();
      this.eval_failure = exceptionName + " during " + duringAction;
      this.bad();
   }

   public void bad_err(String aReason) {
      this.err(aReason);
      this.bad();
   }

   public void ALVO_err_in_eval() {
      UT.errWp("++ALVO_err_in_eval");
      AlvoObject a1 = this.rt.al.pop();
      AlvoObject a2 = this.rt.al.pop();
      UT.errWp("  Message: " + a1);
      UT.errWp("  Eval:    " + a2);
      UT.errWp("++");
   }

   public AlvoListener listener() {
      return this.aal;
   }
}
