import java.util.*;

/*
	https://leetcode.com/problems/all-paths-from-source-to-target/description/
*/
class AllPathsFromSourceToTarget {
	public static void main(String[] args) {
		int[][] graph = {{1,2},{3},{3},{}};
		System.out.println(new Solution().allPathsSourceTarget(graph)); // [[0,1,3],[0,2,3]]
	}
}


class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<>();

        // DFS
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, List.of(0)));

        while ( !que.isEmpty() ) {
            var currNode = que.poll();

            for(int next : graph[currNode.label]) {
                var path = new ArrayList<>(currNode.path);
                path.add(next);

                if (next == graph.length - 1) {
                    paths.add(path);
                } else {
                    que.add(new Node(next, path));
                }
            }
        }

        return paths;
    }

    private class Node {
        int label;
        List<Integer> path;

        Node(int label, List<Integer> path) {
            this.label = label;
            this.path = path;
        }
    }
}
