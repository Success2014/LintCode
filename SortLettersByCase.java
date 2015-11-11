package first;
import java.util.*;
public class SortLettersByCase {
	public void sortLetters(char[] chars) {
        int n = chars.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] >= 'a') {
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                j++;
            }
        }
    }
	public static void main(String[] args) {
		SortLettersByCase sl = new SortLettersByCase();
		char[] chars = {'a', 'B', 'D', 'e','H','m'};
		sl.sortLetters(chars);
		System.out.println(Arrays.toString(chars));
	}

}
