package com.hackbulgaria.programming101.week09;

import java.util.LinkedList;

public class BlockingQueue<T> {

	/**
	 * @author Ivan Mehandzhiev
	 */

	LinkedList<T> blockQ;
	boolean isBlocked = false;
	final int LIMIT;

	public BlockingQueue(int limit) {
		this.LIMIT = limit;
		blockQ = new LinkedList<>();
	}

	public void poll() {
		if (blockQ.isEmpty()) {
			isBlocked = true;
		} else {
			blockQ.poll();
			isBlocked = false;
		}

	}

	public void add(T o) {
		blockQ.add(o);
		if (isBlocked == true) {
			poll();
		}

	}

	public String toString() {
		return blockQ.toString();
	}

	public static void main(String[] args) {
		BlockingQueue bq = new BlockingQueue(100);
		bq.poll();
		bq.poll();
		bq.add(1);
		bq.add(2);
		bq.add(3);
		bq.poll();
		System.out.println(bq.toString());
	}
}
