/*      https://leetcode.com/problems/car-pooling/      */

class CarPooling {
    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            // take array of location - 1000 is the max distance
            // start trip till end - 1
            // put all passengers into the
            // and whenever currCapacity goes above capacity return false
            int[] distance = new int[1001];
            // for(int i = 0; i <= 1000; i++) distance[i] = 0;

            for(int i = 0; i < trips.length;i++) {
                int passengers = trips[i][0];
                int start_loc = trips[i][1];
                int end_loc = trips[i][2];

                for(int j = start_loc; j < end_loc; j++) {
                    distance[j] += passengers;
                    if(distance[j] > capacity)
                        return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] trips1 = {{2,1,5},{3,3,7}} ;
        int capacity1 = 4; // false
        System.out.println(sol.carPooling(trips1, capacity1));


        int[][] trips2 = {{2,1,5},{3,3,7}} ;
        int capacity2 = 5; // true
        System.out.println(sol.carPooling(trips2, capacity2));

        int[][] trips3 = {{2,1,5},{3,5,7}} ;
        int capacity3 = 3; // true
        System.out.println(sol.carPooling(trips3, capacity3));

        int[][] trips4 = {{3,2,7},{3,7,9},{8,3,9}} ;
        int capacity4 = 11; // true
        System.out.println(sol.carPooling(trips4, capacity4));
    }

}

