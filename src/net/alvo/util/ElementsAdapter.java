package net.alvo.util;

import java.util.Enumeration;
import java.util.Iterator;

public class ElementsAdapter implements Enumeration {
   Iterator it;

   public ElementsAdapter(Iterator ait) {
      this.it = ait;
   }

   public boolean hasMoreElements() {
      return this.it.hasNext();
   }

   public Object nextElement() {
      return this.it.next();
   }
}
