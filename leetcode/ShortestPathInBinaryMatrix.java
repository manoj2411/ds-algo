import java.util.*;

/*
		https://leetcode.com/problems/shortest-path-in-binary-matrix/
*/
class ShortestPathInBinaryMatrix {
	public static void main(String[] args) {
		int[][] grid = {{0,1},{1,0}};
		System.out.println(new Solution().shortestPathBinaryMatrix(grid)); // 2

		grid = new int[][] { {0,0,0}, {1,1,0}, {1,1,0} };
		System.out.println(new Solution().shortestPathBinaryMatrix(grid)); // 4
	}
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        
        int M = grid.length;
        int N = grid[0].length;
                
        Queue<Step> que = new LinkedList<>();
        que.add(new Step(0, 0, 1));
        
        int[][] next_rc = {{0,1}, {1,0}, {1,1}, {-1,-1}, {0,-1}, {-1,0}, {-1,1}, {1,-1}};
        
        while(que.size() > 0) {
            var step = que.remove();
            int r = step.r;
            int c = step.c;
            int cost = step.cost;
            
            if(r+1 == M && c+1 == N) return cost;
            
            for(int[]next : next_rc) {
                int r1 = r + next[0];
                int c1 = c + next[1];
                
                if(r1 < M && r1 >= 0 && c1 < N && c1 >= 0 && grid[r1][c1] == 0) {
                    que.add(new Step(r1, c1, cost + 1));
                    grid[r1][c1] = -1;
                }
            }

        }
               
        return -1;
    }
}

class Step { 
    int r;
    int c;
    int cost;
    Step(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }
}