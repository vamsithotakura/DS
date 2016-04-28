package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter some random input >> ");
		String store = br.readLine();
		
		if(store!= null && !store.isEmpty()) {
			char[] chr = store.toCharArray();
			Stack<Character> myStack = new Stack<Character>(chr.length);
			for(int i=0; i<chr.length; i++){
				myStack.push(chr[i]);
			}
			while(!myStack.isEmpty()) {
				System.out.println(myStack.pop());
			}
		}
	}

}
