/*
	https://leetcode.com/problems/median-of-two-sorted-arrays/
*/
class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] arr1 = {};
		int[] arr2 = {2,3};
		System.out.println(new Solution().findMedianSortedArrays(arr1, arr2));

		arr1 = new int[] {1,3};
		arr2 = new int[] {2};
		System.out.println(new Solution().findMedianSortedArrays(arr1, arr2));

		arr1 = new int[] {1,2};
		arr2 = new int[] {3,4};
		System.out.println(new Solution().findMedianSortedArrays(arr1, arr2));

		arr1 = new int[] {2};
		arr2 = new int[] {};
		System.out.println(new Solution().findMedianSortedArrays(arr1, arr2));
	}
}

class Solution {
    /*
        complexity of solution:

            time:   O(m+n)
            space:  O(1)
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;

        int mid = total / 2;

        int i = 0;
        int j = 0;
        int k = 0;

        int curr = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;


        while (i < len1 && j < len2) {

            if (nums1[i] < nums2[j]) {
                if (k == mid) {
                    prev = curr;
                    curr = nums1[i];
                    break;
                }
                curr = nums1[i++];
            } else {
                if (k == mid) {
                    prev = curr;
                    curr = nums2[j];
                    break;
                }
                curr = nums2[j++];
            }

            k++;
        }

        if (prev != Integer.MAX_VALUE)
            return (total % 2 == 1) ? (double)curr : ((double)(curr+prev)) / 2;


        while (i < len1) {
            if (k == mid) {
                prev = curr;
                curr = nums1[i];
                break;
            }
            curr = nums1[i++];
            k++;
        }

        while (j < len2) {

            if (k == mid) {
                prev = curr;
                curr = nums2[j];
                break;
            }
            curr = nums2[j++];
            k++;
        }

        return (total % 2 == 1) ? (double)curr : ((double)(curr+prev)) / 2;
    }
}
