import java.util.*;

/*
	https://leetcode.com/problems/minimum-genetic-mutation/
*/
class MinimumGeneticMutation {
	public static void main(String[] args) {
		String[] bank = {"AACCGGTA"};
		System.out.println(new Solution().minMutation("AACCGGTT", "AACCGGTA", bank)); // 1

		bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
		System.out.println(new Solution().minMutation("AACCGGTT", "AAACGGTA", bank)); // 2

		bank = new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"};
		System.out.println(new Solution().minMutation("AAAAACCC", "AACCCCCC", bank)); // 3
	}
}


class Solution {
    public int minMutation(String start, String end, String[] bank) {

        Queue<String> que = new LinkedList<>();
        que.add(start);
        int mutations = 0;

        boolean[] free = new boolean[bank.length];
        Arrays.fill(free, true);

        while(!que.isEmpty()) {
            mutations++;
            int size = que.size();
            for(int s = 0; s < size; s++) {
                String gene = que.poll();

                for(int i = 0; i < bank.length; i++) {
                    if (free[i] && canMutate(gene, bank[i])) {
                        if (bank[i].equals(end)) {
                            return mutations;
                        }

                        que.add(bank[i]);
                        free[i] = false;
                    }
                }
            }
        }

        return -1;
    }

    private boolean canMutate(String curr, String next) {
        boolean mutated = false;

        for(int i = 0; i < 8; i++) {
            if(curr.charAt(i) != next.charAt(i)) {
                if (mutated) return false;
                mutated = true;
            }
        }

        return mutated;
    }
}
