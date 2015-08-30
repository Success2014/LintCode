package first;

public class SearchA2DMatrixII {
	/**
	 * start from right-upper corner, go down or left to left-lower corner.
	 * @param matrix
	 * @param target
	 * @return
	 */
	public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return 0;
        int count = 0;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i <= m - 1 && j >= 0){
            if (matrix[i][j] == target){
                count++;
                i++;
                j--;
            }
            else if(matrix[i][j] < target){
                i++;
            }
            else{
                j--;
            }
            
        }
        return count;
    }

}
