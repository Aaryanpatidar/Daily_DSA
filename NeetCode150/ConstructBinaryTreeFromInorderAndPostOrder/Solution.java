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

    public TreeNode rec(int[] postorder, int[] inorder,int Is, int Ie, int []ind){
        if(Is>Ie)return null;
        int a = postorder[ind[0]];
        int temp = Is;
        for(;temp<Ie;temp++){
            if(inorder[temp]==a){
                break;
            }
        }
        TreeNode root = new TreeNode(a);
        ind[0]--;
        root.right = rec(postorder,inorder,temp+1,Ie,ind);
        root.left = rec(postorder,inorder,Is,temp-1,ind);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
       int n = postorder.length;
       int ind[]= new int[1];
       ind[0]=n-1;
       return rec(postorder,inorder,0,n-1,ind);
    }
}