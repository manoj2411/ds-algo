import java.util.*;

/*
	https://leetcode.com/problems/find-k-closest-elements/
*/
class FindKClosestElements {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int k = 4;
		int x = 3;

		System.out.println(new Solution().findClosestElements(arr, k, x));
		// Output: [1,2,3,4]
	}
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int mid = findClosest(arr, x);
        int left = mid;
        int right = mid;

        while(right - left + 1 < k) {
            int nextl = left - 1;
            int nextr = right + 1;

            if (nextl < 0) right++;
            else if (nextr == arr.length) left--;
            else if (Math.abs(arr[nextl] - x) <= Math.abs(arr[nextr] - x) ) left--;
            else right++;
        }

        List<Integer> res = new ArrayList<>();

        for(int i = left; i <= right; i++)
            res.add(arr[i]);

        return res;
    }

    /*	TODO: the arr is sorted, apply binary search to find closest element */
    int findClosest(int[] arr, int x) {

        int mid = -1;
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < diff) {
                mid = i;
                diff = Math.abs(arr[i] - x);
            } else if (Math.abs(arr[i] - x) > diff) break;
        }
        return mid;
    }
}
