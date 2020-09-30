import java.util.*;

/*
        https://leetcode.com/problems/word-break/
*/

public class WordBreak {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "applepenapple";
        String[] dict1 = {"apple", "pen"}; // true
        System.out.println(sol.wordBreak(s1, Arrays.asList(dict1)));

        String s2 = "catsandog";
        String[] dict2 = {"cats", "dog", "sand", "and", "cat"}; // false
        System.out.println(sol.wordBreak(s2, Arrays.asList(dict2)));

        String s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] dict3 = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}; // false
        System.out.println(sol.wordBreak(s3, Arrays.asList(dict3)));

    }
}

class Solution {
    class TrieNode {
        boolean isEow;
        Map<Character, TrieNode> children;
        public TrieNode() {
            isEow = false;
            children = new HashMap<>();
        }

        public String toString() {
            return "["+children+", isEow: "+isEow+"]";
        }

    }

    TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        buildTrie(wordDict);
        // System.out.println(root.children);
        List<TrieNode> currNodes = new LinkedList<>();
        currNodes.add(root);

        for(int i = 0; i < s.length() && !currNodes.isEmpty(); i++) {
            char chr = s.charAt(i);
            List<TrieNode> nextNodes = new LinkedList<>();
            boolean canAddRoot = true;
            for(TrieNode node : currNodes){
                if(node.children.containsKey(chr)) {
                    TrieNode nextNode = node.children.get(chr);
                    nextNodes.add(nextNode);
                    if(nextNode.isEow && canAddRoot) {
                        nextNodes.add(root);
                        canAddRoot = false;
                    }

                }
            }
            currNodes = nextNodes;
        }
        for(TrieNode node : currNodes) {
            if(node.isEow) return true;
        }
        return false;
    }

    private void buildTrie(List<String> wordDict) {
        for(String word : wordDict) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.isEow = true;
        }
    }
}
