import java.util.*;

class BalancedSplit {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 5, 7, 1};
		System.out.println(new Solution().balancedSplitExists(arr)); 	// true
		arr = new int[] {12, 7, 6, 7, 6};
		System.out.println(new Solution().balancedSplitExists(arr)); 	// false
		arr = new int[] {};
		System.out.println(new Solution().balancedSplitExists(arr)); 	// false
		arr = new int[] { 2,};
		System.out.println(new Solution().balancedSplitExists(arr));	// false
		arr = new int[] {20, 2,};
		System.out.println(new Solution().balancedSplitExists(arr));	// false
		arr = new int[] {5,7,20,12,5,7,6,14,5,5,6,};
		System.out.println(new Solution().balancedSplitExists(arr));	// true
		arr = new int[] {5,7,20,12,5,7,6,7,14,5,5,6,};
		System.out.println(new Solution().balancedSplitExists(arr));	// false
		arr = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,};
		System.out.println(new Solution().balancedSplitExists(arr));	// false
		arr = null;
		System.out.println(new Solution().balancedSplitExists(arr)); 	// false
	}
}


class Solution {
	boolean balancedSplitExists(int[] arr) {

		if (arr == null || arr.length < 2) return false;

	    Arrays.sort(arr);

	    int left = 0;
	    int right = arr.length - 1;
	    int leftSum = arr[left];
	    int rightSum = arr[right];

	    if(arr[left] == arr[right]) return false;

	    while(arr[left + 1] == arr[left])
	      	leftSum += arr[left++];

	    while(arr[right - 1] == arr[right])
	      	rightSum += arr[right--];

	    while(right - left > 1) {
	      	if (rightSum < leftSum) {
	        	rightSum += arr[--right];
	        	while(arr[right - 1] == arr[right])
	          		rightSum += arr[right--];
	      	} else {
	        	leftSum += arr[++left];
	        	while(arr[left + 1] == arr[left])
	          		leftSum += arr[left++];
	      	}
	    }

    	return leftSum == rightSum;
  }
}
