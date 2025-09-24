class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    public boolean rec(TreeNode root, long ll, long ul){
        if(root==null)return true;
        if(root.val<=ll || root.val>=ul)return false;
        return rec(root.left,ll,root.val) && rec(root.right,root.val,ul);
    }

    public boolean isValidBST(TreeNode root) {
        long ll = Long.MIN_VALUE;
        long ul = Long.MAX_VALUE;
        return rec(root,ll,ul);
    }
}