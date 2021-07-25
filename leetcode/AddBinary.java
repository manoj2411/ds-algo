/*
	https://leetcode.com/problems/add-binary/
*/
class AddBinary {
	public static void main(String[] args) {
		System.out.println(new Solution().addBinary("11", "1")); // 100
		System.out.println(new Solution().addBinary("1010", "1011")); // 10101
	}
}

class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        if (len1 > len2)
            b = zeros(len1 - len2) + b;
        else if (len2 > len1)
            a = zeros(len2 - len1) + a;

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for(int i = Math.max(len1, len2) - 1; i >= 0; i--) {
            int d1 = a.charAt(i) - '0';
            int d2 = b.charAt(i) - '0';

            int sum = d1 + d2 + carry;

            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) result.append(carry);

        return result.reverse().toString();
    }

    String zeros(int num) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num; i++)
            sb.append(0);

        return sb.toString();
    }
}
