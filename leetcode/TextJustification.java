import java.util.*;

/*
	https://leetcode.com/problems/text-justification/
*/
class TextJustification {
	public static void main(String[] args) {
		String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		int maxWidth = 20;

		List<String> result = new Solution().fullJustify(words, maxWidth);

		for(String line : result)
			System.out.println("\"" + line + "\"");
		/* result:
			"Science  is  what we",
  			"understand      well",
  			"enough to explain to",
  			"a  computer.  Art is",
  			"everything  else  we",
  			"do                  "
		*/
	}
}

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int currIndex = 0;
        List<String> lineWords = new ArrayList<>();

        while( currIndex < words.length ) {

	        int lineWordsLength = 0;
	        while( currIndex < words.length && (words[currIndex].length() + lineWords.size() + lineWordsLength) <= maxWidth) {

		        lineWords.add(words[currIndex]);
		        lineWordsLength += words[currIndex].length();
		        currIndex++;
	        }

	        if (currIndex == words.length) break;

            result.add(makeLine(lineWords, lineWordsLength, maxWidth));
            lineWords = new ArrayList<>();
        }

        String lastLine = String.join(" ", lineWords);
        lastLine += spaces(maxWidth - lastLine.length()).toString();

        result.add(lastLine);

        return result;

    }

	String makeLine(List<String> words, int lineWordsLength, int width) {
		StringBuilder res = new StringBuilder();

		if (words.size() == 1) {
			res.append(words.get(0));
			res.append(spaces(width - res.length() ));
			return res.toString();
		}

		int spots = words.size() - 1;
        int totalSpaces = width - lineWordsLength;

		int minSpaces = totalSpaces / spots;
		int extraSpaces = totalSpaces % spots;

		for(int i = 0; i < words.size() - 1; i++) {
			res.append(words.get(i));
			res.append(spaces(minSpaces));
			if (extraSpaces > 0) {
				extraSpaces--;
				res.append(' ');
			}
		}
        res.append(words.get(words.size() - 1));
        return res.toString();
	}

	StringBuilder spaces(int size) {
		StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < size; i++)
			sb.append(' ');
		return sb;
	}
}
