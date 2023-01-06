import java.util.*;

/*
	https://leetcode.com/problems/maximum-ice-cream-bars/description/
*/
class MaximumIceCreamBars {
	public static void main(String[] args) {

		int[] costs = {1,3,2,4,1};
		int coins = 7;
		System.out.println(new Solution().maxIceCream(costs, coins)); // 7

	}
}

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int boughtBars = 0;

        for(int i = 0; i < costs.length; i++) {
            if (costs[i] > coins) {
                break;
            }

            coins -= costs[i];
            boughtBars++;
        }

        return boughtBars;
    }
}
