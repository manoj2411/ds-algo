import java.util.*;

/*
	https://leetcode.com/problems/reorganize-string/description/
*/
class ReorganizeString {
	public static void main(String... args) {

		System.out.println(new Solution().reorganizeString("aab")); // "aba"
		System.out.println(new Solution().reorganizeString("aaab")); // ""
	}
}

class Solution {

    public String reorganizeString(String s) {

        Map<Character, Integer> charCounter = new HashMap<>();
        for(char ch : s.toCharArray()) {
            charCounter.put(ch, 1 + charCounter.getOrDefault(ch, 0));
        }

        PriorityQueue<CharCount> pque = new PriorityQueue<>((c1, c2) -> -Integer.compare(c1.count, c2.count));
        for(char ch : charCounter.keySet()) {
            pque.add(new CharCount(ch, charCounter.get(ch)));
        }

        StringBuilder result = new StringBuilder();
        CharCount prev = pque.poll();
        result.append(prev.ch);

        while(!pque.isEmpty()) {
            CharCount curr = pque.poll();
            result.append(curr.ch);
            if (prev.count > 1) {
                pque.add(new CharCount(prev.ch, prev.count - 1));
            }
            prev = curr;
        }

        if (prev.count == 1) {
            return result.toString();
        }

        return "";
    }

    private record CharCount(char ch, int count) {};
}
