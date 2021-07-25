import java.util.*;

/*
	https://leetcode.com/discuss/interview-question/632717/Facebook-or-Recruiting-Portal-or-Matching-Pairs
*/
class MatchingPairs {

	public static void main(String[] args) {
		List<List<String>> tests = new ArrayList<>();
		List<Integer> expected = new ArrayList<>();

		// diff == 0
		tests.add(List.of("abc", "abc"));
		expected.add(1);
		tests.add(List.of("abcb", "abcb"));
		expected.add(4);

		// diff == 1
		tests.add(List.of("abc", "abx"));
		expected.add(1);
		tests.add(List.of("abc", "abb"));
		expected.add(2);
		tests.add(List.of("aac", "aax"));
		expected.add(2);
		tests.add(List.of("aacd", "aadd"));
		expected.add(3);

		// diff > 1
		tests.add(List.of("abc", "bca"));
		expected.add(1);
		tests.add(List.of("abcd", "adcb"));
		expected.add(4);
		tests.add(List.of("abcde", "bcade"));
		expected.add(3);
		tests.add(List.of("abcde", "baade"));
		expected.add(4);
		tests.add(List.of("anopab", "apoqba"));
		expected.add(4);


		for(int i = 0; i < tests.size(); i++) {

			String s = tests.get(i).get(0);
			String t = tests.get(i).get(1);
			int output = new Solution().matchingPairs(s, t);

			check(output, expected.get(i), i + 1);

		};
	}

	static void check(int output, int expected, int test_case_number) {

    	boolean result = (expected == output);
    	char rightTick = '\u2713';
    	char wrongTick = '\u2717';

    	if (result) {
      		System.out.println(rightTick + " Test #" + test_case_number);
    	} else {
      		System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      		printInteger(expected);
      		System.out.print(" Your output: ");
      		printInteger(output);
      		System.out.println();
    	}
    	test_case_number++;
  }

  static void printInteger(int n) {
    System.out.print("[" + n + "]");
  }

}


class Solution {

  boolean containsUniqueChars(String str) {
    Set<Character> set = new HashSet<>();

    for(int i = 0; i < str.length(); i++) {
      if (!set.add(str.charAt(i))) return false;
    }
    return true;
  }

  // if ch present in str not at the given index
  boolean containsCharNotAt(String str, char ch, int index) {
    for(int i = 0; i < str.length(); i++) {
      if (index == i) continue;
      if (str.charAt(i) == ch) return true;
    }
    return false;
  }

  int gainAfterBestMatch(String s, String t, List<Integer> diff_ids, Map<Character, List<Integer>>diff_map) {
    boolean foundMatch = false;

    for(int i : diff_ids) {
      char ch_in_t = t.charAt(i);

      if (diff_map.containsKey(ch_in_t)) {
        foundMatch = true;
        for(int j : diff_map.get(ch_in_t)) {
        	// find a perfect swap
          	if (t.charAt(j) == s.charAt(i))
            	return 2;
        }
      }
    }

    return foundMatch ? 1 : 0;
  }


  int matchingPairs(String s, String t) {
    int N = s.length();
    List<Integer> diff_ids = new ArrayList<>();
    Map<Character, List<Integer>>diff_map = new HashMap<>();

    for(int i = 0; i < N; i++) {
      char ch_in_s = s.charAt(i);

      if(ch_in_s != t.charAt(i)) {
        diff_ids.add(i);

        if (!diff_map.containsKey(ch_in_s))
          diff_map.put(ch_in_s, new ArrayList<>());

        diff_map.get(ch_in_s).add(i);
      }
    }

    int num_of_matches = N - diff_ids.size();

    if (diff_ids.size() == 0) {
    	// s contains duplicates means we can swap without loosing matching count
      	return containsUniqueChars(s) ? num_of_matches - 2 : num_of_matches;
    }

    if (diff_ids.size() == 1) {
      int i = diff_ids.get(0);
      // contains duplicates means we can swap without loosing matching count
      if (!containsUniqueChars(s)) return num_of_matches;
      if (containsCharNotAt(s, t.charAt(i), i)) return num_of_matches;
      return num_of_matches - 1;
    }

    // maximize the matches by 1 or by 2
    return num_of_matches + gainAfterBestMatch(s, t, diff_ids, diff_map);
  }

}

