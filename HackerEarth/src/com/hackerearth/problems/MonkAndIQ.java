package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


class Course{
	Long c=0L;
	Long z=0L;
	Long iQF=0L;
	Long iQS=0L;
	Long courseNo=0L;

	public Course(Long courseNo){
		this.courseNo=courseNo;
	}
	public Course(Long c,Long IQ,Long courseNo){
		this.c=c;
		this.iQF=IQ;
		this.z=iQF;
		this.courseNo=courseNo;
	}
	public Long getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(Long courseNo) {
		this.courseNo = courseNo;
	}
	public Long getC() {
		return c;
	}
	public void setC(Long c) {
		this.c = c;
	}
	public Long getZ() {
		return z;
	}
	public void setZ(Long z) {
		this.z = z;
	}
	public Long getiQF() {
		return iQF;
	}
	public void setiQF(Long iQF) {
		this.iQF = iQF;
	}
	public Long getiQS() {
		return iQS;
	}
	public void setiQS(Long iQS) {
		this.iQS = iQS;
	}
	public  void calculateZ(){
		if(this.c==1){
			z=this.iQF;
		}else{
			z=(this.c)*(this.iQF+this.iQS);
		}
	}
	public void setNewIQS(Long newQ){
		if(this.c==0){
			this.iQF=newQ;
			this.c=this.c+1;
		}
		else if(this.c==1){
			this.iQS=newQ;
			this.c=this.c+1;
		}else{
			this.iQF=this.iQS;
			this.iQS=newQ;
			this.c=this.c+1;
		}
	}
	
	@Override
	public String toString() {
		return this.courseNo+"";
	}
}
public class MonkAndIQ {

	public static void main(String args[]){
		String input[]=null;
		int i=0;
		try{
			
			
			Comparator<Course> courseComparator= new Comparator<Course>() {

				@Override
				public int compare(Course c1, Course c2) {
					int res=c1.z.compareTo(c2.z);
					if(res==0)
						return c1.courseNo.compareTo(c2.courseNo);
					else
						return res;
				}
			};
			
			PriorityQueue<Course> minPQ = new PriorityQueue<Course>(5,courseComparator);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input=br.readLine().split(" ");
			int C=Integer.parseInt(input[0]);//Courses
			int P=Integer.parseInt(input[1]);//Monk and his p-1 friends
			int N=Integer.parseInt(input[2]);//Student before monk and his friends
			
			input=br.readLine().split(" ");
			for( i=1;i<=N;i++){
				minPQ.add(new Course(1L, Long.parseLong(input[i-1]), (long)(i)));
			}
			if(N<C){
				for(i=N+1;i<=C;i++){
					minPQ.add(new Course((long)(i)));
				}
			}

			input=br.readLine().split(" ");
			StringBuffer buffer=new StringBuffer("");
			
			for(i=1;i<=input.length;i++){
				Course c=minPQ.poll();
				buffer.append(c.getCourseNo()+" ");
				c.setNewIQS(Long.parseLong(input[i-1]));
				c.calculateZ();
				minPQ.add(c);
			}
            for(i=input.length+1;i<=P;i++){
            	Course c=minPQ.poll();
				buffer.append(c.getCourseNo()+" ");
				c.setNewIQS(0L);
				c.calculateZ();
				minPQ.add(c);
            }
			System.out.println(buffer.toString());
		}catch(Exception e){
		System.out.println(input[i]);
			e.printStackTrace();
		}
	}

}
