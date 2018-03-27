package com.hackerearth.problems;

import java.util.Scanner;

public class TrueCells{
	
public static void main(String args[]){
	
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
    int size=1000000-1;
	while(t>0){
		int n=sc.nextInt();
		int c=0;
		for(int i=0;i<n;i++){
			int a=sc.nextInt()-1;
			int b=sc.nextInt()-1;
			
			/*System.out.prinrrtln("input to be processed");
			System.out.println("i "+a);
			System.out.println("j "+b);*/
			
			if(a==b)
				c++;
			else if(a==(size-b-1)){
				c++;
			}
		}
		t--;
		System.out.println(c);
	}
}
}
