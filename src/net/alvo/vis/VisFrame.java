package net.alvo.vis;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import net.alvo.v1.AlvoRuntime;

public class VisFrame extends JFrame {
   public VisFrame() {
      AlvoRuntime rt = new AlvoRuntime();
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      this.getContentPane().add(new VisPanel(rt));
      this.setSize(300, 300);
   }

   public static void main(String[] args) {
      (new VisFrame()).show();
   }
}
