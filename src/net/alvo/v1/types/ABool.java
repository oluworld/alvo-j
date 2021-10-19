package net.alvo.v1.types;

import net.alvo.util.UT;
import net.alvo.v1.AlvoObject;
import net.alvo.v1.AlvoRuntime;
import net.alvo.rdf.Model;
import net.alvo.util.Assert;

import java.io.PrintWriter;
import java.util.List;

public class ABool implements AlvoObject {
	private boolean v;
	public static ABool TRUE = new ABool(true);
	public static ABool FALSE = new ABool(false);

	public ABool(boolean aB) {
		this.v = aB;
	}

	public void printlnM(PrintWriter ps) {
		UT.not_reached();
	}

	public boolean eval(AlvoRuntime rt) {
		UT.not_reached();
		return false;
	}

	public boolean eq(AlvoObject aRightSide, AlvoRuntime rt) {
		UT.not_reached();
		return false;
	}

	public AlvoObject plusM(AlvoObject aRightSide) {
		UT.not_reached();
		return null;
	}

	public String toString() {
		return "<ABool " + (this.v ? "true" : "false") + ">";
	}

	public String typeString() {
		return "ALVO:Boolean";
	}

	public Model aModel() {
		Assert.not_implemented();
		return null;
	}

	public List rdfContent(Model aModel) {
		Assert.not_implemented();
		return null;
	}
}
