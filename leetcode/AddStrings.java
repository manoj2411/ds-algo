/*
		https://leetcode.com/problems/add-strings/
*/
class AddStrings {
	public static void main(String[] arg) {
		System.out.println(new Solution().addStrings("11", "123")); // "134"
		System.out.println(new Solution().addStrings("456", "77")); // "533"
		System.out.println(new Solution().addStrings("0", "0")); // "0"
	}
}


class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 < len2)
            num1 = padZeros(len2 - len1) + num1;
        else if (len1 > len2)
            num2 = padZeros(len1 - len2) + num2;

        int carry = 0;
        StringBuilder result = new StringBuilder();

        for(int i = Math.max(len1, len2) - 1; i >= 0; i--) {
            int dig1 = num1.charAt(i) - '0';
            int dig2 = num2.charAt(i) - '0';
            int sum = dig1 + dig2 + carry;
            result.append( sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) result.append(carry);

        return result.reverse().toString();
    }

    String padZeros(int count) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < count; i++)
            sb.append(0);

        return sb.toString();
    }
}
