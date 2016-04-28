package SingleLinkedList;

class Node <T> {

	private Node<T> next;
	private T data;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public void display() {
		System.out.println("Data : "+data);
	}

	public Node<T> getReferenceToNext() {
		return next;
	}

	public void setNext(Node<T> firstNode) {
		next = firstNode;
	}

}

public class SinglyLinkedList<T> {
	
	private Node<T> firstNode;
	private int size = 0;
	
	public SinglyLinkedList() {
		firstNode = null;
	}
	
	public boolean isEmpty() {
		return (firstNode == null);
	}
	
	public void insertAtBeginning(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(firstNode);
		firstNode = newNode;
		size++;
	}
	
	public Node<T> deleteFirstNode() {
		if(firstNode != null) {
			Node<T> newFirst = firstNode.getReferenceToNext();
			Node<T> tmp = firstNode;
			firstNode = newFirst;
			size--;
			return tmp;
		} else {
			return null;
		}
	}
	
	public void displayList() {
		Node<T> current = firstNode;
		while(current != null) {
			System.out.print(current.getData()+"	");
			current = current.getReferenceToNext();
		}
		System.out.println();
	}
	
	public void add(T element) {
		Node<T> current = firstNode;
		if(current == null) { //Indicates an empty list.
			Node<T> newNode = new Node<T>(element);
			firstNode = newNode;
			size++;
			return;
		} 
		while(current.getReferenceToNext()!= null) {
			current = current.getReferenceToNext();
		}
		Node<T> newNode = new Node<T>(element);
		current.setNext(newNode);
		size++;
	}
	
	public Node<T> findNode(T data) {
		Node<T> current = firstNode;
		while(!current.getData().equals(data)) {
			if(current.getReferenceToNext() == null) {
				return null;
			} else {
				current = current.getReferenceToNext();
			}
		}
		return current;
	}
	
	public Node<T> getHead() {
		return firstNode;
	}
	
	public Node<T> getNode(int index) {
		int id = 0;
		if(firstNode == null) {
			return firstNode;
		} else {
			Node<T> current = firstNode;
			while(current != null) {
				if(id == index) {
					break;
				} else {
					current = current.getReferenceToNext();
					id++;
				}
			}
			if(id == index) {
				return current;
			}
		}
		return null;
	}
	
	public Node<T> deleteNode(T data) {
		Node<T> current = firstNode;
		Node<T> previous = firstNode;
		while(!current.getData().equals(data)) {
			if(current.getReferenceToNext() == null) {
				return null;
			} else {
				previous = current;
				current = current.getReferenceToNext();
			}
		}
		previous.setNext(current.getReferenceToNext());
		current.setNext(null);
		size--;
		return current;
	}
	
	public int getSize() {
		return this.size;
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
		
		list.deleteNode(18);
		list.deleteNode(27);
				
		for(int i=0; i<list.getSize(); i++) {
			System.out.print(list.getNode(i).getData()+" ");
		}
		
	}
}
