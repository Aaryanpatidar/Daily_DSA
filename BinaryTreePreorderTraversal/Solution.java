import java.util.*;

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
    
    public static void rec(TreeNode root, List<Integer>ans){
        if(root==null)return;
        ans.add(root.val);
        rec(root.left,ans);
        rec(root.right,ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        rec(root,ans);
        return ans;
    }
}