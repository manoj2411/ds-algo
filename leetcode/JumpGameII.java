import java.util.*;

/*
		https://leetcode.com/problems/jump-game-ii/
*/
class JumpGameII {
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4}; // 2
		System.out.println(new Solution().jump(nums));

		nums = new int[] {2,3,0,1,4}; // 2
		System.out.println(new Solution().jump(nums));
	}
}

class Solution {
    public int jump(int[] nums) {

        int len = nums.length;
        int[] jumps = new int[len];
        for(int i = 0; i < len; i++)
            jumps[i] = Integer.MAX_VALUE;

        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        jumps[0] = 0;

        while(que.size() > 0) {
            int curr = que.remove();

            if(curr == len - 1) continue;

            for(int i = 1; i <= nums[curr]; i++) {

                if (curr + i < len && (jumps[curr] + 1) < jumps[curr+i]  ) {
                    jumps[curr + i]  = jumps[curr] + 1;
                    que.add(curr + i);
                }

            }
            // System.out.println("for " + curr + " : " + Arrays.toString(jumps));
        }

        return jumps[len - 1];
    }
}
