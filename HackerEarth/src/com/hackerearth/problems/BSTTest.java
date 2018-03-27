package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

class BST<T>{
	private BSTNode<T> root;
    
	private long size=0;
    
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public BSTNode<T> getRoot() {
		return root;
	}

	public void setRoot(BSTNode<T> root) {
		this.root = root;
	}

	public void insert(T data,Comparator<T> dataCompare){
		BSTNode<T> temp=root;
		if(temp==null){
			this.root=new BSTNode<T>(data);
			return;
		}
		boolean flag=true;
		while(flag){
			int res=dataCompare.compare(data,temp.getData());
			if(res==0 || res==-1){
				if(temp.getLeft()==null){
					temp.setLeft(new BSTNode<T>(data));
					flag=false;
					size++;
				}else
					temp=temp.getLeft();
			}else{
				if(temp.getRight()==null){
					temp.setRight(new BSTNode<T>(data));
					flag=false;
					size++;
				}else
					temp=temp.getRight();
			}

		}
	}
	
	public void inorder(BSTNode<T> root){
		if(root==null)
			return;

		inorder(root.getLeft());
		System.out.println(root.getData());
		inorder(root.getRight());
	}
	
	public long hight(BSTNode<T> root){
		if(root==null)
			return 0;

		
	long l_h=hight(root.getLeft());
	long r_h=hight(root.getRight());
	
	return l_h>=r_h?l_h+1:r_h+1;
	}
	public T findMaxUntilKeyFound(T key,BSTNode<T> from,Comparator<T> comparator){
		T max=from.getData();
		boolean flag=true;
		while(flag){
		int com=comparator.compare(key, from.getData());
		if(com==-1){
			from=from.getLeft();
		}else if(com==1){
			from=from.getRight();
		}else{
			flag=false;
		}
		if(comparator.compare(max, from.getData())==-1)
			max=from.getData();
		
	}
		return max;
		
	}
	//node this method will work only if it is gaurented the a and b both present in the tree
	public T maxBetweenLAndRPath(T a,T b,Comparator<T> comparator){
		BSTNode<T> intermidiate=this.findIntermediate(a, b, comparator);
		T max;
		if(comparator.compare(a, intermidiate.getData())==0){
			max=findMaxUntilKeyFound(b, intermidiate, comparator);
		}else if(comparator.compare(b, intermidiate.getData())==0){
			max= findMaxUntilKeyFound(a, intermidiate, comparator);
		}else{
			T lmax=findMaxUntilKeyFound(a, intermidiate, comparator);
			T rmax=findMaxUntilKeyFound(b, intermidiate, comparator);
	    	max=comparator.compare(lmax, rmax)==1?lmax:rmax;
		}
		
		return max;
	}
	
	public BSTNode<T> findIntermediate(T a,T b,Comparator<T> comparator){
		 boolean flag=true;
		 BSTNode<T> temp=this.getRoot();
		 while(flag){
			 int l=comparator.compare(a, temp.getData());
			 int r=comparator.compare(b, temp.getData());
			/* System.out.println("l : " + l);
			 System.out.println("r : "+r);
			 System.out.println("temp "+temp.getData());*/
			 if(l==0 || r==0 ||(l!=r)){
				 flag=false;
			 }else{
				 if(l==-1)
					 temp=temp.getLeft();
				 else
					 temp=temp.getRight();
			
			 }
		 }
		 return temp;
	}
}
//note this should be the inner class of bst but for the time being i am creating it as seperate class
class BSTNode<T>{
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;

	public BSTNode(T data){
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
	public BSTNode<T> getLeft() {
		return left;
	}
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	public BSTNode<T> getRight() {
		return right;
	}
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}		
}

public class BSTTest{
    public static void main(String args[]){
    	try{
    	BST<Integer> tree=new BST<Integer>();
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		Integer N=Integer.parseInt(br.readLine());
	    
       Comparator<Integer> myCom=new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};
	String input[]=br.readLine().split(" ");

    	for(int i=0;i<N.intValue();i++)
    		tree.insert(Integer.parseInt(input[i]), myCom);
    	   br.close();
    	tree.inorder(tree.getRoot());
    	System.out.println("height");
        System.out.println(tree.hight(tree.getRoot()));
        
    }catch(Exception e){
    	
    }
    }
}
