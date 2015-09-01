package first;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	//Version 0: Non-Recursion (Recommend)
	public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            
        }
        return res;
    }
	
	
	/**
	 * Tree is like:
	 *            4
	 *          /  \
	 *         2    6
	 *        / \  / \
	 *       1  3 5   7 
	 * @param args
	 */
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node4.left = node2;
		node4.right = node6;
		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		
		BinaryTreePreorderTraversal btp = new BinaryTreePreorderTraversal();
		System.out.println(btp.preorderTraversal1(node4));
	}

}
