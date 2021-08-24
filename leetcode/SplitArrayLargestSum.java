import java.util.*;

/*
	https://leetcode.com/problems/split-array-largest-sum/
*/
class SplitArrayLargestSum {
	public static void main(String[] args) {
		int[] nums = {7,2,5,10,8};

		System.out.println(new Solution().splitArray(nums, 2)); // 18

		System.out.println(new Solution().splitArray(nums, 3)); // 14
	}
}

class Solution {

    int[][] cache;

    public int splitArray(int[] nums, int m) {
        if (m == 1) {
            return getSum(nums);
        }

        cache = new int[nums.length][m+1];
        for(int i = 0; i < nums.length; i++) Arrays.fill(cache[i], -1);


        return lowestMaxPartition(nums, 0, m);
    }

    private int lowestMaxPartition(int[] nums, int start, int m) {

        if (cache[start][m] != -1) return cache[start][m];

        if (m == 2) {
            cache[start][m] = lowestMaxPartition(nums, start);
            return cache[start][m];
        }

        int result = Integer.MAX_VALUE;

        int currSum = 0;
        for(int i = start; i <= (nums.length - m); i++) {
            currSum += nums[i];

            int max = Math.max(currSum, lowestMaxPartition(nums, i + 1, m - 1));
            // System.out.println("max: " + max);
            result = Math.min(result, max);
        }

        cache[start][m] = result;
        return cache[start][m];
    }

    private int lowestMaxPartition(int[] nums, int start) {
        int right = nums.length - 1;
        int left = start;
        int lsum = nums[left];
        int rsum = nums[right];

        while(right - left > 1) {
            if (lsum < rsum) lsum += nums[++left];
            else rsum += nums[--right];
        }
        return Math.max(lsum, rsum);
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        return sum;
    }
}
