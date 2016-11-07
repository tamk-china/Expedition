package com.tamk.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * зда§Ыј
 * 
 * @author tamk
 *
 */
public class SpinLock {
	private AtomicReference<Thread> owner = new AtomicReference<>();

	public void lock() {
		Thread curThread = Thread.currentThread();

		while (!owner.compareAndSet(null, curThread)) {
			// sleep
		}
	}

	public void unlock() {
		Thread curThread = Thread.currentThread();

		owner.compareAndSet(curThread, null);
	}

}
