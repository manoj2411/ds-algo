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
		for(String[] words : input) {
			System.out.println(new Solution().longestStrChain(words));
            System.out.println(new AlternateSolution().longestStrChain(words));
        }
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


class AlternateSolution {

    record WordInfo(String word, int predessors) {};

    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> wordsByLength = new HashMap<>();

        for(String word : words) {
            wordsByLength.putIfAbsent(word.length(), new ArrayList<>());
            wordsByLength.get(word.length()).add(word);
        }

        List<WordInfo> prevList = List.of();
        int max = 0;
        for(int len = 1; len <= 16; len++) {
            List<WordInfo> nextList = new ArrayList<>();

            for(String word : wordsByLength.getOrDefault(len, List.of())) {
                int predessors = 0;
                for(WordInfo wi : prevList) {
                    if (isPredecessor(word, wi.word)) {
                        predessors = Math.max(predessors, wi.predessors);
                    }
                }
                nextList.add(new WordInfo(word, predessors + 1));
                max = Math.max(max, predessors + 1);
            }
            prevList = nextList;
        }
        return max;
    }

    private boolean isPredecessor(String curr, String prev) {
        boolean skipped = false;
        for(int i = 0, j = 0; i < curr.length() && j < prev.length(); i++) {
            if (curr.charAt(i) == prev.charAt(j)) {
                j++;
            } else if (skipped) {
                return false;
            } else {
                skipped = true;
            }
        }
        return true;
    }
}
