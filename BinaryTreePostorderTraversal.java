package first;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	/**
	 * http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.empty()){
            TreeNode cur = stack.peek();
            //go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if (prev == null || prev.left == cur || prev.right == cur){
            	//prev == null is the situation for the root node
                if (cur.left != null) stack.push(cur.left);
                else if (cur.right != null) stack.push(cur.right);
                else{//leaf
                    res.add(cur.val);
                    stack.pop();
                }
            }
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            else if (cur.left == prev){
                if (cur.right != null) stack.push(cur.right);
                else{//no right child
                    res.add(cur.val);
                    stack.pop();
                }
            }
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack. 
            else if (cur.right == prev){
                res.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return res;
    }

}
