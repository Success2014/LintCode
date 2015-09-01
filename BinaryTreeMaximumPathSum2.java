package first;

public class BinaryTreeMaximumPathSum2 {
	private class ResultType {
        int singlePath, maxPath;
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        ResultType(int x, int y){
            singlePath = x;
            maxPath = y;
        }
    }
    public int maxPathSum(TreeNode root) {
        ResultType res = helper(root);
        return res.maxPath;
        
    }
    public ResultType helper(TreeNode root){
        if (root == null){
            return new ResultType(0, Integer.MIN_VALUE);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int single = Math.max(left.singlePath, right.singlePath) + root.val;
        single = Math.max(single, 0);
        
        int max = Math.max(left.maxPath, right.maxPath);
        max = Math.max(max, left.singlePath + right.singlePath + root.val);
        
        return new ResultType(single, max);
    }

}
