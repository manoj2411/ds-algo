import java.util.*;

/*
    https://leetcode.com/problems/lfu-cache/description/
*/
class LFUCache {

    private int minFrequency;
    private int capacity;

    private Map<Integer, Pair> store;
    private Map<Integer,LinkedHashSet<Integer>> buckets;


    public LFUCache(int capacity) {
        store = new HashMap<>();
        buckets = new HashMap<>();
        this.capacity = capacity;
        this.minFrequency = 0;
    }

    public int get(int key) {
        if (!store.containsKey(key)) return -1;

        var pair = store.get(key);
        incrFrequency(pair.freq, key);
        pair.freq++;
        return pair.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (store.size() == capacity && !store.containsKey(key)) {
            remove();
        }

        if (store.containsKey(key)) {
            get(key);
            store.get(key).val = value;
        } else {
            var pair = new Pair(1, value);
            store.put(key, pair);
            if (!buckets.containsKey(1)) {
                buckets.put(1, new LinkedHashSet<>());
            }
            buckets.get(1).add(key);
            minFrequency = 1;
        }
    }

    private void remove() {
        int key = buckets.get(minFrequency).stream().findFirst().get();

        buckets.get(minFrequency).remove(key);
        store.remove(key);

        if (buckets.get(minFrequency).isEmpty()) {
            // buckets.remove(minFrequency);
            minFrequency++;
        }
    }

    private void incrFrequency(int freq, int key) {
        buckets.get(freq).remove(key);

        if (buckets.get(freq).isEmpty() && freq == minFrequency) {
            // buckets.remove(freq);
            minFrequency++;
        }

        if (!buckets.containsKey(freq + 1)) {
            buckets.put(freq + 1, new LinkedHashSet<>());
        }

        buckets.get(freq+1).add(key);
    }

    class Pair {
        int freq;
        int val;
        Pair(int f, int v) {
            freq = f;
            val = v;
        }
    }

    public static void main(String[] args) {
        TestCaseRunner.run();
    }
}

class TestCaseRunner {
    public static void run() {
        LFUCache cache = new LFUCache(2);
        System.out.println(cache.get(2)); // -1
        cache.put(2, 6);
        System.out.println(cache.get(1)); // -1
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1)); // 2
        System.out.println(cache.get(2)); // 6

    }
}

