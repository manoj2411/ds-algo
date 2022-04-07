import java.util.*;

/*
    https://leetcode.com/problems/last-stone-weight/
*/
    class LastStoneWeight {
        public static void main(String[] args) {
            int[] stones = {2,7,4,1,8,1};
        System.out.println(new Solution().lastStoneWeight(stones)); // 1
    }
}


class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (s1, s2) -> -Integer.compare(s1, s2));

        for(int stone : stones) pq.add(stone);

            while(pq.size() > 1) {
                int y = pq.poll();
                int x = pq.poll();

                if (x != y) pq.add(y - x);
            }

            return pq.size() == 0 ? 0 : pq.poll();
        }
    }
