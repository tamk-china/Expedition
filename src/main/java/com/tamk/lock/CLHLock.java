package com.tamk.lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * CLHËø
 * 
 * @author tamk
 *
 */
public class CLHLock {
	public static class CLHNode {
		private volatile boolean isLocked = true;
	}

	@SuppressWarnings("unused")
	private volatile CLHNode tail;
	private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater
			.newUpdater(CLHLock.class, CLHNode.class, "tail");

	public void lock(CLHNode curNode) {
		CLHNode pre = UPDATER.getAndSet(this, curNode);

		if (null != pre) {
			while (pre.isLocked) {
				// sleep
			}
		}
	}

	public void unlock(CLHNode curNode) {
		if (!UPDATER.compareAndSet(this, curNode, null)) {
			curNode.isLocked = false;
		}
	}
}
