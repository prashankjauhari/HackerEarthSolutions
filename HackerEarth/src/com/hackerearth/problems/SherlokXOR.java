package com.hackerearth.problems;

import  java.util.Scanner;
public class SherlokXOR {
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		long testcase=Long.parseLong(sc.nextLine());
		long odd;
		long even;
		while(testcase-- > 0){
			odd=0;
			even=0;
			long length=Long.parseLong(sc.nextLine());
			String number[]=sc.nextLine().split(" ");
		   for(int i=0;i<length;i++){
			   if(Long.parseLong(number[i])%2==0){
				  even++; 
			   }else{
				   odd++;
			   }
		   }
		   System.out.println(even*odd);
		}
		
	}

}
