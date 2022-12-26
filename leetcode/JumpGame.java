/*
	https://leetcode.com/problems/jump-game/
*/
class JumpGame {
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(new Solution().canJump(nums)); // true;
		nums = new int[] {3,2,1,0,4};
		System.out.println(new Solution().canJump(nums)); // false;
	}
}

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;

        int i = 0;
        int max = nums[0];

        while (i <= max) {
            max = Math.max(max, i + nums[i]);
            i++;

            if(max >= len - 1) return true;

        }

        return false;

    }
}

class AlternateSolution {

    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length && max >= i; i++) {
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
