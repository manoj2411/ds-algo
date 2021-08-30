/*
	https://leetcode.com/problems/patching-array/
*/
class PatchingArray {
	public static void main(String[] args) {
		int[] nums = {1,3};
		int n = 6;
		System.out.println(new Solution().minPatches(nums, n)); // 1

		nums = new int[] {1,5,10};
		n = 20;
		System.out.println(new Solution().minPatches(nums, n)); // 2

		nums = new int[]{1,2,2};
		n = 5;
		System.out.println(new Solution().minPatches(nums, n)); // 0

	}
}


class Solution {
    public int minPatches(int[] nums, int n) {
    	// this track till which number we covered. when it goes above n means we
    	// covered all the number till n
        long numsCovered = 0; // it'll go above int limit and mess up the calculation

        // track number patches we need to do in order to reach n
        int patches = 0;

        // track curr element in the sorted nums array
        int i = 0;
        while (numsCovered < n) {
        	/*		CORE LOGIC

				(numsCovered + 1) : is the min next number we should to cover
				it is either available in the array as current element or we
				need to patch the array in order to cover it

        	*/
            if (i < nums.length && nums[i] <= numsCovered + 1) {
                numsCovered += nums[i++];
            } else {
                numsCovered += numsCovered + 1;
                patches++;
            }
        }

        return patches;
    }
}
