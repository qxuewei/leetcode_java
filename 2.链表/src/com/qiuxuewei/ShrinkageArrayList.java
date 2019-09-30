package com.qiuxuewei;
/// 有动态缩容功能的动态数组
public class ShrinkageArrayList<E> extends AbstractList<E> {
	
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public ShrinkageArrayList(int capacity)
	{
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (E[]) new Object[capacity];
	}

	public ShrinkageArrayList()
	{
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
		
		if (elements != null && elements.length > DEFAULT_CAPACITY) {
			elements = (E[]) new Object[DEFAULT_CAPACITY];
		}
	}

	@Override
	public E get(int index) 
	{
		rangeCheck(index);
		return elements[index];
	}

	@Override
	public E set(int index, E element) 
	{
		rangeCheck(index);
		E oldE = elements[index];
		elements[index] = element;
		return oldE;
	}

	@Override
	public void add(int index, E element)
	{
		rangCheckForAdd(index);	
		ensureCapacity(size + 1);
		
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
	}

	@Override
	public E remove(int index)
	{
		rangeCheck(index);
		E oldE = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null;
		trim();
		return oldE;
	}

	@Override
	public int indexOf(E element) {
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
	

	private void ensureCapacity(int capacity) 
	{
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		
		// 新容量为旧容量的2倍
		// int newCapacity = oldCapacity << 1;
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	
	private void trim()
	{
		int oldCapacity = elements.length;
		int newCapacity = oldCapacity >> 1;
		if (size > newCapacity || oldCapacity <= DEFAULT_CAPACITY) return;
		
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "缩容为" + newCapacity);
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
