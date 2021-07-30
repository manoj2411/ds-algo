import java.util.*;

class QueueRemovals {
	public static void main(String[] args) {

    int x = 5;
    int[] arr = {1, 2, 2, 3, 4, 5};
    System.out.println(Arrays.toString(
    	new Solution().findPositions(arr, x)));
    // res: [5, 6, 4, 1, 2 ]


    x = 4;
    arr = new int[] {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
    System.out.println(Arrays.toString(
    	new Solution().findPositions(arr, x)));
    // res: [2, 5, 10, 13]

	}
}

class Solution {

	int findIndexOfMax(Queue<Node> que, int x) {
		int size = Math.min(x, que.size());
		Node[] nodes = new Node[size];

		int max = -1;
		int max_i = -1;
		for(int i = 0; i < size; i++) {
			nodes[i] = que.poll();
			if (nodes[i].val > max) {
				max = nodes[i].val;
				max_i = i;
			}
		}

		for(int i = 0; i < size; i++) {
			if (i != max_i) {
				if (nodes[i].val > 0) nodes[i].val--;
				que.add(nodes[i]);
			}
		}

		return nodes[max_i].index;
	}

	int[] findPositions(int[] arr, int x) {

		Queue<Node> que = new LinkedList<>();
		for(int i = 0; i < arr.length; i++) {
			que.add(new Node(arr[i], i + 1));
		}

		int[] result = new int[x];

		for(int i = 0; i < x; i++) {
			result[i] = findIndexOfMax(que, x);
		}
		return result;
	}

	private class Node {
		int val;
		int index;
		Node(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}
}

/*
	complexity
		time: 	O(n + x*x)
		space: 	O(n)
*/

