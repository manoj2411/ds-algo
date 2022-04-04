import java.util.*;

/*
	https://leetcode.com/problems/unique-email-addresses/
*/
class UniqueEmailAddresses {
	public static void main(String[] args) {
		String[] emails = {
			"test.email+alex@leetcode.com",
			"test.e.mail+bob.cathy@leetcode.com",
			"testemail+david@lee.tcode.com" };

		System.out.println(new Solution().numUniqueEmails(emails)); // 2
	}
}

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for(String email : emails) {
            String[] parts = email.split("@");
            String localName = parts[0];
            String domainName = parts[1];

            localName = localName.replace(".", "");
            localName = localName.split("\\+")[0];

            uniqueEmails.add(localName + "@" + domainName);
        }

        return uniqueEmails.size();
    }
}
