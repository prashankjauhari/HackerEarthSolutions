package com.hackerearth.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.hackerearth.problems.IkshuAndFriendsDisjointSet.Node;



public class FriendsAndFoes {
	Map<Integer,Node> elements=new HashMap<Integer,Node>();
	class Node{
 
		Long rank;
 
		Integer data;
 
		Node parent;
 
		Long size;
		
		boolean candidateForSpecialGroup=true;
 
		public Node(Integer data){
			rank=0L;
			this.data=data;
			this.parent=this;
			this.size=1L;
		}
 
		public Long getSize() {
			return size;
		}
 
		public void setSize(Long size) {
			this.size = size;
		}
 
		public Long getRank() {
			return rank;
		}
 
		public void setRank(Long rank) {
			this.rank = rank;
		}
 
		public Integer getData() {
			return data;
		}
 
		public void setData(Integer data) {
			this.data = data;
		}
 
		public Node getParent() {
			return parent;
		}
 
		public void setParent(Node parent) {
			this.parent = parent;
		}
 
	}
	public Node find(Node n){
		Node current=n;
		for(current=n.getParent();current!=current.getParent();current=current.getParent()){}
		if(n.getParent()!=current)
			n.setParent(current);
		return current;
	}
 
	public void mergeSet(Node u,Node v){
		Node representativeU=find(u);
		Node representativeV=find(v);
		if(representativeU!=representativeV){
			int compare=representativeU.getRank().compareTo(representativeV.getRank());
 
			switch(compare){
 
			case 1:   
				representativeV.setParent(representativeU);
				representativeU.setSize(representativeU.getSize()+representativeV.getSize());
				break;
 
			case -1:  
				representativeU.setParent(representativeV);  
				representativeV.setSize(representativeV.getSize()+representativeU.getSize());
				break;
			default:
				representativeV.setParent(representativeU);
				representativeU.setSize(representativeU.getSize()+representativeV.getSize());
				representativeU.setRank(representativeU.getRank()+1);
				break;
			}
		}
	}
	public static void main(String args[]){
		FriendsAndFoes set=new FriendsAndFoes();
		Scanner sc=new Scanner(System.in);
		Integer total=Integer.parseInt(sc.nextLine());
		
		for(int i=1;i<=total.intValue();i++){
			set.elements.put(i, set.new Node(i));
		}
		
		Integer noOfFriendRelationBefore=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<noOfFriendRelationBefore.intValue();i++){
			String relation[]=sc.nextLine().split(" ");
			FriendsAndFoes.Node u=set.elements.get(Integer.parseInt(relation[0]));
			FriendsAndFoes.Node v=set.elements.get(Integer.parseInt(relation[1]));
			set.mergeSet(u, v);
		}
		Integer noOfFoeRelationAfter=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<noOfFoeRelationAfter.intValue();i++){
			String relation[]=sc.nextLine().split(" ");
			FriendsAndFoes.Node u=set.find(set.elements.get(Integer.parseInt(relation[0])));
			FriendsAndFoes.Node v=set.find(set.elements.get(Integer.parseInt(relation[1])));
			//both are in same set
			if(u.equals(v)){
				u.candidateForSpecialGroup=false;
			}else if(u.candidateForSpecialGroup && v.candidateForSpecialGroup){
				if(u.getSize()>v.getSize()){
					v.candidateForSpecialGroup=false;
				}else{
					u.candidateForSpecialGroup=false;
				}
			}
		}
		Set<Entry<Integer, Node>> entrySet=set.elements.entrySet();
		Iterator<Entry<Integer, Node>> itr=entrySet.iterator();
		long max=0;
		while(itr.hasNext()){
			Entry<Integer, Node> entry=itr.next();
			FriendsAndFoes.Node node=set.find(entry.getValue());
			if(node.candidateForSpecialGroup && node.getSize()>max){
				max=node.getSize();
			}
		}
		System.out.println(max);
		

		
	}

}
