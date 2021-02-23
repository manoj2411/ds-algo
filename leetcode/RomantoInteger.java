import java.util.*;
/*
        https://leetcode.com/problems/roman-to-integer/
*/
class RomantoInteger {
    public static void main(String[] args) {
        String[] input = { "LVIII", "MCMXCIV"}; // 58, 1994
        for(String roman : input) {
            System.out.println("Roman: " + roman);
            System.out.println("Int: " + new Solution().romanToInt(roman));
            System.out.println();
        }
    }
}

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        int prev = 0;

        for(int i = s.length() - 1; i >= 0; i--) {

            int curr = map.get(s.charAt(i));

            if(curr < prev) res -= curr;
            else res += curr;

            prev = curr;
        }

        return res;
    }
}
