import java.util.*;

/*
    https://leetcode.com/problems/find-the-most-competitive-subsequence/
*/
class MostCompetitiveSubsequence {
    public static void main(String[] args) {
        int[]nums = {3,5,2,6};
        int k = 2;
        int[] res = new Solution().mostCompetitive(nums, k);
        // res should be [2,6]
        System.out.println(Arrays.toString(res));

        nums = new int[]{2,4,3,3,5,4,9,6};
        k = 4;
        res = new Solution().mostCompetitive(nums, k);
        // res should be [2,3,3,4]
        System.out.println(Arrays.toString(res));
    }
}

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        int len = nums.length;
        for(int i = 0; i < len; i++) {

            while(stack.size() > 0 && stack.peek() > nums[i] && (stack.size() - 1) + len - i >= k) {
                stack.pop();
            }

            if(stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--)
            res[i] = stack.pop();

        return res;
    }
}
