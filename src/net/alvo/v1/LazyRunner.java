package net.alvo.v1;

import net.alvo.v1.types.AList;

public class LazyRunner {
	private final InstructionSource src;
	private final IRuntimeSink rs;
	private final AlvoRuntime rt;
	private final ExecutionContext ctx;

	public LazyRunner(InstructionSource aSrc, IRuntimeSink aRs, ExecutionContext aExecutionContext) {
		this.src = aSrc;
		this.rs = aRs;
		this.ctx = aExecutionContext;
		this.rt = this.ctx.rt();
	}

	public void runit() {
		IAlvoRV ao;
		while ((ao = this.src.next()) != null) {
			if (ao instanceof AEvalableToken) {
				this.doEval((AEvalableToken) ao);
			} else if (ao instanceof AList) {
				this.doVectored((AList) ao);
			} else {
				this.doOther(ao);
			}
		}

	}

	private void doEval(AEvalableToken eval) {
		this.rs.eval(eval, this.ctx);
	}

	private void doOther(IAlvoRV ao) {
		this.rs.push(ao);
	}

	private void doVectored(AList ao) {
		ExecutionContext executionContext = this.ctx;
		InstructionSource lis = executionContext.InstructionSourceFor(ao);
		LazyRunner lr = new LazyRunner(lis, this.rs, executionContext);
		lr.runit();
	}
}
