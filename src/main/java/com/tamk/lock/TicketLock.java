package com.tamk.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ≈≈∫≈À¯
 * 
 * @author tamk
 *
 */
public class TicketLock {
	private AtomicInteger serviceNum = new AtomicInteger();
	private AtomicInteger ticketNum = new AtomicInteger();

	public int lock() {
		int ticketNum = this.ticketNum.getAndIncrement();

		while (serviceNum.get() != ticketNum) {
			// sleep
		}

		return ticketNum;
	}

	public void unlock(int ticketNum) {
		serviceNum.compareAndSet(ticketNum, serviceNum.incrementAndGet());
	}
}
