package first;

import java.util.ArrayList;
import java.util.Stack;

public class SearchRangeInBinarySearchTree {
	/**
	 * http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/
	 * idea: inorder traversal
	 * @param root
	 * @param k1
	 * @param k2
	 * @return
	 */
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null){
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.empty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                TreeNode node = stack.pop();
                if (node.val >= k1 && node.val <= k2){
                    res.add(node.val);
                }
                root = node.right;
            }
        }
        return res;
    }

}
