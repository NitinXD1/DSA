/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        helper(0,root,sum);
        return sum[0];
    }

    public void helper(int curr,TreeNode root,int[] sum){
        if(root.left == null && root.right == null){
            sum[0] += curr*10 + root.val;
            return;
        }

        if(root.left != null)helper(curr*10+root.val,root.left,sum);
        if(root.right != null)helper(curr*10+root.val,root.right,sum);
    }
}