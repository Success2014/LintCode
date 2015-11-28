package first;

import java.util.*;

public class NumberOfIslandsII {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
	 class Point {
		 int x;
		 int y;
		 Point() { x = 0; y = 0; }
		 Point(int a, int b) { x = a; y = b; }
	 }
    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        public UnionFind(int n, int m) {
            for (int i = 0; i < m * n; i++) {
                father.put(i, i);
            }
        }
        public int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = x;
            while (father.get(temp) != parent) {
                temp = father.get(x);
                father.put(x, parent);
                x = temp;
            }
            return parent;
        }
        public void union(int x, int y) {
            int faX = find(x);
            int faY = find(y);
            if (faX != faY) {
                father.put(faX, faY);
            }
        }
        
    }
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<Integer>();
        if (operators == null || operators.length == 0) {
            return res;
        }
        int count = 0;
        UnionFind uf = new UnionFind(n, m);
        boolean[] isIsland = new boolean[n * m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < operators.length; i++) {
            count++;
            int x = operators[i].x;
            int y = operators[i].y;
            int curt = convertTo1D(x, y, m);
            isIsland[curt] = true;
            for (int j = 0; j < 4; j++) {
                int nextX = x + dx[j];
                int nextY = y + dy[j];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    int nb = convertTo1D(nextX, nextY, m);
                    int curtFa = uf.find(curt);
                    int nbFa = uf.find(nb);
                    if (isIsland[nb] && curtFa != nbFa) {
                        uf.union(curtFa, nbFa);
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    public int convertTo1D(int x, int y, int m) {
            return x * m + y;
        }
}

