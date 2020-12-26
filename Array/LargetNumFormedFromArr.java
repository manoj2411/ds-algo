import java.util.*;

class LargetNumFormedFromArr {

	public static void main(String[] args) {
		String[] arr = {"3", "30", "34", "5", "9"};
		// 9534330
		System.out.println(new Solution().printLargest(arr));

		arr = new String[]{"54", "546", "548", "60"};
		//	6054854654
		System.out.println(new Solution().printLargest(arr));
	}

}

class Solution {
    String printLargest(String[] arr) {
        Arrays.sort(arr,
            (String a, String b) -> (b+a).compareTo(a+b)
        );

        return String.join("", arr);
    }
}