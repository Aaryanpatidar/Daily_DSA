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
    public boolean isSameTree(TreeNode x, TreeNode y) {

        if(x==null && y == null)return true;
        if(x!=null && y!= null && x.val==y.val){
            return(isSameTree(x.left,y.left) && isSameTree(x.right,y.right));
        }else{
            return false;
        }

    }
}