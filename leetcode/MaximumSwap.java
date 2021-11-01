/*
	https://leetcode.com/problems/maximum-swap/
*/
class MaximumSwap {
	public static void main(String[] args) {
		System.out.println(new Solution().maximumSwap(2736)); // 7236
		System.out.println(new Solution().maximumSwap(9973)); // 9973
		System.out.println(new Solution().maximumSwap(98368)); // 98863
		System.out.println(new Solution().maximumSwap(1993)); // 9913

	}
}

class Solution {
    /*
        can you add some optimization?
    */
    public int maximumSwap(int num) {
        StringBuilder numStr = new StringBuilder(String.valueOf(num));

        for(int i = 0; i < numStr.length() - 1; i++) {

            int maxIndex = i;

            for(int j = numStr.length() - 1 ; j > i; j--) {
                if (numStr.charAt(maxIndex) < numStr.charAt(j)) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                char tmp = numStr.charAt(i);
                numStr.setCharAt(i, numStr.charAt(maxIndex));
                numStr.setCharAt(maxIndex, tmp);
                break;
            }
        }

        return Integer.valueOf(numStr.toString());
    }
}
