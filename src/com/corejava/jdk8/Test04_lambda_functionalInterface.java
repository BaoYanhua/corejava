package com.corejava.jdk8;

import java.util.function.Supplier;

public class Test04_lambda_functionalInterface {

	public static void main(String[] args) {
		Defaulable defaulable = DefaulableFactory.create(DefaultableImpl :: new);
		System.out.println(defaulable.notRequired());
		
		defaulable = DefaulableFactory.create(OverridableImpl::new);
		System.out.println(defaulable.notRequired());
		
		OverrideMethod defaulableMethod = new OverrideMethod();
		System.out.println(defaulableMethod.defaultMethod());
		System.out.println(defaulableMethod.notRequired());
		
		//*******lambda 表达式调用非Functional Interface 方法
//		NonFunctionalInterfaceLambda call =()-> {
//			System.out.println("非Functional Interface 方法使用Lambda");
//		};
//		call.testLambdaExpress();
//		The target type of this expression must be a functional interface
		
		//*******lambda 表达式调用Functional Interface 方法
		FunctionalDefaultMethods call =()-> {
			System.out.println("override funcitonal interface method");
		};
		call.method();
	}
	
	
	
	@FunctionalInterface
	public interface Functional{
		void method();
	}
	
	@FunctionalInterface
	public interface FunctionalDefaultMethods{
//		有此仅有一个抽象方法，这样这个接口才能作为Functional Interface
		void method();
//		默认方法包括到唯一 Functional Interface 方法中
		default void defaultMethod() {
			System.out.println("functional interface default method");
		}
//		java.lang.Object 中的public可以在Funcational Interface中
		String toString();
		
		boolean equals(Object o);
//		clone() 是java.lang.Object中的protected方法，不可以在Functional Interface中
//		Object clone();
		
	}
	
	public static class FunctionalDefaultMehodsImpl implements FunctionalDefaultMethods{

		@Override
		public void method() {
			System.out.println("lambda call function interface method");
		}
		
		@Override
		public void defaultMethod() {
			System.out.println("lambda call function interface default method");
		}
		
	}
	
//	JDK8 实现default接口，实现类可以override or not
	private interface Defaulable {
//		INterfaces now allow default methods, the implementer may or
//		may not implement(Override) them
		default String notRequired() {
			return "Default Implementation";
		}
	}
	
	private static class DefaultableImpl implements Defaulable {
		
	}
	
	private static class OverridableImpl implements Defaulable {
		@Override
		public String notRequired() {
			return "Overridden implementation";
		}
		
	}
	
	private interface DefaulableMethod {
		default String defaultMethod() {
			return "DefaulableMethod Implementation";
		}
	}
	
	private static class OverrideMethod implements Defaulable,DefaulableMethod {
		@Override
		public String notRequired() {
			return "Overridden implemention";
		}
		
//		@Override
//		public String defaultMethod() {
//			return "Overridden defaultMethod implementation";
//		}
	}
	
	//接口可以声明（并提供实现）静态方法
	private interface DefaulableFactory {
		//Interfaces now allow static methods
		static Defaulable create(Supplier <Defaulable> supplier) {
			return supplier.get();
		}
	}
	
	private interface NonFunctionalInterfaceLambda{
		void testLambdaExpress();
		void testLambdaExpress2();
	}
	
	public class NonFunctionalInterfaceLambdaImpl implements NonFunctionalInterfaceLambda{

		@Override
		public void testLambdaExpress() {
			System.out.println("Lambda Call NonFunctionalInterface Method");
		}

		@Override
		public void testLambdaExpress2() {
			System.out.println("Lambda Call NonFunctionalInterface Method2");
		}
		
	}
	
}
