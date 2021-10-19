package net.alvo.util;

public class Assert {
   public static void runtime(String s, boolean b) {
      check(s, b);
   }

   public static void precondition(String s, boolean f) {
      check(s, f);
   }

   public static void postcondition(String s, boolean f) {
      check(s, f);
   }

   public static void check(String s, boolean f) {
      if (!f) {
         System.err.println("assertion failed --> " + s);
      }

   }

   public static void not_reached() {
      System.err.println("not_reached");
      log_position();
   }

   public static void not_implemented() {
      System.err.println("not_implemented");
      log_position();
   }

   public static void log_position() {
      (new Assert.PositionLogger()).printStackTrace(System.err);
   }

   static class PositionLogger extends Exception {
   }
}
