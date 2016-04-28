package SearchAndSort;

import java.util.ArrayList;

public class BinarySearch {
	
	public static <T extends Comparable<T>> int binarySearchEngine(ArrayList<T> list, T searchTerm) {
		if(list == null || list.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int low = 0;
		int high = list.size() -1;
		
		while(low <= high) {
			int mid = (low+high)/2;
			if(list.get(mid).compareTo(searchTerm) == 0) {
				return mid;
			} else if(list.get(mid).compareTo(searchTerm) < 0) {
				low = mid +1;
			} else {
				high = mid -1;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
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
		int index = binarySearchEngine(list, 30);
		if(index != Integer.MIN_VALUE) {
			System.out.println("TERM FOUND :"+list.get(index));
		} else {
			System.out.println("TERM DOESNOT EXIST");
		}
	} 
}
