package first;

public class InsertNodeInABinarySearchTree2 {
	/**recursive
	 * 
	 * @param root
	 * @param node
	 * @return
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return root;
        }
        helper(root, node);
        return root;
    }
    public void helper(TreeNode root, TreeNode node) {
        if (node.val > root.val && root.right == null) {
            root.right = node;
            return;
        } else if (node.val < root.val && root.left == null) {
            root.left = node;
            return;
        }
        if (node.val > root.val) {
            helper(root.right, node);
        } else if (node.val < root.val) {
            helper(root.left, node);
        }
    }
    
    public TreeNode insertNode2(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        TreeNode temp = root;
        TreeNode prev = null;
        while (temp != null) {
            if (node.val > temp.val) {
                prev = temp;
                temp = temp.right;
            } else {
                prev = temp;
                temp = temp.left;
            }
        }
        if (node.val > prev.val) {
            prev.right = node;
        } else {
            prev.left = node;
        }
        return root;
    }
    
    public static void main(String[] args) {
    	InsertNodeInABinarySearchTree2 ibs = new InsertNodeInABinarySearchTree2();
    	TreeNode nd1 = new TreeNode(2);
    	TreeNode nd2 = new TreeNode(1);
    	TreeNode nd3 = new TreeNode(4);
    	TreeNode nd4 = new TreeNode(3);
    	nd1.left = nd2;
    	nd1.right = nd3;
    	nd3.left = nd4;
    	TreeNode nd5 = new TreeNode(6);
    	TreeNode root = ibs.insertNode(nd1, nd5);
    }

}
