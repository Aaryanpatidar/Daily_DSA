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
    
    public int rec(TreeNode root, int []ans){
       if(root==null)return 0;

       int left = rec(root.left,ans);
       int right = rec(root.right,ans);

       int x = right+root.val;
       x = Math.max(x,(left+root.val));
       x = Math.max(x,(root.val));

       ans[0] = Math.max(ans[0],(left+right+root.val));
       ans[0] = Math.max(ans[0],x);
      
       return x;
    }

    public int maxPathSum(TreeNode root) {
       int []ans = new int[]{-1000};
       rec(root,ans);
       return ans[0];
    }
}