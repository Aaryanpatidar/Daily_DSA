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
    public void rec(TreeNode t){
        if(t==null)return;
        TreeNode x = t.left;
        t.left=t.right;
        t.right= x;
        rec(t.left);
        rec(t.right);
    }
    public TreeNode invertTree(TreeNode root) {
        rec(root);
        return root;
    }
}