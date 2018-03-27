package com.hackerearth.problems;

import java.util.Scanner;

public class MirrorImage {
	
	public static void main(String args[]){
		BinaryTree<Integer> mytree=new BinaryTree<Integer>(1);
		Scanner sc=new Scanner(System.in);
		String feedinput=sc.nextLine();
		int n=Integer.parseInt(feedinput.split(" ")[0]);
		int q=Integer.parseInt(feedinput.split(" ")[1]);
		
		
		//feed tree
	
		for(int i=0;i<n-1;i++){
			String input[]=sc.nextLine().split(" ");
			int parent=Integer.parseInt(input[0]);
			binaryTreeNode<Integer> pNode=mytree.find(mytree.getRoot(), parent);
			int child=Integer.parseInt(input[1]);
			if(input[2].equals("L")){
				pNode.setLeft(new binaryTreeNode<Integer>(child));
			}else{
				pNode.setRight(new binaryTreeNode<Integer>(child));
			}
		}
		for(int i=0;i<q;i++){
			feedinput=sc.nextLine();
			StringBuilder path=mytree.searchPath(mytree.getRoot(), Integer.parseInt(feedinput), new Helper()).getPath();
			System.out.println(mytree.findMirror(path, -1));
		}
		
		sc.close();
	
	}
}
