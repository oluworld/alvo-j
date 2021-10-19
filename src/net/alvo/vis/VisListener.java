package net.alvo.vis;

import net.alvo.util.FIFOImpl;

import java.util.Vector;
import javax.swing.AbstractListModel;
import net.alvo.v1.AEvalableToken;
import net.alvo.v1.AlvoListener;
import net.alvo.v1.AlvoObject;
import net.alvo.v1.AlvoStack;
import net.alvo.v1.DefaultAlvoListener;
import net.alvo.v1.ExecutionContext;
import net.alvo.v1.IAlvoRV;
import net.alvo.v1.IRuntimeSink;
import net.alvo.v1.kkk_racist;
import net.alvo.util.FIFOImpl;

final class VisListener extends kkk_racist implements AlvoListener, IRuntimeSink {
	private final DefaultAlvoListener dal = new DefaultAlvoListener();
	private final VisListener.C_a1 mModel = new VisListener.C_a1();

	public void push(AlvoObject X) {
		this.dal.push(X);
		this.model()._push();
	}

	public void eval(AEvalableToken T, ExecutionContext C) {
		this.dal.eval(T, C);
	}

	public AlvoObject pop() {
		AlvoObject X = this.dal.pop();
		this.model()._pop();
		return X;
	}

	public VisListener.C_a1 model() {
		return this.mModel;
	}

	public void push(IAlvoRV aObject) {
		this.push((AlvoObject) aObject);
	}

	private final class C_a1 extends AbstractListModel {
		private final Vector vector;

		C_a1() {
			this.vector = ((FIFOImpl) ((AlvoStack) VisListener.this.dal.s()).my).l;
		}

		public int getSize() {
			return VisListener.this.dal.s().height();
		}

		public Object getElementAt(int aIndex) {
			Object R = this.vector.get(aIndex);
			return R;
		}

		public void _push() {
			int F = Math.max(0, this.getSize() - 1);
			this.fireIntervalAdded(this, F, this.getSize());
		}

		public void _pop() {
			if (this.getSize() > 0) {
				this.fireIntervalRemoved(this, this.getSize() - 1, this.getSize());
			}

		}
	}
}
