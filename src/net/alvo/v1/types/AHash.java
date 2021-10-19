package net.alvo.v1.types;

import net.alvo.v1.AlvoObject;
import net.alvo.rdf.Model;
import net.alvo.util.Assert;

import java.util.Hashtable;
import java.util.List;

public class AHash extends AStringBase {
	public Hashtable h = new Hashtable();

	public AlvoObject plusM(AlvoObject aRightSide) {
		Assert.not_implemented();
		return null;
	}

	public String typeString() {
		return "ALVO:Hash";
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
