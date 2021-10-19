package net.alvo.v1;

import java.io.PrintWriter;
import java.util.List;
import net.alvo.rdf.Model;

public interface AlvoObject {
   void printlnM(PrintWriter var1);

   boolean eq(AlvoObject var1, AlvoRuntime var2);

   AlvoObject plusM(AlvoObject var1);

   String typeString();

   List rdfContent(Model var1);
}
