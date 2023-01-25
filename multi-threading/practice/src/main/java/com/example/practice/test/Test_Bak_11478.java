package com.example.practice.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test_Bak_11478 {
	
	public static void main(String[] args) throws IOException {
//		문제
//		양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 
//		어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 N의 진짜 약수의 개수가 주어진다. 이 개수는 50보다 작거나 같은 자연수이다. 
//		둘째 줄에는 N의 진짜 약수가 주어진다. 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.
//
//		출력
//		첫째 줄에 N을 출력한다. N은 항상 32비트 부호있는 정수로 표현할 수 있다.
		
		String[] pa = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] com = {"josipa", "filipa", "marina", "nikola"};
		
		String competition = solution(pa, com);
		
		System.out.println("COMPETE : " +  competition);
	
	}
	
	public static String solution(String[] participant, String[] completion) {
	    String answer = "";
	    for(int i=0; i<participant.length; i++) {
	    	String paName = participant[i];
	    	boolean isExist = false;
	    	for(int j=0; j<completion.length; j++) {
	    		String coName = completion[j];
	    		if(paName.equals(coName)) {
	    			completion[j] = null;
	    			isExist = true;
	    			break;
	    		}
	    	}
	    	if(!isExist) {
	    		answer = paName;
	    	}
	    }
	    return answer;
	}
	
	
	
	
	
}
