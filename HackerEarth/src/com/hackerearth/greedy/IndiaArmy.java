package com.hackerearth.greedy;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.util.Comparator ;
import java.util.PriorityQueue;
import java.util.Scanner;

public class IndiaArmy {
	
	static class CheckPoint{
		Long start;
		Long end;
		
		public CheckPoint(Long start,Long end){
			this.start=start;
			this.end=end;
		}

		public Long getStart() {
			return start;
		}

		public void setStart(Long start) {
			this.start = start;
		}

		public Long getEnd() {
			return end;
		}

		public void setEnd(Long end) {
			this.end = end;
		}

	}

	//Building PQ will take O(n) time
	public static PriorityQueue<CheckPoint> buildMinHeap(Scanner sc, int n){
		Comparator<CheckPoint> minPQComparator= new Comparator<CheckPoint>() {
			@Override
			public int compare(CheckPoint c1,CheckPoint c2) {
				return c1.start.compareTo(c2.start);
			}
		};
		String input[];
		PriorityQueue<CheckPoint> minPQ = new PriorityQueue<CheckPoint>(n,minPQComparator);
		for(int i=0;i<n;i++){
			input=sc.nextLine().split(" ");
			CheckPoint c=new IndiaArmy.CheckPoint(parseLong(input[0])-parseLong(input[1]), parseLong(input[0])+parseLong(input[1]));
			minPQ.add(c);
		}
		return minPQ;
	}
	//	//208451467498514314
	public static boolean between(long start,long end,long i){
		 return i>=start && i<=end;
	}
	public static long findMinimumDanger(PriorityQueue<CheckPoint> minPQ,long start,long end,long e){
		long s=start;
		if(start==e){
			return 0;
		}
		boolean exchange=false;
		long danger=0L;
		while(true){
			CheckPoint v=minPQ.poll();
			if(v==null){
				if(exchange){
					return danger+e-end;
				}else{
					return e-start;
				}
			}

			if(between(v.start, v.end, start) && (v.end<=e || between(v.start, v.end, e))){
				start=v.start;
				end=v.end;
				exchange=true;
				if(between(start, end, e)){
					return danger;
				}
			}else if(between(v.start, v.end, end) && (v.end<=e || between(v.start, v.end, e))){
				start=v.start;
				end=v.end;
				exchange=true;
				if(between(start, end, e)){
					return danger;
				}
			}else if(end < v.end && (v.end<=e || between(v.start, v.end, e))){
				danger+=(v.start-end);
				start=v.start;
				end=v.end;
				exchange=true;
				if(between(start, end, e)){
					return danger;
				}
			}
			
		}
	}
	
	public static void main(String args[]){
		try{
		Scanner sc= new Scanner(System.in);
			String input[]=sc.nextLine().split(" ");
			int n=parseInt(input[0]);	
			long s=parseLong(input[1]);
			long e=parseLong(input[2]);
			PriorityQueue<CheckPoint> minPQ=buildMinHeap(sc, n);
			System.out.println(IndiaArmy.findMinimumDanger(minPQ, s, s, e));
			sc.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
