package first;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if (left != null && right != null){
            return root;
        }
        else if (left != null){
            return left;
        }
        else if (right != null){
            return right;
        }
        else{
            return null;
        }
        
    }

}
