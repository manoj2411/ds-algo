import java.util.*;

/*
	https://leetcode.com/problems/powerful-integers/
*/
class PowerfulIntegers {
	public static void main(String[] args) {

		System.out.println(new Solution().powerfulIntegers(2,3, 10));
		// [2,3,4,5,7,9,10]

		System.out.println(new Solution().powerfulIntegers(5,3, 15));
		// [2,4,6,8,10,14]

	}
}

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        List<Integer> list = new LinkedList<>();

        if(max == 1)
        	if(bound >= 2) return List.of(2);
        	else return List.of();

        for(int i = 0; Math.pow(max, i) < bound; i++)
            list.add((int)Math.pow(max, i));

        // System.out.println(list);

        Set<Integer> result = new HashSet<>();

        if (min == 1) {
            for(int n2 : list)
                if (1 + n2 <= bound) result.add(1 + n2);

        } else {
            for(int i = 0; Math.pow(min, i) < bound; i++) {
                int n1 = (int)Math.pow(min, i);

                for(int n2 : list) {
                    if (n1 + n2 <= bound) result.add(n1 + n2);
                    else break;
                }
            }
        }

        return List.copyOf(result);
    }
}
