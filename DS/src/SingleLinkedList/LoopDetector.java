package SingleLinkedList;

public class LoopDetector {
	
	public static <T> Node<T> detectLoop(SinglyLinkedList<T> list) {
		if(list == null || list.isEmpty()) {
			return null;
		}
		Node<T> walker = list.getHead();
		Node<T> runner = list.getHead();
		while(true) {
			if(walker == null || runner == null) {
				return null;
			}
			walker = walker.getReferenceToNext();
			if(runner.getReferenceToNext() == null) {
				return null;
			} else {
				runner = runner.getReferenceToNext().getReferenceToNext();
			}
			if(walker == runner){
				return walker;
			}
		}
	}
	
	public static <T> Node<T> firstNodeAtBeginningOfLoop(Node<T> first, Node<T>loopPresence) {
		while(true) {
			if(first == loopPresence) {
				return first;
			}
			first = first.getReferenceToNext();
			loopPresence = loopPresence.getReferenceToNext();
		}
	}
	
	public static <T> void clearLoopBlock(Node<T> first, Node<T>loopPresence) {
		Node<T> previous = null;
		while(true) {
			if(first == loopPresence) {
				break;
			}
			first = first.getReferenceToNext();
			previous = loopPresence;
			loopPresence = loopPresence.getReferenceToNext();
		}
		if(previous != null) {
			previous.setNext(null);
		}
	}
 	
	
	public static void main(String[] args) {
		
		/*SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(6);
		sll.add(12);
		sll.add(18);
		sll.add(24);
		sll.add(30);
		
		Node<Integer> node30 = sll.findNode(30);
		Node<Integer> node12 = sll.findNode(12);
		node30.setNext(node12);*/
		
		SinglyLinkedList<Character> sll = new SinglyLinkedList<Character>();
		sll.add('A');
		sll.add('B');
		sll.add('C');
		sll.add('D');
		sll.add('E');
		
		Node<Character> nodeE = sll.findNode('E');
		Node<Character> nodeC = sll.findNode('C');
		nodeE.setNext(nodeC);
		
		Node<Character> loopPlace = detectLoop(sll);
		if(loopPlace != null) {
			loopPlace.display();
		}
		
		Node<Character> firstNodeInLoop = firstNodeAtBeginningOfLoop(sll.getHead(), loopPlace);
		firstNodeInLoop.display();
		System.out.println();
		clearLoopBlock(sll.getHead(), loopPlace);
		sll.displayList();
	}
}
