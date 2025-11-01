/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left != null){
                parent.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right != null){
                parent.put(node.right,node);
                q.offer(node.right);
            }

        }

        List<Integer> ans = new ArrayList<>();
        Set<Integer> st = new HashSet<>();

        q.offer(target);
        st.add(target.val);
        int dist = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(dist == k)ans.add(node.val);

                if(node.left != null && !st.contains(node.left.val)){
                    q.offer(node.left);
                    st.add(node.left.val);
                }

                if(node.right!= null && !st.contains(node.right.val)){
                    q.offer(node.right);
                    st.add(node.right.val);
                }

                TreeNode p = parent.get(node);
                if(p != null && !st.contains(p.val)){
                    q.offer(p);
                    st.add(p.val);
                }
            }

            dist++;
        }

        return ans;
    }
}