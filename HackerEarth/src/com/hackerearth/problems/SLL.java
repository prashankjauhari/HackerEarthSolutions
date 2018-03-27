
//comparison between iterative solutions and recursive solutions
//Christie and friend removal
package com.hackerearth.problems;
import java.io.BufferedReader;
import java.io.FileInputStream;
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


	void reverseR(){
		if(head==null)return;
		node current=head;
		node next=head.getNext();
		current.setNext(null);
		recursiveReverse(next, current);
	}
 
	//tail recursive solution
	void recursiveReverse(node next,node current){
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
	}
 
	public static void main(String args[]){
		SLL sll=new SLL();
		for(int i=0;i<20000;i++){
			sll.add(i);
		}
		
	}
}