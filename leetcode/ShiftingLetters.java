/*
	https://leetcode.com/problems/shifting-letters/
*/
class ShiftingLetters {
	public static void main(String[] args) {

		String str = "abc";
		int[] shifts = {3,5,9};
		System.out.println(new Solution().shiftingLetters(str, shifts)); // "rpl"

		str = "abc";
		shifts = new int[] {100000004, 100000009, 100000001};
		System.out.println(new Solution().shiftingLetters(str, shifts)); // "cdz"

		str = "ruu";
		shifts = new int[] {26,9,17};
		System.out.println(new Solution().shiftingLetters(str, shifts)); // "rul"
	}
}


class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int N = s.length();

        shifts[N-1] = shifts[N-1] % 26;
        for(int i = N - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i+1]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            int absShifts = (ch - 'a' + shifts[i]) % 26;
            char newChar = (char)( 'a' + absShifts);

            sb.append(newChar);
        }

        return sb.toString();

    }
}
