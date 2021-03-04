import java.util.*;
/*
		https://leetcode.com/problems/missing-number/
*/
class MissingNumber {
	public static void main(String[] args) {
		int[][] input = {
			{9,6,4,2,3,5,7,0,1}, // 8
			{3,0,1}, // 2
			{0}, // 1
			{1}, // 0
		};

		for(int[] nums : input) {
			System.out.println("nums: " + Arrays.toString(nums));
			System.out.println("missing number: " + new Solution().missingNumber(nums));
			System.out.println();
		}
	}
}

class Solution {
    public int missingNumber(int[] nums) {
        int xor = nums.length;

        for(int i = 0; i < nums.length; i++)
            xor ^= nums[i] ^ i;

        return xor;
    }
}

/* complexity
	time: 	O(N)
	space: 	O(1) constant space

*/
