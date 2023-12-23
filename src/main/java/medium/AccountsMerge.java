package medium;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> acc1 = Arrays.asList(new String[]{"John", "j1@mail.com", "j2@mail.com"});
        List<String> acc2 = Arrays.asList(new String[]{"John", "j2@mail.com"});
        List<String> acc3 = Arrays.asList(new String[]{"Mary", "m1@mail.com"});
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);
        List<List<String>> out = new Solution().accountsMerge(accounts);
        System.out.println();
    }


    static class Solution {
        HashSet<String> visited = new HashSet<>();
        Map<String, List<String>> adjacent = new HashMap<String, List<String>>();

        private void DFS(List<String> mergedAccount, String email) {
            visited.add(email);
            // Add the email vector that contains the current component's emails
            mergedAccount.add(email);


            for (String neighbor : adjacent.get(email)) {
                if (!visited.contains(neighbor)) {
                    DFS(mergedAccount, neighbor);
                }
            }
        }

        public List<List<String>> accountsMerge(List<List<String>> accountList) {
            int accountListSize = accountList.size();

            for (List<String> account : accountList) {
                int accountSize = account.size();

                // Building adjacency list
                // Adding edge between first email to all other emails in the account
                String accountFirstEmail = account.get(1);
                for (int j = 2; j < accountSize; j++) {
                    String accountEmail = account.get(j);
                    adjacent.computeIfAbsent(accountFirstEmail, k->new ArrayList<>()).add(accountEmail);
                    adjacent.computeIfAbsent(accountEmail, k->new ArrayList<>()).add(accountFirstEmail);
                }
            }

            // Traverse over all the accounts to store components
            List<List<String>> mergedAccounts = new ArrayList<>();
            for (List<String> account : accountList) {
                String accountName = account.get(0);
                String accountFirstEmail = account.get(1);

                // If email is visited, then it's a part of different component
                // Hence perform DFS only if email is not visited yet
                if (!visited.contains(accountFirstEmail)) {
                    List<String> mergedAccount = new ArrayList<>();
                    // Adding account name at the 0th index
                    mergedAccount.add(accountName);

                    if (adjacent.containsKey(accountFirstEmail)) {
                        DFS(mergedAccount, accountFirstEmail);;
                    }

                    Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                    mergedAccounts.add(mergedAccount);
                }
            }

            return mergedAccounts;
        }
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<List<String>>> map = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                map.computeIfAbsent(account.get(i), k->new ArrayList<>()).add(account);
            }
        }

        List<List<String>> output = new ArrayList<>();

        Set<List<String>> set = new HashSet<>();

        for (Map.Entry<String, List<List<String>>> curr : map.entrySet()) {
            String email = curr.getKey();
            List<List<String>> accs = curr.getValue();

            Set<String> newAccount = new HashSet<>();
            LinkedList<String> newAccountLL = new LinkedList<>();
            for (List<String> acc : accs) {
                if(set.contains(acc)) continue;

                newAccount.add(email);
                newAccountLL.add(email);
                for (int i = 1; i < acc.size(); i++) {
                    String accEmail =  acc.get(i);
                    if(newAccount.contains(accEmail)) continue;

                    newAccount.add(acc.get(i));
                    newAccountLL.add(acc.get(i));
                }

                set.add(acc);
            }

            if(newAccountLL.size()>0){
                Collections.sort(newAccountLL);
                newAccountLL.addFirst(accs.get(0).get(0));
                output.add(newAccountLL);
            }
        }

        return output;
    }
}
