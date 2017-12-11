package com.corejava.jdk8;

import java.util.function.Supplier;

public class Test04_lambda_functionalInterface {

	public static void main(String[] args) {
		Defaulable defaulable = DefaulableFactory.create(DefaultableImpl :: new);
		System.out.println(defaulable.notRequired());
		
		defaulable = DefaulableFactory.create(OverridableImpl::new);
		System.out.println(defaulable.notRequired());
	}
	
	@FunctionalInterface
	public interface Functional{
		void method();
	}
	
	@FunctionalInterface
	public interface FunctionalDefaultMehods{
		void method();
		default void defaultMethod() {
			
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
		
		@Override
		public String defaultMethod() {
			return "Overridden defaultMethod implementation";
		}
	}
	
	//接口可以声明（并提供实现）静态方法
	private interface DefaulableFactory {
		//Interfaces now allow static methods
		static Defaulable create(Supplier <Defaulable> supplier) {
			return supplier.get();
		}
	}
	
}
