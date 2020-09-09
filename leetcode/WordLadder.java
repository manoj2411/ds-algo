import java.util.*;

/*
    https://leetcode.com/problems/word-ladder/
*/

class Solution {
    int wordLen;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordLen = beginWord.length();

        boolean[] visited = new boolean[wordList.size()];
        Queue<String> que = new LinkedList<>();

        que.add(beginWord);
        int levelCount = 1;

        while (!que.isEmpty()) {

            int levelSize = que.size();
            for (int k = 0; k < levelSize; k++) {

                String currWord = que.remove();

                for(int i = 0; i < visited.length; i++) {
                    if (!visited[i]) {

                        String nextWord = wordList.get(i);
                        if (isTransformable(currWord, nextWord)) {
                            if (nextWord.equals(endWord)) return levelCount + 1;
                            que.add(nextWord);
                            visited[i] = true;
                        }
                    }
                }


            }
            levelCount++;
        }

        return 0;
    }

    boolean isTransformable(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < wordLen; i++) {
            if (word1.charAt(i) != word2.charAt(i))
                diff++;
        }
        return diff == 1;
    }
}

public class WordLadder {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println(sol.ladderLength(beginWord, endWord, Arrays.asList(words))); // 5

        beginWord = "hit";
        endWord = "cog";
        String[] newWords = {"hot","dot","dog","lot","log"};
        System.out.println(sol.ladderLength(beginWord, endWord, Arrays.asList(newWords))); // 0

    }

}

