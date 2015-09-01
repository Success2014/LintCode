package first;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        return calHeight(root) != -1;
        
    }
    public int calHeight(TreeNode root){
        if (root == null) return 0;
        int left = calHeight(root.left);
        int right = calHeight(root.right);
        
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        else{
            return Math.max(left, right) + 1;
        }
    }

}
