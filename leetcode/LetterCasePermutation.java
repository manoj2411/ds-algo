import java.util.*;

/*
		https://leetcode.com/problems/letter-case-permutation/
*/
class LetterCasePermutation {
	public static void main(String[] args) {
		String str = "a1b2";
		System.out.println("String: " + str);
		System.out.println(new Solution().letterCasePermutation(str));
		System.out.println();

		str = "3Z4";
		System.out.println("String: " + str);
		System.out.println(new Solution().letterCasePermutation(str));
		System.out.println();
	}
}

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);

        for(int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);

            if(Character.isDigit(ch)) continue;

            List<String> newWords = new LinkedList<>();

            for(String str : result) {
                StringBuilder sb = new StringBuilder(str);

                if(Character.isUpperCase(ch))
                    sb.setCharAt(i, Character.toLowerCase(ch));
                else
                    sb.setCharAt(i, Character.toUpperCase(ch));

                newWords.add(sb.toString());
            }

            result.addAll(newWords);
        }
        return result;

    }
}
