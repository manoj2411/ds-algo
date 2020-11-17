import java.util.*;

//  (or K sorted) array
class SortNearlySortedList {
  public static void main(String[] args) {
    int[] arr = {6, 5, 3, 2, 8, 10, 9};
    System.out.println(Arrays.toString(arr));
    sort(arr, arr.length, 3);
    System.out.println(Arrays.toString(arr));    
  }
  
	static void sort(int[] a, int n, int k) {
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    
	    for(int i = 0; i < k; i++)
	        minHeap.add(a[i]);
	    
	    for(int i = 0; i < n ; i++) {
	        if(k+i < n)
	            minHeap.add(a[k+i]);
	        a[i] = minHeap.remove();
	    }
	}  
}
