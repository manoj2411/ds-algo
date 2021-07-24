import java.util.*;

/*
	https://leetcode.com/problems/word-ladder-ii/
*/
class WordLadderII {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = List.of("hot","dot","dog","lot","log","cog");

		System.out.println(new Solution().findLadders(beginWord, endWord, wordList));
		/*	res: [
				["hit","hot","dot","dog","cog"],
				["hit","hot","lot","log","cog"]]
			]
		*/
	}
}

class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> curr_seq = new ArrayList<>();
        curr_seq.add(List.of(beginWord));

        Set<String> dict = new HashSet<>(wordList);

        if(dict.contains(beginWord))
            dict.remove(beginWord);

        List<List<String>> result = new ArrayList<>();

        while( !curr_seq.isEmpty() && result.isEmpty()) {

            List<List<String>> next_level = new ArrayList<>();
            Set<String> selected = new HashSet<>();

            for(List<String> seq : curr_seq) {

                String word = seq.get(seq.size() - 1);

                for(String dw : dict) {

                    if (diff(dw, word) == 1) {

                        selected.add(dw);
                        List<String> newSeq = new ArrayList<>(seq);
                        newSeq.add(dw);

                        if (dw.equals(endWord)) {
                            result.add(newSeq);
                        } else {
                            next_level.add(newSeq);
                        }

                    }
                }
            }

            for(String s : selected) dict.remove(s);

            curr_seq = next_level;
        }
        return result;
    }

    private int diff(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;

        boolean ignoreOnce = false;
        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (ignoreOnce) return 2;
                ignoreOnce = true;
            }
        }

        return ignoreOnce ? 1 : 0;
    }

}
