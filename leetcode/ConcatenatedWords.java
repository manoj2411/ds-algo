import java.util.*;

/*
	https://leetcode.com/problems/concatenated-words/description/
*/

class ConcatenatedWords {
	public static void main(String[] args) {
		String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		System.out.println(new Solution().findAllConcatenatedWordsInADict(words)); // ["catsdogcats","dogcatsdog","ratcatdogcat"]

		words = new String[]{"cat","catdog", "dog",};
		System.out.println(new Solution().findAllConcatenatedWordsInADict(words)); // ["catdog"]
	}
}

class Solution {

    private TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        List<String> result = new ArrayList<>();

        for(String word : words) {
            if (find(word, 0)) {
                result.add(word);
            }
            addToTrie(word);
        }

        return result;

    }

    private void addToTrie(String word) {
        TrieNode curr = root; // r: [c: [a: [t]]]
                                            //  |
        for(char ch : word.toCharArray()) { // cat
            int i = ch - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.isEow = true;
    }

    private boolean find(String word, int index) {
        if (index == word.length()) return true;

        TrieNode curr = root;

        while(index < word.length()) {
            int i = word.charAt(index++) - 'a';

            curr = curr.children[i];
            if (curr == null) {
                return false;
            } else if (curr.isEow && find(word, index)) {
                return true;
            }
        }

        return curr.isEow;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEow = false;
    }
}

