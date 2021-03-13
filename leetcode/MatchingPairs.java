import java.util.*;

/*
	https://leetcode.com/discuss/interview-question/632717/Facebook-or-Recruiting-Portal-or-Matching-Pairs
*/
class MatchingPairs {
	public static void main(String[] args) {


		System.out.println(new Solution().matchingPairs("abc", "bca")); // 1

		System.out.println(new Solution().matchingPairs("anopab", "apoqba")); // 4

		System.out.println(new Solution().matchingPairs("abcd", "adcb")); // 4
		System.out.println(new Solution().matchingPairs("abcde", "bcade")); // 3
		System.out.println(new Solution().matchingPairs("abcde", "baade")); // 4

		System.out.println(new Solution().matchingPairs("abc", "abc")); // 1
		System.out.println(new Solution().matchingPairs("abcde", "baade")); // 4
	}
}

class Solution {
	List<List<Integer>> diffCharIndices = buildDiffCharIndices();

	int matchingPairs(String s, String t) {

		int matched = 0;

		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i)) {
				matched++;
			} else {
				int ch = s.charAt(i) - 'a';
				diffCharIndices.get(ch).add(i);
			}
		}

		if (matched == s.length()) return matched - 2; // everything is matching

		if (canSwapWithAtLeastOneMatch(t)) {
			matched++;
		} else {
			return matched; // no replaceable match in missing characters
		}

		return canSwapWithTwoMatch(s, t) ? matched + 1 : matched;
	}


	private boolean canSwapWithTwoMatch(String s, String t) {

		for(int i = 0; i < 26; i++) {
			for(int s_i : diffCharIndices.get(i)) {

				int ch_t = t.charAt(s_i) - 'a';
				// System.out.println("s(i) : " + s.charAt(s_i) + ", t(i): " + t.charAt(s_i));

				for (int s_j : diffCharIndices.get(ch_t)) {
					// System.out.println("  s(j) : " + s.charAt(s_j));
					if (t.charAt(s_j) == s.charAt(s_i))
						return true; // there is a matching switch possible
				}
			}
		}

		return false;
	}

	private boolean canSwapWithAtLeastOneMatch(String t) {
		for(int i = 0; i < 26; i++) {
			for(int indx : diffCharIndices.get(i)) {

				int char_in_t = t.charAt(indx) - 'a';

				if (diffCharIndices.get(char_in_t).size() > 0)
					return true;
			}
		}

		return false;
	}

	private List<List<Integer>> buildDiffCharIndices() {
		List<List<Integer>> diffCharIndices = new ArrayList<>();

		for(int i = 0; i < 26; i++)
			diffCharIndices.add(new ArrayList<>());

		return diffCharIndices;
	}
}
