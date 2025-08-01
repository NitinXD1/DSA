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
    int[] max = new int[1];
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max[0];
    }

    public int helper(TreeNode root){
        if(root == null)return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        max[0] = Math.max(left + right,max[0]);

        return Math.max(left,right) + 1;
    }
}