package first;

public class Rehashing {
	public ListNode[] rehashing(ListNode[] hashTable) {
        int n = hashTable.length;
        ListNode[] newTable = new ListNode[2 * n];
        for (int i = 0; i < n; i++) {
            if (hashTable[i] == null) {
                continue;
            }
            ListNode node = hashTable[i];
            while (node != null) {
                int newKey = (node.val >= 0) ? node.val % (2 * n): (node.val % (2 * n) + (2 * n)) % (2 * n);
                
                if (newTable[newKey] == null) {
                    newTable[newKey] = new ListNode(node.val);
                } else {
                    ListNode head = newTable[newKey];
                    while (head.next != null) {
                        head = head.next;
                    }
                    head.next = new ListNode(node.val);
                }
                node = node.next;
            }
        }
        return newTable;
    }

}
