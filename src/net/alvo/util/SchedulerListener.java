package net.alvo.util;

public interface SchedulerListener {
   void handlerError(Exception var1);

   void handleSuccess();

   public static class NullListener implements SchedulerListener {
      public void handlerError(Exception e) {
      }

      public void handleSuccess() {
      }
   }
}
