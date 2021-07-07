import java.util.*;

/*
	https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
*/
class KthSmallestElementInSortedMatrix {
	public static void main(String[] args) {
		int[][] mat = {{1,5,9}, {10,11,13}, {12,13,15}};
		int k = 8;
		System.out.println(new Solution().kthSmallest(mat, k)); // 13
	}
}


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;

        PriorityQueue<Cell> pq = new PriorityQueue<>((c1, c2) -> {
            return Integer.compare(matrix[c1.r][c1.c], matrix[c2.r][c2.c]);
        });

        for(int i = 0; i < N; i++) pq.add(new Cell(i, 0));

        for(int i = 1; i < k; i++) {
            Cell cell = pq.poll();
            cell.c++;
            if (cell.c < N) pq.add(cell);
        }
        Cell cell = pq.poll();

        return matrix[cell.r][cell.c];
    }

    private class Cell {
        int r;
        int c;
        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

