import java.util.*;

/*
        https://leetcode.com/problems/word-ladder/
*/

class WordLadderAlt {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println(sol.ladderLength(beginWord, endWord, Arrays.asList(words)));
        // 5

        beginWord = "hit";
        endWord = "cog";
        String[] newWords = {"hot","dot","dog","lot","log"};
        System.out.println(sol.ladderLength(beginWord, endWord, Arrays.asList(newWords)));
        // 0

    }
}


class Solution {
    Map<String, Set<String>> map;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(dict.add(endWord)) // means endWord is not in dict
            return 0;

        buildMap(wordList);

        int transformations = 0;
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        que.add(beginWord);
        visited.add(beginWord);

        while(!que.isEmpty()) {
            int size = que.size();
            transformations++;

            for(int i = 0; i < size; i++) {
                String word = que.poll();
                for(String masked : masks(word)) {
                    if(!map.containsKey(masked)) continue;

                    for(String nextWord : map.get(masked)) {
                        if(nextWord.equals(endWord))
                            return transformations + 1;
                        if(dict.contains(nextWord) && visited.add(nextWord))
                            que.add(nextWord);
                    }
                }
            }
        }

        return 0;
    }

    void buildMap(List<String> wordList) {
        map = new HashMap<>();

        for(String word : wordList) {
            for(String mask : masks(word)) {
                if(!map.containsKey(mask))
                    map.put(mask, new HashSet<String>());

                map.get(mask).add(word);
            }
        }
        // System.out.println("map: " + map);
    }

    List<String> masks(String word) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            sb.setCharAt(i, '*');
            result.add(sb.toString());
        }
        return result;
    }

}
