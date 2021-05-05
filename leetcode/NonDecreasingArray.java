/*
	https://leetcode.com/problems/non-decreasing-array/
*/
class NonDecreasingArray {
	public static void main(String[] args) {
		int[][] input = {
			{1,5,2,4,6}, 	// true
			{2,4,10,6,8}, 	// true
			{2,4,1,6,8}, 	// true
			{4,5,6,2,3,4},	// false
		};

		for(int[] arr : input)
			System.out.println(new Solution().checkPossibility(arr));
	}
}

class Solution {
	/*
		complexity:
			time :	O(N)
			space :	O(1)
	*/
    public boolean checkPossibility(int[] nums) {

        int i = findDecreasingIndex(nums);

        if (i == -1) return true;

        // now we have 2 possible ways of checking possibility,
        //  by making num[i-1] = num[i] OR num[i] = num[i-1]

        // case 1 : replace nums[i-1] with num[i]
        int prev = nums[i-1];
        nums[i-1] = nums[i];
        if (findDecreasingIndex(nums) == -1) return true;

        // case 2 : replace it with num[i] with num[i-1]
        nums[i] = prev;
        nums[i-1] = prev;

        return findDecreasingIndex(nums) == -1;
    }

    private int findDecreasingIndex(int[] nums) {

        for(int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i-1]) return i;

        return -1;
    }
}
