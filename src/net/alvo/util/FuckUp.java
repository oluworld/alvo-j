package net.alvo.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class FuckUp extends RuntimeException {
   public Exception ae;
   public String payload;

   public FuckUp(Exception aE) {
      this.ae = aE;
   }

   public FuckUp(String aPayload) {
      this.payload = aPayload;
   }

   public String phuk() {
      String R = "";
      if (this.ae != null) {
         StringWriter sw = new StringWriter();
         PrintWriter sos = new PrintWriter(sw);
         this.ae.printStackTrace(sos);
         R = R + sw.toString() + "\n\n";
      }

      if (this.payload != null) {
         R = R + this.payload;
      }

      return R;
   }
}
