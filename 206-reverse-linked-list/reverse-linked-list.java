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
    public ListNode reverse(ListNode head,ListNode prev){
        
        if(head.next==null){
            head.next=prev;
            return head;
        }
        ListNode nextHead=head.next;
        head.next=prev;
        return reverse(nextHead,head);
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)return head;
        return reverse(head,null);
    }
}