package Stack;

public class MinFunctionStack {

	private int[] store;
	private int top;
	private int storeSize;
	private int min;

	private int[] auxiliaryStore;
	private int topA;

	public MinFunctionStack(int storeSize) {
		this.top = -1;
		this.storeSize = storeSize;
		store = new int[this.storeSize];

		this.topA = -1;
		auxiliaryStore = new int[this.storeSize];
		this.min = Integer.MAX_VALUE;
	}

	public boolean isEmpty(){
		return (top == -1);
	}

	public void push(int val){
		this.store[++top] = val;
		if(val <= this.min) {
			this.min = val;
			this.auxiliaryStore[++topA] = this.min;
		} else {
			this.auxiliaryStore[++topA] = this.min;
		}
	}

	public int pop(){ 
		/*if(this.min == this.auxiliaryStore[topA]) {
			this.min = this.auxiliaryStore[--topA];
		}*/
		this.min = this.auxiliaryStore[--topA];
		return this.store[top--];
	}

	public int getTop() {
		return this.store[top];
	}

	public boolean isFull() {
		return (top == this.storeSize - 1);
	}

	public int getMin() {
		return this.min;
	}
	
	public static void main(String[] args) {
		
		MinFunctionStack myStack = new MinFunctionStack(10);
		
		myStack.push(3);
		myStack.push(4);
		myStack.push(2);
		myStack.push(1);
		myStack.pop();
		myStack.pop();
		myStack.push(0);
		System.out.println("MIN >> "+myStack.getMin());
		
		
	}


}
