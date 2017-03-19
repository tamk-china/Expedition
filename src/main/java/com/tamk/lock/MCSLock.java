package com.tamk.lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * MCS锁
 * 
 * @author tamk
 *
 */
public class MCSLock {
	public static class MCSNode {
		public MCSNode next;
		private boolean isLocked = true;
	}

	@SuppressWarnings("unused")
	private volatile MCSNode tail;
	private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater
			.newUpdater(MCSLock.class, MCSNode.class, "tail");

	public void lock(MCSNode curNode) {
		MCSNode pre = UPDATER.getAndSet(this, curNode);

		if (null != pre) {
			pre.next = curNode;
			while (curNode.isLocked) {
				// sleep
			}
		}
	}

	public void unlock(MCSNode curNode) {
		if (UPDATER.get(this) == curNode) {
			// 对尾节点的特殊处理
			if (null == curNode.next) {
				// 二次判断
				if (UPDATER.compareAndSet(this, curNode, null)) {
					return;
				} else {
					while (null == curNode.next) {
						// sleep
					}
				}
			}

			curNode.next.isLocked = false;
			// for GC
			curNode.next = null;
		}
	}
}
