class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
 public class Solution {

    public void rec1(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("N.");
            return;
        }
        String s = Integer.toString(root.val);
        sb.append(s);
        sb.append('.');
        rec1(root.left,sb);
        rec1(root.right,sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        rec1(root,sb);
        return sb.toString();
    }

    public TreeNode rec2(int[] i, String s){
        if(s.charAt(i[0])=='.'){
            i[0]++;
        }
        if(s.charAt(i[0])=='N'){
            i[0]++;
            return null;
        }
        int st = i[0], e = i[0];
        while(s.charAt(i[0]) != '.'){
            e++;
            i[0]++;
        }
        String sub = s.substring(st,e);
        TreeNode root = new TreeNode(Integer.parseInt(sub));
        root.left = rec2(i,s);
        root.right = rec2(i,s);

        return root;
    }

    public TreeNode deserialize(String data) {
        int [] i = new int[]{0};
        return rec2(i,data);
    }
}

