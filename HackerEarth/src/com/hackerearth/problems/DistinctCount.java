package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class DistinctCount {
	
	public static void main(String args[]){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer t=Integer.parseInt(br.readLine());
			while(t-->0){
				String NX[]=br.readLine().split(" ");
				Integer N=Integer.parseInt(NX[0]);
				Integer X=Integer.parseInt(NX[1]);
				HashSet<Integer> set=new HashSet<Integer>();
				String input[]=br.readLine().split(" ");
				for(int i=0;i<N;i++)
					set.add(Integer.parseInt(input[i]));
				if(set.size()==X)
					System.out.println("Good");
				else if(set.size()<X)
					System.out.println("Bad");
				else
					System.out.println("Average");
			}
		}catch(Exception e){
			
		}
	}

}
