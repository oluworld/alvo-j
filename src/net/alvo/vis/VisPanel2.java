package net.alvo.vis;

import net.alvo.v1.AlvoObject;
import net.alvo.v1.AlvoRuntime;
import net.alvo.v1.ExecutionContext;
import net.alvo.util.Assert;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class VisPanel2 extends JPanel {
	private JTextArea text;
	private JTextField field;
	private JButton go_button;
	private AlvoRuntime rt = new AlvoRuntime();
	private ExecutionContext ctx;
	public VisPanel2.LM stack = new VisPanel2.LM();
	private JButton next_button;
	private JButton step_button;
	private JButton open_button;

	public void ChangeText(InputStream T, String fn, File f) {
		this.ChangeText((Reader) (new InputStreamReader(T)), fn, f);
	}

	public void ChangeText(Reader aReader, String fn, File f) {
		try {
			this.field.setText(fn);
			String tt = this.do_changeText_001(aReader, f);
			this.do_changeText_002(fn, tt);
		} catch (Exception var5) {
			this.ChangeText("can open " + var5.getMessage(), f.getAbsolutePath());
		}

	}

	private void do_changeText_002(String fn, String tt) throws Exception {
		this.ctx.load_resource(fn, new StringReader(tt));
		String s2 = "{ /main } main /ifdef";
		StringReader reader = new StringReader("{ /main } main /ifdef");
		this.ctx.load_resource("<inline>", reader);
	}

	private String do_changeText_001(Reader aReader, File f) throws IOException {
		long expected = f.length();
		char[] bb = new char[(int) expected];
		int actual = aReader.read(bb);
		Assert.check("actual", expected == (long) actual);
		String tt = new String(bb);
		this.text.setText(tt);
		return tt;
	}

	public VisPanel2() {
		this.ctx = new ExecutionContext(this.rt);
		this.initComponents();
	}

	private void initComponents() {
		this.setLayout(new BoxLayout(this, 1));
		JPanel j = new JPanel();
		JPanel j2 = new JPanel();
		this.go_button = new JButton();
		this.next_button = new JButton();
		this.step_button = new JButton();
		this.open_button = new JButton();
		this.field = new JTextField();
		this.text = new JTextArea();
		JList l = new JList(this.stack);
		JComponent bb = new JSplitPane(1, new JScrollPane(this.text), new JScrollPane(l));
		j2.setLayout(new BoxLayout(j2, 0));
		j2.add(this.field);
		j2.add(this.go_button);
		j.setLayout(new BoxLayout(j, 0));
		this.go_button.setText("go");
		this.go_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				VisPanel2.this.go_buttonActionPerformed(evt);
			}
		});
		this.next_button.setText("next");
		this.next_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				VisPanel2.this.next_buttonActionPerformed(evt);
			}
		});
		this.step_button.setText("step");
		this.step_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				VisPanel2.this.step_buttonActionPerformed(evt);
			}
		});
		this.open_button.setText("open");
		this.open_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				VisPanel2.this.open_buttonActionPerformed(evt);
			}
		});
		j.add(this.next_button);
		j.add(this.step_button);
		j.add(this.open_button);
		this.add(j2);
		this.add(bb);
		this.add(j);
	}

	private void next_buttonActionPerformed(ActionEvent evt) {
	}

	private void go_buttonActionPerformed(ActionEvent evt) {
		this.setFileName(new File(this.field.getText()));
	}

	private void open_buttonActionPerformed(ActionEvent evt) {
		JFileChooser chooser = new JFileChooser();
		int i = chooser.showOpenDialog(this);
		if (i == 0) {
			File f = chooser.getSelectedFile();
			this.setFileName(f);
		}

	}

	void setFileName(File f) {
		try {
			this.ChangeText((InputStream) (new FileInputStream(f)), f.getAbsolutePath(), f);
		} catch (IOException var3) {
			this.ChangeText("cant open " + var3.getMessage(), f.getAbsolutePath());
		}

	}

	public void ChangeText(String T, String fn) {
		this.text.setText(T);
		this.field.setText(fn);
	}

	private void step_buttonActionPerformed(ActionEvent evt) {
	}

	private void newButtonActionPerformed(ActionEvent evt) {
	}

	private void jTextField1ActionPerformed(ActionEvent evt) {
	}

	private void expertNewButtonActionPerformed(ActionEvent evt) {
		String a1 = "not implemented";
		JOptionPane.showMessageDialog((Component) null, "not implemented", "not implemented", 0);
	}

	class LM extends AbstractListModel {
		Vector v = new Vector();

		public int getSize() {
			return this.v.size();
		}

		public Object getElementAt(int aIndex) {
			return this.v.get(aIndex);
		}

		public void push(AlvoObject aA) {
			this.v.add(aA);
			this.fireIntervalAdded(this, this.v.size(), this.v.size());
		}

		public void pop() {
			this.v.removeElementAt(this.v.size() - 1);
			this.fireIntervalRemoved(this, this.v.size() - 1, this.v.size());
		}
	}

	private class ErrViewTableModel implements TableModel {
		private Vector ll = new Vector();

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
