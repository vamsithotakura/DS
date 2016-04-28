package SingleLinkedList;

public class ReverseSLL {
	
	public static <T> Node<T> reverseList(SinglyLinkedList<T> list) {
		Node<T> current = list.getHead();
		if(current == null) {
			return null;
		}
		Node<T> next;
		Node<T> previous = null;
		while(current.getReferenceToNext() != null) {
			next = current.getReferenceToNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		current.setNext(previous);
		return current;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.add(3);
		list.add(6);
		list.add(9);
		list.add(12);
		list.add(15);
		list.add(18);
		list.add(21);
		list.add(24);
		list.add(27);
		list.add(30);
		
		SinglyLinkedList<String> stringList = new SinglyLinkedList<String>();
		stringList.add("VAMSI");
		stringList.add("SANDEEP");
		stringList.add("SRIDHAR");
		stringList.add("YAGNA");
		stringList.add("PRAVEEN");
		stringList.add("NEELU");
		stringList.add("HARSHA");
		
		Node<String> reversed = ReverseSLL.reverseList(stringList);
		if(reversed != null){
			while(reversed != null) {
				System.out.print(reversed.getData()+" ");
				reversed = reversed.getReferenceToNext();
			}
		}
		
	}

}
