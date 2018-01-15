package com.hackerearth.problems;

import java.util.Scanner;

class Hive_honey {
	static int n;
	static int m;
	static int t;
	static Scanner sc;
	
	static void fill_hive(int hive[][]){
	   for(int i=0;i<n;i++){
		   for(int j=0;j<m;j++){
			   hive[i][j]=sc.nextInt();
		   }
	   }
	}
	
	public static void one_hop(int hive[][],int i,int j){
		int sum=0;
		if(i-1>=0)
			sum+=hive[(i-1)][j];
		//	System.out.println("("+(i-1)+","+j+")");
		if(i+1<n)
			sum+=hive[(i+1)][j];
		//	 System.out.println("("+(i+1)+","+j+")");
		if(j%2==0){
			
			if((j-1)>=0)
				sum+=hive[i][j-1];
				//System.out.println("("+i+","+(j-1)+")");
			if((j+1)<m)
				sum+=hive[i][j+1];
				//System.out.println("("+i+","+(j+1)+")");
			
			if((i-1)>=0){
				if((j-1)>=0)
					sum+=hive[i-1][j-1];
					// System.out.println("("+(i-1)+","+(j-1)+")");
				if((j+1)<m)
					sum+=hive[i-1][j+1];
					//System.out.println("("+(i-1)+","+(j+1)+")");
			}
		}else{
			if((j-1)>=0)
				sum+=hive[i][j-1];
				//System.out.println("("+i+","+(j-1)+")");
			if((j+1)<m)
				sum+=hive[i][j+1];
				//System.out.println("("+i+","+(j+1)+")");
			
			if((i+1)<n){
				if((j-1)>=0)
					sum+=hive[i+1][j-1];
					 //System.out.println("("+(i+1)+","+(j-1)+")");
				if((j+1)<m)
					sum+=hive[i+1][j+1];
					//System.out.println("("+(i+1)+","+(j+1)+")");
				
			}
			
		}
		System.out.println(sum);
	}
	
	public static void two_hop(int hive[][],int i,int j){
		int sum=0;
		if((j-2)>=0)
			sum+=hive[i][j-2];
		//	System.out.println("("+i+","+(j-2)+")");
		if((j+2)<m)
			sum+=hive[i][j+2];
		//	System.out.println("("+i+","+(j+2)+")");
		
		if((i-2)>=0)
			sum+=hive[i-2][j];
		//	System.out.println("("+(i-2)+","+j+")");
		if((i+2)<n)
			sum+=hive[i+2][j];
		//	System.out.println("("+(i+2)+","+j+")");
	
		
		if(j%2==0){
			if((i-1)>=0){
				if((j-2)>=0)
					sum+=hive[i-1][j-2];
	//				System.out.println("("+(i-1)+","+(j-2)+")");
				if((j+2)<m)
					sum+=hive[i-1][j+2];
		//			System.out.println("("+(i-1)+","+(j+2)+")");
			}
			
			if((i-2)>=0){
				if((j-1)>=0)
					sum+=hive[i-2][j-1];
				//	 System.out.println("("+(i-2)+","+(j-1)+")");
				if((j+1)<m)
					sum+=hive[i-2][j+1];
			//		System.out.println("("+(i-2)+","+(j+1)+")");
			}
			if((i+1)<n){
				if((j-2)>=0)
					sum+=hive[i+1][j-2];
				//	System.out.println("("+(i+1)+","+(j-2)+")");
				if((j+2)<m)
					sum+=hive[i+1][j+2];
			//		System.out.println("("+(i+1)+","+(j+2)+")");
				if((j-1)>=0)
					sum+=hive[i+1][j-1];
				//	System.out.println("("+(i+1)+","+(j-1)+")");
				if((j+1)<m)
					sum+=hive[i+1][j+1];
				//	System.out.println("("+(i+1)+","+(j+1)+")");
			}
		}else{
		   if((i-1)>=0){
			   if((j-2)>=0)
					sum+=hive[i-1][j-2];
				   //System.out.println("("+(i-1)+","+(j-2)+")");
				if(j+2<m)
					sum+=hive[i-1][j+2];
		//			System.out.println("("+(i-1)+","+(j+2)+")");
				if((j-1)>=0)
					sum+=hive[i-1][j-1];
			//		System.out.println("("+(i-1)+","+(j-1)+")");
				if(j+1<m)
					sum+=hive[i-1][j+1];
					//System.out.println("("+(i-1)+","+(j+1)+")");
			   
		   }
		   if((i+1)<n){
				if((j-2)>=0)
					sum+=hive[i+1][j-2];
					//System.out.println("("+(i+1)+","+(j-2)+")");
				if((j+2)<m)
					sum+=hive[i+1][j+2];
				//	System.out.println("("+(i+1)+","+(j+2)+")");
			}
			
			if((i+2)<n){//n 9 m 54 8 51
				if((j-1)>=0)
					sum+=hive[i+2][j-1];
		//			System.out.println("("+(i+2)+","+(j-1)+")");
				if((j+1)<m)
					sum+=hive[i+2][j+1];
				//	System.out.println("("+(i+2)+","+(j+1)+")");
			}
		   
		}
		System.out.println(sum);
		
	}
	
	public static void main(String args[]){
	sc=new Scanner(System.in);	
	t=sc.nextInt();
	
	
	  while(t>0){
		  n=sc.nextInt();
			m=sc.nextInt();
			
			int hive[][]=new int[n][m];
			
			fill_hive(hive);
		  int q=sc.nextInt();
		  while(q>0){
		  int hop=sc.nextInt();
		  int i=sc.nextInt();
		  int j=sc.nextInt();
		  /*System.out.println("n"+n);
		  System.out.println("m"+m);
		  System.out.println("i "+i);
		  System.out.println("j "+j);
		  System.out.println("value"+hive[i][j]);*/
		  if(hop==1)
		     one_hop(hive, i, j);
		  if(hop==2)
			  two_hop(hive, i, j);
		  q--;
	   }
		  t--;
	  }
	

	}


}
