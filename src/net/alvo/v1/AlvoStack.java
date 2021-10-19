package net.alvo.v1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import net.alvo.util.FIFO;
import net.alvo.util.FIFOImpl;

public class AlvoStack implements IAlvoStack {
   private int height;
   public FIFO my = new FIFOImpl();

   public int height() {
      return this.height;
   }

   public AlvoObject pop() throws NoSuchElementException {
      AlvoObject R = (AlvoObject)this.my.xout();
      --this.height;
      return R;
   }

   public synchronized void push(AlvoObject o) {
      this.my.xin(o);
      ++this.height;
   }

   public AlvoObject top() throws NoSuchElementException {
      AlvoObject R = (AlvoObject)this.my.xout();
      this.my.xin(R);
      return R;
   }

   public Iterator iterator() {
      return ((FIFOImpl)this.my).l.iterator();
   }

   public String toString() {
      return String.format("<AlvoStack %s>", ((FIFOImpl)this.my).l);
   }
}
