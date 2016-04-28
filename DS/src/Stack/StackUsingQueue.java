package Stack;

import java.util.EmptyStackException;

import Queue.CircularQueue;

/*
 * CAN OPTIMIZE MORE
 * 
 */

public class StackUsingQueue<T> {
	
	private CircularQueue<T> queue1 = null;
	private CircularQueue<T> queue2 = null;
	
	private int size;
	private int elements;
	
	public StackUsingQueue(int size) {
		this.size = size;
		queue1 = new CircularQueue<T>(size);
		queue2 = new CircularQueue<T>(size);
		elements = 0;
	}
	
	public void push(T data) {
		if(isFull()) {
			throw new IndexOutOfBoundsException();
		}
		queue1.enQueue(data);
		elements++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T data = null;
		CircularQueue<T> temp;
		while(!queue1.isEmpty()) {
			data = queue1.deQueue();
			int size = queue1.getQueueSize();
			if(size >= 1) {
				queue2.enQueue(data);
			}
		}
		temp= queue1;
		queue1 = queue2;
		queue2 = temp;
		elements--;
		return data;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T data = null;
		CircularQueue<T> temp;
		while(!queue1.isEmpty()) {
			data = queue1.deQueue();
		}
		temp= queue1;
		queue1 = queue2;
		queue2 = temp;
		return data;
	}
	
	public boolean isEmpty() {
		return (elements == 0);
	}
	
	public boolean isFull() {
		return (elements == size);
	}
	
	public int getStackSize() {
		return this.elements;
	}

	
	public static void main(String[] args) {
		
		StackUsingQueue<Integer> myStack = new StackUsingQueue<Integer>(5);
		myStack.push(3);
		myStack.push(6);
		myStack.push(9);
		myStack.push(12);
		myStack.push(15);
		
		myStack.pop();
		myStack.pop();
		
		System.out.println(myStack.peek());
	}
}
