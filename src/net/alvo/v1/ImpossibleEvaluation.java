package net.alvo.v1;

public class ImpossibleEvaluation extends Exception {
	private AEvalableToken eval;

	public ImpossibleEvaluation(AEvalableToken aet) {
		this.eval = aet;
	}
}
