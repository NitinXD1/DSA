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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        helper(root,ans);
        return ans[0]-1;
    }

    public int helper(TreeNode root,int[] ans){
        if(root == null)return 0;

        int left = 1 + helper(root.left,ans);
        int right = 1 + helper(root.right,ans);

        ans[0] = Math.max(left+right-1,ans[0]);

        return Math.max(left,right);
    }
}