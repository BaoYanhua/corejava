package com.corejava.jdk8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test09_Parameter {

	public static void main(String[] args) throws Exception{
		//JDK8中， 打开-parameter 设置， 通过以下，就可以得到正确的parameter 名字。 
		//打开方式 Project->properity->compile->store information about method parameter
		//或者在maven <plugin><configuration><compilerArgument>-parameters
		Method method = Test09_Parameter.class.getMethod("main", String[].class);
		for(final Parameter parameter:method.getParameters()) {
			System.out.println("Parameter: "+parameter.getName());
		}
	}
	
}
