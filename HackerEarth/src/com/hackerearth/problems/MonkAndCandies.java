package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;


public class MonkAndCandies {

	public static void main(String args[]){
		try{

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Long t=Long.parseLong(br.readLine());
			Comparator<Long> myCom=new Comparator<Long>() {

				@Override
				public int compare(Long o1, Long o2) {
					return o1.compareTo(o2);
				}
			};
			while(t-->0){
				String NM[]=br.readLine().split(" ");
				SET<Long> set=new SET<Long>();
				int n=Integer.parseInt(NM[0]);
				int m=Integer.parseInt(NM[1]);
				
				String input[]=br.readLine().split(" ");
				
				for(int i=0;i<n;i++)
					set.insert(Long.parseLong(input[i]),myCom);
				
				for(int i=n;i<n+m;i++){
					SETNode<Long> temp=set.insert(Long.parseLong(input[i]), myCom);
					if(temp==null)
						System.out.println("YES");
					else{
						System.out.println("NO");
					}
				}

			}
		}catch(Exception e){}
	}
}
