package net.alvo.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MonitoredInputStream extends FilterInputStream {
   public int read() throws IOException {
      int r$ = super.read();
      return r$;
   }

   public MonitoredInputStream(InputStream in) {
      super(in);
   }

   public int read(byte[] b, int off, int len) throws IOException {
      return super.read(b, off, len);
   }
}
