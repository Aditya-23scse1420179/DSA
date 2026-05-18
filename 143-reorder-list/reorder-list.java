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
        while(p1!=null&&p2!=null){
            ListNode h1=p1.next;
            ListNode h2=p2.next;
            p1.next=p2;
            p2.next=h1;
            p1=h1;
            p2=h2;

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