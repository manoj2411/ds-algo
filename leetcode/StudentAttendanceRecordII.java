/*
	https://leetcode.com/problems/student-attendance-record-ii/
*/
class StudentAttendanceRecordII {
	public static void main(String[] args) {
		System.out.println(new Solution().checkRecord(2)); // 8
		System.out.println(new Solution().checkRecord(1)); // 3
		System.out.println(new Solution().checkRecord(5)); // 94
	}
}

class Solution {

    int MAX = 1000000007;
    int[][][] cache;

    public int checkRecord(int n) {
        cache = new int[n+1][2][3];
        return (int)generate(0, 0, n);
    }

    /*
		The idea is to try to generate every possible valid at every step
		- Adding 'P' is always valid
		- Adding 'A' is only allowed once, so absentCount must be 0 for this
		- Adding 'L' must not be 3 or more consecutively, so consecutiveLate must be < 2
			and reset it to 0 whenever choosing 'P' or 'A'
    */
    long generate(int absentCount, int consecutiveLate, int n) {

        if (n == 0) return 1;
        if (cache[n][absentCount][consecutiveLate] > 0) return cache[n][absentCount][consecutiveLate];

        // simulate Adding a 'P' which doesn't need check, its always valid
        long result = generate(absentCount, 0, n - 1);

        // simulate Adding a 'A' here absentCount must be 0 to generate a valid
        // 	record including 'A'
        if (absentCount == 0)
            result += generate(1, 0, n - 1);

		// simulate Adding a 'L' here consecutiveLate must be 0 or 1 to generate
        // 	a valid record including consecutive 'L's
        if (consecutiveLate < 2)
            result += generate(absentCount, consecutiveLate + 1, n - 1);

        cache[n][absentCount][consecutiveLate] = (int)(result % MAX);
        return cache[n][absentCount][consecutiveLate];
    }
}
