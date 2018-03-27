package com.hackerearth.problems;
//HarryAndPhilosperStone
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class HarryAndPhilosperStone {
   	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		try {
			st = new StringTokenizer(br.readLine());
			Integer N=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Stack<Integer> harry=new Stack<Integer>();
			Stack<Integer> monk=new Stack<Integer>();
			for(int i=0;i<N;i++)
				harry.push(Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
     		Integer q=Integer.parseInt(st.nextToken());
     		Integer x=Integer.parseInt(st.nextToken());
     		System.out.println("----------"+x);
     		Integer sum=0;
     		int i=0;
     		boolean flag=false;
     		while(q>0 && !flag){
     			String command=br.readLine();
     			if(command.equals("Harry")){
     				if(i>=N){
     					flag=false;
     					break;
     				}
     				Integer push=harry.pop();
     				System.out.println("element to be pushed "+push);
     				
     				
     				monk.push(push);
     				
//     				try {
//    					Thread.sleep(210);
//    				} catch (InterruptedException e) {
//    					// TODO Auto-generated catch block
//    					e.printStackTrace();
//    				}
     				sum=sum+push;
     				System.out.println("sum after push "+sum);
     				i++;
     				if(sum.intValue()==x.intValue()){
     					System.out.println(true);
     					flag=true;
     					System.out.println("MATCH FOUND");
     					break;
     				}
     			}else{
     				Integer pop=monk.pop();
    				System.out.println("element to be poped "+pop);
//    				try {
//    					Thread.sleep(210);
//    				} catch (InterruptedException e) {
//    					// TODO Auto-generated catch block
//    					e.printStackTrace();
//    				}
    				sum=sum-pop;
    				System.out.println("sum after pop "+sum);
    				if(sum.intValue()==x.intValue()){
     					System.out.println(true);
     					flag=true;
     					System.out.println("MATCH FOUND");
     					break;
     				}	
     			}
     			q--; 
     		}
     		if(flag){
     			System.out.println(monk.size());
     		}else{
     			System.out.println(-1);
     		}
		
	}catch(Exception e){
		
	}
	}

}
