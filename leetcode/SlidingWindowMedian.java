import java.util.*;

/*
        https://leetcode.com/problems/sliding-window-median/
*/
class SlidingWindowMedian {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        String res = Arrays.toString(sol.medianSlidingWindow(nums, k));
        System.out.println(res);
        // [1,-1,-1,3,5,6]
    }
}

class Solution {
    // first half in maxHeap and later in minHeap
    // add element to heaps & adjust
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        for(int i = 0; i < k ; i++)
            add(nums[i]);

        double[] result = new double[nums.length - k + 1];

        for(int i = 0; i + k < nums.length; i++) {

            result[i] = median();
            remove(nums[i]);
            add(nums[i+k]);
        }
        result[result.length - 1] = median();
        return result;
    }

    void add(int num) {
        if(minHeap.isEmpty()) {
            maxHeap.add(num);
        } else if(maxHeap.isEmpty()) {
            minHeap.add(num);
        } else if(maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        adjust();
    }

    void adjust() {
        while(Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            if(maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
    }

    void remove(int num) {
        if(!maxHeap.isEmpty() && maxHeap.peek() >= num)
            maxHeap.remove(num);
        else
            minHeap.remove(num);
    }

    double median() {
        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else if(minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else
            return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2 ;
    }

}
