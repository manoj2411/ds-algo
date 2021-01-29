/*
    https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
*/
class SmallestStrWithGivenValue {
    public static void main(String[] args) {
        int n = 3;
        int k = 27;
        System.out.println("n: " + n + ", k: " + k + " --> " +
            new Solution().getSmallestString(n, k)); // aay

        n = 5;
        k = 73;
        System.out.println("n: " + n + ", k: " + k + " --> " +
            new Solution().getSmallestString(n, k)); // aaszz

    }

}

class Solution {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];

        for(int i = n - 1; i >= 0; i--) {
            int diff = Math.min(k - i, 26);

            res[i] = (char)('a' + diff - 1);

            k -= diff;

        }

        return new String(res);

    }
}
