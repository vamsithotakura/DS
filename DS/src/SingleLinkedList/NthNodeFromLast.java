package SingleLinkedList;

/*
 * Program to print Nth node from last in Singly Linked List.
 */

public class NthNodeFromLast {

	public static <T> Node<T> nthNodeFromLast(SinglyLinkedList<T> list, int n) {
		if(n <1 || list == null){
			return null;
		}
		Node<T> base = list.getHead();
		Node<T> reference = list.getHead();
		int index = 0;
		while(index < n){
			if(reference == null) {
				return null;
			}
			index ++;
			reference = reference.getReferenceToNext(); 
		}
		while(reference!= null){
			base = base.getReferenceToNext();
			reference = reference.getReferenceToNext();
		}
		return base;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		Node<Integer> nthToLast = nthNodeFromLast(list, 6);
		if(nthToLast != null){
			nthToLast.display();
		}
		
	}
}
