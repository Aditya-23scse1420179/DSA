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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr=head;
        while(curr!=null&&curr.next!=null){
            ListNode cu=new ListNode(gcd(curr.val,curr.next.val));
            cu.next=curr.next;
            curr.next=cu;
            curr=curr.next.next;
        }
        return head;
    }public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}