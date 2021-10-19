package net.alvo.v1;

import net.alvo.util.Assert;

public class DefaultAlvoListener extends kkk_racist implements IRuntimeSink, AlvoListener {
	public void eval(AEvalableToken aet, ExecutionContext ctx) {
		IRuntimeSink errstk = null;
		ctx.rt().eval(aet, this, ctx, (IRuntimeSink) errstk);
	}

	public DefaultAlvoListener() {
		this.setStack(new AlvoStack());
	}

	public AlvoObject pop() {
		return this.s().pop();
	}

	public void push(AlvoObject a) {
		Assert.precondition("a != null", a != null);
		this.s().push(a);
	}

	public void push(IAlvoRV aObject) {
		this.push((AlvoObject) aObject);
	}
}
