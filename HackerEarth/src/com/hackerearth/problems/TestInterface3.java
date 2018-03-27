package com.hackerearth.problems;

interface Printable{  
	default void print(){System.out.println("Show able print");};  
}  
interface Showable{  
default void print(){
	System.out.println("Showable print");
};  
}  
  
class TestInterface3 implements Printable, Showable{  
//public void print(){System.out.println("Hello");}  
public static void main(String args[]){  
TestInterface3 obj = new TestInterface3();  
Printable pr=(Printable)obj;
pr.print();  
obj.print();

Showable show=(Showable)obj;
show.print();
 }

@Override
public void print() {
	Printable.super.print();
}

}  

