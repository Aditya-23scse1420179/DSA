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
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        int[]arr=new int[n];
        curr=head;
        int i=0;
        while(curr!=null){
            ListNode cu=curr.next;
            while(cu!=null){
                if(cu.val>curr.val){
                    arr[i]=cu.val;
                    break;
                }
                cu=cu.next;
            }
            curr=curr.next;
            i++;
        }
        return arr;
    }
}