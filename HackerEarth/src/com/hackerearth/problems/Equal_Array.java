package com.hackerearth.problems;
import java.util.Scanner;

class TestClass {
        public static long lcm_of_array_elements(int[] element_array)
    {
        long lcm_of_array_elements = 1;
        int divisor = 2;
        while (true)
        {
            int counter = 0;
            boolean divisible = false;
            for (int i = 0; i < element_array.length; i++)
            {
                 // lcm_of_array_elements (n1,n2,... 0) = 0.
                 // For negative number we convert into
                 // positive and calculate lcm_of_array_elements.
                 
                if (element_array[i] == 0)
                {
                    return 0;
                }
                else if (element_array[i] < 0)
                {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1)
                {
                    counter++;
                }
                 // divide element_array by devisor if complete division i.e. without
                 // remainder then replace number with quotient; used for find
                 // next factor
                if (element_array[i] % divisor == 0)
                {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }
            
             // If divisor able to completely divide any number from array
             // multiply with lcm_of_array_elements and store into lcm_of_array_elements 
             // and continue to same divisor
             // for next factor finding. else increment divisor
              
            if (divisible)
            {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else
            {
                divisor++;
            }
         
             // Check if all element_array is 1 indicate we found all factors and
             // terminate while loop.
  
            if (counter == element_array.length)
            {
                return lcm_of_array_elements;
            }
        }
    }
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
	    int multiplier[]=new int[3];
		int testcase=sc.nextInt();
	   while(testcase>0){

		   int n=sc.nextInt();
		   multiplier[0]=sc.nextInt();
		   multiplier[1]=sc.nextInt();
		   multiplier[2]=sc.nextInt();
		   
		   int lcm=(int)TestClass.lcm_of_array_elements(multiplier);
		   int array[]=new int[n];
		   boolean flag=false;
		   for(int i=0;i<n;i++){
			   array[i]=sc.nextInt();
			   if((array[i]%lcm==0) ||(lcm%array[i]==0)){
				   flag=true;
			   }else{
				   System.out.println("She can't");
				   flag=false;
				   break;
			   }
		   }
		   if(flag){
			   System.out.println("She can");
		   }
		   testcase--;
	   }
	   
	}
}