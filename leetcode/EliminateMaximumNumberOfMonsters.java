import java.util.*;

/*
	https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
*/
class EliminateMaximumNumberOfMonsters {
	public static void main(String... args) {
		int[] dist1 = {1,3,4};
		int[] speed1 = {1,1,1};
		System.out.println(new Solution().eliminateMaximum(dist1, speed1)); // 3

		int[] dist2 = {1,1,2,3};
		int[] speed2 = {1,1,1,1};
		System.out.println(new Solution().eliminateMaximum(dist2, speed2)); // 1
	}
}

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pque = new PriorityQueue<>();

        for(int i = 0; i < dist.length; i++) {
            // find the time that each monster take to reach city and add it to pque so
            //   that we can easily remove the closest monster to the city

            int time = dist[i] / speed[i];
            if (dist[i] % speed[i] != 0) time++;
            pque.offer(time);
        }

        pque.poll();
        for(int time = 1; time <= dist.length; time++) {
            if (pque.size() > 0 && pque.poll() <= time) {
                return time;
            }
        }
        return dist.length;
    }
}
