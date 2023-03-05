import java.util.*;
/*
		https://leetcode.com/problems/jump-game-iv/
*/
class JumpGameIV {
	public static void main(String[] args) {
		int[][] input = {
			{100,-23,-23,404,100,23,23,23,3,404}, // 3
			{4}, // 0
			{7,6,9,6,9,6,9,7}, // 1
			{6,1,9}, // 2
			{11,22,7,7,7,7,7,7,7,22,13}, // 3
		};
		for(int[] arr : input) {
			Solution sol = new Solution();
			System.out.println("Arr: " + Arrays.toString(arr));
			System.out.println("Minimum jumps: " + sol.minJumps(arr));
			System.out.println();
		}
	}
}


class Solution {
    public int minJumps(int[] arr) {
        int length = arr.length;
        if (length <= 2) {
            return length - 1;
        }

        Map<Integer, List<Integer>> indices = getIndicesMapping(arr);
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[length]; // [0]
        que.add(0);
        visited[0] = true;
        int jumps = 1;

        while(!que.isEmpty()) {
            int size = que.size(); // 1

            for(int s = 0; s < size; s++) {
                int currIndex = que.poll(); // 0
                int curr = arr[currIndex];  // 7
                List<Integer> prospects = new LinkedList<>(indices.get(curr)); // all other indices

                if (currIndex + 1 < length) prospects.add(currIndex + 1);
                if (currIndex - 1 >= 0) prospects.add(currIndex - 1);

                for(int next : prospects) {
                    if (visited[next]) continue;
                    if (next == length - 1) return jumps;
                    que.add(next);
                    visited[next] = true;
                }

                indices.put(curr, List.of()); // This is imp to not to process same indices for a number again orElseGet TLE

            }
            jumps++;

        }

        return -1;
    }

    Map<Integer, List<Integer>> getIndicesMapping(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new LinkedList<Integer>());
            list.add(i);
            map.put(arr[i], list);
        }

        return map;
    }
}
