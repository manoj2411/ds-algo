/*
	https://leetcode.com/problems/sentence-screen-fitting/ (premium users)

	https://www.lintcode.com/problem/889/ (free users)
*/
class SentenceScreenFitting {
	public static void main(String[] args) {
		String[] sentence = {"i", "had", "apple", "pie"};
		int rows = 4;
		int cols = 5;
		System.out.println(new Solution().wordsTyping(sentence, rows, cols)); // 1

		sentence = new String[] {"a", "bcd", "e"};
		rows = 3;
		cols = 6;
		System.out.println(new Solution().wordsTyping(sentence, rows, cols)); // 2

		sentence = new String[] {"hello", "world"};
		rows = 2;
		cols = 8;
		System.out.println(new Solution().wordsTyping(sentence, rows, cols)); // 1

	}
}

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {

        int[] wordsLen = getWordLengths(sentence);

        int word_i = 0;
        int row_i = 0;
        int col_i = 0;
        int result = 0;

        while(row_i < rows) {
            int word_len = wordsLen[word_i];

            if ((col_i + word_len) > cols) {
                col_i = 0;
                row_i++;
                continue;
            }

            col_i += word_len + 1;
            word_i++;

            if (word_i == sentence.length) {
                result++;
                word_i = 0;
            }

            if (col_i == cols) {
                col_i = 0;
                row_i++;
            }

        }

        return result;

    }

    private int[] getWordLengths(String[] words) {
        int[] lens = new int[words.length];
        for(int i = 0; i < lens.length; i++)
            lens[i] = words[i].length();
        return lens;
    }
}
