package net.alvo.v1;

public class DebuggingPermission {
	public void step() {
		synchronized (this) {
			this.notifyAll();
		}
	}
}
