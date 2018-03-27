package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KKAndCrush {
	
	public static void main(String args[]){
		try{
			InputStream stream=new FileInputStream(new File("/home/prashank/Documents/Project/HackerEarth/src/com/hackerearth/recursion/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		StringTokenizer st=null;
		StringBuffer output=new StringBuffer("");
		String line;
		do{
			line=br.readLine();
			if(line!=null)
				 output.append(line);
		}while(line!=null);
		Scanner sc=new Scanner(output.toString());
		
		Integer t=sc.nextInt();
	
		int j=0;
		while(j < t.intValue()){

		 int n=sc.nextInt();
		 Hashtable<Integer, Integer> hashtable=new Hashtable<Integer, Integer>(n);
		 for(int i=0;i<n;i++){
                int val=sc.nextInt();
			 hashtable.put(val,val);
		 }

		 Integer q=sc.nextInt();
		 int k=0;
		 
		 while(k < q){
			 Integer _q=sc.nextInt();
               if(hashtable.get(_q)==null)
            	   System.out.println("No");
               else
            	   System.out.println("Yes");
            k++;
		 }
		 j++;
		}
		
		br.close();
		}catch(Exception e){
		e.printStackTrace();	
		}
	
	}

}
