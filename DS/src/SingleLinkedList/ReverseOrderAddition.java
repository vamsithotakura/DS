package SingleLinkedList;

import java.util.LinkedList;

public class ReverseOrderAddition {
	
	/*EXAMPLE
	Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
	Output: 8 -> 0 -> 8 
	DESIGNED ONLY FOR POSITIVE NUMBERS*/
	
	public static <T> SinglyLinkedList<Integer> addLists(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

		Node<T> list1Head = list1.getHead();
		Node<T> list2Head = list2.getHead();

		SinglyLinkedList<Integer> result = new SinglyLinkedList<Integer>();

		int carry = 0;
		while(list1Head != null || list2Head != null) {
			int list1Value = 0;
			int list2Value = 0;
			if(list1Head != null) {
				list1Value = (int)list1Head.getData();
			}
			if(list2Head != null) {
				list2Value = (int) list2Head.getData();
			}
			if((list1Head == null && list2Head.getReferenceToNext() == null) ||   //COVERING ALL EDGE CASES TO ENSURE CARRY GETS ADDED TO FINAL RESULT
					(list2Head == null && list1Head.getReferenceToNext() == null) ||
					(list1Head.getReferenceToNext() == null && list2Head.getReferenceToNext() == null)) {
				int addedValue = list1Value + list2Value + carry;
				result.insertAtBeginning(addedValue);
			} else {
				int addedValue = list1Value + list2Value + carry;
				LinkedList<Integer> stack = new LinkedList<Integer>();
				while (addedValue > 0) {
					stack.push(addedValue % 10);
					addedValue = addedValue / 10;
				}
				if(stack.size() > 1) {
					carry = stack.pop();
				}
				addedValue = stack.pop();
				result.insertAtBeginning(addedValue);
			}
			if(list1Head != null) {
				list1Head = list1Head.getReferenceToNext();
			}
			if(list2Head != null) {
				list2Head = list2Head.getReferenceToNext();
			}
		}

		return result;

	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		list1.add(9);
		list1.add(9);
		list1.add(9);

		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
		list2.add(2);
		list2.add(2);
		list2.add(2);
		
		SinglyLinkedList<Integer> result = addLists(list1, list2);
		result.displayList();
		
	}

}
