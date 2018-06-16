
public class SyncTest {

	Object lock1=new Object();
	Object lock2=new Object();
	Object lock3=new Object();
	
	public void A(){
		synchronized (lock1) {
				System.out.println(Thread.currentThread().getName()+" called A");
			System.out.println("Sleeping");
			try {
				Thread.sleep(6000);
				System.out.println(Thread.currentThread().getName()+" end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void B(){
		synchronized (lock2) {
			System.out.println(Thread.currentThread().getName()+" called B");
			System.out.println("Sleeping");
			try {
				Thread.sleep(6000);
				System.out.println(Thread.currentThread().getName()+" end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void C(){
		synchronized (lock3){
			
			System.out.println(Thread.currentThread().getName()+" called C");
			System.out.println("Sleeping");
			try {
				Thread.sleep(6000);
				System.out.println(Thread.currentThread().getName()+" end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String args[]){
		SyncTest test=new SyncTest();
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				test.A();
			}
		};
	Runnable r1=new Runnable() {
			
			@Override
			public void run() {
				test.B();
			}
		};
	Runnable r2=new Runnable() {
			
			@Override
			public void run() {
				test.C();
			}
		};
		
		Thread t[]=new Thread[8];
		
		t[0]=new Thread(r,"Thread0");
		t[1]=new Thread(r1,"Thread1");
		t[2]=new Thread(r2,"Thread2");
		t[3]=new Thread(r1,"Thread3");
		t[4]=new Thread(r2,"Thread4");
		t[5]=new Thread(r1,"Thread5");
		t[6]=new Thread(r2,"Thread6");
		t[7]=new Thread(r1,"Thread7");
		System.out.println("main theread waiting");
		for(int i=0;i<t.length;i++){
			t[i].start();
		}
		
		for(int i=0;i<t.length;i++){
			try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("main theread waiting end");
	}
}
