import java.util.*;

/*
    https://leetcode.com/problems/generate-parentheses/
*/

public class GenerateParentheses {
    List<String> result;

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            GenerateParentheses obj = new GenerateParentheses();
            System.out.println("s(" + i +"): " + obj.generateParenthesis(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        helper(n, n, "");
        return result;
    }

    void helper(int open, int close, String curr) {
        if (open == 0 && close == 0) {
            result.add(curr);
            return;
        }
        if (open > 0) helper(open - 1, close, curr + "(");
        if (close > open) helper(open, close - 1, curr + ")");
    }

}
