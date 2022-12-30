import java.util.*;

/*
	https://leetcode.com/problems/single-threaded-cpu/description/
*/
class SingleThreadedCPU {
	public static void main(String[] args) {
		int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
		System.out.println(Arrays.toString(new Solution().getOrder(tasks))); // [0,2,3,1]

		tasks = new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}};
		System.out.println(Arrays.toString(new Solution().getOrder(tasks))); // [4,3,2,0,1]

		tasks = new int[][]{{1,2},{20,4},{30,2},{4,1}};
		System.out.println(Arrays.toString(new Solution().getOrder(tasks))); // [0,3,1,2]
	}
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        int length = tasks.length;
        List<Task> list = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            list.add(new Task(i, tasks[i][0], tasks[i][1]));
        }

        Collections.sort(list, (a, b) -> Integer.compare(a.enqueueTime, b.enqueueTime));

        PriorityQueue<Task> pque = new PriorityQueue<>((a, b) -> {
            if (a.processingTime == b.processingTime) {
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.processingTime, b.processingTime);
        });

        int[] result = new int[length];
        int j = 0;
        int i = 0;
        int currTime = 0;
        while(i < length) {
            if (currTime < list.get(i).enqueueTime && pque.isEmpty()) {
                currTime = list.get(i).enqueueTime;
            }

            while(i < length && currTime >= list.get(i).enqueueTime) {
                pque.add(list.get(i++));
            }

            var task = pque.poll();
            result[j++] = task.index;
            currTime += task.processingTime;
        }

        while(!pque.isEmpty()) {
            result[j++] = pque.poll().index;
        }

        return result;
    }

    class Task {
        private int index;
        private int enqueueTime;
        private int processingTime;

        Task(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }
}
