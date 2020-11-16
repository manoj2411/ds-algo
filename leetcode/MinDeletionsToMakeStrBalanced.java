/*
        https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
*/
class MinDeletionsToMakeStrBalanced {
    public static void main(String[] args) {
        String[] inputs = { "aababbab", "bbaaaaabb", "bbaaaa", "aaab", "bbbbaa"};
        for(String s : inputs) {
            Solution sol = new Solution();
            System.out.println("\nstr: " + s + ", min deletions: " + sol.minimumDeletions(s));
        }
    }
}

/*
    The idea is to remove misplaced 'a', for that,  traverse from right to left,
    count number of 'a' and whenever we encounter with a char 'b' and we have
    a's count > 0 then decrease a'count and increment result variable which
    depicts deletion of a character.
*/
class Solution {
    public int minimumDeletions(String s) {
        int acount = 0;

        int res = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == 'a') {
                acount++;
            } else if(acount > 0) {
                acount--;
                res++;
            }
        }

        return res;
    }
}
