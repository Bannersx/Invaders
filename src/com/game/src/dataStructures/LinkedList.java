package com.game.src.dataStructures;



public class LinkedList<T> {
	public int size;
	private Node<T> first = null;
	private Node<T> tail = null;
	
	
	public void add(T i)
	{
	    if(first == null)
	    {
	    	first = new Node<T>(null, i);
	    }
	    else
	    {
	    Node<T> temp = first;
	    while(temp.getNext() != null) {
	    	temp = temp.getNext();
	    	}
	    temp.setNext(new Node<T>(null, i));
	    }
	    size ++;
	}
	
	public void remove(T elem)
	{
		Node<T> temp = first;
	    Node<T> two = null;
	    if(first.getData().equals(elem))
	    {
	        first = first.getNext();
	        
	    }
	   
	    while(temp != null && !temp.getData().equals(elem))
	    {
	        two = temp;
	        temp = temp.getNext();
	    
	    }
	    if (temp == null) {
	    	two.setNext(temp);
	    	return;
	    	}
	    two.setNext(temp.getNext());
	    T spare = temp.getData();
	    temp = null;
	    size--;
	   
	}
	
	public LinkedList() {
		super();
	}
	public int size() {
		
		return this.size;
	}
	public T get(int index) {
        if(first == null) 
        	return null;
        
        Node<T> temp = first;
        for (int i = 0 ; i < index; i++) {
        	temp = temp.getNext();
        }
        
        if (temp== null) 
        	return null;
       
        return temp.getData();
	}
}
