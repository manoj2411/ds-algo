import java.util.*;


/*
	https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
*/
class MinDeletionsToMakeCharFrequenciesUnique {
	public static void main(String[] args) {
		System.out.println(new Solution().minDeletions("aab")); // 0
		System.out.println(new Solution().minDeletions("aaabbbcc")); // 2
		System.out.println(new Solution().minDeletions("ceabaacb")); // 2
	}
}

class Solution {
    public int minDeletions(String s) {
        int[] charFrequency = new int[26];

        for(char ch : s.toCharArray()) {
            int i = ch - 'a';
            charFrequency[i]++;
        }

        Arrays.sort(charFrequency);
        Set<Integer> set = new HashSet<>();
        int deletions = 0;
        for(int f : charFrequency) {
            deletions += deletionsToMakeFrequencyUnique(f, set);
        }
        return deletions;
    }

    private int deletionsToMakeFrequencyUnique(int count, Set<Integer> set) {
        if (count == 0) {
            return 0;
        } else if (!set.contains(count)) {
            set.add(count);
            return 0;
        } else {
            return 1 + deletionsToMakeFrequencyUnique(count - 1, set);
        }
    }
}
