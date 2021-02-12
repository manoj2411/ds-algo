/*
	https://leetcode.com/problems/valid-anagram/
*/
class ValidAnagram {
	public static void main(String[] args) {
		System.out.println(new Solution().isAnagram("cat", "car")); // false
		System.out.println(new Solution().isAnagram("anagram", "nagaram")); // true
	}
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] counts = new int[128];
        
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            counts[t.charAt(i)]--;
        }
        
        for(int c : counts) {
            if(c != 0) return false;
        }
        
        return true;
        
    }
}