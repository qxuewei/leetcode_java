package com.qiuxuewei;

@SuppressWarnings("unchecked")
public class ArrayList<E> {
	
	private int size;
	private E[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	
	public ArrayList(int capacity)
	{
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = ((E[]) new Object[capacity]);
	}
	
	public ArrayList()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public void clear()
	{
		size = 0;
		for (int i = 0; i < size; i++)
		{
			elements[i] = null;
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}

//	public boolean contains(E element)
//	{
//		
//	}
}
