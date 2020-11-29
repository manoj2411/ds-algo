import java.util.*;
/*
	Sort A1 in such a way that the relative order among the elements will be same as
	those in A2.
	For the elements not present in A2, append them at last in sorted order.
*/
class RelativeSorting {
	public static void main(String[] args) {
		int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    	int[] A2 = {2, 1, 8, 3};
		// Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
    	sortWithMap(A1, A1.length, A2, A2.length);
    	System.out.println(Arrays.toString(A1));

    	A1 = new int[]{2, 1, 2, 5, 7, 1, 9, 3, 6, 18, 8};
    	Integer[] a1 = Arrays.stream(A1).boxed().toArray( Integer[]::new );
    	sortWithComparator(a1, a1.length, A2, A2.length);
    	System.out.println(Arrays.toString(a1));
	}

	/*		Sorting using hashMap		*/
	static void sortWithMap(int[] a1, int n, int[] a2, int m) {
	    Map<Integer, Integer> acount = new HashMap<>();
	    for(int i = 0; i < n; i++) {
	        int c = acount.getOrDefault(a1[i], 0);
	        acount.put(a1[i], c + 1);
	    }

	    int ai = 0;
	    for(int item : a2) {
	        if(acount.containsKey(item)) {
	            for(int i = 0; i < acount.get(item); i++)
	                a1[ai++] = item;
	           acount.remove(item);
	        }
	    }
	    List<Integer> keys = new ArrayList<>(acount.keySet());
	    Collections.sort(keys);
        for(int item : keys) {
            for(int i = 0; i < acount.get(item); i++)
                a1[ai++] = item;
        }
	}

	/*		Sorting using Comparator		*/
	static void sortWithComparator(Integer[] a1, int n, int[] a2, int m) {

	    Map<Integer, Integer> indices = new HashMap<>();
	    for(int i = 0; i < m; i++) indices.put(a2[i], i);

	    Arrays.sort(a1, new Comparator<Integer>() {
	        public int compare(Integer a, Integer b) {
	            int ai = indices.getOrDefault(a, m);
	            int bi = indices.getOrDefault(b, m);
	            if(ai == bi)
	                return Integer.compare(a, b);
	           return Integer.compare(ai, bi);
	        }
	    });

	}
}