package first;
import java.util.*;
public class TriangleCount {
	public int triangleCount(int S[]) {
        Arrays.sort(S);
        int res = 0;
        for (int i = 0; i < S.length; i++) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (S[j] + S[k] > S[i]) {
                    res += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

}
