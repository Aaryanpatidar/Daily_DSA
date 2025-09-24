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
    int ans =0;
    public void rec(TreeNode root,int k, int []cnt){
        if(root==null)return;
        rec(root.left,k,cnt);
        cnt[0]++;
        if(cnt[0]==k){
            ans=root.val;
            return;
        }
        rec(root.right,k,cnt);
    }

    public int kthSmallest(TreeNode root, int k) {
        int []cnt = new int[1];
        rec(root,k,cnt);
        return ans;
    }
}