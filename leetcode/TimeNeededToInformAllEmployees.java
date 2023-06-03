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

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> hierarchy = new ArrayList<>();
        for(int e = 0; e < n; e++) hierarchy.add(new ArrayList<>());
        for(int emp = 0; emp < n; emp++) {
            if (emp == headID) continue;
            int managerOfEmp = manager[emp];
            hierarchy.get(managerOfEmp).add(emp);
        }

        return dfs(hierarchy, headID, informTime);
    }

    private int dfs(List<List<Integer>> hierarchy, int currEmp, int[] informTime) {
        if (hierarchy.get(currEmp).isEmpty()) {
            return 0;
        }

        int maxTime = 0;
        for(int nextLevelEmp : hierarchy.get(currEmp)) {
            maxTime = Math.max(maxTime, dfs(hierarchy, nextLevelEmp, informTime) + informTime[currEmp]);
        }
        return maxTime;
    }
}
