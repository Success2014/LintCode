package first;

public class ValidateBinarySearchTree {
	private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(Integer.MIN_VALUE);
    	ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
    	System.out.println(vbst.isValidBST(root));
    }

}
