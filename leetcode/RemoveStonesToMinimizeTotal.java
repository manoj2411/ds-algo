import java.util.*;

/*
	https://leetcode.com/problems/remove-stones-to-minimize-the-total
*/
class RemoveStonesToMinimizeTotal {
	public static void main(String[] args) {
		int[] piles = {5,4,9};
		System.out.println(new Solution().minStoneSum(piles, 2)); // 12

		piles = new int[] {4,3,6,7};
		System.out.println(new Solution().minStoneSum(piles, 3)); // 12

		piles = new int[] {1};
		System.out.println(new Solution().minStoneSum(piles, 10000)); // 1
	}
}

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> -Integer.compare(piles[a], piles[b])
        );

        for(int i = 0; i < piles.length; i++) {
            pq.add(i);
        }

        for(int i = 0; i < k; i++) {
            int index = pq.poll();
            piles[index] -= piles[index] / 2;
            pq.add(index);
        }

        return Arrays.stream(piles).sum();
    }
}
