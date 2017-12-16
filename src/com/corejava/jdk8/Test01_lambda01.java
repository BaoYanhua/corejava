package com.corejava.jdk8;

public class Test01_lambda01 {

	public static void main(String[] args) {
		
		new Runnable() {
			public void run() {
				System.out.println("inner class implements Runnable interface");
				System.out.println("cannot refer variable value, only constant value");
			}
		}.run();
		
		int i=1;
		
		Runnable r=()->{
			System.out.println("Lambda implements Runnable interface");
			System.out.println("although lambda can refer variable value,"
					+ " but still cannot change variable value in Runnable method");
//			i++; //---> cannot accept
			System.out.println("i="+i);
		};
		
		r.run();
		
	}
	
	
}
