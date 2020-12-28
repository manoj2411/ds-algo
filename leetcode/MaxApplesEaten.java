import java.util.*;
/*
		https://leetcode.com/problems/maximum-number-of-eaten-apples/
*/
class MaxApplesEaten {
	public static void main(String[] args) {
		int[] apples = {1,2,3,5,2};
		int[] days = {3,2,1,4,2};
		Solution sol = new Solution();
		System.out.println("maximum number of apples you can eat: " +
			sol.eatenApples(apples, days)); // 7
	}
}

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (Pair p1, Pair p2) -> Integer.compare(p1.days, p2.days)
        );

        int applesEaten = 0;
        for(int d = 0; d < days.length; d++) {
            while(heap.size() > 0 && (heap.peek().days <= d || heap.peek().qty == 0)) {
                heap.remove();
            }

            if(apples[d] > 0) {
                heap.add(new Pair(apples[d], d + days[d]));
            }

            if(heap.size() > 0) {
                applesEaten++;
                heap.peek().qty--;
            }
        }

        int d = days.length;
        while(heap.size() > 0) {
            while(heap.size() > 0 && (heap.peek().days <= d || heap.peek().qty == 0)) {
                heap.remove();
            }

            if(heap.size() > 0) {
                applesEaten++;
                heap.peek().qty--;
            }

            d++;
        }

        return applesEaten;

    }
}

class Pair {
    int qty;
    int days;
    Pair(int q, int d) { qty = q; days = d;}
}