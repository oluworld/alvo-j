package net.alvo.v1;

import java.io.PrintWriter;
import net.alvo.util.UT;
import net.alvo.v1.types.AIdent;
import net.alvo.v1.types.AInt;
import net.alvo.v1.types.AList;
import net.alvo.v1.types.AString;
import net.alvo.v1.types.Lazy;
import net.alvo.util.Assert;

public abstract class kkk_racist implements AlvoListener {
   private IAlvoStack s = null;

   public void num_int(AToken at) {
      String e = at.getText();

      try {
         int i = Integer.parseInt(e);
         this.s().push(new AInt(i));
      } catch (NumberFormatException var4) {
         UT.not_reached();
      }

   }

   public void num_float(AToken at) {
      String e = at.getText();
      this.out().println("num_float " + e);

      try {
         double dbl = Double.parseDouble(e);
         this.s().push(new AFloat(dbl));
      } catch (NumberFormatException var5) {
         UT.not_reached();
      }

   }

   public void string_lit(AToken at) {
      this.out().println("string_lit " + at.getText());
      this.s().push(new AString(at));
   }

   protected PrintWriter out() {
      return UT.outW;
   }

   public void ident(AToken e) {
      this.s().push(new AIdent(e));
   }

   public void lazy(Lazy al) {
      this.push(al);
   }

   public void list(AList al) {
      this.push(al);
   }

   public abstract void push(AlvoObject var1);

   public void list_start() {
      Assert.not_implemented();
   }

   public void list_end() {
      Assert.not_implemented();
   }

   public void lazy_start() {
      Assert.not_implemented();
   }

   public void lazy_end() {
      Assert.not_implemented();
   }

   public void setStack(IAlvoStack s) {
      this.s = s;
   }

   public IAlvoStack s() {
      return this.s;
   }
}
