package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

class SET<T>{
	private SETNode<T> root;
    
	private long size=0;
    
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public SETNode<T> getRoot() {
		return root;
	}

	public void setRoot(SETNode<T> root) {
		this.root = root;
	}

	public SETNode<T> insert(T data,Comparator<T> dataCompare){
		SETNode<T> temp=root;
		if(temp==null){
			this.root=new SETNode<T>(data);
			this.size++;
			return root;
		}
		boolean flag=true;
		while(flag){
			int res=dataCompare.compare(data,temp.getData());
			if(res==-1){
				if(temp.getLeft()==null){
					temp.setLeft(new SETNode<T>(data));
					flag=false;
					size++;
					 temp=temp.getLeft();
				}else
					temp=temp.getLeft();
			}else if(res==0){
				return null;
			}else{
				if(temp.getRight()==null){
					temp.setRight(new SETNode<T>(data));
					flag=false;
					size++;
					temp=temp.getRight();
				}else
					temp=temp.getRight();
			}
		}
		return temp;
	}
	
	public void inorder(SETNode<T> root){
		if(root==null)
			return;

		inorder(root.getLeft());
		System.out.println(root.getData());
		inorder(root.getRight());
	}
	
	public long hight(SETNode<T> root){
		if(root==null)
			return 0;

		
	long l_h=hight(root.getLeft());
	long r_h=hight(root.getRight());
	
	return l_h>=r_h?l_h+1:r_h+1;
	}
}
//note this should be the inner class of SET but for the time being i am creating it as seperate class
class SETNode<T>{
	private T data;
	private SETNode<T> left;
	private SETNode<T> right;

	public SETNode(T data){
		this.data=data;
		this.left=null;
		this.right=null;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public SETNode<T> getLeft() {
		return left;
	}
	public void setLeft(SETNode<T> left) {
		this.left = left;
	}
	public SETNode<T> getRight() {
		return right;
	}
	public void setRight(SETNode<T> right) {
		this.right = right;
	}		
}




public class DistinctUsingMyCustomSet {
	public static void main(String args[]){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer t=Integer.parseInt(br.readLine());
			while(t-->0){
				String NX[]=br.readLine().split(" ");
				Integer N=Integer.parseInt(NX[0]);
				Integer X=Integer.parseInt(NX[1]);
				SET<Integer> set=new SET<Integer>();
				String input[]=br.readLine().split(" ");
				 Comparator<Integer> myCom=new Comparator<Integer>() {

						@Override
						public int compare(Integer o1, Integer o2) {
							return o1.compareTo(o2);
						}
					};
					
				for(int i=0;i<N;i++)
					set.insert(Integer.parseInt(input[i]), myCom);
				if(set.getSize()==X)
					System.out.println("Good");
				else if(set.getSize()<X)
					System.out.println("Bad");
				else
					System.out.println("Average");
				
				System.out.println("traversal");
				set.inorder(set.getRoot());
			    System.out.println("size : "+set.getSize());
			    System.out.println();
			    System.out.println();
			    System.out.println();
			    System.out.println();
			    System.out.println();
			    System.out.println();
			    System.out.println();
			}
		}catch(Exception e){
			
		}
	}

}
