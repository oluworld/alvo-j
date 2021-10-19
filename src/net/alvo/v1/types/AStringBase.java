package net.alvo.v1.types;

import java.io.PrintWriter;
import net.alvo.util.UT;
import net.alvo.v1.AlvoObject;
import net.alvo.v1.AlvoRuntime;

abstract class AStringBase implements AlvoObject {
   String myString = null;

   public boolean eq(AlvoObject aRightSide, AlvoRuntime rt) {
      UT.not_reached();
      return false;
   }

   public void printlnM(PrintWriter ps) {
      ps.print(this.myString);
   }

   public String my() {
      return this.myString;
   }
}
