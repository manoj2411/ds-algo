/*
	https://leetcode.com/problems/integer-break/
*/
class IntegerBreak {
	public static void main(String... args) {
		System.out.println(new Solution().integerBreak(10)); // 36
		System.out.println(new Solution().integerBreak(11)); // 54
	}
}

class Solution {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }

        int[] cache = new int[n+1];
        cache[2] = 2;
        cache[3] = 3;

        for(int a = 4; a <= n; a++) {
            cache[a] = a;
            for(int b = 2; b <= a / 2; b++) {
                cache[a] = Math.max(cache[a], cache[b] * cache[a-b]);
            }
        }
        return cache[n];
    }
}
