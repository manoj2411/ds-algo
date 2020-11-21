import java.util.*;
/*
		https://leetcode.com/problems/decode-string/
*/
class DecodeString {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] inputs = {
			"3[a]2[bc]", 	// aaabcbc
			"3[a2[c]]", 	// accaccacc
			"2[abc]3[cd]ef"	// abcabccdcdcdef
		};

		for(String str : inputs) {

			System.out.println("\nstr: " + str);
			System.out.println("decoded: " + sol.decodeString(str));
		}
	}
}

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> sbStack = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        sbStack.add(new StringBuilder());

        int i = 0;

        while(i < s.length()) {
            char ch = s.charAt(i);

            if(ch == ']') {
                StringBuilder sb = sbStack.pop();
                int num = nums.pop();
                for(int j = 0; j < num; j++)
                    sbStack.peek().append(sb);

            } else if(Character.isDigit(ch)) {
                String numStr = extractNum(s, i);
                nums.add(new Integer(numStr));
                sbStack.add(new StringBuilder());
                i += numStr.length(); // handles digit len and next [ char will be skipped from i++ at the end of loop
            } else {
                sbStack.peek().append(ch);
            }

            i++;
        }

        return sbStack.pop().toString();
    }

    String extractNum(String s, int i) {
        StringBuilder sb = new StringBuilder();
        for(int j = i; j < s.length(); j++) {
            char ch = s.charAt(j);
            if(Character.isDigit(ch))
                sb.append(ch);
            else
                break;
        }
        return sb.toString();
    }
}