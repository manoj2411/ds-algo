/*
	https://leetcode.com/problems/bitwise-and-of-numbers-range/
*/
class BitwiseANDofNumbersRange {
	public static void main(String[] args) {
		System.out.println(new Solution().rangeBitwiseAnd(5, 7)); // 4
		System.out.println(new Solution().rangeBitwiseAnd(1, 2147483647)); // 0
	}
}


class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shifts = 0;

        while(left != right) {

            left >>= 1;
            right >>= 1;
            shifts++;
        }

        return left << shifts;
    }
}

