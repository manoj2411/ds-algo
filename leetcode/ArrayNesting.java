/*
	https://leetcode.com/problems/array-nesting/
*/
class ArrayNesting {
	public static void main(String[] args) {
		int[] nums = {5,4,0,3,1,6,2};
		System.out.println(new Solution().arrayNesting(nums)); // 4

		nums = new int[] {0, 1, 2};
		System.out.println(new Solution().arrayNesting(nums)); // 1
	}
}

class Solution {
    public int arrayNesting(int[] nums) {
        int N = nums.length;
        boolean[] visited = new boolean[N];

        int maxSize = 0;
        for(int i = 0; i < N; i++) {
            if (visited[i] == false) {
                maxSize = Math.max(maxSize, getCycleSize(nums, i, visited));
            }
        }
        return maxSize;
    }

    private int getCycleSize(int[] nums, int curr, boolean[] visited) {

        if (visited[curr]) return 0;

        visited[curr] = true;
        return 1 + getCycleSize(nums, nums[curr], visited);
    }
}
