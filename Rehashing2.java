package first;

public class Rehashing2 {
	public ListNode[] rehashing(ListNode[] hashTable) {
        int n = hashTable.length;
        ListNode[] newTable = new ListNode[2 * n];
        for (int i = 0; i < n; i++) {
            if (hashTable[i] != null) {
                ListNode temp = hashTable[i];
                while (temp != null) {
                    int newKey = temp.val % (2 * n);
                    if (newKey < 0) {
                        newKey = (newKey + 2 *n) % (2 * n);
                    }
                    ListNode newNode = new ListNode(temp.val);
                    if (newTable[newKey] != null) {
                        ListNode head = newTable[newKey];
                        while (head.next != null) {
                            head = head.next;
                        }
                        head.next = newNode;
                    } else {
                        newTable[newKey] = newNode;
                    }
                    temp = temp.next;
                }
            }
        }
        return newTable;
    }

}
