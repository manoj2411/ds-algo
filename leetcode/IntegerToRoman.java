/*
	https://leetcode.com/problems/integer-to-roman/
*/

class IntegerToRoman {
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
    char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int[] values = {1, 5, 10, 50, 100, 500, 1000};
    int[] comesBefore = {0, 0, 0, 2, 2, 4, 4};

    public String intToRoman(int num) {
        int remaining = num;
        String roman = "";

        for(int i = chars.length - 1; i >= 0 && remaining > 0; i--) {
            Result curr = tryToAddCurrChar(i, remaining);
            remaining -= curr.val;
            roman += curr.str;
        }

        return roman;
    }

    private Result tryToAddCurrChar(int i, int num) {

        int currVal = values[i];
        String strForValue = "" + chars[i];

        if ( currVal > num && i > 0) {
            currVal -= values[comesBefore[i]]; // find next smaller possible value
            strForValue = chars[comesBefore[i]] + strForValue;
        }


        if (currVal < num) {
            Result intermediate = tryToAddCurrChar(i, num - currVal);
            return new Result(currVal + intermediate.val, strForValue + intermediate.str);
        } else if (currVal == num) {
            return new Result(currVal, strForValue);
        } else {
            return new Result(); // empty result, not choosing current char as part of result;
        }
    }

    class Result {
	    int val;
	    String str;
	    Result() { val = 0; str = ""; }
	    Result(int v, String s) { val = v; str = s; }
	}
}

