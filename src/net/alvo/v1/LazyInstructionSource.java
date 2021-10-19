package net.alvo.v1;

import net.alvo.v1.types.AInstructionable;

import java.util.Iterator;

public class LazyInstructionSource implements InstructionSource {
	private AInstructionable src;
	private Iterator ii;

	public LazyInstructionSource(AInstructionable aSrc) {
		this.src = aSrc;
		this.ii = this.src.instructionPart().iterator();
	}

	public IAlvoRV next() {
		if (!this.ii.hasNext()) {
			return null;
		} else {
			Object object = this.ii.next();
			AlvoObject R = (AlvoObject) object;
			return (IAlvoRV) R;
		}
	}
}
