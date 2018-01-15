package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MerutMarry {
	public static void main(String args[]){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n=Integer.parseInt(br.readLine().trim());
			Map<String,String> QualityMap=new HashMap<String,String>(n);
			String Q[]=br.readLine().split(" ");
			for(String a:Q){
				QualityMap.put(a, a);
			}
			int goldiggers=Integer.parseInt(br.readLine());
			int Qualifiedgirls=0;
			for(int i=0;i<goldiggers;i++){
				int count=0;
				String gQ[]=br.readLine().split(" ");

				for(String q:gQ){
					if(QualityMap.get(q)!=null){
						count++;
					}
				}
				if(count>=n)
					Qualifiedgirls++;
			}
			System.out.println(Qualifiedgirls);


		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
