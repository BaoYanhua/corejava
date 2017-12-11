package com.corejava.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Test05_lambda_methodcall {
		public static void main(String[] args) {
//			方法引用： 可以直接引用已有的Java类或对象（实例）的方法或构造器。与lambda联合使用
//			第一种方法引用是构造器引用，它的语法是Class::new, 或者更一般的Class<T>::new. 注意构造器没有参数
			final Car car = Car.create(Car::new);
			final List<Car> cars = Arrays.asList(car);
//			第二种方法引用是静态方法引用，它的语法是Class::static_method.注意这个方法接受一个Car类型的参数
			cars.forEach(Car::collide);
//			第三种方法引用特定类的任意对象的方法引用，它的语法是Class::method.注意， 这个方法没有参数
			cars.forEach(Car::repair);
//			第四种方法引用特定对象的方法引用。 它的语法是instance::method注意这个方法接受一个 Car类型的参数
			final Car police = Car.create(Car::new);
			cars.forEach(police::follow);
		}
	
	public static class Car {
		public static Car create(final Supplier<Car> supplier) {
			return supplier.get();
		}
		
		public static void collide(final Car car) {
			System.out.println("Collided "+ car.toString());
		}
		
		public void follow (final Car another) {
			System.out.println("Following the " + another.toString());
		}
		
		public void repair () {
			System.out.println("Repaired "+ this.toString());
		}
	}
	
}
