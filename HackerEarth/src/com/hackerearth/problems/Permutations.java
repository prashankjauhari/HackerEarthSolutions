package com.hackerearth.problems;


public class Permutations {
	public void permute(int array[],int j){
		if(j==array.length-1){
			print(array);
			return;
		}
		for(int i=j;i<array.length;i++){
			int newArray[]=swap(array.clone(),i,j);
			permute(newArray,j+1);
		}
	}
	public static void print(int array[]){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
	public static int[] swap(int arr[],int i,int j){
		int x=arr[i];
		arr[i]=arr[j];
		arr[j]=x;
		return arr;
	}
	
	
	public static void main(String args[]){
			int array[]={1,2,3};
			new Permutations().permute(array, 0);
		}
}
