import java.util.*;

/*
    https://leetcode.com/problems/prefix-and-suffix-search/
*/
class PrefixAndSuffixSearch {
    public static void main(String[] args) {
        String[] words = {"apple", "test"};
        WordFilter obj = new WordFilter(words);
        String[][] searches = {{"a","e"}, {"app","e"}, {"te","st"}, {"apples","e"}, {"b","e"}};

        for(var input : searches) {
            var prefix = input[0];
            var suffix = input[1];
            System.out.print(obj.f(prefix,suffix) + " ");
        } // res : 0 0 1 -1 -1

        System.out.println();


    }
}


class WordFilter {

    Trie prefixTrie;
    Trie suffixTrie;

    Map<String, Set<Integer>> cache;

    public WordFilter(String[] words) {

        prefixTrie = new Trie();
        suffixTrie = new Trie();
        cache = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            var word = words[i];
            var reverseWord = new StringBuilder(word).reverse().toString();

            // System.out.println("word: " + word + "\t reversed: " + reverse);

            prefixTrie.add(word, i);
            suffixTrie.add(reverseWord, i);
        }
        // System.out.println();
    }

    public int f(String prefix, String suffix) {

        String pkey = "p:" + prefix;
        String skey = "s:" + suffix;

        var prefixIndices = prefixTrie.search(prefix);

        var reverseSuffix = new StringBuilder(suffix).reverse().toString();
        var suffixIndices = suffixTrie.search(reverseSuffix);

        // System.out.println("prefix: "+ prefix + ", indices: " + prefixIndices);
        // System.out.println("suffix: "+ suffix + ", indices: " + suffixIndices);
        // System.out.println();

        if (!cache.containsKey(pkey)) cache.put(pkey, Set.copyOf(prefixIndices));
        if (!cache.containsKey(skey)) cache.put(skey, Set.copyOf(suffixIndices));


        if(prefixIndices.size() > suffixIndices.size())
            return findLastInSet(cache.get(pkey), suffixIndices);
        else
            return findLastInSet(cache.get(skey), prefixIndices);


        // Expensive calculation but cleaner, might be useful with smaller data
        //
        // return prefixIndices
        //     .stream()
        //     .filter(suffixIndices::contains)
        //     .mapToInt(v -> v)
        //     .max()
        //     .orElse(-1);

    }

    private int findLastInSet(Set<Integer> set, List<Integer> list) {
        for(int i = list.size() - 1; i>= 0; i--) {
            if (set.contains(list.get(i)))
                return list.get(i);
        }
        return -1;
    }
}




class Trie {

    Node root;
    Trie() { root = new Node(); }

    void add(String word, int index) {

        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!curr.children.containsKey(ch)) {
                curr.children.put(ch, new Node());
            }
            curr = curr.children.get(ch);
            curr.indices.add(index);
        }
    }

    List<Integer> search(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(!curr.children.containsKey(ch)) return List.of();

            curr = curr.children.get(ch);
        }

        return curr.indices;
    }


    class Node {
        Map<Character, Node> children;
        List<Integer> indices;
        Node() {
            children = new HashMap<>();
            indices = new ArrayList<>();
        }
    }
}


