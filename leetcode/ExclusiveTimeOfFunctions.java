import java.util.*;

/*
	https://leetcode.com/problems/exclusive-time-of-functions/
*/
class ExclusiveTimeOfFunctions {
	public static void main(String[] args) {
		int n = 2;
		List<String> logs = List.of("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
		System.out.println(Arrays.toString(
			new Solution().exclusiveTime(n, logs))); // [7, 1]

		n = 3;
		logs = List.of("0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3");
		System.out.println(Arrays.toString(
			new Solution().exclusiveTime(n, logs))); // [1, 1, 2]
	}
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];

        Stack<LogEntity> stack = new Stack<>();


        /*
			The core idea is to maintain curr value correctly and use it to calculate
			 time span for prev log entity
        */

        int curr = 0;

        for(int i = 0; i < logs.size(); i++) {
            LogEntity log = new LogEntity(logs.get(i));

            if(stack.isEmpty()) {
                stack.add(log);
                curr = stack.peek().timestamp;
                continue;
            }

            LogEntity prev = stack.peek();
            int nextCurr = log.timestamp;

            if (log.isStart()) {
                stack.push(log);
            } else {
                nextCurr++;
                stack.pop();
            }

            result[prev.id] += nextCurr - curr;
            curr = nextCurr;

        }

        return result;
    }

    class LogEntity {
        int id;
        String type;
        int timestamp;

        LogEntity(String raw) {
            String[] vals = raw.split(":");

            id = Integer.valueOf(vals[0]);
            type = vals[1];
            timestamp = Integer.valueOf(vals[2]);
        }

        boolean isStart() { return type.equals("start"); }

        boolean isEnd() { return !isStart(); }
    }
}
