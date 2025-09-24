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
    public void rec(TreeNode root, int your_level, int[]level,List<Integer> ans){
        if(root == null)return;
        if(your_level>level[0]){
            level[0]++;
            ans.add(root.val);
        }
        rec(root.right,your_level+1,level,ans);
        rec(root.left,your_level+1,level,ans);
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        int[]level = new int[1];
        level[0]=0;
        rec(root,1,level,ans);
        return ans;
    }
}