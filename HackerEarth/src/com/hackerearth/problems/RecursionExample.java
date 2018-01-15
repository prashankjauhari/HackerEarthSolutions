package com.hackerearth.problems;

public class RecursionExample {

	static  void printR(int arr[],int i){
		if(i<arr.length){
			printR(arr,i+1);
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String args[]){
		int number[]={1,2,3,4,5,6,7,8};
		printR(number,0);
	}
}
