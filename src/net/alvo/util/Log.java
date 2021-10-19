package net.alvo.util;

public class Log {
   public static final int DEBUG = 0;
   public static final int ALL = 5;
   public static final int INFO = 10;
   public static final int WARN = 15;
   public static final int MSG = 20;
   public static final int ERROR = 25;
   public static final int FATAL = 30;

   public static int getErrorLevel(String errorlevel) {
      if (errorlevel.equals("DEBUG")) {
         return 0;
      } else if (errorlevel.equals("ALL")) {
         return 5;
      } else if (errorlevel.equals("INFO")) {
         return 10;
      } else if (errorlevel.equals("WARN")) {
         return 15;
      } else if (errorlevel.equals("MSG")) {
         return 20;
      } else if (errorlevel.equals("ERROR")) {
         return 25;
      } else {
         return errorlevel.equals("FATAL") ? 30 : 30;
      }
   }

   public static String LevelName(int errorlevel) {
      if (errorlevel <= 0) {
         return "DEBUG";
      } else if (errorlevel <= 5) {
         return "ALL";
      } else if (errorlevel <= 10) {
         return "INFO";
      } else if (errorlevel <= 15) {
         return "WARN";
      } else if (errorlevel <= 20) {
         return "MSG";
      } else if (errorlevel <= 25) {
         return "ERROR";
      } else {
         return errorlevel <= 30 ? "FATAL" : "UNKNOWN";
      }
   }
}
