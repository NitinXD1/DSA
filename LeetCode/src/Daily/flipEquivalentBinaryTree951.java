package Daily;

public class flipEquivalentBinaryTree951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1,root2);
    }

    public boolean dfs(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        else if(root1 == null || root2 == null || root1.val != root2.val) return false;

        return (dfs(root1.left,root2.right)||dfs(root1.left,root2.left)) && (dfs(root1.right,root2.right)||dfs(root1.right,root2.left));
    }
}
