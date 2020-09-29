public class SubarrayProductLessThanK {
    static class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;

        int left = 0;
        int right = 0;
        int result = 0;
        int prod = 1;

        while(right < nums.length) {

            prod *= nums[right];

            while(prod >= k && left <= right) {
                prod /= nums[left];
                left++;
            }

            result += right - left + 1;
            right++;
        }
        return result;
    }
    /*
        [3,5,6,4], 2
        [1,1,1,1], 2
    */

    public int bruteForce(int[] nums, int k) {
        int result = 0;
        int[] curr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < k) result++;
            curr[i] = nums[i];
        }

        for(int width = 1; width < nums.length; width++) {
            int[] next = new int[nums.length];

            for(int i = width; i < nums.length; i++) {
                int prod = nums[i] * curr[i-1];
                if(prod < k) result++;
                next[i] = prod;
            }
            curr = next;
        }
        return result;
    }
}

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {10, 5, 2, 6};
        int k = 100; // res : 8
        System.out.println(sol.numSubarrayProductLessThanK(nums, k));
        // System.out.println(sol.bruteForce(nums, k));
        int[] nums2 = {3,5,6,4};
        k = 2; // res : 0
        System.out.println(sol.numSubarrayProductLessThanK(nums2, k));
        // System.out.println(sol.bruteForce(nums2, k));

    }
}
