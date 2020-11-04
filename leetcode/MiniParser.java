import java.util.*;

/*
        https://leetcode.com/problems/mini-parser/
*/
class MiniParser {
    public static void main(String args[]) {

    }
}

class Solution {
    int i = 0;

    public NestedInteger deserialize(String s) {
        NestedInteger base = new NestedInteger();

        if(s.charAt(0) != '[') {
            Integer item = new Integer(s);
            base.setInteger(item);
            return base;
        }

        Stack<NestedInteger> stack = new Stack<>();

        while(hasNextToken(s)) {
            String token = nextToken(s);
            // System.out.println("token: " + token);
            if(token.equals("[")) {
                stack.push(new NestedInteger());
            } else if(token.equals("]")) {
                if(stack.size() > 1) {
                    NestedInteger child = stack.pop();
                    stack.peek().add(child);
                }
            } else {
                Integer num = new Integer(token);
                stack.peek().add(new NestedInteger(num));
            }
        }

        return stack.pop();
    }

    private String nextToken(String s) {
        StringBuilder sb = new StringBuilder();

        char currCh = s.charAt(i++);
        if(currCh == ',') {
            currCh = s.charAt(i++);
        }

        sb.append(currCh);

        if( currCh == '[' || currCh == ']') {
            return sb.toString();
        }

        while(i < s.length() && s.charAt(i) != '[' && s.charAt(i) != ']' && s.charAt(i) != ',') {
            sb.append(s.charAt(i++));
        }

        return sb.toString();

    }

    private boolean hasNextToken(String s) {
        return i < s.length();
    }
}
