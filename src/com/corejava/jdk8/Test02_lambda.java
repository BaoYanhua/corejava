package com.corejava.jdk8;

public class Test02_lambda {

	public static void main(String[] args) {
		new Action() {

			@Override
			public void execute(String content) {
				System.out.println(content);
				
			}
		}.execute("before jdk 1.8, inner class implements method");
		
		Action action=(String context)->{
			System.out.println(context);
		};
		
		action.execute("lambda implements inner class method");
	}
	
	static interface Action{
		void execute(String content);
	}
	
}
