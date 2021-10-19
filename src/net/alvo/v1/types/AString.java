package net.alvo.v1.types;

import java.util.ArrayList;
import java.util.List;
import net.alvo.util.UT;
import net.alvo.v1.AToken;
import net.alvo.v1.AlvoObject;
import net.alvo.rdf.Model;
import net.alvo.util.Assert;
import net.alvo.util.Pair;

public class AString extends AStringBase {
   public String toString() {
      Assert.precondition("not_null", this.my() != null);
      return "<AString " + this.my() + ">";
   }

   public String typeString() {
      return "ALVO:String";
   }

   public AlvoObject plusM(AlvoObject aRightSide) {
      UT.not_reached();
      return null;
   }

   public AString(AToken aToken) {
      this.myString = aToken.getText();
   }

   public List rdfContent(Model aModel) {
      List R = new ArrayList();
      R.add(Pair.make("#type", "STRING"));
      R.add(Pair.make("#text", this.my()));
      return R;
   }
}
