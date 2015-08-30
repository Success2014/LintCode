package first;

public class SearchA2DMatrix {
	/**
	 * Use two binary searches
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        // find row, compare to the last one in a row
        // find first row >= target
        int start = 0, end = m - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (matrix[mid][n-1] == target){
                return true;
            }
            else if (matrix[mid][n-1] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        int row;
        if (matrix[start][n-1] >= target) {
            row = start;
        }
        else if (matrix[end][n-1] >= target){
            row = end;
        }
        else{
            return false;
        }
        
        //find column
        start = 0; end = n - 1;
        while (start + 1 < end){
            int mid = start + (end -start) / 2;
            if (matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        if (matrix[row][start] == target){
        	return true;
        }
        else if (matrix[row][end] == target){
        	return true;
        }
        else{
        	return false;
        }
        
    }
	
	/**
	 * Use one binary search.
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            int number = matrix[mid / n][mid % n];
            if (number == target){
                return true;
            }
            else if (number < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        if (matrix[start / n][start % n] == target){
            return true;
        }
        else if (matrix[end / n][end % n] == target){
            return true;
        }
        else{
            return false;
        }
		
	}
	
	public static void main(String[] args){
		SearchA2DMatrix sm = new SearchA2DMatrix();
		int[][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int[][] matrix2 = {{1,5,10,11,16,23,24,26,29,34,41,48,49,56,63,67,71,74,75},
				{97,118,131,150,160,182,202,226,251,273,289,310,326,349,368,390,401,412,428},
				{445,455,466,483,501,519,538,560,581,606,631,643,653,678,702,726,748,766,781},
				{792,817,837,858,872,884,901,920,936,957,972,982,1001,1024,1044,1063,1086,1098,1111},
				{1129,1151,1172,1194,1213,1224,1234,1250,1267,1279,1289,1310,1327,1348,1371,1393,1414,1436,1452},
				{1467,1477,1494,1510,1526,1550,1568,1585,1599,1615,1625,1649,1663,1674,1693,1710,1735,1750,1769}};
		System.out.println(sm.searchMatrix2(matrix1, 7));
		System.out.println(sm.searchMatrix2(matrix2, 1086));
	}

}
