package net.alvo.v1;

import net.alvo.v1.types.AEval;
import net.alvo.v1.types.AInstructionable;
import net.alvo.v1.types.ASymbol;
import net.alvo.v1.util.CL;

import java.io.Reader;
import java.io.StringReader;

public class ExecutionContext {
	public boolean keeptrying;
	private CL cl;
	private boolean debugging;
	private AlvoRuntime rt;

	public static void evalError(AEvalableToken v, ExecutionContext ctx, CL aCl) {
		AlvoObject[] oa = new AlvoObject[]{(AlvoObject) v, new ASymbol(aCl.eval_failure)};
		ctx.inject("/ALVO:err_in_eval", oa);
	}

	public static void typeMismatch(AlvoObject anObject, String expected, ExecutionContext ctx) {
		AlvoObject[] oa = new AlvoObject[]{anObject, new ASymbol(expected), new ASymbol(anObject.typeString()), new ASymbol("type mismatch")};
		ctx.inject("/ALVO:err", oa);
	}

	public ExecutionContext(AlvoRuntime aRt) {
		this.rt = aRt;
	}

	public ExecutionContext(AlvoRuntime aRt, CL aCl) {
		this.rt = aRt;
		this.cl = aCl;
	}

	public CL cl() {
		return this.cl;
	}

	public void ctx_eval(AEvalableToken ev, AlvoListener aal) {
		if (this.cl == null || aal != this.cl.listener()) {
			this.cl = new CL(ev, aal, this.rt(), this);
		}

		this.rt().tryPossibles(ev, this);
	}

	/** @deprecated */
	public void eval(AEvalableToken aToken, AlvoListener aCur, IRuntimeSink aErrstk) {
		this.rt.eval(aToken, aCur, this, aErrstk);
	}

	public void impossible_evaluation(AEvalableToken aet) {
		String evalName = "evaluation of " + aet.getToken().getText();
		ImpossibleEvaluation exc = new ImpossibleEvaluation(aet);
		this.cl.err(exc, "ImpossibleEvaluation", evalName);
		this.rt.print_exe_stack();
	}

	public void inject(AToken anEval, AlvoObject[] anObjects, IRuntimeSink al) {
		for (int i = 0; i < anObjects.length; ++i) {
			AlvoObject alvoObject = anObjects[i];
			((AlvoListener) al).push(alvoObject);
		}

		AlvoRuntime rt2 = this.rt();
		AEval eval = new AEval(anEval);
		CL cl2 = new CL(eval, (AlvoListener) al, rt2, this);
		ExecutionContext executionContext = new ExecutionContext(rt2, cl2);
		rt2.tryPossibles(eval, executionContext);
	}

	public void inject(String anEvalName, AlvoObject[] anObjects) {
		this.inject(new AToken(anEvalName, -1, -1), anObjects, (IRuntimeSink) this.rt().al);
	}

	DebuggingInstructionSource debuggingInstructionSource = null;

	public InstructionSource InstructionSourceFor(AInstructionable anInstructionList) {
		InstructionSource R = new LazyInstructionSource(anInstructionList);
		if (this.debugging) {
			if (debuggingInstructionSource == null) {
				debuggingInstructionSource = new DebuggingInstructionSource(R);
				return debuggingInstructionSource;
			} else {
				final DerivedDebuggingSource derivedDebuggingSource = new DerivedDebuggingSource(debuggingInstructionSource, R);
				return derivedDebuggingSource;
			}
		}
		return R;
	}

	public void load_resource(String uri, Reader aCharStream) throws Exception {
		ParsedResource.start(uri, aCharStream, this);
	}

	public void load_resource(String uri, String aString) throws Exception {
		Reader s3 = new StringReader(aString);
		ParsedResource p = new ParsedResource(aString, s3, this);
		ParsedResource.start(uri, s3, (ParsedResource) p);
	}

	public void load_resource(String uri, StringReader aReader) throws Exception {
		ParsedResource.start(uri, aReader, (ExecutionContext) this);
	}

	public AlvoRuntime rt() {
		return this.rt;
	}

	public void setDebugging() {
		this.debugging = true;
	}
}
