package GoodConcept;

import java.util.*;

public class kthlargestlevelTREE {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,null);
        root.left = new TreeNode(2,null,null);
        root.left.left = new TreeNode(3,null,null);
        System.out.println(kthLargestLevelSum(root,1));
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    static class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    public static long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,1));
        int currentLvl = 1;
        long sum = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(currentLvl != p.level){
                list.add(sum);
                currentLvl = p.level;
                sum = 0;
            }
            sum += p.node.val;
            if(p.node.left != null){
                q.offer(new Pair(p.node.left,p.level+1));
            }
            if(p.node.right != null){
                q.offer(new Pair(p.node.right,p.level+1));
            }
        }
        list.add(sum);
        Collections.sort(list, Collections.reverseOrder());

        return (k > list.size()) ? -1 : list.get(k-1);
    }
}
