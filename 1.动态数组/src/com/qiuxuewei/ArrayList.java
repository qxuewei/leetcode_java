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

	public boolean contains(E element)
	{
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	public void add(E element) {
		add(size, element);
	}
	
	public void add(int index, E element) 
	{
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
	
		for (int i = size; i > index ; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
	}
	
	public E get(int index) 
	{
		rangeCheckForAdd(index);
		return elements[index];
	}
	
	public E set(int index, E element) 
	{
		rangeCheckForAdd(index);
		E oldE = elements[index];
		elements[index] = element;
		return oldE;
	}
	
	public int indexOf(E element) 
	{
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	public E remove(int index)
	{
		rangeCheckForAdd(index);
		E oldE = elements[index];
		for (int i = index; i < size - 1; i ++) {
			elements[i] = elements[i + 1];
		}
		elements[--size] = null;
		return oldE;
	}
	
	/// mark - Private
	private void outOfBounds(int index)
	{
		throw new IndexOutOfBoundsException("Index" + index + ", Size:" + size);
	}
	
	private void rangeCheckForAdd(int index)
	{
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	
	private void ensureCapacity(int capacity)
	{
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		/// 新容量为就容量的 1.5 倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为：" + newCapacity);
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("size = ").append(size).append(",[");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				stringBuffer.append(", ");
			}
			stringBuffer.append(elements[i]);
		}
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
}
