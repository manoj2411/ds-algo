import java.util.*;

/*
	https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*/
class LetterCombinationsOfPhoneNumber {
	public static void main(String[] args) {
		System.out.println(new Solution().letterCombinations("23"));
		// res: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
	}
}

class Solution {
	// time/space : 4 ^ digits.length
    public List<String> letterCombinations(String digits) {
        char[][] map = {{'a','b','c'},
                        {'d','e','f'},
                        {'g','h','i'},
                        {'j','k','l'},
                        {'m','n','o'},
                        {'p','q','r','s'},
                        {'t','u','v'},
                        {'w','x','y','z'}
                       };

        List<String> res = new LinkedList<>();

        if (digits.length() == 0) return res;

        res.add("");

        for(int i = 0; i < digits.length(); i++) {

            int indx = digits.charAt(i) - '2';

            List<String> list = new LinkedList<>();

            for(String s : res)
                for(char ch : map[indx])
                    list.add(s + ch);


            res = list;
        }

        return res;
    }
}
