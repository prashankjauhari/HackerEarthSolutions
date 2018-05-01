package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


//max heap will be order by trophies and age
class Ghosts{
	Integer age;//age will be unique identifier for ghosts
	Integer trophies;

	@Override
	public boolean equals(Object obj) {
		Ghosts ghost=(Ghosts)obj;
		return this.age.equals(ghost.age);
	}
	public Ghosts(Integer age,Integer trophies){
		this.age=age;
		this.trophies=trophies;
	}
	
	public Ghosts(Integer age){
		this.age=age;
	}
	
	@Override
	public String toString() {
		return this.age+" "+this.trophies;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getTrophies() {
		return trophies;
	}
	public void setTrophies(Integer trophies) {
		this.trophies = trophies;
	}
}


public class GhostsAndConsistencyTrophy {


	public static void printConsitancyTropyResult(String input[],Integer days,Integer ghost){


		Comparator<Ghosts> ConsitencyTropy= new Comparator<Ghosts>() {

			@Override
			public int compare(Ghosts g1, Ghosts g2) {
				int res=g2.trophies.compareTo(g1.trophies);
				if(res==0)
					return g2.age.compareTo(g1.age);
				else
					return res;
			}
		};
		Map<Integer,Ghosts> cache=new HashMap<Integer,Ghosts>();
		PriorityQueue<Ghosts> maxPQ = new PriorityQueue<Ghosts>(input.length,ConsitencyTropy);

		StringBuffer buffer=new StringBuffer();
		
		for(int i=0;i<days;i++){
			
			Ghosts temp=cache.get(Integer.parseInt(input[i]));
			
			if(temp==null){
				temp=new Ghosts(Integer.parseInt(input[i]), 1);
				maxPQ.add(temp);
				cache.put(temp.getAge(), temp);
			}else{
			 maxPQ.remove(new Ghosts(Integer.parseInt(input[i])));
			 temp.setTrophies(temp.getTrophies()+1);
			 maxPQ.add(temp);
			}
			buffer.append(maxPQ.peek()+"\n");
		}
		System.out.println(buffer.toString());
	}

	public static void main(String [] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try{
			String input[]=br.readLine().split(" ");
			Integer days=Integer.parseInt(input[0]);
			Integer ghosts=Integer.parseInt(input[1]);
			input=br.readLine().split(" ");
			printConsitancyTropyResult(input, days, ghosts);
		}catch(Exception e){
          e.printStackTrace();
		}
	}
}
