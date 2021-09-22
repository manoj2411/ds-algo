/*
    https://leetcode.com/problems/max-consecutive-ones/
*/
class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};

        System.out.println(new Solution().findMaxConsecutiveOnes(nums)); // 3
    }
}


class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int num : nums) {
            if (num == 1) count++;
            else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        return Math.max(maxCount, count);
    }
}
