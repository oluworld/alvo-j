package net.alvo.v1;

import net.alvo.v1.types.AInstructionable;

import java.io.Reader;
import java.io.StringReader;

public final class StringResource implements Resource {
	private String mBasicString;

	public StringResource(String string) {
		this.mBasicString = string;
	}

	public Reader getText() {
		Reader s3 = new StringReader(this.getBasicString());
		return s3;
	}

	private String getBasicString() {
		return this.mBasicString;
	}

	public String getLocation() {
		return "<inline>";
	}

	public InstructionSource getResult(ExecutionContext ctx) throws AlvoException {
		AInstructionable res2 = ParsedResource.start(this.getLocation(), this.getText(), ctx);
		return ctx.InstructionSourceFor(res2);
	}
}
