package com.hackerearth.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class jodimaker {
	public static void printjodi(HashMap<String,String> map){
		boolean polygon=true;

		int count=0;
		int obsesive=0;
		for(Map.Entry<String, String> entry:map.entrySet()){
			String value=map.get(entry.getValue());
			if(value !=null && value.equals(entry.getKey())){
				if(entry.getKey().equals(entry.getValue())){
					obsesive++;
				}
				else{
					count++;
				}
				polygon=false;
			}
			if(value==null)
				polygon=false;
		}
		if(!polygon){
			System.out.println("NO");
			System.out.println((count/2)+obsesive);

		}else{
			System.out.println("YES");
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine());
		while(t-- > 0){
			int n=Integer.parseInt(sc.nextLine());
			HashMap<String,String> map=new HashMap<String,String>(n);
			for(int i=0;i<n;i++){
				String pair[]=sc.nextLine().split(" ");
				map.put(pair[0],pair[1]);
			}
			printjodi(map);
			System.out.println();
		}
	}

}