package first;

public class RotateString3 {
	public void rotateString(char[] str, int offset) {
        int n = str.length;
        if (n == 0) {
            return;
        }
        offset = offset % n;
        reverse(str, 0, n - 1 - offset);
        reverse(str, n - offset, n - 1);
        reverse(str, 0, n - 1);
    }
    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            swap(str, start, end);
            start++;
            end--;
        }
    }
    public void swap(char[] str, int x, int y) {
        char temp = str[x];
        str[x] = str[y];
        str[y] = temp;
    }

}
