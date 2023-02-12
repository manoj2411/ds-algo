import java.util.*;

/*
	https://leetcode.com/problems/shortest-path-with-alternating-colors/description/
*/
class ShortestPathWithAlternatingColors {
	public static void main(String[] args) {
		int[][] redEdges = {{0,1}};
		int[][] blueEdges = {{2,1}};
		System.out.println(Arrays.toString(
			new Solution().shortestAlternatingPaths(3, redEdges, blueEdges))); // [0,1,-1]
	}
}


class Solution {

    private record Step(int node, Color edgeColor, int dist){};
    private enum Color {
        RED, BLUE;
        Color getNext() {
            return values()[(this.ordinal() + 1) % 2];
        }
    }

    private Map<Color, boolean[]> visited;
    private Queue<Step> que;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Map<Color, List<List<Integer>>> adj = new HashMap<>();
        adj.put(Color.RED, buildAdj(n, redEdges));
        adj.put(Color.BLUE, buildAdj(n, blueEdges));

        visited = new HashMap<>();
        visited.put(Color.RED, new boolean[n]);
        visited.put(Color.BLUE, new boolean[n]);

        que = new LinkedList<>();

        addToQue(adj.get(Color.RED).get(0), 1, Color.RED);
        addToQue(adj.get(Color.BLUE).get(0), 1, Color.BLUE);

        answer[0] = 0;

        while(!que.isEmpty()) {
            Step curr = que.poll();

            if (answer[curr.node] == -1) {
                answer[curr.node] = curr.dist;
            }

            Color nextColor = curr.edgeColor.getNext();

            for(int node : adj.get(nextColor).get(curr.node)) {
                if (visited.get(nextColor)[node]) continue;

                que.add(new Step(node, nextColor, curr.dist + 1));
                visited.get(nextColor)[node] = true;
            }
        }

        return answer;
    }

    private void addToQue(List<Integer>adj, int dist, Color color) {
        for(int node : adj) {
            que.add(new Step(node, color, dist));
            visited.get(color)[node] = true;
        }
    }

    private List<List<Integer>> buildAdj(int n, int[][]edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        return adj;
    }
}
