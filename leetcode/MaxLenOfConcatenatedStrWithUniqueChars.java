import java.util.*;

/*
	https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
*/
class MaxLenOfConcatenatedStrWithUniqueChars {
	public static void main(String[] args) {
		System.out.println(
			new Solution().maxLength(List.of("cha","r","act","ers"))); // 6
	}
}

class Solution {
    public int maxLength(List<String> arr) {

        List<String> uniques = new ArrayList<>();

        for(String str : arr) {
            if (isUnique(str)) {
                uniques.add(str);
                // if (str.length() > max) max = str.length();
            }
        }

        return helper(uniques, 0, "");
        // return max;
    }

    private int helper(List<String> list, int index, String str) {
        if (index == list.size()) return 0;

        String curr = list.get(index);

        if (canJoin(curr, str)) {
            return Math.max(
                helper(list, index + 1, str),
                helper(list, index + 1, str + curr) + curr.length());
        } else {
            return helper(list, index + 1, str);
        }
    }

    private boolean canJoin(String str1, String str2) {

        for(char ch : str1.toCharArray()) {
            if (str2.indexOf(ch) != -1) return false;
        }

        return true;
    }

    private boolean isUnique(String str) {
        boolean[] chars = new boolean[26];

        for(char ch : str.toCharArray()) {
            if (chars[ch - 'a']) return false;
            chars[ch - 'a'] = true;
        }
        return true;
    }


}
