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
    public int getMinimumDifference(TreeNode root) {
        int[] min = {Integer.MAX_VALUE};
        helper(root,min);
        return min[0];
    }

    public void helper(TreeNode root,int[] min){
        if(root == null)return;

        int left = getMax(root.left);
        int right = getMin(root.right);

        min[0] = Math.min(min[0],Math.min(Math.abs(left-root.val),Math.abs(right-root.val)));

        helper(root.left,min);
        helper(root.right,min);
    }

    public int getMax(TreeNode root){
        if(root == null)return Integer.MAX_VALUE;

        int ans = 0;
        while(root != null){
            ans = root.val;
            root = root.right;
        }
        return ans;
    }

    public int getMin(TreeNode root){
        if(root == null)return Integer.MAX_VALUE;

        int ans = 0;
        while(root != null){
            ans = root.val;
            root = root.left;
        }
        return ans;
    }
}