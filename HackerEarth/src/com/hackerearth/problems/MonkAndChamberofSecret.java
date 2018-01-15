package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Elements{
	int value;
	int position;
	Elements(int value,int position){
		this.value=value;
		this.position=position;
	}
	public String toString(){
		return String.valueOf("("+this.position+","+this.value+")");
	}
}

public class MonkAndChamberofSecret {

	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		try {
			st=new StringTokenizer(br.readLine());

			int n=Integer.parseInt(st.nextToken());

			int x=Integer.parseInt(st.nextToken());

			st=new StringTokenizer(br.readLine());

			Queue <Elements>queue=new LinkedList<Elements>();

			for(int i=0;i<n;i++){
				queue.add(new Elements(Integer.parseInt(st.nextToken()),i+1));
			}


			int found=0;

			while(found<x){
				//System.out.println("---------------"+(found+1)+"-------------");
				Queue <Elements>popedQueue=new LinkedList<Elements>();
				//	System.out.println("Element inside Queue : "+queue);
				Elements max=new Elements(-1,-1);

				for(int i=0;i<x && !queue.isEmpty();i++){
					Elements j=queue.poll();
					if(j.value>max.value){
						max.value=j.value;
						max.position=j.position;
					}
					popedQueue.add(new Elements(j.value,j.position));
				}

				//	System.out.println("popped Queue :"+popedQueue);

				int size=popedQueue.size();

				//System.out.println("Pushing elements back : from poped Queue of size "+size);

				for(int i=0;i<size;i++){
					Elements j=	popedQueue.poll();
					if(j.position==max.position){
						//			System.out.println("this is the max elemets not pushing it back"+j);
					}else{
						int value=-1;
						if(j.value!=0){
							value=j.value-1;
						}else{
							value=j.value;
						}
						//		System.out.println("Element added in parent Queue : "+j.position+","+value);
						queue.add(new Elements(value,j.position));
					}
				}
				//System.out.println("Queue after round : "+(found+1)+" is :"+queue);

				System.out.print(max.position+" ");
				//System.out.println("+++++++++++++++++"+(found+1)+"+++++++++++++++");
				found++;
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
