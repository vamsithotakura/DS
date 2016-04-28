package Stack;

import java.util.EmptyStackException;

public class Stack<T> {

	private T[] store;
	private int top;
	private int storeSize;

	@SuppressWarnings("unchecked")
	public Stack(int storeSize) {
		this.top = -1;
		this.storeSize = storeSize;
		store = (T[]) new Object[this.storeSize];
	}

	public boolean isEmpty(){
		return (top == -1);
	}

	public void push(T myObj){
		if(isFull()) {
			throw new IndexOutOfBoundsException();
		}
		this.store[++top] = myObj;
	}

	public T pop(){
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return this.store[top--];
	}

	public T getTop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return this.store[top];
	}

	public boolean isFull() {
		return (top == this.storeSize - 1);
	}
	
	public int getStackSize() {
		return this.top;
	}

}
