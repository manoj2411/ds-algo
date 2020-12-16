import java.util.*;

/*
	https://leetcode.com/problems/squares-of-a-sorted-array/
*/
class SquaresOfSortedArray {

	public static void main(String[] args) {
		int[][] input = {
			{-4,-1,0,3,10},
			{-7,-3,2,3,11},
			{1,2,3,4,5},
			{-4,-3,-2,-2}
		};

		for(int[] arr : input) {
			Solution sol = new Solution();
			System.out.println("arr: " + Arrays.toString(arr));
			System.out.println("squares : " + Arrays.toString(sol.sortedSquares(arr)));
			System.out.println();
		}
	}
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = -1;
        int right = nums.length;

        while(right - left > 1) {
            int mid = (right + left) / 2;
            if(nums[mid] >= 0)
                right = mid;
            else
                left = mid;
        }
        // System.out.println("left: " + left + ", right: " + right);

        int[] res = new int[nums.length];
        int i = 0;
        while(left >= 0 || right < nums.length) {
            if(left < 0) {
                res[i++] = nums[right] * nums[right];
                right++;
            } else if(right == nums.length) {
                res[i++] = nums[left] * nums[left];
                left--;
            } else if(Math.abs(nums[left]) < nums[right]) {
                res[i++] = nums[left] * nums[left];
                left--;
            } else {
                res[i++] = nums[right] * nums[right];
                right++;
            }

        }

        return res;
    }
}