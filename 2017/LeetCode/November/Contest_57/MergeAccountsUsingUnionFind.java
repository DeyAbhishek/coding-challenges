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

/*
Intuition:
As in other approach in MergeAccount.java, our problem comes down to finding the connected components of a graph. 
This is a natural fit for a Union-Find structure.
*/

public class MergeAccountsUsingUnionFind {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<String, String>();
        UnionFind unionFind = new UnionFind();
        // graph formation out of the accounts starts here
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name.equals("")) {
                name =  email;
                continue;
                }
                emailToName.put(email, name);
                unionFind.union(account.get(1), email);
            }
        }
        
        Map<String, List<String>> components = new HashMap<String, List<String>>();
        
        for (String email : emailToName.keySet()) {
            String root = unionFind.find(email);
            components.computeIfAbsent(root, x -> new ArrayList<String>()).add(email);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        
        for (List<String> component : components.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
            result.add(component);
        }
        
        return result;
    }
    
    private class UnionFind {
        public Map<String, String> parents = new HashMap<String, String>();
        public Map<String, Integer> rootToSize = new HashMap<String, Integer>();
        
        public String find(String str) {
            // Initialization when a node is encountered for first time:
            // every node should be its own parnt initially
            // every node should belong to its own component-set innitially
            if (!parents.containsKey(str)) {
                parents.put(str, str);
                rootToSize.put(str, 1);
            }
            
            while (!parents.get(str).equals(str)) {
                str = parents.get(str);
            }
            return str;
        }
        
        public void union(String str1, String str2) {
            
            String root1 = find(str1);
            String root2 = find(str2);
            
            int size1 = rootToSize.get(str1);
            int size2 = rootToSize.get(str2);
            int newSize = size1;
            
            if (!str1.equals(str2)) {
                newSize += size2;
            }
            
            if (size1 > size2) {
                parents.put(root2, root1);
                rootToSize.put(root1, newSize);
            } else {
                parents.put(root1, root2);
                rootToSize.put(root2, newSize);
            }
        }
    }
}

/*
Complexity Analysis
Time Complexity: O(AlogA), where A = ∑ai and ai is the length of accounts[i]. 
If we used union-by-rank, this complexity improves to O(Aα(A))≈O(A), where α is the Inverse-Ackermann function.
Space Complexity: O(A), the space used by our Union-Find data structure.
*/
