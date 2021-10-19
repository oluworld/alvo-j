package net.alvo.v1;

import java.util.Iterator;
import net.alvo.rdf.Literal;
import net.alvo.rdf.Model;
import net.alvo.rdf.RDFException;
import net.alvo.rdf.RDFNode;
import net.alvo.rdfquery.Query;
import net.alvo.rdfquery.QueryEngine;
import net.alvo.rdfquery.QueryExecution;
import net.alvo.rdfquery.QueryResults;
import net.alvo.rdfquery.ResultBinding;
import net.alvo.util.Assert;

public class FakeResource {
   private CAlvoRdf AlvoRdf = new CAlvoRdf();
   String base;
   private Model m;
   public String querybase;
   private QueryResults results;

   public FakeResource(String aString, Model am) {
      this.base = aString;
      this.m = am;
      this.querybase = this.base + "/0";
   }

   private String _typeString() throws RDFException {
      String R = null;
      this.results = this.do_query(this.base, sm(this.m.createLiteral(this.querybase), this.AlvoRdf.type));
      Literal x = this.extract_query(this.results);
      if (x != null) {
         System.out.println("x = " + x);
         String typename = null;

         try {
            typename = x.getString();
            if (typename.equals("IDENT")) {
               RDFNode a1 = this.AlvoRdf.make_prop("#text");
               String nn = this.base;
               Iterator i = this.do_query(nn, sm(a1, x));
               if (i != null && i.hasNext()) {
                  String var8 = "" + ((ResultBinding)((ResultBinding)i.next())).get("x");
               } else {
                  Assert.not_reached();
               }
            }
         } catch (RDFException var9) {
            Assert.not_reached();
         }
      }

      return (String)R;
   }

   private QueryResults do_query(String aBase, String aQueryString) {
      Query query = new Query(aQueryString);
      query.setSource(this.m);
      QueryExecution qe = new QueryEngine(query);
      return qe.exec();
   }

   private Literal extract_query(QueryResults iter) {
      if (!iter.hasNext()) {
         if (this.results != null) {
            this.results.close();
         }

         return null;
      } else {
         ResultBinding res = (ResultBinding)iter.next();
         Literal x = (Literal)res.get("x");
         return x;
      }
   }

   static String sm(RDFNode aResource, RDFNode aProperty) {
      String a1 = "<" + aResource + ">";
      String a2 = "<" + aProperty + ">";
      String R = "SELECT ?x WHERE (" + a1 + ", " + a2 + ", ?x)";
      return R;
   }

   public String typeString() {
      try {
         return this._typeString();
      } catch (RDFException var2) {
         return null;
      }
   }

   public String getProp(String aString) {
      return null;
   }
}
