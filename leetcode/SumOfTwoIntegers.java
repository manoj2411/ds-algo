/*
	https://leetcode.com/problems/sum-of-two-integers/
*/
class SumOfTwoIntegers {
	public static void main(String[] args) {

		System.out.println(new Solution().getSum(2,3));  // 5
		System.out.println(new Solution().getSum(7,-5)); // 2
		System.out.println(new Solution().getSum(-7,5)); // -2
		System.out.println(new Solution().getSum(-1,1)); // 0
	}
}

class Solution {

    public int getSum(int a, int b) {

        while( b != 0) {

            int xor = a ^ b;
            int carry = (a & b) << 1;

            a = xor;
            b = carry;

        }

        return a;
    }
}
