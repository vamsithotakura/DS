package SingleLinkedList;

/*
 *  Example:
 *  Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
 *  Output:   3->2->1->4->5->6->9->8->7->NULL. 
 * 
 */

public class AlternateReverse {
	
	public static <T> Node<T> computeAlternateGroupReversal(Node<T> head, int groupSize) {
		if(head == null ) {
			return null;
		}
		Node<T> root = null;
		Node<T> tail = null;
		
		int index = 0;
		
		Node<T> current = head;
		Node<T> next = null;
		Node<T> previous = null;
		
		while(index < groupSize && current != null) {
			if(index == 0) {
				tail = current;
			}
			next = current.getReferenceToNext();
			current.setNext(previous);
			previous = current;
			current = next;
			index++;
		}
		root = previous;
		
		tail.setNext(current);
		index = 0;
		while(current != null && index < groupSize) {
			previous = current;
			current = current.getReferenceToNext();
			index++;
		}
		if(previous != root) {
			tail = previous;
		}
		
		tail.setNext(computeAlternateGroupReversal(current, groupSize));
		return root;
	}
	
	
	
	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.add(9);
		list.add(18);
		list.add(27);
		list.add(36);
		list.add(45);
		list.add(54);
		list.add(63);
		list.add(72);
		list.add(81);
		list.add(90);
		list.add(99);
		list.add(108);
		list.add(117);
		list.add(126);
		
		int groupSize = 2;
		
		Node<Integer> root = computeAlternateGroupReversal(list.getHead(), groupSize);
		while(root != null) {
			System.out.print(root.getData()+" ");
			root = root.getReferenceToNext();
		}
		
	}

}
