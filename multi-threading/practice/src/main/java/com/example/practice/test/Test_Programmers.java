package com.example.practice.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Test_Programmers {
	
	private static Deque <Integer> de = new ArrayDeque <Integer> ();
	
	
	public static void main(String[] args) throws IOException {
//		문제 설명
//		햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 
//		함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고,
//		상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 
//		정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 
//		상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 
//		재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
//
//		예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 
//		상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 
//		아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 
//		즉, 2개의 햄버거를 포장하게 됩니다.
//
//		상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 
//		햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
//
//		제한사항
//		1 ≤ ingredient의 길이 ≤ 1,000,000
//		ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
	}

	private static int burgerCount(int[] ingredient) {
		int burgerCount = 0;
		// ingredient 원소는 1,2,3 중에 하나이며 순서대로
		// 1-빵 2- 야채 3 - 고기, 1-2-3-1 ==> HamberGer 1개가 완성이 됨
		
		ArrayList<Integer> ingredientList = new ArrayList<Integer>();
		ArrayList<Integer> burgerList = new ArrayList<Integer>();
		
		while(ingredientList.size() > 3) {
			boolean isExistBurger = false;
			for(int i=0; i<ingredientList.size(); i++) {
				int firstIndex = ingredientList.get(i);
				
				if((firstIndex == 1) && (i+4>ingredientList.size())) {
					break;
				} else {
					for(int j=i; j<(i+4); j++) {
						
					}
				}
				
			}
		}
		
		return burgerCount;
	}
	
	private static int doFunc(String command) {
		String commandLine = command.split(" ")[0];
		if(commandLine.equals("front")) {
			if(de.isEmpty()) {
				return -1;
			} else {
				return de.getFirst();
			}
		}
		if(commandLine.equals("back")) {
			if(de.isEmpty()) {
				return -1;
			} else {
				return de.getLast();
			}
		}
		if(commandLine.equals("size")) {
			return de.size();
		}
		if(commandLine.equals("empty")) {
			if(de.isEmpty()) return 1;
			if(!de.isEmpty()) return 0;
 		}
		if(commandLine.equals("push_front")) {
			int pushFirstInt = Integer.parseInt(command.split(" ")[1]);
			de.addFirst(pushFirstInt);
			return -5;
		}
		if(commandLine.equals("push_back")) {
			int pushLastInt = Integer.parseInt(command.split(" ")[1]);
			de.addLast(pushLastInt);
			return -5;
		}
		if(commandLine.equals("pop_front")) {
			if(de.isEmpty()) return -1;
			int firstInt = de.getFirst();
			de.removeFirst();
			return firstInt;
		}
		if(commandLine.equals("pop_back")) {
			if(de.isEmpty()) return -1;
			int lastInt = de.getLast();
			de.removeLast();
			return lastInt;
		}
		return -5;
	}
	
	 
}




