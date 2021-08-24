/*
	https://leetcode.com/problems/complex-number-multiplication/
*/
class ComplexNumberMultiplication {
	public static void main(String[] args) {
		System.out.println(
			new Solution().complexNumberMultiply("1+1i", "1+1i")); // "0+2i"
		System.out.println(
			new Solution().complexNumberMultiply("1+-1i", "1+-1i")); // ""0+-2i""
	}
}

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] parts1 = num1.split("\\+");
        String[] parts2 = num2.split("\\+");

        int real1 = Integer.valueOf(parts1[0]);
        int complex1 = Integer.valueOf(parts1[1].substring(0, parts1[1].length() - 1));

        int real2 = Integer.valueOf(parts2[0]);
        int complex2 = Integer.valueOf(parts2[1].substring(0, parts2[1].length() - 1));

        // System.out.println(List.of(real1, complex2, real2, complex2));

        int real = (real1 * real2) - (complex1 * complex2);
        int complex = (real1 * complex2) + (real2 * complex1);

        return real + "+" + complex + "i";
    }
}
