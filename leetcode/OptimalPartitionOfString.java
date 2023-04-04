/*
	https://leetcode.com/problems/optimal-partition-of-string/description/
*/
class OptimalPartitionOfString {
	public static void main(String[] args) {
		System.out.println(new Solution().partitionString("abacaba")); // 4
		System.out.println(new Solution().partitionString("ssssss")); // 6
	}
}

class Solution {

    public int partitionString(String s) {
        int partitions = 1;
        boolean[] chars = new boolean[26];

        for(char ch : s.toCharArray()) {
            int charIndex = ch - 'a';
            if (chars[charIndex]) {
                partitions++;
                chars = new boolean[26];
            }
            chars[charIndex] = true;
        }

        return partitions;
    }
}
