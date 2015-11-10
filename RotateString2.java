package first;

public class RotateString2 {
	public void rotateString(char[] str, int offset) {
        int n = str.length;
        if (n == 0) {
            return;
        }
        offset %= n;
        reverse(str, 0, n - offset - 1);
        reverse(str, n - offset, n - 1);
        reverse(str, 0, n - 1);
    }
    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

}
