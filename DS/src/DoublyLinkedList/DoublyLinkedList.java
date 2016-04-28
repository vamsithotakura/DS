package DoublyLinkedList;

class Node<T> {
	
	private Node<T> previous;
	private Node<T> next;
	private T data;
	
	public Node(T data) {
		this.data = data;
	}
	
	public Node<T> getReferenceToNext() {
		return this.next;
	}
	
	public Node<T> getReferenceToPrevious() {
		return this.previous;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void display() {
		System.out.println("Data :"+this.data);
	}
}

public class DoublyLinkedList<T> {
	
	private Node<T> first;
	private Node<T> last;
	
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first == null && last == null);
	}
	
	public void insertFirst(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(first);
		if(first != null){
			first.setPrevious(newNode);
			first = newNode;
		} else {
			first = newNode;
			last = newNode;
		}
	}
	
	public void add(T data){
		Node<T> newNode = new Node<T>(data);
		if(isEmpty()){
			first = newNode;
			last = newNode;
		} else {
			last.setNext(newNode);
			newNode.setPrevious(last);
			last = newNode;
		}
	}
	
	public void deleteFirst(){
		if(isEmpty()){
			return;
		} else {
			Node<T> next = first.getReferenceToNext();
			if(next != null) {
			next.setPrevious(null);
			first.setNext(null);
			first = next;
			} else {
				first = null;
				last = null;
			}
		}
	}
	
	public void deleteLast() {
		if(isEmpty()) {
			return;
		} else {
			if(first == last){
				first = null;
				last = null;
			} else {
				Node<T> previous = last.getReferenceToPrevious();
				last.setPrevious(null);
				previous.setNext(null);
				last = previous;
			}
		}
	}
	
	public void insertAfter(T key, T data) {
		if(isEmpty()) {
			return;
		} else {
			Node<T> current = first;
			while(!current.getData().equals(key)) {
				current = current.getReferenceToNext();
			}
			if(current != null){
				Node<T> newNode = new Node<T>(data);
				Node<T> next = current.getReferenceToNext();
				newNode.setNext(current.getReferenceToNext());
				current.setNext(newNode);
				newNode.setPrevious(current);
				if(current == last) {
					last = newNode;
				} else {
					next.setPrevious(newNode);
				}
			}
		}
	}
	
	public void deleteKey(T key){
		if(isEmpty()) {
			return;
		} else {
			Node<T> current = first;
			while(!current.getData().equals(key)) {
				current = current.getReferenceToNext();
			}
			if(current != null) {
				if(current == first) {
					deleteFirst();
				} else if(current == last) {
					deleteLast();
				} else {
					Node<T> previous = current.getReferenceToPrevious();
					Node<T> next = current.getReferenceToNext();
					previous.setNext(next);
					next.setPrevious(previous);
					current.setNext(null);
					current.setPrevious(null);
				}
			}
		}
	}
	
	public void displayForward() {
		Node<T> current = first;
		while(current != null) {
			System.out.print(current.getData()+" ");
			current = current.getReferenceToNext();
		}
	}
	
	public void displayBackWard() {
		Node<T> current = last;
		while(current != null) {
			System.out.print(current.getData()+" ");
			current = current.getReferenceToPrevious();
		}
	}
	
	public Node<T> getFirst() {
		return this.first;
	}
	
	public Node<T> getLast() {
		return this.last;
	}
	
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		
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
		
		list.deleteFirst();
		list.deleteLast();
		list.add(30);
		list.insertFirst(3);
		
		list.displayForward();
		System.out.println();
		list.displayBackWard();
		
	}

}
