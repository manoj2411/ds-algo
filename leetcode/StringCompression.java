/*
    https://leetcode.com/problems/string-compression/description/
*/
class StringCompression {
    public static void main(String[] args) {
        char[] chars = "aaabbbbbbbbbbbbcdd".toCharArray();
        System.out.println(toCompressed(chars)); // a3b12cd2
    }

    private static String toCompressed(char[] chars) {
        int length = new Solution().compress(chars);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < length; i++) {
            result.append(chars[i]);
        }
        return result.toString();
    }
}

class Solution {
    public int compress(char[] chars) {
        int curr = 0;
        int counter = 1;
        for(int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[curr]) {
                counter++;
            } else {
                curr = mergeCounter(chars, counter, curr);
                chars[curr] = chars[i];
                counter = 1;
            }
        }
        curr = mergeCounter(chars, counter, curr);
        return curr;
    }

    private int mergeCounter(char[] chars, int counter, int index) {
        index++;
        if (counter == 1) {
            return index;
        }

        for(char ch : String.valueOf(counter).toCharArray()) {
            chars[index++] = ch;
        }
        return index;
    }
}

/***

     c
    ["a","a","a","b","c","c","c"]
                                  i
    c : 3

    if c[a] == c[b]
        incr counter
    else
        if counter > 1 then replace a + 1 with coutner str
        a is now at new position, replace the char to  equal to b
        set counter as 1
 */
