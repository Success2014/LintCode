package first;
import java.util.*;
public class MaxTree3 {
	public TreeNode maxTree(int[] A) {
        int n = A.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i <= n; i++) {
            TreeNode curt = (i == n) ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]) ;
            while (!stack.isEmpty() && curt.val > stack.peek().val) {
                TreeNode prev = stack.pop();
                TreeNode left = (stack.isEmpty()) ? (new TreeNode(Integer.MAX_VALUE)) : stack.peek();
                if (left.val < curt.val) {
                    left.right = prev;
                } else {
                    curt.left = prev;
                }
            }
            stack.push(curt);
        }
        return stack.peek().left;
    }

}
