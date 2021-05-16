import java.util.*;
/*
		https://leetcode.com/problems/valid-number/
*/
class ValidNumber {
	public static void main(String[] args) {

		System.out.println(" Invalid cases ");
		for(String num : List.of("+.", ".e+7", "e", ".")) { // invalid cases
			System.out.println(new Solution().isNumber(num) + "\t : " + num);
		}

		System.out.println(" Valid cases ");
		for(String num : List.of("3.e+7", ".1", "1.", "+.1", "-.9", "-90E3", "+6e-1", "53.5e93")) { // valid cases
			System.out.println(new Solution().isNumber(num) + "\t : " + num);
		}

	}
}

class Solution {
    public boolean isNumber(String s) {

        boolean hasDot = false;
        boolean hasE = false;
        boolean hasDigit = false;

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == '+' || ch == '-') {
                if (i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')
                    return false;
            } else if (ch == '.') {
                if (hasDot || hasE)
                    return false;
                hasDot = true;

            } else if (ch == 'e' || ch == 'E') {

                if (hasE || !hasDigit)
                    return false;

                hasE = true;
                hasDigit = false;

            } else if(ch - '0' >= 0 && ch - '0' <= 9) {
                hasDigit = true;
            } else {
                return false;
            }
        }

        return hasDigit;
    }
}
