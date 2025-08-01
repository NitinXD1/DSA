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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return root;

        if(root.val == key){

            if(root.left == null)return root.right;
            if(root.right == null)return root.left;
            
            TreeNode newChild = root.right;
            TreeNode rightLeft = findLeft(newChild);

            rightLeft.left = root.left;

            return newChild;
        }

        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else{
            root.right = deleteNode(root.right,key);
        }

        return root;
    }

    public TreeNode findLeft(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}