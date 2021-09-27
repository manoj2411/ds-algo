import java.util.*;

class MedianStream {
	public static void main(String[] args) {
		int[] arr_1 = {5, 15, 1, 3};
		System.out.println(Arrays.toString(
			new Solution().findMedian(arr_1))); // {5, 10, 5, 4}

		int[] arr_2 = {2, 4, 7, 1, 5, 3};
		System.out.println(Arrays.toString(
			new Solution().findMedian(arr_2))); // {2, 3, 4, 3, 4, 3}

	}
}

class Solution {

	private void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		int diff = Math.abs(maxHeap.size() - minHeap.size());
		if (diff <= 1) return;

		if (maxHeap.size() > minHeap.size()) {
			minHeap.add(maxHeap.poll());
		} else {
			maxHeap.add(minHeap.poll());
		}

	}

	private int getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else if (minHeap.size() > maxHeap.size()) {
			return minHeap.peek();
		} else {
			return (minHeap.peek() + maxHeap.peek()) / 2 ;
		}
	}



	int[] findMedian(int[] arr) {
    	// Write your code here

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int[] result = new int[arr.length];

		result[0] = arr[0];
		maxHeap.add(arr[0]);

		for(int i = 1; i < arr.length; i++) {

			if(maxHeap.peek() < arr[i]) {
				minHeap.add(arr[i]);
			} else {
				maxHeap.add(arr[i]);
			}

			rebalance(maxHeap, minHeap);

			result[i] = getMedian(maxHeap, minHeap);

		}

		return result;
	}

}
