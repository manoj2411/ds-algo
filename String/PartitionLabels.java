package dsAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*      Problem statement: https://leetcode.com/problems/partition-labels/      */

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int len = S.length();

        List<Integer> result = new ArrayList<>();

        int[] group = new int[len];
        for (int i = 0; i < len; i++) group[i] = -1;

        HashMap<Character,Integer> last = new HashMap<>();

        // building group for every Char, using it last index
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);

            if (last.containsKey(c)) {
                unionGroups(group, i, last.get(c));
            } else {
                group[i] = i;
            }
            last.put(c, i);
        }

        // building result by combining same groups
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (group[i] == group[i - 1]) {
                count++;
            } else {
                result.add(count);
                count = 1;
            }
        }
        result.add(count);

        return result;
    }

    private void unionGroups(int[] group, int i, int previ) {
        int leader = group[previ];
        for (; i >= previ && group[i] != leader; i--) {
            group[i] = leader;
        }
    }

    public static void main(String[] args) {

        PartitionLabels obj = new PartitionLabels();
        String[] inputs = {"ababcbacadefegdehijhklij", "a", "ab", "aba", "abab", "bb", "bbb"};
        for (String str : inputs) {
            System.out.println("S: " + str + "\nResult: " + obj.partitionLabels(str));
        }
        // Result => [9,7,8]

    }

}
