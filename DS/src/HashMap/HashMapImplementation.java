package HashMap;

import java.util.Arrays;

class HashMapStandard<K,V> {

	private Entry<K,V>[] table;   //Array of Entry.
	private int capacity = 4;  //Initial capacity of HashMap

	private int insertionCount;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K,V> next;
		public Entry(K key, V value, Entry<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}


	@SuppressWarnings("unchecked")
	public HashMapStandard(){
		table = new Entry[capacity];
	}
	
	public int getTableSize() {
		return capacity;
	}


	public void put(K newKey, V data){
		if(newKey==null) {
			return;    //does not allow to store null.
		}

		//calculate hash of key.
		int hash = hash(newKey.hashCode());
		//create new entry.
		Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);

		if(table[hash] == null){
			table[hash] = newEntry; //NO COLLISSION.
			insertionCount++;
			//ensureCapacity();
		}else{
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];
			while(current != null){ //we have reached last entry of bucket.
				if(current.key.equals(newKey)){           
					if(previous==null){  //node has to be insert on first of bucket.
						newEntry.next=current.next;
						table[hash]=newEntry;
						return;
					} else{
						newEntry.next=current.next; //Remove the object in collision.
						previous.next=newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	public V get(K key){
		int hash = hash(key.hashCode());
		if(table[hash] == null){
			return null;
		}else{
			Entry<K,V> temp = table[hash];
			while(temp!= null){
				if(temp.key.equals(key))
					return temp.value;
				temp = temp.next; //return value corresponding to key.
			}         
			return null;   //returns null if key is not found.
		}
	}

	public boolean remove(K deleteKey){
		int hash = hash(deleteKey.hashCode());
		if(table[hash] == null){ //NO ENTRY IN TABLE.
			return false;
		}else{
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];

			while(current != null){ //we have reached last entry node of bucket.
				if(current.key.equals(deleteKey)){               
					if(previous==null){  //delete first entry node.
						table[hash]=table[hash].next;
						insertionCount--;
						return true;
					} else{
						previous.next=current.next;
						insertionCount--;
						return true;
					}
				}
				previous=current;
				current = current.next;
			}
			return false;
		}

	}

	public void display(){
		for(int i=0;i<capacity;i++){
			if(table[i]!=null){
				Entry<K, V> entry=table[i];
				while(entry!=null){
					System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
					entry=entry.next;
				}
			}
		}             

	}


	private int hash(int hash){
		hash ^= (hash >>> 20) ^ (hash >>> 12);
		int hashVal = hash ^ (hash >>> 7) ^ (hash >>> 4);
	    return indexFor(hashVal, capacity);
	    		
	}
	
	private int indexFor(int h, int length) {
	    return h & (length-1);
	}

	private void ensureCapacity() {
		if(insertionCount == (capacity - 1)) { //Table is full. Double it up.
			capacity = capacity * 2;
			table = Arrays.copyOf(table, capacity);
		}
	}

}


public class HashMapImplementation {

	public static void main(String[] args) {
		
		HashMapStandard<Integer,String> myMap = new HashMapStandard<Integer,String>();
		
		myMap.put(1, "ONE");
		myMap.put(2, "TWO");
		myMap.put(3, "THREE");
		myMap.put(4, "FOUR");
		myMap.put(5, "FIVE");
		myMap.put(6, "SIX");
		
		myMap.put(7, "SEVEN");
		myMap.put(8, "EIGHT");
		myMap.put(9, "NINE");
		myMap.put(10, "TEN");
		myMap.put(11, "ELEVEN");
		myMap.put(12, "TWELVE");
		
		
		System.out.println("TABLE SIZE : "+myMap.getTableSize());
		
	}
}