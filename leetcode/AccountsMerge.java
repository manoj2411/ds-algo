import java.util.*;

/*
	https://leetcode.com/problems/accounts-merge/
*/
class AccountsMerge {
	public static void main(String[] args) {
		List<List<String>> accounts = List.of(
			List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
			List.of("John","johnsmith@mail.com","john00@mail.com"),
			List.of("Mary","mary@mail.com"),
			List.of("John","johnnybravo@mail.com"));

		System.out.println(new Solution().accountsMerge(accounts));

		// [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],
		//  ["Mary","mary@mail.com"],
		//  ["John","johnnybravo@mail.com"]]
	}
}

class Solution {
    String[] names;
    int accLen;
    int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        accLen = accounts.size();
        names = new String[accLen];
        parent = new int[accLen];
        Arrays.fill(parent, -1);

        Map<String, Integer> emails = new HashMap<>();

        for(int i = 0; i < accLen; i++) {

            List<String> list = accounts.get(i);
            names[i] = list.get(0);

            for(int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                if (emails.containsKey(email) && emails.get(email) != i) {
                    union(i, emails.get(email));
                } else {
                    emails.put(email, i);
                }
            }

        }


        Map<Integer, List<String>> groups = new HashMap<>();
        for(String email : emails.keySet()) {
            int i = find(emails.get(email));

            if (!groups.containsKey(i))
                groups.put(i, new ArrayList<>());

            groups.get(i).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        groups.forEach((group, list) -> {

            List<String> account = new ArrayList<>();

            account.add(names[group]);

            Collections.sort(list);
            account.addAll(list);

            result.add(account);

        });

        return result;

    }

    void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        // System.out.println(List.of(p1, p2, n1, n2));
        if (p1 != p2)
            parent[Math.max(p1, p2)] = Math.min(p1, p2);
        // System.out.println(Arrays.toString(parent));
    }

    int find(int g) {
        while(parent[g] != -1) {
            g = parent[g];
        }
        return g;
    }
}
