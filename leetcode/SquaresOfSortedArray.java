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
    /*
        idea is simple, take 2 pointer left and right that starts with pointing
         first and last element, then check whose absolute value is greater and
         put it in the result and move to the next element.
    */
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;

        int[] result = new int[N];

        int r = N - 1;
        int left = 0;
        int right = N - 1;

        while(left <= right) {

            if ( Math.abs(nums[left]) > Math.abs(nums[right]) ) { // process left
                result[r] = nums[left] * nums[left];
                left++;
            } else { // process right
                result[r] = nums[right] * nums[right];
                right--;
            }

            r--;
        }

        return result;
    }


    /*
        Idea is to do binary search to find closest positive to 0 and closest
        negative to 0 using binary search as left and right and then fill in
        result array moving left towards 0 and right towards length()
    */
    public int[] sortedSquaresOld(int[] nums) {
        int left = -1;
        int right = nums.length;

        while(right - left > 1) {
            int mid = (right + left) / 2;
            if(nums[mid] >= 0)
                right = mid;
            else
                left = mid;
        }
        System.out.println("left: " + left + ", right: " + right);

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
