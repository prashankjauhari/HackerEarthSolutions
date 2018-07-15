package com.threads.programme;

import java.util.LinkedList;
import java.util.List;

public class AccessTest {
	
	private static String className="AccessTest";
	
	public static void setClass(String abc){

		synchronized (AccessTest.class){
			System.out.println("Thread that holds the lock is "+Thread.currentThread().getName());
			System.out.println("className changes from "+AccessTest.className+" to "+abc);
			AccessTest.className=abc;
		}
	}
	
	public static String getClassName(){
		return AccessTest.className;
	}
	
	synchronized void abc(){
		try {
			System.out.println("Thread inside abc "+Thread.currentThread().getName());
			Thread.sleep(2000);
			this.wait();
			System.out.println("Thread going out "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		
   List<AccessTest> accessTest=new LinkedList<AccessTest>();
   Runnable run= new Runnable() {
	
	@Override
	public void run() {
		AccessTest.setClass(Thread.currentThread().getName());
	}
};
   for(int i=0;i<10;i++){
	   accessTest.add(new AccessTest());
   }
   for(int i=0;i<10;i++){
	   Thread th=new Thread(run);
	   th.start();
   }

   AccessTest acc=accessTest.get(0);
   acc.setClass(Thread.currentThread().getName());

   
}
}
