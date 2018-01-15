
//comparison between iterative solutions and recursive solutions
package com.hackerearth.problems;

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

}
public class SLL {
	node head;
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
		}
		else{
			node temp=this.head;
			while(temp.getNext()!=null){
				temp=temp.getNext();
			}
			temp.setNext(n);
		}
		size++;
	}

	int length(){
		return this.size;
	}

	void printSLL(){
		node temp=this.head;
		while(temp!=null){
			System.out.println(temp.getValue());
			temp=temp.getNext();
		}
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

		for(int i=1;i<=200000;i++)
			sll.add(i);

		long start=System.currentTimeMillis();
		//		sll.reverseR();
		long end=System.currentTimeMillis();
		//		System.out.println("recursing reverse took"+(end-start));

		start=System.currentTimeMillis();
		sll.reverse();
		end=System.currentTimeMillis();
		System.out.println("iterative reverse took"+(end-start));

		sll.printSLL();

		System.out.println("size of sll :"+sll.length());

	}
}
