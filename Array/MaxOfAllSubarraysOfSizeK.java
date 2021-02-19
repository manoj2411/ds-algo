import java.util.*;

class MaxOfAllSubarraysOfSizeK {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,4,5,2,3,6};
        int k = 3;
        System.out.println("Arr: " + Arrays.toString(arr));
        System.out.println("max of subarrays (using Heap): " + maxOfSubarrays(arr, k));
        System.out.println("max of subarrays (using Map): " + maxOfSubarraysUsingMap(arr, k));

    }

    // Solution using Heap : O(NK)
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (Integer a, Integer b) -> Integer.compare(-a, -b)
        );

        for(int i = 0; i < k; i++)
            maxHeap.add(arr[i]);

        for(int i = k; i < arr.length; i++) {
            res.add(maxHeap.peek());
            maxHeap.remove(arr[i - k]);
            maxHeap.add(arr[i]);
        }
        res.add(maxHeap.peek());

        return res;
    }

    // Solution using TreeMap : O(Nlog(K))
    static ArrayList<Integer> maxOfSubarraysUsingMap(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (Integer a, Integer b) -> Integer.compare(-a, -b)
        );

        for(int i = 0; i < k; i++)
            maxHeap.add(arr[i]);

        for(int i = k; i < arr.length; i++) {
            res.add(maxHeap.peek());
            maxHeap.remove(arr[i - k]);
            maxHeap.add(arr[i]);
        }
        res.add(maxHeap.peek());

        return res;
    }

}
