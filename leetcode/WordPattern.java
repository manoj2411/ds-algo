import java.util.*;

/*      https://leetcode.com/problems/word-pattern/     */

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println("Result: " + wordPattern(pattern, str)); // Output: true

        pattern = "abba"; str = "dog cat cat fish";
        System.out.println("Result: " + wordPattern(pattern, str));// Output: false

        pattern = "aaaa"; str = "dog cat cat dog";
        System.out.println("Result: " + wordPattern(pattern, str));// Output: false

        pattern = "abba"; str = "dog dog dog dog";
        System.out.println("Result: " + wordPattern(pattern, str));// Output: false
    }

    public static boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");

        if (words.length != pattern.length()) return false;

        HashSet<String> wordsUsed = new HashSet<>();
        HashMap<Character, String> mapping = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++ ) {
            char currChar = pattern.charAt(i);
            String currWord = words[i];

            if(!wordsUsed.contains(currWord) && !mapping.containsKey(currChar)) {
                mapping.put(currChar, currWord);
                wordsUsed.add(currWord);
            } else if (!mapping.containsKey(currChar) || !mapping.get(currChar).equals(currWord)) {
                // System.out.println("char: " + currChar + " word: " + currWord + " mapping: " + mapping);
                return false;
            }
        }

        return true;
    }


}
