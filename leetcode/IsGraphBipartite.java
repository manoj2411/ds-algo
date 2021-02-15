import java.util.*;

/*
		https://leetcode.com/problems/is-graph-bipartite/
*/
class IsGraphBipartite {
	public static void main(String[] args) {
		int[][] graph = {{1,2,3}, {0,2}, {0,1,3} ,{0,2}};
		System.out.println(new Solution().isBipartite(graph)); // false

		graph = new int[][] { {1,3}, {0,2}, {1,3}, {0,2}};
		System.out.println(new Solution().isBipartite(graph)); // true

		graph = new int[][] { {}, {3,2}, {1,3}, {1,2}};
		System.out.println(new Solution().isBipartite(graph)); // false		
	}
}


class Solution {
    int[][] graph;
    boolean[] visited;
    List<HashSet<Integer>> sets;
    
    public boolean isBipartite(int[][] graph) {
        
        this.graph = graph;
        int len = graph.length;
        
        sets = new ArrayList<>();
        sets.add(new HashSet<>());
        sets.add(new HashSet<>());
        
        visited = new boolean[len];
        
        for(int i = 0; i < len; i++) {
            if(visited[i]) continue;
            
            if(visitNodesBfs(i) == false) return false;
            
        }
        
        return true;
    }
    
    private boolean visitNodesBfs(int i) {
        
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] {i, 0});
        visited[i] = true;
        sets.get(0).add(i);

        while(que.size() > 0) {
            
            var data = que.remove();
            int u = data[0];
            int set_i = data[1];

            int next_set_i = (set_i + 1) % 2;

            for(int v : graph[u]) {

                if(sets.get(set_i).contains(v)) return false;

                if(visited[v]) continue;

                sets.get(next_set_i).add(v);
                que.add(new int[] {v, next_set_i});
                visited[v] = true;
            }
        }

        return true;       
    }
}