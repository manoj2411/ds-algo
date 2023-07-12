import java.util.*;

/*
	https://leetcode.com/problems/find-eventual-safe-states/description/
*/
class FindEventualSafeStates {
	public static void main(String... args) {
		int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
		System.out.println(new Solution().eventualSafeNodes(graph)); // [2,4,5,6]
	}
}


class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        Boolean[] safeState = new Boolean[graph.length];
        boolean[] inStack = new boolean[graph.length];
        Arrays.fill(inStack, false);

        for(int n = 0; n < graph.length; n++) {
            if (safeState[n] == null) {
                dfs(graph, safeState, n, inStack);
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int n = 0; n < graph.length; n++) {
            if (Optional.ofNullable(safeState[n]).orElse(false)) {
                result.add(n);
            }
        }

        return result;
    }

    private boolean dfs(int[][] graph, Boolean[] safeState, int node, boolean[] inStack) {
        if (safeState[node] != null) {
            return safeState[node];
        }

        if (inStack[node]) {
            safeState[node] = false;
            return false;
        }

        inStack[node] = true;
        for(int n : graph[node]) {
            if (!dfs(graph, safeState, n, inStack)) {
                safeState[n] = false;
                return false;
            }
        }
        inStack[node] = false;
        safeState[node] = true;
        return true;
    }
}
