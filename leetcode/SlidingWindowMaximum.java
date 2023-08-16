import java.util.*;

/*
	https://leetcode.com/problems/sliding-window-maximum/
*/

class SlidingWindowMaximum {
	public static void main(String... args) {
		int[] nums1 = {1,3,-1,-3,5,3,6,7};
		System.out.println(Arrays.toString(
			new Solution().maxSlidingWindow(nums1, 3)
		)); // [3,3,5,5,6,7]
	}
}

class Solution {

    /**
     * 	https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
     *
     * push, pop, peek operations done from the front or first!
     *
        deq: (3, i1)
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Num> deq = new LinkedList<>();

        for(int i = 0; i < k; i++) {
            while(deq.size() > 0 && deq.peek().val < nums[i]) {
                deq.pop();
            }
            deq.push(new Num(nums[i], i));
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = deq.peekLast().val;

        for(int i = k; i < nums.length; i++) {
            if(deq.peekLast().index == i - k) {
                deq.removeLast();
            }

            while(deq.size() > 0 && deq.peek().val < nums[i]) {
                deq.pop();
            }

            deq.push(new Num(nums[i], i));
            result[i-k+1] = deq.peekLast().val;
        }

        return result;
    }

    record Num(int val, int index) {};
}
