package com.hackerearth.dynamicProgramming;

/**
 * this source code provide the bottom up implementation
 * of matrix multiplication 
 * space : O(n^2)
 * time  : O(n^3)
 * @author prashank
 */

public class MatrixMultiplication {

	int m[][];
	int u[][];
	void matrixMultiplication(int p[]){

		int n=p.length;

		m=new int[n][n];
		u=new int[n][n];
		for(int i=0;i<n;i++)
			m[i][i]=0;
		
		//length of matrix
		for(int l=2;l<n;l++){
			for(int i=1;i<(n-l+1);i++){
				int j=i+l-1;
				m[i][j]=999999999;
				for(int s=0;s<(j-i);s++){
					int k=i+s;
					int q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(q<m[i][j]){
						m[i][j]=q;
						u[i][j]=k;
					}
				}
			}
			
		}
	}
	public String printSolution(int i,int j,int u[][]){
		if(i==j){
			return "(A"+i+")";
		}
		if(i==j-1){
			return "(A"+i+"A"+j+")";
		}
		
		StringBuilder build=new StringBuilder();
		build.append("(");
		int k=this.u[i][j];
		String str=printSolution(i, k, u)+printSolution(k+1, j, u);
		build.append(str).append(")");
		return build.toString();
	}
	public static void main(String args[]){
		int p[]= {10, 20, 30, 40};
		MatrixMultiplication m=new MatrixMultiplication();
		m.matrixMultiplication(p);
		System.out.println("Optimal cost is "+m.m[1][p.length-1]);
		System.out.println("Optimal parenthesis is "+m.printSolution(1,p.length-1,m.u));
	}
}
