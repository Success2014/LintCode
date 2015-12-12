package first;
import java.util.*;
public class BinaryTreeInorderTraversal2 {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode curt = stack.pop();
                res.add(curt.val);
                root = curt.right;
            }
        }
        return res;
    }

}
