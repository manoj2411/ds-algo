import java.util.*;
/*
		https://leetcode.com/problems/redundant-connection/
*/
class RedundantConnection {
	public static void main(String[] args) {
		int[][] edges = {{1,2},{1,3},{2,3}};
		System.out.println(
			Arrays.toString(new Solution().findRedundantConnection(edges))); // [2, 3]

		edges = new int[][] {{1,2},{2,3},{3,4},{1,4},{1,5}};
		System.out.println(
			Arrays.toString(new Solution().findRedundantConnection(edges))); // [1, 4]
	}
}

class Solution {
    int[] parents;

    public int[] findRedundantConnection(int[][] edges) {

        parents = new int[edges.length + 1];
        for(int i = 0; i < parents.length; i++) parents[i] = -1;

        for(int[] edge : edges) {
            int parent1 = find(edge[0]);
            int parent2 = find(edge[1]);


            if (parent1 == parent2)
                return edge;

            union(parent1, parent2);
        }

        return null;
    }

    private int find(int i) {
        if (parents[i] == -1) return i;
        return find(parents[i]);
    }

    private void union(int v1, int v2) {
        if (v1 < v2) parents[v2] = v1;
        else parents[v1] = v2;
    }


}
