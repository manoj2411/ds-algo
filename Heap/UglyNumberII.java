import java.util.*;

/*
	https://leetcode.com/problems/ugly-number-ii/
*/
class UglyNumberII {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(n+"th ugly number: " + new Solution().nthUglyNumber(n));

		n = 4;
		System.out.println(n+"th ugly number: " + new Solution().nthUglyNumber(n));

		n = 100;
		System.out.println(n+"th ugly number: " + new Solution().nthUglyNumber(n));

		n = 1000;
		System.out.println(n+"th ugly number: " + new Solution().nthUglyNumber(n));

	}
}

class Solution {
    public int nthUglyNumber(int n) {
        var pq = new PriorityQueue<Long>();
        pq.add(1l);

        long res = 0;

        Set<Long> set = new HashSet<>(n, 1f);

        for(int i = 0; i < n; i++) {
            res = pq.remove();
            if (set.add(res * 2)) pq.add(res * 2);
            if (set.add(res * 3)) pq.add(res * 3);
            if (set.add(res * 5)) pq.add(res * 5);
        }

        return (int)res;
    }
}
