import java.util.*;
/*
	https://leetcode.com/problems/isomorphic-strings/
*/
class IsomorphicStrings {
	public static void main(String[] args) {
		System.out.println(new Solution().isIsomorphic("title", "paper")); // true
		System.out.println(new Solution().isIsomorphic("foo", "bar")); // false
		System.out.println(new Solution().isIsomorphic("egg", "add")); // true
	}
}

class Solution {
    public boolean isIsomorphic(String s, String t) {

        boolean[] taken = new boolean[256];
        Map<Character, Character> map = new HashMap<>();


        for(int i = 0; i < s.length(); i++) {
            char ch_in_s = s.charAt(i);
            char ch_in_t = t.charAt(i);

            if (map.containsKey(ch_in_s)) {
                if (map.get(ch_in_s) != ch_in_t)
                    return false;
            } else {
                if (taken[ch_in_t])
                    return false;

                map.put(ch_in_s, ch_in_t);
                taken[ch_in_t] = true;
            }
        }

        return true;

    }
}
