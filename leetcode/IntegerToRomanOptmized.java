/*
	https://leetcode.com/problems/integer-to-roman/
*/

class IntegerToRomanOptmized {
	public static void main(String[] args) {

		System.out.println(new Solution().intToRoman(4)); // "IV"
		System.out.println(new Solution().intToRoman(7)); // "VII"
		System.out.println(new Solution().intToRoman(8)); // "VIII"
		System.out.println(new Solution().intToRoman(9)); // "IX"
		System.out.println(new Solution().intToRoman(68)); // "LXVIII"
		System.out.println(new Solution().intToRoman(69)); // "LXIX"
		System.out.println(new Solution().intToRoman(1994)); // "MCMXCIV"
		System.out.println(new Solution().intToRoman(1594)); // "MDXCIV"
		System.out.println(new Solution().intToRoman(2994)); // "MMCMXCIV"
		System.out.println(new Solution().intToRoman(3994)); // "MMMCMXCIV"
	}
}

class Solution {

    public String intToRoman(int num) {
        String[] symbols = {"I", "IV", "V", "IX", "X", "XL","L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder result = new StringBuilder();

        for(int i = symbols.length - 1; i >= 0 && num > 0; i--) {

            int currVal = values[i];

            if (currVal <= num) {
                num -= currVal;
                result.append(symbols[i]);

                if(currVal <= num) i++; // retry
            }

        }

        return result.toString();
    }
}

