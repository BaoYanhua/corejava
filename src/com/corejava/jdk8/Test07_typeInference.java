package com.corejava.jdk8;

public class Test07_typeInference<T> {

	public static  <T>  T defaultValue() {
		return null;
	}
	
	public T getOrDefault ( T value, T defaultValue) {
		return (value != null) ? value : defaultValue ;
	}
	
	public static void main(String[] args) {
		final Test07_typeInference<String> value = new Test07_typeInference<>();
		value.getOrDefault("22", Test07_typeInference.defaultValue());
	} 
	
}
