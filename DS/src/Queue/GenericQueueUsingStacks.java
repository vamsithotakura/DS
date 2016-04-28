package Queue;

import Stack.Stack;

/*
 * Implements one of lazy loading concepts.
 */

public class GenericQueueUsingStacks<T> {
	
	private Stack<T> stack1 = null;
	private Stack<T> stack2 = null;
	
	private int size;
	private int elements;
	
	public GenericQueueUsingStacks(int size) {
		this.size = size;
		this.elements = 0;
		stack1 = new Stack<T>(this.size);
		stack2 = new Stack<T>(this.size);
	}
	
	public void enQueue(T data) {
		stack1.push(data);
		elements++;
	}
	
	public int getQueueSize() {
		return (stack1.getStackSize());
	}
	
	public T deQueue() {
		if(!stack2.isEmpty()) {
			T data = stack2.pop();
			elements--;
			return data;
		} else {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			T data = stack2.pop();
			elements--;
			return data;
		}
	}
	
	public T poll() {
		if(!stack2.isEmpty()) {
			return stack2.getTop();
		} else {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.getTop();
		}
	}
	
	public boolean isEmpty() {
		return (elements == 0);
	}
	
	public boolean isFull() {
		return (elements == size);
	}
	
	public static void main(String[] args) {
       GenericQueueUsingStacks<Integer> queue = new GenericQueueUsingStacks<Integer>(10);
		
		queue.enQueue(2);
		queue.enQueue(4);
		queue.enQueue(6);
		queue.enQueue(8);
		queue.enQueue(10);
		queue.enQueue(12);
		queue.enQueue(14);
		queue.enQueue(16);
		queue.enQueue(18);
		queue.enQueue(20);
		
		while(!queue.isEmpty()) {
			System.out.print(queue.deQueue()+" ");
		}
	}
	
}
