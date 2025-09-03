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
    class Pair{
        int pos;
        TreeNode node;

        Pair(int pos,TreeNode node){
            this.pos = pos;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0,root));
        int max = 0;

        while(!q.isEmpty()){
            int size = q.size();

            int left = 0;
            int right = 0;

            for(int i=0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int pos = p.pos;

                if(i == 0){
                    left = pos;
                }

                if(i == size-1){
                    right = pos;
                }

                if(node.left != null)q.offer(new Pair(pos*2+1,node.left));
                if(node.right != null)q.offer(new Pair(pos*2+2,node.right));
            }

            max = Math.max(right - left + 1,max);
        }

        return max;
    }
}