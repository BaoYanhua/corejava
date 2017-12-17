package com.corejava.jdk8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test13_Nashorn {

	public static void main(String[] args) {
//		Nashorn，一个新的JavaScript引擎随着Java 8一起公诸于世，它允许在JVM上开发运行某些JavaScript应用。
//		Nashorn就是javax.script.ScriptEngine的另一种实现，并且它们俩遵循相同的规则，允许Java与JavaScript相互调用。
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName( "JavaScript" );
		         
		System.out.println( engine.getClass().getName() );
		try {
			System.out.println( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" ) );
		}catch(ScriptException se) {
			se.printStackTrace();
		}

	}
}
