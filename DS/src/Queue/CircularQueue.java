package Queue;

import java.util.EmptyStackException;

public class CircularQueue<T> {

	private T[] data;
	private int size;
	
	private int first;
	private int last;
	
	private int elements;
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		this.size = size;
		data = (T[]) new Object[size];
		first = 0;
		last = -1;
		elements = 0;
	}
	
	public boolean isEmpty() {
		return (elements == 0);
	}
	
	public boolean isFull() {
		return (elements == size);
	}
	
	public void enQueue(T data) {
		if(isFull()) {
			throw new IndexOutOfBoundsException();
		}
		if(last == (size - 1)) {
			last = -1;
		}
		last++;
		this.data[last] = data;
		elements++;
	}
	
	public T deQueue() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T data = this.data[first];
		if(first == (size - 1)){
			first = 0;
		} else {
			first++;
		}
		elements--;
		return data;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return(this.data[first]);
	}
	
	public int getQueueSize() {
		return this.elements;
	}
	
	public int getFirstIndex() {
		return this.first;
	}
	
	public int getLastIndex() {
		return this.last;
	}
	
	public T getElementAtIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}
		return this.data[index];
		
	}
	
	public static void main(String[] args) {
		
		CircularQueue<Integer> queue = new CircularQueue<Integer>(10);
		
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
		
		
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		
		System.out.println("SIZE : "+queue.getQueueSize());
		System.out.println("FIRST : "+queue.getFirstIndex());
		System.out.println("LAST : "+queue.getLastIndex());
		
		for(int i=0; i <10; i++) {
			System.out.print(queue.getElementAtIndex(i)+"  ");
		}
		
		
	}
}
