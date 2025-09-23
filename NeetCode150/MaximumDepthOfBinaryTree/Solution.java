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
    public static void rec(TreeNode root, int depth, int[]ans){
        if(root==null)return;
        ans[0]=Math.max(ans[0],depth);
        rec(root.left,depth+1,ans);
        rec(root.right,depth+1,ans);
    }
    public int maxDepth(TreeNode root) {
        int[]ans = new int[1];
        ans[0]=0;
        rec(root,1,ans);
        return ans[0];
        // if(root==null)return 0;
        // int left = maxDepth(root.left);
        // int right = maxDepth(root.right);
        // return Math.max(left,right)+1;
    }
}