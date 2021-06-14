import java.util.*;

/*
	https://leetcode.com/problems/maximum-units-on-a-truck/
*/
class MaximumUnitsOnTruck {
	public static void main(String[] args) {
		int[][] boxTypes = {{1,3}, {2,2}, {3,1}};
		int truckSize = 4;
		System.out.println(new Solution().maximumUnits(boxTypes, truckSize)); // 8

		boxTypes = new int[][] {{5,10}, {2,5}, {4,7}, {3,9}};
		truckSize = 10;
		System.out.println(new Solution().maximumUnits(boxTypes, truckSize)); // 91
	}
}

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> -Integer.compare(a[1], b[1]));

        int maxUnits = 0;
        int boxInTruck = 0;

        for(int[] boxType : boxTypes) {
            int numOfBoxes = boxType[0];
            int unitPerBox = boxType[1];

            int boxesToLoad = Math.min(truckSize - boxInTruck, numOfBoxes);

            maxUnits += boxesToLoad * unitPerBox;

            boxInTruck += boxesToLoad;

            if (boxInTruck == truckSize) break;
        }

        return maxUnits;
    }
}
