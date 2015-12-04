package first;

public class NutsAndBolts {
	
	public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts.length == 0 || bolts.length == 0) {
            return;
        }
        if (nuts.length != bolts.length) {
            return;
        }
        qsort(nuts, bolts, compare, 0, nuts.length -1);
    }
    public void qsort(String[] nuts, String[] bolts, NBComparator compare, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(bolts[start], nuts, compare, start, end);
        partition(nuts[index], bolts, compare, start, end);
        qsort(nuts, bolts, compare, start, index - 1);
        qsort(nuts, bolts, compare, index + 1, end);
    }
    public int partition(String pivot, String[] things, NBComparator compare, int start, int end) {        
        int pivotIndex = start;
        int j = start; //left of j is smaller than pivot
        for (int i = start; i <= end; i++) {
            if (compare.cmp(things[i], pivot) == -1 || compare.cmp(pivot, things[i]) == 1) {
            	if (j == pivotIndex) {//pivot will change position
            		pivotIndex = i;
            	}
                swap(things, i, j);
                j++;
            } else if (compare.cmp(things[i], pivot) == 0 || compare.cmp(pivot, things[i]) == 0) {
                pivotIndex = i;
            }
        }
        swap(things, j, pivotIndex);
        return j;
    }
    public void swap(String[] things, int x, int y) {
        String temp = things[x];
        things[x] = things[y];
        things[y] = temp;
    }
    
    public static void main(String[] args) {
    	NutsAndBolts nab = new NutsAndBolts();
    	String[] nuts = {"d","c","b","e","a"};
    	String[] bolts = {"B","A","D","E","C"};
    	nab.sortNutsAndBolts(nuts, bolts, new NBComparator());
    }

}

class NBComparator {
	 public int cmp(String a, String b) {
		 int aVal = 0;
		 for (int i = 0; i < a.length(); i++) {
			 aVal += Character.toLowerCase(a.charAt(i));
		 }
		 int bVal = 0;
		 for (int i = 0; i < b.length(); i++) {
			 bVal += Character.toLowerCase(b.charAt(i));
		 }
		 if (aVal > bVal) {
			 return 1;
		 } else if (aVal < bVal) {
			 return -1;
		 } else {
			 return 0;
		 }
	 };
}
