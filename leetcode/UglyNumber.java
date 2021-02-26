/*
	https://leetcode.com/problems/ugly-number/
*/
class UglyNumber {
	public static void main(String[] args) {
		int[] input = { 0, 1, 2, 6, 12, 8, 10, 14, 24, 25, 26};

		for(int n : input) {
			System.out.println("n: " + n + " isUgly: " + new Solution().isUgly(n));
		}
	}
}

class Solution {
    public boolean isUgly(int num) {
        if(num == 0) return false;

        while(num % 2 == 0) num = num / 2;
        while(num % 3 == 0) num = num / 3;
        while(num % 5 == 0) num = num / 5;

        return num == 1;
    }
}
