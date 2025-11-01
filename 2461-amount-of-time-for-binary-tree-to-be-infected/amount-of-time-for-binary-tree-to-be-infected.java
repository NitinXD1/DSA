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
    public int amountOfTime(TreeNode root, int start) {
        TreeNode st = null;

        HashMap<TreeNode,TreeNode> parent = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.val == start) st = node;

            if(node.left != null){
                parent.put(node.left,node);
                q.offer(node.left);
            }

            if(node.right != null){
                parent.put(node.right,node);
                q.offer(node.right);
            }
        }

        q.offer(st);
        int time = 0;

        Set<Integer> s = new HashSet<>();

        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                s.add(node.val);

                if(parent.containsKey(node)){
                    TreeNode p = parent.get(node);
                    if(!s.contains(p.val)){
                        q.offer(p);
                    }
                }

                if(node.left != null && !s.contains(node.left.val)){
                    q.offer(node.left);
                }

                if(node.right != null && !s.contains(node.right.val)){
                    q.offer(node.right);
                }
            }
        }

        return time-1;
    }
}