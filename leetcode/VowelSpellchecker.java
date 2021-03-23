import java.util.*;

/*
    https://leetcode.com/problems/vowel-spellchecker/
*/
class VowelSpellchecker {
    public static void main(String[] args) {
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};

        String[] result = new Solution().spellchecker(wordlist, queries);
        // res: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
        System.out.println(Arrays.toString(result));

    }
}

class Solution {
    private static Set<Character> vowels = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>();
        Map<String, String> noCaseWords = new HashMap<>();
        Map<String, String> noVowelsWords = new HashMap<>();

        for(String word : wordlist) {
            String lowercase = word.toLowerCase();
            String noVowelsWord = getNoVowelsWord(lowercase);

            words.add(word);
            if (!noCaseWords.containsKey(lowercase))
                noCaseWords.put(lowercase, word);

            if (!noVowelsWords.containsKey(noVowelsWord)) {
                // System.out.println(noVowelsWords + ", " + word + " : " + noVowelsWord);
                noVowelsWords.put(noVowelsWord, word);
            }

        }

        String[] result = new String[queries.length];

        for(int i = 0; i < queries.length; i++) {
            String word = queries[i];
            String lowercase = word.toLowerCase();
            String noVowelsWord = getNoVowelsWord(lowercase);

            if (words.contains(word)) {
                result[i] = word;
            } else if (noCaseWords.containsKey(lowercase)) {
                result[i] = noCaseWords.get(lowercase);
            } else if (noVowelsWords.containsKey(noVowelsWord)) {
                result[i] = noVowelsWords.get(noVowelsWord);
            } else {
                result[i] = "";
            }
        }

        return result;
    }

    private String getNoVowelsWord(String word) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (vowels.contains(ch))
                sb.append('*');
            else
                sb.append(ch);
        }
        return sb.toString();
    }
}
