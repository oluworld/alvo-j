package net.alvo.v1;

import net.alvo.util.UT;
import net.alvo.v1.compiler.AlvoLexer;
import net.alvo.v1.compiler.AlvoParser;
import net.alvo.v1.types.ABool;
import net.alvo.v1.types.AEval;
import net.alvo.v1.types.AHash;
import net.alvo.v1.types.AIdent;
import net.alvo.v1.types.AInstructionable;
import net.alvo.v1.types.AInt;
import net.alvo.v1.types.AList;
import net.alvo.v1.types.Lazy;
import net.alvo.v1.util.Eval2Wrapper;
import net.alvo.util.Assert;
import net.alvo.util.FIFOImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class AlvoRuntime implements IAlvoPossibleTarget, IRuntimeSink {
	public AlvoListener al;
	private Map dict;
	ExecutionContext dummy;
	public final IAlvoStack frames;
	protected final Map functions;
	private Object parentObject;
	AlvoParser parser;
	private Vector paths;
	protected final List<IAlvoPossible> possibles;

	public static AlvoObject typeCheck(ExecutionContext ctx, String aTypeName, AlvoObject aObject) {
		AlvoObject R = null;
		if (aObject.typeString().equals(aTypeName)) {
			R = aObject;
		} else {
			ExecutionContext.typeMismatch(R, aTypeName, ctx);
			ctx.cl().err("type mismatch");
		}

		return R;
	}

	public AlvoRuntime() {
		this.paths = new Vector();
		this.functions = new Hashtable();
		this.frames = new AlvoStack();
		this.possibles = new Vector();
		this.possibles.add(new PossibleWrapper(this));
		this.possibles.add(new Eval2Wrapper(this));
	}

	public AlvoRuntime(Object a1) {
		this();
		this.parentObject = a1;
		this.possibles.add(new jj(this, this.parentObject));
	}

	public void add_path(String aParent) {
		this.paths.add(0, aParent);
	}

	public void define_method(String name, Lazy def) {
		Assert.precondition("not_already_defined", !this.has_method(name));
		this.functions.put(name, def);
	}

	public void enter_frame(String s, int row, int col) {
		this.frames.push(this.stupid(s, row, col));
	}

	public void eval(AEvalableToken aet, AlvoListener aal, ExecutionContext ctx, IRuntimeSink rs) {
		ctx.ctx_eval(aet, aal);
	}

	public void eval(AEvalableToken aet, ExecutionContext ctx) {
		if (this != ctx.rt()) {
			ctx.rt().eval(aet, ctx);
		} else {
			this.al.eval(aet, ctx);
		}

	}

	public void eval_def(AEval aEval, AlvoRuntime rt, ExecutionContext ctx) {
		String name = ((AIdent) this.pop()).my();
		Lazy def = (Lazy) this.pop();
		if (!rt.has_method(name)) {
			rt.define_method(name, def);
		} else {
			ctx.cl().bad_err("wont redefine " + name);
		}

	}

	public void eval_if_(AEval aEval, AlvoRuntime rt, ExecutionContext ctx) {
		AlvoObject goodaction = this.pop();
		AlvoObject condition = this.pop();
		this.xif(condition, goodaction, new Lazy(new Vector(), (AToken) null, (AToken) null), ctx);
	}

	public void eval_ifelse(AEval aEval, AlvoRuntime rt, ExecutionContext ctx) {
		AlvoObject badaction = this.pop();
		AlvoObject goodaction = this.pop();
		AlvoObject condition = this.pop();
		this.xif(condition, goodaction, badaction, ctx);
	}

	public void eval_open(AEval aEval, AlvoRuntime rt, ExecutionContext ctx) {
		AIdent openee = (AIdent) this.pop();
		String s = openee.my();
		FileReader resource = this.find_resource(s);
		if (resource != null) {
			AInstructionable res1 = null;

			try {
				res1 = ParsedResource.start(s, resource, (ExecutionContext) ctx);
				InstructionSource source = new LazyInstructionSource(res1);
				(new LazyRunner(source, rt, ctx)).runit();
				return;
			} catch (Exception var9) {
				var9.printStackTrace();
			}
		}

		Assert.not_implemented();
	}

	public void eval_println(AEval aEval, AlvoRuntime aRuntime, ExecutionContext ctx) {
		AlvoObject k = this.pop();
		k.printlnM(UT.outW);
	}

	public void eval_using(AEval aEval, AlvoRuntime rt, ExecutionContext ctx) {
		UT.errWp("NOP: using " + this.pop());
	}

	public void eval_writeint(AEval aEval, AlvoRuntime aRuntime, ExecutionContext ctx) {
		AlvoObject k = this.pop();
		System.out.print(((AInt) k).my());
	}

	public void eval_writestr(AEval aEval, AlvoRuntime aRuntime, ExecutionContext ctx) {
		AlvoObject k = this.pop();
		System.out.print(k.toString());
	}

	public void exit_frame() {
		this.frames.pop();
	}

	void fallthru() {
	}

	private FileReader find_resource(String aFilename) {
		FileReader R = null;
		Iterator it = this.paths.iterator();

		while (it.hasNext()) {
			String m = (String) ((String) it.next());

			try {
				return new FileReader(m + "/" + aFilename + ".alvo");
			} catch (FileNotFoundException var6) {
			}
		}

		return (FileReader) R;
	}

	public AlvoObject fload(String ss) {
		Iterator it = this.TI();

		while (it.hasNext()) {
			Hashtable frame = ((AHash) ((AHash) it.next())).h;
			if (frame.get(ss) != null) {
				return (AlvoObject) ((AlvoObject) frame.get(ss));
			}
		}

		return null;
	}

	public Object frame(int aIndex) {
		AlvoStack F = (AlvoStack) this.frames;
		FIFOImpl FI = (FIFOImpl) F.my;
		return FI.l.get(aIndex);
	}

	public void fstore0(AlvoObject name, AlvoObject def) {
		this.T().put(name, def);
	}

	public AlvoObject get(String aa) {
		UT.errWp("256: rt-get " + aa);
		return null;
	}

	public Lazy getFunction(String g, ExecutionContext ctx) {
		AlvoObject propspective = (AlvoObject) ((AlvoObject) this.functions.get(g));
		Lazy kk = null;
		if (propspective != null) {
			kk = (Lazy) typeCheck(ctx, "ALVO:Lazy", propspective);
		}

		return kk;
	}

	public boolean has_method(String name) {
		boolean b = this.functions.containsKey(name);
		return b;
	}

	AlvoParser parserForResource(Reader aReader, String aFilename, AlvoListener aListener) {
		AlvoLexer lexer = new AlvoLexer(aReader);
		lexer.setFilename(aFilename);
		this.al = aListener;
		AlvoParser R = new AlvoParser(lexer);
		R.setFilename(aFilename);
		R.rt = this;
		return R;
	}

	public AlvoObject pop() {
		return this.al.pop();
	}

	public void print_exe_stack() {
		Iterator ii = ((AlvoStack) this.frames).iterator();
		System.out.println("+frames:");

		while (ii.hasNext()) {
			AList f = (AList) ((AList) ii.next());
			System.out.println("--: " + f.my());
		}

		System.out.println("+done");
	}

	public void push(IAlvoRV aObject) {
		UT.errWp("NOP: push " + aObject);
		this.al.push((AlvoObject) aObject);
	}

	public void set(String obnam, Object object) {
		this.dict.put(obnam, object);
	}

	private AlvoObject stupid(String aS, int aRow, int aCol) {
		Vector v = new Vector();
		v.add(aS);
		v.add(new Integer(aRow));
		v.add(new Integer(aCol));
		return new AList(v);
	}

	Hashtable T() {
		return ((AHash) this.frames.top()).h;
	}

	Iterator TI() {
		return ((AlvoStack) this.frames).iterator();
	}

	void tryPossibles(AEvalableToken aet, ExecutionContext ctx) {
		Assert.precondition("same runtime", ctx.rt() == this);
		Iterator<IAlvoPossible> i = this.possibles.iterator();

		while (i.hasNext()) {
			IAlvoPossible h = i.next();
			h.eval(aet, ctx);
			if (!ctx.keeptrying) {
				return;
			}
		}

		ctx.impossible_evaluation(aet);
		this.exit_frame();
	}

	private void xif(AlvoObject condition, AlvoObject goodaction, AlvoObject badaction, ExecutionContext aCtx) {
		final Vector actions = new Vector();
		AInstructionable inst = new AInstructionable() {
			public List instructionPart() {
				return actions;
			}
		};
		if (condition == ABool.TRUE) {
			actions.add(goodaction);
		} else {
			actions.add(badaction);
		}

		(new LazyRunner(new LazyInstructionSource(inst), this, aCtx)).runit();
	}
}
