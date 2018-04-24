package com.corejava.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test03_lambda_paramList {

	public static void main(String[] args) {
//		系统会自动推断出e的类型
		Arrays.asList("a","b","c").forEach(e -> System.out.println(e));
	
		Arrays.asList("aa","bb","cc").forEach((String e) -> System.out.println(e));
		
		Arrays.asList("q","w","e").forEach(e -> {
//			函数体
			System.out.println(e);
		});
		
//		Lambda可以引用类的成员变量与局部变量（如果这些变量不是Final的话， 它们会被隐含的转为final，这样效率更高）
		String separator =",";
		Arrays.asList("a","b","c").forEach(e -> System.out.println(e+separator));
		
//		Lambda 实现排序
		Integer[] list = {3,7,2,3,1,10,4,8};
		Arrays.stream(list).forEach(e->System.out.print(e+","));
		Arrays.asList(list).sort((e1,e2) -> e1.compareTo(e2));
		System.out.println();
		Arrays.stream(list).forEach(e->System.out.print(e+","));
		Arrays.asList(list).sort((e1,e2) -> {
			if(e1<e2) {
				return 1;
			}else if(e1 > e2) {
				return -1;
			}else {
				return 0;   
			}
		});
		System.out.println();
		Arrays.stream(list).forEach(e->System.out.print(e+","));

		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(5);
		arrayList.add(3);
		arrayList.add(8);
//		Arrays.sort(arrayList);
//		arrayList.forEach(e->System.out.println(e));
	}
	
	
	
}
