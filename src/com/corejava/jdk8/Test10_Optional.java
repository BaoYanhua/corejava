package com.corejava.jdk8;

import java.util.Optional;

public class Test10_Optional {

	public static void main(String[] args) {
		Optional<String> fullName = Optional.ofNullable(null);
		//fullName 非空的话， fullName.isPresent() 返回true.
		System.out.println("Full Name is set ? " + fullName.isPresent());
		//为了防止Optional为空值，orElseGet()方法通过回调函数来产生一个默认值
		System.out.println("Full Name: "+fullName.orElseGet(()->"[none]"));
		//map函数对当前Optiaonal的值进行转化，然后返回一个新的Optional 实例。
		//orElse()方法返回默认值orElseGet()用回调函数返回值
		System.out.println(fullName.map(s-> "Hey "+s+"!").orElse("Hey Stranger!"));
		
		
		Optional<String> firstName = Optional.of("Tom");
		System.out.println("First Name is Set ? "+firstName.isPresent());
		System.out.println("First Name : "+firstName.orElseGet(()->"[none]"));
		System.out.println(firstName.map(s -> "Hey "+s+"!").orElse("Hey Stranger!"));
		
	}
	
}
