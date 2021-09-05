import java.util.*;

/*
	https://leetcode.com/problems/sum-of-distances-in-tree/
*/
class SumOfDistancesInTree {
	public static void main(String[] args) {
		int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5},{7,1},{6,1}, {8, 1}, {8, 9}};
		var result = new Solution().sumOfDistancesInTree(10, edges);
		System.out.println(Arrays.toString(result));
		// [17,17,19,27,27,27,25,25,23,31]
	}
}


class Solution {
	/*
		Question dsc is deliberately misleading by calling it a tree, replace
		tee with graph then think about the ways to solve it..
	*/
    List<List<Integer>> adj;
    int[] ncount;
    int[] psum;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        ncount = new int[n];
        psum = new int[n];
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);
        fillDescendants(0, -1);

        return psum;
    }

    private void fillDescendants(int curr, int parent) {
        int currResult = psum[curr];

        for(int child : adj.get(curr)) {
            if (child == parent) continue;

            psum[child] = currResult - ncount[child] + (n - ncount[child]);
            fillDescendants(child, curr);
        }
    }

    private void dfs(int curr, int parent) {
        int pathSum = 0;
        int nodesCount = 0;

        for(int child : adj.get(curr)) {
            if (child == parent) continue;
            dfs(child, curr);
            pathSum += psum[child];
            nodesCount += ncount[child];
        }

        psum[curr] = pathSum + nodesCount;
        ncount[curr] = nodesCount + 1;
    }
}
