package first;
import java.util.*;
public class SearchRangeInBinarySearchTree3 {
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } 
            else {
                TreeNode curt = stack.pop();
                if (curt.val >= k1 && curt.val <= k2) {
                    res.add(curt.val);
                }
                root = curt.right;
            }
        }
        return res;
    }

}
