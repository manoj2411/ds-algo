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
        int alen = a.length();
        int blen = b.length();

        if (alen > blen) {
            b = zeros(alen - blen) + b;
        } else {
            a = zeros(blen - alen) + a;
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for(int i = Math.max(alen, blen) - 1; i >= 0; i--) {
            int d1 = Character.getNumericValue(a.charAt(i));
            int d2 = Character.getNumericValue(b.charAt(i));

            int sum = d1 + d2 + carry;

            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1){
            result.append(carry);
        }

        return result.reverse().toString();
    }

    String zeros(int num) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num; i++) {
            sb.append(0);
        }

        return sb.toString();
    }
}
