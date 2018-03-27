package com.hackerearth.problems;

import java.util.ArrayList;
import java.util.List;

public class ReverseArrayRecursive {
	
	/**
	 * halting condition when index not equal 
	 * to length of array it will return
	 * which in return will empty the recursion
	 * stack.
	 */
	public static void printArrayRev(List<Integer>  array,int index){
		if(index!=array.size()-1){
			printArrayRev(array, index+1);
			System.out.println(array.get(index));
		}
	}

	public static void pirntIterative(List<Integer> array){
		for(int i=0;i<array.size()-1;i++){
			System.out.println(array.get(i));
		}
	}
	public static void main(String args[]){
		List<Integer> array=new ArrayList<Integer>();
		for(int i=0;i<100000;i++){
			array.add(i);
		}
		//ReverseArrayRecursive.printArrayRev(array, 0);
		ReverseArrayRecursive.pirntIterative(array);
	}

}
