/*
	https://leetcode.com/problems/slowest-key/
*/
class SlowestKey {
	public static void main(String[] args) {
		int[] times = {9,29,49,50};
		String keysPressed = "cbcd";
		System.out.println(new Solution().slowestKey(times, keysPressed)); //c
	}
}

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char res = keysPressed.charAt(0);

        for(int i = 1; i < releaseTimes.length; i++) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (diff > max) {
                max = diff;
                res = keysPressed.charAt(i);
            } else if (diff == max && res < keysPressed.charAt(i)) {
                res = keysPressed.charAt(i);
            }
        }

        return res;
    }
}
