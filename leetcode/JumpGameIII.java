import java.util.*;
/*
        https://leetcode.com/problems/jump-game-iii/
*/
class JumpGameIII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {4,2,3,0,3,1,2};
        int start = 0;
        System.out.println("arr: " + Arrays.toString(arr) + ", start: " + start);
        System.out.println("result: " + sol.canReach(arr, start));
    }
}

class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while(que.size() > 0) {
            int i = que.poll();

            if(arr[i] == 0) return true;

            int right = i + arr[i];
            if(right < arr.length && !visited[right]) {
                visited[right] = true;
                que.add(right);
            }
            int left = i - arr[i];
            if(left >= 0 && !visited[left]) {
                visited[left] = true;
                que.add(left);
            }

        }

        return false;
    }
}
