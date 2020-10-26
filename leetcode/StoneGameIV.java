/*
        https://leetcode.com/problems/stone-game-iv/
*/
class StoneGameIV {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.winnerSquareGame(1)); // true
        System.out.println(sol.winnerSquareGame(2)); // false
        System.out.println(sol.winnerSquareGame(7)); // false
        System.out.println(sol.winnerSquareGame(17)); // false
    }
}

class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                int square = j * j;
                if(dp[i - square] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
