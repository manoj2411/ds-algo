/*
	https://leetcode.com/problems/guess-number-higher-or-lower-ii/
*/
class GuessNumberHigherorLowerII {
	public static void main(String[] args) {
		System.out.println(new Solution().getMoneyAmount(6)); // 8
		System.out.println(new Solution().getMoneyAmount(4)); // 4
		System.out.println(new Solution().getMoneyAmount(10)); // 16
	}
}

class Solution {
    public int getMoneyAmount(int n) {
        int[][] cache = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if (i != j) cache[i][j] = -1;
            }
        }


        return helper(1, n, cache);

    }

    /*
        intution is to try to choose pivot between left + 1 and right - 1 and the solution is :
            Min of pivot + Max(left part of pivot , right part of pivot)

        time complexity : N^3
    */
    private int helper(int left, int right, int[][] cache) {

        if(cache[left][right] != -1)
            return cache[left][right];

        int min;

        if (right - left == 1) {
            min = left;
        } else if (right - left == 2) {
            min = left + 1;
        } else {
            min = Integer.MAX_VALUE;

            for(int pivot = left + 1; pivot < right; pivot++) {
                int curr = pivot + Math.max(
                    helper(left, pivot - 1, cache),
                    helper(pivot + 1, right, cache));
                min = Math.min(min, curr);
            }
        }

        cache[left][right] = min;

        return min;
    }
}
