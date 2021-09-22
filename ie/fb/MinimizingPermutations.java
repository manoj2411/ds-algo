import java.util.*;

class MinimizingPermutations {
    public static void main(String[] args) {
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        System.out.println(new Main().minOperations(arr_1));

        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        System.out.println(new Main().minOperations(arr_2));
    }
}

class Main {
    int minOperations(int[] arr) {
    // Write your code here

        int[] target = arr.clone();
        Arrays.sort(target);

        int operations = 0;
        if (Arrays.equals(arr, target)) return operations;

        Set<String> set = new HashSet<>();
        Queue<int[]> que = new LinkedList<>();
        que.add(arr.clone());
        set.add(Arrays.toString(arr));

        while(que.size() > 0) {
          int size = que.size();
          operations++;

          for(int s = 0; s < size; s++) {
            int[] perm = que.poll();

            for(int gap = 1; gap < arr.length; gap++) {

                for(int i = 0; i + gap <  arr.length; i++) {
                    int[] next = perm.clone();
                    reverse(next, i, i + gap);

                    if (Arrays.equals(next, target)) return operations;
                    if (set.add(Arrays.toString(next))) que.add(next);

                }
            }
          }

        }
        return -1;
    }


    private void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

}



