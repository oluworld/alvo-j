package net.alvo.v1;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import net.alvo.util.UT;

public class Main {
   public static final String DefaultExtension = ".alvo";

   public static void main(String[] args) {
      if (args.length < 1) {
         UT.errW.println("Usage: alvoi <directory or file name>");
      } else {
         for(int i = 0; i < args.length; ++i) {
            try {
               doFile(args[i], true);
            } catch (Exception var3) {
               UT.errW.println("exception: " + var3);
               var3.printStackTrace(UT.errW);
            }
         }

      }
   }

   public static void doFile(String fn, boolean recursive) throws Exception {
      File f = new File(fn);
      if (f.isDirectory() && recursive) {
         String[] files = f.list();

         for(int i = 0; i < files.length; ++i) {
            doFile(f + "/" + files[i], false);
         }
      } else if (f.getName().length() > ".alvo".length() && f.getName().endsWith(".alvo")) {
         System.out.println("[-0-] " + f.getAbsolutePath());
         parseFile(f, new FileReader(f));
      }

   }

   public static void parseFile(File f, Reader s) throws Exception {
      AlvoRuntime rt = new AlvoRuntime();
      String fileName = f.getName();
      rt.add_path(f.getParent());
      ExecutionContext ctx = new ExecutionContext(rt);
      ParsedResource pr = new ParsedResource(fileName, s, ctx);
      pr.go_ahead(ctx);
      String s2 = "{ /main } main /ifdef";
      InstructionSource source = (new StringResource("{ /main } main /ifdef")).getResult(ctx);
      (new LazyRunner(source, rt, ctx)).runit();
   }
}
