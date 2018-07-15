package com.threads.programme;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Task implements Runnable   
{
    private String name;
     
    public Task(String s)
    {
        name = s;
    }
     
    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    public void run()
    {
        try
        {
            for (int i = 0; i<=5; i++)
            {
                if (i==0)
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization Time for"
                            + " task name - "+ name +" = " +ft.format(d));   
                    //prints the initialization time for every task 
                }
                else
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - "+
                            name +" = " +ft.format(d));   
                    // prints the execution time for every task 
                }
                Thread.sleep(1000);
            }
            System.out.println(name+" complete");
        }
         
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
public class ThreadPoolTest {

	public static void main(String args[]){
		    Runnable r1 = new Task("task 1");
	        Runnable r2 = new Task("task 2");
	        Runnable r3 = new Task("task 3");
	        Runnable r4 = new Task("task 4");
	        Runnable r5 = new Task("task 5");      
	        
	        ThreadPoolExecutor p = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
	        System.out.println("when no task in pool "+p.getPoolSize());
	        
	        p.execute(r1);
	        System.out.println("when one task in pool "+p.getPoolSize());
	        p.execute(r2);
	        System.out.println("when two task in pool "+p.getPoolSize());
	        p.shutdown();
	}
}
