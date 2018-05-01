
package com.hackerearth.problems;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;



public class TeacherDilemma {
	Map<Integer,Node> elements=new HashMap<Integer,Node>();
    Map<Integer,Node> sets=new HashMap<Integer,Node>();
	class Node{

		Long rank;

		Integer data;

		Node parent;
		
		Long size;

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
		TeacherDilemma set=new TeacherDilemma();
		  Scanner sc=new Scanner(System.in);
	      String input[]=sc.nextLine().split(" ");
	      Integer noOfStudents=Integer.parseInt(input[0]);
	      Integer noOfRelation=Integer.parseInt(input[1]);
	      
	      for(int i=1;i<=noOfStudents.intValue();i++){
	    	  set.elements.put(i, set.new Node(i));
	      }
	      
	      for(int i=0;i<noOfRelation.intValue();i++){
	    	  String relation[]=sc.nextLine().split(" ");
	    	  TeacherDilemma.Node u=set.elements.get(Integer.parseInt(relation[0]));
	    	  TeacherDilemma.Node v=set.elements.get(Integer.parseInt(relation[1]));
	      	  set.mergeSet(u, v);
	      }
	      Set<Entry<Integer, Node>> entrySet=set.elements.entrySet();
	      Iterator<Entry<Integer, Node>> itr=entrySet.iterator();
	      long val=1L;
	      long mod=1000000007;
	      while(itr.hasNext()){
	    	  Entry<Integer, Node> entry=itr.next();
	    	  TeacherDilemma.Node u= set.find(entry.getValue());
	    	  
	    	  if(set.sets.get(u.getData())==null){
	    		  set.sets.put(u.getData(), u);
	    		  val=((val%mod)*(u.getSize()%mod))%mod;
	    	  }
	    	  
	      }
	      System.out.println(val);
	}
}
