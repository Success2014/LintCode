package first;

public class InsertNodeInABinarySearchTree {
	/**
	 * idea:
	 * If root is null, return node.
	 * Go to left or right depending on the value comparison.
	 * use prev to track the parent 
	 * use isLeft to check inserting at left or right  
	 * @param root
	 * @param node
	 * @return
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) return node;
        TreeNode p = root;
        TreeNode prev = null;
        boolean isLeft = true;
        while (p != null){
            prev = p;
            if (p.val < node.val){
                p = p.right;
                isLeft = false;
            }
            else{
                p = p.left;
                isLeft = true;
            }
        }
        if (isLeft){
            prev.left = node;
        }
        else{
            prev.right = node;
        }
        
        return root;
    }
	
	/**
	 * idea:
	 * A little improve over previous method.
	 * No need to use a boolean isLeft to remember left or right, judge it by value.
	 * @param root
	 * @param node
	 * @return
	 */
	public TreeNode insertNode2(TreeNode root, TreeNode node) {
        if (root == null) return node;
        TreeNode p = root;
        TreeNode prev = null;
        while(p != null){
            prev = p;
            if (p.val > node.val){
                p = p.left;
            }
            else{
                p = p.right;
            }
        }
        
        if (prev.val > node.val){
            prev.left = node;
        }
        else{
            prev.right = node;
        }
        
        return root;
    }

}
