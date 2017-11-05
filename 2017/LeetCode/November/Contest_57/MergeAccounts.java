721. Accounts Merge 
Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account, in sorted order.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the format they were given: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].

class MergeAccounts {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //Map<String, List<String>> map = map(accounts);
        List<List<String>> acc = new ArrayList<List<String>>();
        for (List<String> l : accounts) {
            acc.add(l);
        }
        List<List<String>> delete = new ArrayList<List<String>>();
        int count = -1;
        for (List<String> list : accounts) {
            count++;
            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);    
                for (int k = count + 1; k < acc.size(); k++) {
                    List<String> lst = acc.get(k);
                    if (lst != list && lst.get(0).equals(list.get(0))) {
                        if (lst.contains(email)) {
                            for (int j = 1; j < lst.size(); j++) {
                                if (!list.contains(lst.get(j))) {
                                    list.add(lst.get(j));
                                }
                            }
                            delete.add(lst);
                         }                        
                    } 
                    list = sort(list);                
                }
            }
        }
        for (List<String> ac : delete) {
            accounts.remove(ac);
        }
        return accounts;
    }
    
    
    private List<String> sort(List<String> account) {
        List<String> lst =  new ArrayList<String>();
        for (int i = 1; i < account.size(); i++) {
            lst.add(account.get(i));    
        }
        Collections.sort(lst);
        List<String> res = new ArrayList<String>();
        res.add(account.get(0));
        for (int i = 0; i < lst.size(); i++) {
            res.add(lst.get(i));
        }
        return res;
    }
    
//     private Map<String, List<String>> map(List<List<String>> accounts) {
//         Map<String, List<String>> map = new HashMap<String, List<String>>();
//         for (List<String> account : accounts) {
//             addToLast(account, "Unproccessed");
//             String name = account.get(0);
//             map.put(name, account);
//         }
//         return map;
//     }
    
//     private void addToLast(List<String> list, String input) {
//         list.add(input);
//     }
    
//     private String getLast(List<String> list) {
//         int len =  list.size();
//         return list.get(len - 1);
//     }
    
}
