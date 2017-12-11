package com.corejava.jdk8;

import java.util.Arrays;

public class Test03_lambda_paramList {

	public static void main(String[] args) {
//		系统会自动推断出e的类型
		Arrays.asList("a","b","c").forEach(e -> System.out.println(e));
	
		Arrays.asList("aa","bb","cc").forEach((String e) -> System.out.println(e));
		
		Arrays.asList("q","w","e").forEach(e -> {
//			函数体
			System.out.println(e);
			System.out.println(e);
		});
		
//		Lambda可以引用类的成员变量与局部变量（如果这些变量不是Final的话， 它们会被隐含的转为final，这样效率更高）
		String separator =",";
		Arrays.asList("a","b","c").forEach(e -> System.out.println(e+separator));
		
//		Lambda返回一个值，返回类型由编译器推测
		System.out.println("Lambda返回一个值，返回类型由编译器推测");
		Arrays.asList(1,2,3).sort((e1,e2) -> e1.compareTo(e2));
		Arrays.asList(1,2,3).sort( (e1, e2) -> {
			int result = e1.compareTo(e2);
			System.out.println(result);
			return result;
		}) ;
	
	}
	
	
	
}
