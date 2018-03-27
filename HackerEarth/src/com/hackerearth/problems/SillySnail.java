package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SillySnail {

	public static void main(String args[]){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t=Integer.parseInt(br.readLine());
			while(t-- > 0){
				BinaryTree<Integer> mytree=new BinaryTree<Integer>(1);
				mytree.save(mytree.getRoot().getData(), mytree.getRoot());
				int n=Integer.parseInt(br.readLine());
				for(int i=1;i<=n;i++){
					String relation[]=br.readLine().split(" ");
					binaryTreeNode<Integer> X= mytree.get(Integer.parseInt(relation[0]));
					binaryTreeNode<Integer> Y=new binaryTreeNode<Integer>(Integer.parseInt(relation[1]));
					binaryTreeNode<Integer> Z=new binaryTreeNode<Integer>(Integer.parseInt(relation[2]));
					X.setLeft(Y);
					X.setRight(Z);
					mytree.save(Y.getData(),Y);
					mytree.save(Z.getData(),Z);
				}
				StringBuffer buffer=new StringBuffer("");
				buffer=mytree.preorder(mytree.getRoot(),0,buffer);
				System.out.println(buffer.toString());
				System.out.println();
				mytree=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
