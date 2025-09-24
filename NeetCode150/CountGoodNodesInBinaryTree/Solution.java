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
    public void rec(TreeNode root, int[]ans,int max){
        if(root == null)return;
        if(root.val>=max){
            max=root.val;
            ans[0]++;
        }
        rec(root.left,ans,max);
        rec(root.right,ans,max);
    }

    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int[]ans = new int[1];
        rec(root,ans,max);
        return ans[0];
    }
}