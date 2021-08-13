import java.util.*;

/*
	https://leetcode.com/problems/top-k-frequent-words/
*/
class TopKFrequentWords {
	public static void main(String[] args) {

 		String[] words = {"i","love","leetcode","i","love","coding"};
 		int k = 2;
 		System.out.println(new Solution().topKFrequent(words, k));
		// res : ["i","love"]
	}
}


class Solution {
    public List<String> topKFrequent(String[] words, int k) {

		Map<String, Integer> wordCount = new HashMap<>();

		for(String word : words) {
			wordCount.put(word, 1 + wordCount.getOrDefault(word, 0));
		}

		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((pair1, pair2) -> {

	        if (pair1.getValue() == pair2.getValue())
                return -pair1.getKey().compareTo(pair2.getKey());

            return Integer.compare(pair1.getValue(), pair2.getValue());
        });

        for(Map.Entry<String, Integer> entry : wordCount.entrySet()) {
	        pq.add(entry);

	        if (pq.size() > k)  pq.poll();
        }

        List<String> result = new ArrayList<>();
        while(pq.size() > 0) {
	        result.add(pq.poll().getKey());
        }
        Collections.reverse(result);

        return result;
    }

}
