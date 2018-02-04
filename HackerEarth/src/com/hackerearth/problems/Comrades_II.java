package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

//Tree problem solving with leftmost child right sibling represtation

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * left most child right sibling representation node structure
 */
class LCRS_Node<T>{

	private LCRS_Node<T> parent;
	
	private T value;

	private List<LCRS_Node<T>> children;

	public LCRS_Node (T value){
		this.value=value;
		this.children=new LinkedList<LCRS_Node<T>>();
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<LCRS_Node<T>> getChildren() {
		return children;
	}

	public void setChildren(List<LCRS_Node<T>> children) {
		this.children = children;
	}
	
	public LCRS_Node<T> getParent() {
		return parent;
	}

	public void setParent(LCRS_Node<T> parent) {
		this.parent = parent;
	}
	
	
}

class LCRS_Tree<T>{
	
	private LCRS_Node<T> root;
	
	private Map<T,LCRS_Node<T>> cache=new HashMap<T,LCRS_Node<T>>();

	public LCRS_Node<T> getRoot() {
		return root;
	}

	public void setRoot(LCRS_Node<T> root) {
		this.root = root;
	}

	public Map<T, LCRS_Node<T>> getCache() {
		return cache;
	}

	public void setCache(Map<T, LCRS_Node<T>> cache) {
		this.cache = cache;
	}
	
	public LCRS_Node<T> find(T value){
		return this.getCache().get(value);
	}
	
	public void save(T key,LCRS_Node<T> node){
		this.getCache().put(key, node);
	}
}

public class Comrades_II {
	
	public static long handshake(LCRS_Tree<Long> narryTree,long parentSoFar,long h,List<LCRS_Node<Long>> childeren){
		if(childeren==null)
			return 0;
//		System.out.println("h "+h);
//		System.out.println("p "+parentSoFar);
//		System.out.println("childeren length"+childeren.size());
		
		h+=parentSoFar*childeren.size();
	  // System.out.println("new h"+h);
		for(int i=0;i<childeren.size();i++){
			if(childeren.get(i).getChildren()!=null){
				h=handshake(narryTree, parentSoFar+1, h, childeren.get(i).getChildren());
			}
		}
		return h;
	}
	public static void printHandShakeWristPair(long n,long handshake){
		System.out.println(handshake+" "+((n*(n-1))/2-handshake));
	}
	
	public static void main(String args[]){
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/prashank/Documents/Project/HackerEarthSolutions/HackerEarth/src/com/hackerearth/problems/input.txt")));
   
		int t=Integer.parseInt(br.readLine());
		
		while(t-- > 0){
			LCRS_Tree<Long> narryTree=new LCRS_Tree<Long>();
			int n=Integer.parseInt(br.readLine());
			String superviserArray[]=br.readLine().split(" ");
//			System.out.println(superviserArray);
			for(int i=1;i<=n;i++){
				long immedidate=Long.parseLong(superviserArray[i-1]);
				//System.out.println("Imediate :"+immedidate+"********");
				LCRS_Node<Long> node=narryTree.find((long)i)==null?new LCRS_Node<Long>((long)i):narryTree.find((long)i);
				narryTree.save(node.getValue(), node);
				if(immedidate==0){
					//this is supreme commander who does not follow anyone aka KING PIN :-)
					node.setParent(null);
					narryTree.setRoot(node);
					//System.out.println("root set");
				}else{
					LCRS_Node<Long> immediateSuperior=narryTree.find(immedidate);
					if(immediateSuperior!=null){
						node.setParent(immediateSuperior);
						immediateSuperior.getChildren().add(node);
						
					}else{
						immediateSuperior=new LCRS_Node<Long>(immedidate);
						node.setParent(immediateSuperior);
						immediateSuperior.getChildren().add(node);
						narryTree.save(immedidate, immediateSuperior);
					}
				}
			}
//			System.out.println("Insert DOne");
			long handshake=Comrades_II.handshake(narryTree, 1L,0L, narryTree.getRoot().getChildren());
			//System.out.println("handshake : "+handshake);
			Comrades_II.printHandShakeWristPair(n, handshake);
			narryTree=null;
		}
		br.close();
	}catch(Exception e){
		e.printStackTrace();
	}

}
}
