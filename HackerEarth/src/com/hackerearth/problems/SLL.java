
//comparison between iterative solutions and recursive solutions
//Christie and friend removal
package com.hackerearth.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//this should be inner class of SLL 
//but for the time being it is separate class
class node{
	private int value;
	node next;
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public node getNext() {
		return next;
	}
	public void setNext(node next) {
		this.next = next;
	}
	public String toString(){
		return ""+this.value;
	}

}
public class SLL {
	node head;
	node tail;
	int size=0;

	public node getHead() {
		return head;
	}
	public void setHead(node head) {
		this.head = head;
	}
	//add is consuming O(size) time, this can be reduced if we maintain tail pointer
	//then time can be reduced to O(1)i.e reference manipulation
	//code needed to be modified for that
	void add(int value){
		node n=new node();
		n.setValue(value);
		n.setNext(null);
		if(this.head==null){
			head=n;
			head.setNext(null);
			tail=head;
		}
		else{
			tail.next=n;
			tail=n;
		}
		size++;
	}

	public node getTail() {
		return tail;
	}
	public void setTail(node tail) {
		this.tail = tail;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	int length(){
		return this.size;
	}

	void printSLL(){
		node temp=this.head;
		while(temp!=null){
			System.out.print(temp.getValue()+" ");
			temp=temp.getNext();
		}
		System.out.println();
	}

	//iterative reverse

	void reverse(){
		if(head==null)return;
		node current=head;
		node next=head.getNext();
		current.setNext(null);
		while(next!=null){
			node temp=next.getNext();
			next.setNext(current);
			current=next;
			next=temp;
		}
		tail=head;
		head=current;
	}
	/*
	 *  DeleteFriend=false
    for i = 1 to Friend.length-1
         if (Friend[i].popularity < Friend[i+1].popularity)
            delete i th friend
            DeleteFriend=true
            break
    if(DeleteFriend == false)
        delete the last friend
	 */
	void deleteFriend(){
		if(head==null)return;
		if(head==tail){
//			System.out.println("inside this head==tail");
			head=tail=null;
			return;
		}
		node del=null;
		node prev=null;
	for(node temp=head;temp.next!=null;){
		if(temp.getValue() < temp.getNext().getValue()){
//			System.out.println("inside temp.getValue() < temp.getNext().getValue");
//			System.out.println("del"+temp.getValue());
			del=temp;
			break;
		}
		prev=temp;
		temp=temp.next;
	}
	
	if(del==head){
//		System.out.println("inside this del==head");
		head=head.next;
		return;
	}
	else if(del==tail || del==null){
	//	    System.out.println("inside this del==tail");
			prev.next=null;
			tail=prev;
			return;
		}
	else if(del!=null){
//		System.out.println("inside del!=null");
//		System.out.println("prev val"+prev.getValue());
//		System.out.println("del val"+del.getValue());
		prev.next=del.next;
	}
		
	
	}
	
	
	

	/*void reverseR(){
		if(head==null)return;
		node current=head;
		node next=head.getNext();
		current.setNext(null);
		recursiveReverse(next, current);
	}*/

	//tail recursive solution
/*	void recursiveReverse(node next,node current){
		if(next==null){
			tail=head;
			head=current;
			return;
		}
		node temp=next.getNext();
		next.setNext(current);
		current=next;
		next=temp;
		recursiveReverse(next,current);
	}*/

public static void main(String args[]){
		
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
			SLL sll=new SLL();
		String nk[]=br.readLine().split(" ");
		int n=Integer.parseInt(nk[0]);
		int k=Integer.parseInt(nk[1]);
		String input[]=br.readLine().split(" ");
		for(int i=0;i<n;i++){
			sll.add(Integer.parseInt(input[i]));
		}
		for(int i=0;i<k;i++){
			sll.deleteFriend();
		}
		sll.printSLL();
		sll=null;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
