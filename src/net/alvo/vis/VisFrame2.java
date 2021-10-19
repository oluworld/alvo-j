package net.alvo.vis;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;

public class VisFrame2 extends JFrame {
   private VisPanel2 vispanel;

   public VisFrame2() {
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      this.vispanel = new VisPanel2();
      this.getContentPane().add(this.vispanel);
      this.setSize(300, 300);
   }

   public static void main(String[] args) {
      VisFrame2 frame2 = new VisFrame2();
      frame2.setVisible(true);
      frame2.vispanel.setFileName(new File("/local/src/lang/alvo/test/fib.alvo"));
   }
}
