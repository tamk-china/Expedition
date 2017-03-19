package com.tamk.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	private ReentrantLock lock = new ReentrantLock(false);

	public void f() {
		try {
			lock.lock();
			for (int i = 0; i < 10; ++i) {
				System.out.println(Thread.currentThread().getName() + "_" + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Runnable r= new Runnable() {
			private ReentrantLockTest test = new ReentrantLockTest();
			
			@Override
			public void run() {
				test.f();
				test.f();
			}
		};
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(r);
		es.execute(r);
		es.shutdown();
	}
}
