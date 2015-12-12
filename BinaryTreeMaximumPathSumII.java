package first;

public class BinaryTreeMaximumPathSumII {
	public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
    }

}
