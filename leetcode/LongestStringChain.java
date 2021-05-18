import java.util.*;

/*
	https://leetcode.com/problems/longest-string-chain/
*/
class LongestStringChain {
	public static void main(String[] args) {
		String[][] input = {
			{"a","b","ba","bca","bda","bdca"}, 		// 4
			{"xbc","pcxbcf","xb","cxbc","pcxbc"}	// 5
		};
		for(String[] words : input)
			System.out.println(new Solution().longestStrChain(words));
	}
}

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,
                    (w1, w2) -> Integer.compare(w1.length(), w2.length()));

        Map<String, Integer> map = new HashMap<>();

        int res = 1;

        for(String word : words) {
            int max = 0;
            for(String p : predecessors(word)) {
                if (map.containsKey(p)) {
                    max = Math.max(map.get(p), max);
                }
            }
            map.put(word, max + 1);
            res = Math.max(res, max + 1);
        }

        return res;

    }

    List<String> predecessors(String word) {
        List<String> res = new LinkedList<>();

        for(int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            sb.deleteCharAt(i);
            res.add(sb.toString());
        }
        return res;
    }
}
