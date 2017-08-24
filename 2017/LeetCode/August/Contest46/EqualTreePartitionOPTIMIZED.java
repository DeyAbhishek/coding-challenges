/*The idea is to use a hash table to record all the different sums of each subtree in the tree.
If the total sum of the tree is sum, we just need to check if the hash table constains sum/2.

The following code has the correct result at a special case when the tree is [0,-1,1], 
which many solutions dismiss. I think this test case should be added.
*/

    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = getsum(root, map);
        if(sum == 0)return map.getOrDefault(sum, 0) > 1;
        return sum%2 == 0 && map.containsKey(sum/2);
    }
    
    public int getsum(TreeNode root, Map<Integer, Integer> map ){
        if(root == null)return 0;
        int cur = root.val + getsum(root.left, map) + getsum(root.right, map);
        map.put(cur, map.getOrDefault(cur,0) + 1);
        return cur;
    }
