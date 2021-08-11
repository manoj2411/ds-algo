/*
	https://leetcode.com/problems/flip-string-to-monotone-increasing/
*/
class FlipStringToMonotoneIncreasing {
	public static void main(String[] args) {

		System.out.println(new Solution().minFlipsMonoIncr("00110"));// 1
		System.out.println(new Solution().minFlipsMonoIncr("010110"));// 2
		System.out.println(new Solution().minFlipsMonoIncr("00011000"));// 2
		System.out.println(new Solution().minFlipsMonoIncr("10011111110010111011")); // 5
		System.out.println(new Solution().minFlipsMonoIncr("0101100011")); // 3

	}
}

class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] flip0 = new int[len];
        int[] flip1 = new int[len];

        int sum = 0;
        for(int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') sum++;
            flip1[i] = sum;
        }

        sum = 0;
        for(int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') sum++;
            flip0[i] = sum;
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++)
            min = Math.min(min, (flip0[i] + flip1[i]) - 1);

        return min;
    }
}
