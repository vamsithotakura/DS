package SingleLinkedList;

public class DeleteNode {
	
	public static <T> void deleteGivenNode(Node<T> nodeToDelete) {
		if(nodeToDelete == null) {
			return;
		}
		Node<T> next = nodeToDelete.getReferenceToNext();
		nodeToDelete.setData(next.getData());
		nodeToDelete.setNext(next.getReferenceToNext());
		next.setNext(null);
	}

	
	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(5);
		sll.add(10);
		sll.add(15);
		sll.add(18);
		sll.add(20);
		sll.add(25);
		sll.add(30);
		
		Node<Integer> nodeToDelete = sll.findNode(18);
		deleteGivenNode(nodeToDelete);
		sll.displayList();
		
	}
}
