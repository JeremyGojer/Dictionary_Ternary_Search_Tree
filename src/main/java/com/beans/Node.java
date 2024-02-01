package com.beans;

public class Node<T> {

	private T data;
	private Node<T> left;
	private Node<T> mid;
	private Node<T> right;
	private boolean eow=false;
	
	public boolean isEow() {
		return eow;
	}

	public void setEow(boolean eow) {
		this.eow = eow;
	}

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getMid() {
		return mid;
	}

	public void setMid(Node<T> mid) {
		this.mid = mid;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", mid=" + mid + ", right=" + right + ", eow=" + eow + "]";
	}

	
	
	
}
