package first;

public class FindMinimumInRotatedSortedArrayII {
	public int findMin1(int[] num) {
        int min = Integer.MAX_VALUE;
        for (int c: num){
            if (c < min){
                min = c;
            }
        }
        return min;
    }
	
	public int findMin2(int[] num) {
        int start = 0, end = num.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (num[mid] == num[end]){
                if (num[start] >= num[end]){//[2,0,2,2,2]
                    start++;
                }
                else{//[0,2,2,2,2]
                    end--;
                }
            }
            else if (num[mid] < num[end]){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        
        if (num[start] < num[end]){
            return num[start];
        }
        else{
            return num[end];
        }
        
    }
	
	public static void main(String[] args){
		int[] num1 = {0,1,1,1};
		FindMinimumInRotatedSortedArrayII fm = new FindMinimumInRotatedSortedArrayII();
		System.out.println(fm.findMin2(num1));
	}

}
