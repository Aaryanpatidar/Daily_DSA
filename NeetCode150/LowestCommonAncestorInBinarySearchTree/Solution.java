class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 

class Solution {
    public static TreeNode rec(TreeNode root, TreeNode p, TreeNode q){
        if(root.val > p.val && root.val > q.val){
            return rec(root.left,p,q);
        }
        if(root.val < p.val && root.val < q.val){
            return rec(root.right,p,q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return rec(root,p,q);
    }
}