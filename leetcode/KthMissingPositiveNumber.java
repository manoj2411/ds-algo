/*
	https://leetcode.com/problems/kth-missing-positive-number/
*/
class KthMissingPositiveNumber {
	public static void main(String[] args) {
		int[] arr = {2,3,4,7,11};
		System.out.println(new Solution().findKthPositive(arr, 1)); // 1
		System.out.println(new Solution().findKthPositive(arr, 5)); // 9
		System.out.println(new Solution().findKthPositive(arr, 6)); // 10
		System.out.println(new Solution().findKthPositive(arr, 7)); // 12
	}
}

class Solution {

    /*
      	The idea is to find last position where the missing nums are < k
      	 then the result is that position + 1 + k.
      	Assumption is the result lies between the first and last element of the
		 array, to make sure of this, handle base cases in the beginning
    */

    public int findKthPositive(final int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        // 2 base cases :
        if (arr[low] > k) return k;
        if ( arr[high] - (high + 1) < k) return high + 1 + k;


        while(high - low > 1) {
            int mid = (low + high) / 2;

            // System.out.println(" mid: " + mid);
            if ( arr[mid] - (mid + 1) >= k) high = mid - 1;
            else low = mid;
        }

        if (arr[high] - (high + 1) < k)
            return high + 1 + k;
        else
            return low + 1 + k;
    }

}
