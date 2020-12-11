import java.util.*;

class PythagoreanTriplet {

    boolean checkTriplet(int[] arr) {
        int max = 0;
        Set<Integer> set = new HashSet<>();

        for(int e : arr) {
            set.add(e);
            max = Math.max(max, e);
        }

        int[] squares = new int[set.size()];
        int j = 0;
        for(int i = 1; i <= max; i++) {
            if(set.contains(i))
                squares[j++] = i * i;

        }

        // Now we have unique sorted values in squares

        for(int i = squares.length - 1; i >= 2; i--) {
            if(sumOfTwoExists(squares, i, squares[i]))
                return true;
        }
        return false;
    }

    boolean sumOfTwoExists(int[] arr, int n, int target) {
        int l = 0;
        int r = n - 1;

        while(l < r) {
            int sum = arr[l] + arr[r];
            if(sum > target)
                r--;
            else if(sum < target)
                l++;
            else
                return true;
        }
        return false;
    }

	public static void main(String[] args) {
		int[][]input = {
			{3, 2, 4, 6, 5},
			{3, 8, 5},
			{3, 1, 4, 6, 5,},
			{10, 4, 6, 12, 5}
		};

		for(int[] arr : input) {
			PythagoreanTriplet obj = new PythagoreanTriplet();
			System.out.println("arr: " + Arrays.toString(arr));
			System.out.println("Pythagorean Triplet Exists : " + obj.checkTriplet(arr));
			System.out.println();
		}
	}
}