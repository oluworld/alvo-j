package net.alvo.v1.types;

import net.alvo.util.UT;
import net.alvo.v1.AToken;
import net.alvo.v1.AlvoObject;
import net.alvo.v1.AlvoRuntime;
import net.alvo.v1.IAlvoRV;
import net.alvo.rdf.Model;
import net.alvo.util.Pair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AIdent implements AlvoObject, IAlvoRV {
	private AToken myToken = null;

	public boolean eq(AlvoObject aRightSide, AlvoRuntime rt) {
		UT.not_reached();
		return false;
	}

	public AIdent(AToken aToken) {
		this.myToken = aToken;
	}

	public String toString() {
		return "<AIdent " + this.myToken.getText() + ">";
	}

	public void printlnM(PrintWriter ps) {
		ps.println("** IDENT " + this.myToken.getText());
		UT.speculated();
	}

	public AlvoObject plusM(AlvoObject aRightSide) {
		UT.not_reached();
		return null;
	}

	public String typeString() {
		return "ALVO:Ident";
	}

	public AToken myt() {
		return this.myToken;
	}

	public String my() {
		return this.myToken.getText();
	}

	public List rdfContent(Model m) {
		List R = new ArrayList();
		R.add(Pair.make("#type", "IDENT"));
		R.add(Pair.make("#text", this.my()));
		return R;
	}
}
