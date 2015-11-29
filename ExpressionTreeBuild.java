package first;
import java.util.*;
public class ExpressionTreeBuild {
	class ExpressionTreeNode {
		 public String symbol;
		 public ExpressionTreeNode left, right;
		 public ExpressionTreeNode(String symbol) {
			 this.symbol = symbol;
			 this.left = this.right = null;
		 }
	}
	class TreeNode {
        int val; // number denoting the priority
        ExpressionTreeNode node;
        public TreeNode (int val, ExpressionTreeNode node) {
            this.val = val;
            this.node = node;
        }
    }
    public ExpressionTreeNode build(String[] expression) {
        int n = expression.length;
        int base = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i <= n; i++) {
            ExpressionTreeNode dummyENode = new ExpressionTreeNode("");
            TreeNode curtTNode = new TreeNode(Integer.MIN_VALUE, dummyENode);
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
                ExpressionTreeNode curtENode = new ExpressionTreeNode(curtString);
                int curtValue = getValue(curtString, base);
                curtTNode = new TreeNode(curtValue, curtENode);
            } 
            
            while (!stack.isEmpty() && curtTNode.val <= stack.peek().val) {
                TreeNode prev = stack.pop();
                if (stack.isEmpty()) {
                    curtTNode.node.left = prev.node;
                } else {
                    TreeNode left = stack.peek();
                    if (left.val < curtTNode.val) {
                        curtTNode.node.left = prev.node;
                    } else {
                        left.node.right = prev.node;
                    }
                }
            }
            stack.push(curtTNode);
        }
        return stack.peek().node.left;
    }
    public int getValue(String s, int base) {
        if (s.equals("+") || s.equals("-")) {
            return base + 1;
        } else if (s.equals("*") || s.equals("/")) {
            return base + 2;
        } else {
            return Integer.MAX_VALUE;
        }
    }

}
