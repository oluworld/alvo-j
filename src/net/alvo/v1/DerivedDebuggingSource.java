/* -*- Mode: Java; tab-width: 4; indent-tabs-mode: t; c-basic-offset: 4 -*- */
/*
 */
package net.alvo.v1;

/**
 * Created 10/19/21 4:41 AM
 */
public class DerivedDebuggingSource implements InstructionSource {
	private InstructionSource src;
	private DebuggingInstructionSource derived;

	public DerivedDebuggingSource(final DebuggingInstructionSource aDebuggingInstructionSource, final InstructionSource aR) {
		src = aR;
		derived = aDebuggingInstructionSource;
	}

	@Override
	public IAlvoRV next() {
		try {
			synchronized (derived.permission) {
				derived.permission.wait();
			}
		} catch (InterruptedException var3) {
		}

		final IAlvoRV next = this.src.next();
		return next;
	}
}

//
// vim:set shiftwidth=4 softtabstop=0 noexpandtab:
//
