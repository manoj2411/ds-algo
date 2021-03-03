import java.util.*;

/*
		https://leetcode.com/problems/set-mismatch/
*/
class SetMismatch {
	public static void main(String[] args) {
		int[][] input = {
			{1,2,2,3,4}, // [2,5]
			{2,1,2,4},   // [2,3]
			{2,2},       // [2,1]
			{2,2,3}      // [2,1]
		};

		for(int[] arr : input ) {

			int[] res = new Solution().findErrorNums(arr);

			System.out.println(Arrays.toString(res));
		}
	}
}

class Solution {
    public int[] findErrorNums(int[] nums) {

        int dup = -1;
        for(int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);

            if (nums[x-1] < 0)
                dup = x;
            else
                nums[x-1] = -nums[x-1];
        }

        int missing = -1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i+1;
                break;
            }
        }

        return new int[]{dup, missing};

    }
}
/*  complexity of the solution:

		time complexity 	: O(N)
		space complexity 	: O(1)

*/
