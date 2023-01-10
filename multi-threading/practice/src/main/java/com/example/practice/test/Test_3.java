package com.example.practice.test;

public class Test_3 {
	
	public static void main(String[] args) {
		
		// Thread Scheduling
		Thread thread = new Thread(new Runnable() {
			// 새로운 Thread 생성
			@Override
			public void run() {
				System.out.println("Hello From : " + Thread.currentThread().getName());
			}
		});
		
		thread.start();
	}
	
	// 확장성 있게 변경이 가능
	private static class NewThread extends Thread {
		
		
	}
	
	
}
