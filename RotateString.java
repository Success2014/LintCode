package first;

public class RotateString {
	public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) return;
        offset %= str.length;
        int bound = str.length - offset - 1;//0:bound, bound+1:end, inclusive
        reverse(str, 0, bound);
        reverse(str, bound + 1, str.length - 1);
        reverse(str, 0, str.length - 1);
        
    }
    public void reverse(char[] str, int L, int R){
        while (L < R){
            char tmp = str[L];
            str[L] = str[R];
            str[R] = tmp;
            L++;
            R--;
        }
        
    }

}
