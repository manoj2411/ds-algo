import java.util.*;

/*
	https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
*/
class KWeakestRowsInMatrix {
	public static void main(String[] args) {
		int[][] mat = {
			{1,1,0,0,0},
		 	{1,1,1,1,0},
		 	{1,0,0,0,0},
		 	{1,1,0,0,0},
		 	{1,1,1,1,1}
		};

		int[] res = new Solution().kWeakestRows(mat, 3);
		System.out.println(Arrays.toString(res)); // [2, 0, 3]
	}
}

class Solution {
    
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<Row> pque = new PriorityQueue<>((r1, r2) -> {
            if(r1.soldiers == r2.soldiers) 
                return -Integer.compare(r1.index, r2.index);
            return -Integer.compare(r1.soldiers, r2.soldiers);
        });
        
        for(int r = 0; r < mat.length; r++) {
            Row row = new Row(r, countSoldiers(mat[r]));
            
            if(pque.size() < k) {
                pque.add(row);
            } else if(pque.peek().soldiers > row.soldiers) {
                pque.remove();
                pque.add(row);
            }
        }
        
        int[] result = new int[k];
        
        for(int i = k-1; i >= 0; i--)
            result[i] = pque.remove().index;
        
        return result;
    }
    
    int countSoldiers(int[] row) {
        int count = 0;
        for(int c : row) {
            if(c == 0) return count;
            count++;
        }
        return count;
    }
    
}

class Row {
    int index;
    int soldiers;
    Row(int i, int c) { index = i; soldiers = c; }
}