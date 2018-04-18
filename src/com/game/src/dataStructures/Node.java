package com.game.src.dataStructures;

public class Node<T> {
	private Node<T> next;
	private T data;
	
	public Node(Node<T> next, T data)
	{
		this.data = data;
		this.next = null;
	}
	public T setData(T data)
	{
		this.data = data;
		return this.data;
	}
	public T getData()
	{
		return this.data;
	}
	public Node<T> getNext()
	{
		return this.next;
	}
	public void setNext(Node<T> node)
	{
		this.next = node;
	}
}
