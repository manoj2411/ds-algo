import java.util.*;

/*
	https://leetcode.com/problems/interval-list-intersections/
*/
class IntervalListIntersections {
	public static void main(String[] args) {
		int[][] list1 = { {0,2}, {6,7}, {13,23}, {24,25}, {30,40}};
		int[][] list2 = { {1,5}, {8,12}, {15,24}, {25,26}};

		int[][] result = new Solution().intervalIntersection(list1, list2);
		// result: [[1,2],[15,23],[24,24],[25,25]]

		for(int[] interval : result)
			System.out.print(Arrays.toString(interval) + " ");
		System.out.println(Arrays.toString());
	}
}

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int i = 0;
        int j = 0;

        List<int[]> list = new ArrayList<>();

        while(i < firstList.length && j < secondList.length) {

            int istart = Math.max(firstList[i][0], secondList[j][0]);
            int iend = Math.min(firstList[i][1], secondList[j][1]);

            if (istart <= iend) {
                list.add(new int[] {istart, iend});
            }

            if (firstList[i][1] < secondList[j][1])
                i++;
            else if (firstList[i][1] > secondList[j][1])
                j++;
            else {
                i++;
                j++;
            }
        }


        return list.toArray(new int[list.size()][]);
    }
}
