/*
    https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
*/
class LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String... args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(new Solution().longestSubarray(nums)); // 5
    }
}

class Solution {
    public int longestSubarray(int[] nums) {
        int prevGroup = 0; //    2
        int max = 0;  //    5
        int currGroup = 0;  //   0
        boolean allOne = true;

        for(int num : nums) { 
            if (num == 1) {
                currGroup++;
            } else {
                prevGroup = currGroup;
                currGroup = 0;
                allOne = false;
            }
            max = Math.max(max, currGroup + prevGroup);
        }

        return allOne ?  max - 1 : max;
    }
}
