package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        System.out.println(new UniqueEmailAddresses().numUniqueEmails(new String[]{ "test.email@leetcode.com"}));
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < emails.length; i++){
            String temp = refine(emails[i]);
            if(temp!=null && !set.contains(temp))
                set.add(temp);
        }

        return set.size();
    }

    private String refine(String email) {
        String[] split = email.split("@");

        if(split.length != 2) return null;

        String localName = split[0];
        String domainName = split[1];

        int plusIndex = localName.indexOf("+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (plusIndex != -1 ? plusIndex : localName.length()); i++) {
            if(localName.charAt(i) != '.'){
                sb.append(localName.charAt(i));
            }
        }
        localName = sb.toString();

        if(countOccurrence(domainName, '+')>0 || countOccurrence(domainName, '.')>0) return null;

        return new String(localName + "@" + domainName);
    }

    private int countOccurrence(String str, char c){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
}
