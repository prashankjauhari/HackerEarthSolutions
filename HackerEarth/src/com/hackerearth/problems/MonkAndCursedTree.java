package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

public class MonkAndCursedTree {

	public static void main(String args[]){
		BST<Integer> cursedTree=new BST<Integer>();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer N=Integer.parseInt(br.readLine());
			String input[]=br.readLine().split(" ");
			String XY[]=br.readLine().split(" ");
			 Comparator<Integer> integerCom=new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
				};
			for(int i=0;i<N;i++){
				cursedTree.insert(Integer.parseInt(input[i]), integerCom);
			}
			System.out.println(cursedTree.maxBetweenLAndRPath(Integer.parseInt(XY[0]),Integer.parseInt(XY[1]),integerCom));
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
