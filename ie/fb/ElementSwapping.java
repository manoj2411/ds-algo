import java.util.*;

class ElementSwapping {

	public static void main(String[] args) {
	    int[] arr_1 = {5, 3, 1};
		System.out.println(
			Arrays.toString(new Solution().findMinArray(arr_1, 2))); // [1, 5, 3]

	    int[] arr_2 = {8, 9, 11, 2, 1};
	    System.out.println(
	    	Arrays.toString(new Solution().findMinArray(arr_2, 5))); // [1, 8, 9, 2, 11]

	}

}

class Solution {

  int[] findMinArray(int[] arr, int k) {
    // Write your code here

    int n = arr.length;

    for(int i = 0; i < n - 1 && k > 0; i++) {
      int minIndex = i;

      for(int j = i + 1; j < n && j <= i + k; j++) {
        if (arr[j] < arr[minIndex])
          minIndex = j;
      }

      if (minIndex != i) {
        int min = arr[minIndex];
        for(int j = minIndex; j > i; j--, k--) {
          arr[j] = arr[j - 1];
        }
         arr[i] = min;
      }
    }

    return arr;

  }
}
