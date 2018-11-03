package algos;

import java.util.HashSet;
import java.util.Set;

public class StringEmailAddressParse {

	public static void main(String[] args) {
		String[] emails = new String[] { 
			"test.email+alex@leetcode.com", 
			"test.e.mail+bob.cathy@leetcode.com",
			"testemail+david@lee.tcode.com" 
		};
		System.out.println(new StringEmailAddressParse().numUniqueEmails(emails));
	}

	public int numUniqueEmails(String[] emails) {
		Set<String> seen = new HashSet<>();
		for (int i = 0; i < emails.length; i++) {
			seen.add(transform(emails[i]));
		}
		return seen.size();
	}

	private String transform(String s) {
		String email = s.split("@")[0];
		String domain = s.split("@")[1];
		email = email.split("\\+")[0];		
		return email.replaceAll("\\.", "") + "@" + domain;
	}
};