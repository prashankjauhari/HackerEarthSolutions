package com.hackerearth.graphs;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class WitchesOfHEgwarts {

public Queue<Integer>  unitBFS(Queue<Integer>  q,Map<Integer,Integer> vertexes,int cost){
	Queue<Integer> next=new LinkedList<Integer>();
	int v=-1;
	do{
		if(!q.isEmpty()){
			v=q.remove();
		}
		int data=v;
//		System.out.println("data : "+data);
			int s1=data-1;
			//System.out.println(s1+"s1");
			if(s1==1){
				vertexes.put(1, cost);
				return null;
			}else{
				if(vertexes.get(s1)==null){
				vertexes.put(s1, cost);
				next.add(s1);
				}
			}
			if(data%2==0){
				s1=data/2;
				if(s1==1){
					vertexes.put(1, cost);
					return null;
				}else{
					if(vertexes.get(s1)==null){
						vertexes.put(s1, cost);
						next.add(s1);
						}
				}	
			}
			if((data%3)==0){
				s1=data/3;
				if(s1==1){
					vertexes.put(1, cost);
					return null;
				}else{
					if(vertexes.get(s1)==null){
						vertexes.put(s1, cost);
						next.add(s1);
						}
				}	
			}
			
	}while(!q.isEmpty());
	
	return next;
}

public long attackDriver(int i){
	//Scanner sc=new Scanner(System.in);
	if(i==1){
		return 0;
	}
	Queue<Integer> q=new LinkedList<Integer>();
	Map<Integer,Integer> verticies=new HashMap<Integer,Integer>();
	int cost=1;
	verticies.put(i, cost);
	q.add(i);
	boolean run=true;
	while(run){
	q=unitBFS(q,verticies,cost);
	cost++;
	if(q==null){
		run=false;
	}
	}
	return verticies.get(1);
}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int test=Integer.parseInt(sc.nextLine());
		WitchesOfHEgwarts w=new WitchesOfHEgwarts();
		StringBuffer buffer=new StringBuffer();
		while(test-- > 0){
			int n=Integer.parseInt(sc.nextLine());
			buffer.append(w.attackDriver(n)+"\n");
		}
		System.out.println(buffer.toString());
		sc.close();
	}
}
