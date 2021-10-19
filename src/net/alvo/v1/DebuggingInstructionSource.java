package net.alvo.v1;

public class DebuggingInstructionSource implements InstructionSource {
   public DebuggingPermission permission = new DebuggingPermission();
   private InstructionSource src;

   public DebuggingInstructionSource(InstructionSource aSrc) {
      this.src = aSrc;
   }

   public IAlvoRV next() {
      try {
         synchronized(this.permission) {
            this.permission.wait();
         }
      } catch (InterruptedException var3) {
      }

      final IAlvoRV next = this.src.next();
      return next;
   }
}
