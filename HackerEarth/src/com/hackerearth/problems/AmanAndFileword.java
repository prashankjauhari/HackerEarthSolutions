package com.hackerearth.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Order {
	public int i;
	public int ti;
	public int di;
	
	public Order(int i,int ti,int di){
		this.i=i;
		this.ti=ti;
		this.di=di;
	}
	public Order(){}

	@Override
	public String toString(){
		return (this.i+" ");
	}
	
}
public class AmanAndFileword {
	
	
	
	public static void main(String args[]){

		
		Comparator<Order> com=	new Comparator<Order>(
				) {
					@Override
					public int compare(Order o1, Order o2) {
						if(o1.ti<=o2.ti){
							int diff=o2.ti-o1.ti;
							return Integer.compare(o1.di, (o2.di+diff));
						}else{
							int diff=o1.ti-o2.ti;
							return Integer.compare((o1.di+diff), o2.di);
						}
					}
		};
		
		
		ArrayList<Order> orders=new ArrayList<Order>();
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		
		for(int i=1;i<=n;i++){
			String rest[]=sc.nextLine().split(" ");
			Order o=new Order(i, Integer.parseInt(rest[0]), Integer.parseInt(rest[1]));
			orders.add(o);
		}
		
		Collections.sort(orders,com);
		
		for(Order myorder:orders){
			System.out.print(myorder);
		}
		sc.close();

	
	}

}
