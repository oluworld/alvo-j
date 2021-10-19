package net.alvo.v1.types;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.alvo.util.UT;
import net.alvo.v1.AToken;
import net.alvo.v1.AlvoObject;
import net.alvo.v1.AlvoRuntime;
import net.alvo.v1.ExecutionContext;
import net.alvo.v1.IAlvoRV;
import net.alvo.rdf.Model;
import net.alvo.util.Assert;
import net.alvo.util.Pair;

public class Lazy implements AlvoObject, IAlvoRV, AInstructionable {
   private AToken st;
   private AToken et;
   List v = new ArrayList();

   public void printlnM(PrintWriter ps) {
      UT.not_reached();
   }

   public AlvoObject plusM(AlvoObject aRightSide) {
      UT.not_reached();
      return null;
   }

   private static boolean __eval(List aObjects, AlvoRuntime rt) {
      Assert.not_reached();
      Iterator ii = aObjects.iterator();

      while(ii.hasNext()) {
         AlvoObject alvoObject = (AlvoObject)((AlvoObject)ii.next());
         if (alvoObject instanceof AEval) {
            rt.al.eval((AEval)alvoObject, new ExecutionContext(rt));
         } else if (alvoObject instanceof AList) {
            boolean b = __eval(((AList)alvoObject).myVector, rt);
            if (!b) {
               return false;
            }
         } else if (alvoObject instanceof AIdent) {
            AlvoObject ao1 = rt.fload(((AIdent)alvoObject).my());
            if (ao1 == null) {
               return false;
            }

            rt.al.push(ao1);
         } else {
            rt.al.push(alvoObject);
         }
      }

      return true;
   }

   public Lazy(List aVector, AToken aStartToken, AToken aEndToken) {
      this.v = aVector;
      this.st = aStartToken;
      this.et = aEndToken;
   }

   public void append(AlvoObject e) {
      this.v.add(e);
   }

   public String toString() {
      return "<ALazy " + this.v.toString() + ">";
   }

   public List instructionPart() {
      return this.v;
   }

   public String typeString() {
      return "ALVO:Lazy";
   }

   public boolean eq(AlvoObject aRightSide, AlvoRuntime rt) {
      UT.not_reached();
      return false;
   }

   public List rdfContent(Model aModel) {
      List R = new ArrayList();
      R.add(Pair.make("#type", "LAZY"));
      R.add(Pair.make("#count", new Integer(this.v.size())));
      R.add(Pair.make("#start-token", this.st));
      R.add(Pair.make("#end-token", this.et));
      return R;
   }
}
