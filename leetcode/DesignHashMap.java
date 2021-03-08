import java.util.*;

/*
		https://leetcode.com/problems/design-hashmap/
*/
class DesignHashMap {
	public static void main(String[] args) {

		MyHashMap map = new MyHashMap();

		// ["MyHashMap","put","put","get","get","put","get", "remove", "get"]
		// [[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]

		map.put(1,1);
		map.put(2,2);
		System.out.println(map.get(1)); // 1
		System.out.println(map.get(3)); // -1
		map.put(2,1);
		map.remove(2);
		System.out.println(map.get(2)); // -1

	}
}

class MyHashMap {

    List<Pair>[] bucket;

    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new List[2069];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bi = getBucketIndex(key);

        if (bucket[bi] == null) {
            bucket[bi] = new ArrayList<>();
            bucket[bi].add(new Pair(key, value));
        } else {
            int listIndex = getItemIndex(bucket[bi], key);

            if (listIndex == -1) {
                bucket[bi].add(new Pair(key, value));
            } else {
                bucket[bi].get(listIndex).val = value;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int bi = getBucketIndex(key);

        if (bucket[bi] == null)
            return -1;

        int listIndex = getItemIndex(bucket[bi], key);

        if (listIndex == -1) {
            return -1;
        } else {
            return bucket[bi].get(listIndex).val;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bi = getBucketIndex(key);

        if (bucket[bi] == null) return;

        int listIndex = getItemIndex(bucket[bi], key);

        if (listIndex == -1) return;

        bucket[bi].remove(listIndex);

    }

    private int getBucketIndex(int key) {
        return key % bucket.length;
    }

    private int getItemIndex(List<Pair> list, int key) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) return i;
        }
        return -1;
    }
}


class Pair {
    int key;
    int val;
    Pair(int k, int v) {
        key = k;
        val = v;
    }
}

