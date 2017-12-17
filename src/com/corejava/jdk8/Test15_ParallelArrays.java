package com.corejava.jdk8;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Test15_ParallelArrays {

	public static void main( String[] args ) {
        
//		上面的代码片段使用了parallelSetAll()方法来对一个有20000个元素的数组进行随机赋值。
//		然后，调用parallelSort方法。这个程序首先打印出前10个元素的值，之后对整个数组排序。
		long[] arrayOfLong = new long [ 20000 ];        
         
        Arrays.parallelSetAll( arrayOfLong, 
            index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
            i -> System.out.print( i + " " ) );
        System.out.println();
         
        Arrays.parallelSort( arrayOfLong );     
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
            i -> System.out.print( i + " " ) );
        System.out.println();
    }
	
}
