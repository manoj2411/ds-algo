/*
	https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/
class BestTimeToBuyAndSellStockII {
	public static void main(String[] args) {
		int[] prices = {7,1,5,7,3,6,4};
		System.out.println(new Solution().maxProfit(prices)); // 9

		prices = new int[] {1,2,3,4,5};
		System.out.println(new Solution().maxProfit(prices)); // 4

		prices = new int[] {5,4,3};
		System.out.println(new Solution().maxProfit(prices)); // 0
	}
}


class Solution {

    public int maxProfit(int[] prices) {

        int buyAt = -1;
        int profit = 0;

        for(int i = 0; i < prices.length - 1; i++) {

            if (buyAt == -1) { // need to buy
                if (prices[i] < prices[i + 1])
                    buyAt = prices[i];
            } else { // need to sell to make profit

                if (prices[i] > prices[i+1]) {
                    profit += prices[i] - buyAt;
                    buyAt = -1;
                }
            }
        }

        if(buyAt != -1) profit += prices[prices.length - 1] - buyAt;

        return profit;
    }
}
