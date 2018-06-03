package com.hackerearth.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



//1 1,2,3 1,3 1,4,5 1,2 1,5 1,2,4 1,6 1,2,11 1,2,10 11,12,133 10,11,54,123,133 1,54 1,2,3,4,5,10,11,12,54,123,133 2,3,4,5,10,11,12,54,123,133,134,135,136,137,138,139,140,141 2,3,4,5,10,11,12,54,123,133,134,135,136,137,138,139,140,141,142
//4,5,1,3

public class ValidCombinatorLittleMoreEfficent {

		public static void main (String[] args) 
		{
	

			Scanner sc=new Scanner(System.in);
			String validCombination[]=sc.nextLine().split(" ");
			String inputSet[]=sc.nextLine().split(",");
			Map<String,Integer> location=new HashMap<String,Integer>();
			for(int i=0;i<inputSet.length;i++){
				location.put(inputSet[i], i);
			}
			boolean found=false;

			long start=System.currentTimeMillis();
			for(int j=0;j<validCombination.length;j++){
				List<String> list=new LinkedList<String>();
				String character[]=validCombination[j].split(",");
				int i;
				int prevloca=-1;
				for(i=0;i<character.length;i++){
						if(location.get(character[i])!=null){
							if(location.get(character[i])>prevloca){
									prevloca=location.get(character[i]);
									list.add(character[i]);
									found=true;
							}else{
								found=false;
							}
						}else{
							found=false;
							break;
						}
				}
				if(found){
					System.out.println(list);
				}else{
					list=null;
				}
				
			}
			long end=System.currentTimeMillis();
			System.out.println(end-start);
		}
}