import java.util.*;

class SortByFrequency {
    // decreasing frequency, by index

    public static void main(String[] args) {
        Integer[][] inputs = {
            {2, 5, 2, 8, 5, 6, 8, 8}, // 8, 8, 8, 2, 2, 5, 5, 6
            {5, 2, 8, 2, 5, 6, 8, 8}, // 8, 8, 8, 5, 5, 2, 2, 6
            {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}, // 8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999
        };

        for(Integer[] arr : inputs) {
            System.out.println("Original: " + Arrays.toString(arr));
            sort(arr);
            System.out.println("Sorted: " + Arrays.toString(arr));
            System.out.println();
        }
    }

    static void sort(Integer[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> indices = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int count = counter.getOrDefault(arr[i], 0);
            counter.put(arr[i], count + 1);
            if(!indices.containsKey(arr[i])) {
                indices.put(arr[i], i);
            }
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if(counter.get(a) == counter.get(b)) {
                    return Integer.compare(indices.get(a), indices.get(b));
                }
                return Integer.compare(-counter.get(a), -counter.get(b));
            }
        });
    }


}


