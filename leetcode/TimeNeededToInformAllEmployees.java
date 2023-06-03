import java.util.*;

/*
	https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
*/
class TimeNeededToInformAllEmployees {
	public static void main(String[] args) {
		int n = 8;
		int headId = 2;
		int[] manager = {2,2,-1,0,3,1,1,6};
		int[] informTime = {1,2,3,4,0,0,5,0};

		System.out.println(new Solution().numOfMinutes(n, headId, manager, informTime)); // 10
	}
}

class Solution {

    private int maxTime = -1;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> hierarchy = new ArrayList<>();
        for(int e = 0; e < n; e++) hierarchy.add(new ArrayList<>());
        for(int emp = 0; emp < n; emp++) {
            if (emp == headID) continue;
            int managerOfEmp = manager[emp];
            hierarchy.get(managerOfEmp).add(emp);
        }

        dfs(hierarchy, headID, informTime, 0);
        return maxTime;
    }

    private void dfs(List<List<Integer>> hierarchy, int currEmp, int[] informTime, int currTime) {
        if (hierarchy.get(currEmp).isEmpty()) {
            maxTime = Math.max(maxTime, currTime);
            return;
        }

        for(int nextLevelEmp : hierarchy.get(currEmp)) {
            dfs(hierarchy, nextLevelEmp, informTime, currTime + informTime[currEmp]);
        }
    }
}
