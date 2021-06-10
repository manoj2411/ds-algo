import java.util.*;

/*
		https://leetcode.com/problems/jump-game-vi/
*/
class JumpGameVI {
	public static void main(String[] args) {
		int[] nums = {1,-1,-2,4,-7,3};
		int k = 2;
		System.out.println(new Solution().maxResult(nums, k)); // 7

		nums = new int[] {1,-5,-20,4,-1,3,-6,-3};
		k = 2;
		System.out.println(new Solution().maxResult(nums, k)); // 0

	}
}

class Solution {

    public int maxResult(int[] nums, int k) {
        int len = nums.length;

        int[] score = new int[len];
        score[0] = nums[0];

        Deque<Integer> deq = new LinkedList<>();
        deq.add(0);

        for(int i = 1; i < len; i++) {


            if (deq.peek() < i - k)
                deq.remove();

            score[i] = nums[i] + score[deq.peek()];

            while (deq.size() > 0 && score[deq.peekLast()] <= score[i])
                deq.removeLast();

            deq.add(i);

        }

        return score[len - 1];
    }
}
