package net.alvo.v1;

import java.util.Vector;
import net.alvo.v1.types.AList;

public class ListAlvoListener extends SimpleAlvoListener {
   AList myres = null;
   Vector v = new Vector();

   public void append(AlvoObject e) {
      this.v.add(e);
   }

   public AlvoObject res() {
      if (this.myres == null) {
         this.myres = new AList(this.v);
      }

      return this.myres;
   }

   public AlvoObject pop() {
      AlvoObject R = (AlvoObject)((AlvoObject)this.v.elementAt(this.v.size()));
      this.v.removeElementAt(this.v.size());
      return R;
   }

   public void push(AlvoObject anObject) {
      this.append(anObject);
   }
}
