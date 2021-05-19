import java.util.*;
import java.util.stream.Collectors;

/*
	https://leetcode.com/problems/find-duplicate-file-in-system/
*/
class FindDuplicateFileInSystem {
	public static void main(String[] args) {
		String[] paths = {
			"root/a 1.txt(abcd) 2.txt(efgh)",
			"root/c 3.txt(abcd)",
			"root/c/d 4.txt(efgh)",
			"root 4.txt(efgh)"
		};

		System.out.println(new Solution().findDuplicate(paths));
		//res :  [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]


	}
}

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for(String line : paths) {
            String[] dirInfo = line.split(" ");

            String dir = dirInfo[0];

            for(int i = 1; i < dirInfo.length; i++) {
                String file = dirInfo[i];

                var fileNameEndsAt = file.indexOf('(');
                var fileName = file.substring(0, fileNameEndsAt);
                var content = file.substring(fileNameEndsAt + 1, file.length() - 1);

                if (!map.containsKey(content))
                    map.put(content, new LinkedList<>());

                map.get(content).add(dir + "/" + fileName);
            }
        }

        // System.out.println(map);

        return map
            .entrySet()
            .stream()
            .filter(pair -> pair.getValue().size() > 1)
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());

    }


}
