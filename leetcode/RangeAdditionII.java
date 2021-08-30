/*
	https://leetcode.com/problems/range-addition-ii/
*/
class RangeAdditionII {
	public static void main(String[] args) {
		int m = 3, n = 3;
		int[][] ops =  { {2,2}, {3,3} };

		System.out.println(new Solution().maxCount(m, n, ops)); // 4
	}
}

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int[] rows = new int[m + 1];
        int[] cols = new int[n + 1];

        for(int[] op : ops) {
            int r = op[0];
            int c = op[1];

            rows[r]++;
            cols[c]++;
        }

        int maxr = rows[m];
        int maxri = m;
        for(int i = m-1; i > 0; i--) {
            rows[i] += rows[i + 1];

            if (rows[i] > maxr) {
                maxr = rows[i];
                maxri = i;
            }
        }

        int maxc = cols[n];
        int maxci = n;
        for(int i = n-1; i > 0; i--) {
            cols[i] += cols[i + 1];
            if (cols[i] > maxc) {
                maxc = cols[i];
                maxci = i;
            }
        }

        return maxci * maxri;
    }
}
