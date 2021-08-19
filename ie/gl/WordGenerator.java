import java.util.*;

class WordGenerator {
	public static void main(String[] args) {

        new Solution().getWord('I', "ABCDE".toCharArray(), 4);
	}
}


class Solution {

    String getWord(char mendatory, char[] chars, int limit) {

        Queue<String> que = new LinkedList<>();
        que.add(String.valueOf(mendatory));

        while(!que.isEmpty()) {

            String currWord = que.poll();

            Set<String> allWords = generateWords(currWord, mendatory);

            for(char ch : chars) {
                allWords.addAll(generateWords(currWord, ch));
            }

            for(String possibleWord : allWords) {
                if (possibleWord.length() == limit) {
                    System.out.println("last : " + possibleWord);
                } else {
                	System.out.println(possibleWord);
                    que.add(possibleWord);
                }
            }
        }

        return null;
    }

    private Set<String> generateWords(String str, char ch) {
        Set<String> set = new HashSet();

        for(int i = 0; i <= str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            sb.insert(i, ch);
            set.add(sb.toString());
        }
        return set;
    }
}
