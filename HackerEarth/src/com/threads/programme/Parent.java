package com.threads.programme;

public final class Parent {

	static int a=123;
	int b;
	static class child{
		
		public int agetParentA(){
			return a;
		}
		public void setAgetParentA(int a){
			Parent.a=a;
		}
	}
	public static void main(String args[]){
	}
}
