package net.alvo.util;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UT {
   public static PrintWriter errW;

   static {
      errW = new PrintWriter(new OutputStreamWriter(System.err));
   }

   public static String hexify(long id) {
      String R = "";
      String s1 = Long.toString(id, 16);
      R = repeatChar('0', 8 - s1.length()) + s1;
      return R;
   }

   public static String repeatChar(char c, int n) {
      String R;
      for(R = ""; n-- > 0; R = R + c) {
      }

      return R;
   }

   public static boolean string_in(String aVal, String aString, String aString2) {
      return aVal.equals(aString) || aVal.equals(aString2);
   }

   public static String string_times(int i) {
      StringBuffer R = new StringBuffer();

      while(i-- > 0) {
         R.append('*');
      }

      return R.toString();
   }

   public static synchronized void vvv(String aString) {
      System.out.println(aString);
   }
}
