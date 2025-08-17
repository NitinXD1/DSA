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
        return helper(root,root.val);
    }

    public int helper(TreeNode root,int curr){
        if(root.left == null && root.right == null)return curr;

        int left = root.left != null ? helper(root.left , curr * 10 + root.left.val) : 0;
        int right = root.right != null ? helper(root.right , curr * 10 + root.right.val) : 0;

        return left + right;
    }
}