import java.util.*;

class RemoveDuplicateLetters {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] inputs = {"bcabc", "cbacdcbc", "bca", "leetcode"};
        for(String str : inputs) {
            System.out.println("\nWord: " + str);
            System.out.println("Result: " + sol.removeDuplicateLetters(str));
        }
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {

        boolean[] visited = new boolean[26];
        int[] lastIndex = new int[26];

        for(int i = 0; i < s.length(); i++)
            lastIndex[s.charAt(i) - 'a'] = i;

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            int indx = c - 'a';

            if(visited[indx]) continue;

            while(!stack.isEmpty()) {
                if(stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                    char chr = stack.pop();
                    visited[chr - 'a'] = false;
                } else {
                    break;
                }
            }

            visited[indx] = true;
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        for(Character c : stack) {
            sb.append(c);
        }

        return sb.toString();

    }
}

class AlternateSolution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        int[] counter = new int[26];
        for(char ch : s.toCharArray()) { counter[ch-'a']++;}

        boolean[] inStack = new boolean[26];

        for(char ch : s.toCharArray()) {

            while(stack.size() > 0 && stack.peek() > ch && counter[stack.peek() - 'a'] > 0 && !inStack[ch-'a']) {
                inStack[stack.pop()-'a'] = false;
            }

            if(!inStack[ch-'a']) {
                stack.push(ch);
                inStack[ch-'a'] = true;
            }
            counter[ch-'a']--;
        }

        StringBuilder result = new StringBuilder();
        for(char ch : stack) result.append(ch);
        return result.toString();
    }

}
