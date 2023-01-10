package com.example.practice.test;

public class Test_1 {
	
	public static void main(String[] args) throws InterruptedException{
		// 현재 실행 중인 Main Thread 와 JVM 이 생성한 세개의 스레드는 당장 제어가 불가능
		
		// Thread 운영체제의 비동기적으로 작동
		// Thread Scheduling - 운양체제가 각 스레드에 동적 우선순위를 적용
		
		// 기존 방법
		Thread thread = new Thread(new Runnable() {
			// 새로운 Thread 생성
			
			// Debugging 을 위하여 Debug Toggle 을 설정 후 Debug 모드로 Run
			// Debugging Toggle 걸린 바로 전까지만 프로그램이 실행이 됨
			@Override
			public void run() {
				System.out.println("we are now in thread : " + Thread.currentThread().getName());
				
				System.out.println("Current Thread Priority : " + Thread.currentThread().getPriority());
			}
		});
		
		// Thread 이름을 다음과 같이 Setting 가능 (Debugging 에 큰 도움이 됨)
		thread.setName("New worker Thread");
		
		// 동작에는 큰 차이가 없지만 복잡한 프로그램의 스레드에서는 아주 중요한 역할을 함
		thread.setPriority(Thread.MAX_PRIORITY);	// MAX 는 10임
//		thread.setPriority(Thread.MIN_PRIORITY);
		
		// 현재 실행 중인 Thread 이름 얻기 가능
		System.out.println("We are in thread : " + Thread.currentThread().getName() + " BEFORE STARTING A NEW THREAD");
		// 새로운 Thread시작 방법
		thread.start();
		System.out.println("We are in thread : " + Thread.currentThread().getName() + " AFTER STARTING A NEW THREAD");
		
		// Thread 를 잠재우는것 도 가능 
		// 해당 스레드는 해당 시간 동안 CPU 를 사용하지 않음
		Thread.sleep(10000000);
		
		// 람다도 가능
		Thread threadLambda = new Thread(() -> {
			// Java 8 버전 이상부터는 람다도 사용이 가능
		});
		
		
		// Thread 생성하기 위하여 새로운 Thread 객체 생성
//		Thread thread = new Thread(new Runnalbe() {
//			@Override
//			public void run() {
//				// Java 8 이상 버전은 람다로 줄일 수 있음 
//				// Code That will rund in a new thread !
//			}
//		});
//		
//		Thread lamdabThread = new Thread(new Runnable() -> {
//			
//		})
		
	}
	
}
