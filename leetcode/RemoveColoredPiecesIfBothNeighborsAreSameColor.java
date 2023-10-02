import java.util.*;

/*
    https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
*/
class RemoveColoredPiecesIfBothNeighborsAreSameColor {
    public static void main(String... args) {
        System.out.println(new Solution().winnerOfGame("AAABABB"));     // true
        System.out.println(new Solution().winnerOfGame("AA"));          // false
        System.out.println(new Solution().winnerOfGame("ABBBBBBBAAA")); // false
    }
}

class Solution {

    public boolean winnerOfGame(String colors) {
        Stack<Integer> alice = new Stack<>();
        Stack<Integer> bob = new Stack<>();

        int count = 0;
        char prev = '#';
        for(char ch : colors.toCharArray()) {
            if (ch == 'A') {
                if (prev == ch) {
                    count++;
                } else {
                    addTo(bob, count);
                    prev = ch;
                    count = 1;
                }
            } else { // ch == B
                if (prev == ch) {
                    count++;
                } else {
                    addTo(alice, count);
                    prev = ch;
                    count = 1;
                }
            }
        }
        addTo(prev == 'A' ? alice : bob, count);

        boolean aliceTurn = true;
        while(true) {
            if (aliceTurn) {
                if (alice.isEmpty()) return false;
                addTo(alice, alice.pop() - 1);
            } else {
                if (bob.isEmpty()) return true;
                addTo(bob, bob.pop() - 1);
            }
            aliceTurn = !aliceTurn;
        }
    }

    private void addTo(Stack<Integer> stack, int count) {
        if (count >= 3) {
            stack.push(count);
        }
    }
}
