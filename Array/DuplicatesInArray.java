import java.util.*;

class DuplicatesInArray {

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 3, 5, 5};
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("duplicates: " + duplicates(arr, arr.length));
    }

    static ArrayList<Integer> duplicates(int arr[], int n) {
        for(int e : arr) {
            int i = e % n;
            arr[i] += n;
        }
        // System.out.println(Arrays.toString(arr));
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){
            if(arr[i] / n > 1)
                result.add(i);
        }

        if(result.isEmpty())
            result.add(-1);
        return result;
    }
}
