package com.hackerearth.problems;

import java.util.Scanner;

public class Symmetric {
	
	/**
	 * This function is used to compare two row 
	 * @param i
	 * @param j
	 * @param n
	 * @return
	 */
	public static boolean rowCompare(int i,int j,int n,int array[][]){
		for(int pos=0;pos<n;pos++){
			if(array[i][pos]==array[j][pos]){
			}else{
				return false;
			}
		}
		return true;
	}
	/**
	 * This function is used to compare two columns 
	 * @param i
	 * @param j
	 * @param n
	 * @param array
	 * @return
	 */
	public static boolean colCompare(int i,int j,int n,int array[][]){
		for(int pos=0;pos<n;pos++){
			if(array[pos][i]==array[pos][j]){
			}else{
				return false;
			}
		}
		return true;
	}
	/**
	 * Check for symmetric along x axis
	 * @param array
	 * @param n
	 * @return
	 */
	public static boolean xCompare(int array[][],int n){
		int first=0;
		int last=n-1;
		int time=n/2;
		for(int i=0;i<time;i++){
			if(rowCompare(first, last, n, array)){
				first++;
				last--;
			}else{
				return false;
			}
		}
		return true;
	}
	/**
	 * Check for symmetric along y axis
	 * @param array
	 * @param n
	 * @return
	 */
	public static boolean yCompare(int array[][],int n){
		int first=0;
		int last=n-1;
		int time=n/2;
		for(int i=0;i<time;i++){
			if(colCompare(first, last, n, array)){
				first++;
				last--;
			}else{
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]){
	  Scanner sc=new Scanner(System.in);
	  int t=Integer.parseInt(sc.nextLine());
	  
	  while(t>0){
		  int n=Integer.parseInt(sc.nextLine());
		  int array[][]=new int[n][n];
		  for(int i=0;i<n;i++){
			  String temp=sc.nextLine();
			  int len=temp.length();
			  for(int j=0;j<len;j++){
				  array[i][j]=temp.charAt(j)-48;
			  }
		  }
		  if(xCompare(array, n)){
			  if(yCompare(array, n)){
				  System.out.println("YES");
			  }else{
				  System.out.println("NO");
			  }
		  }else{
			  System.out.println("NO");
		  }
		  t--;
	  }

	}
}
