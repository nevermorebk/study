package com.homedirect.study.support;

public class CustomList<T> {

	private Node<T> first;
	private Node<T> last;
	private int size = 0;

	public void add(T e) {
		final Node<T> l = last;
		final Node<T> newNode = new Node<>(e, null);
		last = newNode;
		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		size++;
	}

	public T get(int index) {
		return findNode(index).item;
	}

	public int size() {
		return size;
	}

	private Node<T> findNode(int index) {
		Node<T> x = first;
		for (int i = 0; i < index; i++)
			x = x.next;
		return x;
	}

	private static class Node<T> {
		private T item;
		private Node<T> next;

		Node(T element, Node<T> next) {
			this.item = element;
			this.next = next;
		}
	}
}
