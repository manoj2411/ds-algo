import java.util.*;

/*
		https://leetcode.com/problems/coin-change/
*/
class CoinChange {
	public static void main(String[] args) {

	}
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        // Arrays.sort(coins); // not really required

        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int amt = 1; amt <= amount; amt++)
            dp[0][amt] = 10_001; // max possible result + 1 to mark no answer

        for(int r = 1; r <= coins.length; r++) {
            for(int amt = 1; amt <= amount; amt++) {

                int currCoin = coins[r-1];

                if (currCoin > amt) {
                    dp[r][amt] = dp[r-1][amt];
                } else {
                    dp[r][amt] = Math.min(
                        dp[r-1][amt],
                        1 + dp[r][amt - currCoin]
                    );
                }
            }
        }

        int result = dp[coins.length][amount];


        /*		TOP DOWN 	*/
        // int[][] cache = new int[coins.length][amount+1];
        // for(int j = 0; j < coins.length; j++)
        //     for(int i = 0; i <= amount; i++)
        //         cache[j][i] = -1;

        // int result = helper(coins, amount, coins.length - 1, cache);

        return result <= 10000 ? result : -1;
    }

    private int helper(int[] coins, int amount, int i, int[][] cache) {
        if (i < 0 || amount < 0) return 10001;
        else if (amount == 0) return 0;
        else if (coins[i] > amount) return helper(coins, amount, i - 1, cache);

        if (cache[i][amount] == -1) {
            int result = Math.min(1 + helper(coins, amount - coins[i], i, cache),
                                  helper(coins, amount, i - 1, cache)
                                 );
            // return result;
            cache[i][amount] = result;
        }

        return cache[i][amount];
    }
}

/*
	complexity of th solution

		time: 	O(N*Amt)
		space: 	O(N*Amt) ## TODO: Space can be optimized, reduce to O(Amt)
*/

