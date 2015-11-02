package first;

public class HashFunction {
	public int hashCode(char[] key,int HASH_SIZE) {
        int res = 0;
        int n = key.length;
        int res_wrong = 0;
        for (int i = 0; i < n; i++) {
            res = helper(res, 33, HASH_SIZE);
            res_wrong = res_wrong * 33;
            res += (int) key[i];
            res_wrong += (int) key[i];
            res %= HASH_SIZE;
            res_wrong %= HASH_SIZE;
        }
        return res;
    }
    public int helper(int num, int base, int HASH_SIZE) {
        int res = 0;
        int temp = num - HASH_SIZE;
        for (int i = 0 ; i < base; i++) {
            if (res + temp > 0) {
                res += temp;
            } else {
                res += num;
            }
        }
        return res;
    }
	
	public static void main (String[] args) {
		HashFunction hf = new HashFunction();
		String s1 = "Wrong answer or accepted?";
		char[] key0 = s1.toCharArray();
		char[] key1 = {'u','b','u','n','t','u'};
		char[] key2 = {'a','b','c','d'};
		System.out.println(hf.hashCode(key0, 1000000007));
		System.out.println(hf.hashCode(key1, 1007));
		System.out.println(hf.hashCode(key2, 100));
	}

}
