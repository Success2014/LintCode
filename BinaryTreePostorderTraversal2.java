package first;
import java.util.*;
public class BinaryTreePostorderTraversal2 {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curt = stack.peek();
            if (prev == null || curt == prev.left || curt == prev.right) {//going down
                if (curt.left != null) {
                    stack.push(curt.left);
                } else if (curt.right != null) {
                    stack.push(curt.right);
                } else {//leaf node
                    res.add(curt.val);
                    stack.pop();
                }
            } else if (prev == curt.left) {//up from left
                if (curt.right != null) {
                    stack.push(curt.right);
                } else {
                    res.add(curt.val);
                    stack.pop();
                }
            } else if (prev == curt.right) {//up from right
                res.add(curt.val);
                stack.pop();
            }
            prev = curt;
        }
        return res;
    }

}
