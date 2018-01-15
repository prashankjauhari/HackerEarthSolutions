package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


//approach is {smarter brute force}

public class LittleMonkAndParenthesis {

	public static int[] compute(List<Integer> list,int f){
	 Stack<Integer> stack=new Stack<Integer>();	
	 
	 int result[]=new int[2];
	 
	 result[0]=f;
	 result[1]=-1;

	 for(int i=f;i<list.size();i++){
	      	int a=list.get(i);
	      	if(a>0){
	      		stack.push(a);
	      	}else{
	      		if(stack.isEmpty())
	      			return result;
	      		
	      		int b=stack.pop();
	      		
	      		if((a+b)==0){
	      			if(stack.isEmpty())
	      				result[1]=i;
	      		}else{
	      			return result;
	      		}
	      	}
	 }
	 
	 return result;
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		try {
			st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				 list.add(Integer.parseInt(st.nextToken()));
			
			int max=0;
			for(int i=0;i<list.size();){
			int result[]=LittleMonkAndParenthesis.compute(list,i);
			System.out.println("{ first :"+result[0]+","+"last:"+result[1]+"}");
			if(result[1]!=-1){
				int len=result[1]-result[0]+1; 
				i=result[1]+1;
				if(len>max)
					 max=len;
				}
			else
				i++;
			}
			

			System.out.println(max);
			
		}catch(Exception e){
			
		}
	}
}