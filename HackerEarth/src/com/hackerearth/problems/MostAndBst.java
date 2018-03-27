package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MostAndBst {
	
	public static double logb( double a, double b )
	{
	return Math.log(a) / Math.log(b);
	}
	
	public static double QueryT1(double x,double k,double L){
		double l=Math.floor(MostAndBst.logb(k, 2))+1;
		double a=Math.ceil(x+Math.pow(2,(L-l-1))-1);
		double d=Math.pow(2, L-l);
		double n=k-Math.pow(2,l-1)+1;
		return (a+(n-1)*d);
	}
	
	public static int X(long S,long L){
		long eq=(long)Math.pow(2, L)-1;
		if(L>1){
		long max_index=(long)Math.pow(2, L-1)-1;
		long offset= ((max_index-1)*max_index)/2;
		offset=2*offset+max_index;
		S=S-offset;
		}
		boolean flag=true;
		int i=1;
		while(flag){
			if(eq*i>S){
				flag=false;
                 break;
			}
			i++;
		}
     return i;
	}
	public static Long right(long root,long L){
		if(L==2)
			return root+1;
		else if(L==1)
			return null;
		else{
			return root+(long)Math.pow(2, L-3);
		}
	}
	public static Long left(long root,long L){
		if(L==2)
			return root;
		else if(L==1)
			return null;
		else{
			return root-(long)Math.pow(2, L-3);
		}
	}
	
	
	public static String path(Long val,double x,double k,double L){
		
		long root=(long)MostAndBst.QueryT1(x, k, L);
	//	System.out.println("root"+root);
		if(root==val)
			return "root";
		
		StringBuffer path=new StringBuffer("");
		long i=(long)L;
		while(true){
			if(val>root){
	
				root=MostAndBst.right(root,i);
				path.append('r');
				i--;
			}else if(val<root){
				root=MostAndBst.left(root, i);
				i--;
				path.append('l');
			}else{
				return path.toString();
			}
		}
	}
	
	
	
	public static void main(String args[]){
				try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String LS[]=br.readLine().split(" ");
			long x=(long)MostAndBst.X(Long.parseLong(LS[1]), Long.parseLong(LS[0]));
			Long Q=Long.parseLong(br.readLine());
			   while(Q-->0){
				   //System.out.println("aa");
				   String q[]=br.readLine().split(" ");
				   if(q[0].equals("0")){
					   System.out.println(MostAndBst.path(Long.parseLong(q[1]), x, 1, Long.parseLong(LS[0])));
				   }else{
					 System.out.println((long)MostAndBst.QueryT1(x, Long.parseLong(q[1]), Long.parseLong(LS[0])));  
				   }
			   }
			}catch(Exception e){
				
				e.printStackTrace();
			}
	}
}
