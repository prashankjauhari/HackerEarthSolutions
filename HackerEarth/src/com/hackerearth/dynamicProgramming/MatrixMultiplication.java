package com.hackerearth.dynamicProgramming;

/**
 * this source code provide the bottom up implementation
 * of matrix multiplication 
 * space : O(n^2)
 * time  : O(n^3)
 * @author prashank
 */

public class MatrixMultiplication {

	void matrixMultiplication(int p[]){

		int n=p.length;

		int m[][]=new int[n][n];
		
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
					}
				}
			}
			
		}
		System.out.println(m[1][n-1]);
	}
	public static void main(String args[]){
		//2×3, 3×5, 5×2, 2×4, 4×3 
		int p[]={10, 20, 30};
		new MatrixMultiplication().matrixMultiplication(p);
	}
}
