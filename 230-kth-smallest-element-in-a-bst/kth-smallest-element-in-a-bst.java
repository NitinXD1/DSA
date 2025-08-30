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
    public int kthSmallest(TreeNode root, int k) {
        int[] cnt = {0};
        int[] ans = {-1};
        helper(root,cnt,ans,k);
        return ans[0];
    }

    public void helper(TreeNode root,int[] cnt,int[] ans,int k){
        if(root == null)return;

        if(root.left != null)helper(root.left,cnt,ans,k);

        cnt[0]++;
        if(k == cnt[0]){
            ans[0] = root.val;
        }

        if(root.right != null)helper(root.right,cnt,ans,k);
    }
}