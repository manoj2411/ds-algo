/*
		https://leetcode.com/problems/beautiful-arrangement/solution/
*/
class BeautifulArrangement {
	public static void main(String[] args) {
		System.out.println(new Solution().countArrangement(1)); // 1
		System.out.println(new Solution().countArrangement(2)); // 2
		System.out.println(new Solution().countArrangement(3)); // 3
		System.out.println(new Solution().countArrangement(5)); // 10
	}
}

class Solution {
    int res;
    public int countArrangement(int n) {
        boolean[] used = new boolean[n+1];
        res = 0;
        explore(1, used);
        return res;
    }

    void explore(int i, boolean[] used) {
        if(i == used.length) {
            res++;
            return;
        }

        for(int j = 1; j < used.length; j++) {
            if(used[j])
                continue;

            if(j % i == 0 || i % j == 0) {
                used[j] = true;
                explore(i + 1, used);
                used[j] = false;
            }
        }
    }
}