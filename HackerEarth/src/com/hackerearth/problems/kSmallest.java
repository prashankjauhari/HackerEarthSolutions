package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class kSmallest {
	
	public static String source;
	
	//return -1 if found none
	public static void kSmallest(int l,int r,int k){
		
        if((r-l+1)>=k){
		int freq[]=new int[26];
		for(int i=l;i<=r;i++){
			freq[source.charAt(i)-97]++;
		}
		
		int sum=0;

		for(int i=0;i<26;i++){
			if(freq[i]>0){
				sum+=freq[i];
				if(sum>=k){
					System.out.println((char)(i+97));
					break;
				}
			}
		}
       }else{
    	   System.out.println("Out of range");
       }
	}
	public static void main(String args[]){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8192*2);
		
		int n,q;
		try{
		String temp[]=br.readLine().split(" ");
		n=Integer.parseInt(temp[0]);
		q=Integer.parseInt(temp[1]);
		source=br.readLine();
		while(q>0){
			temp=br.readLine().split(" ");
			kSmallest(Integer.parseInt(temp[0])-1,
					  Integer.parseInt(temp[1])-1,
					  Integer.parseInt(temp[2]));
		    q--;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
