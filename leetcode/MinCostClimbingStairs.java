class MinCostClimbingStairs {
	public static void main(String[] args) {
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		System.out.println(new Solution().minCostClimbingStairs(cost)); // 6
	}
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev1 = cost[1];
        int prev2 = cost[0];

        for(int i = 2; i < cost.length; i++) {
            int curr = Math.min(prev1, prev2) + cost[i];
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
    }
}
