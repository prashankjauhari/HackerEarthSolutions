package com.hackerearth.problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidCombinationProblem {
	
	public static void main(String args[]){
	
		StringBuffer v=new StringBuffer("");
		
		for(int i=0;i<100000;i++){
			v.append(i+",");
		}
		System.out.println(v.toString());
		Scanner sc=new Scanner(System.in);
		String validCombination[]=sc.nextLine().split(" ");
		Set<String> search=new HashSet<String>();
		for(String comb:validCombination)
			search.add(comb);
		


		String inputSet[]=sc.nextLine().split(",");
		System.out.println("length of input set : "+inputSet.length);
		int a=(int)Math.pow(2,inputSet.length);
		System.out.println("to subset : "+a);
		long start =System.currentTimeMillis();
		
		   int N=inputSet.length;
		   boolean resume=true;
	        for(int i = 0;i < a && resume; i++)
	        {
	        	StringBuffer setSoFar=new StringBuffer("");
	            for(int j = 0;j < N;j++){
	                if((i & (1 << j))>0)
	                   setSoFar.append(inputSet[j]+",");
	            }


	            	if(search.contains(setSoFar.toString())){
	            		System.out.println("Match : "+setSoFar);
	            	    
	            	}

	    }
	        
	long end=System.currentTimeMillis();
	System.out.println(end-start);
	}

}
