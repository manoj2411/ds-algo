import java.util.*;

/*
	https://leetcode.com/problems/maximum-performance-of-a-team/
*/
class MaximumPerformanceOfTeam {
	public static void main(String[] args) {
		int n = 6;
		int[] speed = {2,10,3,1,5,8};
		int[] efficiency = {5,4,3,9,7,2};

		System.out.println(new Solution().maxPerformance(n, speed, efficiency, 2)); // 60
		System.out.println(new Solution().maxPerformance(n, speed, efficiency, 3)); // 68
		System.out.println(new Solution().maxPerformance(n, speed, efficiency, 4)); // 72

	}
}

class Solution {

    private static long MAX = 1000000007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        Engineer[] engineers = new Engineer[n];
        for(int i = 0; i < n; i++) {
            engineers[i] = new Engineer(speed[i], efficiency[i]);
        }

        Arrays.sort(engineers, (Engineer e1, Engineer e2) -> {
            return -Integer.compare(e1.efficiency, e2.efficiency);
        });

        // System.out.println(Arrays.toString(engineers));

        PriorityQueue<Engineer> pq = new PriorityQueue<>((Engineer e1, Engineer e2) -> {
            return Integer.compare(e1.speed, e2.speed);
        });

        long maxEfficiency = 0;
        long currEfficiency = 0;
        long totalSpeed = 0;

        for(var engineer : engineers) {

            if (pq.size() == k) {
                var removed = pq.poll();
                totalSpeed -= removed.speed;
                // System.out.println(" removed: " + removed);
            }

            pq.add(engineer);
            totalSpeed += engineer.speed;
            currEfficiency = totalSpeed * engineer.efficiency;
            maxEfficiency = Math.max(maxEfficiency, currEfficiency);
        }

        return (int)(maxEfficiency % MAX) ;
    }
}

class Engineer {
    int speed;
    int efficiency;

    Engineer(int s, int e) {
        speed = s;
        efficiency = e;
    }

    public String toString() { return "(" + efficiency +", " + speed + ")"; }
}

