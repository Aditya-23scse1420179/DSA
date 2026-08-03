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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>set=new HashSet<>();
        for(int a:nums)set.add(a);
        ListNode dummy=new ListNode(0);
        ListNode cu=dummy;
        ListNode curr=head;
        while(curr!=null){
            // for(int i=0;i<nums.length;i++){
                if(!set.contains(curr.val)){
                    cu.next=curr;
                    cu=cu.next;
                }
            // }
            curr=curr.next;
        }
        cu.next=null;
        return dummy.next;

    }
}