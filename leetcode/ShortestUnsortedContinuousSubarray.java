import java.util.*;

/*
	https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
*/
class ShortestUnsortedContinuousSubarray {
	public static void main(String[] args) {
		int[][] input = {
			{2,6,4,8,10,9,15}, 		// 5
			{1}, 					// 0
			{1,1,1,1,12,2,2,2,3,3},	// 6
			{1,2,3,4,5},			// 0
			{5,4,3,2,1},			// 5
		};

		for(int[] nums : input) {
			System.out.println("nums: " + Arrays.toString(nums));
			System.out.println("length of unsorted array: "
				+ new Solution().findUnsortedSubarray(nums));
			System.out.println();
		}
	}
}
class Solution {
		/* Complexity

			time 	: O(N)
			space 	: O(N)
		*/

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int start = nums.length + 1; 	// tracks start of unsorted array
        int end = -1;					// tracks start of unsorted array
        int currMax = nums[0];			// tracks max till current element

        stack.push(0);

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] < currMax) { // means current element is unsorted and we might need to adjust start

            	// remove elements that are greater then current element so that we know the
            	// the correct position for current element P.S. adjust start of unsorted list
                while(stack.size() > 0 && nums[i] < nums[stack.peek()])
                    stack.pop();

                if(stack.isEmpty()) // means current element will be the first element.
                    start = -1;
                else
                    start = Math.min(start, stack.peek()); // find smaller possible start

                end = i;

            } else {
                stack.push(i);
                currMax = Math.max(currMax, nums[i]);
            }
        }

        return end == -1 ? 0 : end - start;

    }
}
