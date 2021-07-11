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

    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((num1, num2) -> Integer.compare(num2, num1));
        rightMinHeap = new PriorityQueue<>();

    }

    public void addNum(int num) {

        if (!leftMaxHeap.isEmpty() && leftMaxHeap.peek() >= num) {
            leftMaxHeap.add(num);
        } else if (!rightMinHeap.isEmpty() && rightMinHeap.peek() <= num) {
            rightMinHeap.add(num);
        } else {
            leftMaxHeap.add(num);
        }
        rebalance();
    }

    public double findMedian() {
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            return (double)leftMaxHeap.peek();
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            return (double)rightMinHeap.peek();
        } else {
            return ((double) leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }
    }

    private void rebalance() {

        while( Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            if (leftMaxHeap.size() > rightMinHeap.size()) {
                rightMinHeap.add(leftMaxHeap.poll());
            } else {
                leftMaxHeap.add(rightMinHeap.poll());
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
