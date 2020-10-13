import java.util.*;

/*
        https://leetcode.com/problems/buddy-strings/
*/
class BuddyStrings {

    public static void main(String[] args) {
        String[][] inputs = { {"ab", "ba"},{"ab", "ab"}, {"aa", "aa"}, {"a", "aa"}};


        for(String[] strings : inputs) {
            Solution sol = new Solution();
            System.out.println("A: " + strings[0] + ", B: " + strings[1]);
            System.out.println("Res: " + sol.buddyStrings(strings[0], strings[1]));
        }

    }
}

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())
            return false;

        // has duplicate and same is true
        if(A.equals(B)) {
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < A.length(); i++)
                set.add(A.charAt(i));
            return A.length() > set.size();
        }

        int j = -1;
        int k = -1;

        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != B.charAt(i)) {
                if(j == -1) {
                    j = i;
                } else if(k == -1) {
                    k = i;
                } else {
                    return false;
                }
            }
        }
        // System.out.println("diff: " + diff + ", hasDuplicate : " + hasDuplicate);
        return j > -1 && k > -1 && A.charAt(k) == B.charAt(j) && A.charAt(j) == B.charAt(k);
    }
}
