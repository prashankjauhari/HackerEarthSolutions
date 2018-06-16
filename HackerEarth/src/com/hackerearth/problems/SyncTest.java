package com.hackerearth.problems;

class SyncContainer{

	private int value;

	private boolean canWrite=true;

	synchronized void put(int value) throws InterruptedException{
		if(!canWrite){
			wait();//waiting ,so that it gets the notification that it can set the new value for consumption
		}
		this.value=value;
		this.canWrite=!this.canWrite;
		System.out.println(Thread.currentThread().getName()+" Produce "+value);
		notifyAll();//notification for the consumer to consume newly created value
	}

	synchronized int get() throws InterruptedException{
		if(canWrite){
			wait();//waiting ,so that it can consumed new value
		}
		this.canWrite=!canWrite;
		notifyAll();//notification for producer to producer new value
		System.out.println(Thread.currentThread().getName()+" consumed "+value);
		return this.value;
	}
}

class Producer implements Runnable{

	private SyncContainer container;

	public Producer(SyncContainer container){
		this.container=container;
	}

	@Override
	public void run() {
		for(int i=0;i<9;i++){
			try {
				container.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

class Consumer implements Runnable{
	private SyncContainer container;

	public  Consumer(SyncContainer container) {
		this.container=container;
	}

	@Override
	public void run() {
		for(int i=0;i<9;i++){
			try {
				container.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

public class SyncTest{
	public static void main(String args[]){

		SyncContainer container=new SyncContainer();
		Thread pro=new Thread(new Producer(container),"Producer");
		Thread con=new Thread(new Consumer(container),"Consumer");
		pro.start();
		con.start();
		try {
			pro.join();
			con.join();
			//main thread waiting for both thread to return
			System.out.println("Both returned");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}