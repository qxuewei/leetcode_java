package com.qiuxuewei;

public class ArrayList <E> extends AbstractList<E> {
	
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayList(int capaticy) 
	{
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = extracted(capaticy);
	}
	
	public ArrayList() 
	{
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public void clear()
	{
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
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
		for (int i = size; i < index; i++) {
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
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[--size] = null;
		return oldE;
	}

	@Override
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
	
	private void ensureCapacity(int capacity)
	{
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;

		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] es = extracted(newCapacity);
		E[] newElements = es;
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}

	@SuppressWarnings("unchecked")
	private E[] extracted(int newCapacity) {
		return ((E[]) new Object[newCapacity]);
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
