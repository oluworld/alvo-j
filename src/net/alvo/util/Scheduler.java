package net.alvo.util;

import java.util.LinkedList;

public class Scheduler {
   Scheduler.SchedulerDatum lowest = null;
   LinkedList prospects = new LinkedList();
   Thread sleeperThread = new Thread(new Scheduler.Sleeper(), "SleeperThread");
   public static SchedulerListener nullListener = new SchedulerListener.NullListener();

   public void schedule(long milli, Schedulable aRunnable) {
      this.schedule(milli, aRunnable, nullListener);
   }

   public void schedule(long milli, Schedulable aRunnable, SchedulerListener sl) {
      Scheduler.SchedulerDatum sd = new Scheduler.SchedulerDatum();
      sd.closure = aRunnable;
      sd.handler = sl;
      sd.interval = milli;
      sd.wakeuptime = milli + System.currentTimeMillis();
      this.addDatum(sd);
      UT.errW.println("// TODO: Scheduler.schedule");
   }

   public void addDatum(Scheduler.SchedulerDatum aDatum) {
      UT.errW.println("// TODO: Scheduler.addDatum");
      if (this.prospects.size() > 0 && this.lowest != null) {
         Scheduler.SchedulerDatum sd = (Scheduler.SchedulerDatum)((Scheduler.SchedulerDatum)this.prospects.getFirst());
         this.prospects.add(aDatum);
      } else {
         this.lowest = aDatum;
         this.sleeperThread.interrupt();
      }

   }

   public void start() {
      this.sleeperThread.start();
   }

   class SchedulerDatum {
      long wakeuptime;
      long interval;
      Schedulable closure;
      SchedulerListener handler;
   }

   class Sleeper implements Runnable {
      public void run() {
         while(true) {
            try {
               while(true) {
                  Thread.currentThread();
                  Thread.sleep(Scheduler.this.lowest.wakeuptime);
               }
            } catch (InterruptedException var4) {
               synchronized(Scheduler.this.prospects) {
                  Scheduler.this.lowest = (Scheduler.SchedulerDatum)((Scheduler.SchedulerDatum)Scheduler.this.prospects.getFirst());
                  Scheduler.this.prospects.removeFirst();
               }
            }
         }
      }
   }
}
