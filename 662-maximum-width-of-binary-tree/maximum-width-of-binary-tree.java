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
        TreeNode node;
        int pos;

        Pair(TreeNode node,int pos){
            this.node = node;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,1));

        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int st = 0;
            int en = 0;
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int dist = p.pos;

                if(i == 0){
                    st = dist;
                }

                if(i == size-1){
                    en = dist;
                }

                if(node.left != null){
                    q.offer(new Pair(node.left,2*dist+1));
                }

                if(node.right != null){
                    q.offer(new Pair(node.right,2*dist+2));
                }
            }

            max = Math.max((en - st) + 1,max);
        }

        return max;
    }
}