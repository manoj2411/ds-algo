import java.util.*;

/*
    https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
*/
class MinOpToReduceXtoZero {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1,1,4,2,3};
        int x = 5; // res: 2
        System.out.println("nums: " + Arrays.toString(nums) + ", x: " + x);
        System.out.println("Result: " + sol.minOperations(nums, x));

        nums = new int[] {5,6,7,8,9};
        x = 4; // res: -1
        System.out.println("nums: " + Arrays.toString(nums) + ", x: " + x);
        System.out.println("Result: " + sol.minOperations(nums, x));

        x = 11; // res: 2
        System.out.println("nums: " + Arrays.toString(nums) + ", x: " + x);
        System.out.println("Result: " + sol.minOperations(nums, x));

        nums = new int[]{3,2,20,1,1,3};
        x = 10; // res: 5
        System.out.println("nums: " + Arrays.toString(nums) + ", x: " + x);
        System.out.println("Result: " + sol.minOperations(nums, x));

    }
}

class Solution {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int result = Integer.MAX_VALUE;


        Map<Integer, Integer> sumRight = new HashMap<>();
        int cummSum = 0;
        for(int i = len - 1; i >= 0; i--) {
            cummSum += nums[i];
            sumRight.put(cummSum, i);
            if(x == cummSum)
                result = len - i;
        }

        cummSum = 0;
        for(int i = 0; i < len; i++) {
            cummSum += nums[i];
            if(cummSum == x) {
                result = Math.min(result, i + 1);
                break;
            } else if(cummSum > x) {
                break;
            } else if(sumRight.containsKey(x - cummSum) && sumRight.get(x - cummSum) > i) {
                int diff = len - sumRight.get(x - cummSum) + i + 1;
                result = Math.min(result, diff);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
