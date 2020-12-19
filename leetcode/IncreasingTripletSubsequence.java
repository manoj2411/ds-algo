import java.util.*;

/*
	https://leetcode.com/problems/increasing-triplet-subsequence/
*/
class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		int[][] input = {
			{1,2,3,4,5},
			{6,5,4,3,2,1},
			{2,1,5,0,4,6},
			{2,1,5,0,6},
			{2,1,5,0,1,4}
		};

		for(int[] arr : input) {
			System.out.println("Nums : " + Arrays.toString(arr));
			System.out.println("Has increasing triplet? : " +
				new Solution().increasingTriplet(arr));
			System.out.println();
		}
	}
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;

        if(len <= 2) return false;

        int[] minLeft = new int[len];
        int[] maxRight = new int[len];

        int l = 0;
        int r = len - 1;

        minLeft[l++] = nums[0];
        maxRight[r--] = nums[len - 1];
        for(; r >= 0; r--, l++) {
            minLeft[l] = Math.min(minLeft[l-1], nums[l]);
            maxRight[r] = Math.max(maxRight[r+1], nums[r]);
        }

        // System.out.println("minLeft: " + Arrays.toString(minLeft));
        // System.out.println("maxRight: " + Arrays.toString(maxRight));

        for(int i = 1; i < len - 1; i++) {
            if(nums[i] > minLeft[i] && maxRight[i] > nums[i])
                return true;
        }

        return false;
    }
}