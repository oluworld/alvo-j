package net.alvo.v1.util;

import net.alvo.util.UT;
import net.alvo.v1.*;
import net.alvo.v1.types.ABool;
import net.alvo.v1.types.AIdent;
import net.alvo.v1.types.AInt;
import net.alvo.v1.types.Lazy;
import net.alvo.util.Assert;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Eval2Wrapper implements IAlvoPossible {
	private final AlvoRuntime myRt;

	public Eval2Wrapper(AlvoRuntime aMyRt) {
		this.myRt = aMyRt;
	}

	private void _doEval2(AEvalableToken aet, ExecutionContext ctx) {
		CL aCl = ctx.cl();
		AToken aToken = aet.getToken();
		String evaluating = aToken.getText();
		String aa = evaluating;
		AlvoRuntime rt = this.myRt;
		UT.outWp("[105] in eval " + evaluating);
		String[] bb = evaluating.substring(1).split(":");
		if (bb.length > 1) {
			int i = 0;
			if (bb[0].equals("")) {
				AlvoObject var9 = rt.al.pop();
			} else {
				while (i < bb.length) {
					rt.get(bb[i++]);
				}
			}
		}

		try {
			String g = aet.getToken().getText().substring(1);
			AlvoObject k;
			AlvoObject l;
			if (aa.equals("/fstore0")) {
				k = rt.al.pop();
				l = rt.al.pop();
				rt.fstore0(k, l);
				ctx.keeptrying = false;
				return;
			}

			if (aa.equals("/eq")) {
				k = rt.al.pop();
				l = rt.al.pop();
				boolean b = l.eq(k, this.myRt);
				rt.al.push(b ? ABool.TRUE : ABool.FALSE);
				ctx.keeptrying = false;
				return;
			}

			if (aa.equals("/len")) {
				k = rt.al.pop();
				k.printlnM(UT.outW);
				ctx.keeptrying = false;
				return;
			}

			if (aa.equals("/cond")) {
				k = rt.al.pop();
			} else {
				if (aa.equals("/dup")) {
					k = rt.al.pop();
					rt.al.push(k);
					rt.al.push(k);
					ctx.keeptrying = false;
					return;
				}

				if (aa.equals("/sub")) {
					AInt kk = (AInt) rt.al.pop();
					AInt ll = (AInt) rt.al.pop();
					rt.al.push(new AInt(ll.my() - kk.my()));
					ctx.keeptrying = false;
					return;
				}

				Lazy F;
				if (this.myRt.has_method(g)) {
					F = rt.getFunction(g, ctx);
					if (F != null) {
						InstructionSource source = ctx.InstructionSourceFor(F);
						(new LazyRunner(source, rt, ctx)).runit();
						ctx.keeptrying = false;
						return;
					}
				} else {
					if (aa.equals("/ifdef")) {
						k = rt.al.pop();
						l = rt.al.pop();
						if (this.myRt.has_method(((AIdent) k).my())) {
							Lazy kk = (Lazy) AlvoRuntime.typeCheck(ctx, "ALVO:Lazy", l);
							if (kk != null) {
								InstructionSource source = ctx.InstructionSourceFor(kk);
								(new LazyRunner(source, rt, ctx)).runit();
							}
						} else {
							this.fallthru();
						}

						ctx.keeptrying = false;
						return;
					}

					if (aa.equals("/ALVO:err_in_eval")) {
						aCl.ALVO_err_in_eval();
						ctx.keeptrying = false;
						return;
					}

					if (aa.equals("/:plus")) {
						k = rt.al.pop();
						l = rt.al.pop();
						((AInt) k).plusD(l, this.myRt);
					} else if (aa.equals("/plus")) {
						k = rt.al.pop();
						l = rt.al.pop();
						rt.al.push(k.plusM(l));
						ctx.keeptrying = true;
					} else if (aa.charAt(1) == ':') {
						UT.not_reached();
					} else {
						if (!this.myRt.has_method(aa.substring(1))) {
							boolean b = aCl.err("undefined evaluator");
							return;
						}

						F = this.myRt.getFunction(aa.substring(1), ctx);
						Assert.not_reached();
					}
				}
			}
		} catch (Exception var14) {
			StringWriter writer = new StringWriter();
			var14.printStackTrace(new PrintWriter(writer));
			aCl.err("Java Exception: " + var14.getMessage() + "\n" + writer.getBuffer().toString());
		}

		Assert.postcondition("not R", true);
		Assert.postcondition("not R implies err != null", aCl.eval_failure != null);
		ctx.keeptrying = true;
	}

	void fallthru() {
	}

	public void eval(AEvalableToken aet, ExecutionContext ctx) {
		ctx.rt().enter_frame("<default> for " + aet.tokenText(), aet.getToken().line, aet.getToken().column);
		this._doEval2(aet, ctx);
		if (!ctx.keeptrying) {
			ctx.cl().process(true);
		}

	}
}
