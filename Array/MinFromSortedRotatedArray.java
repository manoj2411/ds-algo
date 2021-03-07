import java.util.*;

/*
	https://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1#
*/
class MinFromSortedRotatedArray {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 5, 7};
		System.out.println(Arrays.toString(arr) + " => " +
			new Solution().findMin(arr, arr.length));

		arr = new int[] {4 ,5 ,1 ,2 ,3};
		System.out.println(Arrays.toString(arr) + " => " +
			new Solution().findMin(arr, arr.length));

		arr = new int[] {1 ,2 ,3,4};
		System.out.println(Arrays.toString(arr) + " => " +
			new Solution().findMin(arr, arr.length));
	}
}

class Solution {

    int findMin(int arr[], int n) {
        int l = 0;
        int r = n - 1;

        if (arr[l] < arr[r]) return arr[l];

        while (r - l > 1 ) {

            int mid = (r + l) / 2;

            if(arr[mid] > arr[l])
                l = mid;
            else
                r = mid;
        }

        return Math.min(arr[l], arr[r]);
    }
}
