package DoublyLinkedList;

public class ReverseDLL {
	
	public static <T> Node<T> reverseDLL(DoublyLinkedList<T> list) {
		if(list == null || list.isEmpty()) {
			return null;
		} else {
		  Node<T> current = list.getFirst();
		  
		  Node<T> next = null;
		  Node<T> previous = null;
		  
		  while(current.getReferenceToNext() != null) {
			  next = current.getReferenceToNext();
			  previous = current.getReferenceToPrevious();
			  current.setNext(previous);
			  current.setPrevious(next);
			  previous = current;
			  current = next;
		  }
		  current.setNext(previous);
		  current.setPrevious(null);
		  return current;
		  
		}
	}
	
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.add(2);
		dll.add(4);
		dll.add(6);
		dll.add(8);
		dll.add(10);
		
		Node<Integer> head = ReverseDLL.reverseDLL(dll);
		while(head != null) {
			System.out.print(head.getData()+" ");
			head = head.getReferenceToNext();
		}
	}

}
