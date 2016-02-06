package com.hackbulgaria.programming101.week08;

public class Main {
	static class Run implements Runnable {

		@Override
		public void run() {

		}

	}

	/**
	 * 2 ways to create a thread
	 */
	public static void main(String[] args) {
		Thread thread = new Thread(new Run());
	}

	int a = 0;
	Object obj1 = new Object();// Kliuch 1
	Object obj2 = new Object();// Kliuch 2

	// thread A takes obj1 as a key
	public synchronized void helper() {
		// Too many methods, so we use synchronize block instead
	}

	public void incrementA() {// Thread A
		synchronized (obj1) { // same as the synchronised method
			// this block take the
			// kliuch in the beginning of the method and
			// return it in the end
			this.a += 1;
		}
	}

	public synchronized void decrementA() {
		synchronized (obj2) {

			this.a -= 1;
		}
	}

}
