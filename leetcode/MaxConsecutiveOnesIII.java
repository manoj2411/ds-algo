/*
	https://leetcode.com/problems/max-consecutive-ones-iii/
*/
class MaxConsecutiveOnesIII {
	public static void main(String[] args) {
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		System.out.println(new Solution().longestOnes(nums, k)); // 6

		nums = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		k = 3;
		System.out.println(new Solution().longestOnes(nums, k)); // 10
	}
}

class Solution {

    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int start = 0;
        int flippedZeros = 0;

        for(int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                if (flippedZeros < k) {
                    flippedZeros++;
                } else {
                    while(nums[start] == 1) start++;
                    start++;
                }
            }
            max = Math.max(max, end - start + 1);
        }

        return max;
    }

}
