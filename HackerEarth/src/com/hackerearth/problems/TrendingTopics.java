package com.hackerearth.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Topic{
	Integer id;
	Long zScore;
	Long diff;
	
	public Long getDiff() {
		return diff;
	}
	public void setDiff(Long diff) {
		this.diff = diff;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return this.id+" "+this.zScore;
	}
	public long getzScore() {
		return zScore;
	}
	public void setzScore(Long zScore) {
		this.zScore = zScore;
	}
	public Topic(Integer id,Long zScore){
		this.id=id;
		this.zScore=zScore;
	}
	public Topic(Integer id){
		this.id=id;
		}
}
public class TrendingTopics {
	
	public static void main(String args[]){
		Comparator<Topic> topicComparator= new Comparator<Topic>() {

			@Override
			public int compare(Topic t1, Topic t2) {
				int res=t2.diff.compareTo(t1.diff);
				if(res==0)
					return t2.getId().compareTo(t1.getId());
				else
					return res;
			}
		};
		
		
		Scanner sc=new Scanner(System.in);
		Integer N=Integer.parseInt(sc.nextLine());
		PriorityQueue<Topic> maxPQ = new PriorityQueue<Topic>(4,topicComparator);
		
		for(int i=0;i<N;i++){
			String input[]=sc.nextLine().split(" ");
			Topic temp=new Topic(Integer.parseInt(input[0]));
			
			long zOld=Long.parseLong(input[1]);
			long zNew=0L;
			long p=Long.parseLong(input[2]);
			long l=Long.parseLong(input[3]);
			long c=Long.parseLong(input[4]);
			long s=Long.parseLong(input[5]);
			zNew=(p*50)+(l*5)+(c*10)+(s*20);
			temp.setzScore(zNew);
			temp.setDiff((zNew-zOld));
			maxPQ.add(temp);
		}
		for(int i=0;i<5;i++)
			System.out.println(maxPQ.poll());
	}

}
