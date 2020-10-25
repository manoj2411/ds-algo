import java.util.*;

/*
        https://leetcode.com/problems/bag-of-tokens/
*/
class BagOfTokens {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] tokens = {100};
        int power = 50; // res : 0
        System.out.println(sol.bagOfTokensScore(tokens, power));

        int[] tokens1 = {100,200,300,400};
        power = 200; // res : 2
        System.out.println(sol.bagOfTokensScore(tokens1, power));
    }
}

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);

        int high = tokens.length - 1;
        int low = 0;
        int max = 0;
        int score = 0;

        while(low <= high) {
            if(P >= tokens[low]) {
                P -= tokens[low];
                low++;
                score++;
                if(score > max) max = score;
            } else if(score > 0) {
                P += tokens[high];
                high--;
                score--;
            } else {
                break;
            }
        }

        return max;
    }
}
