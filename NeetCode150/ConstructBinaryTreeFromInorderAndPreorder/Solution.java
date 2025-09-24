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

    public TreeNode rec(int[] preorder, int[] inorder,int Is, int Ie, int []ind){
        if(Is>Ie)return null;
        int a = preorder[ind[0]];
        int temp = Is;
        for(;temp<Ie;temp++){
            if(inorder[temp]==a){
                break;
            }
        }
        TreeNode root = new TreeNode(a);
        ind[0]++;
        root.left = rec(preorder,inorder,Is,temp-1,ind);
        root.right = rec(preorder,inorder,temp+1,Ie,ind);
        return root;
    }
    

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int n = preorder.length;
       int ind[]= new int[1];
       return rec(preorder,inorder,0,n-1,ind);
    }
}