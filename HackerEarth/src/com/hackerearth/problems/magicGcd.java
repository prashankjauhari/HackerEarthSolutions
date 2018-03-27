package com.hackerearth.problems;

import java.util.ArrayList;
import java.util.Scanner;

public class magicGcd {

	
	
	
	
	
	

	static long val(char c)
	{
	    if (c >= '0' && c <= '9')
	        return (int)c - '0';
	    else
	        return (int)c - 'A' + 10;
	}
	
	static char reVal(long num)
	{
	    if (num >= 0 && num <= 9)
	        return (char)(num + '0');
	    else
	        return (char)(num - 10 + 'A');
	}
	//any base to decimal
	static long toDeci(String number, long base)
	{
		long len =number.length() ;
		long power = 1; // Initialize power of base
		long num = 0;  // Initialize result
		long i;

		
	    // Decimal equivalent is str[len-1]*1 +
	    // str[len-1]*base + str[len-1]*(base^2) + ...
	    for (i = len - 1; i >= 0; i--)
	    {
	        // A digit in input number must be
	        // less than number's base
	        if (Long.parseLong(""+number.charAt((int) i)) >= base)
	        {
	           System.out.println("Invalid Number");
	           return -1;
	        }
	        num =(num + Long.parseLong(""+number.charAt((int) i)) * power)%1000000007;
	        power = (power * base)%1000000007;
	        
	    }
	    return num;
	}
	
	static String strev(String number)
	{
		StringBuilder str=new StringBuilder(number);
		long len = str.length();
		
		long i;
	    for (i = 0; i < len/2; i++)
	    {
	        char temp = str.charAt((int) i);
	        str.setCharAt((int) i,str.charAt((int) (len-i-1)));
	        str.setCharAt((int) (len-i-1), temp);
	    }
		
	    return str.toString();
	}
	
	static String fromDeci(int base, long inputNum)
	{
		ArrayList<Character>list=new ArrayList<Character>();
	    int index = 0;  // Initialize index of result
	 
	    // Convert input number is given base by repeatedly
	    // dividing it by base and taking remainder
	    while (inputNum > 0)
	    {
	        list.add(reVal(inputNum % base));
	        inputNum /= base;
	    }
	    StringBuilder res = new StringBuilder(list.size());
	    for (Character c : list) {
	    	  res.append(c);
	    	}
	    return strev(res.toString());
	}
	
	static StringBuilder F(long a,long b){
		long c=(a%b);
		if(c==0){
			StringBuilder res=new StringBuilder();
			res.append('1');
			for(int i=0;i<a-1;i++)
				res.append('0'); 
			return res;
		}else{
		 StringBuilder P=F(b,(a%b));
		 StringBuilder res=new StringBuilder();
			for(int i=0;i<a;i++){
				res.append(P.charAt(i%P.length()));
			}
			return res;
		}
	}
	static long g(long a,long b){
		StringBuilder res=F(a,b);
		
		return magicGcd.toDeci(res.toString(), 2);
	}
	
		public static void main(String args[]){
		 
			Scanner sc=new Scanner(System.in);
			long testcase=Long.parseLong(sc.nextLine());
			while(testcase-->0)
			System.out.println(g(sc.nextLong(), sc.nextLong()));
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	static long power(long x, long y, long p)
	{
	    long res = 1;      // Initialize result
	 
	    x = x % p;  // Update x if it is more than or 
	                // equal to p
	    while (y > 0)
	    {
	        // If y is odd, multiply x with result
	        if (y%2!=0)
	            res = (res*x) % p;
	 
	        // y must be even now
	        y = y>>1; // y = y/2
	        x = (x*x) % p;  
	    }
	    return res;
	}
	//any base to decimal
	static long toDeci(long a, long res)
	{


		long len=magicGcd.len(res);
		
		long result = 0;

		while(res !=0)
		{   
		  result  <<= 1;
		  result  |= res & 1;
		  res >>=1;
		}
		res=result;
		long num = 0;  // Initialize result
		long i;
		
		for (i =0; i<a; i++)
	    {    
			long index=(i%len);
			//System.out.println("index : "+index);
			if((res & (1L << (index)))>0){
				//System.out.println("i"+i);
			num=num%1000000007+magicGcd.power(2, i, 1000000007);
			}
	    }
	    return num;
	}
	


	static long F(long a,long b){
		long c=(a%b);
		if(c==0){
		//	System.out.println("for (a,b)"+"("+a+","+b+")"+magicGcd.power(2, --a,1000000007));
			return magicGcd.power(2, a-1,1000000007);
	
		}else{
			long res =F(b,(a%b));
			return magicGcd.toDeci(a, res);
		}
	}
	static long g(long a,long b){
		long res=F(a,b);
		return res;
	}
	
	static long len(long x){
		long ct=0;
		while (x > 1) { 
			ct++; 
			x = x >> 1;
		}
		x = x << ct;
		return ct+1;
	}

	public static void main(String args[]){	
	 BitSet set=new BitSet(1226833920);
	 System.out.println(set.size());

	}*/
} 
