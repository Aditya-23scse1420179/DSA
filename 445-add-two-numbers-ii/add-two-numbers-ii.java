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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer>st1=new Stack<>();
        Stack<Integer>st2=new Stack<>();
        ListNode result=null;
        int carry=0;
        while(l1!=null){
            st1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            st2.push(l2.val);
            l2=l2.next;
        }
        while(!st1.isEmpty()||!st2.isEmpty()){
            int add=carry;
            if(!st1.isEmpty()){
                add+=st1.pop();
            }
            if(!st2.isEmpty()){
                add+=st2.pop();
            }
            int val=add%10;
            carry=add/10;
            result=result!=null?new ListNode(val,result):new ListNode(val);
        }
        if(carry>0){
            result=new ListNode(carry,result);
        }
        return result;
    }
}