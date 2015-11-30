package first;
import java.util.*;
public class ConvertExpressionToReversePolishNotation {
	class TreeNode {
        int val; // priority level, not number
        String s;
        TreeNode left;
        TreeNode right;
        public TreeNode (int val, String s) {
            this.val = val;
            this.s = s;
            this.left = null;
            this.right = null;
        }
    }
    public ArrayList<String> convertToRPN(String[] expression) {
        int n = expression.length;
        ArrayList<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        int base = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i <= n; i++) {
            TreeNode curt = new TreeNode(Integer.MIN_VALUE, "");
            if (i < n) {
                String curtString = expression[i];
                if (curtString.equals("(")) {
                    base += 10;
                    continue;
                }
                if (curtString.equals(")")) {
                    base -= 10;
                    continue;
                }
                int curtValue = getValue(curtString, base);
                curt = new TreeNode(curtValue, curtString);
            }
            while (!stack.isEmpty() && curt.val <= stack.peek().val) {
                TreeNode prev = stack.pop();
                if (stack.isEmpty()) {
                    curt.left = prev;
                } else {
                    TreeNode left = stack.peek();
                    if (left.val < curt.val) {
                        curt.left = prev;
                    } else {
                        left.right = prev;
                    }
                }
            }
            stack.push(curt);
        }
        dfs(stack.pop().left, res);
        return res;
    }
    public void dfs(TreeNode root, ArrayList<String> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.s);
    }
    public int getValue(String s, int base) {
        if (s.equals("+") || s.equals("-")) {
            return 1 + base;
        } else if (s.equals("*") || s.equals("/")) {
            return 2 + base;
        } else {
            return Integer.MAX_VALUE;
        }
    }

}
