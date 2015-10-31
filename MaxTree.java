package first;
import java.util.Stack;

public class MaxTree {
	public TreeNode maxTree(int[] A) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i <= A.length; i++) {
            TreeNode newNode = (i == A.length) ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]);
            while (!stack.isEmpty() && newNode.val > stack.peek().val) {
                TreeNode oldNode = stack.pop();
                if (!stack.isEmpty() && newNode.val > stack.peek().val) {
                    stack.peek().right = oldNode;
                } else {
                    newNode.left = oldNode;
                }
                
            }
            stack.push(newNode);
        }
        return stack.peek().left;
    }

}
