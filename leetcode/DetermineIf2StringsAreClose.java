import java.util.*;
/*
    https://leetcode.com/problems/determine-if-two-strings-are-close/
*/
class DetermineIf2StringsAreClose {
    public static void main(String[] args) {
        System.out.println(new Solution().closeStrings("cabbba", "abbccc")); // T
        System.out.println(new Solution().closeStrings("cabbba", "aabbss")); // F
        System.out.println(new Solution().closeStrings("c", "cc")); // F
    }
}

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;

        Map<Character, Integer> map1 = charsCount(word1);
        Map<Character, Integer> map2 = charsCount(word2);

        if( !map1.keySet().equals(map2.keySet()) )
            return false;

        List<Integer> vals1 = new ArrayList<>(map1.values());
        List<Integer> vals2 = new ArrayList<>(map2.values());

        Collections.sort(vals1);
        Collections.sort(vals2);
        return vals1.equals(vals2);

    }

    Map<Character, Integer> charsCount(String word) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int c = map.getOrDefault(ch, 0);
            map.put(ch, c+1);
        }
        return map;
    }
}
