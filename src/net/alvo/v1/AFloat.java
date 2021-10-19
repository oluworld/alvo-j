package net.alvo.v1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import net.alvo.util.UT;
import net.alvo.rdf.Model;
import net.alvo.util.Pair;

public class AFloat implements AlvoObject {
   double me;

   public boolean eq(AlvoObject aRightSide, AlvoRuntime rt) {
      UT.not_reached();
      return false;
   }

   public AFloat(double aMe) {
      this.me = aMe;
   }

   public void printlnM(PrintWriter ps) {
      ps.println(this.me);
   }

   public boolean eval(AlvoRuntime rt) {
      UT.not_reached();
      return false;
   }

   public AlvoObject plusM(AlvoObject aRightSide) {
      UT.not_reached();
      return null;
   }

   public String typeString() {
      return "ALVO:Float";
   }

   public List rdfContent(Model aModel) {
      List R = new ArrayList();
      R.add(Pair.make("#type", "FLOAT"));
      R.add(Pair.make("#text", "" + this.my()));
      return R;
   }

   private double my() {
      return this.me;
   }
}
