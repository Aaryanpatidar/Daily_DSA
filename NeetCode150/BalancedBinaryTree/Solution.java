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
    public int rec(TreeNode root, boolean []ans){
        if(root==null)return 0;
        int l = rec(root.left,ans);
        int r= rec(root.right,ans);
        if(l-r >1 || r-l >1){
          ans[0]=false;
        }
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        boolean []ans = new boolean[1];
        ans[0]=true;
        rec(root,ans);
        return ans[0];
    }
}