package net.alvo.util;

public class Triplet {
   public Object o1;
   public Object o2;
   public Object o3;

   public static Triplet make(Object a1, Object a2, Object a3) {
      Triplet his = new Triplet();
      his.o1 = a1;
      his.o2 = a2;
      his.o3 = a3;
      return his;
   }
}
