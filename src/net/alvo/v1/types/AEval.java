package net.alvo.v1.types;

import net.alvo.util.UT;
import net.alvo.v1.*;
import net.alvo.rdf.Model;
import net.alvo.util.Pair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AEval implements AlvoObject, IAlvoRV, AEvalableToken {
	AToken myToken = null;

	public boolean eq(AlvoObject aRightSide, AlvoRuntime rt) {
		UT.not_reached();
		return false;
	}

	public AEval(AToken aToken) {
		this.myToken = aToken;
	}

	public AToken my() {
		return this.myToken;
	}

	public void printlnM(PrintWriter ps) {
		ps.println("/" + this.myToken.getText());
	}

	public String toString() {
		return "<AEval " + this.myToken + ">";
	}

	public AlvoObject plusM(AlvoObject aRightSide) {
		return null;
	}

	public String typeString() {
		return "ALVO:AEval";
	}

	public List rdfContent(Model aModel) {
		List R = new ArrayList();
		R.add(Pair.make("#type", "EVAL"));
		R.add(Pair.make("#text", this.myToken.getText().substring(1)));
		return R;
	}

	public AToken getToken() {
		return this.my();
	}

	public String tokenText() {
		return this.getToken().getText();
	}
}
