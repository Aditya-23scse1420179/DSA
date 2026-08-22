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
    public void reorderList(ListNode head) {
        ListNode mid=mid(head);
        ListNode midnxt=mid.next;
        mid.next=null;
        ListNode p=reverse(midnxt);
        ListNode p1=head;
        ListNode p2=p;
        while(p2!=null){
            ListNode temp=p1.next;
            p1.next=p2;
            p1=p2;
            p2=temp;

        }
    }public ListNode mid(ListNode head){
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}