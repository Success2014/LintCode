package first;

public class BinaryTreeMaximumPathSum {
	public int solMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root != null){
             simplePath(root);
        }
        return solMax;
    }
    public int simplePath(TreeNode root){
        if (root == null){
            return 0;
        }
        
        int left = simplePath(root.left);
        int right = simplePath(root.right);
        
        int res = Math.max(left, right) + root.val;
        solMax = Math.max(solMax, root.val + left + right);
        return Math.max(res, 0);
    }

}
