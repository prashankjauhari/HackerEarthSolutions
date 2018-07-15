package com.hackerearth.greedy;


import java.util.Scanner;

public class BennyandCandies {
	
	
	/**
	 * Some time being greedy can be profitable, here i am greedy about 
	 * trade.
	 * @param priceList
	 * @return
	 */
	static long calulateMaxProfit(long priceList[]){
		long CBA=priceList[0];
		long totalProfit=0L;
		for(int i=1;i<priceList.length;i++){
			
			if(priceList[i]<CBA){
				CBA=priceList[i];
			}else if(priceList[i]>CBA){
				totalProfit+=priceList[i]-CBA;
				CBA=priceList[i];
			}
		}
		return totalProfit;
		
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String input[]=sc.nextLine().split(" ");
		long n=Long.parseLong(input[0]);
		long m=Long.parseLong(input[1]);
		input=sc.nextLine().split(" ");
		long a=Long.parseLong(input[0]);
		long b=Long.parseLong(input[1]);
		long c[]=new long[(int)n];
		long x[]=new long[(int)n+1];
		long base=(long)Math.pow(2.0, 32.0);
		long divide=(long)Math.pow(2.0, 8.0);
		for (int i = 0; i < n; i++) {
			x[i+1] = (x[i] % m * a + b) % base;
		    c[i]=(long)Math.floor(x[i+1]/256.0);
		}	
		System.out.println(calulateMaxProfit(c));
	}

}

