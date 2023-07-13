import java.util.*;

/*
	https://leetcode.com/problems/course-schedule/
*/
class CourseSchedule {
	public static void main(String[] args) {


    	int[][] input1 = {{1,0}};
		System.out.println(new Solution().canFinish(2, input1)); // true

		int[][] input2 = {{1,0}, {0,1}};
		System.out.println(new Solution().canFinish(2, input2)); // false

		int[][] input3 = {{1,0}, {0,6}, {1,2}, {2,3}, {3,0}};
		System.out.println(new Solution().canFinish(12, input3)); // true

	}
}


class Solution {

    private List<List<Integer>> dependency;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.dependency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) dependency.add(new ArrayList<>());
        for(int[] preReq : prerequisites) {
            dependency.get(preReq[0]).add(preReq[1]);
        }

        boolean[] completed = new boolean[numCourses];
        boolean[] inProgress = new boolean[numCourses];

        for(int c = 0; c < numCourses; c++) {
            if (completed[c]) continue;

            if (!canFinish(c, completed, inProgress)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinish(int course, boolean[] completed, boolean[] inProgress) {
        if (inProgress[course]) {
            return false;
        } else if (completed[course]) {
            return true;
        }

        inProgress[course] = true;
        for(int c : dependency.get(course)) {
            if (!canFinish(c, completed, inProgress)) {
                return false;
            }
        }

        inProgress[course] = false;
        completed[course] = true;
        return true;
    }
}
