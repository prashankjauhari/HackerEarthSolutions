package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeProfitForTickets {

	public static  Long findMaximumProfit(String input[],Integer rows,Integer viewer){
		PriorityQueue<Long> maxPQ = new PriorityQueue<Long>(input.length,Collections.reverseOrder());

		for(int i=0;i<rows;i++){
			maxPQ.add(Long.parseLong(input[i]));
		}
		input=null;
		Long profit=0L;

		for(int i=0;i<viewer;i++){
			Long maxPriceForHim=maxPQ.poll();
			profit+=maxPriceForHim;
			maxPriceForHim-=1L;
			if(maxPriceForHim>0)
				maxPQ.add(maxPriceForHim);
		}

		return profit;
	}

	public static void main(String args[]){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input[]=br.readLine().split(" ");
			Integer rows=Integer.parseInt(input[0]);
			Integer viewer=Integer.parseInt(input[1]);
			input=br.readLine().split(" ");

			System.out.println(MaximizeProfitForTickets.findMaximumProfit(input, rows, viewer));
		}catch(Exception e){

		}
	}
}
