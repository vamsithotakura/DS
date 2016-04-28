package SingleLinkedList;

public class MergeSortedLists {

	public static <T extends Comparable<T>> Node<T> mergeList(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

		if(list1 == null && list2 == null) {
			return null;
		} else if(list1 != null && list2 == null) {
			return list1.getHead();
		} else  if(list1 == null && list2 != null) {
			return list2.getHead();
		}

		Node<T> head = null;
		Node<T> root = null;

		Node<T> list1Head = list1.getHead();
		Node<T> list2Head = list2.getHead();

		while(list1Head != null && list2Head != null) {
			if(list1Head.getData().compareTo(list2Head.getData()) < 0) { //ELEMENT IN LIST2 IS GREATER
				if(head == null) {
					head = list1Head;
					root = head;
				} else {
					head.setNext(list1Head);
					head = head.getReferenceToNext();
				}
				list1Head = list1Head.getReferenceToNext();
			} else if(list1Head.getData().compareTo(list2Head.getData()) > 0) { //ELEMENT IN LIST1 IS GREATER
				if(head == null) {
					head = list2Head;
					root = head;
				} else {
					head.setNext(list2Head);
					head = head.getReferenceToNext();
				}
				list2Head = list2Head.getReferenceToNext();
			} else {
				if(head == null) { //SPECIAL EDGE CASE.
					head = list1Head;
					root = head;
					list1Head = list1Head.getReferenceToNext();
					head.setNext(list2Head);
					list2Head = list2Head.getReferenceToNext();
					head = head.getReferenceToNext();
				} else {
					head.setNext(list1Head);
					list1Head = list1Head.getReferenceToNext();
					head = head.getReferenceToNext();

					head.setNext(list2Head);
					list2Head = list2Head.getReferenceToNext();
					head = head.getReferenceToNext();
				}
			}
		}

		if(list1Head != null) {
			head.setNext(list1Head);
		} else if( list2Head != null){
			head.setNext(list2Head);
		}
		return root;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		list1.add(3);
		list1.add(6);
		list1.add(9);
		list1.add(12);
		list1.add(15);

		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		list2.add(10);

		SinglyLinkedList<Integer> list3 = new SinglyLinkedList<Integer>();
		list3.add(2);
		list3.add(4);
		list3.add(6);
		list3.add(8);
		list3.add(10);

		Node<Integer> root = mergeList(list1, list2);
		while(root != null) {
			System.out.print(root.getData()+"  ");
			root = root.getReferenceToNext();
		}
	}

}
