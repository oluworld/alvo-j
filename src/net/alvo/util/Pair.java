package net.alvo.util;

public class Pair {
   public Object first;
   public Object second;

   public String toString() {
      return "<Pair " + this.first + " " + this.second + ">";
   }

   public static Pair make(Object aFirst, Object aSecond) {
      Pair R = new Pair();
      R.first = aFirst;
      R.second = aSecond;
      return R;
   }
}
