import java.util.*;

/*
	https://leetcode.com/problems/ipo/description/
*/
class Ipo {
	public static void main(String[] args) {
		int maxProject = 2;
		int initialCapital = 0;
		int[] profits = {1,2,3};
		int[] capital = {0,1,1};
		System.out.println(new Solution()
			.findMaximizedCapital(maxProject, initialCapital, profits, capital)); // 4
	}
}

class Solution {

    record Project(int profit, int capital) {}
    private PriorityQueue<Project> pool;

    Solution() {
        pool = new PriorityQueue<>((a, b) -> -Integer.compare(a.profit, b.profit));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Project[] projects = buildSortedProjects(profits, capital);
        int maxCapital = w;
        int index = addToPool(projects, 0, maxCapital);
        while(k > 0 && pool.size() > 0) {
            Project project = pool.poll();
            maxCapital += project.profit;
            index = addToPool(projects, index, maxCapital);
            k--;
        }
        return maxCapital;
    }

    private Project[] buildSortedProjects(int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];

        for(int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a.capital, b.capital));
        return projects;
    }

    private int addToPool(Project[] projects, int start, int capital) {
        int i = start;
        while(i < projects.length && projects[i].capital <= capital) {
            pool.add(projects[i++]);
        }
        return i;
    }
}

/**

    at most K projects before ipo

    w capital : finish project get profit but need capital

    k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
                             #   #              #   #
    w : 3

    a. when I have X capital, the pool becomes all the projects <= X capital
    b. out of the pool, I need to choose the project with max profit
    c. update current capital and repeat (a) & (b)

 */
