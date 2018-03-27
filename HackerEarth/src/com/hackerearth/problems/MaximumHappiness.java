package com.hackerearth.problems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MaximumHappiness {
	/*private long[] numbers;
    private long[] helper;

    private int number;

    public void sort(long[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new long[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }

*/
	/*public static void main(String args[]){
	
	//MaximumHappiness sort=new MaximumHappiness();
		Scanner sc=new Scanner(System.in);
		
		long T=sc.nextLong();
		while(T>0){
			int N=(int)sc.nextLong();
			Long[] numbers=new Long[N];
			long negativesum=0;
			boolean flag=false;
			
			for(int i=0;i<N;i++){
				numbers[i]=sc.nextLong();
				if(numbers[i]<=0)
					negativesum+=numbers[i];
				else
					flag=true;
			}
			if(!flag){
				System.out.println(negativesum);
				T--;
				continue;
			}
			Arrays.sort(numbers);
			
			long positvesum=0;
			long k=0;
			int i;
			for(i=N-1;(i>=0 && flag);i--){
				if(numbers[i]>=0){
					positvesum+=numbers[i];
					k++;	
				}else{
					flag=false;
					break;
				}
			}
			if(flag){
				System.out.println(positvesum*k);
				T--;
				continue;
			}
			long Ans=(positvesum*k)+negativesum;
			boolean flag2=true;
			for(int j=i;j>=0 && flag2;j--){
				
				positvesum+=numbers[j];
				negativesum-=numbers[j];
				k++;
				long temp=(positvesum*k)+negativesum;
				Ans=Math.max(temp, Ans);
				if(Ans!=temp){
					flag=false;
				}
				
			}
			System.out.println(Ans);
			T--;
		}

}
*/
public static void main(String args[]){
	File input=new File("/home/prashank/Desktop/input.txt");
	try {
		InputStream stream=new FileInputStream(input);
		Scanner sc=new Scanner(stream);
		long t=sc.nextLong();
		
		while(t>0){
			long n=sc.nextLong();
			long [] a=new long[(int)n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextLong();
			}
			System.out.println(a[(int) (n-1)]);
			Date start=new Date();
			Arrays.sort(a);
			Date end=new Date();
			
			//System.out.println("time start peroid in sec"+(start.getSeconds()));			
			//System.out.println("time peroid in sec"+(end.getSeconds()));
			
			t--;
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
