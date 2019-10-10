package com.qiuxuewei;

public class Main {
	
	public static int fib1(int n)
	{
		if (n == 0 || n == 1) return n;
		return fib1(n - 1) + fib1(n - 2);
	}
	
	public static int fib2(int n) {
		if (n <= 1) return n;
		int first = 0;
		int second = 1;
		for (int i = 0; i <n - 1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	public static int fib3(int n) {
		if (n <= 1) return n;
		int first = 0;
		int second = 1;
		for (int i = 0; i <n - 1; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}

	public static void main(String[] args) {

//		int n = 50;
//		System.out.println("fib1 : " + fib1(n));
//		System.out.println("fib2 : " + fib2(n));
		
//		test();
	}
	
	static void test() {
		// int -> Integer
	
		// 所有的类，最终都继承java.lang.Object

		// new是向堆空间申请内存
		ArrayList<Person> persons  = new ArrayList<>();
		persons.add(new Person(10, "Jack"));
		persons.add(new Person(12, "James"));
		persons.add(new Person(15, "Rose"));
		persons.clear();
		persons.add(new Person(22, "abc"));
		
		System.out.println(persons);
		ArrayList<Integer> ints  = new ArrayList<>();
		ints.add(10);
		ints.add(10);
		ints.add(22);
		ints.add(33);
		System.out.println(ints);
	}

}
