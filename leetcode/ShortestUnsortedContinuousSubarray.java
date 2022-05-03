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
            System.out.println("(optimized solution): "
                + new OptSolution().findUnsortedSubarray(nums));
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

class OptSolution {

    /* Complexity

        time    : O(N)
        space   : O(1)
    */
    public int findUnsortedSubarray(int[] nums) {

        int max = nums[0];
        int start = nums.length + 1;
        int end = -1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= max) { // happy case, sorted
                max = nums[i];
            } else {             // unsorted item occurred

                if(start > i) start = i - 1; // first time setting start

                while(start >= 0 && nums[start] > nums[i]) {
                    start--;
                } // now nums[start] will contains a value that is less than or eq to nums[i],
                  //  means start + 1 is the correct position for this item.

                end = i;
            }
        }

        return end == -1 ? 0 : end - start;
    }
}

class SimplifiedOptimalSolution {

    /* Complexity

        time    : O(N)
        space   : O(1)


        idea is to find left and right such that
        (0..left) is sorted and (right..len-1) is sorted

        to find left, traverse from last to first index, keep a min till now
         curr is supposed to be <= min in a sorted array, if this is not the case
         then store the index as left, last left will be our first element out of order.
        Similarly find right, traverse from 0 to last index, keep a max till now
         curr is suppose to be >= max in a sorted array, if this not the case then
         store the index as right, last right will be our last element out of sync

    */
    public int findUnsortedSubarray(int[] nums) {

        int left = -1;
        int min = nums[nums.length - 1];
        for(int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min ) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        if (left == -1) {
            return 0;
        }

        int right = nums.length;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }
        return (right - left) + 1;
    }
}
