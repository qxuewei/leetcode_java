package com.qiuxuewei;

public class Main {
	
	static void textList(List<Integer> list)
	{
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		
		list.add(0, 55); //[55, 11, 22, 33, 44]
		list.add(2, 66); //[55, 11, 66, 22, 33, 44]
		
		
		System.out.println(list);
	}

	public static void main(String[] args) {
		textList(new ArrayList<Integer>());
		textList(new LinkedList<Integer>());
		
	}

}
