package net.alvo.v1;

import net.alvo.rdf.Literal;
import net.alvo.rdf.Model;
import net.alvo.rdf.Property;
import net.alvo.rdf.PropertyImpl;
import net.alvo.rdf.RDFException;
import net.alvo.util.Assert;

public class CAlvoRdf {
   public Property content;
   public Property type;
   public final String URI = "urn:alvo.net:rdf";

   public CAlvoRdf() {
      try {
         this.type = new PropertyImpl("urn:alvo.net:rdf", "#type");
         this.content = new PropertyImpl("urn:alvo.net:rdf", "#content");
      } catch (RDFException var2) {
         var2.printStackTrace();
      }

   }

   public Property make_prop(String s) {
      PropertyImpl R = null;

      try {
         R = new PropertyImpl("urn:alvo.net:rdf", s);
      } catch (RDFException var4) {
         Assert.not_reached();
      }

      return R;
   }

   public Literal typeOf(AlvoObject anObject, Model m) throws RDFException {
      String s = anObject.typeString();
      Literal R = m.createLiteral(s);
      return R;
   }
}
