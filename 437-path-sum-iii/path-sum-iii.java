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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        int currSum = count(root,targetSum);

        int leftSum = pathSum(root.left,targetSum);

        int rightSum = pathSum(root.right,targetSum);

        return leftSum + currSum + rightSum;
    }

    public int count(TreeNode root,long targetSum){
        if(root == null) return 0;

        int cnt = 0;

        // Check if the current node value equals the targetSum
        if (root.val == targetSum) {
            cnt++;
        }
        cnt += count(root.left,targetSum - root.val);
        cnt += count(root.right,targetSum - root.val); 

        return cnt;
    }
}