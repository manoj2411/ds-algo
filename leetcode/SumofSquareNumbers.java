/*
	https://leetcode.com/problems/sum-of-square-numbers/
*/
class SumofSquareNumbers {
	public static void main(String[] args) {
		System.out.println(new Solution().judgeSquareSum(4)); // true
		System.out.println(new Solution().judgeSquareSum(25)); // true
		System.out.println(new Solution().judgeSquareSum(122)); // true
		System.out.println(new Solution().judgeSquareSum(2147483647)); // false
	}
}

class Solution {
    public boolean judgeSquareSum(int c) {

        for(int b = 0; (b * b) <= c; b++) {
            int b2 = b * b;
            int a2 = c - b2; // calculate a square number, check if this number is perfect square

            double a = Math.sqrt(a2);

            if ((a - (int)a) == 0) { // means we a_square is a perfect square root
                return true;
            }

            if (a2 < b2) break; // otherwise we'll repeat the checks in reverse order
        }

        return false;
    }
}
