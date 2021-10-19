package net.alvo.v1;

import net.alvo.util.UT;
import net.alvo.v1.compiler.AlvoParser;
import net.alvo.v1.types.AInstructionable;

import java.io.Reader;

public class ParsedResource implements Resource {
	private String f;
	private Reader s;
	private AlvoRuntime rt;
	private AInstructionable res1;
	private AlvoListener mListener;

	public Reader getText() {
		return this.s;
	}

	public String getLocation() {
		return this.f;
	}

	AlvoParser parserForResource(Reader aReader, String aFilename) {
		return this.rt.parserForResource(aReader, aFilename, this.mListener);
	}

   /** @deprecated */
	public static AInstructionable start(String aResourceName, Reader aCharStream, ExecutionContext ctx) throws AlvoException {
		ParsedResource p = new ParsedResource(aResourceName, aCharStream, ctx);
		return start(aResourceName, aCharStream, p);
	}

	public static AInstructionable start(String aResourceName, Reader aCharStream, ParsedResource a) throws AlvoException {
		try {
			AlvoRuntime rt = a.rt;
			rt.parser = a.parserForResource(a.s, a.f);
			AlvoL l = new AlvoL();
			rt.parser.program(l);
			return l;
		} catch (Exception var5) {
			UT.errW.println("[~01] parser exception: " + var5);
			var5.printStackTrace(UT.errW);
			return null;
		}
	}

	public InstructionSource getResult(ExecutionContext ctx) throws AlvoException {
		this.res1 = start(this.f, this.s, this);
		return ctx.InstructionSourceFor(this.res1);
	}

	public void go_ahead(ExecutionContext ctx) throws Exception {
		InstructionSource result = this.getResult(ctx);
		LazyRunner lazyRunner = new LazyRunner(result, this.rt, ctx);
		lazyRunner.runit();
	}

	public ParsedResource(String aF, Reader aS, ExecutionContext ctx) {
		this.f = aF;
		this.s = aS;
		this.rt = ctx.rt();
		this.mListener = new DefaultAlvoListener();
	}

	public ParsedResource(String aF, Reader aS, ExecutionContext ctx, AlvoListener aal) {
		this.f = aF;
		this.s = aS;
		this.rt = ctx.rt();
		this.mListener = aal;
	}
}
