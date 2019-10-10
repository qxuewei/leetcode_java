package com.qiuxuewei;

public class LinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E> {
		E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(Node<E> prev,E element, Node<E> next) {
			this.setPrev(prev);
			this.element = element;
			this.setNext(next);
		}

		@SuppressWarnings("unused")
		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		@SuppressWarnings("unused")
		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	@Override
	public void clear() 
	{
		size = 0;
		setFirst(null);
		setLast(null);
	}

	@Override
	public E get(int index) 
	{
		return node(index).element;
	}

	@Override
	public E set(int index, E element)
	{
		Node<E> node = node(index);
		E oldE = node.element;
		node.element = element;
		return oldE;
	}

	@Override
	public void add(int index, E element) 
	{
		rangeCheckForAdd(index);
		if (index == size) {
			Node<E> oldNode = last;
			last = new Node<E>(oldNode, element, null);
			if (oldNode == null) {
				first = last;
			} else {
				oldNode.next = last;
			}
			
		} else {
			Node<E> nextNode = node(index);
			Node<E> preNode = nextNode.prev;
			Node<E> node = new Node<E>(preNode, element, nextNode);
			nextNode.prev = node;
			
			if (preNode == null) { /// index == 0
				first = node;
			} else {
				preNode.next = node;
			}
			
		}
		size ++;
		
	}

	@Override
	public E remove(int index) 
	{
		rangeCheck(index);
		Node<E> node = node(index);
		Node<E> preNode = node.prev;
		Node<E> nextNode = node.next;
		
		if (preNode == null) {
			first = nextNode;
		} else {
			preNode.next = nextNode;
		}

		if (nextNode == null) {
			last = preNode;
		} else {
			nextNode.prev = preNode;
		}
		size --;
		
		return node.element;
	}

	@Override
	public int indexOf(E element) 
	{
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node = node.next;
			}
		}
		
		return ELEMENT_NOT_FOUND;
	}
	
	private Node<E> node(int index)
	{
		rangeCheck(index);
		if (index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}

	public Node<E> getFirst() {
		return first;
	}

	public void setFirst(Node<E> first) {
		this.first = first;
	}

	public Node<E> getLast() {
		return last;
	}

	public void setLast(Node<E> last) {
		this.last = last;
	}

}
