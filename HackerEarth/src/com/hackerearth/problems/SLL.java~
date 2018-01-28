
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
	node prev;
	public node getPrev() {
		return prev;
	}

	public void setPrev(node prev) {
		this.prev = prev;
	}

	public int getValue() {
		return value;
	}
	
	node(){};
	node(int n){
		this.value=n;
		this.next=null;
		this.prev=null;
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

	void add(int value){
		node n=new node();
		n.setValue(value);
		n.setNext(null);
		if(this.head==null){
			head=n;
			head.setNext(null);
			head.setPrev(null);
			tail=head;
		}
		else{
			n.setPrev(tail);
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

	StringBuilder printSLL(){
		StringBuilder buff = new StringBuilder();
		node temp=this.head;
		while(temp!=null){
			buff.append(temp.getValue()+" ");
			temp=temp.getNext();
		}
		buff.append('\n');
		return buff;
	}

	void deleteFriend(){
		if(head==null)return;
		if(head==tail){
			head=tail=null;
			return;
		}
		node del=null;
		node prev=null;
		for(node temp=head;temp.next!=null;){
			
			if(temp.getValue() < temp.getNext().getValue()){
				del=temp;
				break;
			}
			prev=temp;
			temp=temp.next;
		}

		if(del==head){
			head=head.next;
			return;
		}
		else if(del==tail || del==null){
			prev.next=null;
			tail=prev;
			return;
		}
		else{
			prev.next=del.next;
		}
		size--;
	}
//
	node deleteFriend(node lastdeleted){
		if(head==null)return null;
		if(head==tail){
			head=tail=null;
			return null;
		}
		node del=null;
		for(node temp=lastdeleted;temp.next!=null;){
			
			if(temp.getValue() < temp.getNext().getValue()){
				del=temp;
				break;
			}
			temp=temp.next;
		}

		if(del==head){
			head=head.next;
			head.setPrev(null);
			size--;
			return head;
		}
		else if(del==tail || del==null){
			tail=tail.prev;
			tail.next=null;
			size--;
			return tail;
		}
		else{
			node prev=del.prev;
			node next=del.next;
			prev.setNext(next);
			next.setPrev(prev);
			size--;
			return prev;
		}
	}



	public static void main(String args[]){
		

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder buff = new StringBuilder("");
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
				node info=sll.head;
				for(int i=0;i<k;i++){
					info=sll.deleteFriend(info);
				}
				buff.append(sll.printSLL());
				sll=null;
			}

			System.out.println(buff);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

