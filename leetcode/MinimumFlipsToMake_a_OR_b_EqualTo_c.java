class MinimumFlipsToMake_a_OR_b_EqualTo_c {
	public static void main(String[] args) {
		System.out.println(new Solution().minFlips(2, 6, 5)); // 3
		System.out.println(new Solution().minFlips(4, 2, 7)); // 1
		System.out.println(new Solution().minFlips(1, 2, 3)); // 0
	}
}

class Solution {

    public int minFlips(int a, int b, int c) {

        int flipped = 0;

        while(a > 0 || b > 0 || c > 0) {
            int x = a % 2;
            int y = b % 2;
            int expected = c % 2;
            int result = x | y;

            if (expected != result) {
                if (expected == 1) { // exp = 1 when res is 0 incr 1 (flip any 0 to 1)
                    flipped++;
                } else if (x == y) { // exp = 0 when both x & y == 1 (flip both to 0)
                    flipped += 2;
                } else {            // // exp = 0 when one of x || y == 1 (flip one 1 to 0)
                    flipped++;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;

            // System.out.println(List.of(a, b, c));
        }

        return flipped;
    }
}
