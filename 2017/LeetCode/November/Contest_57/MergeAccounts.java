/*721. Accounts Merge 
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
*/
class MergeAccounts {
     public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        Map<String, String> emailToName = new HashMap<String, String>();
        
        for (List<String> acc : accounts) {
            String name = "";
            for (String email : acc) {
                if (name.equals("")) {
                    name = email;
                    continue;
                } 
                emailToName.put(email, name);
                if (!graph.containsKey(email)) {
                    graph.put(email, new ArrayList<String>());
                }
                if (!graph.containsKey(acc.get(1))) {
                    graph.put(acc.get(1), new ArrayList<String>());
                }
                graph.get(email).add(acc.get(1));
                graph.get(acc.get(1)).add(email);
            }
        } // graph formation ends
        
        List<List<String>> result = new ArrayList<List<String>>(); 
        Set<String> seen = new HashSet<String>();
        for (String email : graph.keySet()) {
            if (!seen.contains(email)) {
                List<String> components = new ArrayList<String>();
                seen.add(email);
                Stack<String> stack = new Stack<String>();
                stack.push(email);
                components.add(email);
                while (!stack.isEmpty()) {
                    String parent = stack.pop();
                    List<String> childSet = graph.get(parent);
                    for (String child : childSet) {
                        if (!seen.contains(child)) {
                            seen.add(child);
                            stack.push(child);
                            components.add(child);
                        }
                    }
                }
                Collections.sort(components);
                components.add(0, emailToName.get(email));
                result. add(components);
            }
        }
        return result;
    }
}


/*
Complexity Analysis

Time Complexity: O(∑ailogai), where ai is the length of accounts[i]. Without the log factor, this is the complexity to build the graph and search for each component. The log factor is for sorting each component at the end.

Space Complexity: O(∑ai), the space used by our graph and our search.
*/
