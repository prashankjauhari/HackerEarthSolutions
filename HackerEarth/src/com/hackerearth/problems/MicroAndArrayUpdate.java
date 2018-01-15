package com.hackerearth.problems;

import java.util.Scanner;

public class MicroAndArrayUpdate {

	public static void main(String args[]){
		

		Scanner sc=new Scanner(System.in);
		long T=sc.nextLong();
		
		while(T>0){
		    long N=sc.nextLong();
			long K=sc.nextLong();
		    long min=sc.nextLong();
		    for(long i=0;i<N-1;i++){
		    	long temp=sc.nextLong();
		    	if(min>temp)
		    		 min=temp;
		    }
		    System.out.println("minimum is "+min);
		    System.out.println("K is "+K);
		    if(min<K)
		    System.out.println(K-min);
		    else 
		    System.out.println(0);
		    T--;
		  
		}
	}
}
