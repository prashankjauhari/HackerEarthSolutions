package com.hackerearth.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Helper{
	boolean flag;
	StringBuilder path;
	
	public Helper(){
		this.flag=false;
		this.path=new StringBuilder("");
	}
	public StringBuilder getPath() {
		return path;
	}
	public void setPath(StringBuilder path) {
		this.path = path;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
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
	private Map<T,binaryTreeNode<T>> cache=new HashMap<T,binaryTreeNode<T>>();


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

	public void inorder(binaryTreeNode<T> root){
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.getData());
		inorder(root.right);
	}
	public StringBuffer preorder(binaryTreeNode<T> root,T stopdata,StringBuffer buffer){
		if(root==null || root.getData()==stopdata)
			return buffer;
		buffer.append(root.getData()+" ");
		buffer=preorder(root.left,stopdata,buffer);
		buffer=preorder(root.right,stopdata,buffer);
		return buffer;
	}
	
	public binaryTreeNode<T> find(binaryTreeNode<T> root,T value){
		binaryTreeNode<T> parent=null;
		
		if(root==null)
			return parent;

		if(root.getData().equals(value)){
			parent=root;
		}
		if(parent==null)
		parent=find(root.left,value);
		
		if(parent==null)
		parent=find(root.right,value);
		
		return parent;
	}
	
	public Helper searchPath(binaryTreeNode<T> root,T value,Helper help){
	
		if(root==null)
			return help;
		
		if(root.getData().equals(value)){
			help.setFlag(true);
		}
		
		if(!help.isFlag()){
		help.setPath(help.getPath().append("L"));
		help=searchPath(root.left,value,help);
		if(!help.isFlag())
			help.setPath(help.getPath().deleteCharAt(help.getPath().length()-1));
		}
		
		
		if(!help.isFlag()){
		help.setPath(help.getPath().append("R"));
		help=searchPath(root.right,value,help);
		if(!help.isFlag())
			help.setPath(help.getPath().deleteCharAt(help.getPath().length()-1));
		}
		return help;
	}
	//hight of the tree
	public int hight(binaryTreeNode<T> root){
		if(root==null)
			return 0;
		if(root.getLeft()==null && root.getRight()==null)
			return 0;
		return Math.max(hight(root.getLeft()), hight(root.getRight()))+1;
	}
	//calculate diameter of the tree in linear time O(n)
	public int[] hight_diameter(binaryTreeNode<T> root){
		int h_d[]=new int[2];
		if(root==null || isLeaf(root) ){
			h_d[0]=0;
			h_d[1]=0;
			return h_d;
		}
		int left_h_d[]=hight_diameter(root.left);
		int right_h_d[]=hight_diameter(root.right);
		
		h_d[0]=Math.max(left_h_d[0], right_h_d[0])+1;
		
		if(!isFullnode(root)){
			h_d[1]=root.getLeft()==null?right_h_d[1]:left_h_d[1];
		}else{
			h_d[1]=Math.max(left_h_d[1], Math.max(right_h_d[1], (left_h_d[0]+right_h_d[0]+3)));
		}
		return h_d;
	}
	public boolean isLeaf(binaryTreeNode<T> root){
		return (root.getLeft()==null && root.getRight()==null) ? true:false;
	}
	
	public boolean isFullnode(binaryTreeNode<T> root){
		return (root.getLeft()!=null && root.getRight()!=null) ? true:false;
	}
	
	public void save(T key,binaryTreeNode<T> node){
		this.cache.put(key, node);
	}
	public binaryTreeNode<T> get(T key){
		return this.cache.get(key);
	}
	public T findMirror(StringBuilder path,T defaultChar){
		
		binaryTreeNode<T> temp=this.getRoot();
		if(root==null)
			return defaultChar;
		
		for(int i=0;i<path.length();i++){
			if(path.charAt(i)=='L')
				temp=temp.getRight();
			else
				temp=temp.getLeft();
			

			if(temp==null)
				return defaultChar;	
		}
		

		if(temp==null)
			return defaultChar;	
		
		return temp.getData();
	}

	public static void main(String args[]){
		BinaryTree<Integer> mytree=new BinaryTree<Integer>(null);
		Scanner sc=new Scanner(System.in);
		String feedinput=sc.nextLine();
		int n=Integer.parseInt(feedinput.split(" ")[0]);
		mytree.getRoot().setData(Integer.parseInt(feedinput.split(" ")[1]));
		 
		//feed tree
		
		for(int i=0;i<n-1;i++){
			feedinput=sc.nextLine();
			mytree.insert(Integer.parseInt(sc.nextLine()), feedinput);
		}
		sc.close();
		
		System.out.println(mytree.hight_diameter(mytree.root)[1]);
	}
}
