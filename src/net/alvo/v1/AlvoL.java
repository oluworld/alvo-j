package net.alvo.v1;

import net.alvo.util.UT;
import net.alvo.v1.types.*;
import net.alvo.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlvoL implements AlvoListener, AInstructionable {
	AlvoL.IAlvoStack2 top = new AlvoL.AlvoStack2();
	Stack ss = new Stack();
	AlvoL.IAlvoStack2 root;

	public AlvoL() {
		this.root = this.top;
	}

	public void eval(AEvalableToken aToken, ExecutionContext ctx) {
		Assert.not_implemented();
	}

	public void num_int(AToken at) {
		String e = at.getText();

		try {
			int i = Integer.parseInt(e);
			this.top.push(new AInt(i));
		} catch (NumberFormatException var4) {
			UT.not_reached();
		}

	}

	public void num_float(AToken at) {
		String e = at.getText();

		try {
			double d = Double.parseDouble(e);
			this.top.push(new AFloat(d));
		} catch (NumberFormatException var5) {
			UT.not_reached();
		}

	}

	public void string_lit(AToken at) {
		this.top.push(new AString(at));
	}

	public void ident(AToken at) {
		this.top.push(new AIdent(at));
	}

	public AlvoObject pop() {
		Assert.not_implemented();
		return null;
	}

	public void push(AlvoObject anObject) {
		Assert.not_implemented();
	}

	public void lazy_start(AToken aAToken) {
		this.ss.push(this.top);
		this.top = new AlvoL.AlvoStack2();
		this.top.push(aAToken);
	}

	public List instructionPart() {
		return this.result();
	}

	public void lazy_end(AToken aAToken) {
		AlvoL.IAlvoStack2 tmp = this.top;
		this.top.push(aAToken);
		this.top = (AlvoL.IAlvoStack2) ((AlvoL.IAlvoStack2) this.ss.pop());
		this.top.push(new Lazy(tmp.inside(), tmp.first(), tmp.last()));
	}

	public void list_start(AToken aAToken) {
		this.ss.push(this.top);
		this.top = new AlvoL.AlvoStack2();
		this.top.push(aAToken);
	}

	public void list_end(AToken aAToken) {
		AlvoL.IAlvoStack2 tmp = this.top;
		this.top.push(aAToken);
		this.top = (AlvoL.IAlvoStack2) ((AlvoL.IAlvoStack2) this.ss.pop());
		this.top.push(tmp);
	}

	public void eval(AToken aAToken) {
		this.top.push(new AEval(aAToken));
	}

	public List result() {
		return (List) this.top;
	}

	private interface IAlvoStack2 {
		Object push(Object var1);

		List inside();

		AToken first();

		AToken last();
	}

	private class AlvoStack2 extends Stack implements AlvoL.IAlvoStack2 {
		AlvoStack2() {
		}

		public List _subList(int fromIndex, int toIndex) {
			Object L = null;

			try {
				Assert.precondition("proper input", this.size() >= 2);
				if (this.size() == 2) {
					L = new ArrayList();
				} else {
					int toIndex2 = Math.max(fromIndex, toIndex);
					L = this.subList(fromIndex, toIndex2);
				}
			} finally {
				Assert.postcondition("proper size", this.size() == ((List) L).size() + 2);
			}

			return (List) L;
		}

		public List inside() {
			return this._subList(1, this.size() - 1);
		}

		public AToken first() {
			return (AToken) ((AToken) this.get(0));
		}

		public AToken last() {
			return (AToken) ((AToken) this.get(this.size() - 1));
		}
	}
}
