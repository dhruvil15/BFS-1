// Time Complexity : O(N)
// Space Complexity : O(h)

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        //base
        if(root == null) return;

        //logic
        if (this.result.size() == level) {
            result.add(new ArrayList<>());
        }
        this.result.get(level).add(root.val);

        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}