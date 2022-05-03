import java.util.*;

/*
	https://leetcode.com/problems/task-scheduler/
*/
class TaskScheduler {
	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B','C','C','C','D','D','E'};
		System.out.println(new Solution().leastInterval(tasks, 2)); // 12
	}
}

class Solution {
	// Idea is to pick task with most frequency && passed the cooldown period.
	//  Then keep removing all completed tasks until all tasks are executed.
    public int leastInterval(char[] tasks, int n) {
    	// create map to count
        Map<Character, TaskItem> map = createTasksMap(tasks);

        int time;
        for(time = 0; map.size() > 0; time++) {

            TaskItem picked = null;
            Character pickedChar = null;

            for(char task : map.keySet()) {
                if (map.get(task).cooldown < time) {
                	// pick the task with most count and having passed the cooldown period
                    if (picked == null || picked.count < map.get(task).count) {
                        picked = map.get(task);
                        pickedChar = task;
                    }
                }
            }

            if (picked != null) {
            	// decrement the count of picked task
                picked.count--;
                // remove task from map when no task remaining to complete
                if (picked.count == 0) {
                    map.remove(pickedChar);
                } else {
                	// set cooldown for the picked taskItem
                    picked.cooldown = time + n;
                }
            }

        }

        return time;

    }

    private Map<Character, TaskItem> createTasksMap(char[] tasks) {
        Map<Character, TaskItem> map = new HashMap<>();

        for(char task : tasks) {
            if (!map.containsKey(task)) {
                map.put(task, new TaskItem(1, -1));
            } else {
                map.get(task).count++;
            }
        }

        return map;

    }

    // To keep counter of remaining tasks and cooldown number.
    private class TaskItem {
        int count;
        int cooldown;
        TaskItem(int c, int v) { count = c; cooldown = v; }
    }
}
