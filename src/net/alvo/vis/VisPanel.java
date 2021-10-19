package net.alvo.vis;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import net.alvo.v1.AlvoListener;
import net.alvo.v1.AlvoRuntime;
import net.alvo.v1.DebuggingInstructionSource;
import net.alvo.v1.ExecutionContext;
import net.alvo.v1.InstructionSource;
import net.alvo.v1.LazyRunner;
import net.alvo.v1.ParsedResource;

public class VisPanel extends JPanel {
   private AlvoRuntime rt;
   private JButton step;
   private JButton step_next;
   private JButton step_out;
   private JButton start_button;
   private JTextField open;
   private JPanel jPanel7;
   private JPopupMenu jPopupMenu1;
   private JMenuItem jMenuItem1;
   private JToolBar jToolBar1;
   private JButton heapViewButton;
   private JButton expertNewButton;
   private JTree stackTree;
   private JTextField jTextField1;
   private JButton typeButton;
   private JButton newButton;
   private JTable errView;
   private JSplitPane pane;
   private static DebuggingInstructionSource ais;
   static AlvoListener vl = new VisListener();

   public VisPanel(AlvoRuntime aRt) {
      this.rt = aRt;
      this.initComponents();
   }

   private void initComponents() {
      this.jPopupMenu1 = new JPopupMenu();
      this.jMenuItem1 = new JMenuItem();
      this.jToolBar1 = new JToolBar();
      this.heapViewButton = new JButton();
      this.expertNewButton = new JButton();
      this.stackTree = new JTree(new TreeModel() {
         public Object getRoot() {
            return VisPanel.this.rt;
         }

         public AlvoRuntime rr() {
            return VisPanel.this.rt;
         }

         public Object getChild(Object parent, int index) {
            return parent == this.rr() ? new Integer(index) : null;
         }

         public int getChildCount(Object parent) {
            return parent == this.rr() ? this.rr().frames.height() : 0;
         }

         public boolean isLeaf(Object node) {
            return node != this.rr();
         }

         public void valueForPathChanged(TreePath path, Object newValue) {
         }

         public int getIndexOfChild(Object parent, Object child) {
            return 0;
         }

         public void addTreeModelListener(TreeModelListener l) {
         }

         public void removeTreeModelListener(TreeModelListener l) {
         }
      });
      this.jTextField1 = new JTextField();
      this.typeButton = new JButton();
      this.newButton = new JButton();
      this.errView = new JTable();
      this.pane = new JSplitPane();
      this.step = new JButton("step");
      this.step.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            VisPanel.this.step_ActionPerformed(evt);
         }
      });
      this.step_next = new JButton("step next");
      this.step_out = new JButton("step out");
      new JButton("continue");
      this.start_button = new JButton("start");
      this.start_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            VisPanel.this.go_ActionPerformed(evt);
         }
      });
      this.open = new JTextField();
      this.jPanel7 = new JPanel();
      this.jPanel7.setLayout(new BoxLayout(this.jPanel7, 0));
      this.jPanel7.add(this.step);
      this.jPanel7.add(this.step_next);
      this.jPanel7.add(this.step_out);
      this.jPanel7.add(this.start_button);
      this.jPanel7.add(this.open);
      this.add(this.jPanel7);
      this.jMenuItem1.setText("Item");
      this.jPopupMenu1.add(this.jMenuItem1);
      this.setLayout(new BoxLayout(this, 1));
      Box l1 = Box.createHorizontalBox();
      l1.add(new JScrollPane(this.stackTree));
      JList jl1 = new JList(((VisListener)vl).model());
      l1.add(new JScrollPane(jl1));
      this.add(l1);
   }

   private void _u3() {
      this.errView.setModel(new VisPanel.ErrViewTableModel());
      JTableHeader th = this.errView.getTableHeader();
      th.show();
      this.add(this.errView);
      this.pane.setOneTouchExpandable(true);
      this.add(this.pane);
   }

   protected void step_ActionPerformed(ActionEvent event) {
      if (ais != null)
         ais.permission.step();
   }

   private void go_ActionPerformed(ActionEvent event) {
      Thread t = new Thread() {
         public void run() {
            try {
               VisPanel.go(VisPanel.this.rt);
            } catch (Exception var2) {
               var2.printStackTrace();
            }

         }
      };
      t.start();
   }

   private void _u2() {
      JPanel jPanel1 = new JPanel();
      jPanel1.setLayout(new BoxLayout(jPanel1, 0));
      this.jTextField1.setText("jTextField1");
      this.jTextField1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            VisPanel.this.jTextField1ActionPerformed(evt);
         }
      });
      jPanel1.add(this.jTextField1);
      this.typeButton.setText("Type");
      jPanel1.add(this.typeButton);
      this.newButton.setText("New");
      this.newButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            VisPanel.this.newButtonActionPerformed(evt);
         }
      });
      jPanel1.add(this.newButton);
      this.add(jPanel1);
   }

   private void _u1() {
      this.heapViewButton.setText("Heap");
      this.heapViewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            VisPanel.this.heapViewButtonActionPerformed(evt);
         }
      });
      this.jToolBar1.add(this.heapViewButton);
      this.expertNewButton.setText("Expert New...");
      this.expertNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            VisPanel.this.expertNewButtonActionPerformed(evt);
         }
      });
      this.jToolBar1.add(this.expertNewButton);
   }

   private void jTextField1ActionPerformed(ActionEvent evt) {
   }

   private void expertNewButtonActionPerformed(ActionEvent evt) {
      String a1 = "not implemented";
      JOptionPane.showMessageDialog((Component)null, "not implemented", "not implemented", 0);
   }

   private void heapViewButtonActionPerformed(ActionEvent evt) {
   }

   private void newButtonActionPerformed(ActionEvent evt) {
   }

   protected static TreeModel getDefaultTreeModel() {
      DefaultMutableTreeNode root = new DefaultMutableTreeNode("JTree");
      DefaultMutableTreeNode parent = new DefaultMutableTreeNode("colors");
      root.add(parent);
      parent.add(new DefaultMutableTreeNode("blue"));
      parent.add(new DefaultMutableTreeNode("violet"));
      parent.add(new DefaultMutableTreeNode("red"));
      parent.add(new DefaultMutableTreeNode("yellow"));
      parent = new DefaultMutableTreeNode("sports");
      root.add(parent);
      m1(parent, "basketball");
      m1(parent, "soccer");
      m1(parent, "football");
      m1(parent, "hockey");
      parent = new DefaultMutableTreeNode("food");
      root.add(parent);
      m1(parent, "hot dogs");
      m1(parent, "pizza");
      m1(parent, "ravioli");
      m1(parent, "bananas");
      return new DefaultTreeModel(root);
   }

   private static void m1(DefaultMutableTreeNode aParent, String aUserObject) {
      aParent.add(new DefaultMutableTreeNode(aUserObject));
   }

   static void go(AlvoRuntime aRt) throws Exception {
      ExecutionContext ctx = new ExecutionContext(aRt);
      ctx.setDebugging();
      String f = "fact.alvo";
      FileReader fr = new FileReader(f);
      ParsedResource pr = new ParsedResource(f, fr, ctx, vl);
      InstructionSource result = pr.getResult(ctx);
      ais = (DebuggingInstructionSource)result;
      LazyRunner lazyRunner = new LazyRunner(result, aRt, ctx);
      lazyRunner.runit();
   }

   private class ErrViewTableModel implements TableModel {
      private Vector ll = new Vector();
      // $FF: synthetic field
      static Class class$0;

      ErrViewTableModel() {
      }

      public int getRowCount() {
         return 4;
      }

      public int getColumnCount() {
         return 4;
      }

      public String getColumnName(int columnIndex) {
         return "Title " + columnIndex;
      }

      public Class getColumnClass(int columnIndex) {
         return Object.class;
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
         return false;
      }

      public Object getValueAt(int rowIndex, int columnIndex) {
         return "<!>";
      }

      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      }

      public void addTableModelListener(TableModelListener l) {
         this.ll.add(l);
      }

      public void removeTableModelListener(TableModelListener l) {
         this.ll.remove(l);
      }
   }
}
