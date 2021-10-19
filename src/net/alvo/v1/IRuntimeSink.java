package net.alvo.v1;

public interface IRuntimeSink {
	AlvoObject pop();

	void push(IAlvoRV var1);

	void eval(AEvalableToken var1, ExecutionContext var2);
}
