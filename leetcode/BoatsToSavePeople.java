import java.util.*;

/*
	https://leetcode.com/problems/boats-to-save-people/
*/
class BoatsToSavePeople {
	public static void main(String[] args) {
		int[] people = {3,2,2,1};
		int limit = 3;
		System.out.println(new Solution().numRescueBoats(people, limit)); // 3
	}
}

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        int res = 0;

        while(l <= r) {
            if(people[r] + people[l] <= limit) {
                l++;
            }
            r--;
            res++;
        }
        return res;
    }
}