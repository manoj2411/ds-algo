import java.util.*;

/*
        https://leetcode.com/problems/longest-nice-substring/
*/
class LongestNiceSubstring {
    public static void main(String[] args) {
        String[] input = {
            "YazaAay",  // 'aAa'
            "Bb",       // 'Bb'
            "c",        // ''
            "dDzeE"     // 'dD'
        };

        for(String str : input) {
            System.out.println("String: '" + str + "'");
            System.out.println("Longest nice substring: '" +
                new Solution().longestNiceSubstring(str) + "'");
            System.out.println();
        }
    }
}

class Solution {
    public String longestNiceSubstring(String s) {

        Map<String, String> cache = new HashMap<>();

        return helper(s, cache);

    }

    private String helper(String s, Map<String, String> cache) {

        if (s.isEmpty()) return s;

        if (cache.containsKey(s)) return cache.get(s);


        int break_at = -1;
        Set<Character> visited = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (visited.contains(ch)) continue;

            if (Character.isLowerCase(ch)) {

                char upcased = Character.toUpperCase(ch);
                if(s.indexOf(upcased) == -1) {
                    break_at = i;
                    break;
                }
                visited.add(ch);
                visited.add(upcased);

            } else {

                char lowcased = Character.toLowerCase(ch);
               if (s.indexOf(lowcased) == -1) {
                    break_at = i;
                    break;
               }
                visited.add(ch);
                visited.add(lowcased);
            }


        }

        if( break_at == -1) {
            cache.put(s, s);
        } else {
            String r1 = helper(s.substring(0, break_at), cache);
            String r2 = helper(s.substring(break_at+1, s.length()), cache);

            cache.put(s, r1.length() >= r2.length() ? r1 : r2);
        }

        return cache.get(s);

    }
}
