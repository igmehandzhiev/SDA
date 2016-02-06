package com.hackbulgaria.programming101.week08;

public class ConsumerProducerPattern {
	/*
	 * produce "1" consume "1"
	 * 
	 * "wait 1 second"
	 * 
	 * produce "2" consume "2"
	 */
	static class Producer implements Runnable {
		private String[] messages;

		/* wait, notify, notifyAll */
		@Override
		public void run() {
			produceMessages();
			for (String message : messages) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private void produceMessages() {
			messages = new String[] { "gmail", "fmi", "arsenal", "thread" };
		}
	}

	public static void main(String[] args) {

	}

}
