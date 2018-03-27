package com.hackerearth.problems;

class binaryTreeNode<T>{
	T data;

	binaryTreeNode<T> left;

	binaryTreeNode<T> right;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public binaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(binaryTreeNode<T> left) {
		this.left = left;
	}

	public binaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(binaryTreeNode<T> right) {
		this.right = right;
	}

	public binaryTreeNode(T data){
		this.data=data;
		this.left=this.right=null;
	}
}

public class BinaryTree<T> {
	public binaryTreeNode<T> root;


	public binaryTreeNode<T> getRoot() {
		return root;
	}

	public BinaryTree(T root){
		this.root=new binaryTreeNode<T>(root);
	}
	public void setRoot(binaryTreeNode<T> root) {
		this.root = root;
	}

	//take O(n) times
	public int totalRecursive(binaryTreeNode<T> root){
		if(root==null)
			return 0;
		return (totalRecursive(root.getLeft())+totalRecursive(root.getRight()))+1;
	}
	
	//count leaf and non leaf in binary tree
	public int[] CLN(binaryTreeNode<T> root){
		if(root==null){
			int a[]={0,0};
			return a;
		}else{
			int l[]=CLN(root.getLeft());
			int r[]=CLN(root.getRight());
			l[0]+=r[0];
			l[1]+=r[1];
			if(root.getLeft()==null && root.getRight()==null){
				l[0]++;
				return l;
			}else{
				l[1]++;
				return l;
			}
		}
	}
	
	//calculate full node
	public int FFN(binaryTreeNode<T> root){
		if(root==null)
			return 0;
		else
			return FFN(root.left)+FFN(root.right) + ((root.left!=null && root.right!=null)?1:0);
		
	}
	
	//takes O(n) time
	public binaryTreeNode<T> insert(T data,String path){
		if(root==null){
			return null;
		}
		binaryTreeNode<T> temp=root;
		for(int i=0;i<path.length();i++){
			if(path.charAt(i)=='L'){
				if(temp.getLeft()==null)
					temp.setLeft(new binaryTreeNode<T>(null));
				temp=temp.getLeft();
			}else{
				if(temp.getRight()==null)
					temp.setRight(new binaryTreeNode<T>(null));
				temp=temp.getRight();
			}
		}
		temp.data=data;
		return temp;
	}

	public static void main(String args[]){
		BinaryTree<Character> mytree=new BinaryTree<Character>('A');
		mytree.insert('B', "L");
		mytree.insert('C', "R");
		mytree.insert('E', "LL");
		mytree.insert('D', "RL");
		mytree.insert('L', "RR");
		mytree.insert('M', "LR");
		mytree.insert('K', "RRR");
		mytree.insert('N', "RRL");
		int cln[]=mytree.CLN(mytree.root);
		System.out.println("Leaf : "+cln[0]);
		System.out.println("non leaf : "+cln[1]);
		System.out.println("Full node : "+mytree.FFN(mytree.root));
	}
}
