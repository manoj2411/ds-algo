import java.util.*;

/*
        https://leetcode.com/problems/simplify-path/
*/
class SimplifyPath {
    public static void main(String[] args) {
        String[] inputs = {
            "/", "/a", "/a/////",
            "/a/////./..//b///c/d",
            "/home/",
            "/../",
            "/home//..foo/",
            "/a/./b../../../c./"
        };

        for(String path : inputs) {
            System.out.println("Given path: " + path);
            System.out.println("simplified path: " + new Solution().simplifyPath(path));
            System.out.println();
        }

    }
}

/*
    NOTE : here we are traversing string via our own created methods that returns
        next token between / . This slightly complicates the code which can greately
        simplified by using split("/") method on string but I choose to do it by
        own iterator method(sort of iterator :)) to handle complexity around it for
        practice. In real world I would choose split("/") method :)
*/
class Solution {
    int i;
    Stack<String> stack;

    public String simplifyPath(String path) {
        stack = new Stack<>();
        i = 0;

        while(hasNextToken(path)) {
            String token = nextToken(path);

            if(token.equals("") || token.equals(".")) {
                continue;
            } else if(token.equals("..")) {
                if(stack.size() > 0) stack.pop();
            } else {
                stack.push(token);
            }
        }


        StringBuilder canonicalPath = new StringBuilder();
        for(String dir : stack) {
            canonicalPath.append("/" + dir);
        }

        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }

    private boolean hasNextToken(String path) {
        return i + 1 < path.length();
    }

    private String nextToken(String path) {
        StringBuilder sb = new StringBuilder();
        int j;
        for(j = i + 1; j < path.length(); j++) {
            char ch = path.charAt(j);

            if(ch == '/') {
                if(j - i == 1) i++;
                else break;
            } else {
                sb.append(ch);
            }
        }

        i = j;
        return sb.toString();
    }
}
