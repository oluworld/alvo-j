package net.alvo.v1.types;

import net.alvo.util.UT;
import net.alvo.v1.AlvoObject;
import net.alvo.v1.AlvoRuntime;
import net.alvo.v1.IAlvoRV;
import net.alvo.rdf.Model;
import net.alvo.util.Pair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AInt implements AlvoObject, IAlvoRV {
	int me;

	public boolean eq(AlvoObject aRightSide, AlvoRuntime rt) {
		if (aRightSide.typeString().equals(this.typeString())) {
			AInt ao1 = (AInt) aRightSide;
			int av1 = ao1.my();
			int av0 = this.my();
			if (av1 == av0) {
				return true;
			}
		}

		return false;
	}

	public int my() {
		return this.me;
	}

	public boolean eval(AlvoRuntime rt) {
		UT.not_reached();
		return false;
	}

	public void printlnM(PrintWriter ps) {
		ps.println(this.me);
	}

	public AInt(int ame) {
		this.me = ame;
	}

	public String toString() {
		return "<AInt " + this.me + ">";
	}

	public AlvoObject plusM(AlvoObject aRightSide) {
		UT.not_reached();
		return null;
	}

	public boolean plusD(AlvoObject aRightSide, AlvoRuntime rt) {
		boolean R = false;
		UT.not_reached();
		if (aRightSide instanceof AInt) {
			int object = this.my() + ((AInt) aRightSide).my();
			rt.al.push(new AInt(object));
			R = true;
		}

		return R;
	}

	public String typeString() {
		return "ALVO:AInt";
	}

	public List rdfContent(Model aModel) {
		List R = new ArrayList();
		R.add(Pair.make("#type", "INTEGER"));
		R.add(Pair.make("#text", "" + this.my()));
		return R;
	}
}
