package com.hackerearth.problems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class HumanNode<T>{
	public T value;
	public long col;
	public HumanNode<T>left;
	public HumanNode<T>right;	
}

public class GandhiTreeMarch {

	public static StringBuffer input;

	public static List<Character> traverse(HumanNode<Character> root,List<Character> list,int col){
		if(root==null)
			return list;

		traverse(root.left,list,col);
		if(root.col==col)
				list.add(root.value);
		traverse(root.right,list,col);
		return list;
	}

	public static int insert(int index,HumanNode<Character> root,int col){

		//1
		char input=GandhiTreeMarch.input.charAt(index);
		//2
		if(input>=97 && input<=122){
			root.value=input;
			root.col=col;
		}
		//3
		else if(input=='.'){
			root.value='.';
			root.col=10000+1;
			return index+1;
		}
		//entering of open bracket

		//fill left child 
		//4
		index=index+2;
		//5
		HumanNode<Character> left=new HumanNode<Character>();
		//6
		root.left=left;
		//7
		index=insert(index, left, col-1);//assuming insert return next value to be inserted
		//8
		HumanNode<Character> right=new HumanNode<Character>();
		//9
		root.right=right;
		//10
		index=insert(index,right,col+1);
		//11
		if(GandhiTreeMarch.input.charAt(index)==')')
			return index+1;
		else
			return index;
	}


	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		try {
			int t=Integer.parseInt(sc.nextLine());
			while(t-- > 0){
				int col=sc.nextInt();
				GandhiTreeMarch.input=new StringBuffer(sc.nextLine());
				HumanNode<Character> root=new HumanNode<Character>();
				GandhiTreeMarch.insert(1, root, 0);
				List<Character> list=GandhiTreeMarch.traverse(root,new LinkedList<Character>(), col);
				if(list.isEmpty()){
					System.out.println("Common Gandhijee!");
				}else{
					StringBuffer buff=new StringBuffer("");
					Collections.sort(list);
					for(int i=0;i<list.size();i++){
						buff.append(list.get(i));
					}
					System.out.println(buff);
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
