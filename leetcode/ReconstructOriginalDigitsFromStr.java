/*
    https://leetcode.com/problems/reconstruct-original-digits-from-english/
*/

class ReconstructOriginalDigitsFromStr {
    public static void main(String[] args) {
        System.out.println(new Solution().originalDigits("owoztneoerfviefuro"));
    }
}

class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];

        for(int i = 0; i < s.length(); i++) {

            switch(s.charAt(i)) {
                case 'z': count[0]++; break;
                case 'w': count[2]++; break;
                case 'u': count[4]++; break;
                case 'x': count[6]++; break;
                case 'g': count[8]++; break;

                case 'f': count[5]++; break; // - 4
                case 's': count[7]++; break; // - 6

                case 'r': count[3]++; break; // - 0, 4
                case 'o': count[1]++; break; // - 0, 2, 4
                case 'i': count[9]++; break; // - 8, 6, 5
            }

        }

        count[5] -= count[4];
        count[7] -= count[6];

        count[3] -= count[0] + count[4];
        count[1] -= count[0] + count[2] + count[4];
        count[9] -= count[8] + count[6] + count[5];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++)
            for (int j = 0; j < count[i]; j++)
                sb.append(i);

        return sb.toString();

    }
}
