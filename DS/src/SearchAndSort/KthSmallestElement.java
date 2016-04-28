package SearchAndSort;

import java.util.Arrays;

/*
 * NOTE : HANDLES DUPLICATE ELEMENTS AS WELL.
 * TO FIND MEDIAN : INPUT K = (SIZE/2)
 */

public class KthSmallestElement {
	
	public static <T extends Comparable<T>> T kthSmallest(T[] input, int start, int end, int k) {
		if((start < end)) {
			int pivot = pivotPartioner(input, start, end);
			if(pivot > (k-1)) {
				return kthSmallest(input, start, (pivot - 1), k);  //Left Sub-Array
			} else {
				return kthSmallest(input, (pivot+1), end, k);  //Right Sub-Array
			}
		}
		return input[k-1];
	}
	
	public static <T extends Comparable<T>> int pivotPartioner(T[] input, int start, int end) {
		
		T pivotValue = input[end];
		int pivotIndex = start;
		T tmp;
		for(int index = start; index < end; index++) {
			if(input[index].compareTo(pivotValue) < 0 || input[index].compareTo(pivotValue) == 0){
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
		//Integer[] input = {7,5,3,2,8,1,4,5,6,8,4,3,6,2};
		//Integer[] input = {12,16,2,3,1,9,4,18,22};
		Integer[] input = {3, 13, 7, 5, 21, 23, 23, 40, 23, 14, 12, 56, 23, 29};
		int[] sorted = {3, 13, 7, 5, 21, 23, 23, 40, 23, 14, 12, 56, 23, 29};
		
		System.out.println("Size :"+input.length);
		Arrays.sort(sorted);
		for(int i : sorted) {
			System.out.print(i+" ");
		}
		System.out.println();
		Integer kthSmallest = kthSmallest(input, 0, input.length - 1, ((input.length)/2));
		if(kthSmallest != null) {
			System.out.println("Kth Smallest Element is : "+kthSmallest);
		} else {
			System.out.println("Kth Smallest Element not found");
		}
	}

}
