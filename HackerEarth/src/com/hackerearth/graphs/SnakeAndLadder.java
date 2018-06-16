package com.hackerearth.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class SnakeAndLadder {
	
	class node{
		
		private node parent;
		
		private long weight;
		
		private int data;
		
		public node(int data){
			this.parent=null;
			this.weight=0L;
			this.data=data;
		}
		public node getParent() {
			return parent;
		}
		public void setParent(node parent) {
			this.parent = parent;
		}
		public long getWeight() {
			return weight;
		}
		public void setWeight(long weight) {
			this.weight = weight;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		
	}
	
	public Map<Integer,node>  calculatePair(int source,boolean visited[],int x,Map<Integer,Integer> ladderOrSnake) {
	    node v=null;
		Queue<Integer> q=new LinkedList<Integer>();
		Map<Integer,node> vertexes=new HashMap<Integer,node>();
		int cost=10;
		if( ladderOrSnake.get(1)==null){
			q.add(1);
			visited[0]=true;
			node n=new node(1);
			vertexes.put(1, n);
		}else{
			node n=new node(ladderOrSnake.get(1));
			visited[n.getData()-1]=true;
			q.add(ladderOrSnake.get(1));
			vertexes.put(ladderOrSnake.get(1), n);
		}
		int i=1;
		do{
			q=unitBFS(q,visited,x,ladderOrSnake,vertexes,10);
		}while(!q.isEmpty());
		
		return vertexes;
	}
	public Queue<Integer>  unitBFS(Queue<Integer>  q,boolean visited[],int x,Map<Integer,Integer> ladderOrSnake,Map<Integer,node> vertexes,int cost){
		//elements pushed at this level will be inside this queue
		Queue<Integer> next=new LinkedList<Integer>();
		node v=null;
		do{
			if(!q.isEmpty()){
				v=vertexes.get(q.remove());
			}
			for(int j=1;j<=x;j++){
				int i=v.getData()+j;
				if(i>100){
					break;
				}
				if(ladderOrSnake.get(i)==null){
					if(!visited[i-1]){
						node u=new node(i);
						u.setParent(v);
						u.setWeight(cost+v.getWeight());
						visited[u.getData()-1]=true;
						next.add(u.getData());
						vertexes.put(i, u);
					}else{
						node u=vertexes.get(i);
						if(u.getWeight() > v.getWeight()+cost){
							u.setParent(v);
							u.setWeight(v.getWeight()+cost);
						}
					}
				} else {
					int pipe=ladderOrSnake.get(i);
					if(!visited[pipe-1]){
						node u=new node(pipe);
						u.setParent(v);
						u.setWeight(cost+v.getWeight());
						visited[u.getData()-1]=true;
						next.add(u.getData());
						vertexes.put(pipe, u);
					}else{
						node u=vertexes.get(pipe);
						if(u.getWeight() > v.getWeight()+cost){
							u.setParent(v);
							u.setWeight(v.getWeight()+cost);
						}
					}
					
				}
			}
		}while(!q.isEmpty());
		
		return next;
	}
	public static void main(String args[]){

		Scanner sc=new Scanner(System.in);
		int testCase=Integer.parseInt(sc.nextLine());
		while(testCase>0){
		String input[]=sc.nextLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int x=Integer.parseInt(input[1]);
		int c=Integer.parseInt(input[2]);
		
		Map<Integer,Integer> ladderOrSnake=new HashMap<Integer,Integer>();

		for(int i=0;i<n;i++){
			input=sc.nextLine().split(" ");
			ladderOrSnake.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		boolean visited[]=new boolean[100];
		Map<Integer,node> vertex=new SnakeAndLadder().calculatePair(1, new boolean[100],x, ladderOrSnake);
		node destination=vertex.get(c);
		if(destination==null){
			System.out.println(-1);
		}else{
			int i=0;
			while(destination!=null){
				if(destination.getParent()!=null){
					i++;
				}
				destination=destination.getParent();
			} 	
			System.out.println(i);
		}
		

		testCase=testCase-1;
	}
	
	}
}
