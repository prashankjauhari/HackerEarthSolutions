package com.hackerearth.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Anagram {
	public static void main(String args[]){

		Scanner sc=new Scanner(System.in);
		int testcases=Integer.parseInt(sc.nextLine());

		while(testcases-- > 0){
			/*
			 * System.out.println("testcase :"+testcases);
			 * 
			 */
			StringBuilder T=new StringBuilder(sc.nextLine());
			StringBuilder S=new StringBuilder(sc.nextLine());
			
			/*
			 *System.out.println("T :"+T);
			  System.out.println("S :"+S);
			*/
			Map<Character,Integer> map=new HashMap<Character,Integer>();
			for(int i=0;i<T.length();i++)
				map.put(T.charAt(i), map.get(T.charAt(i))==null?1:map.get(T.charAt(i)).intValue()+1);


			int diff=0;
			for(int i=0;i<S.length();i++){
				char ch=S.charAt(i);
				Integer value=map.get(ch);
				if(value==null || value.intValue()<=0)
					diff++;
				else
					map.put(ch, value.intValue()-1);
			}

			for(Entry<Character,Integer> entryset:map.entrySet()){
				Integer value=entryset.getValue();
				if(entryset.getValue()>0){
					diff=diff+value.intValue();
				}
			}
			System.out.println(diff);
		}
		sc.close();
	}

}
