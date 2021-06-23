import java.util.*;

/*
	https://leetcode.com/problems/number-of-matching-subsequences/
*/
class NumberOfMatchingSubsequences {
	public static void main(String[] args) {
		String s = "abcde";
		String[] words = {"a","bb","acd","ace"};
		System.out.println(new Solution().numMatchingSubseq(s, words)); // 3

		s = "dsahjpjauf";
		words = new String[] {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
		System.out.println(new Solution().numMatchingSubseq(s, words)); // 2
	}
}

class Solution {

    public int numMatchingSubseq(String s, String[] words) {

        List<Word>[] buckets = new ArrayList[26];

        for(int i = 0; i < 26; i++)
            buckets[i] = new ArrayList<>();

        for(String word : words) {
            Word w = new Word(word);
            buckets[w.currChar() - 'a'].add(w);
        }

        int result = 0;

        for (char ch : s.toCharArray()) {

            List<Word> bucket = buckets[ch - 'a'];
            buckets[ch - 'a'] = new ArrayList<>();

            for(Word word : bucket) {

                word.i++;

                if (word.isEOW()) {
                    result++;
                } else {
                    buckets[word.currChar() - 'a'].add(word);
                }
            }

        }

        return result;
    }
}

class Word {

    String str;
    int i;

    Word(String s) {
        str = s;
        i = 0;
    }

    boolean isEOW() { return i == str.length(); }

    char currChar() { return str.charAt(i); }
}
