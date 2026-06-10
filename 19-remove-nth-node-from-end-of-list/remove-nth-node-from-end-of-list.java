/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Pehle length nikal lo
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Agar first node delete karni ho
        if (n == length) {
            return head.next;
        }

        // Traverse karke us node ke pehle tak jao
        curr = head;
        for (int i = 1; i < length - n; i++) {
            curr = curr.next;
        }

        // Ab deleteNode jaisa logic lagao
        curr.next = curr.next.next;

        return head;
    }
}
