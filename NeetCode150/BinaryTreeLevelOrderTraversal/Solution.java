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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>>ans = new ArrayList<>();
        if(root==null)return ans;
        q.add(root);
        while(!q.isEmpty()){
            int y = q.size();
            List<Integer>temp = new ArrayList<>();
            for(int i =0;i<y;i++){
                TreeNode x= q.remove();
                temp.add(x.val);
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}