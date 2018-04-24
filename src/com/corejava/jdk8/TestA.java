package com.corejava.jdk8;

import java.util.HashSet;
import java.util.Set;

/**
 * S(K) = {A(K),A(A(K)),A(A(A(K)))....}
 * 
 * M is number of segments in S(K)
 * 
 * A[0] = 1
 * A[1] = 3
 * A[2] = 6
 * A[3] = 5
 * A[4] = 1
 * A[5] = 2
 * A[6] = 0
 * 
 * 
 * N value belongs {0..N-1}
 * 
 * **/

public class TestA {
	
	
	public static int calSegentsNum(int []A) {
		
		Set s = new HashSet();
		int sLen = 0;
		int count = 0;
		for(int i=0;i<A.length;i++) {
			count++;
			int a = A[i];
			//if a cannot be added into s
			do{
				count++;
				s.add(a);
				a = A[a];
			}while(!s.contains(a));
			if(s.size() > sLen) {
				sLen = s.size();
			}
			s.clear();
		}
		System.out.println("final Len:"+sLen);
		System.out.println("final count:"+count);
		return sLen;
	}
	
	public static int calSegentsNum1(int []A) {
		
		Set s = new HashSet();
		Set s1 = new HashSet();
		int sLen = 0;
		int count = 0;
		for(int i=0;i<A.length;i++) {
			count++;
			int a = A[i];
			do{
				count++;
				if(s.contains(a)) {
					break;
				};
				s1.add(a);
				a = A[a];
				
			}while(!s1.contains(a));
			if(s1.size()==A.length) {
				sLen = s1.size();
				s=s1;
				break;
			}
			if(s1.size() > sLen) {
				sLen = s1.size();
				s = s1;
			}
			s1.clear();
			
		}
		System.out.println("final Len:"+sLen);
		System.out.println("final count:"+count);
		return sLen;
	}
	
	public static int calSegmentsNum2(int []A) {
		int m = 0;
		int reversedNum = 0;
		
		for(int i=0;i<A.length;i++) {
			int value = A[i];
			int index = i;
			int n = 0;
			do {
				//if(reversedNum<(A.length-reversedNum))
				n++;
				reversedNum++;
				System.out.print(i+"--"+A[index]);
				value = A[index];
				A[index] = -1;
				//index = temp;
				//value = A[index];
			}while(value>=0&&value<A.length-1);
			m=Math.max(m, n);
		}
		
		
		
		System.out.println(m);
		System.out.println(reversedNum);
		return m;
	}
	
	
	
	
	
	
	
	public static void main(String []argss) {
		int A[]= {1,2,3,4,5,6,0,8,7};
		
		int m = calSegmentsNum2(A);
		
		
		System.out.println(m);
		
	}

}


//A[0]=0 A[1]=1

//A[0]=1 A[1]=0

//A[0]=0 A[1]=2 A[2]=1