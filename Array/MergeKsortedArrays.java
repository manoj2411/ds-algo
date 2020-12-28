import java.util.*;

class MergeKsortedArrays {
	public static void main(String[] args) {
		int K = 4;
		int[][] arrays = { {1,2,3,4}, {2,2,3,4}, {5,5,6,6}, {7,8,9,9} };

		System.out.println(K + " sorted arrays: ");
		for(int[] row : arrays) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
		System.out.println("Res: "+ Solution.mergeKArrays(arrays, K));
	}
}

class Solution {
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k)
    {
        // Write your code here.
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int l = 0;
        int r = k - 1;

        while(l < r) {
            res.add(merge(arrays[l++], arrays[r--]));
        }

        if(l == r) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < k; i++) {
                list.add(arrays[l][i]);
            }
            res.add(list);
        }

        l = 0;
        r = res.size() - 1;

        while(r > 0) {
            while(l < r) {
                res.set(l, merge(res.get(l), res.get(r--)));
                l++;
            }
            l = 0;
            // System.out.println(res);
        }

        return res.get(0);
    }

    static ArrayList<Integer> merge(int[] a1, int[] a2) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < a1.length && j < a2.length) {
            if(a1[i] <= a2[j]) {
                res.add(a1[i++]);
            } else {
                res.add(a2[j++]);
            }
        }
        while(i < a1.length) {
            res.add(a1[i++]);
        }

        while(j < a2.length) {
            res.add(a2[j++]);
        }
        return res;
    }
    static ArrayList<Integer> merge(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < a1.size() && j < a2.size()) {
            if(a1.get(i) <= a2.get(j)) {
                res.add(a1.get(i++));
            } else {
                res.add(a2.get(j++));
            }
        }
        while(i < a1.size()) {
            res.add(a1.get(i++));
        }

        while(j < a2.size()) {
            res.add(a2.get(j++));
        }
        return res;
    }
}