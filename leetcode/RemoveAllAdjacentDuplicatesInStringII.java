import java.util.*;

/*
	https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
*/
class RemoveAllAdjacentDuplicatesInStringII {
	public static void main(String[] args) {
		String s = "abcd";
		int k = 2;
		System.out.println(new Solution().removeDuplicates(s, k)); // abcd

		s = "deeedbbcccbdaa";
		k = 3;
		System.out.println(new Solution().removeDuplicates(s, k)); // aa
	}
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for(char ch : s.toCharArray()) {

            if (stack.isEmpty() || stack.peek().key != ch) {
                stack.push(new Pair<>(ch, 1));
            } else {
                stack.peek().value++;
                if (stack.peek().value == k) {
                    stack.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for(Pair pair : stack) {
            for(int i = 0; i < (int)pair.value; i++) {
                result.append(pair.key);
            }
        }

        return result.toString();

    }

    private class Pair<K,V> {
        K key;
        V value;

        Pair(K k, V v) {
            key = k;
            value = v;
        }
    }
}
