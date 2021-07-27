import java.util.*;

class RevenueMilestones {
	public static void main(String[] args) {
    int revenues[] = {100, 200, 300, 400, 500};
    int milestones[] = {300, 800, 1000, 1400};
    System.out.println(Arrays.toString(
    	new Solution().getMilestoneDays(revenues, milestones)));
    // int expected[] = {2, 4, 4, 5};

    revenues = new int[] {700, 800, 600, 400, 600, 700};
    milestones = new int[] {3100, 2200, 800, 2100, 1000};
    System.out.println(Arrays.toString(
    	new Solution().getMilestoneDays(revenues, milestones)));
    // int expected[] = {5, 4, 2, 3, 2};

	}
}

class Solution {

  int[] getMilestoneDays(int[] revenues, int[] milestones) {
    // Write your code here
    int K = milestones.length;

    int[] result = new int[K];
    Arrays.fill(result, -1);

    int curr_revenue = 0;

    // assuming there are no duplicate milestones
    TreeMap<Integer, Integer> map = new TreeMap<>();

    for(int i = 0; i < K; i++) {
      map.put(milestones[i], i);
    }

    for(int i = 0; i < revenues.length && map.size() > 0; i++) {
      curr_revenue += revenues[i];

      while(!map.isEmpty() && curr_revenue >= map.firstKey() ) {
        Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
        result[entry.getValue()] = i + 1;
      }

    }
    return result;
  }
}
