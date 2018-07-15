package com.threads.programme;

/**
 * A sample programme to demonstrate the 
 * use of count down latch is java.
 * @author prashank
 *
 */
public class CountDownLatch{
	
	private static java.util.concurrent.CountDownLatch counter=new java.util.concurrent.CountDownLatch(2);
	
	public static String name="abc";
	public static void main(String[] args){
		
		//this line will get the initial value of counter
		System.out.println("initial value of counter : "+counter.getCount());
		
			Thread marketRateService=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("initializing market rates,wait for four seconds.\n");
					Thread.sleep(4000);
					counter.countDown();
					System.out.println("market rate initilize.\n");
				} catch (InterruptedException e){
					System.out.println("Market rate service gets intrupted.\n");
				}
			}
		}, "marketRateService");
		Thread coinInitService=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("initializing coins,wait for 1 seconds.\n");
					Thread.sleep(1000);
					counter.countDown();
					System.out.println("All coins nodes successfully started.\n");
				} catch (InterruptedException e){
					System.out.println("Market coin init service intrupted.\n");
				}
			}
		}, "coinInitService");
		
		System.out.println("Both threads are running parallely and will decrement the counter once they done.\n");
		marketRateService.start();
		coinInitService.start();
		try {
			System.out.println("Main Thread is waiting to reach countDownLatch counter to reach 0.\n");
			counter.await();
			System.out.println("Market initilize successfully and coin nodes started  completed successfully.\n");
			System.out.println("starting Exchange server.\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
}