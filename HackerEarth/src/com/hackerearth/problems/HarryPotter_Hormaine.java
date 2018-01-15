package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


class Element{
	long element;
	int index; 
	Element(long value,int index){
		this.element=value;
		this.index=index;
	}
	public String toString(){
		return (this.element+" "+this.index);
	}

}

public class HarryPotter_Hormaine {
		public static long[] findNGERHS(ArrayList<Element> element){
		long x[]=new long[element.size()];
		Stack<Element> stack=new Stack<Element>();
		stack.push(element.get(0));

		for(int j=1;j<element.size();j++){
			Element underProcessing=element.get(j);

			while(!stack.isEmpty() && stack.peek().element<underProcessing.element){
				Element processed=stack.pop();
				x[processed.index]=underProcessing.index+1;
			}
			stack.push(underProcessing);
		}
		while(!stack.isEmpty()){
			x[stack.pop().index]=-1;
		}

		return x;
	}

	public static long[] findNGELHS(ArrayList<Element> element){
		long x[]=new long[element.size()];
		Stack<Element> stack=new Stack<Element>();
		stack.push(element.get(element.size()-1));
		for(int j=element.size()-2;j>=0;j--){
			Element underProcessing=element.get(j);
			while(!stack.isEmpty() && stack.peek().element<underProcessing.element){
				Element processed=stack.pop();
				x[processed.index]=underProcessing.index+1;
			}
			stack.push(underProcessing);
		}
		while(!stack.isEmpty()){
			Element element1=stack.pop();
			x[element1.index]=-1;
		}
		return x;
	}

	public static void main(String args[]) throws IOException{
		
		 BufferedReader br = new BufferedReader(new FileReader("/home/prashank/Downloads/harry/A.txt"));
		 
		 StringTokenizer st = new StringTokenizer(br.readLine()); 

	        ArrayList<Element> list=null;    
	        int N=-1;
	        try{
	        N= Integer.parseInt(st.nextToken());
	        
	        
	        
		list=new ArrayList<Element>(N);
		 st = new StringTokenizer(br.readLine()); 

		
		for(int i=0;st.hasMoreTokens();i++){
			
			list.add(new Element(Long.parseLong(st.nextToken()),i));
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
  //   System.out.println("data reading done");
	
        long x[]=findNGELHS(list);
		long y[]=findNGERHS(list);
	 
	 //System.out.println("calculation done");
		StringBuilder buff = new StringBuilder();
		
		for(int i=0;i<N;i++){
			buff.append(""+(x[i]+y[i])+" ");
		}
		System.out.println( buff.toString());
		buff.setLength(0);
	}

}
