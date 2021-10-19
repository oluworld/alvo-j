package net.alvo.v1.types;

import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import net.alvo.util.UT;
import net.alvo.v1.AlvoObject;
import net.alvo.v1.AlvoRuntime;
import net.alvo.v1.IAlvoRV;
import net.alvo.rdf.Model;
import net.alvo.util.Assert;

public class AList implements AlvoObject, IAlvoRV, AInstructionable {
   Vector myVector = null;

   public AList(Vector aVector) {
      this.myVector = aVector;
   }

   public boolean eq(AlvoObject aRightSide, AlvoRuntime rt) {
      UT.not_reached();
      return false;
   }

   public List instructionPart() {
      return this.my();
   }

   public Vector my() {
      return this.myVector;
   }

   public AlvoObject plusM(AlvoObject aRightSide) {
      UT.not_reached();
      return null;
   }

   public void printlnM(PrintWriter ps) {
      UT.not_reached();
   }

   public List rdfContent(Model aModel) {
      Assert.not_implemented();
      return null;
   }

   public String toString() {
      return "<ALVO:List " + this.my().toString() + ">";
   }

   public String typeString() {
      return "ALVO:List";
   }
}
