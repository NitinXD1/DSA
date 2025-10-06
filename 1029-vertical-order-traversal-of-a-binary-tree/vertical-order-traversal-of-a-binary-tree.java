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
        int row;
        int col;
        TreeNode node;

        Pair(int row,int col,TreeNode node){
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> ls = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,root));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            TreeNode node = p.node;
            int val = node.val;

            if(!ls.containsKey(c)){
                ls.put(c,new TreeMap<>());
            }

            TreeMap<Integer,List<Integer>> currMap = ls.get(c);

            if(!currMap.containsKey(r)){
                currMap.put(r,new ArrayList<>());
            }

            List<Integer> currLs = currMap.get(r);
            currLs.add(val);
            currMap.put(r,currLs);

            if(node.left != null){
                q.offer(new Pair(r+1,c-1,node.left));
            }

            if(node.right != null){
                q.offer(new Pair(r+1,c+1,node.right));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,List<Integer>> mpp : ls.values()){
            List<Integer> curr = new ArrayList<>();
            
            for(List<Integer> level:mpp.values()){
                Collections.sort(level);
                curr.addAll(level);
            }

            ans.add(curr);
        }

        return ans;
    }
}