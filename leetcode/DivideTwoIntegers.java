/*
	https://leetcode.com/problems/divide-two-integers/
*/
class DivideTwoIntegers {
	public static void main(String[] args) {
		System.out.println(new Solution().divide(10, 3)); // 3

		System.out.println(new Solution().divide(2147483647, 1)); // 2147483647
		System.out.println(new Solution().divide(-2147483648, 1)); // -2147483648
		System.out.println(new Solution().divide(-2147483648, -1)); // 2147483647
	}
}

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
        	return Integer.MAX_VALUE;
        }

        boolean isNegative = false;
        if ((dividend < 0 && divisor > 0) || (divisor < 0 && dividend > 0)){
        	isNegative = true;
        }

        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        long result = divide(ldividend, ldivisor);

        return (int)(isNegative ? -result : result);
    }

    private long divide(long dividend, long divisor) {
        if (divisor == 1) return dividend;
        if (dividend < divisor) return 0;

        long curr = divisor;
        long result = 1;

        while(curr + curr <= dividend ) {
            curr += curr;
            result += result;
        }

        return result + divide(dividend - curr, divisor);
    }
}
