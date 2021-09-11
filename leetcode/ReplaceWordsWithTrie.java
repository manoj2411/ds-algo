import java.util.*;

/*
	https://leetcode.com/problems/replace-words/
*/
class ReplaceWordsWithTrie {
	public static void main(String[] args) {
		List<String> dict = List.of("catt","cat","bat","rat");
		String sentence = "the cattle was rattled by the battery";
		System.out.println(new Solution().replaceWords(dict, sentence));
		// result: "the cat was rat by the bat"
	}
}

class Solution {

    Trie trie = new Trie();

    public String replaceWords(List<String> dictionary, String sentence) {
        for(String root : dictionary)
            trie.add(root);

        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length; i++) {
            String wordRoot = trie.getSmallestPrefix(words[i]);
            if (wordRoot != null)
                words[i] = wordRoot;
        }

        return String.join(" ", words);
    }
}

class Trie {
    TrieNode root;

    Trie() { root = new TrieNode(); }

    void add(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }
        curr.isEow = true;
    }

    String getSmallestPrefix(String word) {

        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (curr.children[index] == null)
                return null;

            curr = curr.children[index];
            sb.append(ch);
            if (curr.isEow) return sb.toString();
        }

        return null;
    }


    private class TrieNode {

        boolean isEow;
        TrieNode[] children;

        TrieNode() {
            this.isEow = false;
            this.children = new TrieNode[26];
        }
    }
}
