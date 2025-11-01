/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();

        helper(str,root);

        String ans = str.toString();

        return ans;    
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = new int[1];
        String[] tokens = data.split(",");
        TreeNode root = helper2(tokens,index);

        return root;
    }

    public TreeNode helper2(String[] data,int[] i){
        if(i[0] == data.length || data[i[0]].equals("null")){
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[i[0]++]));

        root.left = helper2(data,i);
        root.right = helper2(data,i);

        return root;
    }

    public void helper(StringBuilder str,TreeNode root){
        if(root == null){
            str.append("null,");
            return;
        }

        str.append(root.val+",");

        helper(str,root.left);
        helper(str,root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));