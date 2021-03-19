/*
    https://leetcode.com/problems/wiggle-subsequence/
*/
class WiggleSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9}; // 2
        System.out.println(new Solution().wiggleMaxLength(nums));

        nums = new int[] {1,7,4,9,2,5}; // 6
        System.out.println(new Solution().wiggleMaxLength(nums));

        nums = new int[] {1,17,5,10,13,15,10,5,16,8}; // 7
        System.out.println(new Solution().wiggleMaxLength(nums));

        nums = new int[] {10,5,5,7}; // 3
        System.out.println(new Solution().wiggleMaxLength(nums));
    }
}

class Solution {
    public int wiggleMaxLength(int[] nums) {
        /*
            The idea is to find count all diffs with sign changes i.e. pos to
             neg or neg to pos. Traverse twice, one trying to count assuming that
             the answer sequence will start from a positive number and another
             with an assumption that answer sequence will start with negative number.
        */

        return Math.max(
            countAlternateSigns(nums, -1),
            countAlternateSigns(nums, 1)
            ) + 1;
    }

    private int countAlternateSigns(int[] nums, int prev) {
        int count = 0;

        for( int i = 1; i < nums.length; i++) {
            int curr = nums[i] - nums[i-1]; // diffs[i];

            if (curr == 0) continue;
            if (( curr < 0 && prev > 0) || (curr > 0 && prev < 0)) count++;

            prev = curr;
        }
        return count;
    }
}
/*  complexity:

        time:   O(n)
        space:  O(1)
*/
