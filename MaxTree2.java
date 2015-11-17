package first;
import java.util.*;
public class MaxTree2 {
	public TreeNode maxTree(int[] A) {
        int n = A.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i <= n; i++) {
            int curtVal = (i == n) ? Integer.MAX_VALUE : A[i] ;
            TreeNode curt = new TreeNode(curtVal);
            while (!stack.isEmpty() && curtVal > stack.peek().val) {
                TreeNode old = stack.pop();
                TreeNode left = (stack.isEmpty()) ? new TreeNode(Integer.MAX_VALUE) : stack.peek();
                if (left.val < curt.val) {
                    left.right = old;
                } else {
                    curt.left = old;
                }
            }
            stack.push(curt);
        }
        return stack.peek().left;
    }

}
