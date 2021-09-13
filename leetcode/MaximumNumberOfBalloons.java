import java.util.*;

/*
	https://leetcode.com/problems/maximum-number-of-balloons/
*/
class MaximumNumberOfBalloons {
	public static void main(String[] args) {
		System.out.println(new Solution().maxNumberOfBalloons("loonbalxballpoona")); // 2
	}
}

class Solution {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> balloon = new HashMap<>();
        balloon.put('b', 1);
        balloon.put('a', 1);
        balloon.put('l', 2);
        balloon.put('o', 2);
        balloon.put('n', 1);

        Map<Character, Integer> count = new HashMap<>();
        count.put('b', 0);
        count.put('a', 0);
        count.put('l', 0);
        count.put('o', 0);
        count.put('n', 0);

        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (count.containsKey(ch))
                count.put(ch, count.get(ch) + 1);
        }

        int min = text.length();
        for(char ch : count.keySet()) {
            int curr = count.get(ch) / balloon.get(ch);
            min = Math.min(min, curr);
        }

        return min;
    }
}
