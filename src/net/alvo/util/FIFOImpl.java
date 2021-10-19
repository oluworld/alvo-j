package net.alvo.util;

import java.util.Vector;

public class FIFOImpl implements FIFO {
   public Vector l = new Vector();

   public boolean isEmpty() {
      return this.l.size() == 0;
   }

   public Object xout() {
      Object o = this.l.lastElement();
      this.l.removeElementAt(this.l.size() - 1);
      return o;
   }

   public void xin(Object t) {
      this.l.addElement(t);
   }
}
