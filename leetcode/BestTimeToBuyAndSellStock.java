/*
	https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(new Solution().maxProfit(prices)); // 5

		prices = new int[] {7,5,3,2};
		System.out.println(new Solution().maxProfit(prices)); // 0
	}
}

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                minPrice = Math.min(minPrice, prices[i-1]);
            }
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}
