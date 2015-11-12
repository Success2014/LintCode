package first;
import java.util.*;
public class SearchRangeInBinarySearchTree2 {
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                if (temp.val > k2) {
                    break;
                }
                if (temp.val >= k1 && temp.val <= k2) {
                    res.add(temp.val);
                }
                root = temp.right;
            }
        }
        return res;
    }
	
	ArrayList<Integer> res = new ArrayList<Integer>();
    public ArrayList<Integer> searchRange2(TreeNode root, int k1, int k2) {
        
        helper(root, k1, k2);
        return res;
    }
    public void helper(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        } 
        if (root.val > k1) {
            helper(root.left, k1, k2);
        } 
        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }
        if (root.val < k2) {
            helper(root.right, k1, k2);
        }
    }

}
