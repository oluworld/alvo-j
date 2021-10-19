package net.alvo.v1;

import net.alvo.util.UT;
import net.alvo.v1.types.AEval;
import net.alvo.v1.types.AIdent;
import net.alvo.v1.types.AInt;
import net.alvo.v1.types.AList;
import net.alvo.v1.types.AString;
import net.alvo.v1.types.Lazy;

public abstract class SimpleAlvoListener implements AlvoListener {
	public void lazy(Lazy al) {
		this.append(al);
		UT.speculated();
	}

	public void list(AList al) {
		this.append(al);
		UT.speculated();
	}

	public void eval(AEvalableToken aet, ExecutionContext ctx) {
		this.append((AEval) aet);
	}

	public void lazy_end() {
		UT.not_reached();
	}

	public void lazy_start() {
		UT.not_reached();
	}

	public void list_end() {
		UT.not_reached();
	}

	public void list_start() {
		UT.not_reached();
	}

	public void num_int(AToken e) {
		try {
			int i = Integer.parseInt(e.getText());
			this.append(new AInt(i));
		} catch (NumberFormatException var3) {
			UT.not_reached();
		}

	}

	public void num_float(AToken e) {
		try {
			double d = Double.parseDouble(e.getText());
			this.append(new AFloat(d));
		} catch (NumberFormatException var4) {
			UT.not_reached();
		}

	}

	public void ident(AToken e) {
		this.append(new AIdent(e));
	}

	public void quote_last() {
		UT.not_reached();
	}

	public void string_lit(AToken e) {
		this.append(new AString(e));
	}

	public abstract void append(AlvoObject var1);

	public abstract void push(AlvoObject var1);

	public abstract AlvoObject pop();
}
