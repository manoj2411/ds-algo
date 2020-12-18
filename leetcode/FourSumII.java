import java.util.*;
/*
		https://leetcode.com/problems/4sum-ii/
*/
class FourSumII {

	public static void main(String[] args) {
		int[] A = { 1, 2};
		int[] B = {-2,-1};
		int[] C = {-1, 2};
		int[] D = { 0, 2};
		Solution sol = new Solution();

		System.out.println(sol.fourSumCount(A, B, C, D));
	}
}

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(N * N, 1.0f);

        for(int a : A) {
            for(int b : B) {
                int c = map.getOrDefault(a + b, 0);
                map.put(a + b, c + 1);
            }
        }

        int count = 0;

        for(int c : C) {
            for(int d : D) {
                int sum = c + d;
                if(map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }

        return count;

    }
}