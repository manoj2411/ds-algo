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
        boolean[] visited = new boolean[length];
        Map<Integer, List<Integer>> indices = getIndicesMapping(arr);

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();

        q.add(0);
        dist.add(0);
        visited[0] = true;

        while(q.size() > 0) {
            int i = q.poll();
            int d = dist.poll();

            if(i == length - 1)
                return d;

            if(i - 1 > 0 && visited[i - 1] == false) {
                q.add(i-1);
                dist.add(d + 1);
                visited[i-1] = true;
            }

            if(i+1 < length && visited[i+1] == false) {
                q.add(i+1);
                dist.add(d+1);
                visited[i+1] = true;
            }

            for(int j : indices.get(arr[i])) {
                if(visited[j] == false) {
                    q.add(j);
                    dist.add(d+1);
                    visited[j] = true;
                }

            }
            indices.put(arr[i], new LinkedList<Integer>());
        }

        return arr.length - 1;
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