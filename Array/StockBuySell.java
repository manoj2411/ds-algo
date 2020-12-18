import java.util.*;

class StockBuySell {

	public static void main(String[] args) {
		int[] arr = {100,180,260,310,40,535,695};
		System.out.println(new StockBuySell().stockBuySell(arr, arr.length));

		arr = new int[] {4,2,2,2,4};
		System.out.println(new StockBuySell().stockBuySell(arr, arr.length));

		arr = new int[] {1,2,3,4,5,7,8,9};
		System.out.println(new StockBuySell().stockBuySell(arr, arr.length));

		arr = new int[] {8,7,4,3,2,1};
		System.out.println(new StockBuySell().stockBuySell(arr, arr.length));

	}

	ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if(n <= 1) return res;

        int i = 1;
        int buyAt = -1;

        while(i < n) {

        	if(buyAt == -1) {
        		if(A[i - 1] < A[i])
        			buyAt = i - 1;
        	} else if(A[i - 1] > A[i]) {
        		ArrayList<Integer> list = new ArrayList<>();
        		list.add(buyAt);
        		list.add(i - 1);
        		res.add(list);
        		buyAt = -1;
        	}

        	i++;
        }

        if(buyAt > -1)
        	res.add(new ArrayList<Integer>(
        		Arrays.asList(buyAt, n -1)
        	));

        return res;

    }
}