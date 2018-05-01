package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MonkAndMultiplicationPriorityQueue {
	
	public static void printProductOfFirstSecThird(String[] input,Integer n){
		StringBuffer buffer=new StringBuffer();
		buffer.append("-1\n-1\n");
		PriorityQueue<Long> maxPQ = new PriorityQueue<Long>(input.length,Collections.reverseOrder());
		maxPQ.add(Long.parseLong(input[0]));
		maxPQ.add(Long.parseLong(input[1]));
		for(int i=2;i<n;i++){
			maxPQ.add(Long.parseLong(input[i]));
			Long first=maxPQ.poll();
			Long second=maxPQ.poll();
			Long third=maxPQ.poll();
			buffer.append(first*second*third);
			buffer.append("\n");
			maxPQ.add(first);
			maxPQ.add(second);
			maxPQ.add(third);
		}
		System.out.println(buffer.toString());
	}
	
	public static void main(String args[]){
		
		try{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n=Integer.parseInt(br.readLine());
		String input[]=br.readLine().split(" ");
		MonkAndMultiplicationPriorityQueue.printProductOfFirstSecThird(input,n);
		}catch(Exception e){
			
		}		
	}

}
