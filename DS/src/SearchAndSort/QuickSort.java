package SearchAndSort;

public class QuickSort {
	
	public static <T extends Comparable<T>> void quickSort(T[] input, int start, int end) {
		if(input == null || input.length == 0) {
			return;
		}
		if(start < end) {
			int pivotIndex = partitioner(input, start, end);
			quickSort(input, start, (pivotIndex - 1));  //Left Sub-Array
			quickSort(input, (pivotIndex+1), end);  //Right Sub-Array
		}
	}
	
	public static <T extends Comparable<T>> int partitioner(T[] input, int start, int end) {
		T pivotValue = input[end];
		int pivotIndex = start;
		T tmp;
		for(int index = start; index < end; index++) {
			if(input[index].compareTo(pivotValue) < 0 || input[index].compareTo(pivotValue) == 0) {
				tmp = input[index];
				input[index] = input[pivotIndex];
				input[pivotIndex] = tmp;
				pivotIndex++;
 			}
		}
		tmp = input[pivotIndex];
		input[pivotIndex] = input[end];
		input[end] = tmp;
		return pivotIndex;
		
	}
	
	public static void main(String[] args) {
		
		Integer[] input = {7,5,3,2,8,1,4,5,6,8,4,3,6,2};
		//String[] input = {"Yagna","Sridhar","Vamsi","Praveen","Harsha","Neelu"};
		quickSort(input, 0, input.length-1);
		for(int i : input) {
			System.out.print(i+" ");
		}
	}

}
