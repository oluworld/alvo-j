package net.alvo.v1.types;

import java.util.List;
import net.alvo.v1.AlvoObject;
import net.alvo.rdf.Model;
import net.alvo.util.Assert;

public class ASymbol extends AStringBase {
   public String toString() {
      Assert.precondition("not_null", this.my() != null);
      return "<ASymbol " + this.my() + ">";
   }

   public ASymbol(String aString) {
      Assert.precondition("not_null", aString != null);
      this.myString = aString;
   }

   public AlvoObject plusM(AlvoObject aRightSide) {
      Assert.not_implemented();
      return null;
   }

   public String typeString() {
      return "ALVO:Symbol";
   }

   public Model aModel() {
      Assert.not_implemented();
      return null;
   }

   public List rdfContent(Model aModel) {
      Assert.not_implemented();
      return null;
   }
}
