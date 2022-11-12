import java.util.*;

/*
	https://leetcode.com/problems/find-median-from-data-stream/
*/
class FindMedianFromDataStream {
	public static void main(String[] args) {
 		MedianFinder obj = new MedianFinder();
 		obj.addNum(1);
 		obj.addNum(-5);
 		obj.addNum(2);
 		System.out.println(obj.findMedian()); // 1
	}
}


class MedianFinder {

    private PriorityQueue<Integer> left; // max heap
    private PriorityQueue<Integer> right; // min heap

    /** initialize your data structure here. */
    public MedianFinder() {

        left = new PriorityQueue<Integer>((a, b) -> -Integer.compare(a,b) );
        right = new PriorityQueue<Integer>();

    }

    public void addNum(int num) {
        if (left.size() > 0 && num < left.peek() ) {
            left.add(num);
        } else {
            right.add(num);
        }

        rebalance();
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else if (right.size() > left.size()) {
            return right.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }

    private void rebalance() {
        int diff = Math.abs(left.size() - right.size());

        if (diff > 1) {
            if (left.size() > right.size()) {
                right.add(left.poll());
            } else {
                left.add(right.poll());
            }
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
