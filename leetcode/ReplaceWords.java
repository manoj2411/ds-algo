import java.util.*;

/*
	https://leetcode.com/problems/replace-words/
*/
class ReplaceWords {
	public static void main(String[] args) {
		List<String> dict = List.of("catt","cat","bat","rat");
		String sentence = "the cattle was rattled by the battery";
		System.out.println(new Solution().replaceWords(dict, sentence));
		// result: "the cat was rat by the bat"
	}
}

class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {

        Set<String> dict = new HashSet<>(dictionary);
        List<String> words = new ArrayList<>();

        for(String word : sentence.split(" ")) {
            words.add(findRoot(word, dict));
        }

        return String.join(" ", words);
    }

    private String findRoot(String word, Set<String> dict) {
        for (int i = 1; i <= word.length(); i++) {
            String root = word.substring(0, i);
            if (dict.contains(root))
                return root;
        }
        return word;
    }
}
