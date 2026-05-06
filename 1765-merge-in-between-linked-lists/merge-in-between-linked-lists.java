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
    public ListNode mergeInBetween(ListNode l1, int a, int b, ListNode l2) {
        ListNode curr=l1;
        for(int i=0;i<a-1;i++){
            curr=curr.next;
        }ListNode temp=curr.next;
        for(int i=a;i<=b;i++){
            temp=temp.next;
        }
        ListNode prev=l2;
        curr.next=prev;
        while(prev.next!=null){
            prev=prev.next;
        }
        prev.next=temp;
        return l1;
    }
}