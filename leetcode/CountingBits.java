/*
    https://leetcode.com/problems/counting-bits/
*/

import java.util.*;

class CountingBits {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
			new Solution().countBits(2))); // [0, 1, 1]

		System.out.println(Arrays.toString(
			new Solution().countBits(5))); // [0,1,1,2,1,2]
	}
}

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i % 2);
        }

        return result;
    }
}
