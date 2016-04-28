package Stack;

public class Driver {
	
	public static void main(String[] args) {
		
		Stack<Integer> myStack = new Stack<Integer>(10);
		
		System.out.println("Is stack empty ?? "+myStack.isEmpty());
		
		myStack.push(9);
		myStack.push(18);
		myStack.push(27);
		myStack.push(36);
		myStack.push(45);
		
		
		System.out.println("Is stack empty ?? "+myStack.isEmpty());
		System.out.println("TOP >>> "+myStack.getTop());
		
		while(!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}
		
		System.out.println("Is stack empty ?? "+myStack.isEmpty());
	}

}
