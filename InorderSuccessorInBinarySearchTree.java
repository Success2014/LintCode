package first;

public class InorderSuccessorInBinarySearchTree {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.right == null) {
            return noRight(root, p);
        } else {
            return hasRight(p);
        }
    }
    public TreeNode noRight(TreeNode root, TreeNode p) {
        TreeNode res = new TreeNode(Integer.MAX_VALUE);
        while (root != p) {
            if (root.val > p.val && root.val < res.val) {
                res = root;
            }
            if (root.val > p.val) {
                root = root.left;
            } else {
                root = root.right;
            }
            
        }
        if (res.val == Integer.MAX_VALUE) {
            return null;
        }
        return res;
    }
    public TreeNode hasRight(TreeNode p) {
        TreeNode right = p.right;
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }

}
