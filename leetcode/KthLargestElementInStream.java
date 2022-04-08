import java.util.*;

/*
	https://leetcode.com/problems/kth-largest-element-in-a-stream/
*/

class KthLargestElementInStream {
	public static void main(String[] args) {
		int k = 3;
		int[] nums = {4,5,8,2};
		KthLargest obj = new KthLargest(k, nums);
		System.out.println(obj.add(3)); // 4
		System.out.println(obj.add(5)); // 5
		System.out.println(obj.add(10));// 5
		System.out.println(obj.add(9)); // 8
		System.out.println(obj.add(4)); // 8
	}
}

class KthLargest {
    /*
		use min heap of size k
		 add element when it is greater than peek() element in Heap
    */
    private int k;
    private PriorityQueue<Integer> pque;

    public KthLargest(int k, int[] nums) {
        this.pque = new PriorityQueue<>();

        this.k = k;
        for(int num : nums) add(num);
    }

    public int add(int val) {

        if (pque.size() < k) {
            pque.add(val);
        } else if (pque.peek() < val) {
            pque.poll();
            pque.add(val);
        }

        return pque.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
