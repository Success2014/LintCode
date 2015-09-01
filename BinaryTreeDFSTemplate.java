package first;

public class BinaryTreeDFSTemplate {
	/**
	 * Template 1: Traverse
	 * @param root
	 */
	public void traverse(TreeNode root){
		if (root == null){
			return;
		}
		// do something with root
		traverse(root.left);
		// do something with root
		traverse(root.right);
		// do something with root
	}
	/**
	 * Template 2: Divide & Conquer
	 * @param root
	 * @return
	 */
	public ResultType traversal(TreeNode root){
		// null or leaf
		if (root == null){
			// do something and return;
		}
		
		// Divide
		ResultType left = traversal(root.left);
		ResultType right = traversal(root.right);
		
		// Conquer
		ResultType result = left; // Merge from left and right;
		return result;
	}
	
	private class ResultType{
		int res1;
		int res2;
		/*ResultType(int x, int y){
			res1 = x;
			res2 = y;
		}*/
	}

}
