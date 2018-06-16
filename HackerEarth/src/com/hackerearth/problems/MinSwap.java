package com.hackerearth.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class MinSwap {

	public static String calulateKey(int[] a){
		StringBuffer buffer=new StringBuffer("");
		for(int i=0;i<a.length;i++){
			buffer.append(a[i]+" ");
		}
		return buffer.toString().trim();
	}

	public static int[] reverse(int array[],int start,int end){
		for(int i=0; i<(end-start+1)/2; i++){
			int temp = array[i];
			array[i] = array[end -i];
			array[end -i] = temp;
		}
		return array;
	}
	public Queue<String>  unitBFS(Queue<String>  q,Map<String,int []> verticies,String des ){
		Queue<String> next=new LinkedList<String>();
		String v="";
		do{
			if(!q.isEmpty()){
				v=q.remove();
			}
			int vertex[]=verticies.get(v);
		//	System.out.println("poped"+calulateKey(vertex));
			for(int i=1;i<vertex.length;i++){
				int temp[]=vertex.clone();
				temp=reverse(temp, 0, i);
				String key=calulateKey(temp);
			//	System.out.println("first : "+key);
				if(key.equals(des)){
					return null;
				}
				if(verticies.get(key)==null){
					verticies.put(key, temp);
					next.add(key);
				}
			}

		}while(!q.isEmpty());

		return next;
	}
	public static void print(int array[]){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}

	public int minOperationDriver(int a[]){
		int des[]=a.clone();
		String srcKey=calulateKey(a);
		Arrays.sort(des);
		String desKey=calulateKey(des);
		if(srcKey.equals(desKey)){
			return 0;
		}
		Map<String,int[]> verticies=new HashMap<String,int[]>();
		verticies.put(srcKey, a);
		Queue<String> q=new LinkedList<String>();
		q.add(srcKey);
		boolean run=true;
		int cost=1;
		//System.out.println(q);
		//Scanner sc=new Scanner(System.in);
		while(run){
			q=unitBFS(q, verticies, desKey);
			//System.out.println(q);
			if(q==null){
				run=false;
			}else{
				cost=cost+1;
			}
		//	sc.nextLine();
		}
		return cost;
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		int a[]=new int[n];
		String input[]=sc.nextLine().split(" ");
		for(int i=0;i<a.length;i++){
			a[i]=Integer.parseInt(input[i]);
		}
		System.out.println(new MinSwap().minOperationDriver(a));
	}

}
