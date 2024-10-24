package Daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
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
public class cousinsBinaryTreeII2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Integer> sums = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            sums.add(sum);
        }

        q.offer(root);
        root.val = 0;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();

                int sum = 0;

                if(node.left != null) sum+=node.left.val;
                if(node.right != null) sum+= node.right.val;

                if(node.left != null){
                    node.left.val = sums.get(level+1) - sum;
                    q.offer(node.left);
                }
                if(node.right != null){
                    node.right.val = sums.get(level+1) - sum;
                    q.offer(node.right);
                }
            }
            level++;
        }

        return root;
    }

    public TreeNode replaceValueInTreeBest(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int prevSum = root.val;
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            int currSum = 0;
            for (int i = 0; i < size ; i++) {
                TreeNode node = q.poll();
                node.val = prevSum - node.val;

                int sibSum = 0;

                if(node.left != null) sibSum +=node.left.val;
                if(node.right != null) sibSum += node.right.val;

                if(node.left != null){
                    currSum += node.left.val;
                    node.left.val = sibSum;
                    q.offer(node.left);
                }
                if(node.right != null) {
                    currSum += node.right.val;
                    node.right.val = sibSum;
                    q.offer(node.right);
                }
            }
            prevSum = currSum;
        }
        return root;
    }
}
