package com.tamk.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.tamk.lock.MCSLock.MCSNode;

public class Main {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			private MCSLock lock = new MCSLock();

			@Override
			public void run() {
				MCSNode node = new MCSNode();
				
				try {
					lock.lock(node);
					for (int i = 0; i < 10; ++i) {
						System.out.println(i);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock(node);
				}
			}
		};

		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(r);
		es.execute(r);
		es.shutdown();
	}
}
