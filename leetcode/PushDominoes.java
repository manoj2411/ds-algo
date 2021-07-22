import java.util.*;

/*
	https://leetcode.com/problems/push-dominoes/
*/
class PushDominoes {
	public static void main(String[] args) {
		System.out.println(
			new Solution().pushDominoes(".L.R...LR..L.."));// "LL.RR.LLRRLL.."
	}
}

class Solution {

    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        Queue<Integer> que = new LinkedList<>();
        StringBuilder state = new StringBuilder(dominoes);
        enqueDominoes(que, state);

        while(que.size() > 0) {
            int size = que.size();
            StringBuilder nextState = new StringBuilder(state);

            for(int s = 0; s < size; s++) {
                int index = que.poll();

                char currState = state.charAt(index);

                if (index == 0) {
                    currState = state.charAt(1); // must be L
                } else if (index == len - 1) {
                    currState = state.charAt(index - 1); // must be R
                } else {

                    if (state.charAt(index - 1) == 'R' && state.charAt(index + 1) == 'L') {
                        continue;
                    } else if (state.charAt(index + 1) == 'L') { // make curr left
                        currState = 'L';
                        if (canEnqueLeft(state, index))
                            que.add(index - 1);
                    } else if (state.charAt(index - 1) == 'R') { // make curr right
                        currState = 'R';
                        if (canEnqueRight(state, index))
                            que.add(index + 1);
                    }
                }

                nextState.setCharAt(index, currState);

            }
            state = nextState;
        }


        return state.toString();
    }

    void enqueDominoes(Queue que, StringBuilder state) {
        int len = state.length();

        // push indices to que
        for(int i = 0; i < len; i++) {

            if(state.charAt(i) == 'L' && canEnqueLeft(state, i)) {
                que.add(i-1);
            } else if (state.charAt(i) == 'R' && canEnqueRight(state, i)) {
                que.add(i+1);
            }
        }

    }

    private boolean canEnqueRight(StringBuilder state, int i) {
        return i + 1 < state.length() && state.charAt(i + 1) == '.';
    }

    private boolean canEnqueLeft(StringBuilder state, int i) {
        return i - 1 >= 0 && state.charAt(i - 1) == '.';
    }
}
