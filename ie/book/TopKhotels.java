import java.util.*;

class TopKhotels {
	public static void main(String[] args) {
        String pos = "view citycenter metro price beach location staff breakfast";
        String neg = "not";
        List<Integer> hotelIds = List.of(1, 2, 1, 1, 2);
        List<String> reviews = List.of("This hotel has a nice view of the citycenter. The location is perfect.",
            "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
            "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
            "They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
            "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");



        System.out.println(Result.awardTopKHotels(pos, neg, hotelIds, reviews, 2));

        // for(String str : reviews) {
        //     str = str.replaceAll("[.,]", "").toLowerCase();
        //     String[] words = str.split("\\s+");
        //     System.out.println(Arrays.toString(words));
        // }

	}
}


class Result {

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
    	// Write your code here

	    int n = hotelIds.size();

	    PriorityQueue<Node> pq = new PriorityQueue<>( (Node n1, Node n2) -> {
	        if(n1.score == n2.score)
	            return -Integer.compare(n1.hotelId, n2.hotelId);
	        return Integer.compare(n1.score, n2.score);

	    });

	    Set<String> pos_set = new HashSet<>();
	    for(String s:positiveKeywords.split(" ")){
	        pos_set.add(s);
	    }

		Set<String> neg_set = new HashSet<>();
	    for(String s:negativeKeywords.split(" ")){
	        neg_set.add(s);
	    }

	    // System.out.println(p_set);
	    // System.out.println(n_set);
	    // System.out.println(hotelIds);
	    // System.out.println(reviews);

	    Map<Integer, Node> map = new HashMap<>();

	    for(int i = 0; i < n; i++) {
	        int hotelId = hotelIds.get(i);
	        String review = reviews.get(i);

	        int score = 0;

	        String[] words = review.replaceAll("[.,]", "").toLowerCase().split("\\s+");

	        for(String word : words) {
	            if(pos_set.contains(word)) score += 3;
	            else if(neg_set.contains(word)) score -= 1;
	        }
	        // System.out.println("score: " + score);

	        Node node = map.getOrDefault(hotelId, new Node(hotelId, 0));
	        node.score += score;
	        map.put(hotelId, node);

	    }

	    for(Node node : map.values()) {
	    	// System.out.println("hotelId: " + node.hotelId + ", score: " + node.score);
	    	if(pq.size() < k) {
	    		pq.add(node);
	    	} else {
	    		pq.add(node);
	    		pq.remove();
	    	}
	    }

	    List<Integer> res = new ArrayList<>();

	    while(pq.size() > 0) res.add(pq.poll().hotelId);

	    Collections.reverse(res);

	    return res;
    }

}



class Node {

    int score;
    int hotelId;

    public Node(int hotelId, int score){
        this.hotelId = hotelId;
        this.score = score;
    }
}
