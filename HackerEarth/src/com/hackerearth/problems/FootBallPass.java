package com.hackerearth.problems;


import java.util.Scanner;
import java.util.Stack;

public class FootBallPass {
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		int t=Integer.parseInt(sc.nextLine());
		while(t>0){
			String N_id[]=sc.nextLine().split(" ");
			int n=Integer.parseInt(N_id[0]);
			Stack<String> stack = new Stack<String>();
			//id of the element who has the ball
			stack.push(N_id[1]);
			
			for(int i=0;i<n;i++){
			   String input[]=sc.nextLine().split(" ");
			   switch(input.length){
			     
			   case 1:stack.push(stack.elementAt(stack.size()-2));
				     break;
			   case 2:stack.push(input[1]);
				     break;
			   default :
				  	 break; 
			   
			   }
			}
			System.out.println(stack.pop());
			t--;
		}
		sc.close();
	}

}
