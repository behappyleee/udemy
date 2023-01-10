package com.example.practice.test;

public class Test_2 {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// Code that will run in a new thread
				// 보통 Java 에서 체크 되지 않은 예외는 직접 캐치하여 관리하지 않으면
				// 전체 스레드를 다운 시킴
				throw new RuntimeException("Intentional Exception !");
			}
		});
		
		thread.setName("Misbehaving thread");
		
		// Thread 에 예외 핸들러 설정이 가능함 (스레드 내에서 발생한 예외가 캐치 되지 않을 시 예외 발생 시 해당 Handler 작동)
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// 보통 리소스 일부를 정리한다던지 ... 예외 후 필요한 작업들을 처리, 추가 데티러를 로그
				System.out.println("A critical error happend in thread : " + t.getName() + " " + e.getMessage());
			}
		});
		
		thread.start();
	}
}
