package com.hackerearth.problems;

import java.util.HashSet;
import java.util.Scanner;

public class SaveLife {
	
	public static void main(String args[]){
		
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int array[]=new int[N];
		
		for(int i=0;i<N;i++)
			array[i]=sc.nextInt();
		
		int queries=sc.nextInt();
		
		while(queries>0){
			
			int p=sc.nextInt()-1;
			int q=sc.nextInt()-1;
			HashSet<Integer> set=new HashSet<Integer>(q-p+1);
			for(int i=p;i<=q;i++){
				set.add(array[i]);
			}
			System.out.println(set.size());
			
			queries--;
		}
		
	}

}
