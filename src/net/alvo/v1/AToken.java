package net.alvo.v1;

import net.alvo.rdf.Model;
import net.alvo.util.Assert;
import net.alvo.util.Pair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AToken implements AlvoObject {
	public int line;
	public int column;
	private String text;

	public AToken(String aString, int aColumn, int aLine) {
		this.line = aLine;
		this.column = aColumn;
		this.text = aString;
	}

	public String getText() {
		return this.text;
	}

	public String toString() {
		return "<AToken \"" + this.getText() + "\",line=" + this.line + ",col=" + this.column + ">";
	}

	public void printlnM(PrintWriter aPs) {
		Assert.not_implemented();
	}

	public boolean eq(AlvoObject aRightSide, AlvoRuntime aRt) {
		Assert.not_implemented();
		return false;
	}

	public AlvoObject plusM(AlvoObject aRightSide) {
		Assert.not_implemented();
		return null;
	}

	public String typeString() {
		return "ALVO:Token";
	}

	public List rdfContent(Model aModel) {
		List R = new ArrayList();
		R.add(Pair.make("#type", "TOKEN"));
		R.add(Pair.make("#line", new Integer(this.line)));
		R.add(Pair.make("#column", new Integer(this.column)));
		R.add(Pair.make("#text", this.getText()));
		return R;
	}
}
