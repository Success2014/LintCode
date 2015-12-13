package first;

public class InsertNodeInABinarySearchTree3 {
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val < node.val) {
            root.right = insertNode(root.right, node);
        } else {
            root.left = insertNode(root.left, node);
        }
        return root;
    }
	public TreeNode insertNode2(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        TreeNode res = root;
        TreeNode prev = root;
        while (root != null) {
            prev = root;
            if (node.val > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (prev.val > node.val) {
            prev.left = node;
        } else {
            prev.right = node;
        }
        return res;
    }

}
