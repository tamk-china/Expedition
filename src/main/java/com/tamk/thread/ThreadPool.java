package com.tamk.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	
	public static class Runner implements Runnable {
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		executor.submit(new Runner());
	}
}
