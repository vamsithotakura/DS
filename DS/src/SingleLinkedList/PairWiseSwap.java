package SingleLinkedList;

/*
 * If the linked list is 1->2->3->4->5->6->7, then the function should change it to 2->1->4->3->6->5->7.
 * If the linked list is 1->2->3->4->5->6, then the function should change it to 2->1->4->3->6->5.
 * 
 */

public class PairWiseSwap {
	
	public static <T> Node<T> computePairWiseSwap(Node<T> head) {
		if(head == null) {
			return null;
		}
		Node<T> current = head;
		
		Node<T> root = null;
		Node<T> tail = null;
		
		int pairSize = 2;
		int index = 0;
		
		Node<T> next = null;
		Node<T> prev = null;

		while(current != null && index < pairSize) {
			if(tail == null) {
				tail = current;
			}
			next = current.getReferenceToNext();
			current.setNext(prev);
			prev = current;
			current = next;
			index++;
		}
		root = prev;
		tail.setNext(computePairWiseSwap(current));
		return root;
	}
	
	
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		sll.add(5);
		sll.add(6);
		sll.add(7);
		Node<Integer> root = computePairWiseSwap(sll.getHead());
		while(root != null) {
			System.out.print(root.getData()+" ");
			root = root.getReferenceToNext();
		}
		
	}

}
